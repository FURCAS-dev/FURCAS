// $ANTLR 3.1.1 C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g 2009-11-18 21:27:32

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FIRST_LOWERCASE_NAME", "FIRST_UPPERCASE_NAME", "STRING", "INT", "FLOAT", "BOOL", "BINARY", "DATE", "COLON", "SEMICOLON", "LBRACKET", "RBRACKET", "DOT", "DDOT", "ASSIGN", "LPAREN", "RPAREN", "LCURL", "RCURL", "PIPE", "EQUALS", "RANGLE", "LANGLE", "COMMENT", "MULTI_LINE_COMMENT", "EQUALSEQUALS", "NL", "WS", "DIGIT", "LOWERCASE_ALPHA", "UPPERCASE_ALPHA", "ALPHA", "FIRST_LOWERCASE_SNAME", "FIRST_UPPERCASE_SNAME", "OBJECT", "RANGE_OR_INT", "NAME", "'value'", "'opposite'", "'DEFAULT'", "'AS'", "'KEY'", "'function'", "'manipulator'", "'IN'", "','", "'OUT'", "'-'", "'not'", "'*'", "'/'", "'AND'", "'OR'", "'+'", "'>='", "'<='", "'!='", "'and'", "'or'", "'xor'", "'count'", "'single'", "'tuple'", "'sum'", "'avg'", "'min'", "'max'", "'create'", "'this'"
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
    public static final int NAME=40;
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
    public static final int COMMENT=27;
    public static final int DOT=16;
    public static final int T__50=50;
    public static final int FIRST_LOWERCASE_SNAME=36;
    public static final int T__42=42;
    public static final int LOWERCASE_ALPHA=33;
    public static final int EQUALSEQUALS=29;
    public static final int T__43=43;
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
    public static final int MULTI_LINE_COMMENT=28;
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
    public String getGrammarFileName() { return "C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g"; }


       private static final String syntaxUUID = "E0356A04C797566BD48011DEA732001CBF0234BB";
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:207:1: firstLowercaseIdentifier returns [Object ret2] : (ast= FIRST_LOWERCASE_NAME ) ;
    public final Object firstLowercaseIdentifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:208:3: ( (ast= FIRST_LOWERCASE_NAME ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:3: (ast= FIRST_LOWERCASE_NAME )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:3: (ast= FIRST_LOWERCASE_NAME )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:209:4: ast= FIRST_LOWERCASE_NAME
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:217:1: firstUppercaseIdentifier returns [Object ret2] : (ast= FIRST_UPPERCASE_NAME ) ;
    public final Object firstUppercaseIdentifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:218:3: ( (ast= FIRST_UPPERCASE_NAME ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:3: (ast= FIRST_UPPERCASE_NAME )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:3: (ast= FIRST_UPPERCASE_NAME )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:219:4: ast= FIRST_UPPERCASE_NAME
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:227:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:228:3: ( (ast= STRING ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:3: (ast= STRING )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:3: (ast= STRING )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:229:4: ast= STRING
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:237:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:238:3: ( (ast= INT ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:3: (ast= INT )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:3: (ast= INT )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:239:4: ast= INT
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:247:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:248:3: ( (ast= INT ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:3: (ast= INT )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:3: (ast= INT )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:249:4: ast= INT
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:257:1: integerAsStringSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:258:3: ( (ast= INT ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:3: (ast= INT )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:3: (ast= INT )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:259:4: ast= INT
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:267:1: floatAsStringSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:268:3: ( (ast= FLOAT ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:3: (ast= FLOAT )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:3: (ast= FLOAT )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:269:4: ast= FLOAT
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:277:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:278:3: ( (ast= BOOL ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:3: (ast= BOOL )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:3: (ast= BOOL )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:279:4: ast= BOOL
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:287:1: binarySymbol returns [Object ret2] : (ast= BINARY ) ;
    public final Object binarySymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:288:3: ( (ast= BINARY ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:3: (ast= BINARY )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:3: (ast= BINARY )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:289:4: ast= BINARY
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:297:1: dateSymbol returns [Object ret2] : (ast= DATE ) ;
    public final Object dateSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:298:3: ( (ast= DATE ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:3: (ast= DATE )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:3: (ast= DATE )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:299:4: ast= DATE
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:307:1: main returns [Object ret2] : ( (ret= structure_finexclass ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:308:3: ( ( (ret= structure_finexclass ) EOF ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:3: ( (ret= structure_finexclass ) EOF )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:3: ( (ret= structure_finexclass ) EOF )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:4: (ret= structure_finexclass ) EOF
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:4: (ret= structure_finexclass )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:309:5: ret= structure_finexclass
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:316:1: structure_finexclass returns [Object ret2] : ( classdeclaration[ret] ) ;
    public final Object structure_finexclass() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"root"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:321:3: ( ( classdeclaration[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:3: ( classdeclaration[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:3: ( classdeclaration[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:322:4: classdeclaration[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C6FF0E01D48011DEBEC9001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:330:1: structure_type_field returns [Object ret2] : (ret= structure_finexclass_field ) ;
    public final Object structure_type_field() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:331:3: ( (ret= structure_finexclass_field ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:3: (ret= structure_finexclass_field )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:3: (ret= structure_finexclass_field )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:332:4: ret= structure_finexclass_field
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:339:1: structure_finexclass_field returns [Object ret2] : ( classdeclaration[ret] ) ;
    public final Object structure_finexclass_field() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"field");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:344:3: ( ( classdeclaration[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:3: ( classdeclaration[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:3: ( classdeclaration[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:345:4: classdeclaration[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7017F00D48011DEBCB4001CBF0234BB");
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
              _beforeSeqEl("E0356A04C7017F03D48011DECF18001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:353:1: classdeclaration[Object ret] : ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final void classdeclaration(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:354:3: ( ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:3: ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:3: ( ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:4: ( ( 'value' ) | ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7017F0CD48011DEAD5F001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:64: ( ( 'value' ) | )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==41) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:65: ( 'value' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:81: ( 'value' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:82: 'value'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7017F0AD48011DECC6B001CBF0234BB");
                    }
                    match(input,41,FOLLOW_41_in_classdeclaration516); if (state.failed) return ;
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:238: 
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
              _beforeSeqEl("E0356A04C703F007D48011DEBDE1001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:76: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:77: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:93: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:94: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C703F001D48011DE8B56001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:153: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:155: temp= firstLowercaseIdentifier
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C703F005D48011DEAC9E001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:82: temp= firstUppercaseIdentifier
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
              _beforeSeqEl("E0356A04C703F008D48011DE8D25001CBF0234BB");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration575); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7063A00D48011DE9531001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:335: ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:337: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C70639FED48011DE9361001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:396: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
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
                else if ( (LA3_0==46) && (synpred2_FinexClass())) {
                    alt3=2;
                }
                else if ( (LA3_0==47) && (synpred2_FinexClass())) {
                    alt3=2;
                }
                else if ( (LA3_0==LBRACKET) ) {
                    alt3=3;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:397: ( structure_association )=> ( (temp= structure_association ) SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(0);
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:440: ( (temp= structure_association ) SEMICOLON )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:441: (temp= structure_association ) SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0356A04C703F00BD48011DEC88D001CBF0234BB");
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:500: (temp= structure_association )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:502: temp= structure_association
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
            	      _beforeSeqEl("E0356A04C70639F0D48011DE9A75001CBF0234BB");
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:4: ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(1);
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:53: ( (temp= behavior_functions_function ) SEMICOLON )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:54: (temp= behavior_functions_function ) SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0356A04C70639F4D48011DEC70F001CBF0234BB");
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:113: (temp= behavior_functions_function )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:115: temp= behavior_functions_function
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
            	      _beforeSeqEl("E0356A04C70639F5D48011DE991F001CBF0234BB");
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:4: ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(2);
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:20: ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:21: LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0356A04C70639F7D48011DEA34C001CBF0234BB");
            	    }
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_classdeclaration650); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0356A04C70639FAD48011DE9594001CBF0234BB");
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:165: (temp= behavior_expressions_expression )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:167: temp= behavior_expressions_expression
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
            	      _beforeSeqEl("E0356A04C70639FBD48011DEB4B2001CBF0234BB");
            	    }
            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_classdeclaration665); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0356A04C70639FCD48011DE922C001CBF0234BB");
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
              _beforeSeqEl("E0356A04C7063A01D48011DE915D001CBF0234BB");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration684); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7063A0AD48011DEBED6001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:623: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:624: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:640: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:641: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7063A04D48011DE8CD2001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:700: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:702: temp= firstLowercaseIdentifier
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7063A08D48011DE988A001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:360:82: temp= firstUppercaseIdentifier
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:367:1: structure_type returns [Object ret2] : (ret= structure_finexclass ) ;
    public final Object structure_type() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:368:3: ( (ret= structure_finexclass ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:3: (ret= structure_finexclass )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:3: (ret= structure_finexclass )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:369:4: ret= structure_finexclass
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:376:1: structure_association returns [Object ret2] : ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) ) ;
    public final Object structure_association() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:3: ( ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:3: ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:3: ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:4: (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C708AAF5D48011DE9825001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:63: (temp= structure_field )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:65: temp= structure_field
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
              _beforeSeqEl("E0356A04C70AF4E7D48011DE9B4C001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:195: ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==42) ) {
                alt5=1;
            }
            else if ( (LA5_0==EOF||LA5_0==SEMICOLON) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:196: ( 'opposite' (temp= structure_field_opposite ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:212: ( 'opposite' (temp= structure_field_opposite ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:213: 'opposite' (temp= structure_field_opposite )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C708AAF6D48011DE930C001CBF0234BB");
                    }
                    match(input,42,FOLLOW_42_in_structure_association797); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C708AAFBD48011DEB6A2001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:357: (temp= structure_field_opposite )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:359: temp= structure_field_opposite
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:4: ( (temp= structure_field_nondeclaredOpposite ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:20: ( (temp= structure_field_nondeclaredOpposite ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:21: (temp= structure_field_nondeclaredOpposite )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C70AF4E5D48011DEA94B001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:80: (temp= structure_field_nondeclaredOpposite )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:383:82: temp= structure_field_nondeclaredOpposite
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
              _beforeSeqEl("E0356A04C70AF4EAD48011DEC5CF001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:391:1: structure_field returns [Object ret2] : ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) ) ;
    public final Object structure_field() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"field"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:3: ( ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:3: ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:3: ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:4: ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C70D65E5D48011DEB779001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:63: ( ( DOT ) | ( DDOT ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:64: ( DOT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:80: ( DOT )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:81: DOT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C70AF4EFD48011DE845B001CBF0234BB");
                    }
                    match(input,DOT,FOLLOW_DOT_in_structure_field881); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C70AF4F2D48011DEC581001CBF0234BB");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:4: ( DDOT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:20: ( DDOT )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:21: DDOT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C70D65E0D48011DEA1F3001CBF0234BB");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_structure_field899); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C70D65E3D48011DE9342001CBF0234BB");
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
              _beforeSeqEl("E0356A04C70FD6FBD48011DE98FC001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:338: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
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
            else if ( (LA13_0==41) && (synpred3_FinexClass())) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:339: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:355: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:356: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C70D65F4D48011DE9EF9001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:415: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:416: ( (temp= firstLowercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:432: ( (temp= firstLowercaseIdentifier ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:433: (temp= firstLowercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70D65E8D48011DEB7F8001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:492: (temp= firstLowercaseIdentifier )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:494: temp= firstLowercaseIdentifier
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
                              _beforeSeqEl("E0356A04C70D65EBD48011DEB9DD001CBF0234BB");
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:4: ( (temp= firstUppercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:20: ( (temp= firstUppercaseIdentifier ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:21: (temp= firstUppercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70D65EFD48011DEA06A001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:80: (temp= firstUppercaseIdentifier )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:82: temp= firstUppercaseIdentifier
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
                              _beforeSeqEl("E0356A04C70D65F2D48011DE8E3F001CBF0234BB");
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
                      _beforeSeqEl("E0356A04C70D6601D48011DEB644001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:388: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:389: ( (temp= firstLowercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:405: ( (temp= firstLowercaseIdentifier ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:406: (temp= firstLowercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70D65F9D48011DEC24D001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:465: (temp= firstLowercaseIdentifier )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:467: temp= firstLowercaseIdentifier
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:4: ( (temp= firstUppercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:20: ( (temp= firstUppercaseIdentifier ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:21: (temp= firstUppercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70D65FFD48011DEC7D3001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:80: (temp= firstUppercaseIdentifier )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:82: temp= firstUppercaseIdentifier
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
                      _beforeSeqEl("E0356A04C70D6602D48011DEB02C001CBF0234BB");
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
                      _beforeSeqEl("E0356A04C70FD6E5D48011DEB1B0001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:410: ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () )
                    int alt11=3;
                    switch ( input.LA(1) ) {
                    case 43:
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
                    case 42:
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:411: ( 'DEFAULT' (temp= behavior_expressions_expression )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:427: ( 'DEFAULT' (temp= behavior_expressions_expression )? )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:428: 'DEFAULT' (temp= behavior_expressions_expression )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70D6603D48011DEC3CC001CBF0234BB");
                            }
                            match(input,43,FOLLOW_43_in_structure_field1011); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70D6605D48011DEBE87001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:571: (temp= behavior_expressions_expression )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>=STRING && LA9_0<=DATE)||LA9_0==DOT||LA9_0==LPAREN||(LA9_0>=51 && LA9_0<=52)||(LA9_0>=71 && LA9_0<=72)) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:573: temp= behavior_expressions_expression
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:4: ( ASSIGN (temp= behavior_expressions_expression )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:20: ( ASSIGN (temp= behavior_expressions_expression )? )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:21: ASSIGN (temp= behavior_expressions_expression )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70FD6E0D48011DE933B001CBF0234BB");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1037); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70FD6E2D48011DEBC1E001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:163: (temp= behavior_expressions_expression )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( ((LA10_0>=STRING && LA10_0<=DATE)||LA10_0==DOT||LA10_0==LPAREN||(LA10_0>=51 && LA10_0<=52)||(LA10_0>=71 && LA10_0<=72)) ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:165: temp= behavior_expressions_expression
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(2);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:20: ()
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:21: 
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:4: ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:46: ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:47: (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C70FD6E9D48011DE900F001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:106: (temp= structure_type_field )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:108: temp= structure_type_field
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
                      _beforeSeqEl("E0356A04C70FD6ECD48011DEBD33001CBF0234BB");
                    }
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "name", null, null, "OCL:self.type.name", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C70FD6EDD48011DE8058001CBF0234BB");
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
                      _beforeSeqEl("E0356A04C70FD6F9D48011DECDDF001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:490: ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () )
                    int alt12=3;
                    switch ( input.LA(1) ) {
                    case 43:
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
                    case 42:
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:491: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:507: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:508: 'DEFAULT' (temp= behavior_expressions_expression )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70FD6EED48011DEA236001CBF0234BB");
                            }
                            match(input,43,FOLLOW_43_in_structure_field1106); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70FD6F1D48011DE8AFA001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:651: (temp= behavior_expressions_expression )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:653: temp= behavior_expressions_expression
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:4: ( ASSIGN (temp= behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:20: ( ASSIGN (temp= behavior_expressions_expression ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:21: ASSIGN (temp= behavior_expressions_expression )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70FD6F3D48011DE888C001CBF0234BB");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1130); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C70FD6F6D48011DEACC6001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:163: (temp= behavior_expressions_expression )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:165: temp= behavior_expressions_expression
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(2);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:20: ()
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:405:21: 
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
              _beforeSeqEl("E0356A04C70FD6FED48011DEC66F001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:413:1: structure_field_opposite returns [Object ret2] : ( (temp= firstLowercaseIdentifier ) ) ;
    public final Object structure_field_opposite() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"opposite");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:418:3: ( ( (temp= firstLowercaseIdentifier ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:3: ( (temp= firstLowercaseIdentifier ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:3: ( (temp= firstLowercaseIdentifier ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:4: (temp= firstLowercaseIdentifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C71220D2D48011DEB775001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:63: (temp= firstLowercaseIdentifier )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:419:65: temp= firstLowercaseIdentifier
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
              _beforeSeqEl("E0356A04C71220DBD48011DEA284001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:427:1: structure_field_nondeclaredOpposite returns [Object ret2] : () ;
    public final Object structure_field_nondeclaredOpposite() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"nondeclaredOpposite");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:432:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:433:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C71491DAD48011DE80D5001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:441:1: askey[Object ret] : ( ( ( 'AS' 'KEY' ) | ) ) ;
    public final void askey(Object ret) throws RecognitionException {
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:3: ( ( ( ( 'AS' 'KEY' ) | ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:3: ( ( ( 'AS' 'KEY' ) | ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:3: ( ( ( 'AS' 'KEY' ) | ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:4: ( ( 'AS' 'KEY' ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C716DBC6D48011DEB65C001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:64: ( ( 'AS' 'KEY' ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==44) ) {
                alt14=1;
            }
            else if ( (LA14_0==EOF||LA14_0==SEMICOLON||LA14_0==ASSIGN||(LA14_0>=42 && LA14_0<=43)) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:65: ( 'AS' 'KEY' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:81: ( 'AS' 'KEY' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:82: 'AS' 'KEY'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C716DBC3D48011DEA781001CBF0234BB");
                    }
                    match(input,44,FOLLOW_44_in_askey1294); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C716DBC4D48011DEB5DB001CBF0234BB");
                    }
                    match(input,45,FOLLOW_45_in_askey1297); if (state.failed) return ;
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:443:309: 
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:451:1: behavior_functions_function returns [Object ret2] : ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) ) ;
    public final Object behavior_functions_function() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","functions","Function");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:3: ( ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:3: ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:3: ( ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:4: ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7194CCBD48011DE8EEA001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:63: ( ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) ) | ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==46) ) {
                alt15=1;
            }
            else if ( (LA15_0==47) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:64: ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:80: ( 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:81: 'function' functionheader[ret] (temp= behavior_functions_signatureimplementation )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7194CC0D48011DEB1D2001CBF0234BB");
                    }
                    match(input,46,FOLLOW_46_in_behavior_functions_function1347); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7194CC1D48011DEBF1B001CBF0234BB");
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
                      _beforeSeqEl("E0356A04C7194CC3D48011DECFE5001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:319: (temp= behavior_functions_signatureimplementation )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:321: temp= behavior_functions_signatureimplementation
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:4: ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:20: ( 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:21: 'manipulator' functionheader[ret] (temp= behavior_functions_signatureimplementation_manipulator )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7194CC5D48011DE969F001CBF0234BB");
                    }
                    match(input,47,FOLLOW_47_in_behavior_functions_function1374); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7194CC6D48011DEC82E001CBF0234BB");
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
                      _beforeSeqEl("E0356A04C7194CC9D48011DEB93C001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:262: (temp= behavior_functions_signatureimplementation_manipulator )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:264: temp= behavior_functions_signatureimplementation_manipulator
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:466:1: functionheader[Object ret] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON ) ;
    public final void functionheader(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:467:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C71B96B3D48011DE8599001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7194CD1D48011DE91D0001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:140: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:142: temp= firstLowercaseIdentifier
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7194CD5D48011DE9A2F001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:82: temp= firstUppercaseIdentifier
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:20: ()
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:21: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C71B96B1D48011DE97AB001CBF0234BB");
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
              _beforeSeqEl("E0356A04C71B96B4D48011DE9704001CBF0234BB");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_functionheader1481); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C71B96D3D48011DEC0EC001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:323: ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==48) ) {
                alt21=1;
            }
            else if ( (LA21_0==50) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:324: ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:340: ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:341: 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C71B96B5D48011DEAC5E001CBF0234BB");
                    }
                    match(input,48,FOLLOW_48_in_functionheader1490); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C71B96BCD48011DE808A001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:479: (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:481: temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )*
                    {
                    pushFollow(FOLLOW_behavior_functions_parameter_IN_in_functionheader1497);
                    temp=behavior_functions_parameter_IN();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:558: ( ( ',' ) temp= behavior_functions_parameter_IN )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==49) ) {
                            int LA17_1 = input.LA(2);

                            if ( ((LA17_1>=FIRST_LOWERCASE_NAME && LA17_1<=FIRST_UPPERCASE_NAME)) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:559: ( ',' ) temp= behavior_functions_parameter_IN
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:576: ( ',' )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:577: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0356A04C71B96B8D48011DE81B8001CBF0234BB");
                    	    }
                    	    match(input,49,FOLLOW_49_in_functionheader1505); if (state.failed) return ;
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
                      _beforeSeqEl("E0356A04C71B96C8D48011DEB130001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:828: ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==49) ) {
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:829: ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:845: ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:846: ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C71B96BDD48011DECC5E001CBF0234BB");
                            }
                            match(input,49,FOLLOW_49_in_functionheader1526); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C71B96BED48011DECA17001CBF0234BB");
                            }
                            match(input,50,FOLLOW_50_in_functionheader1529); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0356A04C71B96C5D48011DECBAA001CBF0234BB");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1063: (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1065: temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                            {
                            pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_functionheader1536);
                            temp=behavior_functions_parameter_OUT();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "parameters", temp);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1143: ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==49) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1144: ( ',' ) temp= behavior_functions_parameter_OUT
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1161: ( ',' )
                            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:1162: ','
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0356A04C71B96C1D48011DE89D1001CBF0234BB");
                            	    }
                            	    match(input,49,FOLLOW_49_in_functionheader1544); if (state.failed) return ;
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:20: ()
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:21: 
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:4: ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:20: ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:21: 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C71B96CAD48011DEAFAD001CBF0234BB");
                    }
                    match(input,50,FOLLOW_50_in_functionheader1585); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C71B96D1D48011DE9C50001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:160: (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:162: temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                    {
                    pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_functionheader1592);
                    temp=behavior_functions_parameter_OUT();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:240: ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==49) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:241: ( ',' ) temp= behavior_functions_parameter_OUT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:258: ( ',' )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:259: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0356A04C71B96CDD48011DEAFE7001CBF0234BB");
                    	    }
                    	    match(input,49,FOLLOW_49_in_functionheader1600); if (state.failed) return ;
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
              _beforeSeqEl("E0356A04C71E07B0D48011DE860A001CBF0234BB");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_functionheader1622); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C71E07B1D48011DE9386001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:479:1: parameter[Object ret] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) ) ;
    public final void parameter(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:480:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C72078B8D48011DE9A21001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C72078B2D48011DEC0B1001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:140: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:481:142: temp= firstLowercaseIdentifier
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C72078B6D48011DEBCC8001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:82: temp= firstUppercaseIdentifier
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
              _beforeSeqEl("E0356A04C72078C5D48011DE8311001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:253: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:254: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:270: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:271: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C72078BDD48011DEA42B001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:330: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:482:332: temp= firstLowercaseIdentifier
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C72078C3D48011DEC78B001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:82: temp= firstUppercaseIdentifier
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
              _beforeSeqEl("E0356A04C72078CDD48011DEC828001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:326: ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==43) ) {
                alt24=1;
            }
            else if ( (LA24_0==RPAREN||LA24_0==49) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:327: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:343: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:344: 'DEFAULT' (temp= behavior_expressions_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C72078C9D48011DEA101001CBF0234BB");
                    }
                    match(input,43,FOLLOW_43_in_parameter1738); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C72078CBD48011DEC67E001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:487: (temp= behavior_expressions_expression )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:489: temp= behavior_expressions_expression
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:483:602: 
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:491:1: behavior_functions_parameter_IN returns [Object ret2] : ( parameter[ret] ) ;
    public final Object behavior_functions_parameter_IN() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","functions","Parameter");
        onEnterTemplateRule(metaType,"IN");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:496:3: ( ( parameter[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:3: ( parameter[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:3: ( parameter[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:497:4: parameter[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C722C2A0D48011DE9FFB001CBF0234BB");
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
              _beforeSeqEl("E0356A04C722C2A3D48011DEB28B001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:505:1: behavior_functions_parameter_OUT returns [Object ret2] : ( parameter[ret] ) ;
    public final Object behavior_functions_parameter_OUT() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","functions","Parameter");
        onEnterTemplateRule(metaType,"OUT");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:510:3: ( ( parameter[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:3: ( parameter[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:3: ( parameter[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:511:4: parameter[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C72533A2D48011DEBF13001CBF0234BB");
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
              _beforeSeqEl("E0356A04C7277D92D48011DE9685001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:519:1: behavior_functions_signatureimplementation returns [Object ret2] : (ret= behavior_actions_block ) ;
    public final Object behavior_functions_signatureimplementation() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:520:3: ( (ret= behavior_actions_block ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:3: (ret= behavior_actions_block )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:3: (ret= behavior_actions_block )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:521:4: ret= behavior_actions_block
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:528:1: behavior_actions_block returns [Object ret2] : ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL ) ;
    public final Object behavior_actions_block() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:533:3: ( ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:3: ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:3: ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:4: LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C729EE90D48011DE9767001CBF0234BB");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_block1907); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C729EE94D48011DEA8AD001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:145: ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:147: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C729EE92D48011DEA2F4001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:206: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=STRING && LA26_0<=DATE)||LA26_0==DOT||LA26_0==LPAREN||(LA26_0>=51 && LA26_0<=52)||(LA26_0>=71 && LA26_0<=72)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:208: temp= behavior_actions_statement (temp= behavior_actions_statement )*
                    {
                    pushFollow(FOLLOW_behavior_actions_statement_in_behavior_actions_block1918);
                    temp=behavior_actions_statement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "statements", temp);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:280: (temp= behavior_actions_statement )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( ((LA25_0>=STRING && LA25_0<=DATE)||LA25_0==DOT||LA25_0==LPAREN||(LA25_0>=51 && LA25_0<=52)||(LA25_0>=71 && LA25_0<=72)) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:282: temp= behavior_actions_statement
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
              _beforeSeqEl("E0356A04C729EE95D48011DECD7B001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:542:1: behavior_functions_signatureimplementation_manipulator returns [Object ret2] : (ret= behavior_actions_manipulator_manipulator ) ;
    public final Object behavior_functions_signatureimplementation_manipulator() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:543:3: ( (ret= behavior_actions_manipulator_manipulator ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:3: (ret= behavior_actions_manipulator_manipulator )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:3: (ret= behavior_actions_manipulator_manipulator )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:544:4: ret= behavior_actions_manipulator_manipulator
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:551:1: behavior_actions_manipulator_manipulator returns [Object ret2] : ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL ) ;
    public final Object behavior_actions_manipulator_manipulator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","Manipulator");
        onEnterTemplateRule(metaType,"manipulator");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:556:3: ( ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:3: ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:3: ( LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:4: LCURL ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C72C5F90D48011DEA575001CBF0234BB");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_manipulator_manipulator2010); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C72C5F98D48011DECE79001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:145: ( ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:146: ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:146: ( (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:147: (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C72C5F96D48011DE9BA5001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:206: (temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:208: temp= behavior_actions_assignment_manipulator ( ( PIPE ) temp= behavior_actions_assignment_manipulator )*
            {
            pushFollow(FOLLOW_behavior_actions_assignment_manipulator_in_behavior_actions_manipulator_manipulator2021);
            temp=behavior_actions_assignment_manipulator();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "assignments", temp);
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:294: ( ( PIPE ) temp= behavior_actions_assignment_manipulator )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==PIPE) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:295: ( PIPE ) temp= behavior_actions_assignment_manipulator
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:312: ( PIPE )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:557:313: PIPE
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0356A04C72C5F93D48011DE99F7001CBF0234BB");
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
              _beforeSeqEl("E0356A04C72C5F99D48011DE9536001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:565:1: behavior_actions_statement returns [Object ret2] : (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement ) ;
    public final Object behavior_actions_statement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:566:3: ( (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:567:4: ret= behavior_actions_statementwithargument
                    {
                    pushFollow(FOLLOW_behavior_actions_statementwithargument_in_behavior_actions_statement2089);
                    ret=behavior_actions_statementwithargument();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:568:5: ret= behavior_actions_expressionstatement
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:575:1: behavior_actions_statementwithargument returns [Object ret2] : ( ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment ) ) ;
    public final Object behavior_actions_statementwithargument() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:576:3: ( ( ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:3: ( ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:3: ( ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:4: ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:23: (ret= behavior_actions_assignment )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:577:24: ret= behavior_actions_assignment
            {
            pushFollow(FOLLOW_behavior_actions_assignment_in_behavior_actions_statementwithargument2133);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:584:1: behavior_actions_assignment returns [Object ret2] : ( assignment[ret] SEMICOLON ) ;
    public final Object behavior_actions_assignment() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","actions","Assignment");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:3: ( ( assignment[ret] SEMICOLON ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:3: ( assignment[ret] SEMICOLON )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:3: ( assignment[ret] SEMICOLON )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:4: assignment[ret] SEMICOLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C735D570D48011DE9D17001CBF0234BB");
            }
            pushFollow(FOLLOW_assignment_in_behavior_actions_assignment2164);
            assignment(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C735D571D48011DE81F9001CBF0234BB");
            }
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_actions_assignment2169); if (state.failed) return ret2;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:598:1: behavior_actions_assignment_manipulator returns [Object ret2] : ( assignment[ret] ) ;
    public final Object behavior_actions_assignment_manipulator() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","actions","Assignment");
        onEnterTemplateRule(metaType,"manipulator");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:603:3: ( ( assignment[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:3: ( assignment[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:3: ( assignment[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:4: assignment[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C735D575D48011DEA222001CBF0234BB");
            }
            pushFollow(FOLLOW_assignment_in_behavior_actions_assignment_manipulator2210);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:612:1: assignment[Object ret] : ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? ) ;
    public final void assignment(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:613:3: ( ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:3: ( DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )? )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:4: DOT ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) EQUALS (temp= behavior_expressions_expression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C735D579D48011DECEC2001CBF0234BB");
            }
            match(input,DOT,FOLLOW_DOT_in_assignment2246); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7381F69D48011DECC8B001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:143: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:144: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:160: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:161: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7381F61D48011DE995B001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:220: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:614:222: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_assignment2259);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7381F67D48011DE89E8001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_assignment2279);
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
              _beforeSeqEl("E0356A04C7381F6AD48011DE988C001CBF0234BB");
            }
            match(input,EQUALS,FOLLOW_EQUALS_in_assignment2291); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7381F6CD48011DEC328001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:418: (temp= behavior_expressions_expression )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=STRING && LA30_0<=DATE)||LA30_0==DOT||LA30_0==LPAREN||(LA30_0>=51 && LA30_0<=52)||(LA30_0>=71 && LA30_0<=72)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:615:420: temp= behavior_expressions_expression
                    {
                    pushFollow(FOLLOW_behavior_expressions_expression_in_assignment2299);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:1: behavior_actions_expressionstatement returns [Object ret2] : ( (temp= behavior_expressions_expression ) SEMICOLON ) ;
    public final Object behavior_actions_expressionstatement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","ExpressionStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:627:3: ( ( (temp= behavior_expressions_expression ) SEMICOLON ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:3: ( (temp= behavior_expressions_expression ) SEMICOLON )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:3: ( (temp= behavior_expressions_expression ) SEMICOLON )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:4: (temp= behavior_expressions_expression ) SEMICOLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C73A9061D48011DEC40C001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:63: (temp= behavior_expressions_expression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_actions_expressionstatement2338);
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
              _beforeSeqEl("E0356A04C73A9062D48011DE8168001CBF0234BB");
            }
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_actions_expressionstatement2345); if (state.failed) return ret2;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:636:1: primary_behavior_expressions_expression returns [Object ret2] : (ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) ;
    public final Object primary_behavior_expressions_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:637:3: ( (ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:3: (ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:3: (ret= behavior_expressions_objectcreationexpression | ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ret= behavior_expressions_this | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            int alt31=5;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt31=1;
                }
                break;
            case STRING:
            case INT:
            case FLOAT:
            case BOOL:
            case BINARY:
            case DATE:
                {
                alt31=2;
                }
                break;
            case DOT:
                {
                alt31=3;
                }
                break;
            case 72:
                {
                alt31=4;
                }
                break;
            case LPAREN:
                {
                alt31=5;
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:4: ret= behavior_expressions_objectcreationexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_objectcreationexpression_in_primary_behavior_expressions_expression2383);
                    ret=behavior_expressions_objectcreationexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:639:5: ret= behavior_expressions_literals_literal
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2391);
                    ret=behavior_expressions_literals_literal();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:5: ret= behavior_expressions_firstpathexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2399);
                    ret=behavior_expressions_firstpathexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:641:5: ret= behavior_expressions_this
                    {
                    pushFollow(FOLLOW_behavior_expressions_this_in_primary_behavior_expressions_expression2407);
                    ret=behavior_expressions_this();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:642:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    {
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:642:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:642:6: LPAREN ret= behavior_expressions_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_behavior_expressions_expression2416); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2422);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_behavior_expressions_expression2426); if (state.failed) return ret2;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:1: expressions_priority_0 returns [Object ret2] : ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object expressions_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:650:3: ( ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=51 && LA35_0<=52)) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=STRING && LA35_0<=DATE)||LA35_0==DOT||LA35_0==LPAREN||(LA35_0>=71 && LA35_0<=72)) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
                    {
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==51) && (synpred5_FinexClass())) {
                        alt32=1;
                    }
                    else if ( (LA32_0==52) && (synpred6_FinexClass())) {
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:6: ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:13: ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:14: '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("-", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,51,FOLLOW_51_in_expressions_priority_02467); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "-";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:94: ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:96: ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02474);
                            ret=behavior_expressions_unaryminus(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02478);
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:3: ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:12: ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:13: 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("not", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,52,FOLLOW_52_in_expressions_priority_02495); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "not";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:99: ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:101: ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_not_in_expressions_priority_02502);
                            ret=behavior_expressions_not(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02506);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    {
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:4: ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
                    {
                    pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02522);
                    ret=primary_behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:47: ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
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
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:48: ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:55: ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:56: DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq(".", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,DOT,FOLLOW_DOT_in_expressions_priority_02531); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = ".";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:137: ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_tuple[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
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
                    	    case 66:
                    	        {
                    	        alt33=4;
                    	        }
                    	        break;
                    	    case 67:
                    	    case 68:
                    	    case 69:
                    	    case 70:
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
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:139: ret= behavior_expressions_booleanaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02539);
                    	            ret=behavior_expressions_booleanaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:659:4: ret= behavior_expressions_count[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_count_in_expressions_priority_02548);
                    	            ret=behavior_expressions_count(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:660:4: ret= behavior_expressions_single[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_single_in_expressions_priority_02557);
                    	            ret=behavior_expressions_single(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:3: (ret= behavior_expressions_tuple[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:3: (ret= behavior_expressions_tuple[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:661:4: ret= behavior_expressions_tuple[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_tuple_in_expressions_priority_02566);
                    	            ret=behavior_expressions_tuple(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:662:4: ret= behavior_expressions_numericaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02575);
                    	            ret=behavior_expressions_numericaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 6 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:663:4: ret= behavior_expressions_pathexpression[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02584);
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
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:3: ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:15: ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:16: LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq("[", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_expressions_priority_02600); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = "[";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:102: ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    {
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:104: ret= behavior_expressions_filterexpression[opName, ret, firstToken]
                    	    {
                    	    pushFollow(FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02608);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:672:1: expressions_priority_1 returns [Object ret2] : ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) ;
    public final Object expressions_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:673:3: ( ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:8: ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12649);
            ret=expressions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:34: ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            loop36:
            do {
                int alt36=4;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==53) && (synpred9_FinexClass())) {
                    alt36=1;
                }
                else if ( (LA36_0==54) && (synpred10_FinexClass())) {
                    alt36=2;
                }
                else if ( (LA36_0==55) && (synpred11_FinexClass())) {
                    alt36=3;
                }


                switch (alt36) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:35: ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:42: ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:43: '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("*", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,53,FOLLOW_53_in_expressions_priority_12658); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "*";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:123: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:125: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12665);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12669);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:3: ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:10: ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:11: '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("/", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,54,FOLLOW_54_in_expressions_priority_12686); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "/";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12693);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12697);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:3: ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:12: ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:13: 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("AND", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,55,FOLLOW_55_in_expressions_priority_12714); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "AND";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:99: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:101: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12721);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12725);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:690:1: expressions_priority_2 returns [Object ret2] : ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) ;
    public final Object expressions_priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:691:3: ( ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:8: ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22767);
            ret=expressions_priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:34: ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            loop37:
            do {
                int alt37=4;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==56) && (synpred12_FinexClass())) {
                    alt37=1;
                }
                else if ( (LA37_0==57) && (synpred13_FinexClass())) {
                    alt37=2;
                }
                else if ( (LA37_0==51) && (synpred14_FinexClass())) {
                    alt37=3;
                }


                switch (alt37) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:35: ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:43: ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:44: 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("OR", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,56,FOLLOW_56_in_expressions_priority_22776); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "OR";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:127: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:129: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22783);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22787);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:3: ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:10: ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:11: '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,57,FOLLOW_57_in_expressions_priority_22804); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22811);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22815);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:3: ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:10: ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:11: '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("-", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,51,FOLLOW_51_in_expressions_priority_22832); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "-";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22839);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22843);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:708:1: expressions_priority_3 returns [Object ret2] : ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) ;
    public final Object expressions_priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:709:3: ( ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:8: ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32885);
            ret=expressions_priority_2();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:34: ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
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
                else if ( (LA38_0==58) && (synpred17_FinexClass())) {
                    alt38=3;
                }
                else if ( (LA38_0==59) && (synpred18_FinexClass())) {
                    alt38=4;
                }
                else if ( (LA38_0==EQUALS) && (synpred19_FinexClass())) {
                    alt38=5;
                }
                else if ( (LA38_0==60) && (synpred20_FinexClass())) {
                    alt38=6;
                }


                switch (alt38) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:35: ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:45: ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:46: RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,RANGLE,FOLLOW_RANGLE_in_expressions_priority_32894); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:130: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:132: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32902);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32906);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:3: ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:13: ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:14: LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LANGLE,FOLLOW_LANGLE_in_expressions_priority_32923); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:98: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:100: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32931);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32935);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:3: ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:11: ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:12: '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,58,FOLLOW_58_in_expressions_priority_32952); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32959);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32963);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:3: ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:11: ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:12: '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,59,FOLLOW_59_in_expressions_priority_32980); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32987);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32991);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:3: ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:13: ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:14: EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQUALS,FOLLOW_EQUALS_in_expressions_priority_33008); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:98: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:100: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33016);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33020);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:3: ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:11: ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:12: '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("!=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,60,FOLLOW_60_in_expressions_priority_33037); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "!=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33044);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_33048);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:735:1: behavior_expressions_expression returns [Object ret2] : ret= expressions_priority_3 ;
    public final Object behavior_expressions_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:736:3: (ret= expressions_priority_3 )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:737:3: ret= expressions_priority_3
            {
            pushFollow(FOLLOW_expressions_priority_3_in_behavior_expressions_expression3081);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:744:1: alias[Object ret] : ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) ) ;
    public final void alias(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:745:3: ( ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:3: ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:3: ( ( ( 'AS' (temp= behavior_expressions_alias ) ) | ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:4: ( ( 'AS' (temp= behavior_expressions_alias ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C73F4B57D48011DEC226001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:64: ( ( 'AS' (temp= behavior_expressions_alias ) ) | )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==44) ) {
                alt39=1;
            }
            else if ( (LA39_0==EOF||(LA39_0>=STRING && LA39_0<=DATE)||(LA39_0>=SEMICOLON && LA39_0<=DOT)||(LA39_0>=LPAREN && LA39_0<=RPAREN)||(LA39_0>=RCURL && LA39_0<=LANGLE)||LA39_0==42||LA39_0==49||(LA39_0>=51 && LA39_0<=60)||(LA39_0>=71 && LA39_0<=72)) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:65: ( 'AS' (temp= behavior_expressions_alias ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:81: ( 'AS' (temp= behavior_expressions_alias ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:82: 'AS' (temp= behavior_expressions_alias )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C73F4B53D48011DEBBE1001CBF0234BB");
                    }
                    match(input,44,FOLLOW_44_in_alias3110); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C73F4B55D48011DE85D7001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:220: (temp= behavior_expressions_alias )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:222: temp= behavior_expressions_alias
                    {
                    pushFollow(FOLLOW_behavior_expressions_alias_in_alias3117);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:323: 
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:754:1: behavior_expressions_alias returns [Object ret2] : ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_alias() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Alias");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:759:3: ( ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:3: ( ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:4: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C741BC58D48011DEC5D6001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:63: ( ( (temp= firstUppercaseIdentifier ) ) | ( (temp= firstLowercaseIdentifier ) ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:64: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:80: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:81: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C741BC52D48011DE8945001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:140: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:760:142: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias3172);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:4: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:20: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:21: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C741BC56D48011DE8DAA001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:80: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:82: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias3192);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:769:1: behavior_expressions_binarybooleanoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_binarybooleanoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryBooleanOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:774:3: ( ( alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:775:3: ( alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:775:3: ( alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:775:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7440643D48011DE9C29001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_binarybooleanoperator3241);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7440646D48011DE9344001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:785:1: behavior_expressions_not[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_not(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Not");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:790:3: ( ( alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:791:3: ( alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:791:3: ( alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:791:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7467741D48011DE9E11001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_not3278);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7467744D48011DEA35B001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:801:1: behavior_expressions_booleanaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_booleanaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BooleanAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:806:3: ( ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:4: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C74B3240D48011DE91B4001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:63: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:64: ( 'and' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:80: ( 'and' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:81: 'and'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C74B3231D48011DEC1C2001CBF0234BB");
                    }
                    match(input,61,FOLLOW_61_in_behavior_expressions_booleanaggregate3320); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C74B3234D48011DEAD3D001CBF0234BB");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:4: ( 'or' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:20: ( 'or' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:21: 'or'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C74B3236D48011DE9E8A001CBF0234BB");
                    }
                    match(input,62,FOLLOW_62_in_behavior_expressions_booleanaggregate3336); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C74B3239D48011DE92C8001CBF0234BB");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:4: ( 'xor' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:20: ( 'xor' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:21: 'xor'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C74B323BD48011DEC0B6001CBF0234BB");
                    }
                    match(input,63,FOLLOW_63_in_behavior_expressions_booleanaggregate3352); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C74B323ED48011DE837B001CBF0234BB");
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
              _beforeSeqEl("E0356A04C74B3241D48011DE8E43001CBF0234BB");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate3364); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C74B3242D48011DEC5CA001CBF0234BB");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate3369); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C74B3243D48011DEBA77001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_booleanaggregate3373);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C74B3246D48011DE903B001CBF0234BB");
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


    // $ANTLR start "behavior_expressions_binarynumericoperator"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:819:1: behavior_expressions_binarynumericoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : () ;
    public final Object behavior_expressions_binarynumericoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryNumericOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:824:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:825:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C74DA335D48011DEC672001CBF0234BB");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.numericPostType(self.operator, self.left.type, self.right.type)", true);_exitInjectorAction();
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
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "behavior_expressions_binarynumericoperator"


    // $ANTLR start "behavior_expressions_unaryminus"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:835:1: behavior_expressions_unaryminus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( alias[ret] ) ;
    public final Object behavior_expressions_unaryminus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","UnaryMinus");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:840:3: ( ( alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:841:3: ( alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:841:3: ( alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:841:4: alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7525E22D48011DEA701001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_unaryminus3443);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7525E25D48011DE9958001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:1: behavior_expressions_count[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'count' LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_count(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Count");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:856:3: ( ( 'count' LPAREN RPAREN alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:857:3: ( 'count' LPAREN RPAREN alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:857:3: ( 'count' LPAREN RPAREN alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:857:4: 'count' LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C754A811D48011DE9BDC001CBF0234BB");
            }
            match(input,64,FOLLOW_64_in_behavior_expressions_count3480); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C754A814D48011DE90EF001CBF0234BB");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C754A815D48011DEC4E2001CBF0234BB");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_count3487); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C754A816D48011DE9B86001CBF0234BB");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_count3492); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C754A817D48011DEBE3F001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_count3496);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:867:1: behavior_expressions_single[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'single' LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_single(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Single");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:872:3: ( ( 'single' LPAREN RPAREN alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:873:3: ( 'single' LPAREN RPAREN alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:873:3: ( 'single' LPAREN RPAREN alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:873:4: 'single' LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7571911D48011DEA1CF001CBF0234BB");
            }
            match(input,65,FOLLOW_65_in_behavior_expressions_single3530); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7571914D48011DE81C2001CBF0234BB");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7571915D48011DEC8DC001CBF0234BB");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_single3537); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7571916D48011DE9784001CBF0234BB");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_single3542); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7571917D48011DEC7F4001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_single3546);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:883:1: behavior_expressions_tuple[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'tuple' (temp= structure_type_tuple ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_tuple(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","Tuple");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:888:3: ( ( 'tuple' (temp= structure_type_tuple ) LPAREN RPAREN alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:889:3: ( 'tuple' (temp= structure_type_tuple ) LPAREN RPAREN alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:889:3: ( 'tuple' (temp= structure_type_tuple ) LPAREN RPAREN alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:889:4: 'tuple' (temp= structure_type_tuple ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7598A11D48011DE9462001CBF0234BB");
            }
            match(input,66,FOLLOW_66_in_behavior_expressions_tuple3580); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7598A14D48011DE96E8001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:889:145: (temp= structure_type_tuple )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:889:147: temp= structure_type_tuple
            {
            pushFollow(FOLLOW_structure_type_tuple_in_behavior_expressions_tuple3587);
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
              _beforeSeqEl("E0356A04C7598A15D48011DE86DD001CBF0234BB");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_tuple3594); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7598A16D48011DEA413001CBF0234BB");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_tuple3599); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7598A17D48011DEA820001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_tuple3603);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:899:1: structure_type_tuple returns [Object ret2] : (ret= structure_finexclass_tuple ) ;
    public final Object structure_type_tuple() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:900:3: ( (ret= structure_finexclass_tuple ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:901:3: (ret= structure_finexclass_tuple )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:901:3: (ret= structure_finexclass_tuple )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:901:4: ret= structure_finexclass_tuple
            {
            pushFollow(FOLLOW_structure_finexclass_tuple_in_structure_type_tuple3633);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:908:1: structure_finexclass_tuple returns [Object ret2] : () ;
    public final Object structure_finexclass_tuple() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","FinexClass");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:913:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:914:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:914:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:914:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C75E4509D48011DE8AC0001CBF0234BB");
            }
            if ( state.backtracking==0 ) {
              List<PredicateSemantic> list = new ArrayList<PredicateSemantic>();
              RuleNameFinder finder = new RuleNameFinder();
              list.add(new PredicateSemantic(null, "structure_association_tuple"));
              setPredicateRef(ret,"associations","tuple","OCL:self.typedElement.oclAsType(\"Tuple\").operand.getAllAliases()",list,finder,true);_exitInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.typedElement.oclAsType(\"Tuple\").operand.getAllAliases()->iterate("+"			 			a; acc='TupleType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement.oclAsType(\"Tuple\").getEnclosingType().oclAsType(FinexClass)", true);_exitInjectorAction();
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:925:1: structure_association_tuple returns [Object ret2] : ( (temp= structure_field_tupleLocalEnd ) (temp= structure_field_tupleOtherEnd ) ) ;
    public final Object structure_association_tuple() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType,"tuple");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:930:3: ( ( (temp= structure_field_tupleLocalEnd ) (temp= structure_field_tupleOtherEnd ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:931:3: ( (temp= structure_field_tupleLocalEnd ) (temp= structure_field_tupleOtherEnd ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:931:3: ( (temp= structure_field_tupleLocalEnd ) (temp= structure_field_tupleOtherEnd ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:931:4: (temp= structure_field_tupleLocalEnd ) (temp= structure_field_tupleOtherEnd )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7608EF2D48011DE9DC0001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:931:63: (temp= structure_field_tupleLocalEnd )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:931:65: temp= structure_field_tupleLocalEnd
            {
            pushFollow(FOLLOW_structure_field_tupleLocalEnd_in_structure_association_tuple3707);
            temp=structure_field_tupleLocalEnd();

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
              _beforeSeqEl("E0356A04C7608EF7D48011DEB2F8001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:931:209: (temp= structure_field_tupleOtherEnd )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:931:211: temp= structure_field_tupleOtherEnd
            {
            pushFollow(FOLLOW_structure_field_tupleOtherEnd_in_structure_association_tuple3717);
            temp=structure_field_tupleOtherEnd();

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
              _beforeSeqEl("E0356A04C7608EFAD48011DE9123001CBF0234BB");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:'Tuple_to_'.concat(#context.oclAsType(Alias).name)", true);_exitInjectorAction();
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


    // $ANTLR start "structure_field_tupleLocalEnd"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:939:1: structure_field_tupleLocalEnd returns [Object ret2] : () ;
    public final Object structure_field_tupleLocalEnd() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"tupleLocalEnd");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:944:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:945:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:945:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:945:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7608F0AD48011DE9BBF001CBF0234BB");
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


    // $ANTLR start "structure_field_tupleOtherEnd"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:953:1: structure_field_tupleOtherEnd returns [Object ret2] : () ;
    public final Object structure_field_tupleOtherEnd() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"tupleOtherEnd");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:958:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:959:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:959:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:959:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C762FFFCD48011DEA3A1001CBF0234BB");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:#context.oclAsType(Alias).name", true);_exitInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();setProperty(ret, "key", false);_exitInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:#context.oclAsType(Alias).aliasFor.type", true);_exitInjectorAction();
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
    // $ANTLR end "structure_field_tupleOtherEnd"


    // $ANTLR start "behavior_expressions_numericaggregate"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:967:1: behavior_expressions_numericaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] ) ;
    public final Object behavior_expressions_numericaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","NumericAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:972:3: ( ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:973:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:973:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:973:4: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76549F5D48011DE9BF4001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:973:63: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) )
            int alt42=4;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt42=1;
                }
                break;
            case 68:
                {
                alt42=2;
                }
                break;
            case 69:
                {
                alt42=3;
                }
                break;
            case 70:
                {
                alt42=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:973:64: ( 'sum' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:973:80: ( 'sum' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:973:81: 'sum'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76549E1D48011DE8B23001CBF0234BB");
                    }
                    match(input,67,FOLLOW_67_in_behavior_expressions_numericaggregate3849); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76549E4D48011DEB22A001CBF0234BB");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:974:4: ( 'avg' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:974:20: ( 'avg' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:974:21: 'avg'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76549E6D48011DEA799001CBF0234BB");
                    }
                    match(input,68,FOLLOW_68_in_behavior_expressions_numericaggregate3865); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76549E9D48011DE9761001CBF0234BB");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:4: ( 'min' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:20: ( 'min' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:975:21: 'min'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76549EBD48011DE8473001CBF0234BB");
                    }
                    match(input,69,FOLLOW_69_in_behavior_expressions_numericaggregate3881); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76549EED48011DE94EB001CBF0234BB");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:4: ( 'max' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:20: ( 'max' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:976:21: 'max'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76549F0D48011DE873A001CBF0234BB");
                    }
                    match(input,70,FOLLOW_70_in_behavior_expressions_numericaggregate3897); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76549F3D48011DEB17A001CBF0234BB");
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
              _beforeSeqEl("E0356A04C767BAE0D48011DE9775001CBF0234BB");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_numericaggregate3909); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C767BAE1D48011DE9CFB001CBF0234BB");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_numericaggregate3914); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C767BAE2D48011DEC400001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_numericaggregate3918);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C767BAE5D48011DE9369001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:986:1: behavior_expressions_objectcreationexpression returns [Object ret2] : ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN ) ;
    public final Object behavior_expressions_objectcreationexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","ObjectCreationExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:991:3: ( ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:3: ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:3: ( 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:4: 'create' (temp= firstUppercaseIdentifier ) LPAREN (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76A2BE0D48011DEAC39001CBF0234BB");
            }
            match(input,71,FOLLOW_71_in_behavior_expressions_objectcreationexpression3954); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76A2BE5D48011DEC254001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:146: (temp= firstUppercaseIdentifier )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:148: temp= firstUppercaseIdentifier
            {
            pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_objectcreationexpression3961);
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
              _beforeSeqEl("E0356A04C76A2BE8D48011DEAD5A001CBF0234BB");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:classToInstantiate", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76A2BE9D48011DE844A001CBF0234BB");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_objectcreationexpression3971); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76A2BEED48011DE99BB001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:622: (temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=FIRST_LOWERCASE_NAME && LA44_0<=FIRST_UPPERCASE_NAME)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:624: temp= behavior_expressions_fieldinitializer ( ( ',' ) temp= behavior_expressions_fieldinitializer )*
                    {
                    pushFollow(FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression3979);
                    temp=behavior_expressions_fieldinitializer();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "fieldInitializers", temp);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:714: ( ( ',' ) temp= behavior_expressions_fieldinitializer )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==49) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:715: ( ',' ) temp= behavior_expressions_fieldinitializer
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:732: ( ',' )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:992:733: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0356A04C76A2BEBD48011DE8F01001CBF0234BB");
                    	    }
                    	    match(input,49,FOLLOW_49_in_behavior_expressions_objectcreationexpression3987); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression3994);
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
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76A2BEFD48011DEA004001CBF0234BB");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_objectcreationexpression4006); if (state.failed) return ret2;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1000:1: behavior_expressions_fieldinitializer returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) ;
    public final Object behavior_expressions_fieldinitializer() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FieldInitializer");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1005:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON (temp= behavior_expressions_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76C75DCD48011DEB1F1001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==FIRST_LOWERCASE_NAME) ) {
                alt45=1;
            }
            else if ( (LA45_0==FIRST_UPPERCASE_NAME) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76C75D4D48011DEACF7001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:140: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1006:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_fieldinitializer4056);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C76C75DAD48011DEA19A001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_fieldinitializer4076);
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
              _beforeSeqEl("E0356A04C76C75DDD48011DEA297001CBF0234BB");
            }
            match(input,COLON,FOLLOW_COLON_in_behavior_expressions_fieldinitializer4088); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76C75DFD48011DE8D43001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:447: (temp= behavior_expressions_expression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1007:449: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_fieldinitializer4096);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1015:1: behavior_expressions_this returns [Object ret2] : ( 'this' alias[ret] ) ;
    public final Object behavior_expressions_this() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","This");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1020:3: ( ( 'this' alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1021:3: ( 'this' alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1021:3: ( 'this' alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1021:4: 'this' alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76EE6D0D48011DEADA2001CBF0234BB");
            }
            match(input,72,FOLLOW_72_in_behavior_expressions_this4139); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76EE6D1D48011DEA001001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_this4142);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C76EE6D4D48011DEB5BF001CBF0234BB");
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


    // $ANTLR start "behavior_expressions_expression_pathExpression"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1029:1: behavior_expressions_expression_pathExpression returns [Object ret2] : (ret= behavior_expressions_implicitcontext_pathExpression ) ;
    public final Object behavior_expressions_expression_pathExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1030:3: ( (ret= behavior_expressions_implicitcontext_pathExpression ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1031:3: (ret= behavior_expressions_implicitcontext_pathExpression )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1031:3: (ret= behavior_expressions_implicitcontext_pathExpression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1031:4: ret= behavior_expressions_implicitcontext_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_implicitcontext_pathExpression_in_behavior_expressions_expression_pathExpression4183);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1038:1: behavior_expressions_implicitcontext_pathExpression returns [Object ret2] : () ;
    public final Object behavior_expressions_implicitcontext_pathExpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","ImplicitContext");
        onEnterTemplateRule(metaType,"pathExpression");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1043:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1044:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1044:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1044:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C773A1C0D48011DE818E001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1052:1: behavior_expressions_firstpathexpression returns [Object ret2] : ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) ;
    public final Object behavior_expressions_firstpathexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FirstPathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1057:3: ( ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:4: DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C773A1C4D48011DEA177001CBF0234BB");
            }
            match(input,DOT,FOLLOW_DOT_in_behavior_expressions_firstpathexpression4254); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C773A1C7D48011DE80B5001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:143: (temp= behavior_expressions_expression_pathExpression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:145: temp= behavior_expressions_expression_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression4262);
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
              _beforeSeqEl("E0356A04C773A1D4D48011DEBF7E001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:309: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==FIRST_LOWERCASE_NAME) ) {
                alt46=1;
            }
            else if ( (LA46_0==FIRST_UPPERCASE_NAME) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:310: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:326: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:327: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C773A1CCD48011DEA9F9001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:386: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1058:388: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression4277);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1059:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1059:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1059:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C773A1D2D48011DEAF8D001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1059:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1059:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression4297);
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
              _beforeSeqEl("E0356A04C773A1D5D48011DE84F8001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_firstpathexpression4308);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C773A1D8D48011DEA0F8001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1067:1: behavior_expressions_pathexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) ;
    public final Object behavior_expressions_pathexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","PathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1072:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7785CB5D48011DE91BC001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C77612C5D48011DE91DE001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:140: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1073:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression4362);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1074:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1074:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1074:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0356A04C7785CB3D48011DE8658001CBF0234BB");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1074:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1074:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression4382);
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
              _beforeSeqEl("E0356A04C7785CB6D48011DE94C6001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_pathexpression4393);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7785CB9D48011DEACF4001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1084:1: behavior_expressions_filterexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] ) ;
    public final Object behavior_expressions_filterexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FilterExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1089:3: ( ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:3: ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:3: ( (temp= behavior_expressions_expression ) RBRACKET alias[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:4: (temp= behavior_expressions_expression ) RBRACKET alias[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C77ACDB2D48011DE95DC001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:63: (temp= behavior_expressions_expression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1090:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression4434);
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
              _beforeSeqEl("E0356A04C77ACDB3D48011DECDB9001CBF0234BB");
            }
            match(input,RBRACKET,FOLLOW_RBRACKET_in_behavior_expressions_filterexpression4441); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C77ACDB4D48011DEAB31001CBF0234BB");
            }
            pushFollow(FOLLOW_alias_in_behavior_expressions_filterexpression4445);
            alias(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C77ACDB7D48011DE983D001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1100:1: behavior_expressions_literals_literal returns [Object ret2] : (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) ;
    public final Object behavior_expressions_literals_literal() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1101:3: ( (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1102:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1102:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            int alt48=6;
            switch ( input.LA(1) ) {
            case BOOL:
                {
                alt48=1;
                }
                break;
            case STRING:
                {
                alt48=2;
                }
                break;
            case FLOAT:
                {
                alt48=3;
                }
                break;
            case INT:
                {
                alt48=4;
                }
                break;
            case DATE:
                {
                alt48=5;
                }
                break;
            case BINARY:
                {
                alt48=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1102:4: ret= behavior_expressions_literals_booleanliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal4478);
                    ret=behavior_expressions_literals_booleanliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1103:5: ret= behavior_expressions_literals_stringliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal4486);
                    ret=behavior_expressions_literals_stringliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1104:5: ret= behavior_expressions_literals_decimalliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal4494);
                    ret=behavior_expressions_literals_decimalliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1105:5: ret= behavior_expressions_literals_integerliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal4502);
                    ret=behavior_expressions_literals_integerliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1106:5: ret= behavior_expressions_literals_dateliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal4510);
                    ret=behavior_expressions_literals_dateliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1107:5: ret= behavior_expressions_literals_binaryliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal4518);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1114:1: behavior_expressions_literals_booleanliteral returns [Object ret2] : ( (temp= booleanSymbol ) ) ;
    public final Object behavior_expressions_literals_booleanliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BooleanLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1119:3: ( ( (temp= booleanSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:3: ( (temp= booleanSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:3: ( (temp= booleanSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:4: (temp= booleanSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C781D290D48011DE91F5001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:63: (temp= booleanSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1120:65: temp= booleanSymbol
            {
            pushFollow(FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral4552);
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
              _beforeSeqEl("E0356A04C781D293D48011DE9E09001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1128:1: behavior_expressions_literals_stringliteral returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object behavior_expressions_literals_stringliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","StringLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1133:3: ( ( (temp= stringSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1134:3: ( (temp= stringSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1134:3: ( (temp= stringSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1134:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7844392D48011DECB70001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1134:63: (temp= stringSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1134:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral4602);
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
              _beforeSeqEl("E0356A04C7844395D48011DE850C001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1142:1: behavior_expressions_literals_decimalliteral returns [Object ret2] : ( (temp= floatAsStringSymbol ) ) ;
    public final Object behavior_expressions_literals_decimalliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DecimalLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1147:3: ( ( (temp= floatAsStringSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:3: ( (temp= floatAsStringSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:3: ( (temp= floatAsStringSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:4: (temp= floatAsStringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C788FE82D48011DE82E7001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:63: (temp= floatAsStringSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1148:65: temp= floatAsStringSymbol
            {
            pushFollow(FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral4652);
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
              _beforeSeqEl("E0356A04C788FE85D48011DEB111001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1156:1: behavior_expressions_literals_integerliteral returns [Object ret2] : ( (temp= integerAsStringSymbol ) ) ;
    public final Object behavior_expressions_literals_integerliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","IntegerLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1161:3: ( ( (temp= integerAsStringSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1162:3: ( (temp= integerAsStringSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1162:3: ( (temp= integerAsStringSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1162:4: (temp= integerAsStringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C78B6F82D48011DEA3B9001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1162:63: (temp= integerAsStringSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1162:65: temp= integerAsStringSymbol
            {
            pushFollow(FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral4702);
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
              _beforeSeqEl("E0356A04C78DB970D48011DEBE7B001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1170:1: behavior_expressions_literals_dateliteral returns [Object ret2] : ( (temp= dateSymbol ) ) ;
    public final Object behavior_expressions_literals_dateliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DateLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1175:3: ( ( (temp= dateSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1176:3: ( (temp= dateSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1176:3: ( (temp= dateSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1176:4: (temp= dateSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7902A72D48011DE9709001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1176:63: (temp= dateSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1176:65: temp= dateSymbol
            {
            pushFollow(FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral4752);
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
              _beforeSeqEl("E0356A04C7902A75D48011DEB62D001CBF0234BB");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1184:1: behavior_expressions_literals_binaryliteral returns [Object ret2] : ( (temp= binarySymbol ) ) ;
    public final Object behavior_expressions_literals_binaryliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BinaryLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1189:3: ( ( (temp= binarySymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1190:3: ( (temp= binarySymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1190:3: ( (temp= binarySymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1190:4: (temp= binarySymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0356A04C7929B72D48011DE8EDD001CBF0234BB");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1190:63: (temp= binarySymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:1190:65: temp= binarySymbol
            {
            pushFollow(FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral4802);
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
              _beforeSeqEl("E0356A04C7929B75D48011DEC092001CBF0234BB");
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
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:397: ( structure_association )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:398: structure_association
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
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:4: ( behavior_functions_function )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:5: behavior_functions_function
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
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:4: ( structure_type_field )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:5: structure_type_field
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
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:6: ( '-' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:651:7: '-'
        {
        match(input,51,FOLLOW_51_in_synpred5_FinexClass2461); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_FinexClass

    // $ANTLR start synpred6_FinexClass
    public final void synpred6_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:3: ( 'not' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:654:4: 'not'
        {
        match(input,52,FOLLOW_52_in_synpred6_FinexClass2489); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_FinexClass

    // $ANTLR start synpred7_FinexClass
    public final void synpred7_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:48: ( DOT )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:658:49: DOT
        {
        match(input,DOT,FOLLOW_DOT_in_synpred7_FinexClass2525); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_FinexClass

    // $ANTLR start synpred8_FinexClass
    public final void synpred8_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:3: ( LBRACKET )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:664:4: LBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred8_FinexClass2594); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_FinexClass

    // $ANTLR start synpred9_FinexClass
    public final void synpred9_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:35: ( '*' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:36: '*'
        {
        match(input,53,FOLLOW_53_in_synpred9_FinexClass2652); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_FinexClass

    // $ANTLR start synpred10_FinexClass
    public final void synpred10_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:3: ( '/' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:677:4: '/'
        {
        match(input,54,FOLLOW_54_in_synpred10_FinexClass2680); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_FinexClass

    // $ANTLR start synpred11_FinexClass
    public final void synpred11_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:3: ( 'AND' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:4: 'AND'
        {
        match(input,55,FOLLOW_55_in_synpred11_FinexClass2708); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_FinexClass

    // $ANTLR start synpred12_FinexClass
    public final void synpred12_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:35: ( 'OR' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:692:36: 'OR'
        {
        match(input,56,FOLLOW_56_in_synpred12_FinexClass2770); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_FinexClass

    // $ANTLR start synpred13_FinexClass
    public final void synpred13_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:3: ( '+' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:4: '+'
        {
        match(input,57,FOLLOW_57_in_synpred13_FinexClass2798); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_FinexClass

    // $ANTLR start synpred14_FinexClass
    public final void synpred14_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:3: ( '-' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:698:4: '-'
        {
        match(input,51,FOLLOW_51_in_synpred14_FinexClass2826); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_FinexClass

    // $ANTLR start synpred15_FinexClass
    public final void synpred15_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:35: ( RANGLE )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:710:36: RANGLE
        {
        match(input,RANGLE,FOLLOW_RANGLE_in_synpred15_FinexClass2888); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_FinexClass

    // $ANTLR start synpred16_FinexClass
    public final void synpred16_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:3: ( LANGLE )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:4: LANGLE
        {
        match(input,LANGLE,FOLLOW_LANGLE_in_synpred16_FinexClass2917); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_FinexClass

    // $ANTLR start synpred17_FinexClass
    public final void synpred17_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:3: ( '>=' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:716:4: '>='
        {
        match(input,58,FOLLOW_58_in_synpred17_FinexClass2946); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_FinexClass

    // $ANTLR start synpred18_FinexClass
    public final void synpred18_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:3: ( '<=' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:719:4: '<='
        {
        match(input,59,FOLLOW_59_in_synpred18_FinexClass2974); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_FinexClass

    // $ANTLR start synpred19_FinexClass
    public final void synpred19_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:3: ( EQUALS )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:722:4: EQUALS
        {
        match(input,EQUALS,FOLLOW_EQUALS_in_synpred19_FinexClass3002); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_FinexClass

    // $ANTLR start synpred20_FinexClass
    public final void synpred20_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:3: ( '!=' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:725:4: '!='
        {
        match(input,60,FOLLOW_60_in_synpred20_FinexClass3031); if (state.failed) return ;

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


    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA28_eotS =
        "\15\uffff";
    static final String DFA28_eofS =
        "\15\uffff";
    static final String DFA28_minS =
        "\1\6\14\uffff";
    static final String DFA28_maxS =
        "\1\110\14\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\12\uffff";
    static final String DFA28_specialS =
        "\15\uffff}>";
    static final String[] DFA28_transitionS = {
            "\6\2\4\uffff\1\1\2\uffff\1\2\37\uffff\2\2\22\uffff\2\2",
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

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "567:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )";
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
    public static final BitSet FOLLOW_41_in_classdeclaration516 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_classdeclaration543 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_classdeclaration563 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_classdeclaration575 = new BitSet(new long[]{0x0000C00000035000L});
    public static final BitSet FOLLOW_structure_association_in_classdeclaration597 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration604 = new BitSet(new long[]{0x0000C00000035000L});
    public static final BitSet FOLLOW_behavior_functions_function_in_classdeclaration628 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration635 = new BitSet(new long[]{0x0000C00000035000L});
    public static final BitSet FOLLOW_LBRACKET_in_classdeclaration650 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_classdeclaration658 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_classdeclaration665 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration670 = new BitSet(new long[]{0x0000C00000035000L});
    public static final BitSet FOLLOW_COLON_in_classdeclaration684 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_classdeclaration697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_classdeclaration717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_in_structure_type752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_field_in_structure_association786 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_structure_association797 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_structure_field_opposite_in_structure_association804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_field_nondeclaredOpposite_in_structure_association824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_structure_field881 = new BitSet(new long[]{0x0000020000000030L});
    public static final BitSet FOLLOW_DDOT_in_structure_field899 = new BitSet(new long[]{0x0000020000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field925 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field948 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field971 = new BitSet(new long[]{0x0000180000040000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field991 = new BitSet(new long[]{0x0000180000040000L});
    public static final BitSet FOLLOW_askey_in_structure_field1002 = new BitSet(new long[]{0x0000080000040002L});
    public static final BitSet FOLLOW_43_in_structure_field1011 = new BitSet(new long[]{0x0018000000090FC2L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1037 = new BitSet(new long[]{0x0018000000090FC2L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_structure_field1088 = new BitSet(new long[]{0x0000180000040000L});
    public static final BitSet FOLLOW_askey_in_structure_field1097 = new BitSet(new long[]{0x0000080000040002L});
    public static final BitSet FOLLOW_43_in_structure_field1106 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1130 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field_opposite1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_askey1294 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_askey1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_behavior_functions_function1347 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_functionheader_in_behavior_functions_function1350 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_behavior_functions_signatureimplementation_in_behavior_functions_function1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_behavior_functions_function1374 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_functionheader_in_behavior_functions_function1377 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_behavior_functions_signatureimplementation_manipulator_in_behavior_functions_function1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_functionheader1436 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_functionheader1456 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_functionheader1481 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_48_in_functionheader1490 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_IN_in_functionheader1497 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_49_in_functionheader1505 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_IN_in_functionheader1512 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_49_in_functionheader1526 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_functionheader1529 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_functionheader1536 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_49_in_functionheader1544 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_functionheader1551 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_50_in_functionheader1585 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_functionheader1592 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_49_in_functionheader1600 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_functionheader1607 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_functionheader1622 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_functionheader1627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_parameter1661 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_parameter1681 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_parameter1701 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_parameter1721 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_parameter1738 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_parameter1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_IN1791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_OUT1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_block_in_behavior_functions_signatureimplementation1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_behavior_actions_block1907 = new BitSet(new long[]{0x0018000000490FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1918 = new BitSet(new long[]{0x0018000000490FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1926 = new BitSet(new long[]{0x0018000000490FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_RCURL_in_behavior_actions_block1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_manipulator_manipulator_in_behavior_functions_signatureimplementation_manipulator1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_behavior_actions_manipulator_manipulator2010 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_behavior_actions_assignment_manipulator_in_behavior_actions_manipulator_manipulator2021 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_PIPE_in_behavior_actions_manipulator_manipulator2030 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_behavior_actions_assignment_manipulator_in_behavior_actions_manipulator_manipulator2038 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RCURL_in_behavior_actions_manipulator_manipulator2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_statementwithargument_in_behavior_actions_statement2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_expressionstatement_in_behavior_actions_statement2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_assignment_in_behavior_actions_statementwithargument2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_behavior_actions_assignment2164 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions_assignment2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_behavior_actions_assignment_manipulator2210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_assignment2246 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_assignment2259 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_assignment2279 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_EQUALS_in_assignment2291 = new BitSet(new long[]{0x0018000000090FC2L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_assignment2299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_actions_expressionstatement2338 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions_expressionstatement2345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_objectcreationexpression_in_primary_behavior_expressions_expression2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_this_in_primary_behavior_expressions_expression2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_behavior_expressions_expression2416 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2422 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_behavior_expressions_expression2426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_expressions_priority_02467 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02474 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_expressions_priority_02495 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_behavior_expressions_not_in_expressions_priority_02502 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02522 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_DOT_in_expressions_priority_02531 = new BitSet(new long[]{0xE000000000000030L,0x000000000000007FL});
    public static final BitSet FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02539 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_count_in_expressions_priority_02548 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_single_in_expressions_priority_02557 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_tuple_in_expressions_priority_02566 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02575 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02584 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_LBRACKET_in_expressions_priority_02600 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02608 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12649 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_53_in_expressions_priority_12658 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12665 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12669 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_54_in_expressions_priority_12686 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12693 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12697 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_55_in_expressions_priority_12714 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12721 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12725 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22767 = new BitSet(new long[]{0x0308000000000002L});
    public static final BitSet FOLLOW_56_in_expressions_priority_22776 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22783 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22787 = new BitSet(new long[]{0x0308000000000002L});
    public static final BitSet FOLLOW_57_in_expressions_priority_22804 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22811 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22815 = new BitSet(new long[]{0x0308000000000002L});
    public static final BitSet FOLLOW_51_in_expressions_priority_22832 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22839 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22843 = new BitSet(new long[]{0x0308000000000002L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32885 = new BitSet(new long[]{0x1C00000007000002L});
    public static final BitSet FOLLOW_RANGLE_in_expressions_priority_32894 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32902 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32906 = new BitSet(new long[]{0x1C00000007000002L});
    public static final BitSet FOLLOW_LANGLE_in_expressions_priority_32923 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32931 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32935 = new BitSet(new long[]{0x1C00000007000002L});
    public static final BitSet FOLLOW_58_in_expressions_priority_32952 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32959 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32963 = new BitSet(new long[]{0x1C00000007000002L});
    public static final BitSet FOLLOW_59_in_expressions_priority_32980 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32987 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32991 = new BitSet(new long[]{0x1C00000007000002L});
    public static final BitSet FOLLOW_EQUALS_in_expressions_priority_33008 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33016 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33020 = new BitSet(new long[]{0x1C00000007000002L});
    public static final BitSet FOLLOW_60_in_expressions_priority_33037 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_33044 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_33048 = new BitSet(new long[]{0x1C00000007000002L});
    public static final BitSet FOLLOW_expressions_priority_3_in_behavior_expressions_expression3081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_alias3110 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_expressions_alias_in_alias3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_alias3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_alias3192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_binarybooleanoperator3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_not3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_behavior_expressions_booleanaggregate3320 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_62_in_behavior_expressions_booleanaggregate3336 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_63_in_behavior_expressions_booleanaggregate3352 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate3364 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate3369 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_booleanaggregate3373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_unaryminus3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_behavior_expressions_count3480 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_count3487 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_count3492 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_count3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_behavior_expressions_single3530 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_single3537 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_single3542 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_single3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_behavior_expressions_tuple3580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_structure_type_tuple_in_behavior_expressions_tuple3587 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_tuple3594 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_tuple3599 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_tuple3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_tuple_in_structure_type_tuple3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_field_tupleLocalEnd_in_structure_association_tuple3707 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_structure_field_tupleOtherEnd_in_structure_association_tuple3717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_behavior_expressions_numericaggregate3849 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_68_in_behavior_expressions_numericaggregate3865 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_69_in_behavior_expressions_numericaggregate3881 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_70_in_behavior_expressions_numericaggregate3897 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_numericaggregate3909 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_numericaggregate3914 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_numericaggregate3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_behavior_expressions_objectcreationexpression3954 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_objectcreationexpression3961 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_objectcreationexpression3971 = new BitSet(new long[]{0x0000000000100030L});
    public static final BitSet FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression3979 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_49_in_behavior_expressions_objectcreationexpression3987 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_expressions_fieldinitializer_in_behavior_expressions_objectcreationexpression3994 = new BitSet(new long[]{0x0002000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_objectcreationexpression4006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_fieldinitializer4056 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_fieldinitializer4076 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_behavior_expressions_fieldinitializer4088 = new BitSet(new long[]{0x0018000000090FC0L,0x0000000000000180L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_fieldinitializer4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_behavior_expressions_this4139 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_this4142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_implicitcontext_pathExpression_in_behavior_expressions_expression_pathExpression4183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_behavior_expressions_firstpathexpression4254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression4262 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression4277 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression4297 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_firstpathexpression4308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression4362 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression4382 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_pathexpression4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression4434 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_behavior_expressions_filterexpression4441 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_alias_in_behavior_expressions_filterexpression4445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal4486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal4494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal4502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal4510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral4552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral4602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral4652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral4752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral4802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_in_synpred1_FinexClass584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_functions_function_in_synpred2_FinexClass615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_synpred3_FinexClass1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred5_FinexClass2461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred6_FinexClass2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred7_FinexClass2525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred8_FinexClass2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred9_FinexClass2652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred10_FinexClass2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred11_FinexClass2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred12_FinexClass2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred13_FinexClass2798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred14_FinexClass2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGLE_in_synpred15_FinexClass2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_synpred16_FinexClass2917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred17_FinexClass2946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_synpred18_FinexClass2974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_synpred19_FinexClass3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_synpred20_FinexClass3031 = new BitSet(new long[]{0x0000000000000002L});

}