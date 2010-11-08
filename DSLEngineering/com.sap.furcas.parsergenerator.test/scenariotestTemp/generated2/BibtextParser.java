// $ANTLR 3.1.1 ./scenariotestTemp/generated2/Bibtext.g 2010-11-04 23:31:03

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
public class BibtextParser extends ObservableInjectingParser {
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


        public BibtextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtextParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/Bibtext.g"; }


       private static final String syntaxUUID = "Bibtext";
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
    // ./scenariotestTemp/generated2/Bibtext.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/Bibtext.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/Bibtext.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/Bibtext.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/Bibtext.g:217:1: main returns [Object ret2] : ( (ret= bibtext_bibtextfile ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Bibtext.g:218:3: ( ( (ret= bibtext_bibtextfile ) EOF ) )
            // ./scenariotestTemp/generated2/Bibtext.g:219:3: ( (ret= bibtext_bibtextfile ) EOF )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:219:3: ( (ret= bibtext_bibtextfile ) EOF )
            // ./scenariotestTemp/generated2/Bibtext.g:219:4: (ret= bibtext_bibtextfile ) EOF
            {
            // ./scenariotestTemp/generated2/Bibtext.g:219:4: (ret= bibtext_bibtextfile )
            // ./scenariotestTemp/generated2/Bibtext.g:219:5: ret= bibtext_bibtextfile
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
    // ./scenariotestTemp/generated2/Bibtext.g:226:1: bibtext_bibtextfile returns [Object ret2] : ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) ;
    public final Object bibtext_bibtextfile() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","BibTextFile");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Bibtext.g:231:3: ( ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) ) )
            // ./scenariotestTemp/generated2/Bibtext.g:232:3: ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:232:3: ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) ) )
            // ./scenariotestTemp/generated2/Bibtext.g:232:4: ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Bibtext.g:232:21: ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? ) )
            // ./scenariotestTemp/generated2/Bibtext.g:232:22: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:232:22: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )? )
            // ./scenariotestTemp/generated2/Bibtext.g:232:23: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Bibtext.g:232:40: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=18 && LA2_0<=19)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/Bibtext.g:232:42: temp= bibtext_bibtextentry (temp= bibtext_bibtextentry )*
                    {
                    pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile138);
                    temp=bibtext_bibtextentry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                    }
                    // ./scenariotestTemp/generated2/Bibtext.g:232:105: (temp= bibtext_bibtextentry )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=18 && LA1_0<=19)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/Bibtext.g:232:107: temp= bibtext_bibtextentry
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
    // ./scenariotestTemp/generated2/Bibtext.g:240:1: bibtext_bibtextentry returns [Object ret2] : (ret= bibtext_article | ret= bibtext_author ) ;
    public final Object bibtext_bibtextentry() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Bibtext.g:241:3: ( (ret= bibtext_article | ret= bibtext_author ) )
            // ./scenariotestTemp/generated2/Bibtext.g:242:3: (ret= bibtext_article | ret= bibtext_author )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:242:3: (ret= bibtext_article | ret= bibtext_author )
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
                    // ./scenariotestTemp/generated2/Bibtext.g:242:4: ret= bibtext_article
                    {
                    pushFollow(FOLLOW_bibtext_article_in_bibtext_bibtextentry194);
                    ret=bibtext_article();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Bibtext.g:243:5: ret= bibtext_author
                    {
                    pushFollow(FOLLOW_bibtext_author_in_bibtext_bibtextentry202);
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
    // ./scenariotestTemp/generated2/Bibtext.g:250:1: bibtext_article returns [Object ret2] : ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY ) ;
    public final Object bibtext_article() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Article");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Bibtext.g:255:3: ( ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/Bibtext.g:256:3: ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:256:3: ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/Bibtext.g:256:4: 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,18,FOLLOW_18_in_bibtext_article232); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtext_article236); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Bibtext.g:256:104: ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) )
            // ./scenariotestTemp/generated2/Bibtext.g:256:105: ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:256:105: ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? )
            // ./scenariotestTemp/generated2/Bibtext.g:256:106: (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Bibtext.g:256:123: (temp= identifier )
            // ./scenariotestTemp/generated2/Bibtext.g:256:125: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article247);
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
            match(input,COMA,FOLLOW_COMA_in_bibtext_article254); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Bibtext.g:256:246: (temp= identifier )
            // ./scenariotestTemp/generated2/Bibtext.g:256:248: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article262);
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
            match(input,COMA,FOLLOW_COMA_in_bibtext_article269); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Bibtext.g:256:435: (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./scenariotestTemp/generated2/Bibtext.g:256:437: temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )?
                    {
                    pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article277);
                    temp=bibtext_attribute();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "attributes", temp);
                    }
                    // ./scenariotestTemp/generated2/Bibtext.g:256:500: ( ( COMA ) temp= bibtext_attribute )?
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

