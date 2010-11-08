// $ANTLR 3.1.1 ./scenariotestTemp/generated2/TCSObsolete.g 2010-11-04 23:29:42

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
public class TCSObsoleteParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "LPAREN", "EQ", "RPAREN", "LCURLY", "RCURLY", "SEMI", "RARROW", "DLCOLON", "COLON", "COMA", "SHARP", "LT", "GT", "LSQUARE", "RSQUARE", "QMARK", "DLCURLY", "DRCURLY", "DLSQUARE", "PIPE", "DRSQUARE", "STAR", "DOLLAR", "POINT", "MINUS", "COMMENT", "EXCL", "AROBAS", "SLASH", "PLUS", "GE", "LE", "NE", "LARROW", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'leftSpace'", "'always'", "'true'", "'for'", "'end'", "'storeOpTo'", "'disambiguate'", "'rightNone'", "'context'", "'ifmissing'", "'primitiveTemplate'", "'refersToKey'", "'leftNone'", "'postfix'", "'part'", "'startNL'", "'indentIncr'", "'esc'", "'mode'", "'lookIn'", "'multiLine'", "'false'", "'words'", "'abstract'", "'default'", "'importContext'", "'never'", "'as'", "'operatorTemplate'", "'serializer'", "'enumerationTemplate'", "'word'", "'template'", "'function'", "'createAs'", "'keywords'", "'main'", "'separator'", "'orKeyword'", "'lexer'", "'token'", "'startNbNL'", "'endOfLine'", "'all'", "'disambiguateV3'", "'and'", "'value'", "'left'", "'operators'", "'prefix'", "'storeRightTo'", "'nbNL'", "'rightSpace'", "'k'", "'one'", "'isDefined'", "'hex'", "'right'", "'nonPrimary'", "'using'", "'refersTo'", "'endNL'", "'priority'", "'autoCreate'", "'source'", "'drop'", "'start'", "'createIn'", "'forcedLower'", "'deep'", "'octal'", "'operatored'", "'symbols'", "'multi'", "'syntax'", "'auto'", "'addToContext'"
    };
    public static final int DLCURLY=24;
    public static final int LT=19;
    public static final int STAR=29;
    public static final int LSQUARE=21;
    public static final int DRCURLY=25;
    public static final int EXCL=34;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int RPAREN=10;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int T__90=90;
    public static final int NL=42;
    public static final int EQ=9;
    public static final int COMMENT=33;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int NE=40;
    public static final int T__95=95;
    public static final int GE=38;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int SHARP=18;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LCURLY=11;
    public static final int INT=6;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int ALPHA=45;
    public static final int T__88=88;
    public static final int WS=43;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int SNAME=46;
    public static final int T__70=70;
    public static final int GT=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int QMARK=23;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int DOLLAR=30;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int POINT=31;
    public static final int AROBAS=35;
    public static final int T__118=118;
    public static final int ESC=47;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int DLCOLON=15;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int DRSQUARE=28;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int LARROW=41;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int FLOAT=7;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int LPAREN=8;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int SLASH=36;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__59=59;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int PLUS=37;
    public static final int PIPE=27;
    public static final int T__112=112;
    public static final int DIGIT=44;
    public static final int T__50=50;
    public static final int DLSQUARE=26;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=14;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int MINUS=32;
    public static final int RSQUARE=22;
    public static final int COMA=17;
    public static final int SEMI=13;
    public static final int COLON=16;
    public static final int RCURLY=12;
    public static final int LE=39;
    public static final int STRING=5;

    // delegates
    // delegators


        public TCSObsoleteParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TCSObsoleteParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return TCSObsoleteParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/TCSObsolete.g"; }


       private static final String syntaxUUID = "TCSObsolete";
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
    // ./scenariotestTemp/generated2/TCSObsolete.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/TCSObsolete.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/TCSObsolete.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'leftSpace' | 'always' | 'true' | 'for' | 'end' | 'storeOpTo' | 'disambiguate' | 'rightNone' | 'context' | 'ifmissing' | 'primitiveTemplate' | 'refersToKey' | 'leftNone' | 'postfix' | 'part' | 'startNL' | 'indentIncr' | 'esc' | 'mode' | 'lookIn' | 'multiLine' | 'false' | 'words' | 'abstract' | 'default' | 'importContext' | 'never' | 'as' | 'operatorTemplate' | 'serializer' | 'enumerationTemplate' | 'word' | 'template' | 'function' | 'createAs' | 'keywords' | 'main' | 'separator' | 'orKeyword' | 'lexer' | 'token' | 'startNbNL' | 'endOfLine' | 'all' | 'disambiguateV3' | 'and' | 'value' | 'left' | 'operators' | 'prefix' | 'storeRightTo' | 'nbNL' | 'rightSpace' | 'k' | 'one' | 'isDefined' | 'hex' | 'right' | 'nonPrimary' | 'using' | 'refersTo' | 'endNL' | 'priority' | 'autoCreate' | 'source' | 'drop' | 'start' | 'createIn' | 'forcedLower' | 'deep' | 'octal' | 'operatored' | 'symbols' | 'multi' | 'syntax' | 'auto' | 'addToContext' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:218:3: ( (ast= NAME | 'leftSpace' | 'always' | 'true' | 'for' | 'end' | 'storeOpTo' | 'disambiguate' | 'rightNone' | 'context' | 'ifmissing' | 'primitiveTemplate' | 'refersToKey' | 'leftNone' | 'postfix' | 'part' | 'startNL' | 'indentIncr' | 'esc' | 'mode' | 'lookIn' | 'multiLine' | 'false' | 'words' | 'abstract' | 'default' | 'importContext' | 'never' | 'as' | 'operatorTemplate' | 'serializer' | 'enumerationTemplate' | 'word' | 'template' | 'function' | 'createAs' | 'keywords' | 'main' | 'separator' | 'orKeyword' | 'lexer' | 'token' | 'startNbNL' | 'endOfLine' | 'all' | 'disambiguateV3' | 'and' | 'value' | 'left' | 'operators' | 'prefix' | 'storeRightTo' | 'nbNL' | 'rightSpace' | 'k' | 'one' | 'isDefined' | 'hex' | 'right' | 'nonPrimary' | 'using' | 'refersTo' | 'endNL' | 'priority' | 'autoCreate' | 'source' | 'drop' | 'start' | 'createIn' | 'forcedLower' | 'deep' | 'octal' | 'operatored' | 'symbols' | 'multi' | 'syntax' | 'auto' | 'addToContext' ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:219:3: (ast= NAME | 'leftSpace' | 'always' | 'true' | 'for' | 'end' | 'storeOpTo' | 'disambiguate' | 'rightNone' | 'context' | 'ifmissing' | 'primitiveTemplate' | 'refersToKey' | 'leftNone' | 'postfix' | 'part' | 'startNL' | 'indentIncr' | 'esc' | 'mode' | 'lookIn' | 'multiLine' | 'false' | 'words' | 'abstract' | 'default' | 'importContext' | 'never' | 'as' | 'operatorTemplate' | 'serializer' | 'enumerationTemplate' | 'word' | 'template' | 'function' | 'createAs' | 'keywords' | 'main' | 'separator' | 'orKeyword' | 'lexer' | 'token' | 'startNbNL' | 'endOfLine' | 'all' | 'disambiguateV3' | 'and' | 'value' | 'left' | 'operators' | 'prefix' | 'storeRightTo' | 'nbNL' | 'rightSpace' | 'k' | 'one' | 'isDefined' | 'hex' | 'right' | 'nonPrimary' | 'using' | 'refersTo' | 'endNL' | 'priority' | 'autoCreate' | 'source' | 'drop' | 'start' | 'createIn' | 'forcedLower' | 'deep' | 'octal' | 'operatored' | 'symbols' | 'multi' | 'syntax' | 'auto' | 'addToContext' )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:219:3: (ast= NAME | 'leftSpace' | 'always' | 'true' | 'for' | 'end' | 'storeOpTo' | 'disambiguate' | 'rightNone' | 'context' | 'ifmissing' | 'primitiveTemplate' | 'refersToKey' | 'leftNone' | 'postfix' | 'part' | 'startNL' | 'indentIncr' | 'esc' | 'mode' | 'lookIn' | 'multiLine' | 'false' | 'words' | 'abstract' | 'default' | 'importContext' | 'never' | 'as' | 'operatorTemplate' | 'serializer' | 'enumerationTemplate' | 'word' | 'template' | 'function' | 'createAs' | 'keywords' | 'main' | 'separator' | 'orKeyword' | 'lexer' | 'token' | 'startNbNL' | 'endOfLine' | 'all' | 'disambiguateV3' | 'and' | 'value' | 'left' | 'operators' | 'prefix' | 'storeRightTo' | 'nbNL' | 'rightSpace' | 'k' | 'one' | 'isDefined' | 'hex' | 'right' | 'nonPrimary' | 'using' | 'refersTo' | 'endNL' | 'priority' | 'autoCreate' | 'source' | 'drop' | 'start' | 'createIn' | 'forcedLower' | 'deep' | 'octal' | 'operatored' | 'symbols' | 'multi' | 'syntax' | 'auto' | 'addToContext' )
            int alt1=78;
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
            case 77:
                {
                alt1=31;
                }
                break;
            case 78:
                {
                alt1=32;
                }
                break;
            case 79:
                {
                alt1=33;
                }
                break;
            case 80:
                {
                alt1=34;
                }
                break;
            case 81:
                {
                alt1=35;
                }
                break;
            case 82:
                {
                alt1=36;
                }
                break;
            case 83:
                {
                alt1=37;
                }
                break;
            case 84:
                {
                alt1=38;
                }
                break;
            case 85:
                {
                alt1=39;
                }
                break;
            case 86:
                {
                alt1=40;
                }
                break;
            case 87:
                {
                alt1=41;
                }
                break;
            case 88:
                {
                alt1=42;
                }
                break;
            case 89:
                {
                alt1=43;
                }
                break;
            case 90:
                {
                alt1=44;
                }
                break;
            case 91:
                {
                alt1=45;
                }
                break;
            case 92:
                {
                alt1=46;
                }
                break;
            case 93:
                {
                alt1=47;
                }
                break;
            case 94:
                {
                alt1=48;
                }
                break;
            case 95:
                {
                alt1=49;
                }
                break;
            case 96:
                {
                alt1=50;
                }
                break;
            case 97:
                {
                alt1=51;
                }
                break;
            case 98:
                {
                alt1=52;
                }
                break;
            case 99:
                {
                alt1=53;
                }
                break;
            case 100:
                {
                alt1=54;
                }
                break;
            case 101:
                {
                alt1=55;
                }
                break;
            case 102:
                {
                alt1=56;
                }
                break;
            case 103:
                {
                alt1=57;
                }
                break;
            case 104:
                {
                alt1=58;
                }
                break;
            case 105:
                {
                alt1=59;
                }
                break;
            case 106:
                {
                alt1=60;
                }
                break;
            case 107:
                {
                alt1=61;
                }
                break;
            case 108:
                {
                alt1=62;
                }
                break;
            case 109:
                {
                alt1=63;
                }
                break;
            case 110:
                {
                alt1=64;
                }
                break;
            case 111:
                {
                alt1=65;
                }
                break;
            case 112:
                {
                alt1=66;
                }
                break;
            case 113:
                {
                alt1=67;
                }
                break;
            case 114:
                {
                alt1=68;
                }
                break;
            case 115:
                {
                alt1=69;
                }
                break;
            case 116:
                {
                alt1=70;
                }
                break;
            case 117:
                {
                alt1=71;
                }
                break;
            case 118:
                {
                alt1=72;
                }
                break;
            case 119:
                {
                alt1=73;
                }
                break;
            case 120:
                {
                alt1=74;
                }
                break;
            case 121:
                {
                alt1=75;
                }
                break;
            case 122:
                {
                alt1=76;
                }
                break;
            case 123:
                {
                alt1=77;
                }
                break;
            case 124:
                {
                alt1=78;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:219:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:221:5: 'leftSpace'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftSpace";
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:222:5: 'always'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "always";
                    }

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:223:5: 'true'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:224:5: 'for'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:225:5: 'end'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "end";
                    }

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:226:5: 'storeOpTo'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeOpTo";
                    }

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:227:5: 'disambiguate'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguate";
                    }

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:228:5: 'rightNone'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightNone";
                    }

                    }
                    break;
                case 10 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:229:5: 'context'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 11 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:230:5: 'ifmissing'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "ifmissing";
                    }

                    }
                    break;
                case 12 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:231:5: 'primitiveTemplate'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "primitiveTemplate";
                    }

                    }
                    break;
                case 13 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:232:5: 'refersToKey'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "refersToKey";
                    }

                    }
                    break;
                case 14 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:233:5: 'leftNone'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftNone";
                    }

                    }
                    break;
                case 15 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:234:5: 'postfix'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "postfix";
                    }

                    }
                    break;
                case 16 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:235:5: 'part'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "part";
                    }

                    }
                    break;
                case 17 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:236:5: 'startNL'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNL";
                    }

                    }
                    break;
                case 18 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:237:5: 'indentIncr'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword236); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "indentIncr";
                    }

                    }
                    break;
                case 19 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:238:5: 'esc'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword244); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "esc";
                    }

                    }
                    break;
                case 20 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:239:5: 'mode'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword252); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "mode";
                    }

                    }
                    break;
                case 21 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:240:5: 'lookIn'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword260); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookIn";
                    }

                    }
                    break;
                case 22 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:241:5: 'multiLine'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword268); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multiLine";
                    }

                    }
                    break;
                case 23 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:242:5: 'false'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword276); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 24 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:243:5: 'words'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "words";
                    }

                    }
                    break;
                case 25 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:244:5: 'abstract'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 26 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:245:5: 'default'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword300); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "default";
                    }

                    }
                    break;
                case 27 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:246:5: 'importContext'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword308); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "importContext";
                    }

                    }
                    break;
                case 28 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:247:5: 'never'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword316); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "never";
                    }

                    }
                    break;
                case 29 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:248:5: 'as'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword324); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "as";
                    }

                    }
                    break;
                case 30 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:249:5: 'operatorTemplate'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword332); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatorTemplate";
                    }

                    }
                    break;
                case 31 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:250:5: 'serializer'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword340); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "serializer";
                    }

                    }
                    break;
                case 32 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:251:5: 'enumerationTemplate'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword348); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "enumerationTemplate";
                    }

                    }
                    break;
                case 33 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:252:5: 'word'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword356); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "word";
                    }

                    }
                    break;
                case 34 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:253:5: 'template'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword364); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "template";
                    }

                    }
                    break;
                case 35 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:254:5: 'function'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword372); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "function";
                    }

                    }
                    break;
                case 36 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:255:5: 'createAs'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword380); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createAs";
                    }

                    }
                    break;
                case 37 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:256:5: 'keywords'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword388); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "keywords";
                    }

                    }
                    break;
                case 38 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:257:5: 'main'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword396); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "main";
                    }

                    }
                    break;
                case 39 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:258:5: 'separator'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword404); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "separator";
                    }

                    }
                    break;
                case 40 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:259:5: 'orKeyword'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword412); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "orKeyword";
                    }

                    }
                    break;
                case 41 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:260:5: 'lexer'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword420); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lexer";
                    }

                    }
                    break;
                case 42 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:261:5: 'token'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword428); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "token";
                    }

                    }
                    break;
                case 43 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:262:5: 'startNbNL'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword436); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNbNL";
                    }

                    }
                    break;
                case 44 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:263:5: 'endOfLine'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword444); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endOfLine";
                    }

                    }
                    break;
                case 45 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:264:5: 'all'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword452); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "all";
                    }

                    }
                    break;
                case 46 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:265:5: 'disambiguateV3'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword460); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguateV3";
                    }

                    }
                    break;
                case 47 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:266:5: 'and'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword468); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 48 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:267:5: 'value'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword476); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "value";
                    }

                    }
                    break;
                case 49 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:268:5: 'left'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword484); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "left";
                    }

                    }
                    break;
                case 50 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:269:5: 'operators'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword492); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operators";
                    }

                    }
                    break;
                case 51 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:270:5: 'prefix'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword500); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "prefix";
                    }

                    }
                    break;
                case 52 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:271:5: 'storeRightTo'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword508); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeRightTo";
                    }

                    }
                    break;
                case 53 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:272:5: 'nbNL'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword516); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nbNL";
                    }

                    }
                    break;
                case 54 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:273:5: 'rightSpace'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword524); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightSpace";
                    }

                    }
                    break;
                case 55 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:274:5: 'k'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword532); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "k";
                    }

                    }
                    break;
                case 56 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:275:5: 'one'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword540); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "one";
                    }

                    }
                    break;
                case 57 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:276:5: 'isDefined'
                    {
                    match(input,103,FOLLOW_103_in_identifierOrKeyword548); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "isDefined";
                    }

                    }
                    break;
                case 58 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:277:5: 'hex'
                    {
                    match(input,104,FOLLOW_104_in_identifierOrKeyword556); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "hex";
                    }

                    }
                    break;
                case 59 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:278:5: 'right'
                    {
                    match(input,105,FOLLOW_105_in_identifierOrKeyword564); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "right";
                    }

                    }
                    break;
                case 60 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:279:5: 'nonPrimary'
                    {
                    match(input,106,FOLLOW_106_in_identifierOrKeyword572); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nonPrimary";
                    }

                    }
                    break;
                case 61 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:280:5: 'using'
                    {
                    match(input,107,FOLLOW_107_in_identifierOrKeyword580); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "using";
                    }

                    }
                    break;
                case 62 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:281:5: 'refersTo'
                    {
                    match(input,108,FOLLOW_108_in_identifierOrKeyword588); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "refersTo";
                    }

                    }
                    break;
                case 63 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:282:5: 'endNL'
                    {
                    match(input,109,FOLLOW_109_in_identifierOrKeyword596); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endNL";
                    }

                    }
                    break;
                case 64 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:283:5: 'priority'
                    {
                    match(input,110,FOLLOW_110_in_identifierOrKeyword604); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "priority";
                    }

                    }
                    break;
                case 65 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:284:5: 'autoCreate'
                    {
                    match(input,111,FOLLOW_111_in_identifierOrKeyword612); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "autoCreate";
                    }

                    }
                    break;
                case 66 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:285:5: 'source'
                    {
                    match(input,112,FOLLOW_112_in_identifierOrKeyword620); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "source";
                    }

                    }
                    break;
                case 67 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:286:5: 'drop'
                    {
                    match(input,113,FOLLOW_113_in_identifierOrKeyword628); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "drop";
                    }

                    }
                    break;
                case 68 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:287:5: 'start'
                    {
                    match(input,114,FOLLOW_114_in_identifierOrKeyword636); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "start";
                    }

                    }
                    break;
                case 69 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:288:5: 'createIn'
                    {
                    match(input,115,FOLLOW_115_in_identifierOrKeyword644); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createIn";
                    }

                    }
                    break;
                case 70 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:289:5: 'forcedLower'
                    {
                    match(input,116,FOLLOW_116_in_identifierOrKeyword652); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedLower";
                    }

                    }
                    break;
                case 71 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:290:5: 'deep'
                    {
                    match(input,117,FOLLOW_117_in_identifierOrKeyword660); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "deep";
                    }

                    }
                    break;
                case 72 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:291:5: 'octal'
                    {
                    match(input,118,FOLLOW_118_in_identifierOrKeyword668); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "octal";
                    }

                    }
                    break;
                case 73 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:292:5: 'operatored'
                    {
                    match(input,119,FOLLOW_119_in_identifierOrKeyword676); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatored";
                    }

                    }
                    break;
                case 74 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:293:5: 'symbols'
                    {
                    match(input,120,FOLLOW_120_in_identifierOrKeyword684); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "symbols";
                    }

                    }
                    break;
                case 75 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:294:5: 'multi'
                    {
                    match(input,121,FOLLOW_121_in_identifierOrKeyword692); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multi";
                    }

                    }
                    break;
                case 76 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:295:5: 'syntax'
                    {
                    match(input,122,FOLLOW_122_in_identifierOrKeyword700); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "syntax";
                    }

                    }
                    break;
                case 77 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:296:5: 'auto'
                    {
                    match(input,123,FOLLOW_123_in_identifierOrKeyword708); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "auto";
                    }

                    }
                    break;
                case 78 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:297:5: 'addToContext'
                    {
                    match(input,124,FOLLOW_124_in_identifierOrKeyword716); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "addToContext";
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
    // ./scenariotestTemp/generated2/TCSObsolete.g:304:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:305:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:306:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:306:3: (ast= STRING )
            // ./scenariotestTemp/generated2/TCSObsolete.g:306:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol747); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/TCSObsolete.g:314:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:315:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:316:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:316:3: (ast= INT )
            // ./scenariotestTemp/generated2/TCSObsolete.g:316:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol778); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/TCSObsolete.g:324:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:325:3: ( (ast= FLOAT ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:326:3: (ast= FLOAT )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:326:3: (ast= FLOAT )
            // ./scenariotestTemp/generated2/TCSObsolete.g:326:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol809); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/TCSObsolete.g:334:1: main returns [Object ret2] : ( (ret= tcs_concretesyntax ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:335:3: ( ( (ret= tcs_concretesyntax ) EOF ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:336:3: ( (ret= tcs_concretesyntax ) EOF )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:336:3: ( (ret= tcs_concretesyntax ) EOF )
            // ./scenariotestTemp/generated2/TCSObsolete.g:336:4: (ret= tcs_concretesyntax ) EOF
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:336:4: (ret= tcs_concretesyntax )
            // ./scenariotestTemp/generated2/TCSObsolete.g:336:5: ret= tcs_concretesyntax
            {
            pushFollow(FOLLOW_tcs_concretesyntax_in_main837);
            ret=tcs_concretesyntax();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main840); if (state.failed) return ret2;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

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


    // $ANTLR start "tcs_concretesyntax"
    // ./scenariotestTemp/generated2/TCSObsolete.g:343:1: tcs_concretesyntax returns [Object ret2] : ( 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) ;
    public final Object tcs_concretesyntax() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConcreteSyntax");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:348:3: ( ( 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:349:3: ( 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:349:3: ( 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            // ./scenariotestTemp/generated2/TCSObsolete.g:349:4: 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,122,FOLLOW_122_in_tcs_concretesyntax871); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:349:62: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:349:64: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_concretesyntax878);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:349:148: ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LPAREN) ) {
                alt2=1;
            }
            else if ( (LA2_0==LCURLY) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:349:149: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:349:165: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:349:166: LPAREN 'k' EQ (temp= integerSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_concretesyntax891); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,101,FOLLOW_101_in_tcs_concretesyntax895); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax899); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:349:297: (temp= integerSymbol )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:349:299: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_tcs_concretesyntax907);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "k", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_concretesyntax914); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:349:424: 
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
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax932); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:350:75: ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:350:76: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:350:76: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:350:77: (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:350:94: (temp= tcs_template (temp= tcs_template )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==58||LA4_0==76||LA4_0==78||(LA4_0>=80 && LA4_0<=81)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:96: temp= tcs_template (temp= tcs_template )*
                    {
                    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax943);
                    temp=tcs_template();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templates", temp);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:153: (temp= tcs_template )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==58||LA3_0==76||LA3_0==78||(LA3_0>=80 && LA3_0<=81)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:350:155: temp= tcs_template
                    	    {
                    	    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax951);
                    	    temp=tcs_template();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "templates", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:350:251: ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==83) ) {
                alt7=1;
            }
            else if ( (LA7_0==RCURLY||(LA7_0>=87 && LA7_0<=88)||LA7_0==96||LA7_0==120) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:252: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:268: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:269: 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,83,FOLLOW_83_in_tcs_concretesyntax968); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax972); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:370: ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:371: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:371: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:372: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:389: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==NAME) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:350:391: temp= tcs_keyword (temp= tcs_keyword )*
                            {
                            pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax983);
                            temp=tcs_keyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "keywords", temp);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:350:446: (temp= tcs_keyword )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==NAME) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:350:448: temp= tcs_keyword
                            	    {
                            	    pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax991);
                            	    temp=tcs_keyword();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "keywords", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop5;
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
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1006); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:350:601: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:351:35: ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==120) ) {
                alt10=1;
            }
            else if ( (LA10_0==RCURLY||(LA10_0>=87 && LA10_0<=88)||LA10_0==96) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:36: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:52: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:53: 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,120,FOLLOW_120_in_tcs_concretesyntax1029); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1033); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:153: ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:154: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:154: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:155: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:172: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==NAME) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:351:174: temp= tcs_symbol (temp= tcs_symbol )*
                            {
                            pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1044);
                            temp=tcs_symbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "symbols", temp);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:351:227: (temp= tcs_symbol )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0==NAME) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:351:229: temp= tcs_symbol
                            	    {
                            	    pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1052);
                            	    temp=tcs_symbol();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "symbols", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
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
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1067); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:351:380: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:352:34: (temp= tcs_operatorlist (temp= tcs_operatorlist )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==96) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:36: temp= tcs_operatorlist (temp= tcs_operatorlist )*
                    {
                    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1088);
                    temp=tcs_operatorlist();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operatorLists", temp);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:101: (temp= tcs_operatorlist )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==96) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:352:103: temp= tcs_operatorlist
                    	    {
                    	    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1096);
                    	    temp=tcs_operatorlist();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "operatorLists", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:352:206: (temp= tcs_token (temp= tcs_token )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==88) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:208: temp= tcs_token (temp= tcs_token )*
                    {
                    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1111);
                    temp=tcs_token();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tokens", temp);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:259: (temp= tcs_token )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==88) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:352:261: temp= tcs_token
                    	    {
                    	    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1119);
                    	    temp=tcs_token();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "tokens", temp);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:352:351: ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==87) ) {
                alt15=1;
            }
            else if ( (LA15_0==RCURLY) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:352: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:368: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:369: 'lexer' EQ (temp= stringSymbol ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,87,FOLLOW_87_in_tcs_concretesyntax1136); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:463: (temp= stringSymbol )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:465: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_concretesyntax1148);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lexer", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_concretesyntax1155); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:352:591: 
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
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1176); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_concretesyntax"


    // $ANTLR start "tcs_template"
    // ./scenariotestTemp/generated2/TCSObsolete.g:361:1: tcs_template returns [Object ret2] : (ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_classtemplate | ret= tcs_operatortemplate | ret= tcs_functiontemplate ) ;
    public final Object tcs_template() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:362:3: ( (ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_classtemplate | ret= tcs_operatortemplate | ret= tcs_functiontemplate ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:363:3: (ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_classtemplate | ret= tcs_operatortemplate | ret= tcs_functiontemplate )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:363:3: (ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_classtemplate | ret= tcs_operatortemplate | ret= tcs_functiontemplate )
            int alt16=5;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt16=1;
                }
                break;
            case 78:
                {
                alt16=2;
                }
                break;
            case 80:
                {
                alt16=3;
                }
                break;
            case 76:
                {
                alt16=4;
                }
                break;
            case 81:
                {
                alt16=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:363:4: ret= tcs_primitivetemplate
                    {
                    pushFollow(FOLLOW_tcs_primitivetemplate_in_tcs_template1214);
                    ret=tcs_primitivetemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:364:5: ret= tcs_enumerationtemplate
                    {
                    pushFollow(FOLLOW_tcs_enumerationtemplate_in_tcs_template1222);
                    ret=tcs_enumerationtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:365:5: ret= tcs_classtemplate
                    {
                    pushFollow(FOLLOW_tcs_classtemplate_in_tcs_template1230);
                    ret=tcs_classtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:366:5: ret= tcs_operatortemplate
                    {
                    pushFollow(FOLLOW_tcs_operatortemplate_in_tcs_template1238);
                    ret=tcs_operatortemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:367:5: ret= tcs_functiontemplate
                    {
                    pushFollow(FOLLOW_tcs_functiontemplate_in_tcs_template1246);
                    ret=tcs_functiontemplate();

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
    // $ANTLR end "tcs_template"


    // $ANTLR start "reference"
    // ./scenariotestTemp/generated2/TCSObsolete.g:374:1: reference[Object ret] : ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) ;
    public final void reference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:375:3: ( ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:376:3: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:376:3: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:376:4: RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_reference1271); if (state.failed) return ;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:376:62: (temp= identifier ( ( DLCOLON ) temp= identifier )* )
            // ./scenariotestTemp/generated2/TCSObsolete.g:376:64: temp= identifier ( ( DLCOLON ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_reference1279);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              setProperty(ret, "names", temp);
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:376:115: ( ( DLCOLON ) temp= identifier )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==DLCOLON) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:376:116: ( DLCOLON ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:376:133: ( DLCOLON )
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:376:134: DLCOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_reference1288); if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_reference1296);
            	    temp=identifier();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "names", temp);
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
    // $ANTLR end "reference"


    // $ANTLR start "tcs_primitivetemplate"
    // ./scenariotestTemp/generated2/TCSObsolete.g:383:1: tcs_primitivetemplate returns [Object ret2] : ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI ) ;
    public final Object tcs_primitivetemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitiveTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:388:3: ( ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:389:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:389:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI )
            // ./scenariotestTemp/generated2/TCSObsolete.g:389:4: 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,58,FOLLOW_58_in_tcs_primitivetemplate1332); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:389:73: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:389:75: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1339);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "templateName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,51,FOLLOW_51_in_tcs_primitivetemplate1345); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            pushFollow(FOLLOW_reference_in_tcs_primitivetemplate1348);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:389:252: ( ( 'default' ) | )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==72) ) {
                alt18=1;
            }
            else if ( (LA18_0==107) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:389:253: ( 'default' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:389:269: ( 'default' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:389:270: 'default'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,72,FOLLOW_72_in_tcs_primitivetemplate1358); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isDefault", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:389:386: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isDefault", java.lang.Boolean.FALSE);
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
            match(input,107,FOLLOW_107_in_tcs_primitivetemplate1376); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:390:74: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:390:76: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1383);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "tokenName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:390:165: ( ( 'orKeyword' ) | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==86) ) {
                alt19=1;
            }
            else if ( (LA19_0==COLON) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:390:166: ( 'orKeyword' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:390:182: ( 'orKeyword' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:390:183: 'orKeyword'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,86,FOLLOW_86_in_tcs_primitivetemplate1395); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:390:301: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);
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
            match(input,COLON,FOLLOW_COLON_in_tcs_primitivetemplate1414); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,94,FOLLOW_94_in_tcs_primitivetemplate1418); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1422); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:391:151: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:391:153: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1430);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:391:240: ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==COMA) ) {
                alt20=1;
            }
            else if ( (LA20_0==SEMI) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:391:241: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:391:257: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:391:258: COMA 'serializer' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_primitivetemplate1443); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,77,FOLLOW_77_in_tcs_primitivetemplate1447); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1451); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:391:396: (temp= stringSymbol )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:391:398: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1459);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "serializer", temp);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:391:490: 
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
            match(input,SEMI,FOLLOW_SEMI_in_tcs_primitivetemplate1479); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_primitivetemplate"


    // $ANTLR start "tcs_enumerationtemplate"
    // ./scenariotestTemp/generated2/TCSObsolete.g:400:1: tcs_enumerationtemplate returns [Object ret2] : ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) ) ;
    public final Object tcs_enumerationtemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumerationTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:405:3: ( ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:406:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:406:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:406:4: 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,78,FOLLOW_78_in_tcs_enumerationtemplate1520); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            pushFollow(FOLLOW_reference_in_tcs_enumerationtemplate1523);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:406:123: ( ( 'auto' ) | )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==123) ) {
                alt21=1;
            }
            else if ( (LA21_0==SEMI||LA21_0==COLON) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:406:124: ( 'auto' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:406:140: ( 'auto' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:406:141: 'auto'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,123,FOLLOW_123_in_tcs_enumerationtemplate1533); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "automatic", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:406:254: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "automatic", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:407:35: ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==COLON) ) {
                alt24=1;
            }
            else if ( (LA24_0==SEMI) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:36: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:52: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:53: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:70: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:71: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:71: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:72: COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_enumerationtemplate1561); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:129: ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:130: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:130: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:131: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:148: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==SHARP) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:407:150: temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )*
                            {
                            pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate1572);
                            temp=tcs_enumliteralmapping();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mappings", temp);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:407:216: ( ( COMA ) temp= tcs_enumliteralmapping )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==COMA) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:407:217: ( COMA ) temp= tcs_enumliteralmapping
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:407:234: ( COMA )
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:407:235: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_enumerationtemplate1581); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate1589);
                            	    temp=tcs_enumliteralmapping();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "mappings", temp);
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


                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate1604); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:472: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:488: ( SEMI )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:407:489: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate1621); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_enumerationtemplate"


    // $ANTLR start "tcs_enumliteralmapping"
    // ./scenariotestTemp/generated2/TCSObsolete.g:416:1: tcs_enumliteralmapping returns [Object ret2] : ( (temp= tcs_enumliteralval ) EQ (temp= tcs_sequenceelement ) ) ;
    public final Object tcs_enumliteralmapping() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:421:3: ( ( (temp= tcs_enumliteralval ) EQ (temp= tcs_sequenceelement ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:422:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_sequenceelement ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:422:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_sequenceelement ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:422:4: (temp= tcs_enumliteralval ) EQ (temp= tcs_sequenceelement )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:422:21: (temp= tcs_enumliteralval )
            // ./scenariotestTemp/generated2/TCSObsolete.g:422:23: temp= tcs_enumliteralval
            {
            pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping1672);
            temp=tcs_enumliteralval();

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
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_enumliteralmapping1679); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:422:154: (temp= tcs_sequenceelement )
            // ./scenariotestTemp/generated2/TCSObsolete.g:422:156: temp= tcs_sequenceelement
            {
            pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_enumliteralmapping1687);
            temp=tcs_sequenceelement();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "element", temp);
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
    // $ANTLR end "tcs_enumliteralmapping"


    // $ANTLR start "tcs_classtemplate"
    // ./scenariotestTemp/generated2/TCSObsolete.g:430:1: tcs_classtemplate returns [Object ret2] : ( 'template' reference[ret] ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) ) ;
    public final Object tcs_classtemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:435:3: ( ( 'template' reference[ret] ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:436:3: ( 'template' reference[ret] ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:436:3: ( 'template' reference[ret] ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:436:4: 'template' reference[ret] ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,80,FOLLOW_80_in_tcs_classtemplate1730); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            pushFollow(FOLLOW_reference_in_tcs_classtemplate1733);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:436:112: ( ( SHARP (temp= identifier ) ) | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==SHARP) ) {
                alt25=1;
            }
            else if ( (LA25_0==LPAREN||LA25_0==SEMI||LA25_0==COLON||LA25_0==56||LA25_0==71||LA25_0==84||LA25_0==97||LA25_0==106||LA25_0==117||LA25_0==119||LA25_0==121||LA25_0==124) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:436:113: ( SHARP (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:436:129: ( SHARP (temp= identifier ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:436:130: SHARP (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_tcs_classtemplate1744); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:436:187: (temp= identifier )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:436:189: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_classtemplate1752);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "mode", temp);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:436:273: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:437:35: ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==LPAREN) ) {
                alt26=1;
            }
            else if ( (LA26_0==SEMI||LA26_0==COLON||LA26_0==56||LA26_0==71||LA26_0==84||LA26_0==97||LA26_0==106||LA26_0==117||LA26_0==119||LA26_0==121||LA26_0==124) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:437:36: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:437:52: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:437:53: LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate1778); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,54,FOLLOW_54_in_tcs_classtemplate1782); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate1786); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:437:195: (temp= stringSymbol )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:437:197: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate1794);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "disambiguate", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate1801); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:437:332: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:438:35: ( ( 'multi' ) | )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==121) ) {
                alt27=1;
            }
            else if ( (LA27_0==SEMI||LA27_0==COLON||LA27_0==56||LA27_0==71||LA27_0==84||LA27_0==97||LA27_0==106||LA27_0==117||LA27_0==119||LA27_0==124) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:438:36: ( 'multi' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:438:52: ( 'multi' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:438:53: 'multi'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,121,FOLLOW_121_in_tcs_classtemplate1824); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isMulti", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:438:165: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isMulti", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:439:35: ( ( 'main' ) | )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==84) ) {
                alt28=1;
            }
            else if ( (LA28_0==SEMI||LA28_0==COLON||LA28_0==56||LA28_0==71||LA28_0==97||LA28_0==106||LA28_0==117||LA28_0==119||LA28_0==124) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:439:36: ( 'main' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:439:52: ( 'main' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:439:53: 'main'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,84,FOLLOW_84_in_tcs_classtemplate1848); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isMain", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:439:163: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isMain", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:440:35: ( ( ( ( 'deep' ) | ) 'abstract' ) | )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==71||LA30_0==117) ) {
                alt30=1;
            }
            else if ( (LA30_0==SEMI||LA30_0==COLON||LA30_0==56||LA30_0==97||LA30_0==106||LA30_0==119||LA30_0==124) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:440:36: ( ( ( 'deep' ) | ) 'abstract' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:440:52: ( ( ( 'deep' ) | ) 'abstract' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:440:53: ( ( 'deep' ) | ) 'abstract'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:440:71: ( ( 'deep' ) | )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==117) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==71) ) {
                        alt29=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:440:72: ( 'deep' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:440:88: ( 'deep' )
                            // ./scenariotestTemp/generated2/TCSObsolete.g:440:89: 'deep'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,117,FOLLOW_117_in_tcs_classtemplate1878); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              setProperty(ret, "isDeep", java.lang.Boolean.TRUE);
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:440:199: 
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "isDeep", java.lang.Boolean.FALSE);
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
                    match(input,71,FOLLOW_71_in_tcs_classtemplate1896); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:441:135: 
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
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:442:35: ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==119) ) {
                alt32=1;
            }
            else if ( (LA32_0==SEMI||LA32_0==COLON||LA32_0==56||LA32_0==97||LA32_0==106||LA32_0==124) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:442:36: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:442:52: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:442:53: 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,119,FOLLOW_119_in_tcs_classtemplate1920); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:442:116: ( ( LPAREN (temp= identifier ) RPAREN ) | )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==LPAREN) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==SEMI||LA31_0==COLON||LA31_0==56||LA31_0==97||LA31_0==106||LA31_0==124) ) {
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
                            // ./scenariotestTemp/generated2/TCSObsolete.g:442:117: ( LPAREN (temp= identifier ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:442:133: ( LPAREN (temp= identifier ) RPAREN )
                            // ./scenariotestTemp/generated2/TCSObsolete.g:442:134: LPAREN (temp= identifier ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate1930); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:442:192: (temp= identifier )
                            // ./scenariotestTemp/generated2/TCSObsolete.g:442:194: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_classtemplate1938);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate1945); if (state.failed) return ret2;
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
                            // ./scenariotestTemp/generated2/TCSObsolete.g:442:392: 
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
                      setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:443:94: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:444:35: ( ( 'context' ) | )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==56) ) {
                alt33=1;
            }
            else if ( (LA33_0==SEMI||LA33_0==COLON||LA33_0==97||LA33_0==106||LA33_0==124) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:444:36: ( 'context' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:444:52: ( 'context' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:444:53: 'context'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,56,FOLLOW_56_in_tcs_classtemplate1983); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isContext", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:444:169: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isContext", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:445:35: ( ( 'addToContext' ) | )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==124) ) {
                alt34=1;
            }
            else if ( (LA34_0==SEMI||LA34_0==COLON||LA34_0==97||LA34_0==106) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:445:36: ( 'addToContext' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:445:52: ( 'addToContext' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:445:53: 'addToContext'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,124,FOLLOW_124_in_tcs_classtemplate2007); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:445:179: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:446:35: ( ( 'nonPrimary' ) | )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==106) ) {
                alt35=1;
            }
            else if ( (LA35_0==SEMI||LA35_0==COLON||LA35_0==97) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:446:36: ( 'nonPrimary' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:446:52: ( 'nonPrimary' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:446:53: 'nonPrimary'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,106,FOLLOW_106_in_tcs_classtemplate2031); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:446:175: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:447:35: ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==97) ) {
                alt36=1;
            }
            else if ( (LA36_0==SEMI||LA36_0==COLON) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:36: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:52: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:53: 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,97,FOLLOW_97_in_tcs_classtemplate2055); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:111: ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:112: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:112: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:113: COLON ( ( (temp= tcs_sequence ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2062); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:170: ( ( (temp= tcs_sequence ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:171: ( (temp= tcs_sequence ) )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:171: ( (temp= tcs_sequence ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:172: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:189: (temp= tcs_sequence )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:191: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2073);
                    temp=tcs_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "prefixSequence", temp);
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


                    }

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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:447:323: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:448:35: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==COLON) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:36: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:52: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:53: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:70: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:71: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:71: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:72: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:129: ( ( (temp= tcs_sequence ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:130: ( (temp= tcs_sequence ) )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:130: ( (temp= tcs_sequence ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:131: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:148: (temp= tcs_sequence )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:150: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2119);
                    temp=tcs_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templateSequence", temp);
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
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2129); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:323: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:339: ( SEMI )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:448:340: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2146); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_classtemplate"


    // $ANTLR start "tcs_operatortemplate"
    // ./scenariotestTemp/generated2/TCSObsolete.g:457:1: tcs_operatortemplate returns [Object ret2] : ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ RARROW (temp= identifier ) ( ( COMA 'storeOpTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'storeRightTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'context' ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) ) ;
    public final Object tcs_operatortemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:462:3: ( ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ RARROW (temp= identifier ) ( ( COMA 'storeOpTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'storeRightTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'context' ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:463:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ RARROW (temp= identifier ) ( ( COMA 'storeOpTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'storeRightTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'context' ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:463:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ RARROW (temp= identifier ) ( ( COMA 'storeOpTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'storeRightTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'context' ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:463:4: 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ RARROW (temp= identifier ) ( ( COMA 'storeOpTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'storeRightTo' EQ RARROW (temp= identifier ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'context' ) | ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,76,FOLLOW_76_in_tcs_operatortemplate2193); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            pushFollow(FOLLOW_reference_in_tcs_operatortemplate2196);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_operatortemplate2201); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,96,FOLLOW_96_in_tcs_operatortemplate2205); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2209); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:463:241: (temp= identifier (temp= identifier )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==NAME) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:463:243: temp= identifier (temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2217);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:463:359: (temp= identifier )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==NAME) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:463:361: temp= identifier
                    	    {
                    	    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2225);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop38;
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
            match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2237); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,112,FOLLOW_112_in_tcs_operatortemplate2241); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2245); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_operatortemplate2250); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:463:673: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:463:675: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2258);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "source", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:463:761: ( ( COMA 'storeOpTo' EQ RARROW (temp= identifier ) ) | )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==COMA) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==54||LA40_1==92||LA40_1==98) ) {
                    alt40=2;
                }
                else if ( (LA40_1==53) ) {
                    alt40=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA40_0==RPAREN) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:463:762: ( COMA 'storeOpTo' EQ RARROW (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:463:778: ( COMA 'storeOpTo' EQ RARROW (temp= identifier ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:463:779: COMA 'storeOpTo' EQ RARROW (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2271); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,53,FOLLOW_53_in_tcs_operatortemplate2275); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2279); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_tcs_operatortemplate2284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:463:957: (temp= identifier )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:463:959: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2292);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "storeOpTo", temp);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:463:1048: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:464:35: ( ( COMA 'storeRightTo' EQ RARROW (temp= identifier ) ) | )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==COMA) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==98) ) {
                    alt41=1;
                }
                else if ( (LA41_1==54||LA41_1==92) ) {
                    alt41=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA41_0==RPAREN) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:464:36: ( COMA 'storeRightTo' EQ RARROW (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:464:52: ( COMA 'storeRightTo' EQ RARROW (temp= identifier ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:464:53: COMA 'storeRightTo' EQ RARROW (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2318); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,98,FOLLOW_98_in_tcs_operatortemplate2322); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2326); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_tcs_operatortemplate2331); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:464:234: (temp= identifier )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:464:236: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2339);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "storeRightTo", temp);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:464:328: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:465:35: ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==COMA) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==54) ) {
                    alt42=1;
                }
                else if ( (LA42_1==92) ) {
                    alt42=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA42_0==RPAREN) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:465:36: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:465:52: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:465:53: COMA 'disambiguate' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2365); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,54,FOLLOW_54_in_tcs_operatortemplate2369); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2373); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:465:193: (temp= stringSymbol )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:465:195: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate2381);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "disambiguate", temp);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:465:289: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:466:35: ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==COMA) ) {
                alt43=1;
            }
            else if ( (LA43_0==RPAREN) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:466:36: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:466:52: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:466:53: COMA 'disambiguateV3' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2407); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,92,FOLLOW_92_in_tcs_operatortemplate2411); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2415); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:466:195: (temp= stringSymbol )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:466:197: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate2423);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "disambiguateV3", temp);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:466:293: 
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
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_operatortemplate2443); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:467:76: ( ( 'context' ) | )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==56) ) {
                alt44=1;
            }
            else if ( (LA44_0==SEMI||LA44_0==COLON) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:467:77: ( 'context' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:467:93: ( 'context' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:467:94: 'context'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,56,FOLLOW_56_in_tcs_operatortemplate2453); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isContext", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:467:210: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isContext", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:468:35: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==COLON) ) {
                alt45=1;
            }
            else if ( (LA45_0==SEMI) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:36: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:52: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:53: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:70: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:71: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:71: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:72: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_operatortemplate2481); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:129: ( ( (temp= tcs_sequence ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:130: ( (temp= tcs_sequence ) )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:130: ( (temp= tcs_sequence ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:131: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:148: (temp= tcs_sequence )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:150: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_operatortemplate2492);
                    temp=tcs_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "otSequence", temp);
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
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate2502); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:317: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:333: ( SEMI )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:468:334: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate2519); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_operatortemplate"


    // $ANTLR start "tcs_functiontemplate"
    // ./scenariotestTemp/generated2/TCSObsolete.g:477:1: tcs_functiontemplate returns [Object ret2] : ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) ;
    public final Object tcs_functiontemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:482:3: ( ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:4: 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,81,FOLLOW_81_in_tcs_functiontemplate2566); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:64: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:66: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functiontemplate2573);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "functionName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_functiontemplate2580); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            pushFollow(FOLLOW_reference_in_tcs_functiontemplate2584);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_functiontemplate2589); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:286: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:287: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:287: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:288: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_functiontemplate2597); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:345: ( ( (temp= tcs_sequence ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:346: ( (temp= tcs_sequence ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:346: ( (temp= tcs_sequence ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:347: (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:364: (temp= tcs_sequence )
            // ./scenariotestTemp/generated2/TCSObsolete.g:483:366: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_functiontemplate2608);
            temp=tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "functionSequence", temp);
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
            match(input,SEMI,FOLLOW_SEMI_in_tcs_functiontemplate2618); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_functiontemplate"


    // $ANTLR start "tcs_sequence"
    // ./scenariotestTemp/generated2/TCSObsolete.g:491:1: tcs_sequence returns [Object ret2] : ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequence() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Sequence");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:496:3: ( ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:497:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:497:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // ./scenariotestTemp/generated2/TCSObsolete.g:497:4: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:497:21: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==STRING||LA47_0==LPAREN||LA47_0==RARROW||LA47_0==LT||LA47_0==LSQUARE||LA47_0==DLCURLY||LA47_0==DLSQUARE||LA47_0==DOLLAR) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:497:23: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence2666);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:497:86: (temp= tcs_sequenceelement )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==STRING||LA46_0==LPAREN||LA46_0==RARROW||LA46_0==LT||LA46_0==LSQUARE||LA46_0==DLCURLY||LA46_0==DLSQUARE||LA46_0==DOLLAR) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:497:88: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence2674);
                    	    temp=tcs_sequenceelement();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "elements", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
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
    // $ANTLR end "tcs_sequence"


    // $ANTLR start "tcs_sequenceelement"
    // ./scenariotestTemp/generated2/TCSObsolete.g:505:1: tcs_sequenceelement returns [Object ret2] : (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_propertyinit | ret= tcs_alternative | ret= tcs_functioncall ) ;
    public final Object tcs_sequenceelement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:506:3: ( (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_propertyinit | ret= tcs_alternative | ret= tcs_functioncall ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:507:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_propertyinit | ret= tcs_alternative | ret= tcs_functioncall )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:507:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_propertyinit | ret= tcs_alternative | ret= tcs_functioncall )
            int alt48=8;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt48=1;
                }
                break;
            case RARROW:
                {
                alt48=2;
                }
                break;
            case LT:
                {
                alt48=3;
                }
                break;
            case LSQUARE:
                {
                alt48=4;
                }
                break;
            case LPAREN:
                {
                alt48=5;
                }
                break;
            case DLCURLY:
                {
                alt48=6;
                }
                break;
            case DLSQUARE:
                {
                alt48=7;
                }
                break;
            case DOLLAR:
                {
                alt48=8;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:507:4: ret= tcs_literalref
                    {
                    pushFollow(FOLLOW_tcs_literalref_in_tcs_sequenceelement2719);
                    ret=tcs_literalref();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:508:5: ret= tcs_property
                    {
                    pushFollow(FOLLOW_tcs_property_in_tcs_sequenceelement2727);
                    ret=tcs_property();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:509:5: ret= tcs_customseparator
                    {
                    pushFollow(FOLLOW_tcs_customseparator_in_tcs_sequenceelement2735);
                    ret=tcs_customseparator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:510:5: ret= tcs_block
                    {
                    pushFollow(FOLLOW_tcs_block_in_tcs_sequenceelement2743);
                    ret=tcs_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:511:5: ret= tcs_conditionalelement
                    {
                    pushFollow(FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement2751);
                    ret=tcs_conditionalelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:512:5: ret= tcs_propertyinit
                    {
                    pushFollow(FOLLOW_tcs_propertyinit_in_tcs_sequenceelement2759);
                    ret=tcs_propertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:513:5: ret= tcs_alternative
                    {
                    pushFollow(FOLLOW_tcs_alternative_in_tcs_sequenceelement2767);
                    ret=tcs_alternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:514:5: ret= tcs_functioncall
                    {
                    pushFollow(FOLLOW_tcs_functioncall_in_tcs_sequenceelement2775);
                    ret=tcs_functioncall();

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
    // $ANTLR end "tcs_sequenceelement"


    // $ANTLR start "tcs_literalref"
    // ./scenariotestTemp/generated2/TCSObsolete.g:521:1: tcs_literalref returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_literalref() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LiteralRef");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:526:3: ( ( (temp= stringSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:527:3: ( (temp= stringSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:527:3: ( (temp= stringSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:527:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:527:21: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:527:23: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_literalref2809);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);
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
    // $ANTLR end "tcs_literalref"


    // $ANTLR start "tcs_property"
    // ./scenariotestTemp/generated2/TCSObsolete.g:535:1: tcs_property returns [Object ret2] : ( RARROW (temp= identifierOrKeyword ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_property() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Property");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:540:3: ( ( RARROW (temp= identifierOrKeyword ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:541:3: ( RARROW (temp= identifierOrKeyword ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:541:3: ( RARROW (temp= identifierOrKeyword ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:541:4: RARROW (temp= identifierOrKeyword ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_property2853); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:541:62: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:541:64: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_property2861);
            temp=identifierOrKeyword();

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
            // ./scenariotestTemp/generated2/TCSObsolete.g:541:157: ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==LCURLY) ) {
                alt51=1;
            }
            else if ( (LA51_0==EOF||LA51_0==STRING||LA51_0==LPAREN||LA51_0==RPAREN||(LA51_0>=RCURLY && LA51_0<=RARROW)||(LA51_0>=COLON && LA51_0<=COMA)||LA51_0==LT||(LA51_0>=LSQUARE && LA51_0<=RSQUARE)||LA51_0==DLCURLY||(LA51_0>=DLSQUARE && LA51_0<=DRSQUARE)||LA51_0==DOLLAR) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:541:158: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:541:174: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:541:175: LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_property2874); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:541:233: (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==59||(LA50_0>=66 && LA50_0<=67)||LA50_0==73||LA50_0==75||LA50_0==82||LA50_0==85||LA50_0==108||LA50_0==111||(LA50_0>=115 && LA50_0<=116)) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:541:235: temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )*
                            {
                            pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property2882);
                            temp=tcs_propertyarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "propertyArgs", temp);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:541:298: ( ( COMA ) temp= tcs_propertyarg )*
                            loop49:
                            do {
                                int alt49=2;
                                int LA49_0 = input.LA(1);

                                if ( (LA49_0==COMA) ) {
                                    alt49=1;
                                }


                                switch (alt49) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:541:299: ( COMA ) temp= tcs_propertyarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:541:316: ( COMA )
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:541:317: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_property2891); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property2899);
                            	    temp=tcs_propertyarg();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "propertyArgs", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop49;
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
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_property2911); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:541:517: 
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
    // $ANTLR end "tcs_property"


    // $ANTLR start "tcs_customseparator"
    // ./scenariotestTemp/generated2/TCSObsolete.g:550:1: tcs_customseparator returns [Object ret2] : ( LT (temp= identifier ) GT ) ;
    public final Object tcs_customseparator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CustomSeparator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:555:3: ( ( LT (temp= identifier ) GT ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:556:3: ( LT (temp= identifier ) GT )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:556:3: ( LT (temp= identifier ) GT )
            // ./scenariotestTemp/generated2/TCSObsolete.g:556:4: LT (temp= identifier ) GT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LT,FOLLOW_LT_in_tcs_customseparator2966); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:556:58: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:556:60: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_customseparator2974);
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
            match(input,GT,FOLLOW_GT_in_tcs_customseparator2981); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_customseparator"


    // $ANTLR start "tcs_block"
    // ./scenariotestTemp/generated2/TCSObsolete.g:564:1: tcs_block returns [Object ret2] : ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_block() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:569:3: ( ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:570:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:570:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:570:4: LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_block3023); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:570:63: (temp= tcs_sequence )
            // ./scenariotestTemp/generated2/TCSObsolete.g:570:65: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_block3031);
            temp=tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "blockSequence", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_block3038); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:570:202: ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==LCURLY) ) {
                alt54=1;
            }
            else if ( (LA54_0==EOF||LA54_0==STRING||LA54_0==LPAREN||LA54_0==RPAREN||(LA54_0>=RCURLY && LA54_0<=RARROW)||(LA54_0>=COLON && LA54_0<=COMA)||LA54_0==LT||(LA54_0>=LSQUARE && LA54_0<=RSQUARE)||LA54_0==DLCURLY||(LA54_0>=DLSQUARE && LA54_0<=DRSQUARE)||LA54_0==DOLLAR) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:570:203: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:570:219: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:570:220: LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_block3049); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:570:278: (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=63 && LA53_0<=64)||LA53_0==89||LA53_0==99||LA53_0==109) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:570:280: temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )*
                            {
                            pushFollow(FOLLOW_tcs_blockarg_in_tcs_block3057);
                            temp=tcs_blockarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "blockArgs", temp);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:570:337: ( ( COMA ) temp= tcs_blockarg )*
                            loop52:
                            do {
                                int alt52=2;
                                int LA52_0 = input.LA(1);

                                if ( (LA52_0==COMA) ) {
                                    alt52=1;
                                }


                                switch (alt52) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:570:338: ( COMA ) temp= tcs_blockarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:570:355: ( COMA )
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:570:356: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_block3066); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_blockarg_in_tcs_block3074);
                            	    temp=tcs_blockarg();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "blockArgs", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop52;
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
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_block3086); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:570:550: 
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
    // $ANTLR end "tcs_block"


    // $ANTLR start "tcs_conditionalelement"
    // ./scenariotestTemp/generated2/TCSObsolete.g:579:1: tcs_conditionalelement returns [Object ret2] : ( LPAREN (temp= tcs_expression ) QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) ;
    public final Object tcs_conditionalelement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConditionalElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:584:3: ( ( LPAREN (temp= tcs_expression ) QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:585:3: ( LPAREN (temp= tcs_expression ) QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:585:3: ( LPAREN (temp= tcs_expression ) QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            // ./scenariotestTemp/generated2/TCSObsolete.g:585:4: LPAREN (temp= tcs_expression ) QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_conditionalelement3141); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:585:62: (temp= tcs_expression )
            // ./scenariotestTemp/generated2/TCSObsolete.g:585:64: temp= tcs_expression
            {
            pushFollow(FOLLOW_tcs_expression_in_tcs_conditionalelement3149);
            temp=tcs_expression();

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
              _beforeSeqEl();
            }
            match(input,QMARK,FOLLOW_QMARK_in_tcs_conditionalelement3156); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:585:196: (temp= tcs_sequence )
            // ./scenariotestTemp/generated2/TCSObsolete.g:585:198: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement3164);
            temp=tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "thenSequence", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:585:292: ( ( COLON (temp= tcs_sequence ) ) | )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==COLON) ) {
                alt55=1;
            }
            else if ( (LA55_0==RPAREN) ) {
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:585:293: ( COLON (temp= tcs_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:585:309: ( COLON (temp= tcs_sequence ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:585:310: COLON (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_conditionalelement3177); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:585:367: (temp= tcs_sequence )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:585:369: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement3185);
                    temp=tcs_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elseSequence", temp);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:585:463: 
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
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_conditionalelement3205); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_conditionalelement"


    // $ANTLR start "tcs_propertyinit"
    // ./scenariotestTemp/generated2/TCSObsolete.g:594:1: tcs_propertyinit returns [Object ret2] : ( DLCURLY RARROW (temp= identifier ) EQ (temp= tcs_value ) DRCURLY ) ;
    public final Object tcs_propertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:599:3: ( ( DLCURLY RARROW (temp= identifier ) EQ (temp= tcs_value ) DRCURLY ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:600:3: ( DLCURLY RARROW (temp= identifier ) EQ (temp= tcs_value ) DRCURLY )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:600:3: ( DLCURLY RARROW (temp= identifier ) EQ (temp= tcs_value ) DRCURLY )
            // ./scenariotestTemp/generated2/TCSObsolete.g:600:4: DLCURLY RARROW (temp= identifier ) EQ (temp= tcs_value ) DRCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,DLCURLY,FOLLOW_DLCURLY_in_tcs_propertyinit3247); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_propertyinit3252); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:600:104: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:600:106: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_propertyinit3260);
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
            match(input,EQ,FOLLOW_EQ_in_tcs_propertyinit3267); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:600:226: (temp= tcs_value )
            // ./scenariotestTemp/generated2/TCSObsolete.g:600:228: temp= tcs_value
            {
            pushFollow(FOLLOW_tcs_value_in_tcs_propertyinit3275);
            temp=tcs_value();

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
            match(input,DRCURLY,FOLLOW_DRCURLY_in_tcs_propertyinit3282); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_propertyinit"


    // $ANTLR start "tcs_alternative"
    // ./scenariotestTemp/generated2/TCSObsolete.g:608:1: tcs_alternative returns [Object ret2] : ( DLSQUARE (temp= tcs_sequence ( ( PIPE ) temp= tcs_sequence )+ ) DRSQUARE ( ( STAR ) | ) ) ;
    public final Object tcs_alternative() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Alternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:613:3: ( ( DLSQUARE (temp= tcs_sequence ( ( PIPE ) temp= tcs_sequence )+ ) DRSQUARE ( ( STAR ) | ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:614:3: ( DLSQUARE (temp= tcs_sequence ( ( PIPE ) temp= tcs_sequence )+ ) DRSQUARE ( ( STAR ) | ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:614:3: ( DLSQUARE (temp= tcs_sequence ( ( PIPE ) temp= tcs_sequence )+ ) DRSQUARE ( ( STAR ) | ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:614:4: DLSQUARE (temp= tcs_sequence ( ( PIPE ) temp= tcs_sequence )+ ) DRSQUARE ( ( STAR ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,DLSQUARE,FOLLOW_DLSQUARE_in_tcs_alternative3324); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:614:64: (temp= tcs_sequence ( ( PIPE ) temp= tcs_sequence )+ )
            // ./scenariotestTemp/generated2/TCSObsolete.g:614:66: temp= tcs_sequence ( ( PIPE ) temp= tcs_sequence )+
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_alternative3332);
            temp=tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "sequences", temp);
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:614:123: ( ( PIPE ) temp= tcs_sequence )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==PIPE) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:614:124: ( PIPE ) temp= tcs_sequence
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:614:141: ( PIPE )
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:614:142: PIPE
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PIPE,FOLLOW_PIPE_in_tcs_alternative3341); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_tcs_sequence_in_tcs_alternative3349);
            	    temp=tcs_sequence();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "sequences", temp);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
            	    if (state.backtracking>0) {state.failed=true; return ret2;}
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,DRSQUARE,FOLLOW_DRSQUARE_in_tcs_alternative3358); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:614:335: ( ( STAR ) | )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==STAR) ) {
                alt57=1;
            }
            else if ( (LA57_0==EOF||LA57_0==STRING||LA57_0==LPAREN||LA57_0==RPAREN||(LA57_0>=RCURLY && LA57_0<=RARROW)||(LA57_0>=COLON && LA57_0<=COMA)||LA57_0==LT||(LA57_0>=LSQUARE && LA57_0<=RSQUARE)||LA57_0==DLCURLY||(LA57_0>=DLSQUARE && LA57_0<=DRSQUARE)||LA57_0==DOLLAR) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:614:336: ( STAR )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:614:352: ( STAR )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:614:353: STAR
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,STAR,FOLLOW_STAR_in_tcs_alternative3369); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isMulti", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:614:464: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isMulti", java.lang.Boolean.FALSE);
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
    // $ANTLR end "tcs_alternative"


    // $ANTLR start "tcs_functioncall"
    // ./scenariotestTemp/generated2/TCSObsolete.g:623:1: tcs_functioncall returns [Object ret2] : ( DOLLAR (temp= identifier ) ) ;
    public final Object tcs_functioncall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:628:3: ( ( DOLLAR (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:629:3: ( DOLLAR (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:629:3: ( DOLLAR (temp= identifier ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:629:4: DOLLAR (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,DOLLAR,FOLLOW_DOLLAR_in_tcs_functioncall3426); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:629:62: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:629:64: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functioncall3434);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);
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
    // $ANTLR end "tcs_functioncall"


    // $ANTLR start "tcs_propertyarg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:637:1: tcs_propertyarg returns [Object ret2] : (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_referstokeyparg | ret= tcs_separatorparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_forcedlowerparg | ret= tcs_createasparg | ret= tcs_modeparg ) ;
    public final Object tcs_propertyarg() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:638:3: ( (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_referstokeyparg | ret= tcs_separatorparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_forcedlowerparg | ret= tcs_createasparg | ret= tcs_modeparg ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:639:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_referstokeyparg | ret= tcs_separatorparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_forcedlowerparg | ret= tcs_createasparg | ret= tcs_modeparg )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:639:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_referstokeyparg | ret= tcs_separatorparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_forcedlowerparg | ret= tcs_createasparg | ret= tcs_modeparg )
            int alt58=11;
            switch ( input.LA(1) ) {
            case 108:
                {
                alt58=1;
                }
                break;
            case 67:
                {
                alt58=2;
                }
                break;
            case 115:
                {
                alt58=3;
                }
                break;
            case 75:
                {
                alt58=4;
                }
                break;
            case 59:
                {
                alt58=5;
                }
                break;
            case 85:
                {
                alt58=6;
                }
                break;
            case 111:
                {
                alt58=7;
                }
                break;
            case 73:
                {
                alt58=8;
                }
                break;
            case 116:
                {
                alt58=9;
                }
                break;
            case 82:
                {
                alt58=10;
                }
                break;
            case 66:
                {
                alt58=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:639:4: ret= tcs_referstoparg
                    {
                    pushFollow(FOLLOW_tcs_referstoparg_in_tcs_propertyarg3474);
                    ret=tcs_referstoparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:640:5: ret= tcs_lookinparg
                    {
                    pushFollow(FOLLOW_tcs_lookinparg_in_tcs_propertyarg3482);
                    ret=tcs_lookinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:641:5: ret= tcs_createinparg
                    {
                    pushFollow(FOLLOW_tcs_createinparg_in_tcs_propertyarg3490);
                    ret=tcs_createinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:642:5: ret= tcs_asparg
                    {
                    pushFollow(FOLLOW_tcs_asparg_in_tcs_propertyarg3498);
                    ret=tcs_asparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:643:5: ret= tcs_referstokeyparg
                    {
                    pushFollow(FOLLOW_tcs_referstokeyparg_in_tcs_propertyarg3506);
                    ret=tcs_referstokeyparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:644:5: ret= tcs_separatorparg
                    {
                    pushFollow(FOLLOW_tcs_separatorparg_in_tcs_propertyarg3514);
                    ret=tcs_separatorparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:645:5: ret= tcs_autocreateparg
                    {
                    pushFollow(FOLLOW_tcs_autocreateparg_in_tcs_propertyarg3522);
                    ret=tcs_autocreateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:646:5: ret= tcs_importcontextparg
                    {
                    pushFollow(FOLLOW_tcs_importcontextparg_in_tcs_propertyarg3530);
                    ret=tcs_importcontextparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 9 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:647:5: ret= tcs_forcedlowerparg
                    {
                    pushFollow(FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg3538);
                    ret=tcs_forcedlowerparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 10 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:648:5: ret= tcs_createasparg
                    {
                    pushFollow(FOLLOW_tcs_createasparg_in_tcs_propertyarg3546);
                    ret=tcs_createasparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 11 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:649:5: ret= tcs_modeparg
                    {
                    pushFollow(FOLLOW_tcs_modeparg_in_tcs_propertyarg3554);
                    ret=tcs_modeparg();

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
    // $ANTLR end "tcs_propertyarg"


    // $ANTLR start "tcs_referstoparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:656:1: tcs_referstoparg returns [Object ret2] : ( 'refersTo' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_referstoparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RefersToPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:661:3: ( ( 'refersTo' EQ (temp= identifierOrKeyword ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:662:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:662:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:662:4: 'refersTo' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,108,FOLLOW_108_in_tcs_referstoparg3584); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_referstoparg3588); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:662:101: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:662:103: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_referstoparg3596);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
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
    // $ANTLR end "tcs_referstoparg"


    // $ANTLR start "tcs_lookinparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:670:1: tcs_lookinparg returns [Object ret2] : ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) ;
    public final Object tcs_lookinparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:675:3: ( ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:676:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:676:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:676:4: 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,67,FOLLOW_67_in_tcs_lookinparg3639); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_lookinparg3643); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:676:100: ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==SHARP) ) {
                alt60=1;
            }
            else if ( (LA60_0==NAME||(LA60_0>=48 && LA60_0<=124)) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:101: ( SHARP 'all' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:117: ( SHARP 'all' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:118: SHARP 'all'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_tcs_lookinparg3654); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,91,FOLLOW_91_in_tcs_lookinparg3658); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyName", new String("#all"));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:269: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:285: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:286: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:303: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:305: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg3675);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyName", temp);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:676:372: ( ( POINT ) temp= identifierOrKeyword )*
                    loop59:
                    do {
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==POINT) ) {
                            alt59=1;
                        }


                        switch (alt59) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:676:373: ( POINT ) temp= identifierOrKeyword
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:676:390: ( POINT )
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:676:391: POINT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,POINT,FOLLOW_POINT_in_tcs_lookinparg3684); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg3692);
                    	    temp=identifierOrKeyword();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "propertyName", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop59;
                        }
                    } while (true);


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
    // $ANTLR end "tcs_lookinparg"


    // $ANTLR start "tcs_createinparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:685:1: tcs_createinparg returns [Object ret2] : ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createinparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:690:3: ( ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:691:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:691:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:691:4: 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,115,FOLLOW_115_in_tcs_createinparg3745); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createinparg3749); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:691:101: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            // ./scenariotestTemp/generated2/TCSObsolete.g:691:103: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg3757);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:691:170: ( ( POINT ) temp= identifierOrKeyword )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==POINT) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:691:171: ( POINT ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:691:188: ( POINT )
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:691:189: POINT
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,POINT,FOLLOW_POINT_in_tcs_createinparg3766); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg3774);
            	    temp=identifierOrKeyword();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "propertyName", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


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
    // $ANTLR end "tcs_createinparg"


    // $ANTLR start "tcs_asparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:699:1: tcs_asparg returns [Object ret2] : ( 'as' EQ (temp= identifier ) ) ;
    public final Object tcs_asparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:704:3: ( ( 'as' EQ (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:705:3: ( 'as' EQ (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:705:3: ( 'as' EQ (temp= identifier ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:705:4: 'as' EQ (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,75,FOLLOW_75_in_tcs_asparg3820); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_asparg3824); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:705:95: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:705:97: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_asparg3832);
            temp=identifier();

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
    // $ANTLR end "tcs_asparg"


    // $ANTLR start "tcs_referstokeyparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:713:1: tcs_referstokeyparg returns [Object ret2] : ( 'refersToKey' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_referstokeyparg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","RefersToKeyPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:718:3: ( ( 'refersToKey' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:719:3: ( 'refersToKey' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:719:3: ( 'refersToKey' EQ ( ( 'true' ) | ( 'false' ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:719:4: 'refersToKey' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,59,FOLLOW_59_in_tcs_referstokeyparg3875); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_referstokeyparg3879); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:719:105: ( ( 'true' ) | ( 'false' ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==50) ) {
                alt62=1;
            }
            else if ( (LA62_0==69) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:719:106: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:719:122: ( 'true' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:719:123: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,50,FOLLOW_50_in_tcs_referstokeyparg3889); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:719:232: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:719:248: ( 'false' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:719:249: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,69,FOLLOW_69_in_tcs_referstokeyparg3902); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_referstokeyparg"


    // $ANTLR start "tcs_separatorparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:728:1: tcs_separatorparg returns [Object ret2] : ( 'separator' EQ (temp= tcs_sequence ) ) ;
    public final Object tcs_separatorparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SeparatorPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:733:3: ( ( 'separator' EQ (temp= tcs_sequence ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:734:3: ( 'separator' EQ (temp= tcs_sequence ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:734:3: ( 'separator' EQ (temp= tcs_sequence ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:734:4: 'separator' EQ (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,85,FOLLOW_85_in_tcs_separatorparg3949); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_separatorparg3953); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:734:102: (temp= tcs_sequence )
            // ./scenariotestTemp/generated2/TCSObsolete.g:734:104: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_separatorparg3961);
            temp=tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "separatorSequence", temp);
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
    // $ANTLR end "tcs_separatorparg"


    // $ANTLR start "tcs_autocreateparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:742:1: tcs_autocreateparg returns [Object ret2] : ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) ;
    public final Object tcs_autocreateparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AutoCreatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:747:3: ( ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:748:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:748:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:748:4: 'autoCreate' EQ (temp= tcs_autocreatekind )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,111,FOLLOW_111_in_tcs_autocreateparg4004); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_autocreateparg4008); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:748:103: (temp= tcs_autocreatekind )
            // ./scenariotestTemp/generated2/TCSObsolete.g:748:105: temp= tcs_autocreatekind
            {
            pushFollow(FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg4016);
            temp=tcs_autocreatekind();

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
    // $ANTLR end "tcs_autocreateparg"


    // $ANTLR start "tcs_autocreatekind"
    // ./scenariotestTemp/generated2/TCSObsolete.g:756:1: tcs_autocreatekind returns [Object ret2] : ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) ;
    public final Object tcs_autocreatekind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:757:3: ( ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:758:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:758:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            int alt63=3;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt63=1;
                }
                break;
            case 57:
                {
                alt63=2;
                }
                break;
            case 74:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:758:4: ( 'always' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:758:4: ( 'always' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:758:5: 'always'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,49,FOLLOW_49_in_tcs_autocreatekind4060); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:759:4: ( 'ifmissing' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:759:4: ( 'ifmissing' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:759:5: 'ifmissing'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,57,FOLLOW_57_in_tcs_autocreatekind4070); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:760:4: ( 'never' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:760:4: ( 'never' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:760:5: 'never'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,74,FOLLOW_74_in_tcs_autocreatekind4080); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");
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
    // $ANTLR end "tcs_autocreatekind"


    // $ANTLR start "tcs_importcontextparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:767:1: tcs_importcontextparg returns [Object ret2] : ( 'importContext' ) ;
    public final Object tcs_importcontextparg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","ImportContextPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:772:3: ( ( 'importContext' ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:773:3: ( 'importContext' )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:773:3: ( 'importContext' )
            // ./scenariotestTemp/generated2/TCSObsolete.g:773:4: 'importContext'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,73,FOLLOW_73_in_tcs_importcontextparg4111); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_importcontextparg"


    // $ANTLR start "tcs_forcedlowerparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:781:1: tcs_forcedlowerparg returns [Object ret2] : ( 'forcedLower' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedlowerparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedLowerPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:786:3: ( ( 'forcedLower' EQ (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:787:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:787:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:787:4: 'forcedLower' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,116,FOLLOW_116_in_tcs_forcedlowerparg4151); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedlowerparg4155); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:787:104: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:787:106: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedlowerparg4163);
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
    // $ANTLR end "tcs_forcedlowerparg"


    // $ANTLR start "tcs_createasparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:795:1: tcs_createasparg returns [Object ret2] : ( 'createAs' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_createasparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateAsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:800:3: ( ( 'createAs' EQ (temp= identifierOrKeyword ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:801:3: ( 'createAs' EQ (temp= identifierOrKeyword ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:801:3: ( 'createAs' EQ (temp= identifierOrKeyword ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:801:4: 'createAs' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,82,FOLLOW_82_in_tcs_createasparg4206); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createasparg4210); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:801:101: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:801:103: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg4218);
            temp=identifierOrKeyword();

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
    // $ANTLR end "tcs_createasparg"


    // $ANTLR start "tcs_modeparg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:809:1: tcs_modeparg returns [Object ret2] : ( 'mode' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_modeparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ModePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:814:3: ( ( 'mode' EQ (temp= identifierOrKeyword ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:815:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:815:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:815:4: 'mode' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,66,FOLLOW_66_in_tcs_modeparg4261); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_modeparg4265); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:815:97: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:815:99: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_modeparg4273);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "mode", temp);
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
    // $ANTLR end "tcs_modeparg"


    // $ANTLR start "tcs_blockarg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:823:1: tcs_blockarg returns [Object ret2] : (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) ;
    public final Object tcs_blockarg() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:824:3: ( (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:825:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:825:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            int alt64=5;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt64=1;
                }
                break;
            case 64:
                {
                alt64=2;
                }
                break;
            case 63:
                {
                alt64=3;
                }
                break;
            case 89:
                {
                alt64=4;
                }
                break;
            case 109:
                {
                alt64=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:825:4: ret= tcs_nbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_nbnlbarg_in_tcs_blockarg4313);
                    ret=tcs_nbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:826:5: ret= tcs_indentincrbarg
                    {
                    pushFollow(FOLLOW_tcs_indentincrbarg_in_tcs_blockarg4321);
                    ret=tcs_indentincrbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:827:5: ret= tcs_startnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnlbarg_in_tcs_blockarg4329);
                    ret=tcs_startnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:828:5: ret= tcs_startnbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg4337);
                    ret=tcs_startnbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:829:5: ret= tcs_endnlbarg
                    {
                    pushFollow(FOLLOW_tcs_endnlbarg_in_tcs_blockarg4345);
                    ret=tcs_endnlbarg();

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
    // $ANTLR end "tcs_blockarg"


    // $ANTLR start "tcs_nbnlbarg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:836:1: tcs_nbnlbarg returns [Object ret2] : ( 'nbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_nbnlbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:841:3: ( ( 'nbNL' EQ (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:842:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:842:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:842:4: 'nbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,99,FOLLOW_99_in_tcs_nbnlbarg4375); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_nbnlbarg4379); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:842:97: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:842:99: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_nbnlbarg4387);
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
    // $ANTLR end "tcs_nbnlbarg"


    // $ANTLR start "tcs_indentincrbarg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:850:1: tcs_indentincrbarg returns [Object ret2] : ( 'indentIncr' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_indentincrbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IndentIncrBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:855:3: ( ( 'indentIncr' EQ (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:856:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:856:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:856:4: 'indentIncr' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,64,FOLLOW_64_in_tcs_indentincrbarg4430); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_indentincrbarg4434); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:856:103: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:856:105: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_indentincrbarg4442);
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
    // $ANTLR end "tcs_indentincrbarg"


    // $ANTLR start "tcs_startnlbarg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:864:1: tcs_startnlbarg returns [Object ret2] : ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_startnlbarg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","StartNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:869:3: ( ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:870:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:870:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:870:4: 'startNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,63,FOLLOW_63_in_tcs_startnlbarg4485); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnlbarg4489); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:870:101: ( ( 'true' ) | ( 'false' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==50) ) {
                alt65=1;
            }
            else if ( (LA65_0==69) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:870:102: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:870:118: ( 'true' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:870:119: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,50,FOLLOW_50_in_tcs_startnlbarg4499); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:870:228: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:870:244: ( 'false' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:870:245: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,69,FOLLOW_69_in_tcs_startnlbarg4512); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_startnlbarg"


    // $ANTLR start "tcs_startnbnlbarg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:879:1: tcs_startnbnlbarg returns [Object ret2] : ( 'startNbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_startnbnlbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StartNbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:884:3: ( ( 'startNbNL' EQ (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:885:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:885:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:885:4: 'startNbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,89,FOLLOW_89_in_tcs_startnbnlbarg4559); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnbnlbarg4563); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:885:102: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:885:104: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_startnbnlbarg4571);
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
    // $ANTLR end "tcs_startnbnlbarg"


    // $ANTLR start "tcs_endnlbarg"
    // ./scenariotestTemp/generated2/TCSObsolete.g:893:1: tcs_endnlbarg returns [Object ret2] : ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_endnlbarg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","EndNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:898:3: ( ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:899:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:899:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:899:4: 'endNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,109,FOLLOW_109_in_tcs_endnlbarg4614); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endnlbarg4618); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:899:99: ( ( 'true' ) | ( 'false' ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==50) ) {
                alt66=1;
            }
            else if ( (LA66_0==69) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:899:100: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:899:116: ( 'true' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:899:117: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,50,FOLLOW_50_in_tcs_endnlbarg4628); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:899:226: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:899:242: ( 'false' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:899:243: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,69,FOLLOW_69_in_tcs_endnlbarg4641); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_endnlbarg"


    // $ANTLR start "tcs_symbol"
    // ./scenariotestTemp/generated2/TCSObsolete.g:908:1: tcs_symbol returns [Object ret2] : ( (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) ;
    public final Object tcs_symbol() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Symbol");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:913:3: ( ( (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:914:3: ( (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:914:3: ( (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            // ./scenariotestTemp/generated2/TCSObsolete.g:914:4: (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:914:21: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:914:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_symbol4692);
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
            match(input,EQ,FOLLOW_EQ_in_tcs_symbol4699); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:914:143: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:914:145: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_symbol4707);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:914:232: ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==COLON) ) {
                alt69=1;
            }
            else if ( (LA69_0==SEMI) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:914:233: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:914:249: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:914:250: COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_symbol4720); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:914:307: (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==48||LA68_0==55||LA68_0==60||LA68_0==100) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:914:309: temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )*
                            {
                            pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol4728);
                            temp=tcs_spacekind();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "spaces", temp);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:914:364: ( ( COMA ) temp= tcs_spacekind )*
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( (LA67_0==COMA) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:914:365: ( COMA ) temp= tcs_spacekind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:914:382: ( COMA )
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:914:383: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_symbol4737); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol4745);
                            	    temp=tcs_spacekind();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "spaces", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop67;
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
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:914:534: 
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
            match(input,SEMI,FOLLOW_SEMI_in_tcs_symbol4770); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_symbol"


    // $ANTLR start "tcs_spacekind"
    // ./scenariotestTemp/generated2/TCSObsolete.g:923:1: tcs_spacekind returns [Object ret2] : ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) ;
    public final Object tcs_spacekind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:924:3: ( ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:925:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:925:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            int alt70=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt70=1;
                }
                break;
            case 60:
                {
                alt70=2;
                }
                break;
            case 100:
                {
                alt70=3;
                }
                break;
            case 55:
                {
                alt70=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:925:4: ( 'leftSpace' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:925:4: ( 'leftSpace' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:925:5: 'leftSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,48,FOLLOW_48_in_tcs_spacekind4812); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:926:4: ( 'leftNone' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:926:4: ( 'leftNone' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:926:5: 'leftNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,60,FOLLOW_60_in_tcs_spacekind4822); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:927:4: ( 'rightSpace' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:927:4: ( 'rightSpace' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:927:5: 'rightSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,100,FOLLOW_100_in_tcs_spacekind4832); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");
                    }

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:928:4: ( 'rightNone' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:928:4: ( 'rightNone' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:928:5: 'rightNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,55,FOLLOW_55_in_tcs_spacekind4842); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");
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
    // $ANTLR end "tcs_spacekind"


    // $ANTLR start "tcs_keyword"
    // ./scenariotestTemp/generated2/TCSObsolete.g:935:1: tcs_keyword returns [Object ret2] : ( (temp= identifier ) EQ (temp= stringSymbol ) SEMI ) ;
    public final Object tcs_keyword() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Keyword");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:940:3: ( ( (temp= identifier ) EQ (temp= stringSymbol ) SEMI ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:941:3: ( (temp= identifier ) EQ (temp= stringSymbol ) SEMI )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:941:3: ( (temp= identifier ) EQ (temp= stringSymbol ) SEMI )
            // ./scenariotestTemp/generated2/TCSObsolete.g:941:4: (temp= identifier ) EQ (temp= stringSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:941:21: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:941:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_keyword4877);
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
            match(input,EQ,FOLLOW_EQ_in_tcs_keyword4884); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:941:143: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:941:145: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_keyword4892);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_keyword4899); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_keyword"


    // $ANTLR start "tcs_operatorlist"
    // ./scenariotestTemp/generated2/TCSObsolete.g:949:1: tcs_operatorlist returns [Object ret2] : ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) ;
    public final Object tcs_operatorlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:954:3: ( ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:955:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:955:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/TCSObsolete.g:955:4: 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,96,FOLLOW_96_in_tcs_operatorlist4940); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:955:66: ( ( (temp= identifier ) ) | )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==NAME) ) {
                alt71=1;
            }
            else if ( (LA71_0==LCURLY) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:955:67: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:955:83: ( (temp= identifier ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:955:84: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:955:101: (temp= identifier )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:955:103: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatorlist4953);
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
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:955:187: 
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
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_operatorlist4973); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:956:75: ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:956:76: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:956:76: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            // ./scenariotestTemp/generated2/TCSObsolete.g:956:77: (temp= tcs_priority (temp= tcs_priority )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:956:94: (temp= tcs_priority (temp= tcs_priority )* )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==110) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:956:96: temp= tcs_priority (temp= tcs_priority )*
                    {
                    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist4984);
                    temp=tcs_priority();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "priorities", temp);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:956:154: (temp= tcs_priority )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==110) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:956:156: temp= tcs_priority
                    	    {
                    	    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist4992);
                    	    temp=tcs_priority();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "priorities", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop72;
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
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_operatorlist5007); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_operatorlist"


    // $ANTLR start "tcs_priority"
    // ./scenariotestTemp/generated2/TCSObsolete.g:964:1: tcs_priority returns [Object ret2] : ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) ;
    public final Object tcs_priority() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Priority");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:969:3: ( ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:970:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:970:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            // ./scenariotestTemp/generated2/TCSObsolete.g:970:4: 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,110,FOLLOW_110_in_tcs_priority5048); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:970:64: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:970:66: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_priority5055);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:970:154: ( () | ( COMA (temp= tcs_associativity ) ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==LCURLY) ) {
                alt74=1;
            }
            else if ( (LA74_0==COMA) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:970:155: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:970:171: ()
                    // ./scenariotestTemp/generated2/TCSObsolete.g:970:172: 
                    {
                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:970:281: ( COMA (temp= tcs_associativity ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:970:297: ( COMA (temp= tcs_associativity ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:970:298: COMA (temp= tcs_associativity )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_priority5078); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:970:354: (temp= tcs_associativity )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:970:356: temp= tcs_associativity
                    {
                    pushFollow(FOLLOW_tcs_associativity_in_tcs_priority5086);
                    temp=tcs_associativity();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "associativity", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));
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
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_priority5100); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:971:75: ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:971:76: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:971:76: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            // ./scenariotestTemp/generated2/TCSObsolete.g:971:77: (temp= tcs_operator (temp= tcs_operator )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:971:94: (temp= tcs_operator (temp= tcs_operator )* )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==NAME||LA76_0==61) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:971:96: temp= tcs_operator (temp= tcs_operator )*
                    {
                    pushFollow(FOLLOW_tcs_operator_in_tcs_priority5111);
                    temp=tcs_operator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operators", temp);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:971:153: (temp= tcs_operator )*
                    loop75:
                    do {
                        int alt75=2;
                        int LA75_0 = input.LA(1);

                        if ( (LA75_0==NAME||LA75_0==61) ) {
                            alt75=1;
                        }


                        switch (alt75) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:971:155: temp= tcs_operator
                    	    {
                    	    pushFollow(FOLLOW_tcs_operator_in_tcs_priority5119);
                    	    temp=tcs_operator();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "operators", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop75;
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
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_priority5134); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_priority"


    // $ANTLR start "tcs_operator"
    // ./scenariotestTemp/generated2/TCSObsolete.g:979:1: tcs_operator returns [Object ret2] : ( ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) ;
    public final Object tcs_operator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Operator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:984:3: ( ( ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:985:3: ( ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:985:3: ( ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            // ./scenariotestTemp/generated2/TCSObsolete.g:985:4: ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:985:22: ( ( 'postfix' ) | )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==61) ) {
                alt77=1;
            }
            else if ( (LA77_0==NAME) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:985:23: ( 'postfix' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:985:39: ( 'postfix' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:985:40: 'postfix'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,61,FOLLOW_61_in_tcs_operator5181); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:985:156: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:986:34: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:986:36: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_operator5203);
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
            match(input,EQ,FOLLOW_EQ_in_tcs_operator5210); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:986:157: ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=NAME && LA79_0<=STRING)) ) {
                alt79=1;
            }
            else if ( (LA79_0==COMA) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:986:158: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:986:174: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:986:175: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:986:192: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==NAME) ) {
                        alt78=1;
                    }
                    else if ( (LA78_0==STRING) ) {
                        alt78=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 78, 0, input);

                        throw nvae;
                    }
                    switch (alt78) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:986:193: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:986:209: ( (temp= identifier ) )
                            // ./scenariotestTemp/generated2/TCSObsolete.g:986:210: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:986:227: (temp= identifier )
                            // ./scenariotestTemp/generated2/TCSObsolete.g:986:229: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_operator5229);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);
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
                            // ./scenariotestTemp/generated2/TCSObsolete.g:987:4: ( (temp= stringSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:987:20: ( (temp= stringSymbol ) )
                            // ./scenariotestTemp/generated2/TCSObsolete.g:987:21: (temp= stringSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:987:38: (temp= stringSymbol )
                            // ./scenariotestTemp/generated2/TCSObsolete.g:987:40: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_operator5249);
                            temp=stringSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:987:245: 
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
            match(input,COMA,FOLLOW_COMA_in_tcs_operator5274); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:988:73: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:988:75: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_operator5282);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "arity", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_operator5289); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_operator"


    // $ANTLR start "tcs_associativity"
    // ./scenariotestTemp/generated2/TCSObsolete.g:996:1: tcs_associativity returns [Object ret2] : ( ( 'left' ) | ( 'right' ) ) ;
    public final Object tcs_associativity() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:997:3: ( ( ( 'left' ) | ( 'right' ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:998:3: ( ( 'left' ) | ( 'right' ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:998:3: ( ( 'left' ) | ( 'right' ) )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==95) ) {
                alt80=1;
            }
            else if ( (LA80_0==105) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:998:4: ( 'left' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:998:4: ( 'left' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:998:5: 'left'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,95,FOLLOW_95_in_tcs_associativity5331); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","Associativity"), "left");
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:999:4: ( 'right' )
                    {
                    // ./scenariotestTemp/generated2/TCSObsolete.g:999:4: ( 'right' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:999:5: 'right'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,105,FOLLOW_105_in_tcs_associativity5341); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("TCS","Associativity"), "right");
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
    // $ANTLR end "tcs_associativity"


    // $ANTLR start "tcs_expression"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1006:1: tcs_expression returns [Object ret2] : (ret= tcs_andexp ) ;
    public final Object tcs_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1007:3: ( (ret= tcs_andexp ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1008:3: (ret= tcs_andexp )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1008:3: (ret= tcs_andexp )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1008:4: ret= tcs_andexp
            {
            pushFollow(FOLLOW_tcs_andexp_in_tcs_expression5369);
            ret=tcs_andexp();

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
    // $ANTLR end "tcs_expression"


    // $ANTLR start "tcs_andexp"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1015:1: tcs_andexp returns [Object ret2] : ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) ;
    public final Object tcs_andexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AndExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1020:3: ( ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1021:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1021:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1021:4: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1021:21: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RARROW||(LA82_0>=102 && LA82_0<=103)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1021:23: temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )*
                    {
                    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp5403);
                    temp=tcs_atomexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "expressions", temp);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1021:81: ( ( 'and' ) temp= tcs_atomexp )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==93) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:1021:82: ( 'and' ) temp= tcs_atomexp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:1021:99: ( 'and' )
                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:1021:100: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,93,FOLLOW_93_in_tcs_andexp5411); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp5418);
                    	    temp=tcs_atomexp();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "expressions", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop81;
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
    // $ANTLR end "tcs_andexp"


    // $ANTLR start "tcs_atomexp"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1029:1: tcs_atomexp returns [Object ret2] : (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp ) ;
    public final Object tcs_atomexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1030:3: ( (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1031:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1031:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp )
            int alt83=4;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1031:4: ret= tcs_equalsexp
                    {
                    pushFollow(FOLLOW_tcs_equalsexp_in_tcs_atomexp5463);
                    ret=tcs_equalsexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1032:5: ret= tcs_booleanpropertyexp
                    {
                    pushFollow(FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp5471);
                    ret=tcs_booleanpropertyexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1033:5: ret= tcs_isdefinedexp
                    {
                    pushFollow(FOLLOW_tcs_isdefinedexp_in_tcs_atomexp5479);
                    ret=tcs_isdefinedexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1034:5: ret= tcs_oneexp
                    {
                    pushFollow(FOLLOW_tcs_oneexp_in_tcs_atomexp5487);
                    ret=tcs_oneexp();

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
    // $ANTLR end "tcs_atomexp"


    // $ANTLR start "tcs_equalsexp"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1041:1: tcs_equalsexp returns [Object ret2] : ( RARROW (temp= identifierOrKeyword ) EQ (temp= tcs_value ) ) ;
    public final Object tcs_equalsexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EqualsExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1046:3: ( ( RARROW (temp= identifierOrKeyword ) EQ (temp= tcs_value ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1047:3: ( RARROW (temp= identifierOrKeyword ) EQ (temp= tcs_value ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1047:3: ( RARROW (temp= identifierOrKeyword ) EQ (temp= tcs_value ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1047:4: RARROW (temp= identifierOrKeyword ) EQ (temp= tcs_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_equalsexp5518); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1047:62: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1047:64: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_equalsexp5526);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_equalsexp5533); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1047:201: (temp= tcs_value )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1047:203: temp= tcs_value
            {
            pushFollow(FOLLOW_tcs_value_in_tcs_equalsexp5541);
            temp=tcs_value();

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
    // $ANTLR end "tcs_equalsexp"


    // $ANTLR start "tcs_booleanpropertyexp"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1055:1: tcs_booleanpropertyexp returns [Object ret2] : ( RARROW (temp= identifierOrKeyword ) ) ;
    public final Object tcs_booleanpropertyexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","BooleanPropertyExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1060:3: ( ( RARROW (temp= identifierOrKeyword ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1061:3: ( RARROW (temp= identifierOrKeyword ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1061:3: ( RARROW (temp= identifierOrKeyword ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1061:4: RARROW (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_booleanpropertyexp5585); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1061:62: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1061:64: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_booleanpropertyexp5593);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
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
    // $ANTLR end "tcs_booleanpropertyexp"


    // $ANTLR start "tcs_isdefinedexp"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1069:1: tcs_isdefinedexp returns [Object ret2] : ( 'isDefined' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN ) ;
    public final Object tcs_isdefinedexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IsDefinedExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1074:3: ( ( 'isDefined' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1075:3: ( 'isDefined' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1075:3: ( 'isDefined' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1075:4: 'isDefined' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,103,FOLLOW_103_in_tcs_isdefinedexp5636); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_isdefinedexp5640); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_isdefinedexp5645); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1075:147: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1075:149: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_isdefinedexp5653);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_isdefinedexp5660); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_isdefinedexp"


    // $ANTLR start "tcs_oneexp"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1083:1: tcs_oneexp returns [Object ret2] : ( 'one' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN ) ;
    public final Object tcs_oneexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OneExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1088:3: ( ( 'one' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1089:3: ( 'one' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1089:3: ( 'one' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1089:4: 'one' LPAREN RARROW (temp= identifierOrKeyword ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,102,FOLLOW_102_in_tcs_oneexp5701); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_oneexp5705); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_oneexp5710); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1089:141: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1089:143: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_oneexp5718);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_oneexp5725); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_oneexp"


    // $ANTLR start "tcs_value"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1097:1: tcs_value returns [Object ret2] : (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) ;
    public final Object tcs_value() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1098:3: ( (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1099:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1099:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            int alt84=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt84=1;
                }
                break;
            case INT:
                {
                alt84=2;
                }
                break;
            case MINUS:
                {
                alt84=3;
                }
                break;
            case SHARP:
                {
                alt84=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1099:4: ret= tcs_stringval
                    {
                    pushFollow(FOLLOW_tcs_stringval_in_tcs_value5763);
                    ret=tcs_stringval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1100:5: ret= tcs_integerval
                    {
                    pushFollow(FOLLOW_tcs_integerval_in_tcs_value5771);
                    ret=tcs_integerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1101:5: ret= tcs_negativeintegerval
                    {
                    pushFollow(FOLLOW_tcs_negativeintegerval_in_tcs_value5779);
                    ret=tcs_negativeintegerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1102:5: ret= tcs_enumliteralval
                    {
                    pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_value5787);
                    ret=tcs_enumliteralval();

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
    // $ANTLR end "tcs_value"


    // $ANTLR start "tcs_stringval"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1109:1: tcs_stringval returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_stringval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1114:3: ( ( (temp= stringSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1115:3: ( (temp= stringSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1115:3: ( (temp= stringSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1115:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1115:21: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1115:23: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_stringval5821);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "symbol", temp);
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
    // $ANTLR end "tcs_stringval"


    // $ANTLR start "tcs_integerval"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1123:1: tcs_integerval returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object tcs_integerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1128:3: ( ( (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1129:3: ( (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1129:3: ( (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1129:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1129:21: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1129:23: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_integerval5868);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "symbol", temp);
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
    // $ANTLR end "tcs_integerval"


    // $ANTLR start "tcs_negativeintegerval"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1137:1: tcs_negativeintegerval returns [Object ret2] : ( MINUS (temp= integerSymbol ) ) ;
    public final Object tcs_negativeintegerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NegativeIntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1142:3: ( ( MINUS (temp= integerSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1143:3: ( MINUS (temp= integerSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1143:3: ( MINUS (temp= integerSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1143:4: MINUS (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,MINUS,FOLLOW_MINUS_in_tcs_negativeintegerval5912); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1143:61: (temp= integerSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1143:63: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_negativeintegerval5920);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "symbol", temp);
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
    // $ANTLR end "tcs_negativeintegerval"


    // $ANTLR start "tcs_enumliteralval"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1151:1: tcs_enumliteralval returns [Object ret2] : ( SHARP (temp= identifierOrKeyword ) ) ;
    public final Object tcs_enumliteralval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1156:3: ( ( SHARP (temp= identifierOrKeyword ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1157:3: ( SHARP (temp= identifierOrKeyword ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1157:3: ( SHARP (temp= identifierOrKeyword ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1157:4: SHARP (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,SHARP,FOLLOW_SHARP_in_tcs_enumliteralval5964); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1157:61: (temp= identifierOrKeyword )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1157:63: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_enumliteralval5972);
            temp=identifierOrKeyword();

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
    // $ANTLR end "tcs_enumliteralval"


    // $ANTLR start "tcs_token"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1165:1: tcs_token returns [Object ret2] : ( 'token' (temp= identifier ) COLON (temp= tcs_orpattern ) SEMI ) ;
    public final Object tcs_token() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Token");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1170:3: ( ( 'token' (temp= identifier ) COLON (temp= tcs_orpattern ) SEMI ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1171:3: ( 'token' (temp= identifier ) COLON (temp= tcs_orpattern ) SEMI )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1171:3: ( 'token' (temp= identifier ) COLON (temp= tcs_orpattern ) SEMI )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1171:4: 'token' (temp= identifier ) COLON (temp= tcs_orpattern ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,88,FOLLOW_88_in_tcs_token6015); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1171:61: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1171:63: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_token6022);
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
            match(input,COLON,FOLLOW_COLON_in_tcs_token6029); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1171:186: (temp= tcs_orpattern )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1171:188: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_token6037);
            temp=tcs_orpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "pattern", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_token6044); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_token"


    // $ANTLR start "tcs_orpattern"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1179:1: tcs_orpattern returns [Object ret2] : ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* ) ) ;
    public final Object tcs_orpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OrPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1184:3: ( ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1185:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1185:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1185:4: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1185:21: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1185:23: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
            {
            pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern6089);
            temp=tcs_simplepattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "simplePatterns", temp);
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1185:90: ( ( PIPE ) temp= tcs_simplepattern )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==PIPE) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:1185:91: ( PIPE ) temp= tcs_simplepattern
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:1185:108: ( PIPE )
            	    // ./scenariotestTemp/generated2/TCSObsolete.g:1185:109: PIPE
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PIPE,FOLLOW_PIPE_in_tcs_orpattern6098); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern6106);
            	    temp=tcs_simplepattern();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "simplePatterns", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


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
    // $ANTLR end "tcs_orpattern"


    // $ANTLR start "tcs_simplepattern"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1193:1: tcs_simplepattern returns [Object ret2] : (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) ;
    public final Object tcs_simplepattern() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1194:3: ( (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1195:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1195:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            int alt86=3;
            switch ( input.LA(1) ) {
            case 68:
            case 79:
            case 90:
                {
                alt86=1;
                }
                break;
            case STRING:
                {
                alt86=2;
                }
                break;
            case LSQUARE:
                {
                alt86=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1195:4: ret= tcs_rulepattern
                    {
                    pushFollow(FOLLOW_tcs_rulepattern_in_tcs_simplepattern6149);
                    ret=tcs_rulepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1196:5: ret= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_simplepattern6157);
                    ret=tcs_stringpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1197:5: ret= tcs_classpattern
                    {
                    pushFollow(FOLLOW_tcs_classpattern_in_tcs_simplepattern6165);
                    ret=tcs_classpattern();

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
    // $ANTLR end "tcs_simplepattern"


    // $ANTLR start "tcs_rulepattern"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1204:1: tcs_rulepattern returns [Object ret2] : ( (temp= tcs_rule ) ) ;
    public final Object tcs_rulepattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RulePattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1209:3: ( ( (temp= tcs_rule ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1210:3: ( (temp= tcs_rule ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1210:3: ( (temp= tcs_rule ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1210:4: (temp= tcs_rule )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1210:21: (temp= tcs_rule )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1210:23: temp= tcs_rule
            {
            pushFollow(FOLLOW_tcs_rule_in_tcs_rulepattern6199);
            temp=tcs_rule();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "rule", temp);
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
    // $ANTLR end "tcs_rulepattern"


    // $ANTLR start "tcs_rule"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1218:1: tcs_rule returns [Object ret2] : (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) ;
    public final Object tcs_rule() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1219:3: ( (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1220:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1220:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            int alt87=3;
            switch ( input.LA(1) ) {
            case 79:
                {
                alt87=1;
                }
                break;
            case 90:
                {
                alt87=2;
                }
                break;
            case 68:
                {
                alt87=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1220:4: ret= tcs_wordrule
                    {
                    pushFollow(FOLLOW_tcs_wordrule_in_tcs_rule6239);
                    ret=tcs_wordrule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1221:5: ret= tcs_endoflinerule
                    {
                    pushFollow(FOLLOW_tcs_endoflinerule_in_tcs_rule6247);
                    ret=tcs_endoflinerule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1222:5: ret= tcs_multilinerule
                    {
                    pushFollow(FOLLOW_tcs_multilinerule_in_tcs_rule6255);
                    ret=tcs_multilinerule();

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
    // $ANTLR end "tcs_rule"


    // $ANTLR start "tcs_wordrule"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1229:1: tcs_wordrule returns [Object ret2] : ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) ( ( COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN ) | ) RPAREN ) ;
    public final Object tcs_wordrule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","WordRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1234:3: ( ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) ( ( COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN ) | ) RPAREN ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1235:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) ( ( COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN ) | ) RPAREN )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1235:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) ( ( COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN ) | ) RPAREN )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1235:4: 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) ( ( COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,79,FOLLOW_79_in_tcs_wordrule6285); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_wordrule6289); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,114,FOLLOW_114_in_tcs_wordrule6293); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule6297); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1235:178: (temp= tcs_orpattern )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1235:180: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule6305);
            temp=tcs_orpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "start", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_wordrule6312); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,62,FOLLOW_62_in_tcs_wordrule6316); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule6320); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1235:382: (temp= tcs_orpattern )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1235:384: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule6328);
            temp=tcs_orpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "part", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1235:471: ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==COMA) ) {
                int LA88_1 = input.LA(2);

                if ( (LA88_1==70) ) {
                    alt88=2;
                }
                else if ( (LA88_1==52) ) {
                    alt88=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA88_0==RPAREN) ) {
                alt88=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1235:472: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1235:488: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1235:489: COMA 'end' EQ (temp= tcs_orpattern )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_wordrule6341); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,52,FOLLOW_52_in_tcs_wordrule6345); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_wordrule6349); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1235:620: (temp= tcs_orpattern )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1235:622: temp= tcs_orpattern
                    {
                    pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule6357);
                    temp=tcs_orpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "end", temp);
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1235:708: 
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:1236:35: ( ( COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN ) | )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==COMA) ) {
                alt91=1;
            }
            else if ( (LA91_0==RPAREN) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1236:36: ( COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1236:52: ( COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1236:53: COMA 'words' EQ LPAREN (temp= tcs_word ( ( COMA ) temp= tcs_word )* )? RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_wordrule6383); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,70,FOLLOW_70_in_tcs_wordrule6387); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_wordrule6391); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_wordrule6396); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1236:227: (temp= tcs_word ( ( COMA ) temp= tcs_word )* )?
                    int alt90=2;
                    int LA90_0 = input.LA(1);

                    if ( (LA90_0==STRING) ) {
                        alt90=1;
                    }
                    switch (alt90) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:1236:229: temp= tcs_word ( ( COMA ) temp= tcs_word )*
                            {
                            pushFollow(FOLLOW_tcs_word_in_tcs_wordrule6404);
                            temp=tcs_word();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "words", temp);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:1236:278: ( ( COMA ) temp= tcs_word )*
                            loop89:
                            do {
                                int alt89=2;
                                int LA89_0 = input.LA(1);

                                if ( (LA89_0==COMA) ) {
                                    alt89=1;
                                }


                                switch (alt89) {
                            	case 1 :
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:1236:279: ( COMA ) temp= tcs_word
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:1236:296: ( COMA )
                            	    // ./scenariotestTemp/generated2/TCSObsolete.g:1236:297: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl();
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_wordrule6413); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_word_in_tcs_wordrule6421);
                            	    temp=tcs_word();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "words", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop89;
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_wordrule6433); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1236:483: 
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
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_wordrule6451); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_wordrule"


    // $ANTLR start "tcs_word"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1245:1: tcs_word returns [Object ret2] : ( (temp= stringSymbol ) COLON (temp= identifier ) ) ;
    public final Object tcs_word() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Word");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1250:3: ( ( (temp= stringSymbol ) COLON (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1251:3: ( (temp= stringSymbol ) COLON (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1251:3: ( (temp= stringSymbol ) COLON (temp= identifier ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1251:4: (temp= stringSymbol ) COLON (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1251:21: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1251:23: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_word6496);
            temp=stringSymbol();

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
            match(input,COLON,FOLLOW_COLON_in_tcs_word6503); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1251:148: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1251:150: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_word6511);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "token", temp);
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
    // $ANTLR end "tcs_word"


    // $ANTLR start "tcs_endoflinerule"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1259:1: tcs_endoflinerule returns [Object ret2] : ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) ;
    public final Object tcs_endoflinerule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EndOfLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1264:3: ( ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1265:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1265:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1265:4: 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,90,FOLLOW_90_in_tcs_endoflinerule6554); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_endoflinerule6558); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,114,FOLLOW_114_in_tcs_endoflinerule6562); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endoflinerule6566); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1265:184: ( ( 'drop' ) | )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==113) ) {
                alt92=1;
            }
            else if ( (LA92_0==STRING) ) {
                alt92=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1265:185: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1265:201: ( 'drop' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1265:202: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,113,FOLLOW_113_in_tcs_endoflinerule6576); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "dropStart", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1265:315: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "dropStart", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:1266:34: (temp= tcs_stringpattern )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1266:36: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_endoflinerule6598);
            temp=tcs_stringpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "start", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_endoflinerule6605); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_endoflinerule"


    // $ANTLR start "tcs_multilinerule"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1274:1: tcs_multilinerule returns [Object ret2] : ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) ;
    public final Object tcs_multilinerule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","MultiLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1279:3: ( ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1280:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1280:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1280:4: 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,68,FOLLOW_68_in_tcs_multilinerule6646); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule6650); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,114,FOLLOW_114_in_tcs_multilinerule6654); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule6658); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1280:184: ( ( 'drop' ) | )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==113) ) {
                alt93=1;
            }
            else if ( (LA93_0==STRING) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1280:185: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1280:201: ( 'drop' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1280:202: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,113,FOLLOW_113_in_tcs_multilinerule6668); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "dropStart", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1280:315: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "dropStart", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:1281:34: (temp= tcs_stringpattern )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1281:36: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule6690);
            temp=tcs_stringpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "start", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule6697); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,52,FOLLOW_52_in_tcs_multilinerule6701); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule6705); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1281:242: ( ( 'drop' ) | )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==113) ) {
                alt94=1;
            }
            else if ( (LA94_0==STRING) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1281:243: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1281:259: ( 'drop' )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1281:260: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,113,FOLLOW_113_in_tcs_multilinerule6715); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1281:371: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);
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
            // ./scenariotestTemp/generated2/TCSObsolete.g:1282:34: (temp= tcs_stringpattern )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1282:36: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule6737);
            temp=tcs_stringpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "end", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1282:126: ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==COMA) ) {
                alt98=1;
            }
            else if ( (LA98_0==RPAREN) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:127: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:143: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:144: COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule6750); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,65,FOLLOW_65_in_tcs_multilinerule6754); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule6758); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:275: (temp= tcs_stringpattern )
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:277: temp= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule6766);
                    temp=tcs_stringpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "esc", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:367: ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==COMA) ) {
                        alt97=1;
                    }
                    else if ( (LA97_0==RPAREN) ) {
                        alt97=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 97, 0, input);

                        throw nvae;
                    }
                    switch (alt97) {
                        case 1 :
                            // ./scenariotestTemp/generated2/TCSObsolete.g:1282:368: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:1282:384: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            // ./scenariotestTemp/generated2/TCSObsolete.g:1282:385: COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule6779); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule6784); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl();
                            }
                            // ./scenariotestTemp/generated2/TCSObsolete.g:1282:482: (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )?
                            int alt96=2;
                            int LA96_0 = input.LA(1);

                            if ( (LA96_0==NAME||LA96_0==POINT||LA96_0==104||LA96_0==118) ) {
                                alt96=1;
                            }
                            switch (alt96) {
                                case 1 :
                                    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:484: temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )*
                                    {
                                    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule6792);
                                    temp=tcs_mapping();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "escMappings", temp);
                                    }
                                    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:542: ( ( COMA ) temp= tcs_mapping )*
                                    loop95:
                                    do {
                                        int alt95=2;
                                        int LA95_0 = input.LA(1);

                                        if ( (LA95_0==COMA) ) {
                                            alt95=1;
                                        }


                                        switch (alt95) {
                                    	case 1 :
                                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:543: ( COMA ) temp= tcs_mapping
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _enterSepSeq();
                                    	    }
                                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:560: ( COMA )
                                    	    // ./scenariotestTemp/generated2/TCSObsolete.g:1282:561: COMA
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _beforeSeqEl();
                                    	    }
                                    	    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule6801); if (state.failed) return ret2;
                                    	    if ( state.backtracking==0 ) {
                                    	      _afterSeqEl();
                                    	    }

                                    	    }

                                    	    if ( state.backtracking==0 ) {
                                    	      _exitSepSeq();
                                    	    }
                                    	    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule6809);
                                    	    temp=tcs_mapping();

                                    	    checkFollows();
                                    	    state._fsp--;
                                    	    if (state.failed) return ret2;
                                    	    if ( state.backtracking==0 ) {
                                    	      setProperty(ret, "escMappings", temp);
                                    	    }

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop95;
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
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule6821); if (state.failed) return ret2;
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
                            // ./scenariotestTemp/generated2/TCSObsolete.g:1282:756: 
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
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1283:35: 
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
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule6852); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_multilinerule"


    // $ANTLR start "tcs_mapping"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1292:1: tcs_mapping returns [Object ret2] : (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) ;
    public final Object tcs_mapping() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1293:3: ( (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1294:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1294:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            int alt99=4;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt99=1;
                }
                break;
            case POINT:
                {
                alt99=2;
                }
                break;
            case 118:
                {
                alt99=3;
                }
                break;
            case 104:
                {
                alt99=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1294:4: ret= tcs_simplemapping
                    {
                    pushFollow(FOLLOW_tcs_simplemapping_in_tcs_mapping6890);
                    ret=tcs_simplemapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1295:5: ret= tcs_wildcardmapping
                    {
                    pushFollow(FOLLOW_tcs_wildcardmapping_in_tcs_mapping6898);
                    ret=tcs_wildcardmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1296:5: ret= tcs_octalmapping
                    {
                    pushFollow(FOLLOW_tcs_octalmapping_in_tcs_mapping6906);
                    ret=tcs_octalmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/TCSObsolete.g:1297:5: ret= tcs_hexadecimalmapping
                    {
                    pushFollow(FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping6914);
                    ret=tcs_hexadecimalmapping();

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
    // $ANTLR end "tcs_mapping"


    // $ANTLR start "tcs_simplemapping"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1304:1: tcs_simplemapping returns [Object ret2] : ( (temp= identifier ) RARROW (temp= identifier ) ) ;
    public final Object tcs_simplemapping() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SimpleMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1309:3: ( ( (temp= identifier ) RARROW (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1310:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1310:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1310:4: (temp= identifier ) RARROW (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1310:21: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1310:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping6948);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "key", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_simplemapping6955); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1310:146: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1310:148: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping6963);
            temp=identifier();

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
    // $ANTLR end "tcs_simplemapping"


    // $ANTLR start "tcs_wildcardmapping"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1318:1: tcs_wildcardmapping returns [Object ret2] : ( POINT RARROW POINT ) ;
    public final Object tcs_wildcardmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","WildcardMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1323:3: ( ( POINT RARROW POINT ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1324:3: ( POINT RARROW POINT )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1324:3: ( POINT RARROW POINT )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1324:4: POINT RARROW POINT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping7007); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_wildcardmapping7012); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping7017); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_wildcardmapping"


    // $ANTLR start "tcs_octalmapping"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1332:1: tcs_octalmapping returns [Object ret2] : ( 'octal' ) ;
    public final Object tcs_octalmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","OctalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1337:3: ( ( 'octal' ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1338:3: ( 'octal' )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1338:3: ( 'octal' )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1338:4: 'octal'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,118,FOLLOW_118_in_tcs_octalmapping7058); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_octalmapping"


    // $ANTLR start "tcs_hexadecimalmapping"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1346:1: tcs_hexadecimalmapping returns [Object ret2] : ( 'hex' ) ;
    public final Object tcs_hexadecimalmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","HexadecimalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1351:3: ( ( 'hex' ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1352:3: ( 'hex' )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1352:3: ( 'hex' )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1352:4: 'hex'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,104,FOLLOW_104_in_tcs_hexadecimalmapping7098); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_hexadecimalmapping"


    // $ANTLR start "tcs_stringpattern"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1360:1: tcs_stringpattern returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_stringpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1365:3: ( ( (temp= stringSymbol ) ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1366:3: ( (temp= stringSymbol ) )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1366:3: ( (temp= stringSymbol ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1366:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1366:21: (temp= stringSymbol )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1366:23: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_stringpattern7142);
            temp=stringSymbol();

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
    // $ANTLR end "tcs_stringpattern"


    // $ANTLR start "tcs_classpattern"
    // ./scenariotestTemp/generated2/TCSObsolete.g:1374:1: tcs_classpattern returns [Object ret2] : ( LSQUARE (temp= identifier ) RSQUARE ) ;
    public final Object tcs_classpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1379:3: ( ( LSQUARE (temp= identifier ) RSQUARE ) )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1380:3: ( LSQUARE (temp= identifier ) RSQUARE )
            {
            // ./scenariotestTemp/generated2/TCSObsolete.g:1380:3: ( LSQUARE (temp= identifier ) RSQUARE )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1380:4: LSQUARE (temp= identifier ) RSQUARE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_classpattern7186); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/TCSObsolete.g:1380:63: (temp= identifier )
            // ./scenariotestTemp/generated2/TCSObsolete.g:1380:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_classpattern7194);
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
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_classpattern7201); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_classpattern"

    // Delegated rules


    protected DFA83 dfa83 = new DFA83(this);
    static final String DFA83_eotS =
        "\124\uffff";
    static final String DFA83_eofS =
        "\4\uffff\116\123\2\uffff";
    static final String DFA83_minS =
        "\1\16\1\4\2\uffff\116\11\2\uffff";
    static final String DFA83_maxS =
        "\1\147\1\174\2\uffff\116\135\2\uffff";
    static final String DFA83_acceptS =
        "\2\uffff\1\3\1\4\116\uffff\1\1\1\2";
    static final String DFA83_specialS =
        "\124\uffff}>";
    static final String[] DFA83_transitionS = {
            "\1\1\127\uffff\1\3\1\2",
            "\1\4\53\uffff\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
            "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
            "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
            "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62"+
            "\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76"+
            "\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110"+
            "\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121",
            "",
            "",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "\1\122\15\uffff\1\123\105\uffff\1\123",
            "",
            ""
    };

    static final short[] DFA83_eot = DFA.unpackEncodedString(DFA83_eotS);
    static final short[] DFA83_eof = DFA.unpackEncodedString(DFA83_eofS);
    static final char[] DFA83_min = DFA.unpackEncodedStringToUnsignedChars(DFA83_minS);
    static final char[] DFA83_max = DFA.unpackEncodedStringToUnsignedChars(DFA83_maxS);
    static final short[] DFA83_accept = DFA.unpackEncodedString(DFA83_acceptS);
    static final short[] DFA83_special = DFA.unpackEncodedString(DFA83_specialS);
    static final short[][] DFA83_transition;

    static {
        int numStates = DFA83_transitionS.length;
        DFA83_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA83_transition[i] = DFA.unpackEncodedString(DFA83_transitionS[i]);
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = DFA83_eot;
            this.eof = DFA83_eof;
            this.min = DFA83_min;
            this.max = DFA83_max;
            this.accept = DFA83_accept;
            this.special = DFA83_special;
            this.transition = DFA83_transition;
        }
        public String getDescription() {
            return "1031:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp )";
        }
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
    public static final BitSet FOLLOW_77_in_identifierOrKeyword340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_identifierOrKeyword348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_identifierOrKeyword356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_identifierOrKeyword364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_identifierOrKeyword372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_identifierOrKeyword380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_identifierOrKeyword388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_identifierOrKeyword396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_identifierOrKeyword404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_identifierOrKeyword412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_identifierOrKeyword420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_identifierOrKeyword428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_identifierOrKeyword436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_identifierOrKeyword444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_identifierOrKeyword452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_identifierOrKeyword460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_identifierOrKeyword468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_identifierOrKeyword476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_identifierOrKeyword484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_identifierOrKeyword492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_identifierOrKeyword500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_identifierOrKeyword508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_identifierOrKeyword516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_identifierOrKeyword524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_identifierOrKeyword532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_identifierOrKeyword540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_identifierOrKeyword548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_identifierOrKeyword556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_identifierOrKeyword564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_identifierOrKeyword572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_identifierOrKeyword580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_identifierOrKeyword588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_identifierOrKeyword596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_identifierOrKeyword604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_identifierOrKeyword612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_identifierOrKeyword620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_identifierOrKeyword628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_identifierOrKeyword636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_identifierOrKeyword644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_identifierOrKeyword652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_identifierOrKeyword660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_identifierOrKeyword668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_identifierOrKeyword676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_identifierOrKeyword684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_identifierOrKeyword692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_identifierOrKeyword700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_identifierOrKeyword708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_identifierOrKeyword716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_concretesyntax_in_main837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_tcs_concretesyntax871 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_concretesyntax878 = new BitSet(new long[]{0x0000000000000900L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_concretesyntax891 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_tcs_concretesyntax895 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax899 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_concretesyntax907 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_concretesyntax914 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax932 = new BitSet(new long[]{0x0400000000001000L,0x01000001018B5000L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax943 = new BitSet(new long[]{0x0400000000001000L,0x01000001018B5000L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax951 = new BitSet(new long[]{0x0400000000001000L,0x01000001018B5000L});
    public static final BitSet FOLLOW_83_in_tcs_concretesyntax968 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax972 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax983 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax991 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1006 = new BitSet(new long[]{0x0000000000001000L,0x0100000101800000L});
    public static final BitSet FOLLOW_120_in_tcs_concretesyntax1029 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1033 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1044 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1052 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1067 = new BitSet(new long[]{0x0000000000001000L,0x0000000101800000L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1088 = new BitSet(new long[]{0x0000000000001000L,0x0000000101800000L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1096 = new BitSet(new long[]{0x0000000000001000L,0x0000000101800000L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1111 = new BitSet(new long[]{0x0000000000001000L,0x0000000001800000L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1119 = new BitSet(new long[]{0x0000000000001000L,0x0000000001800000L});
    public static final BitSet FOLLOW_87_in_tcs_concretesyntax1136 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1140 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_concretesyntax1148 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_concretesyntax1155 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_primitivetemplate_in_tcs_template1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumerationtemplate_in_tcs_template1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classtemplate_in_tcs_template1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_operatortemplate_in_tcs_template1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functiontemplate_in_tcs_template1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_reference1271 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_reference1279 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_DLCOLON_in_reference1288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_reference1296 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_58_in_tcs_primitivetemplate1332 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1339 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_tcs_primitivetemplate1345 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_reference_in_tcs_primitivetemplate1348 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000100L});
    public static final BitSet FOLLOW_72_in_tcs_primitivetemplate1358 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_tcs_primitivetemplate1376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1383 = new BitSet(new long[]{0x0000000000010000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_tcs_primitivetemplate1395 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_primitivetemplate1414 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_tcs_primitivetemplate1418 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1422 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1430 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_primitivetemplate1443 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_tcs_primitivetemplate1447 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1451 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1459 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_primitivetemplate1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_tcs_enumerationtemplate1520 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_reference_in_tcs_enumerationtemplate1523 = new BitSet(new long[]{0x0000000000012000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_tcs_enumerationtemplate1533 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COLON_in_tcs_enumerationtemplate1561 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate1572 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_enumerationtemplate1581 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate1589 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate1604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping1672 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_enumliteralmapping1679 = new BitSet(new long[]{0x0000000045284120L});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_enumliteralmapping1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_tcs_classtemplate1730 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_reference_in_tcs_classtemplate1733 = new BitSet(new long[]{0x0100000000052100L,0x12A0040200100080L});
    public static final BitSet FOLLOW_SHARP_in_tcs_classtemplate1744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate1752 = new BitSet(new long[]{0x0100000000012100L,0x12A0040200100080L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate1778 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_tcs_classtemplate1782 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate1786 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate1794 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate1801 = new BitSet(new long[]{0x0100000000012000L,0x12A0040200100080L});
    public static final BitSet FOLLOW_121_in_tcs_classtemplate1824 = new BitSet(new long[]{0x0100000000012000L,0x10A0040200100080L});
    public static final BitSet FOLLOW_84_in_tcs_classtemplate1848 = new BitSet(new long[]{0x0100000000012000L,0x10A0040200000080L});
    public static final BitSet FOLLOW_117_in_tcs_classtemplate1878 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_tcs_classtemplate1896 = new BitSet(new long[]{0x0100000000012000L,0x1080040200000000L});
    public static final BitSet FOLLOW_119_in_tcs_classtemplate1920 = new BitSet(new long[]{0x0100000000012100L,0x1000040200000000L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate1930 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate1938 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate1945 = new BitSet(new long[]{0x0100000000012000L,0x1000040200000000L});
    public static final BitSet FOLLOW_56_in_tcs_classtemplate1983 = new BitSet(new long[]{0x0000000000012000L,0x1000040200000000L});
    public static final BitSet FOLLOW_124_in_tcs_classtemplate2007 = new BitSet(new long[]{0x0000000000012000L,0x0000040200000000L});
    public static final BitSet FOLLOW_106_in_tcs_classtemplate2031 = new BitSet(new long[]{0x0000000000012000L,0x0000000200000000L});
    public static final BitSet FOLLOW_97_in_tcs_classtemplate2055 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2062 = new BitSet(new long[]{0x0000000045296120L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2073 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2108 = new BitSet(new long[]{0x0000000045286120L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2119 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_tcs_operatortemplate2193 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_reference_in_tcs_operatortemplate2196 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_operatortemplate2201 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_tcs_operatortemplate2205 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2209 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2217 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2225 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2237 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_tcs_operatortemplate2241 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2245 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_operatortemplate2250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2258 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2271 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_tcs_operatortemplate2275 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2279 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_operatortemplate2284 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2292 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2318 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_tcs_operatortemplate2322 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2326 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_operatortemplate2331 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2339 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2365 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_tcs_operatortemplate2369 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2373 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate2381 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2407 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_tcs_operatortemplate2411 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2415 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate2423 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_operatortemplate2443 = new BitSet(new long[]{0x0100000000012000L});
    public static final BitSet FOLLOW_56_in_tcs_operatortemplate2453 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COLON_in_tcs_operatortemplate2481 = new BitSet(new long[]{0x0000000045286120L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_operatortemplate2492 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate2502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate2519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_tcs_functiontemplate2566 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functiontemplate2573 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_functiontemplate2580 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_reference_in_tcs_functiontemplate2584 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_functiontemplate2589 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_functiontemplate2597 = new BitSet(new long[]{0x0000000045286120L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_functiontemplate2608 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_functiontemplate2618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence2666 = new BitSet(new long[]{0x0000000045284122L});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence2674 = new BitSet(new long[]{0x0000000045284122L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_sequenceelement2719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_property_in_tcs_sequenceelement2727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_customseparator_in_tcs_sequenceelement2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_block_in_tcs_sequenceelement2743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement2751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyinit_in_tcs_sequenceelement2759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_alternative_in_tcs_sequenceelement2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functioncall_in_tcs_sequenceelement2775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_literalref2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_tcs_property2853 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_property2861 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_property2874 = new BitSet(new long[]{0x0800000000001000L,0x0018900000240A0CL});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property2882 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_COMA_in_tcs_property2891 = new BitSet(new long[]{0x0800000000000000L,0x0018900000240A0CL});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property2899 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_property2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_tcs_customseparator2966 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_customseparator2974 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_GT_in_tcs_customseparator2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_block3023 = new BitSet(new long[]{0x0000000045684120L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_block3031 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_block3038 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_block3049 = new BitSet(new long[]{0x8000000000001000L,0x0000200802000001L});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block3057 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_COMA_in_tcs_block3066 = new BitSet(new long[]{0x8000000000000000L,0x0000200802000001L});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block3074 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_block3086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_conditionalelement3141 = new BitSet(new long[]{0x0000000000004000L,0x000000C000000000L});
    public static final BitSet FOLLOW_tcs_expression_in_tcs_conditionalelement3149 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_QMARK_in_tcs_conditionalelement3156 = new BitSet(new long[]{0x0000000045294520L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement3164 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_COLON_in_tcs_conditionalelement3177 = new BitSet(new long[]{0x0000000045284520L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement3185 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_conditionalelement3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCURLY_in_tcs_propertyinit3247 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_propertyinit3252 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_propertyinit3260 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_propertyinit3267 = new BitSet(new long[]{0x0000000100040060L});
    public static final BitSet FOLLOW_tcs_value_in_tcs_propertyinit3275 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DRCURLY_in_tcs_propertyinit3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLSQUARE_in_tcs_alternative3324 = new BitSet(new long[]{0x000000004D284120L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_alternative3332 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_PIPE_in_tcs_alternative3341 = new BitSet(new long[]{0x000000005D284120L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_alternative3349 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_DRSQUARE_in_tcs_alternative3358 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_STAR_in_tcs_alternative3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_tcs_functioncall3426 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functioncall3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_referstoparg_in_tcs_propertyarg3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookinparg_in_tcs_propertyarg3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createinparg_in_tcs_propertyarg3490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_asparg_in_tcs_propertyarg3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_referstokeyparg_in_tcs_propertyarg3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_separatorparg_in_tcs_propertyarg3514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_autocreateparg_in_tcs_propertyarg3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_importcontextparg_in_tcs_propertyarg3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createasparg_in_tcs_propertyarg3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_modeparg_in_tcs_propertyarg3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_tcs_referstoparg3584 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_referstoparg3588 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_referstoparg3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_tcs_lookinparg3639 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookinparg3643 = new BitSet(new long[]{0xFFFF000000040010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_SHARP_in_tcs_lookinparg3654 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_tcs_lookinparg3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg3675 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_lookinparg3684 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg3692 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_115_in_tcs_createinparg3745 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_createinparg3749 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg3757 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_createinparg3766 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg3774 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_75_in_tcs_asparg3820 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_asparg3824 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_asparg3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_tcs_referstokeyparg3875 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_referstokeyparg3879 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_50_in_tcs_referstokeyparg3889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_tcs_referstokeyparg3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_tcs_separatorparg3949 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_separatorparg3953 = new BitSet(new long[]{0x0000000045284120L});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_separatorparg3961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_tcs_autocreateparg4004 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_autocreateparg4008 = new BitSet(new long[]{0x0202000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg4016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_tcs_autocreatekind4060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_tcs_autocreatekind4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_tcs_autocreatekind4080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_tcs_importcontextparg4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_tcs_forcedlowerparg4151 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedlowerparg4155 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedlowerparg4163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_tcs_createasparg4206 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_createasparg4210 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg4218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_tcs_modeparg4261 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_modeparg4265 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_modeparg4273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_nbnlbarg_in_tcs_blockarg4313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_indentincrbarg_in_tcs_blockarg4321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnlbarg_in_tcs_blockarg4329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg4337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endnlbarg_in_tcs_blockarg4345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_tcs_nbnlbarg4375 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_nbnlbarg4379 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_nbnlbarg4387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_tcs_indentincrbarg4430 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_indentincrbarg4434 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_indentincrbarg4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_tcs_startnlbarg4485 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnlbarg4489 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_50_in_tcs_startnlbarg4499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_tcs_startnlbarg4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_tcs_startnbnlbarg4559 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnbnlbarg4563 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_startnbnlbarg4571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_tcs_endnlbarg4614 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_endnlbarg4618 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_50_in_tcs_endnlbarg4628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_tcs_endnlbarg4641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_symbol4692 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_symbol4699 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_symbol4707 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_COLON_in_tcs_symbol4720 = new BitSet(new long[]{0x1081000000002000L,0x0000001000000000L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol4728 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_symbol4737 = new BitSet(new long[]{0x1081000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol4745 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_symbol4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_tcs_spacekind4812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_tcs_spacekind4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_tcs_spacekind4832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_tcs_spacekind4842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_keyword4877 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_keyword4884 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_keyword4892 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_keyword4899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_tcs_operatorlist4940 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatorlist4953 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_operatorlist4973 = new BitSet(new long[]{0x0000000000001000L,0x0000400000000000L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist4984 = new BitSet(new long[]{0x0000000000001000L,0x0000400000000000L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist4992 = new BitSet(new long[]{0x0000000000001000L,0x0000400000000000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_operatorlist5007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_tcs_priority5048 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_priority5055 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_priority5078 = new BitSet(new long[]{0x0000000000000000L,0x0000020080000000L});
    public static final BitSet FOLLOW_tcs_associativity_in_tcs_priority5086 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_priority5100 = new BitSet(new long[]{0x2000000000001010L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority5111 = new BitSet(new long[]{0x2000000000001010L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority5119 = new BitSet(new long[]{0x2000000000001010L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_priority5134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_tcs_operator5181 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator5203 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_operator5210 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator5229 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operator5249 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_operator5274 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_operator5282 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operator5289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_tcs_associativity5331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_tcs_associativity5341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_andexp_in_tcs_expression5369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp5403 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_tcs_andexp5411 = new BitSet(new long[]{0x0000000000004000L,0x000000C000000000L});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp5418 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_tcs_equalsexp_in_tcs_atomexp5463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp5471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_isdefinedexp_in_tcs_atomexp5479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_oneexp_in_tcs_atomexp5487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_tcs_equalsexp5518 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_equalsexp5526 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_equalsexp5533 = new BitSet(new long[]{0x0000000100040060L});
    public static final BitSet FOLLOW_tcs_value_in_tcs_equalsexp5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_tcs_booleanpropertyexp5585 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_booleanpropertyexp5593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_tcs_isdefinedexp5636 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_isdefinedexp5640 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_isdefinedexp5645 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_isdefinedexp5653 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_isdefinedexp5660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_tcs_oneexp5701 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_oneexp5705 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_oneexp5710 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_oneexp5718 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_oneexp5725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_stringval_in_tcs_value5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_integerval_in_tcs_value5771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_negativeintegerval_in_tcs_value5779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_value5787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringval5821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_integerval5868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_tcs_negativeintegerval5912 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_negativeintegerval5920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_tcs_enumliteralval5964 = new BitSet(new long[]{0xFFFF000000000010L,0x1FFFFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_enumliteralval5972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_tcs_token6015 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_token6022 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_token6029 = new BitSet(new long[]{0x0000000000200020L,0x0000000004008010L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_token6037 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_token6044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern6089 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_PIPE_in_tcs_orpattern6098 = new BitSet(new long[]{0x0000000000200020L,0x0000000004008010L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern6106 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_tcs_rulepattern_in_tcs_simplepattern6149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_simplepattern6157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classpattern_in_tcs_simplepattern6165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_rule_in_tcs_rulepattern6199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wordrule_in_tcs_rule6239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endoflinerule_in_tcs_rule6247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_multilinerule_in_tcs_rule6255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_tcs_wordrule6285 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_wordrule6289 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_tcs_wordrule6293 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule6297 = new BitSet(new long[]{0x0000000000200020L,0x0000000004008010L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule6305 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule6312 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_tcs_wordrule6316 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule6320 = new BitSet(new long[]{0x0000000000200020L,0x0000000004008010L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule6328 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule6341 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_tcs_wordrule6345 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule6349 = new BitSet(new long[]{0x0000000000200020L,0x0000000004008010L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule6357 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule6383 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_tcs_wordrule6387 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule6391 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_wordrule6396 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_tcs_word_in_tcs_wordrule6404 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule6413 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_word_in_tcs_wordrule6421 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_wordrule6433 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_wordrule6451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_word6496 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_word6503 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_word6511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_tcs_endoflinerule6554 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_endoflinerule6558 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_tcs_endoflinerule6562 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_endoflinerule6566 = new BitSet(new long[]{0x0000000000000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_tcs_endoflinerule6576 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_endoflinerule6598 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_endoflinerule6605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_tcs_multilinerule6646 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule6650 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_tcs_multilinerule6654 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule6658 = new BitSet(new long[]{0x0000000000000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_tcs_multilinerule6668 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule6690 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule6697 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_tcs_multilinerule6701 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule6705 = new BitSet(new long[]{0x0000000000000020L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_tcs_multilinerule6715 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule6737 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule6750 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_tcs_multilinerule6754 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule6758 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule6766 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule6779 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule6784 = new BitSet(new long[]{0x0000000080000410L,0x0040010000000000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule6792 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule6801 = new BitSet(new long[]{0x0000000080000010L,0x0040010000000000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule6809 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule6821 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule6852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplemapping_in_tcs_mapping6890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wildcardmapping_in_tcs_mapping6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_octalmapping_in_tcs_mapping6906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping6914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping6948 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_simplemapping6955 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping6963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping7007 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_wildcardmapping7012 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping7017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_tcs_octalmapping7058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_tcs_hexadecimalmapping7098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringpattern7142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_classpattern7186 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classpattern7194 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_classpattern7201 = new BitSet(new long[]{0x0000000000000002L});

}