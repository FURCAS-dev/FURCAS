// $ANTLR 3.1.1 ./scenariotestTemp/generated2/LOTOS.g 2010-11-04 23:28:40

package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
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

public class LOTOSLexer extends Lexer {
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int LT=28;
    public static final int T__64=64;
    public static final int STAR=38;
    public static final int LSQUARE=8;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int POINT=36;
    public static final int ESC=47;
    public static final int LARROW=41;
    public static final int FLOAT=7;
    public static final int EXCL=23;
    public static final int LSQUARERSQUARE=17;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int LPAREN=12;
    public static final int PIPELSQUARE=19;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int RPAREN=13;
    public static final int T__58=58;
    public static final int NAME=4;
    public static final int SLASH=39;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int COLONEQ=14;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int PIPE=33;
    public static final int PLUS=24;
    public static final int DIGIT=44;
    public static final int NL=42;
    public static final int PIPE3=18;
    public static final int EQ=20;
    public static final int COMMENT=30;
    public static final int T__50=50;
    public static final int RSQUAREPIPE=21;
    public static final int NE=40;
    public static final int GE=25;
    public static final int IMPLIES=29;
    public static final int SHARP=34;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=16;
    public static final int LCURLY=31;
    public static final int INT=6;
    public static final int RSQUARE=10;
    public static final int MINUS=37;
    public static final int COMA=9;
    public static final int SEMI=15;
    public static final int ALPHA=45;
    public static final int COLON=11;
    public static final int COLONCOLON=35;
    public static final int T__71=71;
    public static final int WS=43;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int SNAME=46;
    public static final int RCURLY=32;
    public static final int GT=26;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int QMARK=22;
    public static final int LE=27;
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

