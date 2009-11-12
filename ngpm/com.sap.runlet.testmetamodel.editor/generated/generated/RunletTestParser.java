// $ANTLR 3.1.1 C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g 2009-08-18 08:44:40

package generated;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RunletTestParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "BOOL", "BINARY", "DATE", "LCURL", "SEMICOLON", "RCURL", "COMMENT", "MULTI_LINE_COMMENT", "LBRACKET", "RBRACKET", "LANGLE", "RANGLE", "LPAREN", "RPAREN", "EXCL", "EQUALS", "EQUALSEQUALS", "ASSIGN", "DOT", "DDOT", "ARROW", "PIPE", "COLON", "DCOLON", "INCLUDING", "EXCLUDING", "INCLUDINGAT", "EXCLUDINGAT", "ITERATE", "LCURL_LBRACK", "LBRACK_LCURL", "RCURL_RBRACK", "RBRACK_RCURL", "STAR", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "OBJECT", "RANGE_OR_INT", "'sub'", "'runlettest'"
    };
    public static final int EXCLUDINGAT=35;
    public static final int STAR=41;
    public static final int RBRACK_RCURL=40;
    public static final int LANGLE=18;
    public static final int FLOAT=7;
    public static final int EXCL=22;
    public static final int EQUALS=23;
    public static final int INCLUDINGAT=34;
    public static final int EOF=-1;
    public static final int LPAREN=20;
    public static final int LBRACKET=16;
    public static final int RPAREN=21;
    public static final int NAME=4;
    public static final int DCOLON=31;
    public static final int OBJECT=47;
    public static final int LBRACK_LCURL=38;
    public static final int PIPE=29;
    public static final int DIGIT=44;
    public static final int NL=42;
    public static final int RANGE_OR_INT=48;
    public static final int RBRACKET=17;
    public static final int RANGLE=19;
    public static final int COMMENT=14;
    public static final int DOT=26;
    public static final int T__50=50;
    public static final int EQUALSEQUALS=24;
    public static final int RCURL_RBRACK=39;
    public static final int LCURL_LBRACK=37;
    public static final int DDOT=27;
    public static final int T__49=49;
    public static final int BOOL=8;
    public static final int SEMICOLON=12;
    public static final int INT=6;
    public static final int EXCLUDING=33;
    public static final int MULTI_LINE_COMMENT=15;
    public static final int ALPHA=45;
    public static final int COLON=30;
    public static final int ITERATE=36;
    public static final int LCURL=11;
    public static final int WS=43;
    public static final int SNAME=46;
    public static final int RCURL=13;
    public static final int ASSIGN=25;
    public static final int ARROW=28;
    public static final int BINARY=9;
    public static final int DATE=10;
    public static final int INCLUDING=32;
    public static final int STRING=5;

    // delegates
    // delegators


        public RunletTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RunletTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return RunletTestParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g"; }


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
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:201:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:202:3: ( (ast= NAME ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:203:3: (ast= NAME )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:203:3: (ast= NAME )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:203:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier63); 
            ret = unescapeString( ast.getText());


            }


            ret2=ret;


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


    // $ANTLR start "identifierOrKeyword"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:211:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'sub' | 'runlettest' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:212:3: ( (ast= NAME | 'sub' | 'runlettest' ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:213:3: (ast= NAME | 'sub' | 'runlettest' )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:213:3: (ast= NAME | 'sub' | 'runlettest' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 49:
                {
                alt1=2;
                }
                break;
            case 50:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:213:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword94); 
                    ret = unescapeString( ast.getText());


                    }
                    break;
                case 2 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:215:5: 'sub'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword102); 
                    ret = "sub";

                    }
                    break;
                case 3 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:216:5: 'runlettest'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword110); 
                    ret = "runlettest";

                    }
                    break;

            }


            ret2=ret;


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
    // $ANTLR end "identifierOrKeyword"


    // $ANTLR start "stringSymbol"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:223:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:224:3: ( (ast= STRING ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:225:3: (ast= STRING )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:225:3: (ast= STRING )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:225:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol141); 
            ret = unescapeString( ast.getText());


            }


            ret2=ret;


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
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:233:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:234:3: ( (ast= INT ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:235:3: (ast= INT )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:235:3: (ast= INT )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:235:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol172); 
            ret = Integer.valueOf( ast.getText());


            }


            ret2=ret;


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


    // $ANTLR start "longSymbol"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:243:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:244:3: ( (ast= INT ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:245:3: (ast= INT )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:245:3: (ast= INT )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:245:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol203); 
            ret = Long.valueOf( ast.getText());


            }


            ret2=ret;


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
    // $ANTLR end "longSymbol"


    // $ANTLR start "integerAsStringSymbol"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:253:1: integerAsStringSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:254:3: ( (ast= INT ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:255:3: (ast= INT )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:255:3: (ast= INT )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:255:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsStringSymbol234); 
            ret =  ast.getText();


            }


            ret2=ret;


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
    // $ANTLR end "integerAsStringSymbol"


    // $ANTLR start "floatAsStringSymbol"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:263:1: floatAsStringSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:264:3: ( (ast= FLOAT ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:265:3: (ast= FLOAT )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:265:3: (ast= FLOAT )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:265:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsStringSymbol265); 
            ret =  ast.getText();


            }


            ret2=ret;


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
    // $ANTLR end "floatAsStringSymbol"


    // $ANTLR start "booleanSymbol"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:273:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:274:3: ( (ast= BOOL ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:275:3: (ast= BOOL )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:275:3: (ast= BOOL )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:275:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol296); 
            ret =  ast.getText();


            }


            ret2=ret;


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
    // $ANTLR end "booleanSymbol"


    // $ANTLR start "binarySymbol"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:283:1: binarySymbol returns [Object ret2] : (ast= BINARY ) ;
    public final Object binarySymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:284:3: ( (ast= BINARY ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:285:3: (ast= BINARY )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:285:3: (ast= BINARY )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:285:4: ast= BINARY
            {
            ast=(Token)match(input,BINARY,FOLLOW_BINARY_in_binarySymbol327); 
            ret =  ast.getText();


            }


            ret2=ret;


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
    // $ANTLR end "binarySymbol"


    // $ANTLR start "dateSymbol"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:293:1: dateSymbol returns [Object ret2] : (ast= DATE ) ;
    public final Object dateSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:294:3: ( (ast= DATE ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:295:3: (ast= DATE )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:295:3: (ast= DATE )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:295:4: ast= DATE
            {
            ast=(Token)match(input,DATE,FOLLOW_DATE_in_dateSymbol358); 
            ret =  ast.getText();


            }


            ret2=ret;


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
    // $ANTLR end "dateSymbol"


    // $ANTLR start "main"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:303:1: main returns [Object ret2] : ( (ret= runlettest_runlettest ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:304:3: ( ( (ret= runlettest_runlettest ) EOF ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:305:3: ( (ret= runlettest_runlettest ) EOF )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:305:3: ( (ret= runlettest_runlettest ) EOF )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:305:4: (ret= runlettest_runlettest ) EOF
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:305:4: (ret= runlettest_runlettest )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:305:5: ret= runlettest_runlettest
            {
            pushFollow(FOLLOW_runlettest_runlettest_in_main386);
            ret=runlettest_runlettest();

            checkFollows();
            state._fsp--;


            }

            match(input,EOF,FOLLOW_EOF_in_main389); 

            }


            ret2=ret;


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


    // $ANTLR start "runlettest_runlettest"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:312:1: runlettest_runlettest returns [Object ret2] : ( 'runlettest' (temp= identifier ) LCURL ( ( (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )? ) ) RCURL ) ;
    public final Object runlettest_runlettest() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("runlettest","RunletTest");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"root"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:317:3: ( ( 'runlettest' (temp= identifier ) LCURL ( ( (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )? ) ) RCURL ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:3: ( 'runlettest' (temp= identifier ) LCURL ( ( (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )? ) ) RCURL )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:3: ( 'runlettest' (temp= identifier ) LCURL ( ( (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )? ) ) RCURL )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:4: 'runlettest' (temp= identifier ) LCURL ( ( (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )? ) ) RCURL
            {
            _beforeSeqEl("E064D8BE8ADBF2018BC211DEA79400016CE99C52");
            match(input,50,FOLLOW_50_in_runlettest_runlettest420); 
            _afterSeqEl();
            _beforeSeqEl("E064D8BE8ADBF2038BC211DE822700016CE99C52");
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:150: (temp= identifier )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:152: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_runlettest_runlettest427);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();
            _beforeSeqEl("E064D8BE8ADBF2048BC211DEC31E00016CE99C52");
            match(input,LCURL,FOLLOW_LCURL_in_runlettest_runlettest434); 
            _afterSeqEl();
            _beforeSeqEl("E064D8BE8ADBF20B8BC211DEC53000016CE99C52");
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:359: ( ( (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )? ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:360: ( (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )? )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:360: ( (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )? )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:361: (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )?
            {
            _beforeSeqEl("E064D8BE8ADBF2098BC211DE9D7900016CE99C52");
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:420: (temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==49) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:422: temp= runlettest_subcomponent ( ( SEMICOLON ) temp= runlettest_subcomponent )*
                    {
                    pushFollow(FOLLOW_runlettest_subcomponent_in_runlettest_runlettest445);
                    temp=runlettest_subcomponent();

                    checkFollows();
                    state._fsp--;

                    setProperty(ret, "sub", temp);
                    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:484: ( ( SEMICOLON ) temp= runlettest_subcomponent )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==SEMICOLON) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:485: ( SEMICOLON ) temp= runlettest_subcomponent
                    	    {
                    	    _enterSepSeq();
                    	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:502: ( SEMICOLON )
                    	    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:318:503: SEMICOLON
                    	    {
                    	    _beforeSeqEl("E064D8BE8ADBF2068BC211DEB9C000016CE99C52");
                    	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_runlettest_runlettest454); 
                    	    _afterSeqEl();

                    	    }

                    	    _exitSepSeq();
                    	    pushFollow(FOLLOW_runlettest_subcomponent_in_runlettest_runlettest462);
                    	    temp=runlettest_subcomponent();

                    	    checkFollows();
                    	    state._fsp--;

                    	    setProperty(ret, "sub", temp);

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            _afterSeqEl();

            }


            }

            _afterSeqEl();
            _beforeSeqEl("E064D8BE8ADBF20C8BC211DE857F00016CE99C52");
            match(input,RCURL,FOLLOW_RCURL_in_runlettest_runlettest477); 
            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, true);

             

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
    // $ANTLR end "runlettest_runlettest"


    // $ANTLR start "runlettest_subcomponent"
    // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:326:1: runlettest_subcomponent returns [Object ret2] : ( 'sub' (temp= identifier ) ) ;
    public final Object runlettest_subcomponent() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("runlettest","Subcomponent");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:331:3: ( ( 'sub' (temp= identifier ) ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:332:3: ( 'sub' (temp= identifier ) )
            {
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:332:3: ( 'sub' (temp= identifier ) )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:332:4: 'sub' (temp= identifier )
            {
            _beforeSeqEl("E064D8BE8AEB34408BC211DEC56A00016CE99C52");
            match(input,49,FOLLOW_49_in_runlettest_subcomponent518); 
            _afterSeqEl();
            _beforeSeqEl("E064D8BE8AEB34428BC211DE99BA00016CE99C52");
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:332:143: (temp= identifier )
            // C:\\data\\cts\\FURCAS\\furcas_full\\ngpm\\com.sap.runlet.testmetamodel.editor\\generated\\generated\\RunletTest.g:332:145: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_runlettest_subcomponent525);
            temp=identifier();

            checkFollows();
            state._fsp--;

            setProperty(ret, "name", temp);

            }

            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, false);

             

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
    // $ANTLR end "runlettest_subcomponent"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsStringSymbol234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsStringSymbol265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_binarySymbol327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_in_dateSymbol358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_runlettest_runlettest_in_main386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_runlettest_runlettest420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_runlettest_runlettest427 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURL_in_runlettest_runlettest434 = new BitSet(new long[]{0x0002000000002000L});
    public static final BitSet FOLLOW_runlettest_subcomponent_in_runlettest_runlettest445 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_SEMICOLON_in_runlettest_runlettest454 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_runlettest_subcomponent_in_runlettest_runlettest462 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_RCURL_in_runlettest_runlettest477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_runlettest_subcomponent518 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_runlettest_subcomponent525 = new BitSet(new long[]{0x0000000000000002L});

}