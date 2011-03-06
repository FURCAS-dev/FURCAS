// $ANTLR 3.1.1 /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g 2011-02-28 20:11:34

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
public class OclParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "QNAME", "MULTI_LINE_COMMENT", "INT", "FLOAT", "BOOL", "LPAREN", "RPAREN", "DOT", "ARROW", "EQUALS", "APOSTROPHE", "DCOLON", "LCURL", "COMMA", "RCURL", "DDOT", "COLON", "SEMI", "BAR", "COMMENT", "LBRACKET", "RBRACKET", "STAR", "GT", "GTRQULAS", "LT", "LTEQUALS", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "RANGE_OR_INT", "'if'", "'endif'", "'then'", "'forAll'", "'self'", "'else'", "'Sequence'", "'collect'", "'Set'", "'select'", "'Collection'", "'in'", "'Bag'", "'iterate'", "'OrderedSet'", "'let'"
    };
    public static final int LT=31;
    public static final int STAR=28;
    public static final int FLOAT=9;
    public static final int EQUALS=15;
    public static final int EOF=-1;
    public static final int GTRQULAS=30;
    public static final int LPAREN=11;
    public static final int LBRACKET=26;
    public static final int RPAREN=12;
    public static final int NAME=4;
    public static final int DCOLON=17;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int COMMA=19;
    public static final int DIGIT=35;
    public static final int NL=33;
    public static final int APOSTROPHE=16;
    public static final int RANGE_OR_INT=38;
    public static final int RBRACKET=27;
    public static final int DOT=13;
    public static final int COMMENT=25;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=21;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=10;
    public static final int INT=8;
    public static final int SEMI=23;
    public static final int MULTI_LINE_COMMENT=7;
    public static final int ALPHA=36;
    public static final int COLON=22;
    public static final int LCURL=18;
    public static final int WS=34;
    public static final int QNAME=6;
    public static final int SNAME=37;
    public static final int T__39=39;
    public static final int RCURL=20;
    public static final int GT=29;
    public static final int ARROW=14;
    public static final int LTEQUALS=32;
    public static final int BAR=24;
    public static final int STRING=5;

    // delegates
    // delegators


        public OclParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public OclParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OclParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g"; }


       private static final String syntaxUUID = "_jXPggENuEeCVWekCgdT-_A";
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
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:95:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:96:3: ( (ast= NAME ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:97:3: (ast= NAME )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:97:3: (ast= NAME )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:97:4: ast= NAME
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
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:105:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'if' | 'endif' | 'then' | 'forAll' | 'self' | 'else' | 'Sequence' | 'collect' | 'Set' | 'select' | 'Collection' | 'in' | 'Bag' | 'iterate' | 'OrderedSet' | 'let' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:106:3: ( (ast= NAME | 'if' | 'endif' | 'then' | 'forAll' | 'self' | 'else' | 'Sequence' | 'collect' | 'Set' | 'select' | 'Collection' | 'in' | 'Bag' | 'iterate' | 'OrderedSet' | 'let' ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:107:3: (ast= NAME | 'if' | 'endif' | 'then' | 'forAll' | 'self' | 'else' | 'Sequence' | 'collect' | 'Set' | 'select' | 'Collection' | 'in' | 'Bag' | 'iterate' | 'OrderedSet' | 'let' )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:107:3: (ast= NAME | 'if' | 'endif' | 'then' | 'forAll' | 'self' | 'else' | 'Sequence' | 'collect' | 'Set' | 'select' | 'Collection' | 'in' | 'Bag' | 'iterate' | 'OrderedSet' | 'let' )
            int alt1=17;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 39:
                {
                alt1=2;
                }
                break;
            case 40:
                {
                alt1=3;
                }
                break;
            case 41:
                {
                alt1=4;
                }
                break;
            case 42:
                {
                alt1=5;
                }
                break;
            case 43:
                {
                alt1=6;
                }
                break;
            case 44:
                {
                alt1=7;
                }
                break;
            case 45:
                {
                alt1=8;
                }
                break;
            case 46:
                {
                alt1=9;
                }
                break;
            case 47:
                {
                alt1=10;
                }
                break;
            case 48:
                {
                alt1=11;
                }
                break;
            case 49:
                {
                alt1=12;
                }
                break;
            case 50:
                {
                alt1=13;
                }
                break;
            case 51:
                {
                alt1=14;
                }
                break;
            case 52:
                {
                alt1=15;
                }
                break;
            case 53:
                {
                alt1=16;
                }
                break;
            case 54:
                {
                alt1=17;
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:107:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:109:5: 'if'
                    {
                    match(input,39,FOLLOW_39_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "if";
                    }

                    }
                    break;
                case 3 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:110:5: 'endif'
                    {
                    match(input,40,FOLLOW_40_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endif";
                    }

                    }
                    break;
                case 4 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:111:5: 'then'
                    {
                    match(input,41,FOLLOW_41_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "then";
                    }

                    }
                    break;
                case 5 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:112:5: 'forAll'
                    {
                    match(input,42,FOLLOW_42_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forAll";
                    }

                    }
                    break;
                case 6 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:113:5: 'self'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "self";
                    }

                    }
                    break;
                case 7 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:114:5: 'else'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "else";
                    }

                    }
                    break;
                case 8 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:115:5: 'Sequence'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Sequence";
                    }

                    }
                    break;
                case 9 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:116:5: 'collect'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "collect";
                    }

                    }
                    break;
                case 10 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:117:5: 'Set'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Set";
                    }

                    }
                    break;
                case 11 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:118:5: 'select'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "select";
                    }

                    }
                    break;
                case 12 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:119:5: 'Collection'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Collection";
                    }

                    }
                    break;
                case 13 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:120:5: 'in'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 14 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:121:5: 'Bag'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Bag";
                    }

                    }
                    break;
                case 15 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:122:5: 'iterate'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "iterate";
                    }

                    }
                    break;
                case 16 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:123:5: 'OrderedSet'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "OrderedSet";
                    }

                    }
                    break;
                case 17 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:124:5: 'let'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "let";
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


    // $ANTLR start "stringSymbol"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:131:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:132:3: ( (ast= STRING ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:133:3: (ast= STRING )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:133:3: (ast= STRING )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:133:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol259); if (state.failed) return ret2;
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


    // $ANTLR start "qualifiedNameSymbol"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:141:1: qualifiedNameSymbol returns [Object ret2] : (ast= QNAME ) ;
    public final Object qualifiedNameSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:142:3: ( (ast= QNAME ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:143:3: (ast= QNAME )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:143:3: (ast= QNAME )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:143:4: ast= QNAME
            {
            ast=(Token)match(input,QNAME,FOLLOW_QNAME_in_qualifiedNameSymbol290); if (state.failed) return ret2;
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


    // $ANTLR start "annotationSymbol"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:151:1: annotationSymbol returns [Object ret2] : (ast= MULTI_LINE_COMMENT ) ;
    public final Object annotationSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:152:3: ( (ast= MULTI_LINE_COMMENT ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:153:3: (ast= MULTI_LINE_COMMENT )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:153:3: (ast= MULTI_LINE_COMMENT )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:153:4: ast= MULTI_LINE_COMMENT
            {
            ast=(Token)match(input,MULTI_LINE_COMMENT,FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol321); if (state.failed) return ret2;
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
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:161:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:162:3: ( (ast= INT ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:163:3: (ast= INT )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:163:3: (ast= INT )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:163:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol352); if (state.failed) return ret2;
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
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:171:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:172:3: ( (ast= INT ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:173:3: (ast= INT )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:173:3: (ast= INT )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:173:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol383); if (state.failed) return ret2;
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
    // $ANTLR end "longSymbol"


    // $ANTLR start "integerAsString"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:181:1: integerAsString returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsString() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:182:3: ( (ast= INT ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:183:3: (ast= INT )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:183:3: (ast= INT )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:183:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsString414); if (state.failed) return ret2;
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
    // $ANTLR end "integerAsString"


    // $ANTLR start "floatAsString"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:191:1: floatAsString returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsString() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:192:3: ( (ast= FLOAT ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:193:3: (ast= FLOAT )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:193:3: (ast= FLOAT )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:193:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsString445); if (state.failed) return ret2;
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
    // $ANTLR end "floatAsString"


    // $ANTLR start "booleanSymbol"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:201:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:202:3: ( (ast= BOOL ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:203:3: (ast= BOOL )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:203:3: (ast= BOOL )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:203:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol476); if (state.failed) return ret2;
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


    // $ANTLR start "booleanValueSymbol"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:211:1: booleanValueSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanValueSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:212:3: ( (ast= BOOL ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:213:3: (ast= BOOL )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:213:3: (ast= BOOL )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:213:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanValueSymbol507); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = Boolean.valueOf( ast.getText());

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
    // $ANTLR end "booleanValueSymbol"


    // $ANTLR start "floatSymbol"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:221:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:222:3: ( (ast= FLOAT ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:223:3: (ast= FLOAT )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:223:3: (ast= FLOAT )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:223:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol538); if (state.failed) return ret2;
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


    // $ANTLR start "realSymbol"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:231:1: realSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object realSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:232:3: ( (ast= FLOAT ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:233:3: (ast= FLOAT )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:233:3: (ast= FLOAT )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:233:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_realSymbol569); if (state.failed) return ret2;
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
    // $ANTLR end "realSymbol"


    // $ANTLR start "doubleSymbol"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:241:1: doubleSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object doubleSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:242:3: ( (ast= FLOAT ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:243:3: (ast= FLOAT )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:243:3: (ast= FLOAT )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:243:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_doubleSymbol600); if (state.failed) return ret2;
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
    // $ANTLR end "doubleSymbol"


    // $ANTLR start "ocl_ecore_oclexpression"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:251:1: ocl_ecore_oclexpression returns [Object ret2] : (ret= ocl_ecore_literalexp | ret= ocl_ecore_ifexp | ret= ocl_ecore_letexp | ret= ocl_ecore_variableexp ) ;
    public final Object ocl_ecore_oclexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:252:3: ( (ret= ocl_ecore_literalexp | ret= ocl_ecore_ifexp | ret= ocl_ecore_letexp | ret= ocl_ecore_variableexp ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:253:3: (ret= ocl_ecore_literalexp | ret= ocl_ecore_ifexp | ret= ocl_ecore_letexp | ret= ocl_ecore_variableexp )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:253:3: (ret= ocl_ecore_literalexp | ret= ocl_ecore_ifexp | ret= ocl_ecore_letexp | ret= ocl_ecore_variableexp )
            int alt2=4;
            switch ( input.LA(1) ) {
            case QNAME:
            case INT:
            case FLOAT:
            case BOOL:
            case APOSTROPHE:
            case 45:
            case 47:
            case 49:
            case 51:
            case 53:
                {
                alt2=1;
                }
                break;
            case 39:
                {
                alt2=2;
                }
                break;
            case 54:
                {
                alt2=3;
                }
                break;
            case NAME:
            case 43:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:253:4: ret= ocl_ecore_literalexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_literalexp_in_ocl_ecore_oclexpression627);
                    ret=ocl_ecore_literalexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:254:5: ret= ocl_ecore_ifexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_ifexp_in_ocl_ecore_oclexpression635);
                    ret=ocl_ecore_ifexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:255:5: ret= ocl_ecore_letexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_letexp_in_ocl_ecore_oclexpression643);
                    ret=ocl_ecore_letexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:256:5: ret= ocl_ecore_variableexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_variableexp_in_ocl_ecore_oclexpression651);
                    ret=ocl_ecore_variableexp();

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
    // $ANTLR end "ocl_ecore_oclexpression"


    // $ANTLR start "main"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:263:1: main returns [Object ret2] : ( (ret= ocl_expressions_oclexpression ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:264:3: ( ( (ret= ocl_expressions_oclexpression ) EOF ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:265:3: ( (ret= ocl_expressions_oclexpression ) EOF )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:265:3: ( (ret= ocl_expressions_oclexpression ) EOF )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:265:4: (ret= ocl_expressions_oclexpression ) EOF
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:265:4: (ret= ocl_expressions_oclexpression )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:265:5: ret= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_main679);
            ret=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main682); if (state.failed) return ret2;

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


    // $ANTLR start "primary_ocl_expressions_oclexpression"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:272:1: primary_ocl_expressions_oclexpression returns [Object ret2] : (ret= ocl_ecore_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) ;
    public final Object primary_ocl_expressions_oclexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:273:3: ( (ret= ocl_ecore_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:274:3: (ret= ocl_ecore_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:274:3: (ret= ocl_ecore_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NAME||LA3_0==QNAME||(LA3_0>=INT && LA3_0<=BOOL)||LA3_0==APOSTROPHE||LA3_0==39||LA3_0==43||LA3_0==45||LA3_0==47||LA3_0==49||LA3_0==51||(LA3_0>=53 && LA3_0<=54)) ) {
                alt3=1;
            }
            else if ( (LA3_0==LPAREN) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:274:4: ret= ocl_ecore_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_ecore_oclexpression_in_primary_ocl_expressions_oclexpression710);
                    ret=ocl_ecore_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:275:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    {
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:275:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:275:6: LPAREN ret= ocl_expressions_oclexpression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression719); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression725);
                    ret=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression729); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitOpdBrackSeq();
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
    // $ANTLR end "primary_ocl_expressions_oclexpression"


    // $ANTLR start "oclexpressions_priority_0"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:282:1: oclexpressions_priority_0 returns [Object ret2] : ( (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object oclexpressions_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1); Object semRef=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:283:3: ( ( (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:4: ( (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:4: ( (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:6: (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:6: (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:8: ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_0767);
            ret=primary_ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:49: ( ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==DOT) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred22_Ocl()) ) {
                        alt5=1;
                    }


                }
                else if ( (LA5_0==ARROW) ) {
                    int LA5_3 = input.LA(2);

                    if ( (synpred25_Ocl()) ) {
                        alt5=2;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:50: ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) )
            	    {
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:99: ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) ) )
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:100: DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(".", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,DOT,FOLLOW_DOT_in_oclexpressions_priority_0790); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ".";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:181: ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) )
            	    int alt4=2;
            	    alt4 = dfa4.predict(input);
            	    switch (alt4) {
            	        case 1 :
            	            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:182: ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] )
            	            {
            	            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:204: (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] )
            	            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:205: ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken]
            	            {
            	            pushFollow(FOLLOW_ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp_in_oclexpressions_priority_0805);
            	            ret=ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp(opName, ret, firstToken);

            	            checkFollows();
            	            state._fsp--;
            	            if (state.failed) return ret2;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:285:3: ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] )
            	            {
            	            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:285:24: (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] )
            	            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:285:25: ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken]
            	            {
            	            pushFollow(FOLLOW_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp_in_oclexpressions_priority_0820);
            	            ret=ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp(opName, ret, firstToken);

            	            checkFollows();
            	            state._fsp--;
            	            if (state.failed) return ret2;

            	            }


            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:3: ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) )
            	    {
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:12: ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) )
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:13: ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("->", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,ARROW,FOLLOW_ARROW_in_oclexpressions_priority_0836); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "->";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:98: ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) )
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:99: (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] )
            	    {
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:99: (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] )
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:100: ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp_in_oclexpressions_priority_0844);
            	    ret=ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "oclexpressions_priority_0"


    // $ANTLR start "oclexpressions_priority_1"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:294:1: oclexpressions_priority_1 returns [Object ret2] : ( (ret= oclexpressions_priority_0 ( ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object oclexpressions_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1); Object semRef=null;
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:295:3: ( ( (ret= oclexpressions_priority_0 ( ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) ) )* ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:4: ( (ret= oclexpressions_priority_0 ( ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) ) )* ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:4: ( (ret= oclexpressions_priority_0 ( ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) ) )* ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:6: (ret= oclexpressions_priority_0 ( ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) ) )* )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:6: (ret= oclexpressions_priority_0 ( ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) ) )* )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:8: ret= oclexpressions_priority_0 ( ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_1890);
            ret=oclexpressions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:37: ( ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==EQUALS) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred26_Ocl()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:38: ( EQUALS )=> ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) )
            	    {
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:48: ( EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) ) )
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:49: EQUALS ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQUALS,FOLLOW_EQUALS_in_oclexpressions_priority_1899); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:133: ( (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] ) )
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:134: (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] )
            	    {
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:134: (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken] )
            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:135: ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp_in_oclexpressions_priority_1907);
            	    ret=ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "oclexpressions_priority_1"


    // $ANTLR start "ocl_expressions_oclexpression"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:304:1: ocl_expressions_oclexpression returns [Object ret2] : ret= oclexpressions_priority_1 ;
    public final Object ocl_expressions_oclexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:305:3: (ret= oclexpressions_priority_1 )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:306:3: ret= oclexpressions_priority_1
            {
            pushFollow(FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression944);
            ret=oclexpressions_priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
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
    // $ANTLR end "ocl_expressions_oclexpression"


    // $ANTLR start "ocl_ecore_literalexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:313:1: ocl_ecore_literalexp returns [Object ret2] : (ret= ocl_ecore_primitiveliteralexp | ret= ocl_ecore_enumliteralexp | ret= ocl_ecore_collectionliteralexp ) ;
    public final Object ocl_ecore_literalexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:314:3: ( (ret= ocl_ecore_primitiveliteralexp | ret= ocl_ecore_enumliteralexp | ret= ocl_ecore_collectionliteralexp ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:315:3: (ret= ocl_ecore_primitiveliteralexp | ret= ocl_ecore_enumliteralexp | ret= ocl_ecore_collectionliteralexp )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:315:3: (ret= ocl_ecore_primitiveliteralexp | ret= ocl_ecore_enumliteralexp | ret= ocl_ecore_collectionliteralexp )
            int alt7=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
            case BOOL:
            case APOSTROPHE:
                {
                alt7=1;
                }
                break;
            case QNAME:
                {
                alt7=2;
                }
                break;
            case 45:
            case 47:
            case 49:
            case 51:
            case 53:
                {
                alt7=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:315:4: ret= ocl_ecore_primitiveliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_primitiveliteralexp_in_ocl_ecore_literalexp970);
                    ret=ocl_ecore_primitiveliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:316:5: ret= ocl_ecore_enumliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_enumliteralexp_in_ocl_ecore_literalexp978);
                    ret=ocl_ecore_enumliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:317:5: ret= ocl_ecore_collectionliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_collectionliteralexp_in_ocl_ecore_literalexp986);
                    ret=ocl_ecore_collectionliteralexp();

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
    // $ANTLR end "ocl_ecore_literalexp"


    // $ANTLR start "ocl_ecore_primitiveliteralexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:324:1: ocl_ecore_primitiveliteralexp returns [Object ret2] : (ret= ocl_ecore_numericliteralexp | ret= ocl_ecore_stringliteralexp | ret= ocl_ecore_booleanliteralexp ) ;
    public final Object ocl_ecore_primitiveliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:325:3: ( (ret= ocl_ecore_numericliteralexp | ret= ocl_ecore_stringliteralexp | ret= ocl_ecore_booleanliteralexp ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:326:3: (ret= ocl_ecore_numericliteralexp | ret= ocl_ecore_stringliteralexp | ret= ocl_ecore_booleanliteralexp )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:326:3: (ret= ocl_ecore_numericliteralexp | ret= ocl_ecore_stringliteralexp | ret= ocl_ecore_booleanliteralexp )
            int alt8=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt8=1;
                }
                break;
            case APOSTROPHE:
                {
                alt8=2;
                }
                break;
            case BOOL:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:326:4: ret= ocl_ecore_numericliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_numericliteralexp_in_ocl_ecore_primitiveliteralexp1013);
                    ret=ocl_ecore_numericliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:327:5: ret= ocl_ecore_stringliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_stringliteralexp_in_ocl_ecore_primitiveliteralexp1021);
                    ret=ocl_ecore_stringliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:328:5: ret= ocl_ecore_booleanliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_booleanliteralexp_in_ocl_ecore_primitiveliteralexp1029);
                    ret=ocl_ecore_booleanliteralexp();

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
    // $ANTLR end "ocl_ecore_primitiveliteralexp"


    // $ANTLR start "ocl_ecore_numericliteralexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:335:1: ocl_ecore_numericliteralexp returns [Object ret2] : (ret= ocl_ecore_integerliteralexp | ret= ocl_ecore_realliteralexp ) ;
    public final Object ocl_ecore_numericliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:336:3: ( (ret= ocl_ecore_integerliteralexp | ret= ocl_ecore_realliteralexp ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:337:3: (ret= ocl_ecore_integerliteralexp | ret= ocl_ecore_realliteralexp )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:337:3: (ret= ocl_ecore_integerliteralexp | ret= ocl_ecore_realliteralexp )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==INT) ) {
                alt9=1;
            }
            else if ( (LA9_0==FLOAT) ) {
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:337:4: ret= ocl_ecore_integerliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_integerliteralexp_in_ocl_ecore_numericliteralexp1056);
                    ret=ocl_ecore_integerliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:338:5: ret= ocl_ecore_realliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_realliteralexp_in_ocl_ecore_numericliteralexp1064);
                    ret=ocl_ecore_realliteralexp();

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
    // $ANTLR end "ocl_ecore_numericliteralexp"


    // $ANTLR start "ocl_ecore_integerliteralexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:345:1: ocl_ecore_integerliteralexp returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object ocl_ecore_integerliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","IntegerLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:351:3: ( ( (temp= integerSymbol ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:352:3: ( (temp= integerSymbol ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:352:3: ( (temp= integerSymbol ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:352:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.19/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:352:128: (temp= integerSymbol )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:352:130: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_ocl_ecore_integerliteralexp1098);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "integerSymbol", temp);
              setParent(temp,ret,"integerSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.19/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name='ecore' and c.name='EIntegerObject' endif)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_integerliteralexp"


    // $ANTLR start "ocl_ecore_stringliteralexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:361:1: ocl_ecore_stringliteralexp returns [Object ret2] : ( APOSTROPHE (temp= identifier ) APOSTROPHE ) ;
    public final Object ocl_ecore_stringliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","StringLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:367:3: ( ( APOSTROPHE (temp= identifier ) APOSTROPHE ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:368:3: ( APOSTROPHE (temp= identifier ) APOSTROPHE )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:368:3: ( APOSTROPHE (temp= identifier ) APOSTROPHE )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:368:4: APOSTROPHE (temp= identifier ) APOSTROPHE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.0");
            }
            match(input,APOSTROPHE,FOLLOW_APOSTROPHE_in_ocl_ecore_stringliteralexp1145); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.1");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:368:280: (temp= identifier )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:368:282: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore_stringliteralexp1153);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "stringSymbol", temp);
              setParent(temp,ret,"stringSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.2");
            }
            match(input,APOSTROPHE,FOLLOW_APOSTROPHE_in_ocl_ecore_stringliteralexp1160); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.3");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name='ecore' and c.name='EString' endif)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_stringliteralexp"


    // $ANTLR start "ocl_ecore_realliteralexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:377:1: ocl_ecore_realliteralexp returns [Object ret2] : ( (temp= realSymbol ) ) ;
    public final Object ocl_ecore_realliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","RealLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:383:3: ( ( (temp= realSymbol ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:384:3: ( (temp= realSymbol ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:384:3: ( (temp= realSymbol ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:384:4: (temp= realSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.21/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:384:128: (temp= realSymbol )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:384:130: temp= realSymbol
            {
            pushFollow(FOLLOW_realSymbol_in_ocl_ecore_realliteralexp1208);
            temp=realSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "realSymbol", temp);
              setParent(temp,ret,"realSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.21/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name='ecore' and c.name='EDoubleObject' endif)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_realliteralexp"


    // $ANTLR start "ocl_ecore_booleanliteralexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:393:1: ocl_ecore_booleanliteralexp returns [Object ret2] : ( (temp= booleanValueSymbol ) ) ;
    public final Object ocl_ecore_booleanliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","BooleanLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:399:3: ( ( (temp= booleanValueSymbol ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:400:3: ( (temp= booleanValueSymbol ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:400:3: ( (temp= booleanValueSymbol ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:400:4: (temp= booleanValueSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.22/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:400:128: (temp= booleanValueSymbol )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:400:130: temp= booleanValueSymbol
            {
            pushFollow(FOLLOW_booleanValueSymbol_in_ocl_ecore_booleanliteralexp1258);
            temp=booleanValueSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "booleanSymbol", temp);
              setParent(temp,ret,"booleanSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.22/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name='ecore' and c.name='EBooleanObject' endif)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_booleanliteralexp"


    // $ANTLR start "ocl_ecore_enumliteralexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:409:1: ocl_ecore_enumliteralexp returns [Object ret2] : ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) ;
    public final Object ocl_ecore_enumliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","EnumLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:415:3: ( ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:416:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:416:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:416:4: (temp= qualifiedNameSymbol ) DCOLON (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:416:128: (temp= qualifiedNameSymbol )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:416:130: temp= qualifiedNameSymbol
            {
            pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_ecore_enumliteralexp1308);
            temp=qualifiedNameSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "eType", null, temp, "ecore::EEnum.allInstances() ->select(name = ?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.1");
            }
            match(input,DCOLON,FOLLOW_DCOLON_in_ocl_ecore_enumliteralexp1315); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.2");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:416:532: (temp= identifier )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:416:534: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore_enumliteralexp1323);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "referredEnumLiteral", null, temp, "self.eType.oclAsType(ecore::EEnum).eLiterals->select(literal = ?)");
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
    // $ANTLR end "ocl_ecore_enumliteralexp"


    // $ANTLR start "ocl_expressions_collectionliteralpart"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:424:1: ocl_expressions_collectionliteralpart returns [Object ret2] : (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) ) ;
    public final Object ocl_expressions_collectionliteralpart() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:425:3: ( (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:426:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:426:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )
            int alt10=2;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:426:4: ret= ocl_expressions_collectionitem
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart1363);
                    ret=ocl_expressions_collectionitem();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:427:5: ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange )
                    {
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:427:44: (ret= ocl_expressions_collectionrange )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:427:45: ret= ocl_expressions_collectionrange
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart1378);
                    ret=ocl_expressions_collectionrange();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

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
    // $ANTLR end "ocl_expressions_collectionliteralpart"


    // $ANTLR start "ocl_ecore_collectionliteralexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:434:1: ocl_ecore_collectionliteralexp returns [Object ret2] : ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) ;
    public final Object ocl_ecore_collectionliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","CollectionLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"collectionliteral"}) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:440:3: ( ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:3: ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:3: ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:4: ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:128: ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt11=1;
                }
                break;
            case 47:
                {
                alt11=2;
                }
                break;
            case 49:
                {
                alt11=3;
                }
                break;
            case 51:
                {
                alt11=4;
                }
                break;
            case 53:
                {
                alt11=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:129: ( 'Sequence' (temp= ecore_eclassifier_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:145: ( 'Sequence' (temp= ecore_eclassifier_sequence ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:146: 'Sequence' (temp= ecore_eclassifier_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    match(input,45,FOLLOW_45_in_ocl_ecore_collectionliteralexp1414); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.1");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:470: (temp= ecore_eclassifier_sequence )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:441:472: temp= ecore_eclassifier_sequence
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_sequence_in_ocl_ecore_collectionliteralexp1421);
                    temp=ecore_eclassifier_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.SEQUENCE);_exitInjectorAction();
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:443:4: ( 'Set' (temp= ecore_eclassifier_set ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:443:20: ( 'Set' (temp= ecore_eclassifier_set ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:443:21: 'Set' (temp= ecore_eclassifier_set )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    match(input,47,FOLLOW_47_in_ocl_ecore_collectionliteralexp1440); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.1");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:443:340: (temp= ecore_eclassifier_set )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:443:342: temp= ecore_eclassifier_set
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_set_in_ocl_ecore_collectionliteralexp1447);
                    temp=ecore_eclassifier_set();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.SET);_exitInjectorAction();
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:445:4: ( 'Collection' (temp= ecore_eclassifier_collection ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:445:20: ( 'Collection' (temp= ecore_eclassifier_collection ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:445:21: 'Collection' (temp= ecore_eclassifier_collection )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.0");
                    }
                    match(input,49,FOLLOW_49_in_ocl_ecore_collectionliteralexp1466); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.1");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:445:347: (temp= ecore_eclassifier_collection )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:445:349: temp= ecore_eclassifier_collection
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_collection_in_ocl_ecore_collectionliteralexp1473);
                    temp=ecore_eclassifier_collection();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.COLLECTION);_exitInjectorAction();
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:447:4: ( 'Bag' (temp= ecore_eclassifier_bag ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:447:20: ( 'Bag' (temp= ecore_eclassifier_bag ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:447:21: 'Bag' (temp= ecore_eclassifier_bag )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.0");
                    }
                    match(input,51,FOLLOW_51_in_ocl_ecore_collectionliteralexp1492); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.1");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:447:340: (temp= ecore_eclassifier_bag )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:447:342: temp= ecore_eclassifier_bag
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_bag_in_ocl_ecore_collectionliteralexp1499);
                    temp=ecore_eclassifier_bag();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.BAG);_exitInjectorAction();
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
                case 5 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:449:4: ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(4);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:449:20: ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:449:21: 'OrderedSet' (temp= ecore_eclassifier_orderedset )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.0");
                    }
                    match(input,53,FOLLOW_53_in_ocl_ecore_collectionliteralexp1518); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.1");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:449:347: (temp= ecore_eclassifier_orderedset )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:449:349: temp= ecore_eclassifier_orderedset
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_orderedset_in_ocl_ecore_collectionliteralexp1525);
                    temp=ecore_eclassifier_orderedset();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.ORDERED_SET);_exitInjectorAction();
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.1");
            }
            match(input,LCURL,FOLLOW_LCURL_in_ocl_ecore_collectionliteralexp1540); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.2");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:450:643: (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NAME||LA13_0==QNAME||(LA13_0>=INT && LA13_0<=LPAREN)||LA13_0==APOSTROPHE||LA13_0==39||LA13_0==43||LA13_0==45||LA13_0==47||LA13_0==49||LA13_0==51||(LA13_0>=53 && LA13_0<=54)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:450:645: temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore_collectionliteralexp1548);
                    temp=ocl_expressions_collectionliteralpart();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "part", temp);
                      setParent(temp,ret,"part");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:451:30: ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==COMMA) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:451:31: ( COMMA ) temp= ocl_expressions_collectionliteralpart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:451:48: ( COMMA )
                    	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:451:49: COMMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore_collectionliteralexp1557); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore_collectionliteralexp1565);
                    	    temp=ocl_expressions_collectionliteralpart();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "part", temp);
                    	      setParent(temp,ret,"part");
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.3");
            }
            match(input,RCURL,FOLLOW_RCURL_in_ocl_ecore_collectionliteralexp1577); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.eType.name.substring(1, -4+self.eType.name.size()).concat('{...}')", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_collectionliteralexp"


    // $ANTLR start "ecore_eclassifier_sequence"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:460:1: ecore_eclassifier_sequence returns [Object ret2] : (ret= ecore_edatatype_sequence ) ;
    public final Object ecore_eclassifier_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:461:3: ( (ret= ecore_edatatype_sequence ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:462:3: (ret= ecore_edatatype_sequence )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:462:3: (ret= ecore_edatatype_sequence )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:462:4: ret= ecore_edatatype_sequence
            {
            pushFollow(FOLLOW_ecore_edatatype_sequence_in_ecore_eclassifier_sequence1618);
            ret=ecore_edatatype_sequence();

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
    // $ANTLR end "ecore_eclassifier_sequence"


    // $ANTLR start "ecore_edatatype_sequence"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:469:1: ecore_edatatype_sequence returns [Object ret2] : (ret= ocl_ecore_collectiontype_sequence ) ;
    public final Object ecore_edatatype_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:470:3: ( (ret= ocl_ecore_collectiontype_sequence ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:471:3: (ret= ocl_ecore_collectiontype_sequence )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:471:3: (ret= ocl_ecore_collectiontype_sequence )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:471:4: ret= ocl_ecore_collectiontype_sequence
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_sequence_in_ecore_edatatype_sequence1645);
            ret=ocl_ecore_collectiontype_sequence();

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
    // $ANTLR end "ecore_edatatype_sequence"


    // $ANTLR start "ocl_ecore_collectiontype_sequence"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:478:1: ocl_ecore_collectiontype_sequence returns [Object ret2] : (ret= ocl_ecore_sequencetype_sequence ) ;
    public final Object ocl_ecore_collectiontype_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:479:3: ( (ret= ocl_ecore_sequencetype_sequence ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:480:3: (ret= ocl_ecore_sequencetype_sequence )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:480:3: (ret= ocl_ecore_sequencetype_sequence )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:480:4: ret= ocl_ecore_sequencetype_sequence
            {
            pushFollow(FOLLOW_ocl_ecore_sequencetype_sequence_in_ocl_ecore_collectiontype_sequence1672);
            ret=ocl_ecore_sequencetype_sequence();

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
    // $ANTLR end "ocl_ecore_collectiontype_sequence"


    // $ANTLR start "ocl_ecore_sequencetype_sequence"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:487:1: ocl_ecore_sequencetype_sequence returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_sequencetype_sequence() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","SequenceType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"sequence");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:493:3: ( ( collectiontypeelementtype[ret] ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:494:3: ( collectiontypeelementtype[ret] )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:494:3: ( collectiontypeelementtype[ret] )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:494:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.29/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_sequencetype_sequence1702);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.29/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "SequenceType");_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_sequencetype_sequence"


    // $ANTLR start "ecore_eclassifier_set"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:502:1: ecore_eclassifier_set returns [Object ret2] : (ret= ecore_edatatype_set ) ;
    public final Object ecore_eclassifier_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:503:3: ( (ret= ecore_edatatype_set ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:504:3: (ret= ecore_edatatype_set )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:504:3: (ret= ecore_edatatype_set )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:504:4: ret= ecore_edatatype_set
            {
            pushFollow(FOLLOW_ecore_edatatype_set_in_ecore_eclassifier_set1743);
            ret=ecore_edatatype_set();

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
    // $ANTLR end "ecore_eclassifier_set"


    // $ANTLR start "ecore_edatatype_set"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:511:1: ecore_edatatype_set returns [Object ret2] : (ret= ocl_ecore_collectiontype_set ) ;
    public final Object ecore_edatatype_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:512:3: ( (ret= ocl_ecore_collectiontype_set ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:513:3: (ret= ocl_ecore_collectiontype_set )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:513:3: (ret= ocl_ecore_collectiontype_set )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:513:4: ret= ocl_ecore_collectiontype_set
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_set_in_ecore_edatatype_set1770);
            ret=ocl_ecore_collectiontype_set();

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
    // $ANTLR end "ecore_edatatype_set"


    // $ANTLR start "ocl_ecore_collectiontype_set"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:520:1: ocl_ecore_collectiontype_set returns [Object ret2] : (ret= ocl_ecore_settype_set ) ;
    public final Object ocl_ecore_collectiontype_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:521:3: ( (ret= ocl_ecore_settype_set ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:522:3: (ret= ocl_ecore_settype_set )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:522:3: (ret= ocl_ecore_settype_set )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:522:4: ret= ocl_ecore_settype_set
            {
            pushFollow(FOLLOW_ocl_ecore_settype_set_in_ocl_ecore_collectiontype_set1797);
            ret=ocl_ecore_settype_set();

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
    // $ANTLR end "ocl_ecore_collectiontype_set"


    // $ANTLR start "ocl_ecore_settype_set"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:529:1: ocl_ecore_settype_set returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_settype_set() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","SetType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"set");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:535:3: ( ( collectiontypeelementtype[ret] ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:536:3: ( collectiontypeelementtype[ret] )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:536:3: ( collectiontypeelementtype[ret] )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:536:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.33/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_settype_set1827);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.33/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "SetType");_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_settype_set"


    // $ANTLR start "ecore_eclassifier_collection"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:544:1: ecore_eclassifier_collection returns [Object ret2] : (ret= ecore_edatatype_collection ) ;
    public final Object ecore_eclassifier_collection() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:545:3: ( (ret= ecore_edatatype_collection ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:546:3: (ret= ecore_edatatype_collection )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:546:3: (ret= ecore_edatatype_collection )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:546:4: ret= ecore_edatatype_collection
            {
            pushFollow(FOLLOW_ecore_edatatype_collection_in_ecore_eclassifier_collection1868);
            ret=ecore_edatatype_collection();

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
    // $ANTLR end "ecore_eclassifier_collection"


    // $ANTLR start "ecore_edatatype_collection"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:553:1: ecore_edatatype_collection returns [Object ret2] : (ret= ocl_ecore_collectiontype_collection ) ;
    public final Object ecore_edatatype_collection() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:554:3: ( (ret= ocl_ecore_collectiontype_collection ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:555:3: (ret= ocl_ecore_collectiontype_collection )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:555:3: (ret= ocl_ecore_collectiontype_collection )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:555:4: ret= ocl_ecore_collectiontype_collection
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_collection_in_ecore_edatatype_collection1895);
            ret=ocl_ecore_collectiontype_collection();

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
    // $ANTLR end "ecore_edatatype_collection"


    // $ANTLR start "ocl_ecore_collectiontype_collection"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:562:1: ocl_ecore_collectiontype_collection returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_collectiontype_collection() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","CollectionType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"collection");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:568:3: ( ( collectiontypeelementtype[ret] ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:569:3: ( collectiontypeelementtype[ret] )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:569:3: ( collectiontypeelementtype[ret] )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:569:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.36/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_collectiontype_collection1925);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.36/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "CollectionType");_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_collectiontype_collection"


    // $ANTLR start "ecore_eclassifier_bag"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:577:1: ecore_eclassifier_bag returns [Object ret2] : (ret= ecore_edatatype_bag ) ;
    public final Object ecore_eclassifier_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:578:3: ( (ret= ecore_edatatype_bag ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:579:3: (ret= ecore_edatatype_bag )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:579:3: (ret= ecore_edatatype_bag )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:579:4: ret= ecore_edatatype_bag
            {
            pushFollow(FOLLOW_ecore_edatatype_bag_in_ecore_eclassifier_bag1966);
            ret=ecore_edatatype_bag();

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
    // $ANTLR end "ecore_eclassifier_bag"


    // $ANTLR start "ecore_edatatype_bag"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:586:1: ecore_edatatype_bag returns [Object ret2] : (ret= ocl_ecore_collectiontype_bag ) ;
    public final Object ecore_edatatype_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:587:3: ( (ret= ocl_ecore_collectiontype_bag ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:588:3: (ret= ocl_ecore_collectiontype_bag )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:588:3: (ret= ocl_ecore_collectiontype_bag )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:588:4: ret= ocl_ecore_collectiontype_bag
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_bag_in_ecore_edatatype_bag1993);
            ret=ocl_ecore_collectiontype_bag();

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
    // $ANTLR end "ecore_edatatype_bag"


    // $ANTLR start "ocl_ecore_collectiontype_bag"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:595:1: ocl_ecore_collectiontype_bag returns [Object ret2] : (ret= ocl_ecore_bagtype_bag ) ;
    public final Object ocl_ecore_collectiontype_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:596:3: ( (ret= ocl_ecore_bagtype_bag ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:597:3: (ret= ocl_ecore_bagtype_bag )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:597:3: (ret= ocl_ecore_bagtype_bag )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:597:4: ret= ocl_ecore_bagtype_bag
            {
            pushFollow(FOLLOW_ocl_ecore_bagtype_bag_in_ocl_ecore_collectiontype_bag2020);
            ret=ocl_ecore_bagtype_bag();

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
    // $ANTLR end "ocl_ecore_collectiontype_bag"


    // $ANTLR start "ocl_ecore_bagtype_bag"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:604:1: ocl_ecore_bagtype_bag returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_bagtype_bag() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","BagType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"bag");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:610:3: ( ( collectiontypeelementtype[ret] ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:611:3: ( collectiontypeelementtype[ret] )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:611:3: ( collectiontypeelementtype[ret] )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:611:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.40/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_bagtype_bag2050);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.40/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "BagType");_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_bagtype_bag"


    // $ANTLR start "ecore_eclassifier_orderedset"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:619:1: ecore_eclassifier_orderedset returns [Object ret2] : (ret= ecore_edatatype_orderedset ) ;
    public final Object ecore_eclassifier_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:620:3: ( (ret= ecore_edatatype_orderedset ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:621:3: (ret= ecore_edatatype_orderedset )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:621:3: (ret= ecore_edatatype_orderedset )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:621:4: ret= ecore_edatatype_orderedset
            {
            pushFollow(FOLLOW_ecore_edatatype_orderedset_in_ecore_eclassifier_orderedset2091);
            ret=ecore_edatatype_orderedset();

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
    // $ANTLR end "ecore_eclassifier_orderedset"


    // $ANTLR start "ecore_edatatype_orderedset"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:628:1: ecore_edatatype_orderedset returns [Object ret2] : (ret= ocl_ecore_collectiontype_orderedset ) ;
    public final Object ecore_edatatype_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:629:3: ( (ret= ocl_ecore_collectiontype_orderedset ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:630:3: (ret= ocl_ecore_collectiontype_orderedset )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:630:3: (ret= ocl_ecore_collectiontype_orderedset )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:630:4: ret= ocl_ecore_collectiontype_orderedset
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_orderedset_in_ecore_edatatype_orderedset2118);
            ret=ocl_ecore_collectiontype_orderedset();

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
    // $ANTLR end "ecore_edatatype_orderedset"


    // $ANTLR start "ocl_ecore_collectiontype_orderedset"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:637:1: ocl_ecore_collectiontype_orderedset returns [Object ret2] : (ret= ocl_ecore_orderedsettype_orderedset ) ;
    public final Object ocl_ecore_collectiontype_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:638:3: ( (ret= ocl_ecore_orderedsettype_orderedset ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:639:3: (ret= ocl_ecore_orderedsettype_orderedset )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:639:3: (ret= ocl_ecore_orderedsettype_orderedset )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:639:4: ret= ocl_ecore_orderedsettype_orderedset
            {
            pushFollow(FOLLOW_ocl_ecore_orderedsettype_orderedset_in_ocl_ecore_collectiontype_orderedset2145);
            ret=ocl_ecore_orderedsettype_orderedset();

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
    // $ANTLR end "ocl_ecore_collectiontype_orderedset"


    // $ANTLR start "ocl_ecore_orderedsettype_orderedset"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:646:1: ocl_ecore_orderedsettype_orderedset returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_orderedsettype_orderedset() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","OrderedSetType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"orderedset");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:652:3: ( ( collectiontypeelementtype[ret] ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:653:3: ( collectiontypeelementtype[ret] )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:653:3: ( collectiontypeelementtype[ret] )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:653:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.44/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_orderedsettype_orderedset2175);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.44/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "OrderedSetType");_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_orderedsettype_orderedset"


    // $ANTLR start "collectiontypeelementtype"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:661:1: collectiontypeelementtype[Object ret] : () ;
    public final void collectiontypeelementtype(Object ret) throws RecognitionException {
        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:662:3: ( () )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:663:3: ()
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:663:3: ()
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:663:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.45/@functionSequence/@elements.0");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "elementType", null, null, "OCL:#context(collectionliteral).oclAsType(ocl::ecore::CollectionLiteralExp).part.oclAsType(ocl::ecore::CollectionLiteralPart).eType.oclAsType(ecore::EClass)->iterate("+
              "                                                                t; acc:ecore::EClass=null |"+
              "                                                                        if acc->isEmpty() or acc=t then"+
              "                                                                                t "+
              "                                                                        else "+
              "                                                                                if t.eAllSuperTypes->includes(acc) then"+
              "                                                                                        acc "+
              "                                                                                else "+
              "                                                                                        if acc.eAllSuperTypes->includes(t) then"+
              "                                                                                                t "+
              "                                                                                        else "+
              "                                                                                                null "+
              "                                                                                        endif"+
              "                                                                                endif"+
              "                                                                        endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

                
            }

            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "collectiontypeelementtype"


    // $ANTLR start "ocl_expressions_collectionitem"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:684:1: ocl_expressions_collectionitem returns [Object ret2] : ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem ) ) ;
    public final Object ocl_expressions_collectionitem() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:685:3: ( ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:686:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:686:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:686:4: ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:686:38: (ret= ocl_ecore_collectionitem )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:686:39: ret= ocl_ecore_collectionitem
            {
            pushFollow(FOLLOW_ocl_ecore_collectionitem_in_ocl_expressions_collectionitem2245);
            ret=ocl_ecore_collectionitem();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "ocl_expressions_collectionitem"


    // $ANTLR start "ocl_ecore_collectionitem"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:693:1: ocl_ecore_collectionitem returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_ecore_collectionitem() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","CollectionItem");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:699:3: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:700:3: ( (temp= ocl_expressions_oclexpression ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:700:3: ( (temp= ocl_expressions_oclexpression ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:700:4: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.47/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:700:128: (temp= ocl_expressions_oclexpression )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:700:130: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionitem2280);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "item", temp);
              setParent(temp,ret,"item");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.47/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.item.oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_collectionitem"


    // $ANTLR start "ocl_expressions_collectionrange"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:709:1: ocl_expressions_collectionrange returns [Object ret2] : ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange ) ) ;
    public final Object ocl_expressions_collectionrange() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:710:3: ( ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:711:3: ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:711:3: ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:711:4: ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:711:43: (ret= ocl_ecore_collectionrange )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:711:44: ret= ocl_ecore_collectionrange
            {
            pushFollow(FOLLOW_ocl_ecore_collectionrange_in_ocl_expressions_collectionrange2330);
            ret=ocl_ecore_collectionrange();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // $ANTLR end "ocl_expressions_collectionrange"


    // $ANTLR start "ocl_ecore_collectionrange"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:718:1: ocl_ecore_collectionrange returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_ecore_collectionrange() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","CollectionRange");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:724:3: ( ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:725:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:725:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:725:4: (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:725:128: (temp= ocl_expressions_oclexpression )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:725:130: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionrange2365);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "first", temp);
              setParent(temp,ret,"first");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.1");
            }
            match(input,DDOT,FOLLOW_DDOT_in_ocl_ecore_collectionrange2372); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.2");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:726:317: (temp= ocl_expressions_oclexpression )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:726:319: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionrange2380);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "last", temp);
              setParent(temp,ret,"last");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.3");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:"+
              "                                let f : ocl::ecore::OCLExpression = self.first.oclAsType(ocl::ecore::OCLExpression) in"+
              "                                let l : ocl::ecore::OCLExpression = self.last.oclAsType(ocl::ecore::OCLExpression) in"+
              "                                if f.eType = l.eType then"+
              "                                                        f.eType "+
              "                                                  else "+
              "                                                        if f.eType.oclAsType(ecore::EClass).eAllSuperTypes->includes(l.eType.oclAsType(ecore::EClass)) then"+
              "                                                                l.eType "+
              "                                                        else "+
              "                                                                if l.eType.oclAsType(ecore::EClass).eAllSuperTypes->includes(f.eType.oclAsType(ecore::EClass)) then "+
              "                                                                        f.eType "+
              "                                                                else "+
              "                                                                        null "+
              "                                                                endif "+
              "                                                        endif "+
              "                                                  endif", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_collectionrange"


    // $ANTLR start "ocl_ecore_ifexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:750:1: ocl_ecore_ifexp returns [Object ret2] : ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' ) ;
    public final Object ocl_ecore_ifexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","IfExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:756:3: ( ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:757:3: ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:757:3: ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:757:4: 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.0");
            }
            match(input,39,FOLLOW_39_in_ocl_ecore_ifexp2426); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.1");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:757:272: (temp= ocl_expressions_oclexpression )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==NAME||LA14_0==QNAME||(LA14_0>=INT && LA14_0<=LPAREN)||LA14_0==APOSTROPHE||LA14_0==39||LA14_0==43||LA14_0==45||LA14_0==47||LA14_0==49||LA14_0==51||(LA14_0>=53 && LA14_0<=54)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:757:274: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2433);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "condition", temp);
                      setParent(temp,ret,"condition");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.2");
            }
            match(input,41,FOLLOW_41_in_ocl_ecore_ifexp2441); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.3");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:758:323: ( ( (temp= ocl_expressions_oclexpression )? ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:758:324: ( (temp= ocl_expressions_oclexpression )? )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:758:324: ( (temp= ocl_expressions_oclexpression )? )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:758:325: (temp= ocl_expressions_oclexpression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:758:476: (temp= ocl_expressions_oclexpression )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NAME||LA15_0==QNAME||(LA15_0>=INT && LA15_0<=LPAREN)||LA15_0==APOSTROPHE||LA15_0==39||LA15_0==43||LA15_0==45||LA15_0==47||LA15_0==49||LA15_0==51||(LA15_0>=53 && LA15_0<=54)) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:758:478: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2451);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "thenExpression", temp);
                      setParent(temp,ret,"thenExpression");
                    }

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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.4");
            }
            match(input,44,FOLLOW_44_in_ocl_ecore_ifexp2462); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.5");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:759:346: ( ( (temp= ocl_expressions_oclexpression )? ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:759:347: ( (temp= ocl_expressions_oclexpression )? )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:759:347: ( (temp= ocl_expressions_oclexpression )? )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:759:348: (temp= ocl_expressions_oclexpression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.5/@blockSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:759:499: (temp= ocl_expressions_oclexpression )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==NAME||LA16_0==QNAME||(LA16_0>=INT && LA16_0<=LPAREN)||LA16_0==APOSTROPHE||LA16_0==39||LA16_0==43||LA16_0==45||LA16_0==47||LA16_0==49||LA16_0==51||(LA16_0>=53 && LA16_0<=54)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:759:501: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2472);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elseExpression", temp);
                      setParent(temp,ret,"elseExpression");
                    }

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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.6");
            }
            match(input,40,FOLLOW_40_in_ocl_ecore_ifexp2483); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.7");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:"+
              "                              let te : ocl::ecore::OCLExpression = self.thenExpression.oclAsType(ocl::ecore::OCLExpression) in"+
              "                              let ee : ocl::ecore::OCLExpression = self.elseExpression.oclAsType(ocl::ecore::OCLExpression) in"+
              "                              if te.eType = ee.eType then"+
              "                                  te.eType"+
              "                              else"+
              "                                  if te.oclAsType(ecore::EClass).eAllSuperTypes->includes(ee.eType.oclAsType(ecore::EClass)) then"+
              "                                      ee.eType"+
              "                                  else"+
              "                                      if ee.eType.oclAsType(ecore::EClass).eAllSuperTypes->includes(te.eType.oclAsType(ecore::EClass)) then"+
              "                                          te.eType"+
              "                                      else"+
              "                                          null"+
              "                                      endif"+
              "                                  endif"+
              "                              endif", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_ifexp"


    // $ANTLR start "ocl_ecore_letexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:783:1: ocl_ecore_letexp returns [Object ret2] : ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) ;
    public final Object ocl_ecore_letexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","LetExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:789:3: ( ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:790:3: ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:790:3: ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:790:4: 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.0");
            }
            match(input,54,FOLLOW_54_in_ocl_ecore_letexp2526); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.1");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:790:273: (temp= ocl_expressions_variable_let )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:790:275: temp= ocl_expressions_variable_let
            {
            pushFollow(FOLLOW_ocl_expressions_variable_let_in_ocl_ecore_letexp2533);
            temp=ocl_expressions_variable_let();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "variable", temp);
              setParent(temp,ret,"variable");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.2");
            }
            match(input,50,FOLLOW_50_in_ocl_ecore_letexp2539); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.3");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:791:318: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:791:319: ( (temp= ocl_expressions_oclexpression ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:791:319: ( (temp= ocl_expressions_oclexpression ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:791:320: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:791:471: (temp= ocl_expressions_oclexpression )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:791:473: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_letexp2549);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "in", temp);
              setParent(temp,ret,"in");
            }

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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.\\\"in\\\".oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'let '.concat(self.variable.oclAsType(ocl::ecore::Variable).name)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_letexp"


    // $ANTLR start "ocl_expressions_variable_let"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:800:1: ocl_expressions_variable_let returns [Object ret2] : (ret= ocl_ecore_variable_let ) ;
    public final Object ocl_expressions_variable_let() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:801:3: ( (ret= ocl_ecore_variable_let ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:802:3: (ret= ocl_ecore_variable_let )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:802:3: (ret= ocl_ecore_variable_let )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:802:4: ret= ocl_ecore_variable_let
            {
            pushFollow(FOLLOW_ocl_ecore_variable_let_in_ocl_expressions_variable_let2595);
            ret=ocl_ecore_variable_let();

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
    // $ANTLR end "ocl_expressions_variable_let"


    // $ANTLR start "ocl_ecore_variable_let"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:809:1: ocl_ecore_variable_let returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_ecore_variable_let() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"let");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:815:3: ( ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:816:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:816:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:816:4: (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:816:128: (temp= identifier )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:816:130: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore_variable_let2629);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:817:170: ( () | ( COLON (temp= identifier ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==EQUALS) ) {
                alt17=1;
            }
            else if ( (LA17_0==COLON) ) {
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:817:171: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:817:187: ()
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:817:188: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.0/@elements.0");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.initExpression.oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:818:4: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:818:20: ( COLON (temp= identifier ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:818:21: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.1/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_ecore_variable_let2654); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.1/@elements.1");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:818:342: (temp= identifier )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:818:344: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore_variable_let2662);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "eType", null, temp, "ecore::EClassifier.allInstances()->select(name = ?)");
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.2");
            }
            match(input,EQUALS,FOLLOW_EQUALS_in_ocl_ecore_variable_let2674); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.3");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:818:774: (temp= ocl_expressions_oclexpression )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:818:776: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_variable_let2682);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "initExpression", temp);
              setParent(temp,ret,"initExpression");
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
    // $ANTLR end "ocl_ecore_variable_let"


    // $ANTLR start "ocl_expressions_variable"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:827:1: ocl_expressions_variable returns [Object ret2] : (ret= ocl_ecore_variable ) ;
    public final Object ocl_expressions_variable() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:828:3: ( (ret= ocl_ecore_variable ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:829:3: (ret= ocl_ecore_variable )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:829:3: (ret= ocl_ecore_variable )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:829:4: ret= ocl_ecore_variable
            {
            pushFollow(FOLLOW_ocl_ecore_variable_in_ocl_expressions_variable2722);
            ret=ocl_ecore_variable();

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
    // $ANTLR end "ocl_expressions_variable"


    // $ANTLR start "ocl_ecore_variable"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:836:1: ocl_ecore_variable returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | ) ) ;
    public final Object ocl_ecore_variable() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:842:3: ( ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:843:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:843:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:843:4: (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:843:128: (temp= identifier )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:843:130: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore_variable2756);
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:844:170: ( () | ( COLON (temp= identifier ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==EOF||LA18_0==NAME||LA18_0==EQUALS||LA18_0==COMMA||(LA18_0>=SEMI && LA18_0<=BAR)) ) {
                alt18=1;
            }
            else if ( (LA18_0==COLON) ) {
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:844:171: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:844:187: ()
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:844:188: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.0/@elements.0");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:#context(propertyCallExp).oclAsType(ocl::ecore::CallExp).source.oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:4: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:20: ( COLON (temp= identifier ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:21: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.1/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_ecore_variable2781); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.1/@elements.1");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:342: (temp= identifier )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:344: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore_variable2789);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "eType", null, temp, "ecore::EClassifier.allInstances()->select(name = ?)");
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:627: ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==EQUALS) ) {
                alt19=1;
            }
            else if ( (LA19_0==EOF||LA19_0==NAME||LA19_0==COMMA||(LA19_0>=SEMI && LA19_0<=BAR)) ) {
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:628: ( EQUALS (temp= ocl_expressions_oclexpression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:644: ( EQUALS (temp= ocl_expressions_oclexpression ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:645: EQUALS (temp= ocl_expressions_oclexpression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,EQUALS,FOLLOW_EQUALS_in_ocl_ecore_variable2807); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2/@thenSequence/@elements.1");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:969: (temp= ocl_expressions_oclexpression )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:845:971: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_variable2815);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "initExpression", temp);
                      setParent(temp,ret,"initExpression");
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:846:74: 
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
    // $ANTLR end "ocl_ecore_variable"


    // $ANTLR start "ocl_ecore_variableexp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:855:1: ocl_ecore_variableexp returns [Object ret2] : ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) ) ;
    public final Object ocl_ecore_variableexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","VariableExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:861:3: ( ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:3: ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:3: ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:4: ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:128: ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==43) ) {
                alt20=1;
            }
            else if ( (LA20_0==NAME) ) {
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:129: ( (temp= ocl_expressions_variable_self ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:145: ( (temp= ocl_expressions_variable_self ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:146: (temp= ocl_expressions_variable_self )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:295: (temp= ocl_expressions_variable_self )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:862:297: temp= ocl_expressions_variable_self
                    {
                    pushFollow(FOLLOW_ocl_expressions_variable_self_in_ocl_ecore_variableexp2880);
                    temp=ocl_expressions_variable_self();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "referredVariable", temp);
                      setParent(temp,ret,"referredVariable");
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
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:864:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:864:20: ( (temp= identifier ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:864:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:864:170: (temp= identifier )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:864:172: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore_variableexp2900);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "referredVariable", null, temp, "ocl::ecore::Variable.allInstances()->select(getName() = ?)");
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.referredVariable.oclAsType(ocl::ecore::Variable).eType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredVariable.oclAsType(ocl::ecore::Variable).name", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_variableexp"


    // $ANTLR start "ocl_expressions_variable_self"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:872:1: ocl_expressions_variable_self returns [Object ret2] : (ret= ocl_ecore_variable_self ) ;
    public final Object ocl_expressions_variable_self() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:873:3: ( (ret= ocl_ecore_variable_self ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:874:3: (ret= ocl_ecore_variable_self )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:874:3: (ret= ocl_ecore_variable_self )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:874:4: ret= ocl_ecore_variable_self
            {
            pushFollow(FOLLOW_ocl_ecore_variable_self_in_ocl_expressions_variable_self2948);
            ret=ocl_ecore_variable_self();

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
    // $ANTLR end "ocl_expressions_variable_self"


    // $ANTLR start "ocl_ecore_variable_self"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:881:1: ocl_ecore_variable_self returns [Object ret2] : ( 'self' ) ;
    public final Object ocl_ecore_variable_self() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"self");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:887:3: ( ( 'self' ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:888:3: ( 'self' )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:888:3: ( 'self' )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:888:4: 'self'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.58/@templateSequence/@elements.0");
            }
            match(input,43,FOLLOW_43_in_ocl_ecore_variable_self2978); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.58/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "self");_exitInjectorAction();_enterInjectorAction();setRef(ret, "eType", list("ecore","EClassifier"), null, null, "#context(class)", null, null, false, null, true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_variable_self"


    // $ANTLR start "ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:896:1: ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN ) ;
    public final Object ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("ocl","ecore","IterateExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:901:3: ( ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:3: ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:3: ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:4: ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:128: ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) )
            int alt30=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt30=1;
                }
                break;
            case 42:
                {
                alt30=2;
                }
                break;
            case 46:
                {
                alt30=3;
                }
                break;
            case 48:
                {
                alt30=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:129: ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:145: ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:146: 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    match(input,52,FOLLOW_52_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3027); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3031); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.2");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:642: (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==NAME) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:902:644: temp= ocl_expressions_variable (temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3039);
                            temp=ocl_expressions_variable();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:903:34: (temp= ocl_expressions_variable )*
                            loop21:
                            do {
                                int alt21=2;
                                int LA21_0 = input.LA(1);

                                if ( (LA21_0==NAME) ) {
                                    alt21=1;
                                }


                                switch (alt21) {
                            	case 1 :
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:903:36: temp= ocl_expressions_variable
                            	    {
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3047);
                            	    temp=ocl_expressions_variable();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "iterator", temp);
                            	      setParent(temp,ret,"iterator");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop21;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:904:204: ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==SEMI) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==EOF||LA23_0==BAR) ) {
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
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:904:205: ( SEMI (temp= ocl_expressions_variable ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:904:221: ( SEMI (temp= ocl_expressions_variable ) )
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:904:222: SEMI (temp= ocl_expressions_variable )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.0/@elements.0");
                            }
                            match(input,SEMI,FOLLOW_SEMI_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3064); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.0/@elements.1");
                            }
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:904:592: (temp= ocl_expressions_variable )
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:904:594: temp= ocl_expressions_variable
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3072);
                            temp=ocl_expressions_variable();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "result", temp);
                              setParent(temp,ret,"result");
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
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:906:4: ( (temp= ocl_expressions_variable_implicitAccumulator ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:906:20: ( (temp= ocl_expressions_variable_implicitAccumulator ) )
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:906:21: (temp= ocl_expressions_variable_implicitAccumulator )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.1/@elements.0");
                            }
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:906:195: (temp= ocl_expressions_variable_implicitAccumulator )
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:906:197: temp= ocl_expressions_variable_implicitAccumulator
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_implicitAccumulator_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3092);
                            temp=ocl_expressions_variable_implicitAccumulator();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "result", temp);
                              setParent(temp,ret,"result");
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
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:908:4: ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:908:20: ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:908:21: 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    match(input,42,FOLLOW_42_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3113); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3117); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.2");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:908:516: (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==NAME) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:908:518: temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3125);
                            temp=ocl_expressions_variable();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:909:34: ( ( COMMA ) temp= ocl_expressions_variable )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==COMMA) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:909:35: ( COMMA ) temp= ocl_expressions_variable
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:909:52: ( COMMA )
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:909:53: COMMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3134); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3142);
                            	    temp=ocl_expressions_variable();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "iterator", temp);
                            	      setParent(temp,ret,"iterator");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop24;
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
                      _exitAlt();
                    }

                    }
                    break;
                case 3 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:911:4: ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:911:20: ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:911:21: 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.0");
                    }
                    match(input,46,FOLLOW_46_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3163); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3167); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.2");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:911:517: (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==NAME) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:911:519: temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3175);
                            temp=ocl_expressions_variable();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:912:34: ( ( COMMA ) temp= ocl_expressions_variable )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==COMMA) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:912:35: ( COMMA ) temp= ocl_expressions_variable
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:912:52: ( COMMA )
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:912:53: COMMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3184); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3192);
                            	    temp=ocl_expressions_variable();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "iterator", temp);
                            	      setParent(temp,ret,"iterator");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop26;
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
                      _exitAlt();
                    }

                    }
                    break;
                case 4 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:914:4: ( 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:914:20: ( 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:914:21: 'select' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.3/@elements.0");
                    }
                    match(input,48,FOLLOW_48_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3213); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.3/@elements.1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3217); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.3/@elements.2");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:914:516: (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==NAME) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:914:518: temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3225);
                            temp=ocl_expressions_variable();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:915:34: ( ( COMMA ) temp= ocl_expressions_variable )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==COMMA) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:915:35: ( COMMA ) temp= ocl_expressions_variable
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:915:52: ( COMMA )
                            	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:915:53: COMMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.3/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3234); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3242);
                            	    temp=ocl_expressions_variable();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "iterator", temp);
                            	      setParent(temp,ret,"iterator");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop28;
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
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.1");
            }
            match(input,BAR,FOLLOW_BAR_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3259); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.2");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:916:356: (temp= ocl_expressions_oclexpression )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==NAME||LA31_0==QNAME||(LA31_0>=INT && LA31_0<=LPAREN)||LA31_0==APOSTROPHE||LA31_0==39||LA31_0==43||LA31_0==45||LA31_0==47||LA31_0==49||LA31_0==51||(LA31_0>=53 && LA31_0<=54)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:916:358: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3267);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "body", temp);
                      setParent(temp,ret,"body");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3276); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"source" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);
              leaveContext();


            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp"


    // $ANTLR start "ocl_expressions_variable_implicitAccumulator"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:928:1: ocl_expressions_variable_implicitAccumulator returns [Object ret2] : (ret= ocl_ecore_variable_implicitAccumulator ) ;
    public final Object ocl_expressions_variable_implicitAccumulator() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:929:3: ( (ret= ocl_ecore_variable_implicitAccumulator ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:930:3: (ret= ocl_ecore_variable_implicitAccumulator )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:930:3: (ret= ocl_ecore_variable_implicitAccumulator )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:930:4: ret= ocl_ecore_variable_implicitAccumulator
            {
            pushFollow(FOLLOW_ocl_ecore_variable_implicitAccumulator_in_ocl_expressions_variable_implicitAccumulator3306);
            ret=ocl_ecore_variable_implicitAccumulator();

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
    // $ANTLR end "ocl_expressions_variable_implicitAccumulator"


    // $ANTLR start "ocl_ecore_variable_implicitAccumulator"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:937:1: ocl_ecore_variable_implicitAccumulator returns [Object ret2] : () ;
    public final Object ocl_ecore_variable_implicitAccumulator() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"implicitAccumulator");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:943:3: ( () )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:944:3: ()
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:944:3: ()
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:944:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.61/@templateSequence/@elements.0");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "acc");_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:#context(propertyCallExp).oclAsType(ocl::ecore::IterateExp).\\\"body\\\".oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_ecore_variable_implicitAccumulator"


    // $ANTLR start "ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:952:1: ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifierOrKeyword ) ) ;
    public final Object ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("ocl","ecore","PropertyCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:957:3: ( ( (temp= identifierOrKeyword ) ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:958:3: ( (temp= identifierOrKeyword ) )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:958:3: ( (temp= identifierOrKeyword ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:958:4: (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.62/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:958:128: (temp= identifierOrKeyword )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:958:130: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp3381);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "referredProperty", null, temp, "self.source.oclAsType(ocl::ecore::OCLExpression).eType.oclAsType(ecore::EClass).eAllStructuralFeatures->select(name = ?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.62/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredProperty.oclAsType(ecore::EStructuralFeature).name", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.referredProperty.oclAsType(ecore::EStructuralFeature).eType", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"source" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);
              leaveContext();


            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp"


    // $ANTLR start "ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:969:1: ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifierOrKeyword )? LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ;
    public final Object ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("ocl","ecore","OperationCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:974:3: ( ( (temp= identifierOrKeyword )? LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:975:3: ( (temp= identifierOrKeyword )? LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:975:3: ( (temp= identifierOrKeyword )? LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:975:4: (temp= identifierOrKeyword )? LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:975:128: (temp= identifierOrKeyword )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==NAME||(LA32_0>=39 && LA32_0<=54)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:975:130: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3424);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "referredOperation", null, temp, "OCL:self.source.oclAsType(ocl::ecore::OCLExpression).eType.oclAsType(ecore::EClass).eAllOperations->select(name = ?)");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3433); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.2");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:975:616: (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==NAME||LA34_0==QNAME||(LA34_0>=INT && LA34_0<=LPAREN)||LA34_0==APOSTROPHE||LA34_0==39||LA34_0==43||LA34_0==45||LA34_0==47||LA34_0==49||LA34_0==51||(LA34_0>=53 && LA34_0<=54)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:975:618: temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3441);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "argument", temp);
                      setParent(temp,ret,"argument");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:976:34: (temp= ocl_expressions_oclexpression )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==NAME||LA33_0==QNAME||(LA33_0>=INT && LA33_0<=LPAREN)||LA33_0==APOSTROPHE||LA33_0==39||LA33_0==43||LA33_0==45||LA33_0==47||LA33_0==49||LA33_0==51||(LA33_0>=53 && LA33_0<=54)) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:976:36: temp= ocl_expressions_oclexpression
                    	    {
                    	    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3449);
                    	    temp=ocl_expressions_oclexpression();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "argument", temp);
                    	      setParent(temp,ret,"argument");
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3461); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredOperation.oclAsType(ecore::EOperation).name.concat('(...)')", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:let params : OrderedSet(ecore::EParameter) = self.referredOperation.oclAsType(ecore::EOperation).eParameters in"+
              "             				if params->isEmpty() then"+
              "             					null --todo: use OclVoid from StdLib"+
              "             				else"+
              "             					params->at(1).eType"+
              "             				endif ", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"source" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);
              leaveContext();


            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp"


    // $ANTLR start "ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp"
    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:993:1: ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifierOrKeyword )? (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? ) ;
    public final Object ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("ocl","ecore","OperationCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:998:3: ( ( (temp= identifierOrKeyword )? (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? ) )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:999:3: ( (temp= identifierOrKeyword )? (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? )
            {
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:999:3: ( (temp= identifierOrKeyword )? (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? )
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:999:4: (temp= identifierOrKeyword )? (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.64/@templateSequence/@elements.0");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:999:128: (temp= identifierOrKeyword )?
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:999:130: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp3502);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "referredOperation", null, temp, "OCL:ecore::EClass.allInstances()->select(c | c.ePackage.name = 'oclstdlib' and "+
                      "          				let type : ecore::EClassifier = source.oclAsType(ocl::ecore::OCLExpression).eType in"+
                      "          				if type.name = 'EBoolean' then"+
                      "          					c.name = 'Boolean_Class'"+
                      "          				else"+
                      "          					c.name = 'OclVoid_Class'"+
                      "          				endif"+
                      "          			).eOperations->select(op | op.oclAsType(ecore::EOperation).name = '=')->select(name = ?)");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.64/@templateSequence/@elements.1");
            }
            // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1006:250: (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1006:252: temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp3514);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "argument", temp);
                      setParent(temp,ret,"argument");
                    }
                    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1007:34: (temp= ocl_expressions_oclexpression )*
                    loop36:
                    do {
                        int alt36=2;
                        alt36 = dfa36.predict(input);
                        switch (alt36) {
                    	case 1 :
                    	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1007:36: temp= ocl_expressions_oclexpression
                    	    {
                    	    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp3522);
                    	    temp=ocl_expressions_oclexpression();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "argument", temp);
                    	      setParent(temp,ret,"argument");
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop36;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.64/@templateSequence/@elements.2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setRef(ret, "name", list("ecore","EString"), null, null, "equals", null, null, false, null, true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c | c.ePackage.name ='ecore' and c.name = 'EBoolean')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"source" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);
              leaveContext();


            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp"

    // $ANTLR start synpred22_Ocl
    public final void synpred22_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:50: ( DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:51: DOT ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) )
        {
        match(input,DOT,FOLLOW_DOT_in_synpred22_Ocl770); if (state.failed) return ;
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:54: ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) )
        int alt38=2;
        int LA38_0 = input.LA(1);

        if ( (LA38_0==NAME) ) {
            int LA38_1 = input.LA(2);

            if ( (LA38_1==LPAREN) ) {
                alt38=2;
            }
            else if ( ((LA38_1>=NAME && LA38_1<=BOOL)||(LA38_1>=RPAREN && LA38_1<=54)) ) {
                alt38=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 38, 0, input);

            throw nvae;
        }
        switch (alt38) {
            case 1 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:55: ( identifier ~ LPAREN )
                {
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:55: ( identifier ~ LPAREN )
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:56: identifier ~ LPAREN
                {
                pushFollow(FOLLOW_identifier_in_synpred22_Ocl773);
                identifier();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                if ( (input.LA(1)>=NAME && input.LA(1)<=BOOL)||(input.LA(1)>=RPAREN && input.LA(1)<=54) ) {
                    input.consume();
                    state.errorRecovery=false;state.failed=false;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    MismatchedSetException mse = new MismatchedSetException(null,input);
                    throw mse;
                }


                }


                }
                break;
            case 2 :
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:76: ( identifier LPAREN )
                {
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:76: ( identifier LPAREN )
                // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:77: identifier LPAREN
                {
                pushFollow(FOLLOW_identifier_in_synpred22_Ocl780);
                identifier();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,LPAREN,FOLLOW_LPAREN_in_synpred22_Ocl782); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred22_Ocl

    // $ANTLR start synpred23_Ocl
    public final void synpred23_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:182: ( identifier ~ LPAREN )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:284:183: identifier ~ LPAREN
        {
        pushFollow(FOLLOW_identifier_in_synpred23_Ocl796);
        identifier();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        if ( (input.LA(1)>=NAME && input.LA(1)<=BOOL)||(input.LA(1)>=RPAREN && input.LA(1)<=54) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred23_Ocl

    // $ANTLR start synpred24_Ocl
    public final void synpred24_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:285:3: ( identifier LPAREN )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:285:4: identifier LPAREN
        {
        pushFollow(FOLLOW_identifier_in_synpred24_Ocl812);
        identifier();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred24_Ocl814); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_Ocl

    // $ANTLR start synpred25_Ocl
    public final void synpred25_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:3: ( ARROW )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:286:4: ARROW
        {
        match(input,ARROW,FOLLOW_ARROW_in_synpred25_Ocl830); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_Ocl

    // $ANTLR start synpred26_Ocl
    public final void synpred26_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:38: ( EQUALS )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:296:39: EQUALS
        {
        match(input,EQUALS,FOLLOW_EQUALS_in_synpred26_Ocl893); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Ocl

    // $ANTLR start synpred32_Ocl
    public final void synpred32_Ocl_fragment() throws RecognitionException {   
        Object ret = null;


        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:426:4: (ret= ocl_expressions_collectionitem )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:426:4: ret= ocl_expressions_collectionitem
        {
        pushFollow(FOLLOW_ocl_expressions_collectionitem_in_synpred32_Ocl1363);
        ret=ocl_expressions_collectionitem();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_Ocl

    // $ANTLR start synpred33_Ocl
    public final void synpred33_Ocl_fragment() throws RecognitionException {   
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:427:5: ( ocl_expressions_oclexpression COMMA )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:427:6: ocl_expressions_oclexpression COMMA
        {
        pushFollow(FOLLOW_ocl_expressions_oclexpression_in_synpred33_Ocl1370);
        ocl_expressions_oclexpression();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred33_Ocl1372); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_Ocl

    // $ANTLR start synpred65_Ocl
    public final void synpred65_Ocl_fragment() throws RecognitionException {   
        Object temp = null;


        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:999:130: (temp= identifierOrKeyword )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:999:130: temp= identifierOrKeyword
        {
        pushFollow(FOLLOW_identifierOrKeyword_in_synpred65_Ocl3502);
        temp=identifierOrKeyword();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_Ocl

    // $ANTLR start synpred66_Ocl
    public final void synpred66_Ocl_fragment() throws RecognitionException {   
        Object temp = null;


        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1007:36: (temp= ocl_expressions_oclexpression )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1007:36: temp= ocl_expressions_oclexpression
        {
        pushFollow(FOLLOW_ocl_expressions_oclexpression_in_synpred66_Ocl3522);
        temp=ocl_expressions_oclexpression();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_Ocl

    // $ANTLR start synpred67_Ocl
    public final void synpred67_Ocl_fragment() throws RecognitionException {   
        Object temp = null;


        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1006:252: (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1006:252: temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )*
        {
        pushFollow(FOLLOW_ocl_expressions_oclexpression_in_synpred67_Ocl3514);
        temp=ocl_expressions_oclexpression();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1007:34: (temp= ocl_expressions_oclexpression )*
        loop52:
        do {
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==NAME||LA52_0==QNAME||(LA52_0>=INT && LA52_0<=LPAREN)||LA52_0==APOSTROPHE||LA52_0==39||LA52_0==43||LA52_0==45||LA52_0==47||LA52_0==49||LA52_0==51||(LA52_0>=53 && LA52_0<=54)) ) {
                alt52=1;
            }


            switch (alt52) {
        	case 1 :
        	    // /Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g:1007:36: temp= ocl_expressions_oclexpression
        	    {
        	    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_synpred67_Ocl3522);
        	    temp=ocl_expressions_oclexpression();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop52;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred67_Ocl

    // Delegated rules

    public final boolean synpred25_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA4_eotS =
        "\24\uffff";
    static final String DFA4_eofS =
        "\24\uffff";
    static final String DFA4_minS =
        "\1\4\21\0\2\uffff";
    static final String DFA4_maxS =
        "\1\66\21\0\2\uffff";
    static final String DFA4_acceptS =
        "\22\uffff\1\2\1\1";
    static final String DFA4_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1"+
        "\16\1\17\1\20\1\21\2\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\6\uffff\1\22\33\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
            "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "284:181: ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) | ( identifier LPAREN )=> (ret= ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken] ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_0 = input.LA(1);

                         
                        int index4_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA4_0==NAME) ) {s = 1;}

                        else if ( (LA4_0==39) ) {s = 2;}

                        else if ( (LA4_0==40) ) {s = 3;}

                        else if ( (LA4_0==41) ) {s = 4;}

                        else if ( (LA4_0==42) ) {s = 5;}

                        else if ( (LA4_0==43) ) {s = 6;}

                        else if ( (LA4_0==44) ) {s = 7;}

                        else if ( (LA4_0==45) ) {s = 8;}

                        else if ( (LA4_0==46) ) {s = 9;}

                        else if ( (LA4_0==47) ) {s = 10;}

                        else if ( (LA4_0==48) ) {s = 11;}

                        else if ( (LA4_0==49) ) {s = 12;}

                        else if ( (LA4_0==50) ) {s = 13;}

                        else if ( (LA4_0==51) ) {s = 14;}

                        else if ( (LA4_0==52) ) {s = 15;}

                        else if ( (LA4_0==53) ) {s = 16;}

                        else if ( (LA4_0==54) ) {s = 17;}

                        else if ( (LA4_0==LPAREN) && (synpred24_Ocl())) {s = 18;}

                         
                        input.seek(index4_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_1 = input.LA(1);

                         
                        int index4_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_2 = input.LA(1);

                         
                        int index4_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_4 = input.LA(1);

                         
                        int index4_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_6 = input.LA(1);

                         
                        int index4_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_6);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_8 = input.LA(1);

                         
                        int index4_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_8);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_9 = input.LA(1);

                         
                        int index4_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_9);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_10 = input.LA(1);

                         
                        int index4_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_10);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA4_11 = input.LA(1);

                         
                        int index4_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_11);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA4_12 = input.LA(1);

                         
                        int index4_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_12);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA4_14 = input.LA(1);

                         
                        int index4_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_14);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA4_15 = input.LA(1);

                         
                        int index4_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_15);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA4_16 = input.LA(1);

                         
                        int index4_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_16);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA4_17 = input.LA(1);

                         
                        int index4_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred23_Ocl()) ) {s = 19;}

                        else if ( (synpred24_Ocl()) ) {s = 18;}

                         
                        input.seek(index4_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA10_eotS =
        "\22\uffff";
    static final String DFA10_eofS =
        "\22\uffff";
    static final String DFA10_minS =
        "\1\4\17\0\2\uffff";
    static final String DFA10_maxS =
        "\1\66\17\0\2\uffff";
    static final String DFA10_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA10_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\2\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\16\1\uffff\1\5\1\uffff\1\1\1\2\1\4\1\17\4\uffff\1\3\26\uffff"+
            "\1\13\3\uffff\1\15\1\uffff\1\6\1\uffff\1\7\1\uffff\1\10\1\uffff"+
            "\1\11\1\uffff\1\12\1\14",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "426:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_1 = input.LA(1);

                         
                        int index10_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA10_2 = input.LA(1);

                         
                        int index10_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA10_3 = input.LA(1);

                         
                        int index10_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA10_4 = input.LA(1);

                         
                        int index10_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA10_5 = input.LA(1);

                         
                        int index10_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA10_6 = input.LA(1);

                         
                        int index10_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA10_7 = input.LA(1);

                         
                        int index10_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA10_11 = input.LA(1);

                         
                        int index10_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA10_12 = input.LA(1);

                         
                        int index10_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA10_13 = input.LA(1);

                         
                        int index10_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA10_14 = input.LA(1);

                         
                        int index10_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA10_15 = input.LA(1);

                         
                        int index10_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_Ocl()) ) {s = 16;}

                        else if ( (synpred33_Ocl()) ) {s = 17;}

                         
                        input.seek(index10_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA35_eotS =
        "\42\uffff";
    static final String DFA35_eofS =
        "\1\22\41\uffff";
    static final String DFA35_minS =
        "\1\4\4\0\1\uffff\3\0\1\uffff\1\0\1\uffff\3\0\1\uffff\2\0\20\uffff";
    static final String DFA35_maxS =
        "\1\66\4\0\1\uffff\3\0\1\uffff\1\0\1\uffff\3\0\1\uffff\2\0\20\uffff";
    static final String DFA35_acceptS =
        "\5\uffff\1\1\14\uffff\1\2\17\uffff";
    static final String DFA35_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\uffff\1\4\1\5\1\6\1\uffff\1\7\1\uffff"+
        "\1\10\1\11\1\12\1\uffff\1\13\1\14\20\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1\1\uffff\1\22\1\uffff\11\22\2\uffff\3\22\1\uffff\2\22\16"+
            "\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\5\1\12\1\5\1\14\1\15\1"+
            "\16\1\5\1\20\1\21",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "999:128: (temp= identifierOrKeyword )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_1 = input.LA(1);

                         
                        int index35_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_2 = input.LA(1);

                         
                        int index35_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_3 = input.LA(1);

                         
                        int index35_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA35_4 = input.LA(1);

                         
                        int index35_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA35_6 = input.LA(1);

                         
                        int index35_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA35_7 = input.LA(1);

                         
                        int index35_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA35_8 = input.LA(1);

                         
                        int index35_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA35_10 = input.LA(1);

                         
                        int index35_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_10);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA35_12 = input.LA(1);

                         
                        int index35_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA35_13 = input.LA(1);

                         
                        int index35_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA35_14 = input.LA(1);

                         
                        int index35_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_14);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA35_16 = input.LA(1);

                         
                        int index35_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_16);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA35_17 = input.LA(1);

                         
                        int index35_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred65_Ocl()) ) {s = 5;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index35_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\37\uffff";
    static final String DFA37_eofS =
        "\1\20\36\uffff";
    static final String DFA37_minS =
        "\1\4\17\0\17\uffff";
    static final String DFA37_maxS =
        "\1\66\17\0\17\uffff";
    static final String DFA37_acceptS =
        "\20\uffff\1\2\15\uffff\1\1";
    static final String DFA37_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\17\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\16\1\uffff\1\5\1\uffff\1\1\1\2\1\4\1\17\4\20\1\3\2\uffff"+
            "\3\20\1\uffff\2\20\16\uffff\1\13\2\20\1\uffff\1\15\1\20\1\6"+
            "\1\uffff\1\7\1\uffff\1\10\1\20\1\11\1\uffff\1\12\1\14",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
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

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "1006:250: (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA37_1 = input.LA(1);

                         
                        int index37_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA37_2 = input.LA(1);

                         
                        int index37_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA37_3 = input.LA(1);

                         
                        int index37_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA37_4 = input.LA(1);

                         
                        int index37_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA37_5 = input.LA(1);

                         
                        int index37_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA37_6 = input.LA(1);

                         
                        int index37_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA37_7 = input.LA(1);

                         
                        int index37_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA37_8 = input.LA(1);

                         
                        int index37_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA37_9 = input.LA(1);

                         
                        int index37_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA37_10 = input.LA(1);

                         
                        int index37_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA37_11 = input.LA(1);

                         
                        int index37_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA37_12 = input.LA(1);

                         
                        int index37_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA37_13 = input.LA(1);

                         
                        int index37_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA37_14 = input.LA(1);

                         
                        int index37_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA37_15 = input.LA(1);

                         
                        int index37_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index37_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 37, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA36_eotS =
        "\37\uffff";
    static final String DFA36_eofS =
        "\1\1\36\uffff";
    static final String DFA36_minS =
        "\1\4\14\uffff\1\0\2\uffff\16\0\1\uffff";
    static final String DFA36_maxS =
        "\1\66\14\uffff\1\0\2\uffff\16\0\1\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\2\34\uffff\1\1";
    static final String DFA36_specialS =
        "\15\uffff\1\0\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\14\1\15\1\16\1\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\15\1\uffff\1\24\1\uffff\1\20\1\21\1\23\1\35\4\1\1\22\2\uffff"+
            "\3\1\1\uffff\2\1\16\uffff\1\32\2\1\1\uffff\1\34\1\1\1\25\1\uffff"+
            "\1\26\1\uffff\1\27\1\1\1\30\1\uffff\1\31\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 1007:34: (temp= ocl_expressions_oclexpression )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_13 = input.LA(1);

                         
                        int index36_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_16 = input.LA(1);

                         
                        int index36_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_16);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_17 = input.LA(1);

                         
                        int index36_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_17);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA36_18 = input.LA(1);

                         
                        int index36_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_18);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA36_19 = input.LA(1);

                         
                        int index36_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_19);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA36_20 = input.LA(1);

                         
                        int index36_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_20);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA36_21 = input.LA(1);

                         
                        int index36_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_21);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA36_22 = input.LA(1);

                         
                        int index36_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_22);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA36_23 = input.LA(1);

                         
                        int index36_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_23);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA36_24 = input.LA(1);

                         
                        int index36_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_24);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA36_25 = input.LA(1);

                         
                        int index36_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_25);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA36_26 = input.LA(1);

                         
                        int index36_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_26);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA36_27 = input.LA(1);

                         
                        int index36_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_27);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA36_28 = input.LA(1);

                         
                        int index36_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_28);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA36_29 = input.LA(1);

                         
                        int index36_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_Ocl()) ) {s = 30;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index36_29);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_identifierOrKeyword108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_identifierOrKeyword116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_identifierOrKeyword124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_identifierOrKeyword140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_identifierOrKeyword148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_identifierOrKeyword156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_identifierOrKeyword164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_identifierOrKeyword180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qualifiedNameSymbol290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsString414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsString445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanValueSymbol507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_realSymbol569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_doubleSymbol600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_literalexp_in_ocl_ecore_oclexpression627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_ifexp_in_ocl_ecore_oclexpression635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_letexp_in_ocl_ecore_oclexpression643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variableexp_in_ocl_ecore_oclexpression651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_main679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_oclexpression_in_primary_ocl_expressions_oclexpression710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression719 = new BitSet(new long[]{0x006AA88000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression725 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_0767 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_DOT_in_oclexpressions_priority_0790 = new BitSet(new long[]{0x007FFF8000000810L});
    public static final BitSet FOLLOW_ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp_in_oclexpressions_priority_0805 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp_in_oclexpressions_priority_0820 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ARROW_in_oclexpressions_priority_0836 = new BitSet(new long[]{0x0011440000000000L});
    public static final BitSet FOLLOW_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp_in_oclexpressions_priority_0844 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_1890 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_EQUALS_in_oclexpressions_priority_1899 = new BitSet(new long[]{0x007FFF8000018F50L});
    public static final BitSet FOLLOW_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp_in_oclexpressions_priority_1907 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_primitiveliteralexp_in_ocl_ecore_literalexp970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_enumliteralexp_in_ocl_ecore_literalexp978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectionliteralexp_in_ocl_ecore_literalexp986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_numericliteralexp_in_ocl_ecore_primitiveliteralexp1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_stringliteralexp_in_ocl_ecore_primitiveliteralexp1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_booleanliteralexp_in_ocl_ecore_primitiveliteralexp1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_integerliteralexp_in_ocl_ecore_numericliteralexp1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_realliteralexp_in_ocl_ecore_numericliteralexp1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_ocl_ecore_integerliteralexp1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_APOSTROPHE_in_ocl_ecore_stringliteralexp1145 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_stringliteralexp1153 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_APOSTROPHE_in_ocl_ecore_stringliteralexp1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realSymbol_in_ocl_ecore_realliteralexp1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValueSymbol_in_ocl_ecore_booleanliteralexp1258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_ecore_enumliteralexp1308 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_DCOLON_in_ocl_ecore_enumliteralexp1315 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_enumliteralexp1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ocl_ecore_collectionliteralexp1414 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_sequence_in_ocl_ecore_collectionliteralexp1421 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_47_in_ocl_ecore_collectionliteralexp1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_set_in_ocl_ecore_collectionliteralexp1447 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_49_in_ocl_ecore_collectionliteralexp1466 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_collection_in_ocl_ecore_collectionliteralexp1473 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_51_in_ocl_ecore_collectionliteralexp1492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_bag_in_ocl_ecore_collectionliteralexp1499 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_53_in_ocl_ecore_collectionliteralexp1518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_orderedset_in_ocl_ecore_collectionliteralexp1525 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_LCURL_in_ocl_ecore_collectionliteralexp1540 = new BitSet(new long[]{0x006AA88000110F50L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore_collectionliteralexp1548 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore_collectionliteralexp1557 = new BitSet(new long[]{0x006AA88000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore_collectionliteralexp1565 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_RCURL_in_ocl_ecore_collectionliteralexp1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_sequence_in_ecore_eclassifier_sequence1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_sequence_in_ecore_edatatype_sequence1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_sequencetype_sequence_in_ocl_ecore_collectiontype_sequence1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_sequencetype_sequence1702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_set_in_ecore_eclassifier_set1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_set_in_ecore_edatatype_set1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_settype_set_in_ocl_ecore_collectiontype_set1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_settype_set1827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_collection_in_ecore_eclassifier_collection1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_collection_in_ecore_edatatype_collection1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_collectiontype_collection1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_bag_in_ecore_eclassifier_bag1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_bag_in_ecore_edatatype_bag1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_bagtype_bag_in_ocl_ecore_collectiontype_bag2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_bagtype_bag2050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_orderedset_in_ecore_eclassifier_orderedset2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_orderedset_in_ecore_edatatype_orderedset2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_orderedsettype_orderedset_in_ocl_ecore_collectiontype_orderedset2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_orderedsettype_orderedset2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectionitem_in_ocl_expressions_collectionitem2245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionitem2280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectionrange_in_ocl_expressions_collectionrange2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionrange2365 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DDOT_in_ocl_ecore_collectionrange2372 = new BitSet(new long[]{0x006AA88000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionrange2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ocl_ecore_ifexp2426 = new BitSet(new long[]{0x006AAA8000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2433 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ocl_ecore_ifexp2441 = new BitSet(new long[]{0x006AB88000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2451 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ocl_ecore_ifexp2462 = new BitSet(new long[]{0x006AA98000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2472 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ocl_ecore_ifexp2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ocl_ecore_letexp2526 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_let_in_ocl_ecore_letexp2533 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ocl_ecore_letexp2539 = new BitSet(new long[]{0x006AA88000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_letexp2549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variable_let_in_ocl_expressions_variable_let2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variable_let2629 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_COLON_in_ocl_ecore_variable_let2654 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variable_let2662 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_EQUALS_in_ocl_ecore_variable_let2674 = new BitSet(new long[]{0x006AA88000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_variable_let2682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variable_in_ocl_expressions_variable2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variable2756 = new BitSet(new long[]{0x0000000000408002L});
    public static final BitSet FOLLOW_COLON_in_ocl_ecore_variable2781 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variable2789 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_EQUALS_in_ocl_ecore_variable2807 = new BitSet(new long[]{0x006AA88000010F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_variable2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_variable_self_in_ocl_ecore_variableexp2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variableexp2900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variable_self_in_ocl_expressions_variable_self2948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ocl_ecore_variable_self2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3027 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3031 = new BitSet(new long[]{0x006AA88000810750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3039 = new BitSet(new long[]{0x006AA88000810750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3047 = new BitSet(new long[]{0x006AA88000810750L});
    public static final BitSet FOLLOW_SEMI_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3064 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3072 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ocl_expressions_variable_implicitAccumulator_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3092 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_42_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3113 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3117 = new BitSet(new long[]{0x006AA88001010750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3125 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3134 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3142 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_46_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3163 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3167 = new BitSet(new long[]{0x006AA88001010750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3175 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3184 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3192 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_48_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3213 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3217 = new BitSet(new long[]{0x006AA88001010750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3225 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3234 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3242 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_BAR_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3259 = new BitSet(new long[]{0x006AA88000011F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3267 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variable_implicitAccumulator_in_ocl_expressions_variable_implicitAccumulator3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3424 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3433 = new BitSet(new long[]{0x006AA88000011F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3441 = new BitSet(new long[]{0x006AA88000011F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3449 = new BitSet(new long[]{0x006AA88000011F50L});
    public static final BitSet FOLLOW_RPAREN_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp3502 = new BitSet(new long[]{0x006AA88000010F52L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp3514 = new BitSet(new long[]{0x006AA88000010F52L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp3522 = new BitSet(new long[]{0x006AA88000010F52L});
    public static final BitSet FOLLOW_DOT_in_synpred22_Ocl770 = new BitSet(new long[]{0x006AA88000010750L});
    public static final BitSet FOLLOW_identifier_in_synpred22_Ocl773 = new BitSet(new long[]{0x007FFFFFFFFFF7F0L});
    public static final BitSet FOLLOW_set_in_synpred22_Ocl775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred22_Ocl780 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_synpred22_Ocl782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred23_Ocl796 = new BitSet(new long[]{0x007FFFFFFFFFF7F0L});
    public static final BitSet FOLLOW_set_in_synpred23_Ocl798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred24_Ocl812 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_synpred24_Ocl814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROW_in_synpred25_Ocl830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_synpred26_Ocl893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_synpred32_Ocl1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_synpred33_Ocl1370 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_COMMA_in_synpred33_Ocl1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_synpred65_Ocl3502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_synpred66_Ocl3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_synpred67_Ocl3514 = new BitSet(new long[]{0x006AA88000010F52L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_synpred67_Ocl3522 = new BitSet(new long[]{0x006AA88000010F52L});

}