    public LOTOSLexer() {;} 
    public LOTOSLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public LOTOSLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/LOTOS.g"; }

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:117:7: ( 'is' )
            // ./scenariotestTemp/generated2/LOTOS.g:117:9: 'is'
            {
            match("is"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:118:7: ( 'false' )
            // ./scenariotestTemp/generated2/LOTOS.g:118:9: 'false'
            {
            match("false"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:119:7: ( 'true' )
            // ./scenariotestTemp/generated2/LOTOS.g:119:9: 'true'
            {
            match("true"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:120:7: ( 'choice' )
            // ./scenariotestTemp/generated2/LOTOS.g:120:9: 'choice'
            {
            match("choice"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:121:7: ( 'sorts' )
            // ./scenariotestTemp/generated2/LOTOS.g:121:9: 'sorts'
            {
            match("sorts"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:122:7: ( 'library' )
            // ./scenariotestTemp/generated2/LOTOS.g:122:9: 'library'
            {
            match("library"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:123:7: ( 'endtype' )
            // ./scenariotestTemp/generated2/LOTOS.g:123:9: 'endtype'
            {
            match("endtype"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:124:7: ( 'process' )
            // ./scenariotestTemp/generated2/LOTOS.g:124:9: 'process'
            {
            match("process"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:125:7: ( 'hide' )
            // ./scenariotestTemp/generated2/LOTOS.g:125:9: 'hide'
            {
            match("hide"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:126:7: ( 'where' )
            // ./scenariotestTemp/generated2/LOTOS.g:126:9: 'where'
            {
            match("where"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:127:7: ( 'of' )
            // ./scenariotestTemp/generated2/LOTOS.g:127:9: 'of'
            {
            match("of"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:128:7: ( 'endproc' )
            // ./scenariotestTemp/generated2/LOTOS.g:128:9: 'endproc'
            {
            match("endproc"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:129:7: ( 'in' )
            // ./scenariotestTemp/generated2/LOTOS.g:129:9: 'in'
            {
            match("in"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:130:7: ( 'ofsort' )
            // ./scenariotestTemp/generated2/LOTOS.g:130:9: 'ofsort'
            {
            match("ofsort"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:131:7: ( 'forall' )
            // ./scenariotestTemp/generated2/LOTOS.g:131:9: 'forall'
            {
            match("forall"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:132:7: ( 'or' )
            // ./scenariotestTemp/generated2/LOTOS.g:132:9: 'or'
            {
            match("or"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:133:7: ( 'let' )
            // ./scenariotestTemp/generated2/LOTOS.g:133:9: 'let'
            {
            match("let"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:134:7: ( 'and' )
            // ./scenariotestTemp/generated2/LOTOS.g:134:9: 'and'
            {
            match("and"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:135:7: ( 'endlib' )
            // ./scenariotestTemp/generated2/LOTOS.g:135:9: 'endlib'
            {
            match("endlib"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:136:7: ( 'opns' )
            // ./scenariotestTemp/generated2/LOTOS.g:136:9: 'opns'
            {
            match("opns"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:137:7: ( 'neq' )
            // ./scenariotestTemp/generated2/LOTOS.g:137:9: 'neq'
            {
            match("neq"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:138:7: ( 'exit' )
            // ./scenariotestTemp/generated2/LOTOS.g:138:9: 'exit'
            {
            match("exit"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:139:7: ( 'endspec' )
            // ./scenariotestTemp/generated2/LOTOS.g:139:9: 'endspec'
            {
            match("endspec"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:140:7: ( 'eqns' )
            // ./scenariotestTemp/generated2/LOTOS.g:140:9: 'eqns'
            {
            match("eqns"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:141:7: ( 'behaviour' )
            // ./scenariotestTemp/generated2/LOTOS.g:141:9: 'behaviour'
            {
            match("behaviour"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:142:7: ( 'specification' )
            // ./scenariotestTemp/generated2/LOTOS.g:142:9: 'specification'
            {
            match("specification"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:143:7: ( 'type' )
            // ./scenariotestTemp/generated2/LOTOS.g:143:9: 'type'
            {
            match("type"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:144:7: ( 'eq' )
            // ./scenariotestTemp/generated2/LOTOS.g:144:9: 'eq'
            {
            match("eq"); 


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
            // ./scenariotestTemp/generated2/LOTOS.g:145:7: ( 'noexit' )
            // ./scenariotestTemp/generated2/LOTOS.g:145:9: 'noexit'
            {
            match("noexit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1006:3: ( ( ( ( '(*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*)' ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:1007:6: ( ( ( '(*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*)' ) ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:1007:6: ( ( ( '(*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*)' ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:1007:7: ( ( '(*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*)' ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:1007:7: ( ( '(*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*)' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:1007:8: ( '(*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*)' )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:1007:8: ( '(*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*)' )
            // ./scenariotestTemp/generated2/LOTOS.g:1007:9: '(*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*)'
            {
            match("(*"); 

            // ./scenariotestTemp/generated2/LOTOS.g:1007:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==')') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='(')||(LA1_1>='*' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:1007:43: ( '\\n' | ~ '\\n' )
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
            	    break loop1;
                }
            } while (true);

            match("*)"); 


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

    // $ANTLR start "LSQUARERSQUARE"
    public final void mLSQUARERSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARERSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1012:3: ( '[]' )
            // ./scenariotestTemp/generated2/LOTOS.g:1013:3: '[]'
            {
            match("[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSQUARERSQUARE"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1018:3: ( '[' )
            // ./scenariotestTemp/generated2/LOTOS.g:1019:3: '['
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
            // ./scenariotestTemp/generated2/LOTOS.g:1024:3: ( ']' )
            // ./scenariotestTemp/generated2/LOTOS.g:1025:3: ']'
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

    // $ANTLR start "EXCL"
    public final void mEXCL() throws RecognitionException {
        try {
            int _type = EXCL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1030:3: ( '!' )
            // ./scenariotestTemp/generated2/LOTOS.g:1031:3: '!'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1036:3: ( ',' )
            // ./scenariotestTemp/generated2/LOTOS.g:1037:3: ','
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
            // ./scenariotestTemp/generated2/LOTOS.g:1042:3: ( '(' )
            // ./scenariotestTemp/generated2/LOTOS.g:1043:3: '('
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
            // ./scenariotestTemp/generated2/LOTOS.g:1048:3: ( ')' )
            // ./scenariotestTemp/generated2/LOTOS.g:1049:3: ')'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1054:3: ( '{' )
            // ./scenariotestTemp/generated2/LOTOS.g:1055:3: '{'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1060:3: ( '}' )
            // ./scenariotestTemp/generated2/LOTOS.g:1061:3: '}'
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

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1066:3: ( ';' )
            // ./scenariotestTemp/generated2/LOTOS.g:1067:3: ';'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1072:3: ( ':' )
            // ./scenariotestTemp/generated2/LOTOS.g:1073:3: ':'
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

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1078:3: ( '|' )
            // ./scenariotestTemp/generated2/LOTOS.g:1079:3: '|'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1084:3: ( '#' )
            // ./scenariotestTemp/generated2/LOTOS.g:1085:3: '#'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1090:3: ( '?' )
            // ./scenariotestTemp/generated2/LOTOS.g:1091:3: '?'
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

    // $ANTLR start "COLONCOLON"
    public final void mCOLONCOLON() throws RecognitionException {
        try {
            int _type = COLONCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1096:3: ( '::' )
            // ./scenariotestTemp/generated2/LOTOS.g:1097:3: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLONCOLON"

    // $ANTLR start "PIPE3"
    public final void mPIPE3() throws RecognitionException {
        try {
            int _type = PIPE3;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1102:3: ( '|||' )
            // ./scenariotestTemp/generated2/LOTOS.g:1103:3: '|||'
            {
            match("|||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPE3"

    // $ANTLR start "PIPELSQUARE"
    public final void mPIPELSQUARE() throws RecognitionException {
        try {
            int _type = PIPELSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1108:3: ( '|[' )
            // ./scenariotestTemp/generated2/LOTOS.g:1109:3: '|['
            {
            match("|["); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPELSQUARE"

    // $ANTLR start "RSQUAREPIPE"
    public final void mRSQUAREPIPE() throws RecognitionException {
        try {
            int _type = RSQUAREPIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1114:3: ( ']|' )
            // ./scenariotestTemp/generated2/LOTOS.g:1115:3: ']|'
            {
            match("]|"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSQUAREPIPE"

    // $ANTLR start "COLONEQ"
    public final void mCOLONEQ() throws RecognitionException {
        try {
            int _type = COLONEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1120:3: ( ':=' )
            // ./scenariotestTemp/generated2/LOTOS.g:1121:3: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLONEQ"

    // $ANTLR start "IMPLIES"
    public final void mIMPLIES() throws RecognitionException {
        try {
            int _type = IMPLIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1126:3: ( '=>' )
            // ./scenariotestTemp/generated2/LOTOS.g:1127:3: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPLIES"

    // $ANTLR start "POINT"
    public final void mPOINT() throws RecognitionException {
        try {
            int _type = POINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ./scenariotestTemp/generated2/LOTOS.g:1132:3: ( '.' )
            // ./scenariotestTemp/generated2/LOTOS.g:1133:3: '.'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1138:3: ( '->' )
            // ./scenariotestTemp/generated2/LOTOS.g:1139:3: '->'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1144:3: ( '-' )
            // ./scenariotestTemp/generated2/LOTOS.g:1145:3: '-'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1150:3: ( '*' )
            // ./scenariotestTemp/generated2/LOTOS.g:1151:3: '*'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1156:3: ( '/' )
            // ./scenariotestTemp/generated2/LOTOS.g:1157:3: '/'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1162:3: ( '+' )
            // ./scenariotestTemp/generated2/LOTOS.g:1163:3: '+'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1168:3: ( '=' )
            // ./scenariotestTemp/generated2/LOTOS.g:1169:3: '='
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
            // ./scenariotestTemp/generated2/LOTOS.g:1174:3: ( '>' )
            // ./scenariotestTemp/generated2/LOTOS.g:1175:3: '>'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1180:3: ( '<' )
            // ./scenariotestTemp/generated2/LOTOS.g:1181:3: '<'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1186:3: ( '>=' )
            // ./scenariotestTemp/generated2/LOTOS.g:1187:3: '>='
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
            // ./scenariotestTemp/generated2/LOTOS.g:1192:3: ( '<=' )
            // ./scenariotestTemp/generated2/LOTOS.g:1193:3: '<='
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
            // ./scenariotestTemp/generated2/LOTOS.g:1198:3: ( '<>' )
            // ./scenariotestTemp/generated2/LOTOS.g:1199:3: '<>'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1204:3: ( '<-' )
            // ./scenariotestTemp/generated2/LOTOS.g:1205:3: '<-'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1213:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:1213:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:1213:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // ./scenariotestTemp/generated2/LOTOS.g:1213:6: '\\r' '\\n'
                    {
                    match('\r'); 
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1214:5: '\\n' '\\r'
                    {
                    match('\n'); 
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1215:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1216:5: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

            newline();

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
            // ./scenariotestTemp/generated2/LOTOS.g:1222:2: ( ( ' ' | '\\t' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:1222:4: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


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
            // ./scenariotestTemp/generated2/LOTOS.g:1229:2: ( '0' .. '9' )
            // ./scenariotestTemp/generated2/LOTOS.g:1229:4: '0' .. '9'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1234:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // ./scenariotestTemp/generated2/LOTOS.g:
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
            // ./scenariotestTemp/generated2/LOTOS.g:1248:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // ./scenariotestTemp/generated2/LOTOS.g:1248:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // ./scenariotestTemp/generated2/LOTOS.g:1248:4: ( ALPHA )
            // ./scenariotestTemp/generated2/LOTOS.g:1248:5: ALPHA
            {
            mALPHA(); 

            }

            // ./scenariotestTemp/generated2/LOTOS.g:1248:12: ( ALPHA | DIGIT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\u00D6')||(LA3_0>='\u00D8' && LA3_0<='\u00F6')||(LA3_0>='\u00F8' && LA3_0<='\u00FF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:
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
            // ./scenariotestTemp/generated2/LOTOS.g:1252:2: ( ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:1252:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:1252:4: ( SNAME | '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')||(LA5_0>='\u00C0' && LA5_0<='\u00D6')||(LA5_0>='\u00D8' && LA5_0<='\u00F6')||(LA5_0>='\u00F8' && LA5_0<='\u00FF')) ) {
                alt5=1;
            }
            else if ( (LA5_0=='\"') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1253:4: SNAME
                    {
                    mSNAME(); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1255:5: '\"' ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )* '\"'
                    {
                    match('\"'); 
                    // ./scenariotestTemp/generated2/LOTOS.g:1256:4: ( ESC | '\\n' | ~ ( '\\\\' | '\\\"' | '\\n' ) )*
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
                        else if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=3;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:1256:6: ESC
                    	    {
                    	    mESC(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:1257:6: '\\n'
                    	    {
                    	    match('\n'); 
                    	    newline();

                    	    }
                    	    break;
                    	case 3 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:1258:6: ~ ( '\\\\' | '\\\"' | '\\n' )
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
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 
                    setText(unescapeString(getText(), 1));

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
            // ./scenariotestTemp/generated2/LOTOS.g:1266:2: ( ( DIGIT )+ )
            // ./scenariotestTemp/generated2/LOTOS.g:1266:4: ( DIGIT )+
            {
            // ./scenariotestTemp/generated2/LOTOS.g:1266:4: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/LOTOS.g:1266:5: DIGIT
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
            // ./scenariotestTemp/generated2/LOTOS.g:1270:7: ( ( DIGIT )+ '.' ( DIGIT )* )
            // ./scenariotestTemp/generated2/LOTOS.g:1270:9: ( DIGIT )+ '.' ( DIGIT )*
            {
            // ./scenariotestTemp/generated2/LOTOS.g:1270:9: ( DIGIT )+
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
            	    // ./scenariotestTemp/generated2/LOTOS.g:1270:9: DIGIT
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
            // ./scenariotestTemp/generated2/LOTOS.g:1270:20: ( DIGIT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:1270:20: DIGIT
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
            // ./scenariotestTemp/generated2/LOTOS.g:1274:2: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:1274:4: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
            {
            match('\\'); 
            // ./scenariotestTemp/generated2/LOTOS.g:1275:3: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '\\\\' | ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? ) )
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
                    // ./scenariotestTemp/generated2/LOTOS.g:1275:5: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1276:5: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1277:5: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1278:5: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1279:5: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1280:5: '\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1281:5: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1282:5: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/LOTOS.g:1283:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:1283:5: ( ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )? | ( '4' .. '7' ) ( ( '0' .. '7' ) )? )
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
                            // ./scenariotestTemp/generated2/LOTOS.g:1284:5: ( '0' .. '3' ) ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            {
                            // ./scenariotestTemp/generated2/LOTOS.g:1284:5: ( '0' .. '3' )
                            // ./scenariotestTemp/generated2/LOTOS.g:1284:6: '0' .. '3'
                            {
                            matchRange('0','3'); 

                            }

                            // ./scenariotestTemp/generated2/LOTOS.g:1285:5: ( ( '0' .. '7' ) ( '0' .. '7' )? )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>='0' && LA10_0<='7')) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/LOTOS.g:1289:7: ( '0' .. '7' ) ( '0' .. '7' )?
                                    {
                                    // ./scenariotestTemp/generated2/LOTOS.g:1289:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/LOTOS.g:1289:8: '0' .. '7'
                                    {
                                    matchRange('0','7'); 

                                    }

                                    // ./scenariotestTemp/generated2/LOTOS.g:1290:6: ( '0' .. '7' )?
                                    int alt9=2;
                                    int LA9_0 = input.LA(1);

                                    if ( ((LA9_0>='0' && LA9_0<='7')) ) {
                                        alt9=1;
                                    }
                                    switch (alt9) {
                                        case 1 :
                                            // ./scenariotestTemp/generated2/LOTOS.g:1294:8: '0' .. '7'
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
                            // ./scenariotestTemp/generated2/LOTOS.g:1297:6: ( '4' .. '7' ) ( ( '0' .. '7' ) )?
                            {
                            // ./scenariotestTemp/generated2/LOTOS.g:1297:6: ( '4' .. '7' )
                            // ./scenariotestTemp/generated2/LOTOS.g:1297:7: '4' .. '7'
                            {
                            matchRange('4','7'); 

                            }

                            // ./scenariotestTemp/generated2/LOTOS.g:1298:5: ( ( '0' .. '7' ) )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>='0' && LA11_0<='7')) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/LOTOS.g:1302:7: ( '0' .. '7' )
                                    {
                                    // ./scenariotestTemp/generated2/LOTOS.g:1302:7: ( '0' .. '7' )
                                    // ./scenariotestTemp/generated2/LOTOS.g:1302:8: '0' .. '7'
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
            // ./scenariotestTemp/generated2/LOTOS.g:1319:2: ( '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            // ./scenariotestTemp/generated2/LOTOS.g:1319:4: '\\'' ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
            {
            match('\''); 
            // ./scenariotestTemp/generated2/LOTOS.g:1320:3: ( ESC | '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
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
                else if ( ((LA14_0>='\u0000' && LA14_0<='\t')||(LA14_0>='\u000B' && LA14_0<='&')||(LA14_0>='(' && LA14_0<='[')||(LA14_0>=']' && LA14_0<='\uFFFF')) ) {
                    alt14=3;
                }


                switch (alt14) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:1320:5: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:1321:5: '\\n'
            	    {
            	    match('\n'); 
            	    newline();

            	    }
            	    break;
            	case 3 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:1322:5: ~ ( '\\\\' | '\\'' | '\\n' )
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
            	    break loop14;
                }
            } while (true);

            match('\''); 
            setText(unescapeString(getText(), 1));

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // ./scenariotestTemp/generated2/LOTOS.g:1:8: ( T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | COMMENT | LSQUARERSQUARE | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | COLONCOLON | PIPE3 | PIPELSQUARE | RSQUAREPIPE | COLONEQ | IMPLIES | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING )
        int alt15=69;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:10: T__48
                {
                mT__48(); 

                }
                break;
            case 2 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:16: T__49
                {
                mT__49(); 

                }
                break;
            case 3 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:22: T__50
                {
                mT__50(); 

                }
                break;
            case 4 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:28: T__51
                {
                mT__51(); 

                }
                break;
            case 5 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:34: T__52
                {
                mT__52(); 

                }
                break;
            case 6 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:40: T__53
                {
                mT__53(); 

                }
                break;
            case 7 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:46: T__54
                {
                mT__54(); 

                }
                break;
            case 8 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:52: T__55
                {
                mT__55(); 

                }
                break;
            case 9 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:58: T__56
                {
                mT__56(); 

                }
                break;
            case 10 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:64: T__57
                {
                mT__57(); 

                }
                break;
            case 11 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:70: T__58
                {
                mT__58(); 

                }
                break;
            case 12 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:76: T__59
                {
                mT__59(); 

                }
                break;
            case 13 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:82: T__60
                {
                mT__60(); 

                }
                break;
            case 14 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:88: T__61
                {
                mT__61(); 

                }
                break;
            case 15 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:94: T__62
                {
                mT__62(); 

                }
                break;
            case 16 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:100: T__63
                {
                mT__63(); 

                }
                break;
            case 17 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:106: T__64
                {
                mT__64(); 

                }
                break;
            case 18 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:112: T__65
                {
                mT__65(); 

                }
                break;
            case 19 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:118: T__66
                {
                mT__66(); 

                }
                break;
            case 20 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:124: T__67
                {
                mT__67(); 

                }
                break;
            case 21 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:130: T__68
                {
                mT__68(); 

                }
                break;
            case 22 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:136: T__69
                {
                mT__69(); 

                }
                break;
            case 23 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:142: T__70
                {
                mT__70(); 

                }
                break;
            case 24 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:148: T__71
                {
                mT__71(); 

                }
                break;
            case 25 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:154: T__72
                {
                mT__72(); 

                }
                break;
            case 26 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:160: T__73
                {
                mT__73(); 

                }
                break;
            case 27 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:166: T__74
                {
                mT__74(); 

                }
                break;
            case 28 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:172: T__75
                {
                mT__75(); 

                }
                break;
            case 29 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:178: T__76
                {
                mT__76(); 

                }
                break;
            case 30 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:184: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 31 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:192: LSQUARERSQUARE
                {
                mLSQUARERSQUARE(); 

                }
                break;
            case 32 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:207: LSQUARE
                {
                mLSQUARE(); 

                }
                break;
            case 33 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:215: RSQUARE
                {
                mRSQUARE(); 

                }
                break;
            case 34 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:223: EXCL
                {
                mEXCL(); 

                }
                break;
            case 35 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:228: COMA
                {
                mCOMA(); 

                }
                break;
            case 36 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:233: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 37 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:240: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 38 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:247: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 39 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:254: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 40 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:261: SEMI
                {
                mSEMI(); 

                }
                break;
            case 41 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:266: COLON
                {
                mCOLON(); 

                }
                break;
            case 42 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:272: PIPE
                {
                mPIPE(); 

                }
                break;
            case 43 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:277: SHARP
                {
                mSHARP(); 

                }
                break;
            case 44 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:283: QMARK
                {
                mQMARK(); 

                }
                break;
            case 45 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:289: COLONCOLON
                {
                mCOLONCOLON(); 

                }
                break;
            case 46 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:300: PIPE3
                {
                mPIPE3(); 

                }
                break;
            case 47 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:306: PIPELSQUARE
                {
                mPIPELSQUARE(); 

                }
                break;
            case 48 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:318: RSQUAREPIPE
                {
                mRSQUAREPIPE(); 

                }
                break;
            case 49 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:330: COLONEQ
                {
                mCOLONEQ(); 

                }
                break;
            case 50 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:338: IMPLIES
                {
                mIMPLIES(); 

                }
                break;
            case 51 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:346: POINT
                {
                mPOINT(); 

                }
                break;
            case 52 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:352: RARROW
                {
                mRARROW(); 

                }
                break;
            case 53 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:359: MINUS
                {
                mMINUS(); 

                }
                break;
            case 54 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:365: STAR
                {
                mSTAR(); 

                }
                break;
            case 55 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:370: SLASH
                {
                mSLASH(); 

                }
                break;
            case 56 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:376: PLUS
                {
                mPLUS(); 

                }
                break;
            case 57 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:381: EQ
                {
                mEQ(); 

                }
                break;
            case 58 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:384: GT
                {
                mGT(); 

                }
                break;
            case 59 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:387: LT
                {
                mLT(); 

                }
                break;
            case 60 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:390: GE
                {
                mGE(); 

                }
                break;
            case 61 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:393: LE
                {
                mLE(); 

                }
                break;
            case 62 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:396: NE
                {
                mNE(); 

                }
                break;
            case 63 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:399: LARROW
                {
                mLARROW(); 

                }
                break;
            case 64 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:406: NL
                {
                mNL(); 

                }
                break;
            case 65 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:409: WS
                {
                mWS(); 

                }
                break;
            case 66 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:412: NAME
                {
                mNAME(); 

                }
                break;
            case 67 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:417: INT
                {
                mINT(); 

                }
                break;
            case 68 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:421: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 69 :
                // ./scenariotestTemp/generated2/LOTOS.g:1:427: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\16\46\1\102\1\104\1\106\6\uffff\1\111\1\114\2\uffff\1\116"+
        "\1\uffff\1\120\3\uffff\1\122\1\126\3\uffff\1\127\1\uffff\1\131\1"+
        "\132\13\46\1\147\3\46\1\154\1\155\5\46\32\uffff\10\46\1\173\3\46"+
        "\1\uffff\4\46\2\uffff\1\46\1\u0087\1\u0088\4\46\1\u008d\1\u008e"+
        "\4\46\1\uffff\4\46\1\u0097\1\u0098\1\46\1\u009a\2\46\1\u009d\2\uffff"+
        "\2\46\1\u00a0\1\46\2\uffff\1\46\1\u00a3\6\46\2\uffff\1\46\1\uffff"+
        "\1\u00ab\1\46\1\uffff\2\46\1\uffff\1\u00af\1\u00b0\1\uffff\4\46"+
        "\1\u00b5\2\46\1\uffff\1\u00b8\1\u00b9\1\46\2\uffff\1\46\1\u00bc"+
        "\1\u00bd\1\u00be\1\uffff\1\u00bf\1\u00c0\2\uffff\2\46\5\uffff\2"+
        "\46\1\u00c5\1\46\1\uffff\2\46\1\u00c9\1\uffff";
    static final String DFA15_eofS =
        "\u00ca\uffff";
    static final String DFA15_minS =
        "\1\11\1\156\1\141\1\162\1\150\1\157\1\145\1\156\1\162\1\151\1\150"+
        "\1\146\1\156\2\145\1\52\1\135\1\174\6\uffff\1\72\1\133\2\uffff\1"+
        "\76\1\uffff\1\76\3\uffff\1\75\1\55\3\uffff\1\56\1\uffff\2\60\1\154"+
        "\1\162\1\165\1\160\1\157\1\162\1\145\1\142\1\164\1\144\1\151\1\60"+
        "\1\157\1\144\1\145\2\60\1\156\1\144\1\161\1\145\1\150\32\uffff\1"+
        "\163\1\141\2\145\1\151\1\164\1\143\1\162\1\60\1\154\1\164\1\163"+
        "\1\uffff\1\143\1\145\1\162\1\157\2\uffff\1\163\2\60\1\170\1\141"+
        "\1\145\1\154\2\60\1\143\1\163\1\151\1\141\1\uffff\1\171\1\162\1"+
        "\151\1\160\2\60\1\145\1\60\1\145\1\162\1\60\2\uffff\1\151\1\166"+
        "\1\60\1\154\2\uffff\1\145\1\60\1\146\1\162\1\160\1\157\1\142\1\145"+
        "\2\uffff\1\163\1\uffff\1\60\1\164\1\uffff\1\164\1\151\1\uffff\2"+
        "\60\1\uffff\1\151\1\171\1\145\1\143\1\60\1\143\1\163\1\uffff\2\60"+
        "\1\157\2\uffff\1\143\3\60\1\uffff\2\60\2\uffff\1\165\1\141\5\uffff"+
        "\1\162\1\164\1\60\1\151\1\uffff\1\157\1\156\1\60\1\uffff";
    static final String DFA15_maxS =
        "\1\u00ff\1\163\1\157\1\171\1\150\1\160\1\151\1\170\1\162\1\151\1"+
        "\150\1\162\1\156\1\157\1\145\1\52\1\135\1\174\6\uffff\1\75\1\174"+
        "\2\uffff\1\76\1\uffff\1\76\3\uffff\1\75\1\76\3\uffff\1\71\1\uffff"+
        "\2\u00ff\1\154\1\162\1\165\1\160\1\157\1\162\1\145\1\142\1\164\1"+
        "\144\1\151\1\u00ff\1\157\1\144\1\145\2\u00ff\1\156\1\144\1\161\1"+
        "\145\1\150\32\uffff\1\163\1\141\2\145\1\151\1\164\1\143\1\162\1"+
        "\u00ff\2\164\1\163\1\uffff\1\143\1\145\1\162\1\157\2\uffff\1\163"+
        "\2\u00ff\1\170\1\141\1\145\1\154\2\u00ff\1\143\1\163\1\151\1\141"+
        "\1\uffff\1\171\1\162\1\151\1\160\2\u00ff\1\145\1\u00ff\1\145\1\162"+
        "\1\u00ff\2\uffff\1\151\1\166\1\u00ff\1\154\2\uffff\1\145\1\u00ff"+
        "\1\146\1\162\1\160\1\157\1\142\1\145\2\uffff\1\163\1\uffff\1\u00ff"+
        "\1\164\1\uffff\1\164\1\151\1\uffff\2\u00ff\1\uffff\1\151\1\171\1"+
        "\145\1\143\1\u00ff\1\143\1\163\1\uffff\2\u00ff\1\157\2\uffff\1\143"+
        "\3\u00ff\1\uffff\2\u00ff\2\uffff\1\165\1\141\5\uffff\1\162\1\164"+
        "\1\u00ff\1\151\1\uffff\1\157\1\156\1\u00ff\1\uffff";
    static final String DFA15_acceptS =
        "\22\uffff\1\42\1\43\1\45\1\46\1\47\1\50\2\uffff\1\53\1\54\1\uffff"+
        "\1\63\1\uffff\1\66\1\67\1\70\2\uffff\1\100\1\101\1\102\1\uffff\1"+
        "\105\30\uffff\1\36\1\44\1\37\1\40\1\60\1\41\1\55\1\61\1\51\1\56"+
        "\1\57\1\52\1\62\1\71\1\64\1\65\1\74\1\72\1\75\1\76\1\77\1\73\1\103"+
        "\1\104\1\1\1\15\14\uffff\1\34\4\uffff\1\13\1\20\15\uffff\1\21\13"+
        "\uffff\1\22\1\25\4\uffff\1\3\1\33\10\uffff\1\26\1\30\1\uffff\1\11"+
        "\2\uffff\1\24\2\uffff\1\2\2\uffff\1\5\7\uffff\1\12\3\uffff\1\17"+
        "\1\4\4\uffff\1\23\2\uffff\1\16\1\35\2\uffff\1\6\1\7\1\14\1\27\1"+
        "\10\4\uffff\1\31\3\uffff\1\32";
    static final String DFA15_specialS =
        "\u00ca\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\45\1\44\2\uffff\1\44\22\uffff\1\45\1\22\1\46\1\32\3\uffff"+
            "\1\50\1\17\1\24\1\37\1\41\1\23\1\36\1\35\1\40\12\47\1\30\1\27"+
            "\1\43\1\34\1\42\1\33\1\uffff\32\46\1\20\1\uffff\1\21\1\uffff"+
            "\1\46\1\uffff\1\14\1\16\1\4\1\46\1\7\1\2\1\46\1\11\1\1\2\46"+
            "\1\6\1\46\1\15\1\13\1\10\2\46\1\5\1\3\2\46\1\12\3\46\1\25\1"+
            "\31\1\26\102\uffff\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\52\4\uffff\1\51",
            "\1\53\15\uffff\1\54",
            "\1\55\6\uffff\1\56",
            "\1\57",
            "\1\60\1\61",
            "\1\63\3\uffff\1\62",
            "\1\64\2\uffff\1\66\6\uffff\1\65",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72\11\uffff\1\74\1\uffff\1\73",
            "\1\75",
            "\1\76\11\uffff\1\77",
            "\1\100",
            "\1\101",
            "\1\103",
            "\1\105",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\107\2\uffff\1\110",
            "\1\113\40\uffff\1\112",
            "",
            "",
            "\1\115",
            "",
            "\1\117",
            "",
            "",
            "",
            "\1\121",
            "\1\125\17\uffff\1\123\1\124",
            "",
            "",
            "",
            "\1\130\1\uffff\12\47",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\15\46\1\146\14\46"+
            "\105\uffff\27\46\1\uffff\37\46\1\uffff\10\46",
            "\1\150",
            "\1\151",
            "\1\152",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\22\46\1\153\7\46"+
            "\105\uffff\27\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
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
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\176\3\uffff\1\175\2\uffff\1\177\1\174",
            "\1\u0080",
            "\1\u0081",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "",
            "\1\u0086",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u0099",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u009b",
            "\1\u009c",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "",
            "",
            "\1\u009e",
            "\1\u009f",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u00a1",
            "",
            "",
            "\1\u00a2",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "",
            "\1\u00aa",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u00ac",
            "",
            "\1\u00ad",
            "\1\u00ae",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u00b6",
            "\1\u00b7",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u00ba",
            "",
            "",
            "\1\u00bb",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "",
            "",
            "",
            "",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
            "\1\u00c6",
            "",
            "\1\u00c7",
            "\1\u00c8",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46\105\uffff\27"+
            "\46\1\uffff\37\46\1\uffff\10\46",
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
            return "1:1: Tokens : ( T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | COMMENT | LSQUARERSQUARE | LSQUARE | RSQUARE | EXCL | COMA | LPAREN | RPAREN | LCURLY | RCURLY | SEMI | COLON | PIPE | SHARP | QMARK | COLONCOLON | PIPE3 | PIPELSQUARE | RSQUAREPIPE | COLONEQ | IMPLIES | POINT | RARROW | MINUS | STAR | SLASH | PLUS | EQ | GT | LT | GE | LE | NE | LARROW | NL | WS | NAME | INT | FLOAT | STRING );";
        }
    }
 

}