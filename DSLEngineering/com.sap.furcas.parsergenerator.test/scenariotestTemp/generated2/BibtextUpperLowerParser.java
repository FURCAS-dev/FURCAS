// $ANTLR 3.1.1 ./scenariotestTemp/generated2/BibtextUpperLower.g 2010-11-04 23:31:12

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
public class BibtextUpperLowerParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "LCURLY", "COMA", "RCURLY", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "INT", "FLOAT", "STRING", "'article'", "'author'", "'='", "'.'", "'year'"
    };
    public static final int T__22=22;
    public static final int ESC=14;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int LCURLY=5;
    public static final int FLOAT=16;
    public static final int INT=15;
    public static final int EOF=-1;
    public static final int COMA=6;
    public static final int ALPHA=12;
    public static final int T__19=19;
    public static final int NAME=4;
    public static final int WS=10;
    public static final int T__18=18;
    public static final int SNAME=13;
    public static final int RCURLY=7;
    public static final int NL=9;
    public static final int DIGIT=11;
    public static final int COMMENT=8;
    public static final int STRING=17;

    // delegates
    // delegators


        public BibtextUpperLowerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtextUpperLowerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtextUpperLowerParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/BibtextUpperLower.g"; }


       private static final String syntaxUUID = "BibtextUpperLower";
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
    // ./scenariotestTemp/generated2/BibtextUpperLower.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/BibtextUpperLower.g:217:1: main returns [Object ret2] : ( (ret= bibtext_bibtextfile ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:218:3: ( ( (ret= bibtext_bibtextfile ) EOF ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:219:3: ( (ret= bibtext_bibtextfile ) EOF )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:219:3: ( (ret= bibtext_bibtextfile ) EOF )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:219:4: (ret= bibtext_bibtextfile ) EOF
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:219:4: (ret= bibtext_bibtextfile )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:219:5: ret= bibtext_bibtextfile
            {
            pushFollow(FOLLOW_bibtext_bibtextfile_in_main97);
            ret=bibtext_bibtextfile();

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


    // $ANTLR start "bibtext_bibtextfile"
    // ./scenariotestTemp/generated2/BibtextUpperLower.g:226:1: bibtext_bibtextfile returns [Object ret2] : ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? ) ) ) ) ;
    public final Object bibtext_bibtextfile() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","BibTextFile");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:231:3: ( ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? ) ) ) ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:3: ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? ) ) ) )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:3: ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? ) ) ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:4: ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:21: ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? ) ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:22: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? ) )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:22: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:23: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:40: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )? )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:42: temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )? (temp= bibtext_bibtextentry )?
            {
            pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile138);
            temp=bibtext_bibtextentry();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "entries", temp);
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:105: (temp= bibtext_bibtextentry )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:107: temp= bibtext_bibtextentry
            {
            pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile146);
            temp=bibtext_bibtextentry();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "entries", temp);
            }

            }

            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:171: (temp= bibtext_bibtextentry )?
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:173: temp= bibtext_bibtextentry
                    {
                    pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile155);
                    temp=bibtext_bibtextentry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                    }

                    }
                    break;

            }

            // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:238: (temp= bibtext_bibtextentry )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=18 && LA2_0<=19)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:240: temp= bibtext_bibtextentry
                    {
                    pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile165);
                    temp=bibtext_bibtextentry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }


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
    // $ANTLR end "bibtext_bibtextfile"


    // $ANTLR start "bibtext_bibtextentry"
    // ./scenariotestTemp/generated2/BibtextUpperLower.g:240:1: bibtext_bibtextentry returns [Object ret2] : (ret= bibtext_article | ret= bibtext_author ) ;
    public final Object bibtext_bibtextentry() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:241:3: ( (ret= bibtext_article | ret= bibtext_author ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:242:3: (ret= bibtext_article | ret= bibtext_author )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:242:3: (ret= bibtext_article | ret= bibtext_author )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==18) ) {
                alt3=1;
            }
            else if ( (LA3_0==19) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:242:4: ret= bibtext_article
                    {
                    pushFollow(FOLLOW_bibtext_article_in_bibtext_bibtextentry210);
                    ret=bibtext_article();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:243:5: ret= bibtext_author
                    {
                    pushFollow(FOLLOW_bibtext_author_in_bibtext_bibtextentry218);
                    ret=bibtext_author();

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
    // $ANTLR end "bibtext_bibtextentry"


    // $ANTLR start "bibtext_article"
    // ./scenariotestTemp/generated2/BibtextUpperLower.g:250:1: bibtext_article returns [Object ret2] : ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY ) ;
    public final Object bibtext_article() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Article");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:255:3: ( ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:3: ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:3: ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:4: 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,18,FOLLOW_18_in_bibtext_article248); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtext_article252); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:104: ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:105: ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:105: ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:106: (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:123: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:125: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article263);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "key", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COMA,FOLLOW_COMA_in_bibtext_article270); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:246: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:248: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article278);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "author", list("BibText","Author"), "name", temp, null, "never", null, false, null);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COMA,FOLLOW_COMA_in_bibtext_article285); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:435: (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:437: temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )?
                    {
                    pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article293);
                    temp=bibtext_attribute();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "attributes", temp);
                    }
                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:500: ( ( COMA ) temp= bibtext_attribute )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==COMA) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==22) ) {
                            int LA4_3 = input.LA(3);

                            if ( (LA4_3==20) ) {
                                int LA4_4 = input.LA(4);

                                if ( (LA4_4==NAME) ) {
                                    int LA4_5 = input.LA(5);

                                    if ( (synpred4_BibtextUpperLower()) ) {
                                        alt4=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt4) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:501: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:518: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:519: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article302); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article310);
                            temp=bibtext_attribute();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "attributes", temp);
                            }

                            }
                            break;

                    }

                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:641: ( ( COMA ) temp= bibtext_attribute )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==COMA) ) {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1==22) ) {
                            int LA5_3 = input.LA(3);

                            if ( (LA5_3==20) ) {
                                int LA5_4 = input.LA(4);

                                if ( (LA5_4==NAME) ) {
                                    int LA5_5 = input.LA(5);

                                    if ( (synpred5_BibtextUpperLower()) ) {
                                        alt5=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt5) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:642: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:659: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:660: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article321); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article329);
                            temp=bibtext_attribute();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "attributes", temp);
                            }

                            }
                            break;

                    }

                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:782: ( ( COMA ) temp= bibtext_attribute )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==COMA) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==22) ) {
                            int LA6_3 = input.LA(3);

                            if ( (LA6_3==20) ) {
                                int LA6_4 = input.LA(4);

                                if ( (LA6_4==NAME) ) {
                                    int LA6_5 = input.LA(5);

                                    if ( (synpred6_BibtextUpperLower()) ) {
                                        alt6=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt6) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:783: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:800: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:801: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article340); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article348);
                            temp=bibtext_attribute();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "attributes", temp);
                            }

                            }
                            break;

                    }

                    // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:923: ( ( COMA ) temp= bibtext_attribute )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==COMA) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:924: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:941: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:942: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article359); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article367);
                            temp=bibtext_attribute();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "attributes", temp);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtext_article381); if (state.failed) return ret2;
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
    // $ANTLR end "bibtext_article"


    // $ANTLR start "bibtext_attribute"
    // ./scenariotestTemp/generated2/BibtextUpperLower.g:264:1: bibtext_attribute returns [Object ret2] : (ret= bibtext_year ) ;
    public final Object bibtext_attribute() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:265:3: ( (ret= bibtext_year ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:266:3: (ret= bibtext_year )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:266:3: (ret= bibtext_year )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:266:4: ret= bibtext_year
            {
            pushFollow(FOLLOW_bibtext_year_in_bibtext_attribute419);
            ret=bibtext_year();

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
    // $ANTLR end "bibtext_attribute"


    // $ANTLR start "bibtext_author"
    // ./scenariotestTemp/generated2/BibtextUpperLower.g:273:1: bibtext_author returns [Object ret2] : ( 'author' '=' (temp= identifier ) '.' ) ;
    public final Object bibtext_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Author");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:278:3: ( ( 'author' '=' (temp= identifier ) '.' ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:279:3: ( 'author' '=' (temp= identifier ) '.' )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:279:3: ( 'author' '=' (temp= identifier ) '.' )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:279:4: 'author' '=' (temp= identifier ) '.'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,19,FOLLOW_19_in_bibtext_author449); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_bibtext_author452); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:279:98: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:279:100: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_author459);
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
            match(input,21,FOLLOW_21_in_bibtext_author465); if (state.failed) return ret2;
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
    // $ANTLR end "bibtext_author"


    // $ANTLR start "bibtext_year"
    // ./scenariotestTemp/generated2/BibtextUpperLower.g:287:1: bibtext_year returns [Object ret2] : ( 'year' '=' (temp= identifier ) ) ;
    public final Object bibtext_year() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Year");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:292:3: ( ( 'year' '=' (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:293:3: ( 'year' '=' (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:293:3: ( 'year' '=' (temp= identifier ) )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:293:4: 'year' '=' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,22,FOLLOW_22_in_bibtext_year505); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_bibtext_year508); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:293:96: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextUpperLower.g:293:98: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_year515);
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
    // $ANTLR end "bibtext_year"

    // $ANTLR start synpred1_BibtextUpperLower
    public final void synpred1_BibtextUpperLower_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:173: (temp= bibtext_bibtextentry )
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:232:173: temp= bibtext_bibtextentry
        {
        pushFollow(FOLLOW_bibtext_bibtextentry_in_synpred1_BibtextUpperLower155);
        temp=bibtext_bibtextentry();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_BibtextUpperLower

    // $ANTLR start synpred4_BibtextUpperLower
    public final void synpred4_BibtextUpperLower_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:501: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:501: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:518: ( COMA )
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:519: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred4_BibtextUpperLower302); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred4_BibtextUpperLower310);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_BibtextUpperLower

    // $ANTLR start synpred5_BibtextUpperLower
    public final void synpred5_BibtextUpperLower_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:642: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:642: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:659: ( COMA )
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:660: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred5_BibtextUpperLower321); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred5_BibtextUpperLower329);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_BibtextUpperLower

    // $ANTLR start synpred6_BibtextUpperLower
    public final void synpred6_BibtextUpperLower_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:783: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:783: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:800: ( COMA )
        // ./scenariotestTemp/generated2/BibtextUpperLower.g:256:801: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred6_BibtextUpperLower340); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred6_BibtextUpperLower348);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_BibtextUpperLower

    // Delegated rules

    public final boolean synpred4_BibtextUpperLower() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_BibtextUpperLower_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_BibtextUpperLower() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_BibtextUpperLower_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_BibtextUpperLower() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_BibtextUpperLower_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_BibtextUpperLower() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_BibtextUpperLower_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\41\uffff";
    static final String DFA1_eofS =
        "\1\3\40\uffff";
    static final String DFA1_minS =
        "\1\22\1\5\1\24\1\uffff\2\4\1\6\1\25\1\4\1\0\1\6\1\uffff\1\7\1\24"+
        "\1\0\1\4\1\6\1\26\1\24\1\4\1\6\1\26\1\24\1\4\1\6\1\26\1\24\1\4\1"+
        "\6\1\26\1\24\1\4\1\7";
    static final String DFA1_maxS =
        "\1\23\1\5\1\24\1\uffff\2\4\1\6\1\25\1\4\1\0\1\6\1\uffff\1\26\1\24"+
        "\1\0\1\4\1\7\1\26\1\24\1\4\1\7\1\26\1\24\1\4\1\7\1\26\1\24\1\4\1"+
        "\7\1\26\1\24\1\4\1\7";
    static final String DFA1_acceptS =
        "\3\uffff\1\2\7\uffff\1\1\25\uffff";
    static final String DFA1_specialS =
        "\11\uffff\1\1\4\uffff\1\0\22\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1\1\2",
            "\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\uffff",
            "\1\14",
            "",
            "\1\16\16\uffff\1\15",
            "\1\17",
            "\1\uffff",
            "\1\20",
            "\1\21\1\16",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25\1\16",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31\1\16",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35\1\16",
            "\1\36",
            "\1\37",
            "\1\40",
            "\1\16"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "232:171: (temp= bibtext_bibtextentry )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA1_14 = input.LA(1);

                         
                        int index1_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_BibtextUpperLower()) ) {s = 11;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index1_14);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA1_9 = input.LA(1);

                         
                        int index1_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_BibtextUpperLower()) ) {s = 11;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index1_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextfile_in_main97 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile138 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile146 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile155 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_article_in_bibtext_bibtextentry210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_author_in_bibtext_bibtextentry218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_bibtext_article248 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LCURLY_in_bibtext_article252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article263 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article278 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article285 = new BitSet(new long[]{0x0000000000400080L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article293 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article302 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article310 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article321 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article329 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article340 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article348 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article359 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article367 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtext_article381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_year_in_bibtext_attribute419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_bibtext_author449 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bibtext_author452 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_author459 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_bibtext_author465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_bibtext_year505 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bibtext_year508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_year515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_synpred1_BibtextUpperLower155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred4_BibtextUpperLower302 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred4_BibtextUpperLower310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred5_BibtextUpperLower321 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred5_BibtextUpperLower329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred6_BibtextUpperLower340 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred6_BibtextUpperLower348 = new BitSet(new long[]{0x0000000000000002L});

}