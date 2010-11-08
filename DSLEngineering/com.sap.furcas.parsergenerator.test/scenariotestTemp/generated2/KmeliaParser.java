// $ANTLR 3.1.1 ./scenariotestTemp/generated2/Kmelia.g 2010-11-04 23:31:18

package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.parsergenerator.emf.lookup.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class KmeliaParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "COLON", "LCURLY", "COMA", "RCURLY", "LPAREN", "RPAREN", "MINUSMINUS", "RLARROW", "EXCLEXCL", "COMMENT", "LSQUARE", "RSQUARE", "EXCL", "SEMI", "PIPE", "QMARK", "COLONCOLON", "POINT", "RARROW", "MINUS", "STAR", "SLASH", "PLUS", "EQ", "GT", "LT", "GE", "LE", "NE", "LARROW", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'COMPONENT'", "'INTERFACE'", "'provides'", "'requires'", "'SERVICES'", "'END_SERVICES'", "'required'", "'provided'", "'external'", "'end'", "'Behavior'", "'Interface'", "'init'", "'final'"
    };
    public static final int LT=33;
    public static final int STAR=28;
    public static final int LSQUARE=18;
    public static final int POINT=25;
    public static final int ESC=43;
    public static final int LARROW=37;
    public static final int MINUSMINUS=14;
    public static final int FLOAT=7;
    public static final int EXCL=20;
    public static final int EOF=-1;
    public static final int EXCLEXCL=16;
    public static final int LPAREN=12;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int RPAREN=13;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int SLASH=29;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int PLUS=30;
    public static final int PIPE=22;
    public static final int DIGIT=40;
    public static final int NL=38;
    public static final int EQ=31;
    public static final int COMMENT=17;
    public static final int T__50=50;
    public static final int NE=36;
    public static final int GE=34;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=26;
    public static final int LCURLY=9;
    public static final int INT=6;
    public static final int RSQUARE=19;
    public static final int MINUS=27;
    public static final int COMA=10;
    public static final int SEMI=21;
    public static final int ALPHA=41;
    public static final int COLON=8;
    public static final int RLARROW=15;
    public static final int COLONCOLON=24;
    public static final int WS=39;
    public static final int SNAME=42;
    public static final int RCURLY=11;
    public static final int GT=32;
    public static final int QMARK=23;
    public static final int LE=35;
    public static final int STRING=5;

    // delegates
    // delegators


        public KmeliaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public KmeliaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return KmeliaParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/Kmelia.g"; }


       private static final String syntaxUUID = "Kmelia";
       public String getSyntaxUUID() {
            return syntaxUUID;
       }
       /**
         * Unescape string.
         * 
         * @param s the s
         * @param delimLength the delim length
         * 
         * @return the string
         */
        public String unescapeString(String s) {
            StringBuilder ret = new StringBuilder();
            // get rid of the starting and ending delimiters (e.g., '\'', '"')
           int delimLength = 1; // for delimLength > 0, the following code needs to change
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




    // $ANTLR start "identifier"
    // ./scenariotestTemp/generated2/Kmelia.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/Kmelia.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/Kmelia.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/Kmelia.g:209:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier69); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "identifier"


    // $ANTLR start "stringSymbol"
    // ./scenariotestTemp/generated2/Kmelia.g:217:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/Kmelia.g:218:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/Kmelia.g:219:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:219:3: (ast= STRING )
            // ./scenariotestTemp/generated2/Kmelia.g:219:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol100); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "stringSymbol"


    // $ANTLR start "integerSymbol"
    // ./scenariotestTemp/generated2/Kmelia.g:227:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/Kmelia.g:228:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/Kmelia.g:229:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:229:3: (ast= INT )
            // ./scenariotestTemp/generated2/Kmelia.g:229:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol131); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = Integer.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "integerSymbol"


    // $ANTLR start "floatSymbol"
    // ./scenariotestTemp/generated2/Kmelia.g:237:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/Kmelia.g:238:3: ( (ast= FLOAT ) )
            // ./scenariotestTemp/generated2/Kmelia.g:239:3: (ast= FLOAT )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:239:3: (ast= FLOAT )
            // ./scenariotestTemp/generated2/Kmelia.g:239:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol162); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = Double.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "floatSymbol"


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/Kmelia.g:247:1: main returns [Object ret2] : ( (ret= kmelia_component ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Kmelia.g:248:3: ( ( (ret= kmelia_component ) EOF ) )
            // ./scenariotestTemp/generated2/Kmelia.g:249:3: ( (ret= kmelia_component ) EOF )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:249:3: ( (ret= kmelia_component ) EOF )
            // ./scenariotestTemp/generated2/Kmelia.g:249:4: (ret= kmelia_component ) EOF
            {
            // ./scenariotestTemp/generated2/Kmelia.g:249:4: (ret= kmelia_component )
            // ./scenariotestTemp/generated2/Kmelia.g:249:5: ret= kmelia_component
            {
            pushFollow(FOLLOW_kmelia_component_in_main190);
            ret=kmelia_component();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main193); if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "main"


    // $ANTLR start "kmelia_component"
    // ./scenariotestTemp/generated2/Kmelia.g:256:1: kmelia_component returns [Object ret2] : ( 'COMPONENT' (temp= identifier ) 'INTERFACE' 'provides' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'requires' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'SERVICES' (temp= kmelia_service (temp= kmelia_service )* )? 'END_SERVICES' ) ;
    public final Object kmelia_component() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","Component");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:261:3: ( ( 'COMPONENT' (temp= identifier ) 'INTERFACE' 'provides' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'requires' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'SERVICES' (temp= kmelia_service (temp= kmelia_service )* )? 'END_SERVICES' ) )
            // ./scenariotestTemp/generated2/Kmelia.g:262:3: ( 'COMPONENT' (temp= identifier ) 'INTERFACE' 'provides' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'requires' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'SERVICES' (temp= kmelia_service (temp= kmelia_service )* )? 'END_SERVICES' )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:262:3: ( 'COMPONENT' (temp= identifier ) 'INTERFACE' 'provides' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'requires' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'SERVICES' (temp= kmelia_service (temp= kmelia_service )* )? 'END_SERVICES' )
            // ./scenariotestTemp/generated2/Kmelia.g:262:4: 'COMPONENT' (temp= identifier ) 'INTERFACE' 'provides' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'requires' COLON LCURLY (temp= identifier ( ( COMA ) temp= identifier )* )? RCURLY 'SERVICES' (temp= kmelia_service (temp= kmelia_service )* )? 'END_SERVICES'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,44,FOLLOW_44_in_kmelia_component224); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:262:65: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:262:67: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_component231);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,45,FOLLOW_45_in_kmelia_component237); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,46,FOLLOW_46_in_kmelia_component240); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLON,FOLLOW_COLON_in_kmelia_component244); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_kmelia_component249); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:262:318: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:262:320: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_kmelia_component257);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "provides", list("Kmelia","Service"), "name", temp, null, "never", null, false, null);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:262:437: ( ( COMA ) temp= identifier )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMA) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:262:438: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/Kmelia.g:262:455: ( COMA )
                    	    // ./scenariotestTemp/generated2/Kmelia.g:262:456: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_kmelia_component266); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_kmelia_component274);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setRef(ret, "provides", list("Kmelia","Service"), "name", temp, null, "never", null, false, null);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_kmelia_component286); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,47,FOLLOW_47_in_kmelia_component290); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLON,FOLLOW_COLON_in_kmelia_component294); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_kmelia_component299); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:262:833: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NAME) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:262:835: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_kmelia_component307);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "requires", list("Kmelia","Service"), "name", temp, null, "never", null, false, null);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:262:952: ( ( COMA ) temp= identifier )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==COMA) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:262:953: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/Kmelia.g:262:970: ( COMA )
                    	    // ./scenariotestTemp/generated2/Kmelia.g:262:971: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_kmelia_component316); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_kmelia_component324);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setRef(ret, "requires", list("Kmelia","Service"), "name", temp, null, "never", null, false, null);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_kmelia_component336); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,48,FOLLOW_48_in_kmelia_component340); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:262:1267: (temp= kmelia_service (temp= kmelia_service )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=50 && LA6_0<=51)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:262:1269: temp= kmelia_service (temp= kmelia_service )*
                    {
                    pushFollow(FOLLOW_kmelia_service_in_kmelia_component347);
                    temp=kmelia_service();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "services", temp);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:262:1327: (temp= kmelia_service )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=50 && LA5_0<=51)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:262:1329: temp= kmelia_service
                    	    {
                    	    pushFollow(FOLLOW_kmelia_service_in_kmelia_component355);
                    	    temp=kmelia_service();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "services", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,49,FOLLOW_49_in_kmelia_component366); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, true);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_component"


    // $ANTLR start "kmelia_service"
    // ./scenariotestTemp/generated2/Kmelia.g:270:1: kmelia_service returns [Object ret2] : (ret= kmelia_externalservice | ret= kmelia_internalservice ) ;
    public final Object kmelia_service() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Kmelia.g:271:3: ( (ret= kmelia_externalservice | ret= kmelia_internalservice ) )
            // ./scenariotestTemp/generated2/Kmelia.g:272:3: (ret= kmelia_externalservice | ret= kmelia_internalservice )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:272:3: (ret= kmelia_externalservice | ret= kmelia_internalservice )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==50) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==NAME) ) {
                    alt7=2;
                }
                else if ( (LA7_1==52) ) {
                    alt7=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==51) ) {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==52) ) {
                    alt7=1;
                }
                else if ( (LA7_2==NAME) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:272:4: ret= kmelia_externalservice
                    {
                    pushFollow(FOLLOW_kmelia_externalservice_in_kmelia_service403);
                    ret=kmelia_externalservice();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:273:5: ret= kmelia_internalservice
                    {
                    pushFollow(FOLLOW_kmelia_internalservice_in_kmelia_service411);
                    ret=kmelia_internalservice();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "kmelia_service"


    // $ANTLR start "kmelia_externalservice"
    // ./scenariotestTemp/generated2/Kmelia.g:280:1: kmelia_externalservice returns [Object ret2] : ( ( ( 'required' ) | ( 'provided' ) ) 'external' (temp= identifier ) ) ;
    public final Object kmelia_externalservice() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","ExternalService");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:285:3: ( ( ( ( 'required' ) | ( 'provided' ) ) 'external' (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/Kmelia.g:286:3: ( ( ( 'required' ) | ( 'provided' ) ) 'external' (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:286:3: ( ( ( 'required' ) | ( 'provided' ) ) 'external' (temp= identifier ) )
            // ./scenariotestTemp/generated2/Kmelia.g:286:4: ( ( 'required' ) | ( 'provided' ) ) 'external' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:286:22: ( ( 'required' ) | ( 'provided' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==50) ) {
                alt8=1;
            }
            else if ( (LA8_0==51) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:286:23: ( 'required' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:286:39: ( 'required' )
                    // ./scenariotestTemp/generated2/Kmelia.g:286:40: 'required'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,50,FOLLOW_50_in_kmelia_externalservice447); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isRequired", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:286:158: ( 'provided' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:286:174: ( 'provided' )
                    // ./scenariotestTemp/generated2/Kmelia.g:286:175: 'provided'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,51,FOLLOW_51_in_kmelia_externalservice460); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isRequired", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,52,FOLLOW_52_in_kmelia_externalservice470); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:287:77: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:287:79: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_externalservice477);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_externalservice"


    // $ANTLR start "kmelia_internalservice"
    // ./scenariotestTemp/generated2/Kmelia.g:295:1: kmelia_internalservice returns [Object ret2] : ( ( ( 'required' ) | ( 'provided' ) ) (temp= identifier ) LPAREN (temp= kmelia_parameter ( ( COMA ) temp= kmelia_parameter )* )? RPAREN ( ( COLON (temp= identifier ) ) | ) ( ( (temp= kmelia_body ) ) | ) 'end' ) ;
    public final Object kmelia_internalservice() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","InternalService");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:300:3: ( ( ( ( 'required' ) | ( 'provided' ) ) (temp= identifier ) LPAREN (temp= kmelia_parameter ( ( COMA ) temp= kmelia_parameter )* )? RPAREN ( ( COLON (temp= identifier ) ) | ) ( ( (temp= kmelia_body ) ) | ) 'end' ) )
            // ./scenariotestTemp/generated2/Kmelia.g:301:3: ( ( ( 'required' ) | ( 'provided' ) ) (temp= identifier ) LPAREN (temp= kmelia_parameter ( ( COMA ) temp= kmelia_parameter )* )? RPAREN ( ( COLON (temp= identifier ) ) | ) ( ( (temp= kmelia_body ) ) | ) 'end' )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:301:3: ( ( ( 'required' ) | ( 'provided' ) ) (temp= identifier ) LPAREN (temp= kmelia_parameter ( ( COMA ) temp= kmelia_parameter )* )? RPAREN ( ( COLON (temp= identifier ) ) | ) ( ( (temp= kmelia_body ) ) | ) 'end' )
            // ./scenariotestTemp/generated2/Kmelia.g:301:4: ( ( 'required' ) | ( 'provided' ) ) (temp= identifier ) LPAREN (temp= kmelia_parameter ( ( COMA ) temp= kmelia_parameter )* )? RPAREN ( ( COLON (temp= identifier ) ) | ) ( ( (temp= kmelia_body ) ) | ) 'end'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:301:22: ( ( 'required' ) | ( 'provided' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==50) ) {
                alt9=1;
            }
            else if ( (LA9_0==51) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:301:23: ( 'required' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:301:39: ( 'required' )
                    // ./scenariotestTemp/generated2/Kmelia.g:301:40: 'required'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,50,FOLLOW_50_in_kmelia_internalservice526); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isRequired", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:301:158: ( 'provided' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:301:174: ( 'provided' )
                    // ./scenariotestTemp/generated2/Kmelia.g:301:175: 'provided'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,51,FOLLOW_51_in_kmelia_internalservice539); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isRequired", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:302:34: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:302:36: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_internalservice553);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_kmelia_internalservice560); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:302:160: (temp= kmelia_parameter ( ( COMA ) temp= kmelia_parameter )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:302:162: temp= kmelia_parameter ( ( COMA ) temp= kmelia_parameter )*
                    {
                    pushFollow(FOLLOW_kmelia_parameter_in_kmelia_internalservice568);
                    temp=kmelia_parameter();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:302:224: ( ( COMA ) temp= kmelia_parameter )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:302:225: ( COMA ) temp= kmelia_parameter
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/Kmelia.g:302:242: ( COMA )
                    	    // ./scenariotestTemp/generated2/Kmelia.g:302:243: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_kmelia_internalservice577); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_kmelia_parameter_in_kmelia_internalservice585);
                    	    temp=kmelia_parameter();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "parameters", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_kmelia_internalservice597); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:302:442: ( ( COLON (temp= identifier ) ) | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==COLON) ) {
                alt12=1;
            }
            else if ( (LA12_0==53||LA12_0==55) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:302:443: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:302:459: ( COLON (temp= identifier ) )
                    // ./scenariotestTemp/generated2/Kmelia.g:302:460: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLON,FOLLOW_COLON_in_kmelia_internalservice608); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:302:517: (temp= identifier )
                    // ./scenariotestTemp/generated2/Kmelia.g:302:519: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_kmelia_internalservice616);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "returnType", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:302:609: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:303:35: ( ( (temp= kmelia_body ) ) | )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==55) ) {
                alt13=1;
            }
            else if ( (LA13_0==53) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:303:36: ( (temp= kmelia_body ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:303:52: ( (temp= kmelia_body ) )
                    // ./scenariotestTemp/generated2/Kmelia.g:303:53: (temp= kmelia_body )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:303:70: (temp= kmelia_body )
                    // ./scenariotestTemp/generated2/Kmelia.g:303:72: temp= kmelia_body
                    {
                    pushFollow(FOLLOW_kmelia_body_in_kmelia_internalservice645);
                    temp=kmelia_body();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "body", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:303:157: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,53,FOLLOW_53_in_kmelia_internalservice664); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_internalservice"


    // $ANTLR start "kmelia_parameter"
    // ./scenariotestTemp/generated2/Kmelia.g:312:1: kmelia_parameter returns [Object ret2] : ( (temp= identifier ) COLON (temp= identifier ) ) ;
    public final Object kmelia_parameter() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","Parameter");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:317:3: ( ( (temp= identifier ) COLON (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/Kmelia.g:318:3: ( (temp= identifier ) COLON (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:318:3: ( (temp= identifier ) COLON (temp= identifier ) )
            // ./scenariotestTemp/generated2/Kmelia.g:318:4: (temp= identifier ) COLON (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:318:21: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:318:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_parameter708);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLON,FOLLOW_COLON_in_kmelia_parameter715); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:318:146: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:318:148: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_parameter723);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "type", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_parameter"


    // $ANTLR start "kmelia_body"
    // ./scenariotestTemp/generated2/Kmelia.g:326:1: kmelia_body returns [Object ret2] : ( (temp= kmelia_interface ) ( ( 'Behavior' (temp= kmelia_behavior ) ) | ) ) ;
    public final Object kmelia_body() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","Body");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:331:3: ( ( (temp= kmelia_interface ) ( ( 'Behavior' (temp= kmelia_behavior ) ) | ) ) )
            // ./scenariotestTemp/generated2/Kmelia.g:332:3: ( (temp= kmelia_interface ) ( ( 'Behavior' (temp= kmelia_behavior ) ) | ) )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:332:3: ( (temp= kmelia_interface ) ( ( 'Behavior' (temp= kmelia_behavior ) ) | ) )
            // ./scenariotestTemp/generated2/Kmelia.g:332:4: (temp= kmelia_interface ) ( ( 'Behavior' (temp= kmelia_behavior ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:332:21: (temp= kmelia_interface )
            // ./scenariotestTemp/generated2/Kmelia.g:332:23: temp= kmelia_interface
            {
            pushFollow(FOLLOW_kmelia_interface_in_kmelia_body770);
            temp=kmelia_interface();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "interface", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:332:118: ( ( 'Behavior' (temp= kmelia_behavior ) ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==54) ) {
                alt14=1;
            }
            else if ( (LA14_0==EOF||LA14_0==53) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:332:119: ( 'Behavior' (temp= kmelia_behavior ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:332:135: ( 'Behavior' (temp= kmelia_behavior ) )
                    // ./scenariotestTemp/generated2/Kmelia.g:332:136: 'Behavior' (temp= kmelia_behavior )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,54,FOLLOW_54_in_kmelia_body782); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:332:196: (temp= kmelia_behavior )
                    // ./scenariotestTemp/generated2/Kmelia.g:332:198: temp= kmelia_behavior
                    {
                    pushFollow(FOLLOW_kmelia_behavior_in_kmelia_body789);
                    temp=kmelia_behavior();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "behavior", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:332:291: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_body"


    // $ANTLR start "kmelia_interface"
    // ./scenariotestTemp/generated2/Kmelia.g:341:1: kmelia_interface returns [Object ret2] : ( 'Interface' ) ;
    public final Object kmelia_interface() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("Kmelia","Interface");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:346:3: ( ( 'Interface' ) )
            // ./scenariotestTemp/generated2/Kmelia.g:347:3: ( 'Interface' )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:347:3: ( 'Interface' )
            // ./scenariotestTemp/generated2/Kmelia.g:347:4: 'Interface'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,55,FOLLOW_55_in_kmelia_interface845); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_interface"


    // $ANTLR start "kmelia_behavior"
    // ./scenariotestTemp/generated2/Kmelia.g:355:1: kmelia_behavior returns [Object ret2] : ( 'init' (temp= identifier ) 'final' (temp= identifier ( ( COMA ) temp= identifier )* ) LCURLY (temp= kmelia_transition ( ( COMA ) temp= kmelia_transition )* ) RCURLY ) ;
    public final Object kmelia_behavior() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","Behavior");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:360:3: ( ( 'init' (temp= identifier ) 'final' (temp= identifier ( ( COMA ) temp= identifier )* ) LCURLY (temp= kmelia_transition ( ( COMA ) temp= kmelia_transition )* ) RCURLY ) )
            // ./scenariotestTemp/generated2/Kmelia.g:361:3: ( 'init' (temp= identifier ) 'final' (temp= identifier ( ( COMA ) temp= identifier )* ) LCURLY (temp= kmelia_transition ( ( COMA ) temp= kmelia_transition )* ) RCURLY )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:361:3: ( 'init' (temp= identifier ) 'final' (temp= identifier ( ( COMA ) temp= identifier )* ) LCURLY (temp= kmelia_transition ( ( COMA ) temp= kmelia_transition )* ) RCURLY )
            // ./scenariotestTemp/generated2/Kmelia.g:361:4: 'init' (temp= identifier ) 'final' (temp= identifier ( ( COMA ) temp= identifier )* ) LCURLY (temp= kmelia_transition ( ( COMA ) temp= kmelia_transition )* ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,56,FOLLOW_56_in_kmelia_behavior885); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:361:60: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:361:62: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_behavior892);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "initialState", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,57,FOLLOW_57_in_kmelia_behavior898); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:361:271: (temp= identifier ( ( COMA ) temp= identifier )* )
            // ./scenariotestTemp/generated2/Kmelia.g:361:273: temp= identifier ( ( COMA ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_kmelia_behavior905);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "finalStates", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");
            }
            // ./scenariotestTemp/generated2/Kmelia.g:361:408: ( ( COMA ) temp= identifier )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/Kmelia.g:361:409: ( COMA ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/Kmelia.g:361:426: ( COMA )
            	    // ./scenariotestTemp/generated2/Kmelia.g:361:427: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_kmelia_behavior914); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_kmelia_behavior922);
            	    temp=identifier();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setRef(ret, "finalStates", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");
            	    }

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_kmelia_behavior932); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:361:696: (temp= kmelia_transition ( ( COMA ) temp= kmelia_transition )* )
            // ./scenariotestTemp/generated2/Kmelia.g:361:698: temp= kmelia_transition ( ( COMA ) temp= kmelia_transition )*
            {
            pushFollow(FOLLOW_kmelia_transition_in_kmelia_behavior940);
            temp=kmelia_transition();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "transitions", temp);
            }
            // ./scenariotestTemp/generated2/Kmelia.g:361:762: ( ( COMA ) temp= kmelia_transition )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==COMA) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/Kmelia.g:361:763: ( COMA ) temp= kmelia_transition
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/Kmelia.g:361:780: ( COMA )
            	    // ./scenariotestTemp/generated2/Kmelia.g:361:781: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_kmelia_behavior949); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_kmelia_transition_in_kmelia_behavior957);
            	    temp=kmelia_transition();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "transitions", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_kmelia_behavior967); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, true);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_behavior"


    // $ANTLR start "kmelia_state"
    // ./scenariotestTemp/generated2/Kmelia.g:369:1: kmelia_state returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object kmelia_state() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","State");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:374:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/Kmelia.g:375:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:375:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/Kmelia.g:375:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:375:21: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:375:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_state1012);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_state"


    // $ANTLR start "kmelia_transition"
    // ./scenariotestTemp/generated2/Kmelia.g:383:1: kmelia_transition returns [Object ret2] : ( (temp= identifier ) MINUSMINUS (temp= kmelia_action ( ( COMA ) temp= kmelia_action )* )? RLARROW (temp= identifier ) ) ;
    public final Object kmelia_transition() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","Transition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:388:3: ( ( (temp= identifier ) MINUSMINUS (temp= kmelia_action ( ( COMA ) temp= kmelia_action )* )? RLARROW (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/Kmelia.g:389:3: ( (temp= identifier ) MINUSMINUS (temp= kmelia_action ( ( COMA ) temp= kmelia_action )* )? RLARROW (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:389:3: ( (temp= identifier ) MINUSMINUS (temp= kmelia_action ( ( COMA ) temp= kmelia_action )* )? RLARROW (temp= identifier ) )
            // ./scenariotestTemp/generated2/Kmelia.g:389:4: (temp= identifier ) MINUSMINUS (temp= kmelia_action ( ( COMA ) temp= kmelia_action )* )? RLARROW (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:389:21: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:389:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_transition1059);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "source", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_kmelia_transition1066); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:389:231: (temp= kmelia_action ( ( COMA ) temp= kmelia_action )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==NAME) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:389:233: temp= kmelia_action ( ( COMA ) temp= kmelia_action )*
                    {
                    pushFollow(FOLLOW_kmelia_action_in_kmelia_transition1074);
                    temp=kmelia_action();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "actions", temp);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:389:289: ( ( COMA ) temp= kmelia_action )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==COMA) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:389:290: ( COMA ) temp= kmelia_action
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/Kmelia.g:389:307: ( COMA )
                    	    // ./scenariotestTemp/generated2/Kmelia.g:389:308: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_kmelia_transition1083); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_kmelia_action_in_kmelia_transition1091);
                    	    temp=kmelia_action();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "actions", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RLARROW,FOLLOW_RLARROW_in_kmelia_transition1103); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:389:501: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:389:503: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_transition1111);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "target", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_transition"


    // $ANTLR start "kmelia_action"
    // ./scenariotestTemp/generated2/Kmelia.g:397:1: kmelia_action returns [Object ret2] : (ret= kmelia_functioncall | ret= kmelia_communication ) ;
    public final Object kmelia_action() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Kmelia.g:398:3: ( (ret= kmelia_functioncall | ret= kmelia_communication ) )
            // ./scenariotestTemp/generated2/Kmelia.g:399:3: (ret= kmelia_functioncall | ret= kmelia_communication )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:399:3: (ret= kmelia_functioncall | ret= kmelia_communication )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NAME) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==LPAREN) ) {
                    alt19=1;
                }
                else if ( (LA19_1==EXCLEXCL) ) {
                    alt19=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:399:4: ret= kmelia_functioncall
                    {
                    pushFollow(FOLLOW_kmelia_functioncall_in_kmelia_action1151);
                    ret=kmelia_functioncall();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Kmelia.g:400:5: ret= kmelia_communication
                    {
                    pushFollow(FOLLOW_kmelia_communication_in_kmelia_action1159);
                    ret=kmelia_communication();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "kmelia_action"


    // $ANTLR start "kmelia_functioncall"
    // ./scenariotestTemp/generated2/Kmelia.g:407:1: kmelia_functioncall returns [Object ret2] : ( (temp= identifier ) LPAREN (temp= kmelia_expression ( ( COMA ) temp= kmelia_expression )* )? RPAREN ) ;
    public final Object kmelia_functioncall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","FunctionCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:412:3: ( ( (temp= identifier ) LPAREN (temp= kmelia_expression ( ( COMA ) temp= kmelia_expression )* )? RPAREN ) )
            // ./scenariotestTemp/generated2/Kmelia.g:413:3: ( (temp= identifier ) LPAREN (temp= kmelia_expression ( ( COMA ) temp= kmelia_expression )* )? RPAREN )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:413:3: ( (temp= identifier ) LPAREN (temp= kmelia_expression ( ( COMA ) temp= kmelia_expression )* )? RPAREN )
            // ./scenariotestTemp/generated2/Kmelia.g:413:4: (temp= identifier ) LPAREN (temp= kmelia_expression ( ( COMA ) temp= kmelia_expression )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:413:21: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:413:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_functioncall1193);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_kmelia_functioncall1200); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:413:147: (temp= kmelia_expression ( ( COMA ) temp= kmelia_expression )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ./scenariotestTemp/generated2/Kmelia.g:413:149: temp= kmelia_expression ( ( COMA ) temp= kmelia_expression )*
                    {
                    pushFollow(FOLLOW_kmelia_expression_in_kmelia_functioncall1208);
                    temp=kmelia_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "arguments", temp);
                    }
                    // ./scenariotestTemp/generated2/Kmelia.g:413:211: ( ( COMA ) temp= kmelia_expression )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==COMA) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Kmelia.g:413:212: ( COMA ) temp= kmelia_expression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/Kmelia.g:413:229: ( COMA )
                    	    // ./scenariotestTemp/generated2/Kmelia.g:413:230: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_kmelia_functioncall1217); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_kmelia_expression_in_kmelia_functioncall1225);
                    	    temp=kmelia_expression();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "arguments", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_kmelia_functioncall1237); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_functioncall"


    // $ANTLR start "kmelia_communication"
    // ./scenariotestTemp/generated2/Kmelia.g:421:1: kmelia_communication returns [Object ret2] : (ret= kmelia_servicecall ) ;
    public final Object kmelia_communication() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Kmelia.g:422:3: ( (ret= kmelia_servicecall ) )
            // ./scenariotestTemp/generated2/Kmelia.g:423:3: (ret= kmelia_servicecall )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:423:3: (ret= kmelia_servicecall )
            // ./scenariotestTemp/generated2/Kmelia.g:423:4: ret= kmelia_servicecall
            {
            pushFollow(FOLLOW_kmelia_servicecall_in_kmelia_communication1275);
            ret=kmelia_servicecall();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "kmelia_communication"


    // $ANTLR start "kmelia_servicecall"
    // ./scenariotestTemp/generated2/Kmelia.g:430:1: kmelia_servicecall returns [Object ret2] : ( (temp= identifier ) EXCLEXCL (temp= identifier ) LPAREN RPAREN ) ;
    public final Object kmelia_servicecall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","ServiceCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:435:3: ( ( (temp= identifier ) EXCLEXCL (temp= identifier ) LPAREN RPAREN ) )
            // ./scenariotestTemp/generated2/Kmelia.g:436:3: ( (temp= identifier ) EXCLEXCL (temp= identifier ) LPAREN RPAREN )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:436:3: ( (temp= identifier ) EXCLEXCL (temp= identifier ) LPAREN RPAREN )
            // ./scenariotestTemp/generated2/Kmelia.g:436:4: (temp= identifier ) EXCLEXCL (temp= identifier ) LPAREN RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:436:21: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:436:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_servicecall1309);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "channel", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EXCLEXCL,FOLLOW_EXCLEXCL_in_kmelia_servicecall1316); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:436:152: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:436:154: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_servicecall1324);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_kmelia_servicecall1331); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_kmelia_servicecall1336); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_servicecall"


    // $ANTLR start "kmelia_expression"
    // ./scenariotestTemp/generated2/Kmelia.g:444:1: kmelia_expression returns [Object ret2] : (ret= kmelia_stringexp ) ;
    public final Object kmelia_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Kmelia.g:445:3: ( (ret= kmelia_stringexp ) )
            // ./scenariotestTemp/generated2/Kmelia.g:446:3: (ret= kmelia_stringexp )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:446:3: (ret= kmelia_stringexp )
            // ./scenariotestTemp/generated2/Kmelia.g:446:4: ret= kmelia_stringexp
            {
            pushFollow(FOLLOW_kmelia_stringexp_in_kmelia_expression1374);
            ret=kmelia_stringexp();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "kmelia_expression"


    // $ANTLR start "kmelia_stringexp"
    // ./scenariotestTemp/generated2/Kmelia.g:453:1: kmelia_stringexp returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object kmelia_stringexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Kmelia","StringExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Kmelia.g:458:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/Kmelia.g:459:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/Kmelia.g:459:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/Kmelia.g:459:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Kmelia.g:459:21: (temp= identifier )
            // ./scenariotestTemp/generated2/Kmelia.g:459:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_kmelia_stringexp1408);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "kmelia_stringexp"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kmelia_component_in_main190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_kmelia_component224 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_component231 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_kmelia_component237 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_kmelia_component240 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_kmelia_component244 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LCURLY_in_kmelia_component249 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_identifier_in_kmelia_component257 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COMA_in_kmelia_component266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_component274 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RCURLY_in_kmelia_component286 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_kmelia_component290 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_kmelia_component294 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LCURLY_in_kmelia_component299 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_identifier_in_kmelia_component307 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COMA_in_kmelia_component316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_component324 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RCURLY_in_kmelia_component336 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_kmelia_component340 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_kmelia_service_in_kmelia_component347 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_kmelia_service_in_kmelia_component355 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_49_in_kmelia_component366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kmelia_externalservice_in_kmelia_service403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kmelia_internalservice_in_kmelia_service411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_kmelia_externalservice447 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_51_in_kmelia_externalservice460 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_kmelia_externalservice470 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_externalservice477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_kmelia_internalservice526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_51_in_kmelia_internalservice539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_internalservice553 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_kmelia_internalservice560 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_kmelia_parameter_in_kmelia_internalservice568 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_COMA_in_kmelia_internalservice577 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_kmelia_parameter_in_kmelia_internalservice585 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_RPAREN_in_kmelia_internalservice597 = new BitSet(new long[]{0x00A0000000000100L});
    public static final BitSet FOLLOW_COLON_in_kmelia_internalservice608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_internalservice616 = new BitSet(new long[]{0x00A0000000000000L});
    public static final BitSet FOLLOW_kmelia_body_in_kmelia_internalservice645 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_kmelia_internalservice664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_kmelia_parameter708 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_kmelia_parameter715 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_parameter723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kmelia_interface_in_kmelia_body770 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_kmelia_body782 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_kmelia_behavior_in_kmelia_body789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_kmelia_interface845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_kmelia_behavior885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_behavior892 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_kmelia_behavior898 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_behavior905 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_kmelia_behavior914 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_behavior922 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_LCURLY_in_kmelia_behavior932 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_kmelia_transition_in_kmelia_behavior940 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_COMA_in_kmelia_behavior949 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_kmelia_transition_in_kmelia_behavior957 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_RCURLY_in_kmelia_behavior967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_kmelia_state1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_kmelia_transition1059 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_MINUSMINUS_in_kmelia_transition1066 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_kmelia_action_in_kmelia_transition1074 = new BitSet(new long[]{0x0000000000008400L});
    public static final BitSet FOLLOW_COMA_in_kmelia_transition1083 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_kmelia_action_in_kmelia_transition1091 = new BitSet(new long[]{0x0000000000008400L});
    public static final BitSet FOLLOW_RLARROW_in_kmelia_transition1103 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_transition1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kmelia_functioncall_in_kmelia_action1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kmelia_communication_in_kmelia_action1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_kmelia_functioncall1193 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_kmelia_functioncall1200 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_kmelia_expression_in_kmelia_functioncall1208 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_COMA_in_kmelia_functioncall1217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_kmelia_expression_in_kmelia_functioncall1225 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_RPAREN_in_kmelia_functioncall1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kmelia_servicecall_in_kmelia_communication1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_kmelia_servicecall1309 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_EXCLEXCL_in_kmelia_servicecall1316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_kmelia_servicecall1324 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_kmelia_servicecall1331 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_kmelia_servicecall1336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_kmelia_stringexp_in_kmelia_expression1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_kmelia_stringexp1408 = new BitSet(new long[]{0x0000000000000002L});

}