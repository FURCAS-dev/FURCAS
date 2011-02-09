// $ANTLR 3.1.1 /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g 2011-02-07 00:00:23

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
public class AlternativeBibtexParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "INT", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "FLOAT", "STRING", "'DB:'", "'{'", "'}'", "':'"
    };
    public static final int NAME=4;
    public static final int WS=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int SNAME=11;
    public static final int T__17=17;
    public static final int ESC=12;
    public static final int FLOAT=13;
    public static final int INT=5;
    public static final int DIGIT=9;
    public static final int NL=7;
    public static final int COMMENT=6;
    public static final int EOF=-1;
    public static final int ALPHA=10;
    public static final int STRING=14;

    // delegates
    // delegators


        public AlternativeBibtexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public AlternativeBibtexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return AlternativeBibtexParser.tokenNames; }
    public String getGrammarFileName() { return "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g"; }


       private static final String syntaxUUID = "_4MJ0gDJEEeCD2P2_bQqizw";
       public String getSyntaxUUID() {
            return syntaxUUID;
       }
        public String unescapeString(String s) {
            // get rid of the starting and ending delimiters (e.g., '\'', '"')
           int delimLength = 1; // for delimLength > 0, the following code needs to change
           if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                    s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
            }
            return s;
        }




    // $ANTLR start "identifier"
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:95:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:96:3: ( (ast= NAME ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:97:3: (ast= NAME )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:97:3: (ast= NAME )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:97:4: ast= NAME
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:105:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:106:3: ( (ast= INT ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:107:3: (ast= INT )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:107:3: (ast= INT )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:107:4: ast= INT
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:115:1: main returns [Object ret2] : ( (ret= bibtex_literaturedb ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:116:3: ( ( (ret= bibtex_literaturedb ) EOF ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:117:3: ( (ret= bibtex_literaturedb ) EOF )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:117:3: ( (ret= bibtex_literaturedb ) EOF )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:117:4: (ret= bibtex_literaturedb ) EOF
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:117:4: (ret= bibtex_literaturedb )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:117:5: ret= bibtex_literaturedb
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:124:1: bibtex_literaturedb returns [Object ret2] : ( 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}' ) ;
    public final Object bibtex_literaturedb() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","LiteratureDb");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:130:3: ( ( 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}' ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:131:3: ( 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}' )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:131:3: ( 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}' )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:131:4: 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.2/@templateSequence/@elements.0");
            }
            match(input,15,FOLLOW_15_in_bibtex_literaturedb162); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.2/@templateSequence/@elements.1");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:131:269: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:131:271: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_literaturedb169);
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.2/@templateSequence/@elements.2");
            }
            match(input,16,FOLLOW_16_in_bibtex_literaturedb175); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.2/@templateSequence/@elements.3");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:132:309: ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:132:310: ( (temp= bibtex_author (temp= bibtex_author )* )? )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:132:310: ( (temp= bibtex_author (temp= bibtex_author )* )? )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:132:311: (temp= bibtex_author (temp= bibtex_author )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.2/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:132:460: (temp= bibtex_author (temp= bibtex_author )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:132:462: temp= bibtex_author (temp= bibtex_author )*
                    {
                    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb185);
                    temp=bibtex_author();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "author", temp);
                      setParent(temp,ret,"author");
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:133:32: (temp= bibtex_author )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==NAME) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:133:34: temp= bibtex_author
                    	    {
                    	    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb193);
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.2/@templateSequence/@elements.4");
            }
            match(input,17,FOLLOW_17_in_bibtex_literaturedb207); if (state.failed) return ret2;
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:142:1: bibtex_entry returns [Object ret2] : ( (temp= identifier ) ':' (temp= identifier ) ) ;
    public final Object bibtex_entry() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Entry");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:148:3: ( ( (temp= identifier ) ':' (temp= identifier ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:149:3: ( (temp= identifier ) ':' (temp= identifier ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:149:3: ( (temp= identifier ) ':' (temp= identifier ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:149:4: (temp= identifier ) ':' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.3/@templateSequence/@elements.0");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:149:126: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:149:128: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry251);
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.3/@templateSequence/@elements.1");
            }
            match(input,18,FOLLOW_18_in_bibtex_entry257); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.3/@templateSequence/@elements.2");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:150:307: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:150:309: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry264);
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.3/@templateSequence/@elements.3");
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:159:1: bibtex_author returns [Object ret2] : ( (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) ) ;
    public final Object bibtex_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Author");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:165:3: ( ( (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:166:3: ( (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:166:3: ( (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:166:4: (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.4/@templateSequence/@elements.0");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:166:126: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:166:128: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_author314);
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
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.4/@templateSequence/@elements.1");
            }
            match(input,18,FOLLOW_18_in_bibtex_author320); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.4/@templateSequence/@elements.2");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:167:309: ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:167:310: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:167:310: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:167:311: (temp= bibtex_entry (temp= bibtex_entry )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.4/@templateSequence/@elements.2/@blockSequence/@elements.0");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:167:460: (temp= bibtex_entry (temp= bibtex_entry )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NAME) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==18) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==NAME) ) {
                        int LA4_4 = input.LA(4);

                        if ( (LA4_4==EOF||LA4_4==NAME||LA4_4==17) ) {
                            alt4=1;
                        }
                    }
                }
            }
            switch (alt4) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:167:462: temp= bibtex_entry (temp= bibtex_entry )*
                    {
                    pushFollow(FOLLOW_bibtex_entry_in_bibtex_author330);
                    temp=bibtex_entry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "publications", temp);
                      setParent(temp,ret,"publications");
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:168:38: (temp= bibtex_entry )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NAME) ) {
                            int LA3_1 = input.LA(2);

                            if ( (LA3_1==18) ) {
                                int LA3_3 = input.LA(3);

                                if ( (LA3_3==NAME) ) {
                                    int LA3_4 = input.LA(4);

                                    if ( (LA3_4==EOF||LA3_4==NAME||LA3_4==17) ) {
                                        alt3=1;
                                    }


                                }


                            }


                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/generated/generated/AlternativeBibtex.g:168:40: temp= bibtex_entry
                    	    {
                    	    pushFollow(FOLLOW_bibtex_entry_in_bibtex_author338);
                    	    temp=bibtex_entry();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "publications", temp);
                    	      setParent(temp,ret,"publications");
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

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/bibtex.dsl/mappings/AlternativeBibtex.tcs#//@templates.4/@templateSequence/@elements.3");
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
    public static final BitSet FOLLOW_15_in_bibtex_literaturedb162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_literaturedb169 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_bibtex_literaturedb175 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_bibtex_author_in_bibtex_literaturedb185 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_bibtex_author_in_bibtex_literaturedb193 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_17_in_bibtex_literaturedb207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry251 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_bibtex_entry257 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_bibtex_author314 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_bibtex_author320 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_author330 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_author338 = new BitSet(new long[]{0x0000000000000012L});

}