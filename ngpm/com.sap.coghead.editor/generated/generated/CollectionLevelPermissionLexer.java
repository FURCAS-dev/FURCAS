// $ANTLR 3.1.1 Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g 2010-03-19 19:42:11

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
public class CollectionLevelPermissionLexer extends Lexer {
    public static final int LANGLE=20;
    public static final int FLOAT=7;
    public static final int EQUALS=17;
    public static final int EXCL=22;
    public static final int RANGE_OR_INT_OR_FLOAT_OR_DOUBLE=33;
    public static final int EOF=-1;
    public static final int LPAREN=11;
    public static final int LBRACKET=15;
    public static final int RPAREN=12;
    public static final int NAME=4;
    public static final int DCOLON=27;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int DOUBLE=8;
    public static final int NL=28;
    public static final int DIGIT=30;
    public static final int RBRACKET=16;
    public static final int RANGLE=21;
    public static final int DOT=25;
    public static final int COMMENT=18;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int EQUALSEQUALS=23;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int INT=6;
    public static final int SEMICOLON=13;
    public static final int MULTI_LINE_COMMENT=19;
    public static final int ALPHA=31;
    public static final int COLON=10;
    public static final int LCURL=9;
    public static final int WS=29;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int SNAME=32;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RCURL=14;
    public static final int ASSIGN=24;
    public static final int ARROW=26;
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

