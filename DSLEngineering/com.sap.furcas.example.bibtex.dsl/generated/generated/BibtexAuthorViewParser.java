// $ANTLR 3.1.1 /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g 2011-07-17 01:57:24

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
public class BibtexAuthorViewParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "LCURLY", "RCURLY", "COLON", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "FLOAT", "'Author:'"
    };
    public static final int COLON=9;
    public static final int NAME=4;
    public static final int WS=12;
    public static final int T__18=18;
    public static final int SNAME=15;
    public static final int ESC=16;
    public static final int RCURLY=8;
    public static final int LCURLY=7;
    public static final int FLOAT=17;
    public static final int INT=6;
    public static final int DIGIT=13;
    public static final int NL=11;
    public static final int COMMENT=10;
    public static final int EOF=-1;
    public static final int ALPHA=14;
    public static final int STRING=5;

    // delegates
    // delegators


        public BibtexAuthorViewParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public BibtexAuthorViewParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return BibtexAuthorViewParser.tokenNames; }
    public String getGrammarFileName() { return "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g"; }


       private static final String syntaxUUID = "platform:/resource/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWcLAHEeCt07rYGW4TkQ";
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:103:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:104:3: ( (ast= NAME ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:105:3: (ast= NAME )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:105:3: (ast= NAME )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:105:4: ast= NAME
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:113:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:114:3: ( (ast= STRING ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:115:3: (ast= STRING )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:115:3: (ast= STRING )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:115:4: ast= STRING
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:123:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:124:3: ( (ast= INT ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:125:3: (ast= INT )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:125:3: (ast= INT )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:125:4: ast= INT
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
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:133:1: main returns [Object ret2] : ( (ret= bibtex_author ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:134:3: ( ( (ret= bibtex_author ) EOF ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:135:3: ( (ret= bibtex_author ) EOF )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:135:3: ( (ret= bibtex_author ) EOF )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:135:4: (ret= bibtex_author ) EOF
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:135:4: (ret= bibtex_author )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:135:5: ret= bibtex_author
            {
            pushFollow(FOLLOW_bibtex_author_in_main159);
            ret=bibtex_author();

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


    // $ANTLR start "bibtex_author"
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:142:1: bibtex_author returns [Object ret2] : ( 'Author:' (temp= identifier ) LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY ) ;
    public final Object bibtex_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Author");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWdLAHEeCt07rYGW4TkQ");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:148:3: ( ( 'Author:' (temp= identifier ) LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:149:3: ( 'Author:' (temp= identifier ) LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:149:3: ( 'Author:' (temp= identifier ) LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:149:4: 'Author:' (temp= identifier ) LCURLY ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWdrAHEeCt07rYGW4TkQ");
            }
            match(input,18,FOLLOW_18_in_bibtex_author193); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWd7AHEeCt07rYGW4TkQ");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:149:279: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:149:281: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_author200);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWebAHEeCt07rYGW4TkQ");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_bibtex_author207); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWerAHEeCt07rYGW4TkQ");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:150:320: ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:150:321: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:150:321: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:150:322: (temp= bibtex_entry (temp= bibtex_entry )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWfLAHEeCt07rYGW4TkQ");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:150:447: (temp= bibtex_entry (temp= bibtex_entry )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:150:449: temp= bibtex_entry (temp= bibtex_entry )*
                    {
                    pushFollow(FOLLOW_bibtex_entry_in_bibtex_author218);
                    temp=bibtex_entry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "publications", temp);
                      setParent(temp,ret,"publications");
                    }
                    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:151:38: (temp= bibtex_entry )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==NAME) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:151:40: temp= bibtex_entry
                    	    {
                    	    pushFollow(FOLLOW_bibtex_entry_in_bibtex_author226);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWfrAHEeCt07rYGW4TkQ");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_bibtex_author241); if (state.failed) return ret2;
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


    // $ANTLR start "bibtex_entry"
    // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:160:1: bibtex_entry returns [Object ret2] : ( (temp= identifier ) COLON (temp= stringSymbol ) ) ;
    public final Object bibtex_entry() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("Bibtex","Entry");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWf7AHEeCt07rYGW4TkQ");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:166:3: ( ( (temp= identifier ) COLON (temp= stringSymbol ) ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:167:3: ( (temp= identifier ) COLON (temp= stringSymbol ) )
            {
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:167:3: ( (temp= identifier ) COLON (temp= stringSymbol ) )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:167:4: (temp= identifier ) COLON (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWgbAHEeCt07rYGW4TkQ");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:167:129: (temp= identifier )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:167:131: temp= identifier
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWg7AHEeCt07rYGW4TkQ");
            }
            match(input,COLON,FOLLOW_COLON_in_bibtex_entry293); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.example.bibtex.dsl/mapping/BibtexAuthorView.furcas#_WHHWhLAHEeCt07rYGW4TkQ");
            }
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:168:317: (temp= stringSymbol )
            // /home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/com.sap.furcas.example.bibtex.dsl/generated/generated/BibtexAuthorView.g:168:319: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_bibtex_entry301);
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

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtex_author_in_main159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_bibtex_author193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_bibtex_author200 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_bibtex_author207 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_author218 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_bibtex_entry_in_bibtex_author226 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_RCURLY_in_bibtex_author241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_bibtex_entry286 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_COLON_in_bibtex_entry293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_bibtex_entry301 = new BitSet(new long[]{0x0000000000000002L});

}