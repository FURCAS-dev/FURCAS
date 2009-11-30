// $ANTLR 3.1.1 C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g 2009-11-26 17:23:04

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
public class FinexClassParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FIRST_LOWERCASE_NAME", "FIRST_UPPERCASE_NAME", "STRING", "INT", "FLOAT", "BOOL", "BINARY", "DATE", "COLON", "SEMICOLON", "LBRACKET", "RBRACKET", "DOT", "DDOT", "ASSIGN", "LPAREN", "RPAREN", "LCURL", "RCURL", "PIPE", "EQUALS", "RANGLE", "LANGLE", "EQUALSEQUALS", "COMMENT", "MULTI_LINE_COMMENT", "NL", "WS", "DIGIT", "LOWERCASE_ALPHA", "UPPERCASE_ALPHA", "ALPHA", "FIRST_LOWERCASE_SNAME", "FIRST_UPPERCASE_SNAME", "OBJECT", "RANGE_OR_INT", "'value'", "'opposite'", "'DEFAULT'", "'AS'", "'KEY'", "'function'", "'manipulator'", "'IN'", "','", "'OUT'", "'-'", "'not'", "'*'", "'/'", "'AND'", "'OR'", "'+'", "'>='", "'<='", "'!='", "'and'", "'or'", "'xor'", "'count'", "'single'", "'sum'", "'avg'", "'min'", "'max'", "'create'", "'this'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LANGLE=26;
    public static final int EQUALS=24;
    public static final int FLOAT=8;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int LPAREN=19;
    public static final int LBRACKET=14;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RPAREN=20;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int OBJECT=38;
    public static final int T__59=59;
    public static final int PIPE=23;
    public static final int DIGIT=32;
    public static final int NL=30;
    public static final int RANGE_OR_INT=39;
    public static final int RANGLE=25;
    public static final int RBRACKET=15;
    public static final int COMMENT=28;
    public static final int DOT=16;
    public static final int T__50=50;
    public static final int FIRST_LOWERCASE_SNAME=36;
    public static final int T__42=42;
    public static final int LOWERCASE_ALPHA=33;
    public static final int EQUALSEQUALS=27;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int DDOT=17;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=9;
    public static final int SEMICOLON=13;
    public static final int INT=7;
    public static final int UPPERCASE_ALPHA=34;
    public static final int MULTI_LINE_COMMENT=29;
    public static final int ALPHA=35;
    public static final int COLON=12;
    public static final int LCURL=21;
    public static final int WS=31;
    public static final int T__70=70;
    public static final int FIRST_UPPERCASE_SNAME=37;
    public static final int RCURL=22;
    public static final int FIRST_LOWERCASE_NAME=4;
    public static final int ASSIGN=18;
    public static final int FIRST_UPPERCASE_NAME=5;
    public static final int BINARY=10;
    public static final int DATE=11;
    public static final int STRING=6;

    // delegates
    // delegators


        public FinexClassParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public FinexClassParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return FinexClassParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g"; }


       private static final String syntaxUUID = "E02C978BF432D823DAA711DEC74600155883529C";
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




    // $ANTLR start "firstLowercaseIdentifier"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:207:1: firstLowercaseIdentifier returns [Object ret2] : (ast= FIRST_LOWERCASE_NAME ) ;
    public final Object firstLowercaseIdentifier() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:208:3: ( (ast= FIRST_LOWERCASE_NAME ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:3: (ast= FIRST_LOWERCASE_NAME )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:3: (ast= FIRST_LOWERCASE_NAME )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:4: ast= FIRST_LOWERCASE_NAME
            {
            ast=(Token)match(input,FIRST_LOWERCASE_NAME,FOLLOW_FIRST_LOWERCASE_NAME_in_firstLowercaseIdentifier63); if (state.failed) return ret2;
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
    // $ANTLR end "firstLowercaseIdentifier"


    // $ANTLR start "firstUppercaseIdentifier"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:217:1: firstUppercaseIdentifier returns [Object ret2] : (ast= FIRST_UPPERCASE_NAME ) ;
    public final Object firstUppercaseIdentifier() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:218:3: ( (ast= FIRST_UPPERCASE_NAME ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:3: (ast= FIRST_UPPERCASE_NAME )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:3: (ast= FIRST_UPPERCASE_NAME )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:4: ast= FIRST_UPPERCASE_NAME
            {
            ast=(Token)match(input,FIRST_UPPERCASE_NAME,FOLLOW_FIRST_UPPERCASE_NAME_in_firstUppercaseIdentifier94); if (state.failed) return ret2;
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
    // $ANTLR end "firstUppercaseIdentifier"


    // $ANTLR start "stringSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:227:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:228:3: ( (ast= STRING ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:3: (ast= STRING )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:3: (ast= STRING )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol125); if (state.failed) return ret2;
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:237:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:238:3: ( (ast= INT ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:3: (ast= INT )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:3: (ast= INT )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol156); if (state.failed) return ret2;
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:247:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:248:3: ( (ast= INT ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:3: (ast= INT )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:3: (ast= INT )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol187); if (state.failed) return ret2;
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


    // $ANTLR start "integerAsStringSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:257:1: integerAsStringSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:258:3: ( (ast= INT ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:3: (ast= INT )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:3: (ast= INT )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsStringSymbol218); if (state.failed) return ret2;
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
    // $ANTLR end "integerAsStringSymbol"


    // $ANTLR start "floatAsStringSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:267:1: floatAsStringSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:268:3: ( (ast= FLOAT ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:3: (ast= FLOAT )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:3: (ast= FLOAT )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsStringSymbol249); if (state.failed) return ret2;
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
    // $ANTLR end "floatAsStringSymbol"


    // $ANTLR start "booleanSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:277:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:278:3: ( (ast= BOOL ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:3: (ast= BOOL )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:3: (ast= BOOL )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol280); if (state.failed) return ret2;
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


    // $ANTLR start "binarySymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:287:1: binarySymbol returns [Object ret2] : (ast= BINARY ) ;
    public final Object binarySymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:288:3: ( (ast= BINARY ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:3: (ast= BINARY )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:3: (ast= BINARY )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:4: ast= BINARY
            {
            ast=(Token)match(input,BINARY,FOLLOW_BINARY_in_binarySymbol311); if (state.failed) return ret2;
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
    // $ANTLR end "binarySymbol"


    // $ANTLR start "dateSymbol"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:297:1: dateSymbol returns [Object ret2] : (ast= DATE ) ;
    public final Object dateSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:298:3: ( (ast= DATE ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:3: (ast= DATE )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:3: (ast= DATE )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:4: ast= DATE
            {
            ast=(Token)match(input,DATE,FOLLOW_DATE_in_dateSymbol342); if (state.failed) return ret2;
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
    // $ANTLR end "dateSymbol"


    // $ANTLR start "main"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:307:1: main returns [Object ret2] : ( (ret= structure_finexclass ) EOF ) ;
    public final Object main() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:308:3: ( ( (ret= structure_finexclass ) EOF ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:3: ( (ret= structure_finexclass ) EOF )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:3: ( (ret= structure_finexclass ) EOF )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:4: (ret= structure_finexclass ) EOF
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:4: (ret= structure_finexclass )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:5: ret= structure_finexclass
            {
            pushFollow(FOLLOW_structure_finexclass_in_main370);
            ret=structure_finexclass();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main373); if (state.failed) return ret2;

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


    // $ANTLR start "structure_finexclass"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:316:1: structure_finexclass returns [Object ret2] : ( classdeclaration[ret] ) ;
    public final Object structure_finexclass() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"root"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:321:3: ( ( classdeclaration[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:3: ( classdeclaration[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:3: ( classdeclaration[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:4: classdeclaration[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2BED5C0DAA711DE960100155883529C");
            }
            pushFollow(FOLLOW_classdeclaration_in_structure_finexclass404);
            classdeclaration(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
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
    // $ANTLR end "structure_finexclass"


    // $ANTLR start "structure_type_field"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:330:1: structure_type_field returns [Object ret2] : (ret= structure_finexclass_field ) ;
    public final Object structure_type_field() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:331:3: ( (ret= structure_finexclass_field ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:3: (ret= structure_finexclass_field )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:3: (ret= structure_finexclass_field )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:4: ret= structure_finexclass_field
            {
            pushFollow(FOLLOW_structure_finexclass_field_in_structure_type_field442);
            ret=structure_finexclass_field();

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
    // $ANTLR end "structure_type_field"


    // $ANTLR start "structure_finexclass_field"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:339:1: structure_finexclass_field returns [Object ret2] : ( classdeclaration[ret] ) ;
    public final Object structure_finexclass_field() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"field");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:344:3: ( ( classdeclaration[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:3: ( classdeclaration[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:3: ( classdeclaration[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:4: classdeclaration[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2DB8582DAA711DECAB500155883529C");
            }
            pushFollow(FOLLOW_classdeclaration_in_structure_finexclass_field472);
            classdeclaration(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2E2B170DAA711DEC40900155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "owner", null, null, "OCL:#context(field).oclAsType(structure::Field).association.clazz", true);_exitInjectorAction();
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
    // $ANTLR end "structure_finexclass_field"


    // $ANTLR start "classdeclaration"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:353:1: classdeclaration[Object ret] : ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final void classdeclaration(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:354:3: ( ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:3: ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:3: ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:4: ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2E9DD60DAA711DEA8FC00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:64: ( ( 'value' ) | )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==40) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=FIRST_LOWERCASE_NAME && LA1_0<=FIRST_UPPERCASE_NAME)) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:65: ( 'value' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:81: ( 'value' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:82: 'value'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF2E76C60DAA711DEC67B00155883529C");
                    }
                    match(input,40,FOLLOW_40_in_classdeclaration516); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "valueType", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:238: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "valueType", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E02C978BF2F35344DAA711DEBA6900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:76: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==FIRST_LOWERCASE_NAME) ) {
                alt2=1;
            }
            else if ( (LA2_0==FIRST_UPPERCASE_NAME) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:77: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:93: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:94: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF2EC2751DAA711DE87FB00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:153: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:155: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_classdeclaration543);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF2F35342DAA711DEBE2100155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_classdeclaration563);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2F5C440DAA711DEC6E300155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration575); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2FA7F30DAA711DE809200155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:335: ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:337: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2F80E39DAA711DE800800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:396: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
            loop3:
            do {
                int alt3=4;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==DOT) && (synpred1_FinexClass())) {
                    alt3=1;
                }
                else if ( (LA3_0==DDOT) && (synpred1_FinexClass())) {
                    alt3=1;
                }
                else if ( (LA3_0==45) && (synpred2_FinexClass())) {
                    alt3=2;
                }
                else if ( (LA3_0==46) && (synpred2_FinexClass())) {
                    alt3=2;
                }
                else if ( (LA3_0==LBRACKET) ) {
                    alt3=3;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:397: ( structure_association )=> ( (temp= structure_association ) SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(0);
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:440: ( (temp= structure_association ) SEMICOLON )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:441: (temp= structure_association ) SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF2F5C443DAA711DECF0000155883529C");
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:500: (temp= structure_association )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:502: temp= structure_association
            	    {
            	    pushFollow(FOLLOW_structure_association_in_classdeclaration597);
            	    temp=structure_association();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "associations", temp);
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF2F5C444DAA711DEBF7D00155883529C");
            	    }
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_classdeclaration604); if (state.failed) return ;
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:4: ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(1);
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:53: ( (temp= behavior_functions_function ) SEMICOLON )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:54: (temp= behavior_functions_function ) SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF2F5C448DAA711DE80BE00155883529C");
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:113: (temp= behavior_functions_function )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:115: temp= behavior_functions_function
            	    {
            	    pushFollow(FOLLOW_behavior_functions_function_in_classdeclaration628);
            	    temp=behavior_functions_function();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "functions", temp);
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF2F80E30DAA711DE904300155883529C");
            	    }
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_classdeclaration635); if (state.failed) return ;
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:4: ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(2);
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:20: ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:21: LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF2F80E32DAA711DE92D600155883529C");
            	    }
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_classdeclaration650); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF2F80E35DAA711DE985D00155883529C");
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:165: (temp= behavior_expressions_expression )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:167: temp= behavior_expressions_expression
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_expression_in_classdeclaration658);
            	    temp=behavior_expressions_expression();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "invariants", temp);
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF2F80E36DAA711DE8E2D00155883529C");
            	    }
            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_classdeclaration665); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF2F80E37DAA711DEB2DE00155883529C");
            	    }
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_classdeclaration670); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitAlt();
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2FA7F31DAA711DEA1D400155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration684); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF2FA7F3ADAA711DECDEB00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:623: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==FIRST_LOWERCASE_NAME) ) {
                alt4=1;
            }
            else if ( (LA4_0==FIRST_UPPERCASE_NAME) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:624: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:640: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:641: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF2FA7F34DAA711DE8C1800155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:700: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:702: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_classdeclaration697);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF2FA7F38DAA711DE828800155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_classdeclaration717);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
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
    // $ANTLR end "classdeclaration"


    // $ANTLR start "structure_type"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:367:1: structure_type returns [Object ret2] : (ret= structure_finexclass ) ;
    public final Object structure_type() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:368:3: ( (ret= structure_finexclass ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:3: (ret= structure_finexclass )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:3: (ret= structure_finexclass )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:4: ret= structure_finexclass
            {
            pushFollow(FOLLOW_structure_finexclass_in_structure_type752);
            ret=structure_finexclass();

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
    // $ANTLR end "structure_type"


    // $ANTLR start "structure_association"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:376:1: structure_association returns [Object ret2] : ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) ) ;
    public final Object structure_association() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:3: ( ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:3: ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:3: ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:4: (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF301AB21DAA711DE8C1200155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:63: (temp= structure_field )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:65: temp= structure_field
            {
            pushFollow(FOLLOW_structure_field_in_structure_association786);
            temp=structure_field();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "ends", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF303F512DAA711DE8E1800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:195: ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==41) ) {
                alt5=1;
            }
            else if ( (LA5_0==EOF||LA5_0==SEMICOLON||LA5_0==RPAREN||LA5_0==48) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:196: ( 'opposite' (temp= structure_field_opposite ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:212: ( 'opposite' (temp= structure_field_opposite ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:213: 'opposite' (temp= structure_field_opposite )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF301AB22DAA711DECA1000155883529C");
                    }
                    match(input,41,FOLLOW_41_in_structure_association797); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF301AB27DAA711DEA1A500155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:357: (temp= structure_field_opposite )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:359: temp= structure_field_opposite
                    {
                    pushFollow(FOLLOW_structure_field_opposite_in_structure_association804);
                    temp=structure_field_opposite();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "ends", temp);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:4: ( (temp= structure_field_nondeclaredOpposite ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:20: ( (temp= structure_field_nondeclaredOpposite ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:21: (temp= structure_field_nondeclaredOpposite )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF303F510DAA711DEC9CC00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:80: (temp= structure_field_nondeclaredOpposite )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:82: temp= structure_field_nondeclaredOpposite
                    {
                    pushFollow(FOLLOW_structure_field_nondeclaredOpposite_in_structure_association824);
                    temp=structure_field_nondeclaredOpposite();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "ends", temp);
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
              _beforeSeqEl("E02C978BF303F515DAA711DEC45B00155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:if self.ends->last().name.size() > 0 then"+"		                        self.ends->first().name.concat(' opposite ').concat(self.ends->last().name)"+"		                      else"+"		                        self.ends->first().name"+"		                      endif", true);_exitInjectorAction();
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
    // $ANTLR end "structure_association"


    // $ANTLR start "structure_field"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:391:1: structure_field returns [Object ret2] : ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) ) ;
    public final Object structure_field() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"field"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:3: ( ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:3: ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:3: ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:4: ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF308D711DAA711DEABE900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:63: ( ( DOT ) | ( DDOT ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DOT) ) {
                alt6=1;
            }
            else if ( (LA6_0==DDOT) ) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:64: ( DOT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:80: ( DOT )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:81: DOT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3066611DAA711DE8E9E00155883529C");
                    }
                    match(input,DOT,FOLLOW_DOT_in_structure_field881); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3066614DAA711DE97F500155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:4: ( DDOT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:20: ( DDOT )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:21: DDOT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3066616DAA711DEA04B00155883529C");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_structure_field899); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3066619DAA711DECAFA00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "singleMultiplicity", false);_exitInjectorAction();
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
              _beforeSeqEl("E02C978BF310030EDAA711DE99A500155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:338: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==FIRST_LOWERCASE_NAME) ) {
                int LA13_1 = input.LA(2);

                if ( ((LA13_1>=FIRST_LOWERCASE_NAME && LA13_1<=FIRST_UPPERCASE_NAME)) ) {
                    alt13=1;
                }
                else if ( (LA13_1==COLON) && (synpred3_FinexClass())) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0==FIRST_UPPERCASE_NAME) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==COLON) && (synpred3_FinexClass())) {
                    alt13=2;
                }
                else if ( ((LA13_2>=FIRST_LOWERCASE_NAME && LA13_2<=FIRST_UPPERCASE_NAME)) ) {
                    alt13=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA13_0==40) && (synpred3_FinexClass())) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:339: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:355: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:356: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF308D720DAA711DEA60A00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:415: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==FIRST_LOWERCASE_NAME) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==FIRST_UPPERCASE_NAME) ) {
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:416: ( (temp= firstLowercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:432: ( (temp= firstLowercaseIdentifier ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:433: (temp= firstLowercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF308D714DAA711DEA2EA00155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:492: (temp= firstLowercaseIdentifier )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:494: temp= firstLowercaseIdentifier
                            {
                            pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field925);
                            temp=firstLowercaseIdentifier();

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
                              _beforeSeqEl("E02C978BF308D717DAA711DEA93300155883529C");
                            }
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mandatory", false);_exitInjectorAction();
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:4: ( (temp= firstUppercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:20: ( (temp= firstUppercaseIdentifier ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:21: (temp= firstUppercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF308D71BDAA711DEBA8800155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:80: (temp= firstUppercaseIdentifier )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:82: temp= firstUppercaseIdentifier
                            {
                            pushFollow(FOLLOW_firstUppercaseIdentifier_in_structure_field948);
                            temp=firstUppercaseIdentifier();

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
                              _beforeSeqEl("E02C978BF308D71EDAA711DEB9DF00155883529C");
                            }
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mandatory", true);_exitInjectorAction();
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
                      _beforeSeqEl("E02C978BF30D9202DAA711DE923600155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:388: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==FIRST_LOWERCASE_NAME) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==FIRST_UPPERCASE_NAME) ) {
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:389: ( (temp= firstLowercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:405: ( (temp= firstLowercaseIdentifier ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:406: (temp= firstLowercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF30B2102DAA711DEAE9500155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:465: (temp= firstLowercaseIdentifier )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:467: temp= firstLowercaseIdentifier
                            {
                            pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field971);
                            temp=firstLowercaseIdentifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setOclRef(ret, "type", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:4: ( (temp= firstUppercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:20: ( (temp= firstUppercaseIdentifier ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:21: (temp= firstUppercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF30D9200DAA711DEC34400155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:80: (temp= firstUppercaseIdentifier )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:82: temp= firstUppercaseIdentifier
                            {
                            pushFollow(FOLLOW_firstUppercaseIdentifier_in_structure_field991);
                            temp=firstUppercaseIdentifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setOclRef(ret, "type", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");
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
                      _beforeSeqEl("E02C978BF30D9203DAA711DEBC5D00155883529C");
                    }
                    pushFollow(FOLLOW_askey_in_structure_field1002);
                    askey(ret);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF30D920DDAA711DEB86900155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:410: ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () )
                    int alt11=3;
                    switch ( input.LA(1) ) {
                    case 42:
                        {
                        alt11=1;
                        }
                        break;
                    case ASSIGN:
                        {
                        alt11=2;
                        }
                        break;
                    case EOF:
                    case SEMICOLON:
                    case RPAREN:
                    case 41:
                    case 48:
                        {
                        alt11=3;
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:411: ( 'DEFAULT' (temp= behavior_expressions_expression )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:427: ( 'DEFAULT' (temp= behavior_expressions_expression )? )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:428: 'DEFAULT' (temp= behavior_expressions_expression )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF30D9204DAA711DEB1CE00155883529C");
                            }
                            match(input,42,FOLLOW_42_in_structure_field1011); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF30D9206DAA711DE800C00155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:571: (temp= behavior_expressions_expression )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>=FIRST_LOWERCASE_NAME && LA9_0<=DATE)||LA9_0==LBRACKET||LA9_0==DOT||LA9_0==LPAREN||(LA9_0>=50 && LA9_0<=51)||(LA9_0>=69 && LA9_0<=70)) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:573: temp= behavior_expressions_expression
                                    {
                                    pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field1018);
                                    temp=behavior_expressions_expression();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "defaultValue", temp);
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:4: ( ASSIGN (temp= behavior_expressions_expression )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:20: ( ASSIGN (temp= behavior_expressions_expression )? )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:21: ASSIGN (temp= behavior_expressions_expression )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF30D9208DAA711DEBFF400155883529C");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1037); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF30D920ADAA711DEAF6800155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:163: (temp= behavior_expressions_expression )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>=FIRST_LOWERCASE_NAME && LA10_0<=DATE)||LA10_0==LBRACKET||LA10_0==DOT||LA10_0==LPAREN||(LA10_0>=50 && LA10_0<=51)||(LA10_0>=69 && LA10_0<=70)) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:165: temp= behavior_expressions_expression
                                    {
                                    pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field1045);
                                    temp=behavior_expressions_expression();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "determination", temp);
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
                        case 3 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(2);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:20: ()
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:21: 
                            {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:4: ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:46: ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:47: (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF30D9211DAA711DEBF6600155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:106: (temp= structure_type_field )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:108: temp= structure_type_field
                    {
                    pushFollow(FOLLOW_structure_type_field_in_structure_field1088);
                    temp=structure_type_field();

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
                      _beforeSeqEl("E02C978BF30D9214DAA711DECB6800155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "name", null, null, "OCL:self.type.name", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3100300DAA711DE97B100155883529C");
                    }
                    pushFollow(FOLLOW_askey_in_structure_field1097);
                    askey(ret);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF310030CDAA711DEB4DD00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:490: ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () )
                    int alt12=3;
                    switch ( input.LA(1) ) {
                    case 42:
                        {
                        alt12=1;
                        }
                        break;
                    case ASSIGN:
                        {
                        alt12=2;
                        }
                        break;
                    case EOF:
                    case SEMICOLON:
                    case RPAREN:
                    case 41:
                    case 48:
                        {
                        alt12=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }

                    switch (alt12) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:491: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:507: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:508: 'DEFAULT' (temp= behavior_expressions_expression )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF3100301DAA711DEAED900155883529C");
                            }
                            match(input,42,FOLLOW_42_in_structure_field1106); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF3100304DAA711DEA04800155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:651: (temp= behavior_expressions_expression )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:653: temp= behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field1113);
                            temp=behavior_expressions_expression();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "defaultValue", temp);
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:4: ( ASSIGN (temp= behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:20: ( ASSIGN (temp= behavior_expressions_expression ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:21: ASSIGN (temp= behavior_expressions_expression )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF3100306DAA711DEAADE00155883529C");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1130); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF3100309DAA711DEBE7500155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:163: (temp= behavior_expressions_expression )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:165: temp= behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field1138);
                            temp=behavior_expressions_expression();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "determination", temp);
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
                        case 3 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(2);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:20: ()
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:21: 
                            {
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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3100311DAA711DE9D4400155883529C");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "navigable", true);_exitInjectorAction();
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
    // $ANTLR end "structure_field"


    // $ANTLR start "structure_field_opposite"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:413:1: structure_field_opposite returns [Object ret2] : ( (temp= firstLowercaseIdentifier ) ) ;
    public final Object structure_field_opposite() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"opposite");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:418:3: ( ( (temp= firstLowercaseIdentifier ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:3: ( (temp= firstLowercaseIdentifier ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:3: ( (temp= firstLowercaseIdentifier ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:4: (temp= firstLowercaseIdentifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3124CF2DAA711DEC45200155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:63: (temp= firstLowercaseIdentifier )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:65: temp= firstLowercaseIdentifier
            {
            pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field_opposite1208);
            temp=firstLowercaseIdentifier();

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
              _beforeSeqEl("E02C978BF3124CFBDAA711DE909900155883529C");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "navigable", true);_exitInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.association.clazz", true);_exitInjectorAction();
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
    // $ANTLR end "structure_field_opposite"


    // $ANTLR start "structure_field_nondeclaredOpposite"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:427:1: structure_field_nondeclaredOpposite returns [Object ret2] : () ;
    public final Object structure_field_nondeclaredOpposite() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"nondeclaredOpposite");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:432:3: ( () )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:3: ()
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:3: ()
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF31707E2DAA711DEBAF500155883529C");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "");_exitInjectorAction();setProperty(ret, "navigable", false);_exitInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.association.clazz", true);_exitInjectorAction();
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
    // $ANTLR end "structure_field_nondeclaredOpposite"


    // $ANTLR start "askey"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:441:1: askey[Object ret] : ( ( ( 'AS' 'KEY' ) | ) ) ;
    public final void askey(Object ret) throws RecognitionException {
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:3: ( ( ( ( 'AS' 'KEY' ) | ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:3: ( ( ( 'AS' 'KEY' ) | ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:3: ( ( ( 'AS' 'KEY' ) | ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:4: ( ( 'AS' 'KEY' ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF31978E6DAA711DEA34D00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:64: ( ( 'AS' 'KEY' ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==43) ) {
                alt14=1;
            }
            else if ( (LA14_0==EOF||LA14_0==SEMICOLON||LA14_0==ASSIGN||LA14_0==RPAREN||(LA14_0>=41 && LA14_0<=42)||LA14_0==48) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:65: ( 'AS' 'KEY' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:81: ( 'AS' 'KEY' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:82: 'AS' 'KEY'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF31978E3DAA711DEBD1F00155883529C");
                    }
                    match(input,43,FOLLOW_43_in_askey1294); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF31978E4DAA711DEC98500155883529C");
                    }
                    match(input,44,FOLLOW_44_in_askey1297); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "key", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:309: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "key", java.lang.Boolean.FALSE);
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
    // $ANTLR end "askey"


    // $ANTLR start "behavior_functions_function"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:451:1: behavior_functions_function returns [Object ret2] : ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) ) ;
    public final Object behavior_functions_function() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","functions","Function");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:3: ( ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:3: ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:3: ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:4: ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF320A4D6DAA711DEC68C00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:63: ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==45) ) {
                alt15=1;
            }
            else if ( (LA15_0==46) ) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:64: ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:80: ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:81: 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF31E33D0DAA711DE8AC400155883529C");
                    }
                    match(input,45,FOLLOW_45_in_behavior_functions_function1347); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF31E33D1DAA711DE9ACF00155883529C");
                    }
                    pushFollow(FOLLOW_functionheader_in_behavior_functions_function1350);
                    functionheader(ret);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF31E33D3DAA711DEC6E500155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:319: (temp= behavior_functions_signatureimplementation )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:321: temp= behavior_functions_signatureimplementation
                    {
                    pushFollow(FOLLOW_behavior_functions_signatureimplementation_in_behavior_functions_function1358);
                    temp=behavior_functions_signatureimplementation();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "implementation", temp);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:4: ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:20: ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:21: 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF320A4D0DAA711DEB0D700155883529C");
                    }
                    match(input,46,FOLLOW_46_in_behavior_functions_function1374); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF320A4D1DAA711DEB13300155883529C");
                    }
                    pushFollow(FOLLOW_functionheader_in_behavior_functions_function1377);
                    functionheader(ret);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF320A4D4DAA711DE8C7C00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:262: (temp= behavior_functions_signatureimplementation_manipulator )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:264: temp= behavior_functions_signatureimplementation_manipulator
                    {
                    pushFollow(FOLLOW_behavior_functions_signatureimplementation_manipulator_in_behavior_functions_function1385);
                    temp=behavior_functions_signatureimplementation_manipulator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "implementation", temp);
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
    // $ANTLR end "behavior_functions_function"


    // $ANTLR start "functionheader"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:466:1: functionheader[Object ret] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON ) ;
    public final void functionheader(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:467:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3255FCCDAA711DEB08100155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () )
            int alt16=3;
            switch ( input.LA(1) ) {
            case FIRST_LOWERCASE_NAME:
                {
                alt16=1;
                }
                break;
            case FIRST_UPPERCASE_NAME:
                {
                alt16=2;
                }
                break;
            case LPAREN:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3255FC2DAA711DE83E700155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:140: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_functionheader1436);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3255FC6DAA711DE80B300155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_functionheader1456);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
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
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:20: ()
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:21: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3255FCADAA711DEB63200155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", "");_exitInjectorAction();
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
              _beforeSeqEl("E02C978BF327D0C0DAA711DEB7FD00155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_functionheader1481); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF32A1AC6DAA711DE8D6F00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:323: ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==47) ) {
                alt21=1;
            }
            else if ( (LA21_0==49) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:324: ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:340: ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:341: 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF327D0C1DAA711DE93A300155883529C");
                    }
                    match(input,47,FOLLOW_47_in_functionheader1490); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF327D0C8DAA711DECE4B00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:479: (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:481: temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )*
                    {
                    pushFollow(FOLLOW_behavior_functions_parameter_IN_in_functionheader1497);
                    temp=behavior_functions_parameter_IN();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:558: ( ( ',' ) temp= behavior_functions_parameter_IN )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==48) ) {
                            int LA17_1 = input.LA(2);

                            if ( ((LA17_1>=FIRST_LOWERCASE_NAME && LA17_1<=FIRST_UPPERCASE_NAME)) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:559: ( ',' ) temp= behavior_functions_parameter_IN
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:576: ( ',' )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:577: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E02C978BF327D0C4DAA711DEB9A000155883529C");
                    	    }
                    	    match(input,48,FOLLOW_48_in_functionheader1505); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_behavior_functions_parameter_IN_in_functionheader1512);
                    	    temp=behavior_functions_parameter_IN();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "parameters", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF32A1ABBDAA711DEB2FA00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:828: ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==48) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==RPAREN) ) {
                        alt19=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:829: ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:845: ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:846: ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF32A1AB0DAA711DEBB0200155883529C");
                            }
                            match(input,48,FOLLOW_48_in_functionheader1526); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF32A1AB1DAA711DEC08A00155883529C");
                            }
                            match(input,49,FOLLOW_49_in_functionheader1529); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E02C978BF32A1AB8DAA711DE9B4300155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1063: (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1065: temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                            {
                            pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_functionheader1536);
                            temp=behavior_functions_parameter_OUT();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "parameters", temp);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1143: ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==48) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1144: ( ',' ) temp= behavior_functions_parameter_OUT
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1161: ( ',' )
                            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1162: ','
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E02C978BF32A1AB4DAA711DE84AC00155883529C");
                            	    }
                            	    match(input,48,FOLLOW_48_in_functionheader1544); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_functionheader1551);
                            	    temp=behavior_functions_parameter_OUT();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "parameters", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop18;
                                }
                            } while (true);


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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:20: ()
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:21: 
                            {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:4: ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:20: ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:21: 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF32A1ABDDAA711DE8ACB00155883529C");
                    }
                    match(input,49,FOLLOW_49_in_functionheader1585); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF32A1AC4DAA711DEB9A700155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:160: (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:162: temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                    {
                    pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_functionheader1592);
                    temp=behavior_functions_parameter_OUT();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:240: ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==48) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:241: ( ',' ) temp= behavior_functions_parameter_OUT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:258: ( ',' )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:259: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E02C978BF32A1AC0DAA711DE829100155883529C");
                    	    }
                    	    match(input,48,FOLLOW_48_in_functionheader1600); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_functionheader1607);
                    	    temp=behavior_functions_parameter_OUT();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "parameters", temp);
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
              _beforeSeqEl("E02C978BF32A1AC7DAA711DEC16400155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_functionheader1622); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF32A1AC8DAA711DEBD2300155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_functionheader1627); if (state.failed) return ;
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
    // $ANTLR end "functionheader"


    // $ANTLR start "parameter"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:479:1: parameter[Object ret] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) ) ;
    public final void parameter(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:480:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF32EFCB8DAA711DEBE9F00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FIRST_LOWERCASE_NAME) ) {
                alt22=1;
            }
            else if ( (LA22_0==FIRST_UPPERCASE_NAME) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF32EFCB2DAA711DEC32E00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:140: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_parameter1661);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF32EFCB6DAA711DE8A3F00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_parameter1681);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33146A7DAA711DE85E600155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:253: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==FIRST_LOWERCASE_NAME) ) {
                alt23=1;
            }
            else if ( (LA23_0==FIRST_UPPERCASE_NAME) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:254: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:270: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:271: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF32EFCBDDAA711DEB40B00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:330: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:332: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_parameter1701);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "type", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF33146A5DAA711DEB3C400155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_parameter1721);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "type", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");
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
              _beforeSeqEl("E02C978BF33146AFDAA711DEA95A00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:326: ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==42) ) {
                alt24=1;
            }
            else if ( (LA24_0==RPAREN||LA24_0==48) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:327: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:343: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:344: 'DEFAULT' (temp= behavior_expressions_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF33146ABDAA711DE8A1F00155883529C");
                    }
                    match(input,42,FOLLOW_42_in_parameter1738); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF33146ADDAA711DE880000155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:487: (temp= behavior_expressions_expression )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:489: temp= behavior_expressions_expression
                    {
                    pushFollow(FOLLOW_behavior_expressions_expression_in_parameter1745);
                    temp=behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "defaultValue", temp);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:602: 
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
    // $ANTLR end "parameter"


    // $ANTLR start "behavior_functions_parameter_IN"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:491:1: behavior_functions_parameter_IN returns [Object ret2] : ( parameter[ret] ) ;
    public final Object behavior_functions_parameter_IN() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","functions","Parameter");
        onEnterTemplateRule(metaType,"IN");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:496:3: ( ( parameter[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:3: ( parameter[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:3: ( parameter[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:4: parameter[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33628A0DAA711DE99B400155883529C");
            }
            pushFollow(FOLLOW_parameter_in_behavior_functions_parameter_IN1791);
            parameter(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33628A3DAA711DEB94B00155883529C");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "direction", behavior.functions.DirectionEnum.IN);_exitInjectorAction();
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
    // $ANTLR end "behavior_functions_parameter_IN"


    // $ANTLR start "behavior_functions_parameter_OUT"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:505:1: behavior_functions_parameter_OUT returns [Object ret2] : ( parameter[ret] ) ;
    public final Object behavior_functions_parameter_OUT() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","functions","Parameter");
        onEnterTemplateRule(metaType,"OUT");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:510:3: ( ( parameter[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:3: ( parameter[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:3: ( parameter[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:4: parameter[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3387290DAA711DEA16200155883529C");
            }
            pushFollow(FOLLOW_parameter_in_behavior_functions_parameter_OUT1835);
            parameter(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3387293DAA711DE949F00155883529C");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "direction", behavior.functions.DirectionEnum.OUT);_exitInjectorAction();
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
    // $ANTLR end "behavior_functions_parameter_OUT"


    // $ANTLR start "behavior_functions_signatureimplementation"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:519:1: behavior_functions_signatureimplementation returns [Object ret2] : (ret= behavior_actions_block ) ;
    public final Object behavior_functions_signatureimplementation() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:520:3: ( (ret= behavior_actions_block ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:3: (ret= behavior_actions_block )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:3: (ret= behavior_actions_block )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:4: ret= behavior_actions_block
            {
            pushFollow(FOLLOW_behavior_actions_block_in_behavior_functions_signatureimplementation1876);
            ret=behavior_actions_block();

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
    // $ANTLR end "behavior_functions_signatureimplementation"


    // $ANTLR start "behavior_actions_block"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:528:1: behavior_actions_block returns [Object ret2] : ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL ) ;
    public final Object behavior_actions_block() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:533:3: ( ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:3: ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:3: ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:4: LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33D2D80DAA711DEC7A100155883529C");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_block1907); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33D2D84DAA711DEBDE300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:145: ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:147: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33D2D82DAA711DE962E00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:206: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=FIRST_LOWERCASE_NAME && LA26_0<=DATE)||LA26_0==LBRACKET||LA26_0==DOT||LA26_0==LPAREN||(LA26_0>=50 && LA26_0<=51)||(LA26_0>=69 && LA26_0<=70)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:208: temp= behavior_actions_statement (temp= behavior_actions_statement )*
                    {
                    pushFollow(FOLLOW_behavior_actions_statement_in_behavior_actions_block1918);
                    temp=behavior_actions_statement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "statements", temp);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:280: (temp= behavior_actions_statement )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=FIRST_LOWERCASE_NAME && LA25_0<=DATE)||LA25_0==LBRACKET||LA25_0==DOT||LA25_0==LPAREN||(LA25_0>=50 && LA25_0<=51)||(LA25_0>=69 && LA25_0<=70)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:282: temp= behavior_actions_statement
                    	    {
                    	    pushFollow(FOLLOW_behavior_actions_statement_in_behavior_actions_block1926);
                    	    temp=behavior_actions_statement();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "statements", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
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
              _beforeSeqEl("E02C978BF33D2D85DAA711DEBE9C00155883529C");
            }
            match(input,RCURL,FOLLOW_RCURL_in_behavior_actions_block1941); if (state.failed) return ret2;
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
    // $ANTLR end "behavior_actions_block"


    // $ANTLR start "behavior_functions_signatureimplementation_manipulator"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:542:1: behavior_functions_signatureimplementation_manipulator returns [Object ret2] : (ret= behavior_actions_manipulator_manipulator ) ;
    public final Object behavior_functions_signatureimplementation_manipulator() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:543:3: ( (ret= behavior_actions_manipulator_manipulator ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:3: (ret= behavior_actions_manipulator_manipulator )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:3: (ret= behavior_actions_manipulator_manipulator )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:4: ret= behavior_actions_manipulator_manipulator
            {
            pushFollow(FOLLOW_behavior_actions_manipulator_manipulator_in_behavior_functions_signatureimplementation_manipulator1979);
            ret=behavior_actions_manipulator_manipulator();

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
    // $ANTLR end "behavior_functions_signatureimplementation_manipulator"


    // $ANTLR start "behavior_actions_manipulator_manipulator"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:551:1: behavior_actions_manipulator_manipulator returns [Object ret2] : ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL ) ;
    public final Object behavior_actions_manipulator_manipulator() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","Manipulator");
        onEnterTemplateRule(metaType,"manipulator");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:556:3: ( ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:3: ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:3: ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:4: LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33F9E80DAA711DEBBE000155883529C");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_manipulator_manipulator2010); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33F9E88DAA711DECDBE00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:145: ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:146: ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:146: ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:147: (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF33F9E86DAA711DEBA5E00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:206: (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:208: temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )*
            {
            pushFollow(FOLLOW_behavior_actions_assignment_manipulator_in_behavior_actions_manipulator_manipulator2021);
            temp=behavior_actions_assignment_manipulator();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "assignments", temp);
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:294: ( ( PIPE ) temp= behavior_actions_assignment_manipulator )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==PIPE) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:295: ( PIPE ) temp= behavior_actions_assignment_manipulator
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:312: ( PIPE )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:313: PIPE
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF33F9E83DAA711DEC50000155883529C");
            	    }
            	    match(input,PIPE,FOLLOW_PIPE_in_behavior_actions_manipulator_manipulator2030); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_behavior_actions_assignment_manipulator_in_behavior_actions_manipulator_manipulator2038);
            	    temp=behavior_actions_assignment_manipulator();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "assignments", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


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
              _beforeSeqEl("E02C978BF33F9E89DAA711DE8FD800155883529C");
            }
            match(input,RCURL,FOLLOW_RCURL_in_behavior_actions_manipulator_manipulator2051); if (state.failed) return ret2;
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
    // $ANTLR end "behavior_actions_manipulator_manipulator"


    // $ANTLR start "behavior_actions_statement"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:565:1: behavior_actions_statement returns [Object ret2] : (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement ) ;
    public final Object behavior_actions_statement() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:566:3: ( (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==DOT) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==FIRST_LOWERCASE_NAME) ) {
                    int LA28_3 = input.LA(3);

                    if ( (LA28_3==EQUALS) ) {
                        alt28=1;
                    }
                    else if ( ((LA28_3>=SEMICOLON && LA28_3<=LBRACKET)||LA28_3==DOT||(LA28_3>=RANGLE && LA28_3<=EQUALSEQUALS)||LA28_3==43||LA28_3==50||(LA28_3>=52 && LA28_3<=59)) ) {
                        alt28=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA28_1==FIRST_UPPERCASE_NAME) ) {
                    int LA28_4 = input.LA(3);

                    if ( ((LA28_4>=SEMICOLON && LA28_4<=LBRACKET)||LA28_4==DOT||(LA28_4>=RANGLE && LA28_4<=EQUALSEQUALS)||LA28_4==43||LA28_4==50||(LA28_4>=52 && LA28_4<=59)) ) {
                        alt28=2;
                    }
                    else if ( (LA28_4==EQUALS) ) {
                        alt28=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA28_0>=FIRST_LOWERCASE_NAME && LA28_0<=DATE)||LA28_0==LBRACKET||LA28_0==LPAREN||(LA28_0>=50 && LA28_0<=51)||(LA28_0>=69 && LA28_0<=70)) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:4: ret= behavior_actions_statementwithargument
                    {
                    pushFollow(FOLLOW_behavior_actions_statementwithargument_in_behavior_actions_statement2089);
                    ret=behavior_actions_statementwithargument();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:568:5: ret= behavior_actions_expressionstatement
                    {
                    pushFollow(FOLLOW_behavior_actions_expressionstatement_in_behavior_actions_statement2097);
                    ret=behavior_actions_expressionstatement();

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
    // $ANTLR end "behavior_actions_statement"


    // $ANTLR start "behavior_actions_statementwithargument"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:575:1: behavior_actions_statementwithargument returns [Object ret2] : ( ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment ) ) ;
    public final Object behavior_actions_statementwithargument() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:576:3: ( ( ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:3: ( ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:3: ( ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:4: ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:64: (ret= behavior_actions_assignment )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:65: ret= behavior_actions_assignment
            {
            pushFollow(FOLLOW_behavior_actions_assignment_in_behavior_actions_statementwithargument2139);
            ret=behavior_actions_assignment();

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
    // $ANTLR end "behavior_actions_statementwithargument"


    // $ANTLR start "behavior_actions_assignment"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:584:1: behavior_actions_assignment returns [Object ret2] : ( assignment[ret] SEMICOLON ) ;
    public final Object behavior_actions_assignment() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","actions","Assignment");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:3: ( ( assignment[ret] SEMICOLON ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:3: ( assignment[ret] SEMICOLON )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:3: ( assignment[ret] SEMICOLON )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:4: assignment[ret] SEMICOLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF346CA70DAA711DEBAEC00155883529C");
            }
            pushFollow(FOLLOW_assignment_in_behavior_actions_assignment2170);
            assignment(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF346CA71DAA711DE8B0900155883529C");
            }
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_actions_assignment2175); if (state.failed) return ret2;
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
    // $ANTLR end "behavior_actions_assignment"


    // $ANTLR start "behavior_actions_assignment_manipulator"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:598:1: behavior_actions_assignment_manipulator returns [Object ret2] : ( assignment[ret] ) ;
    public final Object behavior_actions_assignment_manipulator() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","actions","Assignment");
        onEnterTemplateRule(metaType,"manipulator");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:603:3: ( ( assignment[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:3: ( assignment[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:3: ( assignment[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:4: assignment[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3493B70DAA711DEC35C00155883529C");
            }
            pushFollow(FOLLOW_assignment_in_behavior_actions_assignment_manipulator2216);
            assignment(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
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
    // $ANTLR end "behavior_actions_assignment_manipulator"


    // $ANTLR start "assignment"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:612:1: assignment[Object ret] : ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? ) ;
    public final void assignment(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:613:3: ( ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:4: DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF34DF660DAA711DEBEE900155883529C");
            }
            match(input,DOT,FOLLOW_DOT_in_assignment2252); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3504059DAA711DEC38400155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:143: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FIRST_LOWERCASE_NAME) ) {
                alt29=1;
            }
            else if ( (LA29_0==FIRST_UPPERCASE_NAME) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:144: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:160: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:161: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3504051DAA711DEB16400155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:220: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:222: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_assignment2265);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "assignTo", null, temp, "OCL:self.getOwningClass().getNavigableFields()->select(f | f.name = ?)");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3504057DAA711DEBDCB00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_assignment2285);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "assignTo", null, temp, "OCL:self.getOwningClass().getNavigableFields()->select(f | f.name = ?)");
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
              _beforeSeqEl("E02C978BF350405ADAA711DE886400155883529C");
            }
            match(input,EQUALS,FOLLOW_EQUALS_in_assignment2297); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF350405CDAA711DEA46C00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:418: (temp= behavior_expressions_expression )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=FIRST_LOWERCASE_NAME && LA30_0<=DATE)||LA30_0==LBRACKET||LA30_0==DOT||LA30_0==LPAREN||(LA30_0>=50 && LA30_0<=51)||(LA30_0>=69 && LA30_0<=70)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:420: temp= behavior_expressions_expression
                    {
                    pushFollow(FOLLOW_behavior_expressions_expression_in_assignment2305);
                    temp=behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "argument", temp);
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
    // $ANTLR end "assignment"


    // $ANTLR start "behavior_actions_expressionstatement"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:1: behavior_actions_expressionstatement returns [Object ret2] : ( (temp= behavior_expressions_expression ) SEMICOLON ) ;
    public final Object behavior_actions_expressionstatement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","ExpressionStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:627:3: ( ( (temp= behavior_expressions_expression ) SEMICOLON ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:3: ( (temp= behavior_expressions_expression ) SEMICOLON )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:3: ( (temp= behavior_expressions_expression ) SEMICOLON )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:4: (temp= behavior_expressions_expression ) SEMICOLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF352B151DAA711DEC53600155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:63: (temp= behavior_expressions_expression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_actions_expressionstatement2344);
            temp=behavior_expressions_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "expression", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF352B152DAA711DE98CC00155883529C");
            }
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_actions_expressionstatement2351); if (state.failed) return ret2;
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
    // $ANTLR end "behavior_actions_expressionstatement"


    // $ANTLR start "primary_behavior_expressions_expression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:636:1: primary_behavior_expressions_expression returns [Object ret2] : (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ret= behavior_expressions_literals_multiobjectliteral | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) ;
    public final Object primary_behavior_expressions_expression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:637:3: ( (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ret= behavior_expressions_literals_multiobjectliteral | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:3: (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ret= behavior_expressions_literals_multiobjectliteral | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:3: (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ret= behavior_expressions_literals_multiobjectliteral | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            int alt31=7;
            switch ( input.LA(1) ) {
            case FIRST_LOWERCASE_NAME:
            case FIRST_UPPERCASE_NAME:
                {
                alt31=1;
                }
                break;
            case 69:
                {
                alt31=2;
                }
                break;
            case STRING:
            case INT:
            case FLOAT:
            case BOOL:
            case BINARY:
            case DATE:
                {
                alt31=3;
                }
                break;
            case DOT:
                {
                alt31=4;
                }
                break;
            case 70:
                {
                alt31=5;
                }
                break;
            case LBRACKET:
                {
                alt31=6;
                }
                break;
            case LPAREN:
                {
                alt31=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:4: ret= behavior_expressions_namedvalueexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_namedvalueexpression_in_primary_behavior_expressions_expression2389);
                    ret=behavior_expressions_namedvalueexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:639:5: ret= behavior_expressions_objectcreationexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_objectcreationexpression_in_primary_behavior_expressions_expression2397);
                    ret=behavior_expressions_objectcreationexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:5: ret= behavior_expressions_literals_literal
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2405);
                    ret=behavior_expressions_literals_literal();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:641:5: ret= behavior_expressions_firstpathexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2413);
                    ret=behavior_expressions_firstpathexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:642:5: ret= behavior_expressions_this
                    {
                    pushFollow(FOLLOW_behavior_expressions_this_in_primary_behavior_expressions_expression2421);
                    ret=behavior_expressions_this();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:5: ret= behavior_expressions_literals_multiobjectliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_multiobjectliteral_in_primary_behavior_expressions_expression2429);
                    ret=behavior_expressions_literals_multiobjectliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:644:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    {
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:644:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:644:6: LPAREN ret= behavior_expressions_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_behavior_expressions_expression2438); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2444);
                    ret=behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_behavior_expressions_expression2448); if (state.failed) return ret2;
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
    // $ANTLR end "primary_behavior_expressions_expression"


    // $ANTLR start "expressions_priority_0"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:1: expressions_priority_0 returns [Object ret2] : ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object expressions_priority_0() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:3: ( ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=50 && LA35_0<=51)) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=FIRST_LOWERCASE_NAME && LA35_0<=DATE)||LA35_0==LBRACKET||LA35_0==DOT||LA35_0==LPAREN||(LA35_0>=69 && LA35_0<=70)) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
                    {
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==50) && (synpred5_FinexClass())) {
                        alt32=1;
                    }
                    else if ( (LA32_0==51) && (synpred6_FinexClass())) {
                        alt32=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:6: ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:13: ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:14: '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("-", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,50,FOLLOW_50_in_expressions_priority_02489); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "-";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:94: ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:96: ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02496);
                            ret=behavior_expressions_unaryminus(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02500);
                            right=primary_behavior_expressions_expression();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "operand", right);
                              this.setLocationAndComment(ret, firstToken);

                            }

                            }


                            }

                            if ( state.backtracking==0 ) {
                              _exitOpSeq();
                            }

                            }


                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:3: ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:12: ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:13: 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("not", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,51,FOLLOW_51_in_expressions_priority_02517); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "not";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:99: ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:101: ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_not_in_expressions_priority_02524);
                            ret=behavior_expressions_not(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02528);
                            right=primary_behavior_expressions_expression();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "operand", right);
                              this.setLocationAndComment(ret, firstToken);

                            }

                            }


                            }

                            if ( state.backtracking==0 ) {
                              _exitOpSeq();
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    {
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:4: ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
                    {
                    pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02544);
                    ret=primary_behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:47: ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
                    loop34:
                    do {
                        int alt34=3;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==DOT) && (synpred7_FinexClass())) {
                            alt34=1;
                        }
                        else if ( (LA34_0==LBRACKET) && (synpred8_FinexClass())) {
                            alt34=2;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:48: ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:55: ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:56: DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq(".", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,DOT,FOLLOW_DOT_in_expressions_priority_02553); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = ".";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:137: ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
                    	    int alt33=6;
                    	    switch ( input.LA(1) ) {
                    	    case 60:
                    	    case 61:
                    	    case 62:
                    	        {
                    	        alt33=1;
                    	        }
                    	        break;
                    	    case 63:
                    	        {
                    	        alt33=2;
                    	        }
                    	        break;
                    	    case 64:
                    	        {
                    	        alt33=3;
                    	        }
                    	        break;
                    	    case LPAREN:
                    	        {
                    	        alt33=4;
                    	        }
                    	        break;
                    	    case 65:
                    	    case 66:
                    	    case 67:
                    	    case 68:
                    	        {
                    	        alt33=5;
                    	        }
                    	        break;
                    	    case FIRST_LOWERCASE_NAME:
                    	    case FIRST_UPPERCASE_NAME:
                    	        {
                    	        alt33=6;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return ret2;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 33, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt33) {
                    	        case 1 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:139: ret= behavior_expressions_booleanaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02561);
                    	            ret=behavior_expressions_booleanaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:4: ret= behavior_expressions_count[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_count_in_expressions_priority_02570);
                    	            ret=behavior_expressions_count(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:4: ret= behavior_expressions_single[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_single_in_expressions_priority_02579);
                    	            ret=behavior_expressions_single(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:3: (ret= behavior_expressions_tuple[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:3: (ret= behavior_expressions_tuple[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:4: ret= behavior_expressions_tuple[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_tuple_in_expressions_priority_02588);
                    	            ret=behavior_expressions_tuple(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:4: ret= behavior_expressions_numericaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02597);
                    	            ret=behavior_expressions_numericaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 6 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:4: ret= behavior_expressions_pathexpression[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02606);
                    	            ret=behavior_expressions_pathexpression(opName, ret, firstToken);

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
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:3: ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:15: ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:16: LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq("[", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_expressions_priority_02622); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = "[";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:102: ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    {
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:104: ret= behavior_expressions_filterexpression[opName, ret, firstToken]
                    	    {
                    	    pushFollow(FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02630);
                    	    ret=behavior_expressions_filterexpression(opName, ret, firstToken);

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
                    	    break loop34;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
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
    // $ANTLR end "expressions_priority_0"


    // $ANTLR start "expressions_priority_1"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:1: expressions_priority_1 returns [Object ret2] : ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) ;
    public final Object expressions_priority_1() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:3: ( ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:8: ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12671);
            ret=expressions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:34: ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            loop36:
            do {
                int alt36=4;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==52) && (synpred9_FinexClass())) {
                    alt36=1;
                }
                else if ( (LA36_0==53) && (synpred10_FinexClass())) {
                    alt36=2;
                }
                else if ( (LA36_0==54) && (synpred11_FinexClass())) {
                    alt36=3;
                }


                switch (alt36) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:35: ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:42: ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:43: '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("*", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,52,FOLLOW_52_in_expressions_priority_12680); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "*";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:123: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:125: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12687);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12691);
            	    right=expressions_priority_0();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:3: ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:10: ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:11: '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("/", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,53,FOLLOW_53_in_expressions_priority_12708); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "/";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12715);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12719);
            	    right=expressions_priority_0();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:3: ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:12: ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:13: 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("AND", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,54,FOLLOW_54_in_expressions_priority_12736); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "AND";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:99: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:101: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12743);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12747);
            	    right=expressions_priority_0();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "expressions_priority_1"


    // $ANTLR start "expressions_priority_2"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:1: expressions_priority_2 returns [Object ret2] : ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) ;
    public final Object expressions_priority_2() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:3: ( ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:8: ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22789);
            ret=expressions_priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:34: ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            loop37:
            do {
                int alt37=4;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==55) && (synpred12_FinexClass())) {
                    alt37=1;
                }
                else if ( (LA37_0==56) && (synpred13_FinexClass())) {
                    alt37=2;
                }
                else if ( (LA37_0==50) && (synpred14_FinexClass())) {
                    alt37=3;
                }


                switch (alt37) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:35: ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:43: ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:44: 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("OR", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,55,FOLLOW_55_in_expressions_priority_22798); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "OR";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:127: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:129: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22805);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22809);
            	    right=expressions_priority_1();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:3: ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:10: ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:11: '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,56,FOLLOW_56_in_expressions_priority_22826); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22833);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22837);
            	    right=expressions_priority_1();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:3: ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:10: ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:11: '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("-", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,50,FOLLOW_50_in_expressions_priority_22854); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "-";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22861);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22865);
            	    right=expressions_priority_1();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "expressions_priority_2"


    // $ANTLR start "expressions_priority_3"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:1: expressions_priority_3 returns [Object ret2] : ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) ;
    public final Object expressions_priority_3() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:3: ( ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:8: ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32907);
            ret=expressions_priority_2();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:34: ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
            loop38:
            do {
                int alt38=7;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RANGLE) && (synpred15_FinexClass())) {
                    alt38=1;
                }
                else if ( (LA38_0==LANGLE) && (synpred16_FinexClass())) {
                    alt38=2;
                }
                else if ( (LA38_0==57) && (synpred17_FinexClass())) {
                    alt38=3;
                }
                else if ( (LA38_0==58) && (synpred18_FinexClass())) {
                    alt38=4;
                }
                else if ( (LA38_0==EQUALSEQUALS) && (synpred19_FinexClass())) {
                    alt38=5;
                }
                else if ( (LA38_0==59) && (synpred20_FinexClass())) {
                    alt38=6;
                }


                switch (alt38) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:35: ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:45: ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:46: RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,RANGLE,FOLLOW_RANGLE_in_expressions_priority_32916); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:130: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:132: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32924);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32928);
            	    right=expressions_priority_2();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:3: ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:13: ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:14: LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LANGLE,FOLLOW_LANGLE_in_expressions_priority_32945); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:98: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:100: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32953);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32957);
            	    right=expressions_priority_2();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 3 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:3: ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:11: ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:12: '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,57,FOLLOW_57_in_expressions_priority_32974); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32981);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32985);
            	    right=expressions_priority_2();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 4 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:3: ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:11: ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:12: '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,58,FOLLOW_58_in_expressions_priority_33002); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33009);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33013);
            	    right=expressions_priority_2();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 5 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:3: ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:19: ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:20: EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("==", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQUALSEQUALS,FOLLOW_EQUALSEQUALS_in_expressions_priority_33030); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "==";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:112: ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:113: (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:113: (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:114: ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_equals_in_expressions_priority_33038);
            	    ret=behavior_expressions_equals(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33042);
            	    right=expressions_priority_2();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 6 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:3: ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:11: ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:12: '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("!=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,59,FOLLOW_59_in_expressions_priority_33059); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "!=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:95: ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:96: (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:96: (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:97: ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_unequals_in_expressions_priority_33066);
            	    ret=behavior_expressions_unequals(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33070);
            	    right=expressions_priority_2();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "expressions_priority_3"


    // $ANTLR start "behavior_expressions_expression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:737:1: behavior_expressions_expression returns [Object ret2] : ret= expressions_priority_3 ;
    public final Object behavior_expressions_expression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:738:3: (ret= expressions_priority_3 )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:739:3: ret= expressions_priority_3
            {
            pushFollow(FOLLOW_expressions_priority_3_in_behavior_expressions_expression3103);
            ret=expressions_priority_3();

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
    // $ANTLR end "behavior_expressions_expression"


    // $ANTLR start "alias"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:1: alias[Object ret] : ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) ) ;
    public final void alias(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:3: ( ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:3: ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:3: ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:4: ( ( 'AS' (temp= behavior_expressions_alias ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF359DD40DAA711DE92D300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:64: ( ( 'AS' (temp= behavior_expressions_alias ) ) | )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==43) ) {
                alt39=1;
            }
            else if ( (LA39_0==EOF||(LA39_0>=FIRST_LOWERCASE_NAME && LA39_0<=DATE)||(LA39_0>=SEMICOLON && LA39_0<=DOT)||(LA39_0>=LPAREN && LA39_0<=RPAREN)||(LA39_0>=RCURL && LA39_0<=PIPE)||(LA39_0>=RANGLE && LA39_0<=EQUALSEQUALS)||LA39_0==41||LA39_0==48||(LA39_0>=50 && LA39_0<=59)||(LA39_0>=69 && LA39_0<=70)) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:65: ( 'AS' (temp= behavior_expressions_alias ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:81: ( 'AS' (temp= behavior_expressions_alias ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:82: 'AS' (temp= behavior_expressions_alias )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3576C43DAA711DEB7FB00155883529C");
                    }
                    match(input,43,FOLLOW_43_in_alias3132); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3576C45DAA711DEA2B200155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:220: (temp= behavior_expressions_alias )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:222: temp= behavior_expressions_alias
                    {
                    pushFollow(FOLLOW_behavior_expressions_alias_in_alias3139);
                    temp=behavior_expressions_alias();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "alias", temp);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:323: 
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
    // $ANTLR end "alias"


    // $ANTLR start "behavior_expressions_alias"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:756:1: behavior_expressions_alias returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_alias() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Alias");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF359DD4BDAA711DEA64E00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==FIRST_UPPERCASE_NAME) ) {
                alt40=1;
            }
            else if ( (LA40_0==FIRST_LOWERCASE_NAME) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF359DD45DAA711DEC7D000155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:140: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias3194);
                    temp=firstUppercaseIdentifier();

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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:763:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:763:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:763:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF359DD49DAA711DE938200155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:763:80: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:763:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias3214);
                    temp=firstLowercaseIdentifier();

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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF359DD4EDAA711DECB8A00155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:aliasFor.type", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_alias"


    // $ANTLR start "behavior_expressions_binarybooleanoperator"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:771:1: behavior_expressions_binarybooleanoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_binarybooleanoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryBooleanOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:776:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:777:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:777:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:777:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF35C4E43DAA711DE85E400155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_binarybooleanoperator3266);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF35C4E46DAA711DE93B400155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              setProperty(ret,"operator" , opName);
              setProperty(ret,"left" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_binarybooleanoperator"


    // $ANTLR start "behavior_expressions_not"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:787:1: behavior_expressions_not[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_not(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Not");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:792:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:793:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:793:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:793:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3B20F61DAA711DE8D0A00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_not3303);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3B20F64DAA711DEAFEB00155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_not"


    // $ANTLR start "behavior_expressions_booleanaggregate"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:803:1: behavior_expressions_booleanaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_booleanaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BooleanAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:3: ( ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:4: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3B6CA57DAA711DEC05700155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:63: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt41=1;
                }
                break;
            case 61:
                {
                alt41=2;
                }
                break;
            case 62:
                {
                alt41=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:64: ( 'and' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:80: ( 'and' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:81: 'and'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3B48061DAA711DE9E6B00155883529C");
                    }
                    match(input,60,FOLLOW_60_in_behavior_expressions_booleanaggregate3345); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3B48064DAA711DE946A00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operator", "and");_exitInjectorAction();
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:810:4: ( 'or' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:810:20: ( 'or' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:810:21: 'or'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3B48066DAA711DE849E00155883529C");
                    }
                    match(input,61,FOLLOW_61_in_behavior_expressions_booleanaggregate3361); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3B6CA50DAA711DE84EE00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operator", "or");_exitInjectorAction();
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:811:4: ( 'xor' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:811:20: ( 'xor' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:811:21: 'xor'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3B6CA52DAA711DEBB5700155883529C");
                    }
                    match(input,62,FOLLOW_62_in_behavior_expressions_booleanaggregate3377); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3B6CA55DAA711DEB47F00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operator", "xor");_exitInjectorAction();
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
              _beforeSeqEl("E02C978BF3B6CA58DAA711DE835700155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate3389); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3B6CA59DAA711DEA2C900155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate3394); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3B6CA5ADAA711DEB56300155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_booleanaggregate3398);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3B6CA5DDAA711DE9F5400155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_booleanaggregate"


    // $ANTLR start "behavior_expressions_equals"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:821:1: behavior_expressions_equals[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_equals(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Equals");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:826:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:827:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:827:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:827:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3B93B52DAA711DEB9CC00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_equals3435);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3B93B55DAA711DECB6000155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"left" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_equals"


    // $ANTLR start "behavior_expressions_unequals"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:837:1: behavior_expressions_unequals[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_unequals(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Unequals");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:842:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:843:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:843:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:843:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3BBAC52DAA711DEA85900155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_unequals3472);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3BDF640DAA711DE859300155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"left" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_unequals"


    // $ANTLR start "behavior_expressions_binarynumericoperator"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:853:1: behavior_expressions_binarynumericoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_binarynumericoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryNumericOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:858:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:859:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:859:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:859:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C06743DAA711DEA5A600155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_binarynumericoperator3509);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C06746DAA711DEAE9600155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:if self.operator = '+' or"+"		                         self.operator = '-' or"+"		                         self.operator = '*' or"+"		                         self.operator = '/' then"+"		                            self.numericPostType(self.operator, self.left.type, self.right.type)"+"		                      else"+"		                        structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')->asSequence()->first()"+"		                      endif", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              setProperty(ret,"operator" , opName);
              setProperty(ret,"left" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_binarynumericoperator"


    // $ANTLR start "behavior_expressions_unaryminus"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:869:1: behavior_expressions_unaryminus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_unaryminus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","UnaryMinus");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:874:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:875:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:875:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:875:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C2B132DAA711DE93BC00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_unaryminus3546);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C2B135DAA711DE975000155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              setProperty(ret,"operator" , opName);
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_unaryminus"


    // $ANTLR start "behavior_expressions_count"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:885:1: behavior_expressions_count[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'count' LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_count(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Count");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:890:3: ( ( 'count' LPAREN RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:891:3: ( 'count' LPAREN RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:891:3: ( 'count' LPAREN RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:891:4: 'count' LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C52231DAA711DECB3C00155883529C");
            }
            match(input,63,FOLLOW_63_in_behavior_expressions_count3583); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C79330DAA711DEC5AE00155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C79331DAA711DECD1200155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_count3590); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C79332DAA711DEC1D300155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_count3595); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C79333DAA711DEC8C800155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_count3599);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_count"


    // $ANTLR start "behavior_expressions_single"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:901:1: behavior_expressions_single[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'single' LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_single(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Single");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:906:3: ( ( 'single' LPAREN RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:907:3: ( 'single' LPAREN RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:907:3: ( 'single' LPAREN RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:907:4: 'single' LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C9DD21DAA711DEA1AA00155883529C");
            }
            match(input,64,FOLLOW_64_in_behavior_expressions_single3633); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C9DD24DAA711DEC0E500155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C9DD25DAA711DEBB7E00155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_single3640); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C9DD26DAA711DE89F800155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_single3645); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3C9DD27DAA711DE92A300155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_single3649);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_single"


    // $ANTLR start "behavior_expressions_tuple"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:917:1: behavior_expressions_tuple[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] ) ;
    public final Object behavior_expressions_tuple(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Tuple");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:922:3: ( ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:923:3: ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:923:3: ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:923:4: LPAREN (temp= structure_type_tuple ) RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3CC4E21DAA711DE993A00155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_tuple3684); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3CC4E24DAA711DE87DD00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:923:146: (temp= structure_type_tuple )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:923:148: temp= structure_type_tuple
            {
            pushFollow(FOLLOW_structure_type_tuple_in_behavior_expressions_tuple3692);
            temp=structure_type_tuple();

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
              _beforeSeqEl("E02C978BF3CC4E25DAA711DE886F00155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_tuple3699); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3CC4E26DAA711DE8A9800155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_tuple3703);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_tuple"


    // $ANTLR start "structure_type_tuple"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:933:1: structure_type_tuple returns [Object ret2] : (ret= structure_finexclass_tuple ) ;
    public final Object structure_type_tuple() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:934:3: ( (ret= structure_finexclass_tuple ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:935:3: (ret= structure_finexclass_tuple )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:935:3: (ret= structure_finexclass_tuple )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:935:4: ret= structure_finexclass_tuple
            {
            pushFollow(FOLLOW_structure_finexclass_tuple_in_structure_type_tuple3733);
            ret=structure_finexclass_tuple();

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
    // $ANTLR end "structure_type_tuple"


    // $ANTLR start "structure_finexclass_tuple"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:942:1: structure_finexclass_tuple returns [Object ret2] : ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) ) ;
    public final Object structure_finexclass_tuple() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:3: ( ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:3: ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:3: ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:4: (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3CEBF26DAA711DEAF1E00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:63: (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:65: temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )*
            {
            pushFollow(FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3767);
            temp=structure_association_tuple();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "associations", temp);
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:140: ( ( ',' ) temp= structure_association_tuple )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==48) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:141: ( ',' ) temp= structure_association_tuple
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:158: ( ',' )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:159: ','
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF3CEBF22DAA711DE872500155883529C");
            	    }
            	    match(input,48,FOLLOW_48_in_structure_finexclass_tuple3775); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3782);
            	    temp=structure_association_tuple();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "associations", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3D37A14DAA711DEA5C200155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:self.typedElement.oclAsType(\"Tuple\").operand.getAllVisibleAliases()->iterate("+"			 			a; acc='TupleType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement->select(te | te.oclIsKindOf(Expression))."+"			                   oclAsType(Expression).getEnclosingType()", true);_exitInjectorAction();
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
    // $ANTLR end "structure_finexclass_tuple"


    // $ANTLR start "structure_association_tuple"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:956:1: structure_association_tuple returns [Object ret2] : ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) ) ;
    public final Object structure_association_tuple() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:961:3: ( ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:962:3: ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:962:3: ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:962:4: (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3D5C404DAA711DE833A00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:962:63: (temp= structure_field_tuple )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:962:65: temp= structure_field_tuple
            {
            pushFollow(FOLLOW_structure_field_tuple_in_structure_association_tuple3835);
            temp=structure_field_tuple();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "ends", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3D5C409DAA711DE805400155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:962:201: (temp= structure_field_nondeclaredOpposite )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:962:203: temp= structure_field_nondeclaredOpposite
            {
            pushFollow(FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_tuple3845);
            temp=structure_field_nondeclaredOpposite();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "ends", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3D5C40CDAA711DE84A600155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:'Tuple_to_'.concat(self.ends->first().name)", true);_exitInjectorAction();
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
    // $ANTLR end "structure_association_tuple"


    // $ANTLR start "structure_field_tuple"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:970:1: structure_field_tuple returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) ;
    public final Object structure_field_tuple() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3D8350EDAA711DEB69E00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==FIRST_UPPERCASE_NAME) ) {
                alt43=1;
            }
            else if ( (LA43_0==FIRST_LOWERCASE_NAME) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3D83502DAA711DE9EF100155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:140: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_structure_field_tuple3900);
                    temp=firstUppercaseIdentifier();

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
                      _beforeSeqEl("E02C978BF3D83505DAA711DEB04900155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "mandatory", true);_exitInjectorAction();
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3D83509DAA711DE80A900155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:80: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field_tuple3923);
                    temp=firstLowercaseIdentifier();

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
                      _beforeSeqEl("E02C978BF3D8350CDAA711DEBE9100155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "mandatory", false);_exitInjectorAction();
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
              _beforeSeqEl("E02C978BF3D8350FDAA711DEBCAA00155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_structure_field_tuple3938); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3D83512DAA711DEBDA900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:471: (temp= behavior_expressions_expression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:473: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field_tuple3946);
            temp=behavior_expressions_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "defaultValue", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3DAA604DAA711DE8E1100155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.defaultValue.type", true);_exitInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();
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
    // $ANTLR end "structure_field_tuple"


    // $ANTLR start "structure_field_tupleLocalEnd"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:985:1: structure_field_tupleLocalEnd returns [Object ret2] : () ;
    public final Object structure_field_tupleLocalEnd() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"tupleLocalEnd");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:990:3: ( () )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:991:3: ()
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:991:3: ()
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:991:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3DAA614DAA711DEA68000155883529C");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "tuple");_exitInjectorAction();setProperty(ret, "navigable", false);_exitInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();setProperty(ret, "key", false);_exitInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.association.clazz", true);_exitInjectorAction();
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
    // $ANTLR end "structure_field_tupleLocalEnd"


    // $ANTLR start "behavior_expressions_numericaggregate"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:999:1: behavior_expressions_numericaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_numericaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","NumericAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1004:3: ( ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:4: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3DF6100DAA711DE862000155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:63: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt44=1;
                }
                break;
            case 66:
                {
                alt44=2;
                }
                break;
            case 67:
                {
                alt44=3;
                }
                break;
            case 68:
                {
                alt44=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:64: ( 'sum' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:80: ( 'sum' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:81: 'sum'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3DCEFF1DAA711DEA81900155883529C");
                    }
                    match(input,65,FOLLOW_65_in_behavior_expressions_numericaggregate4038); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3DCEFF4DAA711DEBEDE00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operator", "sum");_exitInjectorAction();
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:4: ( 'avg' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:20: ( 'avg' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:21: 'avg'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3DF60F1DAA711DE801500155883529C");
                    }
                    match(input,66,FOLLOW_66_in_behavior_expressions_numericaggregate4054); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3DF60F4DAA711DECC7900155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operator", "avg");_exitInjectorAction();
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:4: ( 'min' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:20: ( 'min' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:21: 'min'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3DF60F6DAA711DEB65F00155883529C");
                    }
                    match(input,67,FOLLOW_67_in_behavior_expressions_numericaggregate4070); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3DF60F9DAA711DEA56200155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operator", "min");_exitInjectorAction();
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1008:4: ( 'max' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1008:20: ( 'max' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1008:21: 'max'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3DF60FBDAA711DEB85600155883529C");
                    }
                    match(input,68,FOLLOW_68_in_behavior_expressions_numericaggregate4086); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3DF60FEDAA711DE9D1F00155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operator", "max");_exitInjectorAction();
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
              _beforeSeqEl("E02C978BF3DF6101DAA711DEA7BE00155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_numericaggregate4098); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3DF6102DAA711DE9A2900155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_numericaggregate4103); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3DF6103DAA711DEB63300155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_numericaggregate4107);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3DF6106DAA711DEC58100155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_numericaggregate"


    // $ANTLR start "behavior_expressions_objectcreationexpression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1018:1: behavior_expressions_objectcreationexpression returns [Object ret2] : ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] ) ;
    public final Object behavior_expressions_objectcreationexpression() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","ObjectCreationExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:3: ( ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:3: ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:3: ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:4: 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E1D1F0DAA711DEC35A00155883529C");
            }
            match(input,69,FOLLOW_69_in_behavior_expressions_objectcreationexpression4143); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E1D1F5DAA711DEBF4700155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:146: (temp= firstUppercaseIdentifier )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:148: temp= firstUppercaseIdentifier
            {
            pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_objectcreationexpression4150);
            temp=firstUppercaseIdentifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "classToInstantiate", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E1D1F8DAA711DEA51500155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:classToInstantiate", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E1D1F9DAA711DEB96700155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_objectcreationexpression4160); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E41BE0DAA711DE900400155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:622: (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==DOT) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:624: temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )*
                    {
                    pushFollow(FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4168);
                    temp=behavior_expressions_fieldinitializer();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "fieldInitializers", temp);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:714: ( ( ',' ) temp= behavior_expressions_fieldinitializer )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==48) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:715: ( ',' ) temp= behavior_expressions_fieldinitializer
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:732: ( ',' )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1024:733: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E02C978BF3E1D1FBDAA711DEAD4900155883529C");
                    	    }
                    	    match(input,48,FOLLOW_48_in_behavior_expressions_objectcreationexpression4176); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4183);
                    	    temp=behavior_expressions_fieldinitializer();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "fieldInitializers", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E41BE1DAA711DE9B2A00155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_objectcreationexpression4195); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E41BE2DAA711DE8E7C00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_objectcreationexpression4199);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
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
    // $ANTLR end "behavior_expressions_objectcreationexpression"


    // $ANTLR start "behavior_expressions_fieldinitializer"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1032:1: behavior_expressions_fieldinitializer returns [Object ret2] : ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) ;
    public final Object behavior_expressions_fieldinitializer() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FieldInitializer");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:3: ( ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:4: DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E68CE0DAA711DECCB900155883529C");
            }
            match(input,DOT,FOLLOW_DOT_in_behavior_expressions_fieldinitializer4241); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E68CEDDAA711DEA5D700155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:143: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==FIRST_LOWERCASE_NAME) ) {
                alt47=1;
            }
            else if ( (LA47_0==FIRST_UPPERCASE_NAME) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:144: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:160: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:161: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3E68CE5DAA711DEA09E00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:220: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:222: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_fieldinitializer4254);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "fieldToInitialize", null, temp, "OCL:self.creationExpression.classToInstantiate.getNavigableFields()->select(f | f.name = ?)");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1039:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1039:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1039:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3E68CEBDAA711DE8E4200155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1039:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1039:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_fieldinitializer4274);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "fieldToInitialize", null, temp, "OCL:self.creationExpression.classToInstantiate.getNavigableFields()->select(f | f.name = ?)");
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
              _beforeSeqEl("E02C978BF3E68CEEDAA711DEC47600155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_behavior_expressions_fieldinitializer4286); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E68CF0DAA711DEC79000155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1039:447: (temp= behavior_expressions_expression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1039:449: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_fieldinitializer4294);
            temp=behavior_expressions_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "initExpression", temp);
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
    // $ANTLR end "behavior_expressions_fieldinitializer"


    // $ANTLR start "behavior_expressions_this"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1047:1: behavior_expressions_this returns [Object ret2] : ( 'this' alias[ret] ) ;
    public final Object behavior_expressions_this() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","This");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1052:3: ( ( 'this' alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1053:3: ( 'this' alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1053:3: ( 'this' alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1053:4: 'this' alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E8D6D0DAA711DEBA5700155883529C");
            }
            match(input,70,FOLLOW_70_in_behavior_expressions_this4337); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E8D6D1DAA711DEAF2800155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_this4340);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E8D6D4DAA711DEB4F400155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.getEnclosingType()", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_this"


    // $ANTLR start "behavior_expressions_namedvalueexpression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1061:1: behavior_expressions_namedvalueexpression returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_namedvalueexpression() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","NamedValueExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3E8D6E4DAA711DE9B6700155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==FIRST_LOWERCASE_NAME) ) {
                alt48=1;
            }
            else if ( (LA48_0==FIRST_UPPERCASE_NAME) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3E8D6DCDAA711DEB04D00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:140: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_namedvalueexpression4393);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "namedValue", null, temp, "OCL:self.getAllVisibleAliases()->select(a | a.name = ?)");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1068:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1068:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1068:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3E8D6E2DAA711DEBA9C00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1068:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1068:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_namedvalueexpression4413);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "namedValue", null, temp, "OCL:self.getAllVisibleAliases()->select(a | a.name = ?)");
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
              _beforeSeqEl("E02C978BF3E8D6E7DAA711DEBC9800155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:namedValue.type", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_namedvalueexpression"


    // $ANTLR start "behavior_expressions_expression_pathExpression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1076:1: behavior_expressions_expression_pathExpression returns [Object ret2] : (ret= behavior_expressions_implicitcontext_pathExpression ) ;
    public final Object behavior_expressions_expression_pathExpression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1077:3: ( (ret= behavior_expressions_implicitcontext_pathExpression ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1078:3: (ret= behavior_expressions_implicitcontext_pathExpression )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1078:3: (ret= behavior_expressions_implicitcontext_pathExpression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1078:4: ret= behavior_expressions_implicitcontext_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_implicitcontext_pathExpression_in_behavior_expressions_expression_pathExpression4461);
            ret=behavior_expressions_implicitcontext_pathExpression();

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
    // $ANTLR end "behavior_expressions_expression_pathExpression"


    // $ANTLR start "behavior_expressions_implicitcontext_pathExpression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1085:1: behavior_expressions_implicitcontext_pathExpression returns [Object ret2] : () ;
    public final Object behavior_expressions_implicitcontext_pathExpression() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","ImplicitContext");
        onEnterTemplateRule(metaType,"pathExpression");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:3: ( () )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1091:3: ()
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1091:3: ()
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1091:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3EDB8D2DAA711DEAE6300155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.getImplicitContextType()", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_implicitcontext_pathExpression"


    // $ANTLR start "behavior_expressions_firstpathexpression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1099:1: behavior_expressions_firstpathexpression returns [Object ret2] : ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) ;
    public final Object behavior_expressions_firstpathexpression() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FirstPathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:3: ( ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:4: DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3F002C0DAA711DEA63300155883529C");
            }
            match(input,DOT,FOLLOW_DOT_in_behavior_expressions_firstpathexpression4532); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3F002C3DAA711DE906300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:143: (temp= behavior_expressions_expression_pathExpression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:145: temp= behavior_expressions_expression_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression4540);
            temp=behavior_expressions_expression_pathExpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "operand", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3F002D0DAA711DE808300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:309: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==FIRST_LOWERCASE_NAME) ) {
                alt49=1;
            }
            else if ( (LA49_0==FIRST_UPPERCASE_NAME) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:310: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:326: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:327: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3F002C8DAA711DE8C9900155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:386: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:388: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression4555);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "field", null, temp, "OCL:self.operand.type.oclAsType(structure::FinexClass).getNavigableFields()->select(f|f.name=?)");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1106:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1106:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1106:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3F002CEDAA711DE94D000155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1106:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1106:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression4575);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "field", null, temp, "OCL:self.operand.type.oclAsType(structure::FinexClass).getNavigableFields()->select(f|f.name=?)");
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
              _beforeSeqEl("E02C978BF3F002D1DAA711DEA41D00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_firstpathexpression4586);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3F002D4DAA711DE993500155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.field.type", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_firstpathexpression"


    // $ANTLR start "behavior_expressions_pathexpression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1114:1: behavior_expressions_pathexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) ;
    public final Object behavior_expressions_pathexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","PathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3F99FBDDAA711DE9F1800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==FIRST_LOWERCASE_NAME) ) {
                alt50=1;
            }
            else if ( (LA50_0==FIRST_UPPERCASE_NAME) ) {
                alt50=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3F99FB5DAA711DECDBB00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:140: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression4640);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "field", null, temp, "OCL:self.operand.type.oclAsType(structure::FinexClass).getNavigableFields()->select(f|f.name=?)");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1121:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1121:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1121:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E02C978BF3F99FBBDAA711DE9E3E00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1121:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1121:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression4660);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "field", null, temp, "OCL:self.operand.type.oclAsType(structure::FinexClass).getNavigableFields()->select(f|f.name=?)");
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
              _beforeSeqEl("E02C978BF3F99FBEDAA711DE926400155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_pathexpression4671);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3F99FC1DAA711DEBCDD00155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.field.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_pathexpression"


    // $ANTLR start "behavior_expressions_filterexpression"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1131:1: behavior_expressions_filterexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] ) ;
    public final Object behavior_expressions_filterexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FilterExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:3: ( ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:3: ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:3: ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:4: (temp= behavior_expressions_expression ) RBRACKET alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3FBE9A2DAA711DE986C00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:63: (temp= behavior_expressions_expression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression4712);
            temp=behavior_expressions_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "condition", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3FBE9A3DAA711DEA2DE00155883529C");
            }
            match(input,RBRACKET,FOLLOW_RBRACKET_in_behavior_expressions_filterexpression4719); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3FBE9A4DAA711DE945700155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_filterexpression4723);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF3FBE9A7DAA711DECAB400155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"operand" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


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
    // $ANTLR end "behavior_expressions_filterexpression"


    // $ANTLR start "behavior_expressions_literals_literal"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1147:1: behavior_expressions_literals_literal returns [Object ret2] : (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) ;
    public final Object behavior_expressions_literals_literal() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:3: ( (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1149:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1149:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            int alt51=6;
            switch ( input.LA(1) ) {
            case BOOL:
                {
                alt51=1;
                }
                break;
            case STRING:
                {
                alt51=2;
                }
                break;
            case FLOAT:
                {
                alt51=3;
                }
                break;
            case INT:
                {
                alt51=4;
                }
                break;
            case DATE:
                {
                alt51=5;
                }
                break;
            case BINARY:
                {
                alt51=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1149:4: ret= behavior_expressions_literals_booleanliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal4756);
                    ret=behavior_expressions_literals_booleanliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1150:5: ret= behavior_expressions_literals_stringliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal4764);
                    ret=behavior_expressions_literals_stringliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1151:5: ret= behavior_expressions_literals_decimalliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal4772);
                    ret=behavior_expressions_literals_decimalliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1152:5: ret= behavior_expressions_literals_integerliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal4780);
                    ret=behavior_expressions_literals_integerliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1153:5: ret= behavior_expressions_literals_dateliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal4788);
                    ret=behavior_expressions_literals_dateliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1154:5: ret= behavior_expressions_literals_binaryliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal4796);
                    ret=behavior_expressions_literals_binaryliteral();

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
    // $ANTLR end "behavior_expressions_literals_literal"


    // $ANTLR start "behavior_expressions_literals_booleanliteral"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1161:1: behavior_expressions_literals_booleanliteral returns [Object ret2] : ( (temp= booleanSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_booleanliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BooleanLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1166:3: ( ( (temp= booleanSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:3: ( (temp= booleanSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:3: ( (temp= booleanSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:4: (temp= booleanSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF4031592DAA711DECDF000155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:63: (temp= booleanSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1167:65: temp= booleanSymbol
            {
            pushFollow(FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral4830);
            temp=booleanSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "literal", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF4031593DAA711DEBC8500155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_booleanliteral4836);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF4031596DAA711DE9F7A00155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_literals_booleanliteral"


    // $ANTLR start "behavior_expressions_literals_stringliteral"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1175:1: behavior_expressions_literals_stringliteral returns [Object ret2] : ( (temp= stringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_stringliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","StringLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:3: ( ( (temp= stringSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1181:3: ( (temp= stringSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1181:3: ( (temp= stringSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1181:4: (temp= stringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF407F792DAA711DE97D100155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1181:63: (temp= stringSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1181:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral4884);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "literal", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF407F793DAA711DEA64F00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_stringliteral4890);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF407F796DAA711DE82F300155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'String')", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_literals_stringliteral"


    // $ANTLR start "behavior_expressions_literals_decimalliteral"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:1: behavior_expressions_literals_decimalliteral returns [Object ret2] : ( (temp= floatAsStringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_decimalliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DecimalLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1194:3: ( ( (temp= floatAsStringSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1195:3: ( (temp= floatAsStringSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1195:3: ( (temp= floatAsStringSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1195:4: (temp= floatAsStringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF40CB282DAA711DEBD8300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1195:63: (temp= floatAsStringSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1195:65: temp= floatAsStringSymbol
            {
            pushFollow(FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral4938);
            temp=floatAsStringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "literal", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF40CB283DAA711DEAD8000155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_decimalliteral4944);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF40CB286DAA711DEC31700155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Decimal')", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_literals_decimalliteral"


    // $ANTLR start "behavior_expressions_literals_integerliteral"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1203:1: behavior_expressions_literals_integerliteral returns [Object ret2] : ( (temp= integerAsStringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_integerliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","IntegerLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1208:3: ( ( (temp= integerAsStringSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1209:3: ( (temp= integerAsStringSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1209:3: ( (temp= integerAsStringSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1209:4: (temp= integerAsStringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF40EFC72DAA711DE830200155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1209:63: (temp= integerAsStringSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1209:65: temp= integerAsStringSymbol
            {
            pushFollow(FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral4992);
            temp=integerAsStringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "literal", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF40EFC73DAA711DEC7B900155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_integerliteral4998);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF40EFC76DAA711DE93C900155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_literals_integerliteral"


    // $ANTLR start "behavior_expressions_literals_dateliteral"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1217:1: behavior_expressions_literals_dateliteral returns [Object ret2] : ( (temp= dateSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_dateliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DateLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:3: ( ( (temp= dateSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1223:3: ( (temp= dateSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1223:3: ( (temp= dateSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1223:4: (temp= dateSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF413DE72DAA711DE9C2B00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1223:63: (temp= dateSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1223:65: temp= dateSymbol
            {
            pushFollow(FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral5046);
            temp=dateSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "literal", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF413DE73DAA711DEA92400155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_dateliteral5052);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF413DE76DAA711DE8A8700155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Date')", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_literals_dateliteral"


    // $ANTLR start "behavior_expressions_literals_binaryliteral"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1231:1: behavior_expressions_literals_binaryliteral returns [Object ret2] : ( (temp= binarySymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_binaryliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BinaryLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1236:3: ( ( (temp= binarySymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1237:3: ( (temp= binarySymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1237:3: ( (temp= binarySymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1237:4: (temp= binarySymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF41D5452DAA711DE8E7500155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1237:63: (temp= binarySymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1237:65: temp= binarySymbol
            {
            pushFollow(FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral5100);
            temp=binarySymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "literal", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF41D5453DAA711DECF9600155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_binaryliteral5106);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF41D5456DAA711DEB95800155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Binary')", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_literals_binaryliteral"


    // $ANTLR start "behavior_expressions_literals_multiobjectliteral"
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1245:1: behavior_expressions_literals_multiobjectliteral returns [Object ret2] : ( LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret] ) ;
    public final Object behavior_expressions_literals_multiobjectliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","MultiObjectLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1250:3: ( ( LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:3: ( LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:3: ( LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:4: LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF41FC550DAA711DE956000155883529C");
            }
            match(input,LBRACKET,FOLLOW_LBRACKET_in_behavior_expressions_literals_multiobjectliteral5151); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF41FC555DAA711DEC7DD00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:148: (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:150: temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )*
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_literals_multiobjectliteral5159);
            temp=behavior_expressions_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "elements", temp);
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:225: ( ( ',' ) temp= behavior_expressions_expression )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==48) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:226: ( ',' ) temp= behavior_expressions_expression
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:243: ( ',' )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1251:244: ','
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E02C978BF41FC552DAA711DE960300155883529C");
            	    }
            	    match(input,48,FOLLOW_48_in_behavior_expressions_literals_multiobjectliteral5167); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_literals_multiobjectliteral5174);
            	    temp=behavior_expressions_expression();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "elements", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF41FC556DAA711DEA31D00155883529C");
            }
            match(input,RBRACKET,FOLLOW_RBRACKET_in_behavior_expressions_literals_multiobjectliteral5184); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF41FC557DAA711DEB14D00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_multiobjectliteral5188);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E02C978BF41FC55ADAA711DE971D00155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.elements->asSequence()->first().type", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_literals_multiobjectliteral"

    // $ANTLR start synpred1_FinexClass
    public final void synpred1_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:397: ( structure_association )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:398: structure_association
        {
        pushFollow(FOLLOW_structure_association_in_synpred1_FinexClass584);
        structure_association();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_FinexClass

    // $ANTLR start synpred2_FinexClass
    public final void synpred2_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:4: ( behavior_functions_function )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:5: behavior_functions_function
        {
        pushFollow(FOLLOW_behavior_functions_function_in_synpred2_FinexClass615);
        behavior_functions_function();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_FinexClass

    // $ANTLR start synpred3_FinexClass
    public final void synpred3_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:4: ( structure_type_field )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:5: structure_type_field
        {
        pushFollow(FOLLOW_structure_type_field_in_synpred3_FinexClass1075);
        structure_type_field();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_FinexClass

    // $ANTLR start synpred5_FinexClass
    public final void synpred5_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:6: ( '-' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:7: '-'
        {
        match(input,50,FOLLOW_50_in_synpred5_FinexClass2483); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_FinexClass

    // $ANTLR start synpred6_FinexClass
    public final void synpred6_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:3: ( 'not' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:656:4: 'not'
        {
        match(input,51,FOLLOW_51_in_synpred6_FinexClass2511); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_FinexClass

    // $ANTLR start synpred7_FinexClass
    public final void synpred7_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:48: ( DOT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:49: DOT
        {
        match(input,DOT,FOLLOW_DOT_in_synpred7_FinexClass2547); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_FinexClass

    // $ANTLR start synpred8_FinexClass
    public final void synpred8_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:3: ( LBRACKET )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:4: LBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred8_FinexClass2616); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_FinexClass

    // $ANTLR start synpred9_FinexClass
    public final void synpred9_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:35: ( '*' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:36: '*'
        {
        match(input,52,FOLLOW_52_in_synpred9_FinexClass2674); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_FinexClass

    // $ANTLR start synpred10_FinexClass
    public final void synpred10_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:3: ( '/' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:4: '/'
        {
        match(input,53,FOLLOW_53_in_synpred10_FinexClass2702); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_FinexClass

    // $ANTLR start synpred11_FinexClass
    public final void synpred11_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:3: ( 'AND' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:682:4: 'AND'
        {
        match(input,54,FOLLOW_54_in_synpred11_FinexClass2730); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_FinexClass

    // $ANTLR start synpred12_FinexClass
    public final void synpred12_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:35: ( 'OR' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:36: 'OR'
        {
        match(input,55,FOLLOW_55_in_synpred12_FinexClass2792); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_FinexClass

    // $ANTLR start synpred13_FinexClass
    public final void synpred13_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:3: ( '+' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:697:4: '+'
        {
        match(input,56,FOLLOW_56_in_synpred13_FinexClass2820); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_FinexClass

    // $ANTLR start synpred14_FinexClass
    public final void synpred14_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:3: ( '-' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:700:4: '-'
        {
        match(input,50,FOLLOW_50_in_synpred14_FinexClass2848); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_FinexClass

    // $ANTLR start synpred15_FinexClass
    public final void synpred15_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:35: ( RANGLE )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:36: RANGLE
        {
        match(input,RANGLE,FOLLOW_RANGLE_in_synpred15_FinexClass2910); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_FinexClass

    // $ANTLR start synpred16_FinexClass
    public final void synpred16_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:3: ( LANGLE )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:715:4: LANGLE
        {
        match(input,LANGLE,FOLLOW_LANGLE_in_synpred16_FinexClass2939); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_FinexClass

    // $ANTLR start synpred17_FinexClass
    public final void synpred17_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:3: ( '>=' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:718:4: '>='
        {
        match(input,57,FOLLOW_57_in_synpred17_FinexClass2968); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_FinexClass

    // $ANTLR start synpred18_FinexClass
    public final void synpred18_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:3: ( '<=' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:721:4: '<='
        {
        match(input,58,FOLLOW_58_in_synpred18_FinexClass2996); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_FinexClass

    // $ANTLR start synpred19_FinexClass
    public final void synpred19_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:3: ( EQUALSEQUALS )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:4: EQUALSEQUALS
        {
        match(input,EQUALSEQUALS,FOLLOW_EQUALSEQUALS_in_synpred19_FinexClass3024); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_FinexClass

    // $ANTLR start synpred20_FinexClass
    public final void synpred20_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:3: ( '!=' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:727:4: '!='
        {
        match(input,59,FOLLOW_59_in_synpred20_FinexClass3053); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_FinexClass

    // Delegated rules

    public final boolean synpred13_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_FinexClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_FinexClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_FIRST_LOWERCASE_NAME_in_firstLowercaseIdentifier63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIRST_UPPERCASE_NAME_in_firstUppercaseIdentifier94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsStringSymbol218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsStringSymbol249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_binarySymbol311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_in_dateSymbol342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_in_main370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classdeclaration_in_structure_finexclass404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_field_in_structure_type_field442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classdeclaration_in_structure_finexclass_field472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_classdeclaration516 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_classdeclaration543 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_classdeclaration563 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_classdeclaration575 = new BitSet(new long[]{0x0000600000035000L});
    public static final BitSet FOLLOW_structure_association_in_classdeclaration597 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration604 = new BitSet(new long[]{0x0000600000035000L});
    public static final BitSet FOLLOW_behavior_functions_function_in_classdeclaration628 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration635 = new BitSet(new long[]{0x0000600000035000L});
    public static final BitSet FOLLOW_LBRACKET_in_classdeclaration650 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_classdeclaration658 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_classdeclaration665 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration670 = new BitSet(new long[]{0x0000600000035000L});
    public static final BitSet FOLLOW_COLON_in_classdeclaration684 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_classdeclaration697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_classdeclaration717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_in_structure_type752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_field_in_structure_association786 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_structure_association797 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_structure_field_opposite_in_structure_association804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_field_nondeclaredOpposite_in_structure_association824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_structure_field881 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_DDOT_in_structure_field899 = new BitSet(new long[]{0x0000010000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field925 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field948 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field971 = new BitSet(new long[]{0x00000C0000040000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field991 = new BitSet(new long[]{0x00000C0000040000L});
    public static final BitSet FOLLOW_askey_in_structure_field1002 = new BitSet(new long[]{0x0000040000040002L});
    public static final BitSet FOLLOW_42_in_structure_field1011 = new BitSet(new long[]{0x000C000000094FF2L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1037 = new BitSet(new long[]{0x000C000000094FF2L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_structure_field1088 = new BitSet(new long[]{0x00000C0000040000L});
    public static final BitSet FOLLOW_askey_in_structure_field1097 = new BitSet(new long[]{0x0000040000040002L});
    public static final BitSet FOLLOW_42_in_structure_field1106 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1130 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field_opposite1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_askey1294 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_askey1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_behavior_functions_function1347 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_functionheader_in_behavior_functions_function1350 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_behavior_functions_signatureimplementation_in_behavior_functions_function1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_behavior_functions_function1374 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_functionheader_in_behavior_functions_function1377 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_behavior_functions_signatureimplementation_manipulator_in_behavior_functions_function1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_functionheader1436 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_functionheader1456 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_functionheader1481 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_47_in_functionheader1490 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_IN_in_functionheader1497 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_48_in_functionheader1505 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_IN_in_functionheader1512 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_48_in_functionheader1526 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_functionheader1529 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_functionheader1536 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_48_in_functionheader1544 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_functionheader1551 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_49_in_functionheader1585 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_functionheader1592 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_48_in_functionheader1600 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_functionheader1607 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_functionheader1622 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_functionheader1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_parameter1661 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_parameter1681 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_parameter1701 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_parameter1721 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_parameter1738 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_parameter1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_IN1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_OUT1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_block_in_behavior_functions_signatureimplementation1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_behavior_actions_block1907 = new BitSet(new long[]{0x000C000000494FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1918 = new BitSet(new long[]{0x000C000000494FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1926 = new BitSet(new long[]{0x000C000000494FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_RCURL_in_behavior_actions_block1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_manipulator_manipulator_in_behavior_functions_signatureimplementation_manipulator1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_behavior_actions_manipulator_manipulator2010 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_behavior_actions_assignment_manipulator_in_behavior_actions_manipulator_manipulator2021 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_PIPE_in_behavior_actions_manipulator_manipulator2030 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_behavior_actions_assignment_manipulator_in_behavior_actions_manipulator_manipulator2038 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RCURL_in_behavior_actions_manipulator_manipulator2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_statementwithargument_in_behavior_actions_statement2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_expressionstatement_in_behavior_actions_statement2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_assignment_in_behavior_actions_statementwithargument2139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_behavior_actions_assignment2170 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions_assignment2175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_behavior_actions_assignment_manipulator2216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_assignment2252 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_assignment2265 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_assignment2285 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_EQUALS_in_assignment2297 = new BitSet(new long[]{0x000C000000094FF2L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_assignment2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_actions_expressionstatement2344 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions_expressionstatement2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_namedvalueexpression_in_primary_behavior_expressions_expression2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_objectcreationexpression_in_primary_behavior_expressions_expression2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_this_in_primary_behavior_expressions_expression2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_multiobjectliteral_in_primary_behavior_expressions_expression2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_behavior_expressions_expression2438 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2444 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_behavior_expressions_expression2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_expressions_priority_02489 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02496 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_expressions_priority_02517 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_not_in_expressions_priority_02524 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02544 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_DOT_in_expressions_priority_02553 = new BitSet(new long[]{0xF000000000080030L,0x000000000000001FL});
    public static final BitSet FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02561 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_count_in_expressions_priority_02570 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_single_in_expressions_priority_02579 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_tuple_in_expressions_priority_02588 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02597 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02606 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_LBRACKET_in_expressions_priority_02622 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02630 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12671 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_52_in_expressions_priority_12680 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12687 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12691 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_53_in_expressions_priority_12708 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12715 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12719 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_54_in_expressions_priority_12736 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12743 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12747 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22789 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_55_in_expressions_priority_22798 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22805 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22809 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_56_in_expressions_priority_22826 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22833 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22837 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_50_in_expressions_priority_22854 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22861 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22865 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32907 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_RANGLE_in_expressions_priority_32916 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32924 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32928 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_LANGLE_in_expressions_priority_32945 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32953 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32957 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_57_in_expressions_priority_32974 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32981 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32985 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_58_in_expressions_priority_33002 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33009 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33013 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_EQUALSEQUALS_in_expressions_priority_33030 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_equals_in_expressions_priority_33038 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33042 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_59_in_expressions_priority_33059 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_unequals_in_expressions_priority_33066 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33070 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_expressions_priority_3_in_behavior_expressions_expression3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_alias3132 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_expressions_alias_in_alias3139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_binarybooleanoperator3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_not3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_behavior_expressions_booleanaggregate3345 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_61_in_behavior_expressions_booleanaggregate3361 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_62_in_behavior_expressions_booleanaggregate3377 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate3389 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate3394 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_booleanaggregate3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_equals3435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_unequals3472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_binarynumericoperator3509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_unaryminus3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_behavior_expressions_count3583 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_count3590 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_count3595 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_count3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_behavior_expressions_single3633 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_single3640 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_single3645 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_single3649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_tuple3684 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_structure_type_tuple_in_behavior_expressions_tuple3692 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_tuple3699 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_tuple3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_tuple_in_structure_type_tuple3733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3767 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_structure_finexclass_tuple3775 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3782 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_structure_field_tuple_in_structure_association_tuple3835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_tuple3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field_tuple3900 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field_tuple3923 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_structure_field_tuple3938 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field_tuple3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_behavior_expressions_numericaggregate4038 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_66_in_behavior_expressions_numericaggregate4054 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_67_in_behavior_expressions_numericaggregate4070 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_68_in_behavior_expressions_numericaggregate4086 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_numericaggregate4098 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_numericaggregate4103 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_numericaggregate4107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_behavior_expressions_objectcreationexpression4143 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_objectcreationexpression4150 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_objectcreationexpression4160 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4168 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_48_in_behavior_expressions_objectcreationexpression4176 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4183 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_objectcreationexpression4195 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_objectcreationexpression4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_behavior_expressions_fieldinitializer4241 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_fieldinitializer4254 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_fieldinitializer4274 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_behavior_expressions_fieldinitializer4286 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_fieldinitializer4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_behavior_expressions_this4337 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_this4340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_namedvalueexpression4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_namedvalueexpression4413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_implicitcontext_pathExpression_in_behavior_expressions_expression_pathExpression4461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_behavior_expressions_firstpathexpression4532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression4540 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression4555 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression4575 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_firstpathexpression4586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression4640 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression4660 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_pathexpression4671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression4712 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_behavior_expressions_filterexpression4719 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_filterexpression4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal4756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal4764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal4772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal4780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal4788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral4830 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_booleanliteral4836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral4884 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_stringliteral4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral4938 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_decimalliteral4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral4992 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_integerliteral4998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral5046 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_dateliteral5052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral5100 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_binaryliteral5106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_behavior_expressions_literals_multiobjectliteral5151 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_literals_multiobjectliteral5159 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_48_in_behavior_expressions_literals_multiobjectliteral5167 = new BitSet(new long[]{0x000C000000094FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_literals_multiobjectliteral5174 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_behavior_expressions_literals_multiobjectliteral5184 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_multiobjectliteral5188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_in_synpred1_FinexClass584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_functions_function_in_synpred2_FinexClass615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_synpred3_FinexClass1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred5_FinexClass2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred6_FinexClass2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred7_FinexClass2547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred8_FinexClass2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred9_FinexClass2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred10_FinexClass2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred11_FinexClass2730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred12_FinexClass2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred13_FinexClass2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred14_FinexClass2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGLE_in_synpred15_FinexClass2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_synpred16_FinexClass2939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred17_FinexClass2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred18_FinexClass2996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALSEQUALS_in_synpred19_FinexClass3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_synpred20_FinexClass3053 = new BitSet(new long[]{0x0000000000000002L});

}