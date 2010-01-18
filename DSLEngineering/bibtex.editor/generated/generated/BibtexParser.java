// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g 2009-12-22 13:24:47

package generated;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.PredicateSemantic;
import com.sap.mi.textual.moinlookup.util.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class BibtexParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "INT", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "FLOAT", "STRING", "'Entries:'", "'{'", "'}'", "'Authors:'", "'@article'", "','", "'title'", "'='", "'author'", "'and'"
    };
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int ESC=12;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int FLOAT=13;
    public static final int INT=5;
    public static final int EOF=-1;
    public static final int ALPHA=10;
    public static final int T__19=19;
    public static final int NAME=4;
    public static final int T__16=16;
    public static final int WS=8;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int SNAME=11;
    public static final int T__17=17;
    public static final int NL=7;
    public static final int DIGIT=9;
    public static final int COMMENT=6;
    public static final int STRING=14;

    // delegates
    // delegators


        public BibtexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtexParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g"; }


       private static final String syntaxUUID = "E007956AFD9847E1EEF411DEA083F7908D1505E2";
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:208:3: ( (ast= NAME ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:209:3: (ast= NAME )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:209:3: (ast= NAME )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:209:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier69); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret =  ast.getText();

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


    // $ANTLR start "integerSymbol"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:217:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:218:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:219:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:219:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:219:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol100); if (state.failed) return ret2;
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


    // $ANTLR start "main"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:227:1: main returns [Object ret2] : ( (ret= bibtex_literaturedb ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:228:3: ( ( (ret= bibtex_literaturedb ) EOF ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:229:3: ( (ret= bibtex_literaturedb ) EOF )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:229:3: ( (ret= bibtex_literaturedb ) EOF )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:229:4: (ret= bibtex_literaturedb ) EOF
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:229:4: (ret= bibtex_literaturedb )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:229:5: ret= bibtex_literaturedb
            {
            pushFollow(FOLLOW_bibtex_literaturedb_in_main128);
            ret=bibtex_literaturedb();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main131); if (state.failed) return ret2;

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


    // $ANTLR start "bibtex_literaturedb"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:236:1: bibtex_literaturedb returns [Object ret2] : ( (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}' ) ;
    public final Object bibtex_literaturedb() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Bibtex","LiteratureDb");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:241:3: ( ( (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:3: ( (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:3: ( (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:4: (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD884251EEF411DEA687F7908D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:63: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_literaturedb166);
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
              _beforeSeqEl("E007956AFD88DE90EEF411DEBDB2F7908D1505E2");
            }
            match(input,15,FOLLOW_15_in_bibtex_literaturedb172); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD88DE91EEF411DE998DF7908D1505E2");
            }
            match(input,16,FOLLOW_16_in_bibtex_literaturedb175); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD88DE93EEF411DE89B6F7908D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:353: (temp= bibtex_entry (temp= bibtex_entry )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==19) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:355: temp= bibtex_entry (temp= bibtex_entry )*
                    {
                    pushFollow(FOLLOW_bibtex_entry_in_bibtex_literaturedb182);
                    temp=bibtex_entry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:410: (temp= bibtex_entry )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==19) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:412: temp= bibtex_entry
                    	    {
                    	    pushFollow(FOLLOW_bibtex_entry_in_bibtex_literaturedb190);
                    	    temp=bibtex_entry();

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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8905A0EEF411DEAF11F7908D1505E2");
            }
            match(input,17,FOLLOW_17_in_bibtex_literaturedb201); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8905A1EEF411DEB71FF7908D1505E2");
            }
            match(input,18,FOLLOW_18_in_bibtex_literaturedb204); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8905A2EEF411DEBFFEF7908D1505E2");
            }
            match(input,16,FOLLOW_16_in_bibtex_literaturedb207); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8905A4EEF411DE8BF7F7908D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:788: (temp= bibtex_author (temp= bibtex_author )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NAME) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:790: temp= bibtex_author (temp= bibtex_author )*
                    {
                    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb214);
                    temp=bibtex_author();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "authors", temp);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:846: (temp= bibtex_author )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NAME) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:242:848: temp= bibtex_author
                    	    {
                    	    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb222);
                    	    temp=bibtex_author();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "authors", temp);
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
              _beforeSeqEl("E007956AFD892CB0EEF411DEAC83F7908D1505E2");
            }
            match(input,17,FOLLOW_17_in_bibtex_literaturedb233); if (state.failed) return ret2;
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
    // $ANTLR end "bibtex_literaturedb"


    // $ANTLR start "bibtex_entry"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:250:1: bibtex_entry returns [Object ret2] : ( '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}' ) ;
    public final Object bibtex_entry() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Bibtex","Entry");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:255:3: ( ( '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:3: ( '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:3: ( '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:4: '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8BC4C0EEF411DECD4EF7908D1505E2");
            }
            match(input,19,FOLLOW_19_in_bibtex_entry273); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8BC4C1EEF411DE8AB8F7908D1505E2");
            }
            match(input,16,FOLLOW_16_in_bibtex_entry276); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8E5CD0EEF411DE9FFAF7908D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:226: ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:227: ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:227: ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:228: (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8BC4C3EEF411DE92C6F7908D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:287: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:289: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry286);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "id", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8BEBD0EEF411DECB6CF7908D1505E2");
            }
            match(input,20,FOLLOW_20_in_bibtex_entry292); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8BEBD1EEF411DEB090F7908D1505E2");
            }
            match(input,21,FOLLOW_21_in_bibtex_entry295); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8BEBD2EEF411DEBC76F7908D1505E2");
            }
            match(input,22,FOLLOW_22_in_bibtex_entry298); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8BEBD3EEF411DECB02F7908D1505E2");
            }
            match(input,16,FOLLOW_16_in_bibtex_entry301); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8BEBD5EEF411DE89E3F7908D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:728: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:730: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry308);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "title", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8C12E0EEF411DE93D5F7908D1505E2");
            }
            match(input,17,FOLLOW_17_in_bibtex_entry314); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8C12E1EEF411DE8679F7908D1505E2");
            }
            match(input,20,FOLLOW_20_in_bibtex_entry317); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8C12E2EEF411DE9313F7908D1505E2");
            }
            match(input,23,FOLLOW_23_in_bibtex_entry320); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8C12E3EEF411DEA877F7908D1505E2");
            }
            match(input,22,FOLLOW_22_in_bibtex_entry323); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8C12E4EEF411DEB0A7F7908D1505E2");
            }
            match(input,16,FOLLOW_16_in_bibtex_entry326); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8D2451EEF411DEA432F7908D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:1251: (temp= identifier ( ( 'and' ) temp= identifier )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:1253: temp= identifier ( ( 'and' ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_bibtex_entry333);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "authors", "name", temp, "OCL:Bibtex::Author.allInstances()->select(a|a.name=?)");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:1369: ( ( 'and' ) temp= identifier )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==24) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:1370: ( 'and' ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:1387: ( 'and' )
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:256:1388: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E007956AFD8C8810EEF411DE86E8F7908D1505E2");
                    	    }
                    	    match(input,24,FOLLOW_24_in_bibtex_entry341); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_bibtex_entry348);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setOclRef(ret, "authors", "name", temp, "OCL:Bibtex::Author.allInstances()->select(a|a.name=?)");
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
              _beforeSeqEl("E007956AFD8DC090EEF411DE9B7BF7908D1505E2");
            }
            match(input,17,FOLLOW_17_in_bibtex_entry359); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD8F2020EEF411DEC9C7F7908D1505E2");
            }
            match(input,17,FOLLOW_17_in_bibtex_entry365); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD93B400EEF411DEA74DF7908D1505E2");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "literturedb", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // $ANTLR end "bibtex_entry"


    // $ANTLR start "bibtex_author"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:264:1: bibtex_author returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object bibtex_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Bibtex","Author");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:269:3: ( ( (temp= identifier ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:270:3: ( (temp= identifier ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:270:3: ( (temp= identifier ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:270:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E007956AFD951391EEF411DEB522F7908D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:270:63: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\Bibtex.g:270:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_author412);
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
              _beforeSeqEl("E007956AFD953AA2EEF411DEBD6CF7908D1505E2");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "literturedb", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // $ANTLR end "bibtex_author"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtex_literaturedb_in_main128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_bibtex_literaturedb166 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_bibtex_literaturedb172 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_bibtex_literaturedb175 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_literaturedb182 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_literaturedb190 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_17_in_bibtex_literaturedb201 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_bibtex_literaturedb204 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_bibtex_literaturedb207 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_bibtex_author_in_bibtex_literaturedb214 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_bibtex_author_in_bibtex_literaturedb222 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_bibtex_literaturedb233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_bibtex_entry273 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_bibtex_entry276 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry286 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bibtex_entry292 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_bibtex_entry295 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_bibtex_entry298 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_bibtex_entry301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry308 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_bibtex_entry314 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bibtex_entry317 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_bibtex_entry320 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_bibtex_entry323 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_bibtex_entry326 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry333 = new BitSet(new long[]{0x0000000001020000L});
    public static final BitSet FOLLOW_24_in_bibtex_entry341 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry348 = new BitSet(new long[]{0x0000000001020000L});
    public static final BitSet FOLLOW_17_in_bibtex_entry359 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_bibtex_entry365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_bibtex_author412 = new BitSet(new long[]{0x0000000000000002L});

}