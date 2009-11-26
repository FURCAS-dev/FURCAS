// $ANTLR 3.1.1 C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g 2009-11-26 11:03:24

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


       private static final String syntaxUUID = "E0B91841EA61ABD9DA7211DEAB0800155883529C";
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
              _beforeSeqEl("E0B91841E988B0F1DA7211DE842000155883529C");
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
              _beforeSeqEl("E0B91841E98B21F2DA7211DE92A500155883529C");
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
              _beforeSeqEl("E0B91841E98D6BE0DA7211DE889100155883529C");
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
              _beforeSeqEl("E0B91841E98FDCE3DA7211DE8C9800155883529C");
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
                      _beforeSeqEl("E0B91841E98FDCE1DA7211DE836000155883529C");
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
              _beforeSeqEl("E0B91841E9924DE4DA7211DE8C4100155883529C");
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
                      _beforeSeqEl("E0B91841E98FDCE6DA7211DE832B00155883529C");
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
                      _beforeSeqEl("E0B91841E9924DE2DA7211DE893700155883529C");
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
              _beforeSeqEl("E0B91841E9924DE5DA7211DE969D00155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration575); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9924DF9DA7211DEC76100155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:335: ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:337: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9924DF7DA7211DEB69600155883529C");
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
            	      _beforeSeqEl("E0B91841E9924DE8DA7211DEA1E400155883529C");
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
            	      _beforeSeqEl("E0B91841E9924DE9DA7211DEBD5400155883529C");
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
            	      _beforeSeqEl("E0B91841E9924DEDDA7211DE9E4900155883529C");
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
            	      _beforeSeqEl("E0B91841E9924DEEDA7211DECD9200155883529C");
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
            	      _beforeSeqEl("E0B91841E9924DF0DA7211DE9F0C00155883529C");
            	    }
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_classdeclaration650); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0B91841E9924DF3DA7211DE957A00155883529C");
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
            	      _beforeSeqEl("E0B91841E9924DF4DA7211DE91AD00155883529C");
            	    }
            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_classdeclaration665); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0B91841E9924DF5DA7211DE955400155883529C");
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
              _beforeSeqEl("E0B91841E9924DFADA7211DEB58800155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration684); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E99497D4DA7211DE9C5800155883529C");
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
                      _beforeSeqEl("E0B91841E9924DFDDA7211DEC82D00155883529C");
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
                      _beforeSeqEl("E0B91841E99497D2DA7211DE918200155883529C");
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
              _beforeSeqEl("E0B91841E99E34C5DA7211DEB67E00155883529C");
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
              _beforeSeqEl("E0B91841E9A07EBDDA7211DE8F3300155883529C");
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
                      _beforeSeqEl("E0B91841E9A07EB0DA7211DEA93900155883529C");
                    }
                    match(input,41,FOLLOW_41_in_structure_association797); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9A07EB5DA7211DEB24000155883529C");
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
                      _beforeSeqEl("E0B91841E9A07EBBDA7211DE9C3400155883529C");
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
              _beforeSeqEl("E0B91841E9A07EC0DA7211DE84EB00155883529C");
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
              _beforeSeqEl("E0B91841E9A2EFBBDA7211DEC45E00155883529C");
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
                      _beforeSeqEl("E0B91841E9A2EFB1DA7211DEA7E000155883529C");
                    }
                    match(input,DOT,FOLLOW_DOT_in_structure_field881); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9A2EFB4DA7211DE943100155883529C");
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
                      _beforeSeqEl("E0B91841E9A2EFB6DA7211DE927E00155883529C");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_structure_field899); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9A2EFB9DA7211DEAC4600155883529C");
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
              _beforeSeqEl("E0B91841E9A7AAA1DA7211DE9F0300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:338: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==FIRST_LOWERCASE_NAME) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==COLON) && (synpred3_FinexClass())) {
                    alt13=2;
                }
                else if ( ((LA13_1>=FIRST_LOWERCASE_NAME && LA13_1<=FIRST_UPPERCASE_NAME)) ) {
                    alt13=1;
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
                      _beforeSeqEl("E0B91841E9A2EFCADA7211DECFA000155883529C");
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
                              _beforeSeqEl("E0B91841E9A2EFBEDA7211DEBEC200155883529C");
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
                              _beforeSeqEl("E0B91841E9A2EFC1DA7211DE9EC100155883529C");
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
                              _beforeSeqEl("E0B91841E9A2EFC5DA7211DEA58200155883529C");
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
                              _beforeSeqEl("E0B91841E9A2EFC8DA7211DEBB6900155883529C");
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
                      _beforeSeqEl("E0B91841E9A560B6DA7211DEA7A600155883529C");
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
                              _beforeSeqEl("E0B91841E9A2EFCFDA7211DEAFDD00155883529C");
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
                              _beforeSeqEl("E0B91841E9A560B4DA7211DE87E400155883529C");
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
                      _beforeSeqEl("E0B91841E9A560B7DA7211DE803600155883529C");
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
                      _beforeSeqEl("E0B91841E9A560C1DA7211DEA21900155883529C");
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
                              _beforeSeqEl("E0B91841E9A560B8DA7211DE967100155883529C");
                            }
                            match(input,42,FOLLOW_42_in_structure_field1011); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0B91841E9A560BADA7211DE84FD00155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:571: (temp= behavior_expressions_expression )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>=FIRST_LOWERCASE_NAME && LA9_0<=DATE)||LA9_0==DOT||LA9_0==LPAREN||(LA9_0>=50 && LA9_0<=51)||(LA9_0>=69 && LA9_0<=70)) ) {
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
                              _beforeSeqEl("E0B91841E9A560BCDA7211DE80ED00155883529C");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1037); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0B91841E9A560BEDA7211DEB68E00155883529C");
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:163: (temp= behavior_expressions_expression )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>=FIRST_LOWERCASE_NAME && LA10_0<=DATE)||LA10_0==DOT||LA10_0==LPAREN||(LA10_0>=50 && LA10_0<=51)||(LA10_0>=69 && LA10_0<=70)) ) {
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
                      _beforeSeqEl("E0B91841E9A560C5DA7211DE9E1300155883529C");
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
                      _beforeSeqEl("E0B91841E9A560C8DA7211DEC7F100155883529C");
                    }
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "name", null, null, "OCL:self.type.name", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9A560C9DA7211DE80D400155883529C");
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
                      _beforeSeqEl("E0B91841E9A560D5DA7211DE8BA900155883529C");
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
                              _beforeSeqEl("E0B91841E9A560CADA7211DECA7800155883529C");
                            }
                            match(input,42,FOLLOW_42_in_structure_field1106); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0B91841E9A560CDDA7211DEC37900155883529C");
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
                              _beforeSeqEl("E0B91841E9A560CFDA7211DE88C900155883529C");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1130); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0B91841E9A560D2DA7211DE946400155883529C");
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
              _beforeSeqEl("E0B91841E9A7AAA4DA7211DEB69200155883529C");
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
              _beforeSeqEl("E0B91841E9A7AAAADA7211DEBCE400155883529C");
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
              _beforeSeqEl("E0B91841E9AA1BA2DA7211DE924C00155883529C");
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
              _beforeSeqEl("E0B91841E9AA1BB0DA7211DECB3600155883529C");
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
              _beforeSeqEl("E0B91841E9AC6598DA7211DEC76A00155883529C");
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
                      _beforeSeqEl("E0B91841E9AC6595DA7211DEBE0700155883529C");
                    }
                    match(input,43,FOLLOW_43_in_askey1294); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9AC6596DA7211DEC48A00155883529C");
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
              _beforeSeqEl("E0B91841E9B14791DA7211DE877000155883529C");
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
                      _beforeSeqEl("E0B91841E9AED690DA7211DE83F900155883529C");
                    }
                    match(input,45,FOLLOW_45_in_behavior_functions_function1347); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9AED691DA7211DEBF4800155883529C");
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
                      _beforeSeqEl("E0B91841E9AED693DA7211DEA55000155883529C");
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
                      _beforeSeqEl("E0B91841E9AED695DA7211DE958100155883529C");
                    }
                    match(input,46,FOLLOW_46_in_behavior_functions_function1374); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9AED696DA7211DEADAA00155883529C");
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
                      _beforeSeqEl("E0B91841E9AED699DA7211DE84BA00155883529C");
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
              _beforeSeqEl("E0B91841E9B147A1DA7211DECA3900155883529C");
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
                      _beforeSeqEl("E0B91841E9B14797DA7211DEA7D600155883529C");
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
                      _beforeSeqEl("E0B91841E9B1479BDA7211DE897C00155883529C");
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
                      _beforeSeqEl("E0B91841E9B1479FDA7211DE8F7400155883529C");
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
              _beforeSeqEl("E0B91841E9B147A2DA7211DEB9D000155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_functionheader1481); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9B39198DA7211DEB5D200155883529C");
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
                      _beforeSeqEl("E0B91841E9B147A3DA7211DEA85300155883529C");
                    }
                    match(input,47,FOLLOW_47_in_functionheader1490); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9B39181DA7211DE847100155883529C");
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
                    	      _beforeSeqEl("E0B91841E9B147A6DA7211DE858800155883529C");
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
                      _beforeSeqEl("E0B91841E9B3918DDA7211DEB4F600155883529C");
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
                              _beforeSeqEl("E0B91841E9B39182DA7211DEA98400155883529C");
                            }
                            match(input,48,FOLLOW_48_in_functionheader1526); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0B91841E9B39183DA7211DEA67900155883529C");
                            }
                            match(input,49,FOLLOW_49_in_functionheader1529); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0B91841E9B3918ADA7211DEB11B00155883529C");
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
                            	      _beforeSeqEl("E0B91841E9B39186DA7211DEAD3C00155883529C");
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
                      _beforeSeqEl("E0B91841E9B3918FDA7211DE861800155883529C");
                    }
                    match(input,49,FOLLOW_49_in_functionheader1585); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9B39196DA7211DE945400155883529C");
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
                    	      _beforeSeqEl("E0B91841E9B39192DA7211DE97D200155883529C");
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
              _beforeSeqEl("E0B91841E9B39199DA7211DE95F400155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_functionheader1622); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9B3919ADA7211DE99B500155883529C");
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
              _beforeSeqEl("E0B91841E9B87388DA7211DEC3F800155883529C");
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
                      _beforeSeqEl("E0B91841E9B87382DA7211DEB7A300155883529C");
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
                      _beforeSeqEl("E0B91841E9B87386DA7211DEC1B300155883529C");
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
              _beforeSeqEl("E0B91841E9B87395DA7211DE81ED00155883529C");
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
                      _beforeSeqEl("E0B91841E9B8738DDA7211DEB65000155883529C");
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
                      _beforeSeqEl("E0B91841E9B87393DA7211DEAD4A00155883529C");
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
              _beforeSeqEl("E0B91841E9B8739DDA7211DEA00500155883529C");
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
                      _beforeSeqEl("E0B91841E9B87399DA7211DEB93B00155883529C");
                    }
                    match(input,42,FOLLOW_42_in_parameter1738); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9B8739BDA7211DE96FF00155883529C");
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
              _beforeSeqEl("E0B91841E9BD2E70DA7211DE97C500155883529C");
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
              _beforeSeqEl("E0B91841E9BD2E73DA7211DEC9D700155883529C");
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
              _beforeSeqEl("E0B91841E9BF7860DA7211DE9BA900155883529C");
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
              _beforeSeqEl("E0B91841E9BF7863DA7211DEA77400155883529C");
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
              _beforeSeqEl("E0B91841E9C45A60DA7211DE92A900155883529C");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_block1907); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9C45A64DA7211DEC88000155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:145: ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:147: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9C45A62DA7211DE96B800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:206: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=FIRST_LOWERCASE_NAME && LA26_0<=DATE)||LA26_0==DOT||LA26_0==LPAREN||(LA26_0>=50 && LA26_0<=51)||(LA26_0>=69 && LA26_0<=70)) ) {
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

                        if ( ((LA25_0>=FIRST_LOWERCASE_NAME && LA25_0<=DATE)||LA25_0==DOT||LA25_0==LPAREN||(LA25_0>=50 && LA25_0<=51)||(LA25_0>=69 && LA25_0<=70)) ) {
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
              _beforeSeqEl("E0B91841E9C45A65DA7211DE8D3500155883529C");
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
              _beforeSeqEl("E0B91841E9C6A450DA7211DE886A00155883529C");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_manipulator_manipulator2010); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9C6A458DA7211DEC43700155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:145: ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:146: ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:146: ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:147: (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9C6A456DA7211DECDB100155883529C");
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
            	      _beforeSeqEl("E0B91841E9C6A453DA7211DEC88C00155883529C");
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
              _beforeSeqEl("E0B91841E9C6A459DA7211DE86E500155883529C");
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

                    if ( (LA28_4==EQUALS) ) {
                        alt28=1;
                    }
                    else if ( ((LA28_4>=SEMICOLON && LA28_4<=LBRACKET)||LA28_4==DOT||(LA28_4>=RANGLE && LA28_4<=EQUALSEQUALS)||LA28_4==43||LA28_4==50||(LA28_4>=52 && LA28_4<=59)) ) {
                        alt28=2;
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
            else if ( ((LA28_0>=FIRST_LOWERCASE_NAME && LA28_0<=DATE)||LA28_0==LPAREN||(LA28_0>=50 && LA28_0<=51)||(LA28_0>=69 && LA28_0<=70)) ) {
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
              _beforeSeqEl("E0B91841E9D4FC30DA7211DECA2100155883529C");
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
              _beforeSeqEl("E0B91841E9D4FC31DA7211DE80B800155883529C");
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
              _beforeSeqEl("E0B91841E9D76D32DA7211DEB5EF00155883529C");
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
              _beforeSeqEl("E0B91841E9D76D36DA7211DEA87200155883529C");
            }
            match(input,DOT,FOLLOW_DOT_in_assignment2252); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9D9B720DA7211DEA90E00155883529C");
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
                      _beforeSeqEl("E0B91841E9D76D3BDA7211DEAB8A00155883529C");
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
                      _beforeSeqEl("E0B91841E9D76D41DA7211DEA2E600155883529C");
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
              _beforeSeqEl("E0B91841E9D9B721DA7211DE8B7200155883529C");
            }
            match(input,EQUALS,FOLLOW_EQUALS_in_assignment2297); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9D9B723DA7211DE90B800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:418: (temp= behavior_expressions_expression )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=FIRST_LOWERCASE_NAME && LA30_0<=DATE)||LA30_0==DOT||LA30_0==LPAREN||(LA30_0>=50 && LA30_0<=51)||(LA30_0>=69 && LA30_0<=70)) ) {
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
              _beforeSeqEl("E0B91841E9DC2821DA7211DEC38300155883529C");
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
              _beforeSeqEl("E0B91841E9DC2822DA7211DECC3900155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:636:1: primary_behavior_expressions_expression returns [Object ret2] : (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) ;
    public final Object primary_behavior_expressions_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:637:3: ( (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:3: (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:3: (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            int alt31=6;
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
            case LPAREN:
                {
                alt31=6;
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    {
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:6: LPAREN ret= behavior_expressions_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_behavior_expressions_expression2430); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2436);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_behavior_expressions_expression2440); if (state.failed) return ret2;
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:650:1: expressions_priority_0 returns [Object ret2] : ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object expressions_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:3: ( ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=50 && LA35_0<=51)) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=FIRST_LOWERCASE_NAME && LA35_0<=DATE)||LA35_0==DOT||LA35_0==LPAREN||(LA35_0>=69 && LA35_0<=70)) ) {
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
                    {
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:6: ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:13: ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:14: '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("-", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,50,FOLLOW_50_in_expressions_priority_02481); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "-";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:94: ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:96: ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02488);
                            ret=behavior_expressions_unaryminus(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02492);
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
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:3: ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:12: ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:13: 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("not", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,51,FOLLOW_51_in_expressions_priority_02509); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "not";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:99: ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:101: ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_not_in_expressions_priority_02516);
                            ret=behavior_expressions_not(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02520);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    {
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:4: ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
                    {
                    pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02536);
                    ret=primary_behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:47: ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
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
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:48: ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:55: ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:56: DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq(".", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,DOT,FOLLOW_DOT_in_expressions_priority_02545); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = ".";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:137: ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
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
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:139: ret= behavior_expressions_booleanaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02553);
                    	            ret=behavior_expressions_booleanaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:4: ret= behavior_expressions_count[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_count_in_expressions_priority_02562);
                    	            ret=behavior_expressions_count(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:4: ret= behavior_expressions_single[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_single_in_expressions_priority_02571);
                    	            ret=behavior_expressions_single(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:3: (ret= behavior_expressions_tuple[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:3: (ret= behavior_expressions_tuple[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:4: ret= behavior_expressions_tuple[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_tuple_in_expressions_priority_02580);
                    	            ret=behavior_expressions_tuple(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:4: ret= behavior_expressions_numericaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02589);
                    	            ret=behavior_expressions_numericaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 6 :
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            {
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:4: ret= behavior_expressions_pathexpression[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02598);
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
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:3: ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:15: ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:16: LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq("[", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_expressions_priority_02614); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = "[";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:102: ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    {
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:104: ret= behavior_expressions_filterexpression[opName, ret, firstToken]
                    	    {
                    	    pushFollow(FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02622);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:673:1: expressions_priority_1 returns [Object ret2] : ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) ;
    public final Object expressions_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:3: ( ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:8: ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12663);
            ret=expressions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:34: ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:35: ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:42: ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:43: '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("*", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,52,FOLLOW_52_in_expressions_priority_12672); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "*";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:123: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:125: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12679);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12683);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:3: ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:10: ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:11: '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("/", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,53,FOLLOW_53_in_expressions_priority_12700); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "/";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12707);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12711);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:3: ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:12: ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:13: 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("AND", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,54,FOLLOW_54_in_expressions_priority_12728); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "AND";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:99: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:101: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12735);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12739);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:691:1: expressions_priority_2 returns [Object ret2] : ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) ;
    public final Object expressions_priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:3: ( ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:8: ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22781);
            ret=expressions_priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:34: ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:35: ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:43: ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:44: 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("OR", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,55,FOLLOW_55_in_expressions_priority_22790); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "OR";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:127: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:129: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22797);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22801);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:3: ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:10: ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:11: '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,56,FOLLOW_56_in_expressions_priority_22818); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22825);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22829);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:3: ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:10: ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:11: '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("-", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,50,FOLLOW_50_in_expressions_priority_22846); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "-";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22853);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22857);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:709:1: expressions_priority_3 returns [Object ret2] : ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) ;
    public final Object expressions_priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:3: ( ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:8: ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32899);
            ret=expressions_priority_2();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:34: ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:35: ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:45: ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:46: RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,RANGLE,FOLLOW_RANGLE_in_expressions_priority_32908); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:130: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:132: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32916);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32920);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:3: ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:13: ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:14: LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LANGLE,FOLLOW_LANGLE_in_expressions_priority_32937); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:98: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:100: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32945);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32949);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:3: ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:11: ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:12: '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,57,FOLLOW_57_in_expressions_priority_32966); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32973);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32977);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:3: ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:11: ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:12: '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,58,FOLLOW_58_in_expressions_priority_32994); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33001);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33005);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:3: ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:19: ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:20: EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("==", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQUALSEQUALS,FOLLOW_EQUALSEQUALS_in_expressions_priority_33022); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "==";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:112: ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:113: (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:113: (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:114: ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_equals_in_expressions_priority_33030);
            	    ret=behavior_expressions_equals(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33034);
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
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:3: ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:11: ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:12: '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("!=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,59,FOLLOW_59_in_expressions_priority_33051); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "!=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:95: ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:96: (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:96: (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:97: ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_unequals_in_expressions_priority_33058);
            	    ret=behavior_expressions_unequals(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33062);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:736:1: behavior_expressions_expression returns [Object ret2] : ret= expressions_priority_3 ;
    public final Object behavior_expressions_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:737:3: (ret= expressions_priority_3 )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:738:3: ret= expressions_priority_3
            {
            pushFollow(FOLLOW_expressions_priority_3_in_behavior_expressions_expression3095);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:745:1: alias[Object ret] : ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) ) ;
    public final void alias(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:3: ( ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:3: ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:3: ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:4: ( ( 'AS' (temp= behavior_expressions_alias ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9E0E317DA7211DE825800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:64: ( ( 'AS' (temp= behavior_expressions_alias ) ) | )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:65: ( 'AS' (temp= behavior_expressions_alias ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:81: ( 'AS' (temp= behavior_expressions_alias ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:82: 'AS' (temp= behavior_expressions_alias )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9E0E313DA7211DEC1CB00155883529C");
                    }
                    match(input,43,FOLLOW_43_in_alias3124); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9E0E315DA7211DE817600155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:220: (temp= behavior_expressions_alias )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:222: temp= behavior_expressions_alias
                    {
                    pushFollow(FOLLOW_behavior_expressions_alias_in_alias3131);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:747:323: 
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:755:1: behavior_expressions_alias returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_alias() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Alias");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9E35418DA7211DEA14700155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9E35412DA7211DEAD9000155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:140: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias3186);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9E35416DA7211DEA55B00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:80: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias3206);
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
              _beforeSeqEl("E0B91841E9E3541BDA7211DEAE4500155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:770:1: behavior_expressions_binarybooleanoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_binarybooleanoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryBooleanOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:775:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:776:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:776:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:776:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9E59E03DA7211DEC00700155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_binarybooleanoperator3258);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9E59E06DA7211DE9E4700155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:786:1: behavior_expressions_not[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_not(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Not");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:791:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:792:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:792:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:792:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9EA8001DA7211DEA34600155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_not3295);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9ECC9F0DA7211DE865700155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:802:1: behavior_expressions_booleanaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_booleanaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BooleanAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:3: ( ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:4: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9EF3B00DA7211DECB1900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:63: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:64: ( 'and' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:80: ( 'and' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:81: 'and'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9EF3AF1DA7211DEAD5200155883529C");
                    }
                    match(input,60,FOLLOW_60_in_behavior_expressions_booleanaggregate3337); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9EF3AF4DA7211DECCF500155883529C");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:4: ( 'or' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:20: ( 'or' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:21: 'or'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9EF3AF6DA7211DEABDE00155883529C");
                    }
                    match(input,61,FOLLOW_61_in_behavior_expressions_booleanaggregate3353); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9EF3AF9DA7211DE9C4400155883529C");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:810:4: ( 'xor' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:810:20: ( 'xor' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:810:21: 'xor'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9EF3AFBDA7211DEA7EE00155883529C");
                    }
                    match(input,62,FOLLOW_62_in_behavior_expressions_booleanaggregate3369); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841E9EF3AFEDA7211DEC66400155883529C");
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
              _beforeSeqEl("E0B91841E9EF3B01DA7211DE839F00155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate3381); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9EF3B02DA7211DE9B4700155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate3386); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9EF3B03DA7211DEB56500155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_booleanaggregate3390);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9EF3B06DA7211DECF2500155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:820:1: behavior_expressions_equals[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_equals(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Equals");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:826:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:826:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:826:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9F3F5E2DA7211DEC9EB00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_equals3427);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9F3F5E5DA7211DEB29000155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:1: behavior_expressions_unequals[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_unequals(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Unequals");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:841:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:842:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:842:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:842:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9F666E2DA7211DEB3CB00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_unequals3464);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9F666E5DA7211DEC72A00155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:852:1: behavior_expressions_binarynumericoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_binarynumericoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryNumericOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:857:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:858:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:858:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:858:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9F8B0D3DA7211DEAFA200155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_binarynumericoperator3501);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9F8B0D6DA7211DE9B7900155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:868:1: behavior_expressions_unaryminus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_unaryminus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","UnaryMinus");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:873:3: ( ( alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:874:3: ( alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:874:3: ( alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:874:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9FD92D2DA7211DE9DA400155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_unaryminus3538);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9FD92D5DA7211DEA38600155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:884:1: behavior_expressions_count[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'count' LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_count(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Count");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:889:3: ( ( 'count' LPAREN RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:890:3: ( 'count' LPAREN RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:890:3: ( 'count' LPAREN RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:890:4: 'count' LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9FFDCC1DA7211DEC42300155883529C");
            }
            match(input,63,FOLLOW_63_in_behavior_expressions_count3575); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9FFDCC4DA7211DEBC5200155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9FFDCC5DA7211DE907800155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_count3582); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9FFDCC6DA7211DE858C00155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_count3587); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841E9FFDCC7DA7211DEAFAF00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_count3591);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:900:1: behavior_expressions_single[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'single' LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_single(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Single");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:905:3: ( ( 'single' LPAREN RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:906:3: ( 'single' LPAREN RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:906:3: ( 'single' LPAREN RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:906:4: 'single' LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA024DC1DA7211DEB8D200155883529C");
            }
            match(input,64,FOLLOW_64_in_behavior_expressions_single3625); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA024DC4DA7211DEA87A00155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA024DC5DA7211DE8AD800155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_single3632); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA024DC6DA7211DEA70800155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_single3637); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA024DC7DA7211DEB95C00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_single3641);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:916:1: behavior_expressions_tuple[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] ) ;
    public final Object behavior_expressions_tuple(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Tuple");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:921:3: ( ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:922:3: ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:922:3: ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:922:4: LPAREN (temp= structure_type_tuple ) RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA0708B1DA7211DE90A400155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_tuple3676); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA0708B4DA7211DE896B00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:922:146: (temp= structure_type_tuple )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:922:148: temp= structure_type_tuple
            {
            pushFollow(FOLLOW_structure_type_tuple_in_behavior_expressions_tuple3684);
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
              _beforeSeqEl("E0B91841EA0708B5DA7211DEAABF00155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_tuple3691); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA0708B6DA7211DE85C700155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_tuple3695);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:932:1: structure_type_tuple returns [Object ret2] : (ret= structure_finexclass_tuple ) ;
    public final Object structure_type_tuple() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:933:3: ( (ret= structure_finexclass_tuple ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:934:3: (ret= structure_finexclass_tuple )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:934:3: (ret= structure_finexclass_tuple )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:934:4: ret= structure_finexclass_tuple
            {
            pushFollow(FOLLOW_structure_finexclass_tuple_in_structure_type_tuple3725);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:941:1: structure_finexclass_tuple returns [Object ret2] : ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) ) ;
    public final Object structure_finexclass_tuple() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:946:3: ( ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:3: ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:3: ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:4: (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA10A5A1DA7211DECEF600155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:63: (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:65: temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )*
            {
            pushFollow(FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3759);
            temp=structure_association_tuple();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "associations", temp);
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:140: ( ( ',' ) temp= structure_association_tuple )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==48) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:141: ( ',' ) temp= structure_association_tuple
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:158: ( ',' )
            	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:947:159: ','
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0B91841EA0E34A4DA7211DEC72B00155883529C");
            	    }
            	    match(input,48,FOLLOW_48_in_structure_finexclass_tuple3767); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3774);
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
              _beforeSeqEl("E0B91841EA10A5A8DA7211DE935000155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:self.typedElement.oclAsType(\"Tuple\").operand.getAllAliases()->iterate("+"			 			a; acc='TupleType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement->select(te | te.oclIsKindOf(Expression))."+"			                   oclAsType(Expression).getEnclosingType()", true);_exitInjectorAction();
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:955:1: structure_association_tuple returns [Object ret2] : ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) ) ;
    public final Object structure_association_tuple() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:960:3: ( ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:961:3: ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:961:3: ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:961:4: (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA10A5B0DA7211DEBA4900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:961:63: (temp= structure_field_tuple )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:961:65: temp= structure_field_tuple
            {
            pushFollow(FOLLOW_structure_field_tuple_in_structure_association_tuple3827);
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
              _beforeSeqEl("E0B91841EA12EF93DA7211DECBA600155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:961:201: (temp= structure_field_nondeclaredOpposite )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:961:203: temp= structure_field_nondeclaredOpposite
            {
            pushFollow(FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_tuple3837);
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
              _beforeSeqEl("E0B91841EA12EF96DA7211DEB4BA00155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:969:1: structure_field_tuple returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) ;
    public final Object structure_field_tuple() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:974:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA156094DA7211DE896100155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA12EF9CDA7211DEA56A00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:140: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_structure_field_tuple3892);
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
                      _beforeSeqEl("E0B91841EA12EF9FDA7211DE8E5700155883529C");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA12EFA3DA7211DE85FB00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:80: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field_tuple3915);
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
                      _beforeSeqEl("E0B91841EA156092DA7211DEC65D00155883529C");
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
              _beforeSeqEl("E0B91841EA156095DA7211DE8A5800155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_structure_field_tuple3930); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA156098DA7211DE96E300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:471: (temp= behavior_expressions_expression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:473: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field_tuple3938);
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
              _beforeSeqEl("E0B91841EA15609FDA7211DECF8200155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:984:1: structure_field_tupleLocalEnd returns [Object ret2] : () ;
    public final Object structure_field_tupleLocalEnd() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"tupleLocalEnd");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:989:3: ( () )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:990:3: ()
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:990:3: ()
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:990:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA17D192DA7211DE997B00155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:998:1: behavior_expressions_numericaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_numericaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","NumericAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1003:3: ( ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1004:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1004:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1004:4: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1A1B95DA7211DE9A3A00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1004:63: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1004:64: ( 'sum' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1004:80: ( 'sum' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1004:81: 'sum'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA1A1B81DA7211DEB89D00155883529C");
                    }
                    match(input,65,FOLLOW_65_in_behavior_expressions_numericaggregate4030); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA1A1B84DA7211DE820400155883529C");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:4: ( 'avg' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:20: ( 'avg' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:21: 'avg'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA1A1B86DA7211DE853600155883529C");
                    }
                    match(input,66,FOLLOW_66_in_behavior_expressions_numericaggregate4046); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA1A1B89DA7211DEA1DE00155883529C");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:4: ( 'min' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:20: ( 'min' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:21: 'min'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA1A1B8BDA7211DE803300155883529C");
                    }
                    match(input,67,FOLLOW_67_in_behavior_expressions_numericaggregate4062); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA1A1B8EDA7211DE936300155883529C");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:4: ( 'max' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:20: ( 'max' )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:21: 'max'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA1A1B90DA7211DEAE7400155883529C");
                    }
                    match(input,68,FOLLOW_68_in_behavior_expressions_numericaggregate4078); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA1A1B93DA7211DE9E4700155883529C");
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
              _beforeSeqEl("E0B91841EA1A1B96DA7211DEBC9C00155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_numericaggregate4090); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1A1B97DA7211DEA5EA00155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_numericaggregate4095); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1A1B98DA7211DEA46000155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_numericaggregate4099);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1A1B9BDA7211DE914D00155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1017:1: behavior_expressions_objectcreationexpression returns [Object ret2] : ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] ) ;
    public final Object behavior_expressions_objectcreationexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","ObjectCreationExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1022:3: ( ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:3: ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:3: ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:4: 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1ED670DA7211DEB31F00155883529C");
            }
            match(input,69,FOLLOW_69_in_behavior_expressions_objectcreationexpression4135); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1ED675DA7211DECB6E00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:146: (temp= firstUppercaseIdentifier )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:148: temp= firstUppercaseIdentifier
            {
            pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_objectcreationexpression4142);
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
              _beforeSeqEl("E0B91841EA1ED678DA7211DE85F500155883529C");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:classToInstantiate", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1ED679DA7211DE81B100155883529C");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_objectcreationexpression4152); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1ED67EDA7211DE986200155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:622: (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=FIRST_LOWERCASE_NAME && LA46_0<=FIRST_UPPERCASE_NAME)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:624: temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )*
                    {
                    pushFollow(FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4160);
                    temp=behavior_expressions_fieldinitializer();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "fieldInitializers", temp);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:714: ( ( ',' ) temp= behavior_expressions_fieldinitializer )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==48) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:715: ( ',' ) temp= behavior_expressions_fieldinitializer
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:732: ( ',' )
                    	    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1023:733: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0B91841EA1ED67BDA7211DEBDBF00155883529C");
                    	    }
                    	    match(input,48,FOLLOW_48_in_behavior_expressions_objectcreationexpression4168); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4175);
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
              _beforeSeqEl("E0B91841EA1ED67FDA7211DEC35D00155883529C");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_objectcreationexpression4187); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA1ED680DA7211DEAA4000155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_objectcreationexpression4191);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1031:1: behavior_expressions_fieldinitializer returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) ;
    public final Object behavior_expressions_fieldinitializer() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FieldInitializer");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1036:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA21477CDA7211DEAD4300155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA214774DA7211DEAD4800155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:140: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1037:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_fieldinitializer4241);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA21477ADA7211DE9C9900155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_fieldinitializer4261);
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
              _beforeSeqEl("E0B91841EA21477DDA7211DE844800155883529C");
            }
            match(input,COLON,FOLLOW_COLON_in_behavior_expressions_fieldinitializer4273); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA21477FDA7211DEB40700155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:447: (temp= behavior_expressions_expression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:449: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_fieldinitializer4281);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1046:1: behavior_expressions_this returns [Object ret2] : ( 'this' alias[ret] ) ;
    public final Object behavior_expressions_this() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","This");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1051:3: ( ( 'this' alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1052:3: ( 'this' alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1052:3: ( 'this' alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1052:4: 'this' alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA23B872DA7211DEB6D700155883529C");
            }
            match(input,70,FOLLOW_70_in_behavior_expressions_this4324); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA23B873DA7211DEB97A00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_this4327);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA23B876DA7211DE845600155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1060:1: behavior_expressions_namedvalueexpression returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_namedvalueexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","NamedValueExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1065:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA260261DA7211DEAADD00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA23B87EDA7211DEA1C100155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:140: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1066:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_namedvalueexpression4380);
                    temp=firstLowercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "namedValue", null, temp, "OCL:self.getAllAliases()->select(a | a.name = ?)");
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA23B884DA7211DEA5F900155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_namedvalueexpression4400);
                    temp=firstUppercaseIdentifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "namedValue", null, temp, "OCL:self.getAllAliases()->select(a | a.name = ?)");
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
              _beforeSeqEl("E0B91841EA260264DA7211DE8C6000155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1075:1: behavior_expressions_expression_pathExpression returns [Object ret2] : (ret= behavior_expressions_implicitcontext_pathExpression ) ;
    public final Object behavior_expressions_expression_pathExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1076:3: ( (ret= behavior_expressions_implicitcontext_pathExpression ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1077:3: (ret= behavior_expressions_implicitcontext_pathExpression )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1077:3: (ret= behavior_expressions_implicitcontext_pathExpression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1077:4: ret= behavior_expressions_implicitcontext_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_implicitcontext_pathExpression_in_behavior_expressions_expression_pathExpression4448);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1084:1: behavior_expressions_implicitcontext_pathExpression returns [Object ret2] : () ;
    public final Object behavior_expressions_implicitcontext_pathExpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","ImplicitContext");
        onEnterTemplateRule(metaType,"pathExpression");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1089:3: ( () )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:3: ()
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:3: ()
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA2D2E52DA7211DEB48200155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1098:1: behavior_expressions_firstpathexpression returns [Object ret2] : ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) ;
    public final Object behavior_expressions_firstpathexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FirstPathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1103:3: ( ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:4: DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA2D2E56DA7211DEA3B600155883529C");
            }
            match(input,DOT,FOLLOW_DOT_in_behavior_expressions_firstpathexpression4519); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA2D2E59DA7211DECEF800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:143: (temp= behavior_expressions_expression_pathExpression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:145: temp= behavior_expressions_expression_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression4527);
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
              _beforeSeqEl("E0B91841EA2F9F51DA7211DE83C800155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:309: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:310: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:326: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:327: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA2D2E5EDA7211DEC46800155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:386: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:388: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression4542);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA2D2E64DA7211DECDEF00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression4562);
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
              _beforeSeqEl("E0B91841EA2F9F52DA7211DE975100155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_firstpathexpression4573);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA2F9F55DA7211DEA50700155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1113:1: behavior_expressions_pathexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) ;
    public final Object behavior_expressions_pathexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","PathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1118:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA31E94DDA7211DE979900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA31E945DA7211DEB12700155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:140: (temp= firstLowercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression4627);
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841EA31E94BDA7211DEA73B00155883529C");
                    }
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:80: (temp= firstUppercaseIdentifier )
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression4647);
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
              _beforeSeqEl("E0B91841EA31E94EDA7211DE9FA400155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_pathexpression4658);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA31E951DA7211DEA08400155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1130:1: behavior_expressions_filterexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] ) ;
    public final Object behavior_expressions_filterexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FilterExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1135:3: ( ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:3: ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:3: ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:4: (temp= behavior_expressions_expression ) RBRACKET alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA345A42DA7211DEB73100155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:63: (temp= behavior_expressions_expression )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression4699);
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
              _beforeSeqEl("E0B91841EA345A43DA7211DE875200155883529C");
            }
            match(input,RBRACKET,FOLLOW_RBRACKET_in_behavior_expressions_filterexpression4706); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA345A44DA7211DE93D300155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_filterexpression4710);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA36CB40DA7211DE811B00155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1146:1: behavior_expressions_literals_literal returns [Object ret2] : (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) ;
    public final Object behavior_expressions_literals_literal() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1147:3: ( (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
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
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:4: ret= behavior_expressions_literals_booleanliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal4743);
                    ret=behavior_expressions_literals_booleanliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1149:5: ret= behavior_expressions_literals_stringliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal4751);
                    ret=behavior_expressions_literals_stringliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1150:5: ret= behavior_expressions_literals_decimalliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal4759);
                    ret=behavior_expressions_literals_decimalliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1151:5: ret= behavior_expressions_literals_integerliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal4767);
                    ret=behavior_expressions_literals_integerliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1152:5: ret= behavior_expressions_literals_dateliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal4775);
                    ret=behavior_expressions_literals_dateliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1153:5: ret= behavior_expressions_literals_binaryliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal4783);
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:1: behavior_expressions_literals_booleanliteral returns [Object ret2] : ( (temp= booleanSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_booleanliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BooleanLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1165:3: ( ( (temp= booleanSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1166:3: ( (temp= booleanSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1166:3: ( (temp= booleanSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1166:4: (temp= booleanSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA44FC12DA7211DE85D700155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1166:63: (temp= booleanSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1166:65: temp= booleanSymbol
            {
            pushFollow(FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral4817);
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
              _beforeSeqEl("E0B91841EA44FC13DA7211DEBF7200155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_booleanliteral4823);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA44FC16DA7211DEA63500155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1174:1: behavior_expressions_literals_stringliteral returns [Object ret2] : ( (temp= stringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_stringliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","StringLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1179:3: ( ( (temp= stringSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:3: ( (temp= stringSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:3: ( (temp= stringSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:4: (temp= stringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA49DE12DA7211DEB98900155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:63: (temp= stringSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1180:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral4871);
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
              _beforeSeqEl("E0B91841EA49DE13DA7211DEB30A00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_stringliteral4877);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA49DE16DA7211DECB9900155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:1: behavior_expressions_literals_decimalliteral returns [Object ret2] : ( (temp= floatAsStringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_decimalliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DecimalLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1193:3: ( ( (temp= floatAsStringSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1194:3: ( (temp= floatAsStringSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1194:3: ( (temp= floatAsStringSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1194:4: (temp= floatAsStringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA4C2802DA7211DE99DA00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1194:63: (temp= floatAsStringSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1194:65: temp= floatAsStringSymbol
            {
            pushFollow(FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral4925);
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
              _beforeSeqEl("E0B91841EA4C2803DA7211DEB12600155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_decimalliteral4931);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA4E9900DA7211DEB1C200155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1202:1: behavior_expressions_literals_integerliteral returns [Object ret2] : ( (temp= integerAsStringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_integerliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","IntegerLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1207:3: ( ( (temp= integerAsStringSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1208:3: ( (temp= integerAsStringSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1208:3: ( (temp= integerAsStringSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1208:4: (temp= integerAsStringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA510A02DA7211DEC2F200155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1208:63: (temp= integerAsStringSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1208:65: temp= integerAsStringSymbol
            {
            pushFollow(FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral4979);
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
              _beforeSeqEl("E0B91841EA510A03DA7211DE850000155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_integerliteral4985);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA510A06DA7211DE9DAE00155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1216:1: behavior_expressions_literals_dateliteral returns [Object ret2] : ( (temp= dateSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_dateliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DateLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1221:3: ( ( (temp= dateSymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:3: ( (temp= dateSymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:3: ( (temp= dateSymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:4: (temp= dateSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA55C4F2DA7211DEBC5D00155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:63: (temp= dateSymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:65: temp= dateSymbol
            {
            pushFollow(FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral5033);
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
              _beforeSeqEl("E0B91841EA55C4F3DA7211DEC4FD00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_dateliteral5039);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA55C4F6DA7211DE9E4500155883529C");
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
    // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1230:1: behavior_expressions_literals_binaryliteral returns [Object ret2] : ( (temp= binarySymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_binaryliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BinaryLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1235:3: ( ( (temp= binarySymbol ) alias[ret] ) )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1236:3: ( (temp= binarySymbol ) alias[ret] )
            {
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1236:3: ( (temp= binarySymbol ) alias[ret] )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1236:4: (temp= binarySymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA5A7FE2DA7211DEC06100155883529C");
            }
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1236:63: (temp= binarySymbol )
            // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1236:65: temp= binarySymbol
            {
            pushFollow(FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral5087);
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
              _beforeSeqEl("E0B91841EA5A7FE3DA7211DE82FA00155883529C");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_binaryliteral5093);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841EA5A7FE6DA7211DE83FC00155883529C");
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
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:6: ( '-' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:7: '-'
        {
        match(input,50,FOLLOW_50_in_synpred5_FinexClass2475); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_FinexClass

    // $ANTLR start synpred6_FinexClass
    public final void synpred6_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:3: ( 'not' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:4: 'not'
        {
        match(input,51,FOLLOW_51_in_synpred6_FinexClass2503); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_FinexClass

    // $ANTLR start synpred7_FinexClass
    public final void synpred7_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:48: ( DOT )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:49: DOT
        {
        match(input,DOT,FOLLOW_DOT_in_synpred7_FinexClass2539); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_FinexClass

    // $ANTLR start synpred8_FinexClass
    public final void synpred8_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:3: ( LBRACKET )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:4: LBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred8_FinexClass2608); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_FinexClass

    // $ANTLR start synpred9_FinexClass
    public final void synpred9_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:35: ( '*' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:675:36: '*'
        {
        match(input,52,FOLLOW_52_in_synpred9_FinexClass2666); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_FinexClass

    // $ANTLR start synpred10_FinexClass
    public final void synpred10_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:3: ( '/' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:4: '/'
        {
        match(input,53,FOLLOW_53_in_synpred10_FinexClass2694); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_FinexClass

    // $ANTLR start synpred11_FinexClass
    public final void synpred11_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:3: ( 'AND' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:4: 'AND'
        {
        match(input,54,FOLLOW_54_in_synpred11_FinexClass2722); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_FinexClass

    // $ANTLR start synpred12_FinexClass
    public final void synpred12_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:35: ( 'OR' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:693:36: 'OR'
        {
        match(input,55,FOLLOW_55_in_synpred12_FinexClass2784); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_FinexClass

    // $ANTLR start synpred13_FinexClass
    public final void synpred13_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:3: ( '+' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:4: '+'
        {
        match(input,56,FOLLOW_56_in_synpred13_FinexClass2812); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_FinexClass

    // $ANTLR start synpred14_FinexClass
    public final void synpred14_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:3: ( '-' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:4: '-'
        {
        match(input,50,FOLLOW_50_in_synpred14_FinexClass2840); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_FinexClass

    // $ANTLR start synpred15_FinexClass
    public final void synpred15_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:35: ( RANGLE )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:36: RANGLE
        {
        match(input,RANGLE,FOLLOW_RANGLE_in_synpred15_FinexClass2902); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_FinexClass

    // $ANTLR start synpred16_FinexClass
    public final void synpred16_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:3: ( LANGLE )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:4: LANGLE
        {
        match(input,LANGLE,FOLLOW_LANGLE_in_synpred16_FinexClass2931); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_FinexClass

    // $ANTLR start synpred17_FinexClass
    public final void synpred17_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:3: ( '>=' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:4: '>='
        {
        match(input,57,FOLLOW_57_in_synpred17_FinexClass2960); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_FinexClass

    // $ANTLR start synpred18_FinexClass
    public final void synpred18_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:3: ( '<=' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:4: '<='
        {
        match(input,58,FOLLOW_58_in_synpred18_FinexClass2988); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_FinexClass

    // $ANTLR start synpred19_FinexClass
    public final void synpred19_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:3: ( EQUALSEQUALS )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:4: EQUALSEQUALS
        {
        match(input,EQUALSEQUALS,FOLLOW_EQUALSEQUALS_in_synpred19_FinexClass3016); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_FinexClass

    // $ANTLR start synpred20_FinexClass
    public final void synpred20_FinexClass_fragment() throws RecognitionException {   
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:3: ( '!=' )
        // C:\\Documents and Settings\\D043530\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:4: '!='
        {
        match(input,59,FOLLOW_59_in_synpred20_FinexClass3045); if (state.failed) return ;

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
    public static final BitSet FOLLOW_LBRACKET_in_classdeclaration650 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
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
    public static final BitSet FOLLOW_42_in_structure_field1011 = new BitSet(new long[]{0x000C000000090FF2L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1037 = new BitSet(new long[]{0x000C000000090FF2L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_structure_field1088 = new BitSet(new long[]{0x00000C0000040000L});
    public static final BitSet FOLLOW_askey_in_structure_field1097 = new BitSet(new long[]{0x0000040000040002L});
    public static final BitSet FOLLOW_42_in_structure_field1106 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1130 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
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
    public static final BitSet FOLLOW_42_in_parameter1738 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_parameter1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_IN1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_OUT1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_block_in_behavior_functions_signatureimplementation1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_behavior_actions_block1907 = new BitSet(new long[]{0x000C000000490FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1918 = new BitSet(new long[]{0x000C000000490FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1926 = new BitSet(new long[]{0x000C000000490FF0L,0x0000000000000060L});
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
    public static final BitSet FOLLOW_EQUALS_in_assignment2297 = new BitSet(new long[]{0x000C000000090FF2L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_assignment2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_actions_expressionstatement2344 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions_expressionstatement2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_namedvalueexpression_in_primary_behavior_expressions_expression2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_objectcreationexpression_in_primary_behavior_expressions_expression2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_this_in_primary_behavior_expressions_expression2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_behavior_expressions_expression2430 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2436 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_behavior_expressions_expression2440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_expressions_priority_02481 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02488 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_expressions_priority_02509 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_not_in_expressions_priority_02516 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02536 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_DOT_in_expressions_priority_02545 = new BitSet(new long[]{0xF000000000080030L,0x000000000000001FL});
    public static final BitSet FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02553 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_count_in_expressions_priority_02562 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_single_in_expressions_priority_02571 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_tuple_in_expressions_priority_02580 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02589 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02598 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_LBRACKET_in_expressions_priority_02614 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02622 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12663 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_52_in_expressions_priority_12672 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12679 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12683 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_53_in_expressions_priority_12700 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12707 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12711 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_54_in_expressions_priority_12728 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12735 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12739 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22781 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_55_in_expressions_priority_22790 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22797 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22801 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_56_in_expressions_priority_22818 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22825 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22829 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_50_in_expressions_priority_22846 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22853 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22857 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32899 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_RANGLE_in_expressions_priority_32908 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32916 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32920 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_LANGLE_in_expressions_priority_32937 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32945 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32949 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_57_in_expressions_priority_32966 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32973 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32977 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_58_in_expressions_priority_32994 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33001 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33005 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_EQUALSEQUALS_in_expressions_priority_33022 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_equals_in_expressions_priority_33030 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33034 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_59_in_expressions_priority_33051 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_unequals_in_expressions_priority_33058 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33062 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_expressions_priority_3_in_behavior_expressions_expression3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_alias3124 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_expressions_alias_in_alias3131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias3186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias3206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_binarybooleanoperator3258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_not3295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_behavior_expressions_booleanaggregate3337 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_61_in_behavior_expressions_booleanaggregate3353 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_62_in_behavior_expressions_booleanaggregate3369 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate3381 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate3386 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_booleanaggregate3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_equals3427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_unequals3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_binarynumericoperator3501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_unaryminus3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_behavior_expressions_count3575 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_count3582 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_count3587 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_count3591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_behavior_expressions_single3625 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_single3632 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_single3637 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_single3641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_tuple3676 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_structure_type_tuple_in_behavior_expressions_tuple3684 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_tuple3691 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_tuple3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_tuple_in_structure_type_tuple3725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3759 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_structure_finexclass_tuple3767 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3774 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_structure_field_tuple_in_structure_association_tuple3827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_tuple3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field_tuple3892 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field_tuple3915 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_structure_field_tuple3930 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field_tuple3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_behavior_expressions_numericaggregate4030 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_66_in_behavior_expressions_numericaggregate4046 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_67_in_behavior_expressions_numericaggregate4062 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_68_in_behavior_expressions_numericaggregate4078 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_numericaggregate4090 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_numericaggregate4095 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_numericaggregate4099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_behavior_expressions_objectcreationexpression4135 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_objectcreationexpression4142 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_objectcreationexpression4152 = new BitSet(new long[]{0x0000000000100030L});
    public static final BitSet FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4160 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_48_in_behavior_expressions_objectcreationexpression4168 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4175 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_objectcreationexpression4187 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_objectcreationexpression4191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_fieldinitializer4241 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_fieldinitializer4261 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_behavior_expressions_fieldinitializer4273 = new BitSet(new long[]{0x000C000000090FF0L,0x0000000000000060L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_fieldinitializer4281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_behavior_expressions_this4324 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_this4327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_namedvalueexpression4380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_namedvalueexpression4400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_implicitcontext_pathExpression_in_behavior_expressions_expression_pathExpression4448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_behavior_expressions_firstpathexpression4519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression4527 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression4542 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression4562 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_firstpathexpression4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression4627 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression4647 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_pathexpression4658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression4699 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_behavior_expressions_filterexpression4706 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_filterexpression4710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal4751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal4759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal4767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral4817 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_booleanliteral4823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral4871 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_stringliteral4877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral4925 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_decimalliteral4931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral4979 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_integerliteral4985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral5033 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_dateliteral5039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral5087 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_binaryliteral5093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_in_synpred1_FinexClass584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_functions_function_in_synpred2_FinexClass615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_synpred3_FinexClass1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred5_FinexClass2475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred6_FinexClass2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred7_FinexClass2539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred8_FinexClass2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred9_FinexClass2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred10_FinexClass2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred11_FinexClass2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred12_FinexClass2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred13_FinexClass2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred14_FinexClass2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGLE_in_synpred15_FinexClass2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_synpred16_FinexClass2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred17_FinexClass2960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred18_FinexClass2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALSEQUALS_in_synpred19_FinexClass3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_synpred20_FinexClass3045 = new BitSet(new long[]{0x0000000000000002L});

}