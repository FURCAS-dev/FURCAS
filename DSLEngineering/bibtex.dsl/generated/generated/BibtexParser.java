// $ANTLR 3.1.1 C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g 2011-04-11 17:03:44

package generated;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.runtime.parser.impl.SemanticDisambRuleData;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;


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
    public String getGrammarFileName() { return "C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g"; }


       private static final String syntaxUUID = "_5Ly3oGRMEeCs1vUJxy3JEw";
       public String getSyntaxUUID() {
            return syntaxUUID;
       }
        public String unescapeString(String s) {
            // get rid of the starting and ending delimiters (e.g., '\'', '"')
           int delimLength = 1; // for delimLength > 0, the following code needs to change
           if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                    s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
           }
           if(s.contains("\\\"")) {
                    s = s.replaceAll("\\\\\"", "\"");
           }
           return s;
        }




    // $ANTLR start "identifier"
    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:103:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:104:3: ( (ast= NAME ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:105:3: (ast= NAME )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:105:3: (ast= NAME )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:105:4: ast= NAME
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
    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:113:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:114:3: ( (ast= INT ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:115:3: (ast= INT )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:115:3: (ast= INT )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:115:4: ast= INT
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
    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:123:1: main returns [Object ret2] : ( (ret= bibtex_literaturedb ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:124:3: ( ( (ret= bibtex_literaturedb ) EOF ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:125:3: ( (ret= bibtex_literaturedb ) EOF )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:125:3: ( (ret= bibtex_literaturedb ) EOF )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:125:4: (ret= bibtex_literaturedb ) EOF
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:125:4: (ret= bibtex_literaturedb )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:125:5: ret= bibtex_literaturedb
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
    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:132:1: bibtex_literaturedb returns [Object ret2] : ( (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}' ) ;
    public final Object bibtex_literaturedb() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","LiteratureDb");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:138:3: ( ( (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}' ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:139:3: ( (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}' )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:139:3: ( (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:139:4: (temp= identifier ) 'Entries:' '{' (temp= bibtex_entry (temp= bibtex_entry )* )? '}' 'Authors:' '{' (temp= bibtex_author (temp= bibtex_author )* )? '}'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.0");
            }
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:139:115: (temp= identifier )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:139:117: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_literaturedb166);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.1");
            }
            match(input,15,FOLLOW_15_in_bibtex_literaturedb172); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.2");
            }
            match(input,16,FOLLOW_16_in_bibtex_literaturedb175); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.3");
            }
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:140:424: (temp= bibtex_entry (temp= bibtex_entry )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==19) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:140:426: temp= bibtex_entry (temp= bibtex_entry )*
                    {
                    pushFollow(FOLLOW_bibtex_entry_in_bibtex_literaturedb182);
                    temp=bibtex_entry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                      setParent(temp,ret,"entries");
                    }
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:141:33: (temp= bibtex_entry )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==19) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:141:35: temp= bibtex_entry
                    	    {
                    	    pushFollow(FOLLOW_bibtex_entry_in_bibtex_literaturedb190);
                    	    temp=bibtex_entry();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "entries", temp);
                    	      setParent(temp,ret,"entries");
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.4");
            }
            match(input,17,FOLLOW_17_in_bibtex_literaturedb201); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.5");
            }
            match(input,18,FOLLOW_18_in_bibtex_literaturedb204); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.6");
            }
            match(input,16,FOLLOW_16_in_bibtex_literaturedb207); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.7");
            }
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:142:562: (temp= bibtex_author (temp= bibtex_author )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NAME) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:142:564: temp= bibtex_author (temp= bibtex_author )*
                    {
                    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb214);
                    temp=bibtex_author();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "author", temp);
                      setParent(temp,ret,"author");
                    }
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:143:32: (temp= bibtex_author )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NAME) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:143:34: temp= bibtex_author
                    	    {
                    	    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb222);
                    	    temp=bibtex_author();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "author", temp);
                    	      setParent(temp,ret,"author");
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.2/@templateSequence/@elements.8");
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
    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:152:1: bibtex_entry returns [Object ret2] : ( '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}' ) ;
    public final Object bibtex_entry() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Entry");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:158:3: ( ( '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}' ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:3: ( '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}' )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:3: ( '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:4: '@article' '{' ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) ) '}'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.0");
            }
            match(input,19,FOLLOW_19_in_bibtex_entry273); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.1");
            }
            match(input,16,FOLLOW_16_in_bibtex_entry276); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2");
            }
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:382: ( ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:383: ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:383: ( (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}' )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:384: (temp= identifier ) ',' 'title' '=' '{' (temp= identifier ) '}' ',' 'author' '=' '{' (temp= identifier ( ( 'and' ) temp= identifier )* )? '}'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.0");
            }
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:522: (temp= identifier )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:159:524: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry286);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "id", temp);
              setParent(temp,ret,"id");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.1");
            }
            match(input,20,FOLLOW_20_in_bibtex_entry292); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.2");
            }
            match(input,21,FOLLOW_21_in_bibtex_entry295); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.3");
            }
            match(input,22,FOLLOW_22_in_bibtex_entry298); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.4");
            }
            match(input,16,FOLLOW_16_in_bibtex_entry301); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.5");
            }
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:160:814: (temp= identifier )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:160:816: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry308);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "title", temp);
              setParent(temp,ret,"title");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.6");
            }
            match(input,17,FOLLOW_17_in_bibtex_entry314); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.7");
            }
            match(input,20,FOLLOW_20_in_bibtex_entry317); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.8");
            }
            match(input,23,FOLLOW_23_in_bibtex_entry320); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.9");
            }
            match(input,22,FOLLOW_22_in_bibtex_entry323); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.10");
            }
            match(input,16,FOLLOW_16_in_bibtex_entry326); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.11");
            }
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:161:977: (temp= identifier ( ( 'and' ) temp= identifier )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:161:979: temp= identifier ( ( 'and' ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_bibtex_entry333);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "author", null, temp, "OCL:Bibtex::Author.allInstances()->select(name = ?)", "platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.11", SyntaxRegistry.getInstance());
                    }
                    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:161:1244: ( ( 'and' ) temp= identifier )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==24) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:161:1245: ( 'and' ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:161:1262: ( 'and' )
                    	    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:161:1263: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.11/@propertyArgs.1/@separatorSequence/@elements.0");
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
                    	      setOclRef(ret, "author", null, temp, "OCL:Bibtex::Author.allInstances()->select(name = ?)", "platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.11", SyntaxRegistry.getInstance());
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2/@blockSequence/@elements.12");
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.3");
            }
            match(input,17,FOLLOW_17_in_bibtex_entry365); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "literaturedb", null, null, "OCL:#context", true, "platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.3/@templateSequence/@elements.4/@injectorActions.0", SyntaxRegistry.getInstance());_exitInjectorAction();
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
    // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:169:1: bibtex_author returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object bibtex_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Author");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:175:3: ( ( (temp= identifier ) ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:176:3: ( (temp= identifier ) )
            {
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:176:3: ( (temp= identifier ) )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:176:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.4/@templateSequence/@elements.0");
            }
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:176:115: (temp= identifier )
            // C:\\Users\\d043530\\git\\DSLEngineering\\bibtex.dsl\\generated\\generated\\Bibtex.g:176:117: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_author412);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.4/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "literaturedb", null, null, "OCL:#context", true, "platform:/plugin/bibtex.dsl/mappings/Bibtex.tcs#//@templates.4/@templateSequence/@elements.1/@injectorActions.0", SyntaxRegistry.getInstance());_exitInjectorAction();
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