    public CollectionLevelPermissionLexer() {;} 
    public CollectionLevelPermissionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CollectionLevelPermissionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g"; }

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:117:7: ( 'EQUALS' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:117:9: 'EQUALS'
            {
            match("EQUALS"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:118:7: ( 'GREATER_THAN' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:118:9: 'GREATER_THAN'
            {
            match("GREATER_THAN"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:119:7: ( 'LESS_THAN' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:119:9: 'LESS_THAN'
            {
            match("LESS_THAN"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:120:7: ( 'GREATER_OR_EQUALS' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:120:9: 'GREATER_OR_EQUALS'
            {
            match("GREATER_OR_EQUALS"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:121:7: ( 'LESS_OR_EQUALS' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:121:9: 'LESS_OR_EQUALS'
            {
            match("LESS_OR_EQUALS"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:122:7: ( 'CONTAINS' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:122:9: 'CONTAINS'
            {
            match("CONTAINS"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:123:7: ( 'collection' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:123:9: 'collection'
            {
            match("collection"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:124:7: ( 'permissions' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:124:9: 'permissions'
            {
            match("permissions"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:125:7: ( 'default' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:125:9: 'default'
            {
            match("default"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:126:7: ( 'create' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:126:9: 'create'
            {
            match("create"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:127:7: ( ',' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:127:9: ','
            {
            match(','); if (state.failed) return ;

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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:128:7: ( 'retrieve' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:128:9: 'retrieve'
            {
            match("retrieve"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:129:7: ( 'update' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:129:9: 'update'
            {
            match("update"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:130:7: ( 'delete' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:130:9: 'delete'
            {
            match("delete"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:131:7: ( 'data-driven' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:131:9: 'data-driven'
            {
            match("data-driven"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:132:7: ( 'from' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:132:9: 'from'
            {
            match("from"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:133:7: ( 'as' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:133:9: 'as'
            {
            match("as"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:134:7: ( 'where' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:134:9: 'where'
            {
            match("where"); if (state.failed) return ;


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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:135:7: ( 'and' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:135:9: 'and'
            {
            match("and"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:489:3: ( ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:6: ( ( ( '//' (~ ( '\\r' | '\\n' ) )* ) ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:7: ( ( '//' (~ ( '\\r' | '\\n' ) )* ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:8: ( '//' (~ ( '\\r' | '\\n' ) )* )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:9: '//' (~ ( '\\r' | '\\n' ) )*
            {
            match("//"); if (state.failed) return ;

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:14: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:490:15: ~ ( '\\r' | '\\n' )
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:495:3: ( ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:6: ( ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:7: ( ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:8: ( '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:9: '/*' ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )* '*/'
            {
            match("/*"); if (state.failed) return ;

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:14: ( options {greedy=false; } : ( '\\n' | ~ '\\n' ) )*
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
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:496:43: ( '\\n' | ~ '\\n' )
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:501:3: ( '[' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:502:3: '['
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:507:3: ( ']' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:508:3: ']'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:513:3: ( '{' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:514:3: '{'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:519:3: ( '}' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:520:3: '}'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:525:3: ( '<' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:526:3: '<'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:531:3: ( '>' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:532:3: '>'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:537:3: ( '(' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:538:3: '('
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:543:3: ( ')' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:544:3: ')'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:549:3: ( '!' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:550:3: '!'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:555:3: ( '=' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:556:3: '='
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:561:3: ( '==' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:562:3: '=='
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:567:3: ( ':=' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:568:3: ':='
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:573:3: ( '.' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:574:3: '.'
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

    // $ANTLR start "ARROW"
    public final void mARROW() throws RecognitionException {
        try {
            int _type = ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:579:3: ( '->' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:580:3: '->'
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:585:3: ( ':' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:586:3: ':'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:591:3: ( '::' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:592:3: '::'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:597:3: ( ';' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:598:3: ';'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:607:2: ( ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:607:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:607:4: ( '\\r' '\\n' | '\\n' '\\r' | '\\r' | '\\n' )
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
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:607:6: '\\r' '\\n'
                    {
                    match('\r'); if (state.failed) return ;
                    match('\n'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:608:5: '\\n' '\\r'
                    {
                    match('\n'); if (state.failed) return ;
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:609:5: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:610:5: '\\n'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:616:2: ( ( ' ' | '\\t' ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:616:4: ( ' ' | '\\t' )
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:623:2: ( '0' .. '9' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:623:4: '0' .. '9'
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:628:2: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:639:2: ( ( ALPHA ) ( ALPHA | DIGIT )* )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:639:4: ( ALPHA ) ( ALPHA | DIGIT )*
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:639:4: ( ALPHA )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:639:5: ALPHA
            {
            mALPHA(); if (state.failed) return ;

            }

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:639:12: ( ALPHA | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u00C0' && LA4_0<='\u00D6')||(LA4_0>='\u00D8' && LA4_0<='\u00F6')||(LA4_0>='\u00F8' && LA4_0<='\u00FF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:
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

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:643:2: ( ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' ) )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:643:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:643:4: ( SNAME | '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')||(LA6_0>='\u00C0' && LA6_0<='\u00D6')||(LA6_0>='\u00D8' && LA6_0<='\u00F6')||(LA6_0>='\u00F8' && LA6_0<='\u00FF')) ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
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
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:644:4: SNAME
                    {
                    mSNAME(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:645:5: '\\'' ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )* '\\''
                    {
                    match('\''); if (state.failed) return ;
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:646:4: ( '\\n' | ~ ( '\\\\' | '\\'' | '\\n' ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\n') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='\t')||(LA5_0>='\u000B' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:648:4: '\\n'
                    	    {
                    	    match('\n'); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      newline();
                    	    }

                    	    }
                    	    break;
                    	case 2 :
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:649:6: ~ ( '\\\\' | '\\'' | '\\n' )
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
                    	    break loop5;
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:656:2: ( '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"' )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:656:4: '\"' ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:657:3: ( '\\n' | ~ ( '\\\\' | '\"' | '\\n' ) )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\n') ) {
                    alt7=1;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:659:4: '\\n'
            	    {
            	    match('\n'); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      newline();
            	    }

            	    }
            	    break;
            	case 2 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:660:5: ~ ( '\\\\' | '\"' | '\\n' )
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
            	    break loop7;
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

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:668:2: ( ( DIGIT )+ )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:668:4: ( DIGIT )+
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:668:4: ( DIGIT )+
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
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:668:5: DIGIT
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:674:2: ( '.' ( DIGIT )+ | ( DIGIT )+ '.' ( DIGIT )* )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='.') ) {
                alt12=1;
            }
            else if ( ((LA12_0>='0' && LA12_0<='9')) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:674:4: '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:674:8: ( DIGIT )+
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
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:674:8: DIGIT
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
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:675:4: ( DIGIT )+ '.' ( DIGIT )*
                    {
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:675:4: ( DIGIT )+
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
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:675:4: DIGIT
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
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:675:15: ( DIGIT )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:675:15: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:681:2: ( ( '.' ( DIGIT )+ | ( DIGIT )+ ( '.' ( DIGIT )* )? ) ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:681:4: ( '.' ( DIGIT )+ | ( DIGIT )+ ( '.' ( DIGIT )* )? ) ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
            {
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:681:4: ( '.' ( DIGIT )+ | ( DIGIT )+ ( '.' ( DIGIT )* )? )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='.') ) {
                alt17=1;
            }
            else if ( ((LA17_0>='0' && LA17_0<='9')) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:682:4: '.' ( DIGIT )+
                    {
                    match('.'); if (state.failed) return ;
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:682:8: ( DIGIT )+
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
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:682:8: DIGIT
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
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:684:6: ( DIGIT )+ ( '.' ( DIGIT )* )?
                    {
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:684:6: ( DIGIT )+
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
                    	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:684:6: DIGIT
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

                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:684:13: ( '.' ( DIGIT )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='.') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:684:15: '.' ( DIGIT )*
                            {
                            match('.'); if (state.failed) return ;
                            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:684:19: ( DIGIT )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:684:19: DIGIT
                            	    {
                            	    mDIGIT(); if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    break loop15;
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

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:686:17: ( '+' | '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='+'||LA18_0=='-') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:
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

            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:686:32: ( DIGIT )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:686:32: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
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
            // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:690:5: ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' ) )=> DOUBLE | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT )
            int alt20=5;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:690:9: ( INT '..' )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 2 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:691:7: ( INT '.' NAME )=> INT
                    {
                    mINT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;
                case 3 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:692:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' ) )=> DOUBLE
                    {
                    mDOUBLE(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = DOUBLE; 
                    }

                    }
                    break;
                case 4 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:699:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT
                    {
                    mFLOAT(); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 5 :
                    // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:706:9: INT
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

    public void mTokens() throws RecognitionException {
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:8: ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | ARROW | COLON | DCOLON | SEMICOLON | NL | WS | NAME | STRING | INT | RANGE_OR_INT_OR_FLOAT_OR_DOUBLE )
        int alt21=44;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:10: T__34
                {
                mT__34(); if (state.failed) return ;

                }
                break;
            case 2 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:16: T__35
                {
                mT__35(); if (state.failed) return ;

                }
                break;
            case 3 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:22: T__36
                {
                mT__36(); if (state.failed) return ;

                }
                break;
            case 4 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:28: T__37
                {
                mT__37(); if (state.failed) return ;

                }
                break;
            case 5 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:34: T__38
                {
                mT__38(); if (state.failed) return ;

                }
                break;
            case 6 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:40: T__39
                {
                mT__39(); if (state.failed) return ;

                }
                break;
            case 7 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:46: T__40
                {
                mT__40(); if (state.failed) return ;

                }
                break;
            case 8 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:52: T__41
                {
                mT__41(); if (state.failed) return ;

                }
                break;
            case 9 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:58: T__42
                {
                mT__42(); if (state.failed) return ;

                }
                break;
            case 10 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:64: T__43
                {
                mT__43(); if (state.failed) return ;

                }
                break;
            case 11 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:70: T__44
                {
                mT__44(); if (state.failed) return ;

                }
                break;
            case 12 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:76: T__45
                {
                mT__45(); if (state.failed) return ;

                }
                break;
            case 13 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:82: T__46
                {
                mT__46(); if (state.failed) return ;

                }
                break;
            case 14 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:88: T__47
                {
                mT__47(); if (state.failed) return ;

                }
                break;
            case 15 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:94: T__48
                {
                mT__48(); if (state.failed) return ;

                }
                break;
            case 16 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:100: T__49
                {
                mT__49(); if (state.failed) return ;

                }
                break;
            case 17 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:106: T__50
                {
                mT__50(); if (state.failed) return ;

                }
                break;
            case 18 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:112: T__51
                {
                mT__51(); if (state.failed) return ;

                }
                break;
            case 19 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:118: T__52
                {
                mT__52(); if (state.failed) return ;

                }
                break;
            case 20 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:124: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 21 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:132: MULTI_LINE_COMMENT
                {
                mMULTI_LINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 22 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:151: LBRACKET
                {
                mLBRACKET(); if (state.failed) return ;

                }
                break;
            case 23 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:160: RBRACKET
                {
                mRBRACKET(); if (state.failed) return ;

                }
                break;
            case 24 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:169: LCURL
                {
                mLCURL(); if (state.failed) return ;

                }
                break;
            case 25 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:175: RCURL
                {
                mRCURL(); if (state.failed) return ;

                }
                break;
            case 26 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:181: LANGLE
                {
                mLANGLE(); if (state.failed) return ;

                }
                break;
            case 27 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:188: RANGLE
                {
                mRANGLE(); if (state.failed) return ;

                }
                break;
            case 28 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:195: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 29 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:202: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 30 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:209: EXCL
                {
                mEXCL(); if (state.failed) return ;

                }
                break;
            case 31 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:214: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 32 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:221: EQUALSEQUALS
                {
                mEQUALSEQUALS(); if (state.failed) return ;

                }
                break;
            case 33 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:234: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;

                }
                break;
            case 34 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:241: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 35 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:245: ARROW
                {
                mARROW(); if (state.failed) return ;

                }
                break;
            case 36 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:251: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 37 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:257: DCOLON
                {
                mDCOLON(); if (state.failed) return ;

                }
                break;
            case 38 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:264: SEMICOLON
                {
                mSEMICOLON(); if (state.failed) return ;

                }
                break;
            case 39 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:274: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;
            case 40 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:277: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 41 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:280: NAME
                {
                mNAME(); if (state.failed) return ;

                }
                break;
            case 42 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:285: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;
            case 43 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:292: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 44 :
                // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:1:296: RANGE_OR_INT_OR_FLOAT_OR_DOUBLE
                {
                mRANGE_OR_INT_OR_FLOAT_OR_DOUBLE(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_CollectionLevelPermission
    public final void synpred1_CollectionLevelPermission_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:690:9: ( INT '..' )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:690:11: INT '..'
        {
        mINT(); if (state.failed) return ;
        match(".."); if (state.failed) return ;


        }
    }
    // $ANTLR end synpred1_CollectionLevelPermission

    // $ANTLR start synpred2_CollectionLevelPermission
    public final void synpred2_CollectionLevelPermission_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:691:7: ( INT '.' NAME )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:691:9: INT '.' NAME
        {
        mINT(); if (state.failed) return ;
        match('.'); if (state.failed) return ;
        mNAME(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_CollectionLevelPermission

    // $ANTLR start synpred3_CollectionLevelPermission
    public final void synpred3_CollectionLevelPermission_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:692:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' ) )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:692:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' )
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
    // $ANTLR end synpred3_CollectionLevelPermission

    // $ANTLR start synpred4_CollectionLevelPermission
    public final void synpred4_CollectionLevelPermission_fragment() throws RecognitionException {   
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:699:9: ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )
        // Z:\\cts.git\\ngpm\\com.sap.coghead.editor\\generated\\generated\\CollectionLevelPermission.g:699:11: INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' )
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
    // $ANTLR end synpred4_CollectionLevelPermission

    public final boolean synpred4_CollectionLevelPermission() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_CollectionLevelPermission_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_CollectionLevelPermission() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_CollectionLevelPermission_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_CollectionLevelPermission() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_CollectionLevelPermission_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_CollectionLevelPermission() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_CollectionLevelPermission_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA20_eotS =
        "\4\uffff\1\13\4\uffff\2\13\1\uffff";
    static final String DFA20_eofS =
        "\14\uffff";
    static final String DFA20_minS =
        "\2\56\1\60\1\56\1\60\4\uffff\2\60\1\uffff";
    static final String DFA20_maxS =
        "\1\71\1\145\1\71\2\145\4\uffff\2\145\1\uffff";
    static final String DFA20_acceptS =
        "\5\uffff\1\3\1\1\1\2\1\5\2\uffff\1\4";
    static final String DFA20_specialS =
        "\1\uffff\1\0\1\uffff\1\3\1\4\4\uffff\1\1\1\2\1\uffff}>";
    static final String[] DFA20_transitionS = {
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

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "689:1: RANGE_OR_INT_OR_FLOAT_OR_DOUBLE : ( ( INT '..' )=> INT | ( INT '.' NAME )=> INT | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) ( 'e' | 'E' ) )=> DOUBLE | ( INT '.' ~ ( '.' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u00FF' ) )=> FLOAT | INT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA20_1 = input.LA(1);

                         
                        int index20_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_1>='0' && LA20_1<='9')) ) {s = 3;}

                        else if ( (LA20_1=='.') ) {s = 4;}

                        else if ( (LA20_1=='E'||LA20_1=='e') && (synpred3_CollectionLevelPermission())) {s = 5;}

                        else if ( (synpred1_CollectionLevelPermission()) ) {s = 6;}

                        else if ( (synpred2_CollectionLevelPermission()) ) {s = 7;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index20_1);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA20_9 = input.LA(1);

                         
                        int index20_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_9>='0' && LA20_9<='9')) ) {s = 9;}

                        else if ( (LA20_9=='E'||LA20_9=='e') && (synpred3_CollectionLevelPermission())) {s = 5;}

                        else s = 11;

                         
                        input.seek(index20_9);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA20_10 = input.LA(1);

                         
                        int index20_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_10>='0' && LA20_10<='9')) ) {s = 10;}

                        else if ( (LA20_10=='E'||LA20_10=='e') && (synpred3_CollectionLevelPermission())) {s = 5;}

                        else s = 11;

                         
                        input.seek(index20_10);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA20_3 = input.LA(1);

                         
                        int index20_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA20_3=='.') ) {s = 4;}

                        else if ( (LA20_3=='E'||LA20_3=='e') && (synpred3_CollectionLevelPermission())) {s = 5;}

                        else if ( ((LA20_3>='0' && LA20_3<='9')) ) {s = 3;}

                         
                        input.seek(index20_3);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA20_4 = input.LA(1);

                         
                        int index20_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA20_4>='0' && LA20_4<='9')) ) {s = 10;}

                        else if ( (LA20_4=='E'||LA20_4=='e') && (synpred3_CollectionLevelPermission())) {s = 5;}

                        else s = 11;

                         
                        input.seek(index20_4);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\1\uffff\7\37\1\uffff\5\37\12\uffff\1\64\1\67\1\71\6\uffff\1\72"+
        "\14\37\1\110\2\37\12\uffff\15\37\1\uffff\1\130\15\37\1\146\1\uffff"+
        "\12\37\1\uffff\2\37\1\uffff\1\164\1\165\5\37\1\173\2\37\1\176\1"+
        "\37\1\u0080\2\uffff\5\37\1\uffff\1\37\1\u0087\1\uffff\1\37\1\uffff"+
        "\3\37\1\u008d\2\37\1\uffff\1\u0090\2\37\1\u0093\1\37\1\uffff\2\37"+
        "\1\uffff\2\37\1\uffff\1\37\1\u009a\4\37\1\uffff\1\u009f\1\u00a0"+
        "\2\37\2\uffff\3\37\1\u00a6\1\37\1\uffff\1\37\1\u00a9\1\uffff";
    static final String DFA21_eofS =
        "\u00aa\uffff";
    static final String DFA21_minS =
        "\1\11\1\121\1\122\1\105\1\117\1\157\1\145\1\141\1\uffff\1\145\1"+
        "\160\1\162\1\156\1\150\1\52\11\uffff\1\75\1\72\1\60\6\uffff\1\56"+
        "\1\125\1\105\1\123\1\116\1\154\1\145\1\162\1\146\2\164\1\144\1\157"+
        "\1\60\1\144\1\145\12\uffff\2\101\1\123\1\124\1\154\1\141\1\155\1"+
        "\141\1\145\1\141\1\162\1\141\1\155\1\uffff\1\60\1\162\1\114\1\124"+
        "\1\137\1\101\1\145\1\164\1\151\1\165\1\164\1\55\1\151\1\164\1\60"+
        "\1\uffff\1\145\1\123\1\105\1\117\1\111\1\143\1\145\1\163\1\154\1"+
        "\145\1\uffff\2\145\1\uffff\2\60\1\122\1\110\1\122\1\116\1\164\1"+
        "\60\1\163\1\164\1\60\1\166\1\60\2\uffff\1\137\1\101\1\137\1\123"+
        "\1\151\1\uffff\1\151\1\60\1\uffff\1\145\1\uffff\1\117\1\116\1\105"+
        "\1\60\2\157\1\uffff\1\60\1\110\1\122\1\60\1\121\1\uffff\2\156\1"+
        "\uffff\1\101\1\137\1\uffff\1\125\1\60\1\163\1\116\1\105\1\101\1"+
        "\uffff\2\60\1\121\1\114\2\uffff\1\125\1\123\1\101\1\60\1\114\1\uffff"+
        "\1\123\1\60\1\uffff";
    static final String DFA21_maxS =
        "\1\u00ff\1\121\1\122\1\105\1\117\1\162\2\145\1\uffff\1\145\1\160"+
        "\1\162\1\163\1\150\1\57\11\uffff\2\75\1\71\6\uffff\1\145\1\125\1"+
        "\105\1\123\1\116\1\154\1\145\1\162\1\154\2\164\1\144\1\157\1\u00ff"+
        "\1\144\1\145\12\uffff\2\101\1\123\1\124\1\154\1\141\1\155\1\141"+
        "\1\145\1\141\1\162\1\141\1\155\1\uffff\1\u00ff\1\162\1\114\1\124"+
        "\1\137\1\101\1\145\1\164\1\151\1\165\1\164\1\55\1\151\1\164\1\u00ff"+
        "\1\uffff\1\145\1\123\1\105\1\124\1\111\1\143\1\145\1\163\1\154\1"+
        "\145\1\uffff\2\145\1\uffff\2\u00ff\1\122\1\110\1\122\1\116\1\164"+
        "\1\u00ff\1\163\1\164\1\u00ff\1\166\1\u00ff\2\uffff\1\137\1\101\1"+
        "\137\1\123\1\151\1\uffff\1\151\1\u00ff\1\uffff\1\145\1\uffff\1\124"+
        "\1\116\1\105\1\u00ff\2\157\1\uffff\1\u00ff\1\110\1\122\1\u00ff\1"+
        "\121\1\uffff\2\156\1\uffff\1\101\1\137\1\uffff\1\125\1\u00ff\1\163"+
        "\1\116\1\105\1\101\1\uffff\2\u00ff\1\121\1\114\2\uffff\1\125\1\123"+
        "\1\101\1\u00ff\1\114\1\uffff\1\123\1\u00ff\1\uffff";
    static final String DFA21_acceptS =
        "\10\uffff\1\13\6\uffff\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
        "\1\36\3\uffff\1\43\1\46\1\47\1\50\1\51\1\52\20\uffff\1\24\1\25\1"+
        "\40\1\37\1\41\1\45\1\44\1\54\1\42\1\53\15\uffff\1\21\17\uffff\1"+
        "\23\12\uffff\1\17\2\uffff\1\20\15\uffff\1\22\1\1\5\uffff\1\12\2"+
        "\uffff\1\16\1\uffff\1\15\6\uffff\1\11\5\uffff\1\6\2\uffff\1\14\2"+
        "\uffff\1\3\6\uffff\1\7\4\uffff\1\10\1\2\5\uffff\1\5\2\uffff\1\4";
    static final String DFA21_specialS =
        "\u00aa\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\36\1\35\2\uffff\1\35\22\uffff\1\36\1\27\1\40\4\uffff\1\37"+
            "\1\25\1\26\2\uffff\1\10\1\33\1\32\1\16\12\41\1\31\1\34\1\23"+
            "\1\30\1\24\2\uffff\2\37\1\4\1\37\1\1\1\37\1\2\4\37\1\3\16\37"+
            "\1\17\1\uffff\1\20\1\uffff\1\37\1\uffff\1\14\1\37\1\5\1\7\1"+
            "\37\1\13\11\37\1\6\1\37\1\11\2\37\1\12\1\37\1\15\3\37\1\21\1"+
            "\uffff\1\22\102\uffff\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46\2\uffff\1\47",
            "\1\50",
            "\1\52\3\uffff\1\51",
            "",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\57\4\uffff\1\56",
            "\1\60",
            "\1\62\4\uffff\1\61",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\63",
            "\1\66\2\uffff\1\65",
            "\12\70",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\70\1\uffff\12\41\13\uffff\1\70\37\uffff\1\70",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102\5\uffff\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\111",
            "\1\112",
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
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\131",
            "\1\132",
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
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\153\4\uffff\1\152",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "",
            "\1\162",
            "\1\163",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\174",
            "\1\175",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\177",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "",
            "",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "",
            "\1\u0086",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "",
            "\1\u0088",
            "",
            "\1\u008a\4\uffff\1\u0089",
            "\1\u008b",
            "\1\u008c",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u008e",
            "\1\u008f",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u0091",
            "\1\u0092",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u0094",
            "",
            "\1\u0095",
            "\1\u0096",
            "",
            "\1\u0097",
            "\1\u0098",
            "",
            "\1\u0099",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
            "\1\u00a7",
            "",
            "\1\u00a8",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37\105\uffff"+
            "\27\37\1\uffff\37\37\1\uffff\10\37",
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
            return "1:1: Tokens : ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | COMMENT | MULTI_LINE_COMMENT | LBRACKET | RBRACKET | LCURL | RCURL | LANGLE | RANGLE | LPAREN | RPAREN | EXCL | EQUALS | EQUALSEQUALS | ASSIGN | DOT | ARROW | COLON | DCOLON | SEMICOLON | NL | WS | NAME | STRING | INT | RANGE_OR_INT_OR_FLOAT_OR_DOUBLE );";
        }
    }
 

}