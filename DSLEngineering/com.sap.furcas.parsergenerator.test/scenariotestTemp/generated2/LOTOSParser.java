// $ANTLR 3.1.1 ./scenariotestTemp/generated2/LOTOS.g 2010-11-04 23:28:40

package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.parsergenerator.emf.lookup.RuleNameFinder;
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
public class LOTOSParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "LSQUARE", "COMA", "RSQUARE", "COLON", "LPAREN", "RPAREN", "COLONEQ", "SEMI", "RARROW", "LSQUARERSQUARE", "PIPE3", "PIPELSQUARE", "EQ", "RSQUAREPIPE", "QMARK", "EXCL", "PLUS", "GE", "GT", "LE", "LT", "IMPLIES", "COMMENT", "LCURLY", "RCURLY", "PIPE", "SHARP", "COLONCOLON", "POINT", "MINUS", "STAR", "SLASH", "NE", "LARROW", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'is'", "'false'", "'true'", "'choice'", "'sorts'", "'library'", "'endtype'", "'process'", "'hide'", "'where'", "'of'", "'endproc'", "'in'", "'ofsort'", "'forall'", "'or'", "'let'", "'and'", "'endlib'", "'opns'", "'neq'", "'exit'", "'endspec'", "'eqns'", "'behaviour'", "'specification'", "'type'", "'eq'", "'noexit'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int LT=28;
    public static final int T__67=67;
    public static final int STAR=38;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int LSQUARE=8;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int POINT=36;
    public static final int ESC=47;
    public static final int LARROW=41;
    public static final int EXCL=23;
    public static final int FLOAT=7;
    public static final int LSQUARERSQUARE=17;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int LPAREN=12;
    public static final int PIPELSQUARE=19;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int RPAREN=13;
    public static final int T__58=58;
    public static final int NAME=4;
    public static final int SLASH=39;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int COLONEQ=14;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int PIPE=33;
    public static final int PLUS=24;
    public static final int DIGIT=44;
    public static final int NL=42;
    public static final int PIPE3=18;
    public static final int EQ=20;
    public static final int COMMENT=30;
    public static final int T__50=50;
    public static final int NE=40;
    public static final int RSQUAREPIPE=21;
    public static final int GE=25;
    public static final int IMPLIES=29;
    public static final int SHARP=34;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=16;
    public static final int LCURLY=31;
    public static final int INT=6;
    public static final int MINUS=37;
    public static final int RSQUARE=10;
    public static final int COMA=9;
    public static final int SEMI=15;
    public static final int ALPHA=45;
    public static final int COLON=11;
    public static final int COLONCOLON=35;
    public static final int WS=43;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int SNAME=46;
    public static final int T__70=70;
    public static final int RCURLY=32;
    public static final int GT=26;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int QMARK=22;
    public static final int T__73=73;
    public static final int LE=27;
    public static final int STRING=5;

    // delegates
    // delegators


        public LOTOSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LOTOSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return LOTOSParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/LOTOS.g"; }


       private static final String syntaxUUID = "LOTOS";
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
    // ./scenariotestTemp/generated2/LOTOS.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/LOTOS.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/LOTOS.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/LOTOS.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'is' | 'false' | 'true' | 'choice' | 'sorts' | 'library' | 'endtype' | 'process' | 'hide' | 'where' | 'of' | 'endproc' | 'in' | 'ofsort' | 'forall' | 'or' | 'let' | 'and' | 'endlib' | 'opns' | 'neq' | 'exit' | 'endspec' | 'eqns' | 'behaviour' | 'specification' | 'type' | 'eq' | 'noexit' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:218:3: ( (ast= NAME | 'is' | 'false' | 'true' | 'choice' | 'sorts' | 'library' | 'endtype' | 'process' | 'hide' | 'where' | 'of' | 'endproc' | 'in' | 'ofsort' | 'forall' | 'or' | 'let' | 'and' | 'endlib' | 'opns' | 'neq' | 'exit' | 'endspec' | 'eqns' | 'behaviour' | 'specification' | 'type' | 'eq' | 'noexit' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:219:3: (ast= NAME | 'is' | 'false' | 'true' | 'choice' | 'sorts' | 'library' | 'endtype' | 'process' | 'hide' | 'where' | 'of' | 'endproc' | 'in' | 'ofsort' | 'forall' | 'or' | 'let' | 'and' | 'endlib' | 'opns' | 'neq' | 'exit' | 'endspec' | 'eqns' | 'behaviour' | 'specification' | 'type' | 'eq' | 'noexit' )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:219:3: (ast= NAME | 'is' | 'false' | 'true' | 'choice' | 'sorts' | 'library' | 'endtype' | 'process' | 'hide' | 'where' | 'of' | 'endproc' | 'in' | 'ofsort' | 'forall' | 'or' | 'let' | 'and' | 'endlib' | 'opns' | 'neq' | 'exit' | 'endspec' | 'eqns' | 'behaviour' | 'specification' | 'type' | 'eq' | 'noexit' )
            int alt1=30;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 48:
                {
                alt1=2;
                }
                break;
            case 49:
                {
                alt1=3;
                }
                break;
            case 50:
                {
                alt1=4;
                }
                break;
            case 51:
                {
                alt1=5;
                }
                break;
            case 52:
                {
                alt1=6;
                }
                break;
            case 53:
                {
                alt1=7;
                }
                break;
            case 54:
                {
                alt1=8;
                }
                break;
            case 55:
                {
                alt1=9;
                }
                break;
            case 56:
                {
                alt1=10;
                }
                break;
            case 57:
                {
                alt1=11;
                }
                break;
            case 58:
                {
                alt1=12;
                }
                break;
            case 59:
                {
                alt1=13;
                }
                break;
            case 60:
                {
                alt1=14;
                }
                break;
            case 61:
                {
                alt1=15;
                }
                break;
            case 62:
                {
                alt1=16;
                }
                break;
            case 63:
                {
                alt1=17;
                }
                break;
            case 64:
                {
                alt1=18;
                }
                break;
            case 65:
                {
                alt1=19;
                }
                break;
            case 66:
                {
                alt1=20;
                }
                break;
            case 67:
                {
                alt1=21;
                }
                break;
            case 68:
                {
                alt1=22;
                }
                break;
            case 69:
                {
                alt1=23;
                }
                break;
            case 70:
                {
                alt1=24;
                }
                break;
            case 71:
                {
                alt1=25;
                }
                break;
            case 72:
                {
                alt1=26;
                }
                break;
            case 73:
                {
                alt1=27;
                }
                break;
            case 74:
                {
                alt1=28;
                }
                break;
            case 75:
                {
                alt1=29;
                }
                break;
            case 76:
                {
                alt1=30;
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
                    // ./scenariotestTemp/generated2/LOTOS.g:219:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:221:5: 'is'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "is";
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/LOTOS.g:222:5: 'false'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/LOTOS.g:223:5: 'true'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/LOTOS.g:224:5: 'choice'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "choice";
                    }

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/LOTOS.g:225:5: 'sorts'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "sorts";
                    }

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/LOTOS.g:226:5: 'library'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "library";
                    }

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/LOTOS.g:227:5: 'endtype'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endtype";
                    }

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/LOTOS.g:228:5: 'process'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "process";
                    }

                    }
                    break;
                case 10 :
                    // ./scenariotestTemp/generated2/LOTOS.g:229:5: 'hide'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "hide";
                    }

                    }
                    break;
                case 11 :
                    // ./scenariotestTemp/generated2/LOTOS.g:230:5: 'where'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "where";
                    }

                    }
                    break;
                case 12 :
                    // ./scenariotestTemp/generated2/LOTOS.g:231:5: 'of'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "of";
                    }

                    }
                    break;
                case 13 :
                    // ./scenariotestTemp/generated2/LOTOS.g:232:5: 'endproc'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endproc";
                    }

                    }
                    break;
                case 14 :
                    // ./scenariotestTemp/generated2/LOTOS.g:233:5: 'in'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 15 :
                    // ./scenariotestTemp/generated2/LOTOS.g:234:5: 'ofsort'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "ofsort";
                    }

                    }
                    break;
                case 16 :
                    // ./scenariotestTemp/generated2/LOTOS.g:235:5: 'forall'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forall";
                    }

                    }
                    break;
                case 17 :
                    // ./scenariotestTemp/generated2/LOTOS.g:236:5: 'or'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "or";
                    }

                    }
                    break;
                case 18 :
                    // ./scenariotestTemp/generated2/LOTOS.g:237:5: 'let'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword236); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "let";
                    }

                    }
                    break;
                case 19 :
                    // ./scenariotestTemp/generated2/LOTOS.g:238:5: 'and'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword244); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 20 :
                    // ./scenariotestTemp/generated2/LOTOS.g:239:5: 'endlib'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword252); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endlib";
                    }

                    }
                    break;
                case 21 :
                    // ./scenariotestTemp/generated2/LOTOS.g:240:5: 'opns'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword260); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "opns";
                    }

                    }
                    break;
                case 22 :
                    // ./scenariotestTemp/generated2/LOTOS.g:241:5: 'neq'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword268); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "neq";
                    }

                    }
                    break;
                case 23 :
                    // ./scenariotestTemp/generated2/LOTOS.g:242:5: 'exit'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword276); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "exit";
                    }

                    }
                    break;
                case 24 :
                    // ./scenariotestTemp/generated2/LOTOS.g:243:5: 'endspec'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endspec";
                    }

                    }
                    break;
                case 25 :
                    // ./scenariotestTemp/generated2/LOTOS.g:244:5: 'eqns'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "eqns";
                    }

                    }
                    break;
                case 26 :
                    // ./scenariotestTemp/generated2/LOTOS.g:245:5: 'behaviour'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword300); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "behaviour";
                    }

                    }
                    break;
                case 27 :
                    // ./scenariotestTemp/generated2/LOTOS.g:246:5: 'specification'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword308); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "specification";
                    }

                    }
                    break;
                case 28 :
                    // ./scenariotestTemp/generated2/LOTOS.g:247:5: 'type'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword316); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "type";
                    }

                    }
                    break;
                case 29 :
                    // ./scenariotestTemp/generated2/LOTOS.g:248:5: 'eq'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword324); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "eq";
                    }

                    }
                    break;
                case 30 :
                    // ./scenariotestTemp/generated2/LOTOS.g:249:5: 'noexit'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword332); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "noexit";
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
    // ./scenariotestTemp/generated2/LOTOS.g:256:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:257:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/LOTOS.g:258:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:258:3: (ast= STRING )
            // ./scenariotestTemp/generated2/LOTOS.g:258:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol363); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/LOTOS.g:266:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:267:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/LOTOS.g:268:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:268:3: (ast= INT )
            // ./scenariotestTemp/generated2/LOTOS.g:268:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol394); if (state.failed) return ret2;
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


    // $ANTLR start "floatSymbol"
    // ./scenariotestTemp/generated2/LOTOS.g:276:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:277:3: ( (ast= FLOAT ) )
            // ./scenariotestTemp/generated2/LOTOS.g:278:3: (ast= FLOAT )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:278:3: (ast= FLOAT )
            // ./scenariotestTemp/generated2/LOTOS.g:278:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol425); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/LOTOS.g:286:1: main returns [Object ret2] : ( (ret= lotos_specification ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:287:3: ( ( (ret= lotos_specification ) EOF ) )
            // ./scenariotestTemp/generated2/LOTOS.g:288:3: ( (ret= lotos_specification ) EOF )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:288:3: ( (ret= lotos_specification ) EOF )
            // ./scenariotestTemp/generated2/LOTOS.g:288:4: (ret= lotos_specification ) EOF
            {
            // ./scenariotestTemp/generated2/LOTOS.g:288:4: (ret= lotos_specification )
            // ./scenariotestTemp/generated2/LOTOS.g:288:5: ret= lotos_specification
            {
            pushFollow(FOLLOW_lotos_specification_in_main453);
            ret=lotos_specification();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main456); if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

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


    // $ANTLR start "lotos_specification"
    // ./scenariotestTemp/generated2/LOTOS.g:295:1: lotos_specification returns [Object ret2] : ( 'specification' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) ( ( (temp= lotos_type (temp= lotos_type )* )? ) ) 'behaviour' ( ( ( ( (temp= lotos_definition ) ) | ) ) ) 'endspec' ) ;
    public final Object lotos_specification() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Specification");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:300:3: ( ( 'specification' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) ( ( (temp= lotos_type (temp= lotos_type )* )? ) ) 'behaviour' ( ( ( ( (temp= lotos_definition ) ) | ) ) ) 'endspec' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:301:3: ( 'specification' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) ( ( (temp= lotos_type (temp= lotos_type )* )? ) ) 'behaviour' ( ( ( ( (temp= lotos_definition ) ) | ) ) ) 'endspec' )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:301:3: ( 'specification' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) ( ( (temp= lotos_type (temp= lotos_type )* )? ) ) 'behaviour' ( ( ( ( (temp= lotos_definition ) ) | ) ) ) 'endspec' )
            // ./scenariotestTemp/generated2/LOTOS.g:301:4: 'specification' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) ( ( (temp= lotos_type (temp= lotos_type )* )? ) ) 'behaviour' ( ( ( ( (temp= lotos_definition ) ) | ) ) ) 'endspec'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,73,FOLLOW_73_in_lotos_specification487); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:301:69: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:301:71: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_specification494);
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
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:301:155: ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LSQUARE) ) {
                alt4=1;
            }
            else if ( (LA4_0==COLON) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:301:156: ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:301:172: ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE )
                    // ./scenariotestTemp/generated2/LOTOS.g:301:173: LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LSQUARE,FOLLOW_LSQUARE_in_lotos_specification507); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:301:232: (temp= identifier ( ( COMA ) temp= identifier )* )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==NAME) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ./scenariotestTemp/generated2/LOTOS.g:301:234: temp= identifier ( ( COMA ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_lotos_specification515);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "gates", temp);
                            }
                            // ./scenariotestTemp/generated2/LOTOS.g:301:285: ( ( COMA ) temp= identifier )*
                            loop2:
                            do {
                                int alt2=2;
                                int LA2_0 = input.LA(1);

                                if ( (LA2_0==COMA) ) {
                                    alt2=1;
                                }


                                switch (alt2) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/LOTOS.g:301:286: ( COMA ) temp= identifier
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/LOTOS.g:301:303: ( COMA )
                            	    // ./scenariotestTemp/generated2/LOTOS.g:301:304: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_lotos_specification524); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_identifier_in_lotos_specification532);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "gates", temp);
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
                      _beforeSeqEl();
                    }
                    match(input,RSQUARE,FOLLOW_RSQUARE_in_lotos_specification544); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/LOTOS.g:301:493: 
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
              _beforeSeqEl();
            }
            match(input,COLON,FOLLOW_COLON_in_lotos_specification562); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:302:75: ( ( 'exit' ) | ( 'noexit' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==69) ) {
                alt5=1;
            }
            else if ( (LA5_0==76) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:302:76: ( 'exit' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:302:92: ( 'exit' )
                    // ./scenariotestTemp/generated2/LOTOS.g:302:93: 'exit'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,69,FOLLOW_69_in_lotos_specification572); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isExit", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:302:203: ( 'noexit' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:302:219: ( 'noexit' )
                    // ./scenariotestTemp/generated2/LOTOS.g:302:220: 'noexit'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,76,FOLLOW_76_in_lotos_specification585); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isExit", java.lang.Boolean.FALSE);
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
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:303:34: ( ( (temp= lotos_type (temp= lotos_type )* )? ) )
            // ./scenariotestTemp/generated2/LOTOS.g:303:35: ( (temp= lotos_type (temp= lotos_type )* )? )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:303:35: ( (temp= lotos_type (temp= lotos_type )* )? )
            // ./scenariotestTemp/generated2/LOTOS.g:303:36: (temp= lotos_type (temp= lotos_type )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:303:53: (temp= lotos_type (temp= lotos_type )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==53||LA7_0==74) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:303:55: temp= lotos_type (temp= lotos_type )*
                    {
                    pushFollow(FOLLOW_lotos_type_in_lotos_specification602);
                    temp=lotos_type();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "types", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:303:106: (temp= lotos_type )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==53||LA6_0==74) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:303:108: temp= lotos_type
                    	    {
                    	    pushFollow(FOLLOW_lotos_type_in_lotos_specification610);
                    	    temp=lotos_type();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "types", temp);
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

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,72,FOLLOW_72_in_lotos_specification624); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:303:259: ( ( ( ( (temp= lotos_definition ) ) | ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:303:260: ( ( ( (temp= lotos_definition ) ) | ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:303:260: ( ( ( (temp= lotos_definition ) ) | ) )
            // ./scenariotestTemp/generated2/LOTOS.g:303:261: ( ( (temp= lotos_definition ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:303:279: ( ( (temp= lotos_definition ) ) | )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==NAME||LA8_0==LPAREN||LA8_0==RARROW||LA8_0==51||LA8_0==56||LA8_0==64) ) {
                alt8=1;
            }
            else if ( (LA8_0==70) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:303:280: ( (temp= lotos_definition ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:303:296: ( (temp= lotos_definition ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:303:297: (temp= lotos_definition )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:303:314: (temp= lotos_definition )
                    // ./scenariotestTemp/generated2/LOTOS.g:303:316: temp= lotos_definition
                    {
                    pushFollow(FOLLOW_lotos_definition_in_lotos_specification640);
                    temp=lotos_definition();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "definition", temp);
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
                    // ./scenariotestTemp/generated2/LOTOS.g:303:412: 
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
              _beforeSeqEl();
            }
            match(input,70,FOLLOW_70_in_lotos_specification662); if (state.failed) return ret2;
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
    // $ANTLR end "lotos_specification"


    // $ANTLR start "lotos_definition"
    // ./scenariotestTemp/generated2/LOTOS.g:312:1: lotos_definition returns [Object ret2] : ( ( ( (temp= lotos_behaviour ) ) ) ( ( 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) ) ) | ) ) ;
    public final Object lotos_definition() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Definition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:317:3: ( ( ( ( (temp= lotos_behaviour ) ) ) ( ( 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) ) ) | ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:318:3: ( ( ( (temp= lotos_behaviour ) ) ) ( ( 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) ) ) | ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:318:3: ( ( ( (temp= lotos_behaviour ) ) ) ( ( 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) ) ) | ) )
            // ./scenariotestTemp/generated2/LOTOS.g:318:4: ( ( (temp= lotos_behaviour ) ) ) ( ( 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:318:21: ( ( (temp= lotos_behaviour ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:318:22: ( (temp= lotos_behaviour ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:318:22: ( (temp= lotos_behaviour ) )
            // ./scenariotestTemp/generated2/LOTOS.g:318:23: (temp= lotos_behaviour )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:318:40: (temp= lotos_behaviour )
            // ./scenariotestTemp/generated2/LOTOS.g:318:42: temp= lotos_behaviour
            {
            pushFollow(FOLLOW_lotos_behaviour_in_lotos_definition709);
            temp=lotos_behaviour();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "behaviour", temp);
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
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:318:154: ( ( 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) ) ) | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==57) ) {
                alt11=1;
            }
            else if ( (LA11_0==EOF||LA11_0==59||LA11_0==70) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:318:155: ( 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:318:171: ( 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:318:172: 'where' ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,57,FOLLOW_57_in_lotos_definition724); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:318:229: ( ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:318:230: ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:318:230: ( (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )? )
                    // ./scenariotestTemp/generated2/LOTOS.g:318:231: (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:318:248: (temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==53||LA10_0==55||LA10_0==74) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ./scenariotestTemp/generated2/LOTOS.g:318:250: temp= lotos_typeorprocessdeclaration (temp= lotos_typeorprocessdeclaration )*
                            {
                            pushFollow(FOLLOW_lotos_typeorprocessdeclaration_in_lotos_definition734);
                            temp=lotos_typeorprocessdeclaration();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "declarations", temp);
                            }
                            // ./scenariotestTemp/generated2/LOTOS.g:318:328: (temp= lotos_typeorprocessdeclaration )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==53||LA9_0==55||LA9_0==74) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/LOTOS.g:318:330: temp= lotos_typeorprocessdeclaration
                            	    {
                            	    pushFollow(FOLLOW_lotos_typeorprocessdeclaration_in_lotos_definition742);
                            	    temp=lotos_typeorprocessdeclaration();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "declarations", temp);
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
                    // ./scenariotestTemp/generated2/LOTOS.g:318:465: 
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
    // $ANTLR end "lotos_definition"


    // $ANTLR start "lotos_typeorprocessdeclaration"
    // ./scenariotestTemp/generated2/LOTOS.g:327:1: lotos_typeorprocessdeclaration returns [Object ret2] : (ret= lotos_process | ret= lotos_type ) ;
    public final Object lotos_typeorprocessdeclaration() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:328:3: ( (ret= lotos_process | ret= lotos_type ) )
            // ./scenariotestTemp/generated2/LOTOS.g:329:3: (ret= lotos_process | ret= lotos_type )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:329:3: (ret= lotos_process | ret= lotos_type )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==55) ) {
                alt12=1;
            }
            else if ( (LA12_0==53||LA12_0==74) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:329:4: ret= lotos_process
                    {
                    pushFollow(FOLLOW_lotos_process_in_lotos_typeorprocessdeclaration803);
                    ret=lotos_process();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:330:5: ret= lotos_type
                    {
                    pushFollow(FOLLOW_lotos_type_in_lotos_typeorprocessdeclaration811);
                    ret=lotos_type();

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
    // $ANTLR end "lotos_typeorprocessdeclaration"


    // $ANTLR start "lotos_process"
    // ./scenariotestTemp/generated2/LOTOS.g:337:1: lotos_process returns [Object ret2] : ( 'process' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) ( ( LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) COLONEQ (temp= lotos_definition ) 'endproc' ) ;
    public final Object lotos_process() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Process");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:342:3: ( ( 'process' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) ( ( LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) COLONEQ (temp= lotos_definition ) 'endproc' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:343:3: ( 'process' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) ( ( LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) COLONEQ (temp= lotos_definition ) 'endproc' )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:343:3: ( 'process' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) ( ( LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) COLONEQ (temp= lotos_definition ) 'endproc' )
            // ./scenariotestTemp/generated2/LOTOS.g:343:4: 'process' (temp= identifier ) ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | ) ( ( LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN ) | ) COLON ( ( 'exit' ) | ( 'noexit' ) ) COLONEQ (temp= lotos_definition ) 'endproc'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,55,FOLLOW_55_in_lotos_process841); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:343:63: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:343:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_process848);
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
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:343:149: ( ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ) | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LSQUARE) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=COLON && LA15_0<=LPAREN)) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:343:150: ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:343:166: ( LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE )
                    // ./scenariotestTemp/generated2/LOTOS.g:343:167: LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LSQUARE,FOLLOW_LSQUARE_in_lotos_process861); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:343:226: (temp= identifier ( ( COMA ) temp= identifier )* )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==NAME) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ./scenariotestTemp/generated2/LOTOS.g:343:228: temp= identifier ( ( COMA ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_lotos_process869);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "gates", temp);
                            }
                            // ./scenariotestTemp/generated2/LOTOS.g:343:279: ( ( COMA ) temp= identifier )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==COMA) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/LOTOS.g:343:280: ( COMA ) temp= identifier
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/LOTOS.g:343:297: ( COMA )
                            	    // ./scenariotestTemp/generated2/LOTOS.g:343:298: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_lotos_process878); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_identifier_in_lotos_process886);
                            	    temp=identifier();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "gates", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RSQUARE,FOLLOW_RSQUARE_in_lotos_process898); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/LOTOS.g:343:487: 
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
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:344:35: ( ( LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN ) | )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LPAREN) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:344:36: ( LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:344:52: ( LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN )
                    // ./scenariotestTemp/generated2/LOTOS.g:344:53: LPAREN (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )? RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_lotos_process922); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:344:111: (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==NAME||LA17_0==COLON) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ./scenariotestTemp/generated2/LOTOS.g:344:113: temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )*
                            {
                            pushFollow(FOLLOW_lotos_variabledeclarations_in_lotos_process930);
                            temp=lotos_variabledeclarations();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "variables", temp);
                            }
                            // ./scenariotestTemp/generated2/LOTOS.g:344:184: ( ( COMA ) temp= lotos_variabledeclarations )*
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( (LA16_0==COMA) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/LOTOS.g:344:185: ( COMA ) temp= lotos_variabledeclarations
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/LOTOS.g:344:202: ( COMA )
                            	    // ./scenariotestTemp/generated2/LOTOS.g:344:203: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_lotos_process939); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_lotos_variabledeclarations_in_lotos_process947);
                            	    temp=lotos_variabledeclarations();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "variables", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_lotos_process959); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/LOTOS.g:344:411: 
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
              _beforeSeqEl();
            }
            match(input,COLON,FOLLOW_COLON_in_lotos_process977); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:345:75: ( ( 'exit' ) | ( 'noexit' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==69) ) {
                alt19=1;
            }
            else if ( (LA19_0==76) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:345:76: ( 'exit' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:345:92: ( 'exit' )
                    // ./scenariotestTemp/generated2/LOTOS.g:345:93: 'exit'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,69,FOLLOW_69_in_lotos_process987); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isExit", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:345:203: ( 'noexit' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:345:219: ( 'noexit' )
                    // ./scenariotestTemp/generated2/LOTOS.g:345:220: 'noexit'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,76,FOLLOW_76_in_lotos_process1000); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isExit", java.lang.Boolean.FALSE);
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
              _beforeSeqEl();
            }
            match(input,COLONEQ,FOLLOW_COLONEQ_in_lotos_process1011); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:346:76: (temp= lotos_definition )
            // ./scenariotestTemp/generated2/LOTOS.g:346:78: temp= lotos_definition
            {
            pushFollow(FOLLOW_lotos_definition_in_lotos_process1019);
            temp=lotos_definition();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "definition", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,59,FOLLOW_59_in_lotos_process1025); if (state.failed) return ret2;
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
    // $ANTLR end "lotos_process"


    // $ANTLR start "primary_lotos_behaviour"
    // ./scenariotestTemp/generated2/LOTOS.g:354:1: primary_lotos_behaviour returns [Object ret2] : (ret= lotos_processcall | ( LPAREN ret= lotos_behaviour RPAREN ) ) ;
    public final Object primary_lotos_behaviour() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:355:3: ( (ret= lotos_processcall | ( LPAREN ret= lotos_behaviour RPAREN ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:356:3: (ret= lotos_processcall | ( LPAREN ret= lotos_behaviour RPAREN ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:356:3: (ret= lotos_processcall | ( LPAREN ret= lotos_behaviour RPAREN ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NAME) ) {
                alt20=1;
            }
            else if ( (LA20_0==LPAREN) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:356:4: ret= lotos_processcall
                    {
                    pushFollow(FOLLOW_lotos_processcall_in_primary_lotos_behaviour1062);
                    ret=lotos_processcall();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:357:5: ( LPAREN ret= lotos_behaviour RPAREN )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:357:5: ( LPAREN ret= lotos_behaviour RPAREN )
                    // ./scenariotestTemp/generated2/LOTOS.g:357:6: LPAREN ret= lotos_behaviour RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_lotos_behaviour1071); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_lotos_behaviour_in_primary_lotos_behaviour1077);
                    ret=lotos_behaviour();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_lotos_behaviour1081); if (state.failed) return ret2;
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
    // $ANTLR end "primary_lotos_behaviour"


    // $ANTLR start "behaviour_priority_0"
    // ./scenariotestTemp/generated2/LOTOS.g:364:1: behaviour_priority_0 returns [Object ret2] : ( ( ( ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) ) ) ) | (ret= primary_lotos_behaviour ) ) ;
    public final Object behaviour_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:365:3: ( ( ( ( ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) ) ) ) | (ret= primary_lotos_behaviour ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:366:4: ( ( ( ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) ) ) ) | (ret= primary_lotos_behaviour ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:366:4: ( ( ( ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) ) ) ) | (ret= primary_lotos_behaviour ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==SEMI||(LA21_1>=QMARK && LA21_1<=EXCL)) ) {
                    alt21=1;
                }
                else if ( (LA21_1==LSQUARE) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA21_0==LPAREN) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:366:5: ( ( ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) ) ) )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:366:5: ( ( ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) ) ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:366:6: ( ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) ) )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:366:6: ( ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:366:7: ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpSeq(";", 1, false);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:366:36: ( (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:366:37: (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:366:37: (ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0 )
                    // ./scenariotestTemp/generated2/LOTOS.g:366:38: ret= lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken] SEMI right= behaviour_priority_0
                    {
                    pushFollow(FOLLOW_lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp_in_behaviour_priority_01121);
                    ret=lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp(opName, null, firstToken);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_behaviour_priority_01124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      opName = ";";
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    pushFollow(FOLLOW_behaviour_priority_0_in_behaviour_priority_01130);
                    right=behaviour_priority_0();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "behaviour", right);
                      this.setLocationAndComment(ret, firstToken);

                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                      _exitOpSeq();
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:370:2: (ret= primary_lotos_behaviour )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:370:2: (ret= primary_lotos_behaviour )
                    // ./scenariotestTemp/generated2/LOTOS.g:370:4: ret= primary_lotos_behaviour
                    {
                    pushFollow(FOLLOW_primary_lotos_behaviour_in_behaviour_priority_01146);
                    ret=primary_lotos_behaviour();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

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
    // $ANTLR end "behaviour_priority_0"


    // $ANTLR start "behaviour_priority_1"
    // ./scenariotestTemp/generated2/LOTOS.g:378:1: behaviour_priority_1 returns [Object ret2] : ( ( ( ( RARROW ) () )=> ( RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) ) ) ) | (ret= behaviour_priority_0 ) ) ;
    public final Object behaviour_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:379:3: ( ( ( ( ( RARROW ) () )=> ( RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) ) ) ) | (ret= behaviour_priority_0 ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:380:4: ( ( ( ( RARROW ) () )=> ( RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) ) ) ) | (ret= behaviour_priority_0 ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:380:4: ( ( ( ( RARROW ) () )=> ( RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) ) ) ) | (ret= behaviour_priority_0 ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RARROW) ) {
                alt22=1;
            }
            else if ( (LA22_0==NAME||LA22_0==LPAREN) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:380:5: ( ( ( RARROW ) () )=> ( RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) ) ) )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:380:5: ( ( ( RARROW ) () )=> ( RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) ) ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:380:6: ( ( RARROW ) () )=> ( RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) ) )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:380:20: ( RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:380:21: RARROW ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpSeq("->", 1, false);
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_behaviour_priority_11192); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      opName = "->";
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:380:107: ( (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:380:108: (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:380:108: (ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0 )
                    // ./scenariotestTemp/generated2/LOTOS.g:380:109: ret= lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken] right= behaviour_priority_0
                    {
                    pushFollow(FOLLOW_lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp_in_behaviour_priority_11200);
                    ret=lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp(opName, null, firstToken);

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    pushFollow(FOLLOW_behaviour_priority_0_in_behaviour_priority_11204);
                    right=behaviour_priority_0();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "behaviour", right);
                      this.setLocationAndComment(ret, firstToken);

                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                      _exitOpSeq();
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:384:2: (ret= behaviour_priority_0 )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:384:2: (ret= behaviour_priority_0 )
                    // ./scenariotestTemp/generated2/LOTOS.g:384:4: ret= behaviour_priority_0
                    {
                    pushFollow(FOLLOW_behaviour_priority_0_in_behaviour_priority_11220);
                    ret=behaviour_priority_0();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

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
    // $ANTLR end "behaviour_priority_1"


    // $ANTLR start "behaviour_priority_2"
    // ./scenariotestTemp/generated2/LOTOS.g:392:1: behaviour_priority_2 returns [Object ret2] : ( (ret= behaviour_priority_1 ( ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) ) )* ) ) ;
    public final Object behaviour_priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:393:3: ( ( (ret= behaviour_priority_1 ( ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:394:4: ( (ret= behaviour_priority_1 ( ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:394:4: ( (ret= behaviour_priority_1 ( ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/LOTOS.g:394:6: (ret= behaviour_priority_1 ( ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:394:6: (ret= behaviour_priority_1 ( ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) ) )* )
            // ./scenariotestTemp/generated2/LOTOS.g:394:8: ret= behaviour_priority_1 ( ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_behaviour_priority_1_in_behaviour_priority_21259);
            ret=behaviour_priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/LOTOS.g:394:32: ( ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==LSQUARERSQUARE) && (synpred52_LOTOS())) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:394:33: ( ( LSQUARERSQUARE ) () )=> ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:394:55: ( LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:394:56: LSQUARERSQUARE ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("[]", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LSQUARERSQUARE,FOLLOW_LSQUARERSQUARE_in_behaviour_priority_21272); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "[]";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:394:150: ( (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:394:151: (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:394:151: (ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:394:152: ret= lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken] right= behaviour_priority_1
            	    {
            	    pushFollow(FOLLOW_lotos_alternative_LOTOS_Alternative_alternativeOp_in_behaviour_priority_21280);
            	    ret=lotos_alternative_LOTOS_Alternative_alternativeOp(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_behaviour_priority_1_in_behaviour_priority_21284);
            	    right=behaviour_priority_1();

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
            	    break loop23;
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
    // $ANTLR end "behaviour_priority_2"


    // $ANTLR start "behaviour_priority_3"
    // ./scenariotestTemp/generated2/LOTOS.g:404:1: behaviour_priority_3 returns [Object ret2] : ( (ret= behaviour_priority_2 ( ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) | ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) )* ) ) ;
    public final Object behaviour_priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:405:3: ( ( (ret= behaviour_priority_2 ( ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) | ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:406:4: ( (ret= behaviour_priority_2 ( ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) | ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:406:4: ( (ret= behaviour_priority_2 ( ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) | ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/LOTOS.g:406:6: (ret= behaviour_priority_2 ( ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) | ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:406:6: (ret= behaviour_priority_2 ( ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) | ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) )* )
            // ./scenariotestTemp/generated2/LOTOS.g:406:8: ret= behaviour_priority_2 ( ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) | ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_behaviour_priority_2_in_behaviour_priority_31331);
            ret=behaviour_priority_2();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/LOTOS.g:406:32: ( ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) | ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) ) )*
            loop24:
            do {
                int alt24=3;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==PIPE3) && (synpred53_LOTOS())) {
                    alt24=1;
                }
                else if ( (LA24_0==PIPELSQUARE) && (synpred54_LOTOS())) {
                    alt24=2;
                }


                switch (alt24) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:406:33: ( ( PIPE3 ) () )=> ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:406:46: ( PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:406:47: PIPE3 ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("|||", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PIPE3,FOLLOW_PIPE3_in_behaviour_priority_31344); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "|||";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:406:134: ( (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:406:135: (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:406:135: (ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:406:136: ret= lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken] right= behaviour_priority_2
            	    {
            	    pushFollow(FOLLOW_lotos_simpleparallel_LOTOS_SimpleParallel_parOp_in_behaviour_priority_31352);
            	    ret=lotos_simpleparallel_LOTOS_SimpleParallel_parOp(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_behaviour_priority_2_in_behaviour_priority_31356);
            	    right=behaviour_priority_2();

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
            	    // ./scenariotestTemp/generated2/LOTOS.g:409:3: ( ( PIPELSQUARE ) () )=> ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:409:22: ( PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:409:23: PIPELSQUARE ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("|[", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PIPELSQUARE,FOLLOW_PIPELSQUARE_in_behaviour_priority_31377); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "|[";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:409:114: ( (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:409:115: (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:409:115: (ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:409:116: ret= lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken] right= behaviour_priority_2
            	    {
            	    pushFollow(FOLLOW_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp_in_behaviour_priority_31385);
            	    ret=lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_behaviour_priority_2_in_behaviour_priority_31389);
            	    right=behaviour_priority_2();

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
            	    break loop24;
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
    // $ANTLR end "behaviour_priority_3"


    // $ANTLR start "lotos_behaviour"
    // ./scenariotestTemp/generated2/LOTOS.g:419:1: lotos_behaviour returns [Object ret2] : (ret= behaviour_priority_3 | ret= lotos_choice | ret= lotos_hide | ret= lotos_let ) ;
    public final Object lotos_behaviour() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:420:3: ( (ret= behaviour_priority_3 | ret= lotos_choice | ret= lotos_hide | ret= lotos_let ) )
            // ./scenariotestTemp/generated2/LOTOS.g:421:3: (ret= behaviour_priority_3 | ret= lotos_choice | ret= lotos_hide | ret= lotos_let )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:421:3: (ret= behaviour_priority_3 | ret= lotos_choice | ret= lotos_hide | ret= lotos_let )
            int alt25=4;
            switch ( input.LA(1) ) {
            case NAME:
            case LPAREN:
            case RARROW:
                {
                alt25=1;
                }
                break;
            case 51:
                {
                alt25=2;
                }
                break;
            case 56:
                {
                alt25=3;
                }
                break;
            case 64:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:421:4: ret= behaviour_priority_3
                    {
                    pushFollow(FOLLOW_behaviour_priority_3_in_lotos_behaviour1428);
                    ret=behaviour_priority_3();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:422:5: ret= lotos_choice
                    {
                    pushFollow(FOLLOW_lotos_choice_in_lotos_behaviour1436);
                    ret=lotos_choice();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/LOTOS.g:423:5: ret= lotos_hide
                    {
                    pushFollow(FOLLOW_lotos_hide_in_lotos_behaviour1444);
                    ret=lotos_hide();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/LOTOS.g:424:5: ret= lotos_let
                    {
                    pushFollow(FOLLOW_lotos_let_in_lotos_behaviour1452);
                    ret=lotos_let();

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
    // $ANTLR end "lotos_behaviour"


    // $ANTLR start "lotos_let"
    // ./scenariotestTemp/generated2/LOTOS.g:431:1: lotos_let returns [Object ret2] : ( 'let' (temp= lotos_variabledeclarations ) EQ (temp= lotos_value ) 'in' ( ( (temp= lotos_behaviour ) ) ) ) ;
    public final Object lotos_let() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Let");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:436:3: ( ( 'let' (temp= lotos_variabledeclarations ) EQ (temp= lotos_value ) 'in' ( ( (temp= lotos_behaviour ) ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:437:3: ( 'let' (temp= lotos_variabledeclarations ) EQ (temp= lotos_value ) 'in' ( ( (temp= lotos_behaviour ) ) ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:437:3: ( 'let' (temp= lotos_variabledeclarations ) EQ (temp= lotos_value ) 'in' ( ( (temp= lotos_behaviour ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:437:4: 'let' (temp= lotos_variabledeclarations ) EQ (temp= lotos_value ) 'in' ( ( (temp= lotos_behaviour ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,64,FOLLOW_64_in_lotos_let1482); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:437:59: (temp= lotos_variabledeclarations )
            // ./scenariotestTemp/generated2/LOTOS.g:437:61: temp= lotos_variabledeclarations
            {
            pushFollow(FOLLOW_lotos_variabledeclarations_in_lotos_let1489);
            temp=lotos_variabledeclarations();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "variables", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_lotos_let1496); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:437:202: (temp= lotos_value )
            // ./scenariotestTemp/generated2/LOTOS.g:437:204: temp= lotos_value
            {
            pushFollow(FOLLOW_lotos_value_in_lotos_let1504);
            temp=lotos_value();

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
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,60,FOLLOW_60_in_lotos_let1510); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:437:326: ( ( (temp= lotos_behaviour ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:437:327: ( (temp= lotos_behaviour ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:437:327: ( (temp= lotos_behaviour ) )
            // ./scenariotestTemp/generated2/LOTOS.g:437:328: (temp= lotos_behaviour )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:437:345: (temp= lotos_behaviour )
            // ./scenariotestTemp/generated2/LOTOS.g:437:347: temp= lotos_behaviour
            {
            pushFollow(FOLLOW_lotos_behaviour_in_lotos_let1520);
            temp=lotos_behaviour();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "behaviour", temp);
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
    // $ANTLR end "lotos_let"


    // $ANTLR start "lotos_choice"
    // ./scenariotestTemp/generated2/LOTOS.g:445:1: lotos_choice returns [Object ret2] : ( 'choice' (temp= lotos_variabledeclarations ) LSQUARERSQUARE ( ( (temp= lotos_behaviour ) ) ) ) ;
    public final Object lotos_choice() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Choice");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:450:3: ( ( 'choice' (temp= lotos_variabledeclarations ) LSQUARERSQUARE ( ( (temp= lotos_behaviour ) ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:451:3: ( 'choice' (temp= lotos_variabledeclarations ) LSQUARERSQUARE ( ( (temp= lotos_behaviour ) ) ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:451:3: ( 'choice' (temp= lotos_variabledeclarations ) LSQUARERSQUARE ( ( (temp= lotos_behaviour ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:451:4: 'choice' (temp= lotos_variabledeclarations ) LSQUARERSQUARE ( ( (temp= lotos_behaviour ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,51,FOLLOW_51_in_lotos_choice1566); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:451:62: (temp= lotos_variabledeclarations )
            // ./scenariotestTemp/generated2/LOTOS.g:451:64: temp= lotos_variabledeclarations
            {
            pushFollow(FOLLOW_lotos_variabledeclarations_in_lotos_choice1573);
            temp=lotos_variabledeclarations();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "variables", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LSQUARERSQUARE,FOLLOW_LSQUARERSQUARE_in_lotos_choice1580); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:451:217: ( ( (temp= lotos_behaviour ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:451:218: ( (temp= lotos_behaviour ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:451:218: ( (temp= lotos_behaviour ) )
            // ./scenariotestTemp/generated2/LOTOS.g:451:219: (temp= lotos_behaviour )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:451:236: (temp= lotos_behaviour )
            // ./scenariotestTemp/generated2/LOTOS.g:451:238: temp= lotos_behaviour
            {
            pushFollow(FOLLOW_lotos_behaviour_in_lotos_choice1591);
            temp=lotos_behaviour();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "behaviour", temp);
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
    // $ANTLR end "lotos_choice"


    // $ANTLR start "lotos_hide"
    // ./scenariotestTemp/generated2/LOTOS.g:459:1: lotos_hide returns [Object ret2] : ( 'hide' (temp= identifier ( ( COMA ) temp= identifier )* )? 'in' ( ( (temp= lotos_behaviour ) ) ) ) ;
    public final Object lotos_hide() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Hide");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:464:3: ( ( 'hide' (temp= identifier ( ( COMA ) temp= identifier )* )? 'in' ( ( (temp= lotos_behaviour ) ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:465:3: ( 'hide' (temp= identifier ( ( COMA ) temp= identifier )* )? 'in' ( ( (temp= lotos_behaviour ) ) ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:465:3: ( 'hide' (temp= identifier ( ( COMA ) temp= identifier )* )? 'in' ( ( (temp= lotos_behaviour ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:465:4: 'hide' (temp= identifier ( ( COMA ) temp= identifier )* )? 'in' ( ( (temp= lotos_behaviour ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,56,FOLLOW_56_in_lotos_hide1637); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:465:60: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==NAME) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:465:62: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_lotos_hide1644);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "gates", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:465:113: ( ( COMA ) temp= identifier )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==COMA) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:465:114: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/LOTOS.g:465:131: ( COMA )
                    	    // ./scenariotestTemp/generated2/LOTOS.g:465:132: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_lotos_hide1653); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_lotos_hide1661);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "gates", temp);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,60,FOLLOW_60_in_lotos_hide1672); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:465:315: ( ( (temp= lotos_behaviour ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:465:316: ( (temp= lotos_behaviour ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:465:316: ( (temp= lotos_behaviour ) )
            // ./scenariotestTemp/generated2/LOTOS.g:465:317: (temp= lotos_behaviour )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:465:334: (temp= lotos_behaviour )
            // ./scenariotestTemp/generated2/LOTOS.g:465:336: temp= lotos_behaviour
            {
            pushFollow(FOLLOW_lotos_behaviour_in_lotos_hide1682);
            temp=lotos_behaviour();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "behaviour", temp);
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
    // $ANTLR end "lotos_hide"


    // $ANTLR start "lotos_processcall"
    // ./scenariotestTemp/generated2/LOTOS.g:473:1: lotos_processcall returns [Object ret2] : ( (temp= identifier ) LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ( ( LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN ) | ) ) ;
    public final Object lotos_processcall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","ProcessCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:478:3: ( ( (temp= identifier ) LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ( ( LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN ) | ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:479:3: ( (temp= identifier ) LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ( ( LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN ) | ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:479:3: ( (temp= identifier ) LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ( ( LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN ) | ) )
            // ./scenariotestTemp/generated2/LOTOS.g:479:4: (temp= identifier ) LSQUARE (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUARE ( ( LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:479:21: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:479:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_processcall1732);
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
              _beforeSeqEl();
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_lotos_processcall1739); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:479:148: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==NAME) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:479:150: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_lotos_processcall1747);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "gates", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:479:201: ( ( COMA ) temp= identifier )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==COMA) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:479:202: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/LOTOS.g:479:219: ( COMA )
                    	    // ./scenariotestTemp/generated2/LOTOS.g:479:220: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_lotos_processcall1756); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_lotos_processcall1764);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "gates", temp);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_lotos_processcall1776); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:479:409: ( ( LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN ) | )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LPAREN) ) {
                alt32=1;
            }
            else if ( (LA32_0==EOF||LA32_0==RPAREN||(LA32_0>=LSQUARERSQUARE && LA32_0<=PIPELSQUARE)||LA32_0==57||LA32_0==59||LA32_0==70) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:479:410: ( LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:479:426: ( LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN )
                    // ./scenariotestTemp/generated2/LOTOS.g:479:427: LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_lotos_processcall1787); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:479:485: (temp= lotos_value ( ( COMA ) temp= lotos_value )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==NAME||LA31_0==INT||LA31_0==LPAREN||(LA31_0>=49 && LA31_0<=50)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ./scenariotestTemp/generated2/LOTOS.g:479:487: temp= lotos_value ( ( COMA ) temp= lotos_value )*
                            {
                            pushFollow(FOLLOW_lotos_value_in_lotos_processcall1795);
                            temp=lotos_value();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "arguments", temp);
                            }
                            // ./scenariotestTemp/generated2/LOTOS.g:479:543: ( ( COMA ) temp= lotos_value )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==COMA) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/LOTOS.g:479:544: ( COMA ) temp= lotos_value
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/LOTOS.g:479:561: ( COMA )
                            	    // ./scenariotestTemp/generated2/LOTOS.g:479:562: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_lotos_processcall1804); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_lotos_value_in_lotos_processcall1812);
                            	    temp=lotos_value();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "arguments", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop30;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_lotos_processcall1824); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/LOTOS.g:479:755: 
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
    // $ANTLR end "lotos_processcall"


    // $ANTLR start "lotos_simpleparallel_LOTOS_SimpleParallel_parOp"
    // ./scenariotestTemp/generated2/LOTOS.g:488:1: lotos_simpleparallel_LOTOS_SimpleParallel_parOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object lotos_simpleparallel_LOTOS_SimpleParallel_parOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("LOTOS","SimpleParallel");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:493:3: ()
            // ./scenariotestTemp/generated2/LOTOS.g:494:3: 
            {
            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
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
    // $ANTLR end "lotos_simpleparallel_LOTOS_SimpleParallel_parOp"


    // $ANTLR start "lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp"
    // ./scenariotestTemp/generated2/LOTOS.g:504:1: lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUAREPIPE ) ;
    public final Object lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","GatedParallel");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:509:3: ( ( (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUAREPIPE ) )
            // ./scenariotestTemp/generated2/LOTOS.g:510:3: ( (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUAREPIPE )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:510:3: ( (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUAREPIPE )
            // ./scenariotestTemp/generated2/LOTOS.g:510:4: (temp= identifier ( ( COMA ) temp= identifier )* )? RSQUAREPIPE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:510:21: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==NAME) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:510:23: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp1911);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "gates", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:510:74: ( ( COMA ) temp= identifier )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==COMA) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:510:75: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/LOTOS.g:510:92: ( COMA )
                    	    // ./scenariotestTemp/generated2/LOTOS.g:510:93: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp1920); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp1928);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "gates", temp);
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
              _beforeSeqEl();
            }
            match(input,RSQUAREPIPE,FOLLOW_RSQUAREPIPE_in_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp1940); if (state.failed) return ret2;
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
    // $ANTLR end "lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp"


    // $ANTLR start "lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp"
    // ./scenariotestTemp/generated2/LOTOS.g:520:1: lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) ;
    public final Object lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","GuardedBehaviour");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:525:3: ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) )
            // ./scenariotestTemp/generated2/LOTOS.g:526:3: ( LSQUARE (temp= lotos_guardexpression ) RSQUARE )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:526:3: ( LSQUARE (temp= lotos_guardexpression ) RSQUARE )
            // ./scenariotestTemp/generated2/LOTOS.g:526:4: LSQUARE (temp= lotos_guardexpression ) RSQUARE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp1975); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:526:63: (temp= lotos_guardexpression )
            // ./scenariotestTemp/generated2/LOTOS.g:526:65: temp= lotos_guardexpression
            {
            pushFollow(FOLLOW_lotos_guardexpression_in_lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp1983);
            temp=lotos_guardexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "guard", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp1990); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"behaviour" , left);
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
    // $ANTLR end "lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp"


    // $ANTLR start "lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp"
    // ./scenariotestTemp/generated2/LOTOS.g:536:1: lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= lotos_action ) ) ;
    public final Object lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","ActionBehaviour");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:541:3: ( ( (temp= lotos_action ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:542:3: ( (temp= lotos_action ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:542:3: ( (temp= lotos_action ) )
            // ./scenariotestTemp/generated2/LOTOS.g:542:4: (temp= lotos_action )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:542:21: (temp= lotos_action )
            // ./scenariotestTemp/generated2/LOTOS.g:542:23: temp= lotos_action
            {
            pushFollow(FOLLOW_lotos_action_in_lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp2028);
            temp=lotos_action();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "action", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"behaviour" , left);
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
    // $ANTLR end "lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp"


    // $ANTLR start "lotos_alternative_LOTOS_Alternative_alternativeOp"
    // ./scenariotestTemp/generated2/LOTOS.g:553:1: lotos_alternative_LOTOS_Alternative_alternativeOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object lotos_alternative_LOTOS_Alternative_alternativeOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("LOTOS","Alternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:558:3: ()
            // ./scenariotestTemp/generated2/LOTOS.g:559:3: 
            {
            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
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
    // $ANTLR end "lotos_alternative_LOTOS_Alternative_alternativeOp"


    // $ANTLR start "lotos_action"
    // ./scenariotestTemp/generated2/LOTOS.g:569:1: lotos_action returns [Object ret2] : (ret= lotos_gateaction ) ;
    public final Object lotos_action() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:570:3: ( (ret= lotos_gateaction ) )
            // ./scenariotestTemp/generated2/LOTOS.g:571:3: (ret= lotos_gateaction )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:571:3: (ret= lotos_gateaction )
            // ./scenariotestTemp/generated2/LOTOS.g:571:4: ret= lotos_gateaction
            {
            pushFollow(FOLLOW_lotos_gateaction_in_lotos_action2088);
            ret=lotos_gateaction();

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
    // $ANTLR end "lotos_action"


    // $ANTLR start "lotos_gateaction"
    // ./scenariotestTemp/generated2/LOTOS.g:578:1: lotos_gateaction returns [Object ret2] : ( (temp= identifier ) ( ( (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | ) ) | ) ) ;
    public final Object lotos_gateaction() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","GateAction");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:583:3: ( ( (temp= identifier ) ( ( (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | ) ) | ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:584:3: ( (temp= identifier ) ( ( (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | ) ) | ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:584:3: ( (temp= identifier ) ( ( (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | ) ) | ) )
            // ./scenariotestTemp/generated2/LOTOS.g:584:4: (temp= identifier ) ( ( (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:584:21: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:584:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_gateaction2122);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "gate", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:584:107: ( ( (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | ) ) | )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=QMARK && LA37_0<=EXCL)) ) {
                alt37=1;
            }
            else if ( (LA37_0==SEMI) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:584:108: ( (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:584:124: ( (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | ) )
                    // ./scenariotestTemp/generated2/LOTOS.g:584:125: (temp= lotos_communication (temp= lotos_communication )* ) ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:584:142: (temp= lotos_communication (temp= lotos_communication )* )
                    // ./scenariotestTemp/generated2/LOTOS.g:584:144: temp= lotos_communication (temp= lotos_communication )*
                    {
                    pushFollow(FOLLOW_lotos_communication_in_lotos_gateaction2138);
                    temp=lotos_communication();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "communications", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:584:213: (temp= lotos_communication )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( ((LA35_0>=QMARK && LA35_0<=EXCL)) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:584:215: temp= lotos_communication
                    	    {
                    	    pushFollow(FOLLOW_lotos_communication_in_lotos_gateaction2146);
                    	    temp=lotos_communication();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "communications", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:584:321: ( ( LSQUARE (temp= lotos_guardexpression ) RSQUARE ) | )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==LSQUARE) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==SEMI) ) {
                        alt36=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ./scenariotestTemp/generated2/LOTOS.g:584:322: ( LSQUARE (temp= lotos_guardexpression ) RSQUARE )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./scenariotestTemp/generated2/LOTOS.g:584:338: ( LSQUARE (temp= lotos_guardexpression ) RSQUARE )
                            // ./scenariotestTemp/generated2/LOTOS.g:584:339: LSQUARE (temp= lotos_guardexpression ) RSQUARE
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,LSQUARE,FOLLOW_LSQUARE_in_lotos_gateaction2162); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            // ./scenariotestTemp/generated2/LOTOS.g:584:398: (temp= lotos_guardexpression )
                            // ./scenariotestTemp/generated2/LOTOS.g:584:400: temp= lotos_guardexpression
                            {
                            pushFollow(FOLLOW_lotos_guardexpression_in_lotos_gateaction2170);
                            temp=lotos_guardexpression();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "guard", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,RSQUARE,FOLLOW_RSQUARE_in_lotos_gateaction2177); if (state.failed) return ret2;
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
                            // ./scenariotestTemp/generated2/LOTOS.g:584:538: 
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
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:585:35: 
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
    // $ANTLR end "lotos_gateaction"


    // $ANTLR start "lotos_communication"
    // ./scenariotestTemp/generated2/LOTOS.g:594:1: lotos_communication returns [Object ret2] : (ret= lotos_incomm | ret= lotos_outcomm ) ;
    public final Object lotos_communication() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:595:3: ( (ret= lotos_incomm | ret= lotos_outcomm ) )
            // ./scenariotestTemp/generated2/LOTOS.g:596:3: (ret= lotos_incomm | ret= lotos_outcomm )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:596:3: (ret= lotos_incomm | ret= lotos_outcomm )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==QMARK) ) {
                alt38=1;
            }
            else if ( (LA38_0==EXCL) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:596:4: ret= lotos_incomm
                    {
                    pushFollow(FOLLOW_lotos_incomm_in_lotos_communication2241);
                    ret=lotos_incomm();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:597:5: ret= lotos_outcomm
                    {
                    pushFollow(FOLLOW_lotos_outcomm_in_lotos_communication2249);
                    ret=lotos_outcomm();

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
    // $ANTLR end "lotos_communication"


    // $ANTLR start "lotos_incomm"
    // ./scenariotestTemp/generated2/LOTOS.g:604:1: lotos_incomm returns [Object ret2] : ( QMARK (temp= lotos_variabledeclarations ) ) ;
    public final Object lotos_incomm() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","InComm");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:609:3: ( ( QMARK (temp= lotos_variabledeclarations ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:610:3: ( QMARK (temp= lotos_variabledeclarations ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:610:3: ( QMARK (temp= lotos_variabledeclarations ) )
            // ./scenariotestTemp/generated2/LOTOS.g:610:4: QMARK (temp= lotos_variabledeclarations )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,QMARK,FOLLOW_QMARK_in_lotos_incomm2280); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:610:61: (temp= lotos_variabledeclarations )
            // ./scenariotestTemp/generated2/LOTOS.g:610:63: temp= lotos_variabledeclarations
            {
            pushFollow(FOLLOW_lotos_variabledeclarations_in_lotos_incomm2288);
            temp=lotos_variabledeclarations();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "declarations", temp);
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
    // $ANTLR end "lotos_incomm"


    // $ANTLR start "lotos_outcomm"
    // ./scenariotestTemp/generated2/LOTOS.g:618:1: lotos_outcomm returns [Object ret2] : ( EXCL (temp= lotos_value ) ) ;
    public final Object lotos_outcomm() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","OutComm");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:623:3: ( ( EXCL (temp= lotos_value ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:624:3: ( EXCL (temp= lotos_value ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:624:3: ( EXCL (temp= lotos_value ) )
            // ./scenariotestTemp/generated2/LOTOS.g:624:4: EXCL (temp= lotos_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EXCL,FOLLOW_EXCL_in_lotos_outcomm2332); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:624:60: (temp= lotos_value )
            // ./scenariotestTemp/generated2/LOTOS.g:624:62: temp= lotos_value
            {
            pushFollow(FOLLOW_lotos_value_in_lotos_outcomm2340);
            temp=lotos_value();

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
    // $ANTLR end "lotos_outcomm"


    // $ANTLR start "lotos_guardexpression"
    // ./scenariotestTemp/generated2/LOTOS.g:632:1: lotos_guardexpression returns [Object ret2] : (ret= lotos_equalitytestguardexp | ret= lotos_booleanguardexp ) ;
    public final Object lotos_guardexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:633:3: ( (ret= lotos_equalitytestguardexp | ret= lotos_booleanguardexp ) )
            // ./scenariotestTemp/generated2/LOTOS.g:634:3: (ret= lotos_equalitytestguardexp | ret= lotos_booleanguardexp )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:634:3: (ret= lotos_equalitytestguardexp | ret= lotos_booleanguardexp )
            int alt39=2;
            switch ( input.LA(1) ) {
            case 50:
                {
                int LA39_1 = input.LA(2);

                if ( (synpred71_LOTOS()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA39_2 = input.LA(2);

                if ( (synpred71_LOTOS()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 2, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                int LA39_3 = input.LA(2);

                if ( (synpred71_LOTOS()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 3, input);

                    throw nvae;
                }
                }
                break;
            case NAME:
                {
                int LA39_4 = input.LA(2);

                if ( (synpred71_LOTOS()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 4, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                int LA39_5 = input.LA(2);

                if ( (synpred71_LOTOS()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 5, input);

                    throw nvae;
                }
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
                    // ./scenariotestTemp/generated2/LOTOS.g:634:4: ret= lotos_equalitytestguardexp
                    {
                    pushFollow(FOLLOW_lotos_equalitytestguardexp_in_lotos_guardexpression2380);
                    ret=lotos_equalitytestguardexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:635:5: ret= lotos_booleanguardexp
                    {
                    pushFollow(FOLLOW_lotos_booleanguardexp_in_lotos_guardexpression2388);
                    ret=lotos_booleanguardexp();

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
    // $ANTLR end "lotos_guardexpression"


    // $ANTLR start "lotos_equalitytestguardexp"
    // ./scenariotestTemp/generated2/LOTOS.g:642:1: lotos_equalitytestguardexp returns [Object ret2] : ( (temp= lotos_value ) EQ (temp= lotos_value ) ) ;
    public final Object lotos_equalitytestguardexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","EqualityTestGuardExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:647:3: ( ( (temp= lotos_value ) EQ (temp= lotos_value ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:648:3: ( (temp= lotos_value ) EQ (temp= lotos_value ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:648:3: ( (temp= lotos_value ) EQ (temp= lotos_value ) )
            // ./scenariotestTemp/generated2/LOTOS.g:648:4: (temp= lotos_value ) EQ (temp= lotos_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:648:21: (temp= lotos_value )
            // ./scenariotestTemp/generated2/LOTOS.g:648:23: temp= lotos_value
            {
            pushFollow(FOLLOW_lotos_value_in_lotos_equalitytestguardexp2422);
            temp=lotos_value();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "left", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_lotos_equalitytestguardexp2429); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:648:144: (temp= lotos_value )
            // ./scenariotestTemp/generated2/LOTOS.g:648:146: temp= lotos_value
            {
            pushFollow(FOLLOW_lotos_value_in_lotos_equalitytestguardexp2437);
            temp=lotos_value();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "right", temp);
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
    // $ANTLR end "lotos_equalitytestguardexp"


    // $ANTLR start "lotos_booleanguardexp"
    // ./scenariotestTemp/generated2/LOTOS.g:656:1: lotos_booleanguardexp returns [Object ret2] : ( (temp= lotos_value ) ) ;
    public final Object lotos_booleanguardexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","BooleanGuardExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:661:3: ( ( (temp= lotos_value ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:662:3: ( (temp= lotos_value ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:662:3: ( (temp= lotos_value ) )
            // ./scenariotestTemp/generated2/LOTOS.g:662:4: (temp= lotos_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:662:21: (temp= lotos_value )
            // ./scenariotestTemp/generated2/LOTOS.g:662:23: temp= lotos_value
            {
            pushFollow(FOLLOW_lotos_value_in_lotos_booleanguardexp2484);
            temp=lotos_value();

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
    // $ANTLR end "lotos_booleanguardexp"


    // $ANTLR start "primary_lotos_value"
    // ./scenariotestTemp/generated2/LOTOS.g:670:1: primary_lotos_value returns [Object ret2] : (ret= lotos_booleanval | ret= lotos_integerval | ret= lotos_operationcall | ret= lotos_variable | ( LPAREN ret= lotos_value RPAREN ) ) ;
    public final Object primary_lotos_value() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:671:3: ( (ret= lotos_booleanval | ret= lotos_integerval | ret= lotos_operationcall | ret= lotos_variable | ( LPAREN ret= lotos_value RPAREN ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:672:3: (ret= lotos_booleanval | ret= lotos_integerval | ret= lotos_operationcall | ret= lotos_variable | ( LPAREN ret= lotos_value RPAREN ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:672:3: (ret= lotos_booleanval | ret= lotos_integerval | ret= lotos_operationcall | ret= lotos_variable | ( LPAREN ret= lotos_value RPAREN ) )
            int alt40=5;
            switch ( input.LA(1) ) {
            case 49:
            case 50:
                {
                alt40=1;
                }
                break;
            case INT:
                {
                alt40=2;
                }
                break;
            case NAME:
                {
                int LA40_3 = input.LA(2);

                if ( (LA40_3==LPAREN) ) {
                    alt40=3;
                }
                else if ( (LA40_3==EOF||(LA40_3>=LSQUARE && LA40_3<=RSQUARE)||LA40_3==RPAREN||LA40_3==SEMI||LA40_3==EQ||(LA40_3>=QMARK && LA40_3<=IMPLIES)||LA40_3==58||LA40_3==60||LA40_3==63||LA40_3==65||LA40_3==68||LA40_3==75) ) {
                    alt40=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 3, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                alt40=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:672:4: ret= lotos_booleanval
                    {
                    pushFollow(FOLLOW_lotos_booleanval_in_primary_lotos_value2524);
                    ret=lotos_booleanval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:673:5: ret= lotos_integerval
                    {
                    pushFollow(FOLLOW_lotos_integerval_in_primary_lotos_value2532);
                    ret=lotos_integerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/LOTOS.g:674:5: ret= lotos_operationcall
                    {
                    pushFollow(FOLLOW_lotos_operationcall_in_primary_lotos_value2540);
                    ret=lotos_operationcall();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/LOTOS.g:675:5: ret= lotos_variable
                    {
                    pushFollow(FOLLOW_lotos_variable_in_primary_lotos_value2548);
                    ret=lotos_variable();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/LOTOS.g:676:5: ( LPAREN ret= lotos_value RPAREN )
                    {
                    // ./scenariotestTemp/generated2/LOTOS.g:676:5: ( LPAREN ret= lotos_value RPAREN )
                    // ./scenariotestTemp/generated2/LOTOS.g:676:6: LPAREN ret= lotos_value RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_lotos_value2557); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_lotos_value_in_primary_lotos_value2563);
                    ret=lotos_value();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_lotos_value2567); if (state.failed) return ret2;
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
    // $ANTLR end "primary_lotos_value"


    // $ANTLR start "value_priority_0"
    // ./scenariotestTemp/generated2/LOTOS.g:683:1: value_priority_0 returns [Object ret2] : ( (ret= primary_lotos_value ( ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object value_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:684:3: ( ( (ret= primary_lotos_value ( ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:685:4: ( (ret= primary_lotos_value ( ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:685:4: ( (ret= primary_lotos_value ( ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) ) )* ) )
            // ./scenariotestTemp/generated2/LOTOS.g:685:6: (ret= primary_lotos_value ( ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:685:6: (ret= primary_lotos_value ( ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) ) )* )
            // ./scenariotestTemp/generated2/LOTOS.g:685:8: ret= primary_lotos_value ( ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_lotos_value_in_value_priority_02605);
            ret=primary_lotos_value();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/LOTOS.g:685:31: ( ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==58) && (synpred76_LOTOS())) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:685:32: ( ( 'of' ) () )=> ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:685:44: ( 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:685:45: 'of' ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("of", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,58,FOLLOW_58_in_value_priority_02618); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "of";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:685:128: ( (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:685:129: (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:685:129: (ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken] )
            	    // ./scenariotestTemp/generated2/LOTOS.g:685:130: ret= lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_lotos_castval_LOTOS_CastVal_opOf_in_value_priority_02625);
            	    ret=lotos_castval_LOTOS_CastVal_opOf(opName, ret, firstToken);

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
            	    break loop41;
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
    // $ANTLR end "value_priority_0"


    // $ANTLR start "value_priority_1"
    // ./scenariotestTemp/generated2/LOTOS.g:693:1: value_priority_1 returns [Object ret2] : ( (ret= value_priority_0 ( ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) ) )* ) ) ;
    public final Object value_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:694:3: ( ( (ret= value_priority_0 ( ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:695:4: ( (ret= value_priority_0 ( ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:695:4: ( (ret= value_priority_0 ( ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/LOTOS.g:695:6: (ret= value_priority_0 ( ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:695:6: (ret= value_priority_0 ( ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) ) )* )
            // ./scenariotestTemp/generated2/LOTOS.g:695:8: ret= value_priority_0 ( ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) ) )*
            {
            pushFollow(FOLLOW_value_priority_0_in_value_priority_12671);
            ret=value_priority_0();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/LOTOS.g:695:28: ( ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==PLUS) && (synpred77_LOTOS())) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:695:29: ( ( PLUS ) () )=> ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:695:41: ( PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:695:42: PLUS ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PLUS,FOLLOW_PLUS_in_value_priority_12684); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:695:124: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:695:125: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:695:125: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:695:126: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_0
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_12692);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_0_in_value_priority_12696);
            	    right=value_priority_0();

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
            	    break loop42;
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
    // $ANTLR end "value_priority_1"


    // $ANTLR start "value_priority_2"
    // ./scenariotestTemp/generated2/LOTOS.g:705:1: value_priority_2 returns [Object ret2] : ( (ret= value_priority_1 ( ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) )* ) ) ;
    public final Object value_priority_2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:706:3: ( ( (ret= value_priority_1 ( ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:707:4: ( (ret= value_priority_1 ( ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:707:4: ( (ret= value_priority_1 ( ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/LOTOS.g:707:6: (ret= value_priority_1 ( ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:707:6: (ret= value_priority_1 ( ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) )* )
            // ./scenariotestTemp/generated2/LOTOS.g:707:8: ret= value_priority_1 ( ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) )*
            {
            pushFollow(FOLLOW_value_priority_1_in_value_priority_22743);
            ret=value_priority_1();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/LOTOS.g:707:28: ( ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) | ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) ) )*
            loop43:
            do {
                int alt43=7;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==75) && (synpred78_LOTOS())) {
                    alt43=1;
                }
                else if ( (LA43_0==GE) && (synpred79_LOTOS())) {
                    alt43=2;
                }
                else if ( (LA43_0==GT) && (synpred80_LOTOS())) {
                    alt43=3;
                }
                else if ( (LA43_0==LE) && (synpred81_LOTOS())) {
                    alt43=4;
                }
                else if ( (LA43_0==LT) && (synpred82_LOTOS())) {
                    alt43=5;
                }
                else if ( (LA43_0==68) && (synpred83_LOTOS())) {
                    alt43=6;
                }


                switch (alt43) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:707:29: ( ( 'eq' ) () )=> ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:707:41: ( 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:707:42: 'eq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("eq", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,75,FOLLOW_75_in_value_priority_22756); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "eq";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:707:125: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:707:126: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:707:126: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:707:127: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22763);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_1_in_value_priority_22767);
            	    right=value_priority_1();

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
            	    // ./scenariotestTemp/generated2/LOTOS.g:710:3: ( ( GE ) () )=> ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:710:13: ( GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:710:14: GE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,GE,FOLLOW_GE_in_value_priority_22788); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:710:96: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:710:97: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:710:97: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:710:98: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22796);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_1_in_value_priority_22800);
            	    right=value_priority_1();

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
            	    // ./scenariotestTemp/generated2/LOTOS.g:713:3: ( ( GT ) () )=> ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:713:13: ( GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:713:14: GT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(">", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,GT,FOLLOW_GT_in_value_priority_22821); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ">";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:713:94: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:713:95: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:713:95: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:713:96: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22829);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_1_in_value_priority_22833);
            	    right=value_priority_1();

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
            	    // ./scenariotestTemp/generated2/LOTOS.g:716:3: ( ( LE ) () )=> ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:716:13: ( LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:716:14: LE ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<=", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LE,FOLLOW_LE_in_value_priority_22854); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<=";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:716:96: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:716:97: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:716:97: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:716:98: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22862);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_1_in_value_priority_22866);
            	    right=value_priority_1();

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
            	    // ./scenariotestTemp/generated2/LOTOS.g:719:3: ( ( LT ) () )=> ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:719:13: ( LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:719:14: LT ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("<", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,LT,FOLLOW_LT_in_value_priority_22887); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "<";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:719:94: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:719:95: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:719:95: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:719:96: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22895);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_1_in_value_priority_22899);
            	    right=value_priority_1();

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
            	    // ./scenariotestTemp/generated2/LOTOS.g:722:3: ( ( 'neq' ) () )=> ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:722:16: ( 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:722:17: 'neq' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("neq", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,68,FOLLOW_68_in_value_priority_22920); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "neq";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:722:103: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:722:104: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:722:104: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:722:105: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_1
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22927);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_1_in_value_priority_22931);
            	    right=value_priority_1();

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
            	    break loop43;
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
    // $ANTLR end "value_priority_2"


    // $ANTLR start "value_priority_3"
    // ./scenariotestTemp/generated2/LOTOS.g:732:1: value_priority_3 returns [Object ret2] : ( (ret= value_priority_2 ( ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) )* ) ) ;
    public final Object value_priority_3() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/LOTOS.g:733:3: ( ( (ret= value_priority_2 ( ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:734:4: ( (ret= value_priority_2 ( ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:734:4: ( (ret= value_priority_2 ( ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) )* ) )
            // ./scenariotestTemp/generated2/LOTOS.g:734:6: (ret= value_priority_2 ( ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:734:6: (ret= value_priority_2 ( ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) )* )
            // ./scenariotestTemp/generated2/LOTOS.g:734:8: ret= value_priority_2 ( ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) )*
            {
            pushFollow(FOLLOW_value_priority_2_in_value_priority_32978);
            ret=value_priority_2();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/LOTOS.g:734:28: ( ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) | ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) ) )*
            loop44:
            do {
                int alt44=3;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==65) && (synpred84_LOTOS())) {
                    alt44=1;
                }
                else if ( (LA44_0==63) && (synpred85_LOTOS())) {
                    alt44=2;
                }


                switch (alt44) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:734:29: ( ( 'and' ) () )=> ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:734:42: ( 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:734:43: 'and' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("and", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,65,FOLLOW_65_in_value_priority_32991); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "and";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:734:129: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:734:130: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:734:130: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:734:131: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_32998);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_2_in_value_priority_33002);
            	    right=value_priority_2();

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
            	    // ./scenariotestTemp/generated2/LOTOS.g:737:3: ( ( 'or' ) () )=> ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:737:15: ( 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:737:16: 'or' ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("or", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,63,FOLLOW_63_in_value_priority_33023); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "or";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:737:99: ( (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 ) )
            	    // ./scenariotestTemp/generated2/LOTOS.g:737:100: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 )
            	    {
            	    // ./scenariotestTemp/generated2/LOTOS.g:737:100: (ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2 )
            	    // ./scenariotestTemp/generated2/LOTOS.g:737:101: ret= lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken] right= value_priority_2
            	    {
            	    pushFollow(FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_33030);
            	    ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_value_priority_2_in_value_priority_33034);
            	    right=value_priority_2();

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
            	    break loop44;
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
    // $ANTLR end "value_priority_3"


    // $ANTLR start "lotos_value"
    // ./scenariotestTemp/generated2/LOTOS.g:747:1: lotos_value returns [Object ret2] : ret= value_priority_3 ;
    public final Object lotos_value() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:748:3: (ret= value_priority_3 )
            // ./scenariotestTemp/generated2/LOTOS.g:749:3: ret= value_priority_3
            {
            pushFollow(FOLLOW_value_priority_3_in_lotos_value3072);
            ret=value_priority_3();

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
    // $ANTLR end "lotos_value"


    // $ANTLR start "lotos_variable"
    // ./scenariotestTemp/generated2/LOTOS.g:756:1: lotos_variable returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object lotos_variable() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Variable");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:761:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:762:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:762:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/LOTOS.g:762:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:762:21: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:762:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_variable3105);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "declaration", list("LOTOS","Declaration"), "name", temp, null, "never", null, false, null);
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
    // $ANTLR end "lotos_variable"


    // $ANTLR start "lotos_operationcall"
    // ./scenariotestTemp/generated2/LOTOS.g:770:1: lotos_operationcall returns [Object ret2] : ( (temp= identifier ) LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN ) ;
    public final Object lotos_operationcall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","OperationCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:775:3: ( ( (temp= identifier ) LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN ) )
            // ./scenariotestTemp/generated2/LOTOS.g:776:3: ( (temp= identifier ) LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:776:3: ( (temp= identifier ) LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN )
            // ./scenariotestTemp/generated2/LOTOS.g:776:4: (temp= identifier ) LPAREN (temp= lotos_value ( ( COMA ) temp= lotos_value )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:776:21: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:776:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_operationcall3152);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "operationName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_lotos_operationcall3159); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:776:156: (temp= lotos_value ( ( COMA ) temp= lotos_value )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==NAME||LA46_0==INT||LA46_0==LPAREN||(LA46_0>=49 && LA46_0<=50)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:776:158: temp= lotos_value ( ( COMA ) temp= lotos_value )*
                    {
                    pushFollow(FOLLOW_lotos_value_in_lotos_operationcall3167);
                    temp=lotos_value();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "arguments", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:776:214: ( ( COMA ) temp= lotos_value )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==COMA) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:776:215: ( COMA ) temp= lotos_value
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/LOTOS.g:776:232: ( COMA )
                    	    // ./scenariotestTemp/generated2/LOTOS.g:776:233: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_lotos_operationcall3176); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_lotos_value_in_lotos_operationcall3184);
                    	    temp=lotos_value();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "arguments", temp);
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
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_lotos_operationcall3196); if (state.failed) return ret2;
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
    // $ANTLR end "lotos_operationcall"


    // $ANTLR start "lotos_integerval"
    // ./scenariotestTemp/generated2/LOTOS.g:784:1: lotos_integerval returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object lotos_integerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","IntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:789:3: ( ( (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:790:3: ( (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:790:3: ( (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/LOTOS.g:790:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:790:21: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/LOTOS.g:790:23: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_lotos_integerval3241);
            temp=integerSymbol();

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
    // $ANTLR end "lotos_integerval"


    // $ANTLR start "lotos_booleanval"
    // ./scenariotestTemp/generated2/LOTOS.g:798:1: lotos_booleanval returns [Object ret2] : ( ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object lotos_booleanval() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("LOTOS","BooleanVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:803:3: ( ( ( ( 'true' ) | ( 'false' ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:804:3: ( ( ( 'true' ) | ( 'false' ) ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:804:3: ( ( ( 'true' ) | ( 'false' ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:804:4: ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:804:22: ( ( 'true' ) | ( 'false' ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==50) ) {
                alt47=1;
            }
            else if ( (LA47_0==49) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:804:23: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:804:39: ( 'true' )
                    // ./scenariotestTemp/generated2/LOTOS.g:804:40: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,50,FOLLOW_50_in_lotos_booleanval3290); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:804:149: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:804:165: ( 'false' )
                    // ./scenariotestTemp/generated2/LOTOS.g:804:166: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,49,FOLLOW_49_in_lotos_booleanval3303); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", java.lang.Boolean.FALSE);
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
    // $ANTLR end "lotos_booleanval"


    // $ANTLR start "lotos_castval_LOTOS_CastVal_opOf"
    // ./scenariotestTemp/generated2/LOTOS.g:813:1: lotos_castval_LOTOS_CastVal_opOf[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object lotos_castval_LOTOS_CastVal_opOf(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","CastVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:818:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:819:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:819:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/LOTOS.g:819:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:819:21: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:819:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_castval_LOTOS_CastVal_opOf3355);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "toType", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"value" , left);
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
    // $ANTLR end "lotos_castval_LOTOS_CastVal_opOf"


    // $ANTLR start "lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr"
    // ./scenariotestTemp/generated2/LOTOS.g:829:1: lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("LOTOS","OperatorCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:834:3: ()
            // ./scenariotestTemp/generated2/LOTOS.g:835:3: 
            {
            if ( state.backtracking==0 ) {

              setProperty(ret,"operatorName" , opName);
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
    // $ANTLR end "lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr"


    // $ANTLR start "lotos_variabledeclaration"
    // ./scenariotestTemp/generated2/LOTOS.g:845:1: lotos_variabledeclaration returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object lotos_variabledeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","VariableDeclaration");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:850:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:851:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:851:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/LOTOS.g:851:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:851:21: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:851:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_variabledeclaration3422);
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
    // $ANTLR end "lotos_variabledeclaration"


    // $ANTLR start "lotos_variabledeclarations"
    // ./scenariotestTemp/generated2/LOTOS.g:859:1: lotos_variabledeclarations returns [Object ret2] : ( (temp= lotos_variabledeclaration ( ( COMA ) temp= lotos_variabledeclaration )* )? COLON (temp= identifier ) ) ;
    public final Object lotos_variabledeclarations() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","VariableDeclarations");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:864:3: ( ( (temp= lotos_variabledeclaration ( ( COMA ) temp= lotos_variabledeclaration )* )? COLON (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:865:3: ( (temp= lotos_variabledeclaration ( ( COMA ) temp= lotos_variabledeclaration )* )? COLON (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:865:3: ( (temp= lotos_variabledeclaration ( ( COMA ) temp= lotos_variabledeclaration )* )? COLON (temp= identifier ) )
            // ./scenariotestTemp/generated2/LOTOS.g:865:4: (temp= lotos_variabledeclaration ( ( COMA ) temp= lotos_variabledeclaration )* )? COLON (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:865:21: (temp= lotos_variabledeclaration ( ( COMA ) temp= lotos_variabledeclaration )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==NAME) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:865:23: temp= lotos_variabledeclaration ( ( COMA ) temp= lotos_variabledeclaration )*
                    {
                    pushFollow(FOLLOW_lotos_variabledeclaration_in_lotos_variabledeclarations3469);
                    temp=lotos_variabledeclaration();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "declarations", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:865:96: ( ( COMA ) temp= lotos_variabledeclaration )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==COMA) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:865:97: ( COMA ) temp= lotos_variabledeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/LOTOS.g:865:114: ( COMA )
                    	    // ./scenariotestTemp/generated2/LOTOS.g:865:115: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_lotos_variabledeclarations3478); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_lotos_variabledeclaration_in_lotos_variabledeclarations3486);
                    	    temp=lotos_variabledeclaration();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "declarations", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLON,FOLLOW_COLON_in_lotos_variabledeclarations3498); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:865:323: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:865:325: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_variabledeclarations3506);
            temp=identifier();

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
    // $ANTLR end "lotos_variabledeclarations"


    // $ANTLR start "lotos_type"
    // ./scenariotestTemp/generated2/LOTOS.g:873:1: lotos_type returns [Object ret2] : (ret= lotos_librarylist | ret= lotos_typedefinition ) ;
    public final Object lotos_type() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:874:3: ( (ret= lotos_librarylist | ret= lotos_typedefinition ) )
            // ./scenariotestTemp/generated2/LOTOS.g:875:3: (ret= lotos_librarylist | ret= lotos_typedefinition )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:875:3: (ret= lotos_librarylist | ret= lotos_typedefinition )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==53) ) {
                alt50=1;
            }
            else if ( (LA50_0==74) ) {
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
                    // ./scenariotestTemp/generated2/LOTOS.g:875:4: ret= lotos_librarylist
                    {
                    pushFollow(FOLLOW_lotos_librarylist_in_lotos_type3546);
                    ret=lotos_librarylist();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:876:5: ret= lotos_typedefinition
                    {
                    pushFollow(FOLLOW_lotos_typedefinition_in_lotos_type3554);
                    ret=lotos_typedefinition();

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
    // $ANTLR end "lotos_type"


    // $ANTLR start "lotos_librarylist"
    // ./scenariotestTemp/generated2/LOTOS.g:883:1: lotos_librarylist returns [Object ret2] : ( 'library' (temp= identifier ( ( COMA ) temp= identifier )* )? 'endlib' ) ;
    public final Object lotos_librarylist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","LibraryList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:888:3: ( ( 'library' (temp= identifier ( ( COMA ) temp= identifier )* )? 'endlib' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:889:3: ( 'library' (temp= identifier ( ( COMA ) temp= identifier )* )? 'endlib' )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:889:3: ( 'library' (temp= identifier ( ( COMA ) temp= identifier )* )? 'endlib' )
            // ./scenariotestTemp/generated2/LOTOS.g:889:4: 'library' (temp= identifier ( ( COMA ) temp= identifier )* )? 'endlib'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,53,FOLLOW_53_in_lotos_librarylist3584); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:889:63: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==NAME) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:889:65: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_lotos_librarylist3591);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "names", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:889:116: ( ( COMA ) temp= identifier )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==COMA) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:889:117: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/LOTOS.g:889:134: ( COMA )
                    	    // ./scenariotestTemp/generated2/LOTOS.g:889:135: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_lotos_librarylist3600); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_lotos_librarylist3608);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "names", temp);
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
              _beforeSeqEl();
            }
            match(input,66,FOLLOW_66_in_lotos_librarylist3619); if (state.failed) return ret2;
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
    // $ANTLR end "lotos_librarylist"


    // $ANTLR start "lotos_typedefinition"
    // ./scenariotestTemp/generated2/LOTOS.g:897:1: lotos_typedefinition returns [Object ret2] : ( 'type' (temp= identifier ) 'is' (temp= identifier ( ( COMA ) temp= identifier )* ) ( ( 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) ) ) ) 'endtype' ) ;
    public final Object lotos_typedefinition() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","TypeDefinition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:902:3: ( ( 'type' (temp= identifier ) 'is' (temp= identifier ( ( COMA ) temp= identifier )* ) ( ( 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) ) ) ) 'endtype' ) )
            // ./scenariotestTemp/generated2/LOTOS.g:903:3: ( 'type' (temp= identifier ) 'is' (temp= identifier ( ( COMA ) temp= identifier )* ) ( ( 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) ) ) ) 'endtype' )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:903:3: ( 'type' (temp= identifier ) 'is' (temp= identifier ( ( COMA ) temp= identifier )* ) ( ( 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) ) ) ) 'endtype' )
            // ./scenariotestTemp/generated2/LOTOS.g:903:4: 'type' (temp= identifier ) 'is' (temp= identifier ( ( COMA ) temp= identifier )* ) ( ( 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) ) ) ) 'endtype'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,74,FOLLOW_74_in_lotos_typedefinition3659); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:60: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:903:62: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_typedefinition3666);
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
              _beforeSeqEl();
            }
            match(input,48,FOLLOW_48_in_lotos_typedefinition3672); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:182: (temp= identifier ( ( COMA ) temp= identifier )* )
            // ./scenariotestTemp/generated2/LOTOS.g:903:184: temp= identifier ( ( COMA ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_lotos_typedefinition3679);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "types", temp);
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:235: ( ( COMA ) temp= identifier )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==COMA) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:903:236: ( COMA ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:903:253: ( COMA )
            	    // ./scenariotestTemp/generated2/LOTOS.g:903:254: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_lotos_typedefinition3688); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_lotos_typedefinition3696);
            	    temp=identifier();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "types", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:398: ( ( 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:903:399: ( 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:903:399: ( 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:903:400: 'sorts' (temp= identifier ( ( COMA ) temp= identifier )* )? 'opns' ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) ) 'eqns' ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,52,FOLLOW_52_in_lotos_typedefinition3708); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:457: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==NAME) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:903:459: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_lotos_typedefinition3715);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sorts", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:903:510: ( ( COMA ) temp= identifier )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==COMA) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:903:511: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/LOTOS.g:903:528: ( COMA )
                    	    // ./scenariotestTemp/generated2/LOTOS.g:903:529: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_lotos_typedefinition3724); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_lotos_typedefinition3732);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "sorts", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,67,FOLLOW_67_in_lotos_typedefinition3743); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:714: ( ( (temp= lotos_operations (temp= lotos_operations )* )? ) )
            // ./scenariotestTemp/generated2/LOTOS.g:903:715: ( (temp= lotos_operations (temp= lotos_operations )* )? )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:903:715: ( (temp= lotos_operations (temp= lotos_operations )* )? )
            // ./scenariotestTemp/generated2/LOTOS.g:903:716: (temp= lotos_operations (temp= lotos_operations )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:733: (temp= lotos_operations (temp= lotos_operations )* )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==NAME) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:903:735: temp= lotos_operations (temp= lotos_operations )*
                    {
                    pushFollow(FOLLOW_lotos_operations_in_lotos_typedefinition3753);
                    temp=lotos_operations();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operations", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:903:797: (temp= lotos_operations )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==NAME) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:903:799: temp= lotos_operations
                    	    {
                    	    pushFollow(FOLLOW_lotos_operations_in_lotos_typedefinition3761);
                    	    temp=lotos_operations();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "operations", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop56;
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
              _beforeSeqEl();
            }
            match(input,71,FOLLOW_71_in_lotos_typedefinition3775); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:956: ( ( (temp= lotos_equations (temp= lotos_equations )* )? ) )
            // ./scenariotestTemp/generated2/LOTOS.g:903:957: ( (temp= lotos_equations (temp= lotos_equations )* )? )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:903:957: ( (temp= lotos_equations (temp= lotos_equations )* )? )
            // ./scenariotestTemp/generated2/LOTOS.g:903:958: (temp= lotos_equations (temp= lotos_equations )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:903:975: (temp= lotos_equations (temp= lotos_equations )* )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==62) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:903:977: temp= lotos_equations (temp= lotos_equations )*
                    {
                    pushFollow(FOLLOW_lotos_equations_in_lotos_typedefinition3785);
                    temp=lotos_equations();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "equations", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:903:1037: (temp= lotos_equations )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==62) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:903:1039: temp= lotos_equations
                    	    {
                    	    pushFollow(FOLLOW_lotos_equations_in_lotos_typedefinition3793);
                    	    temp=lotos_equations();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "equations", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
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

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,54,FOLLOW_54_in_lotos_typedefinition3810); if (state.failed) return ret2;
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
    // $ANTLR end "lotos_typedefinition"


    // $ANTLR start "lotos_operations"
    // ./scenariotestTemp/generated2/LOTOS.g:911:1: lotos_operations returns [Object ret2] : ( (temp= lotos_operationdeclaration ( ( COMA ) temp= lotos_operationdeclaration )* ) COLON (temp= identifier ( ( COMA ) temp= identifier )* )? RARROW (temp= identifier ) ) ;
    public final Object lotos_operations() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Operations");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:916:3: ( ( (temp= lotos_operationdeclaration ( ( COMA ) temp= lotos_operationdeclaration )* ) COLON (temp= identifier ( ( COMA ) temp= identifier )* )? RARROW (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:917:3: ( (temp= lotos_operationdeclaration ( ( COMA ) temp= lotos_operationdeclaration )* ) COLON (temp= identifier ( ( COMA ) temp= identifier )* )? RARROW (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:917:3: ( (temp= lotos_operationdeclaration ( ( COMA ) temp= lotos_operationdeclaration )* ) COLON (temp= identifier ( ( COMA ) temp= identifier )* )? RARROW (temp= identifier ) )
            // ./scenariotestTemp/generated2/LOTOS.g:917:4: (temp= lotos_operationdeclaration ( ( COMA ) temp= lotos_operationdeclaration )* ) COLON (temp= identifier ( ( COMA ) temp= identifier )* )? RARROW (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:917:21: (temp= lotos_operationdeclaration ( ( COMA ) temp= lotos_operationdeclaration )* )
            // ./scenariotestTemp/generated2/LOTOS.g:917:23: temp= lotos_operationdeclaration ( ( COMA ) temp= lotos_operationdeclaration )*
            {
            pushFollow(FOLLOW_lotos_operationdeclaration_in_lotos_operations3854);
            temp=lotos_operationdeclaration();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "declarations", temp);
            }
            // ./scenariotestTemp/generated2/LOTOS.g:917:97: ( ( COMA ) temp= lotos_operationdeclaration )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==COMA) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:917:98: ( COMA ) temp= lotos_operationdeclaration
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:917:115: ( COMA )
            	    // ./scenariotestTemp/generated2/LOTOS.g:917:116: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_lotos_operations3863); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_lotos_operationdeclaration_in_lotos_operations3871);
            	    temp=lotos_operationdeclaration();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "declarations", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLON,FOLLOW_COLON_in_lotos_operations3881); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:917:323: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==NAME) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:917:325: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_lotos_operations3889);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parameterTypes", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:917:385: ( ( COMA ) temp= identifier )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==COMA) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:917:386: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/LOTOS.g:917:403: ( COMA )
                    	    // ./scenariotestTemp/generated2/LOTOS.g:917:404: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_lotos_operations3898); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_lotos_operations3906);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "parameterTypes", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_lotos_operations3918); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:917:600: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:917:602: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_operations3926);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "returnType", temp);
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
    // $ANTLR end "lotos_operations"


    // $ANTLR start "lotos_operationdeclaration"
    // ./scenariotestTemp/generated2/LOTOS.g:925:1: lotos_operationdeclaration returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object lotos_operationdeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","OperationDeclaration");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:930:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:931:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:931:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/LOTOS.g:931:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:931:21: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:931:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_operationdeclaration3973);
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
    // $ANTLR end "lotos_operationdeclaration"


    // $ANTLR start "lotos_equations"
    // ./scenariotestTemp/generated2/LOTOS.g:939:1: lotos_equations returns [Object ret2] : ( 'forall' (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* ) ( ( (temp= lotos_ofsort (temp= lotos_ofsort )* )? ) ) ) ;
    public final Object lotos_equations() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","Equations");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:944:3: ( ( 'forall' (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* ) ( ( (temp= lotos_ofsort (temp= lotos_ofsort )* )? ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:945:3: ( 'forall' (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* ) ( ( (temp= lotos_ofsort (temp= lotos_ofsort )* )? ) ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:945:3: ( 'forall' (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* ) ( ( (temp= lotos_ofsort (temp= lotos_ofsort )* )? ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:945:4: 'forall' (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* ) ( ( (temp= lotos_ofsort (temp= lotos_ofsort )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,62,FOLLOW_62_in_lotos_equations4016); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:945:62: (temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )* )
            // ./scenariotestTemp/generated2/LOTOS.g:945:64: temp= lotos_variabledeclarations ( ( COMA ) temp= lotos_variabledeclarations )*
            {
            pushFollow(FOLLOW_lotos_variabledeclarations_in_lotos_equations4023);
            temp=lotos_variabledeclarations();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "declarations", temp);
            }
            // ./scenariotestTemp/generated2/LOTOS.g:945:138: ( ( COMA ) temp= lotos_variabledeclarations )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==COMA) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/LOTOS.g:945:139: ( COMA ) temp= lotos_variabledeclarations
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/LOTOS.g:945:156: ( COMA )
            	    // ./scenariotestTemp/generated2/LOTOS.g:945:157: COMA
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,COMA,FOLLOW_COMA_in_lotos_equations4032); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_lotos_variabledeclarations_in_lotos_equations4040);
            	    temp=lotos_variabledeclarations();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "declarations", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:945:324: ( ( (temp= lotos_ofsort (temp= lotos_ofsort )* )? ) )
            // ./scenariotestTemp/generated2/LOTOS.g:945:325: ( (temp= lotos_ofsort (temp= lotos_ofsort )* )? )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:945:325: ( (temp= lotos_ofsort (temp= lotos_ofsort )* )? )
            // ./scenariotestTemp/generated2/LOTOS.g:945:326: (temp= lotos_ofsort (temp= lotos_ofsort )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:945:343: (temp= lotos_ofsort (temp= lotos_ofsort )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==61) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:945:345: temp= lotos_ofsort (temp= lotos_ofsort )*
                    {
                    pushFollow(FOLLOW_lotos_ofsort_in_lotos_equations4056);
                    temp=lotos_ofsort();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "ofSorts", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:945:400: (temp= lotos_ofsort )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==61) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:945:402: temp= lotos_ofsort
                    	    {
                    	    pushFollow(FOLLOW_lotos_ofsort_in_lotos_equations4064);
                    	    temp=lotos_ofsort();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "ofSorts", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop64;
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
    // $ANTLR end "lotos_equations"


    // $ANTLR start "lotos_ofsort"
    // ./scenariotestTemp/generated2/LOTOS.g:953:1: lotos_ofsort returns [Object ret2] : ( 'ofsort' (temp= identifier ) ( ( (temp= lotos_equation (temp= lotos_equation )* )? ) ) ) ;
    public final Object lotos_ofsort() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","OfSort");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:958:3: ( ( 'ofsort' (temp= identifier ) ( ( (temp= lotos_equation (temp= lotos_equation )* )? ) ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:959:3: ( 'ofsort' (temp= identifier ) ( ( (temp= lotos_equation (temp= lotos_equation )* )? ) ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:959:3: ( 'ofsort' (temp= identifier ) ( ( (temp= lotos_equation (temp= lotos_equation )* )? ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:959:4: 'ofsort' (temp= identifier ) ( ( (temp= lotos_equation (temp= lotos_equation )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,61,FOLLOW_61_in_lotos_ofsort4115); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:959:62: (temp= identifier )
            // ./scenariotestTemp/generated2/LOTOS.g:959:64: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_lotos_ofsort4122);
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
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:959:147: ( ( (temp= lotos_equation (temp= lotos_equation )* )? ) )
            // ./scenariotestTemp/generated2/LOTOS.g:959:148: ( (temp= lotos_equation (temp= lotos_equation )* )? )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:959:148: ( (temp= lotos_equation (temp= lotos_equation )* )? )
            // ./scenariotestTemp/generated2/LOTOS.g:959:149: (temp= lotos_equation (temp= lotos_equation )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:959:166: (temp= lotos_equation (temp= lotos_equation )* )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==NAME||LA67_0==INT||LA67_0==LPAREN||(LA67_0>=49 && LA67_0<=50)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:959:168: temp= lotos_equation (temp= lotos_equation )*
                    {
                    pushFollow(FOLLOW_lotos_equation_in_lotos_ofsort4135);
                    temp=lotos_equation();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "equations", temp);
                    }
                    // ./scenariotestTemp/generated2/LOTOS.g:959:227: (temp= lotos_equation )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==NAME||LA66_0==INT||LA66_0==LPAREN||(LA66_0>=49 && LA66_0<=50)) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/LOTOS.g:959:229: temp= lotos_equation
                    	    {
                    	    pushFollow(FOLLOW_lotos_equation_in_lotos_ofsort4143);
                    	    temp=lotos_equation();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "equations", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop66;
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
    // $ANTLR end "lotos_ofsort"


    // $ANTLR start "lotos_equation"
    // ./scenariotestTemp/generated2/LOTOS.g:967:1: lotos_equation returns [Object ret2] : (ret= lotos_simpleequation | ret= lotos_guardedequation ) ;
    public final Object lotos_equation() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LOTOS.g:968:3: ( (ret= lotos_simpleequation | ret= lotos_guardedequation ) )
            // ./scenariotestTemp/generated2/LOTOS.g:969:3: (ret= lotos_simpleequation | ret= lotos_guardedequation )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:969:3: (ret= lotos_simpleequation | ret= lotos_guardedequation )
            int alt68=2;
            switch ( input.LA(1) ) {
            case 50:
                {
                int LA68_1 = input.LA(2);

                if ( (synpred109_LOTOS()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;
                }
                }
                break;
            case 49:
                {
                int LA68_2 = input.LA(2);

                if ( (synpred109_LOTOS()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 2, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                int LA68_3 = input.LA(2);

                if ( (synpred109_LOTOS()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 3, input);

                    throw nvae;
                }
                }
                break;
            case NAME:
                {
                int LA68_4 = input.LA(2);

                if ( (synpred109_LOTOS()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 4, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                int LA68_5 = input.LA(2);

                if ( (synpred109_LOTOS()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }

            switch (alt68) {
                case 1 :
                    // ./scenariotestTemp/generated2/LOTOS.g:969:4: ret= lotos_simpleequation
                    {
                    pushFollow(FOLLOW_lotos_simpleequation_in_lotos_equation4191);
                    ret=lotos_simpleequation();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/LOTOS.g:970:5: ret= lotos_guardedequation
                    {
                    pushFollow(FOLLOW_lotos_guardedequation_in_lotos_equation4199);
                    ret=lotos_guardedequation();

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
    // $ANTLR end "lotos_equation"


    // $ANTLR start "lotos_simpleequation"
    // ./scenariotestTemp/generated2/LOTOS.g:977:1: lotos_simpleequation returns [Object ret2] : ( (temp= lotos_value ) EQ (temp= lotos_value ) SEMI ) ;
    public final Object lotos_simpleequation() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","SimpleEquation");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:982:3: ( ( (temp= lotos_value ) EQ (temp= lotos_value ) SEMI ) )
            // ./scenariotestTemp/generated2/LOTOS.g:983:3: ( (temp= lotos_value ) EQ (temp= lotos_value ) SEMI )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:983:3: ( (temp= lotos_value ) EQ (temp= lotos_value ) SEMI )
            // ./scenariotestTemp/generated2/LOTOS.g:983:4: (temp= lotos_value ) EQ (temp= lotos_value ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:983:21: (temp= lotos_value )
            // ./scenariotestTemp/generated2/LOTOS.g:983:23: temp= lotos_value
            {
            pushFollow(FOLLOW_lotos_value_in_lotos_simpleequation4233);
            temp=lotos_value();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "left", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_lotos_simpleequation4240); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:983:144: (temp= lotos_value )
            // ./scenariotestTemp/generated2/LOTOS.g:983:146: temp= lotos_value
            {
            pushFollow(FOLLOW_lotos_value_in_lotos_simpleequation4248);
            temp=lotos_value();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "right", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,SEMI,FOLLOW_SEMI_in_lotos_simpleequation4255); if (state.failed) return ret2;
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
    // $ANTLR end "lotos_simpleequation"


    // $ANTLR start "lotos_guardedequation"
    // ./scenariotestTemp/generated2/LOTOS.g:991:1: lotos_guardedequation returns [Object ret2] : ( (temp= lotos_guardexpression ) IMPLIES (temp= lotos_simpleequation ) ) ;
    public final Object lotos_guardedequation() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("LOTOS","GuardedEquation");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LOTOS.g:996:3: ( ( (temp= lotos_guardexpression ) IMPLIES (temp= lotos_simpleequation ) ) )
            // ./scenariotestTemp/generated2/LOTOS.g:997:3: ( (temp= lotos_guardexpression ) IMPLIES (temp= lotos_simpleequation ) )
            {
            // ./scenariotestTemp/generated2/LOTOS.g:997:3: ( (temp= lotos_guardexpression ) IMPLIES (temp= lotos_simpleequation ) )
            // ./scenariotestTemp/generated2/LOTOS.g:997:4: (temp= lotos_guardexpression ) IMPLIES (temp= lotos_simpleequation )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:997:21: (temp= lotos_guardexpression )
            // ./scenariotestTemp/generated2/LOTOS.g:997:23: temp= lotos_guardexpression
            {
            pushFollow(FOLLOW_lotos_guardexpression_in_lotos_guardedequation4300);
            temp=lotos_guardexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "guard", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,IMPLIES,FOLLOW_IMPLIES_in_lotos_guardedequation4307); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/LOTOS.g:997:160: (temp= lotos_simpleequation )
            // ./scenariotestTemp/generated2/LOTOS.g:997:162: temp= lotos_simpleequation
            {
            pushFollow(FOLLOW_lotos_simpleequation_in_lotos_guardedequation4315);
            temp=lotos_simpleequation();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "equation", temp);
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
    // $ANTLR end "lotos_guardedequation"

    // $ANTLR start synpred52_LOTOS
    public final void synpred52_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:394:33: ( ( LSQUARERSQUARE ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:394:34: ( LSQUARERSQUARE ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:394:34: ( LSQUARERSQUARE )
        // ./scenariotestTemp/generated2/LOTOS.g:394:35: LSQUARERSQUARE
        {
        match(input,LSQUARERSQUARE,FOLLOW_LSQUARERSQUARE_in_synpred52_LOTOS1263); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:394:50: ()
        // ./scenariotestTemp/generated2/LOTOS.g:394:51: 
        {
        }


        }
    }
    // $ANTLR end synpred52_LOTOS

    // $ANTLR start synpred53_LOTOS
    public final void synpred53_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:406:33: ( ( PIPE3 ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:406:34: ( PIPE3 ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:406:34: ( PIPE3 )
        // ./scenariotestTemp/generated2/LOTOS.g:406:35: PIPE3
        {
        match(input,PIPE3,FOLLOW_PIPE3_in_synpred53_LOTOS1335); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:406:41: ()
        // ./scenariotestTemp/generated2/LOTOS.g:406:42: 
        {
        }


        }
    }
    // $ANTLR end synpred53_LOTOS

    // $ANTLR start synpred54_LOTOS
    public final void synpred54_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:409:3: ( ( PIPELSQUARE ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:409:4: ( PIPELSQUARE ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:409:4: ( PIPELSQUARE )
        // ./scenariotestTemp/generated2/LOTOS.g:409:5: PIPELSQUARE
        {
        match(input,PIPELSQUARE,FOLLOW_PIPELSQUARE_in_synpred54_LOTOS1368); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:409:17: ()
        // ./scenariotestTemp/generated2/LOTOS.g:409:18: 
        {
        }


        }
    }
    // $ANTLR end synpred54_LOTOS

    // $ANTLR start synpred71_LOTOS
    public final void synpred71_LOTOS_fragment() throws RecognitionException {   
        Object ret = null;


        // ./scenariotestTemp/generated2/LOTOS.g:634:4: (ret= lotos_equalitytestguardexp )
        // ./scenariotestTemp/generated2/LOTOS.g:634:4: ret= lotos_equalitytestguardexp
        {
        pushFollow(FOLLOW_lotos_equalitytestguardexp_in_synpred71_LOTOS2380);
        ret=lotos_equalitytestguardexp();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred71_LOTOS

    // $ANTLR start synpred76_LOTOS
    public final void synpred76_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:685:32: ( ( 'of' ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:685:33: ( 'of' ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:685:33: ( 'of' )
        // ./scenariotestTemp/generated2/LOTOS.g:685:34: 'of'
        {
        match(input,58,FOLLOW_58_in_synpred76_LOTOS2609); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:685:39: ()
        // ./scenariotestTemp/generated2/LOTOS.g:685:40: 
        {
        }


        }
    }
    // $ANTLR end synpred76_LOTOS

    // $ANTLR start synpred77_LOTOS
    public final void synpred77_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:695:29: ( ( PLUS ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:695:30: ( PLUS ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:695:30: ( PLUS )
        // ./scenariotestTemp/generated2/LOTOS.g:695:31: PLUS
        {
        match(input,PLUS,FOLLOW_PLUS_in_synpred77_LOTOS2675); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:695:36: ()
        // ./scenariotestTemp/generated2/LOTOS.g:695:37: 
        {
        }


        }
    }
    // $ANTLR end synpred77_LOTOS

    // $ANTLR start synpred78_LOTOS
    public final void synpred78_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:707:29: ( ( 'eq' ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:707:30: ( 'eq' ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:707:30: ( 'eq' )
        // ./scenariotestTemp/generated2/LOTOS.g:707:31: 'eq'
        {
        match(input,75,FOLLOW_75_in_synpred78_LOTOS2747); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:707:36: ()
        // ./scenariotestTemp/generated2/LOTOS.g:707:37: 
        {
        }


        }
    }
    // $ANTLR end synpred78_LOTOS

    // $ANTLR start synpred79_LOTOS
    public final void synpred79_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:710:3: ( ( GE ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:710:4: ( GE ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:710:4: ( GE )
        // ./scenariotestTemp/generated2/LOTOS.g:710:5: GE
        {
        match(input,GE,FOLLOW_GE_in_synpred79_LOTOS2779); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:710:8: ()
        // ./scenariotestTemp/generated2/LOTOS.g:710:9: 
        {
        }


        }
    }
    // $ANTLR end synpred79_LOTOS

    // $ANTLR start synpred80_LOTOS
    public final void synpred80_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:713:3: ( ( GT ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:713:4: ( GT ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:713:4: ( GT )
        // ./scenariotestTemp/generated2/LOTOS.g:713:5: GT
        {
        match(input,GT,FOLLOW_GT_in_synpred80_LOTOS2812); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:713:8: ()
        // ./scenariotestTemp/generated2/LOTOS.g:713:9: 
        {
        }


        }
    }
    // $ANTLR end synpred80_LOTOS

    // $ANTLR start synpred81_LOTOS
    public final void synpred81_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:716:3: ( ( LE ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:716:4: ( LE ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:716:4: ( LE )
        // ./scenariotestTemp/generated2/LOTOS.g:716:5: LE
        {
        match(input,LE,FOLLOW_LE_in_synpred81_LOTOS2845); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:716:8: ()
        // ./scenariotestTemp/generated2/LOTOS.g:716:9: 
        {
        }


        }
    }
    // $ANTLR end synpred81_LOTOS

    // $ANTLR start synpred82_LOTOS
    public final void synpred82_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:719:3: ( ( LT ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:719:4: ( LT ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:719:4: ( LT )
        // ./scenariotestTemp/generated2/LOTOS.g:719:5: LT
        {
        match(input,LT,FOLLOW_LT_in_synpred82_LOTOS2878); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:719:8: ()
        // ./scenariotestTemp/generated2/LOTOS.g:719:9: 
        {
        }


        }
    }
    // $ANTLR end synpred82_LOTOS

    // $ANTLR start synpred83_LOTOS
    public final void synpred83_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:722:3: ( ( 'neq' ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:722:4: ( 'neq' ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:722:4: ( 'neq' )
        // ./scenariotestTemp/generated2/LOTOS.g:722:5: 'neq'
        {
        match(input,68,FOLLOW_68_in_synpred83_LOTOS2911); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:722:11: ()
        // ./scenariotestTemp/generated2/LOTOS.g:722:12: 
        {
        }


        }
    }
    // $ANTLR end synpred83_LOTOS

    // $ANTLR start synpred84_LOTOS
    public final void synpred84_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:734:29: ( ( 'and' ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:734:30: ( 'and' ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:734:30: ( 'and' )
        // ./scenariotestTemp/generated2/LOTOS.g:734:31: 'and'
        {
        match(input,65,FOLLOW_65_in_synpred84_LOTOS2982); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:734:37: ()
        // ./scenariotestTemp/generated2/LOTOS.g:734:38: 
        {
        }


        }
    }
    // $ANTLR end synpred84_LOTOS

    // $ANTLR start synpred85_LOTOS
    public final void synpred85_LOTOS_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/LOTOS.g:737:3: ( ( 'or' ) () )
        // ./scenariotestTemp/generated2/LOTOS.g:737:4: ( 'or' ) ()
        {
        // ./scenariotestTemp/generated2/LOTOS.g:737:4: ( 'or' )
        // ./scenariotestTemp/generated2/LOTOS.g:737:5: 'or'
        {
        match(input,63,FOLLOW_63_in_synpred85_LOTOS3014); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/LOTOS.g:737:10: ()
        // ./scenariotestTemp/generated2/LOTOS.g:737:11: 
        {
        }


        }
    }
    // $ANTLR end synpred85_LOTOS

    // $ANTLR start synpred109_LOTOS
    public final void synpred109_LOTOS_fragment() throws RecognitionException {   
        Object ret = null;


        // ./scenariotestTemp/generated2/LOTOS.g:969:4: (ret= lotos_simpleequation )
        // ./scenariotestTemp/generated2/LOTOS.g:969:4: ret= lotos_simpleequation
        {
        pushFollow(FOLLOW_lotos_simpleequation_in_synpred109_LOTOS4191);
        ret=lotos_simpleequation();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred109_LOTOS

    // Delegated rules

    public final boolean synpred83_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred82_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred76_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred76_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred79_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred81_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred71_LOTOS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred71_LOTOS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_identifierOrKeyword108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_identifierOrKeyword164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_identifierOrKeyword180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_identifierOrKeyword188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_identifierOrKeyword196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_identifierOrKeyword204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_identifierOrKeyword212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_identifierOrKeyword220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_identifierOrKeyword228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_identifierOrKeyword236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifierOrKeyword244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_identifierOrKeyword252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_identifierOrKeyword260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_identifierOrKeyword268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_identifierOrKeyword276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_identifierOrKeyword284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_identifierOrKeyword292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_identifierOrKeyword300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_identifierOrKeyword308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_identifierOrKeyword316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_identifierOrKeyword324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_identifierOrKeyword332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_specification_in_main453 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_lotos_specification487 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_specification494 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_LSQUARE_in_lotos_specification507 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_identifier_in_lotos_specification515 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_lotos_specification524 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_specification532 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RSQUARE_in_lotos_specification544 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_lotos_specification562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001020L});
    public static final BitSet FOLLOW_69_in_lotos_specification572 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000500L});
    public static final BitSet FOLLOW_76_in_lotos_specification585 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000500L});
    public static final BitSet FOLLOW_lotos_type_in_lotos_specification602 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000500L});
    public static final BitSet FOLLOW_lotos_type_in_lotos_specification610 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000500L});
    public static final BitSet FOLLOW_72_in_lotos_specification624 = new BitSet(new long[]{0x0108000000011010L,0x0000000000000041L});
    public static final BitSet FOLLOW_lotos_definition_in_lotos_specification640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_lotos_specification662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_behaviour_in_lotos_definition709 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_57_in_lotos_definition724 = new BitSet(new long[]{0x00A0000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_lotos_typeorprocessdeclaration_in_lotos_definition734 = new BitSet(new long[]{0x00A0000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_lotos_typeorprocessdeclaration_in_lotos_definition742 = new BitSet(new long[]{0x00A0000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_lotos_process_in_lotos_typeorprocessdeclaration803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_type_in_lotos_typeorprocessdeclaration811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_lotos_process841 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_process848 = new BitSet(new long[]{0x0000000000001900L});
    public static final BitSet FOLLOW_LSQUARE_in_lotos_process861 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_identifier_in_lotos_process869 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_lotos_process878 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_process886 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RSQUARE_in_lotos_process898 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_LPAREN_in_lotos_process922 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_lotos_variabledeclarations_in_lotos_process930 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_lotos_process939 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_lotos_variabledeclarations_in_lotos_process947 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_lotos_process959 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_COLON_in_lotos_process977 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001020L});
    public static final BitSet FOLLOW_69_in_lotos_process987 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_76_in_lotos_process1000 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_COLONEQ_in_lotos_process1011 = new BitSet(new long[]{0x0108000000011010L,0x0000000000000001L});
    public static final BitSet FOLLOW_lotos_definition_in_lotos_process1019 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_lotos_process1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_processcall_in_primary_lotos_behaviour1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_lotos_behaviour1071 = new BitSet(new long[]{0x0108000000011010L,0x0000000000000001L});
    public static final BitSet FOLLOW_lotos_behaviour_in_primary_lotos_behaviour1077 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_lotos_behaviour1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp_in_behaviour_priority_01121 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_behaviour_priority_01124 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_behaviour_priority_0_in_behaviour_priority_01130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_lotos_behaviour_in_behaviour_priority_01146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_behaviour_priority_11192 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp_in_behaviour_priority_11200 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_behaviour_priority_0_in_behaviour_priority_11204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behaviour_priority_0_in_behaviour_priority_11220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behaviour_priority_1_in_behaviour_priority_21259 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_LSQUARERSQUARE_in_behaviour_priority_21272 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_lotos_alternative_LOTOS_Alternative_alternativeOp_in_behaviour_priority_21280 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_behaviour_priority_1_in_behaviour_priority_21284 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_behaviour_priority_2_in_behaviour_priority_31331 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_PIPE3_in_behaviour_priority_31344 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_lotos_simpleparallel_LOTOS_SimpleParallel_parOp_in_behaviour_priority_31352 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_behaviour_priority_2_in_behaviour_priority_31356 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_PIPELSQUARE_in_behaviour_priority_31377 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp_in_behaviour_priority_31385 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_behaviour_priority_2_in_behaviour_priority_31389 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_behaviour_priority_3_in_lotos_behaviour1428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_choice_in_lotos_behaviour1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_hide_in_lotos_behaviour1444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_let_in_lotos_behaviour1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_lotos_let1482 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_lotos_variabledeclarations_in_lotos_let1489 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EQ_in_lotos_let1496 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_let1504 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_lotos_let1510 = new BitSet(new long[]{0x0108000000011010L,0x0000000000000001L});
    public static final BitSet FOLLOW_lotos_behaviour_in_lotos_let1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_lotos_choice1566 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_lotos_variabledeclarations_in_lotos_choice1573 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LSQUARERSQUARE_in_lotos_choice1580 = new BitSet(new long[]{0x0108000000011010L,0x0000000000000001L});
    public static final BitSet FOLLOW_lotos_behaviour_in_lotos_choice1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_lotos_hide1637 = new BitSet(new long[]{0x1000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_hide1644 = new BitSet(new long[]{0x1000000000000200L});
    public static final BitSet FOLLOW_COMA_in_lotos_hide1653 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_hide1661 = new BitSet(new long[]{0x1000000000000200L});
    public static final BitSet FOLLOW_60_in_lotos_hide1672 = new BitSet(new long[]{0x0108000000011010L,0x0000000000000001L});
    public static final BitSet FOLLOW_lotos_behaviour_in_lotos_hide1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_lotos_processcall1732 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LSQUARE_in_lotos_processcall1739 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_identifier_in_lotos_processcall1747 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_COMA_in_lotos_processcall1756 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_processcall1764 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RSQUARE_in_lotos_processcall1776 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LPAREN_in_lotos_processcall1787 = new BitSet(new long[]{0x0006000000003050L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_processcall1795 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_lotos_processcall1804 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_processcall1812 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_lotos_processcall1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp1911 = new BitSet(new long[]{0x0000000000200200L});
    public static final BitSet FOLLOW_COMA_in_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp1920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp1928 = new BitSet(new long[]{0x0000000000200200L});
    public static final BitSet FOLLOW_RSQUAREPIPE_in_lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp1975 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_guardexpression_in_lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp1983 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RSQUARE_in_lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp1990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_action_in_lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_gateaction_in_lotos_action2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_lotos_gateaction2122 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_lotos_communication_in_lotos_gateaction2138 = new BitSet(new long[]{0x0000000000C00102L});
    public static final BitSet FOLLOW_lotos_communication_in_lotos_gateaction2146 = new BitSet(new long[]{0x0000000000C00102L});
    public static final BitSet FOLLOW_LSQUARE_in_lotos_gateaction2162 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_guardexpression_in_lotos_gateaction2170 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RSQUARE_in_lotos_gateaction2177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_incomm_in_lotos_communication2241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_outcomm_in_lotos_communication2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMARK_in_lotos_incomm2280 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_lotos_variabledeclarations_in_lotos_incomm2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCL_in_lotos_outcomm2332 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_outcomm2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_equalitytestguardexp_in_lotos_guardexpression2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_booleanguardexp_in_lotos_guardexpression2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_equalitytestguardexp2422 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EQ_in_lotos_equalitytestguardexp2429 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_equalitytestguardexp2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_booleanguardexp2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_booleanval_in_primary_lotos_value2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_integerval_in_primary_lotos_value2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_operationcall_in_primary_lotos_value2540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_variable_in_primary_lotos_value2548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_lotos_value2557 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_value_in_primary_lotos_value2563 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_lotos_value2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_lotos_value_in_value_priority_02605 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_value_priority_02618 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_lotos_castval_LOTOS_CastVal_opOf_in_value_priority_02625 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_value_priority_0_in_value_priority_12671 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_PLUS_in_value_priority_12684 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_12692 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_0_in_value_priority_12696 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_value_priority_1_in_value_priority_22743 = new BitSet(new long[]{0x000000001E000002L,0x0000000000000810L});
    public static final BitSet FOLLOW_75_in_value_priority_22756 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22763 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_1_in_value_priority_22767 = new BitSet(new long[]{0x000000001E000002L,0x0000000000000810L});
    public static final BitSet FOLLOW_GE_in_value_priority_22788 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22796 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_1_in_value_priority_22800 = new BitSet(new long[]{0x000000001E000002L,0x0000000000000810L});
    public static final BitSet FOLLOW_GT_in_value_priority_22821 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22829 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_1_in_value_priority_22833 = new BitSet(new long[]{0x000000001E000002L,0x0000000000000810L});
    public static final BitSet FOLLOW_LE_in_value_priority_22854 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22862 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_1_in_value_priority_22866 = new BitSet(new long[]{0x000000001E000002L,0x0000000000000810L});
    public static final BitSet FOLLOW_LT_in_value_priority_22887 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22895 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_1_in_value_priority_22899 = new BitSet(new long[]{0x000000001E000002L,0x0000000000000810L});
    public static final BitSet FOLLOW_68_in_value_priority_22920 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_22927 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_1_in_value_priority_22931 = new BitSet(new long[]{0x000000001E000002L,0x0000000000000810L});
    public static final BitSet FOLLOW_value_priority_2_in_value_priority_32978 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_value_priority_32991 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_32998 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_2_in_value_priority_33002 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_value_priority_33023 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr_in_value_priority_33030 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_value_priority_2_in_value_priority_33034 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_value_priority_3_in_lotos_value3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_lotos_variable3105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_lotos_operationcall3152 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_lotos_operationcall3159 = new BitSet(new long[]{0x0006000000003050L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_operationcall3167 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_COMA_in_lotos_operationcall3176 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_operationcall3184 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_RPAREN_in_lotos_operationcall3196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_lotos_integerval3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_lotos_booleanval3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_lotos_booleanval3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_lotos_castval_LOTOS_CastVal_opOf3355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_lotos_variabledeclaration3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_variabledeclaration_in_lotos_variabledeclarations3469 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMA_in_lotos_variabledeclarations3478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_lotos_variabledeclaration_in_lotos_variabledeclarations3486 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COLON_in_lotos_variabledeclarations3498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_variabledeclarations3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_librarylist_in_lotos_type3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_typedefinition_in_lotos_type3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_lotos_librarylist3584 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000004L});
    public static final BitSet FOLLOW_identifier_in_lotos_librarylist3591 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000004L});
    public static final BitSet FOLLOW_COMA_in_lotos_librarylist3600 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_librarylist3608 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_lotos_librarylist3619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_lotos_typedefinition3659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_typedefinition3666 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_lotos_typedefinition3672 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_typedefinition3679 = new BitSet(new long[]{0x0010000000000200L});
    public static final BitSet FOLLOW_COMA_in_lotos_typedefinition3688 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_typedefinition3696 = new BitSet(new long[]{0x0010000000000200L});
    public static final BitSet FOLLOW_52_in_lotos_typedefinition3708 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000008L});
    public static final BitSet FOLLOW_identifier_in_lotos_typedefinition3715 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000008L});
    public static final BitSet FOLLOW_COMA_in_lotos_typedefinition3724 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_typedefinition3732 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_lotos_typedefinition3743 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000080L});
    public static final BitSet FOLLOW_lotos_operations_in_lotos_typedefinition3753 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000080L});
    public static final BitSet FOLLOW_lotos_operations_in_lotos_typedefinition3761 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_lotos_typedefinition3775 = new BitSet(new long[]{0x4040000000000000L});
    public static final BitSet FOLLOW_lotos_equations_in_lotos_typedefinition3785 = new BitSet(new long[]{0x4040000000000000L});
    public static final BitSet FOLLOW_lotos_equations_in_lotos_typedefinition3793 = new BitSet(new long[]{0x4040000000000000L});
    public static final BitSet FOLLOW_54_in_lotos_typedefinition3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_operationdeclaration_in_lotos_operations3854 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COMA_in_lotos_operations3863 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_lotos_operationdeclaration_in_lotos_operations3871 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_COLON_in_lotos_operations3881 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_identifier_in_lotos_operations3889 = new BitSet(new long[]{0x0000000000010200L});
    public static final BitSet FOLLOW_COMA_in_lotos_operations3898 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_operations3906 = new BitSet(new long[]{0x0000000000010200L});
    public static final BitSet FOLLOW_RARROW_in_lotos_operations3918 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_operations3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_lotos_operationdeclaration3973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_lotos_equations4016 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_lotos_variabledeclarations_in_lotos_equations4023 = new BitSet(new long[]{0x2000000000000202L});
    public static final BitSet FOLLOW_COMA_in_lotos_equations4032 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_lotos_variabledeclarations_in_lotos_equations4040 = new BitSet(new long[]{0x2000000000000202L});
    public static final BitSet FOLLOW_lotos_ofsort_in_lotos_equations4056 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_lotos_ofsort_in_lotos_equations4064 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_lotos_ofsort4115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_lotos_ofsort4122 = new BitSet(new long[]{0x0006000000001052L});
    public static final BitSet FOLLOW_lotos_equation_in_lotos_ofsort4135 = new BitSet(new long[]{0x0006000000001052L});
    public static final BitSet FOLLOW_lotos_equation_in_lotos_ofsort4143 = new BitSet(new long[]{0x0006000000001052L});
    public static final BitSet FOLLOW_lotos_simpleequation_in_lotos_equation4191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_guardedequation_in_lotos_equation4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_simpleequation4233 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EQ_in_lotos_simpleequation4240 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_value_in_lotos_simpleequation4248 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_lotos_simpleequation4255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_guardexpression_in_lotos_guardedequation4300 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_IMPLIES_in_lotos_guardedequation4307 = new BitSet(new long[]{0x0006000000001050L});
    public static final BitSet FOLLOW_lotos_simpleequation_in_lotos_guardedequation4315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARERSQUARE_in_synpred52_LOTOS1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE3_in_synpred53_LOTOS1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPELSQUARE_in_synpred54_LOTOS1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_equalitytestguardexp_in_synpred71_LOTOS2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_synpred76_LOTOS2609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_synpred77_LOTOS2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_synpred78_LOTOS2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GE_in_synpred79_LOTOS2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_synpred80_LOTOS2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LE_in_synpred81_LOTOS2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_synpred82_LOTOS2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_synpred83_LOTOS2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_synpred84_LOTOS2982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_synpred85_LOTOS3014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lotos_simpleequation_in_synpred109_LOTOS4191 = new BitSet(new long[]{0x0000000000000002L});

}