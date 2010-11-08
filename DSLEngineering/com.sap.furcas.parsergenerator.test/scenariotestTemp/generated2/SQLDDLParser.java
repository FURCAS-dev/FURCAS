// $ANTLR 3.1.1 ./scenariotestTemp/generated2/SQLDDL.g 2010-11-04 23:27:46

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
public class SQLDDLParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "LPAREN", "COMA", "RPAREN", "SEMI", "EQ", "COMMENT", "LSQUARE", "RSQUARE", "EXCL", "LCURLY", "RCURLY", "COLON", "COLONS", "PIPE", "SHARP", "QMARK", "POINT", "RARROW", "MINUS", "STAR", "SLASH", "PLUS", "GT", "LT", "GE", "LE", "NE", "LARROW", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'CREATE'", "'TABLE'", "'NOT'", "'NULL'", "'default'", "'UNIQUE'", "'KEY'", "'PRIMARY'", "'FOREIGN'", "'REFERENCES'", "'unsigned'"
    };
    public static final int LT=31;
    public static final int STAR=27;
    public static final int LSQUARE=14;
    public static final int POINT=24;
    public static final int ESC=41;
    public static final int LARROW=35;
    public static final int FLOAT=7;
    public static final int EXCL=16;
    public static final int EOF=-1;
    public static final int LPAREN=8;
    public static final int COLONS=20;
    public static final int RPAREN=10;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int SLASH=28;
    public static final int T__52=52;
    public static final int PIPE=21;
    public static final int PLUS=29;
    public static final int DIGIT=38;
    public static final int NL=36;
    public static final int EQ=12;
    public static final int COMMENT=13;
    public static final int T__50=50;
    public static final int NE=34;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int GE=32;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int SHARP=22;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=25;
    public static final int LCURLY=17;
    public static final int INT=6;
    public static final int RSQUARE=15;
    public static final int MINUS=26;
    public static final int COMA=9;
    public static final int SEMI=11;
    public static final int ALPHA=39;
    public static final int COLON=19;
    public static final int WS=37;
    public static final int SNAME=40;
    public static final int RCURLY=18;
    public static final int GT=30;
    public static final int QMARK=23;
    public static final int LE=33;
    public static final int STRING=5;

    // delegates
    // delegators


        public SQLDDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SQLDDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SQLDDLParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/SQLDDL.g"; }


       private static final String syntaxUUID = "SQLDDL";
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
    // ./scenariotestTemp/generated2/SQLDDL.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/SQLDDL.g:209:4: ast= NAME
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


    // $ANTLR start "stringSymbol"
    // ./scenariotestTemp/generated2/SQLDDL.g:217:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:218:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:219:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:219:3: (ast= STRING )
            // ./scenariotestTemp/generated2/SQLDDL.g:219:4: ast= STRING
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
    // ./scenariotestTemp/generated2/SQLDDL.g:227:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:228:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:229:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:229:3: (ast= INT )
            // ./scenariotestTemp/generated2/SQLDDL.g:229:4: ast= INT
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


    // $ANTLR start "floatSymbol"
    // ./scenariotestTemp/generated2/SQLDDL.g:237:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:238:3: ( (ast= FLOAT ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:239:3: (ast= FLOAT )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:239:3: (ast= FLOAT )
            // ./scenariotestTemp/generated2/SQLDDL.g:239:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol162); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = Double.valueOf( ast.getText());

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
    // $ANTLR end "floatSymbol"


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/SQLDDL.g:247:1: main returns [Object ret2] : ( (ret= sqlddl_database ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:248:3: ( ( (ret= sqlddl_database ) EOF ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:249:3: ( (ret= sqlddl_database ) EOF )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:249:3: ( (ret= sqlddl_database ) EOF )
            // ./scenariotestTemp/generated2/SQLDDL.g:249:4: (ret= sqlddl_database ) EOF
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:249:4: (ret= sqlddl_database )
            // ./scenariotestTemp/generated2/SQLDDL.g:249:5: ret= sqlddl_database
            {
            pushFollow(FOLLOW_sqlddl_database_in_main190);
            ret=sqlddl_database();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main193); if (state.failed) return ret2;

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


    // $ANTLR start "sqlddl_database"
    // ./scenariotestTemp/generated2/SQLDDL.g:256:1: sqlddl_database returns [Object ret2] : ( (temp= sqlddl_table (temp= sqlddl_table )* )? ) ;
    public final Object sqlddl_database() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","Database");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:261:3: ( ( (temp= sqlddl_table (temp= sqlddl_table )* )? ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:262:3: ( (temp= sqlddl_table (temp= sqlddl_table )* )? )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:262:3: ( (temp= sqlddl_table (temp= sqlddl_table )* )? )
            // ./scenariotestTemp/generated2/SQLDDL.g:262:4: (temp= sqlddl_table (temp= sqlddl_table )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:262:21: (temp= sqlddl_table (temp= sqlddl_table )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==42) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:262:23: temp= sqlddl_table (temp= sqlddl_table )*
                    {
                    pushFollow(FOLLOW_sqlddl_table_in_sqlddl_database228);
                    temp=sqlddl_table();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tables", temp);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:262:77: (temp= sqlddl_table )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==42) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:262:79: temp= sqlddl_table
                    	    {
                    	    pushFollow(FOLLOW_sqlddl_table_in_sqlddl_database236);
                    	    temp=sqlddl_table();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "tables", temp);
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
    // $ANTLR end "sqlddl_database"


    // $ANTLR start "sqlddl_table"
    // ./scenariotestTemp/generated2/SQLDDL.g:270:1: sqlddl_table returns [Object ret2] : ( 'CREATE' 'TABLE' (temp= identifier ) LPAREN ( ( (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )? ) ) RPAREN (temp= sqlddl_parameter (temp= sqlddl_parameter )* )? SEMI ) ;
    public final Object sqlddl_table() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","Table");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:275:3: ( ( 'CREATE' 'TABLE' (temp= identifier ) LPAREN ( ( (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )? ) ) RPAREN (temp= sqlddl_parameter (temp= sqlddl_parameter )* )? SEMI ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:276:3: ( 'CREATE' 'TABLE' (temp= identifier ) LPAREN ( ( (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )? ) ) RPAREN (temp= sqlddl_parameter (temp= sqlddl_parameter )* )? SEMI )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:276:3: ( 'CREATE' 'TABLE' (temp= identifier ) LPAREN ( ( (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )? ) ) RPAREN (temp= sqlddl_parameter (temp= sqlddl_parameter )* )? SEMI )
            // ./scenariotestTemp/generated2/SQLDDL.g:276:4: 'CREATE' 'TABLE' (temp= identifier ) LPAREN ( ( (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )? ) ) RPAREN (temp= sqlddl_parameter (temp= sqlddl_parameter )* )? SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,42,FOLLOW_42_in_sqlddl_table284); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,43,FOLLOW_43_in_sqlddl_table287); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:276:102: (temp= identifier )
            // ./scenariotestTemp/generated2/SQLDDL.g:276:104: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_table294);
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
            match(input,LPAREN,FOLLOW_LPAREN_in_sqlddl_table301); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:276:228: ( ( (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )? ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:276:229: ( (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )? )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:276:229: ( (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )? )
            // ./scenariotestTemp/generated2/SQLDDL.g:276:230: (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:276:247: (temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NAME||(LA4_0>=47 && LA4_0<=50)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:276:249: temp= sqlddl_tableelement ( ( COMA ) temp= sqlddl_tableelement )*
                    {
                    pushFollow(FOLLOW_sqlddl_tableelement_in_sqlddl_table312);
                    temp=sqlddl_tableelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:276:312: ( ( COMA ) temp= sqlddl_tableelement )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==COMA) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:276:313: ( COMA ) temp= sqlddl_tableelement
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:276:330: ( COMA )
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:276:331: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_sqlddl_table321); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_sqlddl_tableelement_in_sqlddl_table329);
                    	    temp=sqlddl_tableelement();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "elements", temp);
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
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_sqlddl_table344); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:276:548: (temp= sqlddl_parameter (temp= sqlddl_parameter )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:276:550: temp= sqlddl_parameter (temp= sqlddl_parameter )*
                    {
                    pushFollow(FOLLOW_sqlddl_parameter_in_sqlddl_table352);
                    temp=sqlddl_parameter();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:276:612: (temp= sqlddl_parameter )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==NAME) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/SQLDDL.g:276:614: temp= sqlddl_parameter
                    	    {
                    	    pushFollow(FOLLOW_sqlddl_parameter_in_sqlddl_table360);
                    	    temp=sqlddl_parameter();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "parameters", temp);
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
              _beforeSeqEl();
            }
            match(input,SEMI,FOLLOW_SEMI_in_sqlddl_table372); if (state.failed) return ret2;
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
    // $ANTLR end "sqlddl_table"


    // $ANTLR start "sqlddl_tableelement"
    // ./scenariotestTemp/generated2/SQLDDL.g:284:1: sqlddl_tableelement returns [Object ret2] : (ret= sqlddl_column | ret= sqlddl_key ) ;
    public final Object sqlddl_tableelement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:285:3: ( (ret= sqlddl_column | ret= sqlddl_key ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:286:3: (ret= sqlddl_column | ret= sqlddl_key )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:286:3: (ret= sqlddl_column | ret= sqlddl_key )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==NAME) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=47 && LA7_0<=50)) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:286:4: ret= sqlddl_column
                    {
                    pushFollow(FOLLOW_sqlddl_column_in_sqlddl_tableelement410);
                    ret=sqlddl_column();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:287:5: ret= sqlddl_key
                    {
                    pushFollow(FOLLOW_sqlddl_key_in_sqlddl_tableelement418);
                    ret=sqlddl_key();

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
    // $ANTLR end "sqlddl_tableelement"


    // $ANTLR start "sqlddl_column"
    // ./scenariotestTemp/generated2/SQLDDL.g:294:1: sqlddl_column returns [Object ret2] : ( (temp= identifier ) (temp= sqlddl_type ) ( () | ( 'NOT' 'NULL' ) ) ( ( 'default' (temp= stringSymbol ) ) | ) ) ;
    public final Object sqlddl_column() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","Column");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:299:3: ( ( (temp= identifier ) (temp= sqlddl_type ) ( () | ( 'NOT' 'NULL' ) ) ( ( 'default' (temp= stringSymbol ) ) | ) ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:300:3: ( (temp= identifier ) (temp= sqlddl_type ) ( () | ( 'NOT' 'NULL' ) ) ( ( 'default' (temp= stringSymbol ) ) | ) )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:300:3: ( (temp= identifier ) (temp= sqlddl_type ) ( () | ( 'NOT' 'NULL' ) ) ( ( 'default' (temp= stringSymbol ) ) | ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:300:4: (temp= identifier ) (temp= sqlddl_type ) ( () | ( 'NOT' 'NULL' ) ) ( ( 'default' (temp= stringSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:300:21: (temp= identifier )
            // ./scenariotestTemp/generated2/SQLDDL.g:300:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_column452);
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
            // ./scenariotestTemp/generated2/SQLDDL.g:300:106: (temp= sqlddl_type )
            // ./scenariotestTemp/generated2/SQLDDL.g:300:108: temp= sqlddl_type
            {
            pushFollow(FOLLOW_sqlddl_type_in_sqlddl_column462);
            temp=sqlddl_type();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "type", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:300:193: ( () | ( 'NOT' 'NULL' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==EOF||(LA8_0>=COMA && LA8_0<=RPAREN)||LA8_0==46) ) {
                alt8=1;
            }
            else if ( (LA8_0==44) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:300:194: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:300:210: ()
                    // ./scenariotestTemp/generated2/SQLDDL.g:300:211: 
                    {
                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "canBeNull", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:300:285: ( 'NOT' 'NULL' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:300:301: ( 'NOT' 'NULL' )
                    // ./scenariotestTemp/generated2/SQLDDL.g:300:302: 'NOT' 'NULL'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,44,FOLLOW_44_in_sqlddl_column484); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,45,FOLLOW_45_in_sqlddl_column487); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "canBeNull", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:301:35: ( ( 'default' (temp= stringSymbol ) ) | )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==46) ) {
                alt9=1;
            }
            else if ( (LA9_0==EOF||(LA9_0>=COMA && LA9_0<=RPAREN)) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:301:36: ( 'default' (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:301:52: ( 'default' (temp= stringSymbol ) )
                    // ./scenariotestTemp/generated2/SQLDDL.g:301:53: 'default' (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,46,FOLLOW_46_in_sqlddl_column503); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:301:112: (temp= stringSymbol )
                    // ./scenariotestTemp/generated2/SQLDDL.g:301:114: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_sqlddl_column510);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:301:203: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

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
    // $ANTLR end "sqlddl_column"


    // $ANTLR start "sqlddl_key"
    // ./scenariotestTemp/generated2/SQLDDL.g:310:1: sqlddl_key returns [Object ret2] : (ret= sqlddl_simplekey | ret= sqlddl_primarykey | ret= sqlddl_foreignkey ) ;
    public final Object sqlddl_key() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:311:3: ( (ret= sqlddl_simplekey | ret= sqlddl_primarykey | ret= sqlddl_foreignkey ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:312:3: (ret= sqlddl_simplekey | ret= sqlddl_primarykey | ret= sqlddl_foreignkey )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:312:3: (ret= sqlddl_simplekey | ret= sqlddl_primarykey | ret= sqlddl_foreignkey )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 47:
            case 48:
                {
                alt10=1;
                }
                break;
            case 49:
                {
                alt10=2;
                }
                break;
            case 50:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:312:4: ret= sqlddl_simplekey
                    {
                    pushFollow(FOLLOW_sqlddl_simplekey_in_sqlddl_key563);
                    ret=sqlddl_simplekey();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:313:5: ret= sqlddl_primarykey
                    {
                    pushFollow(FOLLOW_sqlddl_primarykey_in_sqlddl_key571);
                    ret=sqlddl_primarykey();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:314:5: ret= sqlddl_foreignkey
                    {
                    pushFollow(FOLLOW_sqlddl_foreignkey_in_sqlddl_key579);
                    ret=sqlddl_foreignkey();

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
    // $ANTLR end "sqlddl_key"


    // $ANTLR start "sqlddl_simplekey"
    // ./scenariotestTemp/generated2/SQLDDL.g:321:1: sqlddl_simplekey returns [Object ret2] : ( ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN ) ;
    public final Object sqlddl_simplekey() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","SimpleKey");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:326:3: ( ( ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:327:3: ( ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:327:3: ( ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN )
            // ./scenariotestTemp/generated2/SQLDDL.g:327:4: ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:327:22: ( ( 'UNIQUE' ) | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==47) ) {
                alt11=1;
            }
            else if ( (LA11_0==48) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:327:23: ( 'UNIQUE' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:327:39: ( 'UNIQUE' )
                    // ./scenariotestTemp/generated2/SQLDDL.g:327:40: 'UNIQUE'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,47,FOLLOW_47_in_sqlddl_simplekey615); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:327:154: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,48,FOLLOW_48_in_sqlddl_simplekey633); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:328:73: ( ( (temp= identifier ) ) | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NAME) ) {
                alt12=1;
            }
            else if ( (LA12_0==LPAREN) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:328:74: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:328:90: ( (temp= identifier ) )
                    // ./scenariotestTemp/generated2/SQLDDL.g:328:91: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:328:108: (temp= identifier )
                    // ./scenariotestTemp/generated2/SQLDDL.g:328:110: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_sqlddl_simplekey646);
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

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:328:194: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_sqlddl_simplekey666); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:329:75: (temp= identifier ( ( COMA ) temp= identifier )* )
            // ./scenariotestTemp/generated2/SQLDDL.g:329:77: temp= identifier ( ( COMA ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_simplekey674);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:329:192: ( ( COMA ) temp= identifier )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==COMA) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/SQLDDL.g:329:193: ( COMA ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/SQLDDL.g:329:210: ( COMA )
            	    // ./scenariotestTemp/generated2/SQLDDL.g:329:211: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_sqlddl_simplekey683); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_sqlddl_simplekey691);
            	    temp=identifier();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_sqlddl_simplekey701); if (state.failed) return ret2;
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
    // $ANTLR end "sqlddl_simplekey"


    // $ANTLR start "sqlddl_primarykey"
    // ./scenariotestTemp/generated2/SQLDDL.g:337:1: sqlddl_primarykey returns [Object ret2] : ( 'PRIMARY' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN ) ;
    public final Object sqlddl_primarykey() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","PrimaryKey");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:342:3: ( ( 'PRIMARY' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:343:3: ( 'PRIMARY' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:343:3: ( 'PRIMARY' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN )
            // ./scenariotestTemp/generated2/SQLDDL.g:343:4: 'PRIMARY' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,49,FOLLOW_49_in_sqlddl_primarykey742); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:343:64: ( ( 'UNIQUE' ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==47) ) {
                alt14=1;
            }
            else if ( (LA14_0==48) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:343:65: ( 'UNIQUE' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:343:81: ( 'UNIQUE' )
                    // ./scenariotestTemp/generated2/SQLDDL.g:343:82: 'UNIQUE'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,47,FOLLOW_47_in_sqlddl_primarykey751); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:343:196: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,48,FOLLOW_48_in_sqlddl_primarykey769); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:344:73: ( ( (temp= identifier ) ) | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NAME) ) {
                alt15=1;
            }
            else if ( (LA15_0==LPAREN) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:344:74: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:344:90: ( (temp= identifier ) )
                    // ./scenariotestTemp/generated2/SQLDDL.g:344:91: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:344:108: (temp= identifier )
                    // ./scenariotestTemp/generated2/SQLDDL.g:344:110: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_sqlddl_primarykey782);
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

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:344:194: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_sqlddl_primarykey802); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:345:75: (temp= identifier ( ( COMA ) temp= identifier )* )
            // ./scenariotestTemp/generated2/SQLDDL.g:345:77: temp= identifier ( ( COMA ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_primarykey810);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:345:192: ( ( COMA ) temp= identifier )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==COMA) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/SQLDDL.g:345:193: ( COMA ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/SQLDDL.g:345:210: ( COMA )
            	    // ./scenariotestTemp/generated2/SQLDDL.g:345:211: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_sqlddl_primarykey819); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_sqlddl_primarykey827);
            	    temp=identifier();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_sqlddl_primarykey837); if (state.failed) return ret2;
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
    // $ANTLR end "sqlddl_primarykey"


    // $ANTLR start "sqlddl_foreignkey"
    // ./scenariotestTemp/generated2/SQLDDL.g:353:1: sqlddl_foreignkey returns [Object ret2] : ( 'FOREIGN' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN 'REFERENCES' (temp= identifier ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN ) ;
    public final Object sqlddl_foreignkey() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","ForeignKey");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:358:3: ( ( 'FOREIGN' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN 'REFERENCES' (temp= identifier ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:359:3: ( 'FOREIGN' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN 'REFERENCES' (temp= identifier ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:359:3: ( 'FOREIGN' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN 'REFERENCES' (temp= identifier ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN )
            // ./scenariotestTemp/generated2/SQLDDL.g:359:4: 'FOREIGN' ( ( 'UNIQUE' ) | ) 'KEY' ( ( (temp= identifier ) ) | ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN 'REFERENCES' (temp= identifier ) LPAREN (temp= identifier ( ( COMA ) temp= identifier )* ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,50,FOLLOW_50_in_sqlddl_foreignkey878); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:359:64: ( ( 'UNIQUE' ) | )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==47) ) {
                alt17=1;
            }
            else if ( (LA17_0==48) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:359:65: ( 'UNIQUE' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:359:81: ( 'UNIQUE' )
                    // ./scenariotestTemp/generated2/SQLDDL.g:359:82: 'UNIQUE'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,47,FOLLOW_47_in_sqlddl_foreignkey887); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:359:196: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,48,FOLLOW_48_in_sqlddl_foreignkey905); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:360:73: ( ( (temp= identifier ) ) | )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==NAME) ) {
                alt18=1;
            }
            else if ( (LA18_0==LPAREN) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:360:74: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:360:90: ( (temp= identifier ) )
                    // ./scenariotestTemp/generated2/SQLDDL.g:360:91: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:360:108: (temp= identifier )
                    // ./scenariotestTemp/generated2/SQLDDL.g:360:110: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_sqlddl_foreignkey918);
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

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:360:194: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_sqlddl_foreignkey938); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:361:75: (temp= identifier ( ( COMA ) temp= identifier )* )
            // ./scenariotestTemp/generated2/SQLDDL.g:361:77: temp= identifier ( ( COMA ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_foreignkey946);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:361:192: ( ( COMA ) temp= identifier )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/SQLDDL.g:361:193: ( COMA ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/SQLDDL.g:361:210: ( COMA )
            	    // ./scenariotestTemp/generated2/SQLDDL.g:361:211: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_sqlddl_foreignkey955); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_sqlddl_foreignkey963);
            	    temp=identifier();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);
            	    }

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_sqlddl_foreignkey973); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,51,FOLLOW_51_in_sqlddl_foreignkey977); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:361:505: (temp= identifier )
            // ./scenariotestTemp/generated2/SQLDDL.g:361:507: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_foreignkey984);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "referencedTable", list("SQLDDL","Table"), "name", temp, null, "never", null, false, null);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_sqlddl_foreignkey991); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:361:703: (temp= identifier ( ( COMA ) temp= identifier )* )
            // ./scenariotestTemp/generated2/SQLDDL.g:361:705: temp= identifier ( ( COMA ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_foreignkey999);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "referencedColumns", list("SQLDDL","Column"), "name", temp, "referencedTable", "never", null, false, null);
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:361:843: ( ( COMA ) temp= identifier )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/SQLDDL.g:361:844: ( COMA ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/SQLDDL.g:361:861: ( COMA )
            	    // ./scenariotestTemp/generated2/SQLDDL.g:361:862: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_sqlddl_foreignkey1008); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_sqlddl_foreignkey1016);
            	    temp=identifier();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setRef(ret, "referencedColumns", list("SQLDDL","Column"), "name", temp, "referencedTable", "never", null, false, null);
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_sqlddl_foreignkey1026); if (state.failed) return ret2;
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
    // $ANTLR end "sqlddl_foreignkey"


    // $ANTLR start "sqlddl_type"
    // ./scenariotestTemp/generated2/SQLDDL.g:369:1: sqlddl_type returns [Object ret2] : ( (temp= identifier ) ( ( LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN ) | ) ( ( 'unsigned' ) | ) ) ;
    public final Object sqlddl_type() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","Type");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:374:3: ( ( (temp= identifier ) ( ( LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN ) | ) ( ( 'unsigned' ) | ) ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:375:3: ( (temp= identifier ) ( ( LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN ) | ) ( ( 'unsigned' ) | ) )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:375:3: ( (temp= identifier ) ( ( LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN ) | ) ( ( 'unsigned' ) | ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:375:4: (temp= identifier ) ( ( LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN ) | ) ( ( 'unsigned' ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:375:21: (temp= identifier )
            // ./scenariotestTemp/generated2/SQLDDL.g:375:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_type1071);
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
            // ./scenariotestTemp/generated2/SQLDDL.g:375:107: ( ( LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN ) | )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LPAREN) ) {
                alt23=1;
            }
            else if ( (LA23_0==EOF||(LA23_0>=COMA && LA23_0<=RPAREN)||LA23_0==44||LA23_0==46||LA23_0==52) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:375:108: ( LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:375:124: ( LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN )
                    // ./scenariotestTemp/generated2/SQLDDL.g:375:125: LPAREN (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )? RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_sqlddl_type1084); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:375:183: (temp= integerSymbol ( ( COMA ) temp= integerSymbol )? )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==INT) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // ./scenariotestTemp/generated2/SQLDDL.g:375:185: temp= integerSymbol ( ( COMA ) temp= integerSymbol )?
                            {
                            pushFollow(FOLLOW_integerSymbol_in_sqlddl_type1092);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "length", temp);
                            }
                            // ./scenariotestTemp/generated2/SQLDDL.g:375:240: ( ( COMA ) temp= integerSymbol )?
                            int alt21=2;
                            int LA21_0 = input.LA(1);

                            if ( (LA21_0==COMA) ) {
                                alt21=1;
                            }
                            switch (alt21) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/SQLDDL.g:375:241: ( COMA ) temp= integerSymbol
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterSepSeq();
                                    }
                                    // ./scenariotestTemp/generated2/SQLDDL.g:375:258: ( COMA )
                                    // ./scenariotestTemp/generated2/SQLDDL.g:375:259: COMA
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl();
                                    }
                                    match(input,COMA,FOLLOW_COMA_in_sqlddl_type1101); if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }

                                    }

                                    if ( state.backtracking==0 ) {
                                      _exitSepSeq();
                                    }
                                    pushFollow(FOLLOW_integerSymbol_in_sqlddl_type1109);
                                    temp=integerSymbol();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "length", temp);
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
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_sqlddl_type1120); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:375:450: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:376:35: ( ( 'unsigned' ) | )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==52) ) {
                alt24=1;
            }
            else if ( (LA24_0==EOF||(LA24_0>=COMA && LA24_0<=RPAREN)||LA24_0==44||LA24_0==46) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:376:36: ( 'unsigned' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:376:52: ( 'unsigned' )
                    // ./scenariotestTemp/generated2/SQLDDL.g:376:53: 'unsigned'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,52,FOLLOW_52_in_sqlddl_type1143); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnsigned", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:376:171: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnsigned", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

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
    // $ANTLR end "sqlddl_type"


    // $ANTLR start "sqlddl_parameter"
    // ./scenariotestTemp/generated2/SQLDDL.g:385:1: sqlddl_parameter returns [Object ret2] : ( (temp= identifier ) ( ( EQ (temp= sqlddl_value ) ) | ) ) ;
    public final Object sqlddl_parameter() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","Parameter");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:390:3: ( ( (temp= identifier ) ( ( EQ (temp= sqlddl_value ) ) | ) ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:391:3: ( (temp= identifier ) ( ( EQ (temp= sqlddl_value ) ) | ) )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:391:3: ( (temp= identifier ) ( ( EQ (temp= sqlddl_value ) ) | ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:391:4: (temp= identifier ) ( ( EQ (temp= sqlddl_value ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:391:21: (temp= identifier )
            // ./scenariotestTemp/generated2/SQLDDL.g:391:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_sqlddl_parameter1202);
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
            // ./scenariotestTemp/generated2/SQLDDL.g:391:107: ( ( EQ (temp= sqlddl_value ) ) | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==EQ) ) {
                alt25=1;
            }
            else if ( (LA25_0==EOF||LA25_0==NAME||LA25_0==SEMI) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:391:108: ( EQ (temp= sqlddl_value ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:391:124: ( EQ (temp= sqlddl_value ) )
                    // ./scenariotestTemp/generated2/SQLDDL.g:391:125: EQ (temp= sqlddl_value )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_sqlddl_parameter1215); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/SQLDDL.g:391:179: (temp= sqlddl_value )
                    // ./scenariotestTemp/generated2/SQLDDL.g:391:181: temp= sqlddl_value
                    {
                    pushFollow(FOLLOW_sqlddl_value_in_sqlddl_parameter1223);
                    temp=sqlddl_value();

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
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:391:268: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

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
    // $ANTLR end "sqlddl_parameter"


    // $ANTLR start "sqlddl_value"
    // ./scenariotestTemp/generated2/SQLDDL.g:400:1: sqlddl_value returns [Object ret2] : (ret= sqlddl_integerval | ret= sqlddl_nullval | ret= sqlddl_stringval ) ;
    public final Object sqlddl_value() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:401:3: ( (ret= sqlddl_integerval | ret= sqlddl_nullval | ret= sqlddl_stringval ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:402:3: (ret= sqlddl_integerval | ret= sqlddl_nullval | ret= sqlddl_stringval )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:402:3: (ret= sqlddl_integerval | ret= sqlddl_nullval | ret= sqlddl_stringval )
            int alt26=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt26=1;
                }
                break;
            case 45:
                {
                alt26=2;
                }
                break;
            case STRING:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:402:4: ret= sqlddl_integerval
                    {
                    pushFollow(FOLLOW_sqlddl_integerval_in_sqlddl_value1276);
                    ret=sqlddl_integerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:403:5: ret= sqlddl_nullval
                    {
                    pushFollow(FOLLOW_sqlddl_nullval_in_sqlddl_value1284);
                    ret=sqlddl_nullval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/SQLDDL.g:404:5: ret= sqlddl_stringval
                    {
                    pushFollow(FOLLOW_sqlddl_stringval_in_sqlddl_value1292);
                    ret=sqlddl_stringval();

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
    // $ANTLR end "sqlddl_value"


    // $ANTLR start "sqlddl_integerval"
    // ./scenariotestTemp/generated2/SQLDDL.g:411:1: sqlddl_integerval returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object sqlddl_integerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","IntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:416:3: ( ( (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:417:3: ( (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:417:3: ( (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:417:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:417:21: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/SQLDDL.g:417:23: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_sqlddl_integerval1326);
            temp=integerSymbol();

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
    // $ANTLR end "sqlddl_integerval"


    // $ANTLR start "sqlddl_nullval"
    // ./scenariotestTemp/generated2/SQLDDL.g:425:1: sqlddl_nullval returns [Object ret2] : ( 'NULL' ) ;
    public final Object sqlddl_nullval() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("SQLDDL","NullVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:430:3: ( ( 'NULL' ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:431:3: ( 'NULL' )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:431:3: ( 'NULL' )
            // ./scenariotestTemp/generated2/SQLDDL.g:431:4: 'NULL'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,45,FOLLOW_45_in_sqlddl_nullval1369); if (state.failed) return ret2;
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
    // $ANTLR end "sqlddl_nullval"


    // $ANTLR start "sqlddl_stringval"
    // ./scenariotestTemp/generated2/SQLDDL.g:439:1: sqlddl_stringval returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object sqlddl_stringval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("SQLDDL","StringVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/SQLDDL.g:444:3: ( ( (temp= stringSymbol ) ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:445:3: ( (temp= stringSymbol ) )
            {
            // ./scenariotestTemp/generated2/SQLDDL.g:445:3: ( (temp= stringSymbol ) )
            // ./scenariotestTemp/generated2/SQLDDL.g:445:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/SQLDDL.g:445:21: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/SQLDDL.g:445:23: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_sqlddl_stringval1413);
            temp=stringSymbol();

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
    // $ANTLR end "sqlddl_stringval"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_database_in_main190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_table_in_sqlddl_database228 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_sqlddl_table_in_sqlddl_database236 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_sqlddl_table284 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_sqlddl_table287 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_table294 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_sqlddl_table301 = new BitSet(new long[]{0x0007800000000410L});
    public static final BitSet FOLLOW_sqlddl_tableelement_in_sqlddl_table312 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_sqlddl_table321 = new BitSet(new long[]{0x0007800000000010L});
    public static final BitSet FOLLOW_sqlddl_tableelement_in_sqlddl_table329 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RPAREN_in_sqlddl_table344 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_sqlddl_parameter_in_sqlddl_table352 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_sqlddl_parameter_in_sqlddl_table360 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_SEMI_in_sqlddl_table372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_column_in_sqlddl_tableelement410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_key_in_sqlddl_tableelement418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_column452 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_sqlddl_type_in_sqlddl_column462 = new BitSet(new long[]{0x0000500000000002L});
    public static final BitSet FOLLOW_44_in_sqlddl_column484 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_sqlddl_column487 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_sqlddl_column503 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_sqlddl_column510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_simplekey_in_sqlddl_key563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_primarykey_in_sqlddl_key571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_foreignkey_in_sqlddl_key579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_sqlddl_simplekey615 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_sqlddl_simplekey633 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_simplekey646 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_sqlddl_simplekey666 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_simplekey674 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_sqlddl_simplekey683 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_simplekey691 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RPAREN_in_sqlddl_simplekey701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_sqlddl_primarykey742 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_47_in_sqlddl_primarykey751 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_sqlddl_primarykey769 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_primarykey782 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_sqlddl_primarykey802 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_primarykey810 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_sqlddl_primarykey819 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_primarykey827 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RPAREN_in_sqlddl_primarykey837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_sqlddl_foreignkey878 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_47_in_sqlddl_foreignkey887 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_sqlddl_foreignkey905 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_foreignkey918 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_sqlddl_foreignkey938 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_foreignkey946 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_sqlddl_foreignkey955 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_foreignkey963 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RPAREN_in_sqlddl_foreignkey973 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_sqlddl_foreignkey977 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_foreignkey984 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_sqlddl_foreignkey991 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_foreignkey999 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_sqlddl_foreignkey1008 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_foreignkey1016 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RPAREN_in_sqlddl_foreignkey1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_type1071 = new BitSet(new long[]{0x0010000000000102L});
    public static final BitSet FOLLOW_LPAREN_in_sqlddl_type1084 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_integerSymbol_in_sqlddl_type1092 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_sqlddl_type1101 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_sqlddl_type1109 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_sqlddl_type1120 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_sqlddl_type1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_sqlddl_parameter1202 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_EQ_in_sqlddl_parameter1215 = new BitSet(new long[]{0x0000200000000060L});
    public static final BitSet FOLLOW_sqlddl_value_in_sqlddl_parameter1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_integerval_in_sqlddl_value1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_nullval_in_sqlddl_value1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sqlddl_stringval_in_sqlddl_value1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_sqlddl_integerval1326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_sqlddl_nullval1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_sqlddl_stringval1413 = new BitSet(new long[]{0x0000000000000002L});

}