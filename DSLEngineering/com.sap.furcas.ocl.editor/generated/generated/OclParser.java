// $ANTLR 3.1.1 C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g 2011-02-25 10:40:45

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "QNAME", "MULTI_LINE_COMMENT", "INT", "FLOAT", "BOOL", "LPAREN", "RPAREN", "DOT", "ARROW", "APOSTROPHE", "DCOLON", "LCURL", "COMMA", "RCURL", "DDOT", "COLON", "EQUALS", "SEMI", "BAR", "COMMENT", "LBRACKET", "RBRACKET", "STAR", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "RANGE_OR_INT", "'in'", "'Collection'", "'endif'", "'OrderedSet'", "'collect'", "'self'", "'Bag'", "'Set'", "'iterate'", "'if'", "'let'", "'then'", "'forAll'", "'Sequence'", "'else'"
    };
    public static final int STAR=28;
    public static final int FLOAT=9;
    public static final int EQUALS=22;
    public static final int EOF=-1;
    public static final int LPAREN=11;
    public static final int LBRACKET=26;
    public static final int RPAREN=12;
    public static final int NAME=4;
    public static final int DCOLON=16;
    public static final int COMMA=18;
    public static final int DIGIT=31;
    public static final int NL=29;
    public static final int APOSTROPHE=15;
    public static final int RANGE_OR_INT=34;
    public static final int RBRACKET=27;
    public static final int DOT=13;
    public static final int COMMENT=25;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=20;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=10;
    public static final int INT=8;
    public static final int SEMI=23;
    public static final int MULTI_LINE_COMMENT=7;
    public static final int ALPHA=32;
    public static final int COLON=21;
    public static final int LCURL=17;
    public static final int WS=30;
    public static final int QNAME=6;
    public static final int T__35=35;
    public static final int SNAME=33;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RCURL=19;
    public static final int ARROW=14;
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
    public String getGrammarFileName() { return "C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g"; }


       private static final String syntaxUUID = "_DmjicEDDEeCs-v9HhmjWVA";
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:95:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:96:3: ( (ast= NAME ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:97:3: (ast= NAME )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:97:3: (ast= NAME )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:97:4: ast= NAME
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:105:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'in' | 'Collection' | 'endif' | 'OrderedSet' | 'collect' | 'self' | 'Bag' | 'Set' | 'iterate' | 'if' | 'let' | 'then' | 'forAll' | 'Sequence' | 'else' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:106:3: ( (ast= NAME | 'in' | 'Collection' | 'endif' | 'OrderedSet' | 'collect' | 'self' | 'Bag' | 'Set' | 'iterate' | 'if' | 'let' | 'then' | 'forAll' | 'Sequence' | 'else' ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:107:3: (ast= NAME | 'in' | 'Collection' | 'endif' | 'OrderedSet' | 'collect' | 'self' | 'Bag' | 'Set' | 'iterate' | 'if' | 'let' | 'then' | 'forAll' | 'Sequence' | 'else' )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:107:3: (ast= NAME | 'in' | 'Collection' | 'endif' | 'OrderedSet' | 'collect' | 'self' | 'Bag' | 'Set' | 'iterate' | 'if' | 'let' | 'then' | 'forAll' | 'Sequence' | 'else' )
            int alt1=16;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 35:
                {
                alt1=2;
                }
                break;
            case 36:
                {
                alt1=3;
                }
                break;
            case 37:
                {
                alt1=4;
                }
                break;
            case 38:
                {
                alt1=5;
                }
                break;
            case 39:
                {
                alt1=6;
                }
                break;
            case 40:
                {
                alt1=7;
                }
                break;
            case 41:
                {
                alt1=8;
                }
                break;
            case 42:
                {
                alt1=9;
                }
                break;
            case 43:
                {
                alt1=10;
                }
                break;
            case 44:
                {
                alt1=11;
                }
                break;
            case 45:
                {
                alt1=12;
                }
                break;
            case 46:
                {
                alt1=13;
                }
                break;
            case 47:
                {
                alt1=14;
                }
                break;
            case 48:
                {
                alt1=15;
                }
                break;
            case 49:
                {
                alt1=16;
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:107:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:109:5: 'in'
                    {
                    match(input,35,FOLLOW_35_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 3 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:110:5: 'Collection'
                    {
                    match(input,36,FOLLOW_36_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Collection";
                    }

                    }
                    break;
                case 4 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:111:5: 'endif'
                    {
                    match(input,37,FOLLOW_37_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endif";
                    }

                    }
                    break;
                case 5 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:112:5: 'OrderedSet'
                    {
                    match(input,38,FOLLOW_38_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "OrderedSet";
                    }

                    }
                    break;
                case 6 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:113:5: 'collect'
                    {
                    match(input,39,FOLLOW_39_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "collect";
                    }

                    }
                    break;
                case 7 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:114:5: 'self'
                    {
                    match(input,40,FOLLOW_40_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "self";
                    }

                    }
                    break;
                case 8 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:115:5: 'Bag'
                    {
                    match(input,41,FOLLOW_41_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Bag";
                    }

                    }
                    break;
                case 9 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:116:5: 'Set'
                    {
                    match(input,42,FOLLOW_42_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Set";
                    }

                    }
                    break;
                case 10 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:117:5: 'iterate'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "iterate";
                    }

                    }
                    break;
                case 11 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:118:5: 'if'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "if";
                    }

                    }
                    break;
                case 12 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:119:5: 'let'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "let";
                    }

                    }
                    break;
                case 13 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:120:5: 'then'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "then";
                    }

                    }
                    break;
                case 14 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:121:5: 'forAll'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forAll";
                    }

                    }
                    break;
                case 15 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:122:5: 'Sequence'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Sequence";
                    }

                    }
                    break;
                case 16 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:123:5: 'else'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "else";
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:130:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:131:3: ( (ast= STRING ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:132:3: (ast= STRING )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:132:3: (ast= STRING )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:132:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol251); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:140:1: qualifiedNameSymbol returns [Object ret2] : (ast= QNAME ) ;
    public final Object qualifiedNameSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:141:3: ( (ast= QNAME ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:142:3: (ast= QNAME )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:142:3: (ast= QNAME )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:142:4: ast= QNAME
            {
            ast=(Token)match(input,QNAME,FOLLOW_QNAME_in_qualifiedNameSymbol282); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:150:1: annotationSymbol returns [Object ret2] : (ast= MULTI_LINE_COMMENT ) ;
    public final Object annotationSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:151:3: ( (ast= MULTI_LINE_COMMENT ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:152:3: (ast= MULTI_LINE_COMMENT )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:152:3: (ast= MULTI_LINE_COMMENT )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:152:4: ast= MULTI_LINE_COMMENT
            {
            ast=(Token)match(input,MULTI_LINE_COMMENT,FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol313); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:160:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:161:3: ( (ast= INT ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:162:3: (ast= INT )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:162:3: (ast= INT )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:162:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol344); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:170:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:171:3: ( (ast= INT ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:172:3: (ast= INT )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:172:3: (ast= INT )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:172:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol375); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:180:1: integerAsString returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsString() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:181:3: ( (ast= INT ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:182:3: (ast= INT )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:182:3: (ast= INT )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:182:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsString406); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:190:1: floatAsString returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsString() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:191:3: ( (ast= FLOAT ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:192:3: (ast= FLOAT )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:192:3: (ast= FLOAT )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:192:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsString437); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:200:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:201:3: ( (ast= BOOL ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:202:3: (ast= BOOL )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:202:3: (ast= BOOL )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:202:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol468); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:210:1: booleanValueSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanValueSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:211:3: ( (ast= BOOL ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:212:3: (ast= BOOL )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:212:3: (ast= BOOL )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:212:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanValueSymbol499); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:220:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:221:3: ( (ast= FLOAT ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:222:3: (ast= FLOAT )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:222:3: (ast= FLOAT )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:222:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol530); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:230:1: realSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object realSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:231:3: ( (ast= FLOAT ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:232:3: (ast= FLOAT )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:232:3: (ast= FLOAT )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:232:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_realSymbol561); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:240:1: doubleSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object doubleSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:241:3: ( (ast= FLOAT ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:242:3: (ast= FLOAT )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:242:3: (ast= FLOAT )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:242:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_doubleSymbol592); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:250:1: ocl_ecore_oclexpression returns [Object ret2] : (ret= ocl_ecore_literalexp | ret= ocl_ecore_ifexp | ret= ocl_ecore_letexp | ret= ocl_ecore_variableexp ) ;
    public final Object ocl_ecore_oclexpression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:251:3: ( (ret= ocl_ecore_literalexp | ret= ocl_ecore_ifexp | ret= ocl_ecore_letexp | ret= ocl_ecore_variableexp ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:252:3: (ret= ocl_ecore_literalexp | ret= ocl_ecore_ifexp | ret= ocl_ecore_letexp | ret= ocl_ecore_variableexp )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:252:3: (ret= ocl_ecore_literalexp | ret= ocl_ecore_ifexp | ret= ocl_ecore_letexp | ret= ocl_ecore_variableexp )
            int alt2=4;
            switch ( input.LA(1) ) {
            case QNAME:
            case INT:
            case FLOAT:
            case BOOL:
            case APOSTROPHE:
            case 36:
            case 38:
            case 41:
            case 42:
            case 48:
                {
                alt2=1;
                }
                break;
            case 44:
                {
                alt2=2;
                }
                break;
            case 45:
                {
                alt2=3;
                }
                break;
            case NAME:
            case 40:
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:252:4: ret= ocl_ecore_literalexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_literalexp_in_ocl_ecore_oclexpression619);
                    ret=ocl_ecore_literalexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:253:5: ret= ocl_ecore_ifexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_ifexp_in_ocl_ecore_oclexpression627);
                    ret=ocl_ecore_ifexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:254:5: ret= ocl_ecore_letexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_letexp_in_ocl_ecore_oclexpression635);
                    ret=ocl_ecore_letexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:255:5: ret= ocl_ecore_variableexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_variableexp_in_ocl_ecore_oclexpression643);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:262:1: main returns [Object ret2] : ( (ret= ocl_expressions_oclexpression ) EOF ) ;
    public final Object main() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:263:3: ( ( (ret= ocl_expressions_oclexpression ) EOF ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:264:3: ( (ret= ocl_expressions_oclexpression ) EOF )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:264:3: ( (ret= ocl_expressions_oclexpression ) EOF )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:264:4: (ret= ocl_expressions_oclexpression ) EOF
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:264:4: (ret= ocl_expressions_oclexpression )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:264:5: ret= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_main671);
            ret=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main674); if (state.failed) return ret2;

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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:271:1: primary_ocl_expressions_oclexpression returns [Object ret2] : (ret= ocl_ecore_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) ;
    public final Object primary_ocl_expressions_oclexpression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:272:3: ( (ret= ocl_ecore_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:273:3: (ret= ocl_ecore_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:273:3: (ret= ocl_ecore_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NAME||LA3_0==QNAME||(LA3_0>=INT && LA3_0<=BOOL)||LA3_0==APOSTROPHE||LA3_0==36||LA3_0==38||(LA3_0>=40 && LA3_0<=42)||(LA3_0>=44 && LA3_0<=45)||LA3_0==48) ) {
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:273:4: ret= ocl_ecore_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_ecore_oclexpression_in_primary_ocl_expressions_oclexpression702);
                    ret=ocl_ecore_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:274:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    {
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:274:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:274:6: LPAREN ret= ocl_expressions_oclexpression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression711); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression717);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression721); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:281:1: oclexpressions_priority_0 returns [Object ret2] : ( (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object oclexpressions_priority_0() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1); Object semRef=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:282:3: ( ( (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:4: ( (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:4: ( (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:6: (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:6: (ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:8: ret= primary_ocl_expressions_oclexpression ( ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_0759);
            ret=primary_ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:49: ( ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DOT) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred20_Ocl()) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==ARROW) ) {
                    int LA4_3 = input.LA(2);

                    if ( (synpred22_Ocl()) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:50: ( DOT ( ( identifier ~ LPAREN ) ) )=> ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:79: ( DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) )
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:80: DOT ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(".", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,DOT,FOLLOW_DOT_in_oclexpressions_priority_0776); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ".";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:161: ( ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] ) )
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:162: ( identifier ~ LPAREN )=> (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] )
            	    {
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:184: (ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken] )
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:185: ret= ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp_in_oclexpressions_priority_0791);
            	    ret=ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp(opName, ret, firstToken);

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
            	case 2 :
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:3: ( ARROW )=> ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:12: ( ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) ) )
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:13: ARROW ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("->", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,ARROW,FOLLOW_ARROW_in_oclexpressions_priority_0807); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "->";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:98: ( (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] ) )
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:99: (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] )
            	    {
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:99: (ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken] )
            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:100: ret= ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp_in_oclexpressions_priority_0815);
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
            	    break loop4;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:292:1: oclexpressions_priority_1 returns [Object ret2] : ( (ret= oclexpressions_priority_0 ) ) ;
    public final Object oclexpressions_priority_1() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1); Object semRef=null;
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:293:3: ( ( (ret= oclexpressions_priority_0 ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:294:4: ( (ret= oclexpressions_priority_0 ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:294:4: ( (ret= oclexpressions_priority_0 ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:294:6: (ret= oclexpressions_priority_0 )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:294:6: (ret= oclexpressions_priority_0 )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:294:8: ret= oclexpressions_priority_0
            {
            pushFollow(FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_1861);
            ret=oclexpressions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:302:1: ocl_expressions_oclexpression returns [Object ret2] : ret= oclexpressions_priority_1 ;
    public final Object ocl_expressions_oclexpression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:303:3: (ret= oclexpressions_priority_1 )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:304:3: ret= oclexpressions_priority_1
            {
            pushFollow(FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression891);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:311:1: ocl_ecore_literalexp returns [Object ret2] : (ret= ocl_ecore_primitiveliteralexp | ret= ocl_ecore_enumliteralexp | ret= ocl_ecore_collectionliteralexp ) ;
    public final Object ocl_ecore_literalexp() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:312:3: ( (ret= ocl_ecore_primitiveliteralexp | ret= ocl_ecore_enumliteralexp | ret= ocl_ecore_collectionliteralexp ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:313:3: (ret= ocl_ecore_primitiveliteralexp | ret= ocl_ecore_enumliteralexp | ret= ocl_ecore_collectionliteralexp )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:313:3: (ret= ocl_ecore_primitiveliteralexp | ret= ocl_ecore_enumliteralexp | ret= ocl_ecore_collectionliteralexp )
            int alt5=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
            case BOOL:
            case APOSTROPHE:
                {
                alt5=1;
                }
                break;
            case QNAME:
                {
                alt5=2;
                }
                break;
            case 36:
            case 38:
            case 41:
            case 42:
            case 48:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:313:4: ret= ocl_ecore_primitiveliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_primitiveliteralexp_in_ocl_ecore_literalexp917);
                    ret=ocl_ecore_primitiveliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:314:5: ret= ocl_ecore_enumliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_enumliteralexp_in_ocl_ecore_literalexp925);
                    ret=ocl_ecore_enumliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:315:5: ret= ocl_ecore_collectionliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_collectionliteralexp_in_ocl_ecore_literalexp933);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:322:1: ocl_ecore_primitiveliteralexp returns [Object ret2] : (ret= ocl_ecore_numericliteralexp | ret= ocl_ecore_stringliteralexp | ret= ocl_ecore_booleanliteralexp ) ;
    public final Object ocl_ecore_primitiveliteralexp() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:323:3: ( (ret= ocl_ecore_numericliteralexp | ret= ocl_ecore_stringliteralexp | ret= ocl_ecore_booleanliteralexp ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:324:3: (ret= ocl_ecore_numericliteralexp | ret= ocl_ecore_stringliteralexp | ret= ocl_ecore_booleanliteralexp )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:324:3: (ret= ocl_ecore_numericliteralexp | ret= ocl_ecore_stringliteralexp | ret= ocl_ecore_booleanliteralexp )
            int alt6=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt6=1;
                }
                break;
            case APOSTROPHE:
                {
                alt6=2;
                }
                break;
            case BOOL:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:324:4: ret= ocl_ecore_numericliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_numericliteralexp_in_ocl_ecore_primitiveliteralexp960);
                    ret=ocl_ecore_numericliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:325:5: ret= ocl_ecore_stringliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_stringliteralexp_in_ocl_ecore_primitiveliteralexp968);
                    ret=ocl_ecore_stringliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:326:5: ret= ocl_ecore_booleanliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_booleanliteralexp_in_ocl_ecore_primitiveliteralexp976);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:333:1: ocl_ecore_numericliteralexp returns [Object ret2] : (ret= ocl_ecore_integerliteralexp | ret= ocl_ecore_realliteralexp ) ;
    public final Object ocl_ecore_numericliteralexp() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:334:3: ( (ret= ocl_ecore_integerliteralexp | ret= ocl_ecore_realliteralexp ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:335:3: (ret= ocl_ecore_integerliteralexp | ret= ocl_ecore_realliteralexp )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:335:3: (ret= ocl_ecore_integerliteralexp | ret= ocl_ecore_realliteralexp )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==FLOAT) ) {
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:335:4: ret= ocl_ecore_integerliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_integerliteralexp_in_ocl_ecore_numericliteralexp1003);
                    ret=ocl_ecore_integerliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:336:5: ret= ocl_ecore_realliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore_realliteralexp_in_ocl_ecore_numericliteralexp1011);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:343:1: ocl_ecore_integerliteralexp returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object ocl_ecore_integerliteralexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","IntegerLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:349:3: ( ( (temp= integerSymbol ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:350:3: ( (temp= integerSymbol ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:350:3: ( (temp= integerSymbol ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:350:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.19/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:350:110: (temp= integerSymbol )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:350:112: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_ocl_ecore_integerliteralexp1045);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.19/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:359:1: ocl_ecore_stringliteralexp returns [Object ret2] : ( APOSTROPHE (temp= identifier ) APOSTROPHE ) ;
    public final Object ocl_ecore_stringliteralexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","StringLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:365:3: ( ( APOSTROPHE (temp= identifier ) APOSTROPHE ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:366:3: ( APOSTROPHE (temp= identifier ) APOSTROPHE )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:366:3: ( APOSTROPHE (temp= identifier ) APOSTROPHE )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:366:4: APOSTROPHE (temp= identifier ) APOSTROPHE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.0");
            }
            match(input,APOSTROPHE,FOLLOW_APOSTROPHE_in_ocl_ecore_stringliteralexp1092); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.1");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:366:244: (temp= identifier )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:366:246: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore_stringliteralexp1100);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.2");
            }
            match(input,APOSTROPHE,FOLLOW_APOSTROPHE_in_ocl_ecore_stringliteralexp1107); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.3");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:375:1: ocl_ecore_realliteralexp returns [Object ret2] : ( (temp= realSymbol ) ) ;
    public final Object ocl_ecore_realliteralexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","RealLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:381:3: ( ( (temp= realSymbol ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:382:3: ( (temp= realSymbol ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:382:3: ( (temp= realSymbol ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:382:4: (temp= realSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.21/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:382:110: (temp= realSymbol )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:382:112: temp= realSymbol
            {
            pushFollow(FOLLOW_realSymbol_in_ocl_ecore_realliteralexp1155);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.21/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:391:1: ocl_ecore_booleanliteralexp returns [Object ret2] : ( (temp= booleanValueSymbol ) ) ;
    public final Object ocl_ecore_booleanliteralexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","BooleanLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:397:3: ( ( (temp= booleanValueSymbol ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:398:3: ( (temp= booleanValueSymbol ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:398:3: ( (temp= booleanValueSymbol ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:398:4: (temp= booleanValueSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.22/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:398:110: (temp= booleanValueSymbol )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:398:112: temp= booleanValueSymbol
            {
            pushFollow(FOLLOW_booleanValueSymbol_in_ocl_ecore_booleanliteralexp1205);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.22/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:407:1: ocl_ecore_enumliteralexp returns [Object ret2] : ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) ;
    public final Object ocl_ecore_enumliteralexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","EnumLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:413:3: ( ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:414:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:414:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:414:4: (temp= qualifiedNameSymbol ) DCOLON (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:414:110: (temp= qualifiedNameSymbol )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:414:112: temp= qualifiedNameSymbol
            {
            pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_ecore_enumliteralexp1255);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.1");
            }
            match(input,DCOLON,FOLLOW_DCOLON_in_ocl_ecore_enumliteralexp1262); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.2");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:414:478: (temp= identifier )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:414:480: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore_enumliteralexp1270);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:422:1: ocl_expressions_collectionliteralpart returns [Object ret2] : (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) ) ;
    public final Object ocl_expressions_collectionliteralpart() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:423:3: ( (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:424:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:424:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:424:4: ret= ocl_expressions_collectionitem
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart1310);
                    ret=ocl_expressions_collectionitem();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:425:5: ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange )
                    {
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:425:44: (ret= ocl_expressions_collectionrange )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:425:45: ret= ocl_expressions_collectionrange
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart1325);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:432:1: ocl_ecore_collectionliteralexp returns [Object ret2] : ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) ;
    public final Object ocl_ecore_collectionliteralexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","CollectionLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"collectionliteral"}) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:438:3: ( ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:3: ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:3: ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:4: ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:110: ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt9=1;
                }
                break;
            case 42:
                {
                alt9=2;
                }
                break;
            case 36:
                {
                alt9=3;
                }
                break;
            case 41:
                {
                alt9=4;
                }
                break;
            case 38:
                {
                alt9=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:111: ( 'Sequence' (temp= ecore_eclassifier_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:127: ( 'Sequence' (temp= ecore_eclassifier_sequence ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:128: 'Sequence' (temp= ecore_eclassifier_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    match(input,48,FOLLOW_48_in_ocl_ecore_collectionliteralexp1361); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.1");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:416: (temp= ecore_eclassifier_sequence )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:439:418: temp= ecore_eclassifier_sequence
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_sequence_in_ocl_ecore_collectionliteralexp1368);
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
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.2");
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:441:4: ( 'Set' (temp= ecore_eclassifier_set ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:441:20: ( 'Set' (temp= ecore_eclassifier_set ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:441:21: 'Set' (temp= ecore_eclassifier_set )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    match(input,42,FOLLOW_42_in_ocl_ecore_collectionliteralexp1387); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.1");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:441:304: (temp= ecore_eclassifier_set )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:441:306: temp= ecore_eclassifier_set
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_set_in_ocl_ecore_collectionliteralexp1394);
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
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.2");
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:443:4: ( 'Collection' (temp= ecore_eclassifier_collection ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:443:20: ( 'Collection' (temp= ecore_eclassifier_collection ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:443:21: 'Collection' (temp= ecore_eclassifier_collection )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.0");
                    }
                    match(input,36,FOLLOW_36_in_ocl_ecore_collectionliteralexp1413); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.1");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:443:311: (temp= ecore_eclassifier_collection )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:443:313: temp= ecore_eclassifier_collection
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_collection_in_ocl_ecore_collectionliteralexp1420);
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
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.2");
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:445:4: ( 'Bag' (temp= ecore_eclassifier_bag ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:445:20: ( 'Bag' (temp= ecore_eclassifier_bag ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:445:21: 'Bag' (temp= ecore_eclassifier_bag )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.0");
                    }
                    match(input,41,FOLLOW_41_in_ocl_ecore_collectionliteralexp1439); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.1");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:445:304: (temp= ecore_eclassifier_bag )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:445:306: temp= ecore_eclassifier_bag
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_bag_in_ocl_ecore_collectionliteralexp1446);
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
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.2");
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:447:4: ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(4);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:447:20: ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:447:21: 'OrderedSet' (temp= ecore_eclassifier_orderedset )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.0");
                    }
                    match(input,38,FOLLOW_38_in_ocl_ecore_collectionliteralexp1465); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.1");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:447:311: (temp= ecore_eclassifier_orderedset )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:447:313: temp= ecore_eclassifier_orderedset
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_orderedset_in_ocl_ecore_collectionliteralexp1472);
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
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.2");
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.1");
            }
            match(input,LCURL,FOLLOW_LCURL_in_ocl_ecore_collectionliteralexp1487); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.2");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:448:589: (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME||LA11_0==QNAME||(LA11_0>=INT && LA11_0<=LPAREN)||LA11_0==APOSTROPHE||LA11_0==36||LA11_0==38||(LA11_0>=40 && LA11_0<=42)||(LA11_0>=44 && LA11_0<=45)||LA11_0==48) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:448:591: temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore_collectionliteralexp1495);
                    temp=ocl_expressions_collectionliteralpart();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "part", temp);
                      setParent(temp,ret,"part");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:449:30: ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:449:31: ( COMMA ) temp= ocl_expressions_collectionliteralpart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:449:48: ( COMMA )
                    	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:449:49: COMMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore_collectionliteralexp1504); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore_collectionliteralexp1512);
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
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.3");
            }
            match(input,RCURL,FOLLOW_RCURL_in_ocl_ecore_collectionliteralexp1524); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.4");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:458:1: ecore_eclassifier_sequence returns [Object ret2] : (ret= ecore_edatatype_sequence ) ;
    public final Object ecore_eclassifier_sequence() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:459:3: ( (ret= ecore_edatatype_sequence ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:460:3: (ret= ecore_edatatype_sequence )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:460:3: (ret= ecore_edatatype_sequence )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:460:4: ret= ecore_edatatype_sequence
            {
            pushFollow(FOLLOW_ecore_edatatype_sequence_in_ecore_eclassifier_sequence1565);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:467:1: ecore_edatatype_sequence returns [Object ret2] : (ret= ocl_ecore_collectiontype_sequence ) ;
    public final Object ecore_edatatype_sequence() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:468:3: ( (ret= ocl_ecore_collectiontype_sequence ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:469:3: (ret= ocl_ecore_collectiontype_sequence )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:469:3: (ret= ocl_ecore_collectiontype_sequence )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:469:4: ret= ocl_ecore_collectiontype_sequence
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_sequence_in_ecore_edatatype_sequence1592);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:476:1: ocl_ecore_collectiontype_sequence returns [Object ret2] : (ret= ocl_ecore_sequencetype_sequence ) ;
    public final Object ocl_ecore_collectiontype_sequence() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:477:3: ( (ret= ocl_ecore_sequencetype_sequence ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:478:3: (ret= ocl_ecore_sequencetype_sequence )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:478:3: (ret= ocl_ecore_sequencetype_sequence )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:478:4: ret= ocl_ecore_sequencetype_sequence
            {
            pushFollow(FOLLOW_ocl_ecore_sequencetype_sequence_in_ocl_ecore_collectiontype_sequence1619);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:485:1: ocl_ecore_sequencetype_sequence returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_sequencetype_sequence() throws RecognitionException {

        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","SequenceType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"sequence");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:491:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:492:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:492:3: ( collectiontypeelementtype[ret] )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:492:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.29/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_sequencetype_sequence1649);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.29/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:500:1: ecore_eclassifier_set returns [Object ret2] : (ret= ecore_edatatype_set ) ;
    public final Object ecore_eclassifier_set() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:501:3: ( (ret= ecore_edatatype_set ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:502:3: (ret= ecore_edatatype_set )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:502:3: (ret= ecore_edatatype_set )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:502:4: ret= ecore_edatatype_set
            {
            pushFollow(FOLLOW_ecore_edatatype_set_in_ecore_eclassifier_set1690);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:509:1: ecore_edatatype_set returns [Object ret2] : (ret= ocl_ecore_collectiontype_set ) ;
    public final Object ecore_edatatype_set() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:510:3: ( (ret= ocl_ecore_collectiontype_set ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:511:3: (ret= ocl_ecore_collectiontype_set )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:511:3: (ret= ocl_ecore_collectiontype_set )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:511:4: ret= ocl_ecore_collectiontype_set
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_set_in_ecore_edatatype_set1717);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:518:1: ocl_ecore_collectiontype_set returns [Object ret2] : (ret= ocl_ecore_settype_set ) ;
    public final Object ocl_ecore_collectiontype_set() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:519:3: ( (ret= ocl_ecore_settype_set ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:520:3: (ret= ocl_ecore_settype_set )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:520:3: (ret= ocl_ecore_settype_set )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:520:4: ret= ocl_ecore_settype_set
            {
            pushFollow(FOLLOW_ocl_ecore_settype_set_in_ocl_ecore_collectiontype_set1744);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:527:1: ocl_ecore_settype_set returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_settype_set() throws RecognitionException {

        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","SetType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"set");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:533:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:534:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:534:3: ( collectiontypeelementtype[ret] )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:534:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.33/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_settype_set1774);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.33/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:542:1: ecore_eclassifier_collection returns [Object ret2] : (ret= ecore_edatatype_collection ) ;
    public final Object ecore_eclassifier_collection() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:543:3: ( (ret= ecore_edatatype_collection ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:544:3: (ret= ecore_edatatype_collection )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:544:3: (ret= ecore_edatatype_collection )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:544:4: ret= ecore_edatatype_collection
            {
            pushFollow(FOLLOW_ecore_edatatype_collection_in_ecore_eclassifier_collection1815);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:551:1: ecore_edatatype_collection returns [Object ret2] : (ret= ocl_ecore_collectiontype_collection ) ;
    public final Object ecore_edatatype_collection() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:552:3: ( (ret= ocl_ecore_collectiontype_collection ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:553:3: (ret= ocl_ecore_collectiontype_collection )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:553:3: (ret= ocl_ecore_collectiontype_collection )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:553:4: ret= ocl_ecore_collectiontype_collection
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_collection_in_ecore_edatatype_collection1842);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:560:1: ocl_ecore_collectiontype_collection returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_collectiontype_collection() throws RecognitionException {

        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","CollectionType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"collection");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:566:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:567:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:567:3: ( collectiontypeelementtype[ret] )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:567:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.36/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_collectiontype_collection1872);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.36/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:575:1: ecore_eclassifier_bag returns [Object ret2] : (ret= ecore_edatatype_bag ) ;
    public final Object ecore_eclassifier_bag() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:576:3: ( (ret= ecore_edatatype_bag ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:577:3: (ret= ecore_edatatype_bag )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:577:3: (ret= ecore_edatatype_bag )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:577:4: ret= ecore_edatatype_bag
            {
            pushFollow(FOLLOW_ecore_edatatype_bag_in_ecore_eclassifier_bag1913);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:584:1: ecore_edatatype_bag returns [Object ret2] : (ret= ocl_ecore_collectiontype_bag ) ;
    public final Object ecore_edatatype_bag() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:585:3: ( (ret= ocl_ecore_collectiontype_bag ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:586:3: (ret= ocl_ecore_collectiontype_bag )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:586:3: (ret= ocl_ecore_collectiontype_bag )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:586:4: ret= ocl_ecore_collectiontype_bag
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_bag_in_ecore_edatatype_bag1940);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:593:1: ocl_ecore_collectiontype_bag returns [Object ret2] : (ret= ocl_ecore_bagtype_bag ) ;
    public final Object ocl_ecore_collectiontype_bag() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:594:3: ( (ret= ocl_ecore_bagtype_bag ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:595:3: (ret= ocl_ecore_bagtype_bag )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:595:3: (ret= ocl_ecore_bagtype_bag )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:595:4: ret= ocl_ecore_bagtype_bag
            {
            pushFollow(FOLLOW_ocl_ecore_bagtype_bag_in_ocl_ecore_collectiontype_bag1967);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:602:1: ocl_ecore_bagtype_bag returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_bagtype_bag() throws RecognitionException {

        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","BagType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"bag");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:608:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:609:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:609:3: ( collectiontypeelementtype[ret] )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:609:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.40/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_bagtype_bag1997);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.40/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:617:1: ecore_eclassifier_orderedset returns [Object ret2] : (ret= ecore_edatatype_orderedset ) ;
    public final Object ecore_eclassifier_orderedset() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:618:3: ( (ret= ecore_edatatype_orderedset ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:619:3: (ret= ecore_edatatype_orderedset )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:619:3: (ret= ecore_edatatype_orderedset )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:619:4: ret= ecore_edatatype_orderedset
            {
            pushFollow(FOLLOW_ecore_edatatype_orderedset_in_ecore_eclassifier_orderedset2038);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:626:1: ecore_edatatype_orderedset returns [Object ret2] : (ret= ocl_ecore_collectiontype_orderedset ) ;
    public final Object ecore_edatatype_orderedset() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:627:3: ( (ret= ocl_ecore_collectiontype_orderedset ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:628:3: (ret= ocl_ecore_collectiontype_orderedset )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:628:3: (ret= ocl_ecore_collectiontype_orderedset )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:628:4: ret= ocl_ecore_collectiontype_orderedset
            {
            pushFollow(FOLLOW_ocl_ecore_collectiontype_orderedset_in_ecore_edatatype_orderedset2065);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:635:1: ocl_ecore_collectiontype_orderedset returns [Object ret2] : (ret= ocl_ecore_orderedsettype_orderedset ) ;
    public final Object ocl_ecore_collectiontype_orderedset() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:636:3: ( (ret= ocl_ecore_orderedsettype_orderedset ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:637:3: (ret= ocl_ecore_orderedsettype_orderedset )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:637:3: (ret= ocl_ecore_orderedsettype_orderedset )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:637:4: ret= ocl_ecore_orderedsettype_orderedset
            {
            pushFollow(FOLLOW_ocl_ecore_orderedsettype_orderedset_in_ocl_ecore_collectiontype_orderedset2092);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:644:1: ocl_ecore_orderedsettype_orderedset returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_ecore_orderedsettype_orderedset() throws RecognitionException {

        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","OrderedSetType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"orderedset");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:650:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:651:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:651:3: ( collectiontypeelementtype[ret] )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:651:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.44/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore_orderedsettype_orderedset2122);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.44/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:659:1: collectiontypeelementtype[Object ret] : () ;
    public final void collectiontypeelementtype(Object ret) throws RecognitionException {
        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:660:3: ( () )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:661:3: ()
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:661:3: ()
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:661:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.45/@functionSequence/@elements.0");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:682:1: ocl_expressions_collectionitem returns [Object ret2] : ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem ) ) ;
    public final Object ocl_expressions_collectionitem() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:683:3: ( ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:684:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:684:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:684:4: ( ocl_expressions_collectionitem )=> (ret= ocl_ecore_collectionitem )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:684:38: (ret= ocl_ecore_collectionitem )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:684:39: ret= ocl_ecore_collectionitem
            {
            pushFollow(FOLLOW_ocl_ecore_collectionitem_in_ocl_expressions_collectionitem2192);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:691:1: ocl_ecore_collectionitem returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_ecore_collectionitem() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","CollectionItem");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:697:3: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:698:3: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:698:3: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:698:4: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.47/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:698:110: (temp= ocl_expressions_oclexpression )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:698:112: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionitem2227);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.47/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:707:1: ocl_expressions_collectionrange returns [Object ret2] : ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange ) ) ;
    public final Object ocl_expressions_collectionrange() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:708:3: ( ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:709:3: ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:709:3: ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:709:4: ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore_collectionrange )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:709:43: (ret= ocl_ecore_collectionrange )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:709:44: ret= ocl_ecore_collectionrange
            {
            pushFollow(FOLLOW_ocl_ecore_collectionrange_in_ocl_expressions_collectionrange2277);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:716:1: ocl_ecore_collectionrange returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_ecore_collectionrange() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","CollectionRange");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:722:3: ( ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:723:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:723:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:723:4: (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:723:110: (temp= ocl_expressions_oclexpression )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:723:112: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionrange2312);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.1");
            }
            match(input,DDOT,FOLLOW_DDOT_in_ocl_ecore_collectionrange2319); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.2");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:724:281: (temp= ocl_expressions_oclexpression )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:724:283: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionrange2327);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.3");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:748:1: ocl_ecore_ifexp returns [Object ret2] : ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' ) ;
    public final Object ocl_ecore_ifexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","IfExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:754:3: ( ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:755:3: ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:755:3: ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:755:4: 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.0");
            }
            match(input,44,FOLLOW_44_in_ocl_ecore_ifexp2373); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.1");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:755:236: (temp= ocl_expressions_oclexpression )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NAME||LA12_0==QNAME||(LA12_0>=INT && LA12_0<=LPAREN)||LA12_0==APOSTROPHE||LA12_0==36||LA12_0==38||(LA12_0>=40 && LA12_0<=42)||(LA12_0>=44 && LA12_0<=45)||LA12_0==48) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:755:238: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2380);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.2");
            }
            match(input,46,FOLLOW_46_in_ocl_ecore_ifexp2388); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.3");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:756:287: ( ( (temp= ocl_expressions_oclexpression )? ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:756:288: ( (temp= ocl_expressions_oclexpression )? )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:756:288: ( (temp= ocl_expressions_oclexpression )? )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:756:289: (temp= ocl_expressions_oclexpression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:756:422: (temp= ocl_expressions_oclexpression )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==NAME||LA13_0==QNAME||(LA13_0>=INT && LA13_0<=LPAREN)||LA13_0==APOSTROPHE||LA13_0==36||LA13_0==38||(LA13_0>=40 && LA13_0<=42)||(LA13_0>=44 && LA13_0<=45)||LA13_0==48) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:756:424: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2398);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.4");
            }
            match(input,49,FOLLOW_49_in_ocl_ecore_ifexp2409); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.5");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:757:310: ( ( (temp= ocl_expressions_oclexpression )? ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:757:311: ( (temp= ocl_expressions_oclexpression )? )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:757:311: ( (temp= ocl_expressions_oclexpression )? )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:757:312: (temp= ocl_expressions_oclexpression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.5/@blockSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:757:445: (temp= ocl_expressions_oclexpression )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==NAME||LA14_0==QNAME||(LA14_0>=INT && LA14_0<=LPAREN)||LA14_0==APOSTROPHE||LA14_0==36||LA14_0==38||(LA14_0>=40 && LA14_0<=42)||(LA14_0>=44 && LA14_0<=45)||LA14_0==48) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:757:447: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2419);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.6");
            }
            match(input,37,FOLLOW_37_in_ocl_ecore_ifexp2430); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.7");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:781:1: ocl_ecore_letexp returns [Object ret2] : ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) ;
    public final Object ocl_ecore_letexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","LetExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:787:3: ( ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:788:3: ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:788:3: ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:788:4: 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.0");
            }
            match(input,45,FOLLOW_45_in_ocl_ecore_letexp2473); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.1");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:788:237: (temp= ocl_expressions_variable_let )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:788:239: temp= ocl_expressions_variable_let
            {
            pushFollow(FOLLOW_ocl_expressions_variable_let_in_ocl_ecore_letexp2480);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.2");
            }
            match(input,35,FOLLOW_35_in_ocl_ecore_letexp2486); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.3");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:789:282: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:789:283: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:789:283: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:789:284: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:789:417: (temp= ocl_expressions_oclexpression )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:789:419: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_letexp2496);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.4");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:798:1: ocl_expressions_variable_let returns [Object ret2] : (ret= ocl_ecore_variable_let ) ;
    public final Object ocl_expressions_variable_let() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:799:3: ( (ret= ocl_ecore_variable_let ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:800:3: (ret= ocl_ecore_variable_let )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:800:3: (ret= ocl_ecore_variable_let )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:800:4: ret= ocl_ecore_variable_let
            {
            pushFollow(FOLLOW_ocl_ecore_variable_let_in_ocl_expressions_variable_let2542);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:807:1: ocl_ecore_variable_let returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_ecore_variable_let() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"let");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:813:3: ( ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:814:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:814:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:814:4: (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) EQUALS (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:814:110: (temp= identifier )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:814:112: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore_variable_let2576);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:815:152: ( () | ( COLON (temp= identifier ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==EQUALS) ) {
                alt15=1;
            }
            else if ( (LA15_0==COLON) ) {
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:815:153: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:815:169: ()
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:815:170: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.0/@elements.0");
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:816:4: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:816:20: ( COLON (temp= identifier ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:816:21: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.1/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_ecore_variable_let2601); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.1/@elements.1");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:816:306: (temp= identifier )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:816:308: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore_variable_let2609);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.2");
            }
            match(input,EQUALS,FOLLOW_EQUALS_in_ocl_ecore_variable_let2621); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.3");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:816:702: (temp= ocl_expressions_oclexpression )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:816:704: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_variable_let2629);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:825:1: ocl_expressions_variable returns [Object ret2] : (ret= ocl_ecore_variable ) ;
    public final Object ocl_expressions_variable() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:826:3: ( (ret= ocl_ecore_variable ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:827:3: (ret= ocl_ecore_variable )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:827:3: (ret= ocl_ecore_variable )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:827:4: ret= ocl_ecore_variable
            {
            pushFollow(FOLLOW_ocl_ecore_variable_in_ocl_expressions_variable2669);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:834:1: ocl_ecore_variable returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | ) ) ;
    public final Object ocl_ecore_variable() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:840:3: ( ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:841:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:841:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:841:4: (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:841:110: (temp= identifier )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:841:112: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore_variable2703);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:842:152: ( () | ( COLON (temp= identifier ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==EOF||LA16_0==NAME||LA16_0==COMMA||(LA16_0>=EQUALS && LA16_0<=BAR)) ) {
                alt16=1;
            }
            else if ( (LA16_0==COLON) ) {
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:842:153: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:842:169: ()
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:842:170: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.0/@elements.0");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:#context(propertyCallExp).oclAsType(ocl::ecore::PropertyCallExp).source.oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:4: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:20: ( COLON (temp= identifier ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:21: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.1/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_ecore_variable2728); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.1/@elements.1");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:306: (temp= identifier )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:308: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore_variable2736);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:573: ( ( EQUALS (temp= ocl_expressions_oclexpression ) ) | )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==EQUALS) ) {
                alt17=1;
            }
            else if ( (LA17_0==EOF||LA17_0==NAME||LA17_0==COMMA||(LA17_0>=SEMI && LA17_0<=BAR)) ) {
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:574: ( EQUALS (temp= ocl_expressions_oclexpression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:590: ( EQUALS (temp= ocl_expressions_oclexpression ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:591: EQUALS (temp= ocl_expressions_oclexpression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,EQUALS,FOLLOW_EQUALS_in_ocl_ecore_variable2754); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2/@thenSequence/@elements.1");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:879: (temp= ocl_expressions_oclexpression )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:843:881: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_variable2762);
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:844:74: 
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:853:1: ocl_ecore_variableexp returns [Object ret2] : ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) ) ;
    public final Object ocl_ecore_variableexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","VariableExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:859:3: ( ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:3: ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:3: ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:4: ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:110: ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==40) ) {
                alt18=1;
            }
            else if ( (LA18_0==NAME) ) {
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:111: ( (temp= ocl_expressions_variable_self ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:127: ( (temp= ocl_expressions_variable_self ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:128: (temp= ocl_expressions_variable_self )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:259: (temp= ocl_expressions_variable_self )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:860:261: temp= ocl_expressions_variable_self
                    {
                    pushFollow(FOLLOW_ocl_expressions_variable_self_in_ocl_ecore_variableexp2827);
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:862:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:862:20: ( (temp= identifier ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:862:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:862:152: (temp= identifier )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:862:154: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore_variableexp2847);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:870:1: ocl_expressions_variable_self returns [Object ret2] : (ret= ocl_ecore_variable_self ) ;
    public final Object ocl_expressions_variable_self() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:871:3: ( (ret= ocl_ecore_variable_self ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:872:3: (ret= ocl_ecore_variable_self )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:872:3: (ret= ocl_ecore_variable_self )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:872:4: ret= ocl_ecore_variable_self
            {
            pushFollow(FOLLOW_ocl_ecore_variable_self_in_ocl_expressions_variable_self2895);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:879:1: ocl_ecore_variable_self returns [Object ret2] : ( 'self' ) ;
    public final Object ocl_ecore_variable_self() throws RecognitionException {

        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"self");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:885:3: ( ( 'self' ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:886:3: ( 'self' )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:886:3: ( 'self' )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:886:4: 'self'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.58/@templateSequence/@elements.0");
            }
            match(input,40,FOLLOW_40_in_ocl_ecore_variable_self2925); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.58/@templateSequence/@elements.1");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:894:1: ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN ) ;
    public final Object ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("ocl","ecore","IterateExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:899:3: ( ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:3: ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:3: ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:4: ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) BAR (temp= ocl_expressions_oclexpression )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:110: ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt26=1;
                }
                break;
            case 47:
                {
                alt26=2;
                }
                break;
            case 39:
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:111: ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:127: ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:128: 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    match(input,43,FOLLOW_43_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp2974); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp2978); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.2");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:570: (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==NAME) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:900:572: temp= ocl_expressions_variable (temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp2986);
                            temp=ocl_expressions_variable();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:901:34: (temp= ocl_expressions_variable )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==NAME) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:901:36: temp= ocl_expressions_variable
                            	    {
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp2994);
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
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:902:186: ( ( SEMI (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==SEMI) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==EOF||LA21_0==BAR) ) {
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
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:902:187: ( SEMI (temp= ocl_expressions_variable ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:902:203: ( SEMI (temp= ocl_expressions_variable ) )
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:902:204: SEMI (temp= ocl_expressions_variable )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.0/@elements.0");
                            }
                            match(input,SEMI,FOLLOW_SEMI_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3011); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.0/@elements.1");
                            }
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:902:538: (temp= ocl_expressions_variable )
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:902:540: temp= ocl_expressions_variable
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3019);
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
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:904:4: ( (temp= ocl_expressions_variable_implicitAccumulator ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:904:20: ( (temp= ocl_expressions_variable_implicitAccumulator ) )
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:904:21: (temp= ocl_expressions_variable_implicitAccumulator )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.1/@elements.0");
                            }
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:904:177: (temp= ocl_expressions_variable_implicitAccumulator )
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:904:179: temp= ocl_expressions_variable_implicitAccumulator
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_implicitAccumulator_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3039);
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:906:4: ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:906:20: ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:906:21: 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    match(input,47,FOLLOW_47_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3060); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3064); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.2");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:906:462: (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==NAME) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:906:464: temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3072);
                            temp=ocl_expressions_variable();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:907:34: ( ( COMMA ) temp= ocl_expressions_variable )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==COMMA) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:907:35: ( COMMA ) temp= ocl_expressions_variable
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:907:52: ( COMMA )
                            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:907:53: COMMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3081); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3089);
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
                            	    break loop22;
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
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:909:4: ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:909:20: ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:909:21: 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.0");
                    }
                    match(input,39,FOLLOW_39_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3110); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3114); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.2");
                    }
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:909:463: (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==NAME) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:909:465: temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3122);
                            temp=ocl_expressions_variable();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:910:34: ( ( COMMA ) temp= ocl_expressions_variable )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==COMMA) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:910:35: ( COMMA ) temp= ocl_expressions_variable
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:910:52: ( COMMA )
                            	    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:910:53: COMMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3131); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3139);
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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.1");
            }
            match(input,BAR,FOLLOW_BAR_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3156); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.2");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:911:320: (temp= ocl_expressions_oclexpression )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==NAME||LA27_0==QNAME||(LA27_0>=INT && LA27_0<=LPAREN)||LA27_0==APOSTROPHE||LA27_0==36||LA27_0==38||(LA27_0>=40 && LA27_0<=42)||(LA27_0>=44 && LA27_0<=45)||LA27_0==48) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:911:322: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3164);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3173); if (state.failed) return ret2;
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:923:1: ocl_expressions_variable_implicitAccumulator returns [Object ret2] : (ret= ocl_ecore_variable_implicitAccumulator ) ;
    public final Object ocl_expressions_variable_implicitAccumulator() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:924:3: ( (ret= ocl_ecore_variable_implicitAccumulator ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:925:3: (ret= ocl_ecore_variable_implicitAccumulator )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:925:3: (ret= ocl_ecore_variable_implicitAccumulator )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:925:4: ret= ocl_ecore_variable_implicitAccumulator
            {
            pushFollow(FOLLOW_ocl_ecore_variable_implicitAccumulator_in_ocl_expressions_variable_implicitAccumulator3203);
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:932:1: ocl_ecore_variable_implicitAccumulator returns [Object ret2] : () ;
    public final Object ocl_ecore_variable_implicitAccumulator() throws RecognitionException {

        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"implicitAccumulator");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:938:3: ( () )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:939:3: ()
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:939:3: ()
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:939:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.61/@templateSequence/@elements.0");
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
    // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:947:1: ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifierOrKeyword ) ) ;
    public final Object ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("ocl","ecore","PropertyCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:952:3: ( ( (temp= identifierOrKeyword ) ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:953:3: ( (temp= identifierOrKeyword ) )
            {
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:953:3: ( (temp= identifierOrKeyword ) )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:953:4: (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.62/@templateSequence/@elements.0");
            }
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:953:110: (temp= identifierOrKeyword )
            // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:953:112: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp3278);
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
              _beforeSeqEl("platform:/plugin/OCL.dsl/mappings/Ocl.tcs#//@templates.62/@templateSequence/@elements.1");
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

    // $ANTLR start synpred20_Ocl
    public final void synpred20_Ocl_fragment() throws RecognitionException {   
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:50: ( DOT ( ( identifier ~ LPAREN ) ) )
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:51: DOT ( ( identifier ~ LPAREN ) )
        {
        match(input,DOT,FOLLOW_DOT_in_synpred20_Ocl762); if (state.failed) return ;
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:54: ( ( identifier ~ LPAREN ) )
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:55: ( identifier ~ LPAREN )
        {
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:55: ( identifier ~ LPAREN )
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:283:56: identifier ~ LPAREN
        {
        pushFollow(FOLLOW_identifier_in_synpred20_Ocl765);
        identifier();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        if ( (input.LA(1)>=NAME && input.LA(1)<=BOOL)||(input.LA(1)>=RPAREN && input.LA(1)<=49) ) {
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


        }
    }
    // $ANTLR end synpred20_Ocl

    // $ANTLR start synpred22_Ocl
    public final void synpred22_Ocl_fragment() throws RecognitionException {   
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:3: ( ARROW )
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:284:4: ARROW
        {
        match(input,ARROW,FOLLOW_ARROW_in_synpred22_Ocl801); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_Ocl

    // $ANTLR start synpred28_Ocl
    public final void synpred28_Ocl_fragment() throws RecognitionException {   
        Object ret = null;


        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:424:4: (ret= ocl_expressions_collectionitem )
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:424:4: ret= ocl_expressions_collectionitem
        {
        pushFollow(FOLLOW_ocl_expressions_collectionitem_in_synpred28_Ocl1310);
        ret=ocl_expressions_collectionitem();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_Ocl

    // $ANTLR start synpred29_Ocl
    public final void synpred29_Ocl_fragment() throws RecognitionException {   
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:425:5: ( ocl_expressions_oclexpression COMMA )
        // C:\\dev\\workspaces\\runtime-workspace\\OCL.dsl\\generated\\generated\\Ocl.g:425:6: ocl_expressions_oclexpression COMMA
        {
        pushFollow(FOLLOW_ocl_expressions_oclexpression_in_synpred29_Ocl1317);
        ocl_expressions_oclexpression();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred29_Ocl1319); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_Ocl

    // Delegated rules

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
    public final boolean synpred28_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_Ocl() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_Ocl_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\22\uffff";
    static final String DFA8_eofS =
        "\22\uffff";
    static final String DFA8_minS =
        "\1\4\17\0\2\uffff";
    static final String DFA8_maxS =
        "\1\60\17\0\2\uffff";
    static final String DFA8_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA8_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\2\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\16\1\uffff\1\5\1\uffff\1\1\1\2\1\4\1\17\3\uffff\1\3\24\uffff"+
            "\1\10\1\uffff\1\12\1\uffff\1\15\1\11\1\7\1\uffff\1\13\1\14\2"+
            "\uffff\1\6",
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

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "424:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA8_1 = input.LA(1);

                         
                        int index8_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_1);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA8_2 = input.LA(1);

                         
                        int index8_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_2);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA8_3 = input.LA(1);

                         
                        int index8_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_3);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA8_4 = input.LA(1);

                         
                        int index8_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_4);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA8_5 = input.LA(1);

                         
                        int index8_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_5);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_6);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA8_7 = input.LA(1);

                         
                        int index8_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_7);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA8_8 = input.LA(1);

                         
                        int index8_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_8);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA8_9 = input.LA(1);

                         
                        int index8_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_9);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA8_10 = input.LA(1);

                         
                        int index8_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_10);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA8_11 = input.LA(1);

                         
                        int index8_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_11);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA8_12 = input.LA(1);

                         
                        int index8_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_12);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA8_13 = input.LA(1);

                         
                        int index8_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_13);
                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA8_14 = input.LA(1);

                         
                        int index8_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_14);
                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA8_15 = input.LA(1);

                         
                        int index8_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred28_Ocl()) ) {s = 16;}

                        else if ( (synpred29_Ocl()) ) {s = 17;}

                         
                        input.seek(index8_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_identifierOrKeyword108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_identifierOrKeyword116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_identifierOrKeyword124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_identifierOrKeyword140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_identifierOrKeyword148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_identifierOrKeyword156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_identifierOrKeyword164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_identifierOrKeyword180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_identifierOrKeyword188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_identifierOrKeyword196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_identifierOrKeyword204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_identifierOrKeyword212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qualifiedNameSymbol282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsString406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsString437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanValueSymbol499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_realSymbol561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_doubleSymbol592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_literalexp_in_ocl_ecore_oclexpression619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_ifexp_in_ocl_ecore_oclexpression627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_letexp_in_ocl_ecore_oclexpression635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variableexp_in_ocl_ecore_oclexpression643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_main671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_oclexpression_in_primary_ocl_expressions_oclexpression702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression711 = new BitSet(new long[]{0x0001375000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression717 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_0759 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_DOT_in_oclexpressions_priority_0776 = new BitSet(new long[]{0x0003FFF800000010L});
    public static final BitSet FOLLOW_ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp_in_oclexpressions_priority_0791 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_ARROW_in_oclexpressions_priority_0807 = new BitSet(new long[]{0x0000888000000000L});
    public static final BitSet FOLLOW_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp_in_oclexpressions_priority_0815 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_primitiveliteralexp_in_ocl_ecore_literalexp917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_enumliteralexp_in_ocl_ecore_literalexp925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectionliteralexp_in_ocl_ecore_literalexp933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_numericliteralexp_in_ocl_ecore_primitiveliteralexp960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_stringliteralexp_in_ocl_ecore_primitiveliteralexp968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_booleanliteralexp_in_ocl_ecore_primitiveliteralexp976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_integerliteralexp_in_ocl_ecore_numericliteralexp1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_realliteralexp_in_ocl_ecore_numericliteralexp1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_ocl_ecore_integerliteralexp1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_APOSTROPHE_in_ocl_ecore_stringliteralexp1092 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_stringliteralexp1100 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_APOSTROPHE_in_ocl_ecore_stringliteralexp1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realSymbol_in_ocl_ecore_realliteralexp1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValueSymbol_in_ocl_ecore_booleanliteralexp1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_ecore_enumliteralexp1255 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DCOLON_in_ocl_ecore_enumliteralexp1262 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_enumliteralexp1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ocl_ecore_collectionliteralexp1361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_sequence_in_ocl_ecore_collectionliteralexp1368 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_42_in_ocl_ecore_collectionliteralexp1387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_set_in_ocl_ecore_collectionliteralexp1394 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_36_in_ocl_ecore_collectionliteralexp1413 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_collection_in_ocl_ecore_collectionliteralexp1420 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_41_in_ocl_ecore_collectionliteralexp1439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_bag_in_ocl_ecore_collectionliteralexp1446 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_38_in_ocl_ecore_collectionliteralexp1465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_orderedset_in_ocl_ecore_collectionliteralexp1472 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LCURL_in_ocl_ecore_collectionliteralexp1487 = new BitSet(new long[]{0x0001375000088F50L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore_collectionliteralexp1495 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore_collectionliteralexp1504 = new BitSet(new long[]{0x0001375000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore_collectionliteralexp1512 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_RCURL_in_ocl_ecore_collectionliteralexp1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_sequence_in_ecore_eclassifier_sequence1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_sequence_in_ecore_edatatype_sequence1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_sequencetype_sequence_in_ocl_ecore_collectiontype_sequence1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_sequencetype_sequence1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_set_in_ecore_eclassifier_set1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_set_in_ecore_edatatype_set1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_settype_set_in_ocl_ecore_collectiontype_set1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_settype_set1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_collection_in_ecore_eclassifier_collection1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_collection_in_ecore_edatatype_collection1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_collectiontype_collection1872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_bag_in_ecore_eclassifier_bag1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_bag_in_ecore_edatatype_bag1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_bagtype_bag_in_ocl_ecore_collectiontype_bag1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_bagtype_bag1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_orderedset_in_ecore_eclassifier_orderedset2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectiontype_orderedset_in_ecore_edatatype_orderedset2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_orderedsettype_orderedset_in_ocl_ecore_collectiontype_orderedset2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore_orderedsettype_orderedset2122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectionitem_in_ocl_expressions_collectionitem2192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionitem2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_collectionrange_in_ocl_expressions_collectionrange2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionrange2312 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_DDOT_in_ocl_ecore_collectionrange2319 = new BitSet(new long[]{0x0001375000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_collectionrange2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ocl_ecore_ifexp2373 = new BitSet(new long[]{0x0001775000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2380 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ocl_ecore_ifexp2388 = new BitSet(new long[]{0x0003375000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2398 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ocl_ecore_ifexp2409 = new BitSet(new long[]{0x0001377000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_ifexp2419 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ocl_ecore_ifexp2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ocl_ecore_letexp2473 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_let_in_ocl_ecore_letexp2480 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ocl_ecore_letexp2486 = new BitSet(new long[]{0x0001375000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_letexp2496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variable_let_in_ocl_expressions_variable_let2542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variable_let2576 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_COLON_in_ocl_ecore_variable_let2601 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variable_let2609 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUALS_in_ocl_ecore_variable_let2621 = new BitSet(new long[]{0x0001375000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_variable_let2629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variable_in_ocl_expressions_variable2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variable2703 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_COLON_in_ocl_ecore_variable2728 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variable2736 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_EQUALS_in_ocl_ecore_variable2754 = new BitSet(new long[]{0x0001375000008F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_variable2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_variable_self_in_ocl_ecore_variableexp2827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore_variableexp2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variable_self_in_ocl_expressions_variable_self2895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ocl_ecore_variable_self2925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp2974 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp2978 = new BitSet(new long[]{0x0001375000808750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp2986 = new BitSet(new long[]{0x0001375000808750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp2994 = new BitSet(new long[]{0x0001375000808750L});
    public static final BitSet FOLLOW_SEMI_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3011 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3019 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ocl_expressions_variable_implicitAccumulator_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3039 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_47_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3060 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3064 = new BitSet(new long[]{0x0001375001008750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3072 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3081 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3089 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_39_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3110 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3114 = new BitSet(new long[]{0x0001375001008750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3122 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3131 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3139 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_BAR_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3156 = new BitSet(new long[]{0x0001375000009F50L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3164 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp3173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore_variable_implicitAccumulator_in_ocl_expressions_variable_implicitAccumulator3203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred20_Ocl762 = new BitSet(new long[]{0x0001375000008750L});
    public static final BitSet FOLLOW_identifier_in_synpred20_Ocl765 = new BitSet(new long[]{0x0003FFFFFFFFF7F0L});
    public static final BitSet FOLLOW_set_in_synpred20_Ocl767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROW_in_synpred22_Ocl801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_synpred28_Ocl1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_synpred29_Ocl1317 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_synpred29_Ocl1319 = new BitSet(new long[]{0x0000000000000002L});

}