// $ANTLR 3.1.1 /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g 2011-03-09 20:54:55

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class BibtexParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "INT", "LCURLY", "RCURLY", "COMA", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "FLOAT", "STRING", "'Entries:'", "'Authors:'", "'@article'", "'title'", "'='", "'author'", "'and'"
    };
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int ESC=15;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int LCURLY=6;
    public static final int FLOAT=16;
    public static final int INT=5;
    public static final int EOF=-1;
    public static final int COMA=8;
    public static final int ALPHA=13;
    public static final int T__19=19;
    public static final int NAME=4;
    public static final int WS=11;
    public static final int T__18=18;
    public static final int SNAME=14;
    public static final int RCURLY=7;
    public static final int NL=10;
    public static final int DIGIT=12;
    public static final int COMMENT=9;
    public static final int STRING=17;

    // delegates
    // delegators


        public BibtexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtexParser.tokenNames; }
    public String getGrammarFileName() { return "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g"; }


       private static final String syntaxUUID = "_GcOIAEqHEeC18q-QHmvFtQ";
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:102:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:103:3: ( (ast= NAME ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:104:3: (ast= NAME )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:104:3: (ast= NAME )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:104:4: ast= NAME
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:112:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:113:3: ( (ast= INT ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:114:3: (ast= INT )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:114:3: (ast= INT )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:114:4: ast= INT
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:122:1: main returns [Object ret2] : ( (ret= bibtex_literaturedb ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:123:3: ( ( (ret= bibtex_literaturedb ) EOF ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:124:3: ( (ret= bibtex_literaturedb ) EOF )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:124:3: ( (ret= bibtex_literaturedb ) EOF )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:124:4: (ret= bibtex_literaturedb ) EOF
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:124:4: (ret= bibtex_literaturedb )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:124:5: ret= bibtex_literaturedb
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:131:1: bibtex_literaturedb returns [Object ret2] : ( (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY ) ;
    public final Object bibtex_literaturedb() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","LiteratureDb");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:137:3: ( ( (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:138:3: ( (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:138:3: ( (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:138:4: (temp= identifier ) 'Entries:' LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY 'Authors:' LCURLY (temp= bibtex_author (temp= bibtex_author )* )? RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.0");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:138:137: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:138:139: temp= identifier
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.2");
            }
            match(input,18,FOLLOW_18_in_bibtex_literaturedb174); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.3");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_literaturedb178); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.4");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:139:644: ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:139:645: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:139:645: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:139:646: (temp= bibtex_entry (temp= bibtex_entry )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.4/@blockSequence/@elements.0");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:139:806: (temp= bibtex_entry (temp= bibtex_entry )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:139:808: temp= bibtex_entry (temp= bibtex_entry )*
                    {
                    pushFollow(FOLLOW_bibtex_entry_in_bibtex_literaturedb189);
                    temp=bibtex_entry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                      setParent(temp,ret,"entries");
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:140:33: (temp= bibtex_entry )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==20) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:140:35: temp= bibtex_entry
                    	    {
                    	    pushFollow(FOLLOW_bibtex_entry_in_bibtex_literaturedb197);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.5");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_literaturedb212); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.6");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.7");
            }
            match(input,19,FOLLOW_19_in_bibtex_literaturedb218); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.8");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_literaturedb222); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.9");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:141:827: (temp= bibtex_author (temp= bibtex_author )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NAME) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:141:829: temp= bibtex_author (temp= bibtex_author )*
                    {
                    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb230);
                    temp=bibtex_author();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "author", temp);
                      setParent(temp,ret,"author");
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:142:32: (temp= bibtex_author )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NAME) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:142:34: temp= bibtex_author
                    	    {
                    	    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb238);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.10");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_literaturedb250); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.2/@templateSequence/@elements.11");
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
    // $ANTLR end "bibtex_literaturedb"


    // $ANTLR start "bibtex_entry"
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:151:1: bibtex_entry returns [Object ret2] : ( '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= identifier ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY ) ;
    public final Object bibtex_entry() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Entry");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:157:3: ( ( '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= identifier ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:158:3: ( '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= identifier ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:158:3: ( '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= identifier ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:158:4: '@article' LCURLY (temp= identifier ) COMA 'title' '=' LCURLY (temp= identifier ) RCURLY COMA 'author' '=' LCURLY (temp= identifier ( ( 'and' ) temp= identifier )* )? RCURLY RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.0");
            }
            match(input,20,FOLLOW_20_in_bibtex_entry293); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.1");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_entry297); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.2");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:158:453: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:158:455: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry305);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.3");
            }
            match(input,COMA,FOLLOW_COMA_in_bibtex_entry312); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.4");
            }
            match(input,21,FOLLOW_21_in_bibtex_entry316); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.5");
            }
            match(input,22,FOLLOW_22_in_bibtex_entry319); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.6");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_entry323); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.7");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:159:797: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:159:799: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry331);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.8");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_entry338); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.9");
            }
            match(input,COMA,FOLLOW_COMA_in_bibtex_entry343); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.10");
            }
            match(input,23,FOLLOW_23_in_bibtex_entry347); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.11");
            }
            match(input,22,FOLLOW_22_in_bibtex_entry350); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.12");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_entry354); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.13");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:160:962: (temp= identifier ( ( 'and' ) temp= identifier )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:160:964: temp= identifier ( ( 'and' ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_bibtex_entry362);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "author", null, temp, "OCL:self.literaturedb.author->select(name = ?)");
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:160:1070: ( ( 'and' ) temp= identifier )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==24) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:160:1071: ( 'and' ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:160:1088: ( 'and' )
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:160:1089: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.13/@propertyArgs.1/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,24,FOLLOW_24_in_bibtex_entry370); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_bibtex_entry377);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setOclRef(ret, "author", null, temp, "OCL:self.literaturedb.author->select(name = ?)");
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.14");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_entry389); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.15");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_entry394); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.3/@templateSequence/@elements.16");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "literaturedb", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:168:1: bibtex_author returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object bibtex_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Author");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:174:3: ( ( (temp= identifier ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:175:3: ( (temp= identifier ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:175:3: ( (temp= identifier ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:175:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.4/@templateSequence/@elements.0");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:175:137: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/Bibtex.g:175:139: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_author442);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs#//@templates.4/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "literaturedb", null, null, "OCL:#context", true);_exitInjectorAction();
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
    public static final BitSet FOLLOW_identifier_in_bibtex_literaturedb166 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_bibtex_literaturedb174 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_literaturedb178 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_literaturedb189 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_literaturedb197 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_literaturedb212 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_bibtex_literaturedb218 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_literaturedb222 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_bibtex_author_in_bibtex_literaturedb230 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_bibtex_author_in_bibtex_literaturedb238 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_literaturedb250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_bibtex_entry293 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_entry297 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry305 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COMA_in_bibtex_entry312 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_bibtex_entry316 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_bibtex_entry319 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_entry323 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry331 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_entry338 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COMA_in_bibtex_entry343 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_bibtex_entry347 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_bibtex_entry350 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_entry354 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry362 = new BitSet(new long[]{0x0000000001000080L});
    public static final BitSet FOLLOW_24_in_bibtex_entry370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry377 = new BitSet(new long[]{0x0000000001000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_entry389 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_entry394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_bibtex_author442 = new BitSet(new long[]{0x0000000000000002L});

}