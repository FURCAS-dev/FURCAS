// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g 2009-11-06 10:28:15

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
public class AdapterLexer extends Lexer {
    public static final int EXCLUDINGAT=41;
    public static final int STAR=31;
    public static final int LANGLE=24;
    public static final int EQUALS=16;
    public static final int EXCL=38;
    public static final int INCLUDINGAT=40;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int LBRACKET=20;
    public static final int T__91=91;
    public static final int RPAREN=15;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int DCOLON=18;
    public static final int T__90=90;
    public static final int LBRACK_LCURL=32;
    public static final int NL=42;
    public static final int RANGLE=25;
    public static final int COMMENT=36;
    public static final int LCURL_LBRACK=34;
    public static final int T__80=80;
    public static final int DDOT=30;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int BOOL=8;
    public static final int SEMICOLON=11;
    public static final int INT=6;
    public static final int T__85=85;
    public static final int EXCLUDING=28;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int ALPHA=45;
    public static final int T__88=88;
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
    public static final int LPAREN=14;
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
    public static final int PIPE=23;
    public static final int DIGIT=44;
    public static final int RANGE_OR_INT=48;
    public static final int RBRACKET=26;
    public static final int DOT=17;
    public static final int T__50=50;
    public static final int EQUALSEQUALS=21;
    public static final int RCURL_RBRACK=33;
    public static final int T__49=49;
    public static final int MULTI_LINE_COMMENT=37;
    public static final int COLON=22;
    public static final int ITERATE=29;
    public static final int LCURL=12;
    public static final int RCURL=13;
    public static final int ASSIGN=39;
    public static final int ARROW=19;
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

