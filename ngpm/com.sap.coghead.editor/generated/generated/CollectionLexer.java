// $ANTLR 3.1.1 Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g 2010-04-06 11:43:00

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
public class CollectionLexer extends Lexer {
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int EXCLUDINGAT=36;
    public static final int T__64=64;
    public static final int STAR=42;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RBRACK_RCURL=41;
    public static final int LANGLE=20;
    public static final int FLOAT=7;
    public static final int EQUALS=22;
    public static final int EXCL=27;
    public static final int INCLUDINGAT=35;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int RANGE_OR_INT_OR_FLOAT_OR_DOUBLE=49;
    public static final int T__60=60;
    public static final int LPAREN=15;
    public static final int LBRACKET=17;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RPAREN=16;
    public static final int T__57=57;
    public static final int DCOLON=18;
    public static final int T__58=58;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int OBJECT=48;
    public static final int T__59=59;
    public static final int DOUBLE=8;
    public static final int LBRACK_LCURL=39;
    public static final int PIPE=32;
    public static final int DIGIT=45;
    public static final int NL=43;
    public static final int RBRACKET=19;
    public static final int RANGLE=26;
    public static final int DOT=23;
    public static final int COMMENT=24;
    public static final int T__50=50;
    public static final int EQUALSEQUALS=28;
    public static final int RCURL_RBRACK=40;
    public static final int LCURL_LBRACK=38;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int DDOT=30;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int BOOL=9;
    public static final int INT=6;
    public static final int SEMICOLON=14;
    public static final int T__84=84;
    public static final int EXCLUDING=34;
    public static final int MULTI_LINE_COMMENT=25;
    public static final int ALPHA=46;
    public static final int COLON=21;
    public static final int ITERATE=37;
    public static final int LCURL=12;
    public static final int T__71=71;
    public static final int WS=44;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int SNAME=47;
    public static final int RCURL=13;
    public static final int ASSIGN=29;
    public static final int ARROW=31;
    public static final int BINARY=10;
    public static final int T__76=76;
    public static final int DATE=11;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int INCLUDING=33;
    public static final int STRING=5;
    public static final int T__78=78;
    public static final int T__77=77;
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

