// $ANTLR 3.1.1 C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g 2009-12-12 16:31:22

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
public class MofClassParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "QNAME", "MULTI_LINE_COMMENT", "INT", "FLOAT", "BOOL", "LCURL", "RCURL", "LPAREN", "RPAREN", "DDOT", "STAR", "LBRACKET", "RBRACKET", "LBRACK_LCURL", "RCURL_RBRACK", "LCURL_LBRACK", "RBRACK_RCURL", "COLON", "DCOLON", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "RANGE_OR_INT", "'let'", "'iterate'", "'invariants'", "'in'", "'endif'", "'if'", "'|'", "'abstract'", "'public'", "','", "'Bag'", "'Sequence'", "'then'", "'class'", "'self'", "'Collection'", "'->'", "'.'", "'='", "'OrderedSet'", "'protected'", "'extends'", "'else'", "'private'", "'Set'", "'static'", "'readonly'", "';'"
    };
    public static final int STAR=16;
    public static final int RBRACK_RCURL=22;
    public static final int FLOAT=9;
    public static final int EOF=-1;
    public static final int LPAREN=13;
    public static final int LBRACKET=17;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int RPAREN=14;
    public static final int DCOLON=24;
    public static final int T__58=58;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int LBRACK_LCURL=19;
    public static final int DIGIT=28;
    public static final int NL=26;
    public static final int RANGE_OR_INT=31;
    public static final int RBRACKET=18;
    public static final int COMMENT=25;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int RCURL_RBRACK=20;
    public static final int T__43=43;
    public static final int LCURL_LBRACK=21;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=15;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=10;
    public static final int INT=8;
    public static final int MULTI_LINE_COMMENT=7;
    public static final int ALPHA=29;
    public static final int COLON=23;
    public static final int T__32=32;
    public static final int LCURL=11;
    public static final int WS=27;
    public static final int T__33=33;
    public static final int QNAME=6;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int SNAME=30;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RCURL=12;
    public static final int STRING=5;

    // delegates
    // delegators


        public MofClassParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MofClassParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return MofClassParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g"; }


       private static final String syntaxUUID = "E01DFA6E64DB8530E73311DE9C27F7FB8D150602";
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:208:3: ( (ast= NAME ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:209:3: (ast= NAME )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:209:3: (ast= NAME )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:209:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier63); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'let' | 'iterate' | 'invariants' | 'in' | 'endif' | 'if' | '|' | 'abstract' | 'public' | ',' | 'Bag' | 'Sequence' | 'then' | 'class' | 'self' | 'Collection' | '->' | '.' | '=' | 'OrderedSet' | 'protected' | 'extends' | 'else' | 'private' | 'Set' | 'static' | 'readonly' | ';' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:218:3: ( (ast= NAME | 'let' | 'iterate' | 'invariants' | 'in' | 'endif' | 'if' | '|' | 'abstract' | 'public' | ',' | 'Bag' | 'Sequence' | 'then' | 'class' | 'self' | 'Collection' | '->' | '.' | '=' | 'OrderedSet' | 'protected' | 'extends' | 'else' | 'private' | 'Set' | 'static' | 'readonly' | ';' ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:219:3: (ast= NAME | 'let' | 'iterate' | 'invariants' | 'in' | 'endif' | 'if' | '|' | 'abstract' | 'public' | ',' | 'Bag' | 'Sequence' | 'then' | 'class' | 'self' | 'Collection' | '->' | '.' | '=' | 'OrderedSet' | 'protected' | 'extends' | 'else' | 'private' | 'Set' | 'static' | 'readonly' | ';' )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:219:3: (ast= NAME | 'let' | 'iterate' | 'invariants' | 'in' | 'endif' | 'if' | '|' | 'abstract' | 'public' | ',' | 'Bag' | 'Sequence' | 'then' | 'class' | 'self' | 'Collection' | '->' | '.' | '=' | 'OrderedSet' | 'protected' | 'extends' | 'else' | 'private' | 'Set' | 'static' | 'readonly' | ';' )
            int alt1=29;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 32:
                {
                alt1=2;
                }
                break;
            case 33:
                {
                alt1=3;
                }
                break;
            case 34:
                {
                alt1=4;
                }
                break;
            case 35:
                {
                alt1=5;
                }
                break;
            case 36:
                {
                alt1=6;
                }
                break;
            case 37:
                {
                alt1=7;
                }
                break;
            case 38:
                {
                alt1=8;
                }
                break;
            case 39:
                {
                alt1=9;
                }
                break;
            case 40:
                {
                alt1=10;
                }
                break;
            case 41:
                {
                alt1=11;
                }
                break;
            case 42:
                {
                alt1=12;
                }
                break;
            case 43:
                {
                alt1=13;
                }
                break;
            case 44:
                {
                alt1=14;
                }
                break;
            case 45:
                {
                alt1=15;
                }
                break;
            case 46:
                {
                alt1=16;
                }
                break;
            case 47:
                {
                alt1=17;
                }
                break;
            case 48:
                {
                alt1=18;
                }
                break;
            case 49:
                {
                alt1=19;
                }
                break;
            case 50:
                {
                alt1=20;
                }
                break;
            case 51:
                {
                alt1=21;
                }
                break;
            case 52:
                {
                alt1=22;
                }
                break;
            case 53:
                {
                alt1=23;
                }
                break;
            case 54:
                {
                alt1=24;
                }
                break;
            case 55:
                {
                alt1=25;
                }
                break;
            case 56:
                {
                alt1=26;
                }
                break;
            case 57:
                {
                alt1=27;
                }
                break;
            case 58:
                {
                alt1=28;
                }
                break;
            case 59:
                {
                alt1=29;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:219:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword94); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:221:5: 'let'
                    {
                    match(input,32,FOLLOW_32_in_identifierOrKeyword102); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "let";
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:222:5: 'iterate'
                    {
                    match(input,33,FOLLOW_33_in_identifierOrKeyword110); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "iterate";
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:223:5: 'invariants'
                    {
                    match(input,34,FOLLOW_34_in_identifierOrKeyword118); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "invariants";
                    }

                    }
                    break;
                case 5 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:224:5: 'in'
                    {
                    match(input,35,FOLLOW_35_in_identifierOrKeyword126); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 6 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:225:5: 'endif'
                    {
                    match(input,36,FOLLOW_36_in_identifierOrKeyword134); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endif";
                    }

                    }
                    break;
                case 7 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:226:5: 'if'
                    {
                    match(input,37,FOLLOW_37_in_identifierOrKeyword142); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "if";
                    }

                    }
                    break;
                case 8 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:227:5: '|'
                    {
                    match(input,38,FOLLOW_38_in_identifierOrKeyword150); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "|";
                    }

                    }
                    break;
                case 9 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:228:5: 'abstract'
                    {
                    match(input,39,FOLLOW_39_in_identifierOrKeyword158); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 10 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:229:5: 'public'
                    {
                    match(input,40,FOLLOW_40_in_identifierOrKeyword166); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "public";
                    }

                    }
                    break;
                case 11 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:230:5: ','
                    {
                    match(input,41,FOLLOW_41_in_identifierOrKeyword174); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = ",";
                    }

                    }
                    break;
                case 12 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:231:5: 'Bag'
                    {
                    match(input,42,FOLLOW_42_in_identifierOrKeyword182); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Bag";
                    }

                    }
                    break;
                case 13 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:232:5: 'Sequence'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword190); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Sequence";
                    }

                    }
                    break;
                case 14 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:233:5: 'then'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword198); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "then";
                    }

                    }
                    break;
                case 15 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:234:5: 'class'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword206); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "class";
                    }

                    }
                    break;
                case 16 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:235:5: 'self'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword214); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "self";
                    }

                    }
                    break;
                case 17 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:236:5: 'Collection'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword222); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Collection";
                    }

                    }
                    break;
                case 18 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:237:5: '->'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword230); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "->";
                    }

                    }
                    break;
                case 19 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:238:5: '.'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword238); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = ".";
                    }

                    }
                    break;
                case 20 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:239:5: '='
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword246); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "=";
                    }

                    }
                    break;
                case 21 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:240:5: 'OrderedSet'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword254); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "OrderedSet";
                    }

                    }
                    break;
                case 22 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:241:5: 'protected'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword262); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "protected";
                    }

                    }
                    break;
                case 23 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:242:5: 'extends'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword270); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "extends";
                    }

                    }
                    break;
                case 24 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:243:5: 'else'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword278); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "else";
                    }

                    }
                    break;
                case 25 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:244:5: 'private'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword286); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "private";
                    }

                    }
                    break;
                case 26 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:245:5: 'Set'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword294); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Set";
                    }

                    }
                    break;
                case 27 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:246:5: 'static'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword302); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "static";
                    }

                    }
                    break;
                case 28 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:247:5: 'readonly'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword310); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "readonly";
                    }

                    }
                    break;
                case 29 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:248:5: ';'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword318); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = ";";
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:255:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:256:3: ( (ast= STRING ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:257:3: (ast= STRING )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:257:3: (ast= STRING )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:257:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol349); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:265:1: qualifiedNameSymbol returns [Object ret2] : (ast= QNAME ) ;
    public final Object qualifiedNameSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:266:3: ( (ast= QNAME ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:267:3: (ast= QNAME )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:267:3: (ast= QNAME )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:267:4: ast= QNAME
            {
            ast=(Token)match(input,QNAME,FOLLOW_QNAME_in_qualifiedNameSymbol380); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:275:1: annotationSymbol returns [Object ret2] : (ast= MULTI_LINE_COMMENT ) ;
    public final Object annotationSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:276:3: ( (ast= MULTI_LINE_COMMENT ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:277:3: (ast= MULTI_LINE_COMMENT )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:277:3: (ast= MULTI_LINE_COMMENT )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:277:4: ast= MULTI_LINE_COMMENT
            {
            ast=(Token)match(input,MULTI_LINE_COMMENT,FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol411); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:285:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:286:3: ( (ast= INT ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:287:3: (ast= INT )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:287:3: (ast= INT )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:287:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol442); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:295:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:296:3: ( (ast= INT ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:297:3: (ast= INT )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:297:3: (ast= INT )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:297:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol473); if (state.failed) return ret2;
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


    // $ANTLR start "integerAsString"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:305:1: integerAsString returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsString() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:306:3: ( (ast= INT ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:307:3: (ast= INT )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:307:3: (ast= INT )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:307:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsString504); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:315:1: floatAsString returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsString() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:316:3: ( (ast= FLOAT ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:317:3: (ast= FLOAT )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:317:3: (ast= FLOAT )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:317:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsString535); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:325:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:326:3: ( (ast= BOOL ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:327:3: (ast= BOOL )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:327:3: (ast= BOOL )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:327:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol566); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:335:1: booleanValueSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanValueSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:336:3: ( (ast= BOOL ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:337:3: (ast= BOOL )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:337:3: (ast= BOOL )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:337:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanValueSymbol597); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:345:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:346:3: ( (ast= FLOAT ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:347:3: (ast= FLOAT )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:347:3: (ast= FLOAT )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:347:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol628); if (state.failed) return ret2;
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


    // $ANTLR start "main"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:355:1: main returns [Object ret2] : ( (ret= model_class ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:356:3: ( ( (ret= model_class ) EOF ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:357:3: ( (ret= model_class ) EOF )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:357:3: ( (ret= model_class ) EOF )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:357:4: (ret= model_class ) EOF
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:357:4: (ret= model_class )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:357:5: ret= model_class
            {
            pushFollow(FOLLOW_model_class_in_main656);
            ret=model_class();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main659); if (state.failed) return ret2;

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


    // $ANTLR start "model_class"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:364:1: model_class returns [Object ret2] : ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) ) ) | ) LCURL ( ( (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | ) ) ) RCURL ) ;
    public final Object model_class() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Class");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"class"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:369:3: ( ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) ) ) | ) LCURL ( ( (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | ) ) ) RCURL ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:370:3: ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) ) ) | ) LCURL ( ( (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | ) ) ) RCURL )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:370:3: ( annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) ) ) | ) LCURL ( ( (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | ) ) ) RCURL )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:370:4: annotation[ret] visibility[ret] ( ( 'abstract' ) | ) 'class' (temp= identifier ) ( ( 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) ) ) | ) LCURL ( ( (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | ) ) ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E649EA340E73311DE8E70F7FB8D150602");
            }
            pushFollow(FOLLOW_annotation_in_model_class690);
            annotation(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E649EA341E73311DE90A5F7FB8D150602");
            }
            pushFollow(FOLLOW_visibility_in_model_class694);
            visibility(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E649ECA53E73311DEBAC9F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:370:244: ( ( 'abstract' ) | )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==39) ) {
                alt2=1;
            }
            else if ( (LA2_0==45) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:370:245: ( 'abstract' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:370:261: ( 'abstract' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:370:262: 'abstract'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E649ECA51E73311DE9FBBF7FB8D150602");
                    }
                    match(input,39,FOLLOW_39_in_model_class704); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:370:422: 
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
              _beforeSeqEl("E01DFA6E649EF160E73311DEC403F7FB8D150602");
            }
            match(input,45,FOLLOW_45_in_model_class722); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E649EF162E73311DECBF8F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:158: (temp= identifier )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:160: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_class729);
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
              _beforeSeqEl("E01DFA6E649FDBC1E73311DE8B3EF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:286: ( ( 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) ) ) | )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==53) ) {
                alt6=1;
            }
            else if ( (LA6_0==LCURL) ) {
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:287: ( 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:303: ( 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:304: 'extends' ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E649F1870E73311DEBAC3F7FB8D150602");
                    }
                    match(input,53,FOLLOW_53_in_model_class741); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E649FB4B1E73311DE865DF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:447: ( ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) ) | ( (temp= identifier ( ( ',' ) temp= identifier )* ) ) )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==QNAME) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==NAME) ) {
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:448: ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:464: ( (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:465: (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E649F3F82E73311DE9304F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:524: (temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )* )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:526: temp= qualifiedNameSymbol ( ( ',' ) temp= qualifiedNameSymbol )*
                            {
                            pushFollow(FOLLOW_qualifiedNameSymbol_in_model_class753);
                            temp=qualifiedNameSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setOclRef(ret, "supertypes", null, temp, "OCL:"+"			let t=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  				i; acc:Tuple(pos:Integer, ns:Set(Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"				t.ns.contents->select(c | c.name=?.subString(t.pos, ?.size()))"+"  	  		");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:1306: ( ( ',' ) temp= qualifiedNameSymbol )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==41) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:1307: ( ',' ) temp= qualifiedNameSymbol
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:1324: ( ',' )
                            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:371:1325: ','
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E01DFA6E649F1875E73311DE8FD5F7FB8D150602");
                            	    }
                            	    match(input,41,FOLLOW_41_in_model_class761); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_qualifiedNameSymbol_in_model_class768);
                            	    temp=qualifiedNameSymbol();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setOclRef(ret, "supertypes", null, temp, "OCL:"+"			let t=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  				i; acc:Tuple(pos:Integer, ns:Set(Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"				t.ns.contents->select(c | c.name=?.subString(t.pos, ?.size()))"+"  	  		");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop3;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:4: ( (temp= identifier ( ( ',' ) temp= identifier )* ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:20: ( (temp= identifier ( ( ',' ) temp= identifier )* ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:21: (temp= identifier ( ( ',' ) temp= identifier )* )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E649F8DA3E73311DEA806F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:80: (temp= identifier ( ( ',' ) temp= identifier )* )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:82: temp= identifier ( ( ',' ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_model_class791);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setOclRef(ret, "supertypes", null, temp, "OCL:Moin::Model::Class.allInstances()->select(c|c.name=?)");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:203: ( ( ',' ) temp= identifier )*
                            loop4:
                            do {
                                int alt4=2;
                                int LA4_0 = input.LA(1);

                                if ( (LA4_0==41) ) {
                                    alt4=1;
                                }


                                switch (alt4) {
                            	case 1 :
                            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:204: ( ',' ) temp= identifier
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:221: ( ',' )
                            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:222: ','
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E01DFA6E649F8DA0E73311DEC057F7FB8D150602");
                            	    }
                            	    match(input,41,FOLLOW_41_in_model_class799); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_identifier_in_model_class806);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setOclRef(ret, "supertypes", null, temp, "OCL:Moin::Model::Class.allInstances()->select(c|c.name=?)");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop4;
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

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:372:508: 
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E649FDBC2E73311DEB40BF7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E649FDBC3E73311DEB6AAF7FB8D150602");
            }
            match(input,LCURL,FOLLOW_LCURL_in_model_class836); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A050F1E73311DEB381F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:233: ( ( (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:234: ( (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:234: ( (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:235: (temp= model_modelelement (temp= model_modelelement )* )? ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A002D1E73311DECDECF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:294: (temp= model_modelelement (temp= model_modelelement )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NAME||(LA8_0>=QNAME && LA8_0<=MULTI_LINE_COMMENT)||LA8_0==40||LA8_0==52||LA8_0==55||(LA8_0>=57 && LA8_0<=58)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:296: temp= model_modelelement (temp= model_modelelement )*
                    {
                    pushFollow(FOLLOW_model_modelelement_in_model_class847);
                    temp=model_modelelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "contents", temp);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:358: (temp= model_modelelement )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==NAME||(LA7_0>=QNAME && LA7_0<=MULTI_LINE_COMMENT)||LA7_0==40||LA7_0==52||LA7_0==55||(LA7_0>=57 && LA7_0<=58)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:360: temp= model_modelelement
                    	    {
                    	    pushFollow(FOLLOW_model_modelelement_in_model_class855);
                    	    temp=model_modelelement();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "contents", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A029E4E73311DE872AF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:503: ( ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL ) | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==34) ) {
                alt11=1;
            }
            else if ( (LA11_0==RCURL) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:504: ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:520: ( 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:521: 'invariants' LCURL (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )? RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A002D5E73311DEBA08F7FB8D150602");
                    }
                    match(input,34,FOLLOW_34_in_model_class872); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A002D6E73311DEC922F7FB8D150602");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_class876); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A029E1E73311DE88FAF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:749: (temp= model_modelelement_invariants (temp= model_modelelement_invariants )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NAME) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:751: temp= model_modelelement_invariants (temp= model_modelelement_invariants )*
                            {
                            pushFollow(FOLLOW_model_modelelement_invariants_in_model_class884);
                            temp=model_modelelement_invariants();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "contents", temp);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:824: (temp= model_modelelement_invariants )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==NAME) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:826: temp= model_modelelement_invariants
                            	    {
                            	    pushFollow(FOLLOW_model_modelelement_invariants_in_model_class892);
                            	    temp=model_modelelement_invariants();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "contents", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A029E2E73311DECE27F7FB8D150602");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_class904); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:373:1020: 
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


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A050F2E73311DEA951F7FB8D150602");
            }
            match(input,RCURL,FOLLOW_RCURL_in_model_class925); if (state.failed) return ret2;
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
    // $ANTLR end "model_class"


    // $ANTLR start "model_generalizableelement"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:382:1: model_generalizableelement returns [Object ret2] : () ;
    public final Object model_generalizableelement() throws RecognitionException {
        Object ret2 = null;

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:383:3: ( () )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:384:3: ()
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:384:3: ()
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:384:4: 
            {
            }

            if ( state.backtracking==0 ) {


               
            }

            }

        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "model_generalizableelement"


    // $ANTLR start "model_modelelement"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:391:1: model_modelelement returns [Object ret2] : (ret= model_feature ) ;
    public final Object model_modelelement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:392:3: ( (ret= model_feature ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:393:3: (ret= model_feature )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:393:3: (ret= model_feature )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:393:4: ret= model_feature
            {
            pushFollow(FOLLOW_model_feature_in_model_modelelement987);
            ret=model_feature();

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
    // $ANTLR end "model_modelelement"


    // $ANTLR start "model_feature"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:400:1: model_feature returns [Object ret2] : ( ( model_structuralfeature )=> (ret= model_structuralfeature ) | ( model_behavioralfeature )=> (ret= model_behavioralfeature ) ) ;
    public final Object model_feature() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:401:3: ( ( ( model_structuralfeature )=> (ret= model_structuralfeature ) | ( model_behavioralfeature )=> (ret= model_behavioralfeature ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:402:3: ( ( model_structuralfeature )=> (ret= model_structuralfeature ) | ( model_behavioralfeature )=> (ret= model_behavioralfeature ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:402:3: ( ( model_structuralfeature )=> (ret= model_structuralfeature ) | ( model_behavioralfeature )=> (ret= model_behavioralfeature ) )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:402:4: ( model_structuralfeature )=> (ret= model_structuralfeature )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:402:31: (ret= model_structuralfeature )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:402:32: ret= model_structuralfeature
                    {
                    pushFollow(FOLLOW_model_structuralfeature_in_model_feature1019);
                    ret=model_structuralfeature();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:403:5: ( model_behavioralfeature )=> (ret= model_behavioralfeature )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:403:32: (ret= model_behavioralfeature )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:403:33: ret= model_behavioralfeature
                    {
                    pushFollow(FOLLOW_model_behavioralfeature_in_model_feature1033);
                    ret=model_behavioralfeature();

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
    // $ANTLR end "model_feature"


    // $ANTLR start "model_structuralfeature"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:410:1: model_structuralfeature returns [Object ret2] : (ret= model_attribute ) ;
    public final Object model_structuralfeature() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:411:3: ( (ret= model_attribute ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:412:3: (ret= model_attribute )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:412:3: (ret= model_attribute )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:412:4: ret= model_attribute
            {
            pushFollow(FOLLOW_model_attribute_in_model_structuralfeature1061);
            ret=model_attribute();

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
    // $ANTLR end "model_structuralfeature"


    // $ANTLR start "scopeandvisibility"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:419:1: scopeandvisibility[Object ret] : ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ( ( 'static' ) | ) ) ;
    public final void scopeandvisibility(Object ret) throws RecognitionException {
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:420:3: ( ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ( ( 'static' ) | ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:421:3: ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ( ( 'static' ) | ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:421:3: ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ( ( 'static' ) | ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:421:4: ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ( ( 'static' ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A31012E73311DEB0EFF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:421:63: ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case NAME:
            case QNAME:
            case 57:
                {
                alt13=1;
                }
                break;
            case 40:
                {
                alt13=2;
                }
                break;
            case 52:
                {
                alt13=3;
                }
                break;
            case 55:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:421:64: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:421:80: ()
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:421:81: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A29AE1E73311DEA0B5F7FB8D150602");
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:422:4: ( 'public' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:422:20: ( 'public' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:422:21: 'public'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A2C1F0E73311DEA978F7FB8D150602");
                    }
                    match(input,40,FOLLOW_40_in_scopeandvisibility1103); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A2C1F3E73311DEB516F7FB8D150602");
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:423:4: ( 'protected' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:423:20: ( 'protected' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:423:21: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A2C1F5E73311DECDC5F7FB8D150602");
                    }
                    match(input,52,FOLLOW_52_in_scopeandvisibility1119); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A2E902E73311DE8457F7FB8D150602");
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:424:4: ( 'private' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:424:20: ( 'private' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:424:21: 'private'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A2E904E73311DE90E5F7FB8D150602");
                    }
                    match(input,55,FOLLOW_55_in_scopeandvisibility1135); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A31010E73311DE829EF7FB8D150602");
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A35E32E73311DE8C54F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:424:396: ( ( 'static' ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==57) ) {
                alt14=1;
            }
            else if ( (LA14_0==NAME||LA14_0==QNAME) ) {
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:424:397: ( 'static' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:424:413: ( 'static' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:424:414: 'static'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A35E30E73311DEC8ECF7FB8D150602");
                    }
                    match(input,57,FOLLOW_57_in_scopeandvisibility1152); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "scope", createEnumLiteral(list("Model","ScopeKind"),"classifier_level"));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:424:608: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "scope", createEnumLiteral(list("Model","ScopeKind"),"instance_level"));
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
    // $ANTLR end "scopeandvisibility"


    // $ANTLR start "model_attribute"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:432:1: model_attribute returns [Object ret2] : ( annotation[ret] ( () | ( 'readonly' ) ) scopeandvisibility[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ';' ) ;
    public final Object model_attribute() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Attribute");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:437:3: ( ( annotation[ret] ( () | ( 'readonly' ) ) scopeandvisibility[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ';' ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:3: ( annotation[ret] ( () | ( 'readonly' ) ) scopeandvisibility[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ';' )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:3: ( annotation[ret] ( () | ( 'readonly' ) ) scopeandvisibility[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ';' )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:4: annotation[ret] ( () | ( 'readonly' ) ) scopeandvisibility[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A3D360E73311DE9FC8F7FB8D150602");
            }
            pushFollow(FOLLOW_annotation_in_model_attribute1197);
            annotation(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A3FA71E73311DECDD6F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:154: ( () | ( 'readonly' ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NAME||LA15_0==QNAME||LA15_0==40||LA15_0==52||LA15_0==55||LA15_0==57) ) {
                alt15=1;
            }
            else if ( (LA15_0==58) ) {
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:155: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:171: ()
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:172: 
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:249: ( 'readonly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:265: ( 'readonly' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:438:266: 'readonly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A3D365E73311DE8124F7FB8D150602");
                    }
                    match(input,58,FOLLOW_58_in_model_attribute1217); if (state.failed) return ret2;
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
              _beforeSeqEl("E01DFA6E64A3FA72E73311DEBCE8F7FB8D150602");
            }
            pushFollow(FOLLOW_scopeandvisibility_in_model_attribute1227);
            scopeandvisibility(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A3FA73E73311DE9F15F7FB8D150602");
            }
            pushFollow(FOLLOW_typereference_in_model_attribute1231);
            typereference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A3FA75E73311DE80E7F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:439:267: (temp= model_multiplicitytype )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:439:269: temp= model_multiplicitytype
            {
            pushFollow(FOLLOW_model_multiplicitytype_in_model_attribute1239);
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
              _beforeSeqEl("E01DFA6E64A42181E73311DE9505F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:439:414: (temp= identifier )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:439:416: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_attribute1249);
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
              _beforeSeqEl("E01DFA6E64A42182E73311DEAF63F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A42183E73311DE9175F7FB8D150602");
            }
            match(input,59,FOLLOW_59_in_model_attribute1257); if (state.failed) return ret2;
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
    // $ANTLR end "model_attribute"


    // $ANTLR start "typereference"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:447:1: typereference[Object ret] : ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ;
    public final void typereference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:448:3: ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:3: ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:3: ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:4: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A50BE1E73311DE874AF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:63: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==QNAME) ) {
                alt16=1;
            }
            else if ( (LA16_0==NAME) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:64: ( (temp= qualifiedNameSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:80: ( (temp= qualifiedNameSymbol ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:81: (temp= qualifiedNameSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A4BDC4E73311DEBE2BF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:140: (temp= qualifiedNameSymbol )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:449:142: temp= qualifiedNameSymbol
                    {
                    pushFollow(FOLLOW_qualifiedNameSymbol_in_typereference1300);
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:450:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:450:20: ( (temp= identifier ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:450:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A4E4D5E73311DE9ADAF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:450:80: (temp= identifier )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:450:82: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_typereference1320);
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


    // $ANTLR start "model_behavioralfeature"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:457:1: model_behavioralfeature returns [Object ret2] : (ret= model_operation ) ;
    public final Object model_behavioralfeature() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:458:3: ( (ret= model_operation ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:459:3: (ret= model_operation )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:459:3: (ret= model_operation )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:459:4: ret= model_operation
            {
            pushFollow(FOLLOW_model_operation_in_model_behavioralfeature1355);
            ret=model_operation();

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
    // $ANTLR end "model_behavioralfeature"


    // $ANTLR start "model_operation"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:466:1: model_operation returns [Object ret2] : ( annotation[ret] scopeandvisibility[ret] (temp= model_modelelement_returnType ) (temp= identifier ) LPAREN (temp= model_modelelement_parameter (temp= model_modelelement_parameter )* )? RPAREN LCURL (temp= ocl_expressions_oclexpression ) RCURL ) ;
    public final Object model_operation() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Operation");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"operation"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:471:3: ( ( annotation[ret] scopeandvisibility[ret] (temp= model_modelelement_returnType ) (temp= identifier ) LPAREN (temp= model_modelelement_parameter (temp= model_modelelement_parameter )* )? RPAREN LCURL (temp= ocl_expressions_oclexpression ) RCURL ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:3: ( annotation[ret] scopeandvisibility[ret] (temp= model_modelelement_returnType ) (temp= identifier ) LPAREN (temp= model_modelelement_parameter (temp= model_modelelement_parameter )* )? RPAREN LCURL (temp= ocl_expressions_oclexpression ) RCURL )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:3: ( annotation[ret] scopeandvisibility[ret] (temp= model_modelelement_returnType ) (temp= identifier ) LPAREN (temp= model_modelelement_parameter (temp= model_modelelement_parameter )* )? RPAREN LCURL (temp= ocl_expressions_oclexpression ) RCURL )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:4: annotation[ret] scopeandvisibility[ret] (temp= model_modelelement_returnType ) (temp= identifier ) LPAREN (temp= model_modelelement_parameter (temp= model_modelelement_parameter )* )? RPAREN LCURL (temp= ocl_expressions_oclexpression ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A5CF31E73311DE9C96F7FB8D150602");
            }
            pushFollow(FOLLOW_annotation_in_model_operation1385);
            annotation(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A5CF32E73311DEC188F7FB8D150602");
            }
            pushFollow(FOLLOW_scopeandvisibility_in_model_operation1389);
            scopeandvisibility(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A5F641E73311DEC155F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:251: (temp= model_modelelement_returnType )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:253: temp= model_modelelement_returnType
            {
            pushFollow(FOLLOW_model_modelelement_returnType_in_model_operation1397);
            temp=model_modelelement_returnType();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "contents", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A61D51E73311DEAFE5F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:401: (temp= identifier )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:403: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_operation1407);
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
              _beforeSeqEl("E01DFA6E64A61D52E73311DE86A4F7FB8D150602");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_model_operation1414); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A61D55E73311DEAD61F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:611: (temp= model_modelelement_parameter (temp= model_modelelement_parameter )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==NAME||(LA18_0>=QNAME && LA18_0<=MULTI_LINE_COMMENT)||(LA18_0>=39 && LA18_0<=40)||LA18_0==45||LA18_0==52||LA18_0==55||(LA18_0>=57 && LA18_0<=58)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:613: temp= model_modelelement_parameter (temp= model_modelelement_parameter )*
                    {
                    pushFollow(FOLLOW_model_modelelement_parameter_in_model_operation1422);
                    temp=model_modelelement_parameter();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "contents", temp);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:685: (temp= model_modelelement_parameter )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==NAME||(LA17_0>=QNAME && LA17_0<=MULTI_LINE_COMMENT)||(LA17_0>=39 && LA17_0<=40)||LA17_0==45||LA17_0==52||LA17_0==55||(LA17_0>=57 && LA17_0<=58)) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:687: temp= model_modelelement_parameter
                    	    {
                    	    pushFollow(FOLLOW_model_modelelement_parameter_in_model_operation1430);
                    	    temp=model_modelelement_parameter();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "contents", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A61D56E73311DEC6B7F7FB8D150602");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_model_operation1442); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A64460E73311DEC0F7F7FB8D150602");
            }
            match(input,LCURL,FOLLOW_LCURL_in_model_operation1447); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A64463E73311DEA6E4F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:1004: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:472:1006: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_model_operation1455);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "body", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A64464E73311DEA722F7FB8D150602");
            }
            match(input,RCURL,FOLLOW_RCURL_in_model_operation1462); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A66B70E73311DEB7B2F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "isQuery", true);_exitInjectorAction();
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
    // $ANTLR end "model_operation"


    // $ANTLR start "model_modelelement_returnType"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:480:1: model_modelelement_returnType returns [Object ret2] : (ret= model_typedelement_returnType ) ;
    public final Object model_modelelement_returnType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:481:3: ( (ret= model_typedelement_returnType ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:482:3: (ret= model_typedelement_returnType )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:482:3: (ret= model_typedelement_returnType )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:482:4: ret= model_typedelement_returnType
            {
            pushFollow(FOLLOW_model_typedelement_returnType_in_model_modelelement_returnType1503);
            ret=model_typedelement_returnType();

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
    // $ANTLR end "model_modelelement_returnType"


    // $ANTLR start "model_typedelement_returnType"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:489:1: model_typedelement_returnType returns [Object ret2] : (ret= model_parameter_returnType ) ;
    public final Object model_typedelement_returnType() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:490:3: ( (ret= model_parameter_returnType ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:491:3: (ret= model_parameter_returnType )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:491:3: (ret= model_parameter_returnType )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:491:4: ret= model_parameter_returnType
            {
            pushFollow(FOLLOW_model_parameter_returnType_in_model_typedelement_returnType1530);
            ret=model_parameter_returnType();

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
    // $ANTLR end "model_typedelement_returnType"


    // $ANTLR start "model_parameter_returnType"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:498:1: model_parameter_returnType returns [Object ret2] : ( typereference[ret] (temp= model_multiplicitytype ) ) ;
    public final Object model_parameter_returnType() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Parameter");
        onEnterTemplateRule(metaType,"returnType");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:503:3: ( ( typereference[ret] (temp= model_multiplicitytype ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:504:3: ( typereference[ret] (temp= model_multiplicitytype ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:504:3: ( typereference[ret] (temp= model_multiplicitytype ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:504:4: typereference[ret] (temp= model_multiplicitytype )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A7A3F0E73311DEAB0FF7FB8D150602");
            }
            pushFollow(FOLLOW_typereference_in_model_parameter_returnType1560);
            typereference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A7CB01E73311DEC905F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:504:156: (temp= model_multiplicitytype )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:504:158: temp= model_multiplicitytype
            {
            pushFollow(FOLLOW_model_multiplicitytype_in_model_parameter_returnType1568);
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
              _beforeSeqEl("E01DFA6E64A7F210E73311DEA001F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "direction", com.sap.tc.moin.repository.mmi.model.DirectionKindEnum.RETURN_DIR);_exitInjectorAction();setProperty(ret, "name", "result");_exitInjectorAction();
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
    // $ANTLR end "model_parameter_returnType"


    // $ANTLR start "model_modelelement_parameter"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:512:1: model_modelelement_parameter returns [Object ret2] : (ret= model_typedelement_parameter ) ;
    public final Object model_modelelement_parameter() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:513:3: ( (ret= model_typedelement_parameter ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:514:3: (ret= model_typedelement_parameter )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:514:3: (ret= model_typedelement_parameter )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:514:4: ret= model_typedelement_parameter
            {
            pushFollow(FOLLOW_model_typedelement_parameter_in_model_modelelement_parameter1611);
            ret=model_typedelement_parameter();

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
    // $ANTLR end "model_modelelement_parameter"


    // $ANTLR start "model_typedelement_parameter"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:521:1: model_typedelement_parameter returns [Object ret2] : (ret= model_parameter_parameter ) ;
    public final Object model_typedelement_parameter() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:522:3: ( (ret= model_parameter_parameter ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:523:3: (ret= model_parameter_parameter )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:523:3: (ret= model_parameter_parameter )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:523:4: ret= model_parameter_parameter
            {
            pushFollow(FOLLOW_model_parameter_parameter_in_model_typedelement_parameter1638);
            ret=model_parameter_parameter();

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
    // $ANTLR end "model_typedelement_parameter"


    // $ANTLR start "model_parameter_parameter"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:530:1: model_parameter_parameter returns [Object ret2] : ( annotation[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ) ;
    public final Object model_parameter_parameter() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Parameter");
        onEnterTemplateRule(metaType,"parameter");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:535:3: ( ( annotation[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:536:3: ( annotation[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:536:3: ( annotation[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:536:4: annotation[ret] typereference[ret] (temp= model_multiplicitytype ) (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A92A90E73311DEBB2AF7FB8D150602");
            }
            pushFollow(FOLLOW_annotation_in_model_parameter_parameter1668);
            annotation(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A92A91E73311DEB9C9F7FB8D150602");
            }
            pushFollow(FOLLOW_typereference_in_model_parameter_parameter1672);
            typereference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64A92A93E73311DE8463F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:536:246: (temp= model_multiplicitytype )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:536:248: temp= model_multiplicitytype
            {
            pushFollow(FOLLOW_model_multiplicitytype_in_model_parameter_parameter1680);
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
              _beforeSeqEl("E01DFA6E64A92A95E73311DEC201F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:536:393: (temp= identifier )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:536:395: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_parameter_parameter1690);
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
              _beforeSeqEl("E01DFA6E64A951A2E73311DEB6D7F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "direction", com.sap.tc.moin.repository.mmi.model.DirectionKindEnum.IN_DIR);_exitInjectorAction();
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
    // $ANTLR end "model_parameter_parameter"


    // $ANTLR start "model_multiplicitytype"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:544:1: model_multiplicitytype returns [Object ret2] : ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) ) ;
    public final Object model_multiplicitytype() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","MultiplicityType");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:549:3: ( ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:3: ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:3: ( ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:4: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64B20433E73311DE94E0F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:63: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )
            int alt29=15;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:64: ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:144: ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:145: (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64A9EDE1E73311DE866AF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:204: (temp= integerSymbol )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:206: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1763);
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
                      _beforeSeqEl("E01DFA6E64A9EDE2E73311DE9B21F7FB8D150602");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1770); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AA3C01E73311DEBA2FF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:417: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:418: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:434: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:435: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AA14F1E73311DE8F65F7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1781); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:579: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:595: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:596: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AA14F4E73311DE8AA3F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:655: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:657: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1799);
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
                      _beforeSeqEl("E01DFA6E64AA6312E73311DEA151F7FB8D150602");
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:4: ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:53: ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:54: LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AA8A20E73311DE892EF7FB8D150602");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype1836); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AA8A22E73311DE9C9BF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:198: (temp= integerSymbol )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:200: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1844);
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
                      _beforeSeqEl("E01DFA6E64AA8A23E73311DEBE33F7FB8D150602");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1851); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AAD840E73311DE959FF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:411: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:412: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:428: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:429: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AAB131E73311DEA928F7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1862); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:573: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:589: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:590: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AAB134E73311DE881EF7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:649: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:651: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1880);
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
                      _beforeSeqEl("E01DFA6E64AAFF50E73311DEB30FF7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", false);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AAFF51E73311DEC53EF7FB8D150602");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype1897); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:4: ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:50: ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:51: LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AB2660E73311DEB372F7FB8D150602");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype1922); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AB2662E73311DEA5DEF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:192: (temp= integerSymbol )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:194: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1930);
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
                      _beforeSeqEl("E01DFA6E64AB2663E73311DECE17F7FB8D150602");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype1937); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AB7480E73311DEB161F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:405: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:406: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:422: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:423: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AB4D71E73311DE8B1DF7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype1948); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:567: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:583: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:584: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AB4D74E73311DE8AE3F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:643: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:645: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype1966);
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
                      _beforeSeqEl("E01DFA6E64AB9B90E73311DEB433F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AB9B91E73311DEA1B6F7FB8D150602");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype1983); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:4: ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:57: ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:58: LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64ABC2A0E73311DEBEDBF7FB8D150602");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2008); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64ABC2A2E73311DE9D99F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:206: (temp= integerSymbol )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:208: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2016);
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
                      _beforeSeqEl("E01DFA6E64ABC2A3E73311DECFA6F7FB8D150602");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype2023); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AC10C1E73311DE8A9BF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:419: ( ( STAR ) | ( (temp= integerSymbol ) ) )
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:420: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:436: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:437: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64ABE9B1E73311DEB0F8F7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2034); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:581: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:597: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:598: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64ABE9B4E73311DE9456F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:657: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:659: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2052);
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
                      _beforeSeqEl("E01DFA6E64AC37D2E73311DEA46FF7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AC37D3E73311DE8D62F7FB8D150602");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2069); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:4: ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(4);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:57: ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:58: LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AC5EE0E73311DEC6F6F7FB8D150602");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2094); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AC5EE2E73311DEC2AFF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:206: (temp= integerSymbol )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:208: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2102);
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
                      _beforeSeqEl("E01DFA6E64AC5EE3E73311DEB6E0F7FB8D150602");
                    }
                    match(input,DDOT,FOLLOW_DDOT_in_model_multiplicitytype2109); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64ACAD02E73311DEB3C9F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:419: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==STAR) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==INT) ) {
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:420: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:436: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:437: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AC85F3E73311DEC034F7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2120); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:581: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:597: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:598: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64ACAD00E73311DE8ADEF7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:657: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:659: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2138);
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
                      _beforeSeqEl("E01DFA6E64ACD413E73311DEB9A2F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64ACD414E73311DEA9C6F7FB8D150602");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2155); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:4: ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(5);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:52: ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:53: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AD4941E73311DE8223F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:113: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==STAR) ) {
                        alt24=1;
                    }
                    else if ( (LA24_0==INT) ) {
                        alt24=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 0, input);

                        throw nvae;
                    }
                    switch (alt24) {
                        case 1 :
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:114: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:130: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:131: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AD2232E73311DEA812F7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2189); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:275: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:291: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:292: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AD2235E73311DEB8DDF7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:351: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:353: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2207);
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
                      _beforeSeqEl("E01DFA6E64AD7054E73311DEB9FFF7FB8D150602");
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:4: ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(6);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:82: ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:83: LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AD9761E73311DEB5B0F7FB8D150602");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype2252); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64ADE581E73311DEBC4CF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:228: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==STAR) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==INT) ) {
                        alt25=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:229: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:245: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:246: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64ADBE71E73311DECC4CF7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2263); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:390: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:406: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:407: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64ADBE74E73311DEB86CF7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:466: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:468: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2281);
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
                      _beforeSeqEl("E01DFA6E64AE0C94E73311DECF95F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", false);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AE33A0E73311DE9D74F7FB8D150602");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype2298); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:564:4: ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(7);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:564:43: ( LBRACKET RBRACKET )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:564:44: LBRACKET RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AE33A2E73311DECF58F7FB8D150602");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_model_multiplicitytype2321); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AE81C2E73311DEABBCF7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "upper", -1);_exitInjectorAction();setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", false);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AEA8D0E73311DEBC80F7FB8D150602");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_model_multiplicitytype2329); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:4: ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(8);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:70: ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:71: LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AEA8D2E73311DEA285F7FB8D150602");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype2362); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AEF6F3E73311DE8A45F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:213: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==STAR) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==INT) ) {
                        alt26=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:214: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:230: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:231: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AECFE1E73311DE880AF7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2373); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:375: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:391: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:392: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AEF6F1E73311DE9664F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:451: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:453: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2391);
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
                      _beforeSeqEl("E01DFA6E64AF4510E73311DEA12BF7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AF4511E73311DECEACF7FB8D150602");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype2408); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:567:4: ( LCURL RCURL )=> ( LCURL RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(9);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:567:37: ( LCURL RCURL )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:567:38: LCURL RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AF6C20E73311DECFC4F7FB8D150602");
                    }
                    match(input,LCURL,FOLLOW_LCURL_in_model_multiplicitytype2431); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AF9332E73311DEC366F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "upper", -1);_exitInjectorAction();setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", false);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AFBA40E73311DEA3E1F7FB8D150602");
                    }
                    match(input,RCURL,FOLLOW_RCURL_in_model_multiplicitytype2439); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:4: ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(10);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:99: ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:100: LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64AFBA42E73311DE9480F7FB8D150602");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2472); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B00860E73311DE873BF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:249: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==STAR) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==INT) ) {
                        alt27=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:250: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:266: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:267: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AFE151E73311DECA81F7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2483); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:411: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:427: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:428: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64AFE154E73311DEC2B5F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:487: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:489: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2501);
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
                      _beforeSeqEl("E01DFA6E64B02F73E73311DE88EBF7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B02F74E73311DEA0B4F7FB8D150602");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2518); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:4: ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(11);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:99: ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:100: LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B05681E73311DE881EF7FB8D150602");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2551); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B0A4A1E73311DEBA6FF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:249: ( ( STAR ) | ( (temp= integerSymbol ) ) )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==STAR) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==INT) ) {
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:250: ( STAR )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:266: ( STAR )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:267: STAR
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64B07D91E73311DE9B9FF7FB8D150602");
                            }
                            match(input,STAR,FOLLOW_STAR_in_model_multiplicitytype2562); if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:411: ( (temp= integerSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:427: ( (temp= integerSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:428: (temp= integerSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64B07D94E73311DEAC42F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:487: (temp= integerSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:489: temp= integerSymbol
                            {
                            pushFollow(FOLLOW_integerSymbol_in_model_multiplicitytype2580);
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
                      _beforeSeqEl("E01DFA6E64B0CBB4E73311DE9659F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B0F2C0E73311DEBC64F7FB8D150602");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2597); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:572:4: ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(12);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:572:52: ( LCURL_LBRACK RBRACK_RCURL )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:572:53: LCURL_LBRACK RBRACK_RCURL
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B0F2C2E73311DE8D9DF7FB8D150602");
                    }
                    match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2620); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B140E0E73311DECBC3F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "upper", -1);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B140E1E73311DEBCE9F7FB8D150602");
                    }
                    match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2628); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:573:4: ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(13);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:573:52: ( LBRACK_LCURL RCURL_RBRACK )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:573:53: LBRACK_LCURL RCURL_RBRACK
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B167F1E73311DEC074F7FB8D150602");
                    }
                    match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2651); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B18F05E73311DEC6D4F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lower", 0);_exitInjectorAction();setProperty(ret, "upper", -1);_exitInjectorAction();setProperty(ret, "isUnique", true);_exitInjectorAction();setProperty(ret, "isOrdered", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B1B610E73311DEA5BFF7FB8D150602");
                    }
                    match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2659); if (state.failed) return ret2;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:574:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(14);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:574:21: ()
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:574:22: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B20431E73311DEC86CF7FB8D150602");
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


    // $ANTLR start "model_visibilitykind"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:582:1: model_visibilitykind returns [Object ret2] : ( ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ;
    public final Object model_visibilitykind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:583:3: ( ( ( 'public' ) | ( 'protected' ) | ( 'private' ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:584:3: ( ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:584:3: ( ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt30=1;
                }
                break;
            case 52:
                {
                alt30=2;
                }
                break;
            case 55:
                {
                alt30=3;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:584:4: ( 'public' )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:584:4: ( 'public' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:584:5: 'public'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B2EE91E73311DEC74EF7FB8D150602");
                    }
                    match(input,40,FOLLOW_40_in_model_visibilitykind2719); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("Model","VisibilityKind"), "public_vis");
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:585:4: ( 'protected' )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:585:4: ( 'protected' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:585:5: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B315A0E73311DE814CF7FB8D150602");
                    }
                    match(input,52,FOLLOW_52_in_model_visibilitykind2729); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("Model","VisibilityKind"), "protected_vis");
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:586:4: ( 'private' )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:586:4: ( 'private' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:586:5: 'private'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B315A3E73311DE973EF7FB8D150602");
                    }
                    match(input,55,FOLLOW_55_in_model_visibilitykind2739); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("Model","VisibilityKind"), "private_vis");
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
    // $ANTLR end "model_visibilitykind"


    // $ANTLR start "annotation"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:593:1: annotation[Object ret] : ( ( ( (temp= annotationSymbol ) ) | ) ) ;
    public final void annotation(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:594:3: ( ( ( ( (temp= annotationSymbol ) ) | ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:3: ( ( ( (temp= annotationSymbol ) ) | ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:3: ( ( ( (temp= annotationSymbol ) ) | ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:4: ( ( (temp= annotationSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64B3D8F0E73311DEC08EF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:64: ( ( (temp= annotationSymbol ) ) | )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==MULTI_LINE_COMMENT) ) {
                alt31=1;
            }
            else if ( (LA31_0==NAME||LA31_0==QNAME||(LA31_0>=39 && LA31_0<=40)||LA31_0==45||LA31_0==52||LA31_0==55||(LA31_0>=57 && LA31_0<=58)) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:65: ( (temp= annotationSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:81: ( (temp= annotationSymbol ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:82: (temp= annotationSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B3B1E4E73311DE9BB7F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:141: (temp= annotationSymbol )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:143: temp= annotationSymbol
                    {
                    pushFollow(FOLLOW_annotationSymbol_in_annotation2774);
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:595:239: 
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


    // $ANTLR start "visibility"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:603:1: visibility[Object ret] : ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ) ;
    public final void visibility(Object ret) throws RecognitionException {
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:604:3: ( ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:605:3: ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:605:3: ( ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:605:4: ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64B4C354E73311DE8E85F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:605:63: ( () | ( 'public' ) | ( 'protected' ) | ( 'private' ) )
            int alt32=4;
            switch ( input.LA(1) ) {
            case 39:
            case 45:
                {
                alt32=1;
                }
                break;
            case 40:
                {
                alt32=2;
                }
                break;
            case 52:
                {
                alt32=3;
                }
                break;
            case 55:
                {
                alt32=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:605:64: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:605:80: ()
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:605:81: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B44E22E73311DEC049F7FB8D150602");
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:606:4: ( 'public' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:606:20: ( 'public' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:606:21: 'public'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B47531E73311DEAEDCF7FB8D150602");
                    }
                    match(input,40,FOLLOW_40_in_visibility2832); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B47534E73311DE91E6F7FB8D150602");
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:607:4: ( 'protected' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:607:20: ( 'protected' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:607:21: 'protected'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B49C40E73311DEAB84F7FB8D150602");
                    }
                    match(input,52,FOLLOW_52_in_visibility2848); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B49C43E73311DECF7EF7FB8D150602");
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:608:4: ( 'private' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:608:20: ( 'private' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:608:21: 'private'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B49C45E73311DEC816F7FB8D150602");
                    }
                    match(input,55,FOLLOW_55_in_visibility2864); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64B4C352E73311DEA2C7F7FB8D150602");
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


    // $ANTLR start "model_modelelement_invariants"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:615:1: model_modelelement_invariants returns [Object ret2] : (ret= model_constraint_invariants ) ;
    public final Object model_modelelement_invariants() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:616:3: ( (ret= model_constraint_invariants ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:617:3: (ret= model_constraint_invariants )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:617:3: (ret= model_constraint_invariants )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:617:4: ret= model_constraint_invariants
            {
            pushFollow(FOLLOW_model_constraint_invariants_in_model_modelelement_invariants2899);
            ret=model_constraint_invariants();

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
    // $ANTLR end "model_modelelement_invariants"


    // $ANTLR start "model_constraint_invariants"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:624:1: model_constraint_invariants returns [Object ret2] : (ret= ocl_attaching_oclconstraint_invariants ) ;
    public final Object model_constraint_invariants() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:625:3: ( (ret= ocl_attaching_oclconstraint_invariants ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:626:3: (ret= ocl_attaching_oclconstraint_invariants )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:626:3: (ret= ocl_attaching_oclconstraint_invariants )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:626:4: ret= ocl_attaching_oclconstraint_invariants
            {
            pushFollow(FOLLOW_ocl_attaching_oclconstraint_invariants_in_model_constraint_invariants2926);
            ret=ocl_attaching_oclconstraint_invariants();

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
    // $ANTLR end "model_constraint_invariants"


    // $ANTLR start "ocl_attaching_oclconstraint_invariants"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:633:1: ocl_attaching_oclconstraint_invariants returns [Object ret2] : ( (temp= identifier ) COLON (temp= ocl_expressions_oclexpression ) ';' ) ;
    public final Object ocl_attaching_oclconstraint_invariants() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Attaching","OclConstraint");
        onEnterTemplateRule(metaType,"invariants");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:638:3: ( ( (temp= identifier ) COLON (temp= ocl_expressions_oclexpression ) ';' ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:639:3: ( (temp= identifier ) COLON (temp= ocl_expressions_oclexpression ) ';' )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:639:3: ( (temp= identifier ) COLON (temp= ocl_expressions_oclexpression ) ';' )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:639:4: (temp= identifier ) COLON (temp= ocl_expressions_oclexpression ) ';'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64B5FBD1E73311DECA5DF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:639:63: (temp= identifier )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:639:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_attaching_oclconstraint_invariants2960);
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
              _beforeSeqEl("E01DFA6E64B622E0E73311DECDAFF7FB8D150602");
            }
            match(input,COLON,FOLLOW_COLON_in_ocl_attaching_oclconstraint_invariants2967); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64B622E2E73311DE9893F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:639:272: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:639:274: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_attaching_oclconstraint_invariants2975);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "oclExpression", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64B622E3E73311DEC47FF7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64B622E4E73311DEB425F7FB8D150602");
            }
            match(input,59,FOLLOW_59_in_ocl_attaching_oclconstraint_invariants2983); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64B649F0E73311DE94E8F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setRef(ret, "invariantOf", list("Model","Classifier"), null, null, "#context(class)", null, null, false, null, true);_exitInjectorAction();
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
    // $ANTLR end "ocl_attaching_oclconstraint_invariants"


    // $ANTLR start "primary_ocl_expressions_oclexpression"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:647:1: primary_ocl_expressions_oclexpression returns [Object ret2] : (ret= ocl_expressions_letexp | ret= ocl_expressions_ifexp | ret= ocl_expressions_literalexp | ret= ocl_expressions_variableexp | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) ;
    public final Object primary_ocl_expressions_oclexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:648:3: ( (ret= ocl_expressions_letexp | ret= ocl_expressions_ifexp | ret= ocl_expressions_literalexp | ret= ocl_expressions_variableexp | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:649:3: (ret= ocl_expressions_letexp | ret= ocl_expressions_ifexp | ret= ocl_expressions_literalexp | ret= ocl_expressions_variableexp | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:649:3: (ret= ocl_expressions_letexp | ret= ocl_expressions_ifexp | ret= ocl_expressions_literalexp | ret= ocl_expressions_variableexp | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            int alt33=5;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt33=1;
                }
                break;
            case 37:
                {
                alt33=2;
                }
                break;
            case STRING:
            case QNAME:
            case INT:
            case FLOAT:
            case BOOL:
            case 42:
            case 43:
            case 47:
            case 51:
            case 56:
                {
                alt33=3;
                }
                break;
            case NAME:
            case 46:
                {
                alt33=4;
                }
                break;
            case LPAREN:
                {
                alt33=5;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:649:4: ret= ocl_expressions_letexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_letexp_in_primary_ocl_expressions_oclexpression3023);
                    ret=ocl_expressions_letexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:650:5: ret= ocl_expressions_ifexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_ifexp_in_primary_ocl_expressions_oclexpression3031);
                    ret=ocl_expressions_ifexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:651:5: ret= ocl_expressions_literalexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_literalexp_in_primary_ocl_expressions_oclexpression3039);
                    ret=ocl_expressions_literalexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:652:5: ret= ocl_expressions_variableexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_variableexp_in_primary_ocl_expressions_oclexpression3047);
                    ret=ocl_expressions_variableexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:653:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:653:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:653:6: LPAREN ret= ocl_expressions_oclexpression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression3056); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression3062);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression3066); if (state.failed) return ret2;
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
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:660:1: oclexpressions_priority_0 returns [Object ret2] : ( (ret= primary_ocl_expressions_oclexpression ( ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object oclexpressions_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:661:3: ( ( (ret= primary_ocl_expressions_oclexpression ( ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:4: ( (ret= primary_ocl_expressions_oclexpression ( ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:4: ( (ret= primary_ocl_expressions_oclexpression ( ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) ) )* ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:6: (ret= primary_ocl_expressions_oclexpression ( ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) ) )* )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:6: (ret= primary_ocl_expressions_oclexpression ( ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) ) )* )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:8: ret= primary_ocl_expressions_oclexpression ( ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_03104);
            ret=primary_ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:49: ( ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) ) )*
            loop35:
            do {
                int alt35=3;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==49) ) {
                    int LA35_2 = input.LA(2);

                    if ( (synpred17_MofClass()) ) {
                        alt35=1;
                    }


                }
                else if ( (LA35_0==48) ) {
                    int LA35_3 = input.LA(2);

                    if ( (synpred19_MofClass()) ) {
                        alt35=2;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:50: ( '.' )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:57: ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) ) )
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:58: '.' ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(".", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,49,FOLLOW_49_in_oclexpressions_priority_03113); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ".";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:138: ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) )
            	    int alt34=2;
            	    alt34 = dfa34.predict(input);
            	    switch (alt34) {
            	        case 1 :
            	            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:139: ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] )
            	            {
            	            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:161: (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] )
            	            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:162: ret= ocl_expressions_attributecallexp[opName, ret, firstToken]
            	            {
            	            pushFollow(FOLLOW_ocl_expressions_attributecallexp_in_oclexpressions_priority_03127);
            	            ret=ocl_expressions_attributecallexp(opName, ret, firstToken);

            	            checkFollows();
            	            state._fsp--;
            	            if (state.failed) return ret2;

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:663:3: (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] )
            	            {
            	            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:663:3: (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] )
            	            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:663:4: ret= ocl_expressions_operationcallexp[opName, ret, firstToken]
            	            {
            	            pushFollow(FOLLOW_ocl_expressions_operationcallexp_in_oclexpressions_priority_03136);
            	            ret=ocl_expressions_operationcallexp(opName, ret, firstToken);

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
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:3: ( '->' )=> ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:11: ( '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) ) )
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:12: '->' ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("->", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,48,FOLLOW_48_in_oclexpressions_priority_03152); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "->";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:95: ( (ret= ocl_expressions_iterateexp[opName, ret, firstToken] ) )
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:96: (ret= ocl_expressions_iterateexp[opName, ret, firstToken] )
            	    {
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:96: (ret= ocl_expressions_iterateexp[opName, ret, firstToken] )
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:97: ret= ocl_expressions_iterateexp[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_ocl_expressions_iterateexp_in_oclexpressions_priority_03159);
            	    ret=ocl_expressions_iterateexp(opName, ret, firstToken);

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
            	    break loop35;
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
    // $ANTLR end "oclexpressions_priority_0"


    // $ANTLR start "oclexpressions_priority_1"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:672:1: oclexpressions_priority_1 returns [Object ret2] : ( (ret= oclexpressions_priority_0 ) ) ;
    public final Object oclexpressions_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:673:3: ( ( (ret= oclexpressions_priority_0 ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:674:4: ( (ret= oclexpressions_priority_0 ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:674:4: ( (ret= oclexpressions_priority_0 ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:674:6: (ret= oclexpressions_priority_0 )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:674:6: (ret= oclexpressions_priority_0 )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:674:8: ret= oclexpressions_priority_0
            {
            pushFollow(FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_13200);
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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "oclexpressions_priority_1"


    // $ANTLR start "ocl_expressions_oclexpression"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:682:1: ocl_expressions_oclexpression returns [Object ret2] : ret= oclexpressions_priority_1 ;
    public final Object ocl_expressions_oclexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:683:3: (ret= oclexpressions_priority_1 )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:684:3: ret= oclexpressions_priority_1
            {
            pushFollow(FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression3225);
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


    // $ANTLR start "ocl_expressions_literalexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:691:1: ocl_expressions_literalexp returns [Object ret2] : (ret= ocl_expressions_primitiveliteralexp | ret= ocl_expressions_enumliteralexp | ret= ocl_expressions_collectionliteralexp ) ;
    public final Object ocl_expressions_literalexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:692:3: ( (ret= ocl_expressions_primitiveliteralexp | ret= ocl_expressions_enumliteralexp | ret= ocl_expressions_collectionliteralexp ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:693:3: (ret= ocl_expressions_primitiveliteralexp | ret= ocl_expressions_enumliteralexp | ret= ocl_expressions_collectionliteralexp )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:693:3: (ret= ocl_expressions_primitiveliteralexp | ret= ocl_expressions_enumliteralexp | ret= ocl_expressions_collectionliteralexp )
            int alt36=3;
            switch ( input.LA(1) ) {
            case STRING:
            case INT:
            case FLOAT:
            case BOOL:
                {
                alt36=1;
                }
                break;
            case QNAME:
                {
                alt36=2;
                }
                break;
            case 42:
            case 43:
            case 47:
            case 51:
            case 56:
                {
                alt36=3;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:693:4: ret= ocl_expressions_primitiveliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_primitiveliteralexp_in_ocl_expressions_literalexp3251);
                    ret=ocl_expressions_primitiveliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:694:5: ret= ocl_expressions_enumliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_enumliteralexp_in_ocl_expressions_literalexp3259);
                    ret=ocl_expressions_enumliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:695:5: ret= ocl_expressions_collectionliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionliteralexp_in_ocl_expressions_literalexp3267);
                    ret=ocl_expressions_collectionliteralexp();

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
    // $ANTLR end "ocl_expressions_literalexp"


    // $ANTLR start "ocl_expressions_primitiveliteralexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:702:1: ocl_expressions_primitiveliteralexp returns [Object ret2] : (ret= ocl_expressions_numericliteralexp | ret= ocl_expressions_stringliteralexp | ret= ocl_expressions_booleanliteralexp ) ;
    public final Object ocl_expressions_primitiveliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:703:3: ( (ret= ocl_expressions_numericliteralexp | ret= ocl_expressions_stringliteralexp | ret= ocl_expressions_booleanliteralexp ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:704:3: (ret= ocl_expressions_numericliteralexp | ret= ocl_expressions_stringliteralexp | ret= ocl_expressions_booleanliteralexp )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:704:3: (ret= ocl_expressions_numericliteralexp | ret= ocl_expressions_stringliteralexp | ret= ocl_expressions_booleanliteralexp )
            int alt37=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt37=1;
                }
                break;
            case STRING:
                {
                alt37=2;
                }
                break;
            case BOOL:
                {
                alt37=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:704:4: ret= ocl_expressions_numericliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_numericliteralexp_in_ocl_expressions_primitiveliteralexp3294);
                    ret=ocl_expressions_numericliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:705:5: ret= ocl_expressions_stringliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_stringliteralexp_in_ocl_expressions_primitiveliteralexp3302);
                    ret=ocl_expressions_stringliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:706:5: ret= ocl_expressions_booleanliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_booleanliteralexp_in_ocl_expressions_primitiveliteralexp3310);
                    ret=ocl_expressions_booleanliteralexp();

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
    // $ANTLR end "ocl_expressions_primitiveliteralexp"


    // $ANTLR start "ocl_expressions_numericliteralexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:713:1: ocl_expressions_numericliteralexp returns [Object ret2] : (ret= ocl_expressions_integerliteralexp | ret= ocl_expressions_realliteralexp ) ;
    public final Object ocl_expressions_numericliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:714:3: ( (ret= ocl_expressions_integerliteralexp | ret= ocl_expressions_realliteralexp ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:715:3: (ret= ocl_expressions_integerliteralexp | ret= ocl_expressions_realliteralexp )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:715:3: (ret= ocl_expressions_integerliteralexp | ret= ocl_expressions_realliteralexp )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==INT) ) {
                alt38=1;
            }
            else if ( (LA38_0==FLOAT) ) {
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:715:4: ret= ocl_expressions_integerliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_integerliteralexp_in_ocl_expressions_numericliteralexp3337);
                    ret=ocl_expressions_integerliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:716:5: ret= ocl_expressions_realliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_realliteralexp_in_ocl_expressions_numericliteralexp3345);
                    ret=ocl_expressions_realliteralexp();

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
    // $ANTLR end "ocl_expressions_numericliteralexp"


    // $ANTLR start "ocl_expressions_integerliteralexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:723:1: ocl_expressions_integerliteralexp returns [Object ret2] : ( (temp= integerAsString ) ) ;
    public final Object ocl_expressions_integerliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","IntegerLiteralExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:728:3: ( ( (temp= integerAsString ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:729:3: ( (temp= integerAsString ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:729:3: ( (temp= integerAsString ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:729:4: (temp= integerAsString )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BADDD0E73311DEC1B3F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:729:63: (temp= integerAsString )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:729:65: temp= integerAsString
            {
            pushFollow(FOLLOW_integerAsString_in_ocl_expressions_integerliteralexp3379);
            temp=integerAsString();

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
              _beforeSeqEl("E01DFA6E64BB04E2E73311DECC75F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "integerSymbol", null, null, "OCL:self.name.toInteger()", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:Classifier.allInstances()->select(c| if c.container->isEmpty() then false else c.qualifiedName->asSequence()->at(1)='PrimitiveTypes' and qualifiedName->asSequence()->at(2)='Integer' endif)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_integerliteralexp"


    // $ANTLR start "ocl_expressions_stringliteralexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:737:1: ocl_expressions_stringliteralexp returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object ocl_expressions_stringliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","StringLiteralExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:742:3: ( ( (temp= stringSymbol ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:743:3: ( (temp= stringSymbol ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:743:3: ( (temp= stringSymbol ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:743:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BB7A12E73311DECECDF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:743:63: (temp= stringSymbol )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:743:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_ocl_expressions_stringliteralexp3429);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "stringSymbol", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BBA122E73311DEAAFBF7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:self.stringSymbol", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:Classifier.allInstances()->select(c| if c.container->isEmpty() then false else c.qualifiedName->asSequence()->at(1)='PrimitiveTypes' and qualifiedName->asSequence()->at(2)='String' endif)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_stringliteralexp"


    // $ANTLR start "ocl_expressions_realliteralexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:751:1: ocl_expressions_realliteralexp returns [Object ret2] : ( (temp= floatAsString ) ) ;
    public final Object ocl_expressions_realliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","RealLiteralExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:756:3: ( ( (temp= floatAsString ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:757:3: ( (temp= floatAsString ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:757:3: ( (temp= floatAsString ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:757:4: (temp= floatAsString )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BC1652E73311DECA97F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:757:63: (temp= floatAsString )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:757:65: temp= floatAsString
            {
            pushFollow(FOLLOW_floatAsString_in_ocl_expressions_realliteralexp3479);
            temp=floatAsString();

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
              _beforeSeqEl("E01DFA6E64BC3D62E73311DE97ACF7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "realSymbol", null, null, "OCL:self.name.toDouble()", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:Classifier.allInstances()->select(c| if c.container->isEmpty() then false else c.qualifiedName->asSequence()->at(1)='PrimitiveTypes' and qualifiedName->asSequence()->at(2)='Double' endif)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_realliteralexp"


    // $ANTLR start "ocl_expressions_booleanliteralexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:765:1: ocl_expressions_booleanliteralexp returns [Object ret2] : ( (temp= booleanValueSymbol ) ) ;
    public final Object ocl_expressions_booleanliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","BooleanLiteralExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:770:3: ( ( (temp= booleanValueSymbol ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:771:3: ( (temp= booleanValueSymbol ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:771:3: ( (temp= booleanValueSymbol ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:771:4: (temp= booleanValueSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BCB291E73311DEB532F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:771:63: (temp= booleanValueSymbol )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:771:65: temp= booleanValueSymbol
            {
            pushFollow(FOLLOW_booleanValueSymbol_in_ocl_expressions_booleanliteralexp3529);
            temp=booleanValueSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "booleanSymbol", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BCD9A2E73311DE846EF7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:if self.booleanSymbol then 'true' else 'false' endif", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:Classifier.allInstances()->select(c| if c.container->isEmpty() then false else c.qualifiedName->asSequence()->at(1)='PrimitiveTypes' and qualifiedName->asSequence()->at(2)='Boolean' endif)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_booleanliteralexp"


    // $ANTLR start "ocl_expressions_enumliteralexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:779:1: ocl_expressions_enumliteralexp returns [Object ret2] : ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) ;
    public final Object ocl_expressions_enumliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","EnumLiteralExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:784:3: ( ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:785:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:785:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:785:4: (temp= qualifiedNameSymbol ) DCOLON (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BD75E1E73311DE8F6CF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:785:63: (temp= qualifiedNameSymbol )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:785:65: temp= qualifiedNameSymbol
            {
            pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_expressions_enumliteralexp3579);
            temp=qualifiedNameSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "referredEnum", null, temp, "OCL:"+"			let t=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  				i; acc:Tuple(pos:Integer, ns:Set(Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"				t.ns.contents->select(c | c.name=?.subString(t.pos, ?.size()))");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BD75E2E73311DEA877F7FB8D150602");
            }
            match(input,DCOLON,FOLLOW_DCOLON_in_ocl_expressions_enumliteralexp3586); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BD75E4E73311DE96CBF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:785:995: (temp= identifier )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:785:997: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_expressions_enumliteralexp3594);
            temp=identifier();

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
    // $ANTLR end "ocl_expressions_enumliteralexp"


    // $ANTLR start "ocl_expressions_collectionliteralexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:793:1: ocl_expressions_collectionliteralexp returns [Object ret2] : ( ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) ;
    public final Object ocl_expressions_collectionliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","CollectionLiteralExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"collectionliteral"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:798:3: ( ( ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:3: ( ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:3: ( ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:4: ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BF4AA0E73311DECBC2F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:63: ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) )
            int alt39=5;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt39=1;
                }
                break;
            case 56:
                {
                alt39=2;
                }
                break;
            case 47:
                {
                alt39=3;
                }
                break;
            case 42:
                {
                alt39=4;
                }
                break;
            case 51:
                {
                alt39=5;
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:64: ( 'Sequence' (temp= model_classifier_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:80: ( 'Sequence' (temp= model_classifier_sequence ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:81: 'Sequence' (temp= model_classifier_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BE1220E73311DEA390F7FB8D150602");
                    }
                    match(input,43,FOLLOW_43_in_ocl_expressions_collectionliteralexp3642); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BE1223E73311DE8709F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:225: (temp= model_classifier_sequence )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:799:227: temp= model_classifier_sequence
                    {
                    pushFollow(FOLLOW_model_classifier_sequence_in_ocl_expressions_collectionliteralexp3649);
                    temp=model_classifier_sequence();

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
                      _beforeSeqEl("E01DFA6E64BE3932E73311DECF30F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.SEQUENCE);_exitInjectorAction();
                    }
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:800:4: ( 'Set' (temp= model_classifier_set ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:800:20: ( 'Set' (temp= model_classifier_set ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:800:21: 'Set' (temp= model_classifier_set )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BE3934E73311DEA13EF7FB8D150602");
                    }
                    match(input,56,FOLLOW_56_in_ocl_expressions_collectionliteralexp3668); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BE6042E73311DEAE24F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:800:160: (temp= model_classifier_set )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:800:162: temp= model_classifier_set
                    {
                    pushFollow(FOLLOW_model_classifier_set_in_ocl_expressions_collectionliteralexp3675);
                    temp=model_classifier_set();

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
                      _beforeSeqEl("E01DFA6E64BE6045E73311DEA1D3F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.SET);_exitInjectorAction();
                    }
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:801:4: ( 'Collection' (temp= model_classifier_collection ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:801:20: ( 'Collection' (temp= model_classifier_collection ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:801:21: 'Collection' (temp= model_classifier_collection )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BE8750E73311DECB85F7FB8D150602");
                    }
                    match(input,47,FOLLOW_47_in_ocl_expressions_collectionliteralexp3694); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BE8753E73311DE8755F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:801:167: (temp= model_classifier_collection )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:801:169: temp= model_classifier_collection
                    {
                    pushFollow(FOLLOW_model_classifier_collection_in_ocl_expressions_collectionliteralexp3701);
                    temp=model_classifier_collection();

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
                      _beforeSeqEl("E01DFA6E64BEAE60E73311DEBA6DF7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.COLLECTION);_exitInjectorAction();
                    }
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:802:4: ( 'Bag' (temp= model_classifier_bag ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:802:20: ( 'Bag' (temp= model_classifier_bag ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:802:21: 'Bag' (temp= model_classifier_bag )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BEAE62E73311DEB3B2F7FB8D150602");
                    }
                    match(input,42,FOLLOW_42_in_ocl_expressions_collectionliteralexp3720); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BED570E73311DE9459F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:802:160: (temp= model_classifier_bag )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:802:162: temp= model_classifier_bag
                    {
                    pushFollow(FOLLOW_model_classifier_bag_in_ocl_expressions_collectionliteralexp3727);
                    temp=model_classifier_bag();

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
                      _beforeSeqEl("E01DFA6E64BEFC80E73311DEAA2DF7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.BAG);_exitInjectorAction();
                    }
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:4: ( 'OrderedSet' (temp= model_classifier_orderedset ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(4);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:20: ( 'OrderedSet' (temp= model_classifier_orderedset ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:21: 'OrderedSet' (temp= model_classifier_orderedset )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BEFC82E73311DEA4DBF7FB8D150602");
                    }
                    match(input,51,FOLLOW_51_in_ocl_expressions_collectionliteralexp3746); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64BEFC85E73311DE81CAF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:167: (temp= model_classifier_orderedset )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:169: temp= model_classifier_orderedset
                    {
                    pushFollow(FOLLOW_model_classifier_orderedset_in_ocl_expressions_collectionliteralexp3753);
                    temp=model_classifier_orderedset();

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
                      _beforeSeqEl("E01DFA6E64BF2392E73311DEB4C7F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.ORDERED_SET);_exitInjectorAction();
                    }
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
              _beforeSeqEl("E01DFA6E64BF4AA1E73311DE8D26F7FB8D150602");
            }
            match(input,LCURL,FOLLOW_LCURL_in_ocl_expressions_collectionliteralexp3768); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BF71B2E73311DE9B2EF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:605: (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=NAME && LA41_0<=QNAME)||(LA41_0>=INT && LA41_0<=BOOL)||LA41_0==LPAREN||LA41_0==32||LA41_0==37||(LA41_0>=42 && LA41_0<=43)||(LA41_0>=46 && LA41_0<=47)||LA41_0==51||LA41_0==56) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:607: temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_expressions_collectionliteralexp3776);
                    temp=ocl_expressions_collectionliteralpart();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parts", temp);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:685: ( ( ',' ) temp= ocl_expressions_collectionliteralpart )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==41) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:686: ( ',' ) temp= ocl_expressions_collectionliteralpart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:703: ( ',' )
                    	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:803:704: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E01DFA6E64BF4AA3E73311DEC085F7FB8D150602");
                    	    }
                    	    match(input,41,FOLLOW_41_in_ocl_expressions_collectionliteralexp3784); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_expressions_collectionliteralexp3791);
                    	    temp=ocl_expressions_collectionliteralpart();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "parts", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BF71B3E73311DEA621F7FB8D150602");
            }
            match(input,RCURL,FOLLOW_RCURL_in_ocl_expressions_collectionliteralexp3803); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64BF98C0E73311DEA7B6F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:self.type.name.subString(1, -4+type.name.size()).concat('{...}')", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_collectionliteralexp"


    // $ANTLR start "model_classifier_sequence"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:811:1: model_classifier_sequence returns [Object ret2] : (ret= model_datatype_sequence ) ;
    public final Object model_classifier_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:812:3: ( (ret= model_datatype_sequence ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:813:3: (ret= model_datatype_sequence )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:813:3: (ret= model_datatype_sequence )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:813:4: ret= model_datatype_sequence
            {
            pushFollow(FOLLOW_model_datatype_sequence_in_model_classifier_sequence3844);
            ret=model_datatype_sequence();

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
    // $ANTLR end "model_classifier_sequence"


    // $ANTLR start "model_datatype_sequence"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:820:1: model_datatype_sequence returns [Object ret2] : (ret= ocl_types_collectiontype_sequence ) ;
    public final Object model_datatype_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:821:3: ( (ret= ocl_types_collectiontype_sequence ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:822:3: (ret= ocl_types_collectiontype_sequence )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:822:3: (ret= ocl_types_collectiontype_sequence )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:822:4: ret= ocl_types_collectiontype_sequence
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_sequence_in_model_datatype_sequence3871);
            ret=ocl_types_collectiontype_sequence();

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
    // $ANTLR end "model_datatype_sequence"


    // $ANTLR start "ocl_types_collectiontype_sequence"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:829:1: ocl_types_collectiontype_sequence returns [Object ret2] : (ret= ocl_types_sequencetype_sequence ) ;
    public final Object ocl_types_collectiontype_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:830:3: ( (ret= ocl_types_sequencetype_sequence ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:831:3: (ret= ocl_types_sequencetype_sequence )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:831:3: (ret= ocl_types_sequencetype_sequence )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:831:4: ret= ocl_types_sequencetype_sequence
            {
            pushFollow(FOLLOW_ocl_types_sequencetype_sequence_in_ocl_types_collectiontype_sequence3898);
            ret=ocl_types_sequencetype_sequence();

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
    // $ANTLR end "ocl_types_collectiontype_sequence"


    // $ANTLR start "ocl_types_sequencetype_sequence"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:838:1: ocl_types_sequencetype_sequence returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_sequencetype_sequence() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("OCL","Types","SequenceType");
        onEnterTemplateRule(metaType,"sequence");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:843:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:844:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:844:3: ( collectiontypeelementtype[ret] )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:844:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64C257E0E73311DEAA7AF7FB8D150602");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_sequencetype_sequence3928);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64C257E3E73311DEA495F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "SequenceType");_exitInjectorAction();
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
    // $ANTLR end "ocl_types_sequencetype_sequence"


    // $ANTLR start "model_classifier_set"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:852:1: model_classifier_set returns [Object ret2] : (ret= model_datatype_set ) ;
    public final Object model_classifier_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:853:3: ( (ret= model_datatype_set ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:854:3: (ret= model_datatype_set )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:854:3: (ret= model_datatype_set )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:854:4: ret= model_datatype_set
            {
            pushFollow(FOLLOW_model_datatype_set_in_model_classifier_set3969);
            ret=model_datatype_set();

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
    // $ANTLR end "model_classifier_set"


    // $ANTLR start "model_datatype_set"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:861:1: model_datatype_set returns [Object ret2] : (ret= ocl_types_collectiontype_set ) ;
    public final Object model_datatype_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:862:3: ( (ret= ocl_types_collectiontype_set ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:863:3: (ret= ocl_types_collectiontype_set )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:863:3: (ret= ocl_types_collectiontype_set )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:863:4: ret= ocl_types_collectiontype_set
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_set_in_model_datatype_set3996);
            ret=ocl_types_collectiontype_set();

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
    // $ANTLR end "model_datatype_set"


    // $ANTLR start "ocl_types_collectiontype_set"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:870:1: ocl_types_collectiontype_set returns [Object ret2] : (ret= ocl_types_settype_set ) ;
    public final Object ocl_types_collectiontype_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:871:3: ( (ret= ocl_types_settype_set ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:872:3: (ret= ocl_types_settype_set )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:872:3: (ret= ocl_types_settype_set )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:872:4: ret= ocl_types_settype_set
            {
            pushFollow(FOLLOW_ocl_types_settype_set_in_ocl_types_collectiontype_set4023);
            ret=ocl_types_settype_set();

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
    // $ANTLR end "ocl_types_collectiontype_set"


    // $ANTLR start "ocl_types_settype_set"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:879:1: ocl_types_settype_set returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_settype_set() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("OCL","Types","SetType");
        onEnterTemplateRule(metaType,"set");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:884:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:885:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:885:3: ( collectiontypeelementtype[ret] )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:885:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64C51700E73311DE9475F7FB8D150602");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_settype_set4053);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64C51703E73311DEA124F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "SetType");_exitInjectorAction();
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
    // $ANTLR end "ocl_types_settype_set"


    // $ANTLR start "model_classifier_collection"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:893:1: model_classifier_collection returns [Object ret2] : (ret= model_datatype_collection ) ;
    public final Object model_classifier_collection() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:894:3: ( (ret= model_datatype_collection ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:895:3: (ret= model_datatype_collection )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:895:3: (ret= model_datatype_collection )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:895:4: ret= model_datatype_collection
            {
            pushFollow(FOLLOW_model_datatype_collection_in_model_classifier_collection4094);
            ret=model_datatype_collection();

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
    // $ANTLR end "model_classifier_collection"


    // $ANTLR start "model_datatype_collection"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:902:1: model_datatype_collection returns [Object ret2] : (ret= ocl_types_collectiontype_collection ) ;
    public final Object model_datatype_collection() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:903:3: ( (ret= ocl_types_collectiontype_collection ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:904:3: (ret= ocl_types_collectiontype_collection )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:904:3: (ret= ocl_types_collectiontype_collection )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:904:4: ret= ocl_types_collectiontype_collection
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_collection_in_model_datatype_collection4121);
            ret=ocl_types_collectiontype_collection();

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
    // $ANTLR end "model_datatype_collection"


    // $ANTLR start "ocl_types_collectiontype_collection"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:911:1: ocl_types_collectiontype_collection returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_collectiontype_collection() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("OCL","Types","CollectionType");
        onEnterTemplateRule(metaType,"collection");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:916:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:917:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:917:3: ( collectiontypeelementtype[ret] )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:917:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64C760F0E73311DEB7CDF7FB8D150602");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_collectiontype_collection4151);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64C78800E73311DE891EF7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "CollectionType");_exitInjectorAction();
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
    // $ANTLR end "ocl_types_collectiontype_collection"


    // $ANTLR start "model_classifier_bag"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:925:1: model_classifier_bag returns [Object ret2] : (ret= model_datatype_bag ) ;
    public final Object model_classifier_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:926:3: ( (ret= model_datatype_bag ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:927:3: (ret= model_datatype_bag )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:927:3: (ret= model_datatype_bag )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:927:4: ret= model_datatype_bag
            {
            pushFollow(FOLLOW_model_datatype_bag_in_model_classifier_bag4192);
            ret=model_datatype_bag();

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
    // $ANTLR end "model_classifier_bag"


    // $ANTLR start "model_datatype_bag"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:934:1: model_datatype_bag returns [Object ret2] : (ret= ocl_types_collectiontype_bag ) ;
    public final Object model_datatype_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:935:3: ( (ret= ocl_types_collectiontype_bag ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:936:3: (ret= ocl_types_collectiontype_bag )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:936:3: (ret= ocl_types_collectiontype_bag )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:936:4: ret= ocl_types_collectiontype_bag
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_bag_in_model_datatype_bag4219);
            ret=ocl_types_collectiontype_bag();

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
    // $ANTLR end "model_datatype_bag"


    // $ANTLR start "ocl_types_collectiontype_bag"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:943:1: ocl_types_collectiontype_bag returns [Object ret2] : (ret= ocl_types_bagtype_bag ) ;
    public final Object ocl_types_collectiontype_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:944:3: ( (ret= ocl_types_bagtype_bag ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:945:3: (ret= ocl_types_bagtype_bag )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:945:3: (ret= ocl_types_bagtype_bag )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:945:4: ret= ocl_types_bagtype_bag
            {
            pushFollow(FOLLOW_ocl_types_bagtype_bag_in_ocl_types_collectiontype_bag4246);
            ret=ocl_types_bagtype_bag();

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
    // $ANTLR end "ocl_types_collectiontype_bag"


    // $ANTLR start "ocl_types_bagtype_bag"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:952:1: ocl_types_bagtype_bag returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_bagtype_bag() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("OCL","Types","BagType");
        onEnterTemplateRule(metaType,"bag");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:957:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:958:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:958:3: ( collectiontypeelementtype[ret] )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:958:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64C9F900E73311DEB56EF7FB8D150602");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_bagtype_bag4276);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CA2012E73311DEBCA7F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "BagType");_exitInjectorAction();
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
    // $ANTLR end "ocl_types_bagtype_bag"


    // $ANTLR start "model_classifier_orderedset"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:966:1: model_classifier_orderedset returns [Object ret2] : (ret= model_datatype_orderedset ) ;
    public final Object model_classifier_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:967:3: ( (ret= model_datatype_orderedset ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:968:3: (ret= model_datatype_orderedset )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:968:3: (ret= model_datatype_orderedset )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:968:4: ret= model_datatype_orderedset
            {
            pushFollow(FOLLOW_model_datatype_orderedset_in_model_classifier_orderedset4317);
            ret=model_datatype_orderedset();

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
    // $ANTLR end "model_classifier_orderedset"


    // $ANTLR start "model_datatype_orderedset"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:975:1: model_datatype_orderedset returns [Object ret2] : (ret= ocl_types_collectiontype_orderedset ) ;
    public final Object model_datatype_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:976:3: ( (ret= ocl_types_collectiontype_orderedset ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:977:3: (ret= ocl_types_collectiontype_orderedset )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:977:3: (ret= ocl_types_collectiontype_orderedset )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:977:4: ret= ocl_types_collectiontype_orderedset
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_orderedset_in_model_datatype_orderedset4344);
            ret=ocl_types_collectiontype_orderedset();

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
    // $ANTLR end "model_datatype_orderedset"


    // $ANTLR start "ocl_types_collectiontype_orderedset"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:984:1: ocl_types_collectiontype_orderedset returns [Object ret2] : (ret= ocl_types_orderedsettype_orderedset ) ;
    public final Object ocl_types_collectiontype_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:985:3: ( (ret= ocl_types_orderedsettype_orderedset ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:986:3: (ret= ocl_types_orderedsettype_orderedset )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:986:3: (ret= ocl_types_orderedsettype_orderedset )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:986:4: ret= ocl_types_orderedsettype_orderedset
            {
            pushFollow(FOLLOW_ocl_types_orderedsettype_orderedset_in_ocl_types_collectiontype_orderedset4371);
            ret=ocl_types_orderedsettype_orderedset();

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
    // $ANTLR end "ocl_types_collectiontype_orderedset"


    // $ANTLR start "ocl_types_orderedsettype_orderedset"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:993:1: ocl_types_orderedsettype_orderedset returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_orderedsettype_orderedset() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("OCL","Types","OrderedSetType");
        onEnterTemplateRule(metaType,"orderedset");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:998:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:999:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:999:3: ( collectiontypeelementtype[ret] )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:999:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CCDF30E73311DE8CC8F7FB8D150602");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_orderedsettype_orderedset4401);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CCDF33E73311DE9D05F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "OrderedSetType");_exitInjectorAction();
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
    // $ANTLR end "ocl_types_orderedsettype_orderedset"


    // $ANTLR start "collectiontypeelementtype"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1007:1: collectiontypeelementtype[Object ret] : () ;
    public final void collectiontypeelementtype(Object ret) throws RecognitionException {
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1008:3: ( () )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1009:3: ()
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1009:3: ()
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1009:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CE65D2E73311DE9C35F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "elementType", null, null, "OCL:#context(collectionliteral).oclAsType(CollectionLiteralExp).parts.type->iterate("+"  								t; acc:Moin::Model::Classifier=null |"+"  									if acc->isEmpty() or acc=t then"+"  										t "+"  									else "+"  										if t.allSupertypes()->includes(acc) then"+"  											acc "+"  										else "+"  											if acc.allSupertypes()->includes(t) then"+"  												t "+"  											else "+"  												null "+"  											endif"+"  										endif"+"  									endif)", true);_exitInjectorAction();
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


    // $ANTLR start "ocl_expressions_collectionliteralpart"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1016:1: ocl_expressions_collectionliteralpart returns [Object ret2] : ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) ) ;
    public final Object ocl_expressions_collectionliteralpart() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1017:3: ( ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1018:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1018:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) )
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1018:4: ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1018:38: (ret= ocl_expressions_collectionitem )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1018:39: ret= ocl_expressions_collectionitem
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart4471);
                    ret=ocl_expressions_collectionitem();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1019:5: ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1019:40: (ret= ocl_expressions_collectionrange )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1019:41: ret= ocl_expressions_collectionrange
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart4485);
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


    // $ANTLR start "ocl_expressions_collectionitem"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1026:1: ocl_expressions_collectionitem returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_expressions_collectionitem() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","CollectionItem");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1031:3: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1032:3: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1032:3: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1032:4: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CF5030E73311DEB6B4F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1032:63: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1032:65: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionitem4520);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "item", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CF5033E73311DEC223F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.item.type", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_collectionitem"


    // $ANTLR start "ocl_expressions_collectionrange"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1040:1: ocl_expressions_collectionrange returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_expressions_collectionrange() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","CollectionRange");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1045:3: ( ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1046:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1046:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1046:4: (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CFC561E73311DEB88EF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1046:63: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1046:65: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionrange4570);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "first", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CFC562E73311DE9FC5F7FB8D150602");
            }
            match(input,DDOT,FOLLOW_DDOT_in_ocl_expressions_collectionrange4577); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CFEC71E73311DEA475F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1046:291: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1046:293: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionrange4585);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "last", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64CFEC74E73311DE8E70F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:if self.first.type=self.last.type then"+"  	  						self.first.type "+"  	  					  else "+"  	  					  	if self.first.type.allSupertypes()->includes(self.last.type) then"+"  	  					  		self.last.type "+"  	  					  	else "+"  	  					  		if self.last.type.allSupertypes()->includes(self.first.type) then "+"  	  					  			self.first.type "+"  	  					  		else "+"  	  					  			null "+"  	  					  		endif "+"  	  					  	endif "+"  	  					  endif", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_collectionrange"


    // $ANTLR start "ocl_expressions_collectionkind"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1054:1: ocl_expressions_collectionkind returns [Object ret2] : ( ( 'Collection' ) | ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'OrderedSet' ) ) ;
    public final Object ocl_expressions_collectionkind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1055:3: ( ( ( 'Collection' ) | ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'OrderedSet' ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1056:3: ( ( 'Collection' ) | ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'OrderedSet' ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1056:3: ( ( 'Collection' ) | ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'OrderedSet' ) )
            int alt43=5;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt43=1;
                }
                break;
            case 56:
                {
                alt43=2;
                }
                break;
            case 42:
                {
                alt43=3;
                }
                break;
            case 43:
                {
                alt43=4;
                }
                break;
            case 51:
                {
                alt43=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1056:4: ( 'Collection' )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1056:4: ( 'Collection' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1056:5: 'Collection'
                    {
                    match(input,47,FOLLOW_47_in_ocl_expressions_collectionkind4631); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "Collection");
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1057:4: ( 'Set' )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1057:4: ( 'Set' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1057:5: 'Set'
                    {
                    match(input,56,FOLLOW_56_in_ocl_expressions_collectionkind4639); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "Set");
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1058:4: ( 'Bag' )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1058:4: ( 'Bag' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1058:5: 'Bag'
                    {
                    match(input,42,FOLLOW_42_in_ocl_expressions_collectionkind4647); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "Bag");
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1059:4: ( 'Sequence' )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1059:4: ( 'Sequence' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1059:5: 'Sequence'
                    {
                    match(input,43,FOLLOW_43_in_ocl_expressions_collectionkind4655); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "Sequence");
                    }

                    }
                    break;
                case 5 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1060:4: ( 'OrderedSet' )
                    {
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1060:4: ( 'OrderedSet' )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1060:5: 'OrderedSet'
                    {
                    match(input,51,FOLLOW_51_in_ocl_expressions_collectionkind4663); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "OrderedSet");
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
    // $ANTLR end "ocl_expressions_collectionkind"


    // $ANTLR start "ocl_expressions_ifexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1067:1: ocl_expressions_ifexp returns [Object ret2] : ( 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif' ) ;
    public final Object ocl_expressions_ifexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","IfExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1072:3: ( ( 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif' ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:3: ( 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif' )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:3: ( 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif' )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:4: 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D0D6D0E73311DEB0F4F7FB8D150602");
            }
            match(input,37,FOLLOW_37_in_ocl_expressions_ifexp4693); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D0D6D2E73311DEA262F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:142: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:144: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp4700);
            temp=ocl_expressions_oclexpression();

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
              _beforeSeqEl("E01DFA6E64D0D6D3E73311DEB409F7FB8D150602");
            }
            match(input,44,FOLLOW_44_in_ocl_expressions_ifexp4706); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D0FDE1E73311DE8824F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:374: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:375: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:375: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:376: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D0D6D5E73311DEC8ABF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:435: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:437: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp4716);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "thenExpression", temp);
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
              _beforeSeqEl("E01DFA6E64D0FDE2E73311DEAC70F7FB8D150602");
            }
            match(input,54,FOLLOW_54_in_ocl_expressions_ifexp4725); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D124F0E73311DE9231F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:690: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:691: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:691: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:692: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D0FDE4E73311DE8E56F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:751: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1073:753: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp4735);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "elseExpression", temp);
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
              _beforeSeqEl("E01DFA6E64D124F1E73311DECB7FF7FB8D150602");
            }
            match(input,36,FOLLOW_36_in_ocl_expressions_ifexp4744); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D124F6E73311DEA151F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:'if '.concat(self.condition.name)", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:if self.thenExpression.type=self.elseExpression.type then"+"  	                          self.thenExpression.type"+"  	                      else"+"  	                          if self.thenExpression.type.allSupertypes()->includes(self.elseExpression.type) then"+"  	                              self.elseExpression.type"+"  	                          else"+"  	                              if self.elseExpression.type.allSupertypes()->includes(self.thenExpression.type) then"+"  	                                  self.thenExpression.type"+"  	                              else"+"  	                                  null"+"  	                              endif"+"  	                          endif"+"  	                      endif", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_ifexp"


    // $ANTLR start "ocl_expressions_letexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1081:1: ocl_expressions_letexp returns [Object ret2] : ( 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) ;
    public final Object ocl_expressions_letexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","LetExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1086:3: ( ( 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:3: ( 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:3: ( 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:4: 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D1C130E73311DEBB4BF7FB8D150602");
            }
            match(input,32,FOLLOW_32_in_ocl_expressions_letexp4787); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D1E840E73311DE91D0F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:143: (temp= ocl_expressions_variabledeclaration_let )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:145: temp= ocl_expressions_variabledeclaration_let
            {
            pushFollow(FOLLOW_ocl_expressions_variabledeclaration_let_in_ocl_expressions_letexp4794);
            temp=ocl_expressions_variabledeclaration_let();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "variable", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D1E841E73311DEBD36F7FB8D150602");
            }
            match(input,35,FOLLOW_35_in_ocl_expressions_letexp4800); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D20F50E73311DE9CDAF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:382: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:383: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:383: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:384: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D1E843E73311DEB19AF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:443: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1087:445: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_letexp4810);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "in", temp);
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
              _beforeSeqEl("E01DFA6E64D20F55E73311DE9E24F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.\"in\".type", true);_exitInjectorAction();setOclRef(ret, "name", null, null, "OCL:'let '.concat(self.variable.name)", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_letexp"


    // $ANTLR start "ocl_expressions_variabledeclaration_let"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1095:1: ocl_expressions_variabledeclaration_let returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_expressions_variabledeclaration_let() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","VariableDeclaration");
        onEnterTemplateRule(metaType,"let");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1100:3: ( ( (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:3: ( (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:3: ( (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:4: (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D2AB91E73311DEA262F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:63: (temp= identifier )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_expressions_variabledeclaration_let4863);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "varName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D347D0E73311DECCF0F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:193: ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) )
            int alt44=3;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==50) ) {
                alt44=1;
            }
            else if ( (LA44_0==COLON) ) {
                int LA44_2 = input.LA(2);

                if ( (LA44_2==QNAME) ) {
                    alt44=2;
                }
                else if ( (LA44_2==NAME) ) {
                    alt44=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:194: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:210: ()
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1101:211: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D2D2A0E73311DE87C9F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "type", null, null, "OCL:self.initExpression.type", true);_exitInjectorAction();
                    }
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1102:4: ( COLON (temp= qualifiedNameSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1102:20: ( COLON (temp= qualifiedNameSymbol ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1102:21: COLON (temp= qualifiedNameSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D2D2A2E73311DEC05CF7FB8D150602");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_expressions_variabledeclaration_let4888); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D2F9B0E73311DEA82FF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1102:162: (temp= qualifiedNameSymbol )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1102:164: temp= qualifiedNameSymbol
                    {
                    pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_expressions_variabledeclaration_let4896);
                    temp=qualifiedNameSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
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
                case 3 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1103:4: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1103:20: ( COLON (temp= identifier ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1103:21: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D2F9B2E73311DEB81AF7FB8D150602");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_expressions_variabledeclaration_let4913); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D320C3E73311DE8871F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1103:162: (temp= identifier )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1103:164: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_expressions_variabledeclaration_let4921);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D347D1E73311DEC563F7FB8D150602");
            }
            match(input,50,FOLLOW_50_in_ocl_expressions_variabledeclaration_let4932); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D347D4E73311DEB7CCF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1103:459: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1103:461: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_variabledeclaration_let4939);
            temp=ocl_expressions_oclexpression();

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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D36EE2E73311DECD01F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:self.varName", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_variabledeclaration_let"


    // $ANTLR start "ocl_expressions_variabledeclaration"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1111:1: ocl_expressions_variabledeclaration returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) ) ;
    public final Object ocl_expressions_variabledeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","VariableDeclaration");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1116:3: ( ( (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:3: ( (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:3: ( (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:4: (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D40B21E73311DE987AF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:63: (temp= identifier )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_expressions_variabledeclaration4989);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "varName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D40B24E73311DEA214F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:self.varName", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D4A761E73311DE9BA8F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:353: ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==NAME||LA46_0==38||LA46_0==50||LA46_0==59) ) {
                alt46=1;
            }
            else if ( (LA46_0==COLON) ) {
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:354: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:370: ()
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1117:371: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D43232E73311DEC079F7FB8D150602");
                    }
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "type", null, null, "OCL:#context(propertyCallExp).oclAsType(PropertyCallExp).source.type", true);_exitInjectorAction();
                    }
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:4: ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:20: ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:21: COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D43234E73311DE9B82F7FB8D150602");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_expressions_variabledeclaration5017); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D48053E73311DEC9B1F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:162: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==QNAME) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==NAME) ) {
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:163: ( (temp= qualifiedNameSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:179: ( (temp= qualifiedNameSymbol ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:180: (temp= qualifiedNameSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64D45941E73311DE87B7F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:239: (temp= qualifiedNameSymbol )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1118:241: temp= qualifiedNameSymbol
                            {
                            pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_expressions_variabledeclaration5030);
                            temp=qualifiedNameSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
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
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:4: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:20: ( (temp= identifier ) )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:21: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E01DFA6E64D48051E73311DEA644F7FB8D150602");
                            }
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:80: (temp= identifier )
                            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:82: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_ocl_expressions_variabledeclaration5050);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
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
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D4F580E73311DE9F96F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:332: ( ( '=' (temp= ocl_expressions_oclexpression ) ) | )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==50) ) {
                alt47=1;
            }
            else if ( (LA47_0==NAME||LA47_0==38||LA47_0==59) ) {
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:333: ( '=' (temp= ocl_expressions_oclexpression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:349: ( '=' (temp= ocl_expressions_oclexpression ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:350: '=' (temp= ocl_expressions_oclexpression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D4CE71E73311DECBB7F7FB8D150602");
                    }
                    match(input,50,FOLLOW_50_in_ocl_expressions_variabledeclaration5072); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D4CE73E73311DE8A22F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:487: (temp= ocl_expressions_oclexpression )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:489: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_variabledeclaration5079);
                    temp=ocl_expressions_oclexpression();

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
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1119:602: 
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
    // $ANTLR end "ocl_expressions_variabledeclaration"


    // $ANTLR start "ocl_expressions_variableexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1128:1: ocl_expressions_variableexp returns [Object ret2] : ( ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) ) ) ;
    public final Object ocl_expressions_variableexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","VariableExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1133:3: ( ( ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:3: ( ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:3: ( ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:4: ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D5B8D3E73311DEA8B9F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:63: ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==46) ) {
                alt48=1;
            }
            else if ( (LA48_0==NAME) ) {
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:64: ( (temp= ocl_expressions_variabledeclaration_self ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:80: ( (temp= ocl_expressions_variabledeclaration_self ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:81: (temp= ocl_expressions_variabledeclaration_self )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D591C2E73311DE9FE6F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:140: (temp= ocl_expressions_variabledeclaration_self )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1134:142: temp= ocl_expressions_variabledeclaration_self
                    {
                    pushFollow(FOLLOW_ocl_expressions_variabledeclaration_self_in_ocl_expressions_variableexp5144);
                    temp=ocl_expressions_variabledeclaration_self();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "referredVariable", temp);
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1135:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1135:20: ( (temp= identifier ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1135:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D5B8D1E73311DE832AF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1135:80: (temp= identifier )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1135:82: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_expressions_variableexp5164);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "referredVariable", list("OCL","Expressions","VariableDeclaration"), "name", temp, null, "never", null, false, null);
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
              _beforeSeqEl("E01DFA6E64D5DFE3E73311DE8517F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "type", null, null, "OCL:self.referredVariable.type", true);_exitInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredVariable.name", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_variableexp"


    // $ANTLR start "ocl_expressions_variabledeclaration_self"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1143:1: ocl_expressions_variabledeclaration_self returns [Object ret2] : ( 'self' ) ;
    public final Object ocl_expressions_variabledeclaration_self() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("OCL","Expressions","VariableDeclaration");
        onEnterTemplateRule(metaType,"self");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1148:3: ( ( 'self' ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1149:3: ( 'self' )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1149:3: ( 'self' )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1149:4: 'self'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D65510E73311DECACEF7FB8D150602");
            }
            match(input,46,FOLLOW_46_in_ocl_expressions_variabledeclaration_self5215); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D67C24E73311DE9B93F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "self");_exitInjectorAction();setProperty(ret, "varName", "self");_exitInjectorAction();setRef(ret, "type", list("Model","Classifier"), null, null, "#context(class)", null, null, false, null, true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_variabledeclaration_self"


    // $ANTLR start "ocl_expressions_iterateexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1157:1: ocl_expressions_iterateexp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN ) ;
    public final Object ocl_expressions_iterateexp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","IterateExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1162:3: ( ( 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:3: ( 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:3: ( 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:4: 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D71862E73311DEC09BF7FB8D150602");
            }
            match(input,33,FOLLOW_33_in_ocl_expressions_iterateexp5259); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D71863E73311DECC5DF7FB8D150602");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_ocl_expressions_iterateexp5263); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D71865E73311DE829CF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:230: (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:232: temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )*
            {
            pushFollow(FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp5271);
            temp=ocl_expressions_variabledeclaration();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "iterators", temp);
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:312: (temp= ocl_expressions_variabledeclaration )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==NAME) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:314: temp= ocl_expressions_variabledeclaration
            	    {
            	    pushFollow(FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp5279);
            	    temp=ocl_expressions_variabledeclaration();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "iterators", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D76681E73311DEA970F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:472: ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==59) ) {
                alt50=1;
            }
            else if ( (LA50_0==38) ) {
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:473: ( ';' (temp= ocl_expressions_variabledeclaration ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:489: ( ';' (temp= ocl_expressions_variabledeclaration ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:490: ';' (temp= ocl_expressions_variabledeclaration )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D73F70E73311DEC009F7FB8D150602");
                    }
                    match(input,59,FOLLOW_59_in_ocl_expressions_iterateexp5293); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D73F72E73311DEB378F7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:627: (temp= ocl_expressions_variabledeclaration )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1163:629: temp= ocl_expressions_variabledeclaration
                    {
                    pushFollow(FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp5300);
                    temp=ocl_expressions_variabledeclaration();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "result", temp);
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
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1164:4: ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1164:20: ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1164:21: (temp= ocl_expressions_variabledeclaration_implicitAccumulator )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E01DFA6E64D73F76E73311DEB4FDF7FB8D150602");
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1164:80: (temp= ocl_expressions_variabledeclaration_implicitAccumulator )
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1164:82: temp= ocl_expressions_variabledeclaration_implicitAccumulator
                    {
                    pushFollow(FOLLOW_ocl_expressions_variabledeclaration_implicitAccumulator_in_ocl_expressions_iterateexp5320);
                    temp=ocl_expressions_variabledeclaration_implicitAccumulator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "result", temp);
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
              _beforeSeqEl("E01DFA6E64D76682E73311DEBE5BF7FB8D150602");
            }
            match(input,38,FOLLOW_38_in_ocl_expressions_iterateexp5331); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D76684E73311DEC857F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1164:364: (temp= ocl_expressions_oclexpression )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1164:366: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_iterateexp5338);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "body", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D78D90E73311DE9D6AF7FB8D150602");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ocl_expressions_iterateexp5345); if (state.failed) return ret2;
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
    // $ANTLR end "ocl_expressions_iterateexp"


    // $ANTLR start "ocl_expressions_variabledeclaration_implicitAccumulator"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1175:1: ocl_expressions_variabledeclaration_implicitAccumulator returns [Object ret2] : () ;
    public final Object ocl_expressions_variabledeclaration_implicitAccumulator() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("OCL","Expressions","VariableDeclaration");
        onEnterTemplateRule(metaType,"implicitAccumulator");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1180:3: ( () )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1181:3: ()
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1181:3: ()
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1181:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D829D3E73311DEA6C4F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", "acc");_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:#context(propertyCallExp).oclAsType(IterateExp).\"body\".type", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_variabledeclaration_implicitAccumulator"


    // $ANTLR start "ocl_expressions_attributecallexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1189:1: ocl_expressions_attributecallexp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifierOrKeyword ) ) ;
    public final Object ocl_expressions_attributecallexp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","AttributeCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1194:3: ( ( (temp= identifierOrKeyword ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1195:3: ( (temp= identifierOrKeyword ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1195:3: ( (temp= identifierOrKeyword ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1195:4: (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D8C615E73311DEAE29F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1195:63: (temp= identifierOrKeyword )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1195:65: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_ocl_expressions_attributecallexp5423);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "referredAttribute", null, temp, "OCL:self.source.type.allSupertypes()->append(self.source.type)."+"  												contents->select(a | a.oclIsKindOf(Attribute))->select(a|a.name=?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D8ED24E73311DEAF90F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:self.referredAttribute.name", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.referredAttribute.type", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_attributecallexp"


    // $ANTLR start "ocl_expressions_operationcallexp"
    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1206:1: ocl_expressions_operationcallexp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ) ) ;
    public final Object ocl_expressions_operationcallexp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","OperationCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1211:3: ( ( ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:3: ( ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ) )
            {
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:3: ( ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:4: ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64DA25A0E73311DEA83FF7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:63: ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:64: ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN )
            {
            if ( state.backtracking==0 ) {
              _enterAlt(0);
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:103: ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:104: (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D9B074E73311DE8DF1F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:163: (temp= identifierOrKeyword )
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:165: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_ocl_expressions_operationcallexp5479);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "referredOperation", null, temp, "OCL:self.source.type.allSupertypes()->append(self.source.type)."+"  												contents->select(o | o.oclIsKindOf(Operation))->select(o|o.name=?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D9D780E73311DECE9CF7FB8D150602");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_ocl_expressions_operationcallexp5486); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D9D782E73311DE9F29F7FB8D150602");
            }
            // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:549: (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=NAME && LA52_0<=QNAME)||(LA52_0>=INT && LA52_0<=BOOL)||LA52_0==LPAREN||LA52_0==32||LA52_0==37||(LA52_0>=42 && LA52_0<=43)||(LA52_0>=46 && LA52_0<=47)||LA52_0==51||LA52_0==56) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:551: temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_operationcallexp5494);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "arguments", temp);
                    }
                    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:625: (temp= ocl_expressions_oclexpression )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( ((LA51_0>=NAME && LA51_0<=QNAME)||(LA51_0>=INT && LA51_0<=BOOL)||LA51_0==LPAREN||LA51_0==32||LA51_0==37||(LA51_0>=42 && LA51_0<=43)||(LA51_0>=46 && LA51_0<=47)||LA51_0==51||LA51_0==56) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1212:627: temp= ocl_expressions_oclexpression
                    	    {
                    	    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_operationcallexp5502);
                    	    temp=ocl_expressions_oclexpression();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "arguments", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D9D783E73311DEC2A7F7FB8D150602");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ocl_expressions_operationcallexp5514); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E01DFA6E64D9FE90E73311DE8DD3F7FB8D150602");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "name", null, null, "OCL:self.referredOperation.name.concat('(...)')", true);_exitInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.referredOperation.contents->select(p |"+"  	       			p.oclIsKindOf(Moin::Model::Parameter))->select(p |"+"  	       					p.oclAsType(Moin::Model::Parameter).direction = DirectionKind::return_dir)."+"  	       					oclAsType(Moin::Model::Parameter).type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {
              _exitAlt();
            }

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
    // $ANTLR end "ocl_expressions_operationcallexp"

    // $ANTLR start synpred1_MofClass
    public final void synpred1_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:402:4: ( model_structuralfeature )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:402:5: model_structuralfeature
        {
        pushFollow(FOLLOW_model_structuralfeature_in_synpred1_MofClass1013);
        model_structuralfeature();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_MofClass

    // $ANTLR start synpred2_MofClass
    public final void synpred2_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:403:5: ( model_behavioralfeature )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:403:6: model_behavioralfeature
        {
        pushFollow(FOLLOW_model_behavioralfeature_in_synpred2_MofClass1027);
        model_behavioralfeature();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_MofClass

    // $ANTLR start synpred3_MofClass
    public final void synpred3_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:64: ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )
        int alt53=2;
        int LA53_0 = input.LA(1);

        if ( (LA53_0==INT) ) {
            int LA53_1 = input.LA(2);

            if ( (LA53_1==DDOT) ) {
                int LA53_2 = input.LA(3);

                if ( (LA53_2==STAR) ) {
                    alt53=1;
                }
                else if ( (LA53_2==INT) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 53, 0, input);

            throw nvae;
        }
        switch (alt53) {
            case 1 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:65: integerSymbol DDOT STAR
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred3_MofClass1738);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,DDOT,FOLLOW_DDOT_in_synpred3_MofClass1740); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred3_MofClass1742); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:550:91: integerSymbol DDOT integerSymbol
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred3_MofClass1746);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,DDOT,FOLLOW_DDOT_in_synpred3_MofClass1748); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred3_MofClass1750);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred3_MofClass

    // $ANTLR start synpred4_MofClass
    public final void synpred4_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:4: ( LBRACKET integerSymbol DDOT )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:552:5: LBRACKET integerSymbol DDOT
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred4_MofClass1822); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred4_MofClass1824);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred4_MofClass1826); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_MofClass

    // $ANTLR start synpred5_MofClass
    public final void synpred5_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:4: ( LCURL integerSymbol DDOT )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:554:5: LCURL integerSymbol DDOT
        {
        match(input,LCURL,FOLLOW_LCURL_in_synpred5_MofClass1908); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred5_MofClass1910);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred5_MofClass1912); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_MofClass

    // $ANTLR start synpred6_MofClass
    public final void synpred6_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:4: ( LBRACK_LCURL integerSymbol DDOT )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:556:5: LBRACK_LCURL integerSymbol DDOT
        {
        match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred6_MofClass1994); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred6_MofClass1996);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred6_MofClass1998); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_MofClass

    // $ANTLR start synpred7_MofClass
    public final void synpred7_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:4: ( LCURL_LBRACK integerSymbol DDOT )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:558:5: LCURL_LBRACK integerSymbol DDOT
        {
        match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred7_MofClass2080); if (state.failed) return ;
        pushFollow(FOLLOW_integerSymbol_in_synpred7_MofClass2082);
        integerSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,DDOT,FOLLOW_DDOT_in_synpred7_MofClass2084); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_MofClass

    // $ANTLR start synpred8_MofClass
    public final void synpred8_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:4: ( STAR | integerSymbol ~ DDOT )
        int alt54=2;
        int LA54_0 = input.LA(1);

        if ( (LA54_0==STAR) ) {
            alt54=1;
        }
        else if ( (LA54_0==INT) ) {
            alt54=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 54, 0, input);

            throw nvae;
        }
        switch (alt54) {
            case 1 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:5: STAR
                {
                match(input,STAR,FOLLOW_STAR_in_synpred8_MofClass2166); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:560:12: integerSymbol ~ DDOT
                {
                pushFollow(FOLLOW_integerSymbol_in_synpred8_MofClass2170);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                if ( (input.LA(1)>=NAME && input.LA(1)<=RPAREN)||(input.LA(1)>=STAR && input.LA(1)<=59) ) {
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
    // $ANTLR end synpred8_MofClass

    // $ANTLR start synpred9_MofClass
    public final void synpred9_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:4: ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )
        int alt55=2;
        int LA55_0 = input.LA(1);

        if ( (LA55_0==LBRACKET) ) {
            int LA55_1 = input.LA(2);

            if ( (LA55_1==STAR) ) {
                alt55=2;
            }
            else if ( (LA55_1==INT) ) {
                alt55=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 55, 0, input);

            throw nvae;
        }
        switch (alt55) {
            case 1 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:5: LBRACKET integerSymbol RBRACKET
                {
                match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred9_MofClass2230); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred9_MofClass2232);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred9_MofClass2234); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:562:39: LBRACKET STAR RBRACKET
                {
                match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred9_MofClass2238); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred9_MofClass2240); if (state.failed) return ;
                match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred9_MofClass2242); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred9_MofClass

    // $ANTLR start synpred10_MofClass
    public final void synpred10_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:564:4: ( LBRACKET RBRACKET )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:564:5: LBRACKET RBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred10_MofClass2309); if (state.failed) return ;
        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred10_MofClass2311); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_MofClass

    // $ANTLR start synpred11_MofClass
    public final void synpred11_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:4: ( LCURL STAR RCURL | LCURL integerSymbol RCURL )
        int alt56=2;
        int LA56_0 = input.LA(1);

        if ( (LA56_0==LCURL) ) {
            int LA56_1 = input.LA(2);

            if ( (LA56_1==STAR) ) {
                alt56=1;
            }
            else if ( (LA56_1==INT) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 56, 0, input);

            throw nvae;
        }
        switch (alt56) {
            case 1 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:5: LCURL STAR RCURL
                {
                match(input,LCURL,FOLLOW_LCURL_in_synpred11_MofClass2340); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred11_MofClass2342); if (state.failed) return ;
                match(input,RCURL,FOLLOW_RCURL_in_synpred11_MofClass2344); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:565:24: LCURL integerSymbol RCURL
                {
                match(input,LCURL,FOLLOW_LCURL_in_synpred11_MofClass2348); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred11_MofClass2350);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RCURL,FOLLOW_RCURL_in_synpred11_MofClass2352); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred11_MofClass

    // $ANTLR start synpred12_MofClass
    public final void synpred12_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:567:4: ( LCURL RCURL )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:567:5: LCURL RCURL
        {
        match(input,LCURL,FOLLOW_LCURL_in_synpred12_MofClass2419); if (state.failed) return ;
        match(input,RCURL,FOLLOW_RCURL_in_synpred12_MofClass2421); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_MofClass

    // $ANTLR start synpred13_MofClass
    public final void synpred13_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:4: ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )
        int alt57=2;
        int LA57_0 = input.LA(1);

        if ( (LA57_0==LBRACK_LCURL) ) {
            int LA57_1 = input.LA(2);

            if ( (LA57_1==STAR) ) {
                alt57=1;
            }
            else if ( (LA57_1==INT) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 57, 0, input);

            throw nvae;
        }
        switch (alt57) {
            case 1 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:5: LBRACK_LCURL STAR RCURL_RBRACK
                {
                match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred13_MofClass2450); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred13_MofClass2452); if (state.failed) return ;
                match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred13_MofClass2454); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:568:38: LBRACK_LCURL integerSymbol RCURL_RBRACK
                {
                match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred13_MofClass2458); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred13_MofClass2460);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred13_MofClass2462); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred13_MofClass

    // $ANTLR start synpred14_MofClass
    public final void synpred14_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:4: ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )
        int alt58=2;
        int LA58_0 = input.LA(1);

        if ( (LA58_0==LCURL_LBRACK) ) {
            int LA58_1 = input.LA(2);

            if ( (LA58_1==STAR) ) {
                alt58=1;
            }
            else if ( (LA58_1==INT) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 58, 0, input);

            throw nvae;
        }
        switch (alt58) {
            case 1 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:5: LCURL_LBRACK STAR RBRACK_RCURL
                {
                match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred14_MofClass2529); if (state.failed) return ;
                match(input,STAR,FOLLOW_STAR_in_synpred14_MofClass2531); if (state.failed) return ;
                match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred14_MofClass2533); if (state.failed) return ;

                }
                break;
            case 2 :
                // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:570:38: LCURL_LBRACK integerSymbol RBRACK_RCURL
                {
                match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred14_MofClass2537); if (state.failed) return ;
                pushFollow(FOLLOW_integerSymbol_in_synpred14_MofClass2539);
                integerSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred14_MofClass2541); if (state.failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred14_MofClass

    // $ANTLR start synpred15_MofClass
    public final void synpred15_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:572:4: ( LCURL_LBRACK RBRACK_RCURL )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:572:5: LCURL_LBRACK RBRACK_RCURL
        {
        match(input,LCURL_LBRACK,FOLLOW_LCURL_LBRACK_in_synpred15_MofClass2608); if (state.failed) return ;
        match(input,RBRACK_RCURL,FOLLOW_RBRACK_RCURL_in_synpred15_MofClass2610); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_MofClass

    // $ANTLR start synpred16_MofClass
    public final void synpred16_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:573:4: ( LBRACK_LCURL RCURL_RBRACK )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:573:5: LBRACK_LCURL RCURL_RBRACK
        {
        match(input,LBRACK_LCURL,FOLLOW_LBRACK_LCURL_in_synpred16_MofClass2639); if (state.failed) return ;
        match(input,RCURL_RBRACK,FOLLOW_RCURL_RBRACK_in_synpred16_MofClass2641); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_MofClass

    // $ANTLR start synpred17_MofClass
    public final void synpred17_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:50: ( '.' )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:51: '.'
        {
        match(input,49,FOLLOW_49_in_synpred17_MofClass3107); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_MofClass

    // $ANTLR start synpred18_MofClass
    public final void synpred18_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:139: ( identifier ~ LPAREN )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:662:140: identifier ~ LPAREN
        {
        pushFollow(FOLLOW_identifier_in_synpred18_MofClass3118);
        identifier();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        if ( (input.LA(1)>=NAME && input.LA(1)<=RCURL)||(input.LA(1)>=RPAREN && input.LA(1)<=59) ) {
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
    // $ANTLR end synpred18_MofClass

    // $ANTLR start synpred19_MofClass
    public final void synpred19_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:3: ( '->' )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:664:4: '->'
        {
        match(input,48,FOLLOW_48_in_synpred19_MofClass3146); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_MofClass

    // $ANTLR start synpred20_MofClass
    public final void synpred20_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1018:4: ( ocl_expressions_collectionitem )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1018:5: ocl_expressions_collectionitem
        {
        pushFollow(FOLLOW_ocl_expressions_collectionitem_in_synpred20_MofClass4465);
        ocl_expressions_collectionitem();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_MofClass

    // $ANTLR start synpred21_MofClass
    public final void synpred21_MofClass_fragment() throws RecognitionException {   
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1019:5: ( ocl_expressions_collectionrange )
        // C:\\Users\\coretti\\Documents\\FURCAS\\furcas\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\MofClass.g:1019:6: ocl_expressions_collectionrange
        {
        pushFollow(FOLLOW_ocl_expressions_collectionrange_in_synpred21_MofClass4479);
        ocl_expressions_collectionrange();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_MofClass

    // Delegated rules

    public final boolean synpred20_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_MofClass() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_MofClass_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA12_eotS =
        "\65\uffff";
    static final String DFA12_eofS =
        "\65\uffff";
    static final String DFA12_minS =
        "\10\4\1\uffff\1\4\4\10\1\4\1\15\1\10\1\22\1\17\2\4\2\14\1\17\1"+
        "\4\1\24\1\4\1\26\1\17\2\uffff\3\4\1\10\1\4\2\10\2\4\1\10\2\22\2"+
        "\14\2\24\2\26\4\4";
    static final String DFA12_maxS =
        "\2\72\1\6\2\25\3\71\1\uffff\1\17\1\22\1\20\1\24\1\26\1\4\1\73\1"+
        "\20\2\22\2\4\1\14\1\17\1\24\1\4\1\24\1\4\2\26\2\uffff\3\4\1\20\1"+
        "\4\2\20\2\4\1\20\2\22\2\14\2\24\2\26\4\4";
    static final String DFA12_acceptS =
        "\10\uffff\1\1\24\uffff\1\2\1\1\26\uffff";
    static final String DFA12_specialS =
        "\1\1\1\0\15\uffff\1\2\45\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\4\1\uffff\1\3\1\1\40\uffff\1\5\13\uffff\1\6\2\uffff\1\7"+
            "\1\uffff\1\2\1\10",
            "\1\4\1\uffff\1\3\41\uffff\1\5\13\uffff\1\6\2\uffff\1\7\1\uffff"+
            "\1\2\1\10",
            "\1\4\1\uffff\1\3",
            "\1\17\3\uffff\1\11\2\uffff\1\13\4\uffff\1\16\1\12\1\uffff"+
            "\1\14\1\uffff\1\15",
            "\1\17\3\uffff\1\11\2\uffff\1\13\4\uffff\1\16\1\12\1\uffff"+
            "\1\14\1\uffff\1\15",
            "\1\4\1\uffff\1\3\62\uffff\1\2",
            "\1\4\1\uffff\1\3\62\uffff\1\2",
            "\1\4\1\uffff\1\3\62\uffff\1\2",
            "",
            "\1\17\12\uffff\1\20",
            "\1\22\7\uffff\1\21\1\uffff\1\23",
            "\1\26\3\uffff\1\24\3\uffff\1\25",
            "\1\27\7\uffff\1\31\3\uffff\1\30",
            "\1\34\7\uffff\1\33\5\uffff\1\32",
            "\1\17",
            "\1\35\55\uffff\1\36",
            "\1\40\7\uffff\1\37",
            "\1\41",
            "\1\42\2\uffff\1\41",
            "\1\17",
            "\1\17",
            "\1\43",
            "\1\43\2\uffff\1\44",
            "\1\45\4\uffff\1\46",
            "\1\17",
            "\1\46",
            "\1\17",
            "\1\47",
            "\1\50\6\uffff\1\47",
            "",
            "",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\52\7\uffff\1\51",
            "\1\17",
            "\1\54\7\uffff\1\53",
            "\1\56\7\uffff\1\55",
            "\1\17",
            "\1\17",
            "\1\60\7\uffff\1\57",
            "\1\61",
            "\1\61",
            "\1\62",
            "\1\62",
            "\1\63",
            "\1\63",
            "\1\64",
            "\1\64",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "402:3: ( ( model_structuralfeature )=> (ret= model_structuralfeature ) | ( model_behavioralfeature )=> (ret= model_behavioralfeature ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_1 = input.LA(1);

                         
                        int index12_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA12_1==57) ) {s = 2;}

                        else if ( (LA12_1==QNAME) ) {s = 3;}

                        else if ( (LA12_1==NAME) ) {s = 4;}

                        else if ( (LA12_1==40) ) {s = 5;}

                        else if ( (LA12_1==52) ) {s = 6;}

                        else if ( (LA12_1==55) ) {s = 7;}

                        else if ( (LA12_1==58) && (synpred1_MofClass())) {s = 8;}

                         
                        input.seek(index12_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_0 = input.LA(1);

                         
                        int index12_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA12_0==MULTI_LINE_COMMENT) ) {s = 1;}

                        else if ( (LA12_0==57) ) {s = 2;}

                        else if ( (LA12_0==QNAME) ) {s = 3;}

                        else if ( (LA12_0==NAME) ) {s = 4;}

                        else if ( (LA12_0==40) ) {s = 5;}

                        else if ( (LA12_0==52) ) {s = 6;}

                        else if ( (LA12_0==55) ) {s = 7;}

                        else if ( (LA12_0==58) && (synpred1_MofClass())) {s = 8;}

                         
                        input.seek(index12_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_15 = input.LA(1);

                         
                        int index12_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA12_15==LPAREN) && (synpred2_MofClass())) {s = 29;}

                        else if ( (LA12_15==59) && (synpred1_MofClass())) {s = 30;}

                         
                        input.seek(index12_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA29_eotS =
        "\36\uffff";
    static final String DFA29_eofS =
        "\36\uffff";
    static final String DFA29_minS =
        "\2\4\4\10\4\uffff\1\17\3\uffff\1\14\2\uffff\1\17\1\uffff\1\17\12"+
        "\uffff";
    static final String DFA29_maxS =
        "\1\25\1\17\1\22\1\20\1\24\1\26\4\uffff\1\22\3\uffff\1\17\2\uffff"+
        "\1\24\1\uffff\1\26\12\uffff";
    static final String DFA29_acceptS =
        "\6\uffff\1\6\1\17\1\1\1\6\1\uffff\1\10\1\7\1\11\1\uffff\1\12\1"+
        "\13\1\uffff\1\16\1\uffff\1\14\1\15\1\7\1\2\1\3\1\11\1\13\1\4\1\5"+
        "\1\14";
    static final String DFA29_specialS =
        "\1\11\1\0\1\6\1\5\1\7\1\10\4\uffff\1\2\3\uffff\1\1\2\uffff\1\3"+
        "\1\uffff\1\4\12\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\7\3\uffff\1\1\2\uffff\1\3\4\uffff\1\6\1\2\1\uffff\1\4\1"+
            "\uffff\1\5",
            "\1\11\12\uffff\1\10",
            "\1\12\7\uffff\1\14\1\uffff\1\13",
            "\1\16\3\uffff\1\17\3\uffff\1\15",
            "\1\21\7\uffff\1\20\3\uffff\1\22",
            "\1\23\7\uffff\1\24\5\uffff\1\25",
            "",
            "",
            "",
            "",
            "\1\27\2\uffff\1\26",
            "",
            "",
            "",
            "\1\31\2\uffff\1\30",
            "",
            "",
            "\1\33\4\uffff\1\32",
            "",
            "\1\34\6\uffff\1\35",
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

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "550:63: ( ( integerSymbol DDOT STAR | integerSymbol DDOT integerSymbol )=> ( (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol DDOT )=> ( LBRACKET (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LCURL integerSymbol DDOT )=> ( LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LBRACK_LCURL integerSymbol DDOT )=> ( LBRACK_LCURL (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK integerSymbol DDOT )=> ( LCURL_LBRACK (temp= integerSymbol ) DDOT ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( STAR | integerSymbol ~ DDOT )=> ( ( ( STAR ) | ( (temp= integerSymbol ) ) ) ) | ( LBRACKET integerSymbol RBRACKET | LBRACKET STAR RBRACKET )=> ( LBRACKET ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACKET ) | ( LBRACKET RBRACKET )=> ( LBRACKET RBRACKET ) | ( LCURL STAR RCURL | LCURL integerSymbol RCURL )=> ( LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL ) | ( LCURL RCURL )=> ( LCURL RCURL ) | ( LBRACK_LCURL STAR RCURL_RBRACK | LBRACK_LCURL integerSymbol RCURL_RBRACK )=> ( LBRACK_LCURL ( ( STAR ) | ( (temp= integerSymbol ) ) ) RCURL_RBRACK ) | ( LCURL_LBRACK STAR RBRACK_RCURL | LCURL_LBRACK integerSymbol RBRACK_RCURL )=> ( LCURL_LBRACK ( ( STAR ) | ( (temp= integerSymbol ) ) ) RBRACK_RCURL ) | ( LCURL_LBRACK RBRACK_RCURL )=> ( LCURL_LBRACK RBRACK_RCURL ) | ( LBRACK_LCURL RCURL_RBRACK )=> ( LBRACK_LCURL RCURL_RBRACK ) | () )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA29_1 = input.LA(1);

                         
                        int index29_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_1==DDOT) && (synpred3_MofClass())) {s = 8;}

                        else if ( (LA29_1==NAME) && (synpred8_MofClass())) {s = 9;}

                         
                        input.seek(index29_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA29_14 = input.LA(1);

                         
                        int index29_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_14==DDOT) && (synpred5_MofClass())) {s = 24;}

                        else if ( (LA29_14==RCURL) && (synpred11_MofClass())) {s = 25;}

                         
                        input.seek(index29_14);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA29_10 = input.LA(1);

                         
                        int index29_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_10==RBRACKET) && (synpred9_MofClass())) {s = 22;}

                        else if ( (LA29_10==DDOT) && (synpred4_MofClass())) {s = 23;}

                         
                        input.seek(index29_10);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA29_17 = input.LA(1);

                         
                        int index29_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_17==RCURL_RBRACK) && (synpred13_MofClass())) {s = 26;}

                        else if ( (LA29_17==DDOT) && (synpred6_MofClass())) {s = 27;}

                         
                        input.seek(index29_17);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA29_19 = input.LA(1);

                         
                        int index29_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_19==DDOT) && (synpred7_MofClass())) {s = 28;}

                        else if ( (LA29_19==RBRACK_RCURL) && (synpred14_MofClass())) {s = 29;}

                         
                        input.seek(index29_19);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA29_3 = input.LA(1);

                         
                        int index29_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_3==STAR) && (synpred11_MofClass())) {s = 13;}

                        else if ( (LA29_3==INT) ) {s = 14;}

                        else if ( (LA29_3==RCURL) && (synpred12_MofClass())) {s = 15;}

                         
                        input.seek(index29_3);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA29_2 = input.LA(1);

                         
                        int index29_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_2==INT) ) {s = 10;}

                        else if ( (LA29_2==RBRACKET) && (synpred10_MofClass())) {s = 11;}

                        else if ( (LA29_2==STAR) && (synpred9_MofClass())) {s = 12;}

                         
                        input.seek(index29_2);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA29_4 = input.LA(1);

                         
                        int index29_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_4==STAR) && (synpred13_MofClass())) {s = 16;}

                        else if ( (LA29_4==INT) ) {s = 17;}

                        else if ( (LA29_4==RCURL_RBRACK) && (synpred16_MofClass())) {s = 18;}

                         
                        input.seek(index29_4);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA29_5 = input.LA(1);

                         
                        int index29_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_5==INT) ) {s = 19;}

                        else if ( (LA29_5==STAR) && (synpred14_MofClass())) {s = 20;}

                        else if ( (LA29_5==RBRACK_RCURL) && (synpred15_MofClass())) {s = 21;}

                         
                        input.seek(index29_5);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA29_0 = input.LA(1);

                         
                        int index29_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA29_0==INT) ) {s = 1;}

                        else if ( (LA29_0==LBRACKET) ) {s = 2;}

                        else if ( (LA29_0==LCURL) ) {s = 3;}

                        else if ( (LA29_0==LBRACK_LCURL) ) {s = 4;}

                        else if ( (LA29_0==LCURL_LBRACK) ) {s = 5;}

                        else if ( (LA29_0==STAR) && (synpred8_MofClass())) {s = 6;}

                        else if ( (LA29_0==NAME) ) {s = 7;}

                         
                        input.seek(index29_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 29, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA34_eotS =
        "\40\uffff";
    static final String DFA34_eofS =
        "\40\uffff";
    static final String DFA34_minS =
        "\1\4\35\0\2\uffff";
    static final String DFA34_maxS =
        "\1\73\35\0\2\uffff";
    static final String DFA34_acceptS =
        "\36\uffff\1\1\1\2";
    static final String DFA34_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\32\1\33\1\34\2\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\1\33\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
            "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1"+
            "\30\1\31\1\32\1\33\1\34\1\35",
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

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "662:138: ( ( identifier ~ LPAREN )=> (ret= ocl_expressions_attributecallexp[opName, ret, firstToken] ) | (ret= ocl_expressions_operationcallexp[opName, ret, firstToken] ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_1 = input.LA(1);

                         
                        int index34_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_3 = input.LA(1);

                         
                        int index34_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA34_4 = input.LA(1);

                         
                        int index34_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA34_5 = input.LA(1);

                         
                        int index34_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA34_6 = input.LA(1);

                         
                        int index34_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA34_7 = input.LA(1);

                         
                        int index34_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA34_8 = input.LA(1);

                         
                        int index34_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA34_9 = input.LA(1);

                         
                        int index34_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA34_10 = input.LA(1);

                         
                        int index34_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA34_11 = input.LA(1);

                         
                        int index34_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA34_12 = input.LA(1);

                         
                        int index34_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA34_13 = input.LA(1);

                         
                        int index34_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA34_14 = input.LA(1);

                         
                        int index34_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA34_15 = input.LA(1);

                         
                        int index34_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA34_16 = input.LA(1);

                         
                        int index34_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA34_17 = input.LA(1);

                         
                        int index34_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA34_18 = input.LA(1);

                         
                        int index34_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA34_19 = input.LA(1);

                         
                        int index34_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA34_20 = input.LA(1);

                         
                        int index34_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA34_21 = input.LA(1);

                         
                        int index34_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA34_22 = input.LA(1);

                         
                        int index34_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA34_23 = input.LA(1);

                         
                        int index34_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA34_24 = input.LA(1);

                         
                        int index34_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA34_25 = input.LA(1);

                         
                        int index34_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA34_26 = input.LA(1);

                         
                        int index34_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA34_27 = input.LA(1);

                         
                        int index34_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA34_28 = input.LA(1);

                         
                        int index34_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA34_29 = input.LA(1);

                         
                        int index34_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_MofClass()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index34_29);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\22\uffff";
    static final String DFA42_eofS =
        "\22\uffff";
    static final String DFA42_minS =
        "\1\4\17\0\2\uffff";
    static final String DFA42_maxS =
        "\1\70\17\0\2\uffff";
    static final String DFA42_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA42_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\2\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\16\1\5\1\7\1\uffff\1\3\1\4\1\6\2\uffff\1\17\22\uffff\1\1"+
            "\4\uffff\1\2\4\uffff\1\13\1\10\2\uffff\1\15\1\12\3\uffff\1\14"+
            "\4\uffff\1\11",
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

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "1018:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_1 = input.LA(1);

                         
                        int index42_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_2 = input.LA(1);

                         
                        int index42_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_3 = input.LA(1);

                         
                        int index42_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_4 = input.LA(1);

                         
                        int index42_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_5 = input.LA(1);

                         
                        int index42_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_6 = input.LA(1);

                         
                        int index42_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_7 = input.LA(1);

                         
                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA42_8 = input.LA(1);

                         
                        int index42_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA42_9 = input.LA(1);

                         
                        int index42_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA42_10 = input.LA(1);

                         
                        int index42_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA42_11 = input.LA(1);

                         
                        int index42_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA42_12 = input.LA(1);

                         
                        int index42_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA42_13 = input.LA(1);

                         
                        int index42_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA42_14 = input.LA(1);

                         
                        int index42_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA42_15 = input.LA(1);

                         
                        int index42_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_MofClass()) ) {s = 16;}

                        else if ( (synpred21_MofClass()) ) {s = 17;}

                         
                        input.seek(index42_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_identifierOrKeyword102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_identifierOrKeyword110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_identifierOrKeyword118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_identifierOrKeyword126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_identifierOrKeyword134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_identifierOrKeyword142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_identifierOrKeyword150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_identifierOrKeyword158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_identifierOrKeyword166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_identifierOrKeyword174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_identifierOrKeyword182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_identifierOrKeyword190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_identifierOrKeyword198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_identifierOrKeyword206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_identifierOrKeyword214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_identifierOrKeyword222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_identifierOrKeyword230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_identifierOrKeyword286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_identifierOrKeyword294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_identifierOrKeyword302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_identifierOrKeyword310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_identifierOrKeyword318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qualifiedNameSymbol380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsString504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsString535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanValueSymbol597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_class_in_main656 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_class690 = new BitSet(new long[]{0x0090218000000000L});
    public static final BitSet FOLLOW_visibility_in_model_class694 = new BitSet(new long[]{0x0000208000000000L});
    public static final BitSet FOLLOW_39_in_model_class704 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_model_class722 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_class729 = new BitSet(new long[]{0x0020000000000800L});
    public static final BitSet FOLLOW_53_in_model_class741 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_model_class753 = new BitSet(new long[]{0x0000020000000800L});
    public static final BitSet FOLLOW_41_in_model_class761 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_model_class768 = new BitSet(new long[]{0x0000020000000800L});
    public static final BitSet FOLLOW_identifier_in_model_class791 = new BitSet(new long[]{0x0000020000000800L});
    public static final BitSet FOLLOW_41_in_model_class799 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_class806 = new BitSet(new long[]{0x0000020000000800L});
    public static final BitSet FOLLOW_LCURL_in_model_class836 = new BitSet(new long[]{0x06900104000010D0L});
    public static final BitSet FOLLOW_model_modelelement_in_model_class847 = new BitSet(new long[]{0x06900104000010D0L});
    public static final BitSet FOLLOW_model_modelelement_in_model_class855 = new BitSet(new long[]{0x06900104000010D0L});
    public static final BitSet FOLLOW_34_in_model_class872 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURL_in_model_class876 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_model_modelelement_invariants_in_model_class884 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_model_modelelement_invariants_in_model_class892 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_RCURL_in_model_class904 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURL_in_model_class925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_feature_in_model_modelelement987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_structuralfeature_in_model_feature1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_behavioralfeature_in_model_feature1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_attribute_in_model_structuralfeature1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_scopeandvisibility1103 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_52_in_scopeandvisibility1119 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_55_in_scopeandvisibility1135 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_scopeandvisibility1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_attribute1197 = new BitSet(new long[]{0x0690010000000050L});
    public static final BitSet FOLLOW_58_in_model_attribute1217 = new BitSet(new long[]{0x0290010000000050L});
    public static final BitSet FOLLOW_scopeandvisibility_in_model_attribute1227 = new BitSet(new long[]{0x0290010000000050L});
    public static final BitSet FOLLOW_typereference_in_model_attribute1231 = new BitSet(new long[]{0x00000000002B0910L});
    public static final BitSet FOLLOW_model_multiplicitytype_in_model_attribute1239 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_attribute1249 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_model_attribute1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_typereference1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_typereference1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_operation_in_model_behavioralfeature1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_operation1385 = new BitSet(new long[]{0x06900100000000D0L});
    public static final BitSet FOLLOW_scopeandvisibility_in_model_operation1389 = new BitSet(new long[]{0x06900100000000D0L});
    public static final BitSet FOLLOW_model_modelelement_returnType_in_model_operation1397 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_operation1407 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LPAREN_in_model_operation1414 = new BitSet(new long[]{0x02900100000040D0L});
    public static final BitSet FOLLOW_model_modelelement_parameter_in_model_operation1422 = new BitSet(new long[]{0x02900100000040D0L});
    public static final BitSet FOLLOW_model_modelelement_parameter_in_model_operation1430 = new BitSet(new long[]{0x02900100000040D0L});
    public static final BitSet FOLLOW_RPAREN_in_model_operation1442 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURL_in_model_operation1447 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_model_operation1455 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURL_in_model_operation1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_typedelement_returnType_in_model_modelelement_returnType1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_parameter_returnType_in_model_typedelement_returnType1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typereference_in_model_parameter_returnType1560 = new BitSet(new long[]{0x00000000002B0900L});
    public static final BitSet FOLLOW_model_multiplicitytype_in_model_parameter_returnType1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_typedelement_parameter_in_model_modelelement_parameter1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_parameter_parameter_in_model_typedelement_parameter1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotation_in_model_parameter_parameter1668 = new BitSet(new long[]{0x0290010000000050L});
    public static final BitSet FOLLOW_typereference_in_model_parameter_parameter1672 = new BitSet(new long[]{0x00000000002B0910L});
    public static final BitSet FOLLOW_model_multiplicitytype_in_model_parameter_parameter1680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_parameter_parameter1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1763 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1770 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype1836 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1844 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1851 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1862 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1880 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype1922 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1930 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype1937 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype1948 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype1966 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2008 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2016 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype2023 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2034 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2052 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2094 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2102 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_model_multiplicitytype2109 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2120 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2138 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype2252 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2263 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2281 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_model_multiplicitytype2321 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RBRACKET_in_model_multiplicitytype2329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype2362 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2373 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2391 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_model_multiplicitytype2431 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURL_in_model_multiplicitytype2439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2472 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2483 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2501 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2551 = new BitSet(new long[]{0x0000000000010100L});
    public static final BitSet FOLLOW_STAR_in_model_multiplicitytype2562 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_integerSymbol_in_model_multiplicitytype2580 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_model_multiplicitytype2620 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_model_multiplicitytype2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_model_multiplicitytype2651 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_model_multiplicitytype2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_model_visibilitykind2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_model_visibilitykind2729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_model_visibilitykind2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_annotationSymbol_in_annotation2774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_visibility2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_visibility2848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_visibility2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_constraint_invariants_in_model_modelelement_invariants2899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_attaching_oclconstraint_invariants_in_model_constraint_invariants2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_attaching_oclconstraint_invariants2960 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_COLON_in_ocl_attaching_oclconstraint_invariants2967 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_attaching_oclconstraint_invariants2975 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ocl_attaching_oclconstraint_invariants2983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_letexp_in_primary_ocl_expressions_oclexpression3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_ifexp_in_primary_ocl_expressions_oclexpression3031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_literalexp_in_primary_ocl_expressions_oclexpression3039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_variableexp_in_primary_ocl_expressions_oclexpression3047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression3056 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression3062 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression3066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_03104 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_49_in_oclexpressions_priority_03113 = new BitSet(new long[]{0x0FFFFFFF00000010L});
    public static final BitSet FOLLOW_ocl_expressions_attributecallexp_in_oclexpressions_priority_03127 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_operationcallexp_in_oclexpressions_priority_03136 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_48_in_oclexpressions_priority_03152 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ocl_expressions_iterateexp_in_oclexpressions_priority_03159 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_13200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_primitiveliteralexp_in_ocl_expressions_literalexp3251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_enumliteralexp_in_ocl_expressions_literalexp3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralexp_in_ocl_expressions_literalexp3267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_numericliteralexp_in_ocl_expressions_primitiveliteralexp3294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_stringliteralexp_in_ocl_expressions_primitiveliteralexp3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_booleanliteralexp_in_ocl_expressions_primitiveliteralexp3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_integerliteralexp_in_ocl_expressions_numericliteralexp3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_realliteralexp_in_ocl_expressions_numericliteralexp3345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsString_in_ocl_expressions_integerliteralexp3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_ocl_expressions_stringliteralexp3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsString_in_ocl_expressions_realliteralexp3479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValueSymbol_in_ocl_expressions_booleanliteralexp3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_expressions_enumliteralexp3579 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DCOLON_in_ocl_expressions_enumliteralexp3586 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_enumliteralexp3594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ocl_expressions_collectionliteralexp3642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_sequence_in_ocl_expressions_collectionliteralexp3649 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_56_in_ocl_expressions_collectionliteralexp3668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_set_in_ocl_expressions_collectionliteralexp3675 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_47_in_ocl_expressions_collectionliteralexp3694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_collection_in_ocl_expressions_collectionliteralexp3701 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_42_in_ocl_expressions_collectionliteralexp3720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_bag_in_ocl_expressions_collectionliteralexp3727 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_51_in_ocl_expressions_collectionliteralexp3746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_orderedset_in_ocl_expressions_collectionliteralexp3753 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURL_in_ocl_expressions_collectionliteralexp3768 = new BitSet(new long[]{0x0108CC2100003770L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_expressions_collectionliteralexp3776 = new BitSet(new long[]{0x0000020000001000L});
    public static final BitSet FOLLOW_41_in_ocl_expressions_collectionliteralexp3784 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_expressions_collectionliteralexp3791 = new BitSet(new long[]{0x0000020000001000L});
    public static final BitSet FOLLOW_RCURL_in_ocl_expressions_collectionliteralexp3803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_sequence_in_model_classifier_sequence3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_sequence_in_model_datatype_sequence3871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_sequencetype_sequence_in_ocl_types_collectiontype_sequence3898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_sequencetype_sequence3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_set_in_model_classifier_set3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_set_in_model_datatype_set3996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_settype_set_in_ocl_types_collectiontype_set4023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_settype_set4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_collection_in_model_classifier_collection4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_collection_in_model_datatype_collection4121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_collectiontype_collection4151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_bag_in_model_classifier_bag4192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_bag_in_model_datatype_bag4219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_bagtype_bag_in_ocl_types_collectiontype_bag4246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_bagtype_bag4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_orderedset_in_model_classifier_orderedset4317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_orderedset_in_model_datatype_orderedset4344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_orderedsettype_orderedset_in_ocl_types_collectiontype_orderedset4371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_orderedsettype_orderedset4401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionitem4520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionrange4570 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_ocl_expressions_collectionrange4577 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionrange4585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ocl_expressions_collectionkind4631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ocl_expressions_collectionkind4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ocl_expressions_collectionkind4647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ocl_expressions_collectionkind4655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ocl_expressions_collectionkind4663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ocl_expressions_ifexp4693 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp4700 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ocl_expressions_ifexp4706 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp4716 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ocl_expressions_ifexp4725 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp4735 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ocl_expressions_ifexp4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ocl_expressions_letexp4787 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_let_in_ocl_expressions_letexp4794 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ocl_expressions_letexp4800 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_letexp4810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variabledeclaration_let4863 = new BitSet(new long[]{0x0004000000800000L});
    public static final BitSet FOLLOW_COLON_in_ocl_expressions_variabledeclaration_let4888 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_expressions_variabledeclaration_let4896 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_COLON_in_ocl_expressions_variabledeclaration_let4913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variabledeclaration_let4921 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ocl_expressions_variabledeclaration_let4932 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_variabledeclaration_let4939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variabledeclaration4989 = new BitSet(new long[]{0x0004000000800002L});
    public static final BitSet FOLLOW_COLON_in_ocl_expressions_variabledeclaration5017 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_expressions_variabledeclaration5030 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variabledeclaration5050 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ocl_expressions_variabledeclaration5072 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_variabledeclaration5079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_self_in_ocl_expressions_variableexp5144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variableexp5164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ocl_expressions_variabledeclaration_self5215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ocl_expressions_iterateexp5259 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_expressions_iterateexp5263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp5271 = new BitSet(new long[]{0x0800004000000010L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp5279 = new BitSet(new long[]{0x0800004000000010L});
    public static final BitSet FOLLOW_59_in_ocl_expressions_iterateexp5293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp5300 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_implicitAccumulator_in_ocl_expressions_iterateexp5320 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ocl_expressions_iterateexp5331 = new BitSet(new long[]{0x0108CC2100002770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_iterateexp5338 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RPAREN_in_ocl_expressions_iterateexp5345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_expressions_attributecallexp5423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_expressions_operationcallexp5479 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_expressions_operationcallexp5486 = new BitSet(new long[]{0x0108CC2100006770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_operationcallexp5494 = new BitSet(new long[]{0x0108CC2100006770L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_operationcallexp5502 = new BitSet(new long[]{0x0108CC2100006770L});
    public static final BitSet FOLLOW_RPAREN_in_ocl_expressions_operationcallexp5514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_structuralfeature_in_synpred1_MofClass1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_behavioralfeature_in_synpred2_MofClass1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred3_MofClass1738 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_synpred3_MofClass1740 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STAR_in_synpred3_MofClass1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred3_MofClass1746 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_synpred3_MofClass1748 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred3_MofClass1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred4_MofClass1822 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred4_MofClass1824 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_synpred4_MofClass1826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred5_MofClass1908 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred5_MofClass1910 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_synpred5_MofClass1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred6_MofClass1994 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred6_MofClass1996 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_synpred6_MofClass1998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred7_MofClass2080 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred7_MofClass2082 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_synpred7_MofClass2084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred8_MofClass2166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred8_MofClass2170 = new BitSet(new long[]{0x0FFFFFFFFFFF7FF0L});
    public static final BitSet FOLLOW_set_in_synpred8_MofClass2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred9_MofClass2230 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred9_MofClass2232 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred9_MofClass2234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred9_MofClass2238 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STAR_in_synpred9_MofClass2240 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred9_MofClass2242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred10_MofClass2309 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred10_MofClass2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred11_MofClass2340 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STAR_in_synpred11_MofClass2342 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURL_in_synpred11_MofClass2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred11_MofClass2348 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred11_MofClass2350 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURL_in_synpred11_MofClass2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_synpred12_MofClass2419 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURL_in_synpred12_MofClass2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred13_MofClass2450 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STAR_in_synpred13_MofClass2452 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred13_MofClass2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred13_MofClass2458 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred13_MofClass2460 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred13_MofClass2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred14_MofClass2529 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_STAR_in_synpred14_MofClass2531 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred14_MofClass2533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred14_MofClass2537 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_integerSymbol_in_synpred14_MofClass2539 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred14_MofClass2541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_LBRACK_in_synpred15_MofClass2608 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RBRACK_RCURL_in_synpred15_MofClass2610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_LCURL_in_synpred16_MofClass2639 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RCURL_RBRACK_in_synpred16_MofClass2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred17_MofClass3107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred18_MofClass3118 = new BitSet(new long[]{0x0FFFFFFFFFFFDFF0L});
    public static final BitSet FOLLOW_set_in_synpred18_MofClass3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred19_MofClass3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_synpred20_MofClass4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionrange_in_synpred21_MofClass4479 = new BitSet(new long[]{0x0000000000000002L});

}