// $ANTLR 3.1.1 ./scenariotestTemp/generated2/BibtextWithFunction.g 2010-11-04 23:27:25

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
public class BibtextWithFunctionParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "COMA", "LCURLY", "RCURLY", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "STRING", "'article'", "'author'", "'='", "'.'", "'year'"
    };
    public static final int ESC=14;
    public static final int T__20=20;
    public static final int LCURLY=6;
    public static final int EOF=-1;
    public static final int COMA=5;
    public static final int ALPHA=12;
    public static final int T__19=19;
    public static final int NAME=4;
    public static final int T__16=16;
    public static final int WS=10;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int SNAME=13;
    public static final int RCURLY=7;
    public static final int NL=9;
    public static final int DIGIT=11;
    public static final int COMMENT=8;
    public static final int STRING=15;

    // delegates
    // delegators


        public BibtextWithFunctionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtextWithFunctionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtextWithFunctionParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/BibtextWithFunction.g"; }


       private static final String syntaxUUID = "BibtextWithFunction";
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
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:209:4: ast= NAME
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


    // $ANTLR start "addkey"
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:217:1: addkey[Object ret] : ( (temp= identifier ) COMA ) ;
    public final void addkey(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:218:3: ( ( (temp= identifier ) COMA ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:219:3: ( (temp= identifier ) COMA )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:219:3: ( (temp= identifier ) COMA )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:219:4: (temp= identifier ) COMA
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:219:21: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:219:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_addkey97);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ;
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
            match(input,COMA,FOLLOW_COMA_in_addkey104); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

                
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "addkey"


    // $ANTLR start "addkeyandauthor"
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:226:1: addkeyandauthor[Object ret] : ( addkey[ret] (temp= identifier ) COMA ) ;
    public final void addkeyandauthor(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:227:3: ( ( addkey[ret] (temp= identifier ) COMA ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:228:3: ( addkey[ret] (temp= identifier ) COMA )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:228:3: ( addkey[ret] (temp= identifier ) COMA )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:228:4: addkey[ret] (temp= identifier ) COMA
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            pushFollow(FOLLOW_addkey_in_addkeyandauthor129);
            addkey(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:228:65: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:228:67: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_addkeyandauthor137);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ;
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
            match(input,COMA,FOLLOW_COMA_in_addkeyandauthor144); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

                
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "addkeyandauthor"


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:235:1: main returns [Object ret2] : ( (ret= bibtext_bibtextfile ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:236:3: ( ( (ret= bibtext_bibtextfile ) EOF ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:237:3: ( (ret= bibtext_bibtextfile ) EOF )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:237:3: ( (ret= bibtext_bibtextfile ) EOF )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:237:4: (ret= bibtext_bibtextfile ) EOF
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:237:4: (ret= bibtext_bibtextfile )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:237:5: ret= bibtext_bibtextfile
            {
            pushFollow(FOLLOW_bibtext_bibtextfile_in_main173);
            ret=bibtext_bibtextfile();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main176); if (state.failed) return ret2;

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
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:244:1: bibtext_bibtextfile returns [Object ret2] : ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) ;
    public final Object bibtext_bibtextfile() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","BibTextFile");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:249:3: ( ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:3: ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:3: ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:4: ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:21: ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:22: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:22: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:23: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:40: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=16 && LA2_0<=17)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:42: temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )*
                    {
                    pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile214);
                    temp=bibtext_bibtextentry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                    }
                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:105: (temp= bibtext_bibtextentry )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=16 && LA1_0<=17)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/BibtextWithFunction.g:250:107: temp= bibtext_bibtextentry
                    	    {
                    	    pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile222);
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
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:258:1: bibtext_bibtextentry returns [Object ret2] : (ret= bibtext_article | ret= bibtext_author ) ;
    public final Object bibtext_bibtextentry() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:259:3: ( (ret= bibtext_article | ret= bibtext_author ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:260:3: (ret= bibtext_article | ret= bibtext_author )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:260:3: (ret= bibtext_article | ret= bibtext_author )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==17) ) {
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
                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:260:4: ret= bibtext_article
                    {
                    pushFollow(FOLLOW_bibtext_article_in_bibtext_bibtextentry270);
                    ret=bibtext_article();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:261:5: ret= bibtext_author
                    {
                    pushFollow(FOLLOW_bibtext_author_in_bibtext_bibtextentry278);
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
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:268:1: bibtext_article returns [Object ret2] : ( 'article' LCURLY ( ( addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY ) ;
    public final Object bibtext_article() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Article");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:273:3: ( ( 'article' LCURLY ( ( addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:3: ( 'article' LCURLY ( ( addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:3: ( 'article' LCURLY ( ( addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:4: 'article' LCURLY ( ( addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,16,FOLLOW_16_in_bibtext_article308); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtext_article312); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:104: ( ( addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:105: ( addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:105: ( addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:106: addkeyandauthor[ret] (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            pushFollow(FOLLOW_addkeyandauthor_in_bibtext_article319);
            addkeyandauthor(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:176: (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:178: temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )?
                    {
                    pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article327);
                    temp=bibtext_attribute();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "attributes", temp);
                    }
                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:241: ( ( COMA ) temp= bibtext_attribute )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==COMA) ) {
                        int LA4_1 = input.LA(2);

                        if ( (LA4_1==20) ) {
                            int LA4_3 = input.LA(3);

                            if ( (LA4_3==18) ) {
                                int LA4_4 = input.LA(4);

                                if ( (LA4_4==NAME) ) {
                                    int LA4_5 = input.LA(5);

                                    if ( (synpred4_BibtextWithFunction()) ) {
                                        alt4=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt4) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:242: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:259: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:260: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article336); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article344);
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

                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:382: ( ( COMA ) temp= bibtext_attribute )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==COMA) ) {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1==20) ) {
                            int LA5_3 = input.LA(3);

                            if ( (LA5_3==18) ) {
                                int LA5_4 = input.LA(4);

                                if ( (LA5_4==NAME) ) {
                                    int LA5_5 = input.LA(5);

                                    if ( (synpred5_BibtextWithFunction()) ) {
                                        alt5=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt5) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:383: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:400: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:401: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article355); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article363);
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

                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:523: ( ( COMA ) temp= bibtext_attribute )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==COMA) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==20) ) {
                            int LA6_3 = input.LA(3);

                            if ( (LA6_3==18) ) {
                                int LA6_4 = input.LA(4);

                                if ( (LA6_4==NAME) ) {
                                    int LA6_5 = input.LA(5);

                                    if ( (synpred6_BibtextWithFunction()) ) {
                                        alt6=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt6) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:524: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:541: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:542: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article374); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article382);
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

                    // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:664: ( ( COMA ) temp= bibtext_attribute )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==COMA) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:665: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:682: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:683: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article393); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article401);
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
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtext_article415); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:282:1: bibtext_attribute returns [Object ret2] : (ret= bibtext_year ) ;
    public final Object bibtext_attribute() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:283:3: ( (ret= bibtext_year ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:284:3: (ret= bibtext_year )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:284:3: (ret= bibtext_year )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:284:4: ret= bibtext_year
            {
            pushFollow(FOLLOW_bibtext_year_in_bibtext_attribute453);
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
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:291:1: bibtext_author returns [Object ret2] : ( 'author' '=' addkey[ret] (temp= identifier ) '.' ) ;
    public final Object bibtext_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Author");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:296:3: ( ( 'author' '=' addkey[ret] (temp= identifier ) '.' ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:297:3: ( 'author' '=' addkey[ret] (temp= identifier ) '.' )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:297:3: ( 'author' '=' addkey[ret] (temp= identifier ) '.' )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:297:4: 'author' '=' addkey[ret] (temp= identifier ) '.'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,17,FOLLOW_17_in_bibtext_author483); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,18,FOLLOW_18_in_bibtext_author486); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            pushFollow(FOLLOW_addkey_in_bibtext_author489);
            addkey(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:297:142: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:297:144: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_author497);
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
            match(input,19,FOLLOW_19_in_bibtext_author503); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/BibtextWithFunction.g:305:1: bibtext_year returns [Object ret2] : ( 'year' '=' (temp= identifier ) ) ;
    public final Object bibtext_year() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Year");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:310:3: ( ( 'year' '=' (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:311:3: ( 'year' '=' (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:311:3: ( 'year' '=' (temp= identifier ) )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:311:4: 'year' '=' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_bibtext_year543); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,18,FOLLOW_18_in_bibtext_year546); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:311:96: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextWithFunction.g:311:98: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_year553);
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

    // $ANTLR start synpred4_BibtextWithFunction
    public final void synpred4_BibtextWithFunction_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:242: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:242: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:259: ( COMA )
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:260: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred4_BibtextWithFunction336); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred4_BibtextWithFunction344);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_BibtextWithFunction

    // $ANTLR start synpred5_BibtextWithFunction
    public final void synpred5_BibtextWithFunction_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:383: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:383: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:400: ( COMA )
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:401: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred5_BibtextWithFunction355); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred5_BibtextWithFunction363);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_BibtextWithFunction

    // $ANTLR start synpred6_BibtextWithFunction
    public final void synpred6_BibtextWithFunction_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:524: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:524: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:541: ( COMA )
        // ./scenariotestTemp/generated2/BibtextWithFunction.g:274:542: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred6_BibtextWithFunction374); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred6_BibtextWithFunction382);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_BibtextWithFunction

    // Delegated rules

    public final boolean synpred5_BibtextWithFunction() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_BibtextWithFunction_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_BibtextWithFunction() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_BibtextWithFunction_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_BibtextWithFunction() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_BibtextWithFunction_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_identifier_in_addkey97 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COMA_in_addkey104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addkey_in_addkeyandauthor129 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_addkeyandauthor137 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_COMA_in_addkeyandauthor144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextfile_in_main173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile214 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile222 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_bibtext_article_in_bibtext_bibtextentry270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_author_in_bibtext_bibtextentry278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_bibtext_article308 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LCURLY_in_bibtext_article312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_addkeyandauthor_in_bibtext_article319 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article327 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article336 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article344 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article355 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article363 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article374 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article382 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article393 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article401 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtext_article415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_year_in_bibtext_attribute453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_bibtext_author483 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_bibtext_author486 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_addkey_in_bibtext_author489 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_author497 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_bibtext_author503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_bibtext_year543 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_bibtext_year546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_year553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred4_BibtextWithFunction336 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred4_BibtextWithFunction344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred5_BibtextWithFunction355 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred5_BibtextWithFunction363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred6_BibtextWithFunction374 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred6_BibtextWithFunction382 = new BitSet(new long[]{0x0000000000000002L});

}