    public CollectionLexer() {;} 
    public CollectionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CollectionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g"; }

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:117:7: ( 'void' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:117:9: 'void'
            {
            match("void"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:118:7: ( '$' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:118:9: '$'
            {
            match('$'); if (state.failed) return ;

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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:119:7: ( 'break' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:119:9: 'break'
            {
            match("break"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:120:7: ( 'unique' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:120:9: 'unique'
            {
            match("unique"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:121:7: ( 'group' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:121:9: 'group'
            {
            match("group"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:122:7: ( 'constraint' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:122:9: 'constraint'
            {
            match("constraint"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:123:7: ( 'collection' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:123:9: 'collection'
            {
            match("collection"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:124:7: ( 'in' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:124:9: 'in'
            {
            match("in"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:125:7: ( 'body' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:125:9: 'body'
            {
            match("body"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:126:7: ( 'while' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:126:9: 'while'
            {
            match("while"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:127:7: ( 'const' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:127:9: 'const'
            {
            match("const"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:128:7: ( 'completesIn' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:128:9: 'completesIn'
            {
            match("completesIn"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:129:7: ( 'notify' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:129:9: 'notify'
            {
            match("notify"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:130:7: ( 'foreach' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:130:9: 'foreach'
            {
            match("foreach"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:131:7: ( 'subject' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:131:9: 'subject'
            {
            match("subject"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:132:7: ( 'default' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:132:9: 'default'
            {
            match("default"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:133:7: ( '/' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:133:9: '/'
            {
            match('/'); if (state.failed) return ;

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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:134:7: ( 'formula' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:134:9: 'formula'
            {
            match("formula"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:135:7: ( 'string' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:135:9: 'string'
            {
            match("string"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:136:7: ( 'timepoint' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:136:9: 'timepoint'
            {
            match("timepoint"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:137:7: ( 'duration' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:137:9: 'duration'
            {
            match("duration"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:138:7: ( 'number' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:138:9: 'number'
            {
            match("number"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:139:7: ( 'boolean' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:139:9: 'boolean'
            {
            match("boolean"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:140:7: ( 'child' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:140:9: 'child'
            {
            match("child"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:141:7: ( 'descendant' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:141:9: 'descendant'
            {
            match("descendant"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:142:7: ( 'attribute' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:142:9: 'attribute'
            {
            match("attribute"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:143:7: ( 'self' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:143:9: 'self'
            {
            match("self"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:144:7: ( 'descendant_or_self' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:144:9: 'descendant_or_self'
            {
            match("descendant_or_self"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:145:7: ( 'following_sibling' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:145:9: 'following_sibling'
            {
            match("following_sibling"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:146:7: ( 'following' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:146:9: 'following'
            {
            match("following"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:147:7: ( 'namespace' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:147:9: 'namespace'
            {
            match("namespace"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:148:7: ( 'ancestor' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:148:9: 'ancestor'
            {
            match("ancestor"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:149:7: ( 'preceding_sibling' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:149:9: 'preceding_sibling'
            {
            match("preceding_sibling"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:150:7: ( 'preceding' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:150:9: 'preceding'
            {
            match("preceding"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:151:7: ( 'ancestor_or_self' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:151:9: 'ancestor_or_self'
            {
            match("ancestor_or_self"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:859:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:860:15: ~ ( '\\r' | '\\n' )
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:865:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:866:43: ( '\\n' | ~ '\\n' )
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:871:3: ( '[' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:872:3: '['
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:877:3: ( ']' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:878:3: ']'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:883:3: ( '{' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:884:3: '{'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:889:3: ( '}' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:890:3: '}'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:895:3: ( '<' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:896:3: '<'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:901:3: ( '>' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:902:3: '>'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:907:3: ( '(' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:908:3: '('
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:913:3: ( ')' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:914:3: ')'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:919:3: ( '!' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:920:3: '!'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:925:3: ( '=' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:926:3: '='
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:931:3: ( '==' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:932:3: '=='
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:937:3: ( ':=' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:938:3: ':='
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:943:3: ( '.' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:944:3: '.'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:949:3: ( '..' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:950:3: '..'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:955:3: ( '->' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:956:3: '->'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:961:3: ( '|' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:962:3: '|'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:967:3: ( ':' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:968:3: ':'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:973:3: ( '::' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:974:3: '::'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:979:3: ( ';' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:980:3: ';'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:985:3: ( 'including' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:986:3: 'including'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:991:3: ( 'excluding' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:992:3: 'excluding'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:997:3: ( 'includingAt' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:998:3: 'includingAt'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1003:3: ( 'excludingAt' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1004:3: 'excludingAt'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1009:3: ( 'iterate' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1010:3: 'iterate'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1015:3: ( '{[' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1016:3: '{['
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1021:3: ( '[{' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1022:3: '[{'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1027:3: ( '}]' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1028:3: '}]'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1033:3: ( ']}' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1034:3: ']}'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1039:3: ( '*' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1040:3: '*'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1049:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1049:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1049:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1049:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1050:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1051:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1052:5: '\\n'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1058:2: ( ( ' ' | '\\t' ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1058:4: ( ' ' | '\\t' )
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1065:2: ( '0' .. '9' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1065:4: '0' .. '9'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1070:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1081:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1081:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1081:4: ( ALPHA )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1081:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1081:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1084:6: ( 'true' | 'false' )
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
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1084:8: 'true'
                    {
                    match("true"); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1084:17: 'false'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1086:8: ( 'o:' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1086:10: 'o:'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1089:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1089:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1089:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
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
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1090:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1091:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1092:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1094:4: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1095:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1102:2: ( '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+ )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1102:4: '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
            {
            match("0x"); if (state.failed) return ;

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1102:8: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
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
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1102:9: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1108:2: ( ( DIGIT )+ )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1108:4: ( DIGIT )+
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1108:4: ( DIGIT )+
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
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1108:5: DIGIT
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1114:2: ( '.' ( DIGIT )+ | ( DIGIT )+ '.' ( DIGIT )* )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='.') ) {
                alt13=1;
            }
            else if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1114:4: '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1114:8: ( DIGIT )+
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
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1114:8: DIGIT
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


                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1115:4: ( DIGIT )+ '.' ( DIGIT )*
                    {
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1115:4: ( DIGIT )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1115:4: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);

                    match('.'); if (state.failed) return ;
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1115:15: ( DIGIT )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1115:15: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1121:2: ( ( '.' ( DIGIT )+ | ( DIGIT )+ ( '.' ( DIGIT )* )? ) ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1121:4: ( '.' ( DIGIT )+ | ( DIGIT )+ ( '.' ( DIGIT )* )? ) ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1121:4: ( '.' ( DIGIT )+ | ( DIGIT )+ ( '.' ( DIGIT )* )? )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='.') ) {
                alt18=1;
            }
            else if ( ((LA18_0>='0' && LA18_0<='9')) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1122:4: '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1122:8: ( DIGIT )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1122:8: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1124:6: ( DIGIT )+ ( '.' ( DIGIT )* )?
                    {
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1124:6: ( DIGIT )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1124:6: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1124:13: ( '.' ( DIGIT )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='.') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1124:15: '.' ( DIGIT )*
                            {
                            match('.'); if (state.failed) return ;
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1124:19: ( DIGIT )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1124:19: DIGIT
                            	    {
                            	    mDIGIT(); if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1126:17: ( '+' | '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='+'||LA19_0=='-') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:
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


                    }
                    break;

            }

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1126:32: ( DIGIT )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1126:32: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "RANGE_OR_INT_OR_FLOAT_OR_DOUBLE"
    public final void mRANGE_OR_INT_OR_FLOAT_OR_DOUBLE() throws RecognitionException {
        try {
            int _type = RANGE_OR_INT_OR_FLOAT_OR_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1130:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' ) )=> DOUBLE | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt21=5;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1130:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1131:7: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1132:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' ) )=> DOUBLE
                    {
                    mDOUBLE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = DOUBLE; 
                    }

                    }
                    break;
                case 4 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1139:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 5 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1146:9: INT
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
    // $ANTLR end "RANGE_OR_INT_OR_FLOAT_OR_DOUBLE"

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1149:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1149:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1149:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==' '||LA26_0=='T') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1149:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
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
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1150:13: ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==','||LA23_0=='.') && (synpred5_Collection())) {
                        alt23=1;
                    }
                    else {
                        alt23=2;}
                    switch (alt23) {
                        case 1 :
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1151:15: ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ )
                            {
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1151:40: ( ( ',' | '.' ) ( DIGIT )+ )
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1151:41: ( ',' | '.' ) ( DIGIT )+
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

                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1151:53: ( DIGIT )+
                            int cnt22=0;
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( ((LA22_0>='0' && LA22_0<='9')) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1151:54: DIGIT
                            	    {
                            	    mDIGIT(); if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt22 >= 1 ) break loop22;
                            	    if (state.backtracking>0) {state.failed=true; return ;}
                                        EarlyExitException eee =
                                            new EarlyExitException(22, input);
                                        throw eee;
                                }
                                cnt22++;
                            } while (true);


                            }


                            }
                            break;
                        case 2 :
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1153:13: 
                            {
                            }
                            break;

                    }

                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1154:13: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='Z') ) {
                        alt25=1;
                    }
                    else {
                        alt25=2;}
                    switch (alt25) {
                        case 1 :
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1154:14: 'Z'
                            {
                            match('Z'); if (state.failed) return ;

                            }
                            break;
                        case 2 :
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1154:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            {
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1154:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0=='+'||LA24_0=='-') ) {
                                alt24=1;
                            }
                            switch (alt24) {
                                case 1 :
                                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1154:21: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1157:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1157:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1158:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( (LA27_0=='\n') ) {
                    alt27=1;
                }
                else if ( ((LA27_0>='\u0000' && LA27_0<='\t')||(LA27_0>='\u000B' && LA27_0<='!')||(LA27_0>='#' && LA27_0<='[')||(LA27_0>=']' && LA27_0<='\uFFFF')) ) {
                    alt27=2;
                }


                switch (alt27) {
            	case 1 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1160:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1161:5: ~ ( '\\\\' | '\"' | '\\n' )
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
            	    break loop27;
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
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:8: ( T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT_OR_FLOAT_OR_DOUBLE | DATE | STRING )
        int alt28=76;
        alt28 = dfa28.predict(input);
        switch (alt28) {
            case 1 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:10: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 2 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:16: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 3 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:22: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 4 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:28: T__53
                {
                mT__53(); if (state.failed) return ;

                }
                break;
            case 5 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:34: T__54
                {
                mT__54(); if (state.failed) return ;

                }
                break;
            case 6 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:40: T__55
                {
                mT__55(); if (state.failed) return ;

                }
                break;
            case 7 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:46: T__56
                {
                mT__56(); if (state.failed) return ;

                }
                break;
            case 8 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:52: T__57
                {
                mT__57(); if (state.failed) return ;

                }
                break;
            case 9 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:58: T__58
                {
                mT__58(); if (state.failed) return ;

                }
                break;
            case 10 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:64: T__59
                {
                mT__59(); if (state.failed) return ;

                }
                break;
            case 11 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:70: T__60
                {
                mT__60(); if (state.failed) return ;

                }
                break;
            case 12 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:76: T__61
                {
                mT__61(); if (state.failed) return ;

                }
                break;
            case 13 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:82: T__62
                {
                mT__62(); if (state.failed) return ;

                }
                break;
            case 14 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:88: T__63
                {
                mT__63(); if (state.failed) return ;

                }
                break;
            case 15 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:94: T__64
                {
                mT__64(); if (state.failed) return ;

                }
                break;
            case 16 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:100: T__65
                {
                mT__65(); if (state.failed) return ;

                }
                break;
            case 17 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:106: T__66
                {
                mT__66(); if (state.failed) return ;

                }
                break;
            case 18 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:112: T__67
                {
                mT__67(); if (state.failed) return ;

                }
                break;
            case 19 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:118: T__68
                {
                mT__68(); if (state.failed) return ;

                }
                break;
            case 20 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:124: T__69
                {
                mT__69(); if (state.failed) return ;

                }
                break;
            case 21 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:130: T__70
                {
                mT__70(); if (state.failed) return ;

                }
                break;
            case 22 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:136: T__71
                {
                mT__71(); if (state.failed) return ;

                }
                break;
            case 23 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:142: T__72
                {
                mT__72(); if (state.failed) return ;

                }
                break;
            case 24 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:148: T__73
                {
                mT__73(); if (state.failed) return ;

                }
                break;
            case 25 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:154: T__74
                {
                mT__74(); if (state.failed) return ;

                }
                break;
            case 26 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:160: T__75
                {
                mT__75(); if (state.failed) return ;

                }
                break;
            case 27 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:166: T__76
                {
                mT__76(); if (state.failed) return ;

                }
                break;
            case 28 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:172: T__77
                {
                mT__77(); if (state.failed) return ;

                }
                break;
            case 29 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:178: T__78
                {
                mT__78(); if (state.failed) return ;

                }
                break;
            case 30 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:184: T__79
                {
                mT__79(); if (state.failed) return ;

                }
                break;
            case 31 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:190: T__80
                {
                mT__80(); if (state.failed) return ;

                }
                break;
            case 32 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:196: T__81
                {
                mT__81(); if (state.failed) return ;

                }
                break;
            case 33 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:202: T__82
                {
                mT__82(); if (state.failed) return ;

                }
                break;
            case 34 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:208: T__83
                {
                mT__83(); if (state.failed) return ;

                }
                break;
            case 35 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:214: T__84
                {
                mT__84(); if (state.failed) return ;

                }
                break;
            case 36 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:220: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 37 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:228: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 38 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:247: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 39 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:256: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 40 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:265: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 41 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:271: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 42 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:277: LANGLE
                {
                mLANGLE(); if (state.failed) return ;

                }
                break;
            case 43 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:284: RANGLE
                {
                mRANGLE(); if (state.failed) return ;

                }
                break;
            case 44 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:291: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 45 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:298: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 46 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:305: EXCL
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 47 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:310: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 48 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:317: EQUALSEQUALS
                {
                mEQUALSEQUALS(); if (state.failed) return ;

                }
                break;
            case 49 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:330: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 50 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:337: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 51 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:341: DDOT
                {
                mDDOT(); if (state.failed) return ;

                }
                break;
            case 52 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:346: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 53 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:352: PIPE
                {
                mPIPE(); if (state.failed) return ;

                }
                break;
            case 54 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:357: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 55 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:363: DCOLON
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 56 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:370: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 57 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:380: INCLUDING
                {
                mINCLUDING(); if (state.failed) return ;

                }
                break;
            case 58 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:390: EXCLUDING
                {
                mEXCLUDING(); if (state.failed) return ;

                }
                break;
            case 59 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:400: INCLUDINGAT
                {
                mINCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 60 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:412: EXCLUDINGAT
                {
                mEXCLUDINGAT(); if (state.failed) return ;

                }
                break;
            case 61 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:424: ITERATE
                {
                mITERATE(); if (state.failed) return ;

                }
                break;
            case 62 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:432: LCURL_LBRACK
                {
                mLCURL_LBRACK(); if (state.failed) return ;

                }
                break;
            case 63 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:445: LBRACK_LCURL
                {
                mLBRACK_LCURL(); if (state.failed) return ;

                }
                break;
            case 64 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:458: RCURL_RBRACK
                {
                mRCURL_RBRACK(); if (state.failed) return ;

                }
                break;
            case 65 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:471: RBRACK_RCURL
                {
                mRBRACK_RCURL(); if (state.failed) return ;

                }
                break;
            case 66 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:484: STAR
                {
                mSTAR(); if (state.failed) return ;

                }
                break;
            case 67 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:489: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 68 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:492: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 69 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:495: BOOL
                {
                mBOOL(); if (state.failed) return ;

                }
                break;
            case 70 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:500: OBJECT
                {
                mOBJECT(); if (state.failed) return ;

                }
                break;
            case 71 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:507: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 72 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:512: BINARY
                {
                mBINARY(); if (state.failed) return ;

                }
                break;
            case 73 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:519: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 74 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:523: RANGE_OR_INT_OR_FLOAT_OR_DOUBLE
                {
                mRANGE_OR_INT_OR_FLOAT_OR_DOUBLE(); if (state.failed) return ;

                }
                break;
            case 75 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:555: DATE
                {
                mDATE(); if (state.failed) return ;

                }
                break;
            case 76 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1:560: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_Collection
    public final void synpred1_Collection_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1130:9: ( INT '..' )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1130:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_Collection

    // $ANTLR start synpred2_Collection
    public final void synpred2_Collection_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1131:7: ( INT '.' NAME )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1131:9: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Collection

    // $ANTLR start synpred3_Collection
    public final void synpred3_Collection_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1132:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' ) )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1132:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' )
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

        if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end synpred3_Collection

    // $ANTLR start synpred4_Collection
    public final void synpred4_Collection_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1139:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1139:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
    // $ANTLR end synpred4_Collection

    // $ANTLR start synpred5_Collection
    public final void synpred5_Collection_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1151:15: ( ( ',' | '.' ) DIGIT )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\Collection.g:1151:17: ( ',' | '.' ) DIGIT
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
    // $ANTLR end synpred5_Collection

    public final boolean synpred5_Collection() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Collection_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Collection() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Collection_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Collection() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Collection_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Collection() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Collection_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Collection() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Collection_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA21 dfa21 = new DFA21(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA21_eotS =
        "\4\uffff\1\13\4\uffff\2\13\1\uffff";
    static final String DFA21_eofS =
        "\14\uffff";
    static final String DFA21_minS =
        "\2\56\1\60\1\56\1\60\4\uffff\2\60\1\uffff";
    static final String DFA21_maxS =
        "\1\71\1\145\1\71\2\145\4\uffff\2\145\1\uffff";
    static final String DFA21_acceptS =
        "\5\uffff\1\3\1\1\1\2\1\5\2\uffff\1\4";
    static final String DFA21_specialS =
        "\1\uffff\1\4\1\uffff\1\3\1\0\4\uffff\1\2\1\1\1\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\4\1\uffff\12\3\13\uffff\1\5\37\uffff\1\5",
            "\12\11",
            "\1\4\1\uffff\12\3\13\uffff\1\5\37\uffff\1\5",
            "\12\12\13\uffff\1\5\37\uffff\1\5",
            "",
            "",
            "",
            "",
            "\12\11\13\uffff\1\5\37\uffff\1\5",
            "\12\12\13\uffff\1\5\37\uffff\1\5",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1129:1: RANGE_OR_INT_OR_FLOAT_OR_DOUBLE : ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' ) )=> DOUBLE | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA21_4 = input.LA(1);

                         
                        int index21_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_4>='0' && LA21_4<='9')) ) {s = 10;}

                        else if ( (LA21_4=='E'||LA21_4=='e') && (synpred3_Collection())) {s = 5;}

                        else s = 11;

                         
                        input.seek(index21_4);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA21_10 = input.LA(1);

                         
                        int index21_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_10>='0' && LA21_10<='9')) ) {s = 10;}

                        else if ( (LA21_10=='E'||LA21_10=='e') && (synpred3_Collection())) {s = 5;}

                        else s = 11;

                         
                        input.seek(index21_10);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_9>='0' && LA21_9<='9')) ) {s = 9;}

                        else if ( (LA21_9=='E'||LA21_9=='e') && (synpred3_Collection())) {s = 5;}

                        else s = 11;

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA21_3 = input.LA(1);

                         
                        int index21_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_3=='.') ) {s = 4;}

                        else if ( (LA21_3=='E'||LA21_3=='e') && (synpred3_Collection())) {s = 5;}

                        else if ( ((LA21_3>='0' && LA21_3<='9')) ) {s = 3;}

                         
                        input.seek(index21_3);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA21_1 = input.LA(1);

                         
                        int index21_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_1>='0' && LA21_1<='9')) ) {s = 3;}

                        else if ( (LA21_1=='.') ) {s = 4;}

                        else if ( (LA21_1=='E'||LA21_1=='e') && (synpred3_Collection())) {s = 5;}

                        else if ( (synpred1_Collection()) ) {s = 6;}

                        else if ( (synpred2_Collection()) ) {s = 7;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index21_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA28_eotS =
        "\1\uffff\1\45\1\uffff\12\45\1\77\3\45\1\106\1\110\1\112\1\114\5"+
        "\uffff\1\116\1\121\1\124\3\uffff\1\45\3\uffff\1\45\1\uffff\2\130"+
        "\1\uffff\7\45\1\145\14\45\3\uffff\5\45\20\uffff\1\45\3\uffff\1\130"+
        "\13\45\1\uffff\24\45\1\130\1\u009c\1\45\1\u009e\23\45\1\u00b2\4"+
        "\45\1\u00b7\4\45\1\130\1\uffff\1\u00be\1\uffff\2\45\1\u00c1\1\u00c3"+
        "\2\45\1\u00c6\2\45\1\u00c9\6\45\1\u00b7\2\45\1\uffff\4\45\1\uffff"+
        "\4\45\1\130\2\uffff\1\45\1\u00db\1\uffff\1\45\1\uffff\2\45\1\uffff"+
        "\2\45\1\uffff\1\u00e1\1\u00e2\5\45\1\u00e8\10\45\1\u00f1\1\uffff"+
        "\4\45\1\u00f6\2\uffff\1\45\1\u00f8\1\u00f9\1\45\1\u00fb\1\uffff"+
        "\1\u00fc\7\45\1\uffff\4\45\1\uffff\1\45\2\uffff\1\45\2\uffff\1\45"+
        "\1\u010b\2\45\1\u010f\5\45\1\u0116\1\u0117\1\u0119\1\45\1\uffff"+
        "\1\u011b\1\u011c\1\45\1\uffff\1\u011f\1\u0121\1\u0122\1\u0123\2"+
        "\45\2\uffff\1\45\1\uffff\1\u0128\2\uffff\2\45\1\uffff\1\45\3\uffff"+
        "\1\u012c\1\u012d\2\45\1\uffff\2\45\1\u0132\2\uffff\4\45\1\uffff"+
        "\16\45\1\u0145\1\45\1\u0147\1\45\1\uffff\1\u0149\1\uffff\1\u014a"+
        "\2\uffff";
    static final String DFA28_eofS =
        "\u014b\uffff";
    static final String DFA28_minS =
        "\1\11\1\157\1\uffff\1\157\1\156\1\162\1\150\1\156\1\150\2\141\2"+
        "\145\1\52\1\151\1\156\1\162\1\173\1\175\1\133\1\135\5\uffff\1\75"+
        "\1\72\1\56\3\uffff\1\170\3\uffff\1\72\1\uffff\2\56\1\uffff\1\151"+
        "\1\145\1\144\1\151\1\157\1\154\1\151\1\60\1\145\1\151\1\164\2\155"+
        "\2\154\1\142\1\162\1\154\1\146\1\162\3\uffff\1\155\1\165\1\164\1"+
        "\143\1\145\20\uffff\1\143\3\uffff\1\56\1\144\1\141\1\171\1\154\1"+
        "\161\1\165\1\163\1\154\1\160\2\154\1\uffff\1\162\1\154\1\151\1\142"+
        "\2\145\1\154\1\163\1\152\1\151\1\146\1\141\1\143\1\141\2\145\1\162"+
        "\1\145\1\143\1\154\1\56\1\60\1\153\1\60\1\145\1\165\1\160\1\164"+
        "\1\145\1\154\1\144\1\165\1\141\1\145\1\146\1\145\1\163\1\141\1\165"+
        "\1\157\2\145\1\156\1\60\1\165\1\145\1\164\1\160\1\60\1\151\1\163"+
        "\1\145\1\165\1\55\1\uffff\1\60\1\uffff\1\141\1\145\2\60\1\143\1"+
        "\145\1\60\1\144\1\164\1\60\1\171\1\162\1\160\1\143\1\154\1\167\1"+
        "\60\1\143\1\147\1\uffff\1\154\1\156\1\151\1\157\1\uffff\1\142\1"+
        "\164\2\144\1\56\2\uffff\1\156\1\60\1\uffff\1\141\1\uffff\2\164\1"+
        "\uffff\1\151\1\145\1\uffff\2\60\1\141\1\150\1\141\1\151\1\164\1"+
        "\60\1\164\1\144\1\157\1\151\1\165\1\157\2\151\1\60\1\uffff\2\151"+
        "\1\145\1\156\1\60\2\uffff\1\143\2\60\1\156\1\60\1\uffff\1\60\1\141"+
        "\2\156\1\164\1\162\2\156\1\uffff\1\156\1\157\1\163\1\147\1\uffff"+
        "\1\145\2\uffff\1\147\2\uffff\1\156\1\60\1\164\1\145\1\60\2\147\1"+
        "\164\1\156\1\111\3\60\1\164\1\uffff\2\60\1\157\1\uffff\4\60\1\156"+
        "\1\164\2\uffff\1\163\1\uffff\1\60\2\uffff\1\162\1\163\1\uffff\1"+
        "\164\3\uffff\2\60\1\151\1\157\1\uffff\1\137\1\151\1\60\2\uffff\1"+
        "\142\1\162\1\163\1\142\1\uffff\1\154\1\137\1\145\1\154\1\151\1\163"+
        "\1\154\1\151\1\156\1\145\1\146\1\156\1\147\1\154\1\60\1\147\1\60"+
        "\1\146\1\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA28_maxS =
        "\1\u00ff\1\157\1\uffff\1\162\1\156\1\162\1\157\1\164\1\150\1\165"+
        "\1\157\2\165\1\57\1\162\1\164\1\162\1\173\1\175\1\133\1\135\5\uffff"+
        "\2\75\1\71\3\uffff\1\170\3\uffff\1\72\1\uffff\1\170\1\145\1\uffff"+
        "\1\151\1\145\1\157\1\151\1\157\1\156\1\151\1\u00ff\1\145\1\151\1"+
        "\164\2\155\1\162\1\154\1\142\1\162\1\154\1\163\1\162\3\uffff\1\155"+
        "\1\165\1\164\1\143\1\145\20\uffff\1\143\3\uffff\1\145\1\144\1\141"+
        "\1\171\1\154\1\161\1\165\1\163\1\154\1\160\2\154\1\uffff\1\162\1"+
        "\154\1\151\1\142\1\145\1\155\1\154\1\163\1\152\1\151\1\146\1\141"+
        "\1\143\1\141\2\145\1\162\1\145\1\143\1\154\1\145\1\u00ff\1\153\1"+
        "\u00ff\1\145\1\165\1\160\1\164\1\145\1\154\1\144\1\165\1\141\1\145"+
        "\1\146\1\145\1\163\1\141\1\165\1\157\2\145\1\156\1\u00ff\1\165\1"+
        "\145\1\164\1\160\1\u00ff\1\151\1\163\1\145\1\165\1\145\1\uffff\1"+
        "\u00ff\1\uffff\1\141\1\145\2\u00ff\1\143\1\145\1\u00ff\1\144\1\164"+
        "\1\u00ff\1\171\1\162\1\160\1\143\1\154\1\167\1\u00ff\1\143\1\147"+
        "\1\uffff\1\154\1\156\1\151\1\157\1\uffff\1\142\1\164\2\144\1\145"+
        "\2\uffff\1\156\1\u00ff\1\uffff\1\141\1\uffff\2\164\1\uffff\1\151"+
        "\1\145\1\uffff\2\u00ff\1\141\1\150\1\141\1\151\1\164\1\u00ff\1\164"+
        "\1\144\1\157\1\151\1\165\1\157\2\151\1\u00ff\1\uffff\2\151\1\145"+
        "\1\156\1\u00ff\2\uffff\1\143\2\u00ff\1\156\1\u00ff\1\uffff\1\u00ff"+
        "\1\141\2\156\1\164\1\162\2\156\1\uffff\1\156\1\157\1\163\1\147\1"+
        "\uffff\1\145\2\uffff\1\147\2\uffff\1\156\1\u00ff\1\164\1\145\1\u00ff"+
        "\2\147\1\164\1\156\1\111\3\u00ff\1\164\1\uffff\2\u00ff\1\157\1\uffff"+
        "\4\u00ff\1\156\1\164\2\uffff\1\163\1\uffff\1\u00ff\2\uffff\1\162"+
        "\1\163\1\uffff\1\164\3\uffff\2\u00ff\1\151\1\157\1\uffff\1\137\1"+
        "\151\1\u00ff\2\uffff\1\142\1\162\1\163\1\142\1\uffff\1\154\1\137"+
        "\1\145\1\154\1\151\1\163\1\154\1\151\1\156\1\145\1\146\1\156\1\147"+
        "\1\154\1\u00ff\1\147\1\u00ff\1\146\1\uffff\1\u00ff\1\uffff\1\u00ff"+
        "\2\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\2\22\uffff\1\52\1\53\1\54\1\55\1\56\3\uffff\1\64\1\65"+
        "\1\70\1\uffff\1\102\1\103\1\104\1\uffff\1\107\2\uffff\1\114\24\uffff"+
        "\1\44\1\45\1\21\5\uffff\1\77\1\46\1\101\1\47\1\76\1\50\1\100\1\51"+
        "\1\60\1\57\1\61\1\67\1\66\1\63\1\112\1\62\1\uffff\1\106\1\110\1"+
        "\111\14\uffff\1\10\66\uffff\1\1\1\uffff\1\11\23\uffff\1\33\4\uffff"+
        "\1\105\5\uffff\1\113\1\3\2\uffff\1\5\1\uffff\1\13\2\uffff\1\30\2"+
        "\uffff\1\12\21\uffff\1\4\5\uffff\1\15\1\26\5\uffff\1\23\10\uffff"+
        "\1\27\4\uffff\1\75\1\uffff\1\16\1\22\1\uffff\1\17\1\20\16\uffff"+
        "\1\25\3\uffff\1\40\6\uffff\1\71\1\37\1\uffff\1\36\1\uffff\1\24\1"+
        "\32\2\uffff\1\42\1\uffff\1\72\1\6\1\7\4\uffff\1\31\3\uffff\1\14"+
        "\1\73\4\uffff\1\74\22\uffff\1\43\1\uffff\1\35\1\uffff\1\41\1\34";
    static final String DFA28_specialS =
        "\u014b\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\43\1\42\2\uffff\1\42\22\uffff\1\43\1\31\1\50\1\uffff\1\2"+
            "\2\uffff\1\45\1\27\1\30\1\41\2\uffff\1\35\1\34\1\15\1\46\11"+
            "\47\1\33\1\37\1\25\1\32\1\26\2\uffff\32\45\1\21\1\uffff\1\22"+
            "\1\uffff\1\45\1\uffff\1\17\1\3\1\6\1\14\1\40\1\12\1\5\1\45\1"+
            "\7\4\45\1\11\1\44\1\20\2\45\1\13\1\16\1\4\1\1\1\10\3\45\1\23"+
            "\1\36\1\24\102\uffff\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\51",
            "",
            "\1\53\2\uffff\1\52",
            "\1\54",
            "\1\55",
            "\1\57\6\uffff\1\56",
            "\1\60\5\uffff\1\61",
            "\1\62",
            "\1\65\15\uffff\1\63\5\uffff\1\64",
            "\1\67\15\uffff\1\66",
            "\1\72\16\uffff\1\71\1\70",
            "\1\73\17\uffff\1\74",
            "\1\76\4\uffff\1\75",
            "\1\100\10\uffff\1\101",
            "\1\103\5\uffff\1\102",
            "\1\104",
            "\1\105",
            "\1\107",
            "\1\111",
            "\1\113",
            "",
            "",
            "",
            "",
            "",
            "\1\115",
            "\1\120\2\uffff\1\117",
            "\1\122\1\uffff\12\123",
            "",
            "",
            "",
            "\1\125",
            "",
            "",
            "",
            "\1\126",
            "",
            "\1\123\1\uffff\12\131\13\uffff\1\123\37\uffff\1\123\22\uffff"+
            "\1\127",
            "\1\123\1\uffff\12\131\13\uffff\1\123\37\uffff\1\123",
            "",
            "\1\132",
            "\1\133",
            "\1\134\12\uffff\1\135",
            "\1\136",
            "\1\137",
            "\1\141\1\142\1\140",
            "\1\143",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\2\45\1\144\27\45"+
            "\105\uffff\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\154\5\uffff\1\153",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161\14\uffff\1\162",
            "\1\163",
            "",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
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
            "\1\171",
            "",
            "",
            "",
            "\1\123\1\uffff\12\172\13\uffff\1\123\37\uffff\1\123",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b\7\uffff\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\123\1\uffff\12\u009b\13\uffff\1\123\37\uffff\1\123",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u009d",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u009f",
            "\1\u00a0",
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
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bd\1\123\1\uffff\12\u00bc\13\uffff\1\123\37\uffff\1"+
            "\123",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\21\45\1\u00c2\10"+
            "\45\105\uffff\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00c4",
            "\1\u00c5",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00c7",
            "\1\u00c8",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00d0",
            "\1\u00d1",
            "",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\123\1\uffff\12\u00bc\13\uffff\1\123\37\uffff\1\123",
            "",
            "",
            "\1\u00da",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "\1\u00de",
            "",
            "\1\u00df",
            "\1\u00e0",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "",
            "\1\u00f7",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00fa",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "",
            "\1\u0108",
            "",
            "",
            "\1\u0109",
            "",
            "",
            "\1\u010a",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u010c",
            "\1\u010d",
            "\12\45\7\uffff\32\45\4\uffff\1\u010e\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\12\45\7\uffff\1\u0115\31\45\4\uffff\1\45\1\uffff\32\45\105"+
            "\uffff\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\u0118\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u011a",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u011d",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\u011e\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\1\u0120\31\45\4\uffff\1\45\1\uffff\32\45\105"+
            "\uffff\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u0124",
            "\1\u0125",
            "",
            "",
            "\1\u0126",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\u0127\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "",
            "\1\u0129",
            "\1\u012a",
            "",
            "\1\u012b",
            "",
            "",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u012e",
            "\1\u012f",
            "",
            "\1\u0130",
            "\1\u0131",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "",
            "\1\u0137",
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
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u0146",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "\1\u0148",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            "\12\45\7\uffff\32\45\4\uffff\1\45\1\uffff\32\45\105\uffff"+
            "\27\45\1\uffff\37\45\1\uffff\10\45",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT_OR_FLOAT_OR_DOUBLE | DATE | STRING );";
        }
    }
 

}