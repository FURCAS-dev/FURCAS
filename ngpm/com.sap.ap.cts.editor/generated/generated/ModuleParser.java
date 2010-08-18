// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g 2010-03-03 09:14:40

package generated;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;

public class ModuleParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "BOOL", "BINARY", "DATE", "COMMENT", "MULTI_LINE_COMMENT", "LBRACKET", "RBRACKET", "LCURL", "RCURL", "LANGLE", "RANGLE", "LPAREN", "RPAREN", "EXCL", "EQUALS", "EQUALSEQUALS", "ASSIGN", "DOT", "DDOT", "ARROW", "PIPE", "COLON", "DCOLON", "SEMICOLON", "INCLUDING", "EXCLUDING", "INCLUDINGAT", "EXCLUDINGAT", "ITERATE", "LCURL_LBRACK", "LBRACK_LCURL", "RCURL_RBRACK", "RBRACK_RCURL", "STAR", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "OBJECT", "RANGE_OR_INT"
    };
    public static final int EXCLUDINGAT=35;
    public static final int STAR=41;
    public static final int RBRACK_RCURL=40;
    public static final int LANGLE=17;
    public static final int FLOAT=7;
    public static final int EXCL=21;
    public static final int EQUALS=22;
    public static final int INCLUDINGAT=34;
    public static final int EOF=-1;
    public static final int LPAREN=19;
    public static final int LBRACKET=13;
    public static final int RPAREN=20;
    public static final int NAME=4;
    public static final int DCOLON=30;
    public static final int OBJECT=47;
    public static final int LBRACK_LCURL=38;
    public static final int PIPE=28;
    public static final int DIGIT=44;
    public static final int NL=42;
    public static final int RANGE_OR_INT=48;
    public static final int RANGLE=18;
    public static final int RBRACKET=14;
    public static final int COMMENT=11;
    public static final int DOT=25;
    public static final int EQUALSEQUALS=23;
    public static final int RCURL_RBRACK=39;
    public static final int LCURL_LBRACK=37;
    public static final int DDOT=26;
    public static final int BOOL=8;
    public static final int INT=6;
    public static final int SEMICOLON=31;
    public static final int EXCLUDING=33;
    public static final int MULTI_LINE_COMMENT=12;
    public static final int ALPHA=45;
    public static final int COLON=29;
    public static final int ITERATE=36;
    public static final int LCURL=15;
    public static final int WS=43;
    public static final int SNAME=46;
    public static final int RCURL=16;
    public static final int ASSIGN=24;
    public static final int ARROW=27;
    public static final int BINARY=9;
    public static final int DATE=10;
    public static final int INCLUDING=32;
    public static final int STRING=5;

    // delegates
    // delegators


        public ModuleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ModuleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ModuleParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g"; }


       private static final String syntaxUUID = "E012BF1ECFAC8D70269C11DF8247DB7F8D1505E2";
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:208:3: ( (ast= NAME ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:209:3: (ast= NAME )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:209:3: (ast= NAME )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:209:4: ast= NAME
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:218:3: ( (ast= NAME ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:219:3: (ast= NAME )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:219:3: (ast= NAME )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:219:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword94); 
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
    // $ANTLR end "identifierOrKeyword"


    // $ANTLR start "stringSymbol"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:227:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:228:3: ( (ast= STRING ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:229:3: (ast= STRING )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:229:3: (ast= STRING )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:229:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol125); 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:237:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:238:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:239:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:239:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:239:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol156); 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:247:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:248:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:249:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:249:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:249:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol187); 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:257:1: integerAsStringSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:258:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:259:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:259:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:259:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsStringSymbol218); 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:267:1: floatAsStringSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:268:3: ( (ast= FLOAT ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:269:3: (ast= FLOAT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:269:3: (ast= FLOAT )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:269:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsStringSymbol249); 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:277:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:278:3: ( (ast= BOOL ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:279:3: (ast= BOOL )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:279:3: (ast= BOOL )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:279:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol280); 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:287:1: binarySymbol returns [Object ret2] : (ast= BINARY ) ;
    public final Object binarySymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:288:3: ( (ast= BINARY ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:289:3: (ast= BINARY )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:289:3: (ast= BINARY )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:289:4: ast= BINARY
            {
            ast=(Token)match(input,BINARY,FOLLOW_BINARY_in_binarySymbol311); 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:297:1: dateSymbol returns [Object ret2] : (ast= DATE ) ;
    public final Object dateSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:298:3: ( (ast= DATE ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:299:3: (ast= DATE )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:299:3: (ast= DATE )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:299:4: ast= DATE
            {
            ast=(Token)match(input,DATE,FOLLOW_DATE_in_dateSymbol342); 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:307:1: main returns [Object ret2] : ( (ret= modelmanagement_module ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:308:3: ( ( (ret= modelmanagement_module ) EOF ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:309:3: ( (ret= modelmanagement_module ) EOF )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:309:3: ( (ret= modelmanagement_module ) EOF )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:309:4: (ret= modelmanagement_module ) EOF
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:309:4: (ret= modelmanagement_module )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:309:5: ret= modelmanagement_module
            {
            pushFollow(FOLLOW_modelmanagement_module_in_main370);
            ret=modelmanagement_module();

            checkFollows();
            state._fsp--;


            }

            match(input,EOF,FOLLOW_EOF_in_main373); 

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


    // $ANTLR start "modelmanagement_module"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:316:1: modelmanagement_module returns [Object ret2] : () ;
    public final Object modelmanagement_module() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("modelmanagement","Module");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"root"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:321:3: ( () )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:322:3: ()
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:322:3: ()
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.ap.cts.editor\\generated\\generated\\Module.g:322:4: 
            {
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
    // $ANTLR end "modelmanagement_module"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsStringSymbol218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsStringSymbol249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_binarySymbol311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_in_dateSymbol342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modelmanagement_module_in_main370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main373 = new BitSet(new long[]{0x0000000000000002L});

}