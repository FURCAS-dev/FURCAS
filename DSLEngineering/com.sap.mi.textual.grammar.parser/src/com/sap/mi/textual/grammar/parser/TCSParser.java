// $ANTLR 3.1.1 parser/TCS.g 2009-10-28 10:33:29

package com.sap.mi.textual.grammar.parser;
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
public class TCSParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "DLCOLON", "LPAREN", "RPAREN", "EQ", "LCURLY", "RCURLY", "SEMI", "RARROW", "COLON", "COMA", "SHARP", "LT", "GT", "LSQUARE", "RSQUARE", "QMARK", "DLSQUARE", "PIPE", "DRSQUARE", "STAR", "DOLLAR", "DLCURLY", "DRCURLY", "LARROW", "POINT", "MINUS", "COMMENT", "EXCL", "AROBAS", "SLASH", "PLUS", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'octal'", "'start'", "'all'", "'one'", "'left'", "'forcedUpper'", "'rightSpace'", "'refersTo'", "'never'", "'deep'", "'separator'", "'default'", "'multi'", "'template'", "'operators'", "'endOfLine'", "'createAs'", "'indentIncr'", "'startNL'", "'importContext'", "'addToContext'", "'value'", "'rightNone'", "'serializer'", "'multiLine'", "'primitiveTemplate'", "'token'", "'operatorTemplate'", "'word'", "'false'", "'mode'", "'function'", "'orKeyword'", "'end'", "'storeOpTo'", "'endNL'", "'ifmissing'", "'disambiguateV3'", "'part'", "'startNbNL'", "'source'", "'autoCreate'", "'lexer'", "'abstract'", "'when'", "'k'", "'isDefined'", "'lookIn'", "'storeRightTo'", "'omitted'", "'drop'", "'priority'", "'forcedLower'", "'esc'", "'referenceOnly'", "'operatored'", "'instanceOf'", "'nonPrimary'", "'enumerationTemplate'", "'invert'", "'foreach'", "'disambiguate'", "'auto'", "'and'", "'leftNone'", "'nbNL'", "'leftSpace'", "'partial'", "'syntax'", "'hex'", "'right'", "'context'", "'as'", "'prefix'", "'createIn'", "'main'", "'always'", "'query'", "'using'", "'for'", "'postfix'", "'symbols'", "'true'", "'filter'", "'keywords'"
    };
    public static final int DLCURLY=29;
    public static final int LT=19;
    public static final int STAR=27;
    public static final int LSQUARE=21;
    public static final int DRCURLY=30;
    public static final int EXCL=35;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int RPAREN=10;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int T__90=90;
    public static final int NL=42;
    public static final int EQ=11;
    public static final int COMMENT=34;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int NE=41;
    public static final int T__95=95;
    public static final int GE=39;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int SHARP=18;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LCURLY=12;
    public static final int INT=6;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int ALPHA=45;
    public static final int T__88=88;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=43;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int SNAME=46;
    public static final int T__70=70;
    public static final int GT=20;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__130=130;
    public static final int QMARK=23;
    public static final int T__73=73;
    public static final int T__131=131;
    public static final int T__132=132;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int DOLLAR=28;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int POINT=32;
    public static final int AROBAS=36;
    public static final int T__118=118;
    public static final int ESC=47;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int DLCOLON=8;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int DRSQUARE=26;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int LARROW=31;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int FLOAT=7;
    public static final int T__120=120;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int LPAREN=9;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int SLASH=37;
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
    public static final int PLUS=38;
    public static final int PIPE=25;
    public static final int T__112=112;
    public static final int DIGIT=44;
    public static final int T__50=50;
    public static final int DLSQUARE=24;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RARROW=15;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int MINUS=33;
    public static final int RSQUARE=22;
    public static final int COMA=17;
    public static final int SEMI=14;
    public static final int COLON=16;
    public static final int RCURLY=13;
    public static final int LE=40;
    public static final int STRING=5;

    // delegates
    // delegators


        public TCSParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TCSParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return TCSParser.tokenNames; }
    public String getGrammarFileName() { return "parser/TCS.g"; }


       private static final String syntaxUUID = "E0DCF6CDE579EF41C3A411DEB0A500216A684158";
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
    // parser/TCS.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:208:3: ( (ast= NAME ) )
            // parser/TCS.g:209:3: (ast= NAME )
            {
            // parser/TCS.g:209:3: (ast= NAME )
            // parser/TCS.g:209:4: ast= NAME
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
    // parser/TCS.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'octal' | 'start' | 'all' | 'one' | 'left' | 'forcedUpper' | 'rightSpace' | 'refersTo' | 'never' | 'deep' | 'separator' | 'default' | 'multi' | 'template' | 'operators' | 'endOfLine' | 'createAs' | 'indentIncr' | 'startNL' | 'importContext' | 'addToContext' | 'value' | 'rightNone' | 'serializer' | 'multiLine' | 'primitiveTemplate' | 'token' | 'operatorTemplate' | 'word' | 'false' | 'mode' | 'function' | 'orKeyword' | 'end' | 'storeOpTo' | 'endNL' | 'ifmissing' | 'disambiguateV3' | 'part' | 'startNbNL' | 'source' | 'autoCreate' | 'lexer' | 'abstract' | 'when' | 'k' | 'isDefined' | 'lookIn' | 'storeRightTo' | 'omitted' | 'drop' | 'priority' | 'forcedLower' | 'esc' | 'referenceOnly' | 'operatored' | 'instanceOf' | 'nonPrimary' | 'enumerationTemplate' | 'invert' | 'foreach' | 'disambiguate' | 'auto' | 'and' | 'leftNone' | 'nbNL' | 'leftSpace' | 'partial' | 'syntax' | 'hex' | 'right' | 'context' | 'as' | 'prefix' | 'createIn' | 'main' | 'always' | 'query' | 'using' | 'for' | 'postfix' | 'symbols' | 'true' | 'filter' | 'keywords' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:218:3: ( (ast= NAME | 'octal' | 'start' | 'all' | 'one' | 'left' | 'forcedUpper' | 'rightSpace' | 'refersTo' | 'never' | 'deep' | 'separator' | 'default' | 'multi' | 'template' | 'operators' | 'endOfLine' | 'createAs' | 'indentIncr' | 'startNL' | 'importContext' | 'addToContext' | 'value' | 'rightNone' | 'serializer' | 'multiLine' | 'primitiveTemplate' | 'token' | 'operatorTemplate' | 'word' | 'false' | 'mode' | 'function' | 'orKeyword' | 'end' | 'storeOpTo' | 'endNL' | 'ifmissing' | 'disambiguateV3' | 'part' | 'startNbNL' | 'source' | 'autoCreate' | 'lexer' | 'abstract' | 'when' | 'k' | 'isDefined' | 'lookIn' | 'storeRightTo' | 'omitted' | 'drop' | 'priority' | 'forcedLower' | 'esc' | 'referenceOnly' | 'operatored' | 'instanceOf' | 'nonPrimary' | 'enumerationTemplate' | 'invert' | 'foreach' | 'disambiguate' | 'auto' | 'and' | 'leftNone' | 'nbNL' | 'leftSpace' | 'partial' | 'syntax' | 'hex' | 'right' | 'context' | 'as' | 'prefix' | 'createIn' | 'main' | 'always' | 'query' | 'using' | 'for' | 'postfix' | 'symbols' | 'true' | 'filter' | 'keywords' ) )
            // parser/TCS.g:219:3: (ast= NAME | 'octal' | 'start' | 'all' | 'one' | 'left' | 'forcedUpper' | 'rightSpace' | 'refersTo' | 'never' | 'deep' | 'separator' | 'default' | 'multi' | 'template' | 'operators' | 'endOfLine' | 'createAs' | 'indentIncr' | 'startNL' | 'importContext' | 'addToContext' | 'value' | 'rightNone' | 'serializer' | 'multiLine' | 'primitiveTemplate' | 'token' | 'operatorTemplate' | 'word' | 'false' | 'mode' | 'function' | 'orKeyword' | 'end' | 'storeOpTo' | 'endNL' | 'ifmissing' | 'disambiguateV3' | 'part' | 'startNbNL' | 'source' | 'autoCreate' | 'lexer' | 'abstract' | 'when' | 'k' | 'isDefined' | 'lookIn' | 'storeRightTo' | 'omitted' | 'drop' | 'priority' | 'forcedLower' | 'esc' | 'referenceOnly' | 'operatored' | 'instanceOf' | 'nonPrimary' | 'enumerationTemplate' | 'invert' | 'foreach' | 'disambiguate' | 'auto' | 'and' | 'leftNone' | 'nbNL' | 'leftSpace' | 'partial' | 'syntax' | 'hex' | 'right' | 'context' | 'as' | 'prefix' | 'createIn' | 'main' | 'always' | 'query' | 'using' | 'for' | 'postfix' | 'symbols' | 'true' | 'filter' | 'keywords' )
            {
            // parser/TCS.g:219:3: (ast= NAME | 'octal' | 'start' | 'all' | 'one' | 'left' | 'forcedUpper' | 'rightSpace' | 'refersTo' | 'never' | 'deep' | 'separator' | 'default' | 'multi' | 'template' | 'operators' | 'endOfLine' | 'createAs' | 'indentIncr' | 'startNL' | 'importContext' | 'addToContext' | 'value' | 'rightNone' | 'serializer' | 'multiLine' | 'primitiveTemplate' | 'token' | 'operatorTemplate' | 'word' | 'false' | 'mode' | 'function' | 'orKeyword' | 'end' | 'storeOpTo' | 'endNL' | 'ifmissing' | 'disambiguateV3' | 'part' | 'startNbNL' | 'source' | 'autoCreate' | 'lexer' | 'abstract' | 'when' | 'k' | 'isDefined' | 'lookIn' | 'storeRightTo' | 'omitted' | 'drop' | 'priority' | 'forcedLower' | 'esc' | 'referenceOnly' | 'operatored' | 'instanceOf' | 'nonPrimary' | 'enumerationTemplate' | 'invert' | 'foreach' | 'disambiguate' | 'auto' | 'and' | 'leftNone' | 'nbNL' | 'leftSpace' | 'partial' | 'syntax' | 'hex' | 'right' | 'context' | 'as' | 'prefix' | 'createIn' | 'main' | 'always' | 'query' | 'using' | 'for' | 'postfix' | 'symbols' | 'true' | 'filter' | 'keywords' )
            int alt1=86;
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
            case 125:
                {
                alt1=79;
                }
                break;
            case 126:
                {
                alt1=80;
                }
                break;
            case 127:
                {
                alt1=81;
                }
                break;
            case 128:
                {
                alt1=82;
                }
                break;
            case 129:
                {
                alt1=83;
                }
                break;
            case 130:
                {
                alt1=84;
                }
                break;
            case 131:
                {
                alt1=85;
                }
                break;
            case 132:
                {
                alt1=86;
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
                    // parser/TCS.g:219:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:221:5: 'octal'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "octal";
                    }

                    }
                    break;
                case 3 :
                    // parser/TCS.g:222:5: 'start'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "start";
                    }

                    }
                    break;
                case 4 :
                    // parser/TCS.g:223:5: 'all'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "all";
                    }

                    }
                    break;
                case 5 :
                    // parser/TCS.g:224:5: 'one'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "one";
                    }

                    }
                    break;
                case 6 :
                    // parser/TCS.g:225:5: 'left'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "left";
                    }

                    }
                    break;
                case 7 :
                    // parser/TCS.g:226:5: 'forcedUpper'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedUpper";
                    }

                    }
                    break;
                case 8 :
                    // parser/TCS.g:227:5: 'rightSpace'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightSpace";
                    }

                    }
                    break;
                case 9 :
                    // parser/TCS.g:228:5: 'refersTo'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "refersTo";
                    }

                    }
                    break;
                case 10 :
                    // parser/TCS.g:229:5: 'never'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "never";
                    }

                    }
                    break;
                case 11 :
                    // parser/TCS.g:230:5: 'deep'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "deep";
                    }

                    }
                    break;
                case 12 :
                    // parser/TCS.g:231:5: 'separator'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "separator";
                    }

                    }
                    break;
                case 13 :
                    // parser/TCS.g:232:5: 'default'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "default";
                    }

                    }
                    break;
                case 14 :
                    // parser/TCS.g:233:5: 'multi'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multi";
                    }

                    }
                    break;
                case 15 :
                    // parser/TCS.g:234:5: 'template'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "template";
                    }

                    }
                    break;
                case 16 :
                    // parser/TCS.g:235:5: 'operators'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operators";
                    }

                    }
                    break;
                case 17 :
                    // parser/TCS.g:236:5: 'endOfLine'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endOfLine";
                    }

                    }
                    break;
                case 18 :
                    // parser/TCS.g:237:5: 'createAs'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword236); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createAs";
                    }

                    }
                    break;
                case 19 :
                    // parser/TCS.g:238:5: 'indentIncr'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword244); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "indentIncr";
                    }

                    }
                    break;
                case 20 :
                    // parser/TCS.g:239:5: 'startNL'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword252); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNL";
                    }

                    }
                    break;
                case 21 :
                    // parser/TCS.g:240:5: 'importContext'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword260); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "importContext";
                    }

                    }
                    break;
                case 22 :
                    // parser/TCS.g:241:5: 'addToContext'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword268); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "addToContext";
                    }

                    }
                    break;
                case 23 :
                    // parser/TCS.g:242:5: 'value'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword276); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "value";
                    }

                    }
                    break;
                case 24 :
                    // parser/TCS.g:243:5: 'rightNone'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightNone";
                    }

                    }
                    break;
                case 25 :
                    // parser/TCS.g:244:5: 'serializer'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "serializer";
                    }

                    }
                    break;
                case 26 :
                    // parser/TCS.g:245:5: 'multiLine'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword300); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multiLine";
                    }

                    }
                    break;
                case 27 :
                    // parser/TCS.g:246:5: 'primitiveTemplate'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword308); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "primitiveTemplate";
                    }

                    }
                    break;
                case 28 :
                    // parser/TCS.g:247:5: 'token'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword316); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "token";
                    }

                    }
                    break;
                case 29 :
                    // parser/TCS.g:248:5: 'operatorTemplate'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword324); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatorTemplate";
                    }

                    }
                    break;
                case 30 :
                    // parser/TCS.g:249:5: 'word'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword332); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "word";
                    }

                    }
                    break;
                case 31 :
                    // parser/TCS.g:250:5: 'false'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword340); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 32 :
                    // parser/TCS.g:251:5: 'mode'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword348); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "mode";
                    }

                    }
                    break;
                case 33 :
                    // parser/TCS.g:252:5: 'function'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword356); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "function";
                    }

                    }
                    break;
                case 34 :
                    // parser/TCS.g:253:5: 'orKeyword'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword364); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "orKeyword";
                    }

                    }
                    break;
                case 35 :
                    // parser/TCS.g:254:5: 'end'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword372); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "end";
                    }

                    }
                    break;
                case 36 :
                    // parser/TCS.g:255:5: 'storeOpTo'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword380); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeOpTo";
                    }

                    }
                    break;
                case 37 :
                    // parser/TCS.g:256:5: 'endNL'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword388); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endNL";
                    }

                    }
                    break;
                case 38 :
                    // parser/TCS.g:257:5: 'ifmissing'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword396); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "ifmissing";
                    }

                    }
                    break;
                case 39 :
                    // parser/TCS.g:258:5: 'disambiguateV3'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword404); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguateV3";
                    }

                    }
                    break;
                case 40 :
                    // parser/TCS.g:259:5: 'part'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword412); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "part";
                    }

                    }
                    break;
                case 41 :
                    // parser/TCS.g:260:5: 'startNbNL'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword420); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNbNL";
                    }

                    }
                    break;
                case 42 :
                    // parser/TCS.g:261:5: 'source'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword428); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "source";
                    }

                    }
                    break;
                case 43 :
                    // parser/TCS.g:262:5: 'autoCreate'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword436); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "autoCreate";
                    }

                    }
                    break;
                case 44 :
                    // parser/TCS.g:263:5: 'lexer'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword444); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lexer";
                    }

                    }
                    break;
                case 45 :
                    // parser/TCS.g:264:5: 'abstract'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword452); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 46 :
                    // parser/TCS.g:265:5: 'when'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword460); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "when";
                    }

                    }
                    break;
                case 47 :
                    // parser/TCS.g:266:5: 'k'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword468); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "k";
                    }

                    }
                    break;
                case 48 :
                    // parser/TCS.g:267:5: 'isDefined'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword476); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "isDefined";
                    }

                    }
                    break;
                case 49 :
                    // parser/TCS.g:268:5: 'lookIn'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword484); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookIn";
                    }

                    }
                    break;
                case 50 :
                    // parser/TCS.g:269:5: 'storeRightTo'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword492); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeRightTo";
                    }

                    }
                    break;
                case 51 :
                    // parser/TCS.g:270:5: 'omitted'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword500); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "omitted";
                    }

                    }
                    break;
                case 52 :
                    // parser/TCS.g:271:5: 'drop'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword508); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "drop";
                    }

                    }
                    break;
                case 53 :
                    // parser/TCS.g:272:5: 'priority'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword516); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "priority";
                    }

                    }
                    break;
                case 54 :
                    // parser/TCS.g:273:5: 'forcedLower'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword524); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedLower";
                    }

                    }
                    break;
                case 55 :
                    // parser/TCS.g:274:5: 'esc'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword532); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "esc";
                    }

                    }
                    break;
                case 56 :
                    // parser/TCS.g:275:5: 'referenceOnly'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword540); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "referenceOnly";
                    }

                    }
                    break;
                case 57 :
                    // parser/TCS.g:276:5: 'operatored'
                    {
                    match(input,103,FOLLOW_103_in_identifierOrKeyword548); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatored";
                    }

                    }
                    break;
                case 58 :
                    // parser/TCS.g:277:5: 'instanceOf'
                    {
                    match(input,104,FOLLOW_104_in_identifierOrKeyword556); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "instanceOf";
                    }

                    }
                    break;
                case 59 :
                    // parser/TCS.g:278:5: 'nonPrimary'
                    {
                    match(input,105,FOLLOW_105_in_identifierOrKeyword564); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nonPrimary";
                    }

                    }
                    break;
                case 60 :
                    // parser/TCS.g:279:5: 'enumerationTemplate'
                    {
                    match(input,106,FOLLOW_106_in_identifierOrKeyword572); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "enumerationTemplate";
                    }

                    }
                    break;
                case 61 :
                    // parser/TCS.g:280:5: 'invert'
                    {
                    match(input,107,FOLLOW_107_in_identifierOrKeyword580); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "invert";
                    }

                    }
                    break;
                case 62 :
                    // parser/TCS.g:281:5: 'foreach'
                    {
                    match(input,108,FOLLOW_108_in_identifierOrKeyword588); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 63 :
                    // parser/TCS.g:282:5: 'disambiguate'
                    {
                    match(input,109,FOLLOW_109_in_identifierOrKeyword596); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguate";
                    }

                    }
                    break;
                case 64 :
                    // parser/TCS.g:283:5: 'auto'
                    {
                    match(input,110,FOLLOW_110_in_identifierOrKeyword604); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "auto";
                    }

                    }
                    break;
                case 65 :
                    // parser/TCS.g:284:5: 'and'
                    {
                    match(input,111,FOLLOW_111_in_identifierOrKeyword612); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 66 :
                    // parser/TCS.g:285:5: 'leftNone'
                    {
                    match(input,112,FOLLOW_112_in_identifierOrKeyword620); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftNone";
                    }

                    }
                    break;
                case 67 :
                    // parser/TCS.g:286:5: 'nbNL'
                    {
                    match(input,113,FOLLOW_113_in_identifierOrKeyword628); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nbNL";
                    }

                    }
                    break;
                case 68 :
                    // parser/TCS.g:287:5: 'leftSpace'
                    {
                    match(input,114,FOLLOW_114_in_identifierOrKeyword636); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftSpace";
                    }

                    }
                    break;
                case 69 :
                    // parser/TCS.g:288:5: 'partial'
                    {
                    match(input,115,FOLLOW_115_in_identifierOrKeyword644); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "partial";
                    }

                    }
                    break;
                case 70 :
                    // parser/TCS.g:289:5: 'syntax'
                    {
                    match(input,116,FOLLOW_116_in_identifierOrKeyword652); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "syntax";
                    }

                    }
                    break;
                case 71 :
                    // parser/TCS.g:290:5: 'hex'
                    {
                    match(input,117,FOLLOW_117_in_identifierOrKeyword660); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "hex";
                    }

                    }
                    break;
                case 72 :
                    // parser/TCS.g:291:5: 'right'
                    {
                    match(input,118,FOLLOW_118_in_identifierOrKeyword668); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "right";
                    }

                    }
                    break;
                case 73 :
                    // parser/TCS.g:292:5: 'context'
                    {
                    match(input,119,FOLLOW_119_in_identifierOrKeyword676); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 74 :
                    // parser/TCS.g:293:5: 'as'
                    {
                    match(input,120,FOLLOW_120_in_identifierOrKeyword684); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "as";
                    }

                    }
                    break;
                case 75 :
                    // parser/TCS.g:294:5: 'prefix'
                    {
                    match(input,121,FOLLOW_121_in_identifierOrKeyword692); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "prefix";
                    }

                    }
                    break;
                case 76 :
                    // parser/TCS.g:295:5: 'createIn'
                    {
                    match(input,122,FOLLOW_122_in_identifierOrKeyword700); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createIn";
                    }

                    }
                    break;
                case 77 :
                    // parser/TCS.g:296:5: 'main'
                    {
                    match(input,123,FOLLOW_123_in_identifierOrKeyword708); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "main";
                    }

                    }
                    break;
                case 78 :
                    // parser/TCS.g:297:5: 'always'
                    {
                    match(input,124,FOLLOW_124_in_identifierOrKeyword716); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "always";
                    }

                    }
                    break;
                case 79 :
                    // parser/TCS.g:298:5: 'query'
                    {
                    match(input,125,FOLLOW_125_in_identifierOrKeyword724); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "query";
                    }

                    }
                    break;
                case 80 :
                    // parser/TCS.g:299:5: 'using'
                    {
                    match(input,126,FOLLOW_126_in_identifierOrKeyword732); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "using";
                    }

                    }
                    break;
                case 81 :
                    // parser/TCS.g:300:5: 'for'
                    {
                    match(input,127,FOLLOW_127_in_identifierOrKeyword740); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 82 :
                    // parser/TCS.g:301:5: 'postfix'
                    {
                    match(input,128,FOLLOW_128_in_identifierOrKeyword748); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "postfix";
                    }

                    }
                    break;
                case 83 :
                    // parser/TCS.g:302:5: 'symbols'
                    {
                    match(input,129,FOLLOW_129_in_identifierOrKeyword756); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "symbols";
                    }

                    }
                    break;
                case 84 :
                    // parser/TCS.g:303:5: 'true'
                    {
                    match(input,130,FOLLOW_130_in_identifierOrKeyword764); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 85 :
                    // parser/TCS.g:304:5: 'filter'
                    {
                    match(input,131,FOLLOW_131_in_identifierOrKeyword772); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "filter";
                    }

                    }
                    break;
                case 86 :
                    // parser/TCS.g:305:5: 'keywords'
                    {
                    match(input,132,FOLLOW_132_in_identifierOrKeyword780); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "keywords";
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
    // parser/TCS.g:312:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:313:3: ( (ast= STRING ) )
            // parser/TCS.g:314:3: (ast= STRING )
            {
            // parser/TCS.g:314:3: (ast= STRING )
            // parser/TCS.g:314:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol811); if (state.failed) return ret2;
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
    // parser/TCS.g:322:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:323:3: ( (ast= INT ) )
            // parser/TCS.g:324:3: (ast= INT )
            {
            // parser/TCS.g:324:3: (ast= INT )
            // parser/TCS.g:324:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol842); if (state.failed) return ret2;
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
    // parser/TCS.g:332:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:333:3: ( (ast= FLOAT ) )
            // parser/TCS.g:334:3: (ast= FLOAT )
            {
            // parser/TCS.g:334:3: (ast= FLOAT )
            // parser/TCS.g:334:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol873); if (state.failed) return ret2;
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


    // $ANTLR start "model_classifier"
    // parser/TCS.g:342:1: model_classifier returns [Object ret2] : ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) ) ;
    public final Object model_classifier() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Classifier");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:347:3: ( ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) ) )
            // parser/TCS.g:348:3: ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) )
            {
            // parser/TCS.g:348:3: ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) )
            // parser/TCS.g:348:4: ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4A86E73C3A411DEC1FF00216A684158");
            }
            // parser/TCS.g:348:64: ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==EOF||(LA2_1>=LPAREN && LA2_1<=RPAREN)||LA2_1==SEMI||LA2_1==COLON||LA2_1==SHARP||LA2_1==57||(LA2_1>=59 && LA2_1<=60)||LA2_1==68||LA2_1==91||(LA2_1>=102 && LA2_1<=103)||LA2_1==105||LA2_1==110||LA2_1==119||LA2_1==121||LA2_1==123||LA2_1==126) ) {
                    alt2=2;
                }
                else if ( (LA2_1==DLCOLON) ) {
                    alt2=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA2_0==LPAREN) ) {
                alt2=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // parser/TCS.g:348:65: ( (temp= model_namespace ) DLCOLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:348:81: ( (temp= model_namespace ) DLCOLON (temp= identifier ) )
                    // parser/TCS.g:348:82: (temp= model_namespace ) DLCOLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE49C8791C3A411DEAA2500216A684158");
                    }
                    // parser/TCS.g:348:141: (temp= model_namespace )
                    // parser/TCS.g:348:143: temp= model_namespace
                    {
                    pushFollow(FOLLOW_model_namespace_in_model_classifier913);
                    temp=model_namespace();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "container", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4A14280C3A411DE92BF00216A684158");
                    }
                    match(input,DLCOLON,FOLLOW_DLCOLON_in_model_classifier920); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4A14282C3A411DEC12A00216A684158");
                    }
                    // parser/TCS.g:348:362: (temp= identifier )
                    // parser/TCS.g:348:364: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_model_classifier928);
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
                    // parser/TCS.g:348:448: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:348:464: ( (temp= identifier ) )
                    // parser/TCS.g:348:465: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4A86E71C3A411DE8F9700216A684158");
                    }
                    // parser/TCS.g:348:524: (temp= identifier )
                    // parser/TCS.g:348:526: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_model_classifier947);
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
    // $ANTLR end "model_classifier"


    // $ANTLR start "primary_model_namespace"
    // parser/TCS.g:357:1: primary_model_namespace returns [Object ret2] : (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) ) ;
    public final Object primary_model_namespace() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:358:3: ( (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) ) )
            // parser/TCS.g:359:3: (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) )
            {
            // parser/TCS.g:359:3: (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==NAME) ) {
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
                    // parser/TCS.g:359:4: ret= model_generalizableelement
                    {
                    pushFollow(FOLLOW_model_generalizableelement_in_primary_model_namespace993);
                    ret=model_generalizableelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:360:5: ( LPAREN ret= model_namespace RPAREN )
                    {
                    // parser/TCS.g:360:5: ( LPAREN ret= model_namespace RPAREN )
                    // parser/TCS.g:360:6: LPAREN ret= model_namespace RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_model_namespace1002); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_model_namespace_in_primary_model_namespace1008);
                    ret=model_namespace();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_model_namespace1012); if (state.failed) return ret2;
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
    // $ANTLR end "primary_model_namespace"


    // $ANTLR start "dblcolon_priority_0"
    // parser/TCS.g:367:1: dblcolon_priority_0 returns [Object ret2] : ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object dblcolon_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // parser/TCS.g:368:3: ( ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) ) )
            // parser/TCS.g:369:4: ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) )
            {
            // parser/TCS.g:369:4: ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) )
            // parser/TCS.g:369:6: (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* )
            {
            // parser/TCS.g:369:6: (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* )
            // parser/TCS.g:369:8: ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_model_namespace_in_dblcolon_priority_01050);
            ret=primary_model_namespace();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // parser/TCS.g:369:35: ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DLCOLON) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==NAME) ) {
                        int LA4_3 = input.LA(3);

                        if ( (LA4_3==DLCOLON) && (synpred88_TCS())) {
                            alt4=1;
                        }
                        else if ( (LA4_3==RPAREN) ) {
                            int LA4_5 = input.LA(4);

                            if ( (LA4_5==DLCOLON) && (synpred88_TCS())) {
                                alt4=1;
                            }
                            else if ( (LA4_5==RPAREN) && (synpred88_TCS())) {
                                alt4=1;
                            }


                        }


                    }


                }


                switch (alt4) {
            	case 1 :
            	    // parser/TCS.g:369:36: ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) )
            	    {
            	    // parser/TCS.g:369:47: ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) )
            	    // parser/TCS.g:369:48: DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("::", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_dblcolon_priority_01059); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "::";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // parser/TCS.g:369:135: ( (ret= model_modelelement[opName, ret, firstToken] ) )
            	    // parser/TCS.g:369:136: (ret= model_modelelement[opName, ret, firstToken] )
            	    {
            	    // parser/TCS.g:369:136: (ret= model_modelelement[opName, ret, firstToken] )
            	    // parser/TCS.g:369:137: ret= model_modelelement[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_model_modelelement_in_dblcolon_priority_01067);
            	    ret=model_modelelement(opName, ret, firstToken);

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "dblcolon_priority_0"


    // $ANTLR start "model_namespace"
    // parser/TCS.g:377:1: model_namespace returns [Object ret2] : ret= dblcolon_priority_0 ;
    public final Object model_namespace() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:378:3: (ret= dblcolon_priority_0 )
            // parser/TCS.g:379:3: ret= dblcolon_priority_0
            {
            pushFollow(FOLLOW_dblcolon_priority_0_in_model_namespace1099);
            ret=dblcolon_priority_0();

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
    // $ANTLR end "model_namespace"


    // $ANTLR start "model_generalizableelement"
    // parser/TCS.g:386:1: model_generalizableelement returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object model_generalizableelement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","GeneralizableElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:391:3: ( ( (temp= identifier ) ) )
            // parser/TCS.g:392:3: ( (temp= identifier ) )
            {
            // parser/TCS.g:392:3: ( (temp= identifier ) )
            // parser/TCS.g:392:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4B45551C3A411DE8E8300216A684158");
            }
            // parser/TCS.g:392:63: (temp= identifier )
            // parser/TCS.g:392:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_generalizableelement1132);
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
    // $ANTLR end "model_generalizableelement"


    // $ANTLR start "model_modelelement"
    // parser/TCS.g:400:1: model_modelelement[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object model_modelelement(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","ModelElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ?  createReferenceProxy(metaType) : null;


        try {
            // parser/TCS.g:405:3: ( ( (temp= identifier ) ) )
            // parser/TCS.g:406:3: ( (temp= identifier ) )
            {
            // parser/TCS.g:406:3: ( (temp= identifier ) )
            // parser/TCS.g:406:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4B45557C3A411DEA11800216A684158");
            }
            // parser/TCS.g:406:63: (temp= identifier )
            // parser/TCS.g:406:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_modelelement1180);
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

              // discarding operator name instead of storing it here
              setProperty(ret,"container" , left);
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
    // $ANTLR end "model_modelelement"


    // $ANTLR start "textblockdefinition_textblockdefinition"
    // parser/TCS.g:416:1: textblockdefinition_textblockdefinition returns [Object ret2] : () ;
    public final Object textblockdefinition_textblockdefinition() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("textblockdefinition","TextBlockDefinition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:421:3: ( () )
            // parser/TCS.g:422:3: ()
            {
            // parser/TCS.g:422:3: ()
            // parser/TCS.g:422:4: 
            {
            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "textblockdefinition_textblockdefinition"


    // $ANTLR start "main"
    // parser/TCS.g:430:1: main returns [Object ret2] : ( (ret= tcs_concretesyntax ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:431:3: ( ( (ret= tcs_concretesyntax ) EOF ) )
            // parser/TCS.g:432:3: ( (ret= tcs_concretesyntax ) EOF )
            {
            // parser/TCS.g:432:3: ( (ret= tcs_concretesyntax ) EOF )
            // parser/TCS.g:432:4: (ret= tcs_concretesyntax ) EOF
            {
            // parser/TCS.g:432:4: (ret= tcs_concretesyntax )
            // parser/TCS.g:432:5: ret= tcs_concretesyntax
            {
            pushFollow(FOLLOW_tcs_concretesyntax_in_main1250);
            ret=tcs_concretesyntax();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main1253); if (state.failed) return ret2;

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
    // parser/TCS.g:439:1: tcs_concretesyntax returns [Object ret2] : ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) ;
    public final Object tcs_concretesyntax() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConcreteSyntax");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:444:3: ( ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) )
            // parser/TCS.g:445:3: ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            {
            // parser/TCS.g:445:3: ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            // parser/TCS.g:445:4: 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4BB8140C3A411DE825400216A684158");
            }
            match(input,116,FOLLOW_116_in_tcs_concretesyntax1284); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4BB8142C3A411DE89E600216A684158");
            }
            // parser/TCS.g:445:146: (temp= identifier )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NAME) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // parser/TCS.g:445:148: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_concretesyntax1291);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4BB814DC3A411DEBA0100216A684158");
            }
            // parser/TCS.g:445:276: ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LPAREN) ) {
                alt6=1;
            }
            else if ( (LA6_0==LCURLY) ) {
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
                    // parser/TCS.g:445:277: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:445:293: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    // parser/TCS.g:445:294: LPAREN 'k' EQ (temp= integerSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BB8146C3A411DEAF7F00216A684158");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_concretesyntax1306); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BB8147C3A411DEA9AA00216A684158");
                    }
                    match(input,93,FOLLOW_93_in_tcs_concretesyntax1310); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BB8148C3A411DE91AA00216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1314); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BB814AC3A411DEC9B400216A684158");
                    }
                    // parser/TCS.g:445:593: (temp= integerSymbol )
                    // parser/TCS.g:445:595: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_tcs_concretesyntax1322);
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
                      _beforeSeqEl("E0DCF6CDE4BB814BC3A411DEBCCC00216A684158");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_concretesyntax1329); if (state.failed) return ret2;
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
                    // parser/TCS.g:445:762: 
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
              _beforeSeqEl("E0DCF6CDE4BB814EC3A411DEBA7400216A684158");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1347); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4C4F721C3A411DE945100216A684158");
            }
            // parser/TCS.g:446:159: ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) )
            // parser/TCS.g:446:160: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            {
            // parser/TCS.g:446:160: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            // parser/TCS.g:446:161: (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4BB8150C3A411DEC77700216A684158");
            }
            // parser/TCS.g:446:220: (temp= tcs_template (temp= tcs_template )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==61||LA8_0==73||LA8_0==75||LA8_0==79||LA8_0==106) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // parser/TCS.g:446:222: temp= tcs_template (temp= tcs_template )*
                    {
                    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax1358);
                    temp=tcs_template();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templates", temp);
                    }
                    // parser/TCS.g:446:279: (temp= tcs_template )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==61||LA7_0==73||LA7_0==75||LA7_0==79||LA7_0==106) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // parser/TCS.g:446:281: temp= tcs_template
                    	    {
                    	    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax1366);
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
              _beforeSeqEl("E0DCF6CDE4C03C30C3A411DEB65500216A684158");
            }
            // parser/TCS.g:446:419: ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==132) ) {
                alt11=1;
            }
            else if ( (LA11_0==RCURLY||LA11_0==62||LA11_0==74||LA11_0==90||LA11_0==97||LA11_0==129) ) {
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
                    // parser/TCS.g:446:420: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:446:436: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    // parser/TCS.g:446:437: 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BB8154C3A411DEB23600216A684158");
                    }
                    match(input,132,FOLLOW_132_in_tcs_concretesyntax1383); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BB8155C3A411DE948100216A684158");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1387); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BDCB30C3A411DEB57500216A684158");
                    }
                    // parser/TCS.g:446:664: ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) )
                    // parser/TCS.g:446:665: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    {
                    // parser/TCS.g:446:665: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    // parser/TCS.g:446:666: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BB8157C3A411DE87CC00216A684158");
                    }
                    // parser/TCS.g:446:725: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NAME||LA10_0==EQ) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // parser/TCS.g:446:727: temp= tcs_keyword (temp= tcs_keyword )*
                            {
                            pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax1398);
                            temp=tcs_keyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "keywords", temp);
                            }
                            // parser/TCS.g:446:782: (temp= tcs_keyword )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==NAME||LA9_0==EQ) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // parser/TCS.g:446:784: temp= tcs_keyword
                            	    {
                            	    pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax1406);
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
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4BDCB31C3A411DEBA9000216A684158");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1421); if (state.failed) return ret2;
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
                    // parser/TCS.g:446:979: 
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
              _beforeSeqEl("E0DCF6CDE4C03C3CC3A411DE990F00216A684158");
            }
            // parser/TCS.g:447:77: ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==129) ) {
                alt14=1;
            }
            else if ( (LA14_0==RCURLY||LA14_0==62||LA14_0==74||LA14_0==90||LA14_0==97) ) {
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
                    // parser/TCS.g:447:78: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:447:94: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    // parser/TCS.g:447:95: 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C03C34C3A411DECF3400216A684158");
                    }
                    match(input,129,FOLLOW_129_in_tcs_concretesyntax1444); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C03C35C3A411DEBF5A00216A684158");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1448); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C03C39C3A411DE9DD300216A684158");
                    }
                    // parser/TCS.g:447:321: ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) )
                    // parser/TCS.g:447:322: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    {
                    // parser/TCS.g:447:322: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    // parser/TCS.g:447:323: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C03C37C3A411DE9DD300216A684158");
                    }
                    // parser/TCS.g:447:382: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==NAME||LA13_0==EQ) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // parser/TCS.g:447:384: temp= tcs_symbol (temp= tcs_symbol )*
                            {
                            pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1459);
                            temp=tcs_symbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "symbols", temp);
                            }
                            // parser/TCS.g:447:437: (temp= tcs_symbol )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==NAME||LA12_0==EQ) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // parser/TCS.g:447:439: temp= tcs_symbol
                            	    {
                            	    pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1467);
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
                            	    break loop12;
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
                      _beforeSeqEl("E0DCF6CDE4C03C3AC3A411DEA39900216A684158");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1482); if (state.failed) return ret2;
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
                    // parser/TCS.g:447:632: 
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
              _beforeSeqEl("E0DCF6CDE4C03C3EC3A411DE9FFC00216A684158");
            }
            // parser/TCS.g:448:76: (temp= tcs_operatorlist (temp= tcs_operatorlist )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==62) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // parser/TCS.g:448:78: temp= tcs_operatorlist (temp= tcs_operatorlist )*
                    {
                    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1503);
                    temp=tcs_operatorlist();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operatorLists", temp);
                    }
                    // parser/TCS.g:448:143: (temp= tcs_operatorlist )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==62) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // parser/TCS.g:448:145: temp= tcs_operatorlist
                    	    {
                    	    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1511);
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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4C03C40C3A411DE8A9B00216A684158");
            }
            // parser/TCS.g:448:290: (temp= tcs_token (temp= tcs_token )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==74||LA18_0==97) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // parser/TCS.g:448:292: temp= tcs_token (temp= tcs_token )*
                    {
                    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1526);
                    temp=tcs_token();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tokens", temp);
                    }
                    // parser/TCS.g:448:343: (temp= tcs_token )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==74||LA17_0==97) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // parser/TCS.g:448:345: temp= tcs_token
                    	    {
                    	    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1534);
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
              _beforeSeqEl("E0DCF6CDE4C28623C3A411DEB24900216A684158");
            }
            // parser/TCS.g:448:477: ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==90) ) {
                alt19=1;
            }
            else if ( (LA19_0==RCURLY) ) {
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
                    // parser/TCS.g:448:478: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:448:494: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    // parser/TCS.g:448:495: 'lexer' EQ (temp= stringSymbol ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C03C44C3A411DE85EE00216A684158");
                    }
                    match(input,90,FOLLOW_90_in_tcs_concretesyntax1551); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C03C45C3A411DEAE9900216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1555); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C28620C3A411DEC7A200216A684158");
                    }
                    // parser/TCS.g:448:715: (temp= stringSymbol )
                    // parser/TCS.g:448:717: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_concretesyntax1563);
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
                      _beforeSeqEl("E0DCF6CDE4C28621C3A411DEB9B100216A684158");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_concretesyntax1570); if (state.failed) return ret2;
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
                    // parser/TCS.g:448:885: 
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
              _beforeSeqEl("E0DCF6CDE4C76820C3A411DEA46C00216A684158");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1591); if (state.failed) return ret2;
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


    // $ANTLR start "reference"
    // parser/TCS.g:457:1: reference[Object ret] : ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) ) ;
    public final void reference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // parser/TCS.g:458:3: ( ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) ) )
            // parser/TCS.g:459:3: ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) )
            {
            // parser/TCS.g:459:3: ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) )
            // parser/TCS.g:459:4: ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4C9B213C3A411DEA58100216A684158");
            }
            // parser/TCS.g:459:64: ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NAME||LA22_0==LPAREN) ) {
                alt22=1;
            }
            else if ( (LA22_0==RARROW) ) {
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
                    // parser/TCS.g:459:65: ( (temp= model_classifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:459:81: ( (temp= model_classifier ) )
                    // parser/TCS.g:459:82: (temp= model_classifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C76828C3A411DEA98400216A684158");
                    }
                    // parser/TCS.g:459:141: (temp= model_classifier )
                    // parser/TCS.g:459:143: temp= model_classifier
                    {
                    pushFollow(FOLLOW_model_classifier_in_reference1636);
                    temp=model_classifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "metaReference", temp);
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
                    // parser/TCS.g:459:242: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:459:258: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? )
                    // parser/TCS.g:459:259: RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C7682AC3A411DEA90400216A684158");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_reference1652); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4C9B211C3A411DEAAE600216A684158");
                    }
                    // parser/TCS.g:459:401: (temp= identifier ( ( DLCOLON ) temp= identifier )* )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==NAME) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // parser/TCS.g:459:403: temp= identifier ( ( DLCOLON ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_reference1660);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "names", temp);
                            }
                            // parser/TCS.g:459:454: ( ( DLCOLON ) temp= identifier )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==DLCOLON) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // parser/TCS.g:459:455: ( DLCOLON ) temp= identifier
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:459:472: ( DLCOLON )
                            	    // parser/TCS.g:459:473: DLCOLON
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDE4C7682CC3A411DEAB4E00216A684158");
                            	    }
                            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_reference1669); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_identifier_in_reference1677);
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
                            	    break loop20;
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


    // $ANTLR start "tcs_template"
    // parser/TCS.g:467:1: tcs_template returns [Object ret2] : (ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_classtemplate | ret= tcs_operatortemplate | ret= tcs_functiontemplate ) ;
    public final Object tcs_template() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:468:3: ( (ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_classtemplate | ret= tcs_operatortemplate | ret= tcs_functiontemplate ) )
            // parser/TCS.g:469:3: (ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_classtemplate | ret= tcs_operatortemplate | ret= tcs_functiontemplate )
            {
            // parser/TCS.g:469:3: (ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_classtemplate | ret= tcs_operatortemplate | ret= tcs_functiontemplate )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt23=1;
                }
                break;
            case 106:
                {
                alt23=2;
                }
                break;
            case 61:
                {
                alt23=3;
                }
                break;
            case 75:
                {
                alt23=4;
                }
                break;
            case 79:
                {
                alt23=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // parser/TCS.g:469:4: ret= tcs_primitivetemplate
                    {
                    pushFollow(FOLLOW_tcs_primitivetemplate_in_tcs_template1718);
                    ret=tcs_primitivetemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:470:5: ret= tcs_enumerationtemplate
                    {
                    pushFollow(FOLLOW_tcs_enumerationtemplate_in_tcs_template1726);
                    ret=tcs_enumerationtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:471:5: ret= tcs_classtemplate
                    {
                    pushFollow(FOLLOW_tcs_classtemplate_in_tcs_template1734);
                    ret=tcs_classtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:472:5: ret= tcs_operatortemplate
                    {
                    pushFollow(FOLLOW_tcs_operatortemplate_in_tcs_template1742);
                    ret=tcs_operatortemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:473:5: ret= tcs_functiontemplate
                    {
                    pushFollow(FOLLOW_tcs_functiontemplate_in_tcs_template1750);
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


    // $ANTLR start "tcs_primitivetemplate"
    // parser/TCS.g:480:1: tcs_primitivetemplate returns [Object ret2] : ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_primitivetemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitiveTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:485:3: ( ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:486:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:486:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:486:4: 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D0DE00C3A411DEACB000216A684158");
            }
            match(input,73,FOLLOW_73_in_tcs_primitivetemplate1780); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D0DE02C3A411DE8ECB00216A684158");
            }
            // parser/TCS.g:486:157: (temp= identifier )
            // parser/TCS.g:486:159: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1787);
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
              _beforeSeqEl("E0DCF6CDE4D0DE03C3A411DEBE0600216A684158");
            }
            match(input,127,FOLLOW_127_in_tcs_primitivetemplate1793); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D0DE04C3A411DEC85800216A684158");
            }
            pushFollow(FOLLOW_reference_in_tcs_primitivetemplate1796);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D34F03C3A411DEA00800216A684158");
            }
            // parser/TCS.g:486:462: ( ( 'default' ) | )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==59) ) {
                alt24=1;
            }
            else if ( (LA24_0==126) ) {
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
                    // parser/TCS.g:486:463: ( 'default' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:486:479: ( 'default' )
                    // parser/TCS.g:486:480: 'default'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D34F01C3A411DE882D00216A684158");
                    }
                    match(input,59,FOLLOW_59_in_tcs_primitivetemplate1806); if (state.failed) return ret2;
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
                    // parser/TCS.g:486:638: 
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
              _beforeSeqEl("E0DCF6CDE4D34F04C3A411DEA6AA00216A684158");
            }
            match(input,126,FOLLOW_126_in_tcs_primitivetemplate1824); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D34F06C3A411DE843E00216A684158");
            }
            // parser/TCS.g:487:158: (temp= identifier )
            // parser/TCS.g:487:160: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1831);
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
              _beforeSeqEl("E0DCF6CDE4D34F0CC3A411DEADE900216A684158");
            }
            // parser/TCS.g:487:291: ( ( 'orKeyword' ) | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==80) ) {
                alt25=1;
            }
            else if ( (LA25_0==COLON) ) {
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
                    // parser/TCS.g:487:292: ( 'orKeyword' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:487:308: ( 'orKeyword' )
                    // parser/TCS.g:487:309: 'orKeyword'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D34F0AC3A411DEA21000216A684158");
                    }
                    match(input,80,FOLLOW_80_in_tcs_primitivetemplate1843); if (state.failed) return ret2;
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
                    // parser/TCS.g:487:469: 
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
              _beforeSeqEl("E0DCF6CDE4D34F0DC3A411DEA25B00216A684158");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_primitivetemplate1862); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D34F0EC3A411DEC6D200216A684158");
            }
            match(input,69,FOLLOW_69_in_tcs_primitivetemplate1866); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D34F0FC3A411DE851D00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1870); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D34F12C3A411DECE3F00216A684158");
            }
            // parser/TCS.g:488:319: (temp= stringSymbol )
            // parser/TCS.g:488:321: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1878);
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
              _beforeSeqEl("E0DCF6CDE4D34F1DC3A411DE8DDE00216A684158");
            }
            // parser/TCS.g:488:450: ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==COMA) ) {
                alt26=1;
            }
            else if ( (LA26_0==SEMI) ) {
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
                    // parser/TCS.g:488:451: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:488:467: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:488:468: COMA 'serializer' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D34F16C3A411DE94A400216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_primitivetemplate1891); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D34F17C3A411DEA17600216A684158");
                    }
                    match(input,71,FOLLOW_71_in_tcs_primitivetemplate1895); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D34F18C3A411DEC82200216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1899); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D34F1BC3A411DE8DA800216A684158");
                    }
                    // parser/TCS.g:488:774: (temp= stringSymbol )
                    // parser/TCS.g:488:776: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1907);
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
                    // parser/TCS.g:488:868: 
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
              _beforeSeqEl("E0DCF6CDE4D34F1EC3A411DE913200216A684158");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_primitivetemplate1927); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D598F1C3A411DEAD8E00216A684158");
            }
            // parser/TCS.g:489:157: (temp= textblockdefinition_textblockdefinition )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // parser/TCS.g:489:159: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_primitivetemplate1935);
                    temp=textblockdefinition_textblockdefinition();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "textBlockDefinition", temp);
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
    // $ANTLR end "tcs_primitivetemplate"


    // $ANTLR start "tcs_enumerationtemplate"
    // parser/TCS.g:497:1: tcs_enumerationtemplate returns [Object ret2] : ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_enumerationtemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumerationTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:502:3: ( ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:503:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:503:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:503:4: 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D809F0C3A411DEA01400216A684158");
            }
            match(input,106,FOLLOW_106_in_tcs_enumerationtemplate1980); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D809F1C3A411DEC4C400216A684158");
            }
            pushFollow(FOLLOW_reference_in_tcs_enumerationtemplate1983);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4D809F7C3A411DEC94B00216A684158");
            }
            // parser/TCS.g:503:249: ( ( 'auto' ) | )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==110) ) {
                alt28=1;
            }
            else if ( (LA28_0==SEMI||LA28_0==COLON) ) {
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
                    // parser/TCS.g:503:250: ( 'auto' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:503:266: ( 'auto' )
                    // parser/TCS.g:503:267: 'auto'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D809F5C3A411DEBC8500216A684158");
                    }
                    match(input,110,FOLLOW_110_in_tcs_enumerationtemplate1993); if (state.failed) return ret2;
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
                    // parser/TCS.g:503:422: 
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
              _beforeSeqEl("E0DCF6CDE4DA53E8C3A411DEA68500216A684158");
            }
            // parser/TCS.g:504:77: ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==COLON) ) {
                alt31=1;
            }
            else if ( (LA31_0==SEMI) ) {
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
                    // parser/TCS.g:504:78: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:504:94: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    // parser/TCS.g:504:95: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4DA53E4C3A411DE860700216A684158");
                    }
                    // parser/TCS.g:504:154: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    // parser/TCS.g:504:155: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    {
                    // parser/TCS.g:504:155: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    // parser/TCS.g:504:156: COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D809FBC3A411DEB2A800216A684158");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_enumerationtemplate2021); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4DA53E1C3A411DEAD9C00216A684158");
                    }
                    // parser/TCS.g:504:297: ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) )
                    // parser/TCS.g:504:298: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    {
                    // parser/TCS.g:504:298: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    // parser/TCS.g:504:299: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4D80A00C3A411DEBABE00216A684158");
                    }
                    // parser/TCS.g:504:358: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==SHARP) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // parser/TCS.g:504:360: temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )*
                            {
                            pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2032);
                            temp=tcs_enumliteralmapping();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mappings", temp);
                            }
                            // parser/TCS.g:504:426: ( ( COMA ) temp= tcs_enumliteralmapping )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==COMA) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // parser/TCS.g:504:427: ( COMA ) temp= tcs_enumliteralmapping
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:504:444: ( COMA )
                            	    // parser/TCS.g:504:445: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDE4D809FDC3A411DEC40000216A684158");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_enumerationtemplate2041); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2049);
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
                            	    break loop29;
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
                      _beforeSeqEl("E0DCF6CDE4DA53E2C3A411DEA2DB00216A684158");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate2064); if (state.failed) return ret2;
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
                    // parser/TCS.g:504:766: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:504:782: ( SEMI )
                    // parser/TCS.g:504:783: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4DA53E6C3A411DEB59E00216A684158");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate2081); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDE4DA53EBC3A411DEBB8700216A684158");
            }
            // parser/TCS.g:505:76: (temp= textblockdefinition_textblockdefinition )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // parser/TCS.g:505:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_enumerationtemplate2095);
                    temp=textblockdefinition_textblockdefinition();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "textBlockDefinition", temp);
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
    // $ANTLR end "tcs_enumerationtemplate"


    // $ANTLR start "tcs_enumliteralmapping"
    // parser/TCS.g:513:1: tcs_enumliteralmapping returns [Object ret2] : ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) ) ;
    public final Object tcs_enumliteralmapping() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:518:3: ( ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) ) )
            // parser/TCS.g:519:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) )
            {
            // parser/TCS.g:519:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) )
            // parser/TCS.g:519:4: (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4DCC4E1C3A411DE864500216A684158");
            }
            // parser/TCS.g:519:63: (temp= tcs_enumliteralval )
            // parser/TCS.g:519:65: temp= tcs_enumliteralval
            {
            pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping2144);
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
              _beforeSeqEl("E0DCF6CDE4DCC4E2C3A411DECD9500216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_enumliteralmapping2151); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4DCC4E4C3A411DE9B1700216A684158");
            }
            // parser/TCS.g:519:280: (temp= tcs_literalref )
            // parser/TCS.g:519:282: temp= tcs_literalref
            {
            pushFollow(FOLLOW_tcs_literalref_in_tcs_enumliteralmapping2159);
            temp=tcs_literalref();

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
    // parser/TCS.g:527:1: tcs_classtemplate returns [Object ret2] : ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_classtemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:532:3: ( ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:533:3: ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:533:3: ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:533:4: 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4DCC4E8C3A411DEC3E100216A684158");
            }
            match(input,61,FOLLOW_61_in_tcs_classtemplate2202); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4DF35E0C3A411DE944000216A684158");
            }
            pushFollow(FOLLOW_reference_in_tcs_classtemplate2205);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4E63AD9C3A411DEBA9F00216A684158");
            }
            // parser/TCS.g:533:238: ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==102) ) {
                alt47=1;
            }
            else if ( (LA47_0==LPAREN||LA47_0==SEMI||LA47_0==COLON||LA47_0==SHARP||LA47_0==57||LA47_0==60||LA47_0==68||LA47_0==91||LA47_0==103||LA47_0==105||LA47_0==119||LA47_0==121||LA47_0==123) ) {
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
                    // parser/TCS.g:533:239: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:533:255: ( 'referenceOnly' )
                    // parser/TCS.g:533:256: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4DF35E4C3A411DE8A7000216A684158");
                    }
                    match(input,102,FOLLOW_102_in_tcs_classtemplate2215); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:533:426: ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:533:442: ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) )
                    // parser/TCS.g:533:443: ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4DF35EDC3A411DE9C0A00216A684158");
                    }
                    // parser/TCS.g:533:503: ( ( SHARP (temp= identifier ) ) | )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==SHARP) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==LPAREN||LA33_0==SEMI||LA33_0==COLON||LA33_0==57||LA33_0==60||LA33_0==68||LA33_0==91||LA33_0==103||LA33_0==105||LA33_0==119||LA33_0==121||LA33_0==123) ) {
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
                            // parser/TCS.g:533:504: ( SHARP (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:533:520: ( SHARP (temp= identifier ) )
                            // parser/TCS.g:533:521: SHARP (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35E9C3A411DEAF3500216A684158");
                            }
                            match(input,SHARP,FOLLOW_SHARP_in_tcs_classtemplate2235); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35EBC3A411DE940200216A684158");
                            }
                            // parser/TCS.g:533:662: (temp= identifier )
                            // parser/TCS.g:533:664: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_classtemplate2243);
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
                            // parser/TCS.g:533:748: 
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
                      _beforeSeqEl("E0DCF6CDE4DF35F9C3A411DE85CD00216A684158");
                    }
                    // parser/TCS.g:534:77: ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==LPAREN) ) {
                        int LA34_1 = input.LA(2);

                        if ( (LA34_1==85) ) {
                            alt34=2;
                        }
                        else if ( (LA34_1==109) ) {
                            alt34=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 34, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA34_0==SEMI||LA34_0==COLON||LA34_0==57||LA34_0==60||LA34_0==68||LA34_0==91||LA34_0==103||LA34_0==105||LA34_0==119||LA34_0==121||LA34_0==123) ) {
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
                            // parser/TCS.g:534:78: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:534:94: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:534:95: LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35F1C3A411DE9B7700216A684158");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2269); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35F2C3A411DECCD900216A684158");
                            }
                            match(input,109,FOLLOW_109_in_tcs_classtemplate2273); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35F3C3A411DEC0E200216A684158");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2277); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35F6C3A411DE9F6400216A684158");
                            }
                            // parser/TCS.g:534:405: (temp= stringSymbol )
                            // parser/TCS.g:534:407: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2285);
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
                              _beforeSeqEl("E0DCF6CDE4DF35F7C3A411DECDA100216A684158");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2292); if (state.failed) return ret2;
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
                            // parser/TCS.g:534:584: 
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
                      _beforeSeqEl("E0DCF6CDE4DF3605C3A411DEB69C00216A684158");
                    }
                    // parser/TCS.g:535:77: ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==LPAREN) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==SEMI||LA35_0==COLON||LA35_0==57||LA35_0==60||LA35_0==68||LA35_0==91||LA35_0==103||LA35_0==105||LA35_0==119||LA35_0==121||LA35_0==123) ) {
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
                            // parser/TCS.g:535:78: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:535:94: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:535:95: LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35FDC3A411DE990D00216A684158");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2316); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35FEC3A411DE961F00216A684158");
                            }
                            match(input,85,FOLLOW_85_in_tcs_classtemplate2320); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF35FFC3A411DEA51500216A684158");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2324); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF3602C3A411DEB95400216A684158");
                            }
                            // parser/TCS.g:535:407: (temp= stringSymbol )
                            // parser/TCS.g:535:409: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2332);
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
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4DF3603C3A411DE927E00216A684158");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2339); if (state.failed) return ret2;
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
                            // parser/TCS.g:535:588: 
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
                      _beforeSeqEl("E0DCF6CDE4E17FD2C3A411DE85B800216A684158");
                    }
                    // parser/TCS.g:536:77: ( ( 'multi' ) | )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==60) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==SEMI||LA36_0==COLON||LA36_0==57||LA36_0==68||LA36_0==91||LA36_0==103||LA36_0==105||LA36_0==119||LA36_0==121||LA36_0==123) ) {
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
                            // parser/TCS.g:536:78: ( 'multi' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:536:94: ( 'multi' )
                            // parser/TCS.g:536:95: 'multi'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E17FD0C3A411DE870100216A684158");
                            }
                            match(input,60,FOLLOW_60_in_tcs_classtemplate2362); if (state.failed) return ret2;
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
                            // parser/TCS.g:536:249: 
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
                      _beforeSeqEl("E0DCF6CDE4E17FD8C3A411DEBF4000216A684158");
                    }
                    // parser/TCS.g:537:77: ( ( 'main' ) | )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==123) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==SEMI||LA37_0==COLON||LA37_0==57||LA37_0==68||LA37_0==91||LA37_0==103||LA37_0==105||LA37_0==119||LA37_0==121) ) {
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
                            // parser/TCS.g:537:78: ( 'main' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:537:94: ( 'main' )
                            // parser/TCS.g:537:95: 'main'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E17FD6C3A411DE8CF700216A684158");
                            }
                            match(input,123,FOLLOW_123_in_tcs_classtemplate2386); if (state.failed) return ret2;
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
                            // parser/TCS.g:537:247: 
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
                      _beforeSeqEl("E0DCF6CDE4E17FE4C3A411DE8C0100216A684158");
                    }
                    // parser/TCS.g:538:77: ( ( ( ( 'deep' ) | ) 'abstract' ) | )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==57||LA39_0==91) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==SEMI||LA39_0==COLON||LA39_0==68||LA39_0==103||LA39_0==105||LA39_0==119||LA39_0==121) ) {
                        alt39=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // parser/TCS.g:538:78: ( ( ( 'deep' ) | ) 'abstract' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:538:94: ( ( ( 'deep' ) | ) 'abstract' )
                            // parser/TCS.g:538:95: ( ( 'deep' ) | ) 'abstract'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E17FE1C3A411DE9A8D00216A684158");
                            }
                            // parser/TCS.g:538:155: ( ( 'deep' ) | )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==57) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==91) ) {
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
                                    // parser/TCS.g:538:156: ( 'deep' )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:538:172: ( 'deep' )
                                    // parser/TCS.g:538:173: 'deep'
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDE4E17FDFC3A411DE863500216A684158");
                                    }
                                    match(input,57,FOLLOW_57_in_tcs_classtemplate2416); if (state.failed) return ret2;
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
                                    // parser/TCS.g:538:325: 
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
                              _beforeSeqEl("E0DCF6CDE4E17FE2C3A411DE99B800216A684158");
                            }
                            match(input,91,FOLLOW_91_in_tcs_classtemplate2434); if (state.failed) return ret2;
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
                            // parser/TCS.g:539:177: 
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
                      _beforeSeqEl("E0DCF6CDE4E3F0D6C3A411DECE2700216A684158");
                    }
                    // parser/TCS.g:540:77: ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==103) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==SEMI||LA41_0==COLON||LA41_0==68||LA41_0==105||LA41_0==119||LA41_0==121) ) {
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
                            // parser/TCS.g:540:78: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:540:94: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            // parser/TCS.g:540:95: 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E17FE8C3A411DE916C00216A684158");
                            }
                            match(input,103,FOLLOW_103_in_tcs_classtemplate2458); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E3F0D4C3A411DEB5E500216A684158");
                            }
                            // parser/TCS.g:540:242: ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==LPAREN) ) {
                                alt40=1;
                            }
                            else if ( (LA40_0==SEMI||LA40_0==COLON||LA40_0==68||LA40_0==105||LA40_0==119||LA40_0==121) ) {
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
                                    // parser/TCS.g:540:243: ( LPAREN (temp= identifier ) RPAREN )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:540:259: ( LPAREN (temp= identifier ) RPAREN )
                                    // parser/TCS.g:540:260: LPAREN (temp= identifier ) RPAREN
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDE4E17FECC3A411DE9E6900216A684158");
                                    }
                                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2468); if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDE4E3F0D1C3A411DE83F900216A684158");
                                    }
                                    // parser/TCS.g:540:402: (temp= identifier )
                                    // parser/TCS.g:540:404: temp= identifier
                                    {
                                    pushFollow(FOLLOW_identifier_in_tcs_classtemplate2476);
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
                                      _beforeSeqEl("E0DCF6CDE4E3F0D2C3A411DE8E9600216A684158");
                                    }
                                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2483); if (state.failed) return ret2;
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
                                    // parser/TCS.g:540:644: 
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
                            // parser/TCS.g:541:94: 
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
                      _beforeSeqEl("E0DCF6CDE4E3F0E3C3A411DE94B100216A684158");
                    }
                    // parser/TCS.g:542:77: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==119) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==SEMI||LA43_0==COLON||LA43_0==68||LA43_0==105||LA43_0==121) ) {
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
                            // parser/TCS.g:542:78: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:542:94: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            // parser/TCS.g:542:95: 'context' ( ( (temp= tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E3F0DAC3A411DEC85800216A684158");
                            }
                            match(input,119,FOLLOW_119_in_tcs_classtemplate2521); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E3F0E1C3A411DE925300216A684158");
                            }
                            // parser/TCS.g:542:239: ( ( (temp= tcs_contexttags ) ) | )
                            int alt42=2;
                            int LA42_0 = input.LA(1);

                            if ( (LA42_0==LPAREN) ) {
                                alt42=1;
                            }
                            else if ( (LA42_0==SEMI||LA42_0==COLON||LA42_0==68||LA42_0==105||LA42_0==121) ) {
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
                                    // parser/TCS.g:542:240: ( (temp= tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:542:256: ( (temp= tcs_contexttags ) )
                                    // parser/TCS.g:542:257: (temp= tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDE4E3F0DFC3A411DEADB800216A684158");
                                    }
                                    // parser/TCS.g:542:316: (temp= tcs_contexttags )
                                    // parser/TCS.g:542:318: temp= tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_tcs_contexttags_in_tcs_classtemplate2534);
                                    temp=tcs_contexttags();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "contextTags", temp);
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
                                    // parser/TCS.g:542:414: 
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
                              setProperty(ret, "isContext", java.lang.Boolean.TRUE);
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // parser/TCS.g:543:91: 
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
                      _beforeSeqEl("E0DCF6CDE4E63AC3C3A411DEC0F900216A684158");
                    }
                    // parser/TCS.g:544:77: ( ( 'addToContext' ) | )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==68) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==SEMI||LA44_0==COLON||LA44_0==105||LA44_0==121) ) {
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
                            // parser/TCS.g:544:78: ( 'addToContext' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:544:94: ( 'addToContext' )
                            // parser/TCS.g:544:95: 'addToContext'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E63AC1C3A411DEB19B00216A684158");
                            }
                            match(input,68,FOLLOW_68_in_tcs_classtemplate2574); if (state.failed) return ret2;
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
                            // parser/TCS.g:544:263: 
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
                      _beforeSeqEl("E0DCF6CDE4E63AC9C3A411DEB6CF00216A684158");
                    }
                    // parser/TCS.g:545:77: ( ( 'nonPrimary' ) | )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==105) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==SEMI||LA45_0==COLON||LA45_0==121) ) {
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
                            // parser/TCS.g:545:78: ( 'nonPrimary' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:545:94: ( 'nonPrimary' )
                            // parser/TCS.g:545:95: 'nonPrimary'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E63AC7C3A411DEC4F400216A684158");
                            }
                            match(input,105,FOLLOW_105_in_tcs_classtemplate2598); if (state.failed) return ret2;
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
                            // parser/TCS.g:545:259: 
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
                      _beforeSeqEl("E0DCF6CDE4E63AD7C3A411DEAB4C00216A684158");
                    }
                    // parser/TCS.g:546:77: ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==121) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==SEMI||LA46_0==COLON) ) {
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
                            // parser/TCS.g:546:78: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:546:94: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                            // parser/TCS.g:546:95: 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E63ACDC3A411DE8BAC00216A684158");
                            }
                            match(input,121,FOLLOW_121_in_tcs_classtemplate2622); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E63AD5C3A411DE8BC700216A684158");
                            }
                            // parser/TCS.g:546:237: ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                            // parser/TCS.g:546:238: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                            {
                            // parser/TCS.g:546:238: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                            // parser/TCS.g:546:239: COLON ( ( (temp= tcs_sequence ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E63ACEC3A411DEA01D00216A684158");
                            }
                            match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2629); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E63AD3C3A411DEBDDC00216A684158");
                            }
                            // parser/TCS.g:546:380: ( ( (temp= tcs_sequence ) ) )
                            // parser/TCS.g:546:381: ( (temp= tcs_sequence ) )
                            {
                            // parser/TCS.g:546:381: ( (temp= tcs_sequence ) )
                            // parser/TCS.g:546:382: (temp= tcs_sequence )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4E63AD0C3A411DEC84400216A684158");
                            }
                            // parser/TCS.g:546:441: (temp= tcs_sequence )
                            // parser/TCS.g:546:443: temp= tcs_sequence
                            {
                            pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2640);
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
                            // parser/TCS.g:546:575: 
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
                      setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E0DCF6CDE4E8ABCAC3A411DEBEA300216A684158");
            }
            // parser/TCS.g:548:77: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==COLON) ) {
                alt48=1;
            }
            else if ( (LA48_0==SEMI) ) {
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
                    // parser/TCS.g:548:78: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:548:94: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // parser/TCS.g:548:95: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4E8ABC6C3A411DEAEC600216A684158");
                    }
                    // parser/TCS.g:548:154: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // parser/TCS.g:548:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // parser/TCS.g:548:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // parser/TCS.g:548:156: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4E63ADDC3A411DECC9D00216A684158");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2682); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4E8ABC3C3A411DE9F3A00216A684158");
                    }
                    // parser/TCS.g:548:297: ( ( (temp= tcs_sequence ) ) )
                    // parser/TCS.g:548:298: ( (temp= tcs_sequence ) )
                    {
                    // parser/TCS.g:548:298: ( (temp= tcs_sequence ) )
                    // parser/TCS.g:548:299: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4E8ABC0C3A411DEA74B00216A684158");
                    }
                    // parser/TCS.g:548:358: (temp= tcs_sequence )
                    // parser/TCS.g:548:360: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2693);
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
                      _beforeSeqEl("E0DCF6CDE4E8ABC4C3A411DEC62C00216A684158");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2703); if (state.failed) return ret2;
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
                    // parser/TCS.g:548:575: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:548:591: ( SEMI )
                    // parser/TCS.g:548:592: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4E8ABC8C3A411DE8A9E00216A684158");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2720); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDE4E8ABCDC3A411DEA8B900216A684158");
            }
            // parser/TCS.g:549:76: (temp= textblockdefinition_textblockdefinition )?
            int alt49=2;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // parser/TCS.g:549:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_classtemplate2734);
                    temp=textblockdefinition_textblockdefinition();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "textBlockDefinition", temp);
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
    // $ANTLR end "tcs_classtemplate"


    // $ANTLR start "tcs_operatortemplate"
    // parser/TCS.g:557:1: tcs_operatortemplate returns [Object ret2] : ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_operatortemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:562:3: ( ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:563:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:563:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:563:4: 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CC0C3A411DE882400216A684158");
            }
            match(input,75,FOLLOW_75_in_tcs_operatortemplate2779); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CC1C3A411DEB29300216A684158");
            }
            pushFollow(FOLLOW_reference_in_tcs_operatortemplate2782);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CC2C3A411DEC4E600216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_operatortemplate2787); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CC3C3A411DE8FAF00216A684158");
            }
            match(input,62,FOLLOW_62_in_tcs_operatortemplate2791); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CC4C3A411DEA15500216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2795); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CC7C3A411DEA0E600216A684158");
            }
            // parser/TCS.g:563:493: (temp= identifier (temp= identifier )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==NAME) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // parser/TCS.g:563:495: temp= identifier (temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2803);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);
                    }
                    // parser/TCS.g:563:611: (temp= identifier )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==NAME) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // parser/TCS.g:563:613: temp= identifier
                    	    {
                    	    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2811);
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
                    	    break loop50;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CC8C3A411DE865F00216A684158");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2823); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CC9C3A411DEBA8A00216A684158");
            }
            match(input,88,FOLLOW_88_in_tcs_operatortemplate2827); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CCAC3A411DE8A4200216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2831); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EB1CCCC3A411DEBCAC00216A684158");
            }
            // parser/TCS.g:563:1052: (temp= tcs_propertyreference )
            // parser/TCS.g:563:1054: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2839);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "storeLeftSideTo", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4ED66B7C3A411DEAED500216A684158");
            }
            // parser/TCS.g:563:1202: ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==COMA) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==85||LA52_1==96||LA52_1==109) ) {
                    alt52=2;
                }
                else if ( (LA52_1==82) ) {
                    alt52=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA52_0==RPAREN) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // parser/TCS.g:563:1203: ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:563:1219: ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) )
                    // parser/TCS.g:563:1220: COMA 'storeOpTo' EQ (temp= tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66B1C3A411DEC29B00216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2852); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66B2C3A411DE807400216A684158");
                    }
                    match(input,82,FOLLOW_82_in_tcs_operatortemplate2856); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66B3C3A411DE86F600216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2860); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66B5C3A411DEC0FC00216A684158");
                    }
                    // parser/TCS.g:563:1525: (temp= tcs_propertyreference )
                    // parser/TCS.g:563:1527: temp= tcs_propertyreference
                    {
                    pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2868);
                    temp=tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "storeOperatorTo", temp);
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
                    // parser/TCS.g:563:1633: 
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
              _beforeSeqEl("E0DCF6CDE4ED66C1C3A411DE838600216A684158");
            }
            // parser/TCS.g:564:77: ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==COMA) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==85||LA53_1==109) ) {
                    alt53=2;
                }
                else if ( (LA53_1==96) ) {
                    alt53=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA53_0==RPAREN) ) {
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
                    // parser/TCS.g:564:78: ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:564:94: ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) )
                    // parser/TCS.g:564:95: COMA 'storeRightTo' EQ (temp= tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66BBC3A411DEB89C00216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2894); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66BCC3A411DE9FD600216A684158");
                    }
                    match(input,96,FOLLOW_96_in_tcs_operatortemplate2898); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66BDC3A411DE910900216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2902); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66BFC3A411DEB19400216A684158");
                    }
                    // parser/TCS.g:564:403: (temp= tcs_propertyreference )
                    // parser/TCS.g:564:405: temp= tcs_propertyreference
                    {
                    pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2910);
                    temp=tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "storeRightSideTo", temp);
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
                    // parser/TCS.g:564:512: 
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
              _beforeSeqEl("E0DCF6CDE4ED66CCC3A411DEBFC000216A684158");
            }
            // parser/TCS.g:565:77: ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==COMA) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==85) ) {
                    alt54=2;
                }
                else if ( (LA54_1==109) ) {
                    alt54=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA54_0==RPAREN) ) {
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
                    // parser/TCS.g:565:78: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:565:94: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:565:95: COMA 'disambiguate' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66C5C3A411DE80F200216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2936); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66C6C3A411DE9A8700216A684158");
                    }
                    match(input,109,FOLLOW_109_in_tcs_operatortemplate2940); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66C7C3A411DEC10400216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2944); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66CAC3A411DE8F6500216A684158");
                    }
                    // parser/TCS.g:565:403: (temp= stringSymbol )
                    // parser/TCS.g:565:405: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate2952);
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
                    // parser/TCS.g:565:499: 
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
              _beforeSeqEl("E0DCF6CDE4EFD7B0C3A411DEBA4C00216A684158");
            }
            // parser/TCS.g:566:77: ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==COMA) ) {
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
                    // parser/TCS.g:566:78: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:566:94: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:566:95: COMA 'disambiguateV3' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66D0C3A411DEA3EF00216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2978); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66D1C3A411DE878F00216A684158");
                    }
                    match(input,85,FOLLOW_85_in_tcs_operatortemplate2982); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66D2C3A411DE8DCB00216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2986); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4ED66D5C3A411DEAED800216A684158");
                    }
                    // parser/TCS.g:566:405: (temp= stringSymbol )
                    // parser/TCS.g:566:407: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate2994);
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
                    // parser/TCS.g:566:503: 
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
              _beforeSeqEl("E0DCF6CDE4EFD7B1C3A411DE849F00216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_operatortemplate3014); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4EFD7C5C3A411DEA63000216A684158");
            }
            // parser/TCS.g:567:160: ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==102) ) {
                alt58=1;
            }
            else if ( (LA58_0==SEMI||LA58_0==COLON||LA58_0==119) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // parser/TCS.g:567:161: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:567:177: ( 'referenceOnly' )
                    // parser/TCS.g:567:178: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4EFD7B5C3A411DE9A8100216A684158");
                    }
                    match(input,102,FOLLOW_102_in_tcs_operatortemplate3024); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:567:348: ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:567:364: ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) )
                    // parser/TCS.g:567:365: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4EFD7C3C3A411DEA52600216A684158");
                    }
                    // parser/TCS.g:567:425: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==119) ) {
                        alt57=1;
                    }
                    else if ( (LA57_0==SEMI||LA57_0==COLON) ) {
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
                            // parser/TCS.g:567:426: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:567:442: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            // parser/TCS.g:567:443: 'context' ( ( (temp= tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4EFD7BAC3A411DE96F000216A684158");
                            }
                            match(input,119,FOLLOW_119_in_tcs_operatortemplate3043); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE4EFD7C1C3A411DE88DB00216A684158");
                            }
                            // parser/TCS.g:567:587: ( ( (temp= tcs_contexttags ) ) | )
                            int alt56=2;
                            int LA56_0 = input.LA(1);

                            if ( (LA56_0==LPAREN) ) {
                                alt56=1;
                            }
                            else if ( (LA56_0==SEMI||LA56_0==COLON) ) {
                                alt56=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ret2;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 56, 0, input);

                                throw nvae;
                            }
                            switch (alt56) {
                                case 1 :
                                    // parser/TCS.g:567:588: ( (temp= tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:567:604: ( (temp= tcs_contexttags ) )
                                    // parser/TCS.g:567:605: (temp= tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDE4EFD7BFC3A411DEADE000216A684158");
                                    }
                                    // parser/TCS.g:567:664: (temp= tcs_contexttags )
                                    // parser/TCS.g:567:666: temp= tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_tcs_contexttags_in_tcs_operatortemplate3056);
                                    temp=tcs_contexttags();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "contextTags", temp);
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
                                    // parser/TCS.g:567:762: 
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
                              setProperty(ret, "isContext", java.lang.Boolean.TRUE);
                            }
                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // parser/TCS.g:568:91: 
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

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E0DCF6CDE4EFD7D5C3A411DEC08400216A684158");
            }
            // parser/TCS.g:570:77: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==COLON) ) {
                alt59=1;
            }
            else if ( (LA59_0==SEMI) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // parser/TCS.g:570:78: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:570:94: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // parser/TCS.g:570:95: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4EFD7D1C3A411DEAAC000216A684158");
                    }
                    // parser/TCS.g:570:154: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // parser/TCS.g:570:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // parser/TCS.g:570:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // parser/TCS.g:570:156: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4EFD7C9C3A411DE923900216A684158");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_operatortemplate3107); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4EFD7CEC3A411DE89C100216A684158");
                    }
                    // parser/TCS.g:570:297: ( ( (temp= tcs_sequence ) ) )
                    // parser/TCS.g:570:298: ( (temp= tcs_sequence ) )
                    {
                    // parser/TCS.g:570:298: ( (temp= tcs_sequence ) )
                    // parser/TCS.g:570:299: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4EFD7CBC3A411DE961C00216A684158");
                    }
                    // parser/TCS.g:570:358: (temp= tcs_sequence )
                    // parser/TCS.g:570:360: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_operatortemplate3118);
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
                      _beforeSeqEl("E0DCF6CDE4EFD7CFC3A411DEBB1200216A684158");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate3128); if (state.failed) return ret2;
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
                    // parser/TCS.g:570:569: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:570:585: ( SEMI )
                    // parser/TCS.g:570:586: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE4EFD7D3C3A411DEC3B500216A684158");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate3145); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDE4EFD7D8C3A411DEB8CF00216A684158");
            }
            // parser/TCS.g:571:76: (temp= textblockdefinition_textblockdefinition )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // parser/TCS.g:571:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_operatortemplate3159);
                    temp=textblockdefinition_textblockdefinition();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "textBlockDefinition", temp);
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
    // $ANTLR end "tcs_operatortemplate"


    // $ANTLR start "tcs_functiontemplate"
    // parser/TCS.g:579:1: tcs_functiontemplate returns [Object ret2] : ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) ;
    public final Object tcs_functiontemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:584:3: ( ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) )
            // parser/TCS.g:585:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            {
            // parser/TCS.g:585:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            // parser/TCS.g:585:4: 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F221A2C3A411DE853600216A684158");
            }
            match(input,79,FOLLOW_79_in_tcs_functiontemplate3204); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F221A4C3A411DECF1700216A684158");
            }
            // parser/TCS.g:585:148: (temp= identifier )
            // parser/TCS.g:585:150: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functiontemplate3211);
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
              _beforeSeqEl("E0DCF6CDE4F221A5C3A411DE823100216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_functiontemplate3218); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F221A6C3A411DECC5D00216A684158");
            }
            pushFollow(FOLLOW_reference_in_tcs_functiontemplate3222);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F221A7C3A411DE9E7A00216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_functiontemplate3227); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F221B0C3A411DEC24200216A684158");
            }
            // parser/TCS.g:585:538: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            // parser/TCS.g:585:539: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            {
            // parser/TCS.g:585:539: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            // parser/TCS.g:585:540: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F221A8C3A411DE8D5900216A684158");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_functiontemplate3235); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F221ADC3A411DE999800216A684158");
            }
            // parser/TCS.g:585:681: ( ( (temp= tcs_sequence ) ) )
            // parser/TCS.g:585:682: ( (temp= tcs_sequence ) )
            {
            // parser/TCS.g:585:682: ( (temp= tcs_sequence ) )
            // parser/TCS.g:585:683: (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F221AAC3A411DE887500216A684158");
            }
            // parser/TCS.g:585:742: (temp= tcs_sequence )
            // parser/TCS.g:585:744: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_functiontemplate3246);
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
              _beforeSeqEl("E0DCF6CDE4F221AEC3A411DEA73400216A684158");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_functiontemplate3256); if (state.failed) return ret2;
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
    // $ANTLR end "tcs_functiontemplate"


    // $ANTLR start "tcs_contexttags"
    // parser/TCS.g:593:1: tcs_contexttags returns [Object ret2] : ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) ;
    public final Object tcs_contexttags() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ContextTags");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:598:3: ( ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) )
            // parser/TCS.g:599:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            {
            // parser/TCS.g:599:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            // parser/TCS.g:599:4: LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F492A2C3A411DEC2F400216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_contexttags3301); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F492A7C3A411DECC7D00216A684158");
            }
            // parser/TCS.g:599:146: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==NAME) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // parser/TCS.g:599:148: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_contexttags3309);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tags", temp);
                    }
                    // parser/TCS.g:599:198: ( ( COMA ) temp= identifier )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==COMA) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // parser/TCS.g:599:199: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:599:216: ( COMA )
                    	    // parser/TCS.g:599:217: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDE4F492A4C3A411DEB29300216A684158");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_tcs_contexttags3318); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_tcs_contexttags3326);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "tags", temp);
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
              _beforeSeqEl("E0DCF6CDE4F492A8C3A411DE9E5400216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_contexttags3338); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "tcs_contexttags"


    // $ANTLR start "tcs_sequence__impl"
    // parser/TCS.g:607:1: tcs_sequence__impl returns [Object ret2] : ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequence__impl() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Sequence");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:612:3: ( ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // parser/TCS.g:613:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // parser/TCS.g:613:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // parser/TCS.g:613:4: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4F703A1C3A411DE95F700216A684158");
            }
            // parser/TCS.g:613:63: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=NAME && LA64_0<=STRING)||LA64_0==LPAREN||LA64_0==RARROW||LA64_0==LT||LA64_0==LSQUARE||LA64_0==DLSQUARE||(LA64_0>=DOLLAR && LA64_0<=DLCURLY)||(LA64_0>=48 && LA64_0<=132)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // parser/TCS.g:613:65: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3383);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // parser/TCS.g:613:128: (temp= tcs_sequenceelement )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( ((LA63_0>=NAME && LA63_0<=STRING)||LA63_0==LPAREN||LA63_0==RARROW||LA63_0==LT||LA63_0==LSQUARE||LA63_0==DLSQUARE||(LA63_0>=DOLLAR && LA63_0<=DLCURLY)||(LA63_0>=48 && LA63_0<=132)) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // parser/TCS.g:613:130: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3391);
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
                    	    break loop63;
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
    // $ANTLR end "tcs_sequence__impl"


    // $ANTLR start "tcs_sequence"
    // parser/TCS.g:621:1: tcs_sequence returns [Object ret2] : (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) ) ;
    public final Object tcs_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:622:3: ( (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) ) )
            // parser/TCS.g:623:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )
            {
            // parser/TCS.g:623:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // parser/TCS.g:623:4: ret= tcs_sequence__impl
                    {
                    pushFollow(FOLLOW_tcs_sequence__impl_in_tcs_sequence3436);
                    ret=tcs_sequence__impl();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:623:27: (ret= tcs_sequenceinalternative )
                    {
                    // parser/TCS.g:623:27: (ret= tcs_sequenceinalternative )
                    // parser/TCS.g:623:28: ret= tcs_sequenceinalternative
                    {
                    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_sequence3441);
                    ret=tcs_sequenceinalternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {

                      ret2=ret;
                       
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              ret2 = ret;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "tcs_sequence"


    // $ANTLR start "tcs_sequenceelement"
    // parser/TCS.g:630:1: tcs_sequenceelement returns [Object ret2] : (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock ) ;
    public final Object tcs_sequenceelement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:631:3: ( (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock ) )
            // parser/TCS.g:632:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock )
            {
            // parser/TCS.g:632:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock )
            int alt66=8;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt66=1;
                }
                break;
            case NAME:
            case RARROW:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
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
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
                {
                alt66=2;
                }
                break;
            case LT:
                {
                alt66=3;
                }
                break;
            case LSQUARE:
                {
                alt66=4;
                }
                break;
            case LPAREN:
                {
                alt66=5;
                }
                break;
            case DLSQUARE:
                {
                alt66=6;
                }
                break;
            case DOLLAR:
                {
                alt66=7;
                }
                break;
            case DLCURLY:
                {
                alt66=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // parser/TCS.g:632:4: ret= tcs_literalref
                    {
                    pushFollow(FOLLOW_tcs_literalref_in_tcs_sequenceelement3470);
                    ret=tcs_literalref();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:633:5: ret= tcs_property
                    {
                    pushFollow(FOLLOW_tcs_property_in_tcs_sequenceelement3478);
                    ret=tcs_property();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:634:5: ret= tcs_customseparator
                    {
                    pushFollow(FOLLOW_tcs_customseparator_in_tcs_sequenceelement3486);
                    ret=tcs_customseparator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:635:5: ret= tcs_block
                    {
                    pushFollow(FOLLOW_tcs_block_in_tcs_sequenceelement3494);
                    ret=tcs_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:636:5: ret= tcs_conditionalelement
                    {
                    pushFollow(FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement3502);
                    ret=tcs_conditionalelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:637:5: ret= tcs_alternative
                    {
                    pushFollow(FOLLOW_tcs_alternative_in_tcs_sequenceelement3510);
                    ret=tcs_alternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:638:5: ret= tcs_functioncall
                    {
                    pushFollow(FOLLOW_tcs_functioncall_in_tcs_sequenceelement3518);
                    ret=tcs_functioncall();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:639:5: ret= tcs_injectoractionsblock
                    {
                    pushFollow(FOLLOW_tcs_injectoractionsblock_in_tcs_sequenceelement3526);
                    ret=tcs_injectoractionsblock();

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
    // parser/TCS.g:646:1: tcs_literalref returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_literalref() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LiteralRef");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:651:3: ( ( (temp= stringSymbol ) ) )
            // parser/TCS.g:652:3: ( (temp= stringSymbol ) )
            {
            // parser/TCS.g:652:3: ( (temp= stringSymbol ) )
            // parser/TCS.g:652:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE4FE0881C3A411DEB61300216A684158");
            }
            // parser/TCS.g:652:63: (temp= stringSymbol )
            // parser/TCS.g:652:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_literalref3560);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5007980C3A411DE857000216A684158");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
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


    // $ANTLR start "tcs_propertyreference"
    // parser/TCS.g:660:1: tcs_propertyreference returns [Object ret2] : ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) ) ;
    public final Object tcs_propertyreference() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PropertyReference");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:665:3: ( ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) ) )
            // parser/TCS.g:666:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) )
            {
            // parser/TCS.g:666:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) )
            // parser/TCS.g:666:4: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE505347EC3A411DEC80200216A684158");
            }
            // parser/TCS.g:666:64: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==NAME||(LA68_0>=48 && LA68_0<=132)) ) {
                alt68=1;
            }
            else if ( (LA68_0==RARROW) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // parser/TCS.g:666:65: ( (temp= identifierOrKeyword ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:666:81: ( (temp= identifierOrKeyword ) )
                    // parser/TCS.g:666:82: (temp= identifierOrKeyword )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5053477C3A411DE824700216A684158");
                    }
                    // parser/TCS.g:666:141: (temp= identifierOrKeyword )
                    // parser/TCS.g:666:143: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_propertyreference3616);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"		  				let result = c.lookupElementExtended(?) in"+"		  				if not (result.oclIsInvalid()) then"+"		  					if(result.oclIsTypeOf(Model::Attribute) or"+"		  							result.oclIsTypeOf(Model::Reference)"+"		  							or result.oclIsTypeOf(Model::StructureField)) then"+"		  						Bag{result}	"+"		  					else 		"+"		  						c.allSupertypes()->prepend(c)->collect("+"		  							st | st.oclAsType(Model::Classifier).typedElements->select("+"		  								te | "+"		  									if te.oclIsTypeOf(Model::AssociationEnd) then"+"		  										te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"		  									else		"+"		  										false "+"		  									endif"+"		  								)->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"		  						)"+"		  					endif "+"		  				else	"+"		  					c.allSupertypes()->prepend(c)->collect("+"		  						st | st.oclAsType(Model::Classifier).typedElements->select("+"		  							te | "+"		  								if te.oclIsTypeOf(Model::AssociationEnd) then"+"		  									te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"		  								else"+"		  									false "+"		  								endif"+"		  							)"+"		  						)->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"		  					) "+"		  				endif"+"		  					");
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
                    // parser/TCS.g:666:1565: ( RARROW (temp= identifierOrKeyword )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:666:1581: ( RARROW (temp= identifierOrKeyword )? )
                    // parser/TCS.g:666:1582: RARROW (temp= identifierOrKeyword )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5053479C3A411DE9AEF00216A684158");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_tcs_propertyreference3632); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE505347CC3A411DE9A3500216A684158");
                    }
                    // parser/TCS.g:666:1724: (temp= identifierOrKeyword )?
                    int alt67=2;
                    alt67 = dfa67.predict(input);
                    switch (alt67) {
                        case 1 :
                            // parser/TCS.g:666:1726: temp= identifierOrKeyword
                            {
                            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_propertyreference3640);
                            temp=identifierOrKeyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "name", temp);
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

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "tcs_propertyreference"


    // $ANTLR start "tcs_property"
    // parser/TCS.g:675:1: tcs_property returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_property() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Property");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:680:3: ( ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) )
            // parser/TCS.g:681:3: ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            {
            // parser/TCS.g:681:3: ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            // parser/TCS.g:681:4: (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE507A571C3A411DEBE7B00216A684158");
            }
            // parser/TCS.g:681:63: (temp= tcs_propertyreference )
            // parser/TCS.g:681:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_property3695);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE507A57DC3A411DECCC500216A684158");
            }
            // parser/TCS.g:681:215: ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==LCURLY) ) {
                alt71=1;
            }
            else if ( (LA71_0==EOF||(LA71_0>=NAME && LA71_0<=STRING)||(LA71_0>=LPAREN && LA71_0<=RPAREN)||(LA71_0>=RCURLY && LA71_0<=COMA)||LA71_0==LT||(LA71_0>=LSQUARE && LA71_0<=RSQUARE)||(LA71_0>=DLSQUARE && LA71_0<=DRSQUARE)||(LA71_0>=DOLLAR && LA71_0<=DLCURLY)||(LA71_0>=48 && LA71_0<=132)) ) {
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
                    // parser/TCS.g:681:216: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:681:232: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    // parser/TCS.g:681:233: LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE507A575C3A411DE97FB00216A684158");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_property3708); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE507A57AC3A411DE979B00216A684158");
                    }
                    // parser/TCS.g:681:375: (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==53||LA70_0==55||LA70_0==58||LA70_0==64||LA70_0==67||LA70_0==78||LA70_0==89||LA70_0==95||LA70_0==100||LA70_0==109||LA70_0==115||LA70_0==120||LA70_0==122||LA70_0==125||LA70_0==131) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // parser/TCS.g:681:377: temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )*
                            {
                            pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property3716);
                            temp=tcs_propertyarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "propertyArgs", temp);
                            }
                            // parser/TCS.g:681:440: ( ( COMA ) temp= tcs_propertyarg )*
                            loop69:
                            do {
                                int alt69=2;
                                int LA69_0 = input.LA(1);

                                if ( (LA69_0==COMA) ) {
                                    alt69=1;
                                }


                                switch (alt69) {
                            	case 1 :
                            	    // parser/TCS.g:681:441: ( COMA ) temp= tcs_propertyarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:681:458: ( COMA )
                            	    // parser/TCS.g:681:459: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDE507A577C3A411DEC94400216A684158");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_property3725); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property3733);
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
                            	    break loop69;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE507A57BC3A411DE997D00216A684158");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_property3745); if (state.failed) return ret2;
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
                    // parser/TCS.g:681:743: 
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
              _beforeSeqEl("E0DCF6CDE507A580C3A411DE95C200216A684158");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // parser/TCS.g:690:1: tcs_customseparator returns [Object ret2] : ( LT (temp= identifier ) GT ) ;
    public final Object tcs_customseparator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CustomSeparator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:695:3: ( ( LT (temp= identifier ) GT ) )
            // parser/TCS.g:696:3: ( LT (temp= identifier ) GT )
            {
            // parser/TCS.g:696:3: ( LT (temp= identifier ) GT )
            // parser/TCS.g:696:4: LT (temp= identifier ) GT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE509EF60C3A411DEAE1600216A684158");
            }
            match(input,LT,FOLLOW_LT_in_tcs_customseparator3803); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE509EF62C3A411DEC73E00216A684158");
            }
            // parser/TCS.g:696:142: (temp= identifier )
            // parser/TCS.g:696:144: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_customseparator3811);
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
              _beforeSeqEl("E0DCF6CDE509EF63C3A411DEBB6A00216A684158");
            }
            match(input,GT,FOLLOW_GT_in_tcs_customseparator3818); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE509EF66C3A411DE95E500216A684158");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // $ANTLR end "tcs_customseparator"


    // $ANTLR start "tcs_block"
    // parser/TCS.g:704:1: tcs_block returns [Object ret2] : ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_block() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:709:3: ( ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) )
            // parser/TCS.g:710:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            {
            // parser/TCS.g:710:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            // parser/TCS.g:710:4: LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE509EF6AC3A411DEC9A000216A684158");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_block3863); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE509EF6CC3A411DEBC9300216A684158");
            }
            // parser/TCS.g:710:147: (temp= tcs_sequence )
            // parser/TCS.g:710:149: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_block3871);
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
              _beforeSeqEl("E0DCF6CDE509EF6DC3A411DEAE7500216A684158");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_block3878); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE509EF79C3A411DE885200216A684158");
            }
            // parser/TCS.g:710:370: ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==LCURLY) ) {
                alt74=1;
            }
            else if ( (LA74_0==EOF||(LA74_0>=NAME && LA74_0<=STRING)||(LA74_0>=LPAREN && LA74_0<=RPAREN)||(LA74_0>=RCURLY && LA74_0<=COMA)||LA74_0==LT||(LA74_0>=LSQUARE && LA74_0<=RSQUARE)||(LA74_0>=DLSQUARE && LA74_0<=DRSQUARE)||(LA74_0>=DOLLAR && LA74_0<=DLCURLY)||(LA74_0>=48 && LA74_0<=132)) ) {
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
                    // parser/TCS.g:710:371: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:710:387: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    // parser/TCS.g:710:388: LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE509EF71C3A411DEC24D00216A684158");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_block3889); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE509EF76C3A411DEA3FD00216A684158");
                    }
                    // parser/TCS.g:710:530: (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( ((LA73_0>=65 && LA73_0<=66)||LA73_0==83||LA73_0==87||LA73_0==113) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // parser/TCS.g:710:532: temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )*
                            {
                            pushFollow(FOLLOW_tcs_blockarg_in_tcs_block3897);
                            temp=tcs_blockarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "blockArgs", temp);
                            }
                            // parser/TCS.g:710:589: ( ( COMA ) temp= tcs_blockarg )*
                            loop72:
                            do {
                                int alt72=2;
                                int LA72_0 = input.LA(1);

                                if ( (LA72_0==COMA) ) {
                                    alt72=1;
                                }


                                switch (alt72) {
                            	case 1 :
                            	    // parser/TCS.g:710:590: ( COMA ) temp= tcs_blockarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:710:607: ( COMA )
                            	    // parser/TCS.g:710:608: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDE509EF73C3A411DEBAE100216A684158");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_block3906); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_blockarg_in_tcs_block3914);
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
                            	    break loop72;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE509EF77C3A411DE947E00216A684158");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_block3926); if (state.failed) return ret2;
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
                    // parser/TCS.g:710:886: 
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
              _beforeSeqEl("E0DCF6CDE509EF7CC3A411DE96A800216A684158");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // parser/TCS.g:719:1: tcs_conditionalelement returns [Object ret2] : ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) ;
    public final Object tcs_conditionalelement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConditionalElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:724:3: ( ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) )
            // parser/TCS.g:725:3: ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            {
            // parser/TCS.g:725:3: ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            // parser/TCS.g:725:4: LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50C6060C3A411DE84FC00216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_conditionalelement3984); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50C6062C3A411DEBAF500216A684158");
            }
            // parser/TCS.g:725:146: (temp= tcs_expression )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==NAME||LA75_0==RARROW||(LA75_0>=48 && LA75_0<=132)) ) {
                alt75=1;
            }
            else if ( (LA75_0==QMARK) ) {
                int LA75_2 = input.LA(2);

                if ( (synpred168_TCS()) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // parser/TCS.g:725:148: temp= tcs_expression
                    {
                    pushFollow(FOLLOW_tcs_expression_in_tcs_conditionalelement3992);
                    temp=tcs_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "condition", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50C6063C3A411DEC5B500216A684158");
            }
            match(input,QMARK,FOLLOW_QMARK_in_tcs_conditionalelement4001); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50C6065C3A411DEC88100216A684158");
            }
            // parser/TCS.g:725:366: (temp= tcs_sequence )
            // parser/TCS.g:725:368: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement4009);
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
              _beforeSeqEl("E0DCF6CDE50C606DC3A411DE965B00216A684158");
            }
            // parser/TCS.g:725:504: ( ( COLON (temp= tcs_sequence ) ) | )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==COLON) ) {
                alt76=1;
            }
            else if ( (LA76_0==RPAREN) ) {
                alt76=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // parser/TCS.g:725:505: ( COLON (temp= tcs_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:725:521: ( COLON (temp= tcs_sequence ) )
                    // parser/TCS.g:725:522: COLON (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE50C6069C3A411DE9F4800216A684158");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_conditionalelement4022); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE50C606BC3A411DEA04C00216A684158");
                    }
                    // parser/TCS.g:725:663: (temp= tcs_sequence )
                    // parser/TCS.g:725:665: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement4030);
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
                    // parser/TCS.g:725:759: 
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
              _beforeSeqEl("E0DCF6CDE50C606EC3A411DE99F600216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_conditionalelement4050); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50C6071C3A411DEA5F800216A684158");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // $ANTLR end "tcs_conditionalelement"


    // $ANTLR start "tcs_alternative"
    // parser/TCS.g:734:1: tcs_alternative returns [Object ret2] : ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) ) ;
    public final Object tcs_alternative() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Alternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:739:3: ( ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) ) )
            // parser/TCS.g:740:3: ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) )
            {
            // parser/TCS.g:740:3: ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) )
            // parser/TCS.g:740:4: DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50C6075C3A411DEBA3700216A684158");
            }
            match(input,DLSQUARE,FOLLOW_DLSQUARE_in_tcs_alternative4095); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50C607AC3A411DEBF3300216A684158");
            }
            // parser/TCS.g:740:148: (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=NAME && LA78_0<=STRING)||LA78_0==LPAREN||LA78_0==RARROW||LA78_0==LT||LA78_0==LSQUARE||(LA78_0>=DLSQUARE && LA78_0<=PIPE)||(LA78_0>=DOLLAR && LA78_0<=DLCURLY)||(LA78_0>=48 && LA78_0<=132)) ) {
                alt78=1;
            }
            else if ( (LA78_0==DRSQUARE) ) {
                int LA78_2 = input.LA(2);

                if ( (synpred171_TCS()) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // parser/TCS.g:740:150: temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4103);
                    temp=tcs_sequenceinalternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sequences", temp);
                    }
                    // parser/TCS.g:740:220: ( ( PIPE ) temp= tcs_sequenceinalternative )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==PIPE) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // parser/TCS.g:740:221: ( PIPE ) temp= tcs_sequenceinalternative
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:740:238: ( PIPE )
                    	    // parser/TCS.g:740:239: PIPE
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDE50C6077C3A411DE9B3700216A684158");
                    	    }
                    	    match(input,PIPE,FOLLOW_PIPE_in_tcs_alternative4112); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4120);
                    	    temp=tcs_sequenceinalternative();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "sequences", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop77;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50ED160C3A411DEB2AA00216A684158");
            }
            match(input,DRSQUARE,FOLLOW_DRSQUARE_in_tcs_alternative4132); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50ED166C3A411DE852100216A684158");
            }
            // parser/TCS.g:740:574: ( ( STAR ) | )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==STAR) ) {
                alt79=1;
            }
            else if ( (LA79_0==EOF||(LA79_0>=NAME && LA79_0<=STRING)||(LA79_0>=LPAREN && LA79_0<=RPAREN)||(LA79_0>=RCURLY && LA79_0<=COMA)||LA79_0==LT||(LA79_0>=LSQUARE && LA79_0<=RSQUARE)||(LA79_0>=DLSQUARE && LA79_0<=DRSQUARE)||(LA79_0>=DOLLAR && LA79_0<=DLCURLY)||(LA79_0>=48 && LA79_0<=132)) ) {
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
                    // parser/TCS.g:740:575: ( STAR )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:740:591: ( STAR )
                    // parser/TCS.g:740:592: STAR
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE50ED164C3A411DEB9BE00216A684158");
                    }
                    match(input,STAR,FOLLOW_STAR_in_tcs_alternative4143); if (state.failed) return ret2;
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
                    // parser/TCS.g:740:745: 
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
              _beforeSeqEl("E0DCF6CDE50ED169C3A411DE9F0900216A684158");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
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


    // $ANTLR start "tcs_sequenceinalternative"
    // parser/TCS.g:749:1: tcs_sequenceinalternative returns [Object ret2] : ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequenceinalternative() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SequenceInAlternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:754:3: ( ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // parser/TCS.g:755:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // parser/TCS.g:755:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // parser/TCS.g:755:4: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE50ED177C3A411DEC13800216A684158");
            }
            // parser/TCS.g:755:64: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==109) ) {
                int LA80_1 = input.LA(2);

                if ( (LA80_1==LPAREN) ) {
                    int LA80_3 = input.LA(3);

                    if ( (LA80_3==STRING) ) {
                        alt80=1;
                    }
                    else if ( (LA80_3==NAME||LA80_3==RARROW||LA80_3==QMARK||(LA80_3>=48 && LA80_3<=132)) ) {
                        alt80=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 80, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA80_1==EOF||(LA80_1>=NAME && LA80_1<=STRING)||LA80_1==RPAREN||(LA80_1>=LCURLY && LA80_1<=COMA)||LA80_1==LT||(LA80_1>=LSQUARE && LA80_1<=RSQUARE)||(LA80_1>=DLSQUARE && LA80_1<=DRSQUARE)||(LA80_1>=DOLLAR && LA80_1<=DLCURLY)||(LA80_1>=48 && LA80_1<=132)) ) {
                    alt80=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA80_0==EOF||(LA80_0>=NAME && LA80_0<=STRING)||(LA80_0>=LPAREN && LA80_0<=RPAREN)||(LA80_0>=RCURLY && LA80_0<=COMA)||LA80_0==LT||(LA80_0>=LSQUARE && LA80_0<=RSQUARE)||(LA80_0>=DLSQUARE && LA80_0<=DRSQUARE)||(LA80_0>=DOLLAR && LA80_0<=DLCURLY)||(LA80_0>=48 && LA80_0<=108)||(LA80_0>=110 && LA80_0<=132)) ) {
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
                    // parser/TCS.g:755:65: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:755:81: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    // parser/TCS.g:755:82: 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE50ED170C3A411DE87C600216A684158");
                    }
                    match(input,109,FOLLOW_109_in_tcs_sequenceinalternative4208); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE50ED171C3A411DE826A00216A684158");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_sequenceinalternative4212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE50ED174C3A411DE984D00216A684158");
                    }
                    // parser/TCS.g:755:313: (temp= stringSymbol )
                    // parser/TCS.g:755:315: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_sequenceinalternative4220);
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
                      _beforeSeqEl("E0DCF6CDE50ED175C3A411DECD8600216A684158");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_sequenceinalternative4227); if (state.failed) return ret2;
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
                    // parser/TCS.g:755:492: 
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
              _beforeSeqEl("E0DCF6CDE50ED179C3A411DEA6BB00216A684158");
            }
            // parser/TCS.g:756:76: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=NAME && LA82_0<=STRING)||LA82_0==LPAREN||LA82_0==RARROW||LA82_0==LT||LA82_0==LSQUARE||LA82_0==DLSQUARE||(LA82_0>=DOLLAR && LA82_0<=DLCURLY)||(LA82_0>=48 && LA82_0<=132)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // parser/TCS.g:756:78: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4248);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // parser/TCS.g:756:141: (temp= tcs_sequenceelement )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( ((LA81_0>=NAME && LA81_0<=STRING)||LA81_0==LPAREN||LA81_0==RARROW||LA81_0==LT||LA81_0==LSQUARE||LA81_0==DLSQUARE||(LA81_0>=DOLLAR && LA81_0<=DLCURLY)||(LA81_0>=48 && LA81_0<=132)) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // parser/TCS.g:756:143: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4256);
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
    // $ANTLR end "tcs_sequenceinalternative"


    // $ANTLR start "tcs_functioncall"
    // parser/TCS.g:764:1: tcs_functioncall returns [Object ret2] : ( DOLLAR (temp= identifier ) ) ;
    public final Object tcs_functioncall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:769:3: ( ( DOLLAR (temp= identifier ) ) )
            // parser/TCS.g:770:3: ( DOLLAR (temp= identifier ) )
            {
            // parser/TCS.g:770:3: ( DOLLAR (temp= identifier ) )
            // parser/TCS.g:770:4: DOLLAR (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5111B50C3A411DEC9A200216A684158");
            }
            match(input,DOLLAR,FOLLOW_DOLLAR_in_tcs_functioncall4305); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5111B53C3A411DEAA0F00216A684158");
            }
            // parser/TCS.g:770:146: (temp= identifier )
            // parser/TCS.g:770:148: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functioncall4313);
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5111B56C3A411DE8A0500216A684158");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
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


    // $ANTLR start "tcs_injectoractionsblock"
    // parser/TCS.g:778:1: tcs_injectoractionsblock returns [Object ret2] : ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY ) ;
    public final Object tcs_injectoractionsblock() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","InjectorActionsBlock");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:783:3: ( ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY ) )
            // parser/TCS.g:784:3: ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY )
            {
            // parser/TCS.g:784:3: ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY )
            // parser/TCS.g:784:4: DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5111B5AC3A411DEC1FD00216A684158");
            }
            match(input,DLCURLY,FOLLOW_DLCURLY_in_tcs_injectoractionsblock4360); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5111B5FC3A411DEA62200216A684158");
            }
            // parser/TCS.g:784:147: (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==NAME||LA84_0==RARROW||(LA84_0>=48 && LA84_0<=132)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // parser/TCS.g:784:149: temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )*
                    {
                    pushFollow(FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4368);
                    temp=tcs_injectoraction();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "injectorActions", temp);
                    }
                    // parser/TCS.g:784:218: ( ( COMA ) temp= tcs_injectoraction )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==COMA) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // parser/TCS.g:784:219: ( COMA ) temp= tcs_injectoraction
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:784:236: ( COMA )
                    	    // parser/TCS.g:784:237: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDE5111B5CC3A411DEA0B600216A684158");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_tcs_injectoractionsblock4377); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4385);
                    	    temp=tcs_injectoraction();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "injectorActions", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5111B60C3A411DEAE6E00216A684158");
            }
            match(input,DRCURLY,FOLLOW_DRCURLY_in_tcs_injectoractionsblock4397); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5111B63C3A411DEA7D800216A684158");
            }
            if ( state.backtracking==0 ) {
              setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
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
    // $ANTLR end "tcs_injectoractionsblock"


    // $ANTLR start "tcs_injectoraction"
    // parser/TCS.g:792:1: tcs_injectoraction returns [Object ret2] : (ret= tcs_propertyinit ) ;
    public final Object tcs_injectoraction() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:793:3: ( (ret= tcs_propertyinit ) )
            // parser/TCS.g:794:3: (ret= tcs_propertyinit )
            {
            // parser/TCS.g:794:3: (ret= tcs_propertyinit )
            // parser/TCS.g:794:4: ret= tcs_propertyinit
            {
            pushFollow(FOLLOW_tcs_propertyinit_in_tcs_injectoraction4438);
            ret=tcs_propertyinit();

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
    // $ANTLR end "tcs_injectoraction"


    // $ANTLR start "tcs_propertyinit"
    // parser/TCS.g:801:1: tcs_propertyinit returns [Object ret2] : (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit ) ;
    public final Object tcs_propertyinit() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:802:3: ( (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit ) )
            // parser/TCS.g:803:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )
            {
            // parser/TCS.g:803:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )
            int alt85=3;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // parser/TCS.g:803:4: ret= tcs_primitivepropertyinit
                    {
                    pushFollow(FOLLOW_tcs_primitivepropertyinit_in_tcs_propertyinit4465);
                    ret=tcs_primitivepropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:804:5: ret= tcs_lookuppropertyinit
                    {
                    pushFollow(FOLLOW_tcs_lookuppropertyinit_in_tcs_propertyinit4473);
                    ret=tcs_lookuppropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:805:5: ret= tcs_foreachpredicatepropertyinit
                    {
                    pushFollow(FOLLOW_tcs_foreachpredicatepropertyinit_in_tcs_propertyinit4481);
                    ret=tcs_foreachpredicatepropertyinit();

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
    // $ANTLR end "tcs_propertyinit"


    // $ANTLR start "tcs_primitivepropertyinit"
    // parser/TCS.g:812:1: tcs_primitivepropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) ) ;
    public final Object tcs_primitivepropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitivePropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:817:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) ) )
            // parser/TCS.g:818:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) )
            {
            // parser/TCS.g:818:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) )
            // parser/TCS.g:818:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5138C55C3A411DEBD8400216A684158");
            }
            // parser/TCS.g:818:63: (temp= tcs_propertyreference )
            // parser/TCS.g:818:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_primitivepropertyinit4515);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5138C5DC3A411DEC27B00216A684158");
            }
            // parser/TCS.g:818:215: ( ( LARROW ) | ( EQ ) )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==LARROW) ) {
                alt86=1;
            }
            else if ( (LA86_0==EQ) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // parser/TCS.g:818:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:818:232: ( LARROW )
                    // parser/TCS.g:818:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5138C59C3A411DEC91800216A684158");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_primitivepropertyinit4528); if (state.failed) return ret2;
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
                    // parser/TCS.g:818:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:818:406: ( EQ )
                    // parser/TCS.g:818:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5138C5BC3A411DECF3C00216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivepropertyinit4543); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

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
              _beforeSeqEl("E0DCF6CDE515D641C3A411DEB07E00216A684158");
            }
            // parser/TCS.g:819:76: (temp= identifier )
            // parser/TCS.g:819:78: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivepropertyinit4558);
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
    // $ANTLR end "tcs_primitivepropertyinit"


    // $ANTLR start "tcs_lookuppropertyinit"
    // parser/TCS.g:827:1: tcs_lookuppropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN ) ;
    public final Object tcs_lookuppropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookupPropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:832:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN ) )
            // parser/TCS.g:833:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN )
            {
            // parser/TCS.g:833:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN )
            // parser/TCS.g:833:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE515D646C3A411DEA5F300216A684158");
            }
            // parser/TCS.g:833:63: (temp= tcs_propertyreference )
            // parser/TCS.g:833:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_lookuppropertyinit4605);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE515D64EC3A411DECDC000216A684158");
            }
            // parser/TCS.g:833:215: ( ( LARROW ) | ( EQ ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==LARROW) ) {
                alt87=1;
            }
            else if ( (LA87_0==EQ) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // parser/TCS.g:833:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:833:232: ( LARROW )
                    // parser/TCS.g:833:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE515D64AC3A411DE920600216A684158");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_lookuppropertyinit4618); if (state.failed) return ret2;
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
                    // parser/TCS.g:833:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:833:406: ( EQ )
                    // parser/TCS.g:833:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE515D64CC3A411DE99AB00216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_lookuppropertyinit4633); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

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
              _beforeSeqEl("E0DCF6CDE515D64FC3A411DE99D600216A684158");
            }
            match(input,95,FOLLOW_95_in_tcs_lookuppropertyinit4644); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE515D650C3A411DEACFF00216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_lookuppropertyinit4648); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE515D653C3A411DE927100216A684158");
            }
            // parser/TCS.g:834:242: (temp= stringSymbol )
            // parser/TCS.g:834:244: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_lookuppropertyinit4656);
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
              _beforeSeqEl("E0DCF6CDE515D654C3A411DE8F9F00216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_lookuppropertyinit4663); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "tcs_lookuppropertyinit"


    // $ANTLR start "tcs_foreachpredicatepropertyinit"
    // parser/TCS.g:842:1: tcs_foreachpredicatepropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN ) ;
    public final Object tcs_foreachpredicatepropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForeachPredicatePropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:847:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN ) )
            // parser/TCS.g:848:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN )
            {
            // parser/TCS.g:848:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN )
            // parser/TCS.g:848:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5184741C3A411DEC05800216A684158");
            }
            // parser/TCS.g:848:63: (temp= tcs_propertyreference )
            // parser/TCS.g:848:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_foreachpredicatepropertyinit4708);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5184749C3A411DEAFC500216A684158");
            }
            // parser/TCS.g:848:215: ( ( LARROW ) | ( EQ ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==LARROW) ) {
                alt88=1;
            }
            else if ( (LA88_0==EQ) ) {
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
                    // parser/TCS.g:848:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:848:232: ( LARROW )
                    // parser/TCS.g:848:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5184745C3A411DEA35500216A684158");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_foreachpredicatepropertyinit4721); if (state.failed) return ret2;
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
                    // parser/TCS.g:848:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:848:406: ( EQ )
                    // parser/TCS.g:848:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5184747C3A411DECEDF00216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4736); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

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
              _beforeSeqEl("E0DCF6CDE518474AC3A411DEB99F00216A684158");
            }
            match(input,108,FOLLOW_108_in_tcs_foreachpredicatepropertyinit4747); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE518474BC3A411DECAA100216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_foreachpredicatepropertyinit4751); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE518474EC3A411DEB67700216A684158");
            }
            // parser/TCS.g:849:243: (temp= stringSymbol )
            // parser/TCS.g:849:245: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4759);
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
              _beforeSeqEl("E0DCF6CDE5184759C3A411DE9C4F00216A684158");
            }
            // parser/TCS.g:849:374: ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==COMA) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==RPAREN||LA89_1==92||LA89_1==120) ) {
                    alt89=2;
                }
                else if ( (LA89_1==78) ) {
                    int LA89_3 = input.LA(3);

                    if ( (LA89_3==EQ) ) {
                        int LA89_4 = input.LA(4);

                        if ( (LA89_4==STRING) ) {
                            int LA89_5 = input.LA(5);

                            if ( (LA89_5==COMA) ) {
                                int LA89_6 = input.LA(6);

                                if ( (synpred183_TCS()) ) {
                                    alt89=1;
                                }
                                else if ( (true) ) {
                                    alt89=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ret2;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 89, 6, input);

                                    throw nvae;
                                }
                            }
                            else if ( (LA89_5==RPAREN) ) {
                                alt89=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ret2;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 89, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 89, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 89, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA89_0==RPAREN) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // parser/TCS.g:849:375: ( COMA 'mode' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:849:391: ( COMA 'mode' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:849:392: COMA 'mode' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5184752C3A411DECDEB00216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4772); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5184753C3A411DEBF2400216A684158");
                    }
                    match(input,78,FOLLOW_78_in_tcs_foreachpredicatepropertyinit4776); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5184754C3A411DE996400216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4780); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5184757C3A411DECD7600216A684158");
                    }
                    // parser/TCS.g:849:692: (temp= stringSymbol )
                    // parser/TCS.g:849:694: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4788);
                    temp=stringSymbol();

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
                    // parser/TCS.g:849:780: 
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
              _beforeSeqEl("E0DCF6CDE5184764C3A411DEB09D00216A684158");
            }
            // parser/TCS.g:850:77: ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==COMA) ) {
                alt92=1;
            }
            else if ( (LA92_0==RPAREN) ) {
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
                    // parser/TCS.g:850:78: ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:850:94: ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? )
                    // parser/TCS.g:850:95: COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE518475DC3A411DE963600216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4814); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5184762C3A411DEB56D00216A684158");
                    }
                    // parser/TCS.g:850:235: (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==78||LA91_0==92||LA91_0==120) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // parser/TCS.g:850:237: temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )*
                            {
                            pushFollow(FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4822);
                            temp=tcs_predicatesemantic();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "predicatesemantic", temp);
                            }
                            // parser/TCS.g:850:311: ( ( COMA ) temp= tcs_predicatesemantic )*
                            loop90:
                            do {
                                int alt90=2;
                                int LA90_0 = input.LA(1);

                                if ( (LA90_0==COMA) ) {
                                    alt90=1;
                                }


                                switch (alt90) {
                            	case 1 :
                            	    // parser/TCS.g:850:312: ( COMA ) temp= tcs_predicatesemantic
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:850:329: ( COMA )
                            	    // parser/TCS.g:850:330: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDE518475FC3A411DECB0800216A684158");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4831); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4839);
                            	    temp=tcs_predicatesemantic();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "predicatesemantic", temp);
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop90;
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
                    // parser/TCS.g:850:542: 
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
              _beforeSeqEl("E0DCF6CDE5184765C3A411DE915400216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_foreachpredicatepropertyinit4864); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "tcs_foreachpredicatepropertyinit"


    // $ANTLR start "tcs_predicatesemantic"
    // parser/TCS.g:859:1: tcs_predicatesemantic returns [Object ret2] : ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? ) ;
    public final Object tcs_predicatesemantic() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PredicateSemantic");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:864:3: ( ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? ) )
            // parser/TCS.g:865:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? )
            {
            // parser/TCS.g:865:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? )
            // parser/TCS.g:865:4: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE51AB84AC3A411DE8A6B00216A684158");
            }
            // parser/TCS.g:865:64: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==92) ) {
                alt93=1;
            }
            else if ( (LA93_0==78||LA93_0==120) ) {
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
                    // parser/TCS.g:865:65: ( 'when' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:865:81: ( 'when' EQ (temp= stringSymbol ) COMA )
                    // parser/TCS.g:865:82: 'when' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE51AB843C3A411DEC59A00216A684158");
                    }
                    match(input,92,FOLLOW_92_in_tcs_predicatesemantic4911); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE51AB844C3A411DE994500216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic4915); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE51AB847C3A411DE9DD000216A684158");
                    }
                    // parser/TCS.g:865:301: (temp= stringSymbol )
                    // parser/TCS.g:865:303: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_predicatesemantic4923);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "when", temp);
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE51AB848C3A411DE8F8800216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_predicatesemantic4930); if (state.failed) return ret2;
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
                    // parser/TCS.g:865:470: 
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
              _beforeSeqEl("E0DCF6CDE51AB855C3A411DEB92C00216A684158");
            }
            // parser/TCS.g:866:77: ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==78) ) {
                alt94=1;
            }
            else if ( (LA94_0==120) ) {
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
                    // parser/TCS.g:866:78: ( 'mode' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:866:94: ( 'mode' EQ (temp= stringSymbol ) COMA )
                    // parser/TCS.g:866:95: 'mode' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE51AB84EC3A411DEBD5A00216A684158");
                    }
                    match(input,78,FOLLOW_78_in_tcs_predicatesemantic4953); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE51AB84FC3A411DEA50100216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic4957); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE51AB852C3A411DEA11C00216A684158");
                    }
                    // parser/TCS.g:866:314: (temp= stringSymbol )
                    // parser/TCS.g:866:316: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_predicatesemantic4965);
                    temp=stringSymbol();

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
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE51AB853C3A411DECF2300216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_predicatesemantic4972); if (state.failed) return ret2;
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
                    // parser/TCS.g:866:483: 
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
              _beforeSeqEl("E0DCF6CDE51AB856C3A411DE84F000216A684158");
            }
            match(input,120,FOLLOW_120_in_tcs_predicatesemantic4989); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE51AB857C3A411DEA15C00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic4993); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE51D0230C3A411DECA4500216A684158");
            }
            // parser/TCS.g:867:234: (temp= identifierOrKeyword )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==NAME||(LA95_0>=48 && LA95_0<=132)) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // parser/TCS.g:867:236: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_predicatesemantic5001);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"									if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"										t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"										and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"											->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"											->includes(self.foreachParent.propertyReference.strucfeature.type)"+"										and ("+"											if(not self.mode.oclIsUndefined()) then"+"												t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"											endif"+"										)									"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"										else"+"											false"+"										endif"+"									endif)"+"								");
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
    // $ANTLR end "tcs_predicatesemantic"


    // $ANTLR start "tcs_propertyarg"
    // parser/TCS.g:875:1: tcs_propertyarg returns [Object ret2] : (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg ) ;
    public final Object tcs_propertyarg() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:876:3: ( (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg ) )
            // parser/TCS.g:877:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg )
            {
            // parser/TCS.g:877:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg )
            int alt96=15;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt96=1;
                }
                break;
            case 95:
                {
                alt96=2;
                }
                break;
            case 122:
                {
                alt96=3;
                }
                break;
            case 120:
                {
                alt96=4;
                }
                break;
            case 58:
                {
                alt96=5;
                }
                break;
            case 109:
                {
                alt96=6;
                }
                break;
            case 89:
                {
                alt96=7;
                }
                break;
            case 67:
                {
                alt96=8;
                }
                break;
            case 115:
                {
                alt96=9;
                }
                break;
            case 100:
                {
                alt96=10;
                }
                break;
            case 53:
                {
                alt96=11;
                }
                break;
            case 64:
                {
                alt96=12;
                }
                break;
            case 125:
                {
                alt96=13;
                }
                break;
            case 131:
                {
                alt96=14;
                }
                break;
            case 78:
                {
                alt96=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }

            switch (alt96) {
                case 1 :
                    // parser/TCS.g:877:4: ret= tcs_referstoparg
                    {
                    pushFollow(FOLLOW_tcs_referstoparg_in_tcs_propertyarg5043);
                    ret=tcs_referstoparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:878:5: ret= tcs_lookinparg
                    {
                    pushFollow(FOLLOW_tcs_lookinparg_in_tcs_propertyarg5051);
                    ret=tcs_lookinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:879:5: ret= tcs_createinparg
                    {
                    pushFollow(FOLLOW_tcs_createinparg_in_tcs_propertyarg5059);
                    ret=tcs_createinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:880:5: ret= tcs_asparg
                    {
                    pushFollow(FOLLOW_tcs_asparg_in_tcs_propertyarg5067);
                    ret=tcs_asparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:881:5: ret= tcs_separatorparg
                    {
                    pushFollow(FOLLOW_tcs_separatorparg_in_tcs_propertyarg5075);
                    ret=tcs_separatorparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:882:5: ret= tcs_disambiguateparg
                    {
                    pushFollow(FOLLOW_tcs_disambiguateparg_in_tcs_propertyarg5083);
                    ret=tcs_disambiguateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:883:5: ret= tcs_autocreateparg
                    {
                    pushFollow(FOLLOW_tcs_autocreateparg_in_tcs_propertyarg5091);
                    ret=tcs_autocreateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:884:5: ret= tcs_importcontextparg
                    {
                    pushFollow(FOLLOW_tcs_importcontextparg_in_tcs_propertyarg5099);
                    ret=tcs_importcontextparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 9 :
                    // parser/TCS.g:885:5: ret= tcs_partialparg
                    {
                    pushFollow(FOLLOW_tcs_partialparg_in_tcs_propertyarg5107);
                    ret=tcs_partialparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 10 :
                    // parser/TCS.g:886:5: ret= tcs_forcedlowerparg
                    {
                    pushFollow(FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg5115);
                    ret=tcs_forcedlowerparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 11 :
                    // parser/TCS.g:887:5: ret= tcs_forcedupperparg
                    {
                    pushFollow(FOLLOW_tcs_forcedupperparg_in_tcs_propertyarg5123);
                    ret=tcs_forcedupperparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 12 :
                    // parser/TCS.g:888:5: ret= tcs_createasparg
                    {
                    pushFollow(FOLLOW_tcs_createasparg_in_tcs_propertyarg5131);
                    ret=tcs_createasparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 13 :
                    // parser/TCS.g:889:5: ret= tcs_queryparg
                    {
                    pushFollow(FOLLOW_tcs_queryparg_in_tcs_propertyarg5139);
                    ret=tcs_queryparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 14 :
                    // parser/TCS.g:890:5: ret= tcs_filterparg
                    {
                    pushFollow(FOLLOW_tcs_filterparg_in_tcs_propertyarg5147);
                    ret=tcs_filterparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 15 :
                    // parser/TCS.g:891:5: ret= tcs_modeparg
                    {
                    pushFollow(FOLLOW_tcs_modeparg_in_tcs_propertyarg5155);
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
    // parser/TCS.g:898:1: tcs_referstoparg returns [Object ret2] : ( 'refersTo' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_referstoparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RefersToPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:903:3: ( ( 'refersTo' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:904:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:904:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:904:4: 'refersTo' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE51F7330C3A411DEA52A00216A684158");
            }
            match(input,55,FOLLOW_55_in_tcs_referstoparg5185); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE51F7331C3A411DE9DF100216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_referstoparg5189); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE51F7334C3A411DE89F900216A684158");
            }
            // parser/TCS.g:904:227: (temp= identifierOrKeyword )
            // parser/TCS.g:904:229: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_referstoparg5197);
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
    // parser/TCS.g:912:1: tcs_lookinparg returns [Object ret2] : ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) ;
    public final Object tcs_lookinparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:917:3: ( ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) )
            // parser/TCS.g:918:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            {
            // parser/TCS.g:918:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            // parser/TCS.g:918:4: 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE51F7338C3A411DEC54A00216A684158");
            }
            match(input,95,FOLLOW_95_in_tcs_lookinparg5240); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE51F7339C3A411DE830000216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_lookinparg5244); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5242E2BC3A411DEAC2B00216A684158");
            }
            // parser/TCS.g:918:226: ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==SHARP) ) {
                alt98=1;
            }
            else if ( (LA98_0==NAME||(LA98_0>=48 && LA98_0<=132)) ) {
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
                    // parser/TCS.g:918:227: ( SHARP 'all' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:918:243: ( SHARP 'all' )
                    // parser/TCS.g:918:244: SHARP 'all'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5242E21C3A411DEB43300216A684158");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_tcs_lookinparg5255); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5242E22C3A411DECC5600216A684158");
                    }
                    match(input,50,FOLLOW_50_in_tcs_lookinparg5259); if (state.failed) return ret2;
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
                    // parser/TCS.g:918:479: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:918:495: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    // parser/TCS.g:918:496: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5242E29C3A411DE957F00216A684158");
                    }
                    // parser/TCS.g:918:555: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    // parser/TCS.g:918:557: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg5276);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyName", temp);
                    }
                    // parser/TCS.g:918:624: ( ( POINT ) temp= identifierOrKeyword )*
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( (LA97_0==POINT) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // parser/TCS.g:918:625: ( POINT ) temp= identifierOrKeyword
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:918:642: ( POINT )
                    	    // parser/TCS.g:918:643: POINT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDE5242E26C3A411DEB6B900216A684158");
                    	    }
                    	    match(input,POINT,FOLLOW_POINT_in_tcs_lookinparg5285); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg5293);
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
                    	    break loop97;
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
    // parser/TCS.g:927:1: tcs_createinparg returns [Object ret2] : ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createinparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:932:3: ( ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            // parser/TCS.g:933:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            {
            // parser/TCS.g:933:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            // parser/TCS.g:933:4: 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5242E2FC3A411DE8F2600216A684158");
            }
            match(input,122,FOLLOW_122_in_tcs_createinparg5346); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5242E30C3A411DE9EC800216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createinparg5350); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5242E36C3A411DEA73300216A684158");
            }
            // parser/TCS.g:933:227: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            // parser/TCS.g:933:229: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg5358);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
            }
            // parser/TCS.g:933:296: ( ( POINT ) temp= identifierOrKeyword )*
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==POINT) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // parser/TCS.g:933:297: ( POINT ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:933:314: ( POINT )
            	    // parser/TCS.g:933:315: POINT
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CDE5242E33C3A411DEB4D100216A684158");
            	    }
            	    match(input,POINT,FOLLOW_POINT_in_tcs_createinparg5367); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg5375);
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
            	    break loop99;
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
    // parser/TCS.g:941:1: tcs_asparg returns [Object ret2] : ( 'as' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_asparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:946:3: ( ( 'as' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:947:3: ( 'as' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:947:3: ( 'as' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:947:4: 'as' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5269F20C3A411DEA35F00216A684158");
            }
            match(input,120,FOLLOW_120_in_tcs_asparg5421); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5269F21C3A411DEAAED00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_asparg5425); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5269F26C3A411DE849F00216A684158");
            }
            // parser/TCS.g:947:221: (temp= identifierOrKeyword )
            // parser/TCS.g:947:223: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_asparg5433);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"									if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"										t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"										and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"											->prepend(self.property.propertyReference.strucfeature.type)"+"											->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"										and ("+"											if (not self.property.propertyArgs->select("+"													arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"												) "+"											then"+"												t.oclAsType(TCS::ClassTemplate).mode = "+"													self.property.propertyArgs->select("+"														arg | arg.oclIsTypeOf(TCS::ModePArg))"+"															.oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"													.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"											endif"+"										)"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"										else"+"											false"+"										endif"+"									endif)"+"								");
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


    // $ANTLR start "tcs_separatorparg"
    // parser/TCS.g:955:1: tcs_separatorparg returns [Object ret2] : ( 'separator' EQ (temp= tcs_sequence ) ) ;
    public final Object tcs_separatorparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SeparatorPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:960:3: ( ( 'separator' EQ (temp= tcs_sequence ) ) )
            // parser/TCS.g:961:3: ( 'separator' EQ (temp= tcs_sequence ) )
            {
            // parser/TCS.g:961:3: ( 'separator' EQ (temp= tcs_sequence ) )
            // parser/TCS.g:961:4: 'separator' EQ (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5269F2AC3A411DE8BDD00216A684158");
            }
            match(input,58,FOLLOW_58_in_tcs_separatorparg5476); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5269F2BC3A411DE81AF00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_separatorparg5480); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5269F2DC3A411DEA31300216A684158");
            }
            // parser/TCS.g:961:228: (temp= tcs_sequence )
            // parser/TCS.g:961:230: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_separatorparg5488);
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


    // $ANTLR start "tcs_disambiguateparg"
    // parser/TCS.g:969:1: tcs_disambiguateparg returns [Object ret2] : ( 'disambiguate' EQ (temp= stringSymbol ) ) ;
    public final Object tcs_disambiguateparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","DisambiguatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:974:3: ( ( 'disambiguate' EQ (temp= stringSymbol ) ) )
            // parser/TCS.g:975:3: ( 'disambiguate' EQ (temp= stringSymbol ) )
            {
            // parser/TCS.g:975:3: ( 'disambiguate' EQ (temp= stringSymbol ) )
            // parser/TCS.g:975:4: 'disambiguate' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE528E910C3A411DE948400216A684158");
            }
            match(input,109,FOLLOW_109_in_tcs_disambiguateparg5531); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE528E911C3A411DE9EA300216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_disambiguateparg5535); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE528E914C3A411DE99E900216A684158");
            }
            // parser/TCS.g:975:231: (temp= stringSymbol )
            // parser/TCS.g:975:233: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_disambiguateparg5543);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "disambiguation", temp);
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
    // $ANTLR end "tcs_disambiguateparg"


    // $ANTLR start "tcs_autocreateparg"
    // parser/TCS.g:983:1: tcs_autocreateparg returns [Object ret2] : ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) ;
    public final Object tcs_autocreateparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AutoCreatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:988:3: ( ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) )
            // parser/TCS.g:989:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            {
            // parser/TCS.g:989:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            // parser/TCS.g:989:4: 'autoCreate' EQ (temp= tcs_autocreatekind )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE528E918C3A411DECEA700216A684158");
            }
            match(input,89,FOLLOW_89_in_tcs_autocreateparg5586); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE528E919C3A411DEC3F300216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_autocreateparg5590); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE528E91BC3A411DE88F800216A684158");
            }
            // parser/TCS.g:989:229: (temp= tcs_autocreatekind )
            // parser/TCS.g:989:231: temp= tcs_autocreatekind
            {
            pushFollow(FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg5598);
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
    // parser/TCS.g:997:1: tcs_autocreatekind returns [Object ret2] : ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) ;
    public final Object tcs_autocreatekind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:998:3: ( ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) )
            // parser/TCS.g:999:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            {
            // parser/TCS.g:999:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            int alt100=3;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt100=1;
                }
                break;
            case 84:
                {
                alt100=2;
                }
                break;
            case 56:
                {
                alt100=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // parser/TCS.g:999:4: ( 'always' )
                    {
                    // parser/TCS.g:999:4: ( 'always' )
                    // parser/TCS.g:999:5: 'always'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE52B5A11C3A411DE93B700216A684158");
                    }
                    match(input,124,FOLLOW_124_in_tcs_autocreatekind5642); if (state.failed) return ret2;
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
                    // parser/TCS.g:1000:4: ( 'ifmissing' )
                    {
                    // parser/TCS.g:1000:4: ( 'ifmissing' )
                    // parser/TCS.g:1000:5: 'ifmissing'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5301501C3A411DECBFB00216A684158");
                    }
                    match(input,84,FOLLOW_84_in_tcs_autocreatekind5652); if (state.failed) return ret2;
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
                    // parser/TCS.g:1001:4: ( 'never' )
                    {
                    // parser/TCS.g:1001:4: ( 'never' )
                    // parser/TCS.g:1001:5: 'never'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5301504C3A411DECE8B00216A684158");
                    }
                    match(input,56,FOLLOW_56_in_tcs_autocreatekind5662); if (state.failed) return ret2;
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
    // parser/TCS.g:1008:1: tcs_importcontextparg returns [Object ret2] : ( 'importContext' ) ;
    public final Object tcs_importcontextparg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","ImportContextPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1013:3: ( ( 'importContext' ) )
            // parser/TCS.g:1014:3: ( 'importContext' )
            {
            // parser/TCS.g:1014:3: ( 'importContext' )
            // parser/TCS.g:1014:4: 'importContext'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5328600C3A411DEA77300216A684158");
            }
            match(input,67,FOLLOW_67_in_tcs_importcontextparg5693); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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


    // $ANTLR start "tcs_partialparg"
    // parser/TCS.g:1022:1: tcs_partialparg returns [Object ret2] : ( 'partial' ) ;
    public final Object tcs_partialparg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","PartialPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1027:3: ( ( 'partial' ) )
            // parser/TCS.g:1028:3: ( 'partial' )
            {
            // parser/TCS.g:1028:3: ( 'partial' )
            // parser/TCS.g:1028:4: 'partial'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE534CFF0C3A411DE9FD100216A684158");
            }
            match(input,115,FOLLOW_115_in_tcs_partialparg5733); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "tcs_partialparg"


    // $ANTLR start "tcs_forcedlowerparg"
    // parser/TCS.g:1036:1: tcs_forcedlowerparg returns [Object ret2] : ( 'forcedLower' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedlowerparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedLowerPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1041:3: ( ( 'forcedLower' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1042:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1042:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1042:4: 'forcedLower' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE534CFF4C3A411DEA4F800216A684158");
            }
            match(input,100,FOLLOW_100_in_tcs_forcedlowerparg5773); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE534CFF5C3A411DEA85500216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedlowerparg5777); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE534CFF7C3A411DEAE6200216A684158");
            }
            // parser/TCS.g:1042:230: (temp= integerSymbol )
            // parser/TCS.g:1042:232: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedlowerparg5785);
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


    // $ANTLR start "tcs_forcedupperparg"
    // parser/TCS.g:1050:1: tcs_forcedupperparg returns [Object ret2] : ( 'forcedUpper' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedupperparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedUpperPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1055:3: ( ( 'forcedUpper' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1056:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1056:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1056:4: 'forcedUpper' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE534CFFBC3A411DE918400216A684158");
            }
            match(input,53,FOLLOW_53_in_tcs_forcedupperparg5828); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE534CFFCC3A411DECCCD00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedupperparg5832); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE534CFFEC3A411DEAB4B00216A684158");
            }
            // parser/TCS.g:1056:230: (temp= integerSymbol )
            // parser/TCS.g:1056:232: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedupperparg5840);
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
    // $ANTLR end "tcs_forcedupperparg"


    // $ANTLR start "tcs_createasparg"
    // parser/TCS.g:1064:1: tcs_createasparg returns [Object ret2] : ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createasparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateAsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1069:3: ( ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) ) )
            // parser/TCS.g:1070:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) )
            {
            // parser/TCS.g:1070:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) )
            // parser/TCS.g:1070:4: 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53740F0C3A411DEA1AC00216A684158");
            }
            match(input,64,FOLLOW_64_in_tcs_createasparg5883); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53740F1C3A411DE908600216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createasparg5887); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53740F7C3A411DE875700216A684158");
            }
            // parser/TCS.g:1070:227: (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )
            // parser/TCS.g:1070:229: temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg5895);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }
            // parser/TCS.g:1070:288: ( ( DLCOLON ) temp= identifierOrKeyword )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==DLCOLON) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // parser/TCS.g:1070:289: ( DLCOLON ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:1070:306: ( DLCOLON )
            	    // parser/TCS.g:1070:307: DLCOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CDE53740F4C3A411DE87C400216A684158");
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_tcs_createasparg5904); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg5912);
            	    temp=identifierOrKeyword();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "name", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop101;
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
    // $ANTLR end "tcs_createasparg"


    // $ANTLR start "tcs_queryparg"
    // parser/TCS.g:1078:1: tcs_queryparg returns [Object ret2] : ( 'query' EQ (temp= stringSymbol ) ) ;
    public final Object tcs_queryparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","QueryPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1083:3: ( ( 'query' EQ (temp= stringSymbol ) ) )
            // parser/TCS.g:1084:3: ( 'query' EQ (temp= stringSymbol ) )
            {
            // parser/TCS.g:1084:3: ( 'query' EQ (temp= stringSymbol ) )
            // parser/TCS.g:1084:4: 'query' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53740FBC3A411DEA01100216A684158");
            }
            match(input,125,FOLLOW_125_in_tcs_queryparg5958); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53740FCC3A411DEA83000216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_queryparg5962); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53740FFC3A411DE809200216A684158");
            }
            // parser/TCS.g:1084:224: (temp= stringSymbol )
            // parser/TCS.g:1084:226: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_queryparg5970);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "query", temp);
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
    // $ANTLR end "tcs_queryparg"


    // $ANTLR start "tcs_filterparg"
    // parser/TCS.g:1092:1: tcs_filterparg returns [Object ret2] : ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) ) ;
    public final Object tcs_filterparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FilterPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1097:3: ( ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) ) )
            // parser/TCS.g:1098:3: ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) )
            {
            // parser/TCS.g:1098:3: ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) )
            // parser/TCS.g:1098:4: 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5398AE0C3A411DEC07300216A684158");
            }
            match(input,131,FOLLOW_131_in_tcs_filterparg6013); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5398AE1C3A411DE988800216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_filterparg6017); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5398AE4C3A411DEC03800216A684158");
            }
            // parser/TCS.g:1098:225: (temp= stringSymbol )
            // parser/TCS.g:1098:227: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_filterparg6025);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "filter", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5398AEFC3A411DECF8B00216A684158");
            }
            // parser/TCS.g:1098:357: ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==COMA) ) {
                int LA102_1 = input.LA(2);

                if ( (LA102_1==53||LA102_1==55||LA102_1==58||LA102_1==64||LA102_1==67||LA102_1==78||LA102_1==89||LA102_1==95||LA102_1==100||LA102_1==109||LA102_1==115||LA102_1==120||LA102_1==122||LA102_1==125||LA102_1==131) ) {
                    alt102=2;
                }
                else if ( (LA102_1==107) ) {
                    alt102=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 102, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA102_0==EOF||LA102_0==RCURLY) ) {
                alt102=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // parser/TCS.g:1098:358: ( COMA 'invert' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1098:374: ( COMA 'invert' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:1098:375: COMA 'invert' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5398AE8C3A411DEB48F00216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_filterparg6038); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5398AE9C3A411DEB9A400216A684158");
                    }
                    match(input,107,FOLLOW_107_in_tcs_filterparg6042); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5398AEAC3A411DE86C500216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_filterparg6046); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5398AEDC3A411DEC9AC00216A684158");
                    }
                    // parser/TCS.g:1098:677: (temp= stringSymbol )
                    // parser/TCS.g:1098:679: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_filterparg6054);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "invert", temp);
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
                    // parser/TCS.g:1098:767: 
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
    // $ANTLR end "tcs_filterparg"


    // $ANTLR start "tcs_modeparg"
    // parser/TCS.g:1107:1: tcs_modeparg returns [Object ret2] : ( 'mode' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_modeparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ModePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1112:3: ( ( 'mode' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:1113:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:1113:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:1113:4: 'mode' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5398AF3C3A411DE9C1800216A684158");
            }
            match(input,78,FOLLOW_78_in_tcs_modeparg6110); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5398AF4C3A411DEB01E00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_modeparg6114); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5398AF7C3A411DEC27E00216A684158");
            }
            // parser/TCS.g:1113:223: (temp= identifierOrKeyword )
            // parser/TCS.g:1113:225: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_modeparg6122);
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
    // parser/TCS.g:1121:1: tcs_blockarg returns [Object ret2] : (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) ;
    public final Object tcs_blockarg() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1122:3: ( (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) )
            // parser/TCS.g:1123:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            {
            // parser/TCS.g:1123:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            int alt103=5;
            switch ( input.LA(1) ) {
            case 113:
                {
                alt103=1;
                }
                break;
            case 65:
                {
                alt103=2;
                }
                break;
            case 66:
                {
                alt103=3;
                }
                break;
            case 87:
                {
                alt103=4;
                }
                break;
            case 83:
                {
                alt103=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // parser/TCS.g:1123:4: ret= tcs_nbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_nbnlbarg_in_tcs_blockarg6162);
                    ret=tcs_nbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1124:5: ret= tcs_indentincrbarg
                    {
                    pushFollow(FOLLOW_tcs_indentincrbarg_in_tcs_blockarg6170);
                    ret=tcs_indentincrbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1125:5: ret= tcs_startnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnlbarg_in_tcs_blockarg6178);
                    ret=tcs_startnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1126:5: ret= tcs_startnbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg6186);
                    ret=tcs_startnbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1127:5: ret= tcs_endnlbarg
                    {
                    pushFollow(FOLLOW_tcs_endnlbarg_in_tcs_blockarg6194);
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
    // parser/TCS.g:1134:1: tcs_nbnlbarg returns [Object ret2] : ( 'nbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_nbnlbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1139:3: ( ( 'nbNL' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1140:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1140:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1140:4: 'nbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53BFBE2C3A411DEB75A00216A684158");
            }
            match(input,113,FOLLOW_113_in_tcs_nbnlbarg6224); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53BFBE3C3A411DEC9DD00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_nbnlbarg6228); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53BFBE5C3A411DE9E0F00216A684158");
            }
            // parser/TCS.g:1140:223: (temp= integerSymbol )
            // parser/TCS.g:1140:225: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_nbnlbarg6236);
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
    // parser/TCS.g:1148:1: tcs_indentincrbarg returns [Object ret2] : ( 'indentIncr' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_indentincrbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IndentIncrBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1153:3: ( ( 'indentIncr' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1154:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1154:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1154:4: 'indentIncr' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53BFBE9C3A411DE802500216A684158");
            }
            match(input,65,FOLLOW_65_in_tcs_indentincrbarg6279); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53BFBEAC3A411DEA33400216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_indentincrbarg6283); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53BFBECC3A411DEAD3100216A684158");
            }
            // parser/TCS.g:1154:229: (temp= integerSymbol )
            // parser/TCS.g:1154:231: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_indentincrbarg6291);
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
    // parser/TCS.g:1162:1: tcs_startnlbarg returns [Object ret2] : ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_startnlbarg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","StartNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1167:3: ( ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // parser/TCS.g:1168:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // parser/TCS.g:1168:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // parser/TCS.g:1168:4: 'startNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53E6CE0C3A411DEB95A00216A684158");
            }
            match(input,66,FOLLOW_66_in_tcs_startnlbarg6334); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53E6CE1C3A411DE8EC500216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnlbarg6338); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53E6CE9C3A411DEB5DD00216A684158");
            }
            // parser/TCS.g:1168:227: ( ( 'true' ) | ( 'false' ) )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==130) ) {
                alt104=1;
            }
            else if ( (LA104_0==77) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }
            switch (alt104) {
                case 1 :
                    // parser/TCS.g:1168:228: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1168:244: ( 'true' )
                    // parser/TCS.g:1168:245: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE53E6CE5C3A411DEAE4D00216A684158");
                    }
                    match(input,130,FOLLOW_130_in_tcs_startnlbarg6348); if (state.failed) return ret2;
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
                    // parser/TCS.g:1168:396: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1168:412: ( 'false' )
                    // parser/TCS.g:1168:413: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE53E6CE7C3A411DE80A300216A684158");
                    }
                    match(input,77,FOLLOW_77_in_tcs_startnlbarg6361); if (state.failed) return ret2;
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
    // parser/TCS.g:1177:1: tcs_startnbnlbarg returns [Object ret2] : ( 'startNbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_startnbnlbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StartNbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1182:3: ( ( 'startNbNL' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1183:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1183:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1183:4: 'startNbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53E6CEDC3A411DEB1BF00216A684158");
            }
            match(input,87,FOLLOW_87_in_tcs_startnbnlbarg6408); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53E6CEEC3A411DE8AC000216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnbnlbarg6412); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE53E6CF0C3A411DEB85F00216A684158");
            }
            // parser/TCS.g:1183:228: (temp= integerSymbol )
            // parser/TCS.g:1183:230: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_startnbnlbarg6420);
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
    // parser/TCS.g:1191:1: tcs_endnlbarg returns [Object ret2] : ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_endnlbarg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","EndNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1196:3: ( ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // parser/TCS.g:1197:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // parser/TCS.g:1197:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // parser/TCS.g:1197:4: 'endNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE540B6D0C3A411DE966500216A684158");
            }
            match(input,83,FOLLOW_83_in_tcs_endnlbarg6463); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE540B6D1C3A411DE939F00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endnlbarg6467); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE540B6D9C3A411DE820300216A684158");
            }
            // parser/TCS.g:1197:225: ( ( 'true' ) | ( 'false' ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==130) ) {
                alt105=1;
            }
            else if ( (LA105_0==77) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // parser/TCS.g:1197:226: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1197:242: ( 'true' )
                    // parser/TCS.g:1197:243: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE540B6D5C3A411DEA35400216A684158");
                    }
                    match(input,130,FOLLOW_130_in_tcs_endnlbarg6477); if (state.failed) return ret2;
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
                    // parser/TCS.g:1197:394: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1197:410: ( 'false' )
                    // parser/TCS.g:1197:411: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE540B6D7C3A411DEBFB000216A684158");
                    }
                    match(input,77,FOLLOW_77_in_tcs_endnlbarg6490); if (state.failed) return ret2;
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
    // parser/TCS.g:1206:1: tcs_symbol returns [Object ret2] : ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) ;
    public final Object tcs_symbol() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Symbol");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1211:3: ( ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) )
            // parser/TCS.g:1212:3: ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            {
            // parser/TCS.g:1212:3: ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            // parser/TCS.g:1212:4: (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE540B6DEC3A411DEBECC00216A684158");
            }
            // parser/TCS.g:1212:63: (temp= identifier )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==NAME) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // parser/TCS.g:1212:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_symbol6541);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE540B6DFC3A411DEB70000216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_symbol6550); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE540B6E2C3A411DEC59E00216A684158");
            }
            // parser/TCS.g:1212:271: (temp= stringSymbol )
            // parser/TCS.g:1212:273: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_symbol6558);
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
              _beforeSeqEl("E0DCF6CDE540B6EDC3A411DE9A4D00216A684158");
            }
            // parser/TCS.g:1212:402: ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==COLON) ) {
                alt109=1;
            }
            else if ( (LA109_0==SEMI) ) {
                alt109=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // parser/TCS.g:1212:403: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1212:419: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    // parser/TCS.g:1212:420: COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE540B6E6C3A411DEA8CD00216A684158");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_symbol6571); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE540B6EBC3A411DEB8E000216A684158");
                    }
                    // parser/TCS.g:1212:561: (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==54||LA108_0==70||LA108_0==112||LA108_0==114) ) {
                        alt108=1;
                    }
                    switch (alt108) {
                        case 1 :
                            // parser/TCS.g:1212:563: temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )*
                            {
                            pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol6579);
                            temp=tcs_spacekind();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "spaces", temp);
                            }
                            // parser/TCS.g:1212:618: ( ( COMA ) temp= tcs_spacekind )*
                            loop107:
                            do {
                                int alt107=2;
                                int LA107_0 = input.LA(1);

                                if ( (LA107_0==COMA) ) {
                                    alt107=1;
                                }


                                switch (alt107) {
                            	case 1 :
                            	    // parser/TCS.g:1212:619: ( COMA ) temp= tcs_spacekind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:1212:636: ( COMA )
                            	    // parser/TCS.g:1212:637: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDE540B6E8C3A411DEAE1C00216A684158");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_symbol6588); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol6596);
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
                            	    break loop107;
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
                    // parser/TCS.g:1212:830: 
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
              _beforeSeqEl("E0DCF6CDE540B6EEC3A411DEAA3400216A684158");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_symbol6621); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1221:1: tcs_spacekind returns [Object ret2] : ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) ;
    public final Object tcs_spacekind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1222:3: ( ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) )
            // parser/TCS.g:1223:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            {
            // parser/TCS.g:1223:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            int alt110=4;
            switch ( input.LA(1) ) {
            case 114:
                {
                alt110=1;
                }
                break;
            case 112:
                {
                alt110=2;
                }
                break;
            case 54:
                {
                alt110=3;
                }
                break;
            case 70:
                {
                alt110=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // parser/TCS.g:1223:4: ( 'leftSpace' )
                    {
                    // parser/TCS.g:1223:4: ( 'leftSpace' )
                    // parser/TCS.g:1223:5: 'leftSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE54327D1C3A411DE98BA00216A684158");
                    }
                    match(input,114,FOLLOW_114_in_tcs_spacekind6663); if (state.failed) return ret2;
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
                    // parser/TCS.g:1224:4: ( 'leftNone' )
                    {
                    // parser/TCS.g:1224:4: ( 'leftNone' )
                    // parser/TCS.g:1224:5: 'leftNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE54327D4C3A411DE956400216A684158");
                    }
                    match(input,112,FOLLOW_112_in_tcs_spacekind6673); if (state.failed) return ret2;
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
                    // parser/TCS.g:1225:4: ( 'rightSpace' )
                    {
                    // parser/TCS.g:1225:4: ( 'rightSpace' )
                    // parser/TCS.g:1225:5: 'rightSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE54327D7C3A411DECE1500216A684158");
                    }
                    match(input,54,FOLLOW_54_in_tcs_spacekind6683); if (state.failed) return ret2;
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
                    // parser/TCS.g:1226:4: ( 'rightNone' )
                    {
                    // parser/TCS.g:1226:4: ( 'rightNone' )
                    // parser/TCS.g:1226:5: 'rightNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE54327DAC3A411DEC1F000216A684158");
                    }
                    match(input,70,FOLLOW_70_in_tcs_spacekind6693); if (state.failed) return ret2;
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
    // parser/TCS.g:1233:1: tcs_keyword returns [Object ret2] : ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI ) ;
    public final Object tcs_keyword() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Keyword");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1238:3: ( ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI ) )
            // parser/TCS.g:1239:3: ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI )
            {
            // parser/TCS.g:1239:3: ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI )
            // parser/TCS.g:1239:4: (temp= identifier )? EQ (temp= stringSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54327DFC3A411DE929C00216A684158");
            }
            // parser/TCS.g:1239:63: (temp= identifier )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==NAME) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // parser/TCS.g:1239:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_keyword6728);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54327E0C3A411DEB59900216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_keyword6737); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54327E3C3A411DEBD3300216A684158");
            }
            // parser/TCS.g:1239:271: (temp= stringSymbol )
            // parser/TCS.g:1239:273: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_keyword6745);
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
              _beforeSeqEl("E0DCF6CDE54327E4C3A411DEA4AF00216A684158");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_keyword6752); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1247:1: tcs_operatorlist returns [Object ret2] : ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) ;
    public final Object tcs_operatorlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1252:3: ( ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) )
            // parser/TCS.g:1253:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            {
            // parser/TCS.g:1253:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            // parser/TCS.g:1253:4: 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54571C0C3A411DE96BC00216A684158");
            }
            match(input,62,FOLLOW_62_in_tcs_operatorlist6793); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54571C7C3A411DEC35C00216A684158");
            }
            // parser/TCS.g:1253:150: ( ( (temp= identifier ) ) | )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==NAME) ) {
                alt112=1;
            }
            else if ( (LA112_0==LCURLY) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // parser/TCS.g:1253:151: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1253:167: ( (temp= identifier ) )
                    // parser/TCS.g:1253:168: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE54571C5C3A411DE828700216A684158");
                    }
                    // parser/TCS.g:1253:227: (temp= identifier )
                    // parser/TCS.g:1253:229: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatorlist6806);
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
                    // parser/TCS.g:1253:313: 
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
              _beforeSeqEl("E0DCF6CDE54571C8C3A411DEC80200216A684158");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_operatorlist6826); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54571CCC3A411DE89F900216A684158");
            }
            // parser/TCS.g:1254:159: ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) )
            // parser/TCS.g:1254:160: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            {
            // parser/TCS.g:1254:160: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            // parser/TCS.g:1254:161: (temp= tcs_priority (temp= tcs_priority )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54571CAC3A411DEA77800216A684158");
            }
            // parser/TCS.g:1254:220: (temp= tcs_priority (temp= tcs_priority )* )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==99) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // parser/TCS.g:1254:222: temp= tcs_priority (temp= tcs_priority )*
                    {
                    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist6837);
                    temp=tcs_priority();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "priorities", temp);
                    }
                    // parser/TCS.g:1254:280: (temp= tcs_priority )*
                    loop113:
                    do {
                        int alt113=2;
                        int LA113_0 = input.LA(1);

                        if ( (LA113_0==99) ) {
                            alt113=1;
                        }


                        switch (alt113) {
                    	case 1 :
                    	    // parser/TCS.g:1254:282: temp= tcs_priority
                    	    {
                    	    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist6845);
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
                    	    break loop113;
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
              _beforeSeqEl("E0DCF6CDE54571CDC3A411DEC34C00216A684158");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_operatorlist6860); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1262:1: tcs_priority returns [Object ret2] : ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) ;
    public final Object tcs_priority() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Priority");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1267:3: ( ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) )
            // parser/TCS.g:1268:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            {
            // parser/TCS.g:1268:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            // parser/TCS.g:1268:4: 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54571D1C3A411DE9A3E00216A684158");
            }
            match(input,99,FOLLOW_99_in_tcs_priority6901); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE547E2C0C3A411DEC71400216A684158");
            }
            // parser/TCS.g:1268:148: (temp= integerSymbol )
            // parser/TCS.g:1268:150: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_priority6908);
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
              _beforeSeqEl("E0DCF6CDE547E2CAC3A411DECBC000216A684158");
            }
            // parser/TCS.g:1268:280: ( () | ( COMA (temp= tcs_associativity ) ) )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==LCURLY) ) {
                alt115=1;
            }
            else if ( (LA115_0==COMA) ) {
                alt115=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }
            switch (alt115) {
                case 1 :
                    // parser/TCS.g:1268:281: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1268:297: ()
                    // parser/TCS.g:1268:298: 
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
                    // parser/TCS.g:1268:407: ( COMA (temp= tcs_associativity ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1268:423: ( COMA (temp= tcs_associativity ) )
                    // parser/TCS.g:1268:424: COMA (temp= tcs_associativity )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE547E2C6C3A411DEB68A00216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_priority6931); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE547E2C8C3A411DE8B9700216A684158");
                    }
                    // parser/TCS.g:1268:564: (temp= tcs_associativity )
                    // parser/TCS.g:1268:566: temp= tcs_associativity
                    {
                    pushFollow(FOLLOW_tcs_associativity_in_tcs_priority6939);
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
              _beforeSeqEl("E0DCF6CDE547E2CBC3A411DEB9A900216A684158");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_priority6953); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE547E2CFC3A411DE805900216A684158");
            }
            // parser/TCS.g:1269:159: ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) )
            // parser/TCS.g:1269:160: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            {
            // parser/TCS.g:1269:160: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            // parser/TCS.g:1269:161: (temp= tcs_operator (temp= tcs_operator )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE547E2CDC3A411DEB46800216A684158");
            }
            // parser/TCS.g:1269:220: (temp= tcs_operator (temp= tcs_operator )* )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==NAME||LA117_0==EQ||LA117_0==128) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // parser/TCS.g:1269:222: temp= tcs_operator (temp= tcs_operator )*
                    {
                    pushFollow(FOLLOW_tcs_operator_in_tcs_priority6964);
                    temp=tcs_operator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operators", temp);
                    }
                    // parser/TCS.g:1269:279: (temp= tcs_operator )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==NAME||LA116_0==EQ||LA116_0==128) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // parser/TCS.g:1269:281: temp= tcs_operator
                    	    {
                    	    pushFollow(FOLLOW_tcs_operator_in_tcs_priority6972);
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
                    	    break loop116;
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
              _beforeSeqEl("E0DCF6CDE547E2D0C3A411DE840100216A684158");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_priority6987); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1277:1: tcs_operator returns [Object ret2] : ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) ;
    public final Object tcs_operator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Operator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1282:3: ( ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) )
            // parser/TCS.g:1283:3: ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            {
            // parser/TCS.g:1283:3: ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            // parser/TCS.g:1283:4: ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE547E2D9C3A411DE88B500216A684158");
            }
            // parser/TCS.g:1283:64: ( ( 'postfix' ) | )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==128) ) {
                alt118=1;
            }
            else if ( (LA118_0==NAME||LA118_0==EQ) ) {
                alt118=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // parser/TCS.g:1283:65: ( 'postfix' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1283:81: ( 'postfix' )
                    // parser/TCS.g:1283:82: 'postfix'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE547E2D7C3A411DE891500216A684158");
                    }
                    match(input,128,FOLLOW_128_in_tcs_operator7034); if (state.failed) return ret2;
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
                    // parser/TCS.g:1283:240: 
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
              _beforeSeqEl("E0DCF6CDE547E2DBC3A411DEBA9B00216A684158");
            }
            // parser/TCS.g:1284:76: (temp= identifier )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==NAME) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // parser/TCS.g:1284:78: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operator7056);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE547E2DCC3A411DEA73900216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operator7065); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54C9DB1C3A411DEA0BF00216A684158");
            }
            // parser/TCS.g:1284:285: ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( ((LA121_0>=NAME && LA121_0<=STRING)) ) {
                alt121=1;
            }
            else if ( (LA121_0==COMA) ) {
                alt121=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }
            switch (alt121) {
                case 1 :
                    // parser/TCS.g:1284:286: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1284:302: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    // parser/TCS.g:1284:303: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE54A53C9C3A411DE83C600216A684158");
                    }
                    // parser/TCS.g:1284:362: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    int alt120=2;
                    int LA120_0 = input.LA(1);

                    if ( (LA120_0==NAME) ) {
                        alt120=1;
                    }
                    else if ( (LA120_0==STRING) ) {
                        alt120=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 120, 0, input);

                        throw nvae;
                    }
                    switch (alt120) {
                        case 1 :
                            // parser/TCS.g:1284:363: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:1284:379: ( (temp= identifier ) )
                            // parser/TCS.g:1284:380: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE547E2E2C3A411DEA31E00216A684158");
                            }
                            // parser/TCS.g:1284:439: (temp= identifier )
                            // parser/TCS.g:1284:441: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_operator7084);
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
                            // parser/TCS.g:1285:4: ( (temp= stringSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // parser/TCS.g:1285:20: ( (temp= stringSymbol ) )
                            // parser/TCS.g:1285:21: (temp= stringSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE54A53C7C3A411DEA88300216A684158");
                            }
                            // parser/TCS.g:1285:80: (temp= stringSymbol )
                            // parser/TCS.g:1285:82: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_operator7104);
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
                    // parser/TCS.g:1285:287: 
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
              _beforeSeqEl("E0DCF6CDE54C9DB2C3A411DEBD6400216A684158");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_operator7129); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54C9DB4C3A411DECA1B00216A684158");
            }
            // parser/TCS.g:1286:157: (temp= integerSymbol )
            // parser/TCS.g:1286:159: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_operator7137);
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
              _beforeSeqEl("E0DCF6CDE54C9DB5C3A411DECCF300216A684158");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_operator7144); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1294:1: tcs_associativity returns [Object ret2] : ( ( 'left' ) | ( 'right' ) ) ;
    public final Object tcs_associativity() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1295:3: ( ( ( 'left' ) | ( 'right' ) ) )
            // parser/TCS.g:1296:3: ( ( 'left' ) | ( 'right' ) )
            {
            // parser/TCS.g:1296:3: ( ( 'left' ) | ( 'right' ) )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==52) ) {
                alt122=1;
            }
            else if ( (LA122_0==118) ) {
                alt122=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }
            switch (alt122) {
                case 1 :
                    // parser/TCS.g:1296:4: ( 'left' )
                    {
                    // parser/TCS.g:1296:4: ( 'left' )
                    // parser/TCS.g:1296:5: 'left'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE54C9DBAC3A411DE86F400216A684158");
                    }
                    match(input,52,FOLLOW_52_in_tcs_associativity7186); if (state.failed) return ret2;
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
                    // parser/TCS.g:1297:4: ( 'right' )
                    {
                    // parser/TCS.g:1297:4: ( 'right' )
                    // parser/TCS.g:1297:5: 'right'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE54C9DBDC3A411DEC85200216A684158");
                    }
                    match(input,118,FOLLOW_118_in_tcs_associativity7196); if (state.failed) return ret2;
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
    // parser/TCS.g:1304:1: tcs_expression returns [Object ret2] : (ret= tcs_andexp ) ;
    public final Object tcs_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1305:3: ( (ret= tcs_andexp ) )
            // parser/TCS.g:1306:3: (ret= tcs_andexp )
            {
            // parser/TCS.g:1306:3: (ret= tcs_andexp )
            // parser/TCS.g:1306:4: ret= tcs_andexp
            {
            pushFollow(FOLLOW_tcs_andexp_in_tcs_expression7224);
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
    // parser/TCS.g:1313:1: tcs_andexp returns [Object ret2] : ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) ;
    public final Object tcs_andexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AndExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1318:3: ( ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) )
            // parser/TCS.g:1319:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            {
            // parser/TCS.g:1319:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            // parser/TCS.g:1319:4: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE54F0EB6C3A411DE9CC000216A684158");
            }
            // parser/TCS.g:1319:63: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==NAME||LA124_0==RARROW||(LA124_0>=48 && LA124_0<=132)) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // parser/TCS.g:1319:65: temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )*
                    {
                    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp7258);
                    temp=tcs_atomexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "expressions", temp);
                    }
                    // parser/TCS.g:1319:123: ( ( 'and' ) temp= tcs_atomexp )*
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( (LA123_0==111) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // parser/TCS.g:1319:124: ( 'and' ) temp= tcs_atomexp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:1319:141: ( 'and' )
                    	    // parser/TCS.g:1319:142: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDE54F0EB3C3A411DE891E00216A684158");
                    	    }
                    	    match(input,111,FOLLOW_111_in_tcs_andexp7266); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp7273);
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
                    	    break loop123;
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
    // parser/TCS.g:1327:1: tcs_atomexp returns [Object ret2] : (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp ) ;
    public final Object tcs_atomexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1328:3: ( (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp ) )
            // parser/TCS.g:1329:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )
            {
            // parser/TCS.g:1329:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )
            int alt125=5;
            alt125 = dfa125.predict(input);
            switch (alt125) {
                case 1 :
                    // parser/TCS.g:1329:4: ret= tcs_equalsexp
                    {
                    pushFollow(FOLLOW_tcs_equalsexp_in_tcs_atomexp7318);
                    ret=tcs_equalsexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1330:5: ret= tcs_booleanpropertyexp
                    {
                    pushFollow(FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp7326);
                    ret=tcs_booleanpropertyexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1331:5: ret= tcs_isdefinedexp
                    {
                    pushFollow(FOLLOW_tcs_isdefinedexp_in_tcs_atomexp7334);
                    ret=tcs_isdefinedexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1332:5: ret= tcs_oneexp
                    {
                    pushFollow(FOLLOW_tcs_oneexp_in_tcs_atomexp7342);
                    ret=tcs_oneexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1333:5: ret= tcs_instanceofexp
                    {
                    pushFollow(FOLLOW_tcs_instanceofexp_in_tcs_atomexp7350);
                    ret=tcs_instanceofexp();

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
    // parser/TCS.g:1340:1: tcs_equalsexp returns [Object ret2] : ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) ) ;
    public final Object tcs_equalsexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EqualsExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1345:3: ( ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) ) )
            // parser/TCS.g:1346:3: ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) )
            {
            // parser/TCS.g:1346:3: ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) )
            // parser/TCS.g:1346:4: (temp= tcs_propertyreference ) EQ (temp= tcs_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55158A3C3A411DEA69700216A684158");
            }
            // parser/TCS.g:1346:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1346:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_equalsexp7384);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55158A4C3A411DECC1700216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_equalsexp7391); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55158A6C3A411DEBED400216A684158");
            }
            // parser/TCS.g:1346:293: (temp= tcs_value )
            // parser/TCS.g:1346:295: temp= tcs_value
            {
            pushFollow(FOLLOW_tcs_value_in_tcs_equalsexp7399);
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
    // parser/TCS.g:1354:1: tcs_booleanpropertyexp returns [Object ret2] : ( (temp= tcs_propertyreference ) ) ;
    public final Object tcs_booleanpropertyexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","BooleanPropertyExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1359:3: ( ( (temp= tcs_propertyreference ) ) )
            // parser/TCS.g:1360:3: ( (temp= tcs_propertyreference ) )
            {
            // parser/TCS.g:1360:3: ( (temp= tcs_propertyreference ) )
            // parser/TCS.g:1360:4: (temp= tcs_propertyreference )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55158ABC3A411DE863400216A684158");
            }
            // parser/TCS.g:1360:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1360:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_booleanpropertyexp7446);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
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
    // parser/TCS.g:1368:1: tcs_isdefinedexp returns [Object ret2] : ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN ) ;
    public final Object tcs_isdefinedexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IsDefinedExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1373:3: ( ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN ) )
            // parser/TCS.g:1374:3: ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN )
            {
            // parser/TCS.g:1374:3: ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN )
            // parser/TCS.g:1374:4: 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9A0C3A411DECCA700216A684158");
            }
            match(input,94,FOLLOW_94_in_tcs_isdefinedexp7489); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9A1C3A411DE918F00216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_isdefinedexp7493); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9A3C3A411DEBFD600216A684158");
            }
            // parser/TCS.g:1374:232: (temp= tcs_propertyreference )
            // parser/TCS.g:1374:234: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_isdefinedexp7501);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9A4C3A411DE874900216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_isdefinedexp7508); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1382:1: tcs_oneexp returns [Object ret2] : ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN ) ;
    public final Object tcs_oneexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OneExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1387:3: ( ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN ) )
            // parser/TCS.g:1388:3: ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN )
            {
            // parser/TCS.g:1388:3: ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN )
            // parser/TCS.g:1388:4: 'one' LPAREN (temp= tcs_propertyreference ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9A8C3A411DE92D700216A684158");
            }
            match(input,51,FOLLOW_51_in_tcs_oneexp7549); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9A9C3A411DE920F00216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_oneexp7553); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9ABC3A411DE813800216A684158");
            }
            // parser/TCS.g:1388:226: (temp= tcs_propertyreference )
            // parser/TCS.g:1388:228: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_oneexp7561);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9ACC3A411DE9EEA00216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_oneexp7568); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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


    // $ANTLR start "tcs_instanceofexp"
    // parser/TCS.g:1396:1: tcs_instanceofexp returns [Object ret2] : ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) ;
    public final Object tcs_instanceofexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","InstanceOfExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1401:3: ( ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) )
            // parser/TCS.g:1402:3: ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
            {
            // parser/TCS.g:1402:3: ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
            // parser/TCS.g:1402:4: (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9B1C3A411DE9B7B00216A684158");
            }
            // parser/TCS.g:1402:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1402:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_instanceofexp7613);
            temp=tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9B2C3A411DEA1B700216A684158");
            }
            match(input,104,FOLLOW_104_in_tcs_instanceofexp7619); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE553C9B7C3A411DE868D00216A684158");
            }
            // parser/TCS.g:1402:301: (temp= identifier ( ( DLCOLON ) temp= identifier )* )
            // parser/TCS.g:1402:303: temp= identifier ( ( DLCOLON ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_tcs_instanceofexp7626);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "supertype", temp);
            }
            // parser/TCS.g:1402:358: ( ( DLCOLON ) temp= identifier )*
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==DLCOLON) ) {
                    alt126=1;
                }


                switch (alt126) {
            	case 1 :
            	    // parser/TCS.g:1402:359: ( DLCOLON ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:1402:376: ( DLCOLON )
            	    // parser/TCS.g:1402:377: DLCOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CDE553C9B4C3A411DE883D00216A684158");
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_tcs_instanceofexp7635); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_tcs_instanceofexp7643);
            	    temp=identifier();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "supertype", temp);
            	    }

            	    }
            	    break;

            	default :
            	    break loop126;
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
    // $ANTLR end "tcs_instanceofexp"


    // $ANTLR start "tcs_value"
    // parser/TCS.g:1410:1: tcs_value returns [Object ret2] : (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) ;
    public final Object tcs_value() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1411:3: ( (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) )
            // parser/TCS.g:1412:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            {
            // parser/TCS.g:1412:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            int alt127=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt127=1;
                }
                break;
            case INT:
                {
                alt127=2;
                }
                break;
            case MINUS:
                {
                alt127=3;
                }
                break;
            case SHARP:
                {
                alt127=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }

            switch (alt127) {
                case 1 :
                    // parser/TCS.g:1412:4: ret= tcs_stringval
                    {
                    pushFollow(FOLLOW_tcs_stringval_in_tcs_value7686);
                    ret=tcs_stringval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1413:5: ret= tcs_integerval
                    {
                    pushFollow(FOLLOW_tcs_integerval_in_tcs_value7694);
                    ret=tcs_integerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1414:5: ret= tcs_negativeintegerval
                    {
                    pushFollow(FOLLOW_tcs_negativeintegerval_in_tcs_value7702);
                    ret=tcs_negativeintegerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1415:5: ret= tcs_enumliteralval
                    {
                    pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_value7710);
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
    // parser/TCS.g:1422:1: tcs_stringval returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_stringval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1427:3: ( ( (temp= stringSymbol ) ) )
            // parser/TCS.g:1428:3: ( (temp= stringSymbol ) )
            {
            // parser/TCS.g:1428:3: ( (temp= stringSymbol ) )
            // parser/TCS.g:1428:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5563AA4C3A411DEA25700216A684158");
            }
            // parser/TCS.g:1428:63: (temp= stringSymbol )
            // parser/TCS.g:1428:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_stringval7744);
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
    // parser/TCS.g:1436:1: tcs_integerval returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object tcs_integerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1441:3: ( ( (temp= integerSymbol ) ) )
            // parser/TCS.g:1442:3: ( (temp= integerSymbol ) )
            {
            // parser/TCS.g:1442:3: ( (temp= integerSymbol ) )
            // parser/TCS.g:1442:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5588491C3A411DEBE3E00216A684158");
            }
            // parser/TCS.g:1442:63: (temp= integerSymbol )
            // parser/TCS.g:1442:65: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_integerval7791);
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
    // parser/TCS.g:1450:1: tcs_negativeintegerval returns [Object ret2] : ( MINUS (temp= integerSymbol ) ) ;
    public final Object tcs_negativeintegerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NegativeIntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1455:3: ( ( MINUS (temp= integerSymbol ) ) )
            // parser/TCS.g:1456:3: ( MINUS (temp= integerSymbol ) )
            {
            // parser/TCS.g:1456:3: ( MINUS (temp= integerSymbol ) )
            // parser/TCS.g:1456:4: MINUS (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5588495C3A411DEB21600216A684158");
            }
            match(input,MINUS,FOLLOW_MINUS_in_tcs_negativeintegerval7835); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5588497C3A411DE8C3C00216A684158");
            }
            // parser/TCS.g:1456:145: (temp= integerSymbol )
            // parser/TCS.g:1456:147: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_negativeintegerval7843);
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
    // parser/TCS.g:1464:1: tcs_enumliteralval returns [Object ret2] : ( SHARP (temp= identifierOrKeyword ) ) ;
    public final Object tcs_enumliteralval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1469:3: ( ( SHARP (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:1470:3: ( SHARP (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:1470:3: ( SHARP (temp= identifierOrKeyword ) )
            // parser/TCS.g:1470:4: SHARP (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE558849BC3A411DEA01C00216A684158");
            }
            match(input,SHARP,FOLLOW_SHARP_in_tcs_enumliteralval7887); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE558849EC3A411DEBC6800216A684158");
            }
            // parser/TCS.g:1470:145: (temp= identifierOrKeyword )
            // parser/TCS.g:1470:147: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_enumliteralval7895);
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
    // parser/TCS.g:1478:1: tcs_token returns [Object ret2] : ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI ) ;
    public final Object tcs_token() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Token");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1483:3: ( ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI ) )
            // parser/TCS.g:1484:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI )
            {
            // parser/TCS.g:1484:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI )
            // parser/TCS.g:1484:4: ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55AF595C3A411DEA50A00216A684158");
            }
            // parser/TCS.g:1484:64: ( ( 'omitted' ) | )
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==97) ) {
                alt128=1;
            }
            else if ( (LA128_0==74) ) {
                alt128=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }
            switch (alt128) {
                case 1 :
                    // parser/TCS.g:1484:65: ( 'omitted' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1484:81: ( 'omitted' )
                    // parser/TCS.g:1484:82: 'omitted'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE55AF593C3A411DE9CDA00216A684158");
                    }
                    match(input,97,FOLLOW_97_in_tcs_token7944); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1484:240: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);
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
              _beforeSeqEl("E0DCF6CDE55AF596C3A411DEB3B500216A684158");
            }
            match(input,74,FOLLOW_74_in_tcs_token7962); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55AF598C3A411DEA4F400216A684158");
            }
            // parser/TCS.g:1485:158: (temp= identifier )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==NAME) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // parser/TCS.g:1485:160: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_token7969);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55AF599C3A411DE939000216A684158");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_token7978); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55AF59BC3A411DECE6D00216A684158");
            }
            // parser/TCS.g:1485:369: (temp= tcs_orpattern )
            // parser/TCS.g:1485:371: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_token7986);
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
              _beforeSeqEl("E0DCF6CDE55AF59CC3A411DEAB0200216A684158");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_token7993); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1493:1: tcs_orpattern returns [Object ret2] : ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? ) ;
    public final Object tcs_orpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OrPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1498:3: ( ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? ) )
            // parser/TCS.g:1499:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? )
            {
            // parser/TCS.g:1499:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? )
            // parser/TCS.g:1499:4: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55AF5A4C3A411DE84D700216A684158");
            }
            // parser/TCS.g:1499:63: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )?
            int alt131=2;
            switch ( input.LA(1) ) {
                case STRING:
                case LSQUARE:
                case PIPE:
                case 63:
                case 72:
                case 76:
                    {
                    alt131=1;
                    }
                    break;
                case SEMI:
                    {
                    int LA131_2 = input.LA(2);

                    if ( (synpred249_TCS()) ) {
                        alt131=1;
                    }
                    }
                    break;
                case COMA:
                    {
                    int LA131_3 = input.LA(2);

                    if ( (synpred249_TCS()) ) {
                        alt131=1;
                    }
                    }
                    break;
                case RPAREN:
                    {
                    int LA131_4 = input.LA(2);

                    if ( (synpred249_TCS()) ) {
                        alt131=1;
                    }
                    }
                    break;
                case EOF:
                    {
                    int LA131_5 = input.LA(2);

                    if ( (synpred249_TCS()) ) {
                        alt131=1;
                    }
                    }
                    break;
            }

            switch (alt131) {
                case 1 :
                    // parser/TCS.g:1499:65: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
                    {
                    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern8038);
                    temp=tcs_simplepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "simplePatterns", temp);
                    }
                    // parser/TCS.g:1499:132: ( ( PIPE ) temp= tcs_simplepattern )*
                    loop130:
                    do {
                        int alt130=2;
                        int LA130_0 = input.LA(1);

                        if ( (LA130_0==PIPE) ) {
                            alt130=1;
                        }


                        switch (alt130) {
                    	case 1 :
                    	    // parser/TCS.g:1499:133: ( PIPE ) temp= tcs_simplepattern
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:1499:150: ( PIPE )
                    	    // parser/TCS.g:1499:151: PIPE
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDE55AF5A1C3A411DEB07500216A684158");
                    	    }
                    	    match(input,PIPE,FOLLOW_PIPE_in_tcs_orpattern8047); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern8055);
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
                    	    break loop130;
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
    // $ANTLR end "tcs_orpattern"


    // $ANTLR start "tcs_simplepattern"
    // parser/TCS.g:1507:1: tcs_simplepattern returns [Object ret2] : (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) ;
    public final Object tcs_simplepattern() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1508:3: ( (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) )
            // parser/TCS.g:1509:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            {
            // parser/TCS.g:1509:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            int alt132=3;
            switch ( input.LA(1) ) {
            case 63:
            case 72:
            case 76:
                {
                alt132=1;
                }
                break;
            case EOF:
            case STRING:
            case RPAREN:
            case SEMI:
            case COMA:
            case PIPE:
                {
                alt132=2;
                }
                break;
            case LSQUARE:
                {
                alt132=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }

            switch (alt132) {
                case 1 :
                    // parser/TCS.g:1509:4: ret= tcs_rulepattern
                    {
                    pushFollow(FOLLOW_tcs_rulepattern_in_tcs_simplepattern8100);
                    ret=tcs_rulepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1510:5: ret= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_simplepattern8108);
                    ret=tcs_stringpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1511:5: ret= tcs_classpattern
                    {
                    pushFollow(FOLLOW_tcs_classpattern_in_tcs_simplepattern8116);
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
    // parser/TCS.g:1518:1: tcs_rulepattern returns [Object ret2] : ( (temp= tcs_rule ) ) ;
    public final Object tcs_rulepattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RulePattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1523:3: ( ( (temp= tcs_rule ) ) )
            // parser/TCS.g:1524:3: ( (temp= tcs_rule ) )
            {
            // parser/TCS.g:1524:3: ( (temp= tcs_rule ) )
            // parser/TCS.g:1524:4: (temp= tcs_rule )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F83C3A411DEAF0900216A684158");
            }
            // parser/TCS.g:1524:63: (temp= tcs_rule )
            // parser/TCS.g:1524:65: temp= tcs_rule
            {
            pushFollow(FOLLOW_tcs_rule_in_tcs_rulepattern8150);
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
    // parser/TCS.g:1532:1: tcs_rule returns [Object ret2] : (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) ;
    public final Object tcs_rule() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1533:3: ( (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) )
            // parser/TCS.g:1534:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            {
            // parser/TCS.g:1534:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            int alt133=3;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt133=1;
                }
                break;
            case 63:
                {
                alt133=2;
                }
                break;
            case 72:
                {
                alt133=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // parser/TCS.g:1534:4: ret= tcs_wordrule
                    {
                    pushFollow(FOLLOW_tcs_wordrule_in_tcs_rule8190);
                    ret=tcs_wordrule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1535:5: ret= tcs_endoflinerule
                    {
                    pushFollow(FOLLOW_tcs_endoflinerule_in_tcs_rule8198);
                    ret=tcs_endoflinerule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1536:5: ret= tcs_multilinerule
                    {
                    pushFollow(FOLLOW_tcs_multilinerule_in_tcs_rule8206);
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
    // parser/TCS.g:1543:1: tcs_wordrule returns [Object ret2] : ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN ) ;
    public final Object tcs_wordrule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","WordRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1548:3: ( ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN ) )
            // parser/TCS.g:1549:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN )
            {
            // parser/TCS.g:1549:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN )
            // parser/TCS.g:1549:4: 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F89C3A411DEA46600216A684158");
            }
            match(input,76,FOLLOW_76_in_tcs_wordrule8236); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F8AC3A411DE860300216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_wordrule8240); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F8BC3A411DEBA7C00216A684158");
            }
            match(input,49,FOLLOW_49_in_tcs_wordrule8244); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F8CC3A411DEC52F00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8248); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F8EC3A411DEBF6600216A684158");
            }
            // parser/TCS.g:1549:388: (temp= tcs_orpattern )
            // parser/TCS.g:1549:390: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8256);
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
              _beforeSeqEl("E0DCF6CDE55D3F8FC3A411DEBCC700216A684158");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_wordrule8263); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F90C3A411DE9CDB00216A684158");
            }
            match(input,86,FOLLOW_86_in_tcs_wordrule8267); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F91C3A411DE961A00216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8271); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55D3F93C3A411DE92EF00216A684158");
            }
            // parser/TCS.g:1549:760: (temp= tcs_orpattern )
            // parser/TCS.g:1549:762: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8279);
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
              _beforeSeqEl("E0DCF6CDE55FB085C3A411DEAC9500216A684158");
            }
            // parser/TCS.g:1549:891: ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | )
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==COMA) ) {
                alt134=1;
            }
            else if ( (LA134_0==RPAREN) ) {
                alt134=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }
            switch (alt134) {
                case 1 :
                    // parser/TCS.g:1549:892: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1549:908: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    // parser/TCS.g:1549:909: COMA 'end' EQ (temp= tcs_orpattern )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE55D3F97C3A411DE84C400216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_wordrule8292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE55FB080C3A411DEAD0500216A684158");
                    }
                    match(input,81,FOLLOW_81_in_tcs_wordrule8296); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE55FB081C3A411DE9CB200216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8300); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE55FB083C3A411DEBD2E00216A684158");
                    }
                    // parser/TCS.g:1549:1208: (temp= tcs_orpattern )
                    // parser/TCS.g:1549:1210: temp= tcs_orpattern
                    {
                    pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8308);
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
                    // parser/TCS.g:1549:1296: 
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
              _beforeSeqEl("E0DCF6CDE55FB086C3A411DE9F4F00216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_wordrule8328); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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


    // $ANTLR start "tcs_endoflinerule"
    // parser/TCS.g:1558:1: tcs_endoflinerule returns [Object ret2] : ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) ;
    public final Object tcs_endoflinerule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EndOfLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1563:3: ( ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) )
            // parser/TCS.g:1564:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            {
            // parser/TCS.g:1564:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            // parser/TCS.g:1564:4: 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55FB08AC3A411DE912E00216A684158");
            }
            match(input,63,FOLLOW_63_in_tcs_endoflinerule8369); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55FB08BC3A411DE841200216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_endoflinerule8373); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55FB08CC3A411DE9F0200216A684158");
            }
            match(input,49,FOLLOW_49_in_tcs_endoflinerule8377); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55FB08DC3A411DE958000216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endoflinerule8381); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE55FB093C3A411DEA42600216A684158");
            }
            // parser/TCS.g:1564:394: ( ( 'drop' ) | )
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==98) ) {
                alt135=1;
            }
            else if ( (LA135_0==EOF||LA135_0==STRING||LA135_0==RPAREN||LA135_0==SEMI||LA135_0==COMA||LA135_0==PIPE) ) {
                alt135=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }
            switch (alt135) {
                case 1 :
                    // parser/TCS.g:1564:395: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1564:411: ( 'drop' )
                    // parser/TCS.g:1564:412: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE55FB091C3A411DEA19300216A684158");
                    }
                    match(input,98,FOLLOW_98_in_tcs_endoflinerule8391); if (state.failed) return ret2;
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
                    // parser/TCS.g:1564:567: 
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
              _beforeSeqEl("E0DCF6CDE55FB095C3A411DE87C900216A684158");
            }
            // parser/TCS.g:1565:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1565:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_endoflinerule8413);
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
              _beforeSeqEl("E0DCF6CDE55FB096C3A411DEA6D400216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_endoflinerule8420); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1573:1: tcs_multilinerule returns [Object ret2] : ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) ;
    public final Object tcs_multilinerule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","MultiLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1578:3: ( ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) )
            // parser/TCS.g:1579:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            {
            // parser/TCS.g:1579:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            // parser/TCS.g:1579:4: 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5622180C3A411DEB3DA00216A684158");
            }
            match(input,72,FOLLOW_72_in_tcs_multilinerule8461); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5622181C3A411DEA31B00216A684158");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule8465); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5622182C3A411DE950700216A684158");
            }
            match(input,49,FOLLOW_49_in_tcs_multilinerule8469); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5622183C3A411DEA3B100216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8473); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5622189C3A411DECB1100216A684158");
            }
            // parser/TCS.g:1579:394: ( ( 'drop' ) | )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==98) ) {
                alt136=1;
            }
            else if ( (LA136_0==EOF||LA136_0==STRING||LA136_0==RPAREN||LA136_0==SEMI||LA136_0==COMA||LA136_0==PIPE) ) {
                alt136=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }
            switch (alt136) {
                case 1 :
                    // parser/TCS.g:1579:395: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1579:411: ( 'drop' )
                    // parser/TCS.g:1579:412: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5622187C3A411DEC2E100216A684158");
                    }
                    match(input,98,FOLLOW_98_in_tcs_multilinerule8483); if (state.failed) return ret2;
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
                    // parser/TCS.g:1579:567: 
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
              _beforeSeqEl("E0DCF6CDE562218BC3A411DEBF3E00216A684158");
            }
            // parser/TCS.g:1580:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1580:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8505);
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
              _beforeSeqEl("E0DCF6CDE562218CC3A411DEA96900216A684158");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8512); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE562218DC3A411DE9C0B00216A684158");
            }
            match(input,81,FOLLOW_81_in_tcs_multilinerule8516); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE562218EC3A411DEAA4900216A684158");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8520); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5622194C3A411DEB6EA00216A684158");
            }
            // parser/TCS.g:1580:452: ( ( 'drop' ) | )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==98) ) {
                alt137=1;
            }
            else if ( (LA137_0==EOF||LA137_0==STRING||LA137_0==RPAREN||LA137_0==SEMI||LA137_0==COMA||LA137_0==PIPE) ) {
                alt137=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }
            switch (alt137) {
                case 1 :
                    // parser/TCS.g:1580:453: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1580:469: ( 'drop' )
                    // parser/TCS.g:1580:470: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE5622192C3A411DEBDA400216A684158");
                    }
                    match(input,98,FOLLOW_98_in_tcs_multilinerule8530); if (state.failed) return ret2;
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
                    // parser/TCS.g:1580:623: 
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
              _beforeSeqEl("E0DCF6CDE5622196C3A411DE9F4300216A684158");
            }
            // parser/TCS.g:1581:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1581:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8552);
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
              _beforeSeqEl("E0DCF6CDE56221ADC3A411DE9A4F00216A684158");
            }
            // parser/TCS.g:1581:210: ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==COMA) ) {
                alt141=1;
            }
            else if ( (LA141_0==RPAREN) ) {
                alt141=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }
            switch (alt141) {
                case 1 :
                    // parser/TCS.g:1581:211: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1581:227: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    // parser/TCS.g:1581:228: COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE562219AC3A411DEC7B400216A684158");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8565); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE562219BC3A411DEB4DF00216A684158");
                    }
                    match(input,101,FOLLOW_101_in_tcs_multilinerule8569); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE562219CC3A411DE935700216A684158");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8573); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDE562219EC3A411DEC33200216A684158");
                    }
                    // parser/TCS.g:1581:527: (temp= tcs_stringpattern )
                    // parser/TCS.g:1581:529: temp= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8581);
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
                      _beforeSeqEl("E0DCF6CDE56221ABC3A411DEC0F000216A684158");
                    }
                    // parser/TCS.g:1581:661: ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    int alt140=2;
                    int LA140_0 = input.LA(1);

                    if ( (LA140_0==COMA) ) {
                        alt140=1;
                    }
                    else if ( (LA140_0==RPAREN) ) {
                        alt140=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 140, 0, input);

                        throw nvae;
                    }
                    switch (alt140) {
                        case 1 :
                            // parser/TCS.g:1581:662: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:1581:678: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            // parser/TCS.g:1581:679: COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE56221A2C3A411DEB1D300216A684158");
                            }
                            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8594); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE56221A3C3A411DEB2F100216A684158");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule8599); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE56221A8C3A411DECDF200216A684158");
                            }
                            // parser/TCS.g:1581:902: (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )?
                            int alt139=2;
                            int LA139_0 = input.LA(1);

                            if ( (LA139_0==NAME||LA139_0==POINT||LA139_0==48||LA139_0==117) ) {
                                alt139=1;
                            }
                            switch (alt139) {
                                case 1 :
                                    // parser/TCS.g:1581:904: temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )*
                                    {
                                    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule8607);
                                    temp=tcs_mapping();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "escMappings", temp);
                                    }
                                    // parser/TCS.g:1581:962: ( ( COMA ) temp= tcs_mapping )*
                                    loop138:
                                    do {
                                        int alt138=2;
                                        int LA138_0 = input.LA(1);

                                        if ( (LA138_0==COMA) ) {
                                            alt138=1;
                                        }


                                        switch (alt138) {
                                    	case 1 :
                                    	    // parser/TCS.g:1581:963: ( COMA ) temp= tcs_mapping
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _enterSepSeq();
                                    	    }
                                    	    // parser/TCS.g:1581:980: ( COMA )
                                    	    // parser/TCS.g:1581:981: COMA
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _beforeSeqEl("E0DCF6CDE56221A5C3A411DEAFB100216A684158");
                                    	    }
                                    	    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8616); if (state.failed) return ret2;
                                    	    if ( state.backtracking==0 ) {
                                    	      _afterSeqEl();
                                    	    }

                                    	    }

                                    	    if ( state.backtracking==0 ) {
                                    	      _exitSepSeq();
                                    	    }
                                    	    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule8624);
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
                                    	    break loop138;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDE56221A9C3A411DEC1B300216A684158");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule8636); if (state.failed) return ret2;
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
                            // parser/TCS.g:1581:1260: 
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
                    // parser/TCS.g:1582:35: 
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
              _beforeSeqEl("E0DCF6CDE56221AEC3A411DEBDA700216A684158");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule8667); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1591:1: tcs_mapping returns [Object ret2] : (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) ;
    public final Object tcs_mapping() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1592:3: ( (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) )
            // parser/TCS.g:1593:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            {
            // parser/TCS.g:1593:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            int alt142=4;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt142=1;
                }
                break;
            case POINT:
                {
                alt142=2;
                }
                break;
            case 48:
                {
                alt142=3;
                }
                break;
            case 117:
                {
                alt142=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 142, 0, input);

                throw nvae;
            }

            switch (alt142) {
                case 1 :
                    // parser/TCS.g:1593:4: ret= tcs_simplemapping
                    {
                    pushFollow(FOLLOW_tcs_simplemapping_in_tcs_mapping8705);
                    ret=tcs_simplemapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1594:5: ret= tcs_wildcardmapping
                    {
                    pushFollow(FOLLOW_tcs_wildcardmapping_in_tcs_mapping8713);
                    ret=tcs_wildcardmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1595:5: ret= tcs_octalmapping
                    {
                    pushFollow(FOLLOW_tcs_octalmapping_in_tcs_mapping8721);
                    ret=tcs_octalmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1596:5: ret= tcs_hexadecimalmapping
                    {
                    pushFollow(FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping8729);
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
    // parser/TCS.g:1603:1: tcs_simplemapping returns [Object ret2] : ( (temp= identifier ) RARROW (temp= identifier ) ) ;
    public final Object tcs_simplemapping() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SimpleMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1608:3: ( ( (temp= identifier ) RARROW (temp= identifier ) ) )
            // parser/TCS.g:1609:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            {
            // parser/TCS.g:1609:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            // parser/TCS.g:1609:4: (temp= identifier ) RARROW (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5646B73C3A411DE905200216A684158");
            }
            // parser/TCS.g:1609:63: (temp= identifier )
            // parser/TCS.g:1609:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping8763);
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
              _beforeSeqEl("E0DCF6CDE5646B74C3A411DEB4AC00216A684158");
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_simplemapping8770); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5646B76C3A411DE8C6900216A684158");
            }
            // parser/TCS.g:1609:272: (temp= identifier )
            // parser/TCS.g:1609:274: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping8778);
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
    // parser/TCS.g:1617:1: tcs_wildcardmapping returns [Object ret2] : ( POINT RARROW POINT ) ;
    public final Object tcs_wildcardmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","WildcardMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1622:3: ( ( POINT RARROW POINT ) )
            // parser/TCS.g:1623:3: ( POINT RARROW POINT )
            {
            // parser/TCS.g:1623:3: ( POINT RARROW POINT )
            // parser/TCS.g:1623:4: POINT RARROW POINT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5646B7AC3A411DECA1500216A684158");
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping8822); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5646B7BC3A411DEBA6400216A684158");
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_wildcardmapping8827); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5646B7CC3A411DEB6F400216A684158");
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping8832); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1631:1: tcs_octalmapping returns [Object ret2] : ( 'octal' ) ;
    public final Object tcs_octalmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","OctalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1636:3: ( ( 'octal' ) )
            // parser/TCS.g:1637:3: ( 'octal' )
            {
            // parser/TCS.g:1637:3: ( 'octal' )
            // parser/TCS.g:1637:4: 'octal'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE566DC70C3A411DEABA700216A684158");
            }
            match(input,48,FOLLOW_48_in_tcs_octalmapping8873); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1645:1: tcs_hexadecimalmapping returns [Object ret2] : ( 'hex' ) ;
    public final Object tcs_hexadecimalmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","HexadecimalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1650:3: ( ( 'hex' ) )
            // parser/TCS.g:1651:3: ( 'hex' )
            {
            // parser/TCS.g:1651:3: ( 'hex' )
            // parser/TCS.g:1651:4: 'hex'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE566DC74C3A411DEB44000216A684158");
            }
            match(input,117,FOLLOW_117_in_tcs_hexadecimalmapping8913); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1659:1: tcs_stringpattern returns [Object ret2] : ( (temp= stringSymbol )? ) ;
    public final Object tcs_stringpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1664:3: ( ( (temp= stringSymbol )? ) )
            // parser/TCS.g:1665:3: ( (temp= stringSymbol )? )
            {
            // parser/TCS.g:1665:3: ( (temp= stringSymbol )? )
            // parser/TCS.g:1665:4: (temp= stringSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE566DC7AC3A411DEAB1100216A684158");
            }
            // parser/TCS.g:1665:63: (temp= stringSymbol )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==STRING) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // parser/TCS.g:1665:65: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_stringpattern8957);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
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
    // $ANTLR end "tcs_stringpattern"


    // $ANTLR start "tcs_classpattern"
    // parser/TCS.g:1673:1: tcs_classpattern returns [Object ret2] : ( LSQUARE (temp= identifier )? RSQUARE ) ;
    public final Object tcs_classpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1678:3: ( ( LSQUARE (temp= identifier )? RSQUARE ) )
            // parser/TCS.g:1679:3: ( LSQUARE (temp= identifier )? RSQUARE )
            {
            // parser/TCS.g:1679:3: ( LSQUARE (temp= identifier )? RSQUARE )
            // parser/TCS.g:1679:4: LSQUARE (temp= identifier )? RSQUARE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5692660C3A411DEB13600216A684158");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_classpattern9003); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5692662C3A411DE817200216A684158");
            }
            // parser/TCS.g:1679:147: (temp= identifier )?
            int alt144=2;
            int LA144_0 = input.LA(1);

            if ( (LA144_0==NAME) ) {
                alt144=1;
            }
            switch (alt144) {
                case 1 :
                    // parser/TCS.g:1679:149: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_classpattern9011);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDE5692663C3A411DEBA6500216A684158");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_classpattern9020); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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

    // $ANTLR start synpred88_TCS
    public final void synpred88_TCS_fragment() throws RecognitionException {   
        // parser/TCS.g:369:36: ( DLCOLON )
        // parser/TCS.g:369:37: DLCOLON
        {
        match(input,DLCOLON,FOLLOW_DLCOLON_in_synpred88_TCS1053); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_TCS

    // $ANTLR start synpred114_TCS
    public final void synpred114_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:489:159: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:489:159: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred114_TCS1935);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred114_TCS

    // $ANTLR start synpred119_TCS
    public final void synpred119_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:505:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:505:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred119_TCS2095);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred119_TCS

    // $ANTLR start synpred136_TCS
    public final void synpred136_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:549:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:549:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred136_TCS2734);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred136_TCS

    // $ANTLR start synpred147_TCS
    public final void synpred147_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:571:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:571:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred147_TCS3159);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred147_TCS

    // $ANTLR start synpred152_TCS
    public final void synpred152_TCS_fragment() throws RecognitionException {   
        Object ret = null;


        // parser/TCS.g:623:4: (ret= tcs_sequence__impl )
        // parser/TCS.g:623:4: ret= tcs_sequence__impl
        {
        pushFollow(FOLLOW_tcs_sequence__impl_in_synpred152_TCS3436);
        ret=tcs_sequence__impl();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred152_TCS

    // $ANTLR start synpred161_TCS
    public final void synpred161_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:666:1726: (temp= identifierOrKeyword )
        // parser/TCS.g:666:1726: temp= identifierOrKeyword
        {
        pushFollow(FOLLOW_identifierOrKeyword_in_synpred161_TCS3640);
        temp=identifierOrKeyword();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred161_TCS

    // $ANTLR start synpred168_TCS
    public final void synpred168_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:725:148: (temp= tcs_expression )
        // parser/TCS.g:725:148: temp= tcs_expression
        {
        pushFollow(FOLLOW_tcs_expression_in_synpred168_TCS3992);
        temp=tcs_expression();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred168_TCS

    // $ANTLR start synpred171_TCS
    public final void synpred171_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:740:150: (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )
        // parser/TCS.g:740:150: temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )*
        {
        pushFollow(FOLLOW_tcs_sequenceinalternative_in_synpred171_TCS4103);
        temp=tcs_sequenceinalternative();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // parser/TCS.g:740:220: ( ( PIPE ) temp= tcs_sequenceinalternative )*
        loop171:
        do {
            int alt171=2;
            int LA171_0 = input.LA(1);

            if ( (LA171_0==PIPE) ) {
                alt171=1;
            }


            switch (alt171) {
        	case 1 :
        	    // parser/TCS.g:740:221: ( PIPE ) temp= tcs_sequenceinalternative
        	    {
        	    // parser/TCS.g:740:238: ( PIPE )
        	    // parser/TCS.g:740:239: PIPE
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("E0DCF6CDE50C6077C3A411DE9B3700216A684158");
        	    }
        	    match(input,PIPE,FOLLOW_PIPE_in_synpred171_TCS4112); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_tcs_sequenceinalternative_in_synpred171_TCS4120);
        	    temp=tcs_sequenceinalternative();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop171;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred171_TCS

    // $ANTLR start synpred183_TCS
    public final void synpred183_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:849:375: ( ( COMA 'mode' EQ (temp= stringSymbol ) ) )
        // parser/TCS.g:849:375: ( COMA 'mode' EQ (temp= stringSymbol ) )
        {
        if ( state.backtracking==0 ) {
          _enterAlt(0);
        }
        // parser/TCS.g:849:391: ( COMA 'mode' EQ (temp= stringSymbol ) )
        // parser/TCS.g:849:392: COMA 'mode' EQ (temp= stringSymbol )
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl("E0DCF6CDE5184752C3A411DECDEB00216A684158");
        }
        match(input,COMA,FOLLOW_COMA_in_synpred183_TCS4772); if (state.failed) return ;
        match(input,78,FOLLOW_78_in_synpred183_TCS4776); if (state.failed) return ;
        match(input,EQ,FOLLOW_EQ_in_synpred183_TCS4780); if (state.failed) return ;
        // parser/TCS.g:849:692: (temp= stringSymbol )
        // parser/TCS.g:849:694: temp= stringSymbol
        {
        pushFollow(FOLLOW_stringSymbol_in_synpred183_TCS4788);
        temp=stringSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred183_TCS

    // $ANTLR start synpred249_TCS
    public final void synpred249_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:1499:65: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )
        // parser/TCS.g:1499:65: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
        {
        pushFollow(FOLLOW_tcs_simplepattern_in_synpred249_TCS8038);
        temp=tcs_simplepattern();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // parser/TCS.g:1499:132: ( ( PIPE ) temp= tcs_simplepattern )*
        loop184:
        do {
            int alt184=2;
            int LA184_0 = input.LA(1);

            if ( (LA184_0==PIPE) ) {
                alt184=1;
            }


            switch (alt184) {
        	case 1 :
        	    // parser/TCS.g:1499:133: ( PIPE ) temp= tcs_simplepattern
        	    {
        	    // parser/TCS.g:1499:150: ( PIPE )
        	    // parser/TCS.g:1499:151: PIPE
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("E0DCF6CDE55AF5A1C3A411DEB07500216A684158");
        	    }
        	    match(input,PIPE,FOLLOW_PIPE_in_synpred249_TCS8047); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_tcs_simplepattern_in_synpred249_TCS8055);
        	    temp=tcs_simplepattern();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop184;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred249_TCS

    // Delegated rules

    public final boolean synpred147_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred147_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred136_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred183_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred183_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred171_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred171_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred161_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred161_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred249_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred249_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred168_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred168_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred152_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred152_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA27 dfa27 = new DFA27(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA125 dfa125 = new DFA125(this);
    static final String DFA27_eotS =
        "\20\uffff";
    static final String DFA27_eofS =
        "\1\15\17\uffff";
    static final String DFA27_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA27_maxS =
        "\1\u0084\15\0\2\uffff";
    static final String DFA27_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA27_specialS =
        "\1\uffff\1\6\1\11\1\1\1\12\1\4\1\14\1\7\1\2\1\13\1\0\1\5\1\10\1"+
        "\3\2\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\14\57\uffff\1\3\1\10\12\uffff\1\1\1\12\1\4\3\uffff\1\5\12"+
            "\uffff\1\13\6\uffff\1\11\10\uffff\1\2\26\uffff\1\7\2\uffff\1"+
            "\6",
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

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "489:157: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_10 = input.LA(1);

                         
                        int index27_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_3 = input.LA(1);

                         
                        int index27_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_8 = input.LA(1);

                         
                        int index27_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_13 = input.LA(1);

                         
                        int index27_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_13);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA27_5 = input.LA(1);

                         
                        int index27_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA27_7 = input.LA(1);

                         
                        int index27_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA27_12 = input.LA(1);

                         
                        int index27_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA27_2 = input.LA(1);

                         
                        int index27_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_2);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA27_4 = input.LA(1);

                         
                        int index27_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_4);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA27_9 = input.LA(1);

                         
                        int index27_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA27_6 = input.LA(1);

                         
                        int index27_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred114_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA32_eotS =
        "\20\uffff";
    static final String DFA32_eofS =
        "\1\15\17\uffff";
    static final String DFA32_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA32_maxS =
        "\1\u0084\15\0\2\uffff";
    static final String DFA32_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA32_specialS =
        "\1\uffff\1\6\1\11\1\1\1\12\1\3\1\14\1\7\1\2\1\13\1\0\1\4\1\10\1"+
        "\5\2\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\14\57\uffff\1\3\1\10\12\uffff\1\1\1\12\1\4\3\uffff\1\5\12"+
            "\uffff\1\13\6\uffff\1\11\10\uffff\1\2\26\uffff\1\7\2\uffff\1"+
            "\6",
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

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "505:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA32_10 = input.LA(1);

                         
                        int index32_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_8 = input.LA(1);

                         
                        int index32_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_11 = input.LA(1);

                         
                        int index32_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_13 = input.LA(1);

                         
                        int index32_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_12 = input.LA(1);

                         
                        int index32_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_4);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA32_9 = input.LA(1);

                         
                        int index32_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred119_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 32, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA49_eotS =
        "\20\uffff";
    static final String DFA49_eofS =
        "\1\15\17\uffff";
    static final String DFA49_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA49_maxS =
        "\1\u0084\15\0\2\uffff";
    static final String DFA49_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA49_specialS =
        "\1\uffff\1\6\1\11\1\1\1\12\1\3\1\14\1\7\1\2\1\13\1\0\1\4\1\10\1"+
        "\5\2\uffff}>";
    static final String[] DFA49_transitionS = {
            "\1\14\57\uffff\1\3\1\10\12\uffff\1\1\1\12\1\4\3\uffff\1\5\12"+
            "\uffff\1\13\6\uffff\1\11\10\uffff\1\2\26\uffff\1\7\2\uffff\1"+
            "\6",
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

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "549:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA49_10 = input.LA(1);

                         
                        int index49_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA49_3 = input.LA(1);

                         
                        int index49_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA49_8 = input.LA(1);

                         
                        int index49_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA49_5 = input.LA(1);

                         
                        int index49_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA49_11 = input.LA(1);

                         
                        int index49_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA49_13 = input.LA(1);

                         
                        int index49_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA49_1 = input.LA(1);

                         
                        int index49_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_1);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA49_7 = input.LA(1);

                         
                        int index49_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_7);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA49_12 = input.LA(1);

                         
                        int index49_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA49_2 = input.LA(1);

                         
                        int index49_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_2);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA49_4 = input.LA(1);

                         
                        int index49_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_4);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA49_9 = input.LA(1);

                         
                        int index49_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA49_6 = input.LA(1);

                         
                        int index49_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred136_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 49, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA60_eotS =
        "\20\uffff";
    static final String DFA60_eofS =
        "\1\15\17\uffff";
    static final String DFA60_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA60_maxS =
        "\1\u0084\15\0\2\uffff";
    static final String DFA60_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA60_specialS =
        "\1\uffff\1\5\1\11\1\1\1\12\1\3\1\14\1\6\1\2\1\13\1\0\1\4\1\10\1"+
        "\7\2\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\14\57\uffff\1\3\1\10\12\uffff\1\1\1\12\1\4\3\uffff\1\5\12"+
            "\uffff\1\13\6\uffff\1\11\10\uffff\1\2\26\uffff\1\7\2\uffff\1"+
            "\6",
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

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "571:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA60_10 = input.LA(1);

                         
                        int index60_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_3 = input.LA(1);

                         
                        int index60_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_8 = input.LA(1);

                         
                        int index60_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA60_5 = input.LA(1);

                         
                        int index60_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA60_11 = input.LA(1);

                         
                        int index60_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA60_7 = input.LA(1);

                         
                        int index60_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA60_13 = input.LA(1);

                         
                        int index60_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_13);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA60_12 = input.LA(1);

                         
                        int index60_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_12);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA60_2 = input.LA(1);

                         
                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_2);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA60_4 = input.LA(1);

                         
                        int index60_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_4);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA60_9 = input.LA(1);

                         
                        int index60_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA60_6 = input.LA(1);

                         
                        int index60_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA65_eotS =
        "\150\uffff";
    static final String DFA65_eofS =
        "\1\145\147\uffff";
    static final String DFA65_minS =
        "\1\4\145\0\2\uffff";
    static final String DFA65_maxS =
        "\1\u0084\145\0\2\uffff";
    static final String DFA65_acceptS =
        "\146\uffff\1\1\1\2";
    static final String DFA65_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
        "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62"+
        "\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77"+
        "\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112"+
        "\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125"+
        "\1\126\1\127\1\130\1\131\1\132\1\133\1\134\1\135\1\136\1\137\1\140"+
        "\1\141\1\142\1\143\1\144\2\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\2\1\1\3\uffff\1\133\1\142\2\uffff\1\144\1\140\1\130\1\137"+
            "\1\143\1\uffff\1\131\1\uffff\1\132\1\141\1\uffff\1\134\3\uffff"+
            "\1\135\1\136\22\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
            "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
            "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
            "\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57"+
            "\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73"+
            "\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106"+
            "\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120"+
            "\1\121\1\122\1\123\1\124\1\125\1\126\1\127",
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

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "623:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_1 = input.LA(1);

                         
                        int index65_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_2 = input.LA(1);

                         
                        int index65_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_3 = input.LA(1);

                         
                        int index65_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA65_4 = input.LA(1);

                         
                        int index65_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA65_5 = input.LA(1);

                         
                        int index65_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA65_6 = input.LA(1);

                         
                        int index65_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA65_7 = input.LA(1);

                         
                        int index65_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA65_8 = input.LA(1);

                         
                        int index65_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA65_9 = input.LA(1);

                         
                        int index65_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA65_10 = input.LA(1);

                         
                        int index65_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA65_11 = input.LA(1);

                         
                        int index65_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA65_12 = input.LA(1);

                         
                        int index65_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA65_13 = input.LA(1);

                         
                        int index65_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA65_14 = input.LA(1);

                         
                        int index65_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA65_15 = input.LA(1);

                         
                        int index65_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA65_16 = input.LA(1);

                         
                        int index65_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA65_17 = input.LA(1);

                         
                        int index65_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA65_18 = input.LA(1);

                         
                        int index65_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA65_19 = input.LA(1);

                         
                        int index65_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA65_20 = input.LA(1);

                         
                        int index65_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA65_21 = input.LA(1);

                         
                        int index65_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA65_22 = input.LA(1);

                         
                        int index65_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA65_23 = input.LA(1);

                         
                        int index65_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA65_24 = input.LA(1);

                         
                        int index65_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA65_25 = input.LA(1);

                         
                        int index65_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA65_26 = input.LA(1);

                         
                        int index65_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA65_27 = input.LA(1);

                         
                        int index65_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA65_28 = input.LA(1);

                         
                        int index65_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA65_29 = input.LA(1);

                         
                        int index65_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA65_30 = input.LA(1);

                         
                        int index65_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA65_31 = input.LA(1);

                         
                        int index65_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA65_32 = input.LA(1);

                         
                        int index65_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA65_33 = input.LA(1);

                         
                        int index65_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA65_34 = input.LA(1);

                         
                        int index65_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA65_35 = input.LA(1);

                         
                        int index65_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA65_36 = input.LA(1);

                         
                        int index65_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA65_37 = input.LA(1);

                         
                        int index65_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA65_38 = input.LA(1);

                         
                        int index65_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA65_39 = input.LA(1);

                         
                        int index65_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA65_40 = input.LA(1);

                         
                        int index65_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA65_41 = input.LA(1);

                         
                        int index65_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA65_42 = input.LA(1);

                         
                        int index65_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA65_43 = input.LA(1);

                         
                        int index65_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA65_44 = input.LA(1);

                         
                        int index65_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA65_45 = input.LA(1);

                         
                        int index65_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA65_46 = input.LA(1);

                         
                        int index65_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA65_47 = input.LA(1);

                         
                        int index65_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA65_48 = input.LA(1);

                         
                        int index65_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA65_49 = input.LA(1);

                         
                        int index65_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_49);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA65_50 = input.LA(1);

                         
                        int index65_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_50);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA65_51 = input.LA(1);

                         
                        int index65_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_51);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA65_52 = input.LA(1);

                         
                        int index65_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_52);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA65_53 = input.LA(1);

                         
                        int index65_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_53);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA65_54 = input.LA(1);

                         
                        int index65_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_54);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA65_55 = input.LA(1);

                         
                        int index65_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_55);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA65_56 = input.LA(1);

                         
                        int index65_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_56);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA65_57 = input.LA(1);

                         
                        int index65_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_57);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA65_58 = input.LA(1);

                         
                        int index65_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_58);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA65_59 = input.LA(1);

                         
                        int index65_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_59);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA65_60 = input.LA(1);

                         
                        int index65_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_60);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA65_61 = input.LA(1);

                         
                        int index65_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_61);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA65_62 = input.LA(1);

                         
                        int index65_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_62);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA65_63 = input.LA(1);

                         
                        int index65_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_63);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA65_64 = input.LA(1);

                         
                        int index65_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_64);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA65_65 = input.LA(1);

                         
                        int index65_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_65);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA65_66 = input.LA(1);

                         
                        int index65_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_66);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA65_67 = input.LA(1);

                         
                        int index65_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_67);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA65_68 = input.LA(1);

                         
                        int index65_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_68);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA65_69 = input.LA(1);

                         
                        int index65_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_69);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA65_70 = input.LA(1);

                         
                        int index65_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_70);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA65_71 = input.LA(1);

                         
                        int index65_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_71);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA65_72 = input.LA(1);

                         
                        int index65_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_72);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA65_73 = input.LA(1);

                         
                        int index65_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_73);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA65_74 = input.LA(1);

                         
                        int index65_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_74);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA65_75 = input.LA(1);

                         
                        int index65_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_75);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA65_76 = input.LA(1);

                         
                        int index65_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_76);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA65_77 = input.LA(1);

                         
                        int index65_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_77);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA65_78 = input.LA(1);

                         
                        int index65_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_78);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA65_79 = input.LA(1);

                         
                        int index65_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_79);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA65_80 = input.LA(1);

                         
                        int index65_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_80);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA65_81 = input.LA(1);

                         
                        int index65_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_81);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA65_82 = input.LA(1);

                         
                        int index65_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_82);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA65_83 = input.LA(1);

                         
                        int index65_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_83);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA65_84 = input.LA(1);

                         
                        int index65_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_84);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA65_85 = input.LA(1);

                         
                        int index65_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_85);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA65_86 = input.LA(1);

                         
                        int index65_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_86);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA65_87 = input.LA(1);

                         
                        int index65_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_87);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA65_88 = input.LA(1);

                         
                        int index65_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_88);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA65_89 = input.LA(1);

                         
                        int index65_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_89);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA65_90 = input.LA(1);

                         
                        int index65_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_90);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA65_91 = input.LA(1);

                         
                        int index65_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_91);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA65_92 = input.LA(1);

                         
                        int index65_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_92);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA65_93 = input.LA(1);

                         
                        int index65_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_93);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA65_94 = input.LA(1);

                         
                        int index65_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_94);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA65_95 = input.LA(1);

                         
                        int index65_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_95);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA65_96 = input.LA(1);

                         
                        int index65_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_96);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA65_97 = input.LA(1);

                         
                        int index65_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_97);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA65_98 = input.LA(1);

                         
                        int index65_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_98);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA65_99 = input.LA(1);

                         
                        int index65_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_99);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA65_100 = input.LA(1);

                         
                        int index65_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_100);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA65_101 = input.LA(1);

                         
                        int index65_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred152_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_101);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\131\uffff";
    static final String DFA67_eofS =
        "\1\127\130\uffff";
    static final String DFA67_minS =
        "\1\4\126\0\2\uffff";
    static final String DFA67_maxS =
        "\1\u0084\126\0\2\uffff";
    static final String DFA67_acceptS =
        "\127\uffff\1\2\1\1";
    static final String DFA67_specialS =
        "\1\uffff\1\116\1\51\1\64\1\32\1\101\1\33\1\56\1\54\1\124\1\53\1"+
        "\7\1\74\1\27\1\75\1\11\1\50\1\123\1\46\1\121\1\21\1\76\1\22\1\77"+
        "\1\45\1\120\1\43\1\117\1\113\1\42\1\112\1\41\1\23\1\65\1\0\1\66"+
        "\1\20\1\115\1\37\1\114\1\24\1\71\1\3\1\72\1\25\1\36\1\110\1\35\1"+
        "\34\1\106\1\14\1\70\1\31\1\104\1\40\1\111\1\26\1\102\1\107\1\67"+
        "\1\30\1\103\1\122\1\47\1\10\1\105\1\12\1\73\1\6\1\55\1\5\1\125\1"+
        "\13\1\60\1\15\1\100\1\17\1\62\1\16\1\52\1\2\1\61\1\4\1\63\1\1\1"+
        "\57\1\44\2\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\1\1\127\3\uffff\11\127\1\uffff\1\127\1\uffff\6\127\1\uffff"+
            "\2\127\1\uffff\1\127\20\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1"+
            "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1"+
            "\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1"+
            "\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1"+
            "\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1"+
            "\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1"+
            "\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126",
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

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "666:1724: (temp= identifierOrKeyword )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_34 = input.LA(1);

                         
                        int index67_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_34);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA67_84 = input.LA(1);

                         
                        int index67_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_84);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA67_80 = input.LA(1);

                         
                        int index67_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_80);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA67_42 = input.LA(1);

                         
                        int index67_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_42);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA67_82 = input.LA(1);

                         
                        int index67_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_82);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA67_70 = input.LA(1);

                         
                        int index67_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_70);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA67_68 = input.LA(1);

                         
                        int index67_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_68);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA67_11 = input.LA(1);

                         
                        int index67_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_11);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA67_64 = input.LA(1);

                         
                        int index67_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_64);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA67_15 = input.LA(1);

                         
                        int index67_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_15);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA67_66 = input.LA(1);

                         
                        int index67_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_66);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA67_72 = input.LA(1);

                         
                        int index67_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_72);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA67_50 = input.LA(1);

                         
                        int index67_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_50);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA67_74 = input.LA(1);

                         
                        int index67_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_74);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA67_78 = input.LA(1);

                         
                        int index67_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_78);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA67_76 = input.LA(1);

                         
                        int index67_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_76);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA67_36 = input.LA(1);

                         
                        int index67_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_36);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA67_20 = input.LA(1);

                         
                        int index67_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_20);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA67_22 = input.LA(1);

                         
                        int index67_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_22);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA67_32 = input.LA(1);

                         
                        int index67_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_32);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA67_40 = input.LA(1);

                         
                        int index67_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_40);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA67_44 = input.LA(1);

                         
                        int index67_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_44);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA67_56 = input.LA(1);

                         
                        int index67_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_56);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA67_13 = input.LA(1);

                         
                        int index67_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_13);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA67_60 = input.LA(1);

                         
                        int index67_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_60);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA67_52 = input.LA(1);

                         
                        int index67_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_52);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA67_4 = input.LA(1);

                         
                        int index67_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_4);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA67_6 = input.LA(1);

                         
                        int index67_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_6);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA67_48 = input.LA(1);

                         
                        int index67_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_48);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA67_47 = input.LA(1);

                         
                        int index67_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_47);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA67_45 = input.LA(1);

                         
                        int index67_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_45);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA67_38 = input.LA(1);

                         
                        int index67_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_38);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA67_54 = input.LA(1);

                         
                        int index67_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_54);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA67_31 = input.LA(1);

                         
                        int index67_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_31);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA67_29 = input.LA(1);

                         
                        int index67_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_29);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA67_26 = input.LA(1);

                         
                        int index67_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_26);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA67_86 = input.LA(1);

                         
                        int index67_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_86);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA67_24 = input.LA(1);

                         
                        int index67_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_24);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA67_18 = input.LA(1);

                         
                        int index67_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_18);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA67_63 = input.LA(1);

                         
                        int index67_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_63);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA67_16 = input.LA(1);

                         
                        int index67_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_16);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA67_79 = input.LA(1);

                         
                        int index67_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_79);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA67_10 = input.LA(1);

                         
                        int index67_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_10);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA67_8 = input.LA(1);

                         
                        int index67_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_8);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA67_69 = input.LA(1);

                         
                        int index67_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_69);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA67_7 = input.LA(1);

                         
                        int index67_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_7);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA67_85 = input.LA(1);

                         
                        int index67_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_85);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA67_73 = input.LA(1);

                         
                        int index67_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_73);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA67_81 = input.LA(1);

                         
                        int index67_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_81);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA67_77 = input.LA(1);

                         
                        int index67_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_77);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA67_83 = input.LA(1);

                         
                        int index67_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_83);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA67_3 = input.LA(1);

                         
                        int index67_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_3);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA67_33 = input.LA(1);

                         
                        int index67_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_33);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA67_35 = input.LA(1);

                         
                        int index67_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_35);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA67_59 = input.LA(1);

                         
                        int index67_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_59);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA67_51 = input.LA(1);

                         
                        int index67_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_51);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA67_41 = input.LA(1);

                         
                        int index67_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_41);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA67_43 = input.LA(1);

                         
                        int index67_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_43);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA67_67 = input.LA(1);

                         
                        int index67_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_67);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA67_12 = input.LA(1);

                         
                        int index67_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_12);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA67_14 = input.LA(1);

                         
                        int index67_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_14);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA67_21 = input.LA(1);

                         
                        int index67_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_21);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA67_23 = input.LA(1);

                         
                        int index67_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_23);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA67_75 = input.LA(1);

                         
                        int index67_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_75);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA67_5 = input.LA(1);

                         
                        int index67_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_5);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA67_57 = input.LA(1);

                         
                        int index67_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_57);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA67_61 = input.LA(1);

                         
                        int index67_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_61);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA67_53 = input.LA(1);

                         
                        int index67_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_53);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA67_65 = input.LA(1);

                         
                        int index67_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_65);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA67_49 = input.LA(1);

                         
                        int index67_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_49);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA67_58 = input.LA(1);

                         
                        int index67_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_58);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA67_46 = input.LA(1);

                         
                        int index67_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_46);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA67_55 = input.LA(1);

                         
                        int index67_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_55);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA67_30 = input.LA(1);

                         
                        int index67_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_30);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA67_28 = input.LA(1);

                         
                        int index67_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_28);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA67_39 = input.LA(1);

                         
                        int index67_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_39);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA67_37 = input.LA(1);

                         
                        int index67_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_37);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA67_27 = input.LA(1);

                         
                        int index67_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_27);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA67_25 = input.LA(1);

                         
                        int index67_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_25);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA67_19 = input.LA(1);

                         
                        int index67_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_19);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA67_62 = input.LA(1);

                         
                        int index67_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_62);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA67_17 = input.LA(1);

                         
                        int index67_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_17);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA67_9 = input.LA(1);

                         
                        int index67_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_9);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA67_71 = input.LA(1);

                         
                        int index67_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred161_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_71);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 67, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA85_eotS =
        "\u00b3\uffff";
    static final String DFA85_eofS =
        "\u00b3\uffff";
    static final String DFA85_minS =
        "\1\4\126\13\3\4\126\13\3\uffff";
    static final String DFA85_maxS =
        "\1\u0084\126\37\1\u0084\2\154\126\37\3\uffff";
    static final String DFA85_acceptS =
        "\u00b0\uffff\1\1\1\2\1\3";
    static final String DFA85_specialS =
        "\u00b3\uffff}>";
    static final String[] DFA85_transitionS = {
            "\1\1\12\uffff\1\127\40\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1"+
            "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1"+
            "\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1"+
            "\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1"+
            "\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1"+
            "\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1"+
            "\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\132\6\uffff\1\131\23\uffff\1\130\20\uffff\1\133\1\134\1"+
            "\135\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\145\1\146\1"+
            "\147\1\150\1\151\1\152\1\153\1\154\1\155\1\156\1\157\1\160\1"+
            "\161\1\162\1\163\1\164\1\165\1\166\1\167\1\170\1\171\1\172\1"+
            "\173\1\174\1\175\1\176\1\177\1\u0080\1\u0081\1\u0082\1\u0083"+
            "\1\u0084\1\u0085\1\u0086\1\u0087\1\u0088\1\u0089\1\u008a\1\u008b"+
            "\1\u008c\1\u008d\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093"+
            "\1\u0094\1\u0095\1\u0096\1\u0097\1\u0098\1\u0099\1\u009a\1\u009b"+
            "\1\u009c\1\u009d\1\u009e\1\u009f\1\u00a0\1\u00a1\1\u00a2\1\u00a3"+
            "\1\u00a4\1\u00a5\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa\1\u00ab"+
            "\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00b0\132\uffff\1\u00b1\14\uffff\1\u00b2",
            "\1\u00b0\132\uffff\1\u00b1\14\uffff\1\u00b2",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "\1\131\23\uffff\1\130",
            "",
            "",
            ""
    };

    static final short[] DFA85_eot = DFA.unpackEncodedString(DFA85_eotS);
    static final short[] DFA85_eof = DFA.unpackEncodedString(DFA85_eofS);
    static final char[] DFA85_min = DFA.unpackEncodedStringToUnsignedChars(DFA85_minS);
    static final char[] DFA85_max = DFA.unpackEncodedStringToUnsignedChars(DFA85_maxS);
    static final short[] DFA85_accept = DFA.unpackEncodedString(DFA85_acceptS);
    static final short[] DFA85_special = DFA.unpackEncodedString(DFA85_specialS);
    static final short[][] DFA85_transition;

    static {
        int numStates = DFA85_transitionS.length;
        DFA85_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA85_transition[i] = DFA.unpackEncodedString(DFA85_transitionS[i]);
        }
    }

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = DFA85_eot;
            this.eof = DFA85_eof;
            this.min = DFA85_min;
            this.max = DFA85_max;
            this.accept = DFA85_accept;
            this.special = DFA85_special;
            this.transition = DFA85_transition;
        }
        public String getDescription() {
            return "803:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )";
        }
    }
    static final String DFA125_eotS =
        "\u00b4\uffff";
    static final String DFA125_eofS =
        "\1\uffff\127\131\5\uffff\127\131";
    static final String DFA125_minS =
        "\1\4\4\13\1\11\52\13\1\11\46\13\1\4\5\uffff\71\13\1\4\6\13\1\4"+
        "\25\13\1\4";
    static final String DFA125_maxS =
        "\1\u0084\126\157\1\u0084\5\uffff\100\157\1\u0084\26\157";
    static final String DFA125_acceptS =
        "\130\uffff\1\5\1\2\1\1\1\4\1\3\127\uffff";
    static final String DFA125_specialS =
        "\u00b4\uffff}>";
    static final String[] DFA125_transitionS = {
            "\1\1\12\uffff\1\127\40\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1"+
            "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1"+
            "\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1"+
            "\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1"+
            "\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1"+
            "\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1"+
            "\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\133\1\uffff\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff"+
            "\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\134\1\uffff\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff"+
            "\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\135\6\uffff\1\132\13\uffff\1\131\30\uffff\1\136\1\137\1"+
            "\140\1\141\1\142\1\143\1\144\1\145\1\146\1\147\1\150\1\151\1"+
            "\152\1\153\1\154\1\155\1\156\1\157\1\160\1\161\1\162\1\163\1"+
            "\164\1\165\1\166\1\167\1\170\1\171\1\172\1\173\1\174\1\175\1"+
            "\176\1\177\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1"+
            "\u0086\1\u0087\1\u0088\1\u0089\1\u008a\1\u008b\1\u008c\1\u008d"+
            "\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\u0094\1\u0095"+
            "\1\u0096\1\u0097\1\u0098\1\u0099\1\u009a\1\u009b\1\u009c\1\u009d"+
            "\1\u009e\1\u009f\1\u00a0\1\u00a1\1\u00a2\1\u00a3\1\u00a4\1\u00a5"+
            "\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad"+
            "\1\u00ae\1\u00af\1\u00b0\1\u00b1\1\u00b2",
            "",
            "",
            "",
            "",
            "",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\130\6\uffff\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff"+
            "\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\131\6\uffff\1\132\3\uffff\1\131\7\uffff\1\131\30\uffff"+
            "\70\131\1\u00b3\34\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\132\13\uffff\1\131\120\uffff\1\130\6\uffff\1\131",
            "\1\130\6\uffff\1\131\13\uffff\1\131\120\uffff\1\131\6\uffff"+
            "\1\131"
    };

    static final short[] DFA125_eot = DFA.unpackEncodedString(DFA125_eotS);
    static final short[] DFA125_eof = DFA.unpackEncodedString(DFA125_eofS);
    static final char[] DFA125_min = DFA.unpackEncodedStringToUnsignedChars(DFA125_minS);
    static final char[] DFA125_max = DFA.unpackEncodedStringToUnsignedChars(DFA125_maxS);
    static final short[] DFA125_accept = DFA.unpackEncodedString(DFA125_acceptS);
    static final short[] DFA125_special = DFA.unpackEncodedString(DFA125_specialS);
    static final short[][] DFA125_transition;

    static {
        int numStates = DFA125_transitionS.length;
        DFA125_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA125_transition[i] = DFA.unpackEncodedString(DFA125_transitionS[i]);
        }
    }

    class DFA125 extends DFA {

        public DFA125(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 125;
            this.eot = DFA125_eot;
            this.eof = DFA125_eof;
            this.min = DFA125_min;
            this.max = DFA125_max;
            this.accept = DFA125_accept;
            this.special = DFA125_special;
            this.transition = DFA125_transition;
        }
        public String getDescription() {
            return "1329:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )";
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
    public static final BitSet FOLLOW_125_in_identifierOrKeyword724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_identifierOrKeyword732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_identifierOrKeyword740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_identifierOrKeyword748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_identifierOrKeyword756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_identifierOrKeyword764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_identifierOrKeyword772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_identifierOrKeyword780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_namespace_in_model_classifier913 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_DLCOLON_in_model_classifier920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_classifier928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_model_classifier947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_generalizableelement_in_primary_model_namespace993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_model_namespace1002 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_model_namespace_in_primary_model_namespace1008 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_primary_model_namespace1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_model_namespace_in_dblcolon_priority_01050 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_dblcolon_priority_01059 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_model_modelelement_in_dblcolon_priority_01067 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_dblcolon_priority_0_in_model_namespace1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_model_generalizableelement1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_model_modelelement1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_concretesyntax_in_main1250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_tcs_concretesyntax1284 = new BitSet(new long[]{0x0000000000001210L});
    public static final BitSet FOLLOW_identifier_in_tcs_concretesyntax1291 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_concretesyntax1306 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_tcs_concretesyntax1310 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1314 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_concretesyntax1322 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_concretesyntax1329 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1347 = new BitSet(new long[]{0x6000000000002000L,0x0000040204008E00L,0x0000000000000012L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax1358 = new BitSet(new long[]{0x6000000000002000L,0x0000040204008E00L,0x0000000000000012L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax1366 = new BitSet(new long[]{0x6000000000002000L,0x0000040204008E00L,0x0000000000000012L});
    public static final BitSet FOLLOW_132_in_tcs_concretesyntax1383 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1387 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax1398 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax1406 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1421 = new BitSet(new long[]{0x4000000000002000L,0x0000000204000400L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_tcs_concretesyntax1444 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1448 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1459 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1467 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1482 = new BitSet(new long[]{0x4000000000002000L,0x0000000204000400L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1503 = new BitSet(new long[]{0x4000000000002000L,0x0000000204000400L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1511 = new BitSet(new long[]{0x4000000000002000L,0x0000000204000400L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1526 = new BitSet(new long[]{0x0000000000002000L,0x0000000204000400L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1534 = new BitSet(new long[]{0x0000000000002000L,0x0000000204000400L});
    public static final BitSet FOLLOW_90_in_tcs_concretesyntax1551 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1555 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_concretesyntax1563 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_concretesyntax1570 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_classifier_in_reference1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_reference1652 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_reference1660 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_reference1669 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_reference1677 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_tcs_primitivetemplate_in_tcs_template1718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumerationtemplate_in_tcs_template1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classtemplate_in_tcs_template1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_operatortemplate_in_tcs_template1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functiontemplate_in_tcs_template1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_tcs_primitivetemplate1780 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1787 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_tcs_primitivetemplate1793 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_primitivetemplate1796 = new BitSet(new long[]{0x0800000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_59_in_tcs_primitivetemplate1806 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_tcs_primitivetemplate1824 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1831 = new BitSet(new long[]{0x0000000000010000L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_tcs_primitivetemplate1843 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_primitivetemplate1862 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_tcs_primitivetemplate1866 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1870 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1878 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_primitivetemplate1891 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_tcs_primitivetemplate1895 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1899 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1907 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_primitivetemplate1927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_primitivetemplate1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_tcs_enumerationtemplate1980 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_enumerationtemplate1983 = new BitSet(new long[]{0x0000000000014000L,0x0000400000000000L});
    public static final BitSet FOLLOW_110_in_tcs_enumerationtemplate1993 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_enumerationtemplate2021 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2032 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_enumerationtemplate2041 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2049 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate2064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate2081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_enumerationtemplate2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping2144 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_enumliteralmapping2151 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_enumliteralmapping2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_tcs_classtemplate2202 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_classtemplate2205 = new BitSet(new long[]{0x1200000000054200L,0x0A8002C008000010L});
    public static final BitSet FOLLOW_102_in_tcs_classtemplate2215 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_SHARP_in_tcs_classtemplate2235 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate2243 = new BitSet(new long[]{0x1200000000014200L,0x0A80028008000010L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2269 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_tcs_classtemplate2273 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2277 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2285 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2292 = new BitSet(new long[]{0x1200000000014200L,0x0A80028008000010L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_tcs_classtemplate2320 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2324 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2332 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2339 = new BitSet(new long[]{0x1200000000014000L,0x0A80028008000010L});
    public static final BitSet FOLLOW_60_in_tcs_classtemplate2362 = new BitSet(new long[]{0x0200000000014000L,0x0A80028008000010L});
    public static final BitSet FOLLOW_123_in_tcs_classtemplate2386 = new BitSet(new long[]{0x0200000000014000L,0x0280028008000010L});
    public static final BitSet FOLLOW_57_in_tcs_classtemplate2416 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_tcs_classtemplate2434 = new BitSet(new long[]{0x0000000000014000L,0x0280028000000010L});
    public static final BitSet FOLLOW_103_in_tcs_classtemplate2458 = new BitSet(new long[]{0x0000000000014200L,0x0280020000000010L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2468 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate2476 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2483 = new BitSet(new long[]{0x0000000000014000L,0x0280020000000010L});
    public static final BitSet FOLLOW_119_in_tcs_classtemplate2521 = new BitSet(new long[]{0x0000000000014200L,0x0200020000000010L});
    public static final BitSet FOLLOW_tcs_contexttags_in_tcs_classtemplate2534 = new BitSet(new long[]{0x0000000000014000L,0x0200020000000010L});
    public static final BitSet FOLLOW_68_in_tcs_classtemplate2574 = new BitSet(new long[]{0x0000000000014000L,0x0200020000000000L});
    public static final BitSet FOLLOW_105_in_tcs_classtemplate2598 = new BitSet(new long[]{0x0000000000014000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_tcs_classtemplate2622 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2629 = new BitSet(new long[]{0xFFFF000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2640 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2682 = new BitSet(new long[]{0xFFFF000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2693 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_classtemplate2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_tcs_operatortemplate2779 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_operatortemplate2782 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_operatortemplate2787 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_tcs_operatortemplate2791 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2795 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2803 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2811 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2823 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_88_in_tcs_operatortemplate2827 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2831 = new BitSet(new long[]{0xFFFF000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2839 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_tcs_operatortemplate2856 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2860 = new BitSet(new long[]{0xFFFF000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2868 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2894 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_tcs_operatortemplate2898 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2902 = new BitSet(new long[]{0xFFFF000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2910 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2936 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_tcs_operatortemplate2940 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2944 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate2952 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_tcs_operatortemplate2982 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2986 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate2994 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_operatortemplate3014 = new BitSet(new long[]{0x0000000000014000L,0x0080004000000000L});
    public static final BitSet FOLLOW_102_in_tcs_operatortemplate3024 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_119_in_tcs_operatortemplate3043 = new BitSet(new long[]{0x0000000000014200L});
    public static final BitSet FOLLOW_tcs_contexttags_in_tcs_operatortemplate3056 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_operatortemplate3107 = new BitSet(new long[]{0xFFFF000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_operatortemplate3118 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate3128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate3145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_operatortemplate3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_tcs_functiontemplate3204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functiontemplate3211 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_functiontemplate3218 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_functiontemplate3222 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_functiontemplate3227 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_functiontemplate3235 = new BitSet(new long[]{0xFFFF000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_functiontemplate3246 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_functiontemplate3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_contexttags3301 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_identifier_in_tcs_contexttags3309 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_contexttags3318 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_contexttags3326 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_contexttags3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3383 = new BitSet(new long[]{0xFFFF000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3391 = new BitSet(new long[]{0xFFFF000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence__impl_in_tcs_sequence3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_sequence3441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_sequenceelement3470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_property_in_tcs_sequenceelement3478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_customseparator_in_tcs_sequenceelement3486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_block_in_tcs_sequenceelement3494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement3502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_alternative_in_tcs_sequenceelement3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functioncall_in_tcs_sequenceelement3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_injectoractionsblock_in_tcs_sequenceelement3526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_literalref3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_propertyreference3616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_tcs_propertyreference3632 = new BitSet(new long[]{0xFFFF000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_propertyreference3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_property3695 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_property3708 = new BitSet(new long[]{0x04A0000000002000L,0x2508201082004009L,0x0000000000000008L});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property3716 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_property3725 = new BitSet(new long[]{0x04A0000000000000L,0x2508201082004009L,0x0000000000000008L});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property3733 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_property3745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_tcs_customseparator3803 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_customseparator3811 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_GT_in_tcs_customseparator3818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_block3863 = new BitSet(new long[]{0xFFFF000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_block3871 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_block3878 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_block3889 = new BitSet(new long[]{0x0000000000002000L,0x0002000000880006L});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block3897 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_block3906 = new BitSet(new long[]{0x0000000000000000L,0x0002000000880006L});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block3914 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_block3926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_conditionalelement3984 = new BitSet(new long[]{0xFFFF000000808010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_expression_in_tcs_conditionalelement3992 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_QMARK_in_tcs_conditionalelement4001 = new BitSet(new long[]{0xFFFF000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement4009 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_COLON_in_tcs_conditionalelement4022 = new BitSet(new long[]{0xFFFF000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement4030 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_conditionalelement4050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLSQUARE_in_tcs_alternative4095 = new BitSet(new long[]{0xFFFF000037288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4103 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_PIPE_in_tcs_alternative4112 = new BitSet(new long[]{0xFFFF000037288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4120 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_DRSQUARE_in_tcs_alternative4132 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_STAR_in_tcs_alternative4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_tcs_sequenceinalternative4208 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_sequenceinalternative4212 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_sequenceinalternative4220 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_sequenceinalternative4227 = new BitSet(new long[]{0xFFFF000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4248 = new BitSet(new long[]{0xFFFF000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4256 = new BitSet(new long[]{0xFFFF000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_DOLLAR_in_tcs_functioncall4305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functioncall4313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCURLY_in_tcs_injectoractionsblock4360 = new BitSet(new long[]{0xFFFF000040008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4368 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_injectoractionsblock4377 = new BitSet(new long[]{0xFFFF000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4385 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_DRCURLY_in_tcs_injectoractionsblock4397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyinit_in_tcs_injectoraction4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_primitivepropertyinit_in_tcs_propertyinit4465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookuppropertyinit_in_tcs_propertyinit4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_foreachpredicatepropertyinit_in_tcs_propertyinit4481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_primitivepropertyinit4515 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_primitivepropertyinit4528 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivepropertyinit4543 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivepropertyinit4558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_lookuppropertyinit4605 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_lookuppropertyinit4618 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookuppropertyinit4633 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_tcs_lookuppropertyinit4644 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_lookuppropertyinit4648 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_lookuppropertyinit4656 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_lookuppropertyinit4663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_foreachpredicatepropertyinit4708 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_foreachpredicatepropertyinit4721 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4736 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_108_in_tcs_foreachpredicatepropertyinit4747 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_foreachpredicatepropertyinit4751 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4759 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_tcs_foreachpredicatepropertyinit4776 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4780 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4788 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4814 = new BitSet(new long[]{0x0000000000000400L,0x0100000010004000L});
    public static final BitSet FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4822 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4831 = new BitSet(new long[]{0x0000000000000000L,0x0100000010004000L});
    public static final BitSet FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4839 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_foreachpredicatepropertyinit4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_tcs_predicatesemantic4911 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic4915 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_predicatesemantic4923 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_predicatesemantic4930 = new BitSet(new long[]{0x0000000000000000L,0x0100000000004000L});
    public static final BitSet FOLLOW_78_in_tcs_predicatesemantic4953 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic4957 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_predicatesemantic4965 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_predicatesemantic4972 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_120_in_tcs_predicatesemantic4989 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic4993 = new BitSet(new long[]{0xFFFF000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_predicatesemantic5001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_referstoparg_in_tcs_propertyarg5043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookinparg_in_tcs_propertyarg5051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createinparg_in_tcs_propertyarg5059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_asparg_in_tcs_propertyarg5067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_separatorparg_in_tcs_propertyarg5075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_disambiguateparg_in_tcs_propertyarg5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_autocreateparg_in_tcs_propertyarg5091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_importcontextparg_in_tcs_propertyarg5099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_partialparg_in_tcs_propertyarg5107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg5115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedupperparg_in_tcs_propertyarg5123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createasparg_in_tcs_propertyarg5131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_queryparg_in_tcs_propertyarg5139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_filterparg_in_tcs_propertyarg5147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_modeparg_in_tcs_propertyarg5155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_tcs_referstoparg5185 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_referstoparg5189 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_referstoparg5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_tcs_lookinparg5240 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookinparg5244 = new BitSet(new long[]{0xFFFF000000040010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_SHARP_in_tcs_lookinparg5255 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_tcs_lookinparg5259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg5276 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_lookinparg5285 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg5293 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_122_in_tcs_createinparg5346 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_createinparg5350 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg5358 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_createinparg5367 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg5375 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_120_in_tcs_asparg5421 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_asparg5425 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_asparg5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_tcs_separatorparg5476 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_separatorparg5480 = new BitSet(new long[]{0xFFFF000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_separatorparg5488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_tcs_disambiguateparg5531 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_disambiguateparg5535 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_disambiguateparg5543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_tcs_autocreateparg5586 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_autocreateparg5590 = new BitSet(new long[]{0x0100000000000000L,0x1000000000100000L});
    public static final BitSet FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg5598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_tcs_autocreatekind5642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_tcs_autocreatekind5652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_tcs_autocreatekind5662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_tcs_importcontextparg5693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_tcs_partialparg5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_tcs_forcedlowerparg5773 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedlowerparg5777 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedlowerparg5785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_tcs_forcedupperparg5828 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedupperparg5832 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedupperparg5840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_tcs_createasparg5883 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_createasparg5887 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg5895 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_tcs_createasparg5904 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg5912 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_125_in_tcs_queryparg5958 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_queryparg5962 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_queryparg5970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_tcs_filterparg6013 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_filterparg6017 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_filterparg6025 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COMA_in_tcs_filterparg6038 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_tcs_filterparg6042 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_filterparg6046 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_filterparg6054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_tcs_modeparg6110 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_modeparg6114 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_modeparg6122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_nbnlbarg_in_tcs_blockarg6162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_indentincrbarg_in_tcs_blockarg6170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnlbarg_in_tcs_blockarg6178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg6186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endnlbarg_in_tcs_blockarg6194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_tcs_nbnlbarg6224 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_nbnlbarg6228 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_nbnlbarg6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_tcs_indentincrbarg6279 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_indentincrbarg6283 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_indentincrbarg6291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_tcs_startnlbarg6334 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnlbarg6338 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_tcs_startnlbarg6348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_tcs_startnlbarg6361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_tcs_startnbnlbarg6408 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnbnlbarg6412 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_startnbnlbarg6420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_tcs_endnlbarg6463 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_endnlbarg6467 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_tcs_endnlbarg6477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_tcs_endnlbarg6490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_symbol6541 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_symbol6550 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_symbol6558 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_symbol6571 = new BitSet(new long[]{0x0040000000004000L,0x0005000000000040L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol6579 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_symbol6588 = new BitSet(new long[]{0x0040000000000000L,0x0005000000000040L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol6596 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_symbol6621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_tcs_spacekind6663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_tcs_spacekind6673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_tcs_spacekind6683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_tcs_spacekind6693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_keyword6728 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_keyword6737 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_keyword6745 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_keyword6752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_tcs_operatorlist6793 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatorlist6806 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_operatorlist6826 = new BitSet(new long[]{0x0000000000002000L,0x0000000800000000L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist6837 = new BitSet(new long[]{0x0000000000002000L,0x0000000800000000L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist6845 = new BitSet(new long[]{0x0000000000002000L,0x0000000800000000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_operatorlist6860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_tcs_priority6901 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_priority6908 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_COMA_in_tcs_priority6931 = new BitSet(new long[]{0x0010000000000000L,0x0040000000000000L});
    public static final BitSet FOLLOW_tcs_associativity_in_tcs_priority6939 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_priority6953 = new BitSet(new long[]{0x0000000000002810L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority6964 = new BitSet(new long[]{0x0000000000002810L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority6972 = new BitSet(new long[]{0x0000000000002810L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_priority6987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_tcs_operator7034 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator7056 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operator7065 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator7084 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operator7104 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_operator7129 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_operator7137 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operator7144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_tcs_associativity7186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_tcs_associativity7196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_andexp_in_tcs_expression7224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp7258 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_tcs_andexp7266 = new BitSet(new long[]{0xFFFF000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp7273 = new BitSet(new long[]{0x0000000000000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_tcs_equalsexp_in_tcs_atomexp7318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp7326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_isdefinedexp_in_tcs_atomexp7334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_oneexp_in_tcs_atomexp7342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_instanceofexp_in_tcs_atomexp7350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_equalsexp7384 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_equalsexp7391 = new BitSet(new long[]{0x0000000200040060L});
    public static final BitSet FOLLOW_tcs_value_in_tcs_equalsexp7399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_booleanpropertyexp7446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_tcs_isdefinedexp7489 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_isdefinedexp7493 = new BitSet(new long[]{0xFFFF000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_isdefinedexp7501 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_isdefinedexp7508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_tcs_oneexp7549 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_oneexp7553 = new BitSet(new long[]{0xFFFF000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_oneexp7561 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_oneexp7568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_instanceofexp7613 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_tcs_instanceofexp7619 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_instanceofexp7626 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_tcs_instanceofexp7635 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_instanceofexp7643 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_tcs_stringval_in_tcs_value7686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_integerval_in_tcs_value7694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_negativeintegerval_in_tcs_value7702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_value7710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringval7744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_integerval7791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_tcs_negativeintegerval7835 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_negativeintegerval7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_tcs_enumliteralval7887 = new BitSet(new long[]{0xFFFF000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_enumliteralval7895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_tcs_token7944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_tcs_token7962 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_identifier_in_tcs_token7969 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_token7978 = new BitSet(new long[]{0x8000000000204020L,0x0000000000001100L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_token7986 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_token7993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern8038 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_tcs_orpattern8047 = new BitSet(new long[]{0x8000000000200020L,0x0000000000001100L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern8055 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_tcs_rulepattern_in_tcs_simplepattern8100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_simplepattern8108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classpattern_in_tcs_simplepattern8116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_rule_in_tcs_rulepattern8150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wordrule_in_tcs_rule8190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endoflinerule_in_tcs_rule8198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_multilinerule_in_tcs_rule8206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_tcs_wordrule8236 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_wordrule8240 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_tcs_wordrule8244 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8248 = new BitSet(new long[]{0x8000000000220020L,0x0000000000001100L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8256 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule8263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_tcs_wordrule8267 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8271 = new BitSet(new long[]{0x8000000000220420L,0x0000000000001100L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8279 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule8292 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_tcs_wordrule8296 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8300 = new BitSet(new long[]{0x8000000000200420L,0x0000000000001100L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8308 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_wordrule8328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_tcs_endoflinerule8369 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_endoflinerule8373 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_tcs_endoflinerule8377 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_endoflinerule8381 = new BitSet(new long[]{0x0000000000000420L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_tcs_endoflinerule8391 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_endoflinerule8413 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_endoflinerule8420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_tcs_multilinerule8461 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule8465 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_tcs_multilinerule8469 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8473 = new BitSet(new long[]{0x0000000000020020L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_tcs_multilinerule8483 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8505 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_tcs_multilinerule8516 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8520 = new BitSet(new long[]{0x0000000000020420L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_tcs_multilinerule8530 = new BitSet(new long[]{0x0000000000020420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8552 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8565 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_tcs_multilinerule8569 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8573 = new BitSet(new long[]{0x0000000000020420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8581 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8594 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule8599 = new BitSet(new long[]{0x0001000100000410L,0x0020000000000000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule8607 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8616 = new BitSet(new long[]{0x0001000100000010L,0x0020000000000000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule8624 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule8636 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule8667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplemapping_in_tcs_mapping8705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wildcardmapping_in_tcs_mapping8713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_octalmapping_in_tcs_mapping8721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping8729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping8763 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_simplemapping8770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping8778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping8822 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_wildcardmapping8827 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping8832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_tcs_octalmapping8873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_tcs_hexadecimalmapping8913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringpattern8957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_classpattern9003 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classpattern9011 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_classpattern9020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCOLON_in_synpred88_TCS1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred114_TCS1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred119_TCS2095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred136_TCS2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred147_TCS3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequence__impl_in_synpred152_TCS3436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_synpred161_TCS3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_expression_in_synpred168_TCS3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_synpred171_TCS4103 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred171_TCS4112 = new BitSet(new long[]{0xFFFF000033288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000001FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_synpred171_TCS4120 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMA_in_synpred183_TCS4772 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_synpred183_TCS4776 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_synpred183_TCS4780 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_synpred183_TCS4788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_synpred249_TCS8038 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred249_TCS8047 = new BitSet(new long[]{0x8000000000200020L,0x0000000000001100L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_synpred249_TCS8055 = new BitSet(new long[]{0x0000000002000002L});

}