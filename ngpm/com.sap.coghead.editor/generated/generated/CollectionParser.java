// $ANTLR 3.1.1 C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g 2010-03-10 17:55:58

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
public class CollectionParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "DOUBLE", "BOOL", "BINARY", "DATE", "LCURL", "RCURL", "SEMICOLON", "LPAREN", "RPAREN", "LBRACKET", "DCOLON", "RBRACKET", "LANGLE", "COLON", "EQUALS", "DOT", "COMMENT", "MULTI_LINE_COMMENT", "RANGLE", "EXCL", "EQUALSEQUALS", "ASSIGN", "DDOT", "ARROW", "PIPE", "INCLUDING", "EXCLUDING", "INCLUDINGAT", "EXCLUDINGAT", "ITERATE", "LCURL_LBRACK", "LBRACK_LCURL", "RCURL_RBRACK", "RBRACK_RCURL", "STAR", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "OBJECT", "RANGE_OR_INT_OR_FLOAT_OR_DOUBLE", "'formula'", "'group'", "'collection'", "'completesIn'", "'/'", "'body'", "'subject'", "'in'", "'foreach'", "'$'", "'while'", "'unique'", "'notify'", "'void'", "'constraint'", "'break'", "'default'", "'const'", "'string'", "'timepoint'", "'duration'", "'number'", "'boolean'", "'child'", "'descendant'", "'attribute'", "'self'", "'descendant_or_self'", "'following_sibling'", "'following'", "'namespace'", "'ancestor'", "'preceding_sibling'", "'preceding'", "'ancestor_or_self'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int EXCLUDINGAT=36;
    public static final int T__67=67;
    public static final int STAR=42;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RBRACK_RCURL=41;
    public static final int LANGLE=20;
    public static final int EXCL=27;
    public static final int EQUALS=22;
    public static final int FLOAT=7;
    public static final int INCLUDINGAT=35;
    public static final int T__61=61;
    public static final int RANGE_OR_INT_OR_FLOAT_OR_DOUBLE=49;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int LPAREN=15;
    public static final int LBRACKET=17;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RPAREN=16;
    public static final int T__57=57;
    public static final int DCOLON=18;
    public static final int T__58=58;
    public static final int NAME=4;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int OBJECT=48;
    public static final int T__59=59;
    public static final int DOUBLE=8;
    public static final int LBRACK_LCURL=39;
    public static final int PIPE=32;
    public static final int DIGIT=45;
    public static final int NL=43;
    public static final int RANGLE=26;
    public static final int RBRACKET=19;
    public static final int COMMENT=24;
    public static final int DOT=23;
    public static final int T__50=50;
    public static final int RCURL_RBRACK=40;
    public static final int EQUALSEQUALS=28;
    public static final int LCURL_LBRACK=38;
    public static final int T__80=80;
    public static final int DDOT=30;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int BOOL=9;
    public static final int SEMICOLON=14;
    public static final int INT=6;
    public static final int EXCLUDING=34;
    public static final int T__84=84;
    public static final int MULTI_LINE_COMMENT=25;
    public static final int ALPHA=46;
    public static final int COLON=21;
    public static final int ITERATE=37;
    public static final int LCURL=12;
    public static final int WS=44;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int SNAME=47;
    public static final int T__70=70;
    public static final int RCURL=13;
    public static final int ASSIGN=29;
    public static final int ARROW=31;
    public static final int BINARY=10;
    public static final int DATE=11;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int INCLUDING=33;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int STRING=5;
    public static final int T__77=77;

    // delegates
    // delegators


        public CollectionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CollectionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CollectionParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g"; }


       private static final String syntaxUUID = "E0559EB2CBE844802C6511DF9275C9278D1504C0";
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:208:3: ( (ast= NAME ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:209:3: (ast= NAME )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:209:3: (ast= NAME )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:209:4: ast= NAME
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'formula' | 'group' | 'collection' | 'completesIn' | '/' | 'body' | 'subject' | 'in' | 'foreach' | '$' | 'while' | 'unique' | 'notify' | 'void' | 'constraint' | 'break' | 'default' | 'const' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:218:3: ( (ast= NAME | 'formula' | 'group' | 'collection' | 'completesIn' | '/' | 'body' | 'subject' | 'in' | 'foreach' | '$' | 'while' | 'unique' | 'notify' | 'void' | 'constraint' | 'break' | 'default' | 'const' ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:219:3: (ast= NAME | 'formula' | 'group' | 'collection' | 'completesIn' | '/' | 'body' | 'subject' | 'in' | 'foreach' | '$' | 'while' | 'unique' | 'notify' | 'void' | 'constraint' | 'break' | 'default' | 'const' )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:219:3: (ast= NAME | 'formula' | 'group' | 'collection' | 'completesIn' | '/' | 'body' | 'subject' | 'in' | 'foreach' | '$' | 'while' | 'unique' | 'notify' | 'void' | 'constraint' | 'break' | 'default' | 'const' )
            int alt1=19;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 50:
                {
                alt1=2;
                }
                break;
            case 51:
                {
                alt1=3;
                }
                break;
            case 52:
                {
                alt1=4;
                }
                break;
            case 53:
                {
                alt1=5;
                }
                break;
            case 54:
                {
                alt1=6;
                }
                break;
            case 55:
                {
                alt1=7;
                }
                break;
            case 56:
                {
                alt1=8;
                }
                break;
            case 57:
                {
                alt1=9;
                }
                break;
            case 58:
                {
                alt1=10;
                }
                break;
            case 59:
                {
                alt1=11;
                }
                break;
            case 60:
                {
                alt1=12;
                }
                break;
            case 61:
                {
                alt1=13;
                }
                break;
            case 62:
                {
                alt1=14;
                }
                break;
            case 63:
                {
                alt1=15;
                }
                break;
            case 64:
                {
                alt1=16;
                }
                break;
            case 65:
                {
                alt1=17;
                }
                break;
            case 66:
                {
                alt1=18;
                }
                break;
            case 67:
                {
                alt1=19;
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:219:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword94); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:221:5: 'formula'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword102); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "formula";
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:222:5: 'group'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword110); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "group";
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:223:5: 'collection'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword118); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "collection";
                    }

                    }
                    break;
                case 5 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:224:5: 'completesIn'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword126); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "completesIn";
                    }

                    }
                    break;
                case 6 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:225:5: '/'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword134); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "/";
                    }

                    }
                    break;
                case 7 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:226:5: 'body'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword142); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "body";
                    }

                    }
                    break;
                case 8 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:227:5: 'subject'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword150); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "subject";
                    }

                    }
                    break;
                case 9 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:228:5: 'in'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword158); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 10 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:229:5: 'foreach'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword166); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 11 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:230:5: '$'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword174); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "$";
                    }

                    }
                    break;
                case 12 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:231:5: 'while'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword182); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "while";
                    }

                    }
                    break;
                case 13 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:232:5: 'unique'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword190); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "unique";
                    }

                    }
                    break;
                case 14 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:233:5: 'notify'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword198); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "notify";
                    }

                    }
                    break;
                case 15 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:234:5: 'void'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword206); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "void";
                    }

                    }
                    break;
                case 16 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:235:5: 'constraint'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword214); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "constraint";
                    }

                    }
                    break;
                case 17 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:236:5: 'break'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword222); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "break";
                    }

                    }
                    break;
                case 18 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:237:5: 'default'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword230); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "default";
                    }

                    }
                    break;
                case 19 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:238:5: 'const'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword238); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "const";
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:245:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:246:3: ( (ast= STRING ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:247:3: (ast= STRING )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:247:3: (ast= STRING )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:247:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol269); if (state.failed) return ret2;
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:255:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:256:3: ( (ast= INT ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:257:3: (ast= INT )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:257:3: (ast= INT )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:257:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol300); if (state.failed) return ret2;
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:265:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:266:3: ( (ast= INT ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:267:3: (ast= INT )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:267:3: (ast= INT )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:267:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol331); if (state.failed) return ret2;
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:275:1: integerAsStringSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:276:3: ( (ast= INT ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:277:3: (ast= INT )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:277:3: (ast= INT )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:277:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsStringSymbol362); if (state.failed) return ret2;
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:285:1: floatAsStringSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:286:3: ( (ast= FLOAT ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:287:3: (ast= FLOAT )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:287:3: (ast= FLOAT )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:287:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsStringSymbol393); if (state.failed) return ret2;
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


    // $ANTLR start "doubleAsStringSymbol"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:295:1: doubleAsStringSymbol returns [Object ret2] : (ast= DOUBLE ) ;
    public final Object doubleAsStringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:296:3: ( (ast= DOUBLE ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:297:3: (ast= DOUBLE )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:297:3: (ast= DOUBLE )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:297:4: ast= DOUBLE
            {
            ast=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_doubleAsStringSymbol424); if (state.failed) return ret2;
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
    // $ANTLR end "doubleAsStringSymbol"


    // $ANTLR start "booleanSymbol"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:305:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:306:3: ( (ast= BOOL ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:307:3: (ast= BOOL )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:307:3: (ast= BOOL )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:307:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol455); if (state.failed) return ret2;
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:315:1: binarySymbol returns [Object ret2] : (ast= BINARY ) ;
    public final Object binarySymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:316:3: ( (ast= BINARY ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:317:3: (ast= BINARY )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:317:3: (ast= BINARY )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:317:4: ast= BINARY
            {
            ast=(Token)match(input,BINARY,FOLLOW_BINARY_in_binarySymbol486); if (state.failed) return ret2;
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
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:325:1: dateSymbol returns [Object ret2] : (ast= DATE ) ;
    public final Object dateSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:326:3: ( (ast= DATE ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:327:3: (ast= DATE )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:327:3: (ast= DATE )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:327:4: ast= DATE
            {
            ast=(Token)match(input,DATE,FOLLOW_DATE_in_dateSymbol517); if (state.failed) return ret2;
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


    // $ANTLR start "coghead_elementarytypeenum"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:335:1: coghead_elementarytypeenum returns [Object ret2] : ( ( 'string' ) | ( 'timepoint' ) | ( 'duration' ) | ( 'number' ) | ( 'boolean' ) ) ;
    public final Object coghead_elementarytypeenum() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:336:3: ( ( ( 'string' ) | ( 'timepoint' ) | ( 'duration' ) | ( 'number' ) | ( 'boolean' ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:337:3: ( ( 'string' ) | ( 'timepoint' ) | ( 'duration' ) | ( 'number' ) | ( 'boolean' ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:337:3: ( ( 'string' ) | ( 'timepoint' ) | ( 'duration' ) | ( 'number' ) | ( 'boolean' ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt2=1;
                }
                break;
            case 69:
                {
                alt2=2;
                }
                break;
            case 70:
                {
                alt2=3;
                }
                break;
            case 71:
                {
                alt2=4;
                }
                break;
            case 72:
                {
                alt2=5;
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:337:4: ( 'string' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:337:4: ( 'string' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:337:5: 'string'
                    {
                    match(input,68,FOLLOW_68_in_coghead_elementarytypeenum547); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","ElementaryTypeEnum"), "string");
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:338:4: ( 'timepoint' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:338:4: ( 'timepoint' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:338:5: 'timepoint'
                    {
                    match(input,69,FOLLOW_69_in_coghead_elementarytypeenum555); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","ElementaryTypeEnum"), "timepoint");
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:339:4: ( 'duration' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:339:4: ( 'duration' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:339:5: 'duration'
                    {
                    match(input,70,FOLLOW_70_in_coghead_elementarytypeenum563); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","ElementaryTypeEnum"), "duration");
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:340:4: ( 'number' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:340:4: ( 'number' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:340:5: 'number'
                    {
                    match(input,71,FOLLOW_71_in_coghead_elementarytypeenum571); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","ElementaryTypeEnum"), "number");
                    }

                    }
                    break;
                case 5 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:341:4: ( 'boolean' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:341:4: ( 'boolean' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:341:5: 'boolean'
                    {
                    match(input,72,FOLLOW_72_in_coghead_elementarytypeenum579); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","ElementaryTypeEnum"), "boolean");
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
    // $ANTLR end "coghead_elementarytypeenum"


    // $ANTLR start "coghead_xpath_axis"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:348:1: coghead_xpath_axis returns [Object ret2] : ( ( 'child' ) | ( 'descendant' ) | ( 'attribute' ) | ( 'self' ) | ( 'descendant_or_self' ) | ( 'following_sibling' ) | ( 'following' ) | ( 'namespace' ) | ( 'ancestor' ) | ( 'preceding_sibling' ) | ( 'preceding' ) | ( 'ancestor_or_self' ) ) ;
    public final Object coghead_xpath_axis() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:349:3: ( ( ( 'child' ) | ( 'descendant' ) | ( 'attribute' ) | ( 'self' ) | ( 'descendant_or_self' ) | ( 'following_sibling' ) | ( 'following' ) | ( 'namespace' ) | ( 'ancestor' ) | ( 'preceding_sibling' ) | ( 'preceding' ) | ( 'ancestor_or_self' ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:350:3: ( ( 'child' ) | ( 'descendant' ) | ( 'attribute' ) | ( 'self' ) | ( 'descendant_or_self' ) | ( 'following_sibling' ) | ( 'following' ) | ( 'namespace' ) | ( 'ancestor' ) | ( 'preceding_sibling' ) | ( 'preceding' ) | ( 'ancestor_or_self' ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:350:3: ( ( 'child' ) | ( 'descendant' ) | ( 'attribute' ) | ( 'self' ) | ( 'descendant_or_self' ) | ( 'following_sibling' ) | ( 'following' ) | ( 'namespace' ) | ( 'ancestor' ) | ( 'preceding_sibling' ) | ( 'preceding' ) | ( 'ancestor_or_self' ) )
            int alt3=12;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt3=1;
                }
                break;
            case 74:
                {
                alt3=2;
                }
                break;
            case 75:
                {
                alt3=3;
                }
                break;
            case 76:
                {
                alt3=4;
                }
                break;
            case 77:
                {
                alt3=5;
                }
                break;
            case 78:
                {
                alt3=6;
                }
                break;
            case 79:
                {
                alt3=7;
                }
                break;
            case 80:
                {
                alt3=8;
                }
                break;
            case 81:
                {
                alt3=9;
                }
                break;
            case 82:
                {
                alt3=10;
                }
                break;
            case 83:
                {
                alt3=11;
                }
                break;
            case 84:
                {
                alt3=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:350:4: ( 'child' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:350:4: ( 'child' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:350:5: 'child'
                    {
                    match(input,73,FOLLOW_73_in_coghead_xpath_axis609); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "child");
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:351:4: ( 'descendant' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:351:4: ( 'descendant' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:351:5: 'descendant'
                    {
                    match(input,74,FOLLOW_74_in_coghead_xpath_axis617); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "descendant");
                    }

                    }
                    break;
                case 3 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:352:4: ( 'attribute' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:352:4: ( 'attribute' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:352:5: 'attribute'
                    {
                    match(input,75,FOLLOW_75_in_coghead_xpath_axis625); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "attribute");
                    }

                    }
                    break;
                case 4 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:353:4: ( 'self' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:353:4: ( 'self' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:353:5: 'self'
                    {
                    match(input,76,FOLLOW_76_in_coghead_xpath_axis633); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "self");
                    }

                    }
                    break;
                case 5 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:354:4: ( 'descendant_or_self' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:354:4: ( 'descendant_or_self' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:354:5: 'descendant_or_self'
                    {
                    match(input,77,FOLLOW_77_in_coghead_xpath_axis641); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "descendant_or_self");
                    }

                    }
                    break;
                case 6 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:355:4: ( 'following_sibling' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:355:4: ( 'following_sibling' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:355:5: 'following_sibling'
                    {
                    match(input,78,FOLLOW_78_in_coghead_xpath_axis649); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "following_sibling");
                    }

                    }
                    break;
                case 7 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:356:4: ( 'following' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:356:4: ( 'following' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:356:5: 'following'
                    {
                    match(input,79,FOLLOW_79_in_coghead_xpath_axis657); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "following");
                    }

                    }
                    break;
                case 8 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:357:4: ( 'namespace' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:357:4: ( 'namespace' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:357:5: 'namespace'
                    {
                    match(input,80,FOLLOW_80_in_coghead_xpath_axis665); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "namespace");
                    }

                    }
                    break;
                case 9 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:358:4: ( 'ancestor' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:358:4: ( 'ancestor' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:358:5: 'ancestor'
                    {
                    match(input,81,FOLLOW_81_in_coghead_xpath_axis673); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "ancestor");
                    }

                    }
                    break;
                case 10 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:359:4: ( 'preceding_sibling' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:359:4: ( 'preceding_sibling' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:359:5: 'preceding_sibling'
                    {
                    match(input,82,FOLLOW_82_in_coghead_xpath_axis681); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "preceding_sibling");
                    }

                    }
                    break;
                case 11 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:360:4: ( 'preceding' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:360:4: ( 'preceding' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:360:5: 'preceding'
                    {
                    match(input,83,FOLLOW_83_in_coghead_xpath_axis689); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "preceding");
                    }

                    }
                    break;
                case 12 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:361:4: ( 'ancestor_or_self' )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:361:4: ( 'ancestor_or_self' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:361:5: 'ancestor_or_self'
                    {
                    match(input,84,FOLLOW_84_in_coghead_xpath_axis697); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("coghead","xpath","Axis"), "ancestor_or_self");
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
    // $ANTLR end "coghead_xpath_axis"


    // $ANTLR start "main"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:368:1: main returns [Object ret2] : ( (ret= coghead_collection ) EOF ) ;
    public final Object main() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:369:3: ( ( (ret= coghead_collection ) EOF ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:370:3: ( (ret= coghead_collection ) EOF )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:370:3: ( (ret= coghead_collection ) EOF )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:370:4: (ret= coghead_collection ) EOF
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:370:4: (ret= coghead_collection )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:370:5: ret= coghead_collection
            {
            pushFollow(FOLLOW_coghead_collection_in_main725);
            ret=coghead_collection();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main728); if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

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


    // $ANTLR start "coghead_collection"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:377:1: coghead_collection returns [Object ret2] : ( 'collection' (temp= identifier ) LCURL (temp= coghead_schema ) (temp= coghead_action_action (temp= coghead_action_action )* )? RCURL ) ;
    public final Object coghead_collection() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","Collection");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"env"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:382:3: ( ( 'collection' (temp= identifier ) LCURL (temp= coghead_schema ) (temp= coghead_action_action (temp= coghead_action_action )* )? RCURL ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:3: ( 'collection' (temp= identifier ) LCURL (temp= coghead_schema ) (temp= coghead_action_action (temp= coghead_action_action )* )? RCURL )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:3: ( 'collection' (temp= identifier ) LCURL (temp= coghead_schema ) (temp= coghead_action_action (temp= coghead_action_action )* )? RCURL )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:4: 'collection' (temp= identifier ) LCURL (temp= coghead_schema ) (temp= coghead_action_action (temp= coghead_action_action )* )? RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBACE9302C6511DFB7ACC9278D1504C0");
            }
            match(input,52,FOLLOW_52_in_coghead_collection759); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBACE9322C6511DF990FC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:150: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:152: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_collection766);
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
              _beforeSeqEl("E0559EB2CBAD10402C6511DFBC46C9278D1504C0");
            }
            match(input,LCURL,FOLLOW_LCURL_in_coghead_collection773); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBAD37502C6511DF8618C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:359: (temp= coghead_schema )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:361: temp= coghead_schema
            {
            pushFollow(FOLLOW_coghead_schema_in_coghead_collection781);
            temp=coghead_schema();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "schema", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBAD5E622C6511DF83FEC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:492: (temp= coghead_action_action (temp= coghead_action_action )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NAME||(LA5_0>=52 && LA5_0<=53)||LA5_0==67) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:494: temp= coghead_action_action (temp= coghead_action_action )*
                    {
                    pushFollow(FOLLOW_coghead_action_action_in_coghead_collection791);
                    temp=coghead_action_action();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "actions", temp);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:558: (temp= coghead_action_action )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==NAME||(LA4_0>=52 && LA4_0<=53)||LA4_0==67) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:383:560: temp= coghead_action_action
                    	    {
                    	    pushFollow(FOLLOW_coghead_action_action_in_coghead_collection799);
                    	    temp=coghead_action_action();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "actions", temp);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBAD85702C6511DF96E1C9278D1504C0");
            }
            match(input,RCURL,FOLLOW_RCURL_in_coghead_collection811); if (state.failed) return ret2;
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
    // $ANTLR end "coghead_collection"


    // $ANTLR start "coghead_schema"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:391:1: coghead_schema returns [Object ret2] : ( (temp= coghead_schemaentry ( ( SEMICOLON ) temp= coghead_schemaentry )* )? ( ( SEMICOLON ) | ) ) ;
    public final Object coghead_schema() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","Schema");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:396:3: ( ( (temp= coghead_schemaentry ( ( SEMICOLON ) temp= coghead_schemaentry )* )? ( ( SEMICOLON ) | ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:3: ( (temp= coghead_schemaentry ( ( SEMICOLON ) temp= coghead_schemaentry )* )? ( ( SEMICOLON ) | ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:3: ( (temp= coghead_schemaentry ( ( SEMICOLON ) temp= coghead_schemaentry )* )? ( ( SEMICOLON ) | ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:4: (temp= coghead_schemaentry ( ( SEMICOLON ) temp= coghead_schemaentry )* )? ( ( SEMICOLON ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBAE96E02C6511DFB2DCC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:63: (temp= coghead_schemaentry ( ( SEMICOLON ) temp= coghead_schemaentry )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==51||LA7_0==61||(LA7_0>=68 && LA7_0<=72)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:65: temp= coghead_schemaentry ( ( SEMICOLON ) temp= coghead_schemaentry )*
                    {
                    pushFollow(FOLLOW_coghead_schemaentry_in_coghead_schema856);
                    temp=coghead_schemaentry();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "entries", temp);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:127: ( ( SEMICOLON ) temp= coghead_schemaentry )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==SEMICOLON) ) {
                            int LA6_1 = input.LA(2);

                            if ( (LA6_1==51||LA6_1==61||(LA6_1>=68 && LA6_1<=72)) ) {
                                alt6=1;
                            }


                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:128: ( SEMICOLON ) temp= coghead_schemaentry
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:145: ( SEMICOLON )
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:146: SEMICOLON
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0559EB2CBAE6FD12C6511DF92B1C9278D1504C0");
                    	    }
                    	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_schema865); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_coghead_schemaentry_in_coghead_schema873);
                    	    temp=coghead_schemaentry();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "entries", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBAEE5002C6511DFBB3FC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:393: ( ( SEMICOLON ) | )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==SEMICOLON) ) {
                alt8=1;
            }
            else if ( (LA8_0==NAME||LA8_0==RCURL||(LA8_0>=52 && LA8_0<=53)||LA8_0==67) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:394: ( SEMICOLON )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:410: ( SEMICOLON )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:411: SEMICOLON
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBAEBDF12C6511DFA3F4C9278D1504C0");
                    }
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_schema891); if (state.failed) return ret2;
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:397:515: 
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
    // $ANTLR end "coghead_schema"


    // $ANTLR start "coghead_schemaentry"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:406:1: coghead_schemaentry returns [Object ret2] : (ret= coghead_fieldgroup | ret= coghead_field ) ;
    public final Object coghead_schemaentry() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:407:3: ( (ret= coghead_fieldgroup | ret= coghead_field ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:408:3: (ret= coghead_fieldgroup | ret= coghead_field )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:408:3: (ret= coghead_fieldgroup | ret= coghead_field )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==51) ) {
                alt9=1;
            }
            else if ( (LA9_0==61||(LA9_0>=68 && LA9_0<=72)) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:408:4: ret= coghead_fieldgroup
                    {
                    pushFollow(FOLLOW_coghead_fieldgroup_in_coghead_schemaentry942);
                    ret=coghead_fieldgroup();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:409:5: ret= coghead_field
                    {
                    pushFollow(FOLLOW_coghead_field_in_coghead_schemaentry950);
                    ret=coghead_field();

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
    // $ANTLR end "coghead_schemaentry"


    // $ANTLR start "coghead_fieldgroup"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:416:1: coghead_fieldgroup returns [Object ret2] : ( 'group' cardinality[ret] (temp= identifier ) LCURL (temp= coghead_field_inFieldGroup ( ( SEMICOLON ) temp= coghead_field_inFieldGroup )* )? RCURL ) ;
    public final Object coghead_fieldgroup() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","FieldGroup");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"FieldGroup"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:421:3: ( ( 'group' cardinality[ret] (temp= identifier ) LCURL (temp= coghead_field_inFieldGroup ( ( SEMICOLON ) temp= coghead_field_inFieldGroup )* )? RCURL ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:3: ( 'group' cardinality[ret] (temp= identifier ) LCURL (temp= coghead_field_inFieldGroup ( ( SEMICOLON ) temp= coghead_field_inFieldGroup )* )? RCURL )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:3: ( 'group' cardinality[ret] (temp= identifier ) LCURL (temp= coghead_field_inFieldGroup ( ( SEMICOLON ) temp= coghead_field_inFieldGroup )* )? RCURL )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:4: 'group' cardinality[ret] (temp= identifier ) LCURL (temp= coghead_field_inFieldGroup ( ( SEMICOLON ) temp= coghead_field_inFieldGroup )* )? RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB01D802C6511DFCB7BC9278D1504C0");
            }
            match(input,51,FOLLOW_51_in_coghead_fieldgroup980); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB01D812C6511DFB51EC9278D1504C0");
            }
            pushFollow(FOLLOW_cardinality_in_coghead_fieldgroup983);
            cardinality(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB01D832C6511DF9B4FC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:236: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:238: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_fieldgroup991);
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
              _beforeSeqEl("E0559EB2CBB01D842C6511DF816BC9278D1504C0");
            }
            match(input,LCURL,FOLLOW_LCURL_in_coghead_fieldgroup998); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB06BA02C6511DFCA78C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:445: (temp= coghead_field_inFieldGroup ( ( SEMICOLON ) temp= coghead_field_inFieldGroup )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==61||(LA11_0>=68 && LA11_0<=72)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:447: temp= coghead_field_inFieldGroup ( ( SEMICOLON ) temp= coghead_field_inFieldGroup )*
                    {
                    pushFollow(FOLLOW_coghead_field_inFieldGroup_in_coghead_fieldgroup1006);
                    temp=coghead_field_inFieldGroup();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "fields", temp);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:515: ( ( SEMICOLON ) temp= coghead_field_inFieldGroup )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==SEMICOLON) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:516: ( SEMICOLON ) temp= coghead_field_inFieldGroup
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:533: ( SEMICOLON )
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:422:534: SEMICOLON
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0559EB2CBB044912C6511DFBC84C9278D1504C0");
                    	    }
                    	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_fieldgroup1015); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_coghead_field_inFieldGroup_in_coghead_fieldgroup1023);
                    	    temp=coghead_field_inFieldGroup();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "fields", temp);
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
              _beforeSeqEl("E0559EB2CBB06BA12C6511DFCC6BC9278D1504C0");
            }
            match(input,RCURL,FOLLOW_RCURL_in_coghead_fieldgroup1035); if (state.failed) return ret2;
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
    // $ANTLR end "coghead_fieldgroup"


    // $ANTLR start "coghead_field"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:430:1: coghead_field returns [Object ret2] : ( ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | ) ) ;
    public final Object coghead_field() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","Field");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:435:3: ( ( ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:436:3: ( ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:436:3: ( ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:436:4: ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB156022C6511DF8C0CC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:436:64: ( ( 'unique' ) | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==61) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=68 && LA12_0<=72)) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:436:65: ( 'unique' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:436:81: ( 'unique' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:436:82: 'unique'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB156002C6511DFC95DC9278D1504C0");
                    }
                    match(input,61,FOLLOW_61_in_coghead_field1082); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "unique", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:436:236: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "unique", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E0559EB2CBB17D112C6511DFCAEFC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:76: (temp= coghead_elementarytypeenum )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:78: temp= coghead_elementarytypeenum
            {
            pushFollow(FOLLOW_coghead_elementarytypeenum_in_coghead_field1104);
            temp=coghead_elementarytypeenum();

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
              _beforeSeqEl("E0559EB2CBB17D122C6511DFA585C9278D1504C0");
            }
            pushFollow(FOLLOW_cardinality_in_coghead_field1110);
            cardinality(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB17D142C6511DFB36CC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:310: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:312: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_field1118);
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
              _beforeSeqEl("E0559EB2CBB1CB312C6511DFB6F0C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:438: ( ( 'default' (temp= coghead_expression ) ) | )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==66) ) {
                alt13=1;
            }
            else if ( (LA13_0==NAME||(LA13_0>=RCURL && LA13_0<=SEMICOLON)||LA13_0==50||(LA13_0>=52 && LA13_0<=53)||LA13_0==64||LA13_0==67) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:439: ( 'default' (temp= coghead_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:455: ( 'default' (temp= coghead_expression ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:456: 'default' (temp= coghead_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB1A4232C6511DFA380C9278D1504C0");
                    }
                    match(input,66,FOLLOW_66_in_coghead_field1130); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB1A4252C6511DFC859C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:599: (temp= coghead_expression )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:601: temp= coghead_expression
                    {
                    pushFollow(FOLLOW_coghead_expression_in_coghead_field1137);
                    temp=coghead_expression();

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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:437:701: 
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
              _beforeSeqEl("E0559EB2CBB219542C6511DF96FBC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:438:77: ( ( 'formula' (temp= coghead_expression ) ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==50) ) {
                alt14=1;
            }
            else if ( (LA14_0==NAME||(LA14_0>=RCURL && LA14_0<=SEMICOLON)||(LA14_0>=52 && LA14_0<=53)||LA14_0==64||LA14_0==67) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:438:78: ( 'formula' (temp= coghead_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:438:94: ( 'formula' (temp= coghead_expression ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:438:95: 'formula' (temp= coghead_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB219502C6511DFC0C3C9278D1504C0");
                    }
                    match(input,50,FOLLOW_50_in_coghead_field1162); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB219522C6511DF9353C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:438:238: (temp= coghead_expression )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:438:240: temp= coghead_expression
                    {
                    pushFollow(FOLLOW_coghead_expression_in_coghead_field1169);
                    temp=coghead_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "formula", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:438:335: 
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
              _beforeSeqEl("E0559EB2CBB28E802C6511DFB4DBC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:439:77: ( ( 'constraint' (temp= coghead_expression ) ) | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==64) ) {
                alt15=1;
            }
            else if ( (LA15_0==NAME||(LA15_0>=RCURL && LA15_0<=SEMICOLON)||(LA15_0>=52 && LA15_0<=53)||LA15_0==67) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:439:78: ( 'constraint' (temp= coghead_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:439:94: ( 'constraint' (temp= coghead_expression ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:439:95: 'constraint' (temp= coghead_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB267702C6511DFBF2DC9278D1504C0");
                    }
                    match(input,64,FOLLOW_64_in_coghead_field1194); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB267722C6511DFA494C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:439:241: (temp= coghead_expression )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:439:243: temp= coghead_expression
                    {
                    pushFollow(FOLLOW_coghead_expression_in_coghead_field1201);
                    temp=coghead_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "constraint", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:439:341: 
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
    // $ANTLR end "coghead_field"


    // $ANTLR start "coghead_field_inFieldGroup"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:448:1: coghead_field_inFieldGroup returns [Object ret2] : ( ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | ) ) ;
    public final Object coghead_field_inFieldGroup() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","Field");
        onEnterTemplateRule(metaType,"inFieldGroup");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:453:3: ( ( ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:454:3: ( ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:454:3: ( ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:454:4: ( ( 'unique' ) | ) (temp= coghead_elementarytypeenum ) cardinality[ret] (temp= identifier ) ( ( 'default' (temp= coghead_expression ) ) | ) ( ( 'formula' (temp= coghead_expression ) ) | ) ( ( 'constraint' (temp= coghead_expression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB378E02C6511DFBE15C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:454:64: ( ( 'unique' ) | )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==61) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=68 && LA16_0<=72)) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:454:65: ( 'unique' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:454:81: ( 'unique' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:454:82: 'unique'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB351D32C6511DFC522C9278D1504C0");
                    }
                    match(input,61,FOLLOW_61_in_coghead_field_inFieldGroup1263); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "unique", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:454:236: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "unique", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E0559EB2CBB39FF02C6511DFC884C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:76: (temp= coghead_elementarytypeenum )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:78: temp= coghead_elementarytypeenum
            {
            pushFollow(FOLLOW_coghead_elementarytypeenum_in_coghead_field_inFieldGroup1285);
            temp=coghead_elementarytypeenum();

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
              _beforeSeqEl("E0559EB2CBB39FF12C6511DFB062C9278D1504C0");
            }
            pushFollow(FOLLOW_cardinality_in_coghead_field_inFieldGroup1291);
            cardinality(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB39FF32C6511DFA299C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:310: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:312: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_field_inFieldGroup1299);
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
              _beforeSeqEl("E0559EB2CBB3C7012C6511DF961FC9278D1504C0");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "schema", null, null, "OCL:#context(FieldGroup).oclAsType(FieldGroup).schema", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBB415202C6511DFBBE0C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:637: ( ( 'default' (temp= coghead_expression ) ) | )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==66) ) {
                alt17=1;
            }
            else if ( ((LA17_0>=RCURL && LA17_0<=SEMICOLON)||LA17_0==50||LA17_0==64) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:638: ( 'default' (temp= coghead_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:654: ( 'default' (temp= coghead_expression ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:655: 'default' (temp= coghead_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB3EE112C6511DFAEF2C9278D1504C0");
                    }
                    match(input,66,FOLLOW_66_in_coghead_field_inFieldGroup1314); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB3EE132C6511DF98A7C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:798: (temp= coghead_expression )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:800: temp= coghead_expression
                    {
                    pushFollow(FOLLOW_coghead_expression_in_coghead_field_inFieldGroup1321);
                    temp=coghead_expression();

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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:455:900: 
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
              _beforeSeqEl("E0559EB2CBB463402C6511DFA271C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:456:77: ( ( 'formula' (temp= coghead_expression ) ) | )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==50) ) {
                alt18=1;
            }
            else if ( ((LA18_0>=RCURL && LA18_0<=SEMICOLON)||LA18_0==64) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:456:78: ( 'formula' (temp= coghead_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:456:94: ( 'formula' (temp= coghead_expression ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:456:95: 'formula' (temp= coghead_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB43C312C6511DF99B1C9278D1504C0");
                    }
                    match(input,50,FOLLOW_50_in_coghead_field_inFieldGroup1346); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB43C332C6511DF9075C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:456:238: (temp= coghead_expression )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:456:240: temp= coghead_expression
                    {
                    pushFollow(FOLLOW_coghead_expression_in_coghead_field_inFieldGroup1353);
                    temp=coghead_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "formula", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:456:335: 
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
              _beforeSeqEl("E0559EB2CBB4B1612C6511DF9B9FC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:457:77: ( ( 'constraint' (temp= coghead_expression ) ) | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==64) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=RCURL && LA19_0<=SEMICOLON)) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:457:78: ( 'constraint' (temp= coghead_expression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:457:94: ( 'constraint' (temp= coghead_expression ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:457:95: 'constraint' (temp= coghead_expression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB48A512C6511DFB39FC9278D1504C0");
                    }
                    match(input,64,FOLLOW_64_in_coghead_field_inFieldGroup1378); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBB48A532C6511DFA82BC9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:457:241: (temp= coghead_expression )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:457:243: temp= coghead_expression
                    {
                    pushFollow(FOLLOW_coghead_expression_in_coghead_field_inFieldGroup1385);
                    temp=coghead_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "constraint", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:457:341: 
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
    // $ANTLR end "coghead_field_inFieldGroup"


    // $ANTLR start "coghead_expression"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:466:1: coghead_expression returns [Object ret2] : (ret= coghead_xpath_xpathexpression ) ;
    public final Object coghead_expression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:467:3: ( (ret= coghead_xpath_xpathexpression ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:468:3: (ret= coghead_xpath_xpathexpression )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:468:3: (ret= coghead_xpath_xpathexpression )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:468:4: ret= coghead_xpath_xpathexpression
            {
            pushFollow(FOLLOW_coghead_xpath_xpathexpression_in_coghead_expression1438);
            ret=coghead_xpath_xpathexpression();

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
    // $ANTLR end "coghead_expression"


    // $ANTLR start "primary_coghead_xpath_xpathexpression"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:475:1: primary_coghead_xpath_xpathexpression returns [Object ret2] : (ret= coghead_xpath_literal | ret= coghead_xpath_variableref | ret= coghead_xpath_axisstep | ( LPAREN ret= coghead_xpath_xpathexpression RPAREN ) ) ;
    public final Object primary_coghead_xpath_xpathexpression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:476:3: ( (ret= coghead_xpath_literal | ret= coghead_xpath_variableref | ret= coghead_xpath_axisstep | ( LPAREN ret= coghead_xpath_xpathexpression RPAREN ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:477:3: (ret= coghead_xpath_literal | ret= coghead_xpath_variableref | ret= coghead_xpath_axisstep | ( LPAREN ret= coghead_xpath_xpathexpression RPAREN ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:477:3: (ret= coghead_xpath_literal | ret= coghead_xpath_variableref | ret= coghead_xpath_axisstep | ( LPAREN ret= coghead_xpath_xpathexpression RPAREN ) )
            int alt20=4;
            switch ( input.LA(1) ) {
            case STRING:
            case INT:
            case FLOAT:
            case DOUBLE:
                {
                alt20=1;
                }
                break;
            case 59:
                {
                alt20=2;
                }
                break;
            case NAME:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
                {
                alt20=3;
                }
                break;
            case LPAREN:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:477:4: ret= coghead_xpath_literal
                    {
                    pushFollow(FOLLOW_coghead_xpath_literal_in_primary_coghead_xpath_xpathexpression1465);
                    ret=coghead_xpath_literal();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:478:5: ret= coghead_xpath_variableref
                    {
                    pushFollow(FOLLOW_coghead_xpath_variableref_in_primary_coghead_xpath_xpathexpression1473);
                    ret=coghead_xpath_variableref();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:479:5: ret= coghead_xpath_axisstep
                    {
                    pushFollow(FOLLOW_coghead_xpath_axisstep_in_primary_coghead_xpath_xpathexpression1481);
                    ret=coghead_xpath_axisstep();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:480:5: ( LPAREN ret= coghead_xpath_xpathexpression RPAREN )
                    {
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:480:5: ( LPAREN ret= coghead_xpath_xpathexpression RPAREN )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:480:6: LPAREN ret= coghead_xpath_xpathexpression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_coghead_xpath_xpathexpression1490); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_coghead_xpath_xpathexpression_in_primary_coghead_xpath_xpathexpression1496);
                    ret=coghead_xpath_xpathexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_coghead_xpath_xpathexpression1500); if (state.failed) return ret2;
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
    // $ANTLR end "primary_coghead_xpath_xpathexpression"


    // $ANTLR start "xpathexpressions_priority_0"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:487:1: xpathexpressions_priority_0 returns [Object ret2] : ( (ret= primary_coghead_xpath_xpathexpression ( ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object xpathexpressions_priority_0() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:488:3: ( ( (ret= primary_coghead_xpath_xpathexpression ( ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:4: ( (ret= primary_coghead_xpath_xpathexpression ( ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:4: ( (ret= primary_coghead_xpath_xpathexpression ( ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) ) )* ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:6: (ret= primary_coghead_xpath_xpathexpression ( ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) ) )* )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:6: (ret= primary_coghead_xpath_xpathexpression ( ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) ) )* )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:8: ret= primary_coghead_xpath_xpathexpression ( ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_coghead_xpath_xpathexpression_in_xpathexpressions_priority_01538);
            ret=primary_coghead_xpath_xpathexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:49: ( ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==LBRACKET) && (synpred1_Collection())) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:50: ( LBRACKET )=> ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:62: ( LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) ) )
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:63: LBRACKET ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("[", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LBRACKET,FOLLOW_LBRACKET_in_xpathexpressions_priority_01547); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "[";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:149: ( (ret= coghead_xpath_filterexpr[opName, ret, firstToken] ) )
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:150: (ret= coghead_xpath_filterexpr[opName, ret, firstToken] )
            	    {
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:150: (ret= coghead_xpath_filterexpr[opName, ret, firstToken] )
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:151: ret= coghead_xpath_filterexpr[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_coghead_xpath_filterexpr_in_xpathexpressions_priority_01555);
            	    ret=coghead_xpath_filterexpr(opName, ret, firstToken);

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
            	    break loop21;
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
    // $ANTLR end "xpathexpressions_priority_0"


    // $ANTLR start "xpathexpressions_priority_1"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:497:1: xpathexpressions_priority_1 returns [Object ret2] : ( (ret= xpathexpressions_priority_0 ( ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) ) )* ) ) ;
    public final Object xpathexpressions_priority_1() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:498:3: ( ( (ret= xpathexpressions_priority_0 ( ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) ) )* ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:4: ( (ret= xpathexpressions_priority_0 ( ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) ) )* ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:4: ( (ret= xpathexpressions_priority_0 ( ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) ) )* ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:6: (ret= xpathexpressions_priority_0 ( ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) ) )* )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:6: (ret= xpathexpressions_priority_0 ( ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) ) )* )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:8: ret= xpathexpressions_priority_0 ( ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) ) )*
            {
            pushFollow(FOLLOW_xpathexpressions_priority_0_in_xpathexpressions_priority_11596);
            ret=xpathexpressions_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:39: ( ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==54) && (synpred2_Collection())) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:40: ( '/' )=> ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) )
            	    {
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:47: ( '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) ) )
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:48: '/' ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("/", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,54,FOLLOW_54_in_xpathexpressions_priority_11605); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "/";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:128: ( (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 ) )
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:129: (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 )
            	    {
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:129: (ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0 )
            	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:130: ret= coghead_xpath_pathexpr[opName, ret, firstToken] right= xpathexpressions_priority_0
            	    {
            	    pushFollow(FOLLOW_coghead_xpath_pathexpr_in_xpathexpressions_priority_11612);
            	    ret=coghead_xpath_pathexpr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_xpathexpressions_priority_0_in_xpathexpressions_priority_11616);
            	    right=xpathexpressions_priority_0();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "rhs", right);
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
            	    break loop22;
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
    // $ANTLR end "xpathexpressions_priority_1"


    // $ANTLR start "coghead_xpath_xpathexpression"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:509:1: coghead_xpath_xpathexpression returns [Object ret2] : ret= xpathexpressions_priority_1 ;
    public final Object coghead_xpath_xpathexpression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:510:3: (ret= xpathexpressions_priority_1 )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:511:3: ret= xpathexpressions_priority_1
            {
            pushFollow(FOLLOW_xpathexpressions_priority_1_in_coghead_xpath_xpathexpression1649);
            ret=xpathexpressions_priority_1();

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
    // $ANTLR end "coghead_xpath_xpathexpression"


    // $ANTLR start "coghead_xpath_pathexpr"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:518:1: coghead_xpath_pathexpr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object coghead_xpath_pathexpr(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("coghead","xpath","PathExpr");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:523:3: ()
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:524:3: 
            {
            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"lhs" , left);
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
    // $ANTLR end "coghead_xpath_pathexpr"


    // $ANTLR start "coghead_xpath_axisstep"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:534:1: coghead_xpath_axisstep returns [Object ret2] : ( ( ( (temp= coghead_xpath_axis ) DCOLON ) | ) (temp= coghead_xpath_nodetest ) ) ;
    public final Object coghead_xpath_axisstep() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","xpath","AxisStep");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:539:3: ( ( ( ( (temp= coghead_xpath_axis ) DCOLON ) | ) (temp= coghead_xpath_nodetest ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:3: ( ( ( (temp= coghead_xpath_axis ) DCOLON ) | ) (temp= coghead_xpath_nodetest ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:3: ( ( ( (temp= coghead_xpath_axis ) DCOLON ) | ) (temp= coghead_xpath_nodetest ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:4: ( ( (temp= coghead_xpath_axis ) DCOLON ) | ) (temp= coghead_xpath_nodetest )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBBC52822C6511DFCCFAC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:64: ( ( (temp= coghead_xpath_axis ) DCOLON ) | )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=73 && LA23_0<=84)) ) {
                alt23=1;
            }
            else if ( (LA23_0==NAME) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:65: ( (temp= coghead_xpath_axis ) DCOLON )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:81: ( (temp= coghead_xpath_axis ) DCOLON )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:82: (temp= coghead_xpath_axis ) DCOLON
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBBC2B742C6511DFAF0CC9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:141: (temp= coghead_xpath_axis )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:143: temp= coghead_xpath_axis
                    {
                    pushFollow(FOLLOW_coghead_xpath_axis_in_coghead_xpath_axisstep1716);
                    temp=coghead_xpath_axis();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "axis", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBBC52802C6511DF956AC9278D1504C0");
                    }
                    match(input,DCOLON,FOLLOW_DCOLON_in_coghead_xpath_axisstep1723); if (state.failed) return ret2;
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:540:318: 
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
              _beforeSeqEl("E0559EB2CBBC79912C6511DFA4D4C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:541:76: (temp= coghead_xpath_nodetest )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:541:78: temp= coghead_xpath_nodetest
            {
            pushFollow(FOLLOW_coghead_xpath_nodetest_in_coghead_xpath_axisstep1744);
            temp=coghead_xpath_nodetest();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "nodeTest", temp);
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
    // $ANTLR end "coghead_xpath_axisstep"


    // $ANTLR start "coghead_xpath_filterexpr"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:549:1: coghead_xpath_filterexpr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= coghead_xpath_xpathexpression )? RBRACKET ) ;
    public final Object coghead_xpath_filterexpr(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","xpath","FilterExpr");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:554:3: ( ( (temp= coghead_xpath_xpathexpression )? RBRACKET ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:555:3: ( (temp= coghead_xpath_xpathexpression )? RBRACKET )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:555:3: ( (temp= coghead_xpath_xpathexpression )? RBRACKET )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:555:4: (temp= coghead_xpath_xpathexpression )? RBRACKET
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBBEEA902C6511DFB0C5C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:555:63: (temp= coghead_xpath_xpathexpression )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=NAME && LA24_0<=DOUBLE)||LA24_0==LPAREN||LA24_0==59||(LA24_0>=73 && LA24_0<=84)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:555:65: temp= coghead_xpath_xpathexpression
                    {
                    pushFollow(FOLLOW_coghead_xpath_xpathexpression_in_coghead_xpath_filterexpr1792);
                    temp=coghead_xpath_xpathexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "predicates", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBBEEA912C6511DF85AAC9278D1504C0");
            }
            match(input,RBRACKET,FOLLOW_RBRACKET_in_coghead_xpath_filterexpr1801); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"expression" , left);
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
    // $ANTLR end "coghead_xpath_filterexpr"


    // $ANTLR start "coghead_xpath_nodetest"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:565:1: coghead_xpath_nodetest returns [Object ret2] : (ret= coghead_xpath_nametest ) ;
    public final Object coghead_xpath_nodetest() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:566:3: ( (ret= coghead_xpath_nametest ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:567:3: (ret= coghead_xpath_nametest )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:567:3: (ret= coghead_xpath_nametest )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:567:4: ret= coghead_xpath_nametest
            {
            pushFollow(FOLLOW_coghead_xpath_nametest_in_coghead_xpath_nodetest1831);
            ret=coghead_xpath_nametest();

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
    // $ANTLR end "coghead_xpath_nodetest"


    // $ANTLR start "coghead_xpath_nametest"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:574:1: coghead_xpath_nametest returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object coghead_xpath_nametest() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","xpath","NameTest");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:579:3: ( ( (temp= identifier ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:580:3: ( (temp= identifier ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:580:3: ( (temp= identifier ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:580:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBC309412C6511DFBD98C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:580:63: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:580:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_xpath_nametest1865);
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
    // $ANTLR end "coghead_xpath_nametest"


    // $ANTLR start "coghead_xpath_variableref"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:588:1: coghead_xpath_variableref returns [Object ret2] : ( '$' (temp= identifier ) ) ;
    public final Object coghead_xpath_variableref() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","xpath","VariableRef");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:593:3: ( ( '$' (temp= identifier ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:594:3: ( '$' (temp= identifier ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:594:3: ( '$' (temp= identifier ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:594:4: '$' (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBC57A402C6511DF8AE8C9278D1504C0");
            }
            match(input,59,FOLLOW_59_in_coghead_xpath_variableref1908); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBC5A1532C6511DFC96BC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:594:141: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:594:143: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_xpath_variableref1915);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "variable", list("coghead","Variable"), "name", temp, "#context(env).variables", "never", null, false, null);
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
    // $ANTLR end "coghead_xpath_variableref"


    // $ANTLR start "coghead_xpath_literal"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:602:1: coghead_xpath_literal returns [Object ret2] : (ret= coghead_xpath_stringliteral | ret= coghead_xpath_numberliteral ) ;
    public final Object coghead_xpath_literal() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:603:3: ( (ret= coghead_xpath_stringliteral | ret= coghead_xpath_numberliteral ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:604:3: (ret= coghead_xpath_stringliteral | ret= coghead_xpath_numberliteral )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:604:3: (ret= coghead_xpath_stringliteral | ret= coghead_xpath_numberliteral )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==STRING) ) {
                alt25=1;
            }
            else if ( ((LA25_0>=INT && LA25_0<=DOUBLE)) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:604:4: ret= coghead_xpath_stringliteral
                    {
                    pushFollow(FOLLOW_coghead_xpath_stringliteral_in_coghead_xpath_literal1955);
                    ret=coghead_xpath_stringliteral();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:605:5: ret= coghead_xpath_numberliteral
                    {
                    pushFollow(FOLLOW_coghead_xpath_numberliteral_in_coghead_xpath_literal1963);
                    ret=coghead_xpath_numberliteral();

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
    // $ANTLR end "coghead_xpath_literal"


    // $ANTLR start "coghead_xpath_stringliteral"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:612:1: coghead_xpath_stringliteral returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object coghead_xpath_stringliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","xpath","StringLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:617:3: ( ( (temp= stringSymbol ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:618:3: ( (temp= stringSymbol ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:618:3: ( (temp= stringSymbol ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:618:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBCA0E222C6511DFA812C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:618:63: (temp= stringSymbol )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:618:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_coghead_xpath_stringliteral1997);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
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
    // $ANTLR end "coghead_xpath_stringliteral"


    // $ANTLR start "coghead_xpath_numberliteral"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:626:1: coghead_xpath_numberliteral returns [Object ret2] : ( ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) ) ) ;
    public final Object coghead_xpath_numberliteral() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","xpath","NumberLiteral");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:631:3: ( ( ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:3: ( ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:3: ( ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:4: ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD30ED12C6511DF91D7C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:63: ( ( (temp= integerAsStringSymbol ) ) | ( (temp= doubleAsStringSymbol ) ) | ( (temp= floatAsStringSymbol ) ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt26=1;
                }
                break;
            case DOUBLE:
                {
                alt26=2;
                }
                break;
            case FLOAT:
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:64: ( (temp= integerAsStringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:80: ( (temp= integerAsStringSymbol ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:81: (temp= integerAsStringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD299A22C6511DF8390C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:140: (temp= integerAsStringSymbol )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:632:142: temp= integerAsStringSymbol
                    {
                    pushFollow(FOLLOW_integerAsStringSymbol_in_coghead_xpath_numberliteral2049);
                    temp=integerAsStringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:633:4: ( (temp= doubleAsStringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:633:20: ( (temp= doubleAsStringSymbol ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:633:21: (temp= doubleAsStringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD2C0B32C6511DFC23EC9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:633:80: (temp= doubleAsStringSymbol )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:633:82: temp= doubleAsStringSymbol
                    {
                    pushFollow(FOLLOW_doubleAsStringSymbol_in_coghead_xpath_numberliteral2069);
                    temp=doubleAsStringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:634:4: ( (temp= floatAsStringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:634:20: ( (temp= floatAsStringSymbol ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:634:21: (temp= floatAsStringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD2E7C32C6511DF85B7C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:634:80: (temp= floatAsStringSymbol )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:634:82: temp= floatAsStringSymbol
                    {
                    pushFollow(FOLLOW_floatAsStringSymbol_in_coghead_xpath_numberliteral2089);
                    temp=floatAsStringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
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
    // $ANTLR end "coghead_xpath_numberliteral"


    // $ANTLR start "coghead_action_action"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:642:1: coghead_action_action returns [Object ret2] : (ret= coghead_action_userdefinedaction ) ;
    public final Object coghead_action_action() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:643:3: ( (ret= coghead_action_userdefinedaction ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:644:3: (ret= coghead_action_userdefinedaction )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:644:3: (ret= coghead_action_userdefinedaction )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:644:4: ret= coghead_action_userdefinedaction
            {
            pushFollow(FOLLOW_coghead_action_userdefinedaction_in_coghead_action_action2134);
            ret=coghead_action_userdefinedaction();

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
    // $ANTLR end "coghead_action_action"


    // $ANTLR start "actionbasics"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:651:1: actionbasics[Object ret] : ( ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )? ) ;
    public final void actionbasics(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:652:3: ( ( ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )? ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:653:3: ( ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )? )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:653:3: ( ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )? )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:653:4: ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD495702C6511DF83B6C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:653:64: ( ( 'collection' ) | )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==52) ) {
                alt27=1;
            }
            else if ( (LA27_0==NAME||LA27_0==53||LA27_0==67) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:653:65: ( 'collection' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:653:81: ( 'collection' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:653:82: 'collection'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD46E612C6511DFCAF9C9278D1504C0");
                    }
                    match(input,52,FOLLOW_52_in_actionbasics2164); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "scope", createEnumLiteral(list("coghead","ScopeEnum"),"COLLECTION"));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:653:276: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "scope", createEnumLiteral(list("coghead","ScopeEnum"),"RECORD"));
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
              _beforeSeqEl("E0559EB2CBD4BC832C6511DFB271C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:654:77: ( ( 'const' ) | )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==67) ) {
                alt28=1;
            }
            else if ( (LA28_0==NAME||LA28_0==53) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:654:78: ( 'const' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:654:94: ( 'const' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:654:95: 'const'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD4BC812C6511DFC4EEC9278D1504C0");
                    }
                    match(input,67,FOLLOW_67_in_actionbasics2188); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sideEffectFree", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:654:256: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sideEffectFree", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E0559EB2CBD531B12C6511DFA651C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:655:76: ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==53) ) {
                alt30=1;
            }
            else if ( (LA30_0==NAME) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:655:77: ( 'completesIn' LANGLE (temp= longSymbol )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:655:93: ( 'completesIn' LANGLE (temp= longSymbol )? )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:655:94: 'completesIn' LANGLE (temp= longSymbol )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD4E3902C6511DFCEF5C9278D1504C0");
                    }
                    match(input,53,FOLLOW_53_in_actionbasics2211); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD4E3912C6511DFAFA4C9278D1504C0");
                    }
                    match(input,LANGLE,FOLLOW_LANGLE_in_actionbasics2215); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD50AA12C6511DF9268C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:655:324: (temp= longSymbol )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==INT) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:655:326: temp= longSymbol
                            {
                            pushFollow(FOLLOW_longSymbol_in_actionbasics2223);
                            temp=longSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "executionTimeLimit", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:20: ()
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:21: 
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD531B32C6511DFA121C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:112: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:114: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_actionbasics2250);
            temp=identifier();

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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD558C12C6511DF9BA5C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:239: (temp= coghead_action_signature )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:241: temp= coghead_action_signature
            {
            pushFollow(FOLLOW_coghead_action_signature_in_actionbasics2260);
            temp=coghead_action_signature();

            checkFollows();
            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              setProperty(ret, "signature", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD558C32C6511DF99EEC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:385: (temp= coghead_action_block )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==LCURL) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:656:387: temp= coghead_action_block
                    {
                    pushFollow(FOLLOW_coghead_action_block_in_actionbasics2270);
                    temp=coghead_action_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "ownedBlock", temp);
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
    // $ANTLR end "actionbasics"


    // $ANTLR start "coghead_action_userdefinedaction"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:663:1: coghead_action_userdefinedaction returns [Object ret2] : ( ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )? ) ;
    public final Object coghead_action_userdefinedaction() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","action","UserDefinedAction");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:668:3: ( ( ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )? ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:669:3: ( ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )? )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:669:3: ( ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )? )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:669:4: ( ( 'collection' ) | ) ( ( 'const' ) | ) ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () ) (temp= identifier ) (temp= coghead_action_signature ) (temp= coghead_action_block )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD643222C6511DF8F31C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:669:64: ( ( 'collection' ) | )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==52) ) {
                alt32=1;
            }
            else if ( (LA32_0==NAME||LA32_0==53||LA32_0==67) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:669:65: ( 'collection' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:669:81: ( 'collection' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:669:82: 'collection'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD643202C6511DF869BC9278D1504C0");
                    }
                    match(input,52,FOLLOW_52_in_coghead_action_userdefinedaction2311); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "scope", createEnumLiteral(list("coghead","ScopeEnum"),"COLLECTION"));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:669:276: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "scope", createEnumLiteral(list("coghead","ScopeEnum"),"RECORD"));
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
              _beforeSeqEl("E0559EB2CBD691402C6511DFBE7EC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:670:77: ( ( 'const' ) | )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==67) ) {
                alt33=1;
            }
            else if ( (LA33_0==NAME||LA33_0==53) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:670:78: ( 'const' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:670:94: ( 'const' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:670:95: 'const'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD66A332C6511DF8F9EC9278D1504C0");
                    }
                    match(input,67,FOLLOW_67_in_coghead_action_userdefinedaction2335); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sideEffectFree", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:670:256: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sideEffectFree", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E0559EB2CBD6DF602C6511DF9EA0C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:671:76: ( ( 'completesIn' LANGLE (temp= longSymbol )? ) | () )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==53) ) {
                alt35=1;
            }
            else if ( (LA35_0==NAME) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:671:77: ( 'completesIn' LANGLE (temp= longSymbol )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:671:93: ( 'completesIn' LANGLE (temp= longSymbol )? )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:671:94: 'completesIn' LANGLE (temp= longSymbol )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD691412C6511DFA389C9278D1504C0");
                    }
                    match(input,53,FOLLOW_53_in_coghead_action_userdefinedaction2358); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD691422C6511DFA896C9278D1504C0");
                    }
                    match(input,LANGLE,FOLLOW_LANGLE_in_coghead_action_userdefinedaction2362); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD691442C6511DFA9F8C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:671:324: (temp= longSymbol )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==INT) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:671:326: temp= longSymbol
                            {
                            pushFollow(FOLLOW_longSymbol_in_coghead_action_userdefinedaction2370);
                            temp=longSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "executionTimeLimit", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:20: ()
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:21: 
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD6DF622C6511DFC28AC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:112: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:114: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_action_userdefinedaction2397);
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
              _beforeSeqEl("E0559EB2CBD706712C6511DF8D94C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:239: (temp= coghead_action_signature )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:241: temp= coghead_action_signature
            {
            pushFollow(FOLLOW_coghead_action_signature_in_coghead_action_userdefinedaction2407);
            temp=coghead_action_signature();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "signature", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD706732C6511DFBBE5C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:385: (temp= coghead_action_block )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==LCURL) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:672:387: temp= coghead_action_block
                    {
                    pushFollow(FOLLOW_coghead_action_block_in_coghead_action_userdefinedaction2417);
                    temp=coghead_action_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "ownedBlock", temp);
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
    // $ANTLR end "coghead_action_userdefinedaction"


    // $ANTLR start "coghead_action_signature"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:680:1: coghead_action_signature returns [Object ret2] : ( LPAREN (temp= identifier )? RPAREN COLON ( ( (temp= identifier ) ) | ( 'void' ) ) ) ;
    public final Object coghead_action_signature() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","action","Signature");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:685:3: ( ( LPAREN (temp= identifier )? RPAREN COLON ( ( (temp= identifier ) ) | ( 'void' ) ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:3: ( LPAREN (temp= identifier )? RPAREN COLON ( ( (temp= identifier ) ) | ( 'void' ) ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:3: ( LPAREN (temp= identifier )? RPAREN COLON ( ( (temp= identifier ) ) | ( 'void' ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:4: LPAREN (temp= identifier )? RPAREN COLON ( ( (temp= identifier ) ) | ( 'void' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD7F0D02C6511DF8AA0C9278D1504C0");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_coghead_action_signature2463); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD817E02C6511DF81C6C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:146: (temp= identifier )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==NAME) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:148: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_coghead_action_signature2471);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "additionalInput", "collection.name", temp, "OCL:\"Collection\".allInstances()->select(c | c.name=?).schema");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD83EF12C6511DF9960C9278D1504C0");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "additionalInputForm", null, null, "OCL:if self.additionalInput->isEmpty() then"+"		    									 	null "+"		    									 else "+"		    									 	self.additionalInput.collection.getDefaultForm() "+"		    									 endif", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD83EF22C6511DFC93AC9278D1504C0");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_coghead_action_signature2483); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD83EF32C6511DFC188C9278D1504C0");
            }
            match(input,COLON,FOLLOW_COLON_in_coghead_action_signature2488); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBD8B4222C6511DF9A94C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:879: ( ( (temp= identifier ) ) | ( 'void' ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==NAME) ) {
                alt38=1;
            }
            else if ( (LA38_0==63) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:880: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:896: ( (temp= identifier ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:897: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD88D102C6511DF8A59C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:956: (temp= identifier )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:958: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_coghead_action_signature2502);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "output", "collection.name", temp, "OCL:\"Collection\".allInstances()->select(c | c.name=?).schema");
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:1127: ( 'void' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:1143: ( 'void' )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:686:1144: 'void'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBD8B4202C6511DFCB3AC9278D1504C0");
                    }
                    match(input,63,FOLLOW_63_in_coghead_action_signature2517); if (state.failed) return ret2;
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
    // $ANTLR end "coghead_action_signature"


    // $ANTLR start "coghead_action_block"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:695:1: coghead_action_block returns [Object ret2] : ( LCURL (temp= coghead_action_statement ( ( SEMICOLON ) temp= coghead_action_statement )* )? ( ( SEMICOLON ) | ) RCURL ) ;
    public final Object coghead_action_block() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","action","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:700:3: ( ( LCURL (temp= coghead_action_statement ( ( SEMICOLON ) temp= coghead_action_statement )* )? ( ( SEMICOLON ) | ) RCURL ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:3: ( LCURL (temp= coghead_action_statement ( ( SEMICOLON ) temp= coghead_action_statement )* )? ( ( SEMICOLON ) | ) RCURL )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:3: ( LCURL (temp= coghead_action_statement ( ( SEMICOLON ) temp= coghead_action_statement )* )? ( ( SEMICOLON ) | ) RCURL )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:4: LCURL (temp= coghead_action_statement ( ( SEMICOLON ) temp= coghead_action_statement )* )? ( ( SEMICOLON ) | ) RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDB9A502C6511DFAF92C9278D1504C0");
            }
            match(input,LCURL,FOLLOW_LCURL_in_coghead_action_block2564); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDBC1612C6511DFC6A8C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:145: (temp= coghead_action_statement ( ( SEMICOLON ) temp= coghead_action_statement )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==NAME||LA40_0==EQUALS||LA40_0==58||LA40_0==60||LA40_0==62||LA40_0==65||(LA40_0>=68 && LA40_0<=72)) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:147: temp= coghead_action_statement ( ( SEMICOLON ) temp= coghead_action_statement )*
                    {
                    pushFollow(FOLLOW_coghead_action_statement_in_coghead_action_block2572);
                    temp=coghead_action_statement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "statements", temp);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:217: ( ( SEMICOLON ) temp= coghead_action_statement )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==SEMICOLON) ) {
                            int LA39_1 = input.LA(2);

                            if ( (LA39_1==NAME||LA39_1==EQUALS||LA39_1==58||LA39_1==60||LA39_1==62||LA39_1==65||(LA39_1>=68 && LA39_1<=72)) ) {
                                alt39=1;
                            }


                        }


                        switch (alt39) {
                    	case 1 :
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:218: ( SEMICOLON ) temp= coghead_action_statement
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:235: ( SEMICOLON )
                    	    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:236: SEMICOLON
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0559EB2CBDB9A522C6511DF82BDC9278D1504C0");
                    	    }
                    	    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_action_block2581); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_coghead_action_statement_in_coghead_action_block2589);
                    	    temp=coghead_action_statement();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "statements", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDC0F802C6511DFC5AAC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:491: ( ( SEMICOLON ) | )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==SEMICOLON) ) {
                alt41=1;
            }
            else if ( (LA41_0==RCURL) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:492: ( SEMICOLON )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:508: ( SEMICOLON )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:509: SEMICOLON
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBDBE8732C6511DFA4CAC9278D1504C0");
                    }
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_coghead_action_block2607); if (state.failed) return ret2;
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:701:613: 
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
              _beforeSeqEl("E0559EB2CBDC0F812C6511DFBF67C9278D1504C0");
            }
            match(input,RCURL,FOLLOW_RCURL_in_coghead_action_block2625); if (state.failed) return ret2;
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
    // $ANTLR end "coghead_action_block"


    // $ANTLR start "coghead_action_statement"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:710:1: coghead_action_statement returns [Object ret2] : (ret= coghead_action_looplikestatement | ret= coghead_action_breakstatement | ret= coghead_action_notification | ret= coghead_action_variabledeclarationstatement | ret= coghead_action_performactionstatement ) ;
    public final Object coghead_action_statement() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:711:3: ( (ret= coghead_action_looplikestatement | ret= coghead_action_breakstatement | ret= coghead_action_notification | ret= coghead_action_variabledeclarationstatement | ret= coghead_action_performactionstatement ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:712:3: (ret= coghead_action_looplikestatement | ret= coghead_action_breakstatement | ret= coghead_action_notification | ret= coghead_action_variabledeclarationstatement | ret= coghead_action_performactionstatement )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:712:3: (ret= coghead_action_looplikestatement | ret= coghead_action_breakstatement | ret= coghead_action_notification | ret= coghead_action_variabledeclarationstatement | ret= coghead_action_performactionstatement )
            int alt42=5;
            switch ( input.LA(1) ) {
            case 58:
            case 60:
                {
                alt42=1;
                }
                break;
            case 65:
                {
                alt42=2;
                }
                break;
            case 62:
                {
                alt42=3;
                }
                break;
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
                {
                alt42=4;
                }
                break;
            case NAME:
                {
                int LA42_5 = input.LA(2);

                if ( (LA42_5==EQUALS) ) {
                    alt42=5;
                }
                else if ( (LA42_5==NAME||LA42_5==LBRACKET) ) {
                    alt42=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 5, input);

                    throw nvae;
                }
                }
                break;
            case EQUALS:
                {
                alt42=5;
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:712:4: ret= coghead_action_looplikestatement
                    {
                    pushFollow(FOLLOW_coghead_action_looplikestatement_in_coghead_action_statement2663);
                    ret=coghead_action_looplikestatement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:713:5: ret= coghead_action_breakstatement
                    {
                    pushFollow(FOLLOW_coghead_action_breakstatement_in_coghead_action_statement2671);
                    ret=coghead_action_breakstatement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:714:5: ret= coghead_action_notification
                    {
                    pushFollow(FOLLOW_coghead_action_notification_in_coghead_action_statement2679);
                    ret=coghead_action_notification();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:715:5: ret= coghead_action_variabledeclarationstatement
                    {
                    pushFollow(FOLLOW_coghead_action_variabledeclarationstatement_in_coghead_action_statement2687);
                    ret=coghead_action_variabledeclarationstatement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:716:5: ret= coghead_action_performactionstatement
                    {
                    pushFollow(FOLLOW_coghead_action_performactionstatement_in_coghead_action_statement2695);
                    ret=coghead_action_performactionstatement();

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
    // $ANTLR end "coghead_action_statement"


    // $ANTLR start "coghead_action_looplikestatement"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:723:1: coghead_action_looplikestatement returns [Object ret2] : (ret= coghead_action_whilestatement | ret= coghead_action_foreachstatement ) ;
    public final Object coghead_action_looplikestatement() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:724:3: ( (ret= coghead_action_whilestatement | ret= coghead_action_foreachstatement ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:725:3: (ret= coghead_action_whilestatement | ret= coghead_action_foreachstatement )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:725:3: (ret= coghead_action_whilestatement | ret= coghead_action_foreachstatement )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==60) ) {
                alt43=1;
            }
            else if ( (LA43_0==58) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:725:4: ret= coghead_action_whilestatement
                    {
                    pushFollow(FOLLOW_coghead_action_whilestatement_in_coghead_action_looplikestatement2722);
                    ret=coghead_action_whilestatement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:726:5: ret= coghead_action_foreachstatement
                    {
                    pushFollow(FOLLOW_coghead_action_foreachstatement_in_coghead_action_looplikestatement2730);
                    ret=coghead_action_foreachstatement();

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
    // $ANTLR end "coghead_action_looplikestatement"


    // $ANTLR start "coghead_action_whilestatement"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:733:1: coghead_action_whilestatement returns [Object ret2] : ( 'while' (temp= coghead_expression ) (temp= coghead_action_block )? ) ;
    public final Object coghead_action_whilestatement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","action","WhileStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:738:3: ( ( 'while' (temp= coghead_expression ) (temp= coghead_action_block )? ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:739:3: ( 'while' (temp= coghead_expression ) (temp= coghead_action_block )? )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:739:3: ( 'while' (temp= coghead_expression ) (temp= coghead_action_block )? )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:739:4: 'while' (temp= coghead_expression ) (temp= coghead_action_block )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDDBD302C6511DF8C5CC9278D1504C0");
            }
            match(input,60,FOLLOW_60_in_coghead_action_whilestatement2760); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDDBD322C6511DFB827C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:739:145: (temp= coghead_expression )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:739:147: temp= coghead_expression
            {
            pushFollow(FOLLOW_coghead_expression_in_coghead_action_whilestatement2767);
            temp=coghead_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "loopCondition", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDDBD342C6511DFB5CEC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:739:289: (temp= coghead_action_block )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==LCURL) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:739:291: temp= coghead_action_block
                    {
                    pushFollow(FOLLOW_coghead_action_block_in_coghead_action_whilestatement2777);
                    temp=coghead_action_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "ownedBlock", temp);
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
    // $ANTLR end "coghead_action_whilestatement"


    // $ANTLR start "coghead_action_foreachstatement"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:747:1: coghead_action_foreachstatement returns [Object ret2] : ( 'foreach' (temp= coghead_variable_forEachStatement ) 'in' (temp= identifier ) (temp= coghead_action_block )? ) ;
    public final Object coghead_action_foreachstatement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","action","ForEachStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"foreachStatement"}) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:752:3: ( ( 'foreach' (temp= coghead_variable_forEachStatement ) 'in' (temp= identifier ) (temp= coghead_action_block )? ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:3: ( 'foreach' (temp= coghead_variable_forEachStatement ) 'in' (temp= identifier ) (temp= coghead_action_block )? )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:3: ( 'foreach' (temp= coghead_variable_forEachStatement ) 'in' (temp= identifier ) (temp= coghead_action_block )? )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:4: 'foreach' (temp= coghead_variable_forEachStatement ) 'in' (temp= identifier ) (temp= coghead_action_block )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDE80802C6511DFA1C5C9278D1504C0");
            }
            match(input,58,FOLLOW_58_in_coghead_action_foreachstatement2822); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDE80832C6511DF9CC2C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:147: (temp= coghead_variable_forEachStatement )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:149: temp= coghead_variable_forEachStatement
            {
            pushFollow(FOLLOW_coghead_variable_forEachStatement_in_coghead_action_foreachstatement2829);
            temp=coghead_variable_forEachStatement();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "iteratorVariable", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDEA7902C6511DFCE1DC9278D1504C0");
            }
            match(input,57,FOLLOW_57_in_coghead_action_foreachstatement2835); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDEA7932C6511DF9292C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:388: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:390: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_action_foreachstatement2842);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "collectionVariable", list("coghead","Variable"), "name", temp, null, "never", null, false, null);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDEA7952C6511DF905DC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:594: (temp= coghead_action_block )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==LCURL) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:753:596: temp= coghead_action_block
                    {
                    pushFollow(FOLLOW_coghead_action_block_in_coghead_action_foreachstatement2852);
                    temp=coghead_action_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "ownedBlock", temp);
                    }

                    }
                    break;

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
    // $ANTLR end "coghead_action_foreachstatement"


    // $ANTLR start "coghead_variable_forEachStatement"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:761:1: coghead_variable_forEachStatement returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object coghead_variable_forEachStatement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","Variable");
        onEnterTemplateRule(metaType,"forEachStatement");
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:766:3: ( ( (temp= identifier ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:767:3: ( (temp= identifier ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:767:3: ( (temp= identifier ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:767:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBDF6AE12C6511DFBCCCC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:767:63: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:767:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_variable_forEachStatement2901);
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
              _beforeSeqEl("E0559EB2CBDFE0102C6511DF9BC8C9278D1504C0");
            }
            if ( state.backtracking==0 ) {
              setRef(ret, "elementaryType", list("coghead","ElementaryTypeEnum"), null, null, "#context(foreachStatement).oclAsType(ForEachStatement).collectionVariable.elementaryType", null, null, false, null, true);_exitInjectorAction();setRef(ret, "schemaType", list("coghead","Schema"), null, null, "#context(foreachStatement).oclAsType(ForEachStatement).collectionVariable.schemaType", null, null, false, null, true);_exitInjectorAction();setProperty(ret, "multiplicity", coghead.action.MultiplicityEnum.SINGLE);_exitInjectorAction();setRef(ret, "env", list("coghead","DefinitionEnvironment"), null, null, "#context(foreachStatement).oclAsType(ForEachStatement).ownedBlock", null, null, false, null, true);_exitInjectorAction();
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
    // $ANTLR end "coghead_variable_forEachStatement"


    // $ANTLR start "coghead_action_breakstatement"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:775:1: coghead_action_breakstatement returns [Object ret2] : ( 'break' ) ;
    public final Object coghead_action_breakstatement() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("coghead","action","BreakStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:780:3: ( ( 'break' ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:781:3: ( 'break' )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:781:3: ( 'break' )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:781:4: 'break'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE07C502C6511DF8EC6C9278D1504C0");
            }
            match(input,65,FOLLOW_65_in_coghead_action_breakstatement2947); if (state.failed) return ret2;
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
    // $ANTLR end "coghead_action_breakstatement"


    // $ANTLR start "coghead_action_notification"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:789:1: coghead_action_notification returns [Object ret2] : ( 'notify' (temp= coghead_expression ) 'subject' (temp= coghead_expression ) 'body' (temp= coghead_expression ) ) ;
    public final Object coghead_action_notification() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","action","Notification");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:794:3: ( ( 'notify' (temp= coghead_expression ) 'subject' (temp= coghead_expression ) 'body' (temp= coghead_expression ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:3: ( 'notify' (temp= coghead_expression ) 'subject' (temp= coghead_expression ) 'body' (temp= coghead_expression ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:3: ( 'notify' (temp= coghead_expression ) 'subject' (temp= coghead_expression ) 'body' (temp= coghead_expression ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:4: 'notify' (temp= coghead_expression ) 'subject' (temp= coghead_expression ) 'body' (temp= coghead_expression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE118902C6511DFB4D2C9278D1504C0");
            }
            match(input,62,FOLLOW_62_in_coghead_action_notification2987); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE118922C6511DFB3B9C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:146: (temp= coghead_expression )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:148: temp= coghead_expression
            {
            pushFollow(FOLLOW_coghead_expression_in_coghead_action_notification2994);
            temp=coghead_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "to", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE13FA02C6511DF9157C9278D1504C0");
            }
            match(input,56,FOLLOW_56_in_coghead_action_notification3000); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE13FA22C6511DFCD2FC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:363: (temp= coghead_expression )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:365: temp= coghead_expression
            {
            pushFollow(FOLLOW_coghead_expression_in_coghead_action_notification3007);
            temp=coghead_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "subject", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE13FA32C6511DFAA10C9278D1504C0");
            }
            match(input,55,FOLLOW_55_in_coghead_action_notification3013); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE13FA52C6511DF9D8DC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:582: (temp= coghead_expression )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:795:584: temp= coghead_expression
            {
            pushFollow(FOLLOW_coghead_expression_in_coghead_action_notification3020);
            temp=coghead_expression();

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
    // $ANTLR end "coghead_action_notification"


    // $ANTLR start "coghead_action_variabledeclarationstatement"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:803:1: coghead_action_variabledeclarationstatement returns [Object ret2] : ( (temp= coghead_variable ) ) ;
    public final Object coghead_action_variabledeclarationstatement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","action","VariableDeclarationStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:808:3: ( ( (temp= coghead_variable ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:809:3: ( (temp= coghead_variable ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:809:3: ( (temp= coghead_variable ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:809:4: (temp= coghead_variable )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE202F12C6511DF897AC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:809:63: (temp= coghead_variable )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:809:65: temp= coghead_variable
            {
            pushFollow(FOLLOW_coghead_variable_in_coghead_action_variabledeclarationstatement3067);
            temp=coghead_variable();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "declaredVariable", temp);
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
    // $ANTLR end "coghead_action_variabledeclarationstatement"


    // $ANTLR start "coghead_action_performactionstatement"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:817:1: coghead_action_performactionstatement returns [Object ret2] : ( (temp= identifier )? EQUALS (temp= identifier )? DOT (temp= identifier ) LPAREN (temp= identifier )? RPAREN ) ;
    public final Object coghead_action_performactionstatement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","action","PerformActionStatement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:822:3: ( ( (temp= identifier )? EQUALS (temp= identifier )? DOT (temp= identifier ) LPAREN (temp= identifier )? RPAREN ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:3: ( (temp= identifier )? EQUALS (temp= identifier )? DOT (temp= identifier ) LPAREN (temp= identifier )? RPAREN )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:3: ( (temp= identifier )? EQUALS (temp= identifier )? DOT (temp= identifier ) LPAREN (temp= identifier )? RPAREN )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:4: (temp= identifier )? EQUALS (temp= identifier )? DOT (temp= identifier ) LPAREN (temp= identifier )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE2C6402C6511DFC0C9C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:63: (temp= identifier )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==NAME) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_coghead_action_performactionstatement3114);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "output", list("coghead","Variable"), "name", temp, null, "never", null, false, null);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE2C6412C6511DFC2BDC9278D1504C0");
            }
            match(input,EQUALS,FOLLOW_EQUALS_in_coghead_action_performactionstatement3123); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE2ED502C6511DFC202C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:342: (temp= identifier )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==NAME) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:344: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_coghead_action_performactionstatement3131);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "input", list("coghead","Variable"), "name", temp, null, "never", null, false, null);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE2ED512C6511DFB78AC9278D1504C0");
            }
            match(input,DOT,FOLLOW_DOT_in_coghead_action_performactionstatement3140); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE2ED552C6511DF8D0CC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:617: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:619: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_action_performactionstatement3148);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "action", "name", temp, "OCL:input.schemaType.collection.actions->select(a | a.name=?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE314602C6511DFAD1CC9278D1504C0");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_coghead_action_performactionstatement3155); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE314632C6511DFAAFAC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:900: (temp= identifier )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==NAME) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:823:902: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_coghead_action_performactionstatement3163);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "additionalInput", list("coghead","Variable"), "name", temp, null, "never", null, false, null);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE33B702C6511DFBAB8C9278D1504C0");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_coghead_action_performactionstatement3172); if (state.failed) return ret2;
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
    // $ANTLR end "coghead_action_performactionstatement"


    // $ANTLR start "coghead_variable"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:831:1: coghead_variable returns [Object ret2] : ( ( ( (temp= coghead_elementarytypeenum ) ) | ( (temp= identifier ) ( ( LBRACKET RBRACKET ) | ) ) ) (temp= identifier ) ) ;
    public final Object coghead_variable() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("coghead","Variable");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:836:3: ( ( ( ( (temp= coghead_elementarytypeenum ) ) | ( (temp= identifier ) ( ( LBRACKET RBRACKET ) | ) ) ) (temp= identifier ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:3: ( ( ( (temp= coghead_elementarytypeenum ) ) | ( (temp= identifier ) ( ( LBRACKET RBRACKET ) | ) ) ) (temp= identifier ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:3: ( ( ( (temp= coghead_elementarytypeenum ) ) | ( (temp= identifier ) ( ( LBRACKET RBRACKET ) | ) ) ) (temp= identifier ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:4: ( ( (temp= coghead_elementarytypeenum ) ) | ( (temp= identifier ) ( ( LBRACKET RBRACKET ) | ) ) ) (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE4C2102C6511DF8DDDC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:63: ( ( (temp= coghead_elementarytypeenum ) ) | ( (temp= identifier ) ( ( LBRACKET RBRACKET ) | ) ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=68 && LA50_0<=72)) ) {
                alt50=1;
            }
            else if ( (LA50_0==NAME) ) {
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:64: ( (temp= coghead_elementarytypeenum ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:80: ( (temp= coghead_elementarytypeenum ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:81: (temp= coghead_elementarytypeenum )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE3FEC22C6511DFB6A2C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:140: (temp= coghead_elementarytypeenum )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:837:142: temp= coghead_elementarytypeenum
                    {
                    pushFollow(FOLLOW_coghead_elementarytypeenum_in_coghead_variable3222);
                    temp=coghead_elementarytypeenum();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elementaryType", temp);
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:4: ( (temp= identifier ) ( ( LBRACKET RBRACKET ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:20: ( (temp= identifier ) ( ( LBRACKET RBRACKET ) | ) )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:21: (temp= identifier ) ( ( LBRACKET RBRACKET ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE425D52C6511DFC770C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:80: (temp= identifier )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:82: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_coghead_variable3242);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "schemaType", "collection.name", temp, "OCL:\"Collection\".allInstances()->select(c | c.name=?).schema");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE49B002C6511DFCFC1C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:297: ( ( LBRACKET RBRACKET ) | )
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==LBRACKET) ) {
                        alt49=1;
                    }
                    else if ( (LA49_0==NAME) ) {
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
                            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:298: ( LBRACKET RBRACKET )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:314: ( LBRACKET RBRACKET )
                            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:315: LBRACKET RBRACKET
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0559EB2CBE473F12C6511DF9FCCC9278D1504C0");
                            }
                            match(input,LBRACKET,FOLLOW_LBRACKET_in_coghead_variable3255); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0559EB2CBE473F22C6511DF8EDCC9278D1504C0");
                            }
                            match(input,RBRACKET,FOLLOW_RBRACKET_in_coghead_variable3260); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "multiplicity", createEnumLiteral(list("coghead","action","Multiplicity"),"COLLECTION"));
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:838:611: 
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "multiplicity", createEnumLiteral(list("coghead","action","Multiplicity"),"SINGLE"));
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
              _beforeSeqEl("E0559EB2CBE4E9202C6511DFCB73C9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:839:108: (temp= identifier )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:839:110: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_coghead_variable3288);
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
              _beforeSeqEl("E0559EB2CBE4E9232C6511DFCA5CC9278D1504C0");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "env", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // $ANTLR end "coghead_variable"


    // $ANTLR start "cardinality"
    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:847:1: cardinality[Object ret] : ( ( ( LBRACKET RBRACKET ) | ( LBRACKET (temp= integerSymbol ) RBRACKET ) | () ) ) ;
    public final void cardinality(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:848:3: ( ( ( ( LBRACKET RBRACKET ) | ( LBRACKET (temp= integerSymbol ) RBRACKET ) | () ) ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:849:3: ( ( ( LBRACKET RBRACKET ) | ( LBRACKET (temp= integerSymbol ) RBRACKET ) | () ) )
            {
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:849:3: ( ( ( LBRACKET RBRACKET ) | ( LBRACKET (temp= integerSymbol ) RBRACKET ) | () ) )
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:849:4: ( ( LBRACKET RBRACKET ) | ( LBRACKET (temp= integerSymbol ) RBRACKET ) | () )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0559EB2CBE648B02C6511DFB71EC9278D1504C0");
            }
            // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:849:63: ( ( LBRACKET RBRACKET ) | ( LBRACKET (temp= integerSymbol ) RBRACKET ) | () )
            int alt51=3;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==LBRACKET) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==RBRACKET) ) {
                    alt51=1;
                }
                else if ( (LA51_1==INT) ) {
                    alt51=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA51_0==NAME) ) {
                alt51=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:849:64: ( LBRACKET RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:849:80: ( LBRACKET RBRACKET )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:849:81: LBRACKET RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE5AC702C6511DFA034C9278D1504C0");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_cardinality3334); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE5AC712C6511DFA590C9278D1504C0");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_cardinality3339); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE5AC742C6511DFC3D7C9278D1504C0");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "cardinality", -1);_exitInjectorAction();
                    }
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:850:4: ( LBRACKET (temp= integerSymbol ) RBRACKET )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:850:20: ( LBRACKET (temp= integerSymbol ) RBRACKET )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:850:21: LBRACKET (temp= integerSymbol ) RBRACKET
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE5D3812C6511DF9038C9278D1504C0");
                    }
                    match(input,LBRACKET,FOLLOW_LBRACKET_in_cardinality3357); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE5FA902C6511DFB2E9C9278D1504C0");
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:850:165: (temp= integerSymbol )
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:850:167: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_cardinality3365);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "cardinality", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE5FA912C6511DFC9EBC9278D1504C0");
                    }
                    match(input,RBRACKET,FOLLOW_RBRACKET_in_cardinality3372); if (state.failed) return ;
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
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:851:4: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:851:20: ()
                    // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:851:21: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0559EB2CBE621A22C6511DFC190C9278D1504C0");
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "cardinality", 1);_exitInjectorAction();
                    }
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
    // $ANTLR end "cardinality"

    // $ANTLR start synpred1_Collection
    public final void synpred1_Collection_fragment() throws RecognitionException {   
        // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:50: ( LBRACKET )
        // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:489:51: LBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred1_Collection1541); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Collection

    // $ANTLR start synpred2_Collection
    public final void synpred2_Collection_fragment() throws RecognitionException {   
        // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:40: ( '/' )
        // C:\\Users\\siani\\runtime-workspace\\com.sap.coghead.editor\\generated\\generated\\Collection.g:499:41: '/'
        {
        match(input,54,FOLLOW_54_in_synpred2_Collection1599); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Collection

    // Delegated rules

    public final boolean synpred1_Collection() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Collection_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Collection() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Collection_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_NAME_in_identifier63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_identifierOrKeyword142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_identifierOrKeyword150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_identifierOrKeyword158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_identifierOrKeyword166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_identifierOrKeyword174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_identifierOrKeyword182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_identifierOrKeyword190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_identifierOrKeyword198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_identifierOrKeyword206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_identifierOrKeyword214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifierOrKeyword222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_identifierOrKeyword230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_identifierOrKeyword238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsStringSymbol362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsStringSymbol393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_doubleAsStringSymbol424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BINARY_in_binarySymbol486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATE_in_dateSymbol517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_coghead_elementarytypeenum547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_coghead_elementarytypeenum555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_coghead_elementarytypeenum563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_coghead_elementarytypeenum571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_coghead_elementarytypeenum579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_coghead_xpath_axis609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_coghead_xpath_axis617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_coghead_xpath_axis625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_coghead_xpath_axis633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_coghead_xpath_axis641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_coghead_xpath_axis649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_coghead_xpath_axis657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_coghead_xpath_axis665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_coghead_xpath_axis673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_coghead_xpath_axis681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_coghead_xpath_axis689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_coghead_xpath_axis697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_collection_in_main725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_coghead_collection759 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_collection766 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURL_in_coghead_collection773 = new BitSet(new long[]{0x2038000000006010L,0x00000000000001F8L});
    public static final BitSet FOLLOW_coghead_schema_in_coghead_collection781 = new BitSet(new long[]{0x0030000000002010L,0x0000000000000008L});
    public static final BitSet FOLLOW_coghead_action_action_in_coghead_collection791 = new BitSet(new long[]{0x0030000000002010L,0x0000000000000008L});
    public static final BitSet FOLLOW_coghead_action_action_in_coghead_collection799 = new BitSet(new long[]{0x0030000000002010L,0x0000000000000008L});
    public static final BitSet FOLLOW_RCURL_in_coghead_collection811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_schemaentry_in_coghead_schema856 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_schema865 = new BitSet(new long[]{0x2008000000000000L,0x00000000000001F0L});
    public static final BitSet FOLLOW_coghead_schemaentry_in_coghead_schema873 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_schema891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_fieldgroup_in_coghead_schemaentry942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_field_in_coghead_schemaentry950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_coghead_fieldgroup980 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_cardinality_in_coghead_fieldgroup983 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_fieldgroup991 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURL_in_coghead_fieldgroup998 = new BitSet(new long[]{0x2008000000002000L,0x00000000000001F0L});
    public static final BitSet FOLLOW_coghead_field_inFieldGroup_in_coghead_fieldgroup1006 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_fieldgroup1015 = new BitSet(new long[]{0x2008000000000000L,0x00000000000001F0L});
    public static final BitSet FOLLOW_coghead_field_inFieldGroup_in_coghead_fieldgroup1023 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_RCURL_in_coghead_fieldgroup1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_coghead_field1082 = new BitSet(new long[]{0x2008000000000000L,0x00000000000001F0L});
    public static final BitSet FOLLOW_coghead_elementarytypeenum_in_coghead_field1104 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_cardinality_in_coghead_field1110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_field1118 = new BitSet(new long[]{0x0004000000000002L,0x0000000000000005L});
    public static final BitSet FOLLOW_66_in_coghead_field1130 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_field1137 = new BitSet(new long[]{0x0004000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_50_in_coghead_field1162 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_field1169 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_coghead_field1194 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_field1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_coghead_field_inFieldGroup1263 = new BitSet(new long[]{0x2008000000000000L,0x00000000000001F0L});
    public static final BitSet FOLLOW_coghead_elementarytypeenum_in_coghead_field_inFieldGroup1285 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_cardinality_in_coghead_field_inFieldGroup1291 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_field_inFieldGroup1299 = new BitSet(new long[]{0x0004000000000002L,0x0000000000000005L});
    public static final BitSet FOLLOW_66_in_coghead_field_inFieldGroup1314 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_field_inFieldGroup1321 = new BitSet(new long[]{0x0004000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_50_in_coghead_field_inFieldGroup1346 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_field_inFieldGroup1353 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_coghead_field_inFieldGroup1378 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_field_inFieldGroup1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_xpathexpression_in_coghead_expression1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_literal_in_primary_coghead_xpath_xpathexpression1465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_variableref_in_primary_coghead_xpath_xpathexpression1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_axisstep_in_primary_coghead_xpath_xpathexpression1481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_coghead_xpath_xpathexpression1490 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_xpath_xpathexpression_in_primary_coghead_xpath_xpathexpression1496 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_coghead_xpath_xpathexpression1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_coghead_xpath_xpathexpression_in_xpathexpressions_priority_01538 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_LBRACKET_in_xpathexpressions_priority_01547 = new BitSet(new long[]{0x08000000000881F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_xpath_filterexpr_in_xpathexpressions_priority_01555 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_xpathexpressions_priority_0_in_xpathexpressions_priority_11596 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_54_in_xpathexpressions_priority_11605 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_xpath_pathexpr_in_xpathexpressions_priority_11612 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_xpathexpressions_priority_0_in_xpathexpressions_priority_11616 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_xpathexpressions_priority_1_in_coghead_xpath_xpathexpression1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_axis_in_coghead_xpath_axisstep1716 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_DCOLON_in_coghead_xpath_axisstep1723 = new BitSet(new long[]{0x0000000000000010L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_xpath_nodetest_in_coghead_xpath_axisstep1744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_xpathexpression_in_coghead_xpath_filterexpr1792 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACKET_in_coghead_xpath_filterexpr1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_nametest_in_coghead_xpath_nodetest1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_coghead_xpath_nametest1865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_coghead_xpath_variableref1908 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_xpath_variableref1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_stringliteral_in_coghead_xpath_literal1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_xpath_numberliteral_in_coghead_xpath_literal1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_coghead_xpath_stringliteral1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsStringSymbol_in_coghead_xpath_numberliteral2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doubleAsStringSymbol_in_coghead_xpath_numberliteral2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsStringSymbol_in_coghead_xpath_numberliteral2089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_action_userdefinedaction_in_coghead_action_action2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_actionbasics2164 = new BitSet(new long[]{0x0020000000000010L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_actionbasics2188 = new BitSet(new long[]{0x0020000000000010L});
    public static final BitSet FOLLOW_53_in_actionbasics2211 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LANGLE_in_actionbasics2215 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_longSymbol_in_actionbasics2223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_actionbasics2250 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_coghead_action_signature_in_actionbasics2260 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_coghead_action_block_in_actionbasics2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_coghead_action_userdefinedaction2311 = new BitSet(new long[]{0x0020000000000010L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_coghead_action_userdefinedaction2335 = new BitSet(new long[]{0x0020000000000010L});
    public static final BitSet FOLLOW_53_in_coghead_action_userdefinedaction2358 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_LANGLE_in_coghead_action_userdefinedaction2362 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_longSymbol_in_coghead_action_userdefinedaction2370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_action_userdefinedaction2397 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_coghead_action_signature_in_coghead_action_userdefinedaction2407 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_coghead_action_block_in_coghead_action_userdefinedaction2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_action_signature2463 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_identifier_in_coghead_action_signature2471 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_action_signature2483 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COLON_in_coghead_action_signature2488 = new BitSet(new long[]{0x8000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_action_signature2502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_coghead_action_signature2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURL_in_coghead_action_block2564 = new BitSet(new long[]{0x7408000000406010L,0x00000000000001F2L});
    public static final BitSet FOLLOW_coghead_action_statement_in_coghead_action_block2572 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_action_block2581 = new BitSet(new long[]{0x7408000000400010L,0x00000000000001F2L});
    public static final BitSet FOLLOW_coghead_action_statement_in_coghead_action_block2589 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_SEMICOLON_in_coghead_action_block2607 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RCURL_in_coghead_action_block2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_action_looplikestatement_in_coghead_action_statement2663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_action_breakstatement_in_coghead_action_statement2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_action_notification_in_coghead_action_statement2679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_action_variabledeclarationstatement_in_coghead_action_statement2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_action_performactionstatement_in_coghead_action_statement2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_action_whilestatement_in_coghead_action_looplikestatement2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_action_foreachstatement_in_coghead_action_looplikestatement2730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_coghead_action_whilestatement2760 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_action_whilestatement2767 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_coghead_action_block_in_coghead_action_whilestatement2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_coghead_action_foreachstatement2822 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_coghead_variable_forEachStatement_in_coghead_action_foreachstatement2829 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_coghead_action_foreachstatement2835 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_action_foreachstatement2842 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_coghead_action_block_in_coghead_action_foreachstatement2852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_coghead_variable_forEachStatement2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_coghead_action_breakstatement2947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_coghead_action_notification2987 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_action_notification2994 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_coghead_action_notification3000 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_action_notification3007 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_coghead_action_notification3013 = new BitSet(new long[]{0x08000000000081F0L,0x00000000001FFE00L});
    public static final BitSet FOLLOW_coghead_expression_in_coghead_action_notification3020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_variable_in_coghead_action_variabledeclarationstatement3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_coghead_action_performactionstatement3114 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUALS_in_coghead_action_performactionstatement3123 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_identifier_in_coghead_action_performactionstatement3131 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_DOT_in_coghead_action_performactionstatement3140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_action_performactionstatement3148 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LPAREN_in_coghead_action_performactionstatement3155 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_identifier_in_coghead_action_performactionstatement3163 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RPAREN_in_coghead_action_performactionstatement3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_coghead_elementarytypeenum_in_coghead_variable3222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_variable3242 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_LBRACKET_in_coghead_variable3255 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACKET_in_coghead_variable3260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_coghead_variable3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_cardinality3334 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACKET_in_cardinality3339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_cardinality3357 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_cardinality3365 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RBRACKET_in_cardinality3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred1_Collection1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_synpred2_Collection1599 = new BitSet(new long[]{0x0000000000000002L});

}