// $ANTLR 3.1.1 ./scenariotestTemp/generated2/BibtextForcedLower.g 2010-11-04 23:31:01

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
public class BibtextForcedLowerParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "LCURLY", "COMA", "RCURLY", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "STRING", "'article'", "'author'", "'='", "'.'", "'year'"
    };
    public static final int ESC=14;
    public static final int T__20=20;
    public static final int LCURLY=5;
    public static final int EOF=-1;
    public static final int COMA=6;
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


        public BibtextForcedLowerParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtextForcedLowerParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtextForcedLowerParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/BibtextForcedLower.g"; }


       private static final String syntaxUUID = "BibtextForcedLower";
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
    // ./scenariotestTemp/generated2/BibtextForcedLower.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/BibtextForcedLower.g:217:1: main returns [Object ret2] : ( (ret= bibtext_bibtextfile ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:218:3: ( ( (ret= bibtext_bibtextfile ) EOF ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:219:3: ( (ret= bibtext_bibtextfile ) EOF )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:219:3: ( (ret= bibtext_bibtextfile ) EOF )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:219:4: (ret= bibtext_bibtextfile ) EOF
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:219:4: (ret= bibtext_bibtextfile )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:219:5: ret= bibtext_bibtextfile
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
    // ./scenariotestTemp/generated2/BibtextForcedLower.g:226:1: bibtext_bibtextfile returns [Object ret2] : ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ ) ) ) ) ;
    public final Object bibtext_bibtextfile() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","BibTextFile");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:231:3: ( ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ ) ) ) ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:3: ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ ) ) ) )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:3: ( ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ ) ) ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:4: ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:21: ( ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ ) ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:22: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ ) )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:22: ( (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:23: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:40: (temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+ )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:42: temp= bibtext_bibtextentry (temp= bibtext_bibtextentry ) (temp= bibtext_bibtextentry )+
            {
            pushFollow(FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile138);
            temp=bibtext_bibtextentry();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "entries", temp);
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:105: (temp= bibtext_bibtextentry )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:107: temp= bibtext_bibtextentry
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

            // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:171: (temp= bibtext_bibtextentry )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=16 && LA1_0<=17)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/BibtextForcedLower.g:232:173: temp= bibtext_bibtextentry
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

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ret2;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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
    // ./scenariotestTemp/generated2/BibtextForcedLower.g:240:1: bibtext_bibtextentry returns [Object ret2] : (ret= bibtext_article | ret= bibtext_author ) ;
    public final Object bibtext_bibtextentry() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:241:3: ( (ret= bibtext_article | ret= bibtext_author ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:242:3: (ret= bibtext_article | ret= bibtext_author )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:242:3: (ret= bibtext_article | ret= bibtext_author )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==17) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextForcedLower.g:242:4: ret= bibtext_article
                    {
                    pushFollow(FOLLOW_bibtext_article_in_bibtext_bibtextentry200);
                    ret=bibtext_article();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/BibtextForcedLower.g:243:5: ret= bibtext_author
                    {
                    pushFollow(FOLLOW_bibtext_author_in_bibtext_bibtextentry208);
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
    // ./scenariotestTemp/generated2/BibtextForcedLower.g:250:1: bibtext_article returns [Object ret2] : ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY ) ;
    public final Object bibtext_article() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Article");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:255:3: ( ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:3: ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:3: ( 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:4: 'article' LCURLY ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,16,FOLLOW_16_in_bibtext_article238); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtext_article242); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:104: ( ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:105: ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:105: ( (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )? )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:106: (temp= identifier ) COMA (temp= identifier ) COMA (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:123: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:125: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article253);
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
            match(input,COMA,FOLLOW_COMA_in_bibtext_article260); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:246: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:248: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_article268);
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
            match(input,COMA,FOLLOW_COMA_in_bibtext_article275); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:435: (temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:437: temp= bibtext_attribute ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )? ( ( COMA ) temp= bibtext_attribute )?
                    {
                    pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article283);
                    temp=bibtext_attribute();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "attributes", temp);
                    }
                    // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:500: ( ( COMA ) temp= bibtext_attribute )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==COMA) ) {
                        int LA3_1 = input.LA(2);

                        if ( (LA3_1==20) ) {
                            int LA3_3 = input.LA(3);

                            if ( (LA3_3==18) ) {
                                int LA3_4 = input.LA(4);

                                if ( (LA3_4==NAME) ) {
                                    int LA3_5 = input.LA(5);

                                    if ( (synpred3_BibtextForcedLower()) ) {
                                        alt3=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt3) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:501: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:518: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:519: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article292); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article300);
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

                    // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:641: ( ( COMA ) temp= bibtext_attribute )?
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

                                    if ( (synpred4_BibtextForcedLower()) ) {
                                        alt4=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt4) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:642: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:659: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:660: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article311); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article319);
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

                    // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:782: ( ( COMA ) temp= bibtext_attribute )?
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

                                    if ( (synpred5_BibtextForcedLower()) ) {
                                        alt5=1;
                                    }
                                }
                            }
                        }
                    }
                    switch (alt5) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:783: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:800: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:801: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article330); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article338);
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

                    // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:923: ( ( COMA ) temp= bibtext_attribute )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==COMA) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:924: ( COMA ) temp= bibtext_attribute
                            {
                            if ( state.backtracking==0 ) {
                              _enterSepSeq();
                            }
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:941: ( COMA )
                            // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:942: COMA
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_bibtext_article349); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitSepSeq();
                            }
                            pushFollow(FOLLOW_bibtext_attribute_in_bibtext_article357);
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
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtext_article371); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/BibtextForcedLower.g:264:1: bibtext_attribute returns [Object ret2] : (ret= bibtext_year ) ;
    public final Object bibtext_attribute() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:265:3: ( (ret= bibtext_year ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:266:3: (ret= bibtext_year )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:266:3: (ret= bibtext_year )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:266:4: ret= bibtext_year
            {
            pushFollow(FOLLOW_bibtext_year_in_bibtext_attribute409);
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
    // ./scenariotestTemp/generated2/BibtextForcedLower.g:273:1: bibtext_author returns [Object ret2] : ( 'author' '=' (temp= identifier ) '.' ) ;
    public final Object bibtext_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Author");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:278:3: ( ( 'author' '=' (temp= identifier ) '.' ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:279:3: ( 'author' '=' (temp= identifier ) '.' )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:279:3: ( 'author' '=' (temp= identifier ) '.' )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:279:4: 'author' '=' (temp= identifier ) '.'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,17,FOLLOW_17_in_bibtext_author439); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,18,FOLLOW_18_in_bibtext_author442); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:279:98: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:279:100: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_author449);
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
            match(input,19,FOLLOW_19_in_bibtext_author455); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/BibtextForcedLower.g:287:1: bibtext_year returns [Object ret2] : ( 'year' '=' (temp= identifier ) ) ;
    public final Object bibtext_year() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("BibText","Year");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:292:3: ( ( 'year' '=' (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:293:3: ( 'year' '=' (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:293:3: ( 'year' '=' (temp= identifier ) )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:293:4: 'year' '=' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_bibtext_year495); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,18,FOLLOW_18_in_bibtext_year498); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:293:96: (temp= identifier )
            // ./scenariotestTemp/generated2/BibtextForcedLower.g:293:98: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtext_year505);
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

    // $ANTLR start synpred3_BibtextForcedLower
    public final void synpred3_BibtextForcedLower_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:501: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:501: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:518: ( COMA )
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:519: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred3_BibtextForcedLower292); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred3_BibtextForcedLower300);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_BibtextForcedLower

    // $ANTLR start synpred4_BibtextForcedLower
    public final void synpred4_BibtextForcedLower_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:642: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:642: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:659: ( COMA )
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:660: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred4_BibtextForcedLower311); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred4_BibtextForcedLower319);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_BibtextForcedLower

    // $ANTLR start synpred5_BibtextForcedLower
    public final void synpred5_BibtextForcedLower_fragment() throws RecognitionException {   
        Object temp = null;


        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:783: ( ( COMA ) temp= bibtext_attribute )
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:783: ( COMA ) temp= bibtext_attribute
        {
        if ( state.backtracking==0 ) {
          _enterSepSeq();
        }
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:800: ( COMA )
        // ./scenariotestTemp/generated2/BibtextForcedLower.g:256:801: COMA
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl();
        }
        match(input,COMA,FOLLOW_COMA_in_synpred5_BibtextForcedLower330); if (state.failed) return ;

        }

        pushFollow(FOLLOW_bibtext_attribute_in_synpred5_BibtextForcedLower338);
        temp=bibtext_attribute();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_BibtextForcedLower

    // Delegated rules

    public final boolean synpred4_BibtextForcedLower() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_BibtextForcedLower_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_BibtextForcedLower() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_BibtextForcedLower_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_BibtextForcedLower() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_BibtextForcedLower_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile138 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile146 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_bibtext_bibtextentry_in_bibtext_bibtextfile155 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_bibtext_article_in_bibtext_bibtextentry200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_author_in_bibtext_bibtextentry208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_bibtext_article238 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LCURLY_in_bibtext_article242 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article253 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_article268 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article275 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article283 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article292 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article300 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article311 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article319 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article330 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article338 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_COMA_in_bibtext_article349 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_bibtext_article357 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtext_article371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_year_in_bibtext_attribute409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_bibtext_author439 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_bibtext_author442 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_author449 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_bibtext_author455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_bibtext_year495 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_bibtext_year498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtext_year505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred3_BibtextForcedLower292 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred3_BibtextForcedLower300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred4_BibtextForcedLower311 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred4_BibtextForcedLower319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred5_BibtextForcedLower330 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_bibtext_attribute_in_synpred5_BibtextForcedLower338 = new BitSet(new long[]{0x0000000000000002L});

}