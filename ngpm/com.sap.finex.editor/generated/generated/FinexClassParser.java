// $ANTLR 3.1.1 C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g 2009-10-27 16:44:10

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FIRST_LOWERCASE_NAME", "FIRST_UPPERCASE_NAME", "STRING", "INT", "FLOAT", "BOOL", "BINARY", "DATE", "COLON", "SEMICOLON", "LBRACKET", "RBRACKET", "DOT", "DDOT", "ASSIGN", "LPAREN", "RPAREN", "LCURL", "RCURL", "EQUALS", "RANGLE", "LANGLE", "COMMENT", "MULTI_LINE_COMMENT", "EQUALSEQUALS", "PIPE", "NL", "WS", "DIGIT", "LOWERCASE_ALPHA", "UPPERCASE_ALPHA", "ALPHA", "FIRST_LOWERCASE_SNAME", "FIRST_UPPERCASE_SNAME", "OBJECT", "RANGE_OR_INT", "NAME", "'opposite'", "'DEFAULT'", "'AS'", "'KEY'", "'function'", "'IN'", "','", "'OUT'", "'-'", "'not'", "'*'", "'/'", "'AND'", "'OR'", "'+'", "'>='", "'<='", "'!='", "'and'", "'or'", "'xor'", "'count'", "'single'", "'sum'", "'avg'", "'min'", "'max'"
    };
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int LANGLE=25;
    public static final int EQUALS=23;
    public static final int FLOAT=8;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int LPAREN=19;
    public static final int T__55=55;
    public static final int LBRACKET=14;
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
    public static final int PIPE=29;
    public static final int DIGIT=32;
    public static final int NL=30;
    public static final int RANGE_OR_INT=39;
    public static final int RANGLE=24;
    public static final int RBRACKET=15;
    public static final int COMMENT=26;
    public static final int DOT=16;
    public static final int T__50=50;
    public static final int FIRST_LOWERCASE_SNAME=36;
    public static final int T__42=42;
    public static final int LOWERCASE_ALPHA=33;
    public static final int EQUALSEQUALS=28;
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
    public static final int INT=7;
    public static final int SEMICOLON=13;
    public static final int UPPERCASE_ALPHA=34;
    public static final int MULTI_LINE_COMMENT=27;
    public static final int ALPHA=35;
    public static final int COLON=12;
    public static final int LCURL=21;
    public static final int WS=31;
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


       private static final String syntaxUUID = "E0C851178FBE6943C30F11DE8025001A6BCDC3B3";
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
              _beforeSeqEl("E0C851178F3DA081C30F11DEBF81001A6BCDC3B3");
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
              _beforeSeqEl("E0C851178F401181C30F11DE9C6E001A6BCDC3B3");
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
              _beforeSeqEl("E0C851178F401184C30F11DEB84E001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:353:1: classdeclaration[Object ret] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final void classdeclaration(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:354:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) COLON ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) ) COLON ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F428288C30F11DE80B4001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==FIRST_LOWERCASE_NAME) ) {
                alt1=1;
            }
            else if ( (LA1_0==FIRST_UPPERCASE_NAME) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F428282C30F11DE88FF001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:140: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:355:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_classdeclaration519);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F428286C30F11DECDB4001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_classdeclaration539);
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
              _beforeSeqEl("E0C851178F428289C30F11DE8F96001A6BCDC3B3");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration551); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F44CC71C30F11DE9434001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:335: ( ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:336: ( ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:337: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F42829BC30F11DE9E78001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:396: ( ( structure_association )=> ( (temp= structure_association ) SEMICOLON ) | ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON ) | ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON ) )*
            loop2:
            do {
                int alt2=4;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==DOT) && (synpred1_FinexClass())) {
                    alt2=1;
                }
                else if ( (LA2_0==DDOT) && (synpred1_FinexClass())) {
                    alt2=1;
                }
                else if ( (LA2_0==45) && (synpred2_FinexClass())) {
                    alt2=2;
                }
                else if ( (LA2_0==LBRACKET) ) {
                    alt2=3;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:397: ( structure_association )=> ( (temp= structure_association ) SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(0);
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:440: ( (temp= structure_association ) SEMICOLON )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:441: (temp= structure_association ) SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0C851178F42828CC30F11DEC7E4001A6BCDC3B3");
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:500: (temp= structure_association )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:502: temp= structure_association
            	    {
            	    pushFollow(FOLLOW_structure_association_in_classdeclaration573);
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
            	      _beforeSeqEl("E0C851178F42828DC30F11DE8682001A6BCDC3B3");
            	    }
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_classdeclaration580); if (state.failed) return ;
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:4: ( behavior_functions_function )=> ( (temp= behavior_functions_function ) SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(1);
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:53: ( (temp= behavior_functions_function ) SEMICOLON )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:54: (temp= behavior_functions_function ) SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0C851178F428291C30F11DE83D8001A6BCDC3B3");
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:113: (temp= behavior_functions_function )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:115: temp= behavior_functions_function
            	    {
            	    pushFollow(FOLLOW_behavior_functions_function_in_classdeclaration604);
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
            	      _beforeSeqEl("E0C851178F428292C30F11DEBAAD001A6BCDC3B3");
            	    }
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_classdeclaration611); if (state.failed) return ;
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:4: ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterAlt(2);
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:20: ( LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:21: LBRACKET (temp= behavior_expressions_expression ) RBRACKET SEMICOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0C851178F428294C30F11DE8BB4001A6BCDC3B3");
            	    }
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_classdeclaration626); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0C851178F428297C30F11DE827C001A6BCDC3B3");
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:165: (temp= behavior_expressions_expression )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:167: temp= behavior_expressions_expression
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_expression_in_classdeclaration634);
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
            	      _beforeSeqEl("E0C851178F428298C30F11DE983B001A6BCDC3B3");
            	    }
            	    match(input,RBRACKET,FOLLOW_RBRACKET_in_classdeclaration641); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0C851178F428299C30F11DEAC9C001A6BCDC3B3");
            	    }
            	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_classdeclaration646); if (state.failed) return ;
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
            	    break loop2;
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
              _beforeSeqEl("E0C851178F44CC72C30F11DEC7CE001A6BCDC3B3");
            }
            match(input,COLON,FOLLOW_COLON_in_classdeclaration660); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F44CC7BC30F11DECBE5001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:623: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==FIRST_LOWERCASE_NAME) ) {
                alt3=1;
            }
            else if ( (LA3_0==FIRST_UPPERCASE_NAME) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:624: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:640: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:641: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F44CC75C30F11DE9F05001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:700: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:358:702: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_classdeclaration673);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F44CC79C30F11DEA3B3001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:359:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_classdeclaration693);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:366:1: structure_type returns [Object ret2] : (ret= structure_finexclass ) ;
    public final Object structure_type() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:367:3: ( (ret= structure_finexclass ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:368:3: (ret= structure_finexclass )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:368:3: (ret= structure_finexclass )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:368:4: ret= structure_finexclass
            {
            pushFollow(FOLLOW_structure_finexclass_in_structure_type728);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:375:1: structure_association returns [Object ret2] : ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) ) ;
    public final Object structure_association() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Association");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:380:3: ( ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:3: ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:3: ( (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:4: (temp= structure_field ) ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F473D75C30F11DEC725001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:63: (temp= structure_field )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:65: temp= structure_field
            {
            pushFollow(FOLLOW_structure_field_in_structure_association762);
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
              _beforeSeqEl("E0C851178F473D83C30F11DE94E0001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:195: ( ( 'opposite' (temp= structure_field_opposite ) ) | ( (temp= structure_field_nondeclaredOpposite ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==41) ) {
                alt4=1;
            }
            else if ( (LA4_0==EOF||LA4_0==SEMICOLON) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:196: ( 'opposite' (temp= structure_field_opposite ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:212: ( 'opposite' (temp= structure_field_opposite ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:213: 'opposite' (temp= structure_field_opposite )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F473D76C30F11DEB566001A6BCDC3B3");
                    }
                    match(input,41,FOLLOW_41_in_structure_association773); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F473D7BC30F11DEC31C001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:357: (temp= structure_field_opposite )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:381:359: temp= structure_field_opposite
                    {
                    pushFollow(FOLLOW_structure_field_opposite_in_structure_association780);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:4: ( (temp= structure_field_nondeclaredOpposite ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:20: ( (temp= structure_field_nondeclaredOpposite ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:21: (temp= structure_field_nondeclaredOpposite )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F473D81C30F11DEAFDA001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:80: (temp= structure_field_nondeclaredOpposite )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:382:82: temp= structure_field_nondeclaredOpposite
                    {
                    pushFollow(FOLLOW_structure_field_nondeclaredOpposite_in_structure_association800);
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
              _beforeSeqEl("E0C851178F473D86C30F11DE879B001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:390:1: structure_field returns [Object ret2] : ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) ) ;
    public final Object structure_field() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"field"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:395:3: ( ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:3: ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:3: ( ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:4: ( ( DOT ) | ( DDOT ) ) ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F49876DC30F11DEA747001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:63: ( ( DOT ) | ( DDOT ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==DOT) ) {
                alt5=1;
            }
            else if ( (LA5_0==DDOT) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:64: ( DOT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:80: ( DOT )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:396:81: DOT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F498763C30F11DE868B001A6BCDC3B3");
                    }
                    match(input,DOT,FOLLOW_DOT_in_structure_field857); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F498766C30F11DE81BF001A6BCDC3B3");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:4: ( DDOT )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:20: ( DDOT )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:21: DDOT
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F498768C30F11DEA4B8001A6BCDC3B3");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_structure_field875); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F49876BC30F11DEA75A001A6BCDC3B3");
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
              _beforeSeqEl("E0C851178F4E6969C30F11DECB78001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:338: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) ) | ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==FIRST_LOWERCASE_NAME) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==COLON) && (synpred3_FinexClass())) {
                    alt12=2;
                }
                else if ( ((LA12_1>=FIRST_LOWERCASE_NAME && LA12_1<=FIRST_UPPERCASE_NAME)) ) {
                    alt12=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0==FIRST_UPPERCASE_NAME) ) {
                int LA12_2 = input.LA(2);

                if ( ((LA12_2>=FIRST_LOWERCASE_NAME && LA12_2<=FIRST_UPPERCASE_NAME)) ) {
                    alt12=1;
                }
                else if ( (LA12_2==COLON) && (synpred3_FinexClass())) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:339: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:355: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:356: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F4BF864C30F11DEACCD001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:415: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==FIRST_LOWERCASE_NAME) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==FIRST_UPPERCASE_NAME) ) {
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:416: ( (temp= firstLowercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:432: ( (temp= firstLowercaseIdentifier ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:433: (temp= firstLowercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F498770C30F11DE952D001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:492: (temp= firstLowercaseIdentifier )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:397:494: temp= firstLowercaseIdentifier
                            {
                            pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field901);
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
                              _beforeSeqEl("E0C851178F498773C30F11DEBDB5001A6BCDC3B3");
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:4: ( (temp= firstUppercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:20: ( (temp= firstUppercaseIdentifier ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:21: (temp= firstUppercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F498777C30F11DEB62A001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:80: (temp= firstUppercaseIdentifier )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:82: temp= firstUppercaseIdentifier
                            {
                            pushFollow(FOLLOW_firstUppercaseIdentifier_in_structure_field924);
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
                              _beforeSeqEl("E0C851178F4BF862C30F11DEA2F7001A6BCDC3B3");
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
                      _beforeSeqEl("E0C851178F4BF871C30F11DEBE6E001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:388: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:389: ( (temp= firstLowercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:405: ( (temp= firstLowercaseIdentifier ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:406: (temp= firstLowercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4BF869C30F11DE8129001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:465: (temp= firstLowercaseIdentifier )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:398:467: temp= firstLowercaseIdentifier
                            {
                            pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field947);
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:4: ( (temp= firstUppercaseIdentifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:20: ( (temp= firstUppercaseIdentifier ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:21: (temp= firstUppercaseIdentifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4BF86FC30F11DEA031001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:80: (temp= firstUppercaseIdentifier )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:82: temp= firstUppercaseIdentifier
                            {
                            pushFollow(FOLLOW_firstUppercaseIdentifier_in_structure_field967);
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
                      _beforeSeqEl("E0C851178F4BF872C30F11DE8BD1001A6BCDC3B3");
                    }
                    pushFollow(FOLLOW_askey_in_structure_field978);
                    askey(ret);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F4BF87CC30F11DE8C3C001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:410: ( ( 'DEFAULT' (temp= behavior_expressions_expression )? ) | ( ASSIGN (temp= behavior_expressions_expression )? ) | () )
                    int alt10=3;
                    switch ( input.LA(1) ) {
                    case 42:
                        {
                        alt10=1;
                        }
                        break;
                    case ASSIGN:
                        {
                        alt10=2;
                        }
                        break;
                    case EOF:
                    case SEMICOLON:
                    case 41:
                        {
                        alt10=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }

                    switch (alt10) {
                        case 1 :
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:411: ( 'DEFAULT' (temp= behavior_expressions_expression )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:427: ( 'DEFAULT' (temp= behavior_expressions_expression )? )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:428: 'DEFAULT' (temp= behavior_expressions_expression )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4BF873C30F11DEA03C001A6BCDC3B3");
                            }
                            match(input,42,FOLLOW_42_in_structure_field987); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4BF875C30F11DEB0B6001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:571: (temp= behavior_expressions_expression )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( ((LA8_0>=STRING && LA8_0<=DATE)||LA8_0==DOT||LA8_0==LPAREN||(LA8_0>=49 && LA8_0<=50)) ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:399:573: temp= behavior_expressions_expression
                                    {
                                    pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field994);
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:4: ( ASSIGN (temp= behavior_expressions_expression )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:20: ( ASSIGN (temp= behavior_expressions_expression )? )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:21: ASSIGN (temp= behavior_expressions_expression )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4BF877C30F11DE97DE001A6BCDC3B3");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1013); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4BF879C30F11DE9CC0001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:163: (temp= behavior_expressions_expression )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( ((LA9_0>=STRING && LA9_0<=DATE)||LA9_0==DOT||LA9_0==LPAREN||(LA9_0>=49 && LA9_0<=50)) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:400:165: temp= behavior_expressions_expression
                                    {
                                    pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field1021);
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(2);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:20: ()
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:401:21: 
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:4: ( structure_type_field )=> ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:46: ( (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:47: (temp= structure_type_field ) askey[ret] ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F4BF880C30F11DE970B001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:106: (temp= structure_type_field )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:108: temp= structure_type_field
                    {
                    pushFollow(FOLLOW_structure_type_field_in_structure_field1064);
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
                      _beforeSeqEl("E0C851178F4BF883C30F11DECEB3001A6BCDC3B3");
                    }
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "name", null, null, "OCL:self.type.name", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F4BF884C30F11DE90E4001A6BCDC3B3");
                    }
                    pushFollow(FOLLOW_askey_in_structure_field1073);
                    askey(ret);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F4E6967C30F11DEB854001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:490: ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ( ASSIGN (temp= behavior_expressions_expression ) ) | () )
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
                    case 41:
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:491: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:507: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:508: 'DEFAULT' (temp= behavior_expressions_expression )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4BF885C30F11DEC5BC001A6BCDC3B3");
                            }
                            match(input,42,FOLLOW_42_in_structure_field1082); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4BF888C30F11DE9C7C001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:651: (temp= behavior_expressions_expression )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:653: temp= behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field1089);
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:4: ( ASSIGN (temp= behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:20: ( ASSIGN (temp= behavior_expressions_expression ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:21: ASSIGN (temp= behavior_expressions_expression )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4E6961C30F11DEB5D7001A6BCDC3B3");
                            }
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_structure_field1106); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F4E6964C30F11DE9105001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:163: (temp= behavior_expressions_expression )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:403:165: temp= behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_expression_in_structure_field1114);
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(2);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:20: ()
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:404:21: 
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
              _beforeSeqEl("E0C851178F4E696CC30F11DEBB5E001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:412:1: structure_field_opposite returns [Object ret2] : ( (temp= firstLowercaseIdentifier ) ) ;
    public final Object structure_field_opposite() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"opposite");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:417:3: ( ( (temp= firstLowercaseIdentifier ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:418:3: ( (temp= firstLowercaseIdentifier ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:418:3: ( (temp= firstLowercaseIdentifier ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:418:4: (temp= firstLowercaseIdentifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F50B352C30F11DEABE0001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:418:63: (temp= firstLowercaseIdentifier )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:418:65: temp= firstLowercaseIdentifier
            {
            pushFollow(FOLLOW_firstLowercaseIdentifier_in_structure_field_opposite1184);
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
              _beforeSeqEl("E0C851178F50B35BC30F11DEAB1E001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:426:1: structure_field_nondeclaredOpposite returns [Object ret2] : () ;
    public final Object structure_field_nondeclaredOpposite() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("structure","Field");
        onEnterTemplateRule(metaType,"nondeclaredOpposite");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:431:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:432:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:432:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:432:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F532452C30F11DEB501001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:440:1: askey[Object ret] : ( ( ( 'AS' 'KEY' ) | ) ) ;
    public final void askey(Object ret) throws RecognitionException {
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:441:3: ( ( ( ( 'AS' 'KEY' ) | ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:3: ( ( ( 'AS' 'KEY' ) | ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:3: ( ( ( 'AS' 'KEY' ) | ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:4: ( ( 'AS' 'KEY' ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F559556C30F11DEB1CD001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:64: ( ( 'AS' 'KEY' ) | )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==43) ) {
                alt13=1;
            }
            else if ( (LA13_0==EOF||LA13_0==SEMICOLON||LA13_0==ASSIGN||(LA13_0>=41 && LA13_0<=42)) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:65: ( 'AS' 'KEY' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:81: ( 'AS' 'KEY' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:82: 'AS' 'KEY'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F559553C30F11DE86EC001A6BCDC3B3");
                    }
                    match(input,43,FOLLOW_43_in_askey1270); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F559554C30F11DEACD9001A6BCDC3B3");
                    }
                    match(input,44,FOLLOW_44_in_askey1273); if (state.failed) return ;
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:442:309: 
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:450:1: behavior_functions_function returns [Object ret2] : ( 'function' ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON (temp= behavior_actions_block ) ) ;
    public final Object behavior_functions_function() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","functions","Function");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:455:3: ( ( 'function' ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON (temp= behavior_actions_block ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:3: ( 'function' ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON (temp= behavior_actions_block ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:3: ( 'function' ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON (temp= behavior_actions_block ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:4: 'function' ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () ) LPAREN ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) ) RPAREN COLON (temp= behavior_actions_block )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F5A5040C30F11DEB6C0001A6BCDC3B3");
            }
            match(input,45,FOLLOW_45_in_behavior_functions_function1318); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F5A504DC30F11DEB69D001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:148: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) | () )
            int alt14=3;
            switch ( input.LA(1) ) {
            case FIRST_LOWERCASE_NAME:
                {
                alt14=1;
                }
                break;
            case FIRST_UPPERCASE_NAME:
                {
                alt14=2;
                }
                break;
            case LPAREN:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:149: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:165: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:166: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5A5043C30F11DE8F74001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:225: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:456:227: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_functions_function1330);
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
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5A5047C30F11DEC2BB001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:457:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_functions_function1350);
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
                case 3 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:20: ()
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:21: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5A504BC30F11DE9FE5001A6BCDC3B3");
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
              _beforeSeqEl("E0C851178F5A504EC30F11DE8B18001A6BCDC3B3");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_functions_function1375); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F5C9A48C30F11DE80CC001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:323: ( ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) ) | ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==46) ) {
                alt19=1;
            }
            else if ( (LA19_0==48) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:324: ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:340: ( 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:341: 'IN' (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* ) ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5A504FC30F11DEA2C1001A6BCDC3B3");
                    }
                    match(input,46,FOLLOW_46_in_behavior_functions_function1384); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5C9A31C30F11DE99E4001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:479: (temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )* )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:481: temp= behavior_functions_parameter_IN ( ( ',' ) temp= behavior_functions_parameter_IN )*
                    {
                    pushFollow(FOLLOW_behavior_functions_parameter_IN_in_behavior_functions_function1391);
                    temp=behavior_functions_parameter_IN();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:558: ( ( ',' ) temp= behavior_functions_parameter_IN )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==47) ) {
                            int LA15_1 = input.LA(2);

                            if ( ((LA15_1>=FIRST_LOWERCASE_NAME && LA15_1<=FIRST_UPPERCASE_NAME)) ) {
                                alt15=1;
                            }


                        }


                        switch (alt15) {
                    	case 1 :
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:559: ( ',' ) temp= behavior_functions_parameter_IN
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:576: ( ',' )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:577: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0C851178F5A5052C30F11DEB375001A6BCDC3B3");
                    	    }
                    	    match(input,47,FOLLOW_47_in_behavior_functions_function1399); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_behavior_functions_parameter_IN_in_behavior_functions_function1406);
                    	    temp=behavior_functions_parameter_IN();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "parameters", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5C9A3DC30F11DE88F7001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:828: ( ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) ) | () )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==47) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==RPAREN) ) {
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:829: ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:845: ( ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:846: ',' 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F5C9A32C30F11DECF1F001A6BCDC3B3");
                            }
                            match(input,47,FOLLOW_47_in_behavior_functions_function1420); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F5C9A33C30F11DEC59F001A6BCDC3B3");
                            }
                            match(input,48,FOLLOW_48_in_behavior_functions_function1423); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0C851178F5C9A3AC30F11DEA35A001A6BCDC3B3");
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:1063: (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:1065: temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                            {
                            pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_behavior_functions_function1430);
                            temp=behavior_functions_parameter_OUT();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "parameters", temp);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:1143: ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==47) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:1144: ( ',' ) temp= behavior_functions_parameter_OUT
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:1161: ( ',' )
                            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:458:1162: ','
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0C851178F5C9A36C30F11DEB884001A6BCDC3B3");
                            	    }
                            	    match(input,47,FOLLOW_47_in_behavior_functions_function1438); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_behavior_functions_function1445);
                            	    temp=behavior_functions_parameter_OUT();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "parameters", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop16;
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:459:4: ()
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:459:20: ()
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:459:21: 
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:4: ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:20: ( 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:21: 'OUT' (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5C9A3FC30F11DE990B001A6BCDC3B3");
                    }
                    match(input,48,FOLLOW_48_in_behavior_functions_function1479); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5C9A46C30F11DEBCDD001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:160: (temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )* )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:162: temp= behavior_functions_parameter_OUT ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                    {
                    pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_behavior_functions_function1486);
                    temp=behavior_functions_parameter_OUT();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameters", temp);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:240: ( ( ',' ) temp= behavior_functions_parameter_OUT )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==47) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:241: ( ',' ) temp= behavior_functions_parameter_OUT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:258: ( ',' )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:259: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0C851178F5C9A42C30F11DEB166001A6BCDC3B3");
                    	    }
                    	    match(input,47,FOLLOW_47_in_behavior_functions_function1494); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_behavior_functions_parameter_OUT_in_behavior_functions_function1501);
                    	    temp=behavior_functions_parameter_OUT();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
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

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F5C9A49C30F11DEC895001A6BCDC3B3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_functions_function1516); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F5C9A4AC30F11DEAEE7001A6BCDC3B3");
            }
            match(input,COLON,FOLLOW_COLON_in_behavior_functions_function1521); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F5C9A4CC30F11DEA1DE001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:708: (temp= behavior_actions_block )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:460:710: temp= behavior_actions_block
            {
            pushFollow(FOLLOW_behavior_actions_block_in_behavior_functions_function1529);
            temp=behavior_actions_block();

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


    // $ANTLR start "parameter"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:468:1: parameter[Object ret] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) ) ;
    public final void parameter(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:469:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F5F0B38C30F11DEC006001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==FIRST_LOWERCASE_NAME) ) {
                alt20=1;
            }
            else if ( (LA20_0==FIRST_UPPERCASE_NAME) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5F0B32C30F11DEAE01001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:140: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:470:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_parameter1575);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F5F0B36C30F11DEC409001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_parameter1595);
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
              _beforeSeqEl("E0C851178F63C62CC30F11DECCC9001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:253: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FIRST_LOWERCASE_NAME) ) {
                alt21=1;
            }
            else if ( (LA21_0==FIRST_UPPERCASE_NAME) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:254: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:270: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:271: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F63C624C30F11DE82E4001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:330: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:471:332: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_parameter1615);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F63C62AC30F11DEA4AD001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_parameter1635);
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
              _beforeSeqEl("E0C851178F663722C30F11DE8199001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:326: ( ( 'DEFAULT' (temp= behavior_expressions_expression ) ) | )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==42) ) {
                alt22=1;
            }
            else if ( (LA22_0==RPAREN||LA22_0==47) ) {
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:327: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:343: ( 'DEFAULT' (temp= behavior_expressions_expression ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:344: 'DEFAULT' (temp= behavior_expressions_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F63C630C30F11DEBE92001A6BCDC3B3");
                    }
                    match(input,42,FOLLOW_42_in_parameter1652); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F663720C30F11DEB758001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:487: (temp= behavior_expressions_expression )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:489: temp= behavior_expressions_expression
                    {
                    pushFollow(FOLLOW_behavior_expressions_expression_in_parameter1659);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:472:602: 
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:480:1: behavior_functions_parameter_IN returns [Object ret2] : ( parameter[ret] ) ;
    public final Object behavior_functions_parameter_IN() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","functions","Parameter");
        onEnterTemplateRule(metaType,"IN");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:485:3: ( ( parameter[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:486:3: ( parameter[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:486:3: ( parameter[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:486:4: parameter[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F68A820C30F11DE8016001A6BCDC3B3");
            }
            pushFollow(FOLLOW_parameter_in_behavior_functions_parameter_IN1705);
            parameter(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F68A823C30F11DEC3A6001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:494:1: behavior_functions_parameter_OUT returns [Object ret2] : ( parameter[ret] ) ;
    public final Object behavior_functions_parameter_OUT() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","functions","Parameter");
        onEnterTemplateRule(metaType,"OUT");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:499:3: ( ( parameter[ret] ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:500:3: ( parameter[ret] )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:500:3: ( parameter[ret] )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:500:4: parameter[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F6AF210C30F11DEB788001A6BCDC3B3");
            }
            pushFollow(FOLLOW_parameter_in_behavior_functions_parameter_OUT1749);
            parameter(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F6AF213C30F11DECCCC001A6BCDC3B3");
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


    // $ANTLR start "behavior_actions_block"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:508:1: behavior_actions_block returns [Object ret2] : ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL ) ;
    public final Object behavior_actions_block() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:513:3: ( ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:3: ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:3: ( LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:4: LCURL ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F6D6310C30F11DE96E6001A6BCDC3B3");
            }
            match(input,LCURL,FOLLOW_LCURL_in_behavior_actions_block1794); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F6D6314C30F11DE88B8001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:145: ( ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:146: ( (temp= behavior_actions_statement (temp= behavior_actions_statement )* )? )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:147: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F6D6312C30F11DE8BFD001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:206: (temp= behavior_actions_statement (temp= behavior_actions_statement )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=STRING && LA24_0<=DATE)||LA24_0==DOT||LA24_0==LPAREN||(LA24_0>=49 && LA24_0<=50)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:208: temp= behavior_actions_statement (temp= behavior_actions_statement )*
                    {
                    pushFollow(FOLLOW_behavior_actions_statement_in_behavior_actions_block1805);
                    temp=behavior_actions_statement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "statements", temp);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:280: (temp= behavior_actions_statement )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0>=STRING && LA23_0<=DATE)||LA23_0==DOT||LA23_0==LPAREN||(LA23_0>=49 && LA23_0<=50)) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:514:282: temp= behavior_actions_statement
                    	    {
                    	    pushFollow(FOLLOW_behavior_actions_statement_in_behavior_actions_block1813);
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
                    	    break loop23;
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
              _beforeSeqEl("E0C851178F6D6315C30F11DE91ED001A6BCDC3B3");
            }
            match(input,RCURL,FOLLOW_RCURL_in_behavior_actions_block1828); if (state.failed) return ret2;
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


    // $ANTLR start "behavior_actions_statement"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:522:1: behavior_actions_statement returns [Object ret2] : (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement ) ;
    public final Object behavior_actions_statement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:523:3: ( (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:524:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:524:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:524:4: ret= behavior_actions_statementwithargument
                    {
                    pushFollow(FOLLOW_behavior_actions_statementwithargument_in_behavior_actions_statement1866);
                    ret=behavior_actions_statementwithargument();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:525:5: ret= behavior_actions_expressionstatement
                    {
                    pushFollow(FOLLOW_behavior_actions_expressionstatement_in_behavior_actions_statement1874);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:532:1: behavior_actions_statementwithargument returns [Object ret2] : ( ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment ) ) ;
    public final Object behavior_actions_statementwithargument() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:533:3: ( ( ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:3: ( ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:3: ( ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:4: ( DOT NAME EQUALS )=> (ret= behavior_actions_assignment )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:23: (ret= behavior_actions_assignment )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:534:24: ret= behavior_actions_assignment
            {
            pushFollow(FOLLOW_behavior_actions_assignment_in_behavior_actions_statementwithargument1910);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:541:1: behavior_actions_assignment returns [Object ret2] : ( DOT (temp= firstLowercaseIdentifier ) EQUALS (temp= behavior_expressions_expression )? SEMICOLON ) ;
    public final Object behavior_actions_assignment() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","Assignment");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:546:3: ( ( DOT (temp= firstLowercaseIdentifier ) EQUALS (temp= behavior_expressions_expression )? SEMICOLON ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:547:3: ( DOT (temp= firstLowercaseIdentifier ) EQUALS (temp= behavior_expressions_expression )? SEMICOLON )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:547:3: ( DOT (temp= firstLowercaseIdentifier ) EQUALS (temp= behavior_expressions_expression )? SEMICOLON )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:547:4: DOT (temp= firstLowercaseIdentifier ) EQUALS (temp= behavior_expressions_expression )? SEMICOLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F76D8F0C30F11DE87EB001A6BCDC3B3");
            }
            match(input,DOT,FOLLOW_DOT_in_behavior_actions_assignment1942); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F76D8F5C30F11DEA93B001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:547:143: (temp= firstLowercaseIdentifier )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:547:145: temp= firstLowercaseIdentifier
            {
            pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_actions_assignment1950);
            temp=firstLowercaseIdentifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "assignTo", null, temp, "OCL:self.block.getOuterMostBlock().signature.owner.getNavigableFields()->select(f | f.name = ?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F76D8F6C30F11DE89C3001A6BCDC3B3");
            }
            match(input,EQUALS,FOLLOW_EQUALS_in_behavior_actions_assignment1957); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F76D8F8C30F11DECACF001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:547:474: (temp= behavior_expressions_expression )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=STRING && LA26_0<=DATE)||LA26_0==DOT||LA26_0==LPAREN||(LA26_0>=49 && LA26_0<=50)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:547:476: temp= behavior_expressions_expression
                    {
                    pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_actions_assignment1965);
                    temp=behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "argument", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F76D8F9C30F11DEC36C001A6BCDC3B3");
            }
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_actions_assignment1974); if (state.failed) return ret2;
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


    // $ANTLR start "behavior_actions_expressionstatement"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:555:1: behavior_actions_expressionstatement returns [Object ret2] : ( (temp= behavior_expressions_expression ) SEMICOLON ) ;
    public final Object behavior_actions_expressionstatement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","actions","ExpressionStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:560:3: ( ( (temp= behavior_expressions_expression ) SEMICOLON ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:561:3: ( (temp= behavior_expressions_expression ) SEMICOLON )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:561:3: ( (temp= behavior_expressions_expression ) SEMICOLON )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:561:4: (temp= behavior_expressions_expression ) SEMICOLON
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F7949F1C30F11DEB3CC001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:561:63: (temp= behavior_expressions_expression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:561:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_actions_expressionstatement2019);
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
              _beforeSeqEl("E0C851178F7949F2C30F11DE844B001A6BCDC3B3");
            }
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_behavior_actions_expressionstatement2026); if (state.failed) return ret2;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:569:1: primary_behavior_expressions_expression returns [Object ret2] : (ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) ;
    public final Object primary_behavior_expressions_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:570:3: ( (ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ( LPAREN ret= behavior_expressions_expression RPAREN ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:571:3: (ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:571:3: (ret= behavior_expressions_literals_literal | ret= behavior_expressions_firstpathexpression | ( LPAREN ret= behavior_expressions_expression RPAREN ) )
            int alt27=3;
            switch ( input.LA(1) ) {
            case STRING:
            case INT:
            case FLOAT:
            case BOOL:
            case BINARY:
            case DATE:
                {
                alt27=1;
                }
                break;
            case DOT:
                {
                alt27=2;
                }
                break;
            case LPAREN:
                {
                alt27=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:571:4: ret= behavior_expressions_literals_literal
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2064);
                    ret=behavior_expressions_literals_literal();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:572:5: ret= behavior_expressions_firstpathexpression
                    {
                    pushFollow(FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2072);
                    ret=behavior_expressions_firstpathexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:573:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    {
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:573:5: ( LPAREN ret= behavior_expressions_expression RPAREN )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:573:6: LPAREN ret= behavior_expressions_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_behavior_expressions_expression2081); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2087);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_behavior_expressions_expression2091); if (state.failed) return ret2;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:580:1: expressions_priority_0 returns [Object ret2] : ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object expressions_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:581:3: ( ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:4: ( ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) ) | (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=49 && LA31_0<=50)) ) {
                alt31=1;
            }
            else if ( ((LA31_0>=STRING && LA31_0<=DATE)||LA31_0==DOT||LA31_0==LPAREN) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
                    {
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:5: ( ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) | ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) ) )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==49) && (synpred5_FinexClass())) {
                        alt28=1;
                    }
                    else if ( (LA28_0==50) && (synpred6_FinexClass())) {
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:6: ( '-' )=> ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:13: ( '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:14: '-' ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("-", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,49,FOLLOW_49_in_expressions_priority_02132); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "-";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:94: ( (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:95: (ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:96: ret= behavior_expressions_unaryminus[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02139);
                            ret=behavior_expressions_unaryminus(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02143);
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
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:3: ( 'not' )=> ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:12: ( 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:13: 'not' ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterOpSeq("not", 1, false);
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,50,FOLLOW_50_in_expressions_priority_02160); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              opName = "not";
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:99: ( (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression ) )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            {
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:100: (ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression )
                            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:101: ret= behavior_expressions_not[opName, null, firstToken] right= primary_behavior_expressions_expression
                            {
                            pushFollow(FOLLOW_behavior_expressions_not_in_expressions_priority_02167);
                            ret=behavior_expressions_not(opName, null, firstToken);

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02171);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    {
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:2: (ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )* )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:4: ret= primary_behavior_expressions_expression ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
                    {
                    pushFollow(FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02187);
                    ret=primary_behavior_expressions_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:47: ( ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) ) | ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) ) )*
                    loop30:
                    do {
                        int alt30=3;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==DOT) && (synpred7_FinexClass())) {
                            alt30=1;
                        }
                        else if ( (LA30_0==LBRACKET) && (synpred8_FinexClass())) {
                            alt30=2;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:48: ( DOT )=> ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:55: ( DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:56: DOT ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq(".", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,DOT,FOLLOW_DOT_in_expressions_priority_02196); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = ".";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:137: ( (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_count[opName, ret, firstToken] ) | (ret= behavior_expressions_single[opName, ret, firstToken] ) | (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] ) | (ret= behavior_expressions_pathexpression[opName, ret, firstToken] ) )
                    	    int alt29=5;
                    	    switch ( input.LA(1) ) {
                    	    case 59:
                    	    case 60:
                    	    case 61:
                    	        {
                    	        alt29=1;
                    	        }
                    	        break;
                    	    case 62:
                    	        {
                    	        alt29=2;
                    	        }
                    	        break;
                    	    case 63:
                    	        {
                    	        alt29=3;
                    	        }
                    	        break;
                    	    case 64:
                    	    case 65:
                    	    case 66:
                    	    case 67:
                    	        {
                    	        alt29=4;
                    	        }
                    	        break;
                    	    case FIRST_LOWERCASE_NAME:
                    	    case FIRST_UPPERCASE_NAME:
                    	        {
                    	        alt29=5;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return ret2;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 29, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt29) {
                    	        case 1 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:138: (ret= behavior_expressions_booleanaggregate[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:139: ret= behavior_expressions_booleanaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02204);
                    	            ret=behavior_expressions_booleanaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:3: (ret= behavior_expressions_count[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:590:4: ret= behavior_expressions_count[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_count_in_expressions_priority_02213);
                    	            ret=behavior_expressions_count(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 3 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:591:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:591:3: (ret= behavior_expressions_single[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:591:4: ret= behavior_expressions_single[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_single_in_expressions_priority_02222);
                    	            ret=behavior_expressions_single(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 4 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:592:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:592:3: (ret= behavior_expressions_numericaggregate[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:592:4: ret= behavior_expressions_numericaggregate[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02231);
                    	            ret=behavior_expressions_numericaggregate(opName, ret, firstToken);

                    	            checkFollows();
                    	            state._fsp--;
                    	            if (state.failed) return ret2;

                    	            }


                    	            }
                    	            break;
                    	        case 5 :
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:593:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            {
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:593:3: (ret= behavior_expressions_pathexpression[opName, ret, firstToken] )
                    	            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:593:4: ret= behavior_expressions_pathexpression[opName, ret, firstToken]
                    	            {
                    	            pushFollow(FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02240);
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
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:3: ( LBRACKET )=> ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    {
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:15: ( LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) ) )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:16: LBRACKET ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterOpSeq("[", 2, false);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,LBRACKET,FOLLOW_LBRACKET_in_expressions_priority_02256); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      opName = "[";
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:102: ( (ret= behavior_expressions_filterexpression[opName, ret, firstToken] ) )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    {
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:103: (ret= behavior_expressions_filterexpression[opName, ret, firstToken] )
                    	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:104: ret= behavior_expressions_filterexpression[opName, ret, firstToken]
                    	    {
                    	    pushFollow(FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02264);
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
                    	    break loop30;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:602:1: expressions_priority_1 returns [Object ret2] : ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) ;
    public final Object expressions_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:603:3: ( ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:4: ( (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:6: (ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:8: ret= expressions_priority_0 ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12305);
            ret=expressions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:34: ( ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) | ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) ) )*
            loop32:
            do {
                int alt32=4;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==51) && (synpred9_FinexClass())) {
                    alt32=1;
                }
                else if ( (LA32_0==52) && (synpred10_FinexClass())) {
                    alt32=2;
                }
                else if ( (LA32_0==53) && (synpred11_FinexClass())) {
                    alt32=3;
                }


                switch (alt32) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:35: ( '*' )=> ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:42: ( '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:43: '*' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("*", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,51,FOLLOW_51_in_expressions_priority_12314); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "*";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:123: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:124: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:125: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12321);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12325);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:3: ( '/' )=> ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:10: ( '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:11: '/' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("/", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,52,FOLLOW_52_in_expressions_priority_12342); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "/";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12349);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12353);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:3: ( 'AND' )=> ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:12: ( 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:13: 'AND' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("AND", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,53,FOLLOW_53_in_expressions_priority_12370); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "AND";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:99: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:100: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:101: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_0
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12377);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_0_in_expressions_priority_12381);
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
            	    break loop32;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:620:1: expressions_priority_2 returns [Object ret2] : ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) ;
    public final Object expressions_priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:621:3: ( ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:4: ( (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:6: (ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:8: ret= expressions_priority_1 ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22423);
            ret=expressions_priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:34: ( ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) | ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) ) )*
            loop33:
            do {
                int alt33=4;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==54) && (synpred12_FinexClass())) {
                    alt33=1;
                }
                else if ( (LA33_0==55) && (synpred13_FinexClass())) {
                    alt33=2;
                }
                else if ( (LA33_0==49) && (synpred14_FinexClass())) {
                    alt33=3;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:35: ( 'OR' )=> ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:43: ( 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:44: 'OR' ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("OR", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,54,FOLLOW_54_in_expressions_priority_22432); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "OR";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:127: ( (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:128: (ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:129: ret= behavior_expressions_binarybooleanoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22439);
            	    ret=behavior_expressions_binarybooleanoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22443);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:3: ( '+' )=> ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:10: ( '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:11: '+' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,55,FOLLOW_55_in_expressions_priority_22460); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22467);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22471);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:3: ( '-' )=> ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:10: ( '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:11: '-' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("-", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,49,FOLLOW_49_in_expressions_priority_22488); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "-";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:91: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:92: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:93: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_1
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22495);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_1_in_expressions_priority_22499);
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
            	    break loop33;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:638:1: expressions_priority_3 returns [Object ret2] : ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) ;
    public final Object expressions_priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:639:3: ( ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:4: ( (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:6: (ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )* )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:8: ret= expressions_priority_2 ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32541);
            ret=expressions_priority_2();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:34: ( ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) | ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) ) )*
            loop34:
            do {
                int alt34=7;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RANGLE) && (synpred15_FinexClass())) {
                    alt34=1;
                }
                else if ( (LA34_0==LANGLE) && (synpred16_FinexClass())) {
                    alt34=2;
                }
                else if ( (LA34_0==56) && (synpred17_FinexClass())) {
                    alt34=3;
                }
                else if ( (LA34_0==57) && (synpred18_FinexClass())) {
                    alt34=4;
                }
                else if ( (LA34_0==EQUALS) && (synpred19_FinexClass())) {
                    alt34=5;
                }
                else if ( (LA34_0==58) && (synpred20_FinexClass())) {
                    alt34=6;
                }


                switch (alt34) {
            	case 1 :
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:35: ( RANGLE )=> ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:45: ( RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:46: RANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,RANGLE,FOLLOW_RANGLE_in_expressions_priority_32550); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:130: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:131: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:132: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32558);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32562);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:3: ( LANGLE )=> ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:13: ( LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:14: LANGLE ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LANGLE,FOLLOW_LANGLE_in_expressions_priority_32579); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:98: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:100: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32587);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32591);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:3: ( '>=' )=> ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:11: ( '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:12: '>=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,56,FOLLOW_56_in_expressions_priority_32608); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32615);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32619);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:3: ( '<=' )=> ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:11: ( '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:12: '<=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,57,FOLLOW_57_in_expressions_priority_32636); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32643);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32647);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:3: ( EQUALS )=> ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:13: ( EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:14: EQUALS ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,EQUALS,FOLLOW_EQUALS_in_expressions_priority_32664); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:98: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:99: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:100: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32672);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32676);
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
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:3: ( '!=' )=> ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:11: ( '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:12: '!=' ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("!=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,58,FOLLOW_58_in_expressions_priority_32693); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "!=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:95: ( (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 ) )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    {
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:96: (ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2 )
            	    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:97: ret= behavior_expressions_binarynumericoperator[opName, ret, firstToken] right= expressions_priority_2
            	    {
            	    pushFollow(FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32700);
            	    ret=behavior_expressions_binarynumericoperator(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_expressions_priority_2_in_expressions_priority_32704);
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
            	    break loop34;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:665:1: behavior_expressions_expression returns [Object ret2] : ret= expressions_priority_3 ;
    public final Object behavior_expressions_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:666:3: (ret= expressions_priority_3 )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:667:3: ret= expressions_priority_3
            {
            pushFollow(FOLLOW_expressions_priority_3_in_behavior_expressions_expression2737);
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


    // $ANTLR start "behavior_expressions_binarybooleanoperator"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:674:1: behavior_expressions_binarybooleanoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : () ;
    public final Object behavior_expressions_binarybooleanoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryBooleanOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:679:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:680:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F7E04E5C30F11DE9B8E001A6BCDC3B3");
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
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "behavior_expressions_binarybooleanoperator"


    // $ANTLR start "behavior_expressions_not"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:690:1: behavior_expressions_not[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : () ;
    public final Object behavior_expressions_not(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Not");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:695:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:696:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F82BFD3C30F11DEAC23001A6BCDC3B3");
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
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "behavior_expressions_not"


    // $ANTLR start "behavior_expressions_booleanaggregate"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:706:1: behavior_expressions_booleanaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN ) ;
    public final Object behavior_expressions_booleanaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BooleanAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:711:3: ( ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:3: ( ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:4: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) ) LPAREN RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F8530E0C30F11DEB1A6001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:63: ( ( 'and' ) | ( 'or' ) | ( 'xor' ) )
            int alt35=3;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt35=1;
                }
                break;
            case 60:
                {
                alt35=2;
                }
                break;
            case 61:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:64: ( 'and' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:80: ( 'and' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:712:81: 'and'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F8530D1C30F11DE88D9001A6BCDC3B3");
                    }
                    match(input,59,FOLLOW_59_in_behavior_expressions_booleanaggregate2838); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F8530D4C30F11DEB519001A6BCDC3B3");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:4: ( 'or' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:20: ( 'or' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:713:21: 'or'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F8530D6C30F11DEA6B9001A6BCDC3B3");
                    }
                    match(input,60,FOLLOW_60_in_behavior_expressions_booleanaggregate2854); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F8530D9C30F11DE8488001A6BCDC3B3");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:4: ( 'xor' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:20: ( 'xor' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:714:21: 'xor'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F8530DBC30F11DE92E7001A6BCDC3B3");
                    }
                    match(input,61,FOLLOW_61_in_behavior_expressions_booleanaggregate2870); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F8530DEC30F11DEA776001A6BCDC3B3");
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
              _beforeSeqEl("E0C851178F8530E1C30F11DEA307001A6BCDC3B3");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate2882); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F8530E2C30F11DE9268001A6BCDC3B3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate2887); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F8530E5C30F11DEAA35001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:724:1: behavior_expressions_binarynumericoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : () ;
    public final Object behavior_expressions_binarynumericoperator(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","BinaryNumericOperator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:729:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:730:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:730:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:730:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F87A1D5C30F11DEA580001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:740:1: behavior_expressions_unaryminus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : () ;
    public final Object behavior_expressions_unaryminus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","UnaryMinus");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:745:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:746:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F8C5CC1C30F11DEBB97001A6BCDC3B3");
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
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "behavior_expressions_unaryminus"


    // $ANTLR start "behavior_expressions_count"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:756:1: behavior_expressions_count[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'count' LPAREN RPAREN ) ;
    public final Object behavior_expressions_count(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Count");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:761:3: ( ( 'count' LPAREN RPAREN ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:3: ( 'count' LPAREN RPAREN )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:3: ( 'count' LPAREN RPAREN )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:762:4: 'count' LPAREN RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F8EA6B1C30F11DEC361001A6BCDC3B3");
            }
            match(input,62,FOLLOW_62_in_behavior_expressions_count2990); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F8EA6B4C30F11DEB2CD001A6BCDC3B3");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F8EA6B5C30F11DEA52D001A6BCDC3B3");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_count2997); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F8EA6B6C30F11DE943C001A6BCDC3B3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_count3002); if (state.failed) return ret2;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:772:1: behavior_expressions_single[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'single' LPAREN RPAREN ) ;
    public final Object behavior_expressions_single(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","Single");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:777:3: ( ( 'single' LPAREN RPAREN ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:778:3: ( 'single' LPAREN RPAREN )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:778:3: ( 'single' LPAREN RPAREN )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:778:4: 'single' LPAREN RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9117B1C30F11DE8467001A6BCDC3B3");
            }
            match(input,63,FOLLOW_63_in_behavior_expressions_single3036); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9117B4C30F11DECF60001A6BCDC3B3");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9117B5C30F11DE8883001A6BCDC3B3");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_single3043); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9117B6C30F11DE9AAC001A6BCDC3B3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_single3048); if (state.failed) return ret2;
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


    // $ANTLR start "behavior_expressions_numericaggregate"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:788:1: behavior_expressions_numericaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN ) ;
    public final Object behavior_expressions_numericaggregate(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","NumericAggregate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:793:3: ( ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:794:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:794:3: ( ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:794:4: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) ) LPAREN RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9388C5C30F11DE883C001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:794:63: ( ( 'sum' ) | ( 'avg' ) | ( 'min' ) | ( 'max' ) )
            int alt36=4;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt36=1;
                }
                break;
            case 65:
                {
                alt36=2;
                }
                break;
            case 66:
                {
                alt36=3;
                }
                break;
            case 67:
                {
                alt36=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:794:64: ( 'sum' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:794:80: ( 'sum' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:794:81: 'sum'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9388B1C30F11DEB214001A6BCDC3B3");
                    }
                    match(input,64,FOLLOW_64_in_behavior_expressions_numericaggregate3087); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9388B4C30F11DE9FB2001A6BCDC3B3");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:795:4: ( 'avg' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:795:20: ( 'avg' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:795:21: 'avg'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9388B6C30F11DE93B0001A6BCDC3B3");
                    }
                    match(input,65,FOLLOW_65_in_behavior_expressions_numericaggregate3103); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9388B9C30F11DEA319001A6BCDC3B3");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:796:4: ( 'min' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:796:20: ( 'min' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:796:21: 'min'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9388BBC30F11DEA5FF001A6BCDC3B3");
                    }
                    match(input,66,FOLLOW_66_in_behavior_expressions_numericaggregate3119); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9388BEC30F11DEA4FD001A6BCDC3B3");
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:797:4: ( 'max' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:797:20: ( 'max' )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:797:21: 'max'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9388C0C30F11DEC426001A6BCDC3B3");
                    }
                    match(input,67,FOLLOW_67_in_behavior_expressions_numericaggregate3135); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9388C3C30F11DE8E75001A6BCDC3B3");
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
              _beforeSeqEl("E0C851178F9388C6C30F11DE82D3001A6BCDC3B3");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_behavior_expressions_numericaggregate3147); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9388C7C30F11DEAF3C001A6BCDC3B3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_behavior_expressions_numericaggregate3152); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9388CAC30F11DEC0F2001A6BCDC3B3");
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


    // $ANTLR start "behavior_expressions_expression_pathExpression"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:807:1: behavior_expressions_expression_pathExpression returns [Object ret2] : (ret= behavior_expressions_this_pathExpression ) ;
    public final Object behavior_expressions_expression_pathExpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:808:3: ( (ret= behavior_expressions_this_pathExpression ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:3: (ret= behavior_expressions_this_pathExpression )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:3: (ret= behavior_expressions_this_pathExpression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:809:4: ret= behavior_expressions_this_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_this_pathExpression_in_behavior_expressions_expression_pathExpression3185);
            ret=behavior_expressions_this_pathExpression();

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


    // $ANTLR start "behavior_expressions_this_pathExpression"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:816:1: behavior_expressions_this_pathExpression returns [Object ret2] : () ;
    public final Object behavior_expressions_this_pathExpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("behavior","expressions","This");
        onEnterTemplateRule(metaType,"pathExpression");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:821:3: ( () )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:822:3: ()
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:822:3: ()
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:822:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9AB4A2C30F11DEAF30001A6BCDC3B3");
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
    // $ANTLR end "behavior_expressions_this_pathExpression"


    // $ANTLR start "behavior_expressions_firstpathexpression"
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:830:1: behavior_expressions_firstpathexpression returns [Object ret2] : ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_firstpathexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FirstPathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:835:3: ( ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:3: ( DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:4: DOT (temp= behavior_expressions_expression_pathExpression ) ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9AB4A6C30F11DE81EB001A6BCDC3B3");
            }
            match(input,DOT,FOLLOW_DOT_in_behavior_expressions_firstpathexpression3256); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9AB4A9C30F11DEC234001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:143: (temp= behavior_expressions_expression_pathExpression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:145: temp= behavior_expressions_expression_pathExpression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression3264);
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
              _beforeSeqEl("E0C851178F9AB4B6C30F11DEA30E001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:309: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==FIRST_LOWERCASE_NAME) ) {
                alt37=1;
            }
            else if ( (LA37_0==FIRST_UPPERCASE_NAME) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:310: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:326: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:327: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9AB4AEC30F11DE80F6001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:386: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:836:388: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression3279);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:837:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:837:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:837:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9AB4B4C30F11DEB807001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:837:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:837:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression3299);
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
              _beforeSeqEl("E0C851178F9AB4B9C30F11DE88AE001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:845:1: behavior_expressions_pathexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) ;
    public final Object behavior_expressions_pathexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","PathExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:850:3: ( ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:3: ( ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:4: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178F9F6F9CC30F11DEC767001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:63: ( ( (temp= firstLowercaseIdentifier ) ) | ( (temp= firstUppercaseIdentifier ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==FIRST_LOWERCASE_NAME) ) {
                alt38=1;
            }
            else if ( (LA38_0==FIRST_UPPERCASE_NAME) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:64: ( (temp= firstLowercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:80: ( (temp= firstLowercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:81: (temp= firstLowercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9F6F94C30F11DEAF24001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:140: (temp= firstLowercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:851:142: temp= firstLowercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression3360);
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
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:852:4: ( (temp= firstUppercaseIdentifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:852:20: ( (temp= firstUppercaseIdentifier ) )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:852:21: (temp= firstUppercaseIdentifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0C851178F9F6F9AC30F11DEC6FB001A6BCDC3B3");
                    }
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:852:80: (temp= firstUppercaseIdentifier )
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:852:82: temp= firstUppercaseIdentifier
                    {
                    pushFollow(FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression3380);
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
              _beforeSeqEl("E0C851178F9F6F9FC30F11DEA276001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:862:1: behavior_expressions_filterexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= behavior_expressions_expression ) RBRACKET ) ;
    public final Object behavior_expressions_filterexpression(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","FilterExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:867:3: ( ( (temp= behavior_expressions_expression ) RBRACKET ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:868:3: ( (temp= behavior_expressions_expression ) RBRACKET )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:868:3: ( (temp= behavior_expressions_expression ) RBRACKET )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:868:4: (temp= behavior_expressions_expression ) RBRACKET
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178FA1B982C30F11DECA7F001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:868:63: (temp= behavior_expressions_expression )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:868:65: temp= behavior_expressions_expression
            {
            pushFollow(FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression3428);
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
              _beforeSeqEl("E0C851178FA1B983C30F11DE8207001A6BCDC3B3");
            }
            match(input,RBRACKET,FOLLOW_RBRACKET_in_behavior_expressions_filterexpression3435); if (state.failed) return ret2;
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:878:1: behavior_expressions_literals_literal returns [Object ret2] : (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) ;
    public final Object behavior_expressions_literals_literal() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:879:3: ( (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:880:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:880:3: (ret= behavior_expressions_literals_booleanliteral | ret= behavior_expressions_literals_stringliteral | ret= behavior_expressions_literals_decimalliteral | ret= behavior_expressions_literals_integerliteral | ret= behavior_expressions_literals_dateliteral | ret= behavior_expressions_literals_binaryliteral )
            int alt39=6;
            switch ( input.LA(1) ) {
            case BOOL:
                {
                alt39=1;
                }
                break;
            case STRING:
                {
                alt39=2;
                }
                break;
            case FLOAT:
                {
                alt39=3;
                }
                break;
            case INT:
                {
                alt39=4;
                }
                break;
            case DATE:
                {
                alt39=5;
                }
                break;
            case BINARY:
                {
                alt39=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:880:4: ret= behavior_expressions_literals_booleanliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal3465);
                    ret=behavior_expressions_literals_booleanliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:881:5: ret= behavior_expressions_literals_stringliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal3473);
                    ret=behavior_expressions_literals_stringliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:882:5: ret= behavior_expressions_literals_decimalliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal3481);
                    ret=behavior_expressions_literals_decimalliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:883:5: ret= behavior_expressions_literals_integerliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal3489);
                    ret=behavior_expressions_literals_integerliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:884:5: ret= behavior_expressions_literals_dateliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal3497);
                    ret=behavior_expressions_literals_dateliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:885:5: ret= behavior_expressions_literals_binaryliteral
                    {
                    pushFollow(FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal3505);
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:892:1: behavior_expressions_literals_booleanliteral returns [Object ret2] : ( (temp= booleanSymbol ) ) ;
    public final Object behavior_expressions_literals_booleanliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BooleanLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:897:3: ( ( (temp= booleanSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:898:3: ( (temp= booleanSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:898:3: ( (temp= booleanSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:898:4: (temp= booleanSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178FA69B82C30F11DEB0F1001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:898:63: (temp= booleanSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:898:65: temp= booleanSymbol
            {
            pushFollow(FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral3539);
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
              _beforeSeqEl("E0C851178FA69B85C30F11DEC02A001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:906:1: behavior_expressions_literals_stringliteral returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object behavior_expressions_literals_stringliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","StringLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:911:3: ( ( (temp= stringSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:912:3: ( (temp= stringSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:912:3: ( (temp= stringSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:912:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178FAB5672C30F11DE8EC5001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:912:63: (temp= stringSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:912:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral3589);
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
              _beforeSeqEl("E0C851178FAB5675C30F11DEBE59001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:920:1: behavior_expressions_literals_decimalliteral returns [Object ret2] : ( (temp= floatAsStringSymbol ) ) ;
    public final Object behavior_expressions_literals_decimalliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DecimalLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:925:3: ( ( (temp= floatAsStringSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:926:3: ( (temp= floatAsStringSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:926:3: ( (temp= floatAsStringSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:926:4: (temp= floatAsStringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178FADA062C30F11DE8587001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:926:63: (temp= floatAsStringSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:926:65: temp= floatAsStringSymbol
            {
            pushFollow(FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral3639);
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
              _beforeSeqEl("E0C851178FB01162C30F11DEA741001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:934:1: behavior_expressions_literals_integerliteral returns [Object ret2] : ( (temp= integerAsStringSymbol ) ) ;
    public final Object behavior_expressions_literals_integerliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","IntegerLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:939:3: ( ( (temp= integerAsStringSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:940:3: ( (temp= integerAsStringSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:940:3: ( (temp= integerAsStringSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:940:4: (temp= integerAsStringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178FB28262C30F11DE83D8001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:940:63: (temp= integerAsStringSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:940:65: temp= integerAsStringSymbol
            {
            pushFollow(FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral3689);
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
              _beforeSeqEl("E0C851178FB28265C30F11DEC552001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:948:1: behavior_expressions_literals_dateliteral returns [Object ret2] : ( (temp= dateSymbol ) ) ;
    public final Object behavior_expressions_literals_dateliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","DateLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:953:3: ( ( (temp= dateSymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:954:3: ( (temp= dateSymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:954:3: ( (temp= dateSymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:954:4: (temp= dateSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178FB4CC52C30F11DEB093001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:954:63: (temp= dateSymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:954:65: temp= dateSymbol
            {
            pushFollow(FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral3739);
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
              _beforeSeqEl("E0C851178FB4CC55C30F11DECC5F001A6BCDC3B3");
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
    // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:962:1: behavior_expressions_literals_binaryliteral returns [Object ret2] : ( (temp= binarySymbol ) ) ;
    public final Object behavior_expressions_literals_binaryliteral() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("behavior","expressions","literals","BinaryLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:967:3: ( ( (temp= binarySymbol ) ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:968:3: ( (temp= binarySymbol ) )
            {
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:968:3: ( (temp= binarySymbol ) )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:968:4: (temp= binarySymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0C851178FB73D52C30F11DEAAFD001A6BCDC3B3");
            }
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:968:63: (temp= binarySymbol )
            // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:968:65: temp= binarySymbol
            {
            pushFollow(FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral3789);
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
              _beforeSeqEl("E0C851178FB73D55C30F11DEA42A001A6BCDC3B3");
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
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:397: ( structure_association )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:356:398: structure_association
        {
        pushFollow(FOLLOW_structure_association_in_synpred1_FinexClass560);
        structure_association();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_FinexClass

    // $ANTLR start synpred2_FinexClass
    public final void synpred2_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:4: ( behavior_functions_function )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:357:5: behavior_functions_function
        {
        pushFollow(FOLLOW_behavior_functions_function_in_synpred2_FinexClass591);
        behavior_functions_function();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_FinexClass

    // $ANTLR start synpred3_FinexClass
    public final void synpred3_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:4: ( structure_type_field )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:402:5: structure_type_field
        {
        pushFollow(FOLLOW_structure_type_field_in_synpred3_FinexClass1051);
        structure_type_field();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_FinexClass

    // $ANTLR start synpred5_FinexClass
    public final void synpred5_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:6: ( '-' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:582:7: '-'
        {
        match(input,49,FOLLOW_49_in_synpred5_FinexClass2126); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_FinexClass

    // $ANTLR start synpred6_FinexClass
    public final void synpred6_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:3: ( 'not' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:585:4: 'not'
        {
        match(input,50,FOLLOW_50_in_synpred6_FinexClass2154); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_FinexClass

    // $ANTLR start synpred7_FinexClass
    public final void synpred7_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:48: ( DOT )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:589:49: DOT
        {
        match(input,DOT,FOLLOW_DOT_in_synpred7_FinexClass2190); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_FinexClass

    // $ANTLR start synpred8_FinexClass
    public final void synpred8_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:3: ( LBRACKET )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:594:4: LBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred8_FinexClass2250); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_FinexClass

    // $ANTLR start synpred9_FinexClass
    public final void synpred9_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:35: ( '*' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:604:36: '*'
        {
        match(input,51,FOLLOW_51_in_synpred9_FinexClass2308); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_FinexClass

    // $ANTLR start synpred10_FinexClass
    public final void synpred10_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:3: ( '/' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:607:4: '/'
        {
        match(input,52,FOLLOW_52_in_synpred10_FinexClass2336); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_FinexClass

    // $ANTLR start synpred11_FinexClass
    public final void synpred11_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:3: ( 'AND' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:610:4: 'AND'
        {
        match(input,53,FOLLOW_53_in_synpred11_FinexClass2364); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_FinexClass

    // $ANTLR start synpred12_FinexClass
    public final void synpred12_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:35: ( 'OR' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:622:36: 'OR'
        {
        match(input,54,FOLLOW_54_in_synpred12_FinexClass2426); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_FinexClass

    // $ANTLR start synpred13_FinexClass
    public final void synpred13_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:3: ( '+' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:625:4: '+'
        {
        match(input,55,FOLLOW_55_in_synpred13_FinexClass2454); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_FinexClass

    // $ANTLR start synpred14_FinexClass
    public final void synpred14_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:3: ( '-' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:628:4: '-'
        {
        match(input,49,FOLLOW_49_in_synpred14_FinexClass2482); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_FinexClass

    // $ANTLR start synpred15_FinexClass
    public final void synpred15_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:35: ( RANGLE )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:640:36: RANGLE
        {
        match(input,RANGLE,FOLLOW_RANGLE_in_synpred15_FinexClass2544); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_FinexClass

    // $ANTLR start synpred16_FinexClass
    public final void synpred16_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:3: ( LANGLE )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:643:4: LANGLE
        {
        match(input,LANGLE,FOLLOW_LANGLE_in_synpred16_FinexClass2573); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_FinexClass

    // $ANTLR start synpred17_FinexClass
    public final void synpred17_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:3: ( '>=' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:646:4: '>='
        {
        match(input,56,FOLLOW_56_in_synpred17_FinexClass2602); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_FinexClass

    // $ANTLR start synpred18_FinexClass
    public final void synpred18_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:3: ( '<=' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:649:4: '<='
        {
        match(input,57,FOLLOW_57_in_synpred18_FinexClass2630); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_FinexClass

    // $ANTLR start synpred19_FinexClass
    public final void synpred19_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:3: ( EQUALS )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:652:4: EQUALS
        {
        match(input,EQUALS,FOLLOW_EQUALS_in_synpred19_FinexClass2658); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_FinexClass

    // $ANTLR start synpred20_FinexClass
    public final void synpred20_FinexClass_fragment() throws RecognitionException {   
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:3: ( '!=' )
        // C:\\jan_dev\\runlet\\runtime-workspace\\com.sap.finex.editor\\generated\\generated\\FinexClass.g:655:4: '!='
        {
        match(input,58,FOLLOW_58_in_synpred20_FinexClass2687); if (state.failed) return ;

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


    protected DFA25 dfa25 = new DFA25(this);
    static final String DFA25_eotS =
        "\13\uffff";
    static final String DFA25_eofS =
        "\13\uffff";
    static final String DFA25_minS =
        "\1\6\12\uffff";
    static final String DFA25_maxS =
        "\1\62\12\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\1\1\2\10\uffff";
    static final String DFA25_specialS =
        "\13\uffff}>";
    static final String[] DFA25_transitionS = {
            "\6\2\4\uffff\1\1\2\uffff\1\2\35\uffff\2\2",
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

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "524:3: (ret= behavior_actions_statementwithargument | ret= behavior_actions_expressionstatement )";
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
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_classdeclaration519 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_classdeclaration539 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_classdeclaration551 = new BitSet(new long[]{0x0000200000035000L});
    public static final BitSet FOLLOW_structure_association_in_classdeclaration573 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration580 = new BitSet(new long[]{0x0000200000035000L});
    public static final BitSet FOLLOW_behavior_functions_function_in_classdeclaration604 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration611 = new BitSet(new long[]{0x0000200000035000L});
    public static final BitSet FOLLOW_LBRACKET_in_classdeclaration626 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_classdeclaration634 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_classdeclaration641 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classdeclaration646 = new BitSet(new long[]{0x0000200000035000L});
    public static final BitSet FOLLOW_COLON_in_classdeclaration660 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_classdeclaration673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_classdeclaration693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_finexclass_in_structure_type728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_field_in_structure_association762 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_structure_association773 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_structure_field_opposite_in_structure_association780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_field_nondeclaredOpposite_in_structure_association800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_structure_field857 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_DDOT_in_structure_field875 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field901 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field924 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field947 = new BitSet(new long[]{0x00000C0000040000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_structure_field967 = new BitSet(new long[]{0x00000C0000040000L});
    public static final BitSet FOLLOW_askey_in_structure_field978 = new BitSet(new long[]{0x0000040000040002L});
    public static final BitSet FOLLOW_42_in_structure_field987 = new BitSet(new long[]{0x0006000000090FC2L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1013 = new BitSet(new long[]{0x0006000000090FC2L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_structure_field1064 = new BitSet(new long[]{0x00000C0000040000L});
    public static final BitSet FOLLOW_askey_in_structure_field1073 = new BitSet(new long[]{0x0000040000040002L});
    public static final BitSet FOLLOW_42_in_structure_field1082 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_structure_field1106 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_structure_field1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_structure_field_opposite1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_askey1270 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_askey1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_behavior_functions_function1318 = new BitSet(new long[]{0x0000000000080030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_functions_function1330 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_functions_function1350 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_functions_function1375 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_46_in_behavior_functions_function1384 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_IN_in_behavior_functions_function1391 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_behavior_functions_function1399 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_IN_in_behavior_functions_function1406 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_behavior_functions_function1420 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_behavior_functions_function1423 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_behavior_functions_function1430 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_behavior_functions_function1438 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_behavior_functions_function1445 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_48_in_behavior_functions_function1479 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_behavior_functions_function1486 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_47_in_behavior_functions_function1494 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_behavior_functions_parameter_OUT_in_behavior_functions_function1501 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_functions_function1516 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_COLON_in_behavior_functions_function1521 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_behavior_actions_block_in_behavior_functions_function1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_parameter1575 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_parameter1595 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_parameter1615 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_parameter1635 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_parameter1652 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_parameter1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_IN1705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_in_behavior_functions_parameter_OUT1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_behavior_actions_block1794 = new BitSet(new long[]{0x0006000000490FC0L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1805 = new BitSet(new long[]{0x0006000000490FC0L});
    public static final BitSet FOLLOW_behavior_actions_statement_in_behavior_actions_block1813 = new BitSet(new long[]{0x0006000000490FC0L});
    public static final BitSet FOLLOW_RCURL_in_behavior_actions_block1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_statementwithargument_in_behavior_actions_statement1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_expressionstatement_in_behavior_actions_statement1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_actions_assignment_in_behavior_actions_statementwithargument1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_behavior_actions_assignment1942 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_actions_assignment1950 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_EQUALS_in_behavior_actions_assignment1957 = new BitSet(new long[]{0x0006000000092FC0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_actions_assignment1965 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions_assignment1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_actions_expressionstatement2019 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_behavior_actions_expressionstatement2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_literal_in_primary_behavior_expressions_expression2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_firstpathexpression_in_primary_behavior_expressions_expression2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_behavior_expressions_expression2081 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_primary_behavior_expressions_expression2087 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_behavior_expressions_expression2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_expressions_priority_02132 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_unaryminus_in_expressions_priority_02139 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_expressions_priority_02160 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_not_in_expressions_priority_02167 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_behavior_expressions_expression_in_expressions_priority_02187 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_DOT_in_expressions_priority_02196 = new BitSet(new long[]{0xF800000000000030L,0x000000000000000FL});
    public static final BitSet FOLLOW_behavior_expressions_booleanaggregate_in_expressions_priority_02204 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_count_in_expressions_priority_02213 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_single_in_expressions_priority_02222 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_numericaggregate_in_expressions_priority_02231 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_behavior_expressions_pathexpression_in_expressions_priority_02240 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_LBRACKET_in_expressions_priority_02256 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_filterexpression_in_expressions_priority_02264 = new BitSet(new long[]{0x0000000000014002L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12305 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_51_in_expressions_priority_12314 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12321 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12325 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_52_in_expressions_priority_12342 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_12349 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12353 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_53_in_expressions_priority_12370 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_12377 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_0_in_expressions_priority_12381 = new BitSet(new long[]{0x0038000000000002L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22423 = new BitSet(new long[]{0x00C2000000000002L});
    public static final BitSet FOLLOW_54_in_expressions_priority_22432 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarybooleanoperator_in_expressions_priority_22439 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22443 = new BitSet(new long[]{0x00C2000000000002L});
    public static final BitSet FOLLOW_55_in_expressions_priority_22460 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22467 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22471 = new BitSet(new long[]{0x00C2000000000002L});
    public static final BitSet FOLLOW_49_in_expressions_priority_22488 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_22495 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_1_in_expressions_priority_22499 = new BitSet(new long[]{0x00C2000000000002L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32541 = new BitSet(new long[]{0x0700000003800002L});
    public static final BitSet FOLLOW_RANGLE_in_expressions_priority_32550 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32558 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32562 = new BitSet(new long[]{0x0700000003800002L});
    public static final BitSet FOLLOW_LANGLE_in_expressions_priority_32579 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32587 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32591 = new BitSet(new long[]{0x0700000003800002L});
    public static final BitSet FOLLOW_56_in_expressions_priority_32608 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32615 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32619 = new BitSet(new long[]{0x0700000003800002L});
    public static final BitSet FOLLOW_57_in_expressions_priority_32636 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32643 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32647 = new BitSet(new long[]{0x0700000003800002L});
    public static final BitSet FOLLOW_EQUALS_in_expressions_priority_32664 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32672 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32676 = new BitSet(new long[]{0x0700000003800002L});
    public static final BitSet FOLLOW_58_in_expressions_priority_32693 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_behavior_expressions_binarynumericoperator_in_expressions_priority_32700 = new BitSet(new long[]{0x0006000000090FC0L});
    public static final BitSet FOLLOW_expressions_priority_2_in_expressions_priority_32704 = new BitSet(new long[]{0x0700000003800002L});
    public static final BitSet FOLLOW_expressions_priority_3_in_behavior_expressions_expression2737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_behavior_expressions_booleanaggregate2838 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_60_in_behavior_expressions_booleanaggregate2854 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_61_in_behavior_expressions_booleanaggregate2870 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_booleanaggregate2882 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_booleanaggregate2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_behavior_expressions_count2990 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_count2997 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_count3002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_behavior_expressions_single3036 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_single3043 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_single3048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_behavior_expressions_numericaggregate3087 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_65_in_behavior_expressions_numericaggregate3103 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_66_in_behavior_expressions_numericaggregate3119 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_67_in_behavior_expressions_numericaggregate3135 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_LPAREN_in_behavior_expressions_numericaggregate3147 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_behavior_expressions_numericaggregate3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_this_pathExpression_in_behavior_expressions_expression_pathExpression3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_behavior_expressions_firstpathexpression3256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_behavior_expressions_expression_pathExpression_in_behavior_expressions_firstpathexpression3264 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_firstpathexpression3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_firstpathexpression3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstLowercaseIdentifier_in_behavior_expressions_pathexpression3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_firstUppercaseIdentifier_in_behavior_expressions_pathexpression3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_expression_in_behavior_expressions_filterexpression3428 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RBRACKET_in_behavior_expressions_filterexpression3435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_booleanliteral_in_behavior_expressions_literals_literal3465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_stringliteral_in_behavior_expressions_literals_literal3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_decimalliteral_in_behavior_expressions_literals_literal3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_integerliteral_in_behavior_expressions_literals_literal3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_dateliteral_in_behavior_expressions_literals_literal3497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_expressions_literals_binaryliteral_in_behavior_expressions_literals_literal3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanSymbol_in_behavior_expressions_literals_booleanliteral3539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_behavior_expressions_literals_stringliteral3589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsStringSymbol_in_behavior_expressions_literals_decimalliteral3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsStringSymbol_in_behavior_expressions_literals_integerliteral3689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dateSymbol_in_behavior_expressions_literals_dateliteral3739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binarySymbol_in_behavior_expressions_literals_binaryliteral3789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_association_in_synpred1_FinexClass560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behavior_functions_function_in_synpred2_FinexClass591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structure_type_field_in_synpred3_FinexClass1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred5_FinexClass2126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_synpred6_FinexClass2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_synpred7_FinexClass2190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred8_FinexClass2250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_synpred9_FinexClass2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_synpred10_FinexClass2336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred11_FinexClass2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred12_FinexClass2426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_synpred13_FinexClass2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred14_FinexClass2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGLE_in_synpred15_FinexClass2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LANGLE_in_synpred16_FinexClass2573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_synpred17_FinexClass2602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_synpred18_FinexClass2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_synpred19_FinexClass2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred20_FinexClass2687 = new BitSet(new long[]{0x0000000000000002L});

}