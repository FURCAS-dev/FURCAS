// $ANTLR 3.1.1 C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g 2009-08-14 11:44:59

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
import java.util.Map;
import java.util.HashMap;
public class MofPackageParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "QNAME", "STRING", "MULTI_LINE_COMMENT", "INT", "BOOL", "LCURL", "RCURL", "DDOT", "STAR", "LBRACKET", "RBRACKET", "LBRACK_LCURL", "RCURL_RBRACK", "LCURL_LBRACK", "RBRACK_RCURL", "COMMENT", "LPAREN", "RPAREN", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "FLOAT", "RANGE_OR_INT", "'private'", "'readonly'", "'class'", "'<>'", "';'", "'protected'", "'->'", "'public'", "'abstract'", "'association'", "'package'"
    };
    public static final int RCURL_RBRACK=17;
    public static final int LCURL_LBRACK=18;
    public static final int T__40=40;
    public static final int STAR=13;
    public static final int DDOT=12;
    public static final int RBRACK_RCURL=19;
    public static final int BOOL=9;
    public static final int FLOAT=28;
    public static final int INT=8;
    public static final int EOF=-1;
    public static final int MULTI_LINE_COMMENT=7;
    public static final int ALPHA=26;
    public static final int LPAREN=21;
    public static final int LBRACKET=14;
    public static final int T__30=30;
    public static final int RPAREN=22;
    public static final int T__31=31;
    public static final int LCURL=10;
    public static final int T__32=32;
    public static final int NAME=4;
    public static final int WS=24;
    public static final int T__33=33;
    public static final int QNAME=5;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int SNAME=27;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RCURL=11;
    public static final int LBRACK_LCURL=16;
    public static final int DIGIT=25;
    public static final int NL=23;
    public static final int RANGE_OR_INT=29;
    public static final int RBRACKET=15;
    public static final int COMMENT=20;
    public static final int STRING=6;

    // delegates
    // delegators


        public MofPackageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MofPackageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return MofPackageParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g"; }


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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:201:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:202:3: ( (ast= NAME ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:203:3: (ast= NAME )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:203:3: (ast= NAME )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:203:4: ast= NAME
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


    // $ANTLR start "identifierOrKeyword"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:211:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'private' | 'readonly' | 'class' | '<>' | ';' | 'protected' | '->' | 'public' | 'abstract' | 'association' | 'package' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:212:3: ( (ast= NAME | 'private' | 'readonly' | 'class' | '<>' | ';' | 'protected' | '->' | 'public' | 'abstract' | 'association' | 'package' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:213:3: (ast= NAME | 'private' | 'readonly' | 'class' | '<>' | ';' | 'protected' | '->' | 'public' | 'abstract' | 'association' | 'package' )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:213:3: (ast= NAME | 'private' | 'readonly' | 'class' | '<>' | ';' | 'protected' | '->' | 'public' | 'abstract' | 'association' | 'package' )
            int alt1=12;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 30:
                {
                alt1=2;
                }
                break;
            case 31:
                {
                alt1=3;
                }
                break;
            case 32:
                {
                alt1=4;
                }
                break;
            case 33:
                {
                alt1=5;
                }
                break;
            case 34:
                {
                alt1=6;
                }
                break;
            case 35:
                {
                alt1=7;
                }
                break;
            case 36:
                {
                alt1=8;
                }
                break;
            case 37:
                {
                alt1=9;
                }
                break;
            case 38:
                {
                alt1=10;
                }
                break;
            case 39:
                {
                alt1=11;
                }
                break;
            case 40:
                {
                alt1=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:213:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:215:5: 'private'
                    {
                    match(input,30,FOLLOW_30_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "private";
                    }

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:216:5: 'readonly'
                    {
                    match(input,31,FOLLOW_31_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "readonly";
                    }

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:217:5: 'class'
                    {
                    match(input,32,FOLLOW_32_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "class";
                    }

                    }
                    break;
                case 5 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:218:5: '<>'
                    {
                    match(input,33,FOLLOW_33_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "<>";
                    }

                    }
                    break;
                case 6 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:219:5: ';'
                    {
                    match(input,34,FOLLOW_34_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = ";";
                    }

                    }
                    break;
                case 7 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:220:5: 'protected'
                    {
                    match(input,35,FOLLOW_35_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "protected";
                    }

                    }
                    break;
                case 8 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:221:5: '->'
                    {
                    match(input,36,FOLLOW_36_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "->";
                    }

                    }
                    break;
                case 9 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:222:5: 'public'
                    {
                    match(input,37,FOLLOW_37_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "public";
                    }

                    }
                    break;
                case 10 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:223:5: 'abstract'
                    {
                    match(input,38,FOLLOW_38_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 11 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:224:5: 'association'
                    {
                    match(input,39,FOLLOW_39_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "association";
                    }

                    }
                    break;
                case 12 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:225:5: 'package'
                    {
                    match(input,40,FOLLOW_40_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "package";
                    }

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
    // $ANTLR end "identifierOrKeyword"


    // $ANTLR start "qualifiedNameSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:232:1: qualifiedNameSymbol returns [Object ret2] : (ast= QNAME ) ;
    public final Object qualifiedNameSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:233:3: ( (ast= QNAME ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:234:3: (ast= QNAME )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:234:3: (ast= QNAME )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:234:4: ast= QNAME
            {
            ast=(Token)match(input,QNAME,FOLLOW_QNAME_in_qualifiedNameSymbol219); if (state.failed) return ret2;
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
    // $ANTLR end "qualifiedNameSymbol"


    // $ANTLR start "stringSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:242:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:243:3: ( (ast= STRING ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:244:3: (ast= STRING )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:244:3: (ast= STRING )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:244:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol250); if (state.failed) return ret2;
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


    // $ANTLR start "annotationSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:252:1: annotationSymbol returns [Object ret2] : (ast= MULTI_LINE_COMMENT ) ;
    public final Object annotationSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:253:3: ( (ast= MULTI_LINE_COMMENT ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:254:3: (ast= MULTI_LINE_COMMENT )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:254:3: (ast= MULTI_LINE_COMMENT )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:254:4: ast= MULTI_LINE_COMMENT
            {
            ast=(Token)match(input,MULTI_LINE_COMMENT,FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol281); if (state.failed) return ret2;
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
    // $ANTLR end "annotationSymbol"


    // $ANTLR start "integerSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:262:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:263:3: ( (ast= INT ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:264:3: (ast= INT )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:264:3: (ast= INT )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:264:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol312); if (state.failed) return ret2;
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


    // $ANTLR start "longSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:272:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:273:3: ( (ast= INT ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:274:3: (ast= INT )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:274:3: (ast= INT )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:274:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol343); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = Long.valueOf( ast.getText());

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
    // $ANTLR end "longSymbol"


    // $ANTLR start "booleanSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:282:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:283:3: ( (ast= BOOL ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:284:3: (ast= BOOL )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:284:3: (ast= BOOL )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:284:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol374); if (state.failed) return ret2;
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
    // $ANTLR end "booleanSymbol"


    // $ANTLR start "main"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:292:1: main returns [Object ret2] : ( (ret= model_package ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:293:3: ( ( (ret= model_package ) EOF ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:294:3: ( (ret= model_package ) EOF )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:294:3: ( (ret= model_package ) EOF )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:294:4: (ret= model_package ) EOF
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:294:4: (ret= model_package )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:294:5: ret= model_package
            {
            pushFollow(FOLLOW_model_package_in_main402);
            ret=model_package();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main405); if (state.failed) return ret2;

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


    // $ANTLR start "model_package"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:301:1: model_package returns [Object ret2] : ( annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL ) ;
    public final Object model_package() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Package");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:306:3: ( ( annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:3: ( annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:3: ( annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:4: annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E173D004088B711DEBD0500155883529C");
            }
            pushFollow(FOLLOW_annotation_in_model_package436);
            annotation(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E174DC92088B711DE9B6800155883529C");
            }
            match(input,40,FOLLOW_40_in_model_package440); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E176807E088B711DE8A3A00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:237: (temp= identifier )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:239: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_package447);
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
              _beforeSeqEl("E012BF1E17C4F4F088B711DE938800155883529C");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E17CC20E088B711DE9DC500155883529C");
            }
            match(input,LCURL,FOLLOW_LCURL_in_model_package456); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E1826C40088B711DE9A6400155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:521: ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:522: ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:522: ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:523: (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E17DCC2B088B711DE9B6300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:582: (temp= model_modelelement_classes (temp= model_modelelement_classes )* )?
            int alt3=2;
            switch ( input.LA(1) ) {
                case MULTI_LINE_COMMENT:
                    {
                    switch ( input.LA(2) ) {
                        case 37:
                            {
                            int LA3_3 = input.LA(3);

                            if ( (LA3_3==32||LA3_3==38) ) {
                                alt3=1;
                            }
                            }
                            break;
                        case 35:
                            {
                            int LA3_4 = input.LA(3);

                            if ( (LA3_4==32||LA3_4==38) ) {
                                alt3=1;
                            }
                            }
                            break;
                        case 30:
                            {
                            int LA3_5 = input.LA(3);

                            if ( (LA3_5==32||LA3_5==38) ) {
                                alt3=1;
                            }
                            }
                            break;
                        case 32:
                        case 38:
                            {
                            alt3=1;
                            }
                            break;
                    }

                    }
                    break;
                case 32:
                case 38:
                    {
                    alt3=1;
                    }
                    break;
                case 37:
                    {
                    int LA3_3 = input.LA(2);

                    if ( (LA3_3==32||LA3_3==38) ) {
                        alt3=1;
                    }
                    }
                    break;
                case 35:
                    {
                    int LA3_4 = input.LA(2);

                    if ( (LA3_4==32||LA3_4==38) ) {
                        alt3=1;
                    }
                    }
                    break;
                case 30:
                    {
                    int LA3_5 = input.LA(2);

                    if ( (LA3_5==32||LA3_5==38) ) {
                        alt3=1;
                    }
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:584: temp= model_modelelement_classes (temp= model_modelelement_classes )*
                    {
                    pushFollow(FOLLOW_model_modelelement_classes_in_model_package467);
                    temp=model_modelelement_classes();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "contents", temp);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:654: (temp= model_modelelement_classes )*
                    loop2:
                    do {
                        int alt2=2;
                        switch ( input.LA(1) ) {
                        case MULTI_LINE_COMMENT:
                            {
                            switch ( input.LA(2) ) {
                            case 32:
                            case 38:
                                {
                                alt2=1;
                                }
                                break;
                            case 37:
                                {
                                int LA2_3 = input.LA(3);

                                if ( (LA2_3==32||LA2_3==38) ) {
                                    alt2=1;
                                }


                                }
                                break;
                            case 35:
                                {
                                int LA2_4 = input.LA(3);

                                if ( (LA2_4==32||LA2_4==38) ) {
                                    alt2=1;
                                }


                                }
                                break;
                            case 30:
                                {
                                int LA2_5 = input.LA(3);

                                if ( (LA2_5==32||LA2_5==38) ) {
                                    alt2=1;
                                }


                                }
                                break;

                            }

                            }
                            break;
                        case 37:
                            {
                            int LA2_3 = input.LA(2);

                            if ( (LA2_3==32||LA2_3==38) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 35:
                            {
                            int LA2_4 = input.LA(2);

                            if ( (LA2_4==32||LA2_4==38) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 30:
                            {
                            int LA2_5 = input.LA(2);

                            if ( (LA2_5==32||LA2_5==38) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 32:
                        case 38:
                            {
                            alt2=1;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:656: temp= model_modelelement_classes
                    	    {
                    	    pushFollow(FOLLOW_model_modelelement_classes_in_model_package475);
                    	    temp=model_modelelement_classes();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "contents", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E17E3EEA288B711DE8AA200155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:806: (temp= model_modelelement_associations (temp= model_modelelement_associations )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=NAME && LA5_0<=QNAME)||LA5_0==MULTI_LINE_COMMENT||(LA5_0>=30 && LA5_0<=33)||(LA5_0>=35 && LA5_0<=40)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:808: temp= model_modelelement_associations (temp= model_modelelement_associations )*
                    {
                    pushFollow(FOLLOW_model_modelelement_associations_in_model_package490);
                    temp=model_modelelement_associations();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "contents", temp);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:883: (temp= model_modelelement_associations )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=NAME && LA4_0<=QNAME)||LA4_0==MULTI_LINE_COMMENT||(LA4_0>=30 && LA4_0<=33)||(LA4_0>=35 && LA4_0<=40)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:307:885: temp= model_modelelement_associations
                    	    {
                    	    pushFollow(FOLLOW_model_modelelement_associations_in_model_package498);
                    	    temp=model_modelelement_associations();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "contents", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
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
              _beforeSeqEl("E012BF1E1832AAE088B711DEC59C00155883529C");
            }
            match(input,RCURL,FOLLOW_RCURL_in_model_package513); if (state.failed) return ret2;
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
    // $ANTLR end "model_package"


    // $ANTLR start "model_modelelement_classes"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:315:1: model_modelelement_classes returns [Object ret2] : (ret= model_namespace_classes ) ;
    public final Object model_modelelement_classes() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:316:3: ( (ret= model_namespace_classes ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:317:3: (ret= model_namespace_classes )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:317:3: (ret= model_namespace_classes )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:317:4: ret= model_namespace_classes
            {
            pushFollow(FOLLOW_model_namespace_classes_in_model_modelelement_classes551);
            ret=model_namespace_classes();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_modelelement_classes"


    // $ANTLR start "model_namespace_classes"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:324:1: model_namespace_classes returns [Object ret2] : (ret= model_generalizableelement_classes ) ;
    public final Object model_namespace_classes() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:325:3: ( (ret= model_generalizableelement_classes ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:326:3: (ret= model_generalizableelement_classes )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:326:3: (ret= model_generalizableelement_classes )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:326:4: ret= model_generalizableelement_classes
            {
            pushFollow(FOLLOW_model_generalizableelement_classes_in_model_namespace_classes578);
            ret=model_generalizableelement_classes();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_namespace_classes"


    // $ANTLR start "model_generalizableelement_classes"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:333:1: model_generalizableelement_classes returns [Object ret2] : (ret= model_classifier_classes ) ;
    public final Object model_generalizableelement_classes() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:334:3: ( (ret= model_classifier_classes ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:335:3: (ret= model_classifier_classes )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:335:3: (ret= model_classifier_classes )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:335:4: ret= model_classifier_classes
            {
            pushFollow(FOLLOW_model_classifier_classes_in_model_generalizableelement_classes605);
            ret=model_classifier_classes();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_generalizableelement_classes"


    // $ANTLR start "model_classifier_classes"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:342:1: model_classifier_classes returns [Object ret2] : (ret= model_class_classes ) ;
    public final Object model_classifier_classes() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:343:3: ( (ret= model_class_classes ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:344:3: (ret= model_class_classes )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:344:3: (ret= model_class_classes )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:344:4: ret= model_class_classes
            {
            pushFollow(FOLLOW_model_class_classes_in_model_classifier_classes632);
            ret=model_class_classes();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_classifier_classes"


    // $ANTLR start "model_class_classes"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:351:1: model_class_classes returns [Object ret2] : ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';' ) ;
    public final Object model_class_classes() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Class");
        onEnterTemplateRule(metaType,"classes");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:356:3: ( ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:357:3: ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';' )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:357:3: ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:357:4: annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E186BE35088B711DEA4C100155883529C");
            }
            pushFollow(FOLLOW_annotation_in_model_class_classes662);
            annotation(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E186BE35188B711DE9B9400155883529C");
            }
            pushFollow(FOLLOW_visibility_in_model_class_classes666);
            visibility(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E189934E088B711DE937500155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:357:244: ( ( 'abstract' ) | )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==38) ) {
                alt6=1;
            }
            else if ( (LA6_0==32) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:357:245: ( 'abstract' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:357:261: ( 'abstract' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:357:262: 'abstract'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E189452E088B711DEB46200155883529C");
                    }
                    match(input,38,FOLLOW_38_in_model_class_classes676); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:357:422: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E012BF1E18A9D6B088B711DE879700155883529C");
            }
            match(input,32,FOLLOW_32_in_model_class_classes694); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18A9D6B288B711DECDDB00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:358:158: (temp= identifier )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:358:160: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_class_classes701);
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
              _beforeSeqEl("E012BF1E18A9D6B388B711DE83D700155883529C");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18A9D6B488B711DEA52D00155883529C");
            }
            match(input,34,FOLLOW_34_in_model_class_classes709); if (state.failed) return ret2;
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
    // $ANTLR end "model_class_classes"


    // $ANTLR start "model_modelelement_associations"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:366:1: model_modelelement_associations returns [Object ret2] : (ret= model_namespace_associations ) ;
    public final Object model_modelelement_associations() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:367:3: ( (ret= model_namespace_associations ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:368:3: (ret= model_namespace_associations )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:368:3: (ret= model_namespace_associations )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:368:4: ret= model_namespace_associations
            {
            pushFollow(FOLLOW_model_namespace_associations_in_model_modelelement_associations746);
            ret=model_namespace_associations();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_modelelement_associations"


    // $ANTLR start "model_namespace_associations"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:375:1: model_namespace_associations returns [Object ret2] : (ret= model_generalizableelement_associations ) ;
    public final Object model_namespace_associations() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:376:3: ( (ret= model_generalizableelement_associations ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:377:3: (ret= model_generalizableelement_associations )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:377:3: (ret= model_generalizableelement_associations )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:377:4: ret= model_generalizableelement_associations
            {
            pushFollow(FOLLOW_model_generalizableelement_associations_in_model_namespace_associations773);
            ret=model_generalizableelement_associations();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_namespace_associations"


    // $ANTLR start "model_generalizableelement_associations"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:384:1: model_generalizableelement_associations returns [Object ret2] : (ret= model_classifier_associations ) ;
    public final Object model_generalizableelement_associations() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:385:3: ( (ret= model_classifier_associations ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:386:3: (ret= model_classifier_associations )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:386:3: (ret= model_classifier_associations )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:386:4: ret= model_classifier_associations
            {
            pushFollow(FOLLOW_model_classifier_associations_in_model_generalizableelement_associations800);
            ret=model_classifier_associations();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_generalizableelement_associations"


    // $ANTLR start "model_classifier_associations"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:393:1: model_classifier_associations returns [Object ret2] : (ret= model_association_associations ) ;
    public final Object model_classifier_associations() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:394:3: ( (ret= model_association_associations ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:395:3: (ret= model_association_associations )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:395:3: (ret= model_association_associations )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:395:4: ret= model_association_associations
            {
            pushFollow(FOLLOW_model_association_associations_in_model_classifier_associations827);
            ret=model_association_associations();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_classifier_associations"


    // $ANTLR start "model_association_associations"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:402:1: model_association_associations returns [Object ret2] : ( annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL ) ;
    public final Object model_association_associations() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Association");
        onEnterTemplateRule(metaType,"associations");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:407:3: ( ( annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:3: ( annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:3: ( annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:4: annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18AE91A488B711DE837C00155883529C");
            }
            pushFollow(FOLLOW_annotation_in_model_association_associations857);
            annotation(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18AE91A588B711DE9C0500155883529C");
            }
            pushFollow(FOLLOW_visibility_in_model_association_associations861);
            visibility(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18AE91A688B711DEBC0F00155883529C");
            }
            match(input,39,FOLLOW_39_in_model_association_associations865); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18AE91A888B711DEA9E900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:331: (temp= identifier )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:333: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_association_associations872);
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
              _beforeSeqEl("E012BF1E18AE91A988B711DE8D7D00155883529C");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18AE91AA88B711DEABD300155883529C");
            }
            match(input,LCURL,FOLLOW_LCURL_in_model_association_associations881); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18D4B74388B711DE9B6600155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:615: ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:616: ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:616: ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:617: (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18D4B74088B711DE924A00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:676: (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:678: temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds )
            {
            pushFollow(FOLLOW_model_modelelement_associationEnds_in_model_association_associations892);
            temp=model_modelelement_associationEnds();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "contents", temp);
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:756: ( ( ';' ) temp= model_modelelement_associationEnds )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:757: ( ';' ) temp= model_modelelement_associationEnds
            {
            if ( state.backtracking==0 ) {
              _enterSepSeq();
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:774: ( ';' )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:408:775: ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18C6867088B711DE9EAD00155883529C");
            }
            match(input,34,FOLLOW_34_in_model_association_associations900); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {
              _exitSepSeq();
            }
            pushFollow(FOLLOW_model_modelelement_associationEnds_in_model_association_associations907);
            temp=model_modelelement_associationEnds();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "contents", temp);
            }

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18D4B74188B711DEC90800155883529C");
            }
            match(input,34,FOLLOW_34_in_model_association_associations914); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18D4B74488B711DE8F1000155883529C");
            }
            match(input,RCURL,FOLLOW_RCURL_in_model_association_associations921); if (state.failed) return ret2;
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
    // $ANTLR end "model_association_associations"


    // $ANTLR start "model_modelelement_associationEnds"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:416:1: model_modelelement_associationEnds returns [Object ret2] : (ret= model_typedelement_associationEnds ) ;
    public final Object model_modelelement_associationEnds() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:417:3: ( (ret= model_typedelement_associationEnds ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:418:3: (ret= model_typedelement_associationEnds )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:418:3: (ret= model_typedelement_associationEnds )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:418:4: ret= model_typedelement_associationEnds
            {
            pushFollow(FOLLOW_model_typedelement_associationEnds_in_model_modelelement_associationEnds959);
            ret=model_typedelement_associationEnds();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_modelelement_associationEnds"


    // $ANTLR start "model_typedelement_associationEnds"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:425:1: model_typedelement_associationEnds returns [Object ret2] : (ret= model_associationend_associationEnds ) ;
    public final Object model_typedelement_associationEnds() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:426:3: ( (ret= model_associationend_associationEnds ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:427:3: (ret= model_associationend_associationEnds )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:427:3: (ret= model_associationend_associationEnds )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:427:4: ret= model_associationend_associationEnds
            {
            pushFollow(FOLLOW_model_associationend_associationEnds_in_model_typedelement_associationEnds986);
            ret=model_associationend_associationEnds();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "model_typedelement_associationEnds"


    // $ANTLR start "model_associationend_associationEnds"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:434:1: model_associationend_associationEnds returns [Object ret2] : ( annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ) ;
    public final Object model_associationend_associationEnds() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","AssociationEnd");
        onEnterTemplateRule(metaType,"associationEnds");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:439:3: ( ( annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:440:3: ( annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:440:3: ( annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:440:4: annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18D7284688B711DEADB900155883529C");
            }
            pushFollow(FOLLOW_annotation_in_model_associationend_associationEnds1016);
            annotation(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E18D9994488B711DEABC200155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:440:154: ( ( '->' ) | )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==36) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=NAME && LA7_0<=QNAME)||LA7_0==31||LA7_0==33) ) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:440:155: ( '->' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:440:171: ( '->' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:440:172: '->'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E18D9994288B711DE9C3D00155883529C");
                    }
                    match(input,36,FOLLOW_36_in_model_associationend_associationEnds1026); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isNavigable", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:440:327: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isNavigable", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E012BF1E19282E7088B711DEA18300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:441:76: ( () | ( '<>' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=NAME && LA8_0<=QNAME)||LA8_0==31) ) {
                alt8=1;
            }
            else if ( (LA8_0==33) ) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:441:77: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:441:93: ()
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:441:94: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E18FADCE088B711DEA3E500155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "aggregation", com.sap.tc.moin.repository.mmi.model.AggregationKindEnum.NONE);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:4: ( '<>' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:20: ( '<>' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:21: '<>'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1921028088B711DE8B9900155883529C");
                    }
                    match(input,33,FOLLOW_33_in_model_associationend_associationEnds1062); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1921028388B711DEA0C100155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "aggregation", com.sap.tc.moin.repository.mmi.model.AggregationKindEnum.COMPOSITE);
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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E192F5A6488B711DE911E00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:369: ( () | ( 'readonly' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=NAME && LA9_0<=QNAME)) ) {
                alt9=1;
            }
            else if ( (LA9_0==31) ) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:370: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:386: ()
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:387: 
                    {
                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isChangeable", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:464: ( 'readonly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:480: ( 'readonly' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:442:481: 'readonly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E192F5A6288B711DE8C0900155883529C");
                    }
                    match(input,31,FOLLOW_31_in_model_associationend_associationEnds1089); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isChangeable", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E012BF1E1934155088B711DE829500155883529C");
            }
            pushFollow(FOLLOW_typereference_in_model_associationend_associationEnds1099);
            typereference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E1934155288B711DE88CB00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:443:169: (temp= model_multiplicitytype )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:443:171: temp= model_multiplicitytype
            {
            pushFollow(FOLLOW_model_multiplicitytype_in_model_associationend_associationEnds1107);
            temp=model_multiplicitytype();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "multiplicity", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E1934155488B711DE9AE500155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:443:316: (temp= identifier )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:443:318: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_associationend_associationEnds1117);
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
    // $ANTLR end "model_associationend_associationEnds"


    // $ANTLR start "typereference"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:451:1: typereference[Object ret] : ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ;
    public final void typereference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:452:3: ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:3: ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:3: ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:4: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E19B26D1888B711DEA99400155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:63: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==QNAME) ) {
                alt10=1;
            }
            else if ( (LA10_0==NAME) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:64: ( (temp= qualifiedNameSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:80: ( (temp= qualifiedNameSymbol ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:81: (temp= qualifiedNameSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19B26D1088B711DEBF6200155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:140: (temp= qualifiedNameSymbol )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:453:142: temp= qualifiedNameSymbol
                    {
                    pushFollow(FOLLOW_qualifiedNameSymbol_in_typereference1163);
                    temp=qualifiedNameSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "type", null, temp, "OCL:"+"			let t=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  				i; acc:Tuple(pos:Integer, ns:Set(Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=s.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"				t.ns.contents->select(c | c.name=s.subString(t.pos, s.size()))");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:454:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:454:20: ( (temp= identifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:454:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19B26D1688B711DEB98600155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:454:80: (temp= identifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:454:82: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_typereference1183);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "type", null, temp, "OCL:Model::Classifier.allInstances()->select(name=?)");
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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

                
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "typereference"


    // $ANTLR start "visibility"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:461:1: visibility[Object ret] : ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ) ;
    public final void visibility(Object ret) throws RecognitionException {
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:462:3: ( ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:463:3: ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:463:3: ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:463:4: ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E19CCABE388B711DEBA0800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:463:63: ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 32:
            case 38:
            case 39:
                {
                alt11=1;
                }
                break;
            case 37:
                {
                alt11=2;
                }
                break;
            case 35:
                {
                alt11=3;
                }
                break;
            case 30:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:463:64: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:463:80: ()
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:463:81: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19CCABD288B711DE996700155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "visibility", com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum.PUBLIC_VIS);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:464:4: ( 'public' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:464:20: ( 'public' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:464:21: 'public'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19CCABD488B711DE8C1700155883529C");
                    }
                    match(input,37,FOLLOW_37_in_visibility1233); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19CCABD788B711DEC4A700155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "visibility", com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum.PUBLIC_VIS);
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
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:465:4: ( 'protected' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:465:20: ( 'protected' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:465:21: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19CCABD988B711DE81EA00155883529C");
                    }
                    match(input,35,FOLLOW_35_in_visibility1249); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19CCABDC88B711DECAC600155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "visibility", com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum.PROTECTED_VIS);
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
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:466:4: ( 'private' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:466:20: ( 'private' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:466:21: 'private'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19CCABDE88B711DE9BBD00155883529C");
                    }
                    match(input,30,FOLLOW_30_in_visibility1265); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19CCABE188B711DEBC1500155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "visibility", com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum.PRIVATE_VIS);
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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

                
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "visibility"


    // $ANTLR start "annotation"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:473:1: annotation[Object ret] : ( ( ( (temp= annotationSymbol ) ) | ) ) ;
    public final void annotation(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:474:3: ( ( ( ( (temp= annotationSymbol ) ) | ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:3: ( ( ( (temp= annotationSymbol ) ) | ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:3: ( ( ( (temp= annotationSymbol ) ) | ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:4: ( ( (temp= annotationSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E19DD74B588B711DEB36D00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:64: ( ( (temp= annotationSymbol ) ) | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==MULTI_LINE_COMMENT) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=NAME && LA12_0<=QNAME)||(LA12_0>=30 && LA12_0<=33)||(LA12_0>=35 && LA12_0<=40)) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:65: ( (temp= annotationSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:81: ( (temp= annotationSymbol ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:82: (temp= annotationSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19DD74B388B711DEA3C400155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:141: (temp= annotationSymbol )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:143: temp= annotationSymbol
                    {
                    pushFollow(FOLLOW_annotationSymbol_in_annotation1307);
                    temp=annotationSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "annotation", temp);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:475:239: 
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

                
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "annotation"


    // $ANTLR start "model_multiplicitytype"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:483:1: model_multiplicitytype returns [Object ret2] : ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) ) ;
    public final Object model_multiplicitytype() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","MultiplicityType");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:488:3: ( ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:3: ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:3: ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:4: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E012BF1E1A24DE0188B711DEB78900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:63: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )
            int alt23=15;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:64: ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:144: ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:145: (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19E6EA9188B711DEA0C100155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:204: (temp= integerSymbol )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:206: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1380);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E19E6EA9288B711DEB97800155883529C");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1387); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A0F813688B711DEC5F600155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:417: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==STAR) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==INT) ) {
                        alt13=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:418: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:434: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:435: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A0F813188B711DEBFFE00155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1398); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:579: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:595: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:596: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A0F813488B711DEC9B300155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:655: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:657: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1416);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A0F813B88B711DEA42100155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", false);setProperty(ret, "isOrdered", false);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:4: ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:53: ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:54: LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A11CB2088B711DE85F600155883529C");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype1453); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A11CB2288B711DE884B00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:198: (temp= integerSymbol )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:200: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1461);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A11CB2388B711DEB3E400155883529C");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1468); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A11CB2D88B711DEB96E00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:411: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==STAR) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==INT) ) {
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:412: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:428: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:429: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A11CB2888B711DEC59D00155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1479); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:573: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:589: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:590: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A11CB2B88B711DEB84800155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:649: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:651: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1497);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A11CB3288B711DE9B5E00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", false);setProperty(ret, "isOrdered", true);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A11CB3388B711DEB8B600155883529C");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype1514); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:4: ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:50: ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:51: LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A11CB3588B711DEA41500155883529C");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype1539); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A11CB3788B711DEC23D00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:192: (temp= integerSymbol )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:194: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1547);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A11CB3888B711DE9BA500155883529C");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1554); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A143C2588B711DECD3E00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:405: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==STAR) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==INT) ) {
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:406: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:422: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:423: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A143C2088B711DEC4CF00155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1565); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:567: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:583: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:584: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A143C2388B711DECFB700155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:643: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:645: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1583);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A143C2A88B711DEB2D800155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", false);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A143C2B88B711DE968C00155883529C");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype1600); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:4: ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:57: ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:58: LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A143C2D88B711DE9E6200155883529C");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype1625); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A143C2F88B711DE877A00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:206: (temp= integerSymbol )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:208: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1633);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A143C3088B711DE837500155883529C");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1640); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A16AD2188B711DE981000155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:419: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==STAR) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==INT) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:420: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:436: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:437: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A143C3588B711DE867F00155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1651); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:581: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:597: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:598: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A143C3888B711DEBAF500155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:657: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:659: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1669);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A16AD2688B711DEA80D00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", true);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A16AD2788B711DE91DA00155883529C");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype1686); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 5 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:4: ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(4);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:57: ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:58: LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A16AD2988B711DE8B8A00155883529C");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype1711); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A16AD2B88B711DE948D00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:206: (temp= integerSymbol )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:208: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1719);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A16AD2C88B711DECF7E00155883529C");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1726); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A16AD3688B711DE89F800155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:419: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==STAR) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==INT) ) {
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:420: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:436: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:437: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A16AD3188B711DEA9E000155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1737); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:581: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:597: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:598: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A16AD3488B711DE971D00155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:657: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:659: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1755);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A18F71088B711DE93C800155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", true);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A18F71188B711DEC0B700155883529C");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype1772); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 6 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:4: ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(5);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:52: ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:53: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A18F71C88B711DEC15F00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:113: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==STAR) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==INT) ) {
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:114: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:130: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:131: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A18F71788B711DE875500155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1806); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:275: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:291: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:292: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A18F71A88B711DEA98500155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:351: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:353: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1824);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A18F72388B711DEB0D500155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);setProperty(ret, "isUnique", false);setProperty(ret, "isOrdered", false);
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
                case 7 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:4: ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(6);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:82: ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:83: LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A18F72588B711DE853100155883529C");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype1869); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1B681488B711DEAEE700155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:228: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==STAR) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==INT) ) {
                        alt19=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:229: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:245: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:246: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A18F72A88B711DEC2B400155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1880); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:390: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:406: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:407: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A1B681288B711DE9EFD00155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:466: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:468: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1898);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A1B681B88B711DE8ED200155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);setProperty(ret, "isUnique", false);setProperty(ret, "isOrdered", false);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1B681C88B711DEB8FD00155883529C");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype1915); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 8 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:503:4: ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(7);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:503:43: ( LBRACKET RBRACKET )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:503:44: LBRACKET RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1B681E88B711DEC5CE00155883529C");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype1938); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1B682788B711DEC09200155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "upper", -1);setProperty(ret, "lower", 0);setProperty(ret, "isUnique", false);setProperty(ret, "isOrdered", true);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1B682888B711DEC51400155883529C");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype1946); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 9 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:4: ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(8);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:70: ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:71: LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1B682A88B711DE91E400155883529C");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype1979); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1DD91788B711DE961600155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:213: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==STAR) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==INT) ) {
                        alt20=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:214: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:230: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:231: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A1DD91288B711DEB10700155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1990); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:375: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:391: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:392: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A1DD91588B711DEB31800155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:451: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:453: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2008);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A1DD91E88B711DEA3B200155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", false);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1DD91F88B711DEBB0A00155883529C");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype2025); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 10 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:506:4: ( LCURL RCURL )=> ( LCURL RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(9);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:506:37: ( LCURL RCURL )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:506:38: LCURL RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1DD92188B711DE9AB600155883529C");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype2048); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A1DD92A88B711DEC5DB00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "upper", -1);setProperty(ret, "lower", 0);setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", false);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A20230088B711DE8A4600155883529C");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype2056); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 11 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:4: ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(10);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:99: ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:100: LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A20230288B711DEC81500155883529C");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2089); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A20230C88B711DEACD100155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:249: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==STAR) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==INT) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:250: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:266: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:267: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A20230788B711DEA26A00155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2100); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:411: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:427: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:428: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A20230A88B711DEC9CA00155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:487: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:489: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2118);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A20231388B711DEB9F600155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", true);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A20231488B711DECEFD00155883529C");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2135); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 12 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:4: ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(11);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:99: ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:100: LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A20231688B711DE960C00155883529C");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2168); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A22940188B711DEBACF00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:249: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==STAR) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==INT) ) {
                        alt22=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:250: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:266: ( STAR )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:267: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A20231B88B711DEB0EA00155883529C");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2179); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", new Integer(-1));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:411: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:427: ( (temp= integerSymbol ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:428: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E012BF1E1A20231E88B711DEA06600155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:487: (temp= integerSymbol )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:489: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2197);
                            temp=integerSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "upper", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
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
                      _beforeSeqEl("E012BF1E1A22940888B711DEC7FB00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", true);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A22940988B711DEAF5000155883529C");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2214); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 13 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:511:4: ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(12);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:511:52: ( LCURL_LBRACK RBRACK_RCURL )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:511:53: LCURL_LBRACK RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A22940B88B711DEB0B700155883529C");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2237); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A22941488B711DE975900155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);setProperty(ret, "upper", -1);setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", true);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A22941588B711DEB04100155883529C");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2245); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 14 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:512:4: ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(13);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:512:52: ( LBRACK_LCURL RCURL_RBRACK )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:512:53: LBRACK_LCURL RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A22941788B711DEAA8400155883529C");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2268); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A24DDF488B711DEADD400155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);setProperty(ret, "upper", -1);setProperty(ret, "isUnique", true);setProperty(ret, "isOrdered", true);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A24DDF588B711DE895300155883529C");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2276); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 15 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:513:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(14);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:513:21: ()
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:513:22: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E012BF1E1A24DDFF88B711DEB1FB00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);setProperty(ret, "upper", 1);setProperty(ret, "isOrdered", false);setProperty(ret, "isUnique", false);
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
    // $ANTLR end "model_multiplicitytype"

    // $ANTLR start synpred26_MofPackage
    public final void synpred26_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:64: ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )
        int alt26=2;
        int LA26_0 = input.LA(1);

        if ( (LA26_0==INT) ) {
            int LA26_1 = input.LA(2);

            if ( (LA26_1==DDOT) ) {
                int LA26_2 = input.LA(3);

                if ( (LA26_2==STAR) ) {
                    alt26=1;
                }
                else if ( (LA26_2==INT) ) {
                    alt26=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 26, 0, input);

            throw nvae;
        }
        switch (alt26) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:65: integerSymbol DDOT STAR
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred26_MofPackage1355);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,DDOT,FOLLOW_DDOT_in_synpred26_MofPackage1357); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred26_MofPackage1359); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:489:91: integerSymbol DDOT integerSymbol
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred26_MofPackage1363);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,DDOT,FOLLOW_DDOT_in_synpred26_MofPackage1365); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred26_MofPackage1367);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred26_MofPackage

    // $ANTLR start synpred28_MofPackage
    public final void synpred28_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:4: ( LBRACKET integerSymbol DDOT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:491:5: LBRACKET integerSymbol DDOT
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred28_MofPackage1439); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred28_MofPackage1441);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred28_MofPackage1443); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_MofPackage

    // $ANTLR start synpred30_MofPackage
    public final void synpred30_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:4: ( LCURL integerSymbol DDOT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:493:5: LCURL integerSymbol DDOT
        {
        match(input,LCURL,FOLLOW_LCURL_in_synpred30_MofPackage1525); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred30_MofPackage1527);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred30_MofPackage1529); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_MofPackage

    // $ANTLR start synpred32_MofPackage
    public final void synpred32_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:4: ( LBRACK_LCURL integerSymbol DDOT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:495:5: LBRACK_LCURL integerSymbol DDOT
        {
        match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred32_MofPackage1611); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred32_MofPackage1613);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred32_MofPackage1615); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_MofPackage

    // $ANTLR start synpred34_MofPackage
    public final void synpred34_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:4: ( LCURL_LBRACK integerSymbol DDOT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:497:5: LCURL_LBRACK integerSymbol DDOT
        {
        match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred34_MofPackage1697); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred34_MofPackage1699);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred34_MofPackage1701); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_MofPackage

    // $ANTLR start synpred37_MofPackage
    public final void synpred37_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:4: ( STAR | integerSymbol ~ DDOT )
        int alt27=2;
        int LA27_0 = input.LA(1);

        if ( (LA27_0==STAR) ) {
            alt27=1;
        }
        else if ( (LA27_0==INT) ) {
            alt27=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 27, 0, input);

            throw nvae;
        }
        switch (alt27) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:5: STAR
                {
                match(input,STAR,FOLLOW_STAR_in_synpred37_MofPackage1783); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:499:12: integerSymbol ~ DDOT
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred37_MofPackage1787);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                if ( (input.LA(1)>=NAME && input.LA(1)<=RCURL)||(input.LA(1)>=STAR && input.LA(1)<=40) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }


                }
                break;

        }}
    // $ANTLR end synpred37_MofPackage

    // $ANTLR start synpred40_MofPackage
    public final void synpred40_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:4: ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )
        int alt28=2;
        int LA28_0 = input.LA(1);

        if ( (LA28_0==LBRACKET) ) {
            int LA28_1 = input.LA(2);

            if ( (LA28_1==STAR) ) {
                alt28=2;
            }
            else if ( (LA28_1==INT) ) {
                alt28=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 28, 0, input);

            throw nvae;
        }
        switch (alt28) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:5: LBRACKET integerSymbol RBRACKET
                {
                match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred40_MofPackage1847); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred40_MofPackage1849);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred40_MofPackage1851); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:501:39: LBRACKET STAR RBRACKET
                {
                match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred40_MofPackage1855); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred40_MofPackage1857); if (state.failed) return ;
                match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred40_MofPackage1859); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred40_MofPackage

    // $ANTLR start synpred42_MofPackage
    public final void synpred42_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:503:4: ( LBRACKET RBRACKET )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:503:5: LBRACKET RBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred42_MofPackage1926); if (state.failed) return ;
        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred42_MofPackage1928); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_MofPackage

    // $ANTLR start synpred44_MofPackage
    public final void synpred44_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:4: ( LCURL STAR RCURL | LCURL integerSymbol RCURL )
        int alt29=2;
        int LA29_0 = input.LA(1);

        if ( (LA29_0==LCURL) ) {
            int LA29_1 = input.LA(2);

            if ( (LA29_1==STAR) ) {
                alt29=1;
            }
            else if ( (LA29_1==INT) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 29, 0, input);

            throw nvae;
        }
        switch (alt29) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:5: LCURL STAR RCURL
                {
                match(input,LCURL,FOLLOW_LCURL_in_synpred44_MofPackage1957); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred44_MofPackage1959); if (state.failed) return ;
                match(input,RCURL,FOLLOW_RCURL_in_synpred44_MofPackage1961); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:504:24: LCURL integerSymbol RCURL
                {
                match(input,LCURL,FOLLOW_LCURL_in_synpred44_MofPackage1965); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred44_MofPackage1967);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RCURL,FOLLOW_RCURL_in_synpred44_MofPackage1969); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred44_MofPackage

    // $ANTLR start synpred46_MofPackage
    public final void synpred46_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:506:4: ( LCURL RCURL )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:506:5: LCURL RCURL
        {
        match(input,LCURL,FOLLOW_LCURL_in_synpred46_MofPackage2036); if (state.failed) return ;
        match(input,RCURL,FOLLOW_RCURL_in_synpred46_MofPackage2038); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_MofPackage

    // $ANTLR start synpred48_MofPackage
    public final void synpred48_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:4: ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )
        int alt30=2;
        int LA30_0 = input.LA(1);

        if ( (LA30_0==LBRACK_LCURL) ) {
            int LA30_1 = input.LA(2);

            if ( (LA30_1==STAR) ) {
                alt30=1;
            }
            else if ( (LA30_1==INT) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 30, 0, input);

            throw nvae;
        }
        switch (alt30) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:5: LBRACK_LCURL STAR RCURL_RBRACK
                {
                match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred48_MofPackage2067); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred48_MofPackage2069); if (state.failed) return ;
                match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred48_MofPackage2071); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:507:38: LBRACK_LCURL integerSymbol RCURL_RBRACK
                {
                match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred48_MofPackage2075); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred48_MofPackage2077);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred48_MofPackage2079); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred48_MofPackage

    // $ANTLR start synpred51_MofPackage
    public final void synpred51_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:4: ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )
        int alt31=2;
        int LA31_0 = input.LA(1);

        if ( (LA31_0==LCURL_LBRACK) ) {
            int LA31_1 = input.LA(2);

            if ( (LA31_1==STAR) ) {
                alt31=1;
            }
            else if ( (LA31_1==INT) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 31, 0, input);

            throw nvae;
        }
        switch (alt31) {
            case 1 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:5: LCURL_LBRACK STAR RBRACK_RCURL
                {
                match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred51_MofPackage2146); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred51_MofPackage2148); if (state.failed) return ;
                match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred51_MofPackage2150); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:509:38: LCURL_LBRACK integerSymbol RBRACK_RCURL
                {
                match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred51_MofPackage2154); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred51_MofPackage2156);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred51_MofPackage2158); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred51_MofPackage

    // $ANTLR start synpred53_MofPackage
    public final void synpred53_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:511:4: ( LCURL_LBRACK RBRACK_RCURL )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:511:5: LCURL_LBRACK RBRACK_RCURL
        {
        match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred53_MofPackage2225); if (state.failed) return ;
        match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred53_MofPackage2227); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_MofPackage

    // $ANTLR start synpred54_MofPackage
    public final void synpred54_MofPackage_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:512:4: ( LBRACK_LCURL RCURL_RBRACK )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofPackage.g:512:5: LBRACK_LCURL RCURL_RBRACK
        {
        match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred54_MofPackage2256); if (state.failed) return ;
        match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred54_MofPackage2258); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_MofPackage

    // Delegated rules

    public final boolean synpred34_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_MofPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_MofPackage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA23 dfa23 = new DFA23(this);
    static final String DFA23_eotS =
        "\36\uffff";
    static final String DFA23_eofS =
        "\36\uffff";
    static final String DFA23_minS =
        "\2\4\4\10\4\uffff\1\14\4\uffff\1\13\1\14\3\uffff\1\14\11\uffff";
    static final String DFA23_maxS =
        "\1\22\1\14\1\17\1\15\1\21\1\23\4\uffff\1\17\4\uffff\1\14\1\21\3"+
        "\uffff\1\23\11\uffff";
    static final String DFA23_acceptS =
        "\6\uffff\1\6\1\17\1\1\1\6\1\uffff\1\7\1\10\1\12\1\11\2\uffff\1\13"+
        "\1\16\1\15\1\uffff\1\14\1\2\1\7\1\11\1\3\1\13\1\4\1\14\1\5";
    static final String DFA23_specialS =
        "\1\7\1\1\1\11\1\6\1\0\1\2\4\uffff\1\4\4\uffff\1\3\1\10\3\uffff\1"+
        "\5\11\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\7\3\uffff\1\1\1\uffff\1\3\2\uffff\1\6\1\2\1\uffff\1\4\1\uffff"+
            "\1\5",
            "\1\11\7\uffff\1\10",
            "\1\12\4\uffff\1\13\1\uffff\1\14",
            "\1\17\2\uffff\1\15\1\uffff\1\16",
            "\1\20\4\uffff\1\21\3\uffff\1\22",
            "\1\24\4\uffff\1\25\5\uffff\1\23",
            "",
            "",
            "",
            "",
            "\1\26\2\uffff\1\27",
            "",
            "",
            "",
            "",
            "\1\30\1\31",
            "\1\33\4\uffff\1\32",
            "",
            "",
            "",
            "\1\35\6\uffff\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "489:63: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_4 = input.LA(1);

                         
                        int index23_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_4==INT) ) {s = 16;}

                        else if ( (LA23_4==STAR) && (synpred48_MofPackage())) {s = 17;}

                        else if ( (LA23_4==RCURL_RBRACK) && (synpred54_MofPackage())) {s = 18;}

                         
                        input.seek(index23_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA23_1 = input.LA(1);

                         
                        int index23_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_1==DDOT) && (synpred26_MofPackage())) {s = 8;}

                        else if ( (LA23_1==NAME) && (synpred37_MofPackage())) {s = 9;}

                         
                        input.seek(index23_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_5 = input.LA(1);

                         
                        int index23_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_5==RBRACK_RCURL) && (synpred53_MofPackage())) {s = 19;}

                        else if ( (LA23_5==INT) ) {s = 20;}

                        else if ( (LA23_5==STAR) && (synpred51_MofPackage())) {s = 21;}

                         
                        input.seek(index23_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA23_15 = input.LA(1);

                         
                        int index23_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_15==RCURL) && (synpred44_MofPackage())) {s = 24;}

                        else if ( (LA23_15==DDOT) && (synpred30_MofPackage())) {s = 25;}

                         
                        input.seek(index23_15);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA23_10 = input.LA(1);

                         
                        int index23_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_10==DDOT) && (synpred28_MofPackage())) {s = 22;}

                        else if ( (LA23_10==RBRACKET) && (synpred40_MofPackage())) {s = 23;}

                         
                        input.seek(index23_10);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_20 = input.LA(1);

                         
                        int index23_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_20==RBRACK_RCURL) && (synpred51_MofPackage())) {s = 28;}

                        else if ( (LA23_20==DDOT) && (synpred34_MofPackage())) {s = 29;}

                         
                        input.seek(index23_20);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_3 = input.LA(1);

                         
                        int index23_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_3==RCURL) && (synpred46_MofPackage())) {s = 13;}

                        else if ( (LA23_3==STAR) && (synpred44_MofPackage())) {s = 14;}

                        else if ( (LA23_3==INT) ) {s = 15;}

                         
                        input.seek(index23_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_0 = input.LA(1);

                         
                        int index23_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_0==INT) ) {s = 1;}

                        else if ( (LA23_0==LBRACKET) ) {s = 2;}

                        else if ( (LA23_0==LCURL) ) {s = 3;}

                        else if ( (LA23_0==LBRACK_LCURL) ) {s = 4;}

                        else if ( (LA23_0==LCURL_LBRACK) ) {s = 5;}

                        else if ( (LA23_0==STAR) && (synpred37_MofPackage())) {s = 6;}

                        else if ( (LA23_0==NAME) ) {s = 7;}

                         
                        input.seek(index23_0);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_16 = input.LA(1);

                         
                        int index23_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_16==RCURL_RBRACK) && (synpred48_MofPackage())) {s = 26;}

                        else if ( (LA23_16==DDOT) && (synpred32_MofPackage())) {s = 27;}

                         
                        input.seek(index23_16);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_2 = input.LA(1);

                         
                        int index23_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_2==INT) ) {s = 10;}

                        else if ( (LA23_2==STAR) && (synpred40_MofPackage())) {s = 11;}

                        else if ( (LA23_2==RBRACKET) && (synpred42_MofPackage())) {s = 12;}

                         
                        input.seek(index23_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_identifierOrKeyword108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_identifierOrKeyword116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_identifierOrKeyword124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_identifierOrKeyword140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_identifierOrKeyword148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_identifierOrKeyword156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_identifierOrKeyword164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_identifierOrKeyword180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_identifierOrKeyword188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qualifiedNameSymbol219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_package_in_main402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_package436 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_model_package440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_package447 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LCURL_in_model_package456 = new BitSet(new long[]{0x000000E940000880L});
    public static final BitSet FOLLOW_model_modelelement_classes_in_model_package467 = new BitSet(new long[]{0x000000E940000880L});
    public static final BitSet FOLLOW_model_modelelement_classes_in_model_package475 = new BitSet(new long[]{0x000000E940000880L});
    public static final BitSet FOLLOW_model_modelelement_associations_in_model_package490 = new BitSet(new long[]{0x000000A840000880L});
    public static final BitSet FOLLOW_model_modelelement_associations_in_model_package498 = new BitSet(new long[]{0x000000A840000880L});
    public static final BitSet FOLLOW_RCURL_in_model_package513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_namespace_classes_in_model_modelelement_classes551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_generalizableelement_classes_in_model_namespace_classes578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_classifier_classes_in_model_generalizableelement_classes605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_class_classes_in_model_classifier_classes632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_class_classes662 = new BitSet(new long[]{0x0000006940000000L});
    public static final BitSet FOLLOW_visibility_in_model_class_classes666 = new BitSet(new long[]{0x0000004100000000L});
    public static final BitSet FOLLOW_38_in_model_class_classes676 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_model_class_classes694 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_class_classes701 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_model_class_classes709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_namespace_associations_in_model_modelelement_associations746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_generalizableelement_associations_in_model_namespace_associations773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_classifier_associations_in_model_generalizableelement_associations800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_association_associations_in_model_classifier_associations827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_association_associations857 = new BitSet(new long[]{0x000000A840000000L});
    public static final BitSet FOLLOW_visibility_in_model_association_associations861 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_model_association_associations865 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_association_associations872 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LCURL_in_model_association_associations881 = new BitSet(new long[]{0x00000012800000B0L});
    public static final BitSet FOLLOW_model_modelelement_associationEnds_in_model_association_associations892 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_model_association_associations900 = new BitSet(new long[]{0x00000012800000B0L});
    public static final BitSet FOLLOW_model_modelelement_associationEnds_in_model_association_associations907 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_model_association_associations914 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_model_association_associations921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_typedelement_associationEnds_in_model_modelelement_associationEnds959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_associationend_associationEnds_in_model_typedelement_associationEnds986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_associationend_associationEnds1016 = new BitSet(new long[]{0x0000001280000030L});
    public static final BitSet FOLLOW_36_in_model_associationend_associationEnds1026 = new BitSet(new long[]{0x0000000280000030L});
    public static final BitSet FOLLOW_33_in_model_associationend_associationEnds1062 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_31_in_model_associationend_associationEnds1089 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_typereference_in_model_associationend_associationEnds1099 = new BitSet(new long[]{0x0000000000056510L});
    public static final BitSet FOLLOW_model_multiplicitytype_in_model_associationend_associationEnds1107 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_associationend_associationEnds1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_typereference1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_typereference1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_visibility1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_visibility1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_visibility1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationSymbol_in_annotation1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1380 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1387 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype1453 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1461 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1468 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1479 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1497 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype1539 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1547 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1554 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1565 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1583 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype1600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype1625 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1633 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1640 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1651 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1669 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype1711 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1719 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1726 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1737 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1755 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype1869 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1880 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1898 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype1938 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype1979 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1990 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2008 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype2048 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2089 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2100 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2118 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2168 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2179 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2197 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2237 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2268 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred26_MofPackage1355 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred26_MofPackage1357 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred26_MofPackage1359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred26_MofPackage1363 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred26_MofPackage1365 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred26_MofPackage1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred28_MofPackage1439 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred28_MofPackage1441 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred28_MofPackage1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred30_MofPackage1525 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred30_MofPackage1527 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred30_MofPackage1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred32_MofPackage1611 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred32_MofPackage1613 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred32_MofPackage1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred34_MofPackage1697 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred34_MofPackage1699 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred34_MofPackage1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred37_MofPackage1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred37_MofPackage1787 = new BitSet(new long[]{0x000001FFFFFFEFF0L});
    public static final BitSet FOLLOW_set_in_synpred37_MofPackage1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred40_MofPackage1847 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred40_MofPackage1849 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred40_MofPackage1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred40_MofPackage1855 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred40_MofPackage1857 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred40_MofPackage1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred42_MofPackage1926 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred42_MofPackage1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred44_MofPackage1957 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred44_MofPackage1959 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_synpred44_MofPackage1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred44_MofPackage1965 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred44_MofPackage1967 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_synpred44_MofPackage1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred46_MofPackage2036 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_synpred46_MofPackage2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred48_MofPackage2067 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred48_MofPackage2069 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred48_MofPackage2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred48_MofPackage2075 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred48_MofPackage2077 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred48_MofPackage2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred51_MofPackage2146 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred51_MofPackage2148 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred51_MofPackage2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred51_MofPackage2154 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred51_MofPackage2156 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred51_MofPackage2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred53_MofPackage2225 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred53_MofPackage2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred54_MofPackage2256 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred54_MofPackage2258 = new BitSet(new long[]{0x0000000000000002L});

}