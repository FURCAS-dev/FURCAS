// $ANTLR 3.1.1 /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g 2010-01-21 15:13:55

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
public class MofPackageParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "QNAME", "STRING", "MULTI_LINE_COMMENT", "INT", "BOOL", "LCURL", "RCURL", "DDOT", "STAR", "LBRACKET", "RBRACKET", "LBRACK_LCURL", "RCURL_RBRACK", "LCURL_LBRACK", "RBRACK_RCURL", "COMMENT", "LPAREN", "RPAREN", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "FLOAT", "RANGE_OR_INT", "'class'", "'->'", "'abstract'", "'package'", "'public'", "'association'", "'<>'", "'private'", "'protected'", "';'", "'readonly'"
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
    public String getGrammarFileName() { return "/home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g"; }


       private static final String syntaxUUID = "E0677A9A344A7F10069711DFC262CDAB0A1CE22F";
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:208:3: ( (ast= NAME ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:209:3: (ast= NAME )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:209:3: (ast= NAME )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:209:4: ast= NAME
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'class' | '->' | 'abstract' | 'package' | 'public' | 'association' | '<>' | 'private' | 'protected' | ';' | 'readonly' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:218:3: ( (ast= NAME | 'class' | '->' | 'abstract' | 'package' | 'public' | 'association' | '<>' | 'private' | 'protected' | ';' | 'readonly' ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:219:3: (ast= NAME | 'class' | '->' | 'abstract' | 'package' | 'public' | 'association' | '<>' | 'private' | 'protected' | ';' | 'readonly' )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:219:3: (ast= NAME | 'class' | '->' | 'abstract' | 'package' | 'public' | 'association' | '<>' | 'private' | 'protected' | ';' | 'readonly' )
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:219:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:221:5: 'class'
                    {
                    match(input,30,FOLLOW_30_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "class";
                    }

                    }
                    break;
                case 3 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:222:5: '->'
                    {
                    match(input,31,FOLLOW_31_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "->";
                    }

                    }
                    break;
                case 4 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:223:5: 'abstract'
                    {
                    match(input,32,FOLLOW_32_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 5 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:224:5: 'package'
                    {
                    match(input,33,FOLLOW_33_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "package";
                    }

                    }
                    break;
                case 6 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:225:5: 'public'
                    {
                    match(input,34,FOLLOW_34_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "public";
                    }

                    }
                    break;
                case 7 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:226:5: 'association'
                    {
                    match(input,35,FOLLOW_35_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "association";
                    }

                    }
                    break;
                case 8 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:227:5: '<>'
                    {
                    match(input,36,FOLLOW_36_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "<>";
                    }

                    }
                    break;
                case 9 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:228:5: 'private'
                    {
                    match(input,37,FOLLOW_37_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "private";
                    }

                    }
                    break;
                case 10 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:229:5: 'protected'
                    {
                    match(input,38,FOLLOW_38_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "protected";
                    }

                    }
                    break;
                case 11 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:230:5: ';'
                    {
                    match(input,39,FOLLOW_39_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = ";";
                    }

                    }
                    break;
                case 12 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:231:5: 'readonly'
                    {
                    match(input,40,FOLLOW_40_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "readonly";
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:238:1: qualifiedNameSymbol returns [Object ret2] : (ast= QNAME ) ;
    public final Object qualifiedNameSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:239:3: ( (ast= QNAME ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:240:3: (ast= QNAME )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:240:3: (ast= QNAME )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:240:4: ast= QNAME
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:248:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:249:3: ( (ast= STRING ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:250:3: (ast= STRING )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:250:3: (ast= STRING )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:250:4: ast= STRING
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:258:1: annotationSymbol returns [Object ret2] : (ast= MULTI_LINE_COMMENT ) ;
    public final Object annotationSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:259:3: ( (ast= MULTI_LINE_COMMENT ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:260:3: (ast= MULTI_LINE_COMMENT )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:260:3: (ast= MULTI_LINE_COMMENT )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:260:4: ast= MULTI_LINE_COMMENT
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:268:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:269:3: ( (ast= INT ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:270:3: (ast= INT )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:270:3: (ast= INT )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:270:4: ast= INT
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:278:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:279:3: ( (ast= INT ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:280:3: (ast= INT )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:280:3: (ast= INT )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:280:4: ast= INT
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:288:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:289:3: ( (ast= BOOL ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:290:3: (ast= BOOL )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:290:3: (ast= BOOL )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:290:4: ast= BOOL
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:298:1: main returns [Object ret2] : ( (ret= model_package ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:299:3: ( ( (ret= model_package ) EOF ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:300:3: ( (ret= model_package ) EOF )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:300:3: ( (ret= model_package ) EOF )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:300:4: (ret= model_package ) EOF
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:300:4: (ret= model_package )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:300:5: ret= model_package
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:307:1: model_package returns [Object ret2] : ( annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL ) ;
    public final Object model_package() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Package");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:312:3: ( ( annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:3: ( annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:3: ( annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:4: annotation[ret] 'package' (temp= identifier ) LCURL ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A3419AB10069711DFCADBCDAB0A1CE22F");
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
              _beforeSeqEl("E0677A9A3419D220069711DF96B5CDAB0A1CE22F");
            }
            match(input,33,FOLLOW_33_in_model_package440); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A3419D222069711DFB891CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:237: (temp= identifier )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:239: temp= identifier
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
              _beforeSeqEl("E0677A9A341A4750069711DF8045CDAB0A1CE22F");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A341A6E60069711DFC78FCDAB0A1CE22F");
            }
            match(input,LCURL,FOLLOW_LCURL_in_model_package456); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A341BCDF0069711DFC842CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:521: ( ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:522: ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:522: ( (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )? )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:523: (temp= model_modelelement_classes (temp= model_modelelement_classes )* )? (temp= model_modelelement_associations (temp= model_modelelement_associations )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A341B0AA0069711DF8029CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:582: (temp= model_modelelement_classes (temp= model_modelelement_classes )* )?
            int alt3=2;
            switch ( input.LA(1) ) {
                case MULTI_LINE_COMMENT:
                    {
                    switch ( input.LA(2) ) {
                        case 34:
                            {
                            int LA3_3 = input.LA(3);

                            if ( (LA3_3==30||LA3_3==32) ) {
                                alt3=1;
                            }
                            }
                            break;
                        case 38:
                            {
                            int LA3_4 = input.LA(3);

                            if ( (LA3_4==30||LA3_4==32) ) {
                                alt3=1;
                            }
                            }
                            break;
                        case 37:
                            {
                            int LA3_5 = input.LA(3);

                            if ( (LA3_5==30||LA3_5==32) ) {
                                alt3=1;
                            }
                            }
                            break;
                        case 30:
                        case 32:
                            {
                            alt3=1;
                            }
                            break;
                    }

                    }
                    break;
                case 30:
                case 32:
                    {
                    alt3=1;
                    }
                    break;
                case 34:
                    {
                    int LA3_3 = input.LA(2);

                    if ( (LA3_3==30||LA3_3==32) ) {
                        alt3=1;
                    }
                    }
                    break;
                case 38:
                    {
                    int LA3_4 = input.LA(2);

                    if ( (LA3_4==30||LA3_4==32) ) {
                        alt3=1;
                    }
                    }
                    break;
                case 37:
                    {
                    int LA3_5 = input.LA(2);

                    if ( (LA3_5==30||LA3_5==32) ) {
                        alt3=1;
                    }
                    }
                    break;
            }

            switch (alt3) {
                case 1 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:584: temp= model_modelelement_classes (temp= model_modelelement_classes )*
                    {
                    pushFollow(FOLLOW_model_modelelement_classes_in_model_package467);
                    temp=model_modelelement_classes();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "contents", temp);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:654: (temp= model_modelelement_classes )*
                    loop2:
                    do {
                        int alt2=2;
                        switch ( input.LA(1) ) {
                        case MULTI_LINE_COMMENT:
                            {
                            switch ( input.LA(2) ) {
                            case 30:
                            case 32:
                                {
                                alt2=1;
                                }
                                break;
                            case 34:
                                {
                                int LA2_3 = input.LA(3);

                                if ( (LA2_3==30||LA2_3==32) ) {
                                    alt2=1;
                                }


                                }
                                break;
                            case 38:
                                {
                                int LA2_4 = input.LA(3);

                                if ( (LA2_4==30||LA2_4==32) ) {
                                    alt2=1;
                                }


                                }
                                break;
                            case 37:
                                {
                                int LA2_5 = input.LA(3);

                                if ( (LA2_5==30||LA2_5==32) ) {
                                    alt2=1;
                                }


                                }
                                break;

                            }

                            }
                            break;
                        case 34:
                            {
                            int LA2_3 = input.LA(2);

                            if ( (LA2_3==30||LA2_3==32) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 38:
                            {
                            int LA2_4 = input.LA(2);

                            if ( (LA2_4==30||LA2_4==32) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 37:
                            {
                            int LA2_5 = input.LA(2);

                            if ( (LA2_5==30||LA2_5==32) ) {
                                alt2=1;
                            }


                            }
                            break;
                        case 30:
                        case 32:
                            {
                            alt2=1;
                            }
                            break;

                        }

                        switch (alt2) {
                    	case 1 :
                    	    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:656: temp= model_modelelement_classes
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
              _beforeSeqEl("E0677A9A341B58C3069711DFACA9CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:806: (temp= model_modelelement_associations (temp= model_modelelement_associations )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=NAME && LA5_0<=QNAME)||LA5_0==MULTI_LINE_COMMENT||(LA5_0>=30 && LA5_0<=38)||LA5_0==40) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:808: temp= model_modelelement_associations (temp= model_modelelement_associations )*
                    {
                    pushFollow(FOLLOW_model_modelelement_associations_in_model_package490);
                    temp=model_modelelement_associations();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "contents", temp);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:883: (temp= model_modelelement_associations )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=NAME && LA4_0<=QNAME)||LA4_0==MULTI_LINE_COMMENT||(LA4_0>=30 && LA4_0<=38)||LA4_0==40) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:313:885: temp= model_modelelement_associations
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
              _beforeSeqEl("E0677A9A341BCDF1069711DFA279CDAB0A1CE22F");
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:321:1: model_modelelement_classes returns [Object ret2] : (ret= model_namespace_classes ) ;
    public final Object model_modelelement_classes() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:322:3: ( (ret= model_namespace_classes ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:323:3: (ret= model_namespace_classes )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:323:3: (ret= model_namespace_classes )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:323:4: ret= model_namespace_classes
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:330:1: model_namespace_classes returns [Object ret2] : (ret= model_generalizableelement_classes ) ;
    public final Object model_namespace_classes() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:331:3: ( (ret= model_generalizableelement_classes ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:332:3: (ret= model_generalizableelement_classes )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:332:3: (ret= model_generalizableelement_classes )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:332:4: ret= model_generalizableelement_classes
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:339:1: model_generalizableelement_classes returns [Object ret2] : (ret= model_classifier_classes ) ;
    public final Object model_generalizableelement_classes() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:340:3: ( (ret= model_classifier_classes ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:341:3: (ret= model_classifier_classes )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:341:3: (ret= model_classifier_classes )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:341:4: ret= model_classifier_classes
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:348:1: model_classifier_classes returns [Object ret2] : (ret= model_class_classes ) ;
    public final Object model_classifier_classes() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:349:3: ( (ret= model_class_classes ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:350:3: (ret= model_class_classes )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:350:3: (ret= model_class_classes )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:350:4: ret= model_class_classes
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:357:1: model_class_classes returns [Object ret2] : ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';' ) ;
    public final Object model_class_classes() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Class");
        onEnterTemplateRule(metaType,"classes");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:362:3: ( ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';' ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:363:3: ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';' )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:363:3: ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';' )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:363:4: annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A3420AFF0069711DFC61ECDAB0A1CE22F");
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
              _beforeSeqEl("E0677A9A3420D700069711DF86F7CDAB0A1CE22F");
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
              _beforeSeqEl("E0677A9A34217341069711DFCB49CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:363:244: ( ( 'abstract' ) | )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==32) ) {
                alt6=1;
            }
            else if ( (LA6_0==30) ) {
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:363:245: ( 'abstract' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:363:261: ( 'abstract' )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:363:262: 'abstract'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34214C31069711DF8F33CDAB0A1CE22F");
                    }
                    match(input,32,FOLLOW_32_in_model_class_classes676); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:363:422: 
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
              _beforeSeqEl("E0677A9A34219A50069711DFC67ECDAB0A1CE22F");
            }
            match(input,30,FOLLOW_30_in_model_class_classes694); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34219A52069711DF8F02CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:364:158: (temp= identifier )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:364:160: temp= identifier
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
              _beforeSeqEl("E0677A9A3421C160069711DF96B2CDAB0A1CE22F");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A3421C161069711DFCA1BCDAB0A1CE22F");
            }
            match(input,39,FOLLOW_39_in_model_class_classes709); if (state.failed) return ret2;
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:372:1: model_modelelement_associations returns [Object ret2] : (ret= model_namespace_associations ) ;
    public final Object model_modelelement_associations() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:373:3: ( (ret= model_namespace_associations ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:374:3: (ret= model_namespace_associations )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:374:3: (ret= model_namespace_associations )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:374:4: ret= model_namespace_associations
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:381:1: model_namespace_associations returns [Object ret2] : (ret= model_generalizableelement_associations ) ;
    public final Object model_namespace_associations() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:382:3: ( (ret= model_generalizableelement_associations ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:383:3: (ret= model_generalizableelement_associations )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:383:3: (ret= model_generalizableelement_associations )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:383:4: ret= model_generalizableelement_associations
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:390:1: model_generalizableelement_associations returns [Object ret2] : (ret= model_classifier_associations ) ;
    public final Object model_generalizableelement_associations() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:391:3: ( (ret= model_classifier_associations ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:392:3: (ret= model_classifier_associations )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:392:3: (ret= model_classifier_associations )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:392:4: ret= model_classifier_associations
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:399:1: model_classifier_associations returns [Object ret2] : (ret= model_association_associations ) ;
    public final Object model_classifier_associations() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:400:3: ( (ret= model_association_associations ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:401:3: (ret= model_association_associations )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:401:3: (ret= model_association_associations )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:401:4: ret= model_association_associations
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:408:1: model_association_associations returns [Object ret2] : ( annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL ) ;
    public final Object model_association_associations() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Association");
        onEnterTemplateRule(metaType,"associations");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:413:3: ( ( annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:3: ( annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:3: ( annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:4: annotation[ret] visibility[ret] 'association' (temp= identifier ) LCURL ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34243260069711DF8E2ECDAB0A1CE22F");
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
              _beforeSeqEl("E0677A9A34245970069711DF8B84CDAB0A1CE22F");
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
              _beforeSeqEl("E0677A9A34245971069711DF94ECCDAB0A1CE22F");
            }
            match(input,35,FOLLOW_35_in_model_association_associations865); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34245973069711DFAD59CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:331: (temp= identifier )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:333: temp= identifier
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
              _beforeSeqEl("E0677A9A34248080069711DFC148CDAB0A1CE22F");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34248081069711DFCF7ACDAB0A1CE22F");
            }
            match(input,LCURL,FOLLOW_LCURL_in_model_association_associations881); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34260720069711DF9A34CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:615: ( ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:616: ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:616: ( (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';' )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:617: (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) ) ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A3425B900069711DFA75DCDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:676: (temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:678: temp= model_modelelement_associationEnds ( ( ';' ) temp= model_modelelement_associationEnds )
            {
            pushFollow(FOLLOW_model_modelelement_associationEnds_in_model_association_associations892);
            temp=model_modelelement_associationEnds();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "contents", temp);
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:756: ( ( ';' ) temp= model_modelelement_associationEnds )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:757: ( ';' ) temp= model_modelelement_associationEnds
            {
            if ( state.backtracking==0 ) {
              _enterSepSeq();
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:774: ( ';' )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:414:775: ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34251CC0069711DFC4FCCDAB0A1CE22F");
            }
            match(input,39,FOLLOW_39_in_model_association_associations900); if (state.failed) return ret2;
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
              _beforeSeqEl("E0677A9A3425E010069711DFC12ECDAB0A1CE22F");
            }
            match(input,39,FOLLOW_39_in_model_association_associations914); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34262E30069711DFB83CCDAB0A1CE22F");
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:422:1: model_modelelement_associationEnds returns [Object ret2] : (ret= model_typedelement_associationEnds ) ;
    public final Object model_modelelement_associationEnds() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:423:3: ( (ret= model_typedelement_associationEnds ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:424:3: (ret= model_typedelement_associationEnds )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:424:3: (ret= model_typedelement_associationEnds )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:424:4: ret= model_typedelement_associationEnds
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:431:1: model_typedelement_associationEnds returns [Object ret2] : (ret= model_associationend_associationEnds ) ;
    public final Object model_typedelement_associationEnds() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:432:3: ( (ret= model_associationend_associationEnds ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:433:3: (ret= model_associationend_associationEnds )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:433:3: (ret= model_associationend_associationEnds )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:433:4: ret= model_associationend_associationEnds
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:440:1: model_associationend_associationEnds returns [Object ret2] : ( annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ) ;
    public final Object model_associationend_associationEnds() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","AssociationEnd");
        onEnterTemplateRule(metaType,"associationEnds");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:445:3: ( ( annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:446:3: ( annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:446:3: ( annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:446:4: annotation[ret] ( ( '->' ) | ) ( () | ( '<>' ) ) ( () | ( 'readonly' ) ) typereference[ret] (temp= model_multiplicitytype ) (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A342802F0069711DFC5C1CDAB0A1CE22F");
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
              _beforeSeqEl("E0677A9A34285111069711DFB88DCDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:446:154: ( ( '->' ) | )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==31) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=NAME && LA7_0<=QNAME)||LA7_0==36||LA7_0==40) ) {
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:446:155: ( '->' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:446:171: ( '->' )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:446:172: '->'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34282A01069711DF9B26CDAB0A1CE22F");
                    }
                    match(input,31,FOLLOW_31_in_model_associationend_associationEnds1026); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:446:327: 
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
              _beforeSeqEl("E0677A9A342A25D0069711DF8607CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:447:76: ( () | ( '<>' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=NAME && LA8_0<=QNAME)||LA8_0==40) ) {
                alt8=1;
            }
            else if ( (LA8_0==36) ) {
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:447:77: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:447:93: ()
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:447:94: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34296280069711DFC035CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "aggregation", com.sap.tc.moin.repository.mmi.model.AggregationKindEnum.NONE);_exitInjectorAction();
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:4: ( '<>' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:20: ( '<>' )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:21: '<>'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3429B0A1069711DFA33CCDAB0A1CE22F");
                    }
                    match(input,36,FOLLOW_36_in_model_associationend_associationEnds1062); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3429D7B2069711DF8DF4CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "aggregation", com.sap.tc.moin.repository.mmi.model.AggregationKindEnum.COMPOSITE);_exitInjectorAction();
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
              _beforeSeqEl("E0677A9A342A73F3069711DFCC7FCDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:391: ( () | ( 'readonly' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=NAME && LA9_0<=QNAME)) ) {
                alt9=1;
            }
            else if ( (LA9_0==40) ) {
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:392: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:408: ()
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:409: 
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:486: ( 'readonly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:502: ( 'readonly' )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:448:503: 'readonly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342A73F1069711DFCC6DCDAB0A1CE22F");
                    }
                    match(input,40,FOLLOW_40_in_model_associationend_associationEnds1089); if (state.failed) return ret2;
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
              _beforeSeqEl("E0677A9A342AC210069711DFB59BCDAB0A1CE22F");
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
              _beforeSeqEl("E0677A9A342AC212069711DFC98FCDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:449:169: (temp= model_multiplicitytype )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:449:171: temp= model_multiplicitytype
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
              _beforeSeqEl("E0677A9A342AE920069711DFBA2FCDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:449:316: (temp= identifier )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:449:318: temp= identifier
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:457:1: typereference[Object ret] : ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ;
    public final void typereference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:458:3: ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:3: ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:3: ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:4: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A342C96D1069711DFBC8CCDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:63: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:64: ( (temp= qualifiedNameSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:80: ( (temp= qualifiedNameSymbol ) )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:81: (temp= qualifiedNameSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342BFA91069711DFB6A9CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:140: (temp= qualifiedNameSymbol )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:459:142: temp= qualifiedNameSymbol
                    {
                    pushFollow(FOLLOW_qualifiedNameSymbol_in_typereference1163);
                    temp=qualifiedNameSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "type", null, temp, "OCL:"+"			let t=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  				i; acc:Tuple(pos:Integer, ns:Set(Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"				t.ns.contents->select(c | c.name=?.subString(t.pos, ?.size()))");
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:460:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:460:20: ( (temp= identifier ) )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:460:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342C48B4069711DFCDE6CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:460:80: (temp= identifier )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:460:82: temp= identifier
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:467:1: visibility[Object ret] : ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ) ;
    public final void visibility(Object ret) throws RecognitionException {
        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:468:3: ( ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:469:3: ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:469:3: ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:469:4: ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A342F55F0069711DF93F2CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:469:63: ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 30:
            case 32:
            case 35:
                {
                alt11=1;
                }
                break;
            case 34:
                {
                alt11=2;
                }
                break;
            case 38:
                {
                alt11=3;
                }
                break;
            case 37:
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:469:64: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:469:80: ()
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:469:81: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342E1D70069711DF9E6DCDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "visibility", com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum.PUBLIC_VIS);_exitInjectorAction();
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:470:4: ( 'public' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:470:20: ( 'public' )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:470:21: 'public'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342E4480069711DF82DBCDAB0A1CE22F");
                    }
                    match(input,34,FOLLOW_34_in_visibility1233); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342E6B90069711DFA90CCDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "visibility", com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum.PUBLIC_VIS);_exitInjectorAction();
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:471:4: ( 'protected' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:471:20: ( 'protected' )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:471:21: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342E92A0069711DFB3FECDAB0A1CE22F");
                    }
                    match(input,38,FOLLOW_38_in_visibility1249); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342EB9B1069711DF84A7CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "visibility", com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum.PROTECTED_VIS);_exitInjectorAction();
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:472:4: ( 'private' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:472:20: ( 'private' )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:472:21: 'private'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342EE0C1069711DFB00ECDAB0A1CE22F");
                    }
                    match(input,37,FOLLOW_37_in_visibility1265); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A342F07D2069711DFA1E2CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "visibility", com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum.PRIVATE_VIS);_exitInjectorAction();
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:479:1: annotation[Object ret] : ( ( ( (temp= annotationSymbol ) ) | ) ) ;
    public final void annotation(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:480:3: ( ( ( ( (temp= annotationSymbol ) ) | ) ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:3: ( ( ( (temp= annotationSymbol ) ) | ) )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:3: ( ( ( (temp= annotationSymbol ) ) | ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:4: ( ( (temp= annotationSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34308E70069711DF993BCDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:64: ( ( (temp= annotationSymbol ) ) | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==MULTI_LINE_COMMENT) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=NAME && LA12_0<=QNAME)||(LA12_0>=30 && LA12_0<=38)||LA12_0==40) ) {
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:65: ( (temp= annotationSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:81: ( (temp= annotationSymbol ) )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:82: (temp= annotationSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34304052069711DFC70DCDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:141: (temp= annotationSymbol )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:143: temp= annotationSymbol
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
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34306760069711DFA3D2CDAB0A1CE22F");
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:481:314: 
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
    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:489:1: model_multiplicitytype returns [Object ret2] : ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) ) ;
    public final Object model_multiplicitytype() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","MultiplicityType");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:494:3: ( ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:3: ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) )
            {
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:3: ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) )
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:4: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A34459D11069711DF8388CDAB0A1CE22F");
            }
            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:63: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )
            int alt23=15;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:64: ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:144: ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:145: (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343151C1069711DFBE65CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:204: (temp= integerSymbol )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:206: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1382);
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
                      _beforeSeqEl("E0677A9A343178D0069711DF98FACDAB0A1CE22F");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1389); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3432D861069711DFA360CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:417: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:418: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:434: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:435: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A34328A41069711DF8AB4CDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1400); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:579: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:595: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:596: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A3432B152069711DFAFB5CDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:655: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:657: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1418);
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
                      _beforeSeqEl("E0677A9A34334D91069711DF9E6FCDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", false);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:4: ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:53: ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:54: LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34339BB0069711DF84BECDAB0A1CE22F");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype1455); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3433C2C1069711DFAF2DCDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:198: (temp= integerSymbol )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:200: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1463);
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
                      _beforeSeqEl("E0677A9A3433C2C2069711DFADFFCDAB0A1CE22F");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1470); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34345F00069711DFB365CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:411: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:412: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:428: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:429: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A343410E0069711DF8D7ECDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1481); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:573: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:589: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:590: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A343437F0069711DFA97CCDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:649: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:651: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1499);
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
                      _beforeSeqEl("E0677A9A3434AD22069711DFA6A7CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", false);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3434D430069711DF98F7CDAB0A1CE22F");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype1516); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:4: ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:50: ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:51: LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34352250069711DF82BDCDAB0A1CE22F");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype1541); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34352252069711DFA946CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:192: (temp= integerSymbol )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:194: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1549);
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
                      _beforeSeqEl("E0677A9A34354960069711DFAC0ACDAB0A1CE22F");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1556); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3435E5A0069711DF8389CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:405: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:406: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:422: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:423: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A34359780069711DFC13CCDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1567); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:567: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:583: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:584: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A34359783069711DFCD2ACDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:643: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:645: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1585);
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
                      _beforeSeqEl("E0677A9A343633C1069711DFBC8DCDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34365AD0069711DFB117CDAB0A1CE22F");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype1602); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:4: ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:57: ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:58: LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3436A8F0069711DFB8FBCDAB0A1CE22F");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype1627); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3436A8F2069711DFB137CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:206: (temp= integerSymbol )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:208: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1635);
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
                      _beforeSeqEl("E0677A9A3436D000069711DF9ACCCDAB0A1CE22F");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1642); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34374531069711DFAE90CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:419: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:420: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:436: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:437: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A3436F711069711DFBC08CDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1653); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:581: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:597: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:598: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A34371E21069711DFC275CDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:657: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:659: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1671);
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
                      _beforeSeqEl("E0677A9A3437BA60069711DFC863CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3437E170069711DF9106CDAB0A1CE22F");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype1688); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:4: ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(4);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:57: ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:58: LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34382F90069711DFCDB7CDAB0A1CE22F");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype1713); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34382F92069711DF96EFCDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:206: (temp= integerSymbol )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:208: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1721);
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
                      _beforeSeqEl("E0677A9A343856A0069711DFCD54CDAB0A1CE22F");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1728); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3438CBD0069711DF89A8CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:419: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:420: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:436: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:437: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A34387DB1069711DFAA6ACDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1739); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:581: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:597: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:598: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A3438A4C1069711DF9BC0CDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:657: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:659: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1757);
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
                      _beforeSeqEl("E0677A9A34394100069711DFC7EBCDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34396810069711DFCA5DCDAB0A1CE22F");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype1774); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:4: ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(5);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:52: ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:53: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343A5270069711DF9E98CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:113: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:114: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:130: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:131: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A343A0450069711DFAA50CDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1808); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:275: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:291: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:292: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A343A2B61069711DFCCB4CDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:351: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:353: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1826);
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
                      _beforeSeqEl("E0677A9A343AC7A1069711DF974DCDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", false);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:4: ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(6);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:82: ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:83: LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343B15C0069711DFA1D2CDAB0A1CE22F");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype1871); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343BB200069711DFB78CCDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:228: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:229: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:245: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:246: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A343B63E0069711DFC6CBCDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1882); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:390: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:406: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:407: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A343B8AF1069711DFAAEFCDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:466: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:468: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1900);
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
                      _beforeSeqEl("E0677A9A343C4E40069711DF93FECDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", false);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343C7550069711DF835ECDAB0A1CE22F");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype1917); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:509:4: ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(7);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:509:43: ( LBRACKET RBRACKET )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:509:44: LBRACKET RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343C9C60069711DFA24CCDAB0A1CE22F");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype1940); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343D38A0069711DF931FCDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "upper", -1);_exitInjectorAction();setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", false);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343D5FB0069711DFBDC4CDAB0A1CE22F");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype1948); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:4: ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(8);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:70: ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:71: LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343D86C0069711DF90C3CDAB0A1CE22F");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype1981); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343E2300069711DFB70BCDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:213: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:214: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:230: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:231: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A343DD4E0069711DF9445CDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1992); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:375: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:391: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:392: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A343DFBF1069711DFB78BCDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:451: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:453: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2010);
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
                      _beforeSeqEl("E0677A9A343E9832069711DFCC40CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343EBF40069711DFA703CDAB0A1CE22F");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype2027); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:512:4: ( LCURL RCURL )=> ( LCURL RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(9);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:512:37: ( LCURL RCURL )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:512:38: LCURL RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343F0D60069711DF8C57CDAB0A1CE22F");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype2050); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343F8291069711DFB5D8CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "upper", -1);_exitInjectorAction();setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343FD0B0069711DFA9FDCDAB0A1CE22F");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype2058); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:4: ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(10);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:99: ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:100: LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A343FF7C0069711DFA2CBCDAB0A1CE22F");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2091); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34409400069711DFC172CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:249: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:250: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:266: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:267: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A344045E0069711DFB073CDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2102); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:411: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:427: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:428: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A34406CF1069711DFCD18CDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:487: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:489: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2120);
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
                      _beforeSeqEl("E0677A9A34413040069711DF9831CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34413041069711DFA3F7CDAB0A1CE22F");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2137); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:4: ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(11);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:99: ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:100: LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34417E60069711DFCCABCDAB0A1CE22F");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2170); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34421AA1069711DFA700CDAB0A1CE22F");
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:249: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:250: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:266: ( STAR )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:267: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A3441CC80069711DFA02CCDAB0A1CE22F");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2181); if (state.failed) return ret2;
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
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:411: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:427: ( (temp= integerSymbol ) )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:428: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A3441F391069711DFC280CDAB0A1CE22F");
                            }
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:487: (temp= integerSymbol )
                            // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:489: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2199);
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
                      _beforeSeqEl("E0677A9A3442B6E0069711DFAA91CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3442DDF0069711DF89CFCDAB0A1CE22F");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2216); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:517:4: ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(12);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:517:52: ( LCURL_LBRACK RBRACK_RCURL )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:517:53: LCURL_LBRACK RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34430500069711DF931ECDAB0A1CE22F");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2239); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3443A140069711DF89A1CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "upper", -1);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3443C850069711DF8DBDCDAB0A1CE22F");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2247); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:518:4: ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(13);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:518:52: ( LBRACK_LCURL RCURL_RBRACK )
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:518:53: LBRACK_LCURL RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3443EF60069711DFB077CDAB0A1CE22F");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2270); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34448BA0069711DFB524CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "upper", -1);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A3444B2B0069711DF924ACDAB0A1CE22F");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2278); if (state.failed) return ret2;
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
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:519:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(14);
                    }
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:519:21: ()
                    // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:519:22: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A34457600069711DFC004CDAB0A1CE22F");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "upper", 1);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();setProperty(ret, "isUnique", false);_exitInjectorAction();
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
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:64: ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )
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
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:65: integerSymbol DDOT STAR
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred26_MofPackage1357);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,DDOT,FOLLOW_DDOT_in_synpred26_MofPackage1359); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred26_MofPackage1361); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:495:91: integerSymbol DDOT integerSymbol
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred26_MofPackage1365);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,DDOT,FOLLOW_DDOT_in_synpred26_MofPackage1367); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred26_MofPackage1369);
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
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:4: ( LBRACKET integerSymbol DDOT )
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:497:5: LBRACKET integerSymbol DDOT
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred28_MofPackage1441); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred28_MofPackage1443);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred28_MofPackage1445); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_MofPackage

    // $ANTLR start synpred30_MofPackage
    public final void synpred30_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:4: ( LCURL integerSymbol DDOT )
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:499:5: LCURL integerSymbol DDOT
        {
        match(input,LCURL,FOLLOW_LCURL_in_synpred30_MofPackage1527); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred30_MofPackage1529);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred30_MofPackage1531); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_MofPackage

    // $ANTLR start synpred32_MofPackage
    public final void synpred32_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:4: ( LBRACK_LCURL integerSymbol DDOT )
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:501:5: LBRACK_LCURL integerSymbol DDOT
        {
        match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred32_MofPackage1613); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred32_MofPackage1615);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred32_MofPackage1617); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_MofPackage

    // $ANTLR start synpred34_MofPackage
    public final void synpred34_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:4: ( LCURL_LBRACK integerSymbol DDOT )
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:503:5: LCURL_LBRACK integerSymbol DDOT
        {
        match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred34_MofPackage1699); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred34_MofPackage1701);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred34_MofPackage1703); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_MofPackage

    // $ANTLR start synpred37_MofPackage
    public final void synpred37_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:4: ( STAR | integerSymbol ~ DDOT )
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
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:5: STAR
                {
                match(input,STAR,FOLLOW_STAR_in_synpred37_MofPackage1785); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:505:12: integerSymbol ~ DDOT
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred37_MofPackage1789);
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
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:4: ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )
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
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:5: LBRACKET integerSymbol RBRACKET
                {
                match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred40_MofPackage1849); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred40_MofPackage1851);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred40_MofPackage1853); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:507:39: LBRACKET STAR RBRACKET
                {
                match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred40_MofPackage1857); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred40_MofPackage1859); if (state.failed) return ;
                match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred40_MofPackage1861); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred40_MofPackage

    // $ANTLR start synpred42_MofPackage
    public final void synpred42_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:509:4: ( LBRACKET RBRACKET )
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:509:5: LBRACKET RBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred42_MofPackage1928); if (state.failed) return ;
        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred42_MofPackage1930); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_MofPackage

    // $ANTLR start synpred44_MofPackage
    public final void synpred44_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:4: ( LCURL STAR RCURL | LCURL integerSymbol RCURL )
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
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:5: LCURL STAR RCURL
                {
                match(input,LCURL,FOLLOW_LCURL_in_synpred44_MofPackage1959); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred44_MofPackage1961); if (state.failed) return ;
                match(input,RCURL,FOLLOW_RCURL_in_synpred44_MofPackage1963); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:510:24: LCURL integerSymbol RCURL
                {
                match(input,LCURL,FOLLOW_LCURL_in_synpred44_MofPackage1967); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred44_MofPackage1969);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RCURL,FOLLOW_RCURL_in_synpred44_MofPackage1971); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred44_MofPackage

    // $ANTLR start synpred46_MofPackage
    public final void synpred46_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:512:4: ( LCURL RCURL )
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:512:5: LCURL RCURL
        {
        match(input,LCURL,FOLLOW_LCURL_in_synpred46_MofPackage2038); if (state.failed) return ;
        match(input,RCURL,FOLLOW_RCURL_in_synpred46_MofPackage2040); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_MofPackage

    // $ANTLR start synpred48_MofPackage
    public final void synpred48_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:4: ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )
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
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:5: LBRACK_LCURL STAR RCURL_RBRACK
                {
                match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred48_MofPackage2069); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred48_MofPackage2071); if (state.failed) return ;
                match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred48_MofPackage2073); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:513:38: LBRACK_LCURL integerSymbol RCURL_RBRACK
                {
                match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred48_MofPackage2077); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred48_MofPackage2079);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred48_MofPackage2081); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred48_MofPackage

    // $ANTLR start synpred51_MofPackage
    public final void synpred51_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:4: ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )
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
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:5: LCURL_LBRACK STAR RBRACK_RCURL
                {
                match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred51_MofPackage2148); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred51_MofPackage2150); if (state.failed) return ;
                match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred51_MofPackage2152); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:515:38: LCURL_LBRACK integerSymbol RBRACK_RCURL
                {
                match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred51_MofPackage2156); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred51_MofPackage2158);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred51_MofPackage2160); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred51_MofPackage

    // $ANTLR start synpred53_MofPackage
    public final void synpred53_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:517:4: ( LCURL_LBRACK RBRACK_RCURL )
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:517:5: LCURL_LBRACK RBRACK_RCURL
        {
        match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred53_MofPackage2227); if (state.failed) return ;
        match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred53_MofPackage2229); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_MofPackage

    // $ANTLR start synpred54_MofPackage
    public final void synpred54_MofPackage_fragment() throws RecognitionException {   
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:518:4: ( LBRACK_LCURL RCURL_RBRACK )
        // /home/trxadm/workspace/furcas_full/DSLEngineering/com.sap.tc.moin.tcs.mof.editor/generated/generated/MofPackage.g:518:5: LBRACK_LCURL RCURL_RBRACK
        {
        match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred54_MofPackage2258); if (state.failed) return ;
        match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred54_MofPackage2260); if (state.failed) return ;

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
        "\2\4\4\10\5\uffff\1\14\2\uffff\1\13\1\uffff\1\14\3\uffff\1\14\11"+
        "\uffff";
    static final String DFA23_maxS =
        "\1\22\1\14\1\17\1\15\1\21\1\23\5\uffff\1\17\2\uffff\1\14\1\uffff"+
        "\1\21\3\uffff\1\23\11\uffff";
    static final String DFA23_acceptS =
        "\6\uffff\1\6\1\17\1\1\1\6\1\7\1\uffff\1\10\1\11\1\uffff\1\12\1\uffff"+
        "\1\16\1\13\1\15\1\uffff\1\14\1\7\1\2\1\11\1\3\1\4\1\13\1\14\1\5";
    static final String DFA23_specialS =
        "\1\0\1\4\1\2\1\6\1\5\1\3\5\uffff\1\10\2\uffff\1\1\1\uffff\1\11\3"+
        "\uffff\1\7\11\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\7\3\uffff\1\1\1\uffff\1\3\2\uffff\1\6\1\2\1\uffff\1\4\1\uffff"+
            "\1\5",
            "\1\11\7\uffff\1\10",
            "\1\13\4\uffff\1\12\1\uffff\1\14",
            "\1\16\2\uffff\1\17\1\uffff\1\15",
            "\1\20\4\uffff\1\22\3\uffff\1\21",
            "\1\24\4\uffff\1\25\5\uffff\1\23",
            "",
            "",
            "",
            "",
            "",
            "\1\27\2\uffff\1\26",
            "",
            "",
            "\1\30\1\31",
            "",
            "\1\32\4\uffff\1\33",
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
            return "495:63: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
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
                    case 1 : 
                        int LA23_14 = input.LA(1);

                         
                        int index23_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_14==RCURL) && (synpred44_MofPackage())) {s = 24;}

                        else if ( (LA23_14==DDOT) && (synpred30_MofPackage())) {s = 25;}

                         
                        input.seek(index23_14);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA23_2 = input.LA(1);

                         
                        int index23_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_2==STAR) && (synpred40_MofPackage())) {s = 10;}

                        else if ( (LA23_2==INT) ) {s = 11;}

                        else if ( (LA23_2==RBRACKET) && (synpred42_MofPackage())) {s = 12;}

                         
                        input.seek(index23_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
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
                    case 4 : 
                        int LA23_1 = input.LA(1);

                         
                        int index23_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_1==DDOT) && (synpred26_MofPackage())) {s = 8;}

                        else if ( (LA23_1==NAME) && (synpred37_MofPackage())) {s = 9;}

                         
                        input.seek(index23_1);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA23_4 = input.LA(1);

                         
                        int index23_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_4==INT) ) {s = 16;}

                        else if ( (LA23_4==RCURL_RBRACK) && (synpred54_MofPackage())) {s = 17;}

                        else if ( (LA23_4==STAR) && (synpred48_MofPackage())) {s = 18;}

                         
                        input.seek(index23_4);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA23_3 = input.LA(1);

                         
                        int index23_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_3==STAR) && (synpred44_MofPackage())) {s = 13;}

                        else if ( (LA23_3==INT) ) {s = 14;}

                        else if ( (LA23_3==RCURL) && (synpred46_MofPackage())) {s = 15;}

                         
                        input.seek(index23_3);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA23_20 = input.LA(1);

                         
                        int index23_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_20==RBRACK_RCURL) && (synpred51_MofPackage())) {s = 28;}

                        else if ( (LA23_20==DDOT) && (synpred34_MofPackage())) {s = 29;}

                         
                        input.seek(index23_20);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA23_11 = input.LA(1);

                         
                        int index23_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_11==RBRACKET) && (synpred40_MofPackage())) {s = 22;}

                        else if ( (LA23_11==DDOT) && (synpred28_MofPackage())) {s = 23;}

                         
                        input.seek(index23_11);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA23_16 = input.LA(1);

                         
                        int index23_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA23_16==DDOT) && (synpred32_MofPackage())) {s = 26;}

                        else if ( (LA23_16==RCURL_RBRACK) && (synpred48_MofPackage())) {s = 27;}

                         
                        input.seek(index23_16);
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
    public static final BitSet FOLLOW_annotation_in_model_package436 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_model_package440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_package447 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LCURL_in_model_package456 = new BitSet(new long[]{0x0000006D40000880L});
    public static final BitSet FOLLOW_model_modelelement_classes_in_model_package467 = new BitSet(new long[]{0x0000006D40000880L});
    public static final BitSet FOLLOW_model_modelelement_classes_in_model_package475 = new BitSet(new long[]{0x0000006D40000880L});
    public static final BitSet FOLLOW_model_modelelement_associations_in_model_package490 = new BitSet(new long[]{0x0000006C00000880L});
    public static final BitSet FOLLOW_model_modelelement_associations_in_model_package498 = new BitSet(new long[]{0x0000006C00000880L});
    public static final BitSet FOLLOW_RCURL_in_model_package513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_namespace_classes_in_model_modelelement_classes551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_generalizableelement_classes_in_model_namespace_classes578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_classifier_classes_in_model_generalizableelement_classes605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_class_classes_in_model_classifier_classes632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_class_classes662 = new BitSet(new long[]{0x0000006540000000L});
    public static final BitSet FOLLOW_visibility_in_model_class_classes666 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_32_in_model_class_classes676 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_model_class_classes694 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_class_classes701 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_model_class_classes709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_namespace_associations_in_model_modelelement_associations746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_generalizableelement_associations_in_model_namespace_associations773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_classifier_associations_in_model_generalizableelement_associations800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_association_associations_in_model_classifier_associations827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_association_associations857 = new BitSet(new long[]{0x0000006C00000000L});
    public static final BitSet FOLLOW_visibility_in_model_association_associations861 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_model_association_associations865 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_association_associations872 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LCURL_in_model_association_associations881 = new BitSet(new long[]{0x00000110800000B0L});
    public static final BitSet FOLLOW_model_modelelement_associationEnds_in_model_association_associations892 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_model_association_associations900 = new BitSet(new long[]{0x00000110800000B0L});
    public static final BitSet FOLLOW_model_modelelement_associationEnds_in_model_association_associations907 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_model_association_associations914 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_model_association_associations921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_typedelement_associationEnds_in_model_modelelement_associationEnds959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_associationend_associationEnds_in_model_typedelement_associationEnds986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_associationend_associationEnds1016 = new BitSet(new long[]{0x0000011080000030L});
    public static final BitSet FOLLOW_31_in_model_associationend_associationEnds1026 = new BitSet(new long[]{0x0000011000000030L});
    public static final BitSet FOLLOW_36_in_model_associationend_associationEnds1062 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_40_in_model_associationend_associationEnds1089 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_typereference_in_model_associationend_associationEnds1099 = new BitSet(new long[]{0x0000000000056510L});
    public static final BitSet FOLLOW_model_multiplicitytype_in_model_associationend_associationEnds1107 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_associationend_associationEnds1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_typereference1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_typereference1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_visibility1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_visibility1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_visibility1265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationSymbol_in_annotation1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1382 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1389 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype1455 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1463 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1470 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1481 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1499 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype1541 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1549 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1556 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1567 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1585 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype1602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype1627 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1635 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1642 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1653 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1671 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype1713 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1721 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1728 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1739 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1757 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype1871 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1882 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1900 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype1917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype1940 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype1981 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1992 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2010 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype2050 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype2058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2091 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2102 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2120 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2170 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2181 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2199 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2239 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2270 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred26_MofPackage1357 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred26_MofPackage1359 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred26_MofPackage1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred26_MofPackage1365 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred26_MofPackage1367 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred26_MofPackage1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred28_MofPackage1441 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred28_MofPackage1443 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred28_MofPackage1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred30_MofPackage1527 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred30_MofPackage1529 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred30_MofPackage1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred32_MofPackage1613 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred32_MofPackage1615 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred32_MofPackage1617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred34_MofPackage1699 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred34_MofPackage1701 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_DDOT_in_synpred34_MofPackage1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred37_MofPackage1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred37_MofPackage1789 = new BitSet(new long[]{0x000001FFFFFFEFF0L});
    public static final BitSet FOLLOW_set_in_synpred37_MofPackage1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred40_MofPackage1849 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred40_MofPackage1851 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred40_MofPackage1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred40_MofPackage1857 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred40_MofPackage1859 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred40_MofPackage1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred42_MofPackage1928 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred42_MofPackage1930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred44_MofPackage1959 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred44_MofPackage1961 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_synpred44_MofPackage1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred44_MofPackage1967 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred44_MofPackage1969 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_synpred44_MofPackage1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred46_MofPackage2038 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURL_in_synpred46_MofPackage2040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred48_MofPackage2069 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred48_MofPackage2071 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred48_MofPackage2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred48_MofPackage2077 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred48_MofPackage2079 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred48_MofPackage2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred51_MofPackage2148 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_STAR_in_synpred51_MofPackage2150 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred51_MofPackage2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred51_MofPackage2156 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred51_MofPackage2158 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred51_MofPackage2160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred53_MofPackage2227 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred53_MofPackage2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred54_MofPackage2258 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred54_MofPackage2260 = new BitSet(new long[]{0x0000000000000002L});

}