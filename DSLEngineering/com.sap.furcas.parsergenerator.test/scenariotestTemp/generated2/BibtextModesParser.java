// $ANTLR 3.1.1 ./scenariotestTemp/generated2/BibtextModes.g 2010-11-04 23:27:50

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
public class BibtextModesParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "LCURLY", "COMA", "RCURLY", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "INT", "FLOAT", "STRING", "'article'", "';'", "'author'", "'='"
    };
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


        public BibtextModesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtextModesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtextModesParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/BibtextModes.g"; }


       private static final String syntaxUUID = "BibtextModes";
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
    // ./scenariotestTemp/generated2/BibtextModes.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/BibtextModes.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/BibtextModes.g:217:1: main returns [Object ret2] : ( (ret= bibtext_bibtextfile ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:218:3: ( ( (ret= bibtext_bibtextfile ) EOF ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:219:3: ( (ret= bibtext_bibtextfile ) EOF )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:219:3: ( (ret= bibtext_bibtextfile ) EOF )
            // ./scenariotestTemp/generated2/BibtextModes.g:219:4: (ret= bibtext_bibtextfile ) EOF
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:219:4: (ret= bibtext_bibtextfile )
            // ./scenariotestTemp/generated2/BibtextModes.g:219:5: ret= bibtext_bibtextfile
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
    // ./scenariotestTemp/generated2/BibtextModes.g:226:1: bibtext_bibtextfile returns [Object ret2] : ( ( ( ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) ) ) ;
    public final Object bibtext_bibtextfile() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","BibTextFile");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:231:3: ( ( ( ( ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) ) ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:232:3: ( ( ( ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) ) )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:232:3: ( ( ( ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:232:4: ( ( ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextModes.g:232:21: ( ( ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:232:22: ( ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:232:22: ( ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:232:23: ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextModes.g:232:41: ( ( (temp= bibtext_bibtextentry_single ) ) | ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 18:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==LCURLY) ) {
                    int LA3_4 = input.LA(3);

                    if ( (LA3_4==NAME) ) {
                        int LA3_6 = input.LA(4);

                        if ( (LA3_6==COMA) ) {
                            alt3=2;
                        }
                        else if ( (LA3_6==RCURLY) ) {
                            alt3=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case 20:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==21) ) {
                    int LA3_5 = input.LA(3);

                    if ( (LA3_5==NAME) ) {
                        int LA3_7 = input.LA(4);

                        if ( (LA3_7==19) ) {
                            alt3=2;
                        }
                        else if ( (LA3_7==EOF) ) {
                            alt3=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 7, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 5, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case EOF:
                {
                alt3=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:42: ( (temp= bibtext_bibtextentry_single ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:58: ( (temp= bibtext_bibtextentry_single ) )
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:59: (temp= bibtext_bibtextentry_single )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:76: (temp= bibtext_bibtextentry_single )
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:78: temp= bibtext_bibtextentry_single
                    {
                    pushFollow(FOLLOW_bibtext_bibtextentry_single_in_bibtext_bibtextfile144);
                    temp=bibtext_bibtextentry_single();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
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
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:182: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:198: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? )
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:199: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/BibtextModes.g:232:216: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==18||LA2_0==20) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextModes.g:232:218: temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )*
                            {
                            pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile163);
                            temp=bibtext_bibtextentry();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "entries", temp);
                            }
                            // ./scenariotestTemp/generated2/BibtextModes.g:232:281: (temp= bibtext_bibtextentry )*
                            loop1:
                            do {
                                int alt1=2;
                                int LA1_0 = input.LA(1);

                                if ( (LA1_0==18||LA1_0==20) ) {
                                    alt1=1;
                                }


                                switch (alt1) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/BibtextModes.g:232:283: temp= bibtext_bibtextentry
                            	    {
                            	    pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile171);
                            	    temp=bibtext_bibtextentry();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "entries", temp);
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
    // ./scenariotestTemp/generated2/BibtextModes.g:241:1: bibtext_bibtextentry returns [Object ret2] : (ret= bibtext_article | ret= bibtext_author ) ;
    public final Object bibtext_bibtextentry() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:242:3: ( (ret= bibtext_article | ret= bibtext_author ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:243:3: (ret= bibtext_article | ret= bibtext_author )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:243:3: (ret= bibtext_article | ret= bibtext_author )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            else if ( (LA4_0==20) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextModes.g:243:4: ret= bibtext_article
                    {
                    pushFollow(FOLLOW_bibtext_article_in_bibtext_bibtextentry225);
                    ret=bibtext_article();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/BibtextModes.g:244:5: ret= bibtext_author
                    {
                    pushFollow(FOLLOW_bibtext_author_in_bibtext_bibtextentry233);
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


    // $ANTLR start "bibtext_bibtextentry_single"
    // ./scenariotestTemp/generated2/BibtextModes.g:251:1: bibtext_bibtextentry_single returns [Object ret2] : (ret= bibtext_article_single | ret= bibtext_author_single ) ;
    public final Object bibtext_bibtextentry_single() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:252:3: ( (ret= bibtext_article_single | ret= bibtext_author_single ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:253:3: (ret= bibtext_article_single | ret= bibtext_author_single )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:253:3: (ret= bibtext_article_single | ret= bibtext_author_single )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            else if ( (LA5_0==20) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextModes.g:253:4: ret= bibtext_article_single
                    {
                    pushFollow(FOLLOW_bibtext_article_single_in_bibtext_bibtextentry_single260);
                    ret=bibtext_article_single();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/BibtextModes.g:254:5: ret= bibtext_author_single
                    {
                    pushFollow(FOLLOW_bibtext_author_single_in_bibtext_bibtextentry_single268);
                    ret=bibtext_author_single();

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
    // $ANTLR end "bibtext_bibtextentry_single"


    // $ANTLR start "bibtext_article"
    // ./scenariotestTemp/generated2/BibtextModes.g:261:1: bibtext_article returns [Object ret2] : ( 'article' LCURLY (temp= identifier ) COMA (temp= identifier ) RCURLY ';' ) ;
    public final Object bibtext_article() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Article");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:266:3: ( ( 'article' LCURLY (temp= identifier ) COMA (temp= identifier ) RCURLY ';' ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:267:3: ( 'article' LCURLY (temp= identifier ) COMA (temp= identifier ) RCURLY ';' )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:267:3: ( 'article' LCURLY (temp= identifier ) COMA (temp= identifier ) RCURLY ';' )
            // ./scenariotestTemp/generated2/BibtextModes.g:267:4: 'article' LCURLY (temp= identifier ) COMA (temp= identifier ) RCURLY ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,18,FOLLOW_18_in_bibtext_article298); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtext_article302); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextModes.g:267:104: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextModes.g:267:106: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article310);
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
            match(input,COMA,FOLLOW_COMA_in_bibtext_article317); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextModes.g:267:227: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextModes.g:267:229: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article325);
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
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtext_article332); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,19,FOLLOW_19_in_bibtext_article336); if (state.failed) return ret2;
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


    // $ANTLR start "bibtext_author"
    // ./scenariotestTemp/generated2/BibtextModes.g:275:1: bibtext_author returns [Object ret2] : ( 'author' '=' (temp= identifier ) ';' ) ;
    public final Object bibtext_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Author");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:280:3: ( ( 'author' '=' (temp= identifier ) ';' ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:281:3: ( 'author' '=' (temp= identifier ) ';' )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:281:3: ( 'author' '=' (temp= identifier ) ';' )
            // ./scenariotestTemp/generated2/BibtextModes.g:281:4: 'author' '=' (temp= identifier ) ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_bibtext_author376); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,21,FOLLOW_21_in_bibtext_author379); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextModes.g:281:98: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextModes.g:281:100: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_author386);
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
            match(input,19,FOLLOW_19_in_bibtext_author392); if (state.failed) return ret2;
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


    // $ANTLR start "bibtext_article_single"
    // ./scenariotestTemp/generated2/BibtextModes.g:289:1: bibtext_article_single returns [Object ret2] : ( 'article' LCURLY (temp= identifier ) RCURLY ) ;
    public final Object bibtext_article_single() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Article");
        onEnterTemplateRule(metaType,"single");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:294:3: ( ( 'article' LCURLY (temp= identifier ) RCURLY ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:295:3: ( 'article' LCURLY (temp= identifier ) RCURLY )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:295:3: ( 'article' LCURLY (temp= identifier ) RCURLY )
            // ./scenariotestTemp/generated2/BibtextModes.g:295:4: 'article' LCURLY (temp= identifier ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,18,FOLLOW_18_in_bibtext_article_single432); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtext_article_single436); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextModes.g:295:104: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextModes.g:295:106: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article_single444);
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
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtext_article_single451); if (state.failed) return ret2;
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
    // $ANTLR end "bibtext_article_single"


    // $ANTLR start "bibtext_author_single"
    // ./scenariotestTemp/generated2/BibtextModes.g:303:1: bibtext_author_single returns [Object ret2] : ( 'author' '=' (temp= identifier ) ) ;
    public final Object bibtext_author_single() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Author");
        onEnterTemplateRule(metaType,"single");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextModes.g:308:3: ( ( 'author' '=' (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:309:3: ( 'author' '=' (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/BibtextModes.g:309:3: ( 'author' '=' (temp= identifier ) )
            // ./scenariotestTemp/generated2/BibtextModes.g:309:4: 'author' '=' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_bibtext_author_single492); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,21,FOLLOW_21_in_bibtext_author_single495); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextModes.g:309:98: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextModes.g:309:100: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_author_single502);
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
    // $ANTLR end "bibtext_author_single"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextfile_in_main97 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_single_in_bibtext_bibtextfile144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile163 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile171 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_bibtext_article_in_bibtext_bibtextentry225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_author_in_bibtext_bibtextentry233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_article_single_in_bibtext_bibtextentry_single260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_author_single_in_bibtext_bibtextentry_single268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_bibtext_article298 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LCURLY_in_bibtext_article302 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article310 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article317 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article325 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtext_article332 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_bibtext_article336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_bibtext_author376 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_bibtext_author379 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_author386 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_bibtext_author392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_bibtext_article_single432 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LCURLY_in_bibtext_article_single436 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article_single444 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtext_article_single451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_bibtext_author_single492 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_bibtext_author_single495 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_author_single502 = new BitSet(new long[]{0x0000000000000002L});

}