                                    if ( (synpred4_Bibtext()) ) {
                                        alt4=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt4) {
                        case 1 :
                            // ./scenariotestTemp/generated2/Bibtext.g:256:501: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/Bibtext.g:256:518: ( COMA )
                            // ./scenariotestTemp/generated2/Bibtext.g:256:519: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article286); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article294);
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

                    // ./scenariotestTemp/generated2/Bibtext.g:256:641: ( ( COMA ) temp= bibtext_attribute )?
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

                                    if ( (synpred5_Bibtext()) ) {
                                        alt5=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt5) {
                        case 1 :
                            // ./scenariotestTemp/generated2/Bibtext.g:256:642: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/Bibtext.g:256:659: ( COMA )
                            // ./scenariotestTemp/generated2/Bibtext.g:256:660: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article305); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article313);
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

                    // ./scenariotestTemp/generated2/Bibtext.g:256:782: ( ( COMA ) temp= bibtext_attribute )?
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

                                    if ( (synpred6_Bibtext()) ) {
                                        alt6=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt6) {
                        case 1 :
                            // ./scenariotestTemp/generated2/Bibtext.g:256:783: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/Bibtext.g:256:800: ( COMA )
                            // ./scenariotestTemp/generated2/Bibtext.g:256:801: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article324); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article332);
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

                    // ./scenariotestTemp/generated2/Bibtext.g:256:923: ( ( COMA ) temp= bibtext_attribute )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==COMA) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./scenariotestTemp/generated2/Bibtext.g:256:924: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/Bibtext.g:256:941: ( COMA )
                            // ./scenariotestTemp/generated2/Bibtext.g:256:942: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article343); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article351);
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
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtext_article365); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/Bibtext.g:264:1: bibtext_attribute returns [Object ret2] : (ret= bibtext_year ) ;
    public final Object bibtext_attribute() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Bibtext.g:265:3: ( (ret= bibtext_year ) )
            // ./scenariotestTemp/generated2/Bibtext.g:266:3: (ret= bibtext_year )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:266:3: (ret= bibtext_year )
            // ./scenariotestTemp/generated2/Bibtext.g:266:4: ret= bibtext_year
            {
            pushFollow(FOLLOW_bibtext_year_in_bibtext_attribute403);
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
    // ./scenariotestTemp/generated2/Bibtext.g:273:1: bibtext_author returns [Object ret2] : ( 'author' '=' (temp= identifier ) '.' ) ;
    public final Object bibtext_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Author");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Bibtext.g:278:3: ( ( 'author' '=' (temp= identifier ) '.' ) )
            // ./scenariotestTemp/generated2/Bibtext.g:279:3: ( 'author' '=' (temp= identifier ) '.' )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:279:3: ( 'author' '=' (temp= identifier ) '.' )
            // ./scenariotestTemp/generated2/Bibtext.g:279:4: 'author' '=' (temp= identifier ) '.'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,19,FOLLOW_19_in_bibtext_author433); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_bibtext_author436); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Bibtext.g:279:98: (temp= identifier )
            // ./scenariotestTemp/generated2/Bibtext.g:279:100: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_author443);
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
            match(input,21,FOLLOW_21_in_bibtext_author449); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/Bibtext.g:287:1: bibtext_year returns [Object ret2] : ( 'year' '=' (temp= identifier ) ) ;
    public final Object bibtext_year() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Year");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Bibtext.g:292:3: ( ( 'year' '=' (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/Bibtext.g:293:3: ( 'year' '=' (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/Bibtext.g:293:3: ( 'year' '=' (temp= identifier ) )
            // ./scenariotestTemp/generated2/Bibtext.g:293:4: 'year' '=' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,22,FOLLOW_22_in_bibtext_year489); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_bibtext_year492); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Bibtext.g:293:96: (temp= identifier )
            // ./scenariotestTemp/generated2/Bibtext.g:293:98: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_year499);
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

    // $ANTLR start synpred4_Bibtext
    public final void synpred4_Bibtext_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/Bibtext.g:256:501: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/Bibtext.g:256:501: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/Bibtext.g:256:518: ( COMA )
        // ./scenariotestTemp/generated2/Bibtext.g:256:519: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred4_Bibtext286); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred4_Bibtext294);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Bibtext

    // $ANTLR start synpred5_Bibtext
    public final void synpred5_Bibtext_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/Bibtext.g:256:642: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/Bibtext.g:256:642: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/Bibtext.g:256:659: ( COMA )
        // ./scenariotestTemp/generated2/Bibtext.g:256:660: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred5_Bibtext305); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred5_Bibtext313);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Bibtext

    // $ANTLR start synpred6_Bibtext
    public final void synpred6_Bibtext_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/Bibtext.g:256:783: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/Bibtext.g:256:783: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/Bibtext.g:256:800: ( COMA )
        // ./scenariotestTemp/generated2/Bibtext.g:256:801: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred6_Bibtext324); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred6_Bibtext332);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_Bibtext

    // Delegated rules

    public final boolean synpred4_Bibtext() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Bibtext_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_Bibtext() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Bibtext_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_Bibtext() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Bibtext_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_bibtext_bibtextfile_in_main97 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile138 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile146 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_bibtext_article_in_bibtext_bibtextentry194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_author_in_bibtext_bibtextentry202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_bibtext_article232 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LCURLY_in_bibtext_article236 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article247 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article254 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article262 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article269 = new BitSet(new long[]{0x0000000000400080L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article277 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article286 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article294 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article305 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article313 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article324 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article332 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article343 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article351 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtext_article365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_year_in_bibtext_attribute403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_bibtext_author433 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bibtext_author436 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_author443 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_bibtext_author449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_bibtext_year489 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bibtext_year492 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_year499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred4_Bibtext286 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred4_Bibtext294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred5_Bibtext305 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred5_Bibtext313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred6_Bibtext324 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred6_Bibtext332 = new BitSet(new long[]{0x0000000000000002L});

}