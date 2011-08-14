// $ANTLR 3.1.1 /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g 2011-08-14 02:17:34

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
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistryFacade;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class BibtexLibraryViewParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "LCURLY", "RCURLY", "COMA", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "FLOAT", "'Library:'", "'Entries:'", "'Authors:'", "'@article'", "'title'", "'='", "'author'", "'and'"
    };
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int ESC=16;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int LCURLY=7;
    public static final int FLOAT=17;
    public static final int INT=6;
    public static final int EOF=-1;
    public static final int COMA=9;
    public static final int ALPHA=14;
    public static final int T__19=19;
    public static final int NAME=4;
    public static final int WS=12;
    public static final int T__18=18;
    public static final int SNAME=15;
    public static final int RCURLY=8;
    public static final int DIGIT=13;
    public static final int NL=11;
    public static final int COMMENT=10;
    public static final int STRING=5;

    // delegates
    // delegators


        public BibtexLibraryViewParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtexLibraryViewParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtexLibraryViewParser.tokenNames; }
    public String getGrammarFileName() { return "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g"; }


       private static final String syntaxUUID = "platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcAUMYKEeC54tK7O0t61w";
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:103:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:104:3: ( (ast= NAME ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:105:3: (ast= NAME )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:105:3: (ast= NAME )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:105:4: ast= NAME
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


    // $ANTLR start "stringSymbol"
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:113:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:114:3: ( (ast= STRING ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:115:3: (ast= STRING )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:115:3: (ast= STRING )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:115:4: ast= STRING
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:123:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:124:3: ( (ast= INT ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:125:3: (ast= INT )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:125:3: (ast= INT )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:125:4: ast= INT
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


    // $ANTLR start "main"
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:133:1: main returns [Object ret2] : ( (ret= bibtex_literaturedb ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:134:3: ( ( (ret= bibtex_literaturedb ) EOF ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:135:3: ( (ret= bibtex_literaturedb ) EOF )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:135:3: ( (ret= bibtex_literaturedb ) EOF )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:135:4: (ret= bibtex_literaturedb ) EOF
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:135:4: (ret= bibtex_literaturedb )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:135:5: ret= bibtex_literaturedb
            {
            pushFollow(FOLLOW_bibtex_literaturedb_in_main159);
            ret=bibtex_literaturedb();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main162); if (state.failed) return ret2;

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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:142:1: bibtex_literaturedb returns [Object ret2] : ( 'Library:' (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY ) ;
    public final Object bibtex_literaturedb() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","LiteratureDb");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcAVMYKEeC54tK7O0t61w");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:148:3: ( ( 'Library:' (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:149:3: ( 'Library:' (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:149:3: ( 'Library:' (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:149:4: 'Library:' (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcAVsYKEeC54tK7O0t61w");
            }
            match(input,18,FOLLOW_18_in_bibtex_literaturedb193); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcAV8YKEeC54tK7O0t61w");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:149:282: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:149:284: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_literaturedb200);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcAWcYKEeC54tK7O0t61w");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcAWsYKEeC54tK7O0t61w");
            }
            match(input,19,FOLLOW_19_in_bibtex_literaturedb208); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcAW8YKEeC54tK7O0t61w");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_literaturedb212); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcAXMYKEeC54tK7O0t61w");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:150:616: ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:150:617: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:150:617: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:150:618: (temp= bibtex_entry (temp= bibtex_entry )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnYcYKEeC54tK7O0t61w");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:150:744: (temp= bibtex_entry (temp= bibtex_entry )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==21) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:150:746: temp= bibtex_entry (temp= bibtex_entry )*
                    {
                    pushFollow(FOLLOW_bibtex_entry_in_bibtex_literaturedb223);
                    temp=bibtex_entry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                      setParent(temp,ret,"entries");
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:151:33: (temp= bibtex_entry )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==21) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:151:35: temp= bibtex_entry
                    	    {
                    	    pushFollow(FOLLOW_bibtex_entry_in_bibtex_literaturedb231);
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

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnY8YKEeC54tK7O0t61w");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_literaturedb246); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnZMYKEeC54tK7O0t61w");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnZcYKEeC54tK7O0t61w");
            }
            match(input,20,FOLLOW_20_in_bibtex_literaturedb252); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnZsYKEeC54tK7O0t61w");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_literaturedb256); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnZ8YKEeC54tK7O0t61w");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:152:792: (temp= bibtex_author (temp= bibtex_author )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NAME) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:152:794: temp= bibtex_author (temp= bibtex_author )*
                    {
                    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb264);
                    temp=bibtex_author();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "author", temp);
                      setParent(temp,ret,"author");
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:153:32: (temp= bibtex_author )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NAME) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:153:34: temp= bibtex_author
                    	    {
                    	    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb272);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnacYKEeC54tK7O0t61w");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_literaturedb284); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnasYKEeC54tK7O0t61w");
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
            onExitTemplateRule();
        }
        return ret2;
    }
    // $ANTLR end "bibtex_literaturedb"


    // $ANTLR start "bibtex_entry"
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:162:1: bibtex_entry returns [Object ret2] : ( '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= stringSymbol ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY ) ;
    public final Object bibtex_entry() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Entry");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcna8YKEeC54tK7O0t61w");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:168:3: ( ( '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= stringSymbol ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:169:3: ( '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= stringSymbol ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:169:3: ( '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= stringSymbol ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:169:4: '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= stringSymbol ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnbcYKEeC54tK7O0t61w");
            }
            match(input,21,FOLLOW_21_in_bibtex_entry327); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnbsYKEeC54tK7O0t61w");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_entry331); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnb8YKEeC54tK7O0t61w");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:169:432: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:169:434: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry339);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnccYKEeC54tK7O0t61w");
            }
            match(input,COMA,FOLLOW_COMA_in_bibtex_entry346); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcncsYKEeC54tK7O0t61w");
            }
            match(input,22,FOLLOW_22_in_bibtex_entry350); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnc8YKEeC54tK7O0t61w");
            }
            match(input,23,FOLLOW_23_in_bibtex_entry353); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcndMYKEeC54tK7O0t61w");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_entry357); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcndcYKEeC54tK7O0t61w");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:170:762: (temp= stringSymbol )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:170:764: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_bibtex_entry365);
            temp=stringSymbol();

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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcneMYKEeC54tK7O0t61w");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_entry372); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnecYKEeC54tK7O0t61w");
            }
            match(input,COMA,FOLLOW_COMA_in_bibtex_entry377); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnesYKEeC54tK7O0t61w");
            }
            match(input,24,FOLLOW_24_in_bibtex_entry381); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcne8YKEeC54tK7O0t61w");
            }
            match(input,23,FOLLOW_23_in_bibtex_entry384); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnfMYKEeC54tK7O0t61w");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_entry388); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnfcYKEeC54tK7O0t61w");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:171:916: (temp= identifier ( ( 'and' ) temp= identifier )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:171:918: temp= identifier ( ( 'and' ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_bibtex_entry396);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "author", null, temp, "OCL:self.literaturedb.author->select(name = ?)", "platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnfcYKEeC54tK7O0t61w", SyntaxRegistryFacade.getModelUpdaterRegistry());
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:171:1183: ( ( 'and' ) temp= identifier )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==25) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:171:1184: ( 'and' ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:171:1201: ( 'and' )
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:171:1202: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcngcYKEeC54tK7O0t61w");
                    	    }
                    	    match(input,25,FOLLOW_25_in_bibtex_entry404); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_bibtex_entry411);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setOclRef(ret, "author", null, temp, "OCL:self.literaturedb.author->select(name = ?)", "platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnfcYKEeC54tK7O0t61w", SyntaxRegistryFacade.getModelUpdaterRegistry());
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnhMYKEeC54tK7O0t61w");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_entry423); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnhcYKEeC54tK7O0t61w");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_entry428); if (state.failed) return ret2;
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
            onExitTemplateRule();
        }
        return ret2;
    }
    // $ANTLR end "bibtex_entry"


    // $ANTLR start "bibtex_author"
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:179:1: bibtex_author returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object bibtex_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Author");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcnhsYKEeC54tK7O0t61w");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:185:3: ( ( (temp= identifier ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:186:3: ( (temp= identifier ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:186:3: ( (temp= identifier ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:186:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas#_zpcniMYKEeC54tK7O0t61w");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:186:130: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexLibraryView.g:186:132: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_author473);
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
            onExitTemplateRule();
        }
        return ret2;
    }
    // $ANTLR end "bibtex_author"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtex_literaturedb_in_main159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_bibtex_literaturedb193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_literaturedb200 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_bibtex_literaturedb208 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_literaturedb212 = new BitSet(new long[]{0x0000000000200100L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_literaturedb223 = new BitSet(new long[]{0x0000000000200100L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_literaturedb231 = new BitSet(new long[]{0x0000000000200100L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_literaturedb246 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_bibtex_literaturedb252 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_literaturedb256 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_bibtex_author_in_bibtex_literaturedb264 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_bibtex_author_in_bibtex_literaturedb272 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_literaturedb284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_bibtex_entry327 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_entry331 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry339 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMA_in_bibtex_entry346 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_bibtex_entry350 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_bibtex_entry353 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_entry357 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_bibtex_entry365 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_entry372 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COMA_in_bibtex_entry377 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_bibtex_entry381 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_bibtex_entry384 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_entry388 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry396 = new BitSet(new long[]{0x0000000002000100L});
    public static final BitSet FOLLOW_25_in_bibtex_entry404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry411 = new BitSet(new long[]{0x0000000002000100L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_entry423 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_entry428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_bibtex_author473 = new BitSet(new long[]{0x0000000000000002L});

}