// $ANTLR 3.1.1 ./scenariotestTemp/generated2/People.g 2010-11-04 23:28:47

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
public class PeopleParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "WORLD", "LPAREN", "RPAREN", "STAR", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "INT", "FLOAT", "STRING", "'{'", "','", "'}'", "'heaven'", "'defs:'", "'['", "']'", "'capital:'", "'('", "')'", "'representative:'", "'@'", "'mother:'", "'spouse:'"
    };
    public static final int STAR=8;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int WORLD=5;
    public static final int T__23=23;
    public static final int ESC=15;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int FLOAT=17;
    public static final int INT=16;
    public static final int EOF=-1;
    public static final int ALPHA=13;
    public static final int LPAREN=6;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int RPAREN=7;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int NAME=4;
    public static final int WS=11;
    public static final int SNAME=14;
    public static final int DIGIT=12;
    public static final int NL=10;
    public static final int COMMENT=9;
    public static final int STRING=18;

    // delegates
    // delegators


        public PeopleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PeopleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PeopleParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/People.g"; }


       private static final String syntaxUUID = "People";
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
    // ./scenariotestTemp/generated2/People.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/People.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/People.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/People.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/People.g:209:4: ast= NAME
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


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/People.g:217:1: main returns [Object ret2] : ( (ret= people_world ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/People.g:218:3: ( ( (ret= people_world ) EOF ) )
            // ./scenariotestTemp/generated2/People.g:219:3: ( (ret= people_world ) EOF )
            {
            // ./scenariotestTemp/generated2/People.g:219:3: ( (ret= people_world ) EOF )
            // ./scenariotestTemp/generated2/People.g:219:4: (ret= people_world ) EOF
            {
            // ./scenariotestTemp/generated2/People.g:219:4: (ret= people_world )
            // ./scenariotestTemp/generated2/People.g:219:5: ret= people_world
            {
            pushFollow(FOLLOW_people_world_in_main97);
            ret=people_world();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main100); if (state.failed) return ret2;

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


    // $ANTLR start "people_world"
    // ./scenariotestTemp/generated2/People.g:226:1: people_world returns [Object ret2] : ( ( ( WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' ) | (~ WORLD )=> ( 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )? ) ) ) ;
    public final Object people_world() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("People","World");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/People.g:231:3: ( ( ( ( WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' ) | (~ WORLD )=> ( 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )? ) ) ) )
            // ./scenariotestTemp/generated2/People.g:232:3: ( ( ( WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' ) | (~ WORLD )=> ( 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )? ) ) )
            {
            // ./scenariotestTemp/generated2/People.g:232:3: ( ( ( WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' ) | (~ WORLD )=> ( 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )? ) ) )
            // ./scenariotestTemp/generated2/People.g:232:4: ( ( WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' ) | (~ WORLD )=> ( 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:232:21: ( ( WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' ) | (~ WORLD )=> ( 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )? ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==WORLD) ) {
                alt7=1;
            }
            else if ( (LA7_0==22) && (synpred4_People())) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:232:22: ( WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/People.g:232:38: ( WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' )
                    // ./scenariotestTemp/generated2/People.g:232:39: WORLD '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,WORLD,FOLLOW_WORLD_in_people_world137); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,19,FOLLOW_19_in_people_world141); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/People.g:232:132: (temp= people_nation ( ( ',' ) temp= people_nation )* )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==NAME||LA2_0==24) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ./scenariotestTemp/generated2/People.g:232:134: temp= people_nation ( ( ',' ) temp= people_nation )*
                            {
                            pushFollow(FOLLOW_people_nation_in_people_world148);
                            temp=people_nation();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "nations", temp);
                            }
                            // ./scenariotestTemp/generated2/People.g:232:190: ( ( ',' ) temp= people_nation )*
                            loop1:
                            do {
                                int alt1=2;
                                int LA1_0 = input.LA(1);

                                if ( (LA1_0==20) ) {
                                    alt1=1;
                                }


                                switch (alt1) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/People.g:232:191: ( ',' ) temp= people_nation
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/People.g:232:208: ( ',' )
                            	    // ./scenariotestTemp/generated2/People.g:232:209: ','
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,20,FOLLOW_20_in_people_world156); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_people_nation_in_people_world163);
                            	    temp=people_nation();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "nations", temp);
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
                    match(input,21,FOLLOW_21_in_people_world174); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/People.g:233:4: (~ WORLD )=> ( 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/People.g:233:32: ( 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )? )
                    // ./scenariotestTemp/generated2/People.g:233:33: 'heaven' '{' (temp= people_nation ( ( ',' ) temp= people_nation )* )? '}' 'defs:' (temp= people_persondefinition (temp= people_persondefinition )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,22,FOLLOW_22_in_people_world194); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,19,FOLLOW_19_in_people_world197); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/People.g:233:127: (temp= people_nation ( ( ',' ) temp= people_nation )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==NAME||LA4_0==24) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ./scenariotestTemp/generated2/People.g:233:129: temp= people_nation ( ( ',' ) temp= people_nation )*
                            {
                            pushFollow(FOLLOW_people_nation_in_people_world204);
                            temp=people_nation();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "nations", temp);
                            }
                            // ./scenariotestTemp/generated2/People.g:233:185: ( ( ',' ) temp= people_nation )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==20) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/People.g:233:186: ( ',' ) temp= people_nation
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/People.g:233:203: ( ',' )
                            	    // ./scenariotestTemp/generated2/People.g:233:204: ','
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,20,FOLLOW_20_in_people_world212); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_people_nation_in_people_world219);
                            	    temp=people_nation();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "nations", temp);
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
                    match(input,21,FOLLOW_21_in_people_world230); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,23,FOLLOW_23_in_people_world233); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/People.g:233:428: (temp= people_persondefinition (temp= people_persondefinition )* )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==NAME||LA6_0==LPAREN) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ./scenariotestTemp/generated2/People.g:233:430: temp= people_persondefinition (temp= people_persondefinition )*
                            {
                            pushFollow(FOLLOW_people_persondefinition_in_people_world240);
                            temp=people_persondefinition();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "definitions", temp);
                            }
                            // ./scenariotestTemp/generated2/People.g:233:500: (temp= people_persondefinition )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==NAME||LA5_0==LPAREN) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/People.g:233:502: temp= people_persondefinition
                            	    {
                            	    pushFollow(FOLLOW_people_persondefinition_in_people_world248);
                            	    temp=people_persondefinition();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "definitions", temp);
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
    // $ANTLR end "people_world"


    // $ANTLR start "people_nation"
    // ./scenariotestTemp/generated2/People.g:241:1: people_nation returns [Object ret2] : ( (temp= identifier )? '[' (temp= people_city ( ( ',' ) temp= people_city )* )? ']' 'capital:' (temp= identifier )? ) ;
    public final Object people_nation() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("People","Nation");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"nationTag"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/People.g:246:3: ( ( (temp= identifier )? '[' (temp= people_city ( ( ',' ) temp= people_city )* )? ']' 'capital:' (temp= identifier )? ) )
            // ./scenariotestTemp/generated2/People.g:247:3: ( (temp= identifier )? '[' (temp= people_city ( ( ',' ) temp= people_city )* )? ']' 'capital:' (temp= identifier )? )
            {
            // ./scenariotestTemp/generated2/People.g:247:3: ( (temp= identifier )? '[' (temp= people_city ( ( ',' ) temp= people_city )* )? ']' 'capital:' (temp= identifier )? )
            // ./scenariotestTemp/generated2/People.g:247:4: (temp= identifier )? '[' (temp= people_city ( ( ',' ) temp= people_city )* )? ']' 'capital:' (temp= identifier )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:247:21: (temp= identifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NAME) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:247:23: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_people_nation305);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
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
            match(input,24,FOLLOW_24_in_people_nation313); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:247:144: (temp= people_city ( ( ',' ) temp= people_city )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==NAME||LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:247:146: temp= people_city ( ( ',' ) temp= people_city )*
                    {
                    pushFollow(FOLLOW_people_city_in_people_nation320);
                    temp=people_city();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "cities", temp);
                    }
                    // ./scenariotestTemp/generated2/People.g:247:199: ( ( ',' ) temp= people_city )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==20) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/People.g:247:200: ( ',' ) temp= people_city
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/People.g:247:217: ( ',' )
                    	    // ./scenariotestTemp/generated2/People.g:247:218: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,20,FOLLOW_20_in_people_nation328); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_people_city_in_people_nation335);
                    	    temp=people_city();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "cities", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
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
            match(input,25,FOLLOW_25_in_people_nation346); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,26,FOLLOW_26_in_people_nation349); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:247:442: (temp= identifier )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:247:444: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_people_nation356);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "capital", list("People","City"), "name", temp, "cities", "never", null, false, null);
                    }

                    }
                    break;

            }

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
    // $ANTLR end "people_nation"


    // $ANTLR start "people_city"
    // ./scenariotestTemp/generated2/People.g:255:1: people_city returns [Object ret2] : ( (temp= identifier )? '(' (temp= people_person ( ( ',' ) temp= people_person )* )? ')' ( ( 'representative:' (temp= identifier ) ) | ) ) ;
    public final Object people_city() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("People","City");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/People.g:260:3: ( ( (temp= identifier )? '(' (temp= people_person ( ( ',' ) temp= people_person )* )? ')' ( ( 'representative:' (temp= identifier ) ) | ) ) )
            // ./scenariotestTemp/generated2/People.g:261:3: ( (temp= identifier )? '(' (temp= people_person ( ( ',' ) temp= people_person )* )? ')' ( ( 'representative:' (temp= identifier ) ) | ) )
            {
            // ./scenariotestTemp/generated2/People.g:261:3: ( (temp= identifier )? '(' (temp= people_person ( ( ',' ) temp= people_person )* )? ')' ( ( 'representative:' (temp= identifier ) ) | ) )
            // ./scenariotestTemp/generated2/People.g:261:4: (temp= identifier )? '(' (temp= people_person ( ( ',' ) temp= people_person )* )? ')' ( ( 'representative:' (temp= identifier ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:261:21: (temp= identifier )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NAME) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:261:23: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_people_city405);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
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
            match(input,27,FOLLOW_27_in_people_city413); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:261:144: (temp= people_person ( ( ',' ) temp= people_person )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==NAME) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:261:146: temp= people_person ( ( ',' ) temp= people_person )*
                    {
                    pushFollow(FOLLOW_people_person_in_people_city420);
                    temp=people_person();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "persons", temp);
                    }
                    // ./scenariotestTemp/generated2/People.g:261:202: ( ( ',' ) temp= people_person )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==20) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/People.g:261:203: ( ',' ) temp= people_person
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/People.g:261:220: ( ',' )
                    	    // ./scenariotestTemp/generated2/People.g:261:221: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,20,FOLLOW_20_in_people_city428); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_people_person_in_people_city435);
                    	    temp=people_person();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "persons", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
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
            match(input,28,FOLLOW_28_in_people_city446); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:261:406: ( ( 'representative:' (temp= identifier ) ) | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==29) ) {
                alt15=1;
            }
            else if ( (LA15_0==EOF||LA15_0==20||LA15_0==25) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:261:407: ( 'representative:' (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/People.g:261:423: ( 'representative:' (temp= identifier ) )
                    // ./scenariotestTemp/generated2/People.g:261:424: 'representative:' (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,29,FOLLOW_29_in_people_city455); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/People.g:261:491: (temp= identifier )
                    // ./scenariotestTemp/generated2/People.g:261:493: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_people_city462);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "representative", "name", temp, "OCL:#context(nationTag).capital.persons->select(p | p.name = ?)");
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
                    // ./scenariotestTemp/generated2/People.g:261:660: 
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
    // $ANTLR end "people_city"


    // $ANTLR start "people_person"
    // ./scenariotestTemp/generated2/People.g:270:1: people_person returns [Object ret2] : ( (temp= identifier ) '@' (temp= identifier )? ( ( '(' 'mother:' (temp= identifier ) ')' ) | ) ( ( 'spouse:' (temp= identifier ) ) | ) ) ;
    public final Object people_person() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("People","Person");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/People.g:275:3: ( ( (temp= identifier ) '@' (temp= identifier )? ( ( '(' 'mother:' (temp= identifier ) ')' ) | ) ( ( 'spouse:' (temp= identifier ) ) | ) ) )
            // ./scenariotestTemp/generated2/People.g:276:3: ( (temp= identifier ) '@' (temp= identifier )? ( ( '(' 'mother:' (temp= identifier ) ')' ) | ) ( ( 'spouse:' (temp= identifier ) ) | ) )
            {
            // ./scenariotestTemp/generated2/People.g:276:3: ( (temp= identifier ) '@' (temp= identifier )? ( ( '(' 'mother:' (temp= identifier ) ')' ) | ) ( ( 'spouse:' (temp= identifier ) ) | ) )
            // ./scenariotestTemp/generated2/People.g:276:4: (temp= identifier ) '@' (temp= identifier )? ( ( '(' 'mother:' (temp= identifier ) ')' ) | ) ( ( 'spouse:' (temp= identifier ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:276:21: (temp= identifier )
            // ./scenariotestTemp/generated2/People.g:276:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_people_person522);
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
            match(input,30,FOLLOW_30_in_people_person528); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:276:142: (temp= identifier )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==NAME) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:276:144: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_people_person535);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "currentlyIn", list("People","City"), "name", temp, "#context(nationTag).cities", "never", null, false, null);
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
            // ./scenariotestTemp/generated2/People.g:276:321: ( ( '(' 'mother:' (temp= identifier ) ')' ) | )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            else if ( (LA17_0==EOF||LA17_0==20||LA17_0==28||LA17_0==32) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:276:322: ( '(' 'mother:' (temp= identifier ) ')' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/People.g:276:338: ( '(' 'mother:' (temp= identifier ) ')' )
                    // ./scenariotestTemp/generated2/People.g:276:339: '(' 'mother:' (temp= identifier ) ')'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,27,FOLLOW_27_in_people_person549); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,31,FOLLOW_31_in_people_person552); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/People.g:276:434: (temp= identifier )
                    // ./scenariotestTemp/generated2/People.g:276:436: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_people_person559);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "parents", list("People","Person"), "name", temp, null, "never", null, false, null);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,28,FOLLOW_28_in_people_person565); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/People.g:276:621: 
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
            // ./scenariotestTemp/generated2/People.g:277:35: ( ( 'spouse:' (temp= identifier ) ) | )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            else if ( (LA18_0==EOF||LA18_0==20||LA18_0==28) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:277:36: ( 'spouse:' (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/People.g:277:52: ( 'spouse:' (temp= identifier ) )
                    // ./scenariotestTemp/generated2/People.g:277:53: 'spouse:' (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,32,FOLLOW_32_in_people_person587); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/People.g:277:112: (temp= identifier )
                    // ./scenariotestTemp/generated2/People.g:277:114: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_people_person594);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "spouse", null, temp, "OCL:Person.allInstances()->select(p|p.name=?)");
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
                    // ./scenariotestTemp/generated2/People.g:277:253: 
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
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "male", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "age", 42);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "height", 1.83);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "codeName", "Viper");_exitInjectorAction();_enterInjectorAction();setRef(ret, "embassy", list("People","City"), null, null, "currentlyIn.nation.capital", null, null, false, null, true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "embassy2", null, null, "OCL:currentlyIn.nation.capital", true);_exitInjectorAction();
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
    // $ANTLR end "people_person"


    // $ANTLR start "primary_people_persondefinition"
    // ./scenariotestTemp/generated2/People.g:286:1: primary_people_persondefinition returns [Object ret2] : (ret= people_concretepersondefinition | ( LPAREN ret= people_persondefinition RPAREN ) ) ;
    public final Object primary_people_persondefinition() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/People.g:287:3: ( (ret= people_concretepersondefinition | ( LPAREN ret= people_persondefinition RPAREN ) ) )
            // ./scenariotestTemp/generated2/People.g:288:3: (ret= people_concretepersondefinition | ( LPAREN ret= people_persondefinition RPAREN ) )
            {
            // ./scenariotestTemp/generated2/People.g:288:3: (ret= people_concretepersondefinition | ( LPAREN ret= people_persondefinition RPAREN ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NAME) ) {
                alt19=1;
            }
            else if ( (LA19_0==LPAREN) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:288:4: ret= people_concretepersondefinition
                    {
                    pushFollow(FOLLOW_people_concretepersondefinition_in_primary_people_persondefinition650);
                    ret=people_concretepersondefinition();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/People.g:289:5: ( LPAREN ret= people_persondefinition RPAREN )
                    {
                    // ./scenariotestTemp/generated2/People.g:289:5: ( LPAREN ret= people_persondefinition RPAREN )
                    // ./scenariotestTemp/generated2/People.g:289:6: LPAREN ret= people_persondefinition RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_people_persondefinition659); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_people_persondefinition_in_primary_people_persondefinition665);
                    ret=people_persondefinition();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_people_persondefinition669); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitOpdBrackSeq();
                    }

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
    // $ANTLR end "primary_people_persondefinition"


    // $ANTLR start "persondefinitions_priority_0"
    // ./scenariotestTemp/generated2/People.g:296:1: persondefinitions_priority_0 returns [Object ret2] : ( (ret= primary_people_persondefinition ) ( ( ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) ) ) | ) ) ;
    public final Object persondefinitions_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/People.g:297:3: ( ( (ret= primary_people_persondefinition ) ( ( ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) ) ) | ) ) )
            // ./scenariotestTemp/generated2/People.g:298:4: ( (ret= primary_people_persondefinition ) ( ( ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) ) ) | ) )
            {
            // ./scenariotestTemp/generated2/People.g:298:4: ( (ret= primary_people_persondefinition ) ( ( ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) ) ) | ) )
            // ./scenariotestTemp/generated2/People.g:298:6: (ret= primary_people_persondefinition ) ( ( ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) ) ) | )
            {
            // ./scenariotestTemp/generated2/People.g:298:6: (ret= primary_people_persondefinition )
            // ./scenariotestTemp/generated2/People.g:298:8: ret= primary_people_persondefinition
            {
            pushFollow(FOLLOW_primary_people_persondefinition_in_persondefinitions_priority_0707);
            ret=primary_people_persondefinition();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            // ./scenariotestTemp/generated2/People.g:299:2: ( ( ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) ) ) | )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==STAR) ) {
                alt20=1;
            }
            else if ( (LA20_0==EOF||LA20_0==NAME||(LA20_0>=LPAREN && LA20_0<=RPAREN)) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ./scenariotestTemp/generated2/People.g:300:1: ( ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) ) )
                    {
                    // ./scenariotestTemp/generated2/People.g:300:1: ( ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) ) )
                    // ./scenariotestTemp/generated2/People.g:300:2: ( ( STAR ) () )=> ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) )
                    {
                    // ./scenariotestTemp/generated2/People.g:300:14: ( STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) ) )
                    // ./scenariotestTemp/generated2/People.g:300:15: STAR ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpSeq("*", 1, true);
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,STAR,FOLLOW_STAR_in_persondefinitions_priority_0724); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      opName = "*";
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    // ./scenariotestTemp/generated2/People.g:300:96: ( (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] ) )
                    // ./scenariotestTemp/generated2/People.g:300:97: (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] )
                    {
                    // ./scenariotestTemp/generated2/People.g:300:97: (ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken] )
                    // ./scenariotestTemp/generated2/People.g:300:98: ret= people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken]
                    {
                    pushFollow(FOLLOW_people_nestedpersondefinition_People_NestedPersonDefinition_starOp_in_persondefinitions_priority_0732);
                    ret=people_nestedpersondefinition_People_NestedPersonDefinition_starOp(opName, ret, firstToken);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      this.setLocationAndComment(ret, firstToken);

                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                      _exitOpSeq();
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/People.g:303:1: 
                    {
                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "persondefinitions_priority_0"


    // $ANTLR start "people_persondefinition"
    // ./scenariotestTemp/generated2/People.g:311:1: people_persondefinition returns [Object ret2] : ret= persondefinitions_priority_0 ;
    public final Object people_persondefinition() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/People.g:312:3: (ret= persondefinitions_priority_0 )
            // ./scenariotestTemp/generated2/People.g:313:3: ret= persondefinitions_priority_0
            {
            pushFollow(FOLLOW_persondefinitions_priority_0_in_people_persondefinition772);
            ret=persondefinitions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
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
    // $ANTLR end "people_persondefinition"


    // $ANTLR start "people_concretepersondefinition"
    // ./scenariotestTemp/generated2/People.g:320:1: people_concretepersondefinition returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object people_concretepersondefinition() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("People","ConcretePersonDefinition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/People.g:325:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/People.g:326:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/People.g:326:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/People.g:326:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/People.g:326:21: (temp= identifier )
            // ./scenariotestTemp/generated2/People.g:326:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_people_concretepersondefinition805);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "person", list("People","Person"), "name", temp, null, "never", null, false, null);
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
    // $ANTLR end "people_concretepersondefinition"


    // $ANTLR start "people_nestedpersondefinition_People_NestedPersonDefinition_starOp"
    // ./scenariotestTemp/generated2/People.g:334:1: people_nestedpersondefinition_People_NestedPersonDefinition_starOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : () ;
    public final Object people_nestedpersondefinition_People_NestedPersonDefinition_starOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("People","NestedPersonDefinition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/People.g:339:3: ( () )
            // ./scenariotestTemp/generated2/People.g:340:3: ()
            {
            // ./scenariotestTemp/generated2/People.g:340:3: ()
            // ./scenariotestTemp/generated2/People.g:340:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "lowerMultiplicity", 0);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "upperMultiplicity", -1);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              setProperty(ret,"op" , opName);
              setProperty(ret,"nestedDefinition" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


            }

            }

        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "people_nestedpersondefinition_People_NestedPersonDefinition_starOp"

    // $ANTLR start synpred4_People
    public final void synpred4_People_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/People.g:233:4: (~ WORLD )
        // ./scenariotestTemp/generated2/People.g:233:5: ~ WORLD
        {
        if ( input.LA(1)==NAME||(input.LA(1)>=LPAREN && input.LA(1)<=32) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred4_People

    // Delegated rules

    public final boolean synpred4_People() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_People_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_people_world_in_main97 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORLD_in_people_world137 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_people_world141 = new BitSet(new long[]{0x0000000001200010L});
    public static final BitSet FOLLOW_people_nation_in_people_world148 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_people_world156 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_people_nation_in_people_world163 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_people_world174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_people_world194 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_people_world197 = new BitSet(new long[]{0x0000000001200010L});
    public static final BitSet FOLLOW_people_nation_in_people_world204 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_people_world212 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_people_nation_in_people_world219 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_people_world230 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_people_world233 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_people_persondefinition_in_people_world240 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_people_persondefinition_in_people_world248 = new BitSet(new long[]{0x0000000000000052L});
    public static final BitSet FOLLOW_identifier_in_people_nation305 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_people_nation313 = new BitSet(new long[]{0x000000000A000010L});
    public static final BitSet FOLLOW_people_city_in_people_nation320 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_20_in_people_nation328 = new BitSet(new long[]{0x0000000008000010L});
    public static final BitSet FOLLOW_people_city_in_people_nation335 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_25_in_people_nation346 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_people_nation349 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_people_nation356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_people_city405 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_people_city413 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_people_person_in_people_city420 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_20_in_people_city428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_people_person_in_people_city435 = new BitSet(new long[]{0x0000000010100000L});
    public static final BitSet FOLLOW_28_in_people_city446 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_people_city455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_people_city462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_people_person522 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_people_person528 = new BitSet(new long[]{0x0000000108000012L});
    public static final BitSet FOLLOW_identifier_in_people_person535 = new BitSet(new long[]{0x0000000108000002L});
    public static final BitSet FOLLOW_27_in_people_person549 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_people_person552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_people_person559 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_people_person565 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_people_person587 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_people_person594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_people_concretepersondefinition_in_primary_people_persondefinition650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_people_persondefinition659 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_people_persondefinition_in_primary_people_persondefinition665 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RPAREN_in_primary_people_persondefinition669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_people_persondefinition_in_persondefinitions_priority_0707 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_STAR_in_persondefinitions_priority_0724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_people_nestedpersondefinition_People_NestedPersonDefinition_starOp_in_persondefinitions_priority_0732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_persondefinitions_priority_0_in_people_persondefinition772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_people_concretepersondefinition805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred4_People184 = new BitSet(new long[]{0x0000000000000002L});

}