    public AdapterLexer() {;} 
    public AdapterLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public AdapterLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g"; }

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:117:7: ( 'foreach' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:117:9: 'foreach'
            {
            match("foreach"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:118:7: ( 'replace' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:118:9: 'replace'
            {
            match("replace"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:119:7: ( 'adapter' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:119:9: 'adapter'
            {
            match("adapter"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:120:7: ( 'aggregate' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:120:9: 'aggregate'
            {
            match("aggregate"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:121:7: ( 'owns' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:121:9: 'owns'
            {
            match("owns"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:122:7: ( 'delete' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:122:9: 'delete'
            {
            match("delete"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:123:7: ( '+=' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:123:9: '+='
            {
            match("+="); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:124:7: ( 'store' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:124:9: 'store'
            {
            match("store"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:125:7: ( '?' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:125:9: '?'
            {
            match('?'); if (state.failed) return ;
            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:126:7: ( 'void' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:126:9: 'void'
            {
            match("void"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:127:7: ( 'key' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:127:9: 'key'
            {
            match("key"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:128:7: ( 'head' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:128:9: 'head'
            {
            match("head"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:129:7: ( 'const' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:129:9: 'const'
            {
            match("const"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:130:7: ( 'count' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:130:9: 'count'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:131:7: ( 'changed' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:131:9: 'changed'
            {
            match("changed"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:132:7: ( 'return' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:132:9: 'return'
            {
            match("return"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:133:7: ( 'to' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:133:9: 'to'
            {
            match("to"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:134:7: ( 'while' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:134:9: 'while'
            {
            match("while"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:135:7: ( '<$' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:135:9: '<$'
            {
            match("<$"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:136:7: ( 'else' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:136:9: 'else'
            {
            match("else"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:137:7: ( 'commit' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:137:9: 'commit'
            {
            match("commit"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:138:7: ( 'dim' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:138:9: 'dim'
            {
            match("dim"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:139:7: ( '-=' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:139:9: '-='
            {
            match("-="); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:140:7: ( 'tail' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:140:9: 'tail'
            {
            match("tail"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:141:7: ( 'snapshot' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:141:9: 'snapshot'
            {
            match("snapshot"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:142:7: ( 'converter' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:142:9: 'converter'
            {
            match("converter"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:143:7: ( 'from' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:143:9: 'from'
            {
            match("from"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:144:7: ( 'all' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:144:9: 'all'
            {
            match("all"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:145:7: ( 'NULL' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:145:9: 'NULL'
            {
            match("NULL"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:146:7: ( 'value' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:146:9: 'value'
            {
            match("value"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:147:7: ( 'function' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:147:9: 'function'
            {
            match("function"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:148:7: ( 'RemoveLink' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:148:9: 'RemoveLink'
            {
            match("RemoveLink"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:149:7: ( 'rollback' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:149:9: 'rollback'
            {
            match("rollback"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:150:7: ( 'AddLink' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:150:9: 'AddLink'
            {
            match("AddLink"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:151:7: ( 'var' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:151:9: 'var'
            {
            match("var"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:152:7: ( 'native' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:152:9: 'native'
            {
            match("native"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:153:7: ( 'new' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:153:9: 'new'
            {
            match("new"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:154:7: ( '$>' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:154:9: '$>'
            {
            match("$>"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:155:7: ( 'if' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:155:9: 'if'
            {
            match("if"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:156:7: ( 'by' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:156:9: 'by'
            {
            match("by"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:157:7: ( 'this' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:157:9: 'this'
            {
            match("this"); if (state.failed) return ;

            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:158:7: ( ',' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:158:9: ','
            {
            match(','); if (state.failed) return ;
            
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:159:7: ( '1000' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:159:9: '1000'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:160:7: ( '2000' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:160:9: '2000'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:161:7: ( '3000' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:161:9: '3000'
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

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2460:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);
                
                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }
                
            
                switch (alt1) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2461:15: ~ ( '\\r' | '\\n' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2466:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2467:43: ( '\\n' | ~ '\\n' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2472:3: ( '[' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2473:3: '['
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2478:3: ( ']' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2479:3: ']'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2484:3: ( '{' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2485:3: '{'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2490:3: ( '}' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2491:3: '}'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2496:3: ( '<' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2497:3: '<'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2502:3: ( '>' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2503:3: '>'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2508:3: ( '(' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2509:3: '('
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2514:3: ( ')' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2515:3: ')'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2520:3: ( '!' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2521:3: '!'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2526:3: ( '=' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2527:3: '='
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2532:3: ( '==' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2533:3: '=='
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2538:3: ( ':=' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2539:3: ':='
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2544:3: ( '.' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2545:3: '.'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2550:3: ( '..' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2551:3: '..'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2556:3: ( '->' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2557:3: '->'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2562:3: ( '|' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2563:3: '|'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2568:3: ( ':' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2569:3: ':'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2574:3: ( '::' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2575:3: '::'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2580:3: ( ';' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2581:3: ';'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2586:3: ( 'including' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2587:3: 'including'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2592:3: ( 'excluding' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2593:3: 'excluding'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2598:3: ( 'includingAt' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2599:3: 'includingAt'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2604:3: ( 'excludingAt' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2605:3: 'excludingAt'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2610:3: ( 'iterate' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2611:3: 'iterate'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2616:3: ( '{[' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2617:3: '{['
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2622:3: ( '[{' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2623:3: '[{'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2628:3: ( '}]' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2629:3: '}]'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2634:3: ( ']}' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2635:3: ']}'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2640:3: ( '*' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2641:3: '*'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2650:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2650:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2650:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2650:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;
                    
                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2651:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;
                    
                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2652:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;
                    
                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2653:5: '\\n'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2659:2: ( ( ' ' | '\\t' ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2659:4: ( ' ' | '\\t' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2666:2: ( '0' .. '9' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2666:4: '0' .. '9'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2671:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2682:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2682:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2682:4: ( ALPHA )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2682:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;
            
            }

            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2682:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);
                
                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }
                
            
                switch (alt4) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2685:6: ( 'true' | 'false' )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2685:8: 'true'
                    {
                    match("true"); if (state.failed) return ;

                    
                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2685:17: 'false'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2687:8: ( 'o:' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2687:10: 'o:'
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2690:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2690:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2690:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2691:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;
                    
                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2692:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2693:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2695:4: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }
                    	    
                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2696:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2703:2: ( '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+ )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2703:4: '0x' ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
            {
            match("0x"); if (state.failed) return ;

            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2703:8: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2703:9: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2708:2: ( ( DIGIT )+ )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2708:4: ( DIGIT )+
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2708:4: ( DIGIT )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2708:5: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2713:2: ( ( DIGIT )+ '.' ( DIGIT )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2713:4: ( DIGIT )+ '.' ( DIGIT )*
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2713:4: ( DIGIT )+
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2713:4: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2713:15: ( DIGIT )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);
                
                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }
                
            
                switch (alt11) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2713:15: DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2717:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt12=4;
            int LA12_0 = input.LA(1);
            
            if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                int LA12_1 = input.LA(2);
                
                if ( ((LA12_1>='0' && LA12_1<='9')) && (synpred3_Adapter())) {
                    alt12=3;
                }
                else if ( (LA12_1=='.') && (synpred3_Adapter())) {
                    alt12=3;
                }
                else if ( (synpred1_Adapter()) ) {
                    alt12=1;
                }
                else if ( (synpred2_Adapter()) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2717:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }
                    
                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2718:7: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }
                    
                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2719:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }
                    
                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2726:9: INT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2730:6: ( DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )? )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2730:8: DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2730:64: ( ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);
            
            if ( (LA17_0==' '||LA17_0=='T') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2730:65: ( ' ' | 'T' ) DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | ) ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2731:13: ( ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ ) | )
                    int alt14=2;
                    int LA14_0 = input.LA(1);
                    
                    if ( (LA14_0==','||LA14_0=='.') && (synpred4_Adapter())) {
                        alt14=1;
                    }
                    else {
                        alt14=2;}
                    switch (alt14) {
                        case 1 :
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2732:15: ( ( ',' | '.' ) DIGIT )=> ( ( ',' | '.' ) ( DIGIT )+ )
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2732:40: ( ( ',' | '.' ) ( DIGIT )+ )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2732:41: ( ',' | '.' ) ( DIGIT )+
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

                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2732:53: ( DIGIT )+
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
                            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2732:54: DIGIT
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2734:13: 
                            {
                            }
                            break;
                    
                    }

                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2735:13: ( 'Z' | ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )? )
                    int alt16=2;
                    int LA16_0 = input.LA(1);
                    
                    if ( (LA16_0=='Z') ) {
                        alt16=1;
                    }
                    else {
                        alt16=2;}
                    switch (alt16) {
                        case 1 :
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2735:14: 'Z'
                            {
                            match('Z'); if (state.failed) return ;
                            
                            }
                            break;
                        case 2 :
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2735:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2735:20: ( ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);
                            
                            if ( (LA15_0=='+'||LA15_0=='-') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2735:21: ( '+' | '-' ) DIGIT DIGIT DIGIT DIGIT
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
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2738:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2738:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2739:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2741:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }
            	    
            	    }
            	    break;
            	case 2 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2742:5: ~ ( '\\\\' | '\"' | '\\n' )
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
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:8: ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING )
        int alt19=86;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:10: T__49
                {
                mT__49(); if (state.failed) return ;
                
                }
                break;
            case 2 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:16: T__50
                {
                mT__50(); if (state.failed) return ;
                
                }
                break;
            case 3 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:22: T__51
                {
                mT__51(); if (state.failed) return ;
                
                }
                break;
            case 4 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:28: T__52
                {
                mT__52(); if (state.failed) return ;
                
                }
                break;
            case 5 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:34: T__53
                {
                mT__53(); if (state.failed) return ;
                
                }
                break;
            case 6 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:40: T__54
                {
                mT__54(); if (state.failed) return ;
                
                }
                break;
            case 7 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:46: T__55
                {
                mT__55(); if (state.failed) return ;
                
                }
                break;
            case 8 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:52: T__56
                {
                mT__56(); if (state.failed) return ;
                
                }
                break;
            case 9 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:58: T__57
                {
                mT__57(); if (state.failed) return ;
                
                }
                break;
            case 10 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:64: T__58
                {
                mT__58(); if (state.failed) return ;
                
                }
                break;
            case 11 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:70: T__59
                {
                mT__59(); if (state.failed) return ;
                
                }
                break;
            case 12 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:76: T__60
                {
                mT__60(); if (state.failed) return ;
                
                }
                break;
            case 13 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:82: T__61
                {
                mT__61(); if (state.failed) return ;
                
                }
                break;
            case 14 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:88: T__62
                {
                mT__62(); if (state.failed) return ;
                
                }
                break;
            case 15 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:94: T__63
                {
                mT__63(); if (state.failed) return ;
                
                }
                break;
            case 16 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:100: T__64
                {
                mT__64(); if (state.failed) return ;
                
                }
                break;
            case 17 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:106: T__65
                {
                mT__65(); if (state.failed) return ;
                
                }
                break;
            case 18 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:112: T__66
                {
                mT__66(); if (state.failed) return ;
                
                }
                break;
            case 19 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:118: T__67
                {
                mT__67(); if (state.failed) return ;
                
                }
                break;
            case 20 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:124: T__68
                {
                mT__68(); if (state.failed) return ;
                
                }
                break;
            case 21 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:130: T__69
                {
                mT__69(); if (state.failed) return ;
                
                }
                break;
            case 22 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:136: T__70
                {
                mT__70(); if (state.failed) return ;
                
                }
                break;
            case 23 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:142: T__71
                {
                mT__71(); if (state.failed) return ;
                
                }
                break;
            case 24 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:148: T__72
                {
                mT__72(); if (state.failed) return ;
                
                }
                break;
            case 25 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:154: T__73
                {
                mT__73(); if (state.failed) return ;
                
                }
                break;
            case 26 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:160: T__74
                {
                mT__74(); if (state.failed) return ;
                
                }
                break;
            case 27 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:166: T__75
                {
                mT__75(); if (state.failed) return ;
                
                }
                break;
            case 28 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:172: T__76
                {
                mT__76(); if (state.failed) return ;
                
                }
                break;
            case 29 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:178: T__77
                {
                mT__77(); if (state.failed) return ;
                
                }
                break;
            case 30 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:184: T__78
                {
                mT__78(); if (state.failed) return ;
                
                }
                break;
            case 31 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:190: T__79
                {
                mT__79(); if (state.failed) return ;
                
                }
                break;
            case 32 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:196: T__80
                {
                mT__80(); if (state.failed) return ;
                
                }
                break;
            case 33 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:202: T__81
                {
                mT__81(); if (state.failed) return ;
                
                }
                break;
            case 34 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:208: T__82
                {
                mT__82(); if (state.failed) return ;
                
                }
                break;
            case 35 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:214: T__83
                {
                mT__83(); if (state.failed) return ;
                
                }
                break;
            case 36 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:220: T__84
                {
                mT__84(); if (state.failed) return ;
                
                }
                break;
            case 37 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:226: T__85
                {
                mT__85(); if (state.failed) return ;
                
                }
                break;
            case 38 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:232: T__86
                {
                mT__86(); if (state.failed) return ;
                
                }
                break;
            case 39 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:238: T__87
                {
                mT__87(); if (state.failed) return ;
                
                }
                break;
            case 40 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:244: T__88
                {
                mT__88(); if (state.failed) return ;
                
                }
                break;
            case 41 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:250: T__89
                {
                mT__89(); if (state.failed) return ;
                
                }
                break;
            case 42 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:256: T__90
                {
                mT__90(); if (state.failed) return ;
                
                }
                break;
            case 43 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:262: T__91
                {
                mT__91(); if (state.failed) return ;
                
                }
                break;
            case 44 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:268: T__92
                {
                mT__92(); if (state.failed) return ;
                
                }
                break;
            case 45 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:274: T__93
                {
                mT__93(); if (state.failed) return ;
                
                }
                break;
            case 46 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:280: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;
                
                }
                break;
            case 47 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:288: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;
                
                }
                break;
            case 48 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:307: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;
                
                }
                break;
            case 49 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:316: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;
                
                }
                break;
            case 50 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:325: LCURL
                {
                mLCURL(); if (state.failed) return ;
                
                }
                break;
            case 51 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:331: RCURL
                {
                mRCURL(); if (state.failed) return ;
                
                }
                break;
            case 52 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:337: LANGLE
                {
                mLANGLE(); if (state.failed) return ;
                
                }
                break;
            case 53 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:344: RANGLE
                {
                mRANGLE(); if (state.failed) return ;
                
                }
                break;
            case 54 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:351: LPAREN
                {
                mLPAREN(); if (state.failed) return ;
                
                }
                break;
            case 55 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:358: RPAREN
                {
                mRPAREN(); if (state.failed) return ;
                
                }
                break;
            case 56 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:365: EXCL
                {
                mEXCL(); if (state.failed) return ;
                
                }
                break;
            case 57 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:370: EQUALS
                {
                mEQUALS(); if (state.failed) return ;
                
                }
                break;
            case 58 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:377: EQUALSEQUALS
                {
                mEQUALSEQUALS(); if (state.failed) return ;
                
                }
                break;
            case 59 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:390: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;
                
                }
                break;
            case 60 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:397: DOT
                {
                mDOT(); if (state.failed) return ;
                
                }
                break;
            case 61 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:401: DDOT
                {
                mDDOT(); if (state.failed) return ;
                
                }
                break;
            case 62 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:406: ARROW
                {
                mARROW(); if (state.failed) return ;
                
                }
                break;
            case 63 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:412: PIPE
                {
                mPIPE(); if (state.failed) return ;
                
                }
                break;
            case 64 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:417: COLON
                {
                mCOLON(); if (state.failed) return ;
                
                }
                break;
            case 65 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:423: DCOLON
                {
                mDCOLON(); if (state.failed) return ;
                
                }
                break;
            case 66 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:430: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;
                
                }
                break;
            case 67 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:440: INCLUDING
                {
                mINCLUDING(); if (state.failed) return ;
                
                }
                break;
            case 68 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:450: EXCLUDING
                {
                mEXCLUDING(); if (state.failed) return ;
                
                }
                break;
            case 69 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:460: INCLUDINGAT
                {
                mINCLUDINGAT(); if (state.failed) return ;
                
                }
                break;
            case 70 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:472: EXCLUDINGAT
                {
                mEXCLUDINGAT(); if (state.failed) return ;
                
                }
                break;
            case 71 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:484: ITERATE
                {
                mITERATE(); if (state.failed) return ;
                
                }
                break;
            case 72 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:492: LCURL_LBRACK
                {
                mLCURL_LBRACK(); if (state.failed) return ;
                
                }
                break;
            case 73 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:505: LBRACK_LCURL
                {
                mLBRACK_LCURL(); if (state.failed) return ;
                
                }
                break;
            case 74 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:518: RCURL_RBRACK
                {
                mRCURL_RBRACK(); if (state.failed) return ;
                
                }
                break;
            case 75 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:531: RBRACK_RCURL
                {
                mRBRACK_RCURL(); if (state.failed) return ;
                
                }
                break;
            case 76 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:544: STAR
                {
                mSTAR(); if (state.failed) return ;
                
                }
                break;
            case 77 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:549: NL
                {
                mNL(); if (state.failed) return ;
                
                }
                break;
            case 78 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:552: WS
                {
                mWS(); if (state.failed) return ;
                
                }
                break;
            case 79 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:555: BOOL
                {
                mBOOL(); if (state.failed) return ;
                
                }
                break;
            case 80 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:560: OBJECT
                {
                mOBJECT(); if (state.failed) return ;
                
                }
                break;
            case 81 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:567: NAME
                {
                mNAME(); if (state.failed) return ;
                
                }
                break;
            case 82 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:572: BINARY
                {
                mBINARY(); if (state.failed) return ;
                
                }
                break;
            case 83 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:579: INT
                {
                mINT(); if (state.failed) return ;
                
                }
                break;
            case 84 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:583: RANGE_OR_INT
                {
                mRANGE_OR_INT(); if (state.failed) return ;
                
                }
                break;
            case 85 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:596: DATE
                {
                mDATE(); if (state.failed) return ;
                
                }
                break;
            case 86 :
                // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:1:601: STRING
                {
                mSTRING(); if (state.failed) return ;
                
                }
                break;
        
        }
    
    }

    // $ANTLR start synpred1_Adapter
    public final void synpred1_Adapter_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2717:9: ( INT '..' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2717:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;

        
        }
    }
    // $ANTLR end synpred1_Adapter

    // $ANTLR start synpred2_Adapter
    public final void synpred2_Adapter_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2718:7: ( INT '.' NAME )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2718:9: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;
        
        }
    }
    // $ANTLR end synpred2_Adapter

    // $ANTLR start synpred3_Adapter
    public final void synpred3_Adapter_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2719:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2719:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
    // $ANTLR end synpred3_Adapter

    // $ANTLR start synpred4_Adapter
    public final void synpred4_Adapter_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2732:15: ( ( ',' | '.' ) DIGIT )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Adapter.g:2732:17: ( ',' | '.' ) DIGIT
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
    // $ANTLR end synpred4_Adapter

    public final boolean synpred3_Adapter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Adapter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Adapter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Adapter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Adapter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Adapter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Adapter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Adapter_fragment(); // can never throw exception
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
        "\1\uffff\5\56\1\uffff\1\56\1\uffff\6\56\1\115\1\56\1\uffff\4\56"+
        "\1\uffff\2\56\1\uffff\3\134\1\uffff\1\144\1\146\1\150\1\152\4\uffff"+
        "\1\154\1\157\1\161\6\uffff\2\134\1\uffff\12\56\1\uffff\12\56\1\u008b"+
        "\4\56\2\uffff\2\56\2\uffff\5\56\1\u0097\2\56\1\u009a\1\134\1\uffff"+
        "\1\134\1\uffff\2\134\22\uffff\11\56\1\u00a8\2\56\1\u00ab\4\56\1"+
        "\u00b0\1\u00b1\5\56\1\uffff\12\56\1\u00c2\1\uffff\2\56\1\uffff\4"+
        "\134\1\56\1\u00ca\7\56\1\uffff\1\u00d2\1\56\1\uffff\2\56\1\u00d6"+
        "\1\56\2\uffff\1\u00d8\5\56\1\u00de\1\u00df\1\u00e0\1\56\1\u00e2"+
        "\1\56\1\u00e4\3\56\1\uffff\2\56\1\u00ea\1\134\1\u00ed\1\u00ee\1"+
        "\56\1\uffff\1\56\1\u00e0\5\56\1\uffff\1\56\1\u00f7\1\56\1\uffff"+
        "\1\u00f9\1\uffff\1\u00fa\1\56\1\u00fc\2\56\3\uffff\1\u00ff\1\uffff"+
        "\1\56\1\uffff\5\56\1\uffff\1\134\3\uffff\3\56\1\u0109\3\56\1\u010d"+
        "\1\uffff\1\56\2\uffff\1\56\1\uffff\1\u0110\1\56\1\uffff\3\56\1\u0115"+
        "\2\56\1\u0118\1\56\1\u011a\1\uffff\1\56\1\u011c\1\56\1\uffff\2\56"+
        "\1\uffff\1\u0120\2\56\1\u0123\1\uffff\1\56\1\u0125\1\uffff\1\u0126"+
        "\1\uffff\1\u0127\1\uffff\1\56\1\u0129\1\56\1\uffff\2\56\1\uffff"+
        "\1\56\3\uffff\1\u012e\1\uffff\1\u012f\1\u0131\1\56\1\u0134\2\uffff"+
        "\1\56\1\uffff\1\u0136\1\56\1\uffff\1\u0138\1\uffff\1\u0139\2\uffff";
    static final String DFA19_eofS =
        "\u013a\uffff";
    static final String DFA19_minS =
        "\1\11\1\141\1\145\1\144\1\72\1\145\1\uffff\1\156\1\uffff\1\141\2"+
        "\145\1\150\1\141\1\150\1\44\1\154\1\75\1\125\1\145\1\144\1\141\1"+
        "\uffff\1\146\1\171\1\uffff\3\56\1\52\1\173\1\175\1\133\1\135\4\uffff"+
        "\1\75\1\72\1\56\6\uffff\2\56\1\uffff\1\162\1\157\1\156\1\154\1\160"+
        "\1\154\1\141\1\147\1\154\1\156\1\uffff\1\154\1\155\1\157\1\141\1"+
        "\151\1\154\1\171\1\141\1\155\1\141\1\60\2\151\1\165\1\151\2\uffff"+
        "\1\163\1\143\2\uffff\1\114\1\155\1\144\1\164\1\167\1\60\1\143\1"+
        "\145\1\60\1\56\1\uffff\1\56\1\uffff\2\56\22\uffff\1\145\1\155\1"+
        "\143\1\163\1\154\1\165\1\154\1\160\1\162\1\60\1\163\1\145\1\60\1"+
        "\162\1\160\1\144\1\165\2\60\1\144\1\163\1\156\1\155\1\156\1\uffff"+
        "\1\154\1\163\1\145\1\154\1\145\1\154\1\114\1\157\1\114\1\151\1\60"+
        "\1\uffff\1\154\1\162\1\uffff\4\56\1\141\1\60\1\164\1\145\1\141\1"+
        "\162\1\142\1\164\1\145\1\uffff\1\60\1\164\1\uffff\1\145\1\163\1"+
        "\60\1\145\2\uffff\1\60\1\164\1\145\1\164\1\151\1\147\3\60\1\145"+
        "\1\60\1\165\1\60\1\166\1\151\1\166\1\uffff\1\165\1\141\4\55\1\143"+
        "\1\uffff\1\151\1\60\1\143\1\156\1\141\1\145\1\147\1\uffff\1\145"+
        "\1\60\1\150\1\uffff\1\60\1\uffff\1\60\1\162\1\60\1\164\1\145\3\uffff"+
        "\1\60\1\uffff\1\144\1\uffff\1\145\1\156\1\145\1\144\1\164\1\uffff"+
        "\1\56\3\uffff\1\150\1\157\1\145\1\60\1\143\1\162\1\141\1\60\1\uffff"+
        "\1\157\2\uffff\1\164\1\uffff\1\60\1\144\1\uffff\1\151\1\114\1\153"+
        "\1\60\1\151\1\145\1\60\1\156\1\60\1\uffff\1\153\1\60\1\164\1\uffff"+
        "\1\164\1\145\1\uffff\1\60\1\156\1\151\1\60\1\uffff\1\156\1\60\1"+
        "\uffff\1\60\1\uffff\1\60\1\uffff\1\145\1\60\1\162\1\uffff\1\147"+
        "\1\156\1\uffff\1\147\3\uffff\1\60\1\uffff\2\60\1\153\1\60\2\uffff"+
        "\1\164\1\uffff\1\60\1\164\1\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA19_maxS =
        "\1\u00ff\1\165\1\157\1\154\1\167\1\151\1\uffff\1\164\1\uffff\1\157"+
        "\2\145\1\157\1\162\1\150\1\44\1\170\1\76\1\125\1\145\1\144\1\145"+
        "\1\uffff\1\164\1\171\1\uffff\3\71\1\57\1\173\1\175\1\133\1\135\4"+
        "\uffff\2\75\1\56\6\uffff\1\170\1\71\1\uffff\1\162\1\157\1\156\1"+
        "\154\1\164\1\154\1\141\1\147\1\154\1\156\1\uffff\1\154\1\155\1\157"+
        "\1\141\1\151\1\162\1\171\1\141\1\165\1\141\1\u00ff\2\151\1\165\1"+
        "\151\2\uffff\1\163\1\143\2\uffff\1\114\1\155\1\144\1\164\1\167\1"+
        "\u00ff\1\143\1\145\1\u00ff\1\71\1\uffff\1\71\1\uffff\2\71\22\uffff"+
        "\1\145\1\155\1\143\1\163\1\154\1\165\1\154\1\160\1\162\1\u00ff\1"+
        "\163\1\145\1\u00ff\1\162\1\160\1\144\1\165\2\u00ff\1\144\1\166\1"+
        "\156\1\155\1\156\1\uffff\1\154\1\163\1\145\1\154\1\145\1\154\1\114"+
        "\1\157\1\114\1\151\1\u00ff\1\uffff\1\154\1\162\1\uffff\4\71\1\141"+
        "\1\u00ff\1\164\1\145\1\141\1\162\1\142\1\164\1\145\1\uffff\1\u00ff"+
        "\1\164\1\uffff\1\145\1\163\1\u00ff\1\145\2\uffff\1\u00ff\1\164\1"+
        "\145\1\164\1\151\1\147\3\u00ff\1\145\1\u00ff\1\165\1\u00ff\1\166"+
        "\1\151\1\166\1\uffff\1\165\1\141\4\71\1\143\1\uffff\1\151\1\u00ff"+
        "\1\143\1\156\1\141\1\145\1\147\1\uffff\1\145\1\u00ff\1\150\1\uffff"+
        "\1\u00ff\1\uffff\1\u00ff\1\162\1\u00ff\1\164\1\145\3\uffff\1\u00ff"+
        "\1\uffff\1\144\1\uffff\1\145\1\156\1\145\1\144\1\164\1\uffff\1\71"+
        "\3\uffff\1\150\1\157\1\145\1\u00ff\1\143\1\162\1\141\1\u00ff\1\uffff"+
        "\1\157\2\uffff\1\164\1\uffff\1\u00ff\1\144\1\uffff\1\151\1\114\1"+
        "\153\1\u00ff\1\151\1\145\1\u00ff\1\156\1\u00ff\1\uffff\1\153\1\u00ff"+
        "\1\164\1\uffff\1\164\1\145\1\uffff\1\u00ff\1\156\1\151\1\u00ff\1"+
        "\uffff\1\156\1\u00ff\1\uffff\1\u00ff\1\uffff\1\u00ff\1\uffff\1\145"+
        "\1\u00ff\1\162\1\uffff\1\147\1\156\1\uffff\1\147\3\uffff\1\u00ff"+
        "\1\uffff\2\u00ff\1\153\1\u00ff\2\uffff\1\164\1\uffff\1\u00ff\1\164"+
        "\1\uffff\1\u00ff\1\uffff\1\u00ff\2\uffff";
    static final String DFA19_acceptS =
        "\6\uffff\1\7\1\uffff\1\11\15\uffff\1\46\2\uffff\1\52\10\uffff\1"+
        "\65\1\66\1\67\1\70\3\uffff\1\77\1\102\1\114\1\115\1\116\1\121\2"+
        "\uffff\1\126\12\uffff\1\120\17\uffff\1\23\1\64\2\uffff\1\27\1\76"+
        "\12\uffff\1\123\1\uffff\1\124\2\uffff\1\56\1\57\1\111\1\60\1\113"+
        "\1\61\1\110\1\62\1\112\1\63\1\72\1\71\1\73\1\101\1\100\1\75\1\74"+
        "\1\122\30\uffff\1\21\13\uffff\1\47\2\uffff\1\50\15\uffff\1\34\2"+
        "\uffff\1\26\4\uffff\1\43\1\13\20\uffff\1\45\7\uffff\1\33\7\uffff"+
        "\1\5\3\uffff\1\12\1\uffff\1\14\5\uffff\1\30\1\51\1\117\1\uffff\1"+
        "\24\1\uffff\1\35\5\uffff\1\53\1\uffff\1\125\1\54\1\55\10\uffff\1"+
        "\10\1\uffff\1\36\1\15\1\uffff\1\16\2\uffff\1\22\11\uffff\1\20\3"+
        "\uffff\1\6\2\uffff\1\25\4\uffff\1\44\2\uffff\1\1\1\uffff\1\2\1\uffff"+
        "\1\3\3\uffff\1\17\2\uffff\1\42\1\uffff\1\107\1\37\1\41\1\uffff\1"+
        "\31\4\uffff\1\4\1\32\1\uffff\1\104\2\uffff\1\103\1\uffff\1\40\1"+
        "\uffff\1\106\1\105";
    static final String DFA19_specialS =
        "\u013a\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\55\1\54\2\uffff\1\54\22\uffff\1\55\1\45\1\61\1\uffff\1\26"+
            "\2\uffff\1\56\1\43\1\44\1\53\1\6\1\31\1\21\1\50\1\35\1\57\1"+
            "\32\1\33\1\34\6\60\1\47\1\52\1\17\1\46\1\42\1\10\1\uffff\1\24"+
            "\14\56\1\22\3\56\1\23\10\56\1\36\1\uffff\1\37\1\uffff\1\56\1"+
            "\uffff\1\3\1\30\1\14\1\5\1\20\1\1\1\56\1\13\1\27\1\56\1\12\2"+
            "\56\1\25\1\4\2\56\1\2\1\7\1\15\1\56\1\11\1\16\3\56\1\40\1\51"+
            "\1\41\102\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\65\15\uffff\1\62\2\uffff\1\63\2\uffff\1\64",
            "\1\66\11\uffff\1\67",
            "\1\70\2\uffff\1\71\4\uffff\1\72",
            "\1\74\74\uffff\1\73",
            "\1\75\3\uffff\1\76",
            "",
            "\1\100\5\uffff\1\77",
            "",
            "\1\102\15\uffff\1\101",
            "\1\103",
            "\1\104",
            "\1\106\6\uffff\1\105",
            "\1\110\6\uffff\1\111\6\uffff\1\107\2\uffff\1\112",
            "\1\113",
            "\1\114",
            "\1\116\13\uffff\1\117",
            "\1\120\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125\3\uffff\1\126",
            "",
            "\1\127\7\uffff\1\130\5\uffff\1\131",
            "\1\132",
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
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167\3\uffff\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083\5\uffff\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0089\1\u0087\6\uffff\1\u0088",
            "\1\u008a",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "",
            "",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0098",
            "\1\u0099",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\136\1\uffff\1\u009b\11\u009c",
            "",
            "\1\136\1\uffff\12\u009c",
            "",
            "\1\136\1\uffff\1\u009d\11\u009c",
            "\1\136\1\uffff\1\u009e\11\u009c",
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
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00a9",
            "\1\u00aa",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00b2",
            "\1\u00b3\2\uffff\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "",
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
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "",
            "\1\136\1\uffff\1\u00c5\11\u00c6",
            "\1\136\1\uffff\12\u00c6",
            "\1\136\1\uffff\1\u00c7\11\u00c6",
            "\1\136\1\uffff\1\u00c8\11\u00c6",
            "\1\u00c9",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00d3",
            "",
            "\1\u00d4",
            "\1\u00d5",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00d7",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00e1",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00e3",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ec\1\136\1\uffff\12\u00eb",
            "\1\u00ec\1\136\1\uffff\12\u00eb",
            "\1\u00ec\1\136\1\uffff\12\u00eb",
            "\1\u00ec\1\136\1\uffff\12\u00eb",
            "\1\u00ef",
            "",
            "\1\u00f0",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "",
            "\1\u00f6",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00f8",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00fb",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u00fd",
            "\1\u00fe",
            "",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0100",
            "",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "",
            "\1\136\1\uffff\12\u00eb",
            "",
            "",
            "",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u010e",
            "",
            "",
            "\1\u010f",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0111",
            "",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0116",
            "\1\u0117",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0119",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u011b",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u011d",
            "",
            "\1\u011e",
            "\1\u011f",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0121",
            "\1\u0122",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0124",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\1\u0128",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u012a",
            "",
            "\1\u012b",
            "\1\u012c",
            "",
            "\1\u012d",
            "",
            "",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\12\56\7\uffff\1\u0130\31\56\4\uffff\1\56\1\uffff\32\56\105"+
            "\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0132",
            "\12\56\7\uffff\1\u0133\31\56\4\uffff\1\56\1\uffff\32\56\105"+
            "\uffff\27\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "",
            "\1\u0135",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "\1\u0137",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
            "",
            "\12\56\7\uffff\32\56\4\uffff\1\56\1\uffff\32\56\105\uffff\27"+
            "\56\1\uffff\37\56\1\uffff\10\56",
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
            return "1:1: Tokens : ( T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | DDOT | ARROW | PIPE | COLON | DCOLON | SEMICOLON | INCLUDING | EXCLUDING | INCLUDINGAT | EXCLUDINGAT | ITERATE | LCURL_LBRACK | LBRACK_LCURL | RCURL_RBRACK | RBRACK_RCURL | STAR | NL | WS | BOOL | OBJECT | NAME | BINARY | INT | RANGE_OR_INT | DATE | STRING );";
        }
    }
 

}