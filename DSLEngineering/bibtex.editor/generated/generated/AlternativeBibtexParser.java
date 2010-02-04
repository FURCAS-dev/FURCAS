// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g 2010-01-21 16:11:57

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
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g"; }


       private static final String syntaxUUID = "E0356A0450CAF810069F11DF8994D1958D03C068";
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:208:3: ( (ast= NAME ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:209:3: (ast= NAME )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:209:3: (ast= NAME )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:209:4: ast= NAME
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:217:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:218:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:219:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:219:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:219:4: ast= INT
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:227:1: main returns [Object ret2] : ( (ret= bibtex_literaturedb ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:228:3: ( ( (ret= bibtex_literaturedb ) EOF ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:229:3: ( (ret= bibtex_literaturedb ) EOF )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:229:3: ( (ret= bibtex_literaturedb ) EOF )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:229:4: (ret= bibtex_literaturedb ) EOF
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:229:4: (ret= bibtex_literaturedb )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:229:5: ret= bibtex_literaturedb
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:236:1: bibtex_literaturedb returns [Object ret2] : ( 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}' ) ;
    public final Object bibtex_literaturedb() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Bibtex","LiteratureDb");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:241:3: ( ( 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:3: ( 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:3: ( 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:4: 'DB:' (temp= identifier ) '{' ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) ) '}'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C66430069F11DFCD90D1958D03C068");
            }
            match(input,15,FOLLOW_15_in_bibtex_literaturedb162); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C68B41069F11DF88E2D1958D03C068");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:143: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:145: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_literaturedb169);
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
              _beforeSeqEl("E0356A0450C6B250069F11DFCCAAD1958D03C068");
            }
            match(input,16,FOLLOW_16_in_bibtex_literaturedb175); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C70070069F11DF8833D1958D03C068");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:348: ( ( (temp= bibtex_author (temp= bibtex_author )* )? ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:349: ( (temp= bibtex_author (temp= bibtex_author )* )? )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:349: ( (temp= bibtex_author (temp= bibtex_author )* )? )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:350: (temp= bibtex_author (temp= bibtex_author )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C6B252069F11DFB818D1958D03C068");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:409: (temp= bibtex_author (temp= bibtex_author )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:411: temp= bibtex_author (temp= bibtex_author )*
                    {
                    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb185);
                    temp=bibtex_author();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "author", temp);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:466: (temp= bibtex_author )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==NAME) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:242:468: temp= bibtex_author
                    	    {
                    	    pushFollow(FOLLOW_bibtex_author_in_bibtex_literaturedb193);
                    	    temp=bibtex_author();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "author", temp);
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
              _beforeSeqEl("E0356A0450C70071069F11DFC8E5D1958D03C068");
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:250:1: bibtex_entry returns [Object ret2] : ( (temp= identifier ) ':' (temp= identifier ) ) ;
    public final Object bibtex_entry() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Bibtex","Entry");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:255:3: ( ( (temp= identifier ) ':' (temp= identifier ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:256:3: ( (temp= identifier ) ':' (temp= identifier ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:256:3: ( (temp= identifier ) ':' (temp= identifier ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:256:4: (temp= identifier ) ':' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C7EAD1069F11DF9CDAD1958D03C068");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:256:63: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:256:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry251);
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
              _beforeSeqEl("E0356A0450C811E0069F11DFA125D1958D03C068");
            }
            match(input,18,FOLLOW_18_in_bibtex_entry257); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C838F0069F11DFB24CD1958D03C068");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:256:266: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:256:268: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_entry264);
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
              _beforeSeqEl("E0356A0450C88710069F11DF89C6D1958D03C068");
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:264:1: bibtex_author returns [Object ret2] : ( (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) ) ;
    public final Object bibtex_author() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Bibtex","Author");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:269:3: ( ( (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:3: ( (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:3: ( (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:4: (temp= identifier ) ':' ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C94A61069F11DFBD1AD1958D03C068");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:63: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_bibtex_author314);
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
              _beforeSeqEl("E0356A0450C97170069F11DF8608D1958D03C068");
            }
            match(input,18,FOLLOW_18_in_bibtex_author320); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C9BF90069F11DFB738D1958D03C068");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:268: ( ( (temp= bibtex_entry (temp= bibtex_entry )* )? ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:269: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:269: ( (temp= bibtex_entry (temp= bibtex_entry )* )? )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:270: (temp= bibtex_entry (temp= bibtex_entry )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A0450C97172069F11DF9E70D1958D03C068");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:329: (temp= bibtex_entry (temp= bibtex_entry )* )?
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:331: temp= bibtex_entry (temp= bibtex_entry )*
                    {
                    pushFollow(FOLLOW_bibtex_entry_in_bibtex_author330);
                    temp=bibtex_entry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "publications", temp);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:391: (temp= bibtex_entry )*
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
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\bibtex.editor\\generated\\generated\\AlternativeBibtex.g:270:393: temp= bibtex_entry
                    	    {
                    	    pushFollow(FOLLOW_bibtex_entry_in_bibtex_author338);
                    	    temp=bibtex_entry();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "publications", temp);
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
              _beforeSeqEl("E0356A0450CA0DB0069F11DF85B4D1958D03C068");
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