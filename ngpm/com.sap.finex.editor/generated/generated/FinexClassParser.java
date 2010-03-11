// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g 2010-03-09 14:56:52

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FIRST_LOWERCASE_NAME", "FIRST_UPPERCASE_NAME", "STRING", "INT", "FLOAT", "BOOL", "BINARY", "DATE", "COLON", "SEMICOLON", "LBRACKET", "RBRACKET", "DOT", "DDOT", "ASSIGN", "LPAREN", "RPAREN", "LCURL", "RCURL", "PIPE", "EQUALS", "RANGLE", "LANGLE", "EQUALSEQUALS", "COMMENT", "MULTI_LINE_COMMENT", "NL", "WS", "DIGIT", "LOWERCASE_ALPHA", "UPPERCASE_ALPHA", "ALPHA", "FIRST_LOWERCASE_SNAME", "FIRST_UPPERCASE_SNAME", "OBJECT", "RANGE_OR_INT", "'value'", "'opposite'", "'DEFAULT'", "'AS'", "'KEY'", "'function'", "'manipulator'", "'IN'", "','", "'OUT'", "'-'", "'not'", "'*'", "'/'", "'AND'", "'OR'", "'+'", "'>='", "'<='", "'!='", "'all'", "'and'", "'or'", "'xor'", "'count'", "'single'", "'sum'", "'avg'", "'min'", "'max'", "'create'", "'this'", "'select'", "'from'", "'where'", "'as'"
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
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int FIRST_UPPERCASE_SNAME=37;
    public static final int RCURL=22;
    public static final int FIRST_LOWERCASE_NAME=4;
    public static final int ASSIGN=18;
    public static final int FIRST_UPPERCASE_NAME=5;
    public static final int BINARY=10;
    public static final int DATE=11;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
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
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g"; }


       private static final String syntaxUUID = "E0677A9A9881FC9B2B8311DFB37BC07B8D1505E2";
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:207:1: firstLowercaseIdentifier returns [Object ret2] : (ast= FIRST_LOWERCASE_NAME ) ;
    public final Object firstLowercaseIdentifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:208:3: ( (ast= FIRST_LOWERCASE_NAME ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:3: (ast= FIRST_LOWERCASE_NAME )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:3: (ast= FIRST_LOWERCASE_NAME )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:4: ast= FIRST_LOWERCASE_NAME
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:217:1: firstUppercaseIdentifier returns [Object ret2] : (ast= FIRST_UPPERCASE_NAME ) ;
    public final Object firstUppercaseIdentifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:218:3: ( (ast= FIRST_UPPERCASE_NAME ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:3: (ast= FIRST_UPPERCASE_NAME )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:3: (ast= FIRST_UPPERCASE_NAME )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:4: ast= FIRST_UPPERCASE_NAME
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:227:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:228:3: ( (ast= STRING ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:3: (ast= STRING )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:3: (ast= STRING )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:4: ast= STRING
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:237:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:238:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:4: ast= INT
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:247:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:248:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:4: ast= INT
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:257:1: integerAsStringSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:258:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:4: ast= INT
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:267:1: floatAsStringSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:268:3: ( (ast= FLOAT ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:3: (ast= FLOAT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:3: (ast= FLOAT )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:4: ast= FLOAT
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:277:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:278:3: ( (ast= BOOL ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:3: (ast= BOOL )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:3: (ast= BOOL )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:4: ast= BOOL
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:287:1: binarySymbol returns [Object ret2] : (ast= BINARY ) ;
    public final Object binarySymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:288:3: ( (ast= BINARY ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:3: (ast= BINARY )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:3: (ast= BINARY )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:4: ast= BINARY
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:297:1: dateSymbol returns [Object ret2] : (ast= DATE ) ;
    public final Object dateSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:298:3: ( (ast= DATE ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:3: (ast= DATE )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:3: (ast= DATE )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:4: ast= DATE
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:307:1: main returns [Object ret2] : ( (ret= structure_finexclass ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:308:3: ( ( (ret= structure_finexclass ) EOF ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:3: ( (ret= structure_finexclass ) EOF )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:3: ( (ret= structure_finexclass ) EOF )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:4: (ret= structure_finexclass ) EOF
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:4: (ret= structure_finexclass )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:5: ret= structure_finexclass
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:316:1: structure_finexclass returns [Object ret2] : ( classdeclaration[ret] ) ;
    public final Object structure_finexclass() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"root"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:321:3: ( ( classdeclaration[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:3: ( classdeclaration[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:3: ( classdeclaration[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:4: classdeclaration[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A97F721B32B8311DFA415C07B8D1505E2");
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:330:1: structure_type_field returns [Object ret2] : (ret= structure_finexclass_field ) ;
    public final Object structure_type_field() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:331:3: ( (ret= structure_finexclass_field ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:3: (ret= structure_finexclass_field )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:3: (ret= structure_finexclass_field )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:4: ret= structure_finexclass_field
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:339:1: structure_finexclass_field returns [Object ret2] : ( classdeclaration[ret] ) ;
    public final Object structure_finexclass_field() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"field");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:344:3: ( ( classdeclaration[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:3: ( classdeclaration[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:3: ( classdeclaration[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:4: classdeclaration[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A97F8A8502B8311DF94B8C07B8D1505E2");
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
              _beforeSeqEl("E0677A9A97F8A8532B8311DF904FC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "owner", null, null, "OCL:#context(field).oclAsType(structure::Field).association.clazz", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:353:1: classdeclaration[Object ret] : ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final void classdeclaration(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:354:3: ( ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:3: ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:3: ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:4: ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A97F8A85C2B8311DFA935C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:64: ( ( 'value' ) | )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:65: ( 'value' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:81: ( 'value' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:82: 'value'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97F8A85A2B8311DF8B5CC07B8D1505E2");
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:238: 
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
              _beforeSeqEl("E0677A9A97FA2EF42B8311DF9CE7C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:76: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:77: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:93: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:94: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97F8A85F2B8311DFA3EEC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:153: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:155: temp= firstLowercaseIdentifier
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FA2EF22B8311DFC559C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:82: temp= firstUppercaseIdentifier
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
              _beforeSeqEl("E0677A9A97FA2EF52B8311DFC9D7C07B8D1505E2");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration575); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A97FA2F092B8311DFC965C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:335: ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:337: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A97FA2F072B8311DF8575C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:396: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:397: ( structure_association )=> ( (temp= structure_association ) SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(0);
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:440: ( (temp= structure_association ) SEMICOLON )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:441: (temp= structure_association ) SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A97FA2EF82B8311DF95B1C07B8D1505E2");
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:500: (temp= structure_association )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:502: temp= structure_association
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
            	      _beforeSeqEl("E0677A9A97FA2EF92B8311DF9CADC07B8D1505E2");
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:4: ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(1);
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:53: ( (temp= behavior_functions_function ) SEMICOLON )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:54: (temp= behavior_functions_function ) SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A97FA2EFD2B8311DF9214C07B8D1505E2");
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:113: (temp= behavior_functions_function )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:115: temp= behavior_functions_function
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
            	      _beforeSeqEl("E0677A9A97FA2EFE2B8311DFB098C07B8D1505E2");
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:4: ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(2);
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:20: ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:21: LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A97FA2F002B8311DF9C13C07B8D1505E2");
            	    }
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_classdeclaration650); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A97FA2F032B8311DFB44AC07B8D1505E2");
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:165: (temp= behavior_expressions_expression )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:167: temp= behavior_expressions_expression
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
            	      _beforeSeqEl("E0677A9A97FA2F042B8311DF91DDC07B8D1505E2");
            	    }
            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_classdeclaration665); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A97FA2F052B8311DFAB81C07B8D1505E2");
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
              _beforeSeqEl("E0677A9A97FA2F0A2B8311DFBE65C07B8D1505E2");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration684); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A97FA2F132B8311DFA34DC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:623: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:624: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:640: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:641: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FA2F0D2B8311DFAC6BC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:700: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:702: temp= firstLowercaseIdentifier
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FA2F112B8311DF8A63C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:82: temp= firstUppercaseIdentifier
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:367:1: structure_type returns [Object ret2] : (ret= structure_finexclass ) ;
    public final Object structure_type() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:368:3: ( (ret= structure_finexclass ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:3: (ret= structure_finexclass )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:3: (ret= structure_finexclass )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:4: ret= structure_finexclass
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:376:1: structure_association returns [Object ret2] : ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) ) ;
    public final Object structure_association() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:3: ( ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:3: ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:3: ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:4: (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A97FBB5962B8311DFAB78C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:63: (temp= structure_field )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:65: temp= structure_field
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
              _beforeSeqEl("E0677A9A97FD3C3B2B8311DF8395C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:195: ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==41) ) {
                alt5=1;
            }
            else if ( (LA5_0==EOF||LA5_0==SEMICOLON||LA5_0==RPAREN||LA5_0==48||LA5_0==73) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:196: ( 'opposite' (temp= structure_field_opposite ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:212: ( 'opposite' (temp= structure_field_opposite ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:213: 'opposite' (temp= structure_field_opposite )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FBB5972B8311DF880DC07B8D1505E2");
                    }
                    match(input,41,FOLLOW_41_in_structure_association797); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FD3C332B8311DFA512C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:357: (temp= structure_field_opposite )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:359: temp= structure_field_opposite
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:4: ( (temp= structure_field_nondeclaredOpposite ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:20: ( (temp= structure_field_nondeclaredOpposite ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:21: (temp= structure_field_nondeclaredOpposite )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FD3C392B8311DFB113C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:80: (temp= structure_field_nondeclaredOpposite )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:82: temp= structure_field_nondeclaredOpposite
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
              _beforeSeqEl("E0677A9A97FD3C3E2B8311DFCA67C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:if self.ends->last().name.size() > 0 then"+"		                        self.ends->first().name.concat(' opposite ').concat(self.ends->last().name)"+"		                      else"+"		                        self.ends->first().name"+"		                      endif", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:391:1: structure_field returns [Object ret2] : ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) ) ;
    public final Object structure_field() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"field"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:3: ( ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:3: ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:3: ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:4: ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A97FEC2D82B8311DF92DCC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:63: ( ( DOT ) | ( DDOT ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:64: ( DOT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:80: ( DOT )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:81: DOT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FD3C432B8311DF9C6BC07B8D1505E2");
                    }
                    match(input,DOT,FOLLOW_DOT_in_structure_field881); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FEC2D12B8311DFCD1EC07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:4: ( DDOT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:20: ( DDOT )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:21: DDOT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FEC2D32B8311DFB117C07B8D1505E2");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_structure_field899); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FEC2D62B8311DFB581C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "singleMultiplicity", false);_exitInjectorAction();
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
              _beforeSeqEl("E0677A9A9800498F2B8311DFB226C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:361: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
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

                if ( ((LA13_2>=FIRST_LOWERCASE_NAME && LA13_2<=FIRST_UPPERCASE_NAME)) ) {
                    alt13=1;
                }
                else if ( (LA13_2==COLON) && (synpred3_FinexClass())) {
                    alt13=2;
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:362: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:378: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:379: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A97FEC2E72B8311DFC1F5C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:438: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:439: ( (temp= firstLowercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:455: ( (temp= firstLowercaseIdentifier ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:456: (temp= firstLowercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A97FEC2DB2B8311DF97D3C07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:515: (temp= firstLowercaseIdentifier )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:517: temp= firstLowercaseIdentifier
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
                              _beforeSeqEl("E0677A9A97FEC2DE2B8311DFA77BC07B8D1505E2");
                            }
                            if ( state.backtracking==0 ) {
                              _enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:4: ( (temp= firstUppercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:20: ( (temp= firstUppercaseIdentifier ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:21: (temp= firstUppercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A97FEC2E22B8311DFB14FC07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:80: (temp= firstUppercaseIdentifier )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:82: temp= firstUppercaseIdentifier
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
                              _beforeSeqEl("E0677A9A97FEC2E52B8311DFCB84C07B8D1505E2");
                            }
                            if ( state.backtracking==0 ) {
                              _enterInjectorAction();setProperty(ret, "mandatory", true);_exitInjectorAction();
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
                      _beforeSeqEl("E0677A9A97FEC2F42B8311DF83E2C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:411: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:412: ( (temp= firstLowercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:428: ( (temp= firstLowercaseIdentifier ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:429: (temp= firstLowercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A97FEC2EC2B8311DFAC62C07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:488: (temp= firstLowercaseIdentifier )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:490: temp= firstLowercaseIdentifier
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:4: ( (temp= firstUppercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:20: ( (temp= firstUppercaseIdentifier ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:21: (temp= firstUppercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A97FEC2F22B8311DF9343C07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:80: (temp= firstUppercaseIdentifier )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:82: temp= firstUppercaseIdentifier
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
                      _beforeSeqEl("E0677A9A97FEC2F52B8311DF9BC2C07B8D1505E2");
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
                      _beforeSeqEl("E0677A9A980049792B8311DFC852C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:410: ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () )
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
                    case 73:
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:411: ( 'DEFAULT' (temp= behavior_expressions_expression )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:427: ( 'DEFAULT' (temp= behavior_expressions_expression )? )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:428: 'DEFAULT' (temp= behavior_expressions_expression )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980049702B8311DFB231C07B8D1505E2");
                            }
                            match(input,42,FOLLOW_42_in_structure_field1011); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980049722B8311DFB364C07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:571: (temp= behavior_expressions_expression )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>=FIRST_LOWERCASE_NAME && LA9_0<=DATE)||LA9_0==LBRACKET||LA9_0==DOT||LA9_0==LPAREN||(LA9_0>=50 && LA9_0<=51)||LA9_0==60||(LA9_0>=70 && LA9_0<=73)) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:573: temp= behavior_expressions_expression
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:4: ( ASSIGN (temp= behavior_expressions_expression )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:20: ( ASSIGN (temp= behavior_expressions_expression )? )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:21: ASSIGN (temp= behavior_expressions_expression )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980049742B8311DF9951C07B8D1505E2");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1037); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980049762B8311DFBC3AC07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:163: (temp= behavior_expressions_expression )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>=FIRST_LOWERCASE_NAME && LA10_0<=DATE)||LA10_0==LBRACKET||LA10_0==DOT||LA10_0==LPAREN||(LA10_0>=50 && LA10_0<=51)||LA10_0==60||(LA10_0>=70 && LA10_0<=73)) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:165: temp= behavior_expressions_expression
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(2);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:20: ()
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:21: 
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:4: ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:46: ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:47: (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9800497D2B8311DFB7F8C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:106: (temp= structure_type_field )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:108: temp= structure_type_field
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
                      _beforeSeqEl("E0677A9A980049802B8311DFCA36C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.type.name", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980049812B8311DF873CC07B8D1505E2");
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
                      _beforeSeqEl("E0677A9A9800498D2B8311DFA361C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:513: ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () )
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
                    case 73:
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:514: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:530: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:531: 'DEFAULT' (temp= behavior_expressions_expression )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980049822B8311DFB47CC07B8D1505E2");
                            }
                            match(input,42,FOLLOW_42_in_structure_field1106); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980049852B8311DF886CC07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:674: (temp= behavior_expressions_expression )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:676: temp= behavior_expressions_expression
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:4: ( ASSIGN (temp= behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:20: ( ASSIGN (temp= behavior_expressions_expression ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:21: ASSIGN (temp= behavior_expressions_expression )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980049872B8311DFCD48C07B8D1505E2");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1130); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A9800498A2B8311DFC6CFC07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:163: (temp= behavior_expressions_expression )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:165: temp= behavior_expressions_expression
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(2);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:20: ()
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:21: 
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
              _beforeSeqEl("E0677A9A980049922B8311DF9016C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:413:1: structure_field_opposite returns [Object ret2] : ( (temp= firstLowercaseIdentifier ) ) ;
    public final Object structure_field_opposite() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"opposite");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:418:3: ( ( (temp= firstLowercaseIdentifier ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:3: ( (temp= firstLowercaseIdentifier ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:3: ( (temp= firstLowercaseIdentifier ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:4: (temp= firstLowercaseIdentifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9801D0122B8311DF8301C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:63: (temp= firstLowercaseIdentifier )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:65: temp= firstLowercaseIdentifier
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
              _beforeSeqEl("E0677A9A9801D01B2B8311DFC9EAC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.association.clazz", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:427:1: structure_field_nondeclaredOpposite returns [Object ret2] : () ;
    public final Object structure_field_nondeclaredOpposite() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"nondeclaredOpposite");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:432:3: ( () )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:3: ()
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:3: ()
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A980356BA2B8311DFC90AC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "");_exitInjectorAction();_enterInjectorAction();setProperty(ret, "navigable", false);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.association.clazz", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:441:1: askey[Object ret] : ( ( ( 'AS' 'KEY' ) | ) ) ;
    public final void askey(Object ret) throws RecognitionException {
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:3: ( ( ( ( 'AS' 'KEY' ) | ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:3: ( ( ( 'AS' 'KEY' ) | ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:3: ( ( ( 'AS' 'KEY' ) | ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:4: ( ( 'AS' 'KEY' ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9807EA942B8311DFC6D4C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:64: ( ( 'AS' 'KEY' ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==43) ) {
                alt14=1;
            }
            else if ( (LA14_0==EOF||LA14_0==SEMICOLON||LA14_0==ASSIGN||LA14_0==RPAREN||(LA14_0>=41 && LA14_0<=42)||LA14_0==48||LA14_0==73) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:65: ( 'AS' 'KEY' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:81: ( 'AS' 'KEY' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:82: 'AS' 'KEY'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9807EA912B8311DFB7D1C07B8D1505E2");
                    }
                    match(input,43,FOLLOW_43_in_askey1294); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9807EA922B8311DF850DC07B8D1505E2");
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:309: 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:451:1: behavior_functions_function returns [Object ret2] : ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) ) ;
    public final Object behavior_functions_function() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","functions","Function");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:3: ( ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:3: ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:3: ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:4: ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9809713B2B8311DFAAEFC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:63: ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:64: ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:80: ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:81: 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980971302B8311DFC9AFC07B8D1505E2");
                    }
                    match(input,45,FOLLOW_45_in_behavior_functions_function1347); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980971312B8311DF9073C07B8D1505E2");
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
                      _beforeSeqEl("E0677A9A980971332B8311DF9AEBC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:319: (temp= behavior_functions_signatureimplementation )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:321: temp= behavior_functions_signatureimplementation
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:4: ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:20: ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:21: 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980971352B8311DF993FC07B8D1505E2");
                    }
                    match(input,46,FOLLOW_46_in_behavior_functions_function1374); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980971362B8311DF95F3C07B8D1505E2");
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
                      _beforeSeqEl("E0677A9A980971392B8311DFBDF8C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:262: (temp= behavior_functions_signatureimplementation_manipulator )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:264: temp= behavior_functions_signatureimplementation_manipulator
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:466:1: functionheader[Object ret] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON ) ;
    public final void functionheader(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:467:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A980AF7D82B8311DFB44EC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980971412B8311DFBFC1C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:140: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:142: temp= firstLowercaseIdentifier
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980AF7D22B8311DF8E41C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:82: temp= firstUppercaseIdentifier
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:20: ()
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:21: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980AF7D62B8311DF830FC07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "name", "");_exitInjectorAction();
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
              _beforeSeqEl("E0677A9A980AF7D92B8311DFA22CC07B8D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_functionheader1481); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A980C7E732B8311DFC2B1C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:346: ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:347: ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:363: ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:364: 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980AF7DA2B8311DF920FC07B8D1505E2");
                    }
                    match(input,47,FOLLOW_47_in_functionheader1490); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980AF7E12B8311DFB4A2C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:502: (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:504: temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )*
                    {
                    pushFollow(FOLLOW_behavior_functions_parameter_IN_in_functionheader1497);
                    temp=behavior_functions_parameter_IN();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:581: ( ( ',' ) temp= behavior_functions_parameter_IN )*
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
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:582: ( ',' ) temp= behavior_functions_parameter_IN
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:599: ( ',' )
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:600: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0677A9A980AF7DD2B8311DF8F09C07B8D1505E2");
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
                      _beforeSeqEl("E0677A9A980AF7ED2B8311DF8B11C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:851: ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () )
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:852: ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:868: ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:869: ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980AF7E22B8311DF896EC07B8D1505E2");
                            }
                            match(input,48,FOLLOW_48_in_functionheader1526); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980AF7E32B8311DFA1B9C07B8D1505E2");
                            }
                            match(input,49,FOLLOW_49_in_functionheader1529); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0677A9A980AF7EA2B8311DFB12DC07B8D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1086: (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1088: temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                            {
                            pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_functionheader1536);
                            temp=behavior_functions_parameter_OUT();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "parameters", temp);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1166: ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==48) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1167: ( ',' ) temp= behavior_functions_parameter_OUT
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1184: ( ',' )
                            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1185: ','
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0677A9A980AF7E62B8311DFBC85C07B8D1505E2");
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:20: ()
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:21: 
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:4: ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:20: ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:21: 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980AF7EF2B8311DF9E9EC07B8D1505E2");
                    }
                    match(input,49,FOLLOW_49_in_functionheader1585); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980C7E712B8311DF9D68C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:160: (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:162: temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                    {
                    pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_functionheader1592);
                    temp=behavior_functions_parameter_OUT();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:240: ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==48) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:241: ( ',' ) temp= behavior_functions_parameter_OUT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:258: ( ',' )
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:259: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0677A9A980AF7F22B8311DFC8F7C07B8D1505E2");
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
              _beforeSeqEl("E0677A9A980C7E742B8311DF8C1EC07B8D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_functionheader1622); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A980C7E752B8311DF9F75C07B8D1505E2");
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:479:1: parameter[Object ret] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) ) ;
    public final void parameter(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:480:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A980E05182B8311DF81BAC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980E05122B8311DF9699C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:140: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:142: temp= firstLowercaseIdentifier
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980E05162B8311DFB03FC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:82: temp= firstUppercaseIdentifier
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
              _beforeSeqEl("E0677A9A980E05252B8311DFA08BC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:253: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:254: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:270: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:271: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980E051D2B8311DF94BFC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:330: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:332: temp= firstLowercaseIdentifier
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980E05232B8311DFC0A7C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:82: temp= firstUppercaseIdentifier
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
              _beforeSeqEl("E0677A9A980F8BB72B8311DFCCC5C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:326: ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:327: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:343: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:344: 'DEFAULT' (temp= behavior_expressions_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980F8BB32B8311DF9FE7C07B8D1505E2");
                    }
                    match(input,42,FOLLOW_42_in_parameter1738); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A980F8BB52B8311DF867CC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:487: (temp= behavior_expressions_expression )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:489: temp= behavior_expressions_expression
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:602: 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:491:1: behavior_functions_parameter_IN returns [Object ret2] : ( parameter[ret] ) ;
    public final Object behavior_functions_parameter_IN() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","functions","Parameter");
        onEnterTemplateRule(metaType,"IN");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:496:3: ( ( parameter[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:3: ( parameter[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:3: ( parameter[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:4: parameter[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A981112502B8311DFA553C07B8D1505E2");
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
              _beforeSeqEl("E0677A9A981112532B8311DF9B2CC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "direction", behavior.functions.DirectionEnum.IN);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:505:1: behavior_functions_parameter_OUT returns [Object ret2] : ( parameter[ret] ) ;
    public final Object behavior_functions_parameter_OUT() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","functions","Parameter");
        onEnterTemplateRule(metaType,"OUT");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:510:3: ( ( parameter[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:3: ( parameter[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:3: ( parameter[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:4: parameter[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A981298F02B8311DFC3E9C07B8D1505E2");
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
              _beforeSeqEl("E0677A9A981298F32B8311DFB84BC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "direction", behavior.functions.DirectionEnum.OUT);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:519:1: behavior_functions_signatureimplementation returns [Object ret2] : (ret= behavior_actions_block ) ;
    public final Object behavior_functions_signatureimplementation() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:520:3: ( (ret= behavior_actions_block ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:3: (ret= behavior_actions_block )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:3: (ret= behavior_actions_block )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:4: ret= behavior_actions_block
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:528:1: behavior_actions_block returns [Object ret2] : ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL ) ;
    public final Object behavior_actions_block() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:533:3: ( ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:3: ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:3: ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:4: LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9815A6302B8311DF98D9C07B8D1505E2");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_block1907); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9815A6342B8311DFA266C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:145: ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:147: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9815A6322B8311DF9B7DC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:206: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=FIRST_LOWERCASE_NAME && LA26_0<=DATE)||LA26_0==LBRACKET||LA26_0==DOT||LA26_0==LPAREN||(LA26_0>=50 && LA26_0<=51)||LA26_0==60||(LA26_0>=70 && LA26_0<=73)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:208: temp= behavior_actions_statement (temp= behavior_actions_statement )*
                    {
                    pushFollow(FOLLOW_behavior_actions_statement_in_behavior_actions_block1918);
                    temp=behavior_actions_statement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "statements", temp);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:280: (temp= behavior_actions_statement )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=FIRST_LOWERCASE_NAME && LA25_0<=DATE)||LA25_0==LBRACKET||LA25_0==DOT||LA25_0==LPAREN||(LA25_0>=50 && LA25_0<=51)||LA25_0==60||(LA25_0>=70 && LA25_0<=73)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:282: temp= behavior_actions_statement
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
              _beforeSeqEl("E0677A9A9815A6352B8311DFC60BC07B8D1505E2");
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:542:1: behavior_functions_signatureimplementation_manipulator returns [Object ret2] : (ret= behavior_actions_manipulator_manipulator ) ;
    public final Object behavior_functions_signatureimplementation_manipulator() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:543:3: ( (ret= behavior_actions_manipulator_manipulator ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:3: (ret= behavior_actions_manipulator_manipulator )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:3: (ret= behavior_actions_manipulator_manipulator )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:4: ret= behavior_actions_manipulator_manipulator
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:551:1: behavior_actions_manipulator_manipulator returns [Object ret2] : ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL ) ;
    public final Object behavior_actions_manipulator_manipulator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","Manipulator");
        onEnterTemplateRule(metaType,"manipulator");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:556:3: ( ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:3: ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:3: ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:4: LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98172CD02B8311DF8698C07B8D1505E2");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_manipulator_manipulator2010); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98172CD82B8311DFC844C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:145: ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:146: ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:146: ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:147: (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98172CD62B8311DF8122C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:206: (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:208: temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )*
            {
            pushFollow(FOLLOW_behavior_actions_assignment_manipulator_in_behavior_actions_manipulator_manipulator2021);
            temp=behavior_actions_assignment_manipulator();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "assignments", temp);
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:294: ( ( PIPE ) temp= behavior_actions_assignment_manipulator )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==PIPE) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:295: ( PIPE ) temp= behavior_actions_assignment_manipulator
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:312: ( PIPE )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:313: PIPE
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A98172CD32B8311DFAAFDC07B8D1505E2");
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
              _beforeSeqEl("E0677A9A98172CD92B8311DF882FC07B8D1505E2");
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:565:1: behavior_actions_statement returns [Object ret2] : (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement ) ;
    public final Object behavior_actions_statement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:566:3: ( (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==DOT) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==FIRST_LOWERCASE_NAME) ) {
                    int LA28_3 = input.LA(3);

                    if ( ((LA28_3>=SEMICOLON && LA28_3<=LBRACKET)||LA28_3==DOT||(LA28_3>=RANGLE && LA28_3<=EQUALSEQUALS)||LA28_3==43||LA28_3==50||(LA28_3>=52 && LA28_3<=59)) ) {
                        alt28=2;
                    }
                    else if ( (LA28_3==EQUALS) ) {
                        alt28=1;
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
            else if ( ((LA28_0>=FIRST_LOWERCASE_NAME && LA28_0<=DATE)||LA28_0==LBRACKET||LA28_0==LPAREN||(LA28_0>=50 && LA28_0<=51)||LA28_0==60||(LA28_0>=70 && LA28_0<=73)) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:4: ret= behavior_actions_statementwithargument
                    {
                    pushFollow(FOLLOW_behavior_actions_statementwithargument_in_behavior_actions_statement2089);
                    ret=behavior_actions_statementwithargument();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:568:5: ret= behavior_actions_expressionstatement
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:575:1: behavior_actions_statementwithargument returns [Object ret2] : ( ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment ) ) ;
    public final Object behavior_actions_statementwithargument() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:576:3: ( ( ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:3: ( ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:3: ( ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:4: ( DOT ( FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME ) EQUALS )=> (ret= behavior_actions_assignment )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:64: (ret= behavior_actions_assignment )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:65: ret= behavior_actions_assignment
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:584:1: behavior_actions_assignment returns [Object ret2] : ( assignment[ret] SEMICOLON ) ;
    public final Object behavior_actions_assignment() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","actions","Assignment");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:3: ( ( assignment[ret] SEMICOLON ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:3: ( assignment[ret] SEMICOLON )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:3: ( assignment[ret] SEMICOLON )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:4: assignment[ret] SEMICOLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A981D47502B8311DF92ECC07B8D1505E2");
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
              _beforeSeqEl("E0677A9A981D47512B8311DFBB5EC07B8D1505E2");
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:598:1: behavior_actions_assignment_manipulator returns [Object ret2] : ( assignment[ret] ) ;
    public final Object behavior_actions_assignment_manipulator() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","actions","Assignment");
        onEnterTemplateRule(metaType,"manipulator");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:603:3: ( ( assignment[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:3: ( assignment[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:3: ( assignment[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:4: assignment[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A981D47552B8311DF830EC07B8D1505E2");
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:612:1: assignment[Object ret] : ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? ) ;
    public final void assignment(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:613:3: ( ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:4: DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A981D47592B8311DF9BB7C07B8D1505E2");
            }
            match(input,DOT,FOLLOW_DOT_in_assignment2252); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A981ECDF62B8311DF9745C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:143: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:144: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:160: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:161: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A981D475E2B8311DF8A25C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:220: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:222: temp= firstLowercaseIdentifier
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A981ECDF42B8311DF93ACC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:82: temp= firstUppercaseIdentifier
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
              _beforeSeqEl("E0677A9A981ECDF72B8311DFAC27C07B8D1505E2");
            }
            match(input,EQUALS,FOLLOW_EQUALS_in_assignment2297); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A981ECDF92B8311DFA2A8C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:418: (temp= behavior_expressions_expression )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=FIRST_LOWERCASE_NAME && LA30_0<=DATE)||LA30_0==LBRACKET||LA30_0==DOT||LA30_0==LPAREN||(LA30_0>=50 && LA30_0<=51)||LA30_0==60||(LA30_0>=70 && LA30_0<=73)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:420: temp= behavior_expressions_expression
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:1: behavior_actions_expressionstatement returns [Object ret2] : ( (temp= behavior_expressions_expression ) SEMICOLON ) ;
    public final Object behavior_actions_expressionstatement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","ExpressionStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:627:3: ( ( (temp= behavior_expressions_expression ) SEMICOLON ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:3: ( (temp= behavior_expressions_expression ) SEMICOLON )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:3: ( (temp= behavior_expressions_expression ) SEMICOLON )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:4: (temp= behavior_expressions_expression ) SEMICOLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A982054912B8311DF8ADCC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:63: (temp= behavior_expressions_expression )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:65: temp= behavior_expressions_expression
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
              _beforeSeqEl("E0677A9A982054922B8311DF8948C07B8D1505E2");
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:636:1: primary_behavior_expressions_expression returns [Object ret2] : (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_oql_oqlquery | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ret= behavior_expressions_literals_multiobjectliteral | ret= behavior_expressions_all | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) ;
    public final Object primary_behavior_expressions_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:637:3: ( (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_oql_oqlquery | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ret= behavior_expressions_literals_multiobjectliteral | ret= behavior_expressions_all | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:3: (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_oql_oqlquery | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ret= behavior_expressions_literals_multiobjectliteral | ret= behavior_expressions_all | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:3: (ret= behavior_expressions_namedvalueexpression | ret= behavior_expressions_oql_oqlquery | ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ret= behavior_expressions_literals_multiobjectliteral | ret= behavior_expressions_all | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            int alt31=9;
            switch ( input.LA(1) ) {
            case FIRST_LOWERCASE_NAME:
            case FIRST_UPPERCASE_NAME:
                {
                alt31=1;
                }
                break;
            case 72:
            case 73:
                {
                alt31=2;
                }
                break;
            case 70:
                {
                alt31=3;
                }
                break;
            case STRING:
            case INT:
            case FLOAT:
            case BOOL:
            case BINARY:
            case DATE:
                {
                alt31=4;
                }
                break;
            case DOT:
                {
                alt31=5;
                }
                break;
            case 71:
                {
                alt31=6;
                }
                break;
            case LBRACKET:
                {
                alt31=7;
                }
                break;
            case 60:
                {
                alt31=8;
                }
                break;
            case LPAREN:
                {
                alt31=9;
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:4: ret= behavior_expressions_namedvalueexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_namedvalueexpression_in_primary_behavior_expressions_expression2389);
                    ret=behavior_expressions_namedvalueexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:639:5: ret= behavior_expressions_oql_oqlquery
                    {
                    pushFollow(FOLLOW_behavior_expressions_oql_oqlquery_in_primary_behavior_expressions_expression2397);
                    ret=behavior_expressions_oql_oqlquery();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:5: ret= behavior_expressions_objectcreationexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_objectcreationexpression_in_primary_behavior_expressions_expression2405);
                    ret=behavior_expressions_objectcreationexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:641:5: ret= behavior_expressions_literals_literal
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2413);
                    ret=behavior_expressions_literals_literal();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:642:5: ret= behavior_expressions_firstpathexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2421);
                    ret=behavior_expressions_firstpathexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:5: ret= behavior_expressions_this
                    {
                    pushFollow(FOLLOW_behavior_expressions_this_in_primary_behavior_expressions_expression2429);
                    ret=behavior_expressions_this();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:644:5: ret= behavior_expressions_literals_multiobjectliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_multiobjectliteral_in_primary_behavior_expressions_expression2437);
                    ret=behavior_expressions_literals_multiobjectliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:645:5: ret= behavior_expressions_all
                    {
                    pushFollow(FOLLOW_behavior_expressions_all_in_primary_behavior_expressions_expression2445);
                    ret=behavior_expressions_all();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 9 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:6: LPAREN ret= behavior_expressions_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_behavior_expressions_expression2454); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2460);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_behavior_expressions_expression2464); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:653:1: expressions_priority_0 returns [Object ret2] : ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object expressions_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:3: ( ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=50 && LA35_0<=51)) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=FIRST_LOWERCASE_NAME && LA35_0<=DATE)||LA35_0==LBRACKET||LA35_0==DOT||LA35_0==LPAREN||LA35_0==60||(LA35_0>=70 && LA35_0<=73)) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:6: ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:13: ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:14: '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("-", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,50,FOLLOW_50_in_expressions_priority_02505); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "-";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:94: ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:96: ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02512);
                            ret=behavior_expressions_unaryminus(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02516);
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
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:3: ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:12: ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:13: 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("not", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,51,FOLLOW_51_in_expressions_priority_02533); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "not";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:99: ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:101: ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_not_in_expressions_priority_02540);
                            ret=behavior_expressions_not(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02544);
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:4: ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
                    {
                    pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02560);
                    ret=primary_behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:47: ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
                    loop34:
                    do {
                        int alt34=3;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==DOT) ) {
                            int LA34_2 = input.LA(2);

                            if ( (synpred7_FinexClass()) ) {
                                alt34=1;
                            }


                        }
                        else if ( (LA34_0==LBRACKET) ) {
                            int LA34_3 = input.LA(2);

                            if ( (synpred8_FinexClass()) ) {
                                alt34=2;
                            }


                        }


                        switch (alt34) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:48: ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:55: ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:56: DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq(".", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,DOT,FOLLOW_DOT_in_expressions_priority_02569); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = ".";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:137: ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
                    	    int alt33=6;
                    	    switch ( input.LA(1) ) {
                    	    case 61:
                    	    case 62:
                    	    case 63:
                    	        {
                    	        alt33=1;
                    	        }
                    	        break;
                    	    case 64:
                    	        {
                    	        alt33=2;
                    	        }
                    	        break;
                    	    case 65:
                    	        {
                    	        alt33=3;
                    	        }
                    	        break;
                    	    case LPAREN:
                    	        {
                    	        alt33=4;
                    	        }
                    	        break;
                    	    case 66:
                    	    case 67:
                    	    case 68:
                    	    case 69:
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
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:139: ret= behavior_expressions_booleanaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02577);
                    	            ret=behavior_expressions_booleanaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            {
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:4: ret= behavior_expressions_count[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_count_in_expressions_priority_02586);
                    	            ret=behavior_expressions_count(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            {
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:4: ret= behavior_expressions_single[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_single_in_expressions_priority_02595);
                    	            ret=behavior_expressions_single(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:3: (ret= behavior_expressions_tuple[opName, ret, firstToken] )
                    	            {
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:3: (ret= behavior_expressions_tuple[opName, ret, firstToken] )
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:4: ret= behavior_expressions_tuple[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_tuple_in_expressions_priority_02604);
                    	            ret=behavior_expressions_tuple(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:4: ret= behavior_expressions_numericaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02613);
                    	            ret=behavior_expressions_numericaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 6 :
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:667:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            {
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:667:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:667:4: ret= behavior_expressions_pathexpression[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02622);
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
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:3: ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:15: ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:16: LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq("[", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_expressions_priority_02638); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = "[";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:102: ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    {
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:104: ret= behavior_expressions_filterexpression[opName, ret, firstToken]
                    	    {
                    	    pushFollow(FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02646);
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
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "expressions_priority_0"


    // $ANTLR start "expressions_priority_1"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:676:1: expressions_priority_1 returns [Object ret2] : ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) ;
    public final Object expressions_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:3: ( ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:8: ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12692);
            ret=expressions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:34: ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            loop36:
            do {
                int alt36=4;
                switch ( input.LA(1) ) {
                case 52:
                    {
                    int LA36_2 = input.LA(2);

                    if ( (synpred9_FinexClass()) ) {
                        alt36=1;
                    }


                    }
                    break;
                case 53:
                    {
                    int LA36_3 = input.LA(2);

                    if ( (synpred10_FinexClass()) ) {
                        alt36=2;
                    }


                    }
                    break;
                case 54:
                    {
                    int LA36_4 = input.LA(2);

                    if ( (synpred11_FinexClass()) ) {
                        alt36=3;
                    }


                    }
                    break;

                }

                switch (alt36) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:35: ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:42: ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:43: '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("*", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,52,FOLLOW_52_in_expressions_priority_12701); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "*";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:123: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:125: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12708);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12712);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:3: ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:10: ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:11: '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("/", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,53,FOLLOW_53_in_expressions_priority_12729); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "/";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12736);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12740);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:3: ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:12: ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:13: 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("AND", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,54,FOLLOW_54_in_expressions_priority_12757); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "AND";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:99: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:101: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12764);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12768);
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
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "expressions_priority_1"


    // $ANTLR start "expressions_priority_2"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:694:1: expressions_priority_2 returns [Object ret2] : ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) ;
    public final Object expressions_priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:3: ( ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:8: ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22815);
            ret=expressions_priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:34: ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            loop37:
            do {
                int alt37=4;
                switch ( input.LA(1) ) {
                case 55:
                    {
                    int LA37_2 = input.LA(2);

                    if ( (synpred12_FinexClass()) ) {
                        alt37=1;
                    }


                    }
                    break;
                case 56:
                    {
                    int LA37_3 = input.LA(2);

                    if ( (synpred13_FinexClass()) ) {
                        alt37=2;
                    }


                    }
                    break;
                case 50:
                    {
                    int LA37_4 = input.LA(2);

                    if ( (synpred14_FinexClass()) ) {
                        alt37=3;
                    }


                    }
                    break;

                }

                switch (alt37) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:35: ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:43: ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:44: 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("OR", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,55,FOLLOW_55_in_expressions_priority_22824); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "OR";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:127: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:129: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22831);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22835);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:3: ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:10: ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:11: '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,56,FOLLOW_56_in_expressions_priority_22852); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22859);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22863);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:3: ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:10: ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:11: '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("-", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,50,FOLLOW_50_in_expressions_priority_22880); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "-";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22887);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22891);
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
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "expressions_priority_2"


    // $ANTLR start "expressions_priority_3"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:1: expressions_priority_3 returns [Object ret2] : ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) ;
    public final Object expressions_priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:3: ( ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:8: ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32938);
            ret=expressions_priority_2();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:34: ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
            loop38:
            do {
                int alt38=7;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:35: ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:45: ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:46: RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,RANGLE,FOLLOW_RANGLE_in_expressions_priority_32947); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:130: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:132: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32955);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32959);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:3: ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:13: ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:14: LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LANGLE,FOLLOW_LANGLE_in_expressions_priority_32976); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:98: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:100: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32984);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32988);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:3: ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:11: ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:12: '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,57,FOLLOW_57_in_expressions_priority_33005); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33012);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33016);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:3: ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:11: ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:12: '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,58,FOLLOW_58_in_expressions_priority_33033); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33040);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33044);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:3: ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:19: ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:20: EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("==", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQUALSEQUALS,FOLLOW_EQUALSEQUALS_in_expressions_priority_33061); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "==";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:112: ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:113: (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:113: (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:114: ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_equals_in_expressions_priority_33069);
            	    ret=behavior_expressions_equals(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33073);
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
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:3: ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:11: ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:12: '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("!=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,59,FOLLOW_59_in_expressions_priority_33090); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "!=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:95: ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:96: (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:96: (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:97: ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_unequals_in_expressions_priority_33097);
            	    ret=behavior_expressions_unequals(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33101);
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
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "expressions_priority_3"


    // $ANTLR start "behavior_expressions_expression"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:739:1: behavior_expressions_expression returns [Object ret2] : ret= expressions_priority_3 ;
    public final Object behavior_expressions_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:740:3: (ret= expressions_priority_3 )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:741:3: ret= expressions_priority_3
            {
            pushFollow(FOLLOW_expressions_priority_3_in_behavior_expressions_expression3139);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:748:1: alias[Object ret] : ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) ) ;
    public final void alias(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:749:3: ( ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:3: ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:3: ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:4: ( ( 'AS' (temp= behavior_expressions_alias ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9824E8772B8311DF9EB9C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:64: ( ( 'AS' (temp= behavior_expressions_alias ) ) | )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==43) ) {
                alt39=1;
            }
            else if ( (LA39_0==EOF||(LA39_0>=FIRST_LOWERCASE_NAME && LA39_0<=DATE)||(LA39_0>=SEMICOLON && LA39_0<=DOT)||(LA39_0>=LPAREN && LA39_0<=RPAREN)||(LA39_0>=RCURL && LA39_0<=PIPE)||(LA39_0>=RANGLE && LA39_0<=EQUALSEQUALS)||LA39_0==41||LA39_0==48||(LA39_0>=50 && LA39_0<=60)||(LA39_0>=70 && LA39_0<=73)||LA39_0==75) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:65: ( 'AS' (temp= behavior_expressions_alias ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:81: ( 'AS' (temp= behavior_expressions_alias ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:82: 'AS' (temp= behavior_expressions_alias )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9824E8732B8311DF9D5EC07B8D1505E2");
                    }
                    match(input,43,FOLLOW_43_in_alias3168); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9824E8752B8311DFC71BC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:220: (temp= behavior_expressions_alias )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:222: temp= behavior_expressions_alias
                    {
                    pushFollow(FOLLOW_behavior_expressions_alias_in_alias3175);
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:750:323: 
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:758:1: behavior_expressions_alias returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_alias() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Alias");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:763:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9824E8822B8311DF9F4EC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9824E87C2B8311DFA1D8C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:140: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:764:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias3230);
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:765:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:765:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:765:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9824E8802B8311DF87B3C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:765:80: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:765:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias3250);
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
              _beforeSeqEl("E0677A9A98266F122B8311DF99C9C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:aliasFor.type", true);_exitInjectorAction();
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


    // $ANTLR start "behavior_expressions_all"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:773:1: behavior_expressions_all returns [Object ret2] : ( 'all' (temp= firstUppercaseIdentifier ) ) ;
    public final Object behavior_expressions_all() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","All");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:778:3: ( ( 'all' (temp= firstUppercaseIdentifier ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:779:3: ( 'all' (temp= firstUppercaseIdentifier ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:779:3: ( 'all' (temp= firstUppercaseIdentifier ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:779:4: 'all' (temp= firstUppercaseIdentifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98266F162B8311DFB369C07B8D1505E2");
            }
            match(input,60,FOLLOW_60_in_behavior_expressions_all3301); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98266F1B2B8311DF80B4C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:779:143: (temp= firstUppercaseIdentifier )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:779:145: temp= firstUppercaseIdentifier
            {
            pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_all3308);
            temp=firstUppercaseIdentifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "clazz", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98266F1E2B8311DFC6F2C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.clazz", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_all"


    // $ANTLR start "behavior_expressions_binarybooleanoperator"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:787:1: behavior_expressions_binarybooleanoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_binarybooleanoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryBooleanOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:792:3: ( ( alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:793:3: ( alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:793:3: ( alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:793:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98297C532B8311DFAD9BC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_binarybooleanoperator3355);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98297C562B8311DF96CCC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:803:1: behavior_expressions_not[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_not(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Not");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:3: ( ( alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:3: ( alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:3: ( alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A982B02F12B8311DFC206C07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_not3392);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A982B02F42B8311DFB69FC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:819:1: behavior_expressions_booleanaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_booleanaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BooleanAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:824:3: ( ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:4: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A982E10402B8311DFB784C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:63: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
            int alt41=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt41=1;
                }
                break;
            case 62:
                {
                alt41=2;
                }
                break;
            case 63:
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:64: ( 'and' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:80: ( 'and' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:81: 'and'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A982E10312B8311DF8E88C07B8D1505E2");
                    }
                    match(input,61,FOLLOW_61_in_behavior_expressions_booleanaggregate3434); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A982E10342B8311DFB9EBC07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "operator", "and");_exitInjectorAction();
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:826:4: ( 'or' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:826:20: ( 'or' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:826:21: 'or'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A982E10362B8311DF989EC07B8D1505E2");
                    }
                    match(input,62,FOLLOW_62_in_behavior_expressions_booleanaggregate3450); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A982E10392B8311DFBD18C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "operator", "or");_exitInjectorAction();
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:827:4: ( 'xor' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:827:20: ( 'xor' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:827:21: 'xor'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A982E103B2B8311DF8F59C07B8D1505E2");
                    }
                    match(input,63,FOLLOW_63_in_behavior_expressions_booleanaggregate3466); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A982E103E2B8311DFA1F1C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "operator", "xor");_exitInjectorAction();
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
              _beforeSeqEl("E0677A9A982E10412B8311DFB348C07B8D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate3478); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A982E10422B8311DFC945C07B8D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate3483); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A982E10432B8311DFC931C07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_booleanaggregate3487);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A982F96D02B8311DFCE38C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:837:1: behavior_expressions_equals[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_equals(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Equals");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:842:3: ( ( alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:843:3: ( alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:843:3: ( alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:843:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9832A4122B8311DF9AF2C07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_equals3524);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9832A4152B8311DF81D6C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:853:1: behavior_expressions_unequals[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_unequals(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Unequals");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:858:3: ( ( alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:859:3: ( alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:859:3: ( alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:859:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98342AB22B8311DFB9FEC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_unequals3561);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98342AB52B8311DFAB6AC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:869:1: behavior_expressions_binarynumericoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_binarynumericoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryNumericOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:874:3: ( ( alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:875:3: ( alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:875:3: ( alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:875:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9835B1532B8311DF94FCC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_binarynumericoperator3598);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983737F02B8311DFA9C1C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:if self.operator = '+' or"+"		                         self.operator = '-' or"+"		                         self.operator = '*' or"+"		                         self.operator = '/' then"+"		                            self.numericPostType(self.operator, self.left.type, self.right.type)"+"		                      else"+"		                        structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')->asSequence()->first()"+"		                      endif", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:885:1: behavior_expressions_unaryminus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_unaryminus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","UnaryMinus");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:890:3: ( ( alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:891:3: ( alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:891:3: ( alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:891:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9838BE922B8311DF890AC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_unaryminus3635);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9838BE952B8311DF9A9BC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:901:1: behavior_expressions_count[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'count' LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_count(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Count");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:906:3: ( ( 'count' LPAREN RPAREN alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:907:3: ( 'count' LPAREN RPAREN alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:907:3: ( 'count' LPAREN RPAREN alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:907:4: 'count' LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983A45312B8311DF989FC07B8D1505E2");
            }
            match(input,64,FOLLOW_64_in_behavior_expressions_count3672); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983A45342B8311DFC95BC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983A45352B8311DFC2E5C07B8D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_count3679); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983A45362B8311DFC675C07B8D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_count3684); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983A45372B8311DFCFE4C07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_count3688);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:917:1: behavior_expressions_single[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'single' LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_single(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Single");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:922:3: ( ( 'single' LPAREN RPAREN alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:923:3: ( 'single' LPAREN RPAREN alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:923:3: ( 'single' LPAREN RPAREN alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:923:4: 'single' LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983BCBD12B8311DF92CDC07B8D1505E2");
            }
            match(input,65,FOLLOW_65_in_behavior_expressions_single3722); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983BCBD42B8311DFBDA2C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983BCBD52B8311DFB393C07B8D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_single3729); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983BCBD62B8311DFB663C07B8D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_single3734); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983BCBD72B8311DFAC27C07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_single3738);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:933:1: behavior_expressions_tuple[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] ) ;
    public final Object behavior_expressions_tuple(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Tuple");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:938:3: ( ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:939:3: ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:939:3: ( LPAREN (temp= structure_type_tuple ) RPAREN alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:939:4: LPAREN (temp= structure_type_tuple ) RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983D52712B8311DFBD33C07B8D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_tuple3773); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983D52742B8311DFB79BC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:939:146: (temp= structure_type_tuple )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:939:148: temp= structure_type_tuple
            {
            pushFollow(FOLLOW_structure_type_tuple_in_behavior_expressions_tuple3781);
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
              _beforeSeqEl("E0677A9A983ED9102B8311DFBE87C07B8D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_tuple3788); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983ED9112B8311DF8434C07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_tuple3792);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:949:1: structure_type_tuple returns [Object ret2] : (ret= structure_finexclass_tuple ) ;
    public final Object structure_type_tuple() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:950:3: ( (ret= structure_finexclass_tuple ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:951:3: (ret= structure_finexclass_tuple )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:951:3: (ret= structure_finexclass_tuple )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:951:4: ret= structure_finexclass_tuple
            {
            pushFollow(FOLLOW_structure_finexclass_tuple_in_structure_type_tuple3822);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:958:1: structure_finexclass_tuple returns [Object ret2] : ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) ) ;
    public final Object structure_finexclass_tuple() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:963:3: ( ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:3: ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:3: ( (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:4: (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A983ED91D2B8311DF8FEEC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:63: (temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:65: temp= structure_association_tuple ( ( ',' ) temp= structure_association_tuple )*
            {
            pushFollow(FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3856);
            temp=structure_association_tuple();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "associations", temp);
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:140: ( ( ',' ) temp= structure_association_tuple )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==48) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:141: ( ',' ) temp= structure_association_tuple
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:158: ( ',' )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:964:159: ','
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A983ED9192B8311DFCAECC07B8D1505E2");
            	    }
            	    match(input,48,FOLLOW_48_in_structure_finexclass_tuple3864); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3871);
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
              _beforeSeqEl("E0677A9A983ED9242B8311DFC501C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.typedElement->select(te|te.oclIsKindOf(\"Tuple\")).oclAsType(\"Tuple\").operand.getAllVisibleAliases()->iterate("+"			 			a; acc='TupleType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement->select(te | te.oclIsKindOf(Expression))."+"			                   oclAsType(Expression).getEnclosingType()", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:972:1: structure_association_tuple returns [Object ret2] : ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) ) ;
    public final Object structure_association_tuple() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:977:3: ( ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:3: ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:3: ( (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:4: (temp= structure_field_tuple ) (temp= structure_field_nondeclaredOpposite )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98405FB62B8311DF822DC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:63: (temp= structure_field_tuple )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:65: temp= structure_field_tuple
            {
            pushFollow(FOLLOW_structure_field_tuple_in_structure_association_tuple3924);
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
              _beforeSeqEl("E0677A9A98405FBB2B8311DF9FBFC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:201: (temp= structure_field_nondeclaredOpposite )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:978:203: temp= structure_field_nondeclaredOpposite
            {
            pushFollow(FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_tuple3934);
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
              _beforeSeqEl("E0677A9A98405FBE2B8311DFAEFCC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'Tuple_to_'.concat(self.ends->first().name)", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:986:1: structure_field_tuple returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) ;
    public final Object structure_field_tuple() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:991:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9841E65E2B8311DF8B4FC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9841E6522B8311DF9428C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:140: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_structure_field_tuple3989);
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
                      _beforeSeqEl("E0677A9A9841E6552B8311DF96D5C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "mandatory", true);_exitInjectorAction();
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:993:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:993:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:993:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9841E6592B8311DFCD56C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:993:80: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:993:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field_tuple4012);
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
                      _beforeSeqEl("E0677A9A9841E65C2B8311DFC252C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();
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
              _beforeSeqEl("E0677A9A9841E65F2B8311DF8C84C07B8D1505E2");
            }
            match(input,COLON,FOLLOW_COLON_in_structure_field_tuple4027); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9841E6622B8311DFA6F9C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:993:494: (temp= behavior_expressions_expression )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:993:496: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field_tuple4035);
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
              _beforeSeqEl("E0677A9A9841E6692B8311DF9C01C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.defaultValue.type", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();
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


    // $ANTLR start "behavior_expressions_numericaggregate"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1001:1: behavior_expressions_numericaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_numericaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","NumericAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:3: ( ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:4: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9844F3A52B8311DFB7F6C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:63: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt44=1;
                }
                break;
            case 67:
                {
                alt44=2;
                }
                break;
            case 68:
                {
                alt44=3;
                }
                break;
            case 69:
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:64: ( 'sum' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:80: ( 'sum' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:81: 'sum'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9844F3912B8311DF9104C07B8D1505E2");
                    }
                    match(input,66,FOLLOW_66_in_behavior_expressions_numericaggregate4087); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9844F3942B8311DFC8B4C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "operator", "sum");_exitInjectorAction();
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1008:4: ( 'avg' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1008:20: ( 'avg' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1008:21: 'avg'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9844F3962B8311DF823AC07B8D1505E2");
                    }
                    match(input,67,FOLLOW_67_in_behavior_expressions_numericaggregate4103); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9844F3992B8311DFC8B2C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "operator", "avg");_exitInjectorAction();
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1009:4: ( 'min' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1009:20: ( 'min' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1009:21: 'min'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9844F39B2B8311DF9962C07B8D1505E2");
                    }
                    match(input,68,FOLLOW_68_in_behavior_expressions_numericaggregate4119); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9844F39E2B8311DFB269C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "operator", "min");_exitInjectorAction();
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1010:4: ( 'max' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1010:20: ( 'max' )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1010:21: 'max'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9844F3A02B8311DFAC5DC07B8D1505E2");
                    }
                    match(input,69,FOLLOW_69_in_behavior_expressions_numericaggregate4135); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9844F3A32B8311DF8D34C07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "operator", "max");_exitInjectorAction();
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
              _beforeSeqEl("E0677A9A9844F3A62B8311DF9A2EC07B8D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_numericaggregate4147); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9844F3A72B8311DF9B28C07B8D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_numericaggregate4152); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9844F3A82B8311DFCFFCC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_numericaggregate4156);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9844F3AB2B8311DF8666C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1020:1: behavior_expressions_objectcreationexpression returns [Object ret2] : ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] ) ;
    public final Object behavior_expressions_objectcreationexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","ObjectCreationExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1025:3: ( ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:3: ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:3: ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:4: 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98467A302B8311DFB935C07B8D1505E2");
            }
            match(input,70,FOLLOW_70_in_behavior_expressions_objectcreationexpression4192); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98467A352B8311DFBF67C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:146: (temp= firstUppercaseIdentifier )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:148: temp= firstUppercaseIdentifier
            {
            pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_objectcreationexpression4199);
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
              _beforeSeqEl("E0677A9A984800D22B8311DFB080C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:classToInstantiate", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984800D32B8311DFA5DBC07B8D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_objectcreationexpression4209); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984800D82B8311DFC821C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:645: (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==DOT) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:647: temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )*
                    {
                    pushFollow(FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4217);
                    temp=behavior_expressions_fieldinitializer();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "fieldInitializers", temp);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:737: ( ( ',' ) temp= behavior_expressions_fieldinitializer )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==48) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:738: ( ',' ) temp= behavior_expressions_fieldinitializer
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:755: ( ',' )
                    	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1026:756: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0677A9A984800D52B8311DFC1A1C07B8D1505E2");
                    	    }
                    	    match(input,48,FOLLOW_48_in_behavior_expressions_objectcreationexpression4225); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4232);
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
              _beforeSeqEl("E0677A9A984800D92B8311DFC465C07B8D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_objectcreationexpression4244); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984800DA2B8311DFA1EBC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_objectcreationexpression4248);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1034:1: behavior_expressions_fieldinitializer returns [Object ret2] : ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) ;
    public final Object behavior_expressions_fieldinitializer() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FieldInitializer");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1039:3: ( ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:4: DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984987702B8311DF8965C07B8D1505E2");
            }
            match(input,DOT,FOLLOW_DOT_in_behavior_expressions_fieldinitializer4290); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9849877D2B8311DF81B0C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:143: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:144: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:160: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:161: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A984987752B8311DF890AC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:220: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1040:222: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_fieldinitializer4303);
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1041:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1041:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1041:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9849877B2B8311DF949CC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1041:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1041:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_fieldinitializer4323);
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
              _beforeSeqEl("E0677A9A9849877E2B8311DF874FC07B8D1505E2");
            }
            match(input,COLON,FOLLOW_COLON_in_behavior_expressions_fieldinitializer4335); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984987802B8311DFA66EC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1041:447: (temp= behavior_expressions_expression )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1041:449: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_fieldinitializer4343);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1049:1: behavior_expressions_this returns [Object ret2] : ( 'this' alias[ret] ) ;
    public final Object behavior_expressions_this() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","This");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1054:3: ( ( 'this' alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1055:3: ( 'this' alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1055:3: ( 'this' alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1055:4: 'this' alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984B0E102B8311DF9C96C07B8D1505E2");
            }
            match(input,71,FOLLOW_71_in_behavior_expressions_this4386); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984B0E112B8311DF9F17C07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_this4389);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984B0E142B8311DFC252C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.getEnclosingType()", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1063:1: behavior_expressions_namedvalueexpression returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_namedvalueexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","NamedValueExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1068:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984B0E242B8311DFCFADC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A984B0E1C2B8311DF82BDC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:140: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1069:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_namedvalueexpression4442);
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1070:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1070:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1070:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A984B0E222B8311DFA3A5C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1070:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1070:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_namedvalueexpression4462);
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
              _beforeSeqEl("E0677A9A984C94B12B8311DFBD9AC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:namedValue.type", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1078:1: behavior_expressions_expression_pathExpression returns [Object ret2] : (ret= behavior_expressions_implicitcontext_pathExpression ) ;
    public final Object behavior_expressions_expression_pathExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1079:3: ( (ret= behavior_expressions_implicitcontext_pathExpression ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1080:3: (ret= behavior_expressions_implicitcontext_pathExpression )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1080:3: (ret= behavior_expressions_implicitcontext_pathExpression )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1080:4: ret= behavior_expressions_implicitcontext_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_implicitcontext_pathExpression_in_behavior_expressions_expression_pathExpression4510);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1087:1: behavior_expressions_implicitcontext_pathExpression returns [Object ret2] : () ;
    public final Object behavior_expressions_implicitcontext_pathExpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","ImplicitContext");
        onEnterTemplateRule(metaType,"pathExpression");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1092:3: ( () )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1093:3: ()
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1093:3: ()
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1093:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984FA1F22B8311DFA49BC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.getImplicitContextType()", true);_exitInjectorAction();
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


    // $ANTLR start "behavior_expressions_oql_oqlquery"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1101:1: behavior_expressions_oql_oqlquery returns [Object ret2] : ( ( ( 'select' (temp= structure_type_oqlQuery ) ) | ( (temp= structure_type_oqlQueryWithImplicitSelect ) ) ) 'from' (temp= behavior_expressions_oql_fromclause ( ( ',' ) temp= behavior_expressions_oql_fromclause )* ) 'where' (temp= behavior_expressions_expression ) ) ;
    public final Object behavior_expressions_oql_oqlquery() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","oql","OqlQuery");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1106:3: ( ( ( ( 'select' (temp= structure_type_oqlQuery ) ) | ( (temp= structure_type_oqlQueryWithImplicitSelect ) ) ) 'from' (temp= behavior_expressions_oql_fromclause ( ( ',' ) temp= behavior_expressions_oql_fromclause )* ) 'where' (temp= behavior_expressions_expression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:3: ( ( ( 'select' (temp= structure_type_oqlQuery ) ) | ( (temp= structure_type_oqlQueryWithImplicitSelect ) ) ) 'from' (temp= behavior_expressions_oql_fromclause ( ( ',' ) temp= behavior_expressions_oql_fromclause )* ) 'where' (temp= behavior_expressions_expression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:3: ( ( ( 'select' (temp= structure_type_oqlQuery ) ) | ( (temp= structure_type_oqlQueryWithImplicitSelect ) ) ) 'from' (temp= behavior_expressions_oql_fromclause ( ( ',' ) temp= behavior_expressions_oql_fromclause )* ) 'where' (temp= behavior_expressions_expression ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:4: ( ( 'select' (temp= structure_type_oqlQuery ) ) | ( (temp= structure_type_oqlQueryWithImplicitSelect ) ) ) 'from' (temp= behavior_expressions_oql_fromclause ( ( ',' ) temp= behavior_expressions_oql_fromclause )* ) 'where' (temp= behavior_expressions_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A984FA1FF2B8311DF9908C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:63: ( ( 'select' (temp= structure_type_oqlQuery ) ) | ( (temp= structure_type_oqlQueryWithImplicitSelect ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==72) ) {
                alt49=1;
            }
            else if ( (LA49_0==73) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:64: ( 'select' (temp= structure_type_oqlQuery ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:80: ( 'select' (temp= structure_type_oqlQuery ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:81: 'select' (temp= structure_type_oqlQuery )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A984FA1F62B8311DFB030C07B8D1505E2");
                    }
                    match(input,72,FOLLOW_72_in_behavior_expressions_oql_oqlquery4585); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A984FA1F92B8311DFC4D2C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:223: (temp= structure_type_oqlQuery )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:225: temp= structure_type_oqlQuery
                    {
                    pushFollow(FOLLOW_structure_type_oqlQuery_in_behavior_expressions_oql_oqlquery4592);
                    temp=structure_type_oqlQuery();

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

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:4: ( (temp= structure_type_oqlQueryWithImplicitSelect ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:20: ( (temp= structure_type_oqlQueryWithImplicitSelect ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:21: (temp= structure_type_oqlQueryWithImplicitSelect )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A984FA1FD2B8311DF9A8AC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:80: (temp= structure_type_oqlQueryWithImplicitSelect )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:82: temp= structure_type_oqlQueryWithImplicitSelect
                    {
                    pushFollow(FOLLOW_structure_type_oqlQueryWithImplicitSelect_in_behavior_expressions_oql_oqlquery4612);
                    temp=structure_type_oqlQueryWithImplicitSelect();

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
              _beforeSeqEl("E0677A9A984FA2002B8311DFA9E6C07B8D1505E2");
            }
            match(input,73,FOLLOW_73_in_behavior_expressions_oql_oqlquery4623); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A985128902B8311DFA686C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:351: (temp= behavior_expressions_oql_fromclause ( ( ',' ) temp= behavior_expressions_oql_fromclause )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:353: temp= behavior_expressions_oql_fromclause ( ( ',' ) temp= behavior_expressions_oql_fromclause )*
            {
            pushFollow(FOLLOW_behavior_expressions_oql_fromclause_in_behavior_expressions_oql_oqlquery4630);
            temp=behavior_expressions_oql_fromclause();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "fromClauses", temp);
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:435: ( ( ',' ) temp= behavior_expressions_oql_fromclause )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==48) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:436: ( ',' ) temp= behavior_expressions_oql_fromclause
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:453: ( ',' )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:454: ','
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A984FA2022B8311DFC1B5C07B8D1505E2");
            	    }
            	    match(input,48,FOLLOW_48_in_behavior_expressions_oql_oqlquery4638); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_behavior_expressions_oql_fromclause_in_behavior_expressions_oql_oqlquery4645);
            	    temp=behavior_expressions_oql_fromclause();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "fromClauses", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A985128912B8311DF81AAC07B8D1505E2");
            }
            match(input,74,FOLLOW_74_in_behavior_expressions_oql_oqlquery4654); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A985128942B8311DFAA0CC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:792: (temp= behavior_expressions_expression )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1108:794: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_oql_oqlquery4661);
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
    // $ANTLR end "behavior_expressions_oql_oqlquery"


    // $ANTLR start "behavior_expressions_oql_fromclause"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1116:1: behavior_expressions_oql_fromclause returns [Object ret2] : ( (temp= behavior_expressions_expression ) 'as' (temp= behavior_expressions_alias_fromClause ) ) ;
    public final Object behavior_expressions_oql_fromclause() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","oql","FromClause");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1121:3: ( ( (temp= behavior_expressions_expression ) 'as' (temp= behavior_expressions_alias_fromClause ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1122:3: ( (temp= behavior_expressions_expression ) 'as' (temp= behavior_expressions_alias_fromClause ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1122:3: ( (temp= behavior_expressions_expression ) 'as' (temp= behavior_expressions_alias_fromClause ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1122:4: (temp= behavior_expressions_expression ) 'as' (temp= behavior_expressions_alias_fromClause )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A985128992B8311DFCA0AC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1122:63: (temp= behavior_expressions_expression )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1122:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_oql_fromclause4708);
            temp=behavior_expressions_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "fromExpression", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9851289A2B8311DF87DDC07B8D1505E2");
            }
            match(input,75,FOLLOW_75_in_behavior_expressions_oql_fromclause4714); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9851289D2B8311DFB2ADC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1122:300: (temp= behavior_expressions_alias_fromClause )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1122:302: temp= behavior_expressions_alias_fromClause
            {
            pushFollow(FOLLOW_behavior_expressions_alias_fromClause_in_behavior_expressions_oql_fromclause4721);
            temp=behavior_expressions_alias_fromClause();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "alias", temp);
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
    // $ANTLR end "behavior_expressions_oql_fromclause"


    // $ANTLR start "behavior_expressions_alias_fromClause"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1130:1: behavior_expressions_alias_fromClause returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_alias_fromClause() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Alias");
        onEnterTemplateRule(metaType,"fromClause");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1135:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9852AF312B8311DFA8D2C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FIRST_UPPERCASE_NAME) ) {
                alt51=1;
            }
            else if ( (LA51_0==FIRST_LOWERCASE_NAME) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A985128A32B8311DFAF2FC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:140: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1136:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias_fromClause4773);
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A985128A72B8311DFC9BFC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:80: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1137:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias_fromClause4793);
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
              _beforeSeqEl("E0677A9A9852AF342B8311DF8C36C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.fromClause.fromExpression.type", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_alias_fromClause"


    // $ANTLR start "structure_type_oqlQuery"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1145:1: structure_type_oqlQuery returns [Object ret2] : (ret= structure_finexclass_oqlQuery ) ;
    public final Object structure_type_oqlQuery() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1146:3: ( (ret= structure_finexclass_oqlQuery ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1147:3: (ret= structure_finexclass_oqlQuery )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1147:3: (ret= structure_finexclass_oqlQuery )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1147:4: ret= structure_finexclass_oqlQuery
            {
            pushFollow(FOLLOW_structure_finexclass_oqlQuery_in_structure_type_oqlQuery4841);
            ret=structure_finexclass_oqlQuery();

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
    // $ANTLR end "structure_type_oqlQuery"


    // $ANTLR start "structure_finexclass_oqlQuery"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1154:1: structure_finexclass_oqlQuery returns [Object ret2] : ( (temp= structure_association_oqlQuery ( ( ',' ) temp= structure_association_oqlQuery )* ) ) ;
    public final Object structure_finexclass_oqlQuery() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"oqlQuery");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1159:3: ( ( (temp= structure_association_oqlQuery ( ( ',' ) temp= structure_association_oqlQuery )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:3: ( (temp= structure_association_oqlQuery ( ( ',' ) temp= structure_association_oqlQuery )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:3: ( (temp= structure_association_oqlQuery ( ( ',' ) temp= structure_association_oqlQuery )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:4: (temp= structure_association_oqlQuery ( ( ',' ) temp= structure_association_oqlQuery )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9852AF402B8311DFCC12C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:63: (temp= structure_association_oqlQuery ( ( ',' ) temp= structure_association_oqlQuery )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:65: temp= structure_association_oqlQuery ( ( ',' ) temp= structure_association_oqlQuery )*
            {
            pushFollow(FOLLOW_structure_association_oqlQuery_in_structure_finexclass_oqlQuery4875);
            temp=structure_association_oqlQuery();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "associations", temp);
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:143: ( ( ',' ) temp= structure_association_oqlQuery )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==48) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:144: ( ',' ) temp= structure_association_oqlQuery
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:161: ( ',' )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1160:162: ','
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A9852AF3C2B8311DF940CC07B8D1505E2");
            	    }
            	    match(input,48,FOLLOW_48_in_structure_finexclass_oqlQuery4883); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_structure_association_oqlQuery_in_structure_finexclass_oqlQuery4890);
            	    temp=structure_association_oqlQuery();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "associations", temp);
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
              _beforeSeqEl("E0677A9A985435D42B8311DFACD3C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.typedElement->select(te|te.oclIsKindOf(OqlQuery)).oclAsType(OqlQuery).fromClauses.alias->iterate("+"			 			a; acc='QueryType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement->select(te | te.oclIsKindOf(Expression))."+"			                   oclAsType(Expression).getEnclosingType()", true);_exitInjectorAction();
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
    // $ANTLR end "structure_finexclass_oqlQuery"


    // $ANTLR start "structure_association_oqlQuery"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1168:1: structure_association_oqlQuery returns [Object ret2] : ( (temp= structure_field_oqlQuery ) (temp= structure_field_nondeclaredOpposite ) ) ;
    public final Object structure_association_oqlQuery() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType,"oqlQuery");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1173:3: ( ( (temp= structure_field_oqlQuery ) (temp= structure_field_nondeclaredOpposite ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1174:3: ( (temp= structure_field_oqlQuery ) (temp= structure_field_nondeclaredOpposite ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1174:3: ( (temp= structure_field_oqlQuery ) (temp= structure_field_nondeclaredOpposite ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1174:4: (temp= structure_field_oqlQuery ) (temp= structure_field_nondeclaredOpposite )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9855BC742B8311DF9E86C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1174:63: (temp= structure_field_oqlQuery )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1174:65: temp= structure_field_oqlQuery
            {
            pushFollow(FOLLOW_structure_field_oqlQuery_in_structure_association_oqlQuery4943);
            temp=structure_field_oqlQuery();

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
              _beforeSeqEl("E0677A9A9855BC792B8311DFABC4C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1174:204: (temp= structure_field_nondeclaredOpposite )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1174:206: temp= structure_field_nondeclaredOpposite
            {
            pushFollow(FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_oqlQuery4953);
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
              _beforeSeqEl("E0677A9A9855BC7C2B8311DFAA1CC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'Query_to_'.concat(self.ends->first().name)", true);_exitInjectorAction();
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
    // $ANTLR end "structure_association_oqlQuery"


    // $ANTLR start "structure_field_oqlQuery"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1182:1: structure_field_oqlQuery returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) (temp= behavior_expressions_expression_oqlQuery ) ) ;
    public final Object structure_field_oqlQuery() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"oqlQuery");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1187:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) (temp= behavior_expressions_expression_oqlQuery ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) (temp= behavior_expressions_expression_oqlQuery ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) (temp= behavior_expressions_expression_oqlQuery ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) (temp= behavior_expressions_expression_oqlQuery )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9858C9B22B8311DF8E6EC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FIRST_UPPERCASE_NAME) ) {
                alt53=1;
            }
            else if ( (LA53_0==FIRST_LOWERCASE_NAME) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A985743142B8311DF8FBEC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:140: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1188:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_structure_field_oqlQuery5008);
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
                      _beforeSeqEl("E0677A9A985743172B8311DFC1EFC07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "mandatory", true);_exitInjectorAction();
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9857431B2B8311DF9500C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:80: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field_oqlQuery5031);
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
                      _beforeSeqEl("E0677A9A9858C9B02B8311DFCA0BC07B8D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();
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
              _beforeSeqEl("E0677A9A9858C9B62B8311DFA797C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:412: (temp= behavior_expressions_expression_oqlQuery )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:414: temp= behavior_expressions_expression_oqlQuery
            {
            pushFollow(FOLLOW_behavior_expressions_expression_oqlQuery_in_structure_field_oqlQuery5049);
            temp=behavior_expressions_expression_oqlQuery();

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
              _beforeSeqEl("E0677A9A9858C9BD2B8311DFBA07C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.defaultValue.type", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();
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
    // $ANTLR end "structure_field_oqlQuery"


    // $ANTLR start "behavior_expressions_expression_oqlQuery"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1197:1: behavior_expressions_expression_oqlQuery returns [Object ret2] : (ret= behavior_expressions_namedvalueexpression_oqlQuery ) ;
    public final Object behavior_expressions_expression_oqlQuery() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1198:3: ( (ret= behavior_expressions_namedvalueexpression_oqlQuery ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1199:3: (ret= behavior_expressions_namedvalueexpression_oqlQuery )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1199:3: (ret= behavior_expressions_namedvalueexpression_oqlQuery )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1199:4: ret= behavior_expressions_namedvalueexpression_oqlQuery
            {
            pushFollow(FOLLOW_behavior_expressions_namedvalueexpression_oqlQuery_in_behavior_expressions_expression_oqlQuery5092);
            ret=behavior_expressions_namedvalueexpression_oqlQuery();

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
    // $ANTLR end "behavior_expressions_expression_oqlQuery"


    // $ANTLR start "behavior_expressions_namedvalueexpression_oqlQuery"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1206:1: behavior_expressions_namedvalueexpression_oqlQuery returns [Object ret2] : () ;
    public final Object behavior_expressions_namedvalueexpression_oqlQuery() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","NamedValueExpression");
        onEnterTemplateRule(metaType,"oqlQuery");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1211:3: ( () )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1212:3: ()
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1212:3: ()
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1212:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A985A50562B8311DF805BC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "namedValue", null, null, "OCL:self.defaultOf.oclAsType(Field).association.clazz.typedElement."+"						          oclAsType(OqlQuery).fromClauses.alias->select(a|"+"								                                a.name=self.defaultOf.oclAsType(Field).name)", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:namedValue.type", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_namedvalueexpression_oqlQuery"


    // $ANTLR start "structure_type_oqlQueryWithImplicitSelect"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1220:1: structure_type_oqlQueryWithImplicitSelect returns [Object ret2] : (ret= structure_finexclass_oqlQueryWithImplicitSelect ) ;
    public final Object structure_type_oqlQueryWithImplicitSelect() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1221:3: ( (ret= structure_finexclass_oqlQueryWithImplicitSelect ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:3: (ret= structure_finexclass_oqlQueryWithImplicitSelect )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:3: (ret= structure_finexclass_oqlQueryWithImplicitSelect )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1222:4: ret= structure_finexclass_oqlQueryWithImplicitSelect
            {
            pushFollow(FOLLOW_structure_finexclass_oqlQueryWithImplicitSelect_in_structure_type_oqlQueryWithImplicitSelect5159);
            ret=structure_finexclass_oqlQueryWithImplicitSelect();

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
    // $ANTLR end "structure_type_oqlQueryWithImplicitSelect"


    // $ANTLR start "structure_finexclass_oqlQueryWithImplicitSelect"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1229:1: structure_finexclass_oqlQueryWithImplicitSelect returns [Object ret2] : () ;
    public final Object structure_finexclass_oqlQueryWithImplicitSelect() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"oqlQueryWithImplicitSelect");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1234:3: ( () )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1235:3: ()
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1235:3: ()
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1235:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A985BD6FB2B8311DFA3E5C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();
              {
              List<PredicateSemantic> list = new ArrayList<PredicateSemantic>();
              RuleNameFinder finder = new RuleNameFinder();
              list.add(new PredicateSemantic(null, "structure_association_oqlQueryWithImplicitSelect"));
              setPredicateRef(ret,"associations","oqlQueryWithImplicitSelect","OCL:self.typedElement->select(te|te.oclIsKindOf(OqlQuery)).oclAsType(OqlQuery).fromClauses",list,finder,true);
              }
              _exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.typedElement->select(te|te.oclIsKindOf(OqlQuery)).oclAsType(OqlQuery).fromClauses.alias->iterate("+"			 			a; acc='QueryType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement->select(te | te.oclIsKindOf(Expression))."+"			                   oclAsType(Expression).getEnclosingType()", true);_exitInjectorAction();
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
    // $ANTLR end "structure_finexclass_oqlQueryWithImplicitSelect"


    // $ANTLR start "structure_association_oqlQueryWithImplicitSelect"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1250:1: structure_association_oqlQueryWithImplicitSelect returns [Object ret2] : ( (temp= structure_field_oqlQueryWithImplicitSelect ) (temp= structure_field_nondeclaredOpposite ) ) ;
    public final Object structure_association_oqlQueryWithImplicitSelect() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType,"oqlQueryWithImplicitSelect");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1255:3: ( ( (temp= structure_field_oqlQueryWithImplicitSelect ) (temp= structure_field_nondeclaredOpposite ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1256:3: ( (temp= structure_field_oqlQueryWithImplicitSelect ) (temp= structure_field_nondeclaredOpposite ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1256:3: ( (temp= structure_field_oqlQueryWithImplicitSelect ) (temp= structure_field_nondeclaredOpposite ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1256:4: (temp= structure_field_oqlQueryWithImplicitSelect ) (temp= structure_field_nondeclaredOpposite )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A985D5D972B8311DF979FC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1256:63: (temp= structure_field_oqlQueryWithImplicitSelect )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1256:65: temp= structure_field_oqlQueryWithImplicitSelect
            {
            pushFollow(FOLLOW_structure_field_oqlQueryWithImplicitSelect_in_structure_association_oqlQueryWithImplicitSelect5233);
            temp=structure_field_oqlQueryWithImplicitSelect();

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
              _beforeSeqEl("E0677A9A985D5D9C2B8311DFCC25C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1256:222: (temp= structure_field_nondeclaredOpposite )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1256:224: temp= structure_field_nondeclaredOpposite
            {
            pushFollow(FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_oqlQueryWithImplicitSelect5243);
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
              _beforeSeqEl("E0677A9A985D5D9F2B8311DFC23CC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'Query_to_'.concat(self.ends->first().name)", true);_exitInjectorAction();
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
    // $ANTLR end "structure_association_oqlQueryWithImplicitSelect"


    // $ANTLR start "structure_field_oqlQueryWithImplicitSelect"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1264:1: structure_field_oqlQueryWithImplicitSelect returns [Object ret2] : ( (temp= behavior_expressions_expression_oqlQueryWithImplicitSelect ) ) ;
    public final Object structure_field_oqlQueryWithImplicitSelect() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"oqlQueryWithImplicitSelect");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1269:3: ( ( (temp= behavior_expressions_expression_oqlQueryWithImplicitSelect ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1270:3: ( (temp= behavior_expressions_expression_oqlQueryWithImplicitSelect ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1270:3: ( (temp= behavior_expressions_expression_oqlQueryWithImplicitSelect ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1270:4: (temp= behavior_expressions_expression_oqlQueryWithImplicitSelect )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A985EE4332B8311DFA613C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1270:63: (temp= behavior_expressions_expression_oqlQueryWithImplicitSelect )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1270:65: temp= behavior_expressions_expression_oqlQueryWithImplicitSelect
            {
            pushFollow(FOLLOW_behavior_expressions_expression_oqlQueryWithImplicitSelect_in_structure_field_oqlQueryWithImplicitSelect5293);
            temp=behavior_expressions_expression_oqlQueryWithImplicitSelect();

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
              _beforeSeqEl("E0677A9A985EE43C2B8311DFB0E1C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.defaultValue.type", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:#context.oclAsType(FromClause).alias.name", true);_exitInjectorAction();
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
    // $ANTLR end "structure_field_oqlQueryWithImplicitSelect"


    // $ANTLR start "behavior_expressions_expression_oqlQueryWithImplicitSelect"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1278:1: behavior_expressions_expression_oqlQueryWithImplicitSelect returns [Object ret2] : (ret= behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect ) ;
    public final Object behavior_expressions_expression_oqlQueryWithImplicitSelect() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1279:3: ( (ret= behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1280:3: (ret= behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1280:3: (ret= behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1280:4: ret= behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect
            {
            pushFollow(FOLLOW_behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect_in_behavior_expressions_expression_oqlQueryWithImplicitSelect5336);
            ret=behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect();

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
    // $ANTLR end "behavior_expressions_expression_oqlQueryWithImplicitSelect"


    // $ANTLR start "behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1287:1: behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect returns [Object ret2] : () ;
    public final Object behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","NamedValueExpression");
        onEnterTemplateRule(metaType,"oqlQueryWithImplicitSelect");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1292:3: ( () )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1293:3: ()
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1293:3: ()
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1293:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9861F1742B8311DFC9C1C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "namedValue", null, null, "OCL:#context.oclAsType(FromClause).alias", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.namedValue.type", true);_exitInjectorAction();
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
    // $ANTLR end "behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect"


    // $ANTLR start "behavior_expressions_firstpathexpression"
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1301:1: behavior_expressions_firstpathexpression returns [Object ret2] : ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) ;
    public final Object behavior_expressions_firstpathexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FirstPathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1306:3: ( ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:4: DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A986378132B8311DFAF5DC07B8D1505E2");
            }
            match(input,DOT,FOLLOW_DOT_in_behavior_expressions_firstpathexpression5407); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A986378162B8311DFC906C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:143: (temp= behavior_expressions_expression_pathExpression )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:145: temp= behavior_expressions_expression_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression5415);
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
              _beforeSeqEl("E0677A9A986378232B8311DF98EBC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:309: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==FIRST_LOWERCASE_NAME) ) {
                alt54=1;
            }
            else if ( (LA54_0==FIRST_UPPERCASE_NAME) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:310: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:326: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:327: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9863781B2B8311DFC804C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:386: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1307:388: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression5430);
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1308:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1308:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1308:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A986378212B8311DFC7A4C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1308:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1308:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression5450);
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
              _beforeSeqEl("E0677A9A986378242B8311DFB96EC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_firstpathexpression5461);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A986378272B8311DF9894C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.field.type", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1316:1: behavior_expressions_pathexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) ;
    public final Object behavior_expressions_pathexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","PathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1321:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9866855D2B8311DFA8ADC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==FIRST_LOWERCASE_NAME) ) {
                alt55=1;
            }
            else if ( (LA55_0==FIRST_UPPERCASE_NAME) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A986685552B8311DF958BC07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:140: (temp= firstLowercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1322:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression5515);
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
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1323:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1323:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1323:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0677A9A9866855B2B8311DFB279C07B8D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1323:80: (temp= firstUppercaseIdentifier )
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1323:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression5535);
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
              _beforeSeqEl("E0677A9A9866855E2B8311DFB4DBC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_pathexpression5546);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A986685612B8311DFC85BC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.field.type", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1333:1: behavior_expressions_filterexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] ) ;
    public final Object behavior_expressions_filterexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FilterExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1338:3: ( ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1339:3: ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1339:3: ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1339:4: (temp= behavior_expressions_expression ) RBRACKET alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98680BF22B8311DFA6F7C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1339:63: (temp= behavior_expressions_expression )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1339:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression5587);
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
              _beforeSeqEl("E0677A9A98680BF32B8311DF8C7BC07B8D1505E2");
            }
            match(input,RBRACKET,FOLLOW_RBRACKET_in_behavior_expressions_filterexpression5594); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98680BF42B8311DFA06BC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_filterexpression5598);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A98680BF72B8311DFC2A0C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1349:1: behavior_expressions_literals_literal returns [Object ret2] : (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) ;
    public final Object behavior_expressions_literals_literal() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1350:3: ( (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1351:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1351:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            int alt56=6;
            switch ( input.LA(1) ) {
            case BOOL:
                {
                alt56=1;
                }
                break;
            case STRING:
                {
                alt56=2;
                }
                break;
            case FLOAT:
                {
                alt56=3;
                }
                break;
            case INT:
                {
                alt56=4;
                }
                break;
            case DATE:
                {
                alt56=5;
                }
                break;
            case BINARY:
                {
                alt56=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1351:4: ret= behavior_expressions_literals_booleanliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal5631);
                    ret=behavior_expressions_literals_booleanliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1352:5: ret= behavior_expressions_literals_stringliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal5639);
                    ret=behavior_expressions_literals_stringliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1353:5: ret= behavior_expressions_literals_decimalliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal5647);
                    ret=behavior_expressions_literals_decimalliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1354:5: ret= behavior_expressions_literals_integerliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal5655);
                    ret=behavior_expressions_literals_integerliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1355:5: ret= behavior_expressions_literals_dateliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal5663);
                    ret=behavior_expressions_literals_dateliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1356:5: ret= behavior_expressions_literals_binaryliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal5671);
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1363:1: behavior_expressions_literals_booleanliteral returns [Object ret2] : ( (temp= booleanSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_booleanliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BooleanLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1368:3: ( ( (temp= booleanSymbol ) alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1369:3: ( (temp= booleanSymbol ) alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1369:3: ( (temp= booleanSymbol ) alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1369:4: (temp= booleanSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A986E26722B8311DFB79EC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1369:63: (temp= booleanSymbol )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1369:65: temp= booleanSymbol
            {
            pushFollow(FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral5705);
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
              _beforeSeqEl("E0677A9A986E26732B8311DFB00CC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_booleanliteral5711);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A986E26762B8311DFB8E1C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1377:1: behavior_expressions_literals_stringliteral returns [Object ret2] : ( (temp= stringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_stringliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","StringLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1382:3: ( ( (temp= stringSymbol ) alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1383:3: ( (temp= stringSymbol ) alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1383:3: ( (temp= stringSymbol ) alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1383:4: (temp= stringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A986FAD122B8311DFCE80C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1383:63: (temp= stringSymbol )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1383:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral5759);
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
              _beforeSeqEl("E0677A9A986FAD132B8311DFA0FAC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_stringliteral5765);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A987133B02B8311DFAB8DC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'String')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1391:1: behavior_expressions_literals_decimalliteral returns [Object ret2] : ( (temp= floatAsStringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_decimalliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DecimalLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1396:3: ( ( (temp= floatAsStringSymbol ) alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1397:3: ( (temp= floatAsStringSymbol ) alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1397:3: ( (temp= floatAsStringSymbol ) alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1397:4: (temp= floatAsStringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9872BA522B8311DFA7A3C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1397:63: (temp= floatAsStringSymbol )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1397:65: temp= floatAsStringSymbol
            {
            pushFollow(FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral5813);
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
              _beforeSeqEl("E0677A9A9872BA532B8311DF85DCC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_decimalliteral5819);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9872BA562B8311DFB7D0C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Decimal')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1405:1: behavior_expressions_literals_integerliteral returns [Object ret2] : ( (temp= integerAsStringSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_integerliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","IntegerLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1410:3: ( ( (temp= integerAsStringSymbol ) alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1411:3: ( (temp= integerAsStringSymbol ) alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1411:3: ( (temp= integerAsStringSymbol ) alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1411:4: (temp= integerAsStringSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9875C7922B8311DF929FC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1411:63: (temp= integerAsStringSymbol )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1411:65: temp= integerAsStringSymbol
            {
            pushFollow(FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral5867);
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
              _beforeSeqEl("E0677A9A9875C7932B8311DFC80BC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_integerliteral5873);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9875C7962B8311DFABA9C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1419:1: behavior_expressions_literals_dateliteral returns [Object ret2] : ( (temp= dateSymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_dateliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DateLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1424:3: ( ( (temp= dateSymbol ) alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1425:3: ( (temp= dateSymbol ) alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1425:3: ( (temp= dateSymbol ) alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1425:4: (temp= dateSymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9878D4D22B8311DFA835C07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1425:63: (temp= dateSymbol )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1425:65: temp= dateSymbol
            {
            pushFollow(FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral5921);
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
              _beforeSeqEl("E0677A9A9878D4D32B8311DF8000C07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_dateliteral5927);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A9878D4D62B8311DFBAF4C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Date')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1433:1: behavior_expressions_literals_binaryliteral returns [Object ret2] : ( (temp= binarySymbol ) alias[ret] ) ;
    public final Object behavior_expressions_literals_binaryliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BinaryLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1438:3: ( ( (temp= binarySymbol ) alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1439:3: ( (temp= binarySymbol ) alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1439:3: ( (temp= binarySymbol ) alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1439:4: (temp= binarySymbol ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A987D68B22B8311DFAE4DC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1439:63: (temp= binarySymbol )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1439:65: temp= binarySymbol
            {
            pushFollow(FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral5975);
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
              _beforeSeqEl("E0677A9A987D68B32B8311DFC58FC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_binaryliteral5981);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A987D68B62B8311DF9751C07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Binary')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1447:1: behavior_expressions_literals_multiobjectliteral returns [Object ret2] : ( LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret] ) ;
    public final Object behavior_expressions_literals_multiobjectliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","MultiObjectLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1452:3: ( ( LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:3: ( LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:3: ( LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:4: LBRACKET (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* ) RBRACKET alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A987EEF502B8311DF8F6BC07B8D1505E2");
            }
            match(input,LBRACKET,FOLLOW_LBRACKET_in_behavior_expressions_literals_multiobjectliteral6026); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A987EEF552B8311DFBAFEC07B8D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:148: (temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )* )
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:150: temp= behavior_expressions_expression ( ( ',' ) temp= behavior_expressions_expression )*
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_literals_multiobjectliteral6034);
            temp=behavior_expressions_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "elements", temp);
            }
            // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:225: ( ( ',' ) temp= behavior_expressions_expression )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==48) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:226: ( ',' ) temp= behavior_expressions_expression
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:243: ( ',' )
            	    // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1453:244: ','
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0677A9A987EEF522B8311DFB170C07B8D1505E2");
            	    }
            	    match(input,48,FOLLOW_48_in_behavior_expressions_literals_multiobjectliteral6042); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_literals_multiobjectliteral6049);
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
            	    break loop57;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A988075F02B8311DF95E6C07B8D1505E2");
            }
            match(input,RBRACKET,FOLLOW_RBRACKET_in_behavior_expressions_literals_multiobjectliteral6059); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A988075F12B8311DFB26BC07B8D1505E2");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_literals_multiobjectliteral6063);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0677A9A988075F42B8311DFAB7AC07B8D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.elements->asSequence()->first().type", true);_exitInjectorAction();
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
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:397: ( structure_association )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:398: structure_association
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
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:4: ( behavior_functions_function )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:5: behavior_functions_function
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
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:4: ( structure_type_field )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:5: structure_type_field
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
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:6: ( '-' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:7: '-'
        {
        match(input,50,FOLLOW_50_in_synpred5_FinexClass2499); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_FinexClass

    // $ANTLR start synpred6_FinexClass
    public final void synpred6_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:3: ( 'not' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:4: 'not'
        {
        match(input,51,FOLLOW_51_in_synpred6_FinexClass2527); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_FinexClass

    // $ANTLR start synpred7_FinexClass
    public final void synpred7_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:48: ( DOT )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:49: DOT
        {
        match(input,DOT,FOLLOW_DOT_in_synpred7_FinexClass2563); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_FinexClass

    // $ANTLR start synpred8_FinexClass
    public final void synpred8_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:3: ( LBRACKET )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:668:4: LBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred8_FinexClass2632); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_FinexClass

    // $ANTLR start synpred9_FinexClass
    public final void synpred9_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:35: ( '*' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:678:36: '*'
        {
        match(input,52,FOLLOW_52_in_synpred9_FinexClass2695); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_FinexClass

    // $ANTLR start synpred10_FinexClass
    public final void synpred10_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:3: ( '/' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:681:4: '/'
        {
        match(input,53,FOLLOW_53_in_synpred10_FinexClass2723); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_FinexClass

    // $ANTLR start synpred11_FinexClass
    public final void synpred11_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:3: ( 'AND' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:684:4: 'AND'
        {
        match(input,54,FOLLOW_54_in_synpred11_FinexClass2751); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_FinexClass

    // $ANTLR start synpred12_FinexClass
    public final void synpred12_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:35: ( 'OR' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:36: 'OR'
        {
        match(input,55,FOLLOW_55_in_synpred12_FinexClass2818); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_FinexClass

    // $ANTLR start synpred13_FinexClass
    public final void synpred13_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:3: ( '+' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:699:4: '+'
        {
        match(input,56,FOLLOW_56_in_synpred13_FinexClass2846); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_FinexClass

    // $ANTLR start synpred14_FinexClass
    public final void synpred14_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:3: ( '-' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:702:4: '-'
        {
        match(input,50,FOLLOW_50_in_synpred14_FinexClass2874); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_FinexClass

    // $ANTLR start synpred15_FinexClass
    public final void synpred15_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:35: ( RANGLE )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:36: RANGLE
        {
        match(input,RANGLE,FOLLOW_RANGLE_in_synpred15_FinexClass2941); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_FinexClass

    // $ANTLR start synpred16_FinexClass
    public final void synpred16_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:3: ( LANGLE )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:717:4: LANGLE
        {
        match(input,LANGLE,FOLLOW_LANGLE_in_synpred16_FinexClass2970); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_FinexClass

    // $ANTLR start synpred17_FinexClass
    public final void synpred17_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:3: ( '>=' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:720:4: '>='
        {
        match(input,57,FOLLOW_57_in_synpred17_FinexClass2999); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_FinexClass

    // $ANTLR start synpred18_FinexClass
    public final void synpred18_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:3: ( '<=' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:723:4: '<='
        {
        match(input,58,FOLLOW_58_in_synpred18_FinexClass3027); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_FinexClass

    // $ANTLR start synpred19_FinexClass
    public final void synpred19_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:3: ( EQUALSEQUALS )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:726:4: EQUALSEQUALS
        {
        match(input,EQUALSEQUALS,FOLLOW_EQUALSEQUALS_in_synpred19_FinexClass3055); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_FinexClass

    // $ANTLR start synpred20_FinexClass
    public final void synpred20_FinexClass_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:3: ( '!=' )
        // C:\\_fzi\\projects\\CTS\\git\\ngpm\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:4: '!='
        {
        match(input,59,FOLLOW_59_in_synpred20_FinexClass3084); if (state.failed) return ;

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


    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA38_eotS =
        "\16\uffff";
    static final String DFA38_eofS =
        "\1\1\15\uffff";
    static final String DFA38_minS =
        "\1\15\1\uffff\6\0\6\uffff";
    static final String DFA38_maxS =
        "\1\113\1\uffff\6\0\6\uffff";
    static final String DFA38_acceptS =
        "\1\uffff\1\7\6\uffff\1\1\1\2\1\3\1\4\1\5\1\6";
    static final String DFA38_specialS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\1\1\0\6\uffff}>";
    static final String[] DFA38_transitionS = {
            "\4\1\3\uffff\1\1\1\uffff\2\1\1\uffff\1\2\1\3\1\6\15\uffff\1"+
            "\1\6\uffff\1\1\1\uffff\1\1\1\uffff\5\1\1\4\1\5\1\7\17\uffff"+
            "\1\1",
            "",
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
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "()* loopback of 714:34: ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALSEQUALS )=> ( EQUALSEQUALS ( (ret= behavior_expressions_equals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_unequals[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_7 = input.LA(1);

                         
                        int index38_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_FinexClass()) ) {s = 13;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index38_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_6 = input.LA(1);

                         
                        int index38_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_FinexClass()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index38_6);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA38_2 = input.LA(1);

                         
                        int index38_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_FinexClass()) ) {s = 8;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index38_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA38_3 = input.LA(1);

                         
                        int index38_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred16_FinexClass()) ) {s = 9;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index38_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA38_4 = input.LA(1);

                         
                        int index38_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred17_FinexClass()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index38_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA38_5 = input.LA(1);

                         
                        int index38_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_FinexClass()) ) {s = 11;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index38_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
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
    public static final BitSet FOLLOW_LBRACKET_in_classdeclaration650 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
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
    public static final BitSet FOLLOW_42_in_structure_field1011 = new BitSet(new long[]{0x100C000000094FF2L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1037 = new BitSet(new long[]{0x100C000000094FF2L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_structure_field1088 = new BitSet(new long[]{0x00000C0000040000L});
    public static final BitSet FOLLOW_askey_in_structure_field1097 = new BitSet(new long[]{0x0000040000040002L});
    public static final BitSet FOLLOW_42_in_structure_field1106 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1130 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
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
    public static final BitSet FOLLOW_42_in_parameter1738 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_parameter1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_IN1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_OUT1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_block_in_behavior_functions_signatureimplementation1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_behavior_actions_block1907 = new BitSet(new long[]{0x100C000000494FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1918 = new BitSet(new long[]{0x100C000000494FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1926 = new BitSet(new long[]{0x100C000000494FF0L,0x00000000000001C0L});
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
    public static final BitSet FOLLOW_EQUALS_in_assignment2297 = new BitSet(new long[]{0x100C000000094FF2L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_assignment2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_actions_expressionstatement2344 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions_expressionstatement2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_namedvalueexpression_in_primary_behavior_expressions_expression2389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_oql_oqlquery_in_primary_behavior_expressions_expression2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_objectcreationexpression_in_primary_behavior_expressions_expression2405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_this_in_primary_behavior_expressions_expression2429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_multiobjectliteral_in_primary_behavior_expressions_expression2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_all_in_primary_behavior_expressions_expression2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_behavior_expressions_expression2454 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2460 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_behavior_expressions_expression2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_expressions_priority_02505 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02512 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_expressions_priority_02533 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_not_in_expressions_priority_02540 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02560 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_DOT_in_expressions_priority_02569 = new BitSet(new long[]{0xE000000000080030L,0x000000000000003FL});
    public static final BitSet FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02577 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_count_in_expressions_priority_02586 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_single_in_expressions_priority_02595 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_tuple_in_expressions_priority_02604 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02613 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02622 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_LBRACKET_in_expressions_priority_02638 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02646 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12692 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_52_in_expressions_priority_12701 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12708 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12712 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_53_in_expressions_priority_12729 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12736 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12740 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_54_in_expressions_priority_12757 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12764 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12768 = new BitSet(new long[]{0x0070000000000002L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22815 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_55_in_expressions_priority_22824 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22831 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22835 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_56_in_expressions_priority_22852 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22859 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22863 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_50_in_expressions_priority_22880 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22887 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22891 = new BitSet(new long[]{0x0184000000000002L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32938 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_RANGLE_in_expressions_priority_32947 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32955 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32959 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_LANGLE_in_expressions_priority_32976 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32984 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32988 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_57_in_expressions_priority_33005 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33012 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33016 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_58_in_expressions_priority_33033 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33040 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33044 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_EQUALSEQUALS_in_expressions_priority_33061 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_equals_in_expressions_priority_33069 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33073 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_59_in_expressions_priority_33090 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_behavior_expressions_unequals_in_expressions_priority_33097 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33101 = new BitSet(new long[]{0x0E0000000E000002L});
    public static final BitSet FOLLOW_expressions_priority_3_in_behavior_expressions_expression3139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_alias3168 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_expressions_alias_in_alias3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias3250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_behavior_expressions_all3301 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_all3308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_binarybooleanoperator3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_not3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_behavior_expressions_booleanaggregate3434 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_62_in_behavior_expressions_booleanaggregate3450 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_63_in_behavior_expressions_booleanaggregate3466 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate3478 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate3483 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_booleanaggregate3487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_equals3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_unequals3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_binarynumericoperator3598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_unaryminus3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_behavior_expressions_count3672 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_count3679 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_count3684 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_count3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_behavior_expressions_single3722 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_single3729 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_single3734 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_single3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_tuple3773 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_structure_type_tuple_in_behavior_expressions_tuple3781 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_tuple3788 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_tuple3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_tuple_in_structure_type_tuple3822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3856 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_structure_finexclass_tuple3864 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_structure_association_tuple_in_structure_finexclass_tuple3871 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_structure_field_tuple_in_structure_association_tuple3924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_tuple3934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field_tuple3989 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field_tuple4012 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_structure_field_tuple4027 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field_tuple4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_behavior_expressions_numericaggregate4087 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_67_in_behavior_expressions_numericaggregate4103 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_68_in_behavior_expressions_numericaggregate4119 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_69_in_behavior_expressions_numericaggregate4135 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_numericaggregate4147 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_numericaggregate4152 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_numericaggregate4156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_behavior_expressions_objectcreationexpression4192 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_objectcreationexpression4199 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_objectcreationexpression4209 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4217 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_48_in_behavior_expressions_objectcreationexpression4225 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression4232 = new BitSet(new long[]{0x0001000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_objectcreationexpression4244 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_objectcreationexpression4248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_behavior_expressions_fieldinitializer4290 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_fieldinitializer4303 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_fieldinitializer4323 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_behavior_expressions_fieldinitializer4335 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_fieldinitializer4343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_behavior_expressions_this4386 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_this4389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_namedvalueexpression4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_namedvalueexpression4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_implicitcontext_pathExpression_in_behavior_expressions_expression_pathExpression4510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_behavior_expressions_oql_oqlquery4585 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_structure_type_oqlQuery_in_behavior_expressions_oql_oqlquery4592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_structure_type_oqlQueryWithImplicitSelect_in_behavior_expressions_oql_oqlquery4612 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_behavior_expressions_oql_oqlquery4623 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_oql_fromclause_in_behavior_expressions_oql_oqlquery4630 = new BitSet(new long[]{0x0001000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_48_in_behavior_expressions_oql_oqlquery4638 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_oql_fromclause_in_behavior_expressions_oql_oqlquery4645 = new BitSet(new long[]{0x0001000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_behavior_expressions_oql_oqlquery4654 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_oql_oqlquery4661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_oql_fromclause4708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_behavior_expressions_oql_fromclause4714 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_expressions_alias_fromClause_in_behavior_expressions_oql_fromclause4721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias_fromClause4773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias_fromClause4793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_oqlQuery_in_structure_type_oqlQuery4841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_oqlQuery_in_structure_finexclass_oqlQuery4875 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_structure_finexclass_oqlQuery4883 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_structure_association_oqlQuery_in_structure_finexclass_oqlQuery4890 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_structure_field_oqlQuery_in_structure_association_oqlQuery4943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_oqlQuery4953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field_oqlQuery5008 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field_oqlQuery5031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_behavior_expressions_expression_oqlQuery_in_structure_field_oqlQuery5049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_namedvalueexpression_oqlQuery_in_behavior_expressions_expression_oqlQuery5092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_oqlQueryWithImplicitSelect_in_structure_type_oqlQueryWithImplicitSelect5159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_field_oqlQueryWithImplicitSelect_in_structure_association_oqlQueryWithImplicitSelect5233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_structure_field_nondeclaredOpposite_in_structure_association_oqlQueryWithImplicitSelect5243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_oqlQueryWithImplicitSelect_in_structure_field_oqlQueryWithImplicitSelect5293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect_in_behavior_expressions_expression_oqlQueryWithImplicitSelect5336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_behavior_expressions_firstpathexpression5407 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression5415 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression5430 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression5450 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_firstpathexpression5461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression5515 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression5535 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_pathexpression5546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression5587 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_behavior_expressions_filterexpression5594 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_filterexpression5598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal5631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal5639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal5647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal5655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal5663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal5671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral5705 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_booleanliteral5711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral5759 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_stringliteral5765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral5813 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_decimalliteral5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral5867 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_integerliteral5873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral5921 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_dateliteral5927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral5975 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_binaryliteral5981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_behavior_expressions_literals_multiobjectliteral6026 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_literals_multiobjectliteral6034 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_48_in_behavior_expressions_literals_multiobjectliteral6042 = new BitSet(new long[]{0x100C000000094FF0L,0x00000000000001C0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_literals_multiobjectliteral6049 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_behavior_expressions_literals_multiobjectliteral6059 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_literals_multiobjectliteral6063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_in_synpred1_FinexClass584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_functions_function_in_synpred2_FinexClass615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_synpred3_FinexClass1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred5_FinexClass2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred6_FinexClass2527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred7_FinexClass2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred8_FinexClass2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred9_FinexClass2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred10_FinexClass2723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred11_FinexClass2751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred12_FinexClass2818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred13_FinexClass2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred14_FinexClass2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGLE_in_synpred15_FinexClass2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_synpred16_FinexClass2970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred17_FinexClass2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred18_FinexClass3027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALSEQUALS_in_synpred19_FinexClass3055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_synpred20_FinexClass3084 = new BitSet(new long[]{0x0000000000000002L});

}