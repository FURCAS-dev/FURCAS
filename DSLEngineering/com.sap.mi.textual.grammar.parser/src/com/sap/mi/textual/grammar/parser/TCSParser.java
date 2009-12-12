// $ANTLR 3.1.1 parser/TCS.g 2009-12-11 15:51:45

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "QNAME", "LPAREN", "EQ", "RPAREN", "LCURLY", "RCURLY", "SEMI", "RARROW", "COLON", "COMA", "SHARP", "LT", "GT", "LSQUARE", "RSQUARE", "QMARK", "DLSQUARE", "PIPE", "DRSQUARE", "STAR", "DOLLAR", "DLCURLY", "DRCURLY", "LARROW", "POINT", "DLCOLON", "MINUS", "COMMENT", "MULTI_LINE_COMMENT", "EXCL", "AROBAS", "SLASH", "PLUS", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "ORKEYWORD", "SNAME", "QNAME_OR_NAME", "ESC", "'instanceOf'", "'k'", "'template'", "'isDefined'", "'one'", "'endNL'", "'disambiguate'", "'createIn'", "'start'", "'syntax'", "'storeOpTo'", "'nonPrimary'", "'omitted'", "'main'", "'esc'", "'auto'", "'enumerationTemplate'", "'indentIncr'", "'storeRightTo'", "'source'", "'foreach'", "'rightSpace'", "'keywords'", "'priority'", "'drop'", "'addToContext'", "'context'", "'disambiguateV3'", "'and'", "'rightNone'", "'token'", "'prefix'", "'word'", "'as'", "'endOfLine'", "'right'", "'nbNL'", "'postfix'", "'query'", "'value'", "'createAs'", "'importContext'", "'operators'", "'multi'", "'always'", "'referenceOnly'", "'false'", "'serializer'", "'separator'", "'for'", "'end'", "'lookIn'", "'leftNone'", "'all'", "'filter'", "'function'", "'forcedUpper'", "'default'", "'multiLine'", "'when'", "'startNbNL'", "'invert'", "'ifmissing'", "'mode'", "'deep'", "'octal'", "'hex'", "'operatorTemplate'", "'symbols'", "'abstract'", "'part'", "'partial'", "'refersTo'", "'using'", "'left'", "'operatored'", "'primitiveTemplate'", "'startNL'", "'autoCreate'", "'never'", "'lexer'", "'true'", "'forcedLower'", "'leftSpace'"
    };
    public static final int DLCURLY=29;
    public static final int LT=19;
    public static final int STAR=27;
    public static final int LSQUARE=21;
    public static final int ORKEYWORD=48;
    public static final int DRCURLY=30;
    public static final int EXCL=37;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int RPAREN=11;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int T__90=90;
    public static final int NL=44;
    public static final int EQ=10;
    public static final int COMMENT=35;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int NE=43;
    public static final int T__95=95;
    public static final int GE=41;
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
    public static final int ALPHA=47;
    public static final int T__88=88;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=45;
    public static final int QNAME=8;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int SNAME=49;
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
    public static final int T__133=133;
    public static final int T__78=78;
    public static final int T__134=134;
    public static final int T__77=77;
    public static final int T__135=135;
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
    public static final int AROBAS=38;
    public static final int T__118=118;
    public static final int ESC=51;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int DLCOLON=33;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int DRSQUARE=26;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int LARROW=31;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int FLOAT=7;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int LPAREN=9;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int SLASH=39;
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
    public static final int PLUS=40;
    public static final int PIPE=25;
    public static final int T__112=112;
    public static final int DIGIT=46;
    public static final int QNAME_OR_NAME=50;
    public static final int DLSQUARE=24;
    public static final int RARROW=15;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int MINUS=34;
    public static final int RSQUARE=22;
    public static final int COMA=17;
    public static final int SEMI=14;
    public static final int MULTI_LINE_COMMENT=36;
    public static final int COLON=16;
    public static final int RCURLY=13;
    public static final int LE=42;
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


       private static final String syntaxUUID = "E0DCF6CD9301CB60E66411DEC46AE1868D1505E2";
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
    // parser/TCS.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'instanceOf' | 'k' | 'template' | 'isDefined' | 'one' | 'endNL' | 'disambiguate' | 'createIn' | 'orKeyword' | 'start' | 'syntax' | 'storeOpTo' | 'nonPrimary' | 'omitted' | 'main' | 'esc' | 'auto' | 'enumerationTemplate' | 'indentIncr' | 'storeRightTo' | 'source' | 'foreach' | 'rightSpace' | 'keywords' | 'priority' | 'drop' | 'addToContext' | 'context' | 'disambiguateV3' | 'and' | 'rightNone' | 'token' | 'prefix' | 'word' | 'as' | 'endOfLine' | 'right' | 'nbNL' | 'postfix' | 'query' | 'value' | 'createAs' | 'importContext' | 'operators' | 'multi' | 'always' | 'referenceOnly' | 'false' | 'serializer' | 'separator' | 'for' | 'end' | 'lookIn' | 'leftNone' | 'all' | 'filter' | 'function' | 'forcedUpper' | 'default' | 'multiLine' | 'when' | 'startNbNL' | 'invert' | 'ifmissing' | 'mode' | 'deep' | 'octal' | 'hex' | 'operatorTemplate' | 'symbols' | 'abstract' | 'part' | 'partial' | 'refersTo' | 'using' | 'left' | 'operatored' | 'primitiveTemplate' | 'startNL' | 'autoCreate' | 'never' | 'lexer' | 'true' | 'forcedLower' | 'leftSpace' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:218:3: ( (ast= NAME | 'instanceOf' | 'k' | 'template' | 'isDefined' | 'one' | 'endNL' | 'disambiguate' | 'createIn' | 'orKeyword' | 'start' | 'syntax' | 'storeOpTo' | 'nonPrimary' | 'omitted' | 'main' | 'esc' | 'auto' | 'enumerationTemplate' | 'indentIncr' | 'storeRightTo' | 'source' | 'foreach' | 'rightSpace' | 'keywords' | 'priority' | 'drop' | 'addToContext' | 'context' | 'disambiguateV3' | 'and' | 'rightNone' | 'token' | 'prefix' | 'word' | 'as' | 'endOfLine' | 'right' | 'nbNL' | 'postfix' | 'query' | 'value' | 'createAs' | 'importContext' | 'operators' | 'multi' | 'always' | 'referenceOnly' | 'false' | 'serializer' | 'separator' | 'for' | 'end' | 'lookIn' | 'leftNone' | 'all' | 'filter' | 'function' | 'forcedUpper' | 'default' | 'multiLine' | 'when' | 'startNbNL' | 'invert' | 'ifmissing' | 'mode' | 'deep' | 'octal' | 'hex' | 'operatorTemplate' | 'symbols' | 'abstract' | 'part' | 'partial' | 'refersTo' | 'using' | 'left' | 'operatored' | 'primitiveTemplate' | 'startNL' | 'autoCreate' | 'never' | 'lexer' | 'true' | 'forcedLower' | 'leftSpace' ) )
            // parser/TCS.g:219:3: (ast= NAME | 'instanceOf' | 'k' | 'template' | 'isDefined' | 'one' | 'endNL' | 'disambiguate' | 'createIn' | 'orKeyword' | 'start' | 'syntax' | 'storeOpTo' | 'nonPrimary' | 'omitted' | 'main' | 'esc' | 'auto' | 'enumerationTemplate' | 'indentIncr' | 'storeRightTo' | 'source' | 'foreach' | 'rightSpace' | 'keywords' | 'priority' | 'drop' | 'addToContext' | 'context' | 'disambiguateV3' | 'and' | 'rightNone' | 'token' | 'prefix' | 'word' | 'as' | 'endOfLine' | 'right' | 'nbNL' | 'postfix' | 'query' | 'value' | 'createAs' | 'importContext' | 'operators' | 'multi' | 'always' | 'referenceOnly' | 'false' | 'serializer' | 'separator' | 'for' | 'end' | 'lookIn' | 'leftNone' | 'all' | 'filter' | 'function' | 'forcedUpper' | 'default' | 'multiLine' | 'when' | 'startNbNL' | 'invert' | 'ifmissing' | 'mode' | 'deep' | 'octal' | 'hex' | 'operatorTemplate' | 'symbols' | 'abstract' | 'part' | 'partial' | 'refersTo' | 'using' | 'left' | 'operatored' | 'primitiveTemplate' | 'startNL' | 'autoCreate' | 'never' | 'lexer' | 'true' | 'forcedLower' | 'leftSpace' )
            {
            // parser/TCS.g:219:3: (ast= NAME | 'instanceOf' | 'k' | 'template' | 'isDefined' | 'one' | 'endNL' | 'disambiguate' | 'createIn' | 'orKeyword' | 'start' | 'syntax' | 'storeOpTo' | 'nonPrimary' | 'omitted' | 'main' | 'esc' | 'auto' | 'enumerationTemplate' | 'indentIncr' | 'storeRightTo' | 'source' | 'foreach' | 'rightSpace' | 'keywords' | 'priority' | 'drop' | 'addToContext' | 'context' | 'disambiguateV3' | 'and' | 'rightNone' | 'token' | 'prefix' | 'word' | 'as' | 'endOfLine' | 'right' | 'nbNL' | 'postfix' | 'query' | 'value' | 'createAs' | 'importContext' | 'operators' | 'multi' | 'always' | 'referenceOnly' | 'false' | 'serializer' | 'separator' | 'for' | 'end' | 'lookIn' | 'leftNone' | 'all' | 'filter' | 'function' | 'forcedUpper' | 'default' | 'multiLine' | 'when' | 'startNbNL' | 'invert' | 'ifmissing' | 'mode' | 'deep' | 'octal' | 'hex' | 'operatorTemplate' | 'symbols' | 'abstract' | 'part' | 'partial' | 'refersTo' | 'using' | 'left' | 'operatored' | 'primitiveTemplate' | 'startNL' | 'autoCreate' | 'never' | 'lexer' | 'true' | 'forcedLower' | 'leftSpace' )
            int alt1=86;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 52:
                {
                alt1=2;
                }
                break;
            case 53:
                {
                alt1=3;
                }
                break;
            case 54:
                {
                alt1=4;
                }
                break;
            case 55:
                {
                alt1=5;
                }
                break;
            case 56:
                {
                alt1=6;
                }
                break;
            case 57:
                {
                alt1=7;
                }
                break;
            case 58:
                {
                alt1=8;
                }
                break;
            case 59:
                {
                alt1=9;
                }
                break;
            case ORKEYWORD:
                {
                alt1=10;
                }
                break;
            case 60:
                {
                alt1=11;
                }
                break;
            case 61:
                {
                alt1=12;
                }
                break;
            case 62:
                {
                alt1=13;
                }
                break;
            case 63:
                {
                alt1=14;
                }
                break;
            case 64:
                {
                alt1=15;
                }
                break;
            case 65:
                {
                alt1=16;
                }
                break;
            case 66:
                {
                alt1=17;
                }
                break;
            case 67:
                {
                alt1=18;
                }
                break;
            case 68:
                {
                alt1=19;
                }
                break;
            case 69:
                {
                alt1=20;
                }
                break;
            case 70:
                {
                alt1=21;
                }
                break;
            case 71:
                {
                alt1=22;
                }
                break;
            case 72:
                {
                alt1=23;
                }
                break;
            case 73:
                {
                alt1=24;
                }
                break;
            case 74:
                {
                alt1=25;
                }
                break;
            case 75:
                {
                alt1=26;
                }
                break;
            case 76:
                {
                alt1=27;
                }
                break;
            case 77:
                {
                alt1=28;
                }
                break;
            case 78:
                {
                alt1=29;
                }
                break;
            case 79:
                {
                alt1=30;
                }
                break;
            case 80:
                {
                alt1=31;
                }
                break;
            case 81:
                {
                alt1=32;
                }
                break;
            case 82:
                {
                alt1=33;
                }
                break;
            case 83:
                {
                alt1=34;
                }
                break;
            case 84:
                {
                alt1=35;
                }
                break;
            case 85:
                {
                alt1=36;
                }
                break;
            case 86:
                {
                alt1=37;
                }
                break;
            case 87:
                {
                alt1=38;
                }
                break;
            case 88:
                {
                alt1=39;
                }
                break;
            case 89:
                {
                alt1=40;
                }
                break;
            case 90:
                {
                alt1=41;
                }
                break;
            case 91:
                {
                alt1=42;
                }
                break;
            case 92:
                {
                alt1=43;
                }
                break;
            case 93:
                {
                alt1=44;
                }
                break;
            case 94:
                {
                alt1=45;
                }
                break;
            case 95:
                {
                alt1=46;
                }
                break;
            case 96:
                {
                alt1=47;
                }
                break;
            case 97:
                {
                alt1=48;
                }
                break;
            case 98:
                {
                alt1=49;
                }
                break;
            case 99:
                {
                alt1=50;
                }
                break;
            case 100:
                {
                alt1=51;
                }
                break;
            case 101:
                {
                alt1=52;
                }
                break;
            case 102:
                {
                alt1=53;
                }
                break;
            case 103:
                {
                alt1=54;
                }
                break;
            case 104:
                {
                alt1=55;
                }
                break;
            case 105:
                {
                alt1=56;
                }
                break;
            case 106:
                {
                alt1=57;
                }
                break;
            case 107:
                {
                alt1=58;
                }
                break;
            case 108:
                {
                alt1=59;
                }
                break;
            case 109:
                {
                alt1=60;
                }
                break;
            case 110:
                {
                alt1=61;
                }
                break;
            case 111:
                {
                alt1=62;
                }
                break;
            case 112:
                {
                alt1=63;
                }
                break;
            case 113:
                {
                alt1=64;
                }
                break;
            case 114:
                {
                alt1=65;
                }
                break;
            case 115:
                {
                alt1=66;
                }
                break;
            case 116:
                {
                alt1=67;
                }
                break;
            case 117:
                {
                alt1=68;
                }
                break;
            case 118:
                {
                alt1=69;
                }
                break;
            case 119:
                {
                alt1=70;
                }
                break;
            case 120:
                {
                alt1=71;
                }
                break;
            case 121:
                {
                alt1=72;
                }
                break;
            case 122:
                {
                alt1=73;
                }
                break;
            case 123:
                {
                alt1=74;
                }
                break;
            case 124:
                {
                alt1=75;
                }
                break;
            case 125:
                {
                alt1=76;
                }
                break;
            case 126:
                {
                alt1=77;
                }
                break;
            case 127:
                {
                alt1=78;
                }
                break;
            case 128:
                {
                alt1=79;
                }
                break;
            case 129:
                {
                alt1=80;
                }
                break;
            case 130:
                {
                alt1=81;
                }
                break;
            case 131:
                {
                alt1=82;
                }
                break;
            case 132:
                {
                alt1=83;
                }
                break;
            case 133:
                {
                alt1=84;
                }
                break;
            case 134:
                {
                alt1=85;
                }
                break;
            case 135:
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
                    // parser/TCS.g:221:5: 'instanceOf'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "instanceOf";
                    }

                    }
                    break;
                case 3 :
                    // parser/TCS.g:222:5: 'k'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "k";
                    }

                    }
                    break;
                case 4 :
                    // parser/TCS.g:223:5: 'template'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "template";
                    }

                    }
                    break;
                case 5 :
                    // parser/TCS.g:224:5: 'isDefined'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "isDefined";
                    }

                    }
                    break;
                case 6 :
                    // parser/TCS.g:225:5: 'one'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "one";
                    }

                    }
                    break;
                case 7 :
                    // parser/TCS.g:226:5: 'endNL'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endNL";
                    }

                    }
                    break;
                case 8 :
                    // parser/TCS.g:227:5: 'disambiguate'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguate";
                    }

                    }
                    break;
                case 9 :
                    // parser/TCS.g:228:5: 'createIn'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createIn";
                    }

                    }
                    break;
                case 10 :
                    // parser/TCS.g:229:5: 'orKeyword'
                    {
                    match(input,ORKEYWORD,FOLLOW_ORKEYWORD_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "orKeyword";
                    }

                    }
                    break;
                case 11 :
                    // parser/TCS.g:230:5: 'start'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "start";
                    }

                    }
                    break;
                case 12 :
                    // parser/TCS.g:231:5: 'syntax'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "syntax";
                    }

                    }
                    break;
                case 13 :
                    // parser/TCS.g:232:5: 'storeOpTo'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeOpTo";
                    }

                    }
                    break;
                case 14 :
                    // parser/TCS.g:233:5: 'nonPrimary'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nonPrimary";
                    }

                    }
                    break;
                case 15 :
                    // parser/TCS.g:234:5: 'omitted'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "omitted";
                    }

                    }
                    break;
                case 16 :
                    // parser/TCS.g:235:5: 'main'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "main";
                    }

                    }
                    break;
                case 17 :
                    // parser/TCS.g:236:5: 'esc'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "esc";
                    }

                    }
                    break;
                case 18 :
                    // parser/TCS.g:237:5: 'auto'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword236); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "auto";
                    }

                    }
                    break;
                case 19 :
                    // parser/TCS.g:238:5: 'enumerationTemplate'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword244); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "enumerationTemplate";
                    }

                    }
                    break;
                case 20 :
                    // parser/TCS.g:239:5: 'indentIncr'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword252); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "indentIncr";
                    }

                    }
                    break;
                case 21 :
                    // parser/TCS.g:240:5: 'storeRightTo'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword260); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeRightTo";
                    }

                    }
                    break;
                case 22 :
                    // parser/TCS.g:241:5: 'source'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword268); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "source";
                    }

                    }
                    break;
                case 23 :
                    // parser/TCS.g:242:5: 'foreach'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword276); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 24 :
                    // parser/TCS.g:243:5: 'rightSpace'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightSpace";
                    }

                    }
                    break;
                case 25 :
                    // parser/TCS.g:244:5: 'keywords'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "keywords";
                    }

                    }
                    break;
                case 26 :
                    // parser/TCS.g:245:5: 'priority'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword300); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "priority";
                    }

                    }
                    break;
                case 27 :
                    // parser/TCS.g:246:5: 'drop'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword308); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "drop";
                    }

                    }
                    break;
                case 28 :
                    // parser/TCS.g:247:5: 'addToContext'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword316); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "addToContext";
                    }

                    }
                    break;
                case 29 :
                    // parser/TCS.g:248:5: 'context'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword324); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 30 :
                    // parser/TCS.g:249:5: 'disambiguateV3'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword332); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguateV3";
                    }

                    }
                    break;
                case 31 :
                    // parser/TCS.g:250:5: 'and'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword340); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 32 :
                    // parser/TCS.g:251:5: 'rightNone'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword348); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightNone";
                    }

                    }
                    break;
                case 33 :
                    // parser/TCS.g:252:5: 'token'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword356); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "token";
                    }

                    }
                    break;
                case 34 :
                    // parser/TCS.g:253:5: 'prefix'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword364); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "prefix";
                    }

                    }
                    break;
                case 35 :
                    // parser/TCS.g:254:5: 'word'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword372); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "word";
                    }

                    }
                    break;
                case 36 :
                    // parser/TCS.g:255:5: 'as'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword380); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "as";
                    }

                    }
                    break;
                case 37 :
                    // parser/TCS.g:256:5: 'endOfLine'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword388); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endOfLine";
                    }

                    }
                    break;
                case 38 :
                    // parser/TCS.g:257:5: 'right'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword396); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "right";
                    }

                    }
                    break;
                case 39 :
                    // parser/TCS.g:258:5: 'nbNL'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword404); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nbNL";
                    }

                    }
                    break;
                case 40 :
                    // parser/TCS.g:259:5: 'postfix'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword412); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "postfix";
                    }

                    }
                    break;
                case 41 :
                    // parser/TCS.g:260:5: 'query'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword420); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "query";
                    }

                    }
                    break;
                case 42 :
                    // parser/TCS.g:261:5: 'value'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword428); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "value";
                    }

                    }
                    break;
                case 43 :
                    // parser/TCS.g:262:5: 'createAs'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword436); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createAs";
                    }

                    }
                    break;
                case 44 :
                    // parser/TCS.g:263:5: 'importContext'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword444); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "importContext";
                    }

                    }
                    break;
                case 45 :
                    // parser/TCS.g:264:5: 'operators'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword452); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operators";
                    }

                    }
                    break;
                case 46 :
                    // parser/TCS.g:265:5: 'multi'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword460); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multi";
                    }

                    }
                    break;
                case 47 :
                    // parser/TCS.g:266:5: 'always'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword468); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "always";
                    }

                    }
                    break;
                case 48 :
                    // parser/TCS.g:267:5: 'referenceOnly'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword476); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "referenceOnly";
                    }

                    }
                    break;
                case 49 :
                    // parser/TCS.g:268:5: 'false'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword484); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 50 :
                    // parser/TCS.g:269:5: 'serializer'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword492); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "serializer";
                    }

                    }
                    break;
                case 51 :
                    // parser/TCS.g:270:5: 'separator'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword500); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "separator";
                    }

                    }
                    break;
                case 52 :
                    // parser/TCS.g:271:5: 'for'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword508); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 53 :
                    // parser/TCS.g:272:5: 'end'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword516); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "end";
                    }

                    }
                    break;
                case 54 :
                    // parser/TCS.g:273:5: 'lookIn'
                    {
                    match(input,103,FOLLOW_103_in_identifierOrKeyword524); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookIn";
                    }

                    }
                    break;
                case 55 :
                    // parser/TCS.g:274:5: 'leftNone'
                    {
                    match(input,104,FOLLOW_104_in_identifierOrKeyword532); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftNone";
                    }

                    }
                    break;
                case 56 :
                    // parser/TCS.g:275:5: 'all'
                    {
                    match(input,105,FOLLOW_105_in_identifierOrKeyword540); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "all";
                    }

                    }
                    break;
                case 57 :
                    // parser/TCS.g:276:5: 'filter'
                    {
                    match(input,106,FOLLOW_106_in_identifierOrKeyword548); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "filter";
                    }

                    }
                    break;
                case 58 :
                    // parser/TCS.g:277:5: 'function'
                    {
                    match(input,107,FOLLOW_107_in_identifierOrKeyword556); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "function";
                    }

                    }
                    break;
                case 59 :
                    // parser/TCS.g:278:5: 'forcedUpper'
                    {
                    match(input,108,FOLLOW_108_in_identifierOrKeyword564); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedUpper";
                    }

                    }
                    break;
                case 60 :
                    // parser/TCS.g:279:5: 'default'
                    {
                    match(input,109,FOLLOW_109_in_identifierOrKeyword572); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "default";
                    }

                    }
                    break;
                case 61 :
                    // parser/TCS.g:280:5: 'multiLine'
                    {
                    match(input,110,FOLLOW_110_in_identifierOrKeyword580); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multiLine";
                    }

                    }
                    break;
                case 62 :
                    // parser/TCS.g:281:5: 'when'
                    {
                    match(input,111,FOLLOW_111_in_identifierOrKeyword588); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "when";
                    }

                    }
                    break;
                case 63 :
                    // parser/TCS.g:282:5: 'startNbNL'
                    {
                    match(input,112,FOLLOW_112_in_identifierOrKeyword596); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNbNL";
                    }

                    }
                    break;
                case 64 :
                    // parser/TCS.g:283:5: 'invert'
                    {
                    match(input,113,FOLLOW_113_in_identifierOrKeyword604); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "invert";
                    }

                    }
                    break;
                case 65 :
                    // parser/TCS.g:284:5: 'ifmissing'
                    {
                    match(input,114,FOLLOW_114_in_identifierOrKeyword612); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "ifmissing";
                    }

                    }
                    break;
                case 66 :
                    // parser/TCS.g:285:5: 'mode'
                    {
                    match(input,115,FOLLOW_115_in_identifierOrKeyword620); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "mode";
                    }

                    }
                    break;
                case 67 :
                    // parser/TCS.g:286:5: 'deep'
                    {
                    match(input,116,FOLLOW_116_in_identifierOrKeyword628); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "deep";
                    }

                    }
                    break;
                case 68 :
                    // parser/TCS.g:287:5: 'octal'
                    {
                    match(input,117,FOLLOW_117_in_identifierOrKeyword636); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "octal";
                    }

                    }
                    break;
                case 69 :
                    // parser/TCS.g:288:5: 'hex'
                    {
                    match(input,118,FOLLOW_118_in_identifierOrKeyword644); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "hex";
                    }

                    }
                    break;
                case 70 :
                    // parser/TCS.g:289:5: 'operatorTemplate'
                    {
                    match(input,119,FOLLOW_119_in_identifierOrKeyword652); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatorTemplate";
                    }

                    }
                    break;
                case 71 :
                    // parser/TCS.g:290:5: 'symbols'
                    {
                    match(input,120,FOLLOW_120_in_identifierOrKeyword660); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "symbols";
                    }

                    }
                    break;
                case 72 :
                    // parser/TCS.g:291:5: 'abstract'
                    {
                    match(input,121,FOLLOW_121_in_identifierOrKeyword668); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 73 :
                    // parser/TCS.g:292:5: 'part'
                    {
                    match(input,122,FOLLOW_122_in_identifierOrKeyword676); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "part";
                    }

                    }
                    break;
                case 74 :
                    // parser/TCS.g:293:5: 'partial'
                    {
                    match(input,123,FOLLOW_123_in_identifierOrKeyword684); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "partial";
                    }

                    }
                    break;
                case 75 :
                    // parser/TCS.g:294:5: 'refersTo'
                    {
                    match(input,124,FOLLOW_124_in_identifierOrKeyword692); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "refersTo";
                    }

                    }
                    break;
                case 76 :
                    // parser/TCS.g:295:5: 'using'
                    {
                    match(input,125,FOLLOW_125_in_identifierOrKeyword700); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "using";
                    }

                    }
                    break;
                case 77 :
                    // parser/TCS.g:296:5: 'left'
                    {
                    match(input,126,FOLLOW_126_in_identifierOrKeyword708); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "left";
                    }

                    }
                    break;
                case 78 :
                    // parser/TCS.g:297:5: 'operatored'
                    {
                    match(input,127,FOLLOW_127_in_identifierOrKeyword716); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatored";
                    }

                    }
                    break;
                case 79 :
                    // parser/TCS.g:298:5: 'primitiveTemplate'
                    {
                    match(input,128,FOLLOW_128_in_identifierOrKeyword724); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "primitiveTemplate";
                    }

                    }
                    break;
                case 80 :
                    // parser/TCS.g:299:5: 'startNL'
                    {
                    match(input,129,FOLLOW_129_in_identifierOrKeyword732); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNL";
                    }

                    }
                    break;
                case 81 :
                    // parser/TCS.g:300:5: 'autoCreate'
                    {
                    match(input,130,FOLLOW_130_in_identifierOrKeyword740); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "autoCreate";
                    }

                    }
                    break;
                case 82 :
                    // parser/TCS.g:301:5: 'never'
                    {
                    match(input,131,FOLLOW_131_in_identifierOrKeyword748); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "never";
                    }

                    }
                    break;
                case 83 :
                    // parser/TCS.g:302:5: 'lexer'
                    {
                    match(input,132,FOLLOW_132_in_identifierOrKeyword756); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lexer";
                    }

                    }
                    break;
                case 84 :
                    // parser/TCS.g:303:5: 'true'
                    {
                    match(input,133,FOLLOW_133_in_identifierOrKeyword764); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 85 :
                    // parser/TCS.g:304:5: 'forcedLower'
                    {
                    match(input,134,FOLLOW_134_in_identifierOrKeyword772); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedLower";
                    }

                    }
                    break;
                case 86 :
                    // parser/TCS.g:305:5: 'leftSpace'
                    {
                    match(input,135,FOLLOW_135_in_identifierOrKeyword780); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftSpace";
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


    // $ANTLR start "qualifiedNameSymbol"
    // parser/TCS.g:342:1: qualifiedNameSymbol returns [Object ret2] : (ast= QNAME ) ;
    public final Object qualifiedNameSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:343:3: ( (ast= QNAME ) )
            // parser/TCS.g:344:3: (ast= QNAME )
            {
            // parser/TCS.g:344:3: (ast= QNAME )
            // parser/TCS.g:344:4: ast= QNAME
            {
            ast=(Token)match(input,QNAME,FOLLOW_QNAME_in_qualifiedNameSymbol904); if (state.failed) return ret2;
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


    // $ANTLR start "qualifiedNameSymbolList"
    // parser/TCS.g:352:1: qualifiedNameSymbolList returns [Object ret2] : (ast= QNAME ) ;
    public final Object qualifiedNameSymbolList() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:353:3: ( (ast= QNAME ) )
            // parser/TCS.g:354:3: (ast= QNAME )
            {
            // parser/TCS.g:354:3: (ast= QNAME )
            // parser/TCS.g:354:4: ast= QNAME
            {
            ast=(Token)match(input,QNAME,FOLLOW_QNAME_in_qualifiedNameSymbolList935); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = java.util.Arrays.asList(unescapeString( ast.getText()).split("::"));

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
    // $ANTLR end "qualifiedNameSymbolList"


    // $ANTLR start "textblockdefinition_textblockdefinition"
    // parser/TCS.g:362:1: textblockdefinition_textblockdefinition returns [Object ret2] : () ;
    public final Object textblockdefinition_textblockdefinition() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("textblockdefinition","TextBlockDefinition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:367:3: ( () )
            // parser/TCS.g:368:3: ()
            {
            // parser/TCS.g:368:3: ()
            // parser/TCS.g:368:4: 
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
    // parser/TCS.g:376:1: main returns [Object ret2] : ( (ret= tcs_concretesyntax ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:377:3: ( ( (ret= tcs_concretesyntax ) EOF ) )
            // parser/TCS.g:378:3: ( (ret= tcs_concretesyntax ) EOF )
            {
            // parser/TCS.g:378:3: ( (ret= tcs_concretesyntax ) EOF )
            // parser/TCS.g:378:4: (ret= tcs_concretesyntax ) EOF
            {
            // parser/TCS.g:378:4: (ret= tcs_concretesyntax )
            // parser/TCS.g:378:5: ret= tcs_concretesyntax
            {
            pushFollow(FOLLOW_tcs_concretesyntax_in_main1000);
            ret=tcs_concretesyntax();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main1003); if (state.failed) return ret2;

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
    // parser/TCS.g:385:1: tcs_concretesyntax returns [Object ret2] : ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) ;
    public final Object tcs_concretesyntax() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConcreteSyntax");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:390:3: ( ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) )
            // parser/TCS.g:391:3: ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            {
            // parser/TCS.g:391:3: ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            // parser/TCS.g:391:4: 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92486670E66411DEB6CBE1868D1505E2");
            }
            match(input,61,FOLLOW_61_in_tcs_concretesyntax1034); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD924BE8E0E66411DEA8ACE1868D1505E2");
            }
            // parser/TCS.g:391:146: (temp= identifier )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // parser/TCS.g:391:148: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_concretesyntax1041);
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
              _beforeSeqEl("E0DCF6CD925AB5F0E66411DEB64CE1868D1505E2");
            }
            // parser/TCS.g:391:276: ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LPAREN) ) {
                alt3=1;
            }
            else if ( (LA3_0==LCURLY) ) {
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
                    // parser/TCS.g:391:277: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:391:293: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    // parser/TCS.g:391:294: LPAREN 'k' EQ (temp= integerSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9257A8B0E66411DEC0E7E1868D1505E2");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_concretesyntax1056); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9257A8B1E66411DE932FE1868D1505E2");
                    }
                    match(input,53,FOLLOW_53_in_tcs_concretesyntax1060); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9257A8B2E66411DECCBFE1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1064); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9257A8B4E66411DE92FFE1868D1505E2");
                    }
                    // parser/TCS.g:391:593: (temp= integerSymbol )
                    // parser/TCS.g:391:595: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_tcs_concretesyntax1072);
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
                      _beforeSeqEl("E0DCF6CD9257CFC0E66411DEC953E1868D1505E2");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_concretesyntax1079); if (state.failed) return ret2;
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
                    // parser/TCS.g:391:762: 
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
              _beforeSeqEl("E0DCF6CD925CFFE0E66411DECB33E1868D1505E2");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1097); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD9268BFB0E66411DEAEAAE1868D1505E2");
            }
            // parser/TCS.g:392:159: ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) )
            // parser/TCS.g:392:160: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            {
            // parser/TCS.g:392:160: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            // parser/TCS.g:392:161: (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD925D26F1E66411DEBD39E1868D1505E2");
            }
            // parser/TCS.g:392:220: (temp= tcs_template (temp= tcs_template )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==54||LA5_0==68||LA5_0==107||LA5_0==119||LA5_0==128) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // parser/TCS.g:392:222: temp= tcs_template (temp= tcs_template )*
                    {
                    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax1108);
                    temp=tcs_template();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templates", temp);
                    }
                    // parser/TCS.g:392:279: (temp= tcs_template )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==54||LA4_0==68||LA4_0==107||LA4_0==119||LA4_0==128) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // parser/TCS.g:392:281: temp= tcs_template
                    	    {
                    	    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax1116);
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
              _beforeSeqEl("E0DCF6CD92611E90E66411DEB5E3E1868D1505E2");
            }
            // parser/TCS.g:392:419: ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==74) ) {
                alt8=1;
            }
            else if ( (LA8_0==RCURLY||LA8_0==64||LA8_0==82||LA8_0==94||LA8_0==120||LA8_0==132) ) {
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
                    // parser/TCS.g:392:420: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:392:436: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    // parser/TCS.g:392:437: 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD925D7511E66411DEA1B1E1868D1505E2");
                    }
                    match(input,74,FOLLOW_74_in_tcs_concretesyntax1133); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD925D9C20E66411DEB90BE1868D1505E2");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1137); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD925EFBB0E66411DEB12FE1868D1505E2");
                    }
                    // parser/TCS.g:392:664: ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) )
                    // parser/TCS.g:392:665: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    {
                    // parser/TCS.g:392:665: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    // parser/TCS.g:392:666: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD925D9C22E66411DEB802E1868D1505E2");
                    }
                    // parser/TCS.g:392:725: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==NAME||LA7_0==EQ) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // parser/TCS.g:392:727: temp= tcs_keyword (temp= tcs_keyword )*
                            {
                            pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax1148);
                            temp=tcs_keyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "keywords", temp);
                            }
                            // parser/TCS.g:392:782: (temp= tcs_keyword )*
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( (LA6_0==NAME||LA6_0==EQ) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // parser/TCS.g:392:784: temp= tcs_keyword
                            	    {
                            	    pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax1156);
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
                      _beforeSeqEl("E0DCF6CD9260D070E66411DE8BC2E1868D1505E2");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1171); if (state.failed) return ret2;
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
                    // parser/TCS.g:392:979: 
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
              _beforeSeqEl("E0DCF6CD92625710E66411DEAA56E1868D1505E2");
            }
            // parser/TCS.g:393:77: ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==120) ) {
                alt11=1;
            }
            else if ( (LA11_0==RCURLY||LA11_0==64||LA11_0==82||LA11_0==94||LA11_0==132) ) {
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
                    // parser/TCS.g:393:78: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:393:94: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    // parser/TCS.g:393:95: 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD926193C0E66411DE837EE1868D1505E2");
                    }
                    match(input,120,FOLLOW_120_in_tcs_concretesyntax1194); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD926193C1E66411DE9BEEE1868D1505E2");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1198); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9261E1E0E66411DEA331E1868D1505E2");
                    }
                    // parser/TCS.g:393:321: ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) )
                    // parser/TCS.g:393:322: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    {
                    // parser/TCS.g:393:322: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    // parser/TCS.g:393:323: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9261BAD1E66411DEA47DE1868D1505E2");
                    }
                    // parser/TCS.g:393:382: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NAME||LA10_0==EQ) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // parser/TCS.g:393:384: temp= tcs_symbol (temp= tcs_symbol )*
                            {
                            pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1209);
                            temp=tcs_symbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "symbols", temp);
                            }
                            // parser/TCS.g:393:437: (temp= tcs_symbol )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==NAME||LA9_0==EQ) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // parser/TCS.g:393:439: temp= tcs_symbol
                            	    {
                            	    pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1217);
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
                      _beforeSeqEl("E0DCF6CD926208F0E66411DEBA10E1868D1505E2");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1232); if (state.failed) return ret2;
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
                    // parser/TCS.g:393:632: 
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
              _beforeSeqEl("E0DCF6CD9262A530E66411DE988DE1868D1505E2");
            }
            // parser/TCS.g:394:76: (temp= tcs_operatorlist (temp= tcs_operatorlist )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==94) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // parser/TCS.g:394:78: temp= tcs_operatorlist (temp= tcs_operatorlist )*
                    {
                    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1253);
                    temp=tcs_operatorlist();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operatorLists", temp);
                    }
                    // parser/TCS.g:394:143: (temp= tcs_operatorlist )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==94) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // parser/TCS.g:394:145: temp= tcs_operatorlist
                    	    {
                    	    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1261);
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
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92631A60E66411DEC7A2E1868D1505E2");
            }
            // parser/TCS.g:394:290: (temp= tcs_token (temp= tcs_token )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==64||LA15_0==82) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // parser/TCS.g:394:292: temp= tcs_token (temp= tcs_token )*
                    {
                    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1276);
                    temp=tcs_token();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tokens", temp);
                    }
                    // parser/TCS.g:394:343: (temp= tcs_token )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==64||LA14_0==82) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // parser/TCS.g:394:345: temp= tcs_token
                    	    {
                    	    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1284);
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
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD9266C3E0E66411DEABCAE1868D1505E2");
            }
            // parser/TCS.g:394:477: ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==132) ) {
                alt16=1;
            }
            else if ( (LA16_0==RCURLY) ) {
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
                    // parser/TCS.g:394:478: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:394:494: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    // parser/TCS.g:394:495: 'lexer' EQ (temp= stringSymbol ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92636880E66411DE8D6AE1868D1505E2");
                    }
                    match(input,132,FOLLOW_132_in_tcs_concretesyntax1301); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92636881E66411DE82BAE1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1305); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92658B60E66411DEC8C9E1868D1505E2");
                    }
                    // parser/TCS.g:394:715: (temp= stringSymbol )
                    // parser/TCS.g:394:717: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_concretesyntax1313);
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
                      _beforeSeqEl("E0DCF6CD926675C0E66411DEA7D4E1868D1505E2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_concretesyntax1320); if (state.failed) return ret2;
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
                    // parser/TCS.g:394:885: 
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
              _beforeSeqEl("E0DCF6CD926A1F40E66411DEAFC7E1868D1505E2");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1341); if (state.failed) return ret2;
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
    // parser/TCS.g:403:1: reference[Object ret] : ( ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) | ( ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) ) ) ) ) ;
    public final void reference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // parser/TCS.g:404:3: ( ( ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) | ( ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) ) ) ) ) )
            // parser/TCS.g:405:3: ( ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) | ( ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) ) ) ) )
            {
            // parser/TCS.g:405:3: ( ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) | ( ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) ) ) ) )
            // parser/TCS.g:405:4: ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) | ( ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD9276F080E66411DEAF2DE1868D1505E2");
            }
            // parser/TCS.g:405:64: ( ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) | ( ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME||LA21_0==QNAME) ) {
                alt21=1;
            }
            else if ( (LA21_0==RARROW) ) {
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
                    // parser/TCS.g:405:65: ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:405:81: ( ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
                    // parser/TCS.g:405:82: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92717240E66411DEAF9BE1868D1505E2");
                    }
                    // parser/TCS.g:405:141: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==QNAME) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==NAME) ) {
                        alt17=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // parser/TCS.g:405:142: ( (temp= qualifiedNameSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:405:158: ( (temp= qualifiedNameSymbol ) )
                            // parser/TCS.g:405:159: (temp= qualifiedNameSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD926DEFD0E66411DE8C41E1868D1505E2");
                            }
                            // parser/TCS.g:405:218: (temp= qualifiedNameSymbol )
                            // parser/TCS.g:405:220: temp= qualifiedNameSymbol
                            {
                            pushFollow(FOLLOW_qualifiedNameSymbol_in_reference1391);
                            temp=qualifiedNameSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setOclRef(ret, "metaReference", null, temp, "let e=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  					i; acc:Tuple(pos:Integer, ns:Set(Model::Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"            			  e.ns.contents->select(c | c.name=?.subString(e.pos, ?.size()))");
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
                            // parser/TCS.g:406:4: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // parser/TCS.g:406:20: ( (temp= identifier ) )
                            // parser/TCS.g:406:21: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD927087E3E66411DECC5AE1868D1505E2");
                            }
                            // parser/TCS.g:406:80: (temp= identifier )
                            // parser/TCS.g:406:82: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_reference1411);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setOclRef(ret, "metaReference", null, temp, "Classifier.allInstances()->select(c | c.name = ?)");
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
                    // parser/TCS.g:406:264: ( ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:406:280: ( ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) ) )
                    // parser/TCS.g:406:281: ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9276A260E66411DE9C00E1868D1505E2");
                    }
                    // parser/TCS.g:406:340: ( ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? ) | ( RARROW (temp= identifier ) ) )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RARROW) ) {
                        int LA20_1 = input.LA(2);

                        if ( (LA20_1==NAME) ) {
                            alt20=2;
                        }
                        else if ( ((LA20_1>=QNAME && LA20_1<=LPAREN)||LA20_1==RPAREN||LA20_1==SEMI||LA20_1==COLON||LA20_1==SHARP||LA20_1==63||LA20_1==65||LA20_1==67||(LA20_1>=77 && LA20_1<=78)||LA20_1==83||LA20_1==95||LA20_1==97||LA20_1==109||LA20_1==116||LA20_1==121||LA20_1==125||LA20_1==127) ) {
                            alt20=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 20, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // parser/TCS.g:406:341: ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:406:357: ( RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )? )
                            // parser/TCS.g:406:358: RARROW (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )?
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92731FF0E66411DE919BE1868D1505E2");
                            }
                            match(input,RARROW,FOLLOW_RARROW_in_reference1437); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92731FF3E66411DE9837E1868D1505E2");
                            }
                            // parser/TCS.g:406:500: (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==QNAME) ) {
                                alt19=1;
                            }
                            switch (alt19) {
                                case 1 :
                                    // parser/TCS.g:406:502: temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )*
                                    {
                                    pushFollow(FOLLOW_qualifiedNameSymbolList_in_reference1445);
                                    temp=qualifiedNameSymbolList();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "names", temp);
                                    }
                                    // parser/TCS.g:406:566: (temp= qualifiedNameSymbolList )*
                                    loop18:
                                    do {
                                        int alt18=2;
                                        int LA18_0 = input.LA(1);

                                        if ( (LA18_0==QNAME) ) {
                                            alt18=1;
                                        }


                                        switch (alt18) {
                                    	case 1 :
                                    	    // parser/TCS.g:406:568: temp= qualifiedNameSymbolList
                                    	    {
                                    	    pushFollow(FOLLOW_qualifiedNameSymbolList_in_reference1453);
                                    	    temp=qualifiedNameSymbolList();

                                    	    checkFollows();
                                    	    state._fsp--;
                                    	    if (state.failed) return ;
                                    	    if ( state.backtracking==0 ) {
                                    	      setProperty(ret, "names", temp);
                                    	    }

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop18;
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
                            // parser/TCS.g:407:4: ( RARROW (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // parser/TCS.g:407:20: ( RARROW (temp= identifier ) )
                            // parser/TCS.g:407:21: RARROW (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92736E10E66411DECC94E1868D1505E2");
                            }
                            match(input,RARROW,FOLLOW_RARROW_in_reference1475); if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92762D30E66411DEB46DE1868D1505E2");
                            }
                            // parser/TCS.g:407:163: (temp= identifier )
                            // parser/TCS.g:407:165: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_reference1483);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "names", temp);
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
    // parser/TCS.g:415:1: tcs_template returns [Object ret2] : (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate ) ;
    public final Object tcs_template() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:416:3: ( (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate ) )
            // parser/TCS.g:417:3: (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate )
            {
            // parser/TCS.g:417:3: (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate )
            int alt22=4;
            switch ( input.LA(1) ) {
            case 54:
            case 119:
                {
                alt22=1;
                }
                break;
            case 128:
                {
                alt22=2;
                }
                break;
            case 68:
                {
                alt22=3;
                }
                break;
            case 107:
                {
                alt22=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // parser/TCS.g:417:4: ret= tcs_contexttemplate
                    {
                    pushFollow(FOLLOW_tcs_contexttemplate_in_tcs_template1524);
                    ret=tcs_contexttemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:418:5: ret= tcs_primitivetemplate
                    {
                    pushFollow(FOLLOW_tcs_primitivetemplate_in_tcs_template1532);
                    ret=tcs_primitivetemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:419:5: ret= tcs_enumerationtemplate
                    {
                    pushFollow(FOLLOW_tcs_enumerationtemplate_in_tcs_template1540);
                    ret=tcs_enumerationtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:420:5: ret= tcs_functiontemplate
                    {
                    pushFollow(FOLLOW_tcs_functiontemplate_in_tcs_template1548);
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


    // $ANTLR start "tcs_contexttemplate"
    // parser/TCS.g:427:1: tcs_contexttemplate returns [Object ret2] : (ret= tcs_classtemplate | ret= tcs_operatortemplate ) ;
    public final Object tcs_contexttemplate() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:428:3: ( (ret= tcs_classtemplate | ret= tcs_operatortemplate ) )
            // parser/TCS.g:429:3: (ret= tcs_classtemplate | ret= tcs_operatortemplate )
            {
            // parser/TCS.g:429:3: (ret= tcs_classtemplate | ret= tcs_operatortemplate )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==54) ) {
                alt23=1;
            }
            else if ( (LA23_0==119) ) {
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
                    // parser/TCS.g:429:4: ret= tcs_classtemplate
                    {
                    pushFollow(FOLLOW_tcs_classtemplate_in_tcs_contexttemplate1575);
                    ret=tcs_classtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:430:5: ret= tcs_operatortemplate
                    {
                    pushFollow(FOLLOW_tcs_operatortemplate_in_tcs_contexttemplate1583);
                    ret=tcs_operatortemplate();

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
    // $ANTLR end "tcs_contexttemplate"


    // $ANTLR start "tcs_primitivetemplate"
    // parser/TCS.g:437:1: tcs_primitivetemplate returns [Object ret2] : ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_primitivetemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitiveTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:442:3: ( ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:443:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:443:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:443:4: 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD927AE820E66411DEC4A7E1868D1505E2");
            }
            match(input,128,FOLLOW_128_in_tcs_primitivetemplate1613); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD927B0F30E66411DE8CA4E1868D1505E2");
            }
            // parser/TCS.g:443:157: (temp= identifier )
            // parser/TCS.g:443:159: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1620);
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
              _beforeSeqEl("E0DCF6CD927B0F31E66411DE8322E1868D1505E2");
            }
            match(input,101,FOLLOW_101_in_tcs_primitivetemplate1626); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD927B8460E66411DEC992E1868D1505E2");
            }
            pushFollow(FOLLOW_reference_in_tcs_primitivetemplate1629);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD927DA740E66411DEC172E1868D1505E2");
            }
            // parser/TCS.g:443:462: ( ( 'default' ) | )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==109) ) {
                alt24=1;
            }
            else if ( (LA24_0==125) ) {
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
                    // parser/TCS.g:443:463: ( 'default' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:443:479: ( 'default' )
                    // parser/TCS.g:443:480: 'default'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD927D8031E66411DEC1ACE1868D1505E2");
                    }
                    match(input,109,FOLLOW_109_in_tcs_primitivetemplate1639); if (state.failed) return ret2;
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
                    // parser/TCS.g:443:638: 
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
              _beforeSeqEl("E0DCF6CD927DCE50E66411DEA4B7E1868D1505E2");
            }
            match(input,125,FOLLOW_125_in_tcs_primitivetemplate1657); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD927DCE52E66411DEAC30E1868D1505E2");
            }
            // parser/TCS.g:444:158: (temp= identifier )
            // parser/TCS.g:444:160: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1664);
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
              _beforeSeqEl("E0DCF6CD927EDFC0E66411DE842BE1868D1505E2");
            }
            // parser/TCS.g:444:291: ( ( 'orKeyword' ) | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ORKEYWORD) ) {
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
                    // parser/TCS.g:444:292: ( 'orKeyword' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:444:308: ( 'orKeyword' )
                    // parser/TCS.g:444:309: 'orKeyword'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD927EB8B1E66411DEB9CAE1868D1505E2");
                    }
                    match(input,ORKEYWORD,FOLLOW_ORKEYWORD_in_tcs_primitivetemplate1676); if (state.failed) return ret2;
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
                    // parser/TCS.g:444:469: 
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
              _beforeSeqEl("E0DCF6CD927F06D0E66411DE8CC6E1868D1505E2");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_primitivetemplate1695); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD927F06D1E66411DEC2EAE1868D1505E2");
            }
            match(input,91,FOLLOW_91_in_tcs_primitivetemplate1699); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD927F06D2E66411DEB57AE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1703); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD927F2DE0E66411DECCD0E1868D1505E2");
            }
            // parser/TCS.g:445:319: (temp= stringSymbol )
            // parser/TCS.g:445:321: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1711);
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
              _beforeSeqEl("E0DCF6CD927FF130E66411DE9441E1868D1505E2");
            }
            // parser/TCS.g:445:450: ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | )
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
                    // parser/TCS.g:445:451: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:445:467: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:445:468: COMA 'serializer' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD927F7C00E66411DE8755E1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_primitivetemplate1724); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD927F7C01E66411DEA84FE1868D1505E2");
                    }
                    match(input,99,FOLLOW_99_in_tcs_primitivetemplate1728); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD927F7C02E66411DEA822E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1732); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD927F7C05E66411DE95CCE1868D1505E2");
                    }
                    // parser/TCS.g:445:774: (temp= stringSymbol )
                    // parser/TCS.g:445:776: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1740);
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
                    // parser/TCS.g:445:868: 
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
              _beforeSeqEl("E0DCF6CD927FF131E66411DE987BE1868D1505E2");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_primitivetemplate1760); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92801842E66411DEBDBAE1868D1505E2");
            }
            // parser/TCS.g:446:157: (temp= textblockdefinition_textblockdefinition )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // parser/TCS.g:446:159: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_primitivetemplate1768);
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
    // parser/TCS.g:454:1: tcs_enumerationtemplate returns [Object ret2] : ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_enumerationtemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumerationTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:459:3: ( ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:460:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:460:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:460:4: 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92819EE0E66411DEB1ECE1868D1505E2");
            }
            match(input,68,FOLLOW_68_in_tcs_enumerationtemplate1813); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92819EE1E66411DEB644E1868D1505E2");
            }
            pushFollow(FOLLOW_reference_in_tcs_enumerationtemplate1816);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD9281ED00E66411DECF98E1868D1505E2");
            }
            // parser/TCS.g:460:249: ( ( 'auto' ) | )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==67) ) {
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
                    // parser/TCS.g:460:250: ( 'auto' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:460:266: ( 'auto' )
                    // parser/TCS.g:460:267: 'auto'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9281C5F1E66411DEBBDDE1868D1505E2");
                    }
                    match(input,67,FOLLOW_67_in_tcs_enumerationtemplate1826); if (state.failed) return ret2;
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
                    // parser/TCS.g:460:422: 
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
              _beforeSeqEl("E0DCF6CD9286CF00E66411DEB7B7E1868D1505E2");
            }
            // parser/TCS.g:461:77: ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) )
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
                    // parser/TCS.g:461:78: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:461:94: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    // parser/TCS.g:461:95: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD928680E0E66411DEB30FE1868D1505E2");
                    }
                    // parser/TCS.g:461:154: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    // parser/TCS.g:461:155: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    {
                    // parser/TCS.g:461:155: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    // parser/TCS.g:461:156: COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92823B20E66411DEA28FE1868D1505E2");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_enumerationtemplate1854); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD928632C0E66411DEB1ECE1868D1505E2");
                    }
                    // parser/TCS.g:461:297: ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) )
                    // parser/TCS.g:461:298: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    {
                    // parser/TCS.g:461:298: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    // parser/TCS.g:461:299: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9284FA40E66411DEBF74E1868D1505E2");
                    }
                    // parser/TCS.g:461:358: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==SHARP) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // parser/TCS.g:461:360: temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )*
                            {
                            pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate1865);
                            temp=tcs_enumliteralmapping();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mappings", temp);
                            }
                            // parser/TCS.g:461:426: ( ( COMA ) temp= tcs_enumliteralmapping )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==COMA) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // parser/TCS.g:461:427: ( COMA ) temp= tcs_enumliteralmapping
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:461:444: ( COMA )
                            	    // parser/TCS.g:461:445: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD92823B22E66411DEB978E1868D1505E2");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_enumerationtemplate1874); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate1882);
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
                      _beforeSeqEl("E0DCF6CD928659D0E66411DE81F9E1868D1505E2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate1897); if (state.failed) return ret2;
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
                    // parser/TCS.g:461:766: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:461:782: ( SEMI )
                    // parser/TCS.g:461:783: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9286A7F0E66411DEA742E1868D1505E2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate1914); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD9286F612E66411DE91DCE1868D1505E2");
            }
            // parser/TCS.g:462:76: (temp= textblockdefinition_textblockdefinition )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // parser/TCS.g:462:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_enumerationtemplate1928);
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
    // parser/TCS.g:470:1: tcs_enumliteralmapping returns [Object ret2] : ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) ) ;
    public final Object tcs_enumliteralmapping() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:475:3: ( ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) ) )
            // parser/TCS.g:476:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) )
            {
            // parser/TCS.g:476:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) )
            // parser/TCS.g:476:4: (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92879251E66411DEC815E1868D1505E2");
            }
            // parser/TCS.g:476:63: (temp= tcs_enumliteralval )
            // parser/TCS.g:476:65: temp= tcs_enumliteralval
            {
            pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping1977);
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
              _beforeSeqEl("E0DCF6CD92879252E66411DE90EBE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_enumliteralmapping1984); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92879254E66411DEB4FCE1868D1505E2");
            }
            // parser/TCS.g:476:280: (temp= tcs_literalref )
            // parser/TCS.g:476:282: temp= tcs_literalref
            {
            pushFollow(FOLLOW_tcs_literalref_in_tcs_enumliteralmapping1992);
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
    // parser/TCS.g:484:1: tcs_classtemplate returns [Object ret2] : ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_classtemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:489:3: ( ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:490:3: ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:490:3: ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:490:4: 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD9288A3C0E66411DE9B3CE1868D1505E2");
            }
            match(input,54,FOLLOW_54_in_tcs_classtemplate2035); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD9288A3C1E66411DE96AFE1868D1505E2");
            }
            pushFollow(FOLLOW_reference_in_tcs_classtemplate2038);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929267C0E66411DECBBCE1868D1505E2");
            }
            // parser/TCS.g:490:238: ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==97) ) {
                alt47=1;
            }
            else if ( (LA47_0==LPAREN||LA47_0==SEMI||LA47_0==COLON||LA47_0==SHARP||LA47_0==63||LA47_0==65||(LA47_0>=77 && LA47_0<=78)||LA47_0==83||LA47_0==95||LA47_0==116||LA47_0==121||LA47_0==127) ) {
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
                    // parser/TCS.g:490:239: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:490:255: ( 'referenceOnly' )
                    // parser/TCS.g:490:256: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9288F1E0E66411DEA75DE1868D1505E2");
                    }
                    match(input,97,FOLLOW_97_in_tcs_classtemplate2048); if (state.failed) return ret2;
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
                    // parser/TCS.g:490:426: ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:490:442: ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) )
                    // parser/TCS.g:490:443: ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92896711E66411DECD65E1868D1505E2");
                    }
                    // parser/TCS.g:490:503: ( ( SHARP (temp= identifier ) ) | )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==SHARP) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==LPAREN||LA33_0==SEMI||LA33_0==COLON||LA33_0==63||LA33_0==65||(LA33_0>=77 && LA33_0<=78)||LA33_0==83||LA33_0==95||LA33_0==116||LA33_0==121||LA33_0==127) ) {
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
                            // parser/TCS.g:490:504: ( SHARP (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:490:520: ( SHARP (temp= identifier ) )
                            // parser/TCS.g:490:521: SHARP (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92894000E66411DECF29E1868D1505E2");
                            }
                            match(input,SHARP,FOLLOW_SHARP_in_tcs_classtemplate2068); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92894002E66411DEA2F9E1868D1505E2");
                            }
                            // parser/TCS.g:490:662: (temp= identifier )
                            // parser/TCS.g:490:664: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_classtemplate2076);
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
                            // parser/TCS.g:490:748: 
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
                      _beforeSeqEl("E0DCF6CD928A2A60E66411DEBE48E1868D1505E2");
                    }
                    // parser/TCS.g:491:77: ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==LPAREN) ) {
                        int LA34_1 = input.LA(2);

                        if ( (LA34_1==58) ) {
                            alt34=1;
                        }
                        else if ( (LA34_1==79) ) {
                            alt34=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 34, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA34_0==SEMI||LA34_0==COLON||LA34_0==63||LA34_0==65||(LA34_0>=77 && LA34_0<=78)||LA34_0==83||LA34_0==95||LA34_0==116||LA34_0==121||LA34_0==127) ) {
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
                            // parser/TCS.g:491:78: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:491:94: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:491:95: LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD9289B531E66411DE8D09E1868D1505E2");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2102); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD9289B532E66411DE8E16E1868D1505E2");
                            }
                            match(input,58,FOLLOW_58_in_tcs_classtemplate2106); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD9289B533E66411DEB629E1868D1505E2");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2110); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD9289DC42E66411DE87ACE1868D1505E2");
                            }
                            // parser/TCS.g:491:405: (temp= stringSymbol )
                            // parser/TCS.g:491:407: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2118);
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
                              _beforeSeqEl("E0DCF6CD928A0350E66411DEAA27E1868D1505E2");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2125); if (state.failed) return ret2;
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
                            // parser/TCS.g:491:584: 
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
                      _beforeSeqEl("E0DCF6CD928AEDB0E66411DEC105E1868D1505E2");
                    }
                    // parser/TCS.g:492:77: ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==LPAREN) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==SEMI||LA35_0==COLON||LA35_0==63||LA35_0==65||(LA35_0>=77 && LA35_0<=78)||LA35_0==83||LA35_0==95||LA35_0==116||LA35_0==121||LA35_0==127) ) {
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
                            // parser/TCS.g:492:78: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:492:94: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:492:95: LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928A7880E66411DEC6CBE1868D1505E2");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2149); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928A7881E66411DE9972E1868D1505E2");
                            }
                            match(input,79,FOLLOW_79_in_tcs_classtemplate2153); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928A7882E66411DE8714E1868D1505E2");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2157); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928A7885E66411DE82D0E1868D1505E2");
                            }
                            // parser/TCS.g:492:407: (temp= stringSymbol )
                            // parser/TCS.g:492:409: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2165);
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
                              _beforeSeqEl("E0DCF6CD928A9F90E66411DEB726E1868D1505E2");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2172); if (state.failed) return ret2;
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
                            // parser/TCS.g:492:588: 
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
                      _beforeSeqEl("E0DCF6CD928B3BD2E66411DE8FC6E1868D1505E2");
                    }
                    // parser/TCS.g:493:77: ( ( 'multi' ) | )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==95) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==SEMI||LA36_0==COLON||LA36_0==63||LA36_0==65||(LA36_0>=77 && LA36_0<=78)||LA36_0==83||LA36_0==116||LA36_0==121||LA36_0==127) ) {
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
                            // parser/TCS.g:493:78: ( 'multi' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:493:94: ( 'multi' )
                            // parser/TCS.g:493:95: 'multi'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928B3BD0E66411DEB4B5E1868D1505E2");
                            }
                            match(input,95,FOLLOW_95_in_tcs_classtemplate2195); if (state.failed) return ret2;
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
                            // parser/TCS.g:493:249: 
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
                      _beforeSeqEl("E0DCF6CD928BB100E66411DEBF9DE1868D1505E2");
                    }
                    // parser/TCS.g:494:77: ( ( 'main' ) | )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==65) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==SEMI||LA37_0==COLON||LA37_0==63||(LA37_0>=77 && LA37_0<=78)||LA37_0==83||LA37_0==116||LA37_0==121||LA37_0==127) ) {
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
                            // parser/TCS.g:494:78: ( 'main' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:494:94: ( 'main' )
                            // parser/TCS.g:494:95: 'main'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928B89F1E66411DEB659E1868D1505E2");
                            }
                            match(input,65,FOLLOW_65_in_tcs_classtemplate2219); if (state.failed) return ret2;
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
                            // parser/TCS.g:494:247: 
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
                      _beforeSeqEl("E0DCF6CD928D1090E66411DEB346E1868D1505E2");
                    }
                    // parser/TCS.g:495:77: ( ( ( ( 'deep' ) | ) 'abstract' ) | )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==116||LA39_0==121) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==SEMI||LA39_0==COLON||LA39_0==63||(LA39_0>=77 && LA39_0<=78)||LA39_0==83||LA39_0==127) ) {
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
                            // parser/TCS.g:495:78: ( ( ( 'deep' ) | ) 'abstract' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:495:94: ( ( ( 'deep' ) | ) 'abstract' )
                            // parser/TCS.g:495:95: ( ( 'deep' ) | ) 'abstract'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928C2632E66411DECEA0E1868D1505E2");
                            }
                            // parser/TCS.g:495:155: ( ( 'deep' ) | )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( (LA38_0==116) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==121) ) {
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
                                    // parser/TCS.g:495:156: ( 'deep' )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:495:172: ( 'deep' )
                                    // parser/TCS.g:495:173: 'deep'
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD928C2630E66411DE96A3E1868D1505E2");
                                    }
                                    match(input,116,FOLLOW_116_in_tcs_classtemplate2249); if (state.failed) return ret2;
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
                                    // parser/TCS.g:495:325: 
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
                              _beforeSeqEl("E0DCF6CD928CE980E66411DE9267E1868D1505E2");
                            }
                            match(input,121,FOLLOW_121_in_tcs_classtemplate2267); if (state.failed) return ret2;
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
                            // parser/TCS.g:496:177: 
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
                      _beforeSeqEl("E0DCF6CD928F0C61E66411DE96EEE1868D1505E2");
                    }
                    // parser/TCS.g:497:77: ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==127) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==SEMI||LA41_0==COLON||LA41_0==63||(LA41_0>=77 && LA41_0<=78)||LA41_0==83) ) {
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
                            // parser/TCS.g:497:78: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:497:94: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            // parser/TCS.g:497:95: 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928D37A3E66411DEB4C1E1868D1505E2");
                            }
                            match(input,127,FOLLOW_127_in_tcs_classtemplate2291); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928EE550E66411DE96B1E1868D1505E2");
                            }
                            // parser/TCS.g:497:242: ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==LPAREN) ) {
                                alt40=1;
                            }
                            else if ( (LA40_0==SEMI||LA40_0==COLON||LA40_0==63||(LA40_0>=77 && LA40_0<=78)||LA40_0==83) ) {
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
                                    // parser/TCS.g:497:243: ( LPAREN (temp= identifier ) RPAREN )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:497:259: ( LPAREN (temp= identifier ) RPAREN )
                                    // parser/TCS.g:497:260: LPAREN (temp= identifier ) RPAREN
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD928D85C0E66411DE9744E1868D1505E2");
                                    }
                                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2301); if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD928E9730E66411DEB097E1868D1505E2");
                                    }
                                    // parser/TCS.g:497:402: (temp= identifier )
                                    // parser/TCS.g:497:404: temp= identifier
                                    {
                                    pushFollow(FOLLOW_identifier_in_tcs_classtemplate2309);
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
                                      _beforeSeqEl("E0DCF6CD928EBE40E66411DE8C61E1868D1505E2");
                                    }
                                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2316); if (state.failed) return ret2;
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
                                    // parser/TCS.g:497:644: 
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
                            // parser/TCS.g:498:94: 
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
                      _beforeSeqEl("E0DCF6CD928FCFB1E66411DEBC5BE1868D1505E2");
                    }
                    // parser/TCS.g:499:77: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==78) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==SEMI||LA43_0==COLON||LA43_0==63||LA43_0==77||LA43_0==83) ) {
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
                            // parser/TCS.g:499:78: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:499:94: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            // parser/TCS.g:499:95: 'context' ( ( (temp= tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928F5A81E66411DE8817E1868D1505E2");
                            }
                            match(input,78,FOLLOW_78_in_tcs_classtemplate2354); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD928FA8A1E66411DE86B9E1868D1505E2");
                            }
                            // parser/TCS.g:499:239: ( ( (temp= tcs_contexttags ) ) | )
                            int alt42=2;
                            int LA42_0 = input.LA(1);

                            if ( (LA42_0==LPAREN) ) {
                                alt42=1;
                            }
                            else if ( (LA42_0==SEMI||LA42_0==COLON||LA42_0==63||LA42_0==77||LA42_0==83) ) {
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
                                    // parser/TCS.g:499:240: ( (temp= tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:499:256: ( (temp= tcs_contexttags ) )
                                    // parser/TCS.g:499:257: (temp= tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD928F8192E66411DE8EE2E1868D1505E2");
                                    }
                                    // parser/TCS.g:499:316: (temp= tcs_contexttags )
                                    // parser/TCS.g:499:318: temp= tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_tcs_contexttags_in_tcs_classtemplate2367);
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
                                    // parser/TCS.g:499:414: 
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
                            // parser/TCS.g:500:91: 
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
                      _beforeSeqEl("E0DCF6CD92901DD2E66411DE9090E1868D1505E2");
                    }
                    // parser/TCS.g:501:77: ( ( 'addToContext' ) | )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==77) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==SEMI||LA44_0==COLON||LA44_0==63||LA44_0==83) ) {
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
                            // parser/TCS.g:501:78: ( 'addToContext' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:501:94: ( 'addToContext' )
                            // parser/TCS.g:501:95: 'addToContext'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92901DD0E66411DEA58CE1868D1505E2");
                            }
                            match(input,77,FOLLOW_77_in_tcs_classtemplate2407); if (state.failed) return ret2;
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
                            // parser/TCS.g:501:263: 
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
                      _beforeSeqEl("E0DCF6CD92909300E66411DECA51E1868D1505E2");
                    }
                    // parser/TCS.g:502:77: ( ( 'nonPrimary' ) | )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==63) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==SEMI||LA45_0==COLON||LA45_0==83) ) {
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
                            // parser/TCS.g:502:78: ( 'nonPrimary' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:502:94: ( 'nonPrimary' )
                            // parser/TCS.g:502:95: 'nonPrimary'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92906BF1E66411DEBE3CE1868D1505E2");
                            }
                            match(input,63,FOLLOW_63_in_tcs_classtemplate2431); if (state.failed) return ret2;
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
                            // parser/TCS.g:502:259: 
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
                      _beforeSeqEl("E0DCF6CD9291F290E66411DEA25AE1868D1505E2");
                    }
                    // parser/TCS.g:503:77: ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==83) ) {
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
                            // parser/TCS.g:503:78: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:503:94: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                            // parser/TCS.g:503:95: 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92915650E66411DEB507E1868D1505E2");
                            }
                            match(input,83,FOLLOW_83_in_tcs_classtemplate2455); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD9291CB80E66411DEB718E1868D1505E2");
                            }
                            // parser/TCS.g:503:237: ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                            // parser/TCS.g:503:238: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                            {
                            // parser/TCS.g:503:238: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                            // parser/TCS.g:503:239: COLON ( ( (temp= tcs_sequence ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92915651E66411DEAC1EE1868D1505E2");
                            }
                            match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2462); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92917D62E66411DEA191E1868D1505E2");
                            }
                            // parser/TCS.g:503:380: ( ( (temp= tcs_sequence ) ) )
                            // parser/TCS.g:503:381: ( (temp= tcs_sequence ) )
                            {
                            // parser/TCS.g:503:381: ( (temp= tcs_sequence ) )
                            // parser/TCS.g:503:382: (temp= tcs_sequence )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92915653E66411DE823DE1868D1505E2");
                            }
                            // parser/TCS.g:503:441: (temp= tcs_sequence )
                            // parser/TCS.g:503:443: temp= tcs_sequence
                            {
                            pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2473);
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
                            // parser/TCS.g:503:575: 
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
              _beforeSeqEl("E0DCF6CD92935221E66411DE8D73E1868D1505E2");
            }
            // parser/TCS.g:505:77: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
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
                    // parser/TCS.g:505:78: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:505:94: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // parser/TCS.g:505:95: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92932B10E66411DEB900E1868D1505E2");
                    }
                    // parser/TCS.g:505:154: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // parser/TCS.g:505:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // parser/TCS.g:505:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // parser/TCS.g:505:156: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9292B5E0E66411DEA8DEE1868D1505E2");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2515); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9292DCF1E66411DEA041E1868D1505E2");
                    }
                    // parser/TCS.g:505:297: ( ( (temp= tcs_sequence ) ) )
                    // parser/TCS.g:505:298: ( (temp= tcs_sequence ) )
                    {
                    // parser/TCS.g:505:298: ( (temp= tcs_sequence ) )
                    // parser/TCS.g:505:299: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9292B5E2E66411DEBA14E1868D1505E2");
                    }
                    // parser/TCS.g:505:358: (temp= tcs_sequence )
                    // parser/TCS.g:505:360: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2526);
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
                      _beforeSeqEl("E0DCF6CD92930400E66411DE9C6FE1868D1505E2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2536); if (state.failed) return ret2;
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
                    // parser/TCS.g:505:575: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:505:591: ( SEMI )
                    // parser/TCS.g:505:592: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92932B12E66411DEC354E1868D1505E2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2553); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD92937932E66411DE9221E1868D1505E2");
            }
            // parser/TCS.g:506:76: (temp= textblockdefinition_textblockdefinition )?
            int alt49=2;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // parser/TCS.g:506:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_classtemplate2567);
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
    // parser/TCS.g:514:1: tcs_operatortemplate returns [Object ret2] : ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_operatortemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:519:3: ( ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:520:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:520:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:520:4: 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92941570E66411DECDBAE1868D1505E2");
            }
            match(input,119,FOLLOW_119_in_tcs_operatortemplate2612); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92941571E66411DEAD0AE1868D1505E2");
            }
            pushFollow(FOLLOW_reference_in_tcs_operatortemplate2615);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92941572E66411DE9A0AE1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_operatortemplate2620); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92941573E66411DEB8CEE1868D1505E2");
            }
            match(input,94,FOLLOW_94_in_tcs_operatortemplate2624); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92941574E66411DEA6E0E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2628); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92943C82E66411DE9AE4E1868D1505E2");
            }
            // parser/TCS.g:520:493: (temp= identifier (temp= identifier )* )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==NAME) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // parser/TCS.g:520:495: temp= identifier (temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2636);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);
                    }
                    // parser/TCS.g:520:611: (temp= identifier )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==NAME) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // parser/TCS.g:520:613: temp= identifier
                    	    {
                    	    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2644);
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
              _beforeSeqEl("E0DCF6CD92946390E66411DE801FE1868D1505E2");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2656); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92946391E66411DEADECE1868D1505E2");
            }
            match(input,71,FOLLOW_71_in_tcs_operatortemplate2660); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92946392E66411DEB935E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2664); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92946394E66411DEB3ECE1868D1505E2");
            }
            // parser/TCS.g:520:1052: (temp= tcs_propertyreference )
            // parser/TCS.g:520:1054: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2672);
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
              _beforeSeqEl("E0DCF6CD92957500E66411DE8DF4E1868D1505E2");
            }
            // parser/TCS.g:520:1202: ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==COMA) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==58||LA52_1==70||LA52_1==79) ) {
                    alt52=2;
                }
                else if ( (LA52_1==62) ) {
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
                    // parser/TCS.g:520:1203: ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:520:1219: ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) )
                    // parser/TCS.g:520:1220: COMA 'storeOpTo' EQ (temp= tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92948AA1E66411DE9F63E1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2685); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92948AA2E66411DE831EE1868D1505E2");
                    }
                    match(input,62,FOLLOW_62_in_tcs_operatortemplate2689); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9294B1B0E66411DE80D8E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2693); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9294B1B2E66411DECC70E1868D1505E2");
                    }
                    // parser/TCS.g:520:1525: (temp= tcs_propertyreference )
                    // parser/TCS.g:520:1527: temp= tcs_propertyreference
                    {
                    pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2701);
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
                    // parser/TCS.g:520:1633: 
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
              _beforeSeqEl("E0DCF6CD92961140E66411DEB478E1868D1505E2");
            }
            // parser/TCS.g:521:77: ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==COMA) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==58||LA53_1==79) ) {
                    alt53=2;
                }
                else if ( (LA53_1==70) ) {
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
                    // parser/TCS.g:521:78: ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:521:94: ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) )
                    // parser/TCS.g:521:95: COMA 'storeRightTo' EQ (temp= tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9295C321E66411DEC22BE1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2727); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9295C322E66411DE9C3AE1868D1505E2");
                    }
                    match(input,70,FOLLOW_70_in_tcs_operatortemplate2731); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9295C323E66411DEC005E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2735); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9295C325E66411DECCCAE1868D1505E2");
                    }
                    // parser/TCS.g:521:403: (temp= tcs_propertyreference )
                    // parser/TCS.g:521:405: temp= tcs_propertyreference
                    {
                    pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2743);
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
                    // parser/TCS.g:521:512: 
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
              _beforeSeqEl("E0DCF6CD92968670E66411DEA9C2E1868D1505E2");
            }
            // parser/TCS.g:522:77: ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==COMA) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==79) ) {
                    alt54=2;
                }
                else if ( (LA54_1==58) ) {
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
                    // parser/TCS.g:522:78: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:522:94: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:522:95: COMA 'disambiguate' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92963851E66411DE8F4DE1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2769); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92963852E66411DE8A14E1868D1505E2");
                    }
                    match(input,58,FOLLOW_58_in_tcs_operatortemplate2773); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92963853E66411DEC6B2E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2777); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92965F62E66411DEB598E1868D1505E2");
                    }
                    // parser/TCS.g:522:403: (temp= stringSymbol )
                    // parser/TCS.g:522:405: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate2785);
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
                    // parser/TCS.g:522:499: 
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
              _beforeSeqEl("E0DCF6CD929722B0E66411DE84DDE1868D1505E2");
            }
            // parser/TCS.g:523:77: ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | )
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
                    // parser/TCS.g:523:78: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:523:94: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:523:95: COMA 'disambiguateV3' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9296D491E66411DECD5EE1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2811); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9296D492E66411DEC22FE1868D1505E2");
                    }
                    match(input,79,FOLLOW_79_in_tcs_operatortemplate2815); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9296D493E66411DE8F16E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2819); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9296FBA0E66411DE8E8DE1868D1505E2");
                    }
                    // parser/TCS.g:523:405: (temp= stringSymbol )
                    // parser/TCS.g:523:407: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate2827);
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
                    // parser/TCS.g:523:503: 
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
              _beforeSeqEl("E0DCF6CD929749C0E66411DEB721E1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_operatortemplate2847); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92983420E66411DECDCEE1868D1505E2");
            }
            // parser/TCS.g:524:160: ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==97) ) {
                alt58=1;
            }
            else if ( (LA58_0==SEMI||LA58_0==COLON||LA58_0==78) ) {
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
                    // parser/TCS.g:524:161: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:524:177: ( 'referenceOnly' )
                    // parser/TCS.g:524:178: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD929770D0E66411DEBDE8E1868D1505E2");
                    }
                    match(input,97,FOLLOW_97_in_tcs_operatortemplate2857); if (state.failed) return ret2;
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
                    // parser/TCS.g:524:348: ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:524:364: ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) )
                    // parser/TCS.g:524:365: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92980D10E66411DEB92CE1868D1505E2");
                    }
                    // parser/TCS.g:524:425: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==78) ) {
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
                            // parser/TCS.g:524:426: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:524:442: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            // parser/TCS.g:524:443: 'context' ( ( (temp= tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD929797E1E66411DEBFCDE1868D1505E2");
                            }
                            match(input,78,FOLLOW_78_in_tcs_operatortemplate2876); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD9297E600E66411DE84E6E1868D1505E2");
                            }
                            // parser/TCS.g:524:587: ( ( (temp= tcs_contexttags ) ) | )
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
                                    // parser/TCS.g:524:588: ( (temp= tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:524:604: ( (temp= tcs_contexttags ) )
                                    // parser/TCS.g:524:605: (temp= tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD9297BEF2E66411DEA3E6E1868D1505E2");
                                    }
                                    // parser/TCS.g:524:664: (temp= tcs_contexttags )
                                    // parser/TCS.g:524:666: temp= tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_tcs_contexttags_in_tcs_operatortemplate2889);
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
                                    // parser/TCS.g:524:762: 
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
                            // parser/TCS.g:525:91: 
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
              _beforeSeqEl("E0DCF6CD9299BAC2E66411DE9EA8E1868D1505E2");
            }
            // parser/TCS.g:527:77: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
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
                    // parser/TCS.g:527:78: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:527:94: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // parser/TCS.g:527:95: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD929993B0E66411DEA3B5E1868D1505E2");
                    }
                    // parser/TCS.g:527:154: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // parser/TCS.g:527:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // parser/TCS.g:527:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // parser/TCS.g:527:156: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92988240E66411DE9422E1868D1505E2");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_operatortemplate2940); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92996CA0E66411DE9B58E1868D1505E2");
                    }
                    // parser/TCS.g:527:297: ( ( (temp= tcs_sequence ) ) )
                    // parser/TCS.g:527:298: ( (temp= tcs_sequence ) )
                    {
                    // parser/TCS.g:527:298: ( (temp= tcs_sequence ) )
                    // parser/TCS.g:527:299: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92988242E66411DEA76EE1868D1505E2");
                    }
                    // parser/TCS.g:527:358: (temp= tcs_sequence )
                    // parser/TCS.g:527:360: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_operatortemplate2951);
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
                      _beforeSeqEl("E0DCF6CD92996CA1E66411DECA2BE1868D1505E2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate2961); if (state.failed) return ret2;
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
                    // parser/TCS.g:527:569: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:527:585: ( SEMI )
                    // parser/TCS.g:527:586: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD9299BAC0E66411DEB2C9E1868D1505E2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate2978); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD9299E1D2E66411DEAF4DE1868D1505E2");
            }
            // parser/TCS.g:528:76: (temp= textblockdefinition_textblockdefinition )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // parser/TCS.g:528:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_operatortemplate2992);
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
    // parser/TCS.g:536:1: tcs_functiontemplate returns [Object ret2] : ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) ;
    public final Object tcs_functiontemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:541:3: ( ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) )
            // parser/TCS.g:542:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            {
            // parser/TCS.g:542:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            // parser/TCS.g:542:4: 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929ACC30E66411DE9967E1868D1505E2");
            }
            match(input,107,FOLLOW_107_in_tcs_functiontemplate3037); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929ACC32E66411DE989EE1868D1505E2");
            }
            // parser/TCS.g:542:148: (temp= identifier )
            // parser/TCS.g:542:150: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functiontemplate3044);
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
              _beforeSeqEl("E0DCF6CD929ACC33E66411DE80B4E1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_functiontemplate3051); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929AF340E66411DE9BF2E1868D1505E2");
            }
            pushFollow(FOLLOW_reference_in_tcs_functiontemplate3055);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929AF341E66411DEA48DE1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_functiontemplate3060); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929B4160E66411DEA4EFE1868D1505E2");
            }
            // parser/TCS.g:542:538: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            // parser/TCS.g:542:539: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            {
            // parser/TCS.g:542:539: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            // parser/TCS.g:542:540: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929AF342E66411DEC270E1868D1505E2");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_functiontemplate3068); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929B1A51E66411DEC928E1868D1505E2");
            }
            // parser/TCS.g:542:681: ( ( (temp= tcs_sequence ) ) )
            // parser/TCS.g:542:682: ( (temp= tcs_sequence ) )
            {
            // parser/TCS.g:542:682: ( (temp= tcs_sequence ) )
            // parser/TCS.g:542:683: (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929AF344E66411DE8ECBE1868D1505E2");
            }
            // parser/TCS.g:542:742: (temp= tcs_sequence )
            // parser/TCS.g:542:744: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_functiontemplate3079);
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
              _beforeSeqEl("E0DCF6CD929B1A52E66411DEBAEAE1868D1505E2");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_functiontemplate3089); if (state.failed) return ret2;
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
    // parser/TCS.g:550:1: tcs_contexttags returns [Object ret2] : ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) ;
    public final Object tcs_contexttags() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ContextTags");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:555:3: ( ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) )
            // parser/TCS.g:556:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            {
            // parser/TCS.g:556:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            // parser/TCS.g:556:4: LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929BB690E66411DEBA1EE1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_contexttags3134); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929BDDA1E66411DE82C6E1868D1505E2");
            }
            // parser/TCS.g:556:146: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==NAME) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // parser/TCS.g:556:148: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_contexttags3142);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tags", temp);
                    }
                    // parser/TCS.g:556:198: ( ( COMA ) temp= identifier )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==COMA) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // parser/TCS.g:556:199: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:556:216: ( COMA )
                    	    // parser/TCS.g:556:217: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD929BB692E66411DE9CE0E1868D1505E2");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_tcs_contexttags3151); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_tcs_contexttags3159);
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
              _beforeSeqEl("E0DCF6CD929C04B0E66411DEC99DE1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_contexttags3171); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:564:1: tcs_sequence__impl returns [Object ret2] : ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequence__impl() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Sequence");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:569:3: ( ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // parser/TCS.g:570:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // parser/TCS.g:570:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // parser/TCS.g:570:4: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD929C52D0E66411DEAD5CE1868D1505E2");
            }
            // parser/TCS.g:570:63: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( ((LA64_0>=NAME && LA64_0<=STRING)||LA64_0==LPAREN||LA64_0==RARROW||LA64_0==LT||LA64_0==LSQUARE||LA64_0==DLSQUARE||(LA64_0>=DOLLAR && LA64_0<=DLCURLY)||LA64_0==ORKEYWORD||(LA64_0>=52 && LA64_0<=135)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // parser/TCS.g:570:65: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3216);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // parser/TCS.g:570:128: (temp= tcs_sequenceelement )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( ((LA63_0>=NAME && LA63_0<=STRING)||LA63_0==LPAREN||LA63_0==RARROW||LA63_0==LT||LA63_0==LSQUARE||LA63_0==DLSQUARE||(LA63_0>=DOLLAR && LA63_0<=DLCURLY)||LA63_0==ORKEYWORD||(LA63_0>=52 && LA63_0<=135)) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // parser/TCS.g:570:130: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3224);
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
    // parser/TCS.g:578:1: tcs_sequence returns [Object ret2] : (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) ) ;
    public final Object tcs_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:579:3: ( (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) ) )
            // parser/TCS.g:580:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )
            {
            // parser/TCS.g:580:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )
            int alt65=2;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // parser/TCS.g:580:4: ret= tcs_sequence__impl
                    {
                    pushFollow(FOLLOW_tcs_sequence__impl_in_tcs_sequence3269);
                    ret=tcs_sequence__impl();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:580:27: (ret= tcs_sequenceinalternative )
                    {
                    // parser/TCS.g:580:27: (ret= tcs_sequenceinalternative )
                    // parser/TCS.g:580:28: ret= tcs_sequenceinalternative
                    {
                    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_sequence3274);
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
    // parser/TCS.g:587:1: tcs_sequenceelement returns [Object ret2] : (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock ) ;
    public final Object tcs_sequenceelement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:588:3: ( (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock ) )
            // parser/TCS.g:589:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock )
            {
            // parser/TCS.g:589:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock )
            int alt66=8;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt66=1;
                }
                break;
            case NAME:
            case RARROW:
            case ORKEYWORD:
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
            case 133:
            case 134:
            case 135:
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
                    // parser/TCS.g:589:4: ret= tcs_literalref
                    {
                    pushFollow(FOLLOW_tcs_literalref_in_tcs_sequenceelement3303);
                    ret=tcs_literalref();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:590:5: ret= tcs_property
                    {
                    pushFollow(FOLLOW_tcs_property_in_tcs_sequenceelement3311);
                    ret=tcs_property();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:591:5: ret= tcs_customseparator
                    {
                    pushFollow(FOLLOW_tcs_customseparator_in_tcs_sequenceelement3319);
                    ret=tcs_customseparator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:592:5: ret= tcs_block
                    {
                    pushFollow(FOLLOW_tcs_block_in_tcs_sequenceelement3327);
                    ret=tcs_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:593:5: ret= tcs_conditionalelement
                    {
                    pushFollow(FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement3335);
                    ret=tcs_conditionalelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:594:5: ret= tcs_alternative
                    {
                    pushFollow(FOLLOW_tcs_alternative_in_tcs_sequenceelement3343);
                    ret=tcs_alternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:595:5: ret= tcs_functioncall
                    {
                    pushFollow(FOLLOW_tcs_functioncall_in_tcs_sequenceelement3351);
                    ret=tcs_functioncall();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:596:5: ret= tcs_injectoractionsblock
                    {
                    pushFollow(FOLLOW_tcs_injectoractionsblock_in_tcs_sequenceelement3359);
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
    // parser/TCS.g:603:1: tcs_literalref returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_literalref() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LiteralRef");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:608:3: ( ( (temp= stringSymbol ) ) )
            // parser/TCS.g:609:3: ( (temp= stringSymbol ) )
            {
            // parser/TCS.g:609:3: ( (temp= stringSymbol ) )
            // parser/TCS.g:609:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92A30990E66411DE8BAFE1868D1505E2");
            }
            // parser/TCS.g:609:63: (temp= stringSymbol )
            // parser/TCS.g:609:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_literalref3393);
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
              _beforeSeqEl("E0DCF6CD92AA83A0E66411DECD92E1868D1505E2");
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
    // parser/TCS.g:617:1: tcs_propertyreference returns [Object ret2] : ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) ) ;
    public final Object tcs_propertyreference() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PropertyReference");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:622:3: ( ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) ) )
            // parser/TCS.g:623:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) )
            {
            // parser/TCS.g:623:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) )
            // parser/TCS.g:623:4: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92AD69D1E66411DEA607E1868D1505E2");
            }
            // parser/TCS.g:623:64: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==NAME||LA68_0==ORKEYWORD||(LA68_0>=52 && LA68_0<=135)) ) {
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
                    // parser/TCS.g:623:65: ( (temp= identifierOrKeyword ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:623:81: ( (temp= identifierOrKeyword ) )
                    // parser/TCS.g:623:82: (temp= identifierOrKeyword )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92ACF4A3E66411DEB9C2E1868D1505E2");
                    }
                    // parser/TCS.g:623:141: (temp= identifierOrKeyword )
                    // parser/TCS.g:623:143: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_propertyreference3449);
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
                    // parser/TCS.g:623:1565: ( RARROW (temp= identifierOrKeyword )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:623:1581: ( RARROW (temp= identifierOrKeyword )? )
                    // parser/TCS.g:623:1582: RARROW (temp= identifierOrKeyword )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92AD42C0E66411DEC3F5E1868D1505E2");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_tcs_propertyreference3465); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92AD42C3E66411DE82BFE1868D1505E2");
                    }
                    // parser/TCS.g:623:1724: (temp= identifierOrKeyword )?
                    int alt67=2;
                    alt67 = dfa67.predict(input);
                    switch (alt67) {
                        case 1 :
                            // parser/TCS.g:623:1726: temp= identifierOrKeyword
                            {
                            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_propertyreference3473);
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
    // parser/TCS.g:632:1: tcs_property returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_property() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Property");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:637:3: ( ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) )
            // parser/TCS.g:638:3: ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            {
            // parser/TCS.g:638:3: ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            // parser/TCS.g:638:4: (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92ADB7F1E66411DE92BCE1868D1505E2");
            }
            // parser/TCS.g:638:63: (temp= tcs_propertyreference )
            // parser/TCS.g:638:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_property3528);
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
              _beforeSeqEl("E0DCF6CD92AEC961E66411DE8403E1868D1505E2");
            }
            // parser/TCS.g:638:215: ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==LCURLY) ) {
                alt71=1;
            }
            else if ( (LA71_0==EOF||(LA71_0>=NAME && LA71_0<=STRING)||LA71_0==LPAREN||LA71_0==RPAREN||(LA71_0>=RCURLY && LA71_0<=COMA)||LA71_0==LT||(LA71_0>=LSQUARE && LA71_0<=RSQUARE)||(LA71_0>=DLSQUARE && LA71_0<=DRSQUARE)||(LA71_0>=DOLLAR && LA71_0<=DLCURLY)||LA71_0==ORKEYWORD||(LA71_0>=52 && LA71_0<=135)) ) {
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
                    // parser/TCS.g:638:216: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:638:232: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    // parser/TCS.g:638:233: LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92AE0610E66411DECDDAE1868D1505E2");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_property3541); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92AE2D20E66411DECC2BE1868D1505E2");
                    }
                    // parser/TCS.g:638:375: (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( ((LA70_0>=58 && LA70_0<=59)||LA70_0==85||LA70_0==90||(LA70_0>=92 && LA70_0<=93)||LA70_0==100||LA70_0==103||LA70_0==106||LA70_0==108||LA70_0==115||(LA70_0>=123 && LA70_0<=124)||LA70_0==130||LA70_0==134) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // parser/TCS.g:638:377: temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )*
                            {
                            pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property3549);
                            temp=tcs_propertyarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "propertyArgs", temp);
                            }
                            // parser/TCS.g:638:440: ( ( COMA ) temp= tcs_propertyarg )*
                            loop69:
                            do {
                                int alt69=2;
                                int LA69_0 = input.LA(1);

                                if ( (LA69_0==COMA) ) {
                                    alt69=1;
                                }


                                switch (alt69) {
                            	case 1 :
                            	    // parser/TCS.g:638:441: ( COMA ) temp= tcs_propertyarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:638:458: ( COMA )
                            	    // parser/TCS.g:638:459: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD92AE0612E66411DEA098E1868D1505E2");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_property3558); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property3566);
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
                      _beforeSeqEl("E0DCF6CD92AEA250E66411DE8854E1868D1505E2");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_property3578); if (state.failed) return ret2;
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
                    // parser/TCS.g:638:743: 
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
              _beforeSeqEl("E0DCF6CD92AF1780E66411DE985AE1868D1505E2");
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
    // parser/TCS.g:647:1: tcs_customseparator returns [Object ret2] : ( LT (temp= identifier ) GT ) ;
    public final Object tcs_customseparator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CustomSeparator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:652:3: ( ( LT (temp= identifier ) GT ) )
            // parser/TCS.g:653:3: ( LT (temp= identifier ) GT )
            {
            // parser/TCS.g:653:3: ( LT (temp= identifier ) GT )
            // parser/TCS.g:653:4: LT (temp= identifier ) GT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92AF65A0E66411DE86E5E1868D1505E2");
            }
            match(input,LT,FOLLOW_LT_in_tcs_customseparator3636); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92AF65A2E66411DEC75DE1868D1505E2");
            }
            // parser/TCS.g:653:142: (temp= identifier )
            // parser/TCS.g:653:144: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_customseparator3644);
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
              _beforeSeqEl("E0DCF6CD92AF65A3E66411DEA9D6E1868D1505E2");
            }
            match(input,GT,FOLLOW_GT_in_tcs_customseparator3651); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92AF8CB1E66411DE95C5E1868D1505E2");
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
    // parser/TCS.g:661:1: tcs_block returns [Object ret2] : ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_block() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:666:3: ( ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) )
            // parser/TCS.g:667:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            {
            // parser/TCS.g:667:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            // parser/TCS.g:667:4: LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92AFDAD0E66411DE9711E1868D1505E2");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_block3696); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B001E0E66411DE9225E1868D1505E2");
            }
            // parser/TCS.g:667:147: (temp= tcs_sequence )
            // parser/TCS.g:667:149: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_block3704);
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
              _beforeSeqEl("E0DCF6CD92B001E1E66411DEA125E1868D1505E2");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_block3711); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B09E20E66411DE9E1BE1868D1505E2");
            }
            // parser/TCS.g:667:370: ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==LCURLY) ) {
                alt74=1;
            }
            else if ( (LA74_0==EOF||(LA74_0>=NAME && LA74_0<=STRING)||LA74_0==LPAREN||LA74_0==RPAREN||(LA74_0>=RCURLY && LA74_0<=COMA)||LA74_0==LT||(LA74_0>=LSQUARE && LA74_0<=RSQUARE)||(LA74_0>=DLSQUARE && LA74_0<=DRSQUARE)||(LA74_0>=DOLLAR && LA74_0<=DLCURLY)||LA74_0==ORKEYWORD||(LA74_0>=52 && LA74_0<=135)) ) {
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
                    // parser/TCS.g:667:371: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:667:387: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    // parser/TCS.g:667:388: LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B028F0E66411DE846CE1868D1505E2");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_block3722); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B05001E66411DEABB0E1868D1505E2");
                    }
                    // parser/TCS.g:667:530: (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==57||LA73_0==69||LA73_0==88||LA73_0==112||LA73_0==129) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // parser/TCS.g:667:532: temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )*
                            {
                            pushFollow(FOLLOW_tcs_blockarg_in_tcs_block3730);
                            temp=tcs_blockarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "blockArgs", temp);
                            }
                            // parser/TCS.g:667:589: ( ( COMA ) temp= tcs_blockarg )*
                            loop72:
                            do {
                                int alt72=2;
                                int LA72_0 = input.LA(1);

                                if ( (LA72_0==COMA) ) {
                                    alt72=1;
                                }


                                switch (alt72) {
                            	case 1 :
                            	    // parser/TCS.g:667:590: ( COMA ) temp= tcs_blockarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:667:607: ( COMA )
                            	    // parser/TCS.g:667:608: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD92B028F2E66411DE9280E1868D1505E2");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_block3739); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_blockarg_in_tcs_block3747);
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
                      _beforeSeqEl("E0DCF6CD92B07710E66411DEBD30E1868D1505E2");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_block3759); if (state.failed) return ret2;
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
                    // parser/TCS.g:667:886: 
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
              _beforeSeqEl("E0DCF6CD92B11350E66411DE9002E1868D1505E2");
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
    // parser/TCS.g:676:1: tcs_conditionalelement returns [Object ret2] : ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) ;
    public final Object tcs_conditionalelement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConditionalElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:681:3: ( ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) )
            // parser/TCS.g:682:3: ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            {
            // parser/TCS.g:682:3: ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            // parser/TCS.g:682:4: LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B18880E66411DE8C26E1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_conditionalelement3817); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B18882E66411DE9F86E1868D1505E2");
            }
            // parser/TCS.g:682:146: (temp= tcs_expression )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==NAME||LA75_0==RARROW||LA75_0==ORKEYWORD||(LA75_0>=52 && LA75_0<=135)) ) {
                alt75=1;
            }
            else if ( (LA75_0==QMARK) ) {
                int LA75_2 = input.LA(2);

                if ( (synpred167_TCS()) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // parser/TCS.g:682:148: temp= tcs_expression
                    {
                    pushFollow(FOLLOW_tcs_expression_in_tcs_conditionalelement3825);
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
              _beforeSeqEl("E0DCF6CD92B18883E66411DE8C03E1868D1505E2");
            }
            match(input,QMARK,FOLLOW_QMARK_in_tcs_conditionalelement3834); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B18885E66411DEBE6FE1868D1505E2");
            }
            // parser/TCS.g:682:366: (temp= tcs_sequence )
            // parser/TCS.g:682:368: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement3842);
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
              _beforeSeqEl("E0DCF6CD92B1FDB0E66411DEB4D1E1868D1505E2");
            }
            // parser/TCS.g:682:504: ( ( COLON (temp= tcs_sequence ) ) | )
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
                    // parser/TCS.g:682:505: ( COLON (temp= tcs_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:682:521: ( COLON (temp= tcs_sequence ) )
                    // parser/TCS.g:682:522: COLON (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B1AF93E66411DEB99DE1868D1505E2");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_conditionalelement3855); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B1D6A1E66411DEA156E1868D1505E2");
                    }
                    // parser/TCS.g:682:663: (temp= tcs_sequence )
                    // parser/TCS.g:682:665: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement3863);
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
                    // parser/TCS.g:682:759: 
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
              _beforeSeqEl("E0DCF6CD92B1FDB1E66411DECE9FE1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_conditionalelement3883); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B224C0E66411DE81DAE1868D1505E2");
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
    // parser/TCS.g:691:1: tcs_alternative returns [Object ret2] : ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) ) ;
    public final Object tcs_alternative() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Alternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:696:3: ( ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) ) )
            // parser/TCS.g:697:3: ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) )
            {
            // parser/TCS.g:697:3: ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) )
            // parser/TCS.g:697:4: DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B2C100E66411DEA351E1868D1505E2");
            }
            match(input,DLSQUARE,FOLLOW_DLSQUARE_in_tcs_alternative3928); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B2E813E66411DEC6BCE1868D1505E2");
            }
            // parser/TCS.g:697:148: (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( ((LA78_0>=NAME && LA78_0<=STRING)||LA78_0==LPAREN||LA78_0==RARROW||LA78_0==LT||LA78_0==LSQUARE||(LA78_0>=DLSQUARE && LA78_0<=PIPE)||(LA78_0>=DOLLAR && LA78_0<=DLCURLY)||LA78_0==ORKEYWORD||(LA78_0>=52 && LA78_0<=135)) ) {
                alt78=1;
            }
            else if ( (LA78_0==DRSQUARE) ) {
                int LA78_2 = input.LA(2);

                if ( (synpred170_TCS()) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // parser/TCS.g:697:150: temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_alternative3936);
                    temp=tcs_sequenceinalternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sequences", temp);
                    }
                    // parser/TCS.g:697:220: ( ( PIPE ) temp= tcs_sequenceinalternative )*
                    loop77:
                    do {
                        int alt77=2;
                        int LA77_0 = input.LA(1);

                        if ( (LA77_0==PIPE) ) {
                            alt77=1;
                        }


                        switch (alt77) {
                    	case 1 :
                    	    // parser/TCS.g:697:221: ( PIPE ) temp= tcs_sequenceinalternative
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:697:238: ( PIPE )
                    	    // parser/TCS.g:697:239: PIPE
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD92B2E810E66411DEAC24E1868D1505E2");
                    	    }
                    	    match(input,PIPE,FOLLOW_PIPE_in_tcs_alternative3945); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_alternative3953);
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
              _beforeSeqEl("E0DCF6CD92B30F20E66411DE984AE1868D1505E2");
            }
            match(input,DRSQUARE,FOLLOW_DRSQUARE_in_tcs_alternative3965); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B33633E66411DE9DDAE1868D1505E2");
            }
            // parser/TCS.g:697:574: ( ( STAR ) | )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==STAR) ) {
                alt79=1;
            }
            else if ( (LA79_0==EOF||(LA79_0>=NAME && LA79_0<=STRING)||LA79_0==LPAREN||LA79_0==RPAREN||(LA79_0>=RCURLY && LA79_0<=COMA)||LA79_0==LT||(LA79_0>=LSQUARE && LA79_0<=RSQUARE)||(LA79_0>=DLSQUARE && LA79_0<=DRSQUARE)||(LA79_0>=DOLLAR && LA79_0<=DLCURLY)||LA79_0==ORKEYWORD||(LA79_0>=52 && LA79_0<=135)) ) {
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
                    // parser/TCS.g:697:575: ( STAR )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:697:591: ( STAR )
                    // parser/TCS.g:697:592: STAR
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B33631E66411DE86C2E1868D1505E2");
                    }
                    match(input,STAR,FOLLOW_STAR_in_tcs_alternative3976); if (state.failed) return ret2;
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
                    // parser/TCS.g:697:745: 
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
              _beforeSeqEl("E0DCF6CD92B35D42E66411DEB791E1868D1505E2");
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
    // parser/TCS.g:706:1: tcs_sequenceinalternative returns [Object ret2] : ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequenceinalternative() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SequenceInAlternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:711:3: ( ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // parser/TCS.g:712:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // parser/TCS.g:712:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // parser/TCS.g:712:4: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B42090E66411DE9298E1868D1505E2");
            }
            // parser/TCS.g:712:64: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==58) ) {
                int LA80_1 = input.LA(2);

                if ( (LA80_1==EOF||(LA80_1>=NAME && LA80_1<=STRING)||(LA80_1>=RPAREN && LA80_1<=COMA)||LA80_1==LT||(LA80_1>=LSQUARE && LA80_1<=RSQUARE)||(LA80_1>=DLSQUARE && LA80_1<=DRSQUARE)||(LA80_1>=DOLLAR && LA80_1<=DLCURLY)||LA80_1==ORKEYWORD||(LA80_1>=52 && LA80_1<=135)) ) {
                    alt80=2;
                }
                else if ( (LA80_1==LPAREN) ) {
                    int LA80_3 = input.LA(3);

                    if ( (LA80_3==STRING) ) {
                        alt80=1;
                    }
                    else if ( (LA80_3==NAME||LA80_3==RARROW||LA80_3==QMARK||LA80_3==ORKEYWORD||(LA80_3>=52 && LA80_3<=135)) ) {
                        alt80=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 80, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA80_0==EOF||(LA80_0>=NAME && LA80_0<=STRING)||LA80_0==LPAREN||LA80_0==RPAREN||(LA80_0>=RCURLY && LA80_0<=COMA)||LA80_0==LT||(LA80_0>=LSQUARE && LA80_0<=RSQUARE)||(LA80_0>=DLSQUARE && LA80_0<=DRSQUARE)||(LA80_0>=DOLLAR && LA80_0<=DLCURLY)||LA80_0==ORKEYWORD||(LA80_0>=52 && LA80_0<=57)||(LA80_0>=59 && LA80_0<=135)) ) {
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
                    // parser/TCS.g:712:65: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:712:81: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    // parser/TCS.g:712:82: 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B3D271E66411DE8C34E1868D1505E2");
                    }
                    match(input,58,FOLLOW_58_in_tcs_sequenceinalternative4041); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B3D272E66411DEB311E1868D1505E2");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_sequenceinalternative4045); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B3D275E66411DEAF3DE1868D1505E2");
                    }
                    // parser/TCS.g:712:313: (temp= stringSymbol )
                    // parser/TCS.g:712:315: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_sequenceinalternative4053);
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
                      _beforeSeqEl("E0DCF6CD92B3F980E66411DE822CE1868D1505E2");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_sequenceinalternative4060); if (state.failed) return ret2;
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
                    // parser/TCS.g:712:492: 
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
              _beforeSeqEl("E0DCF6CD92B42092E66411DEC2C5E1868D1505E2");
            }
            // parser/TCS.g:713:76: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=NAME && LA82_0<=STRING)||LA82_0==LPAREN||LA82_0==RARROW||LA82_0==LT||LA82_0==LSQUARE||LA82_0==DLSQUARE||(LA82_0>=DOLLAR && LA82_0<=DLCURLY)||LA82_0==ORKEYWORD||(LA82_0>=52 && LA82_0<=135)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // parser/TCS.g:713:78: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4081);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // parser/TCS.g:713:141: (temp= tcs_sequenceelement )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( ((LA81_0>=NAME && LA81_0<=STRING)||LA81_0==LPAREN||LA81_0==RARROW||LA81_0==LT||LA81_0==LSQUARE||LA81_0==DLSQUARE||(LA81_0>=DOLLAR && LA81_0<=DLCURLY)||LA81_0==ORKEYWORD||(LA81_0>=52 && LA81_0<=135)) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // parser/TCS.g:713:143: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4089);
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
    // parser/TCS.g:721:1: tcs_functioncall returns [Object ret2] : ( DOLLAR (temp= identifier ) ) ;
    public final Object tcs_functioncall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:726:3: ( ( DOLLAR (temp= identifier ) ) )
            // parser/TCS.g:727:3: ( DOLLAR (temp= identifier ) )
            {
            // parser/TCS.g:727:3: ( DOLLAR (temp= identifier ) )
            // parser/TCS.g:727:4: DOLLAR (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B46EB0E66411DEB2D8E1868D1505E2");
            }
            match(input,DOLLAR,FOLLOW_DOLLAR_in_tcs_functioncall4138); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B46EB3E66411DE89DDE1868D1505E2");
            }
            // parser/TCS.g:727:146: (temp= identifier )
            // parser/TCS.g:727:148: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functioncall4146);
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
              _beforeSeqEl("E0DCF6CD92B495C2E66411DEC16AE1868D1505E2");
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
    // parser/TCS.g:735:1: tcs_injectoractionsblock returns [Object ret2] : ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY ) ;
    public final Object tcs_injectoractionsblock() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","InjectorActionsBlock");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:740:3: ( ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY ) )
            // parser/TCS.g:741:3: ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY )
            {
            // parser/TCS.g:741:3: ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY )
            // parser/TCS.g:741:4: DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B4E3E0E66411DE9FE6E1868D1505E2");
            }
            match(input,DLCURLY,FOLLOW_DLCURLY_in_tcs_injectoractionsblock4193); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B50AF1E66411DEB58CE1868D1505E2");
            }
            // parser/TCS.g:741:147: (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==NAME||LA84_0==RARROW||LA84_0==ORKEYWORD||(LA84_0>=52 && LA84_0<=135)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // parser/TCS.g:741:149: temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )*
                    {
                    pushFollow(FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4201);
                    temp=tcs_injectoraction();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "injectorActions", temp);
                    }
                    // parser/TCS.g:741:218: ( ( COMA ) temp= tcs_injectoraction )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==COMA) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // parser/TCS.g:741:219: ( COMA ) temp= tcs_injectoraction
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:741:236: ( COMA )
                    	    // parser/TCS.g:741:237: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD92B4E3E2E66411DE8CF6E1868D1505E2");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_tcs_injectoractionsblock4210); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4218);
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
              _beforeSeqEl("E0DCF6CD92B53200E66411DEB1A6E1868D1505E2");
            }
            match(input,DRCURLY,FOLLOW_DRCURLY_in_tcs_injectoractionsblock4230); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B53203E66411DEA266E1868D1505E2");
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
    // parser/TCS.g:749:1: tcs_injectoraction returns [Object ret2] : (ret= tcs_propertyinit ) ;
    public final Object tcs_injectoraction() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:750:3: ( (ret= tcs_propertyinit ) )
            // parser/TCS.g:751:3: (ret= tcs_propertyinit )
            {
            // parser/TCS.g:751:3: (ret= tcs_propertyinit )
            // parser/TCS.g:751:4: ret= tcs_propertyinit
            {
            pushFollow(FOLLOW_tcs_propertyinit_in_tcs_injectoraction4271);
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
    // parser/TCS.g:758:1: tcs_propertyinit returns [Object ret2] : (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit ) ;
    public final Object tcs_propertyinit() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:759:3: ( (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit ) )
            // parser/TCS.g:760:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )
            {
            // parser/TCS.g:760:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )
            int alt85=3;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // parser/TCS.g:760:4: ret= tcs_primitivepropertyinit
                    {
                    pushFollow(FOLLOW_tcs_primitivepropertyinit_in_tcs_propertyinit4298);
                    ret=tcs_primitivepropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:761:5: ret= tcs_lookuppropertyinit
                    {
                    pushFollow(FOLLOW_tcs_lookuppropertyinit_in_tcs_propertyinit4306);
                    ret=tcs_lookuppropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:762:5: ret= tcs_foreachpredicatepropertyinit
                    {
                    pushFollow(FOLLOW_tcs_foreachpredicatepropertyinit_in_tcs_propertyinit4314);
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
    // parser/TCS.g:769:1: tcs_primitivepropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) ) ;
    public final Object tcs_primitivepropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitivePropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:774:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) ) )
            // parser/TCS.g:775:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) )
            {
            // parser/TCS.g:775:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) )
            // parser/TCS.g:775:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B5F551E66411DEBE8BE1868D1505E2");
            }
            // parser/TCS.g:775:63: (temp= tcs_propertyreference )
            // parser/TCS.g:775:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_primitivepropertyinit4348);
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
              _beforeSeqEl("E0DCF6CD92B64373E66411DECEC1E1868D1505E2");
            }
            // parser/TCS.g:775:215: ( ( LARROW ) | ( EQ ) )
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
                    // parser/TCS.g:775:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:775:232: ( LARROW )
                    // parser/TCS.g:775:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B61C62E66411DE8326E1868D1505E2");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_primitivepropertyinit4361); if (state.failed) return ret2;
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
                    // parser/TCS.g:775:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:775:406: ( EQ )
                    // parser/TCS.g:775:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B64371E66411DE980FE1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivepropertyinit4376); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD92B66A81E66411DE8EAFE1868D1505E2");
            }
            // parser/TCS.g:776:76: (temp= identifier )
            // parser/TCS.g:776:78: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivepropertyinit4391);
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
    // parser/TCS.g:784:1: tcs_lookuppropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN ) ;
    public final Object tcs_lookuppropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookupPropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:789:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN ) )
            // parser/TCS.g:790:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN )
            {
            // parser/TCS.g:790:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN )
            // parser/TCS.g:790:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B6B8A1E66411DEAE7FE1868D1505E2");
            }
            // parser/TCS.g:790:63: (temp= tcs_propertyreference )
            // parser/TCS.g:790:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_lookuppropertyinit4438);
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
              _beforeSeqEl("E0DCF6CD92B706C2E66411DE91DDE1868D1505E2");
            }
            // parser/TCS.g:790:215: ( ( LARROW ) | ( EQ ) )
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
                    // parser/TCS.g:790:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:790:232: ( LARROW )
                    // parser/TCS.g:790:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B6DFB2E66411DEC305E1868D1505E2");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_lookuppropertyinit4451); if (state.failed) return ret2;
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
                    // parser/TCS.g:790:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:790:406: ( EQ )
                    // parser/TCS.g:790:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B706C0E66411DEA405E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_lookuppropertyinit4466); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD92B72DD0E66411DE9B05E1868D1505E2");
            }
            match(input,103,FOLLOW_103_in_tcs_lookuppropertyinit4477); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B72DD1E66411DEAA43E1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_lookuppropertyinit4481); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B72DD4E66411DE8A88E1868D1505E2");
            }
            // parser/TCS.g:791:242: (temp= stringSymbol )
            // parser/TCS.g:791:244: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_lookuppropertyinit4489);
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
              _beforeSeqEl("E0DCF6CD92B754E0E66411DECAE9E1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_lookuppropertyinit4496); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:799:1: tcs_foreachpredicatepropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN ) ;
    public final Object tcs_foreachpredicatepropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForeachPredicatePropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:804:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN ) )
            // parser/TCS.g:805:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN )
            {
            // parser/TCS.g:805:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN )
            // parser/TCS.g:805:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B7A301E66411DEC0ECE1868D1505E2");
            }
            // parser/TCS.g:805:63: (temp= tcs_propertyreference )
            // parser/TCS.g:805:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_foreachpredicatepropertyinit4541);
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
              _beforeSeqEl("E0DCF6CD92B7F122E66411DEC661E1868D1505E2");
            }
            // parser/TCS.g:805:215: ( ( LARROW ) | ( EQ ) )
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
                    // parser/TCS.g:805:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:805:232: ( LARROW )
                    // parser/TCS.g:805:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B7CA12E66411DE8FD6E1868D1505E2");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_foreachpredicatepropertyinit4554); if (state.failed) return ret2;
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
                    // parser/TCS.g:805:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:805:406: ( EQ )
                    // parser/TCS.g:805:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B7F120E66411DEB96BE1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4569); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD92B81830E66411DE86B5E1868D1505E2");
            }
            match(input,72,FOLLOW_72_in_tcs_foreachpredicatepropertyinit4580); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B81831E66411DEB4D1E1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_foreachpredicatepropertyinit4584); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92B81834E66411DEC8E1E1868D1505E2");
            }
            // parser/TCS.g:806:243: (temp= stringSymbol )
            // parser/TCS.g:806:245: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4592);
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
              _beforeSeqEl("E0DCF6CD92B929A0E66411DE8A86E1868D1505E2");
            }
            // parser/TCS.g:806:374: ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==COMA) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==RPAREN||LA89_1==85||LA89_1==111) ) {
                    alt89=2;
                }
                else if ( (LA89_1==115) ) {
                    int LA89_3 = input.LA(3);

                    if ( (LA89_3==EQ) ) {
                        int LA89_4 = input.LA(4);

                        if ( (LA89_4==STRING) ) {
                            int LA89_5 = input.LA(5);

                            if ( (LA89_5==COMA) ) {
                                int LA89_6 = input.LA(6);

                                if ( (synpred182_TCS()) ) {
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
                    // parser/TCS.g:806:375: ( COMA 'mode' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:806:391: ( COMA 'mode' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:806:392: COMA 'mode' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B83F43E66411DE93EAE1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4605); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B83F44E66411DEB028E1868D1505E2");
                    }
                    match(input,115,FOLLOW_115_in_tcs_foreachpredicatepropertyinit4609); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B8DB80E66411DEC3F4E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4613); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B90291E66411DEB233E1868D1505E2");
                    }
                    // parser/TCS.g:806:692: (temp= stringSymbol )
                    // parser/TCS.g:806:694: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4621);
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
                    // parser/TCS.g:806:780: 
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
              _beforeSeqEl("E0DCF6CD92B99ED1E66411DEBC1FE1868D1505E2");
            }
            // parser/TCS.g:807:77: ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | )
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
                    // parser/TCS.g:807:78: ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:807:94: ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? )
                    // parser/TCS.g:807:95: COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B950B2E66411DEC596E1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4647); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92B977C2E66411DE8649E1868D1505E2");
                    }
                    // parser/TCS.g:807:235: (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==85||LA91_0==111||LA91_0==115) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // parser/TCS.g:807:237: temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )*
                            {
                            pushFollow(FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4655);
                            temp=tcs_predicatesemantic();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "predicatesemantic", temp);
                            }
                            // parser/TCS.g:807:311: ( ( COMA ) temp= tcs_predicatesemantic )*
                            loop90:
                            do {
                                int alt90=2;
                                int LA90_0 = input.LA(1);

                                if ( (LA90_0==COMA) ) {
                                    alt90=1;
                                }


                                switch (alt90) {
                            	case 1 :
                            	    // parser/TCS.g:807:312: ( COMA ) temp= tcs_predicatesemantic
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:807:329: ( COMA )
                            	    // parser/TCS.g:807:330: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD92B950B4E66411DE8295E1868D1505E2");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4664); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4672);
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
                    // parser/TCS.g:807:542: 
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
              _beforeSeqEl("E0DCF6CD92B9C5E0E66411DEA176E1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_foreachpredicatepropertyinit4697); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:816:1: tcs_predicatesemantic returns [Object ret2] : ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ ( ( (temp= qualifiedNameSymbol )? ) | ( (temp= identifierOrKeyword )? ) ) ) ;
    public final Object tcs_predicatesemantic() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PredicateSemantic");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:821:3: ( ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ ( ( (temp= qualifiedNameSymbol )? ) | ( (temp= identifierOrKeyword )? ) ) ) )
            // parser/TCS.g:822:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ ( ( (temp= qualifiedNameSymbol )? ) | ( (temp= identifierOrKeyword )? ) ) )
            {
            // parser/TCS.g:822:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ ( ( (temp= qualifiedNameSymbol )? ) | ( (temp= identifierOrKeyword )? ) ) )
            // parser/TCS.g:822:4: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ ( ( (temp= qualifiedNameSymbol )? ) | ( (temp= identifierOrKeyword )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92BA8930E66411DE8827E1868D1505E2");
            }
            // parser/TCS.g:822:64: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==111) ) {
                alt93=1;
            }
            else if ( (LA93_0==85||LA93_0==115) ) {
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
                    // parser/TCS.g:822:65: ( 'when' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:822:81: ( 'when' EQ (temp= stringSymbol ) COMA )
                    // parser/TCS.g:822:82: 'when' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92BA3B11E66411DE8F80E1868D1505E2");
                    }
                    match(input,111,FOLLOW_111_in_tcs_predicatesemantic4744); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92BA3B12E66411DE8FCFE1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic4748); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92BA6220E66411DECEB5E1868D1505E2");
                    }
                    // parser/TCS.g:822:301: (temp= stringSymbol )
                    // parser/TCS.g:822:303: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_predicatesemantic4756);
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
                      _beforeSeqEl("E0DCF6CD92BA6221E66411DE9725E1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_predicatesemantic4763); if (state.failed) return ret2;
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
                    // parser/TCS.g:822:470: 
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
              _beforeSeqEl("E0DCF6CD92BAFE60E66411DEA78BE1868D1505E2");
            }
            // parser/TCS.g:823:77: ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==115) ) {
                alt94=1;
            }
            else if ( (LA94_0==85) ) {
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
                    // parser/TCS.g:823:78: ( 'mode' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:823:94: ( 'mode' EQ (temp= stringSymbol ) COMA )
                    // parser/TCS.g:823:95: 'mode' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92BAB042E66411DEA694E1868D1505E2");
                    }
                    match(input,115,FOLLOW_115_in_tcs_predicatesemantic4786); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92BAB043E66411DEC08CE1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic4790); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92BAD750E66411DE8B69E1868D1505E2");
                    }
                    // parser/TCS.g:823:314: (temp= stringSymbol )
                    // parser/TCS.g:823:316: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_predicatesemantic4798);
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
                      _beforeSeqEl("E0DCF6CD92BAD751E66411DEB867E1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_predicatesemantic4805); if (state.failed) return ret2;
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
                    // parser/TCS.g:823:483: 
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
              _beforeSeqEl("E0DCF6CD92BAFE61E66411DEC97AE1868D1505E2");
            }
            match(input,85,FOLLOW_85_in_tcs_predicatesemantic4822); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92BAFE62E66411DE83B7E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic4826); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92C7A890E66411DE8188E1868D1505E2");
            }
            // parser/TCS.g:824:234: ( ( (temp= qualifiedNameSymbol )? ) | ( (temp= identifierOrKeyword )? ) )
            int alt97=2;
            switch ( input.LA(1) ) {
            case QNAME:
                {
                alt97=1;
                }
                break;
            case COMA:
                {
                int LA97_2 = input.LA(2);

                if ( (synpred189_TCS()) ) {
                    alt97=1;
                }
                else if ( (true) ) {
                    alt97=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 2, input);

                    throw nvae;
                }
                }
                break;
            case RPAREN:
                {
                int LA97_3 = input.LA(2);

                if ( (synpred189_TCS()) ) {
                    alt97=1;
                }
                else if ( (true) ) {
                    alt97=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 3, input);

                    throw nvae;
                }
                }
                break;
            case EOF:
                {
                int LA97_4 = input.LA(2);

                if ( (synpred189_TCS()) ) {
                    alt97=1;
                }
                else if ( (true) ) {
                    alt97=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 97, 4, input);

                    throw nvae;
                }
                }
                break;
            case NAME:
            case ORKEYWORD:
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
            case 133:
            case 134:
            case 135:
                {
                alt97=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // parser/TCS.g:824:235: ( (temp= qualifiedNameSymbol )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:824:251: ( (temp= qualifiedNameSymbol )? )
                    // parser/TCS.g:824:252: (temp= qualifiedNameSymbol )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92BB2574E66411DEB81DE1868D1505E2");
                    }
                    // parser/TCS.g:824:311: (temp= qualifiedNameSymbol )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==QNAME) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // parser/TCS.g:824:313: temp= qualifiedNameSymbol
                            {
                            pushFollow(FOLLOW_qualifiedNameSymbol_in_tcs_predicatesemantic4839);
                            temp=qualifiedNameSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"				let e=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  					i; acc:Tuple(pos:Integer, ns:Set(Model::Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"            			  e.ns.contents->select(c | c.name=?.subString(e.pos, ?.size()))->asSequence()->at(1) ="+"										t.oclAsType(TCS::ClassTemplate).metaReference"+"										and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"											->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"											->includes(self.foreachParent.propertyReference.strucfeature.type)"+"										and ("+"											if(not self.mode.oclIsUndefined()) then"+"												t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"											endif"+"										)									"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"										else"+"											false"+"										endif"+"									endif)"+"								");
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
                    // parser/TCS.g:825:4: ( (temp= identifierOrKeyword )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:825:20: ( (temp= identifierOrKeyword )? )
                    // parser/TCS.g:825:21: (temp= identifierOrKeyword )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92BB7391E66411DE8C71E1868D1505E2");
                    }
                    // parser/TCS.g:825:80: (temp= identifierOrKeyword )?
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==NAME||LA96_0==ORKEYWORD||(LA96_0>=52 && LA96_0<=135)) ) {
                        alt96=1;
                    }
                    switch (alt96) {
                        case 1 :
                            // parser/TCS.g:825:82: temp= identifierOrKeyword
                            {
                            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_predicatesemantic4861);
                            temp=identifierOrKeyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");
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
    // $ANTLR end "tcs_predicatesemantic"


    // $ANTLR start "tcs_propertyarg"
    // parser/TCS.g:833:1: tcs_propertyarg returns [Object ret2] : (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg ) ;
    public final Object tcs_propertyarg() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:834:3: ( (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg ) )
            // parser/TCS.g:835:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg )
            {
            // parser/TCS.g:835:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg )
            int alt98=15;
            switch ( input.LA(1) ) {
            case 124:
                {
                alt98=1;
                }
                break;
            case 103:
                {
                alt98=2;
                }
                break;
            case 59:
                {
                alt98=3;
                }
                break;
            case 85:
                {
                alt98=4;
                }
                break;
            case 100:
                {
                alt98=5;
                }
                break;
            case 58:
                {
                alt98=6;
                }
                break;
            case 130:
                {
                alt98=7;
                }
                break;
            case 93:
                {
                alt98=8;
                }
                break;
            case 123:
                {
                alt98=9;
                }
                break;
            case 134:
                {
                alt98=10;
                }
                break;
            case 108:
                {
                alt98=11;
                }
                break;
            case 92:
                {
                alt98=12;
                }
                break;
            case 90:
                {
                alt98=13;
                }
                break;
            case 106:
                {
                alt98=14;
                }
                break;
            case 115:
                {
                alt98=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }

            switch (alt98) {
                case 1 :
                    // parser/TCS.g:835:4: ret= tcs_referstoparg
                    {
                    pushFollow(FOLLOW_tcs_referstoparg_in_tcs_propertyarg4908);
                    ret=tcs_referstoparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:836:5: ret= tcs_lookinparg
                    {
                    pushFollow(FOLLOW_tcs_lookinparg_in_tcs_propertyarg4916);
                    ret=tcs_lookinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:837:5: ret= tcs_createinparg
                    {
                    pushFollow(FOLLOW_tcs_createinparg_in_tcs_propertyarg4924);
                    ret=tcs_createinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:838:5: ret= tcs_asparg
                    {
                    pushFollow(FOLLOW_tcs_asparg_in_tcs_propertyarg4932);
                    ret=tcs_asparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:839:5: ret= tcs_separatorparg
                    {
                    pushFollow(FOLLOW_tcs_separatorparg_in_tcs_propertyarg4940);
                    ret=tcs_separatorparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:840:5: ret= tcs_disambiguateparg
                    {
                    pushFollow(FOLLOW_tcs_disambiguateparg_in_tcs_propertyarg4948);
                    ret=tcs_disambiguateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:841:5: ret= tcs_autocreateparg
                    {
                    pushFollow(FOLLOW_tcs_autocreateparg_in_tcs_propertyarg4956);
                    ret=tcs_autocreateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:842:5: ret= tcs_importcontextparg
                    {
                    pushFollow(FOLLOW_tcs_importcontextparg_in_tcs_propertyarg4964);
                    ret=tcs_importcontextparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 9 :
                    // parser/TCS.g:843:5: ret= tcs_partialparg
                    {
                    pushFollow(FOLLOW_tcs_partialparg_in_tcs_propertyarg4972);
                    ret=tcs_partialparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 10 :
                    // parser/TCS.g:844:5: ret= tcs_forcedlowerparg
                    {
                    pushFollow(FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg4980);
                    ret=tcs_forcedlowerparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 11 :
                    // parser/TCS.g:845:5: ret= tcs_forcedupperparg
                    {
                    pushFollow(FOLLOW_tcs_forcedupperparg_in_tcs_propertyarg4988);
                    ret=tcs_forcedupperparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 12 :
                    // parser/TCS.g:846:5: ret= tcs_createasparg
                    {
                    pushFollow(FOLLOW_tcs_createasparg_in_tcs_propertyarg4996);
                    ret=tcs_createasparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 13 :
                    // parser/TCS.g:847:5: ret= tcs_queryparg
                    {
                    pushFollow(FOLLOW_tcs_queryparg_in_tcs_propertyarg5004);
                    ret=tcs_queryparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 14 :
                    // parser/TCS.g:848:5: ret= tcs_filterparg
                    {
                    pushFollow(FOLLOW_tcs_filterparg_in_tcs_propertyarg5012);
                    ret=tcs_filterparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 15 :
                    // parser/TCS.g:849:5: ret= tcs_modeparg
                    {
                    pushFollow(FOLLOW_tcs_modeparg_in_tcs_propertyarg5020);
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
    // parser/TCS.g:856:1: tcs_referstoparg returns [Object ret2] : ( 'refersTo' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_referstoparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RefersToPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:861:3: ( ( 'refersTo' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:862:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:862:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:862:4: 'refersTo' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92C81DC2E66411DECC6EE1868D1505E2");
            }
            match(input,124,FOLLOW_124_in_tcs_referstoparg5050); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92C81DC3E66411DEC3F1E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_referstoparg5054); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92C844D2E66411DEA7C4E1868D1505E2");
            }
            // parser/TCS.g:862:227: (temp= identifierOrKeyword )
            // parser/TCS.g:862:229: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_referstoparg5062);
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
    // parser/TCS.g:870:1: tcs_lookinparg returns [Object ret2] : ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) ;
    public final Object tcs_lookinparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:875:3: ( ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) )
            // parser/TCS.g:876:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            {
            // parser/TCS.g:876:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            // parser/TCS.g:876:4: 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92C892F0E66411DE9D28E1868D1505E2");
            }
            match(input,103,FOLLOW_103_in_tcs_lookinparg5105); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92C892F1E66411DE8757E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_lookinparg5109); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CC3C71E66411DEC622E1868D1505E2");
            }
            // parser/TCS.g:876:226: ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==SHARP) ) {
                alt100=1;
            }
            else if ( (LA100_0==NAME||LA100_0==ORKEYWORD||(LA100_0>=52 && LA100_0<=135)) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // parser/TCS.g:876:227: ( SHARP 'all' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:876:243: ( SHARP 'all' )
                    // parser/TCS.g:876:244: SHARP 'all'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92CBC741E66411DEC321E1868D1505E2");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_tcs_lookinparg5120); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92CBC742E66411DEBD97E1868D1505E2");
                    }
                    match(input,105,FOLLOW_105_in_tcs_lookinparg5124); if (state.failed) return ret2;
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
                    // parser/TCS.g:876:479: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:876:495: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    // parser/TCS.g:876:496: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92CC1561E66411DEC8D8E1868D1505E2");
                    }
                    // parser/TCS.g:876:555: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    // parser/TCS.g:876:557: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg5141);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyName", temp);
                    }
                    // parser/TCS.g:876:624: ( ( POINT ) temp= identifierOrKeyword )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==POINT) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // parser/TCS.g:876:625: ( POINT ) temp= identifierOrKeyword
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:876:642: ( POINT )
                    	    // parser/TCS.g:876:643: POINT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD92CBEE52E66411DE85DEE1868D1505E2");
                    	    }
                    	    match(input,POINT,FOLLOW_POINT_in_tcs_lookinparg5150); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg5158);
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
                    }
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
    // parser/TCS.g:885:1: tcs_createinparg returns [Object ret2] : ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createinparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:890:3: ( ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            // parser/TCS.g:891:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            {
            // parser/TCS.g:891:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            // parser/TCS.g:891:4: 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CCD8B0E66411DEC7D5E1868D1505E2");
            }
            match(input,59,FOLLOW_59_in_tcs_createinparg5211); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CCD8B1E66411DE81F7E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createinparg5215); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CCFFC1E66411DE8091E1868D1505E2");
            }
            // parser/TCS.g:891:227: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            // parser/TCS.g:891:229: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg5223);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
            }
            // parser/TCS.g:891:296: ( ( POINT ) temp= identifierOrKeyword )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==POINT) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // parser/TCS.g:891:297: ( POINT ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:891:314: ( POINT )
            	    // parser/TCS.g:891:315: POINT
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CD92CCD8B4E66411DEA4F5E1868D1505E2");
            	    }
            	    match(input,POINT,FOLLOW_POINT_in_tcs_createinparg5232); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg5240);
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
    // $ANTLR end "tcs_createinparg"


    // $ANTLR start "tcs_asparg"
    // parser/TCS.g:899:1: tcs_asparg returns [Object ret2] : ( 'as' EQ ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifierOrKeyword ) ) ) ) ;
    public final Object tcs_asparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:904:3: ( ( 'as' EQ ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifierOrKeyword ) ) ) ) )
            // parser/TCS.g:905:3: ( 'as' EQ ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifierOrKeyword ) ) ) )
            {
            // parser/TCS.g:905:3: ( 'as' EQ ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifierOrKeyword ) ) ) )
            // parser/TCS.g:905:4: 'as' EQ ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifierOrKeyword ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CD4DE1E66411DE86CAE1868D1505E2");
            }
            match(input,85,FOLLOW_85_in_tcs_asparg5286); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CD4DE2E66411DE8BFDE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_asparg5290); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CDC311E66411DEC317E1868D1505E2");
            }
            // parser/TCS.g:905:221: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifierOrKeyword ) ) )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==QNAME) ) {
                alt102=1;
            }
            else if ( (LA102_0==NAME||LA102_0==ORKEYWORD||(LA102_0>=52 && LA102_0<=135)) ) {
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
                    // parser/TCS.g:905:222: ( (temp= qualifiedNameSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:905:238: ( (temp= qualifiedNameSymbol ) )
                    // parser/TCS.g:905:239: (temp= qualifiedNameSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92CD74F2E66411DEC2C8E1868D1505E2");
                    }
                    // parser/TCS.g:905:298: (temp= qualifiedNameSymbol )
                    // parser/TCS.g:905:300: temp= qualifiedNameSymbol
                    {
                    pushFollow(FOLLOW_qualifiedNameSymbol_in_tcs_asparg5303);
                    temp=qualifiedNameSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"				let e=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  					i; acc:Tuple(pos:Integer, ns:Set(Model::Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"            			  e.ns.contents->select(c | c.name=?.subString(e.pos, ?.size()))->asSequence()->at(1) ="+"										t.oclAsType(TCS::ClassTemplate).metaReference"+"										and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"											->prepend(self.property.propertyReference.strucfeature.type)"+"											->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"										and ("+"											if (not self.property.propertyArgs->select("+"													arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"												) "+"											then"+"												t.oclAsType(TCS::ClassTemplate).mode = "+"													self.property.propertyArgs->select("+"														arg | arg.oclIsTypeOf(TCS::ModePArg))"+"															.oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"													.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"											endif"+"										)"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"										else"+"											false"+"										endif"+"									endif)"+"								");
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
                    // parser/TCS.g:906:4: ( (temp= identifierOrKeyword ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:906:20: ( (temp= identifierOrKeyword ) )
                    // parser/TCS.g:906:21: (temp= identifierOrKeyword )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92CD9C05E66411DEBF63E1868D1505E2");
                    }
                    // parser/TCS.g:906:80: (temp= identifierOrKeyword )
                    // parser/TCS.g:906:82: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_asparg5323);
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
    // $ANTLR end "tcs_asparg"


    // $ANTLR start "tcs_separatorparg"
    // parser/TCS.g:914:1: tcs_separatorparg returns [Object ret2] : ( 'separator' EQ (temp= tcs_sequence ) ) ;
    public final Object tcs_separatorparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SeparatorPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:919:3: ( ( 'separator' EQ (temp= tcs_sequence ) ) )
            // parser/TCS.g:920:3: ( 'separator' EQ (temp= tcs_sequence ) )
            {
            // parser/TCS.g:920:3: ( 'separator' EQ (temp= tcs_sequence ) )
            // parser/TCS.g:920:4: 'separator' EQ (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CE1132E66411DEAE39E1868D1505E2");
            }
            match(input,100,FOLLOW_100_in_tcs_separatorparg5371); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CE1133E66411DE83CDE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_separatorparg5375); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CE3840E66411DEC21CE1868D1505E2");
            }
            // parser/TCS.g:920:228: (temp= tcs_sequence )
            // parser/TCS.g:920:230: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_separatorparg5383);
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
    // parser/TCS.g:928:1: tcs_disambiguateparg returns [Object ret2] : ( 'disambiguate' EQ (temp= stringSymbol ) ) ;
    public final Object tcs_disambiguateparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","DisambiguatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:933:3: ( ( 'disambiguate' EQ (temp= stringSymbol ) ) )
            // parser/TCS.g:934:3: ( 'disambiguate' EQ (temp= stringSymbol ) )
            {
            // parser/TCS.g:934:3: ( 'disambiguate' EQ (temp= stringSymbol ) )
            // parser/TCS.g:934:4: 'disambiguate' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CE5F50E66411DEBC03E1868D1505E2");
            }
            match(input,58,FOLLOW_58_in_tcs_disambiguateparg5426); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CE5F51E66411DEAC9AE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_disambiguateparg5430); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CE5F54E66411DECD7BE1868D1505E2");
            }
            // parser/TCS.g:934:231: (temp= stringSymbol )
            // parser/TCS.g:934:233: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_disambiguateparg5438);
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
    // parser/TCS.g:942:1: tcs_autocreateparg returns [Object ret2] : ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) ;
    public final Object tcs_autocreateparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AutoCreatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:947:3: ( ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) )
            // parser/TCS.g:948:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            {
            // parser/TCS.g:948:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            // parser/TCS.g:948:4: 'autoCreate' EQ (temp= tcs_autocreatekind )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CEAD70E66411DEB17CE1868D1505E2");
            }
            match(input,130,FOLLOW_130_in_tcs_autocreateparg5481); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CEAD71E66411DE9164E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_autocreateparg5485); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92CEAD73E66411DE8F02E1868D1505E2");
            }
            // parser/TCS.g:948:229: (temp= tcs_autocreatekind )
            // parser/TCS.g:948:231: temp= tcs_autocreatekind
            {
            pushFollow(FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg5493);
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
    // parser/TCS.g:956:1: tcs_autocreatekind returns [Object ret2] : ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) ;
    public final Object tcs_autocreatekind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:957:3: ( ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) )
            // parser/TCS.g:958:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            {
            // parser/TCS.g:958:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            int alt103=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt103=1;
                }
                break;
            case 114:
                {
                alt103=2;
                }
                break;
            case 131:
                {
                alt103=3;
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
                    // parser/TCS.g:958:4: ( 'always' )
                    {
                    // parser/TCS.g:958:4: ( 'always' )
                    // parser/TCS.g:958:5: 'always'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92D00D00E66411DEB4B1E1868D1505E2");
                    }
                    match(input,96,FOLLOW_96_in_tcs_autocreatekind5537); if (state.failed) return ret2;
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
                    // parser/TCS.g:959:4: ( 'ifmissing' )
                    {
                    // parser/TCS.g:959:4: ( 'ifmissing' )
                    // parser/TCS.g:959:5: 'ifmissing'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92D452C1E66411DE99EFE1868D1505E2");
                    }
                    match(input,114,FOLLOW_114_in_tcs_autocreatekind5547); if (state.failed) return ret2;
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
                    // parser/TCS.g:960:4: ( 'never' )
                    {
                    // parser/TCS.g:960:4: ( 'never' )
                    // parser/TCS.g:960:5: 'never'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92D479D0E66411DE8A2DE1868D1505E2");
                    }
                    match(input,131,FOLLOW_131_in_tcs_autocreatekind5557); if (state.failed) return ret2;
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
    // parser/TCS.g:967:1: tcs_importcontextparg returns [Object ret2] : ( 'importContext' ) ;
    public final Object tcs_importcontextparg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","ImportContextPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:972:3: ( ( 'importContext' ) )
            // parser/TCS.g:973:3: ( 'importContext' )
            {
            // parser/TCS.g:973:3: ( 'importContext' )
            // parser/TCS.g:973:4: 'importContext'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D78710E66411DEB579E1868D1505E2");
            }
            match(input,93,FOLLOW_93_in_tcs_importcontextparg5588); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:981:1: tcs_partialparg returns [Object ret2] : ( 'partial' ) ;
    public final Object tcs_partialparg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","PartialPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:986:3: ( ( 'partial' ) )
            // parser/TCS.g:987:3: ( 'partial' )
            {
            // parser/TCS.g:987:3: ( 'partial' )
            // parser/TCS.g:987:4: 'partial'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D7AE22E66411DEADE3E1868D1505E2");
            }
            match(input,123,FOLLOW_123_in_tcs_partialparg5628); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:995:1: tcs_forcedlowerparg returns [Object ret2] : ( 'forcedLower' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedlowerparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedLowerPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1000:3: ( ( 'forcedLower' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1001:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1001:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1001:4: 'forcedLower' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D7FC40E66411DEB4EAE1868D1505E2");
            }
            match(input,134,FOLLOW_134_in_tcs_forcedlowerparg5668); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D7FC41E66411DE83C6E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedlowerparg5672); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D7FC43E66411DE846EE1868D1505E2");
            }
            // parser/TCS.g:1001:230: (temp= integerSymbol )
            // parser/TCS.g:1001:232: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedlowerparg5680);
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
    // parser/TCS.g:1009:1: tcs_forcedupperparg returns [Object ret2] : ( 'forcedUpper' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedupperparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedUpperPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1014:3: ( ( 'forcedUpper' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1015:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1015:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1015:4: 'forcedUpper' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D82352E66411DE87E9E1868D1505E2");
            }
            match(input,108,FOLLOW_108_in_tcs_forcedupperparg5723); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D82353E66411DE9719E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedupperparg5727); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D84A61E66411DE827CE1868D1505E2");
            }
            // parser/TCS.g:1015:230: (temp= integerSymbol )
            // parser/TCS.g:1015:232: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedupperparg5735);
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
    // parser/TCS.g:1023:1: tcs_createasparg returns [Object ret2] : ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createasparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateAsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1028:3: ( ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) ) )
            // parser/TCS.g:1029:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) )
            {
            // parser/TCS.g:1029:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) )
            // parser/TCS.g:1029:4: 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D87171E66411DE9717E1868D1505E2");
            }
            match(input,92,FOLLOW_92_in_tcs_createasparg5778); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D87172E66411DE835BE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createasparg5782); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D89883E66411DEB22CE1868D1505E2");
            }
            // parser/TCS.g:1029:227: (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )
            // parser/TCS.g:1029:229: temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg5790);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }
            // parser/TCS.g:1029:288: ( ( DLCOLON ) temp= identifierOrKeyword )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==DLCOLON) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // parser/TCS.g:1029:289: ( DLCOLON ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:1029:306: ( DLCOLON )
            	    // parser/TCS.g:1029:307: DLCOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CD92D89880E66411DEA6CBE1868D1505E2");
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_tcs_createasparg5799); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg5807);
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
            	    break loop104;
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
    // parser/TCS.g:1037:1: tcs_queryparg returns [Object ret2] : ( 'query' EQ (temp= stringSymbol ) ) ;
    public final Object tcs_queryparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","QueryPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1042:3: ( ( 'query' EQ (temp= stringSymbol ) ) )
            // parser/TCS.g:1043:3: ( 'query' EQ (temp= stringSymbol ) )
            {
            // parser/TCS.g:1043:3: ( 'query' EQ (temp= stringSymbol ) )
            // parser/TCS.g:1043:4: 'query' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D8E6A0E66411DEB91CE1868D1505E2");
            }
            match(input,90,FOLLOW_90_in_tcs_queryparg5853); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D8E6A1E66411DEA185E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_queryparg5857); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D90DB1E66411DEC92BE1868D1505E2");
            }
            // parser/TCS.g:1043:224: (temp= stringSymbol )
            // parser/TCS.g:1043:226: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_queryparg5865);
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
    // parser/TCS.g:1051:1: tcs_filterparg returns [Object ret2] : ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) ) ;
    public final Object tcs_filterparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FilterPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1056:3: ( ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) ) )
            // parser/TCS.g:1057:3: ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) )
            {
            // parser/TCS.g:1057:3: ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) )
            // parser/TCS.g:1057:4: 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D934C2E66411DEC418E1868D1505E2");
            }
            match(input,106,FOLLOW_106_in_tcs_filterparg5908); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D934C3E66411DE86AAE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_filterparg5912); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92D95BD2E66411DEC364E1868D1505E2");
            }
            // parser/TCS.g:1057:225: (temp= stringSymbol )
            // parser/TCS.g:1057:227: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_filterparg5920);
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
              _beforeSeqEl("E0DCF6CD92D9D100E66411DEA035E1868D1505E2");
            }
            // parser/TCS.g:1057:357: ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==COMA) ) {
                int LA105_1 = input.LA(2);

                if ( ((LA105_1>=58 && LA105_1<=59)||LA105_1==85||LA105_1==90||(LA105_1>=92 && LA105_1<=93)||LA105_1==100||LA105_1==103||LA105_1==106||LA105_1==108||LA105_1==115||(LA105_1>=123 && LA105_1<=124)||LA105_1==130||LA105_1==134) ) {
                    alt105=2;
                }
                else if ( (LA105_1==113) ) {
                    alt105=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 105, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA105_0==EOF||LA105_0==RCURLY) ) {
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
                    // parser/TCS.g:1057:358: ( COMA 'invert' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1057:374: ( COMA 'invert' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:1057:375: COMA 'invert' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92D982E1E66411DE8DDCE1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_filterparg5933); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92D982E2E66411DE90D3E1868D1505E2");
                    }
                    match(input,113,FOLLOW_113_in_tcs_filterparg5937); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92D982E3E66411DE9F17E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_filterparg5941); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92D9A9F0E66411DEAB71E1868D1505E2");
                    }
                    // parser/TCS.g:1057:677: (temp= stringSymbol )
                    // parser/TCS.g:1057:679: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_filterparg5949);
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
                    // parser/TCS.g:1057:767: 
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
    // parser/TCS.g:1066:1: tcs_modeparg returns [Object ret2] : ( 'mode' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_modeparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ModePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1071:3: ( ( 'mode' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:1072:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:1072:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:1072:4: 'mode' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DA1F20E66411DEBBA6E1868D1505E2");
            }
            match(input,115,FOLLOW_115_in_tcs_modeparg6005); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DA1F21E66411DEBD56E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_modeparg6009); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DA1F24E66411DECB1AE1868D1505E2");
            }
            // parser/TCS.g:1072:223: (temp= identifierOrKeyword )
            // parser/TCS.g:1072:225: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_modeparg6017);
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
    // parser/TCS.g:1080:1: tcs_blockarg returns [Object ret2] : (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) ;
    public final Object tcs_blockarg() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1081:3: ( (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) )
            // parser/TCS.g:1082:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            {
            // parser/TCS.g:1082:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            int alt106=5;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt106=1;
                }
                break;
            case 69:
                {
                alt106=2;
                }
                break;
            case 129:
                {
                alt106=3;
                }
                break;
            case 112:
                {
                alt106=4;
                }
                break;
            case 57:
                {
                alt106=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // parser/TCS.g:1082:4: ret= tcs_nbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_nbnlbarg_in_tcs_blockarg6057);
                    ret=tcs_nbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1083:5: ret= tcs_indentincrbarg
                    {
                    pushFollow(FOLLOW_tcs_indentincrbarg_in_tcs_blockarg6065);
                    ret=tcs_indentincrbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1084:5: ret= tcs_startnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnlbarg_in_tcs_blockarg6073);
                    ret=tcs_startnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1085:5: ret= tcs_startnbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg6081);
                    ret=tcs_startnbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1086:5: ret= tcs_endnlbarg
                    {
                    pushFollow(FOLLOW_tcs_endnlbarg_in_tcs_blockarg6089);
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
    // parser/TCS.g:1093:1: tcs_nbnlbarg returns [Object ret2] : ( 'nbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_nbnlbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1098:3: ( ( 'nbNL' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1099:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1099:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1099:4: 'nbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DA6D42E66411DE9718E1868D1505E2");
            }
            match(input,88,FOLLOW_88_in_tcs_nbnlbarg6119); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DA6D43E66411DE873CE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_nbnlbarg6123); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DA6D45E66411DEBA99E1868D1505E2");
            }
            // parser/TCS.g:1099:223: (temp= integerSymbol )
            // parser/TCS.g:1099:225: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_nbnlbarg6131);
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
    // parser/TCS.g:1107:1: tcs_indentincrbarg returns [Object ret2] : ( 'indentIncr' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_indentincrbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IndentIncrBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1112:3: ( ( 'indentIncr' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1113:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1113:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1113:4: 'indentIncr' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DB57A1E66411DEAD2CE1868D1505E2");
            }
            match(input,69,FOLLOW_69_in_tcs_indentincrbarg6174); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DB7EB0E66411DE9314E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_indentincrbarg6178); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DB7EB2E66411DECFEBE1868D1505E2");
            }
            // parser/TCS.g:1113:229: (temp= integerSymbol )
            // parser/TCS.g:1113:231: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_indentincrbarg6186);
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
    // parser/TCS.g:1121:1: tcs_startnlbarg returns [Object ret2] : ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_startnlbarg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","StartNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1126:3: ( ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // parser/TCS.g:1127:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // parser/TCS.g:1127:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // parser/TCS.g:1127:4: 'startNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DBA5C1E66411DEB41AE1868D1505E2");
            }
            match(input,129,FOLLOW_129_in_tcs_startnlbarg6229); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DBA5C2E66411DECFFEE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnlbarg6233); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DBF3E0E66411DEC424E1868D1505E2");
            }
            // parser/TCS.g:1127:227: ( ( 'true' ) | ( 'false' ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==133) ) {
                alt107=1;
            }
            else if ( (LA107_0==98) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // parser/TCS.g:1127:228: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1127:244: ( 'true' )
                    // parser/TCS.g:1127:245: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DBCCD1E66411DEAB21E1868D1505E2");
                    }
                    match(input,133,FOLLOW_133_in_tcs_startnlbarg6243); if (state.failed) return ret2;
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
                    // parser/TCS.g:1127:396: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1127:412: ( 'false' )
                    // parser/TCS.g:1127:413: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DBCCD3E66411DEAF82E1868D1505E2");
                    }
                    match(input,98,FOLLOW_98_in_tcs_startnlbarg6256); if (state.failed) return ret2;
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
    // parser/TCS.g:1136:1: tcs_startnbnlbarg returns [Object ret2] : ( 'startNbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_startnbnlbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StartNbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1141:3: ( ( 'startNbNL' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1142:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1142:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1142:4: 'startNbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DC4200E66411DEA962E1868D1505E2");
            }
            match(input,112,FOLLOW_112_in_tcs_startnbnlbarg6303); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DC4201E66411DEC34DE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnbnlbarg6307); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DC4203E66411DECFCEE1868D1505E2");
            }
            // parser/TCS.g:1142:228: (temp= integerSymbol )
            // parser/TCS.g:1142:230: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_startnbnlbarg6315);
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
    // parser/TCS.g:1150:1: tcs_endnlbarg returns [Object ret2] : ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_endnlbarg() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","EndNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1155:3: ( ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // parser/TCS.g:1156:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // parser/TCS.g:1156:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // parser/TCS.g:1156:4: 'endNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DC6912E66411DE821EE1868D1505E2");
            }
            match(input,57,FOLLOW_57_in_tcs_endnlbarg6358); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DC9020E66411DEBCD4E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endnlbarg6362); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DCB732E66411DE9738E1868D1505E2");
            }
            // parser/TCS.g:1156:225: ( ( 'true' ) | ( 'false' ) )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==133) ) {
                alt108=1;
            }
            else if ( (LA108_0==98) ) {
                alt108=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }
            switch (alt108) {
                case 1 :
                    // parser/TCS.g:1156:226: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1156:242: ( 'true' )
                    // parser/TCS.g:1156:243: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DC9024E66411DECB6AE1868D1505E2");
                    }
                    match(input,133,FOLLOW_133_in_tcs_endnlbarg6372); if (state.failed) return ret2;
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
                    // parser/TCS.g:1156:394: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1156:410: ( 'false' )
                    // parser/TCS.g:1156:411: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DCB730E66411DECC15E1868D1505E2");
                    }
                    match(input,98,FOLLOW_98_in_tcs_endnlbarg6385); if (state.failed) return ret2;
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
    // parser/TCS.g:1165:1: tcs_symbol returns [Object ret2] : ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) ;
    public final Object tcs_symbol() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Symbol");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1170:3: ( ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) )
            // parser/TCS.g:1171:3: ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            {
            // parser/TCS.g:1171:3: ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            // parser/TCS.g:1171:4: (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DD0551E66411DEC0CEE1868D1505E2");
            }
            // parser/TCS.g:1171:63: (temp= identifier )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==NAME) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // parser/TCS.g:1171:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_symbol6436);
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
              _beforeSeqEl("E0DCF6CD92DD0552E66411DEAC8CE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_symbol6445); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DD0555E66411DECD36E1868D1505E2");
            }
            // parser/TCS.g:1171:271: (temp= stringSymbol )
            // parser/TCS.g:1171:273: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_symbol6453);
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
              _beforeSeqEl("E0DCF6CD92DD7A81E66411DEABC3E1868D1505E2");
            }
            // parser/TCS.g:1171:402: ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==COLON) ) {
                alt112=1;
            }
            else if ( (LA112_0==SEMI) ) {
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
                    // parser/TCS.g:1171:403: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1171:419: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    // parser/TCS.g:1171:420: COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DD2C63E66411DE960EE1868D1505E2");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_symbol6466); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DD5373E66411DEBF3BE1868D1505E2");
                    }
                    // parser/TCS.g:1171:561: (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==73||LA111_0==81||LA111_0==104||LA111_0==135) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // parser/TCS.g:1171:563: temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )*
                            {
                            pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol6474);
                            temp=tcs_spacekind();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "spaces", temp);
                            }
                            // parser/TCS.g:1171:618: ( ( COMA ) temp= tcs_spacekind )*
                            loop110:
                            do {
                                int alt110=2;
                                int LA110_0 = input.LA(1);

                                if ( (LA110_0==COMA) ) {
                                    alt110=1;
                                }


                                switch (alt110) {
                            	case 1 :
                            	    // parser/TCS.g:1171:619: ( COMA ) temp= tcs_spacekind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:1171:636: ( COMA )
                            	    // parser/TCS.g:1171:637: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD92DD5370E66411DE93C8E1868D1505E2");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_symbol6483); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol6491);
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
                            	    break loop110;
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
                    // parser/TCS.g:1171:830: 
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
              _beforeSeqEl("E0DCF6CD92DDA190E66411DEBFE5E1868D1505E2");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_symbol6516); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1180:1: tcs_spacekind returns [Object ret2] : ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) ;
    public final Object tcs_spacekind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1181:3: ( ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) )
            // parser/TCS.g:1182:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            {
            // parser/TCS.g:1182:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            int alt113=4;
            switch ( input.LA(1) ) {
            case 135:
                {
                alt113=1;
                }
                break;
            case 104:
                {
                alt113=2;
                }
                break;
            case 73:
                {
                alt113=3;
                }
                break;
            case 81:
                {
                alt113=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // parser/TCS.g:1182:4: ( 'leftSpace' )
                    {
                    // parser/TCS.g:1182:4: ( 'leftSpace' )
                    // parser/TCS.g:1182:5: 'leftSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DDC8A3E66411DEA332E1868D1505E2");
                    }
                    match(input,135,FOLLOW_135_in_tcs_spacekind6558); if (state.failed) return ret2;
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
                    // parser/TCS.g:1183:4: ( 'leftNone' )
                    {
                    // parser/TCS.g:1183:4: ( 'leftNone' )
                    // parser/TCS.g:1183:5: 'leftNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DDEFB1E66411DECADCE1868D1505E2");
                    }
                    match(input,104,FOLLOW_104_in_tcs_spacekind6568); if (state.failed) return ret2;
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
                    // parser/TCS.g:1184:4: ( 'rightSpace' )
                    {
                    // parser/TCS.g:1184:4: ( 'rightSpace' )
                    // parser/TCS.g:1184:5: 'rightSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DE16C1E66411DEAA22E1868D1505E2");
                    }
                    match(input,73,FOLLOW_73_in_tcs_spacekind6578); if (state.failed) return ret2;
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
                    // parser/TCS.g:1185:4: ( 'rightNone' )
                    {
                    // parser/TCS.g:1185:4: ( 'rightNone' )
                    // parser/TCS.g:1185:5: 'rightNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DE16C4E66411DE828EE1868D1505E2");
                    }
                    match(input,81,FOLLOW_81_in_tcs_spacekind6588); if (state.failed) return ret2;
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
    // parser/TCS.g:1192:1: tcs_keyword returns [Object ret2] : ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI ) ;
    public final Object tcs_keyword() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Keyword");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1197:3: ( ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI ) )
            // parser/TCS.g:1198:3: ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI )
            {
            // parser/TCS.g:1198:3: ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI )
            // parser/TCS.g:1198:4: (temp= identifier )? EQ (temp= stringSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DEDA10E66411DEA35BE1868D1505E2");
            }
            // parser/TCS.g:1198:63: (temp= identifier )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==NAME) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // parser/TCS.g:1198:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_keyword6623);
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
              _beforeSeqEl("E0DCF6CD92DF0120E66411DEA8C9E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_keyword6632); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DF0123E66411DE936FE1868D1505E2");
            }
            // parser/TCS.g:1198:271: (temp= stringSymbol )
            // parser/TCS.g:1198:273: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_keyword6640);
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
              _beforeSeqEl("E0DCF6CD92DF2830E66411DEC182E1868D1505E2");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_keyword6647); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1206:1: tcs_operatorlist returns [Object ret2] : ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) ;
    public final Object tcs_operatorlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1211:3: ( ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) )
            // parser/TCS.g:1212:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            {
            // parser/TCS.g:1212:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            // parser/TCS.g:1212:4: 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DF4F40E66411DEB92AE1868D1505E2");
            }
            match(input,94,FOLLOW_94_in_tcs_operatorlist6688); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DF7654E66411DEAA9BE1868D1505E2");
            }
            // parser/TCS.g:1212:150: ( ( (temp= identifier ) ) | )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==NAME) ) {
                alt115=1;
            }
            else if ( (LA115_0==LCURLY) ) {
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
                    // parser/TCS.g:1212:151: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1212:167: ( (temp= identifier ) )
                    // parser/TCS.g:1212:168: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92DF7652E66411DE8F72E1868D1505E2");
                    }
                    // parser/TCS.g:1212:227: (temp= identifier )
                    // parser/TCS.g:1212:229: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatorlist6701);
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
                    // parser/TCS.g:1212:313: 
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
              _beforeSeqEl("E0DCF6CD92DF9D60E66411DE9791E1868D1505E2");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_operatorlist6721); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DFC470E66411DEAEA4E1868D1505E2");
            }
            // parser/TCS.g:1213:159: ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) )
            // parser/TCS.g:1213:160: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            {
            // parser/TCS.g:1213:160: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            // parser/TCS.g:1213:161: (temp= tcs_priority (temp= tcs_priority )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92DF9D62E66411DEA204E1868D1505E2");
            }
            // parser/TCS.g:1213:220: (temp= tcs_priority (temp= tcs_priority )* )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==75) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // parser/TCS.g:1213:222: temp= tcs_priority (temp= tcs_priority )*
                    {
                    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist6732);
                    temp=tcs_priority();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "priorities", temp);
                    }
                    // parser/TCS.g:1213:280: (temp= tcs_priority )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==75) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // parser/TCS.g:1213:282: temp= tcs_priority
                    	    {
                    	    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist6740);
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
              _beforeSeqEl("E0DCF6CD92DFC471E66411DEA15FE1868D1505E2");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_operatorlist6755); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1221:1: tcs_priority returns [Object ret2] : ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) ;
    public final Object tcs_priority() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Priority");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1226:3: ( ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) )
            // parser/TCS.g:1227:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            {
            // parser/TCS.g:1227:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            // parser/TCS.g:1227:4: 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E01290E66411DECFCAE1868D1505E2");
            }
            match(input,75,FOLLOW_75_in_tcs_priority6796); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E01292E66411DEC94EE1868D1505E2");
            }
            // parser/TCS.g:1227:148: (temp= integerSymbol )
            // parser/TCS.g:1227:150: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_priority6803);
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
              _beforeSeqEl("E0DCF6CD92E060B0E66411DE94BDE1868D1505E2");
            }
            // parser/TCS.g:1227:280: ( () | ( COMA (temp= tcs_associativity ) ) )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==LCURLY) ) {
                alt118=1;
            }
            else if ( (LA118_0==COMA) ) {
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
                    // parser/TCS.g:1227:281: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1227:297: ()
                    // parser/TCS.g:1227:298: 
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
                    // parser/TCS.g:1227:407: ( COMA (temp= tcs_associativity ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1227:423: ( COMA (temp= tcs_associativity ) )
                    // parser/TCS.g:1227:424: COMA (temp= tcs_associativity )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E039A2E66411DE996BE1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_priority6826); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E039A4E66411DECC90E1868D1505E2");
                    }
                    // parser/TCS.g:1227:564: (temp= tcs_associativity )
                    // parser/TCS.g:1227:566: temp= tcs_associativity
                    {
                    pushFollow(FOLLOW_tcs_associativity_in_tcs_priority6834);
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
              _beforeSeqEl("E0DCF6CD92E060B1E66411DE9C43E1868D1505E2");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_priority6848); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E087C3E66411DECC0AE1868D1505E2");
            }
            // parser/TCS.g:1228:159: ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) )
            // parser/TCS.g:1228:160: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            {
            // parser/TCS.g:1228:160: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            // parser/TCS.g:1228:161: (temp= tcs_operator (temp= tcs_operator )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E087C1E66411DECF21E1868D1505E2");
            }
            // parser/TCS.g:1228:220: (temp= tcs_operator (temp= tcs_operator )* )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==NAME||LA120_0==EQ||LA120_0==89) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // parser/TCS.g:1228:222: temp= tcs_operator (temp= tcs_operator )*
                    {
                    pushFollow(FOLLOW_tcs_operator_in_tcs_priority6859);
                    temp=tcs_operator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operators", temp);
                    }
                    // parser/TCS.g:1228:279: (temp= tcs_operator )*
                    loop119:
                    do {
                        int alt119=2;
                        int LA119_0 = input.LA(1);

                        if ( (LA119_0==NAME||LA119_0==EQ||LA119_0==89) ) {
                            alt119=1;
                        }


                        switch (alt119) {
                    	case 1 :
                    	    // parser/TCS.g:1228:281: temp= tcs_operator
                    	    {
                    	    pushFollow(FOLLOW_tcs_operator_in_tcs_priority6867);
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
                    	    break loop119;
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
              _beforeSeqEl("E0DCF6CD92E087C4E66411DE9CC9E1868D1505E2");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_priority6882); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1236:1: tcs_operator returns [Object ret2] : ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) ;
    public final Object tcs_operator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Operator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1241:3: ( ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) )
            // parser/TCS.g:1242:3: ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            {
            // parser/TCS.g:1242:3: ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            // parser/TCS.g:1242:4: ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E0FCF3E66411DEADD8E1868D1505E2");
            }
            // parser/TCS.g:1242:64: ( ( 'postfix' ) | )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==89) ) {
                alt121=1;
            }
            else if ( (LA121_0==NAME||LA121_0==EQ) ) {
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
                    // parser/TCS.g:1242:65: ( 'postfix' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1242:81: ( 'postfix' )
                    // parser/TCS.g:1242:82: 'postfix'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E0FCF1E66411DEAB51E1868D1505E2");
                    }
                    match(input,89,FOLLOW_89_in_tcs_operator6929); if (state.failed) return ret2;
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
                    // parser/TCS.g:1242:240: 
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
              _beforeSeqEl("E0DCF6CD92E12401E66411DEC06AE1868D1505E2");
            }
            // parser/TCS.g:1243:76: (temp= identifier )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==NAME) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // parser/TCS.g:1243:78: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operator6951);
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
              _beforeSeqEl("E0DCF6CD92E12402E66411DEBAC5E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operator6960); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E1C042E66411DEB6A5E1868D1505E2");
            }
            // parser/TCS.g:1243:285: ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | )
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( ((LA124_0>=NAME && LA124_0<=STRING)) ) {
                alt124=1;
            }
            else if ( (LA124_0==COMA) ) {
                alt124=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }
            switch (alt124) {
                case 1 :
                    // parser/TCS.g:1243:286: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1243:302: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    // parser/TCS.g:1243:303: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E1C040E66411DEAFB7E1868D1505E2");
                    }
                    // parser/TCS.g:1243:362: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    int alt123=2;
                    int LA123_0 = input.LA(1);

                    if ( (LA123_0==NAME) ) {
                        alt123=1;
                    }
                    else if ( (LA123_0==STRING) ) {
                        alt123=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 123, 0, input);

                        throw nvae;
                    }
                    switch (alt123) {
                        case 1 :
                            // parser/TCS.g:1243:363: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:1243:379: ( (temp= identifier ) )
                            // parser/TCS.g:1243:380: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92E14B12E66411DEA5C9E1868D1505E2");
                            }
                            // parser/TCS.g:1243:439: (temp= identifier )
                            // parser/TCS.g:1243:441: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_operator6979);
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
                            // parser/TCS.g:1244:4: ( (temp= stringSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // parser/TCS.g:1244:20: ( (temp= stringSymbol ) )
                            // parser/TCS.g:1244:21: (temp= stringSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92E17226E66411DE8F9CE1868D1505E2");
                            }
                            // parser/TCS.g:1244:80: (temp= stringSymbol )
                            // parser/TCS.g:1244:82: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_operator6999);
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
                    // parser/TCS.g:1244:287: 
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
              _beforeSeqEl("E0DCF6CD92E1E750E66411DEC088E1868D1505E2");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_operator7024); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E1E752E66411DE9415E1868D1505E2");
            }
            // parser/TCS.g:1245:157: (temp= integerSymbol )
            // parser/TCS.g:1245:159: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_operator7032);
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
              _beforeSeqEl("E0DCF6CD92E23570E66411DEB5D2E1868D1505E2");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_operator7039); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1253:1: tcs_associativity returns [Object ret2] : ( ( 'left' ) | ( 'right' ) ) ;
    public final Object tcs_associativity() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1254:3: ( ( ( 'left' ) | ( 'right' ) ) )
            // parser/TCS.g:1255:3: ( ( 'left' ) | ( 'right' ) )
            {
            // parser/TCS.g:1255:3: ( ( 'left' ) | ( 'right' ) )
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==126) ) {
                alt125=1;
            }
            else if ( (LA125_0==87) ) {
                alt125=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;
            }
            switch (alt125) {
                case 1 :
                    // parser/TCS.g:1255:4: ( 'left' )
                    {
                    // parser/TCS.g:1255:4: ( 'left' )
                    // parser/TCS.g:1255:5: 'left'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E28391E66411DEACFCE1868D1505E2");
                    }
                    match(input,126,FOLLOW_126_in_tcs_associativity7081); if (state.failed) return ret2;
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
                    // parser/TCS.g:1256:4: ( 'right' )
                    {
                    // parser/TCS.g:1256:4: ( 'right' )
                    // parser/TCS.g:1256:5: 'right'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E28394E66411DE8197E1868D1505E2");
                    }
                    match(input,87,FOLLOW_87_in_tcs_associativity7091); if (state.failed) return ret2;
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
    // parser/TCS.g:1263:1: tcs_expression returns [Object ret2] : (ret= tcs_andexp ) ;
    public final Object tcs_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1264:3: ( (ret= tcs_andexp ) )
            // parser/TCS.g:1265:3: (ret= tcs_andexp )
            {
            // parser/TCS.g:1265:3: (ret= tcs_andexp )
            // parser/TCS.g:1265:4: ret= tcs_andexp
            {
            pushFollow(FOLLOW_tcs_andexp_in_tcs_expression7119);
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
    // parser/TCS.g:1272:1: tcs_andexp returns [Object ret2] : ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) ;
    public final Object tcs_andexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AndExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1277:3: ( ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) )
            // parser/TCS.g:1278:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            {
            // parser/TCS.g:1278:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            // parser/TCS.g:1278:4: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E2F8C0E66411DEBAE6E1868D1505E2");
            }
            // parser/TCS.g:1278:63: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==NAME||LA127_0==RARROW||LA127_0==ORKEYWORD||(LA127_0>=52 && LA127_0<=135)) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // parser/TCS.g:1278:65: temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )*
                    {
                    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp7153);
                    temp=tcs_atomexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "expressions", temp);
                    }
                    // parser/TCS.g:1278:123: ( ( 'and' ) temp= tcs_atomexp )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==80) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // parser/TCS.g:1278:124: ( 'and' ) temp= tcs_atomexp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:1278:141: ( 'and' )
                    	    // parser/TCS.g:1278:142: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD92E2D1B3E66411DE951AE1868D1505E2");
                    	    }
                    	    match(input,80,FOLLOW_80_in_tcs_andexp7161); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp7168);
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
                    	    break loop126;
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
    // parser/TCS.g:1286:1: tcs_atomexp returns [Object ret2] : (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp ) ;
    public final Object tcs_atomexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1287:3: ( (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp ) )
            // parser/TCS.g:1288:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )
            {
            // parser/TCS.g:1288:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )
            int alt128=5;
            alt128 = dfa128.predict(input);
            switch (alt128) {
                case 1 :
                    // parser/TCS.g:1288:4: ret= tcs_equalsexp
                    {
                    pushFollow(FOLLOW_tcs_equalsexp_in_tcs_atomexp7213);
                    ret=tcs_equalsexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1289:5: ret= tcs_booleanpropertyexp
                    {
                    pushFollow(FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp7221);
                    ret=tcs_booleanpropertyexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1290:5: ret= tcs_isdefinedexp
                    {
                    pushFollow(FOLLOW_tcs_isdefinedexp_in_tcs_atomexp7229);
                    ret=tcs_isdefinedexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1291:5: ret= tcs_oneexp
                    {
                    pushFollow(FOLLOW_tcs_oneexp_in_tcs_atomexp7237);
                    ret=tcs_oneexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1292:5: ret= tcs_instanceofexp
                    {
                    pushFollow(FOLLOW_tcs_instanceofexp_in_tcs_atomexp7245);
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
    // parser/TCS.g:1299:1: tcs_equalsexp returns [Object ret2] : ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) ) ;
    public final Object tcs_equalsexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EqualsExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1304:3: ( ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) ) )
            // parser/TCS.g:1305:3: ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) )
            {
            // parser/TCS.g:1305:3: ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) )
            // parser/TCS.g:1305:4: (temp= tcs_propertyreference ) EQ (temp= tcs_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E346E1E66411DE8DE9E1868D1505E2");
            }
            // parser/TCS.g:1305:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1305:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_equalsexp7279);
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
              _beforeSeqEl("E0DCF6CD92E346E2E66411DE9A4EE1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_equalsexp7286); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E346E4E66411DECBBCE1868D1505E2");
            }
            // parser/TCS.g:1305:293: (temp= tcs_value )
            // parser/TCS.g:1305:295: temp= tcs_value
            {
            pushFollow(FOLLOW_tcs_value_in_tcs_equalsexp7294);
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
    // parser/TCS.g:1313:1: tcs_booleanpropertyexp returns [Object ret2] : ( (temp= tcs_propertyreference ) ) ;
    public final Object tcs_booleanpropertyexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","BooleanPropertyExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1318:3: ( ( (temp= tcs_propertyreference ) ) )
            // parser/TCS.g:1319:3: ( (temp= tcs_propertyreference ) )
            {
            // parser/TCS.g:1319:3: ( (temp= tcs_propertyreference ) )
            // parser/TCS.g:1319:4: (temp= tcs_propertyreference )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E39501E66411DEBAB4E1868D1505E2");
            }
            // parser/TCS.g:1319:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1319:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_booleanpropertyexp7341);
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
    // parser/TCS.g:1327:1: tcs_isdefinedexp returns [Object ret2] : ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN ) ;
    public final Object tcs_isdefinedexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IsDefinedExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1332:3: ( ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN ) )
            // parser/TCS.g:1333:3: ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN )
            {
            // parser/TCS.g:1333:3: ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN )
            // parser/TCS.g:1333:4: 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E3BC10E66411DE8A4DE1868D1505E2");
            }
            match(input,55,FOLLOW_55_in_tcs_isdefinedexp7384); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E3BC11E66411DEB2BAE1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_isdefinedexp7388); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E3BC13E66411DE840CE1868D1505E2");
            }
            // parser/TCS.g:1333:232: (temp= tcs_propertyreference )
            // parser/TCS.g:1333:234: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_isdefinedexp7396);
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
              _beforeSeqEl("E0DCF6CD92E3BC14E66411DEC646E1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_isdefinedexp7403); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1341:1: tcs_oneexp returns [Object ret2] : ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN ) ;
    public final Object tcs_oneexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OneExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1346:3: ( ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN ) )
            // parser/TCS.g:1347:3: ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN )
            {
            // parser/TCS.g:1347:3: ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN )
            // parser/TCS.g:1347:4: 'one' LPAREN (temp= tcs_propertyreference ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E40A30E66411DE8207E1868D1505E2");
            }
            match(input,56,FOLLOW_56_in_tcs_oneexp7444); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E40A31E66411DEC913E1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_oneexp7448); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E40A33E66411DE850DE1868D1505E2");
            }
            // parser/TCS.g:1347:226: (temp= tcs_propertyreference )
            // parser/TCS.g:1347:228: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_oneexp7456);
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
              _beforeSeqEl("E0DCF6CD92E40A34E66411DE91DDE1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_oneexp7463); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1355:1: tcs_instanceofexp returns [Object ret2] : ( (temp= tcs_propertyreference ) 'instanceOf' ( ( (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* ) ) | ( (temp= identifier ) ) ) ) ;
    public final Object tcs_instanceofexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","InstanceOfExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1360:3: ( ( (temp= tcs_propertyreference ) 'instanceOf' ( ( (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* ) ) | ( (temp= identifier ) ) ) ) )
            // parser/TCS.g:1361:3: ( (temp= tcs_propertyreference ) 'instanceOf' ( ( (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* ) ) | ( (temp= identifier ) ) ) )
            {
            // parser/TCS.g:1361:3: ( (temp= tcs_propertyreference ) 'instanceOf' ( ( (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* ) ) | ( (temp= identifier ) ) ) )
            // parser/TCS.g:1361:4: (temp= tcs_propertyreference ) 'instanceOf' ( ( (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E43143E66411DE9D47E1868D1505E2");
            }
            // parser/TCS.g:1361:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1361:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_instanceofexp7508);
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
              _beforeSeqEl("E0DCF6CD92E45850E66411DEA167E1868D1505E2");
            }
            match(input,52,FOLLOW_52_in_tcs_instanceofexp7514); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E4A671E66411DEBA69E1868D1505E2");
            }
            // parser/TCS.g:1361:301: ( ( (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* ) ) | ( (temp= identifier ) ) )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==QNAME) ) {
                alt130=1;
            }
            else if ( (LA130_0==NAME) ) {
                alt130=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }
            switch (alt130) {
                case 1 :
                    // parser/TCS.g:1361:302: ( (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1361:318: ( (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* ) )
                    // parser/TCS.g:1361:319: (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E45853E66411DEB7D5E1868D1505E2");
                    }
                    // parser/TCS.g:1361:378: (temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )* )
                    // parser/TCS.g:1361:380: temp= qualifiedNameSymbolList (temp= qualifiedNameSymbolList )*
                    {
                    pushFollow(FOLLOW_qualifiedNameSymbolList_in_tcs_instanceofexp7526);
                    temp=qualifiedNameSymbolList();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "supertype", temp);
                    }
                    // parser/TCS.g:1361:448: (temp= qualifiedNameSymbolList )*
                    loop129:
                    do {
                        int alt129=2;
                        int LA129_0 = input.LA(1);

                        if ( (LA129_0==QNAME) ) {
                            alt129=1;
                        }


                        switch (alt129) {
                    	case 1 :
                    	    // parser/TCS.g:1361:450: temp= qualifiedNameSymbolList
                    	    {
                    	    pushFollow(FOLLOW_qualifiedNameSymbolList_in_tcs_instanceofexp7534);
                    	    temp=qualifiedNameSymbolList();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "supertype", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop129;
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
                    // parser/TCS.g:1362:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1362:20: ( (temp= identifier ) )
                    // parser/TCS.g:1362:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E47F64E66411DEBCD3E1868D1505E2");
                    }
                    // parser/TCS.g:1362:80: (temp= identifier )
                    // parser/TCS.g:1362:82: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_instanceofexp7557);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "supertype", temp);
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
    // $ANTLR end "tcs_instanceofexp"


    // $ANTLR start "tcs_value"
    // parser/TCS.g:1370:1: tcs_value returns [Object ret2] : (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) ;
    public final Object tcs_value() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1371:3: ( (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) )
            // parser/TCS.g:1372:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            {
            // parser/TCS.g:1372:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            int alt131=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt131=1;
                }
                break;
            case INT:
                {
                alt131=2;
                }
                break;
            case MINUS:
                {
                alt131=3;
                }
                break;
            case SHARP:
                {
                alt131=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }

            switch (alt131) {
                case 1 :
                    // parser/TCS.g:1372:4: ret= tcs_stringval
                    {
                    pushFollow(FOLLOW_tcs_stringval_in_tcs_value7602);
                    ret=tcs_stringval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1373:5: ret= tcs_integerval
                    {
                    pushFollow(FOLLOW_tcs_integerval_in_tcs_value7610);
                    ret=tcs_integerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1374:5: ret= tcs_negativeintegerval
                    {
                    pushFollow(FOLLOW_tcs_negativeintegerval_in_tcs_value7618);
                    ret=tcs_negativeintegerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1375:5: ret= tcs_enumliteralval
                    {
                    pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_value7626);
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
    // parser/TCS.g:1382:1: tcs_stringval returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_stringval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1387:3: ( ( (temp= stringSymbol ) ) )
            // parser/TCS.g:1388:3: ( (temp= stringSymbol ) )
            {
            // parser/TCS.g:1388:3: ( (temp= stringSymbol ) )
            // parser/TCS.g:1388:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E4F494E66411DEC06CE1868D1505E2");
            }
            // parser/TCS.g:1388:63: (temp= stringSymbol )
            // parser/TCS.g:1388:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_stringval7660);
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
    // parser/TCS.g:1396:1: tcs_integerval returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object tcs_integerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1401:3: ( ( (temp= integerSymbol ) ) )
            // parser/TCS.g:1402:3: ( (temp= integerSymbol ) )
            {
            // parser/TCS.g:1402:3: ( (temp= integerSymbol ) )
            // parser/TCS.g:1402:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E569C2E66411DE92C5E1868D1505E2");
            }
            // parser/TCS.g:1402:63: (temp= integerSymbol )
            // parser/TCS.g:1402:65: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_integerval7707);
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
    // parser/TCS.g:1410:1: tcs_negativeintegerval returns [Object ret2] : ( MINUS (temp= integerSymbol ) ) ;
    public final Object tcs_negativeintegerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NegativeIntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1415:3: ( ( MINUS (temp= integerSymbol ) ) )
            // parser/TCS.g:1416:3: ( MINUS (temp= integerSymbol ) )
            {
            // parser/TCS.g:1416:3: ( MINUS (temp= integerSymbol ) )
            // parser/TCS.g:1416:4: MINUS (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E5B7E0E66411DEB11DE1868D1505E2");
            }
            match(input,MINUS,FOLLOW_MINUS_in_tcs_negativeintegerval7751); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E5B7E2E66411DEAED9E1868D1505E2");
            }
            // parser/TCS.g:1416:145: (temp= integerSymbol )
            // parser/TCS.g:1416:147: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_negativeintegerval7759);
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
    // parser/TCS.g:1424:1: tcs_enumliteralval returns [Object ret2] : ( SHARP (temp= identifierOrKeyword ) ) ;
    public final Object tcs_enumliteralval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1429:3: ( ( SHARP (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:1430:3: ( SHARP (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:1430:3: ( SHARP (temp= identifierOrKeyword ) )
            // parser/TCS.g:1430:4: SHARP (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E5DEF0E66411DE89BAE1868D1505E2");
            }
            match(input,SHARP,FOLLOW_SHARP_in_tcs_enumliteralval7803); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E5DEF3E66411DECA31E1868D1505E2");
            }
            // parser/TCS.g:1430:145: (temp= identifierOrKeyword )
            // parser/TCS.g:1430:147: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_enumliteralval7811);
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
    // parser/TCS.g:1438:1: tcs_token returns [Object ret2] : ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI ) ;
    public final Object tcs_token() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Token");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1443:3: ( ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI ) )
            // parser/TCS.g:1444:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI )
            {
            // parser/TCS.g:1444:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI )
            // parser/TCS.g:1444:4: ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E65420E66411DE9832E1868D1505E2");
            }
            // parser/TCS.g:1444:64: ( ( 'omitted' ) | )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==64) ) {
                alt132=1;
            }
            else if ( (LA132_0==82) ) {
                alt132=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;
            }
            switch (alt132) {
                case 1 :
                    // parser/TCS.g:1444:65: ( 'omitted' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1444:81: ( 'omitted' )
                    // parser/TCS.g:1444:82: 'omitted'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E62D13E66411DE8DC5E1868D1505E2");
                    }
                    match(input,64,FOLLOW_64_in_tcs_token7860); if (state.failed) return ret2;
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
                    // parser/TCS.g:1444:240: 
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
              _beforeSeqEl("E0DCF6CD92E65421E66411DEBFACE1868D1505E2");
            }
            match(input,82,FOLLOW_82_in_tcs_token7878); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E65423E66411DEA4B2E1868D1505E2");
            }
            // parser/TCS.g:1445:158: (temp= identifier )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==NAME) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // parser/TCS.g:1445:160: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_token7885);
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
              _beforeSeqEl("E0DCF6CD92E65424E66411DEA00EE1868D1505E2");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_token7894); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E67B30E66411DEA74EE1868D1505E2");
            }
            // parser/TCS.g:1445:369: (temp= tcs_orpattern )
            // parser/TCS.g:1445:371: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_token7902);
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
              _beforeSeqEl("E0DCF6CD92E67B31E66411DEAA52E1868D1505E2");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_token7909); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1453:1: tcs_orpattern returns [Object ret2] : ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? ) ;
    public final Object tcs_orpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OrPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1458:3: ( ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? ) )
            // parser/TCS.g:1459:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? )
            {
            // parser/TCS.g:1459:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? )
            // parser/TCS.g:1459:4: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E6C951E66411DE9945E1868D1505E2");
            }
            // parser/TCS.g:1459:63: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )?
            int alt135=2;
            switch ( input.LA(1) ) {
                case STRING:
                case LSQUARE:
                case PIPE:
                case 84:
                case 86:
                case 110:
                    {
                    alt135=1;
                    }
                    break;
                case SEMI:
                    {
                    int LA135_2 = input.LA(2);

                    if ( (synpred252_TCS()) ) {
                        alt135=1;
                    }
                    }
                    break;
                case COMA:
                    {
                    int LA135_3 = input.LA(2);

                    if ( (synpred252_TCS()) ) {
                        alt135=1;
                    }
                    }
                    break;
                case RPAREN:
                    {
                    int LA135_4 = input.LA(2);

                    if ( (synpred252_TCS()) ) {
                        alt135=1;
                    }
                    }
                    break;
                case EOF:
                    {
                    int LA135_5 = input.LA(2);

                    if ( (synpred252_TCS()) ) {
                        alt135=1;
                    }
                    }
                    break;
            }

            switch (alt135) {
                case 1 :
                    // parser/TCS.g:1459:65: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
                    {
                    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern7954);
                    temp=tcs_simplepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "simplePatterns", temp);
                    }
                    // parser/TCS.g:1459:132: ( ( PIPE ) temp= tcs_simplepattern )*
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);

                        if ( (LA134_0==PIPE) ) {
                            alt134=1;
                        }


                        switch (alt134) {
                    	case 1 :
                    	    // parser/TCS.g:1459:133: ( PIPE ) temp= tcs_simplepattern
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:1459:150: ( PIPE )
                    	    // parser/TCS.g:1459:151: PIPE
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD92E6A243E66411DEA64BE1868D1505E2");
                    	    }
                    	    match(input,PIPE,FOLLOW_PIPE_in_tcs_orpattern7963); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern7971);
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
                    	    break loop134;
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
    // parser/TCS.g:1467:1: tcs_simplepattern returns [Object ret2] : (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) ;
    public final Object tcs_simplepattern() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1468:3: ( (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) )
            // parser/TCS.g:1469:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            {
            // parser/TCS.g:1469:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            int alt136=3;
            switch ( input.LA(1) ) {
            case 84:
            case 86:
            case 110:
                {
                alt136=1;
                }
                break;
            case EOF:
            case STRING:
            case RPAREN:
            case SEMI:
            case COMA:
            case PIPE:
                {
                alt136=2;
                }
                break;
            case LSQUARE:
                {
                alt136=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }

            switch (alt136) {
                case 1 :
                    // parser/TCS.g:1469:4: ret= tcs_rulepattern
                    {
                    pushFollow(FOLLOW_tcs_rulepattern_in_tcs_simplepattern8016);
                    ret=tcs_rulepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1470:5: ret= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_simplepattern8024);
                    ret=tcs_stringpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1471:5: ret= tcs_classpattern
                    {
                    pushFollow(FOLLOW_tcs_classpattern_in_tcs_simplepattern8032);
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
    // parser/TCS.g:1478:1: tcs_rulepattern returns [Object ret2] : ( (temp= tcs_rule ) ) ;
    public final Object tcs_rulepattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RulePattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1483:3: ( ( (temp= tcs_rule ) ) )
            // parser/TCS.g:1484:3: ( (temp= tcs_rule ) )
            {
            // parser/TCS.g:1484:3: ( (temp= tcs_rule ) )
            // parser/TCS.g:1484:4: (temp= tcs_rule )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E71771E66411DEA536E1868D1505E2");
            }
            // parser/TCS.g:1484:63: (temp= tcs_rule )
            // parser/TCS.g:1484:65: temp= tcs_rule
            {
            pushFollow(FOLLOW_tcs_rule_in_tcs_rulepattern8066);
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
    // parser/TCS.g:1492:1: tcs_rule returns [Object ret2] : (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) ;
    public final Object tcs_rule() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1493:3: ( (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) )
            // parser/TCS.g:1494:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            {
            // parser/TCS.g:1494:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            int alt137=3;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt137=1;
                }
                break;
            case 86:
                {
                alt137=2;
                }
                break;
            case 110:
                {
                alt137=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }

            switch (alt137) {
                case 1 :
                    // parser/TCS.g:1494:4: ret= tcs_wordrule
                    {
                    pushFollow(FOLLOW_tcs_wordrule_in_tcs_rule8106);
                    ret=tcs_wordrule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1495:5: ret= tcs_endoflinerule
                    {
                    pushFollow(FOLLOW_tcs_endoflinerule_in_tcs_rule8114);
                    ret=tcs_endoflinerule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1496:5: ret= tcs_multilinerule
                    {
                    pushFollow(FOLLOW_tcs_multilinerule_in_tcs_rule8122);
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
    // parser/TCS.g:1503:1: tcs_wordrule returns [Object ret2] : ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN ) ;
    public final Object tcs_wordrule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","WordRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1508:3: ( ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN ) )
            // parser/TCS.g:1509:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN )
            {
            // parser/TCS.g:1509:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN )
            // parser/TCS.g:1509:4: 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E73E82E66411DE8183E1868D1505E2");
            }
            match(input,84,FOLLOW_84_in_tcs_wordrule8152); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E73E83E66411DE9F64E1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_wordrule8156); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E73E84E66411DE8738E1868D1505E2");
            }
            match(input,60,FOLLOW_60_in_tcs_wordrule8160); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E76590E66411DEB668E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8164); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E76592E66411DEC371E1868D1505E2");
            }
            // parser/TCS.g:1509:388: (temp= tcs_orpattern )
            // parser/TCS.g:1509:390: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8172);
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
              _beforeSeqEl("E0DCF6CD92E76593E66411DE9970E1868D1505E2");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_wordrule8179); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E76594E66411DEC2E8E1868D1505E2");
            }
            match(input,122,FOLLOW_122_in_tcs_wordrule8183); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E76595E66411DEA600E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8187); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E76597E66411DEA551E1868D1505E2");
            }
            // parser/TCS.g:1509:760: (temp= tcs_orpattern )
            // parser/TCS.g:1509:762: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8195);
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
              _beforeSeqEl("E0DCF6CD92E7DAC0E66411DEA532E1868D1505E2");
            }
            // parser/TCS.g:1509:891: ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==COMA) ) {
                alt138=1;
            }
            else if ( (LA138_0==RPAREN) ) {
                alt138=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }
            switch (alt138) {
                case 1 :
                    // parser/TCS.g:1509:892: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1509:908: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    // parser/TCS.g:1509:909: COMA 'end' EQ (temp= tcs_orpattern )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E7B3B0E66411DEC7ADE1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_wordrule8208); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E7B3B1E66411DE873BE1868D1505E2");
                    }
                    match(input,102,FOLLOW_102_in_tcs_wordrule8212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E7B3B2E66411DE87E6E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8216); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E7B3B4E66411DE918BE1868D1505E2");
                    }
                    // parser/TCS.g:1509:1208: (temp= tcs_orpattern )
                    // parser/TCS.g:1509:1210: temp= tcs_orpattern
                    {
                    pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8224);
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
                    // parser/TCS.g:1509:1296: 
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
              _beforeSeqEl("E0DCF6CD92E7DAC1E66411DEA335E1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_wordrule8244); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1518:1: tcs_endoflinerule returns [Object ret2] : ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) ;
    public final Object tcs_endoflinerule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EndOfLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1523:3: ( ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) )
            // parser/TCS.g:1524:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            {
            // parser/TCS.g:1524:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            // parser/TCS.g:1524:4: 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E87700E66411DE876EE1868D1505E2");
            }
            match(input,86,FOLLOW_86_in_tcs_endoflinerule8285); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E87701E66411DE9743E1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_endoflinerule8289); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E87702E66411DE8383E1868D1505E2");
            }
            match(input,60,FOLLOW_60_in_tcs_endoflinerule8293); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E87703E66411DE8530E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endoflinerule8297); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E89E15E66411DE9764E1868D1505E2");
            }
            // parser/TCS.g:1524:394: ( ( 'drop' ) | )
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==76) ) {
                alt139=1;
            }
            else if ( (LA139_0==EOF||LA139_0==STRING||LA139_0==RPAREN||LA139_0==SEMI||LA139_0==COMA||LA139_0==PIPE) ) {
                alt139=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }
            switch (alt139) {
                case 1 :
                    // parser/TCS.g:1524:395: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1524:411: ( 'drop' )
                    // parser/TCS.g:1524:412: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E89E13E66411DEC4BCE1868D1505E2");
                    }
                    match(input,76,FOLLOW_76_in_tcs_endoflinerule8307); if (state.failed) return ret2;
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
                    // parser/TCS.g:1524:567: 
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
              _beforeSeqEl("E0DCF6CD92E8C521E66411DEA28EE1868D1505E2");
            }
            // parser/TCS.g:1525:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1525:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_endoflinerule8329);
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
              _beforeSeqEl("E0DCF6CD92E8C522E66411DE9018E1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_endoflinerule8336); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1533:1: tcs_multilinerule returns [Object ret2] : ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) ;
    public final Object tcs_multilinerule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","MultiLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1538:3: ( ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) )
            // parser/TCS.g:1539:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            {
            // parser/TCS.g:1539:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            // parser/TCS.g:1539:4: 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E91340E66411DEADF1E1868D1505E2");
            }
            match(input,110,FOLLOW_110_in_tcs_multilinerule8377); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E91341E66411DE9F55E1868D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule8381); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E91342E66411DEAD95E1868D1505E2");
            }
            match(input,60,FOLLOW_60_in_tcs_multilinerule8385); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E91343E66411DE83F4E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8389); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E93A53E66411DECDE6E1868D1505E2");
            }
            // parser/TCS.g:1539:394: ( ( 'drop' ) | )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==76) ) {
                alt140=1;
            }
            else if ( (LA140_0==EOF||LA140_0==STRING||LA140_0==RPAREN||LA140_0==SEMI||LA140_0==COMA||LA140_0==PIPE) ) {
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
                    // parser/TCS.g:1539:395: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1539:411: ( 'drop' )
                    // parser/TCS.g:1539:412: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E93A51E66411DEA815E1868D1505E2");
                    }
                    match(input,76,FOLLOW_76_in_tcs_multilinerule8399); if (state.failed) return ret2;
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
                    // parser/TCS.g:1539:567: 
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
              _beforeSeqEl("E0DCF6CD92E96161E66411DE98BDE1868D1505E2");
            }
            // parser/TCS.g:1540:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1540:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8421);
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
              _beforeSeqEl("E0DCF6CD92E96162E66411DEBFA4E1868D1505E2");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8428); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E96163E66411DEBF53E1868D1505E2");
            }
            match(input,102,FOLLOW_102_in_tcs_multilinerule8432); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E96164E66411DE9746E1868D1505E2");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8436); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92E98872E66411DECB4AE1868D1505E2");
            }
            // parser/TCS.g:1540:452: ( ( 'drop' ) | )
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==76) ) {
                alt141=1;
            }
            else if ( (LA141_0==EOF||LA141_0==STRING||LA141_0==RPAREN||LA141_0==SEMI||LA141_0==COMA||LA141_0==PIPE) ) {
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
                    // parser/TCS.g:1540:453: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1540:469: ( 'drop' )
                    // parser/TCS.g:1540:470: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E98870E66411DEBFAFE1868D1505E2");
                    }
                    match(input,76,FOLLOW_76_in_tcs_multilinerule8446); if (state.failed) return ret2;
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
                    // parser/TCS.g:1540:623: 
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
              _beforeSeqEl("E0DCF6CD92E98874E66411DECA63E1868D1505E2");
            }
            // parser/TCS.g:1541:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1541:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8468);
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
              _beforeSeqEl("E0DCF6CD92EA4BC1E66411DEA106E1868D1505E2");
            }
            // parser/TCS.g:1541:210: ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | )
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==COMA) ) {
                alt145=1;
            }
            else if ( (LA145_0==RPAREN) ) {
                alt145=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;
            }
            switch (alt145) {
                case 1 :
                    // parser/TCS.g:1541:211: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1541:227: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    // parser/TCS.g:1541:228: COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E9AF83E66411DEA725E1868D1505E2");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8481); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E9AF84E66411DEBC20E1868D1505E2");
                    }
                    match(input,66,FOLLOW_66_in_tcs_multilinerule8485); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E9AF85E66411DE8606E1868D1505E2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8489); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD92E9D691E66411DE95EDE1868D1505E2");
                    }
                    // parser/TCS.g:1541:527: (temp= tcs_stringpattern )
                    // parser/TCS.g:1541:529: temp= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8497);
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
                      _beforeSeqEl("E0DCF6CD92EA24B2E66411DEBC89E1868D1505E2");
                    }
                    // parser/TCS.g:1541:661: ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    int alt144=2;
                    int LA144_0 = input.LA(1);

                    if ( (LA144_0==COMA) ) {
                        alt144=1;
                    }
                    else if ( (LA144_0==RPAREN) ) {
                        alt144=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 144, 0, input);

                        throw nvae;
                    }
                    switch (alt144) {
                        case 1 :
                            // parser/TCS.g:1541:662: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:1541:678: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            // parser/TCS.g:1541:679: COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92E9D695E66411DEC3EBE1868D1505E2");
                            }
                            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8510); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92E9D696E66411DECBF3E1868D1505E2");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule8515); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92E9FDA4E66411DEB4D6E1868D1505E2");
                            }
                            // parser/TCS.g:1541:902: (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )?
                            int alt143=2;
                            int LA143_0 = input.LA(1);

                            if ( (LA143_0==NAME||LA143_0==POINT||(LA143_0>=117 && LA143_0<=118)) ) {
                                alt143=1;
                            }
                            switch (alt143) {
                                case 1 :
                                    // parser/TCS.g:1541:904: temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )*
                                    {
                                    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule8523);
                                    temp=tcs_mapping();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "escMappings", temp);
                                    }
                                    // parser/TCS.g:1541:962: ( ( COMA ) temp= tcs_mapping )*
                                    loop142:
                                    do {
                                        int alt142=2;
                                        int LA142_0 = input.LA(1);

                                        if ( (LA142_0==COMA) ) {
                                            alt142=1;
                                        }


                                        switch (alt142) {
                                    	case 1 :
                                    	    // parser/TCS.g:1541:963: ( COMA ) temp= tcs_mapping
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _enterSepSeq();
                                    	    }
                                    	    // parser/TCS.g:1541:980: ( COMA )
                                    	    // parser/TCS.g:1541:981: COMA
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _beforeSeqEl("E0DCF6CD92E9FDA1E66411DEBFA5E1868D1505E2");
                                    	    }
                                    	    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8532); if (state.failed) return ret2;
                                    	    if ( state.backtracking==0 ) {
                                    	      _afterSeqEl();
                                    	    }

                                    	    }

                                    	    if ( state.backtracking==0 ) {
                                    	      _exitSepSeq();
                                    	    }
                                    	    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule8540);
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
                                    	    break loop142;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD92EA24B0E66411DE8F57E1868D1505E2");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule8552); if (state.failed) return ret2;
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
                            // parser/TCS.g:1541:1260: 
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
                    // parser/TCS.g:1542:35: 
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
              _beforeSeqEl("E0DCF6CD92EA72D0E66411DEAD20E1868D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule8583); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1551:1: tcs_mapping returns [Object ret2] : (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) ;
    public final Object tcs_mapping() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1552:3: ( (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) )
            // parser/TCS.g:1553:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            {
            // parser/TCS.g:1553:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            int alt146=4;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt146=1;
                }
                break;
            case POINT:
                {
                alt146=2;
                }
                break;
            case 117:
                {
                alt146=3;
                }
                break;
            case 118:
                {
                alt146=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 146, 0, input);

                throw nvae;
            }

            switch (alt146) {
                case 1 :
                    // parser/TCS.g:1553:4: ret= tcs_simplemapping
                    {
                    pushFollow(FOLLOW_tcs_simplemapping_in_tcs_mapping8621);
                    ret=tcs_simplemapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1554:5: ret= tcs_wildcardmapping
                    {
                    pushFollow(FOLLOW_tcs_wildcardmapping_in_tcs_mapping8629);
                    ret=tcs_wildcardmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1555:5: ret= tcs_octalmapping
                    {
                    pushFollow(FOLLOW_tcs_octalmapping_in_tcs_mapping8637);
                    ret=tcs_octalmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1556:5: ret= tcs_hexadecimalmapping
                    {
                    pushFollow(FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping8645);
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
    // parser/TCS.g:1563:1: tcs_simplemapping returns [Object ret2] : ( (temp= identifier ) RARROW (temp= identifier ) ) ;
    public final Object tcs_simplemapping() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SimpleMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1568:3: ( ( (temp= identifier ) RARROW (temp= identifier ) ) )
            // parser/TCS.g:1569:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            {
            // parser/TCS.g:1569:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            // parser/TCS.g:1569:4: (temp= identifier ) RARROW (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EAE801E66411DE830AE1868D1505E2");
            }
            // parser/TCS.g:1569:63: (temp= identifier )
            // parser/TCS.g:1569:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping8679);
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
              _beforeSeqEl("E0DCF6CD92EAE802E66411DE8820E1868D1505E2");
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_simplemapping8686); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EAE804E66411DEB39EE1868D1505E2");
            }
            // parser/TCS.g:1569:272: (temp= identifier )
            // parser/TCS.g:1569:274: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping8694);
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
    // parser/TCS.g:1577:1: tcs_wildcardmapping returns [Object ret2] : ( POINT RARROW POINT ) ;
    public final Object tcs_wildcardmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","WildcardMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1582:3: ( ( POINT RARROW POINT ) )
            // parser/TCS.g:1583:3: ( POINT RARROW POINT )
            {
            // parser/TCS.g:1583:3: ( POINT RARROW POINT )
            // parser/TCS.g:1583:4: POINT RARROW POINT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EB3620E66411DEA932E1868D1505E2");
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping8738); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EB3621E66411DEC1A3E1868D1505E2");
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_wildcardmapping8743); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EB3622E66411DE82AAE1868D1505E2");
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping8748); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1591:1: tcs_octalmapping returns [Object ret2] : ( 'octal' ) ;
    public final Object tcs_octalmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","OctalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1596:3: ( ( 'octal' ) )
            // parser/TCS.g:1597:3: ( 'octal' )
            {
            // parser/TCS.g:1597:3: ( 'octal' )
            // parser/TCS.g:1597:4: 'octal'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EBAB50E66411DEB2A0E1868D1505E2");
            }
            match(input,117,FOLLOW_117_in_tcs_octalmapping8789); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1605:1: tcs_hexadecimalmapping returns [Object ret2] : ( 'hex' ) ;
    public final Object tcs_hexadecimalmapping() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("TCS","HexadecimalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1610:3: ( ( 'hex' ) )
            // parser/TCS.g:1611:3: ( 'hex' )
            {
            // parser/TCS.g:1611:3: ( 'hex' )
            // parser/TCS.g:1611:4: 'hex'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EBD260E66411DE92F1E1868D1505E2");
            }
            match(input,118,FOLLOW_118_in_tcs_hexadecimalmapping8829); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1619:1: tcs_stringpattern returns [Object ret2] : ( (temp= stringSymbol )? ) ;
    public final Object tcs_stringpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1624:3: ( ( (temp= stringSymbol )? ) )
            // parser/TCS.g:1625:3: ( (temp= stringSymbol )? )
            {
            // parser/TCS.g:1625:3: ( (temp= stringSymbol )? )
            // parser/TCS.g:1625:4: (temp= stringSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EBF972E66411DEC2F6E1868D1505E2");
            }
            // parser/TCS.g:1625:63: (temp= stringSymbol )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==STRING) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // parser/TCS.g:1625:65: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_stringpattern8873);
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
    // parser/TCS.g:1633:1: tcs_classpattern returns [Object ret2] : ( LSQUARE (temp= identifier )? RSQUARE ) ;
    public final Object tcs_classpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1638:3: ( ( LSQUARE (temp= identifier )? RSQUARE ) )
            // parser/TCS.g:1639:3: ( LSQUARE (temp= identifier )? RSQUARE )
            {
            // parser/TCS.g:1639:3: ( LSQUARE (temp= identifier )? RSQUARE )
            // parser/TCS.g:1639:4: LSQUARE (temp= identifier )? RSQUARE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EC2081E66411DE8BF9E1868D1505E2");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_classpattern8919); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD92EC2083E66411DEB7F4E1868D1505E2");
            }
            // parser/TCS.g:1639:147: (temp= identifier )?
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==NAME) ) {
                alt148=1;
            }
            switch (alt148) {
                case 1 :
                    // parser/TCS.g:1639:149: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_classpattern8927);
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
              _beforeSeqEl("E0DCF6CD92EC4790E66411DE85BDE1868D1505E2");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_classpattern8936); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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

    // $ANTLR start synpred113_TCS
    public final void synpred113_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:446:159: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:446:159: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred113_TCS1768);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred113_TCS

    // $ANTLR start synpred118_TCS
    public final void synpred118_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:462:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:462:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred118_TCS1928);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred118_TCS

    // $ANTLR start synpred135_TCS
    public final void synpred135_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:506:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:506:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred135_TCS2567);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred135_TCS

    // $ANTLR start synpred146_TCS
    public final void synpred146_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:528:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:528:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred146_TCS2992);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred146_TCS

    // $ANTLR start synpred151_TCS
    public final void synpred151_TCS_fragment() throws RecognitionException {   
        Object ret = null;


        // parser/TCS.g:580:4: (ret= tcs_sequence__impl )
        // parser/TCS.g:580:4: ret= tcs_sequence__impl
        {
        pushFollow(FOLLOW_tcs_sequence__impl_in_synpred151_TCS3269);
        ret=tcs_sequence__impl();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred151_TCS

    // $ANTLR start synpred160_TCS
    public final void synpred160_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:623:1726: (temp= identifierOrKeyword )
        // parser/TCS.g:623:1726: temp= identifierOrKeyword
        {
        pushFollow(FOLLOW_identifierOrKeyword_in_synpred160_TCS3473);
        temp=identifierOrKeyword();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred160_TCS

    // $ANTLR start synpred167_TCS
    public final void synpred167_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:682:148: (temp= tcs_expression )
        // parser/TCS.g:682:148: temp= tcs_expression
        {
        pushFollow(FOLLOW_tcs_expression_in_synpred167_TCS3825);
        temp=tcs_expression();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred167_TCS

    // $ANTLR start synpred170_TCS
    public final void synpred170_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:697:150: (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )
        // parser/TCS.g:697:150: temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )*
        {
        pushFollow(FOLLOW_tcs_sequenceinalternative_in_synpred170_TCS3936);
        temp=tcs_sequenceinalternative();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // parser/TCS.g:697:220: ( ( PIPE ) temp= tcs_sequenceinalternative )*
        loop178:
        do {
            int alt178=2;
            int LA178_0 = input.LA(1);

            if ( (LA178_0==PIPE) ) {
                alt178=1;
            }


            switch (alt178) {
        	case 1 :
        	    // parser/TCS.g:697:221: ( PIPE ) temp= tcs_sequenceinalternative
        	    {
        	    // parser/TCS.g:697:238: ( PIPE )
        	    // parser/TCS.g:697:239: PIPE
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("E0DCF6CD92B2E810E66411DEAC24E1868D1505E2");
        	    }
        	    match(input,PIPE,FOLLOW_PIPE_in_synpred170_TCS3945); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_tcs_sequenceinalternative_in_synpred170_TCS3953);
        	    temp=tcs_sequenceinalternative();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop178;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred170_TCS

    // $ANTLR start synpred182_TCS
    public final void synpred182_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:806:375: ( ( COMA 'mode' EQ (temp= stringSymbol ) ) )
        // parser/TCS.g:806:375: ( COMA 'mode' EQ (temp= stringSymbol ) )
        {
        if ( state.backtracking==0 ) {
          _enterAlt(0);
        }
        // parser/TCS.g:806:391: ( COMA 'mode' EQ (temp= stringSymbol ) )
        // parser/TCS.g:806:392: COMA 'mode' EQ (temp= stringSymbol )
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl("E0DCF6CD92B83F43E66411DE93EAE1868D1505E2");
        }
        match(input,COMA,FOLLOW_COMA_in_synpred182_TCS4605); if (state.failed) return ;
        match(input,115,FOLLOW_115_in_synpred182_TCS4609); if (state.failed) return ;
        match(input,EQ,FOLLOW_EQ_in_synpred182_TCS4613); if (state.failed) return ;
        // parser/TCS.g:806:692: (temp= stringSymbol )
        // parser/TCS.g:806:694: temp= stringSymbol
        {
        pushFollow(FOLLOW_stringSymbol_in_synpred182_TCS4621);
        temp=stringSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred182_TCS

    // $ANTLR start synpred189_TCS
    public final void synpred189_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:824:235: ( ( (temp= qualifiedNameSymbol )? ) )
        // parser/TCS.g:824:235: ( (temp= qualifiedNameSymbol )? )
        {
        if ( state.backtracking==0 ) {
          _enterAlt(0);
        }
        // parser/TCS.g:824:251: ( (temp= qualifiedNameSymbol )? )
        // parser/TCS.g:824:252: (temp= qualifiedNameSymbol )?
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl("E0DCF6CD92BB2574E66411DEB81DE1868D1505E2");
        }
        // parser/TCS.g:824:311: (temp= qualifiedNameSymbol )?
        int alt184=2;
        int LA184_0 = input.LA(1);

        if ( (LA184_0==QNAME) ) {
            alt184=1;
        }
        switch (alt184) {
            case 1 :
                // parser/TCS.g:824:313: temp= qualifiedNameSymbol
                {
                pushFollow(FOLLOW_qualifiedNameSymbol_in_synpred189_TCS4839);
                temp=qualifiedNameSymbol();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred189_TCS

    // $ANTLR start synpred252_TCS
    public final void synpred252_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:1459:65: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )
        // parser/TCS.g:1459:65: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
        {
        pushFollow(FOLLOW_tcs_simplepattern_in_synpred252_TCS7954);
        temp=tcs_simplepattern();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // parser/TCS.g:1459:132: ( ( PIPE ) temp= tcs_simplepattern )*
        loop193:
        do {
            int alt193=2;
            int LA193_0 = input.LA(1);

            if ( (LA193_0==PIPE) ) {
                alt193=1;
            }


            switch (alt193) {
        	case 1 :
        	    // parser/TCS.g:1459:133: ( PIPE ) temp= tcs_simplepattern
        	    {
        	    // parser/TCS.g:1459:150: ( PIPE )
        	    // parser/TCS.g:1459:151: PIPE
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("E0DCF6CD92E6A243E66411DEA64BE1868D1505E2");
        	    }
        	    match(input,PIPE,FOLLOW_PIPE_in_synpred252_TCS7963); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_tcs_simplepattern_in_synpred252_TCS7971);
        	    temp=tcs_simplepattern();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop193;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred252_TCS

    // Delegated rules

    public final boolean synpred252_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred252_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred189_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred189_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred151_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred151_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred182_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred182_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred146_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred146_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred170_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred170_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred167_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred167_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred160_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred160_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred118_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_TCS_fragment(); // can never throw exception
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
    protected DFA128 dfa128 = new DFA128(this);
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
        "\1\uffff\1\6\1\10\1\11\1\14\1\7\1\5\1\12\1\3\1\13\1\0\1\4\1\1\1"+
        "\2\2\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\14\50\uffff\1\1\11\uffff\1\11\3\uffff\1\4\5\uffff\1\6\7"+
            "\uffff\1\12\13\uffff\1\10\14\uffff\1\5\13\uffff\1\2\1\7\7\uffff"+
            "\1\3\3\uffff\1\13",
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
            return "446:157: (temp= textblockdefinition_textblockdefinition )?";
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
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_12 = input.LA(1);

                         
                        int index27_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_13 = input.LA(1);

                         
                        int index27_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_8 = input.LA(1);

                         
                        int index27_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA27_6 = input.LA(1);

                         
                        int index27_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA27_5 = input.LA(1);

                         
                        int index27_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_5);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA27_2 = input.LA(1);

                         
                        int index27_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_2);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA27_3 = input.LA(1);

                         
                        int index27_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA27_7 = input.LA(1);

                         
                        int index27_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_7);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA27_9 = input.LA(1);

                         
                        int index27_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA27_4 = input.LA(1);

                         
                        int index27_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred113_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index27_4);
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
        "\1\uffff\1\6\1\10\1\11\1\14\1\7\1\5\1\12\1\2\1\13\1\0\1\4\1\1\1"+
        "\3\2\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\14\50\uffff\1\1\11\uffff\1\11\3\uffff\1\4\5\uffff\1\6\7"+
            "\uffff\1\12\13\uffff\1\10\14\uffff\1\5\13\uffff\1\2\1\7\7\uffff"+
            "\1\3\3\uffff\1\13",
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
            return "462:76: (temp= textblockdefinition_textblockdefinition )?";
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
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA32_12 = input.LA(1);

                         
                        int index32_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA32_8 = input.LA(1);

                         
                        int index32_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA32_13 = input.LA(1);

                         
                        int index32_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_13);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA32_11 = input.LA(1);

                         
                        int index32_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA32_6 = input.LA(1);

                         
                        int index32_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA32_1 = input.LA(1);

                         
                        int index32_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_1);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA32_5 = input.LA(1);

                         
                        int index32_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_5);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA32_2 = input.LA(1);

                         
                        int index32_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_2);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA32_3 = input.LA(1);

                         
                        int index32_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA32_7 = input.LA(1);

                         
                        int index32_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_7);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA32_9 = input.LA(1);

                         
                        int index32_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA32_4 = input.LA(1);

                         
                        int index32_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred118_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index32_4);
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
        "\1\uffff\1\6\1\10\1\11\1\14\1\7\1\5\1\12\1\3\1\13\1\0\1\4\1\1\1"+
        "\2\2\uffff}>";
    static final String[] DFA49_transitionS = {
            "\1\14\50\uffff\1\1\11\uffff\1\11\3\uffff\1\4\5\uffff\1\6\7"+
            "\uffff\1\12\13\uffff\1\10\14\uffff\1\5\13\uffff\1\2\1\7\7\uffff"+
            "\1\3\3\uffff\1\13",
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
            return "506:76: (temp= textblockdefinition_textblockdefinition )?";
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
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA49_12 = input.LA(1);

                         
                        int index49_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA49_13 = input.LA(1);

                         
                        int index49_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA49_8 = input.LA(1);

                         
                        int index49_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_8);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA49_11 = input.LA(1);

                         
                        int index49_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA49_6 = input.LA(1);

                         
                        int index49_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA49_1 = input.LA(1);

                         
                        int index49_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_1);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA49_5 = input.LA(1);

                         
                        int index49_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_5);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA49_2 = input.LA(1);

                         
                        int index49_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_2);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA49_3 = input.LA(1);

                         
                        int index49_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA49_7 = input.LA(1);

                         
                        int index49_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_7);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA49_9 = input.LA(1);

                         
                        int index49_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA49_4 = input.LA(1);

                         
                        int index49_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred135_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index49_4);
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
        "\1\uffff\1\6\1\10\1\11\1\14\1\7\1\5\1\12\1\2\1\13\1\0\1\4\1\1\1"+
        "\3\2\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\14\50\uffff\1\1\11\uffff\1\11\3\uffff\1\4\5\uffff\1\6\7"+
            "\uffff\1\12\13\uffff\1\10\14\uffff\1\5\13\uffff\1\2\1\7\7\uffff"+
            "\1\3\3\uffff\1\13",
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
            return "528:76: (temp= textblockdefinition_textblockdefinition )?";
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
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA60_12 = input.LA(1);

                         
                        int index60_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA60_8 = input.LA(1);

                         
                        int index60_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA60_13 = input.LA(1);

                         
                        int index60_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_13);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA60_11 = input.LA(1);

                         
                        int index60_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA60_6 = input.LA(1);

                         
                        int index60_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA60_1 = input.LA(1);

                         
                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA60_5 = input.LA(1);

                         
                        int index60_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_5);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA60_2 = input.LA(1);

                         
                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_2);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA60_3 = input.LA(1);

                         
                        int index60_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_3);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA60_7 = input.LA(1);

                         
                        int index60_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_7);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA60_9 = input.LA(1);

                         
                        int index60_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_9);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA60_4 = input.LA(1);

                         
                        int index60_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred146_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index60_4);
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
        "\1\u0087\145\0\2\uffff";
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
            "\1\2\1\1\3\uffff\1\133\1\uffff\1\142\1\uffff\1\144\1\140\1"+
            "\130\1\137\1\143\1\uffff\1\131\1\uffff\1\132\1\141\1\uffff\1"+
            "\134\3\uffff\1\135\1\136\22\uffff\1\13\3\uffff\1\3\1\4\1\5\1"+
            "\6\1\7\1\10\1\11\1\12\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
            "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
            "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
            "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67"+
            "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1"+
            "\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1"+
            "\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1"+
            "\127",
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
            return "580:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )";
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
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_2 = input.LA(1);

                         
                        int index65_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_3 = input.LA(1);

                         
                        int index65_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA65_4 = input.LA(1);

                         
                        int index65_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA65_5 = input.LA(1);

                         
                        int index65_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA65_6 = input.LA(1);

                         
                        int index65_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA65_7 = input.LA(1);

                         
                        int index65_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA65_8 = input.LA(1);

                         
                        int index65_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA65_9 = input.LA(1);

                         
                        int index65_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA65_10 = input.LA(1);

                         
                        int index65_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA65_11 = input.LA(1);

                         
                        int index65_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA65_12 = input.LA(1);

                         
                        int index65_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA65_13 = input.LA(1);

                         
                        int index65_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA65_14 = input.LA(1);

                         
                        int index65_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA65_15 = input.LA(1);

                         
                        int index65_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA65_16 = input.LA(1);

                         
                        int index65_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA65_17 = input.LA(1);

                         
                        int index65_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA65_18 = input.LA(1);

                         
                        int index65_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA65_19 = input.LA(1);

                         
                        int index65_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA65_20 = input.LA(1);

                         
                        int index65_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA65_21 = input.LA(1);

                         
                        int index65_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA65_22 = input.LA(1);

                         
                        int index65_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA65_23 = input.LA(1);

                         
                        int index65_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA65_24 = input.LA(1);

                         
                        int index65_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA65_25 = input.LA(1);

                         
                        int index65_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA65_26 = input.LA(1);

                         
                        int index65_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA65_27 = input.LA(1);

                         
                        int index65_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA65_28 = input.LA(1);

                         
                        int index65_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA65_29 = input.LA(1);

                         
                        int index65_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA65_30 = input.LA(1);

                         
                        int index65_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA65_31 = input.LA(1);

                         
                        int index65_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA65_32 = input.LA(1);

                         
                        int index65_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_32);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA65_33 = input.LA(1);

                         
                        int index65_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_33);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA65_34 = input.LA(1);

                         
                        int index65_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_34);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA65_35 = input.LA(1);

                         
                        int index65_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_35);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA65_36 = input.LA(1);

                         
                        int index65_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_36);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA65_37 = input.LA(1);

                         
                        int index65_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_37);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA65_38 = input.LA(1);

                         
                        int index65_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_38);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA65_39 = input.LA(1);

                         
                        int index65_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_39);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA65_40 = input.LA(1);

                         
                        int index65_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_40);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA65_41 = input.LA(1);

                         
                        int index65_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_41);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA65_42 = input.LA(1);

                         
                        int index65_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_42);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA65_43 = input.LA(1);

                         
                        int index65_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_43);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA65_44 = input.LA(1);

                         
                        int index65_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA65_45 = input.LA(1);

                         
                        int index65_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_45);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA65_46 = input.LA(1);

                         
                        int index65_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_46);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA65_47 = input.LA(1);

                         
                        int index65_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_47);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA65_48 = input.LA(1);

                         
                        int index65_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_48);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA65_49 = input.LA(1);

                         
                        int index65_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_49);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA65_50 = input.LA(1);

                         
                        int index65_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_50);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA65_51 = input.LA(1);

                         
                        int index65_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_51);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA65_52 = input.LA(1);

                         
                        int index65_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_52);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA65_53 = input.LA(1);

                         
                        int index65_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_53);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA65_54 = input.LA(1);

                         
                        int index65_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_54);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA65_55 = input.LA(1);

                         
                        int index65_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_55);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA65_56 = input.LA(1);

                         
                        int index65_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_56);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA65_57 = input.LA(1);

                         
                        int index65_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_57);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA65_58 = input.LA(1);

                         
                        int index65_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_58);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA65_59 = input.LA(1);

                         
                        int index65_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_59);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA65_60 = input.LA(1);

                         
                        int index65_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_60);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA65_61 = input.LA(1);

                         
                        int index65_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_61);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA65_62 = input.LA(1);

                         
                        int index65_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_62);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA65_63 = input.LA(1);

                         
                        int index65_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_63);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA65_64 = input.LA(1);

                         
                        int index65_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_64);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA65_65 = input.LA(1);

                         
                        int index65_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_65);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA65_66 = input.LA(1);

                         
                        int index65_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_66);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA65_67 = input.LA(1);

                         
                        int index65_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_67);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA65_68 = input.LA(1);

                         
                        int index65_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_68);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA65_69 = input.LA(1);

                         
                        int index65_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_69);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA65_70 = input.LA(1);

                         
                        int index65_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_70);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA65_71 = input.LA(1);

                         
                        int index65_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_71);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA65_72 = input.LA(1);

                         
                        int index65_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_72);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA65_73 = input.LA(1);

                         
                        int index65_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_73);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA65_74 = input.LA(1);

                         
                        int index65_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_74);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA65_75 = input.LA(1);

                         
                        int index65_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_75);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA65_76 = input.LA(1);

                         
                        int index65_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_76);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA65_77 = input.LA(1);

                         
                        int index65_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_77);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA65_78 = input.LA(1);

                         
                        int index65_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_78);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA65_79 = input.LA(1);

                         
                        int index65_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_79);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA65_80 = input.LA(1);

                         
                        int index65_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_80);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA65_81 = input.LA(1);

                         
                        int index65_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_81);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA65_82 = input.LA(1);

                         
                        int index65_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_82);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA65_83 = input.LA(1);

                         
                        int index65_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_83);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA65_84 = input.LA(1);

                         
                        int index65_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_84);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA65_85 = input.LA(1);

                         
                        int index65_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_85);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA65_86 = input.LA(1);

                         
                        int index65_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_86);
                        if ( s>=0 ) return s;
                        break;
                    case 86 : 
                        int LA65_87 = input.LA(1);

                         
                        int index65_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_87);
                        if ( s>=0 ) return s;
                        break;
                    case 87 : 
                        int LA65_88 = input.LA(1);

                         
                        int index65_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_88);
                        if ( s>=0 ) return s;
                        break;
                    case 88 : 
                        int LA65_89 = input.LA(1);

                         
                        int index65_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_89);
                        if ( s>=0 ) return s;
                        break;
                    case 89 : 
                        int LA65_90 = input.LA(1);

                         
                        int index65_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_90);
                        if ( s>=0 ) return s;
                        break;
                    case 90 : 
                        int LA65_91 = input.LA(1);

                         
                        int index65_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_91);
                        if ( s>=0 ) return s;
                        break;
                    case 91 : 
                        int LA65_92 = input.LA(1);

                         
                        int index65_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_92);
                        if ( s>=0 ) return s;
                        break;
                    case 92 : 
                        int LA65_93 = input.LA(1);

                         
                        int index65_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_93);
                        if ( s>=0 ) return s;
                        break;
                    case 93 : 
                        int LA65_94 = input.LA(1);

                         
                        int index65_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_94);
                        if ( s>=0 ) return s;
                        break;
                    case 94 : 
                        int LA65_95 = input.LA(1);

                         
                        int index65_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_95);
                        if ( s>=0 ) return s;
                        break;
                    case 95 : 
                        int LA65_96 = input.LA(1);

                         
                        int index65_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_96);
                        if ( s>=0 ) return s;
                        break;
                    case 96 : 
                        int LA65_97 = input.LA(1);

                         
                        int index65_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_97);
                        if ( s>=0 ) return s;
                        break;
                    case 97 : 
                        int LA65_98 = input.LA(1);

                         
                        int index65_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_98);
                        if ( s>=0 ) return s;
                        break;
                    case 98 : 
                        int LA65_99 = input.LA(1);

                         
                        int index65_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_99);
                        if ( s>=0 ) return s;
                        break;
                    case 99 : 
                        int LA65_100 = input.LA(1);

                         
                        int index65_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

                        else if ( (true) ) {s = 103;}

                         
                        input.seek(index65_100);
                        if ( s>=0 ) return s;
                        break;
                    case 100 : 
                        int LA65_101 = input.LA(1);

                         
                        int index65_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred151_TCS()) ) {s = 102;}

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
        "\1\u0087\126\0\2\uffff";
    static final String DFA67_acceptS =
        "\127\uffff\1\2\1\1";
    static final String DFA67_specialS =
        "\1\uffff\1\11\1\20\1\7\1\75\1\46\1\115\1\47\1\33\1\62\1\13\1\60"+
        "\1\40\1\42\1\112\1\43\1\113\1\5\1\64\1\3\1\63\1\44\1\116\1\45\1"+
        "\117\1\120\1\54\1\121\1\55\1\4\1\107\1\24\1\106\1\2\1\122\1\51\1"+
        "\123\1\0\1\105\1\22\1\104\1\1\1\52\1\124\1\53\1\10\1\67\1\27\1\103"+
        "\1\6\1\66\1\56\1\125\1\12\1\70\1\37\1\110\1\14\1\71\1\111\1\41\1"+
        "\36\1\102\1\35\1\61\1\32\1\101\1\34\1\114\1\26\1\73\1\25\1\57\1"+
        "\30\1\100\1\31\1\50\1\21\1\77\1\17\1\76\1\15\1\72\1\16\1\74\1\23"+
        "\1\65\2\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\1\1\127\3\uffff\11\127\1\uffff\1\127\1\uffff\6\127\1\uffff"+
            "\2\127\1\uffff\1\127\20\uffff\1\12\3\uffff\1\2\1\3\1\4\1\5\1"+
            "\6\1\7\1\10\1\11\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
            "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
            "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
            "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67"+
            "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1"+
            "\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1"+
            "\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126",
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
            return "623:1724: (temp= identifierOrKeyword )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA67_37 = input.LA(1);

                         
                        int index67_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_37);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA67_41 = input.LA(1);

                         
                        int index67_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_41);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA67_33 = input.LA(1);

                         
                        int index67_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_33);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA67_19 = input.LA(1);

                         
                        int index67_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_19);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA67_29 = input.LA(1);

                         
                        int index67_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_29);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA67_17 = input.LA(1);

                         
                        int index67_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_17);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA67_49 = input.LA(1);

                         
                        int index67_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_49);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA67_3 = input.LA(1);

                         
                        int index67_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_3);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA67_45 = input.LA(1);

                         
                        int index67_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_45);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA67_53 = input.LA(1);

                         
                        int index67_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_53);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA67_10 = input.LA(1);

                         
                        int index67_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_10);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA67_57 = input.LA(1);

                         
                        int index67_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_57);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA67_81 = input.LA(1);

                         
                        int index67_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_81);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA67_83 = input.LA(1);

                         
                        int index67_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_83);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA67_79 = input.LA(1);

                         
                        int index67_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_79);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA67_77 = input.LA(1);

                         
                        int index67_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_77);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA67_39 = input.LA(1);

                         
                        int index67_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_39);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA67_85 = input.LA(1);

                         
                        int index67_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_85);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA67_31 = input.LA(1);

                         
                        int index67_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_31);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA67_71 = input.LA(1);

                         
                        int index67_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_71);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA67_69 = input.LA(1);

                         
                        int index67_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_69);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA67_47 = input.LA(1);

                         
                        int index67_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_47);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA67_73 = input.LA(1);

                         
                        int index67_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_73);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA67_75 = input.LA(1);

                         
                        int index67_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_75);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA67_65 = input.LA(1);

                         
                        int index67_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_65);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA67_8 = input.LA(1);

                         
                        int index67_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_8);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA67_67 = input.LA(1);

                         
                        int index67_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_67);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA67_63 = input.LA(1);

                         
                        int index67_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_63);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA67_61 = input.LA(1);

                         
                        int index67_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_61);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA67_55 = input.LA(1);

                         
                        int index67_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_55);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA67_12 = input.LA(1);

                         
                        int index67_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_12);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA67_60 = input.LA(1);

                         
                        int index67_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_60);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA67_13 = input.LA(1);

                         
                        int index67_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_13);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA67_15 = input.LA(1);

                         
                        int index67_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_15);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA67_21 = input.LA(1);

                         
                        int index67_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_21);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA67_23 = input.LA(1);

                         
                        int index67_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_23);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA67_5 = input.LA(1);

                         
                        int index67_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_5);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA67_7 = input.LA(1);

                         
                        int index67_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_7);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA67_76 = input.LA(1);

                         
                        int index67_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_76);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA67_35 = input.LA(1);

                         
                        int index67_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_35);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA67_42 = input.LA(1);

                         
                        int index67_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_42);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA67_44 = input.LA(1);

                         
                        int index67_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_44);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA67_26 = input.LA(1);

                         
                        int index67_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_26);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA67_28 = input.LA(1);

                         
                        int index67_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_28);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA67_51 = input.LA(1);

                         
                        int index67_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_51);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA67_72 = input.LA(1);

                         
                        int index67_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_72);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA67_11 = input.LA(1);

                         
                        int index67_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_11);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA67_64 = input.LA(1);

                         
                        int index67_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_64);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA67_9 = input.LA(1);

                         
                        int index67_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_9);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA67_20 = input.LA(1);

                         
                        int index67_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_20);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA67_18 = input.LA(1);

                         
                        int index67_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_18);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA67_86 = input.LA(1);

                         
                        int index67_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_86);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA67_50 = input.LA(1);

                         
                        int index67_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_50);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA67_46 = input.LA(1);

                         
                        int index67_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_46);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA67_54 = input.LA(1);

                         
                        int index67_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_54);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA67_58 = input.LA(1);

                         
                        int index67_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_58);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA67_82 = input.LA(1);

                         
                        int index67_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_82);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA67_70 = input.LA(1);

                         
                        int index67_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_70);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA67_84 = input.LA(1);

                         
                        int index67_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_84);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA67_4 = input.LA(1);

                         
                        int index67_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_4);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA67_80 = input.LA(1);

                         
                        int index67_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_80);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA67_78 = input.LA(1);

                         
                        int index67_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_78);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA67_74 = input.LA(1);

                         
                        int index67_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_74);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA67_66 = input.LA(1);

                         
                        int index67_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_66);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA67_62 = input.LA(1);

                         
                        int index67_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_62);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA67_48 = input.LA(1);

                         
                        int index67_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_48);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA67_40 = input.LA(1);

                         
                        int index67_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_40);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA67_38 = input.LA(1);

                         
                        int index67_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_38);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA67_32 = input.LA(1);

                         
                        int index67_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_32);
                        if ( s>=0 ) return s;
                        break;
                    case 71 : 
                        int LA67_30 = input.LA(1);

                         
                        int index67_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_30);
                        if ( s>=0 ) return s;
                        break;
                    case 72 : 
                        int LA67_56 = input.LA(1);

                         
                        int index67_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_56);
                        if ( s>=0 ) return s;
                        break;
                    case 73 : 
                        int LA67_59 = input.LA(1);

                         
                        int index67_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_59);
                        if ( s>=0 ) return s;
                        break;
                    case 74 : 
                        int LA67_14 = input.LA(1);

                         
                        int index67_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_14);
                        if ( s>=0 ) return s;
                        break;
                    case 75 : 
                        int LA67_16 = input.LA(1);

                         
                        int index67_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_16);
                        if ( s>=0 ) return s;
                        break;
                    case 76 : 
                        int LA67_68 = input.LA(1);

                         
                        int index67_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_68);
                        if ( s>=0 ) return s;
                        break;
                    case 77 : 
                        int LA67_6 = input.LA(1);

                         
                        int index67_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_6);
                        if ( s>=0 ) return s;
                        break;
                    case 78 : 
                        int LA67_22 = input.LA(1);

                         
                        int index67_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_22);
                        if ( s>=0 ) return s;
                        break;
                    case 79 : 
                        int LA67_24 = input.LA(1);

                         
                        int index67_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_24);
                        if ( s>=0 ) return s;
                        break;
                    case 80 : 
                        int LA67_25 = input.LA(1);

                         
                        int index67_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_25);
                        if ( s>=0 ) return s;
                        break;
                    case 81 : 
                        int LA67_27 = input.LA(1);

                         
                        int index67_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_27);
                        if ( s>=0 ) return s;
                        break;
                    case 82 : 
                        int LA67_34 = input.LA(1);

                         
                        int index67_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_34);
                        if ( s>=0 ) return s;
                        break;
                    case 83 : 
                        int LA67_36 = input.LA(1);

                         
                        int index67_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_36);
                        if ( s>=0 ) return s;
                        break;
                    case 84 : 
                        int LA67_43 = input.LA(1);

                         
                        int index67_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_43);
                        if ( s>=0 ) return s;
                        break;
                    case 85 : 
                        int LA67_52 = input.LA(1);

                         
                        int index67_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred160_TCS()) ) {s = 88;}

                        else if ( (true) ) {s = 87;}

                         
                        input.seek(index67_52);
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
        "\1\4\126\12\3\4\126\12\3\uffff";
    static final String DFA85_maxS =
        "\1\u0087\126\37\1\u0087\2\147\126\37\3\uffff";
    static final String DFA85_acceptS =
        "\u00b0\uffff\1\3\1\1\1\2";
    static final String DFA85_specialS =
        "\u00b3\uffff}>";
    static final String[] DFA85_transitionS = {
            "\1\1\12\uffff\1\127\40\uffff\1\12\3\uffff\1\2\1\3\1\4\1\5\1"+
            "\6\1\7\1\10\1\11\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
            "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
            "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
            "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67"+
            "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1"+
            "\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1"+
            "\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\132\5\uffff\1\131\24\uffff\1\130\20\uffff\1\143\3\uffff"+
            "\1\133\1\134\1\135\1\136\1\137\1\140\1\141\1\142\1\144\1\145"+
            "\1\146\1\147\1\150\1\151\1\152\1\153\1\154\1\155\1\156\1\157"+
            "\1\160\1\161\1\162\1\163\1\164\1\165\1\166\1\167\1\170\1\171"+
            "\1\172\1\173\1\174\1\175\1\176\1\177\1\u0080\1\u0081\1\u0082"+
            "\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087\1\u0088\1\u0089\1\u008a"+
            "\1\u008b\1\u008c\1\u008d\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092"+
            "\1\u0093\1\u0094\1\u0095\1\u0096\1\u0097\1\u0098\1\u0099\1\u009a"+
            "\1\u009b\1\u009c\1\u009d\1\u009e\1\u009f\1\u00a0\1\u00a1\1\u00a2"+
            "\1\u00a3\1\u00a4\1\u00a5\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa"+
            "\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00b1\103\uffff\1\u00b0\36\uffff\1\u00b2",
            "\1\u00b1\103\uffff\1\u00b0\36\uffff\1\u00b2",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
            "\1\131\24\uffff\1\130",
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
            return "760:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )";
        }
    }
    static final String DFA128_eotS =
        "\u00b4\uffff";
    static final String DFA128_eofS =
        "\1\uffff\127\131\5\uffff\127\131";
    static final String DFA128_minS =
        "\1\4\4\12\2\11\120\12\1\4\5\uffff\1\12\1\4\34\12\1\4\67\12\1\4";
    static final String DFA128_maxS =
        "\1\u0087\126\120\1\u0087\5\uffff\36\120\1\u0087\70\120";
    static final String DFA128_acceptS =
        "\130\uffff\1\5\1\2\1\1\1\3\1\4\127\uffff";
    static final String DFA128_specialS =
        "\u00b4\uffff}>";
    static final String[] DFA128_transitionS = {
            "\1\1\12\uffff\1\127\40\uffff\1\12\3\uffff\1\2\1\3\1\4\1\5\1"+
            "\6\1\7\1\10\1\11\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
            "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37"+
            "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53"+
            "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67"+
            "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1"+
            "\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1"+
            "\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\133\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\134\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\135\5\uffff\1\132\14\uffff\1\131\30\uffff\1\146\3\uffff"+
            "\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1\145\1\147\1\150"+
            "\1\151\1\152\1\153\1\154\1\155\1\156\1\157\1\160\1\161\1\162"+
            "\1\163\1\164\1\165\1\166\1\167\1\170\1\171\1\172\1\173\1\174"+
            "\1\175\1\176\1\177\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084\1"+
            "\u0085\1\u0086\1\u0087\1\u0088\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008d\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\u0094"+
            "\1\u0095\1\u0096\1\u0097\1\u0098\1\u0099\1\u009a\1\u009b\1\u009c"+
            "\1\u009d\1\u009e\1\u009f\1\u00a0\1\u00a1\1\u00a2\1\u00a3\1\u00a4"+
            "\1\u00a5\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa\1\u00ab\1\u00ac"+
            "\1\u00ad\1\u00ae\1\u00af\1\u00b0\1\u00b1\1\u00b2",
            "",
            "",
            "",
            "",
            "",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\130\3\uffff\1\130\1\uffff\1\132\14\uffff\1\131\34\uffff"+
            "\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\131\5\uffff\1\132\4\uffff\1\131\7\uffff\1\131\30\uffff"+
            "\1\131\3\uffff\1\u00b3\123\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\132\14\uffff\1\131\34\uffff\1\130\33\uffff\1\131",
            "\1\130\3\uffff\1\130\1\uffff\1\131\14\uffff\1\131\34\uffff"+
            "\1\131\33\uffff\1\131"
    };

    static final short[] DFA128_eot = DFA.unpackEncodedString(DFA128_eotS);
    static final short[] DFA128_eof = DFA.unpackEncodedString(DFA128_eofS);
    static final char[] DFA128_min = DFA.unpackEncodedStringToUnsignedChars(DFA128_minS);
    static final char[] DFA128_max = DFA.unpackEncodedStringToUnsignedChars(DFA128_maxS);
    static final short[] DFA128_accept = DFA.unpackEncodedString(DFA128_acceptS);
    static final short[] DFA128_special = DFA.unpackEncodedString(DFA128_specialS);
    static final short[][] DFA128_transition;

    static {
        int numStates = DFA128_transitionS.length;
        DFA128_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA128_transition[i] = DFA.unpackEncodedString(DFA128_transitionS[i]);
        }
    }

    class DFA128 extends DFA {

        public DFA128(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 128;
            this.eot = DFA128_eot;
            this.eof = DFA128_eof;
            this.min = DFA128_min;
            this.max = DFA128_max;
            this.accept = DFA128_accept;
            this.special = DFA128_special;
            this.transition = DFA128_transition;
        }
        public String getDescription() {
            return "1288:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )";
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_identifierOrKeyword140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_identifierOrKeyword148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_identifierOrKeyword156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_identifierOrKeyword164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORKEYWORD_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_identifierOrKeyword180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_identifierOrKeyword188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_identifierOrKeyword196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_identifierOrKeyword204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_identifierOrKeyword212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifierOrKeyword220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_identifierOrKeyword228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_identifierOrKeyword236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_identifierOrKeyword244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_identifierOrKeyword252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_identifierOrKeyword260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_identifierOrKeyword268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_identifierOrKeyword276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_identifierOrKeyword284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_identifierOrKeyword292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_identifierOrKeyword300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_identifierOrKeyword308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_identifierOrKeyword316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_identifierOrKeyword324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_identifierOrKeyword332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_identifierOrKeyword340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_identifierOrKeyword348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_identifierOrKeyword356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_identifierOrKeyword364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_identifierOrKeyword372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_identifierOrKeyword380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_identifierOrKeyword388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_identifierOrKeyword396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_identifierOrKeyword404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_identifierOrKeyword412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_identifierOrKeyword420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_identifierOrKeyword428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_identifierOrKeyword436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_identifierOrKeyword444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_identifierOrKeyword452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_identifierOrKeyword460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_identifierOrKeyword468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_identifierOrKeyword476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_identifierOrKeyword484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_identifierOrKeyword492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_identifierOrKeyword500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_identifierOrKeyword508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_identifierOrKeyword516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_identifierOrKeyword524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_identifierOrKeyword532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_identifierOrKeyword540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_identifierOrKeyword548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_identifierOrKeyword556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_identifierOrKeyword564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_identifierOrKeyword572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_identifierOrKeyword580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_identifierOrKeyword588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_identifierOrKeyword596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_identifierOrKeyword604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_identifierOrKeyword612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_identifierOrKeyword620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_identifierOrKeyword628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_identifierOrKeyword636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_identifierOrKeyword644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_identifierOrKeyword652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_identifierOrKeyword660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_identifierOrKeyword668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_identifierOrKeyword676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_identifierOrKeyword684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_identifierOrKeyword692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_identifierOrKeyword700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_identifierOrKeyword708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_identifierOrKeyword716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_identifierOrKeyword724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_identifierOrKeyword732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_identifierOrKeyword740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_identifierOrKeyword748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_identifierOrKeyword756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_identifierOrKeyword764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_identifierOrKeyword772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_identifierOrKeyword780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qualifiedNameSymbol904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qualifiedNameSymbolList935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_concretesyntax_in_main1000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_tcs_concretesyntax1034 = new BitSet(new long[]{0x0000000000001210L});
    public static final BitSet FOLLOW_identifier_in_tcs_concretesyntax1041 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_concretesyntax1056 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_tcs_concretesyntax1060 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1064 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_concretesyntax1072 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_concretesyntax1079 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1097 = new BitSet(new long[]{0x0040000000002000L,0x0180080040040411L,0x0000000000000011L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax1108 = new BitSet(new long[]{0x0040000000002000L,0x0180080040040411L,0x0000000000000011L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax1116 = new BitSet(new long[]{0x0040000000002000L,0x0180080040040411L,0x0000000000000011L});
    public static final BitSet FOLLOW_74_in_tcs_concretesyntax1133 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1137 = new BitSet(new long[]{0x0000000000002410L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax1148 = new BitSet(new long[]{0x0000000000002410L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax1156 = new BitSet(new long[]{0x0000000000002410L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1171 = new BitSet(new long[]{0x0000000000002000L,0x0100000040040001L,0x0000000000000010L});
    public static final BitSet FOLLOW_120_in_tcs_concretesyntax1194 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1198 = new BitSet(new long[]{0x0000000000002410L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1209 = new BitSet(new long[]{0x0000000000002410L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1217 = new BitSet(new long[]{0x0000000000002410L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1232 = new BitSet(new long[]{0x0000000000002000L,0x0000000040040001L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1253 = new BitSet(new long[]{0x0000000000002000L,0x0000000040040001L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1261 = new BitSet(new long[]{0x0000000000002000L,0x0000000040040001L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1276 = new BitSet(new long[]{0x0000000000002000L,0x0000000000040001L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1284 = new BitSet(new long[]{0x0000000000002000L,0x0000000000040001L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_tcs_concretesyntax1301 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1305 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_concretesyntax1313 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_concretesyntax1320 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_reference1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_reference1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_reference1437 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_qualifiedNameSymbolList_in_reference1445 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_qualifiedNameSymbolList_in_reference1453 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_RARROW_in_reference1475 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_reference1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_contexttemplate_in_tcs_template1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_primitivetemplate_in_tcs_template1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumerationtemplate_in_tcs_template1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functiontemplate_in_tcs_template1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classtemplate_in_tcs_contexttemplate1575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_operatortemplate_in_tcs_contexttemplate1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_tcs_primitivetemplate1613 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1620 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_tcs_primitivetemplate1626 = new BitSet(new long[]{0x0000000000008110L});
    public static final BitSet FOLLOW_reference_in_tcs_primitivetemplate1629 = new BitSet(new long[]{0x0000000000000000L,0x2000200000000000L});
    public static final BitSet FOLLOW_109_in_tcs_primitivetemplate1639 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_tcs_primitivetemplate1657 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1664 = new BitSet(new long[]{0x0001000000010000L});
    public static final BitSet FOLLOW_ORKEYWORD_in_tcs_primitivetemplate1676 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_primitivetemplate1695 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_tcs_primitivetemplate1699 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1703 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1711 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_primitivetemplate1724 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_tcs_primitivetemplate1728 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1732 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1740 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_primitivetemplate1760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_primitivetemplate1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_tcs_enumerationtemplate1813 = new BitSet(new long[]{0x0000000000008110L});
    public static final BitSet FOLLOW_reference_in_tcs_enumerationtemplate1816 = new BitSet(new long[]{0x0000000000014000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_tcs_enumerationtemplate1826 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_enumerationtemplate1854 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate1865 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_enumerationtemplate1874 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate1882 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate1897 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate1914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_enumerationtemplate1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping1977 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_enumliteralmapping1984 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_enumliteralmapping1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_tcs_classtemplate2035 = new BitSet(new long[]{0x0000000000008110L});
    public static final BitSet FOLLOW_reference_in_tcs_classtemplate2038 = new BitSet(new long[]{0x8000000000054200L,0x8210000280086002L});
    public static final BitSet FOLLOW_97_in_tcs_classtemplate2048 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_SHARP_in_tcs_classtemplate2068 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate2076 = new BitSet(new long[]{0x8000000000014200L,0x8210000080086002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2102 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_tcs_classtemplate2106 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2110 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2118 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2125 = new BitSet(new long[]{0x8000000000014200L,0x8210000080086002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2149 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_tcs_classtemplate2153 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2157 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2165 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2172 = new BitSet(new long[]{0x8000000000014000L,0x8210000080086002L});
    public static final BitSet FOLLOW_95_in_tcs_classtemplate2195 = new BitSet(new long[]{0x8000000000014000L,0x8210000000086002L});
    public static final BitSet FOLLOW_65_in_tcs_classtemplate2219 = new BitSet(new long[]{0x8000000000014000L,0x8210000000086000L});
    public static final BitSet FOLLOW_116_in_tcs_classtemplate2249 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_121_in_tcs_classtemplate2267 = new BitSet(new long[]{0x8000000000014000L,0x8000000000086000L});
    public static final BitSet FOLLOW_127_in_tcs_classtemplate2291 = new BitSet(new long[]{0x8000000000014200L,0x0000000000086000L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2301 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate2309 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2316 = new BitSet(new long[]{0x8000000000014000L,0x0000000000086000L});
    public static final BitSet FOLLOW_78_in_tcs_classtemplate2354 = new BitSet(new long[]{0x8000000000014200L,0x0000000000082000L});
    public static final BitSet FOLLOW_tcs_contexttags_in_tcs_classtemplate2367 = new BitSet(new long[]{0x8000000000014000L,0x0000000000082000L});
    public static final BitSet FOLLOW_77_in_tcs_classtemplate2407 = new BitSet(new long[]{0x8000000000014000L,0x0000000000080000L});
    public static final BitSet FOLLOW_63_in_tcs_classtemplate2431 = new BitSet(new long[]{0x0000000000014000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_tcs_classtemplate2455 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2462 = new BitSet(new long[]{0xFFF1000031288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2473 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2515 = new BitSet(new long[]{0xFFF1000031288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2526 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2536 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2553 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_classtemplate2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_tcs_operatortemplate2612 = new BitSet(new long[]{0x0000000000008110L});
    public static final BitSet FOLLOW_reference_in_tcs_operatortemplate2615 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_operatortemplate2620 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_tcs_operatortemplate2624 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2628 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2636 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2644 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2656 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_tcs_operatortemplate2660 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2664 = new BitSet(new long[]{0xFFF1000000008010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2672 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2685 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_tcs_operatortemplate2689 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2693 = new BitSet(new long[]{0xFFF1000000008010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2701 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2727 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_tcs_operatortemplate2731 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2735 = new BitSet(new long[]{0xFFF1000000008010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2743 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2769 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_tcs_operatortemplate2773 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2777 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate2785 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2811 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_tcs_operatortemplate2815 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2819 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate2827 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_operatortemplate2847 = new BitSet(new long[]{0x0000000000014000L,0x0000000200004000L});
    public static final BitSet FOLLOW_97_in_tcs_operatortemplate2857 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_78_in_tcs_operatortemplate2876 = new BitSet(new long[]{0x0000000000014200L});
    public static final BitSet FOLLOW_tcs_contexttags_in_tcs_operatortemplate2889 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_operatortemplate2940 = new BitSet(new long[]{0xFFF1000031288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_operatortemplate2951 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate2961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate2978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_operatortemplate2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_tcs_functiontemplate3037 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functiontemplate3044 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_functiontemplate3051 = new BitSet(new long[]{0x0000000000008110L});
    public static final BitSet FOLLOW_reference_in_tcs_functiontemplate3055 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_functiontemplate3060 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_functiontemplate3068 = new BitSet(new long[]{0xFFF1000031288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_functiontemplate3079 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_functiontemplate3089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_contexttags3134 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_identifier_in_tcs_contexttags3142 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_contexttags3151 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_contexttags3159 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_contexttags3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3216 = new BitSet(new long[]{0xFFF1000031288232L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3224 = new BitSet(new long[]{0xFFF1000031288232L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence__impl_in_tcs_sequence3269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_sequence3274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_sequenceelement3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_property_in_tcs_sequenceelement3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_customseparator_in_tcs_sequenceelement3319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_block_in_tcs_sequenceelement3327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement3335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_alternative_in_tcs_sequenceelement3343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functioncall_in_tcs_sequenceelement3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_injectoractionsblock_in_tcs_sequenceelement3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_literalref3393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_propertyreference3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_tcs_propertyreference3465 = new BitSet(new long[]{0xFFF1000000000012L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_propertyreference3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_property3528 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_property3541 = new BitSet(new long[]{0x0C00000000002000L,0x1808149034200000L,0x0000000000000044L});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property3549 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_property3558 = new BitSet(new long[]{0x0C00000000000000L,0x1808149034200000L,0x0000000000000044L});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property3566 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_property3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_tcs_customseparator3636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_customseparator3644 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_GT_in_tcs_customseparator3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_block3696 = new BitSet(new long[]{0xFFF1000031288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_block3704 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_block3711 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_block3722 = new BitSet(new long[]{0x0200000000002000L,0x0001000001000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block3730 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_block3739 = new BitSet(new long[]{0x0200000000000000L,0x0001000001000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block3747 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_block3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_conditionalelement3817 = new BitSet(new long[]{0xFFF1000000808010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_expression_in_tcs_conditionalelement3825 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_QMARK_in_tcs_conditionalelement3834 = new BitSet(new long[]{0xFFF1000031288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement3842 = new BitSet(new long[]{0x0000000000010800L});
    public static final BitSet FOLLOW_COLON_in_tcs_conditionalelement3855 = new BitSet(new long[]{0xFFF1000031288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement3863 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_conditionalelement3883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLSQUARE_in_tcs_alternative3928 = new BitSet(new long[]{0xFFF1000037288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_alternative3936 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_PIPE_in_tcs_alternative3945 = new BitSet(new long[]{0xFFF1000037288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_alternative3953 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_DRSQUARE_in_tcs_alternative3965 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_STAR_in_tcs_alternative3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_tcs_sequenceinalternative4041 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_sequenceinalternative4045 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_sequenceinalternative4053 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_sequenceinalternative4060 = new BitSet(new long[]{0xFFF1000031288232L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4081 = new BitSet(new long[]{0xFFF1000031288232L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4089 = new BitSet(new long[]{0xFFF1000031288232L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_DOLLAR_in_tcs_functioncall4138 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functioncall4146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCURLY_in_tcs_injectoractionsblock4193 = new BitSet(new long[]{0xFFF1000040008010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4201 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_injectoractionsblock4210 = new BitSet(new long[]{0xFFF1000000008010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4218 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_DRCURLY_in_tcs_injectoractionsblock4230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyinit_in_tcs_injectoraction4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_primitivepropertyinit_in_tcs_propertyinit4298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookuppropertyinit_in_tcs_propertyinit4306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_foreachpredicatepropertyinit_in_tcs_propertyinit4314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_primitivepropertyinit4348 = new BitSet(new long[]{0x0000000080000400L});
    public static final BitSet FOLLOW_LARROW_in_tcs_primitivepropertyinit4361 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivepropertyinit4376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivepropertyinit4391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_lookuppropertyinit4438 = new BitSet(new long[]{0x0000000080000400L});
    public static final BitSet FOLLOW_LARROW_in_tcs_lookuppropertyinit4451 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookuppropertyinit4466 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_103_in_tcs_lookuppropertyinit4477 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_lookuppropertyinit4481 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_lookuppropertyinit4489 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_lookuppropertyinit4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_foreachpredicatepropertyinit4541 = new BitSet(new long[]{0x0000000080000400L});
    public static final BitSet FOLLOW_LARROW_in_tcs_foreachpredicatepropertyinit4554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4569 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_tcs_foreachpredicatepropertyinit4580 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_foreachpredicatepropertyinit4584 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4592 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4605 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_tcs_foreachpredicatepropertyinit4609 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4613 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4621 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4647 = new BitSet(new long[]{0x0000000000000800L,0x0008800000200000L});
    public static final BitSet FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4655 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4664 = new BitSet(new long[]{0x0000000000000000L,0x0008800000200000L});
    public static final BitSet FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4672 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_foreachpredicatepropertyinit4697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_tcs_predicatesemantic4744 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic4748 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_predicatesemantic4756 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_predicatesemantic4763 = new BitSet(new long[]{0x0000000000000000L,0x0008000000200000L});
    public static final BitSet FOLLOW_115_in_tcs_predicatesemantic4786 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic4790 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_predicatesemantic4798 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_predicatesemantic4805 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_tcs_predicatesemantic4822 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic4826 = new BitSet(new long[]{0xFFF1000000000112L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_tcs_predicatesemantic4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_predicatesemantic4861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_referstoparg_in_tcs_propertyarg4908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookinparg_in_tcs_propertyarg4916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createinparg_in_tcs_propertyarg4924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_asparg_in_tcs_propertyarg4932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_separatorparg_in_tcs_propertyarg4940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_disambiguateparg_in_tcs_propertyarg4948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_autocreateparg_in_tcs_propertyarg4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_importcontextparg_in_tcs_propertyarg4964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_partialparg_in_tcs_propertyarg4972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg4980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedupperparg_in_tcs_propertyarg4988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createasparg_in_tcs_propertyarg4996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_queryparg_in_tcs_propertyarg5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_filterparg_in_tcs_propertyarg5012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_modeparg_in_tcs_propertyarg5020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_tcs_referstoparg5050 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_referstoparg5054 = new BitSet(new long[]{0xFFF1000000000010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_referstoparg5062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_tcs_lookinparg5105 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookinparg5109 = new BitSet(new long[]{0xFFF1000000040010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_SHARP_in_tcs_lookinparg5120 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_tcs_lookinparg5124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg5141 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_lookinparg5150 = new BitSet(new long[]{0xFFF1000000000010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg5158 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_59_in_tcs_createinparg5211 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_createinparg5215 = new BitSet(new long[]{0xFFF1000000000010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg5223 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_createinparg5232 = new BitSet(new long[]{0xFFF1000000000010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg5240 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_85_in_tcs_asparg5286 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_asparg5290 = new BitSet(new long[]{0xFFF1000000000110L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_tcs_asparg5303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_asparg5323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_tcs_separatorparg5371 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_separatorparg5375 = new BitSet(new long[]{0xFFF1000031288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_separatorparg5383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_tcs_disambiguateparg5426 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_disambiguateparg5430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_disambiguateparg5438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_tcs_autocreateparg5481 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_autocreateparg5485 = new BitSet(new long[]{0x0000000000000000L,0x0004000100000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg5493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_tcs_autocreatekind5537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_tcs_autocreatekind5547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_tcs_autocreatekind5557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_tcs_importcontextparg5588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_tcs_partialparg5628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_tcs_forcedlowerparg5668 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedlowerparg5672 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedlowerparg5680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_tcs_forcedupperparg5723 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedupperparg5727 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedupperparg5735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_tcs_createasparg5778 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_createasparg5782 = new BitSet(new long[]{0xFFF1000000000010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg5790 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_DLCOLON_in_tcs_createasparg5799 = new BitSet(new long[]{0xFFF1000000000010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg5807 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_90_in_tcs_queryparg5853 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_queryparg5857 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_queryparg5865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_tcs_filterparg5908 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_filterparg5912 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_filterparg5920 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COMA_in_tcs_filterparg5933 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_tcs_filterparg5937 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_filterparg5941 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_filterparg5949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_tcs_modeparg6005 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_modeparg6009 = new BitSet(new long[]{0xFFF1000000000010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_modeparg6017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_nbnlbarg_in_tcs_blockarg6057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_indentincrbarg_in_tcs_blockarg6065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnlbarg_in_tcs_blockarg6073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg6081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endnlbarg_in_tcs_blockarg6089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_tcs_nbnlbarg6119 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_nbnlbarg6123 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_nbnlbarg6131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_tcs_indentincrbarg6174 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_indentincrbarg6178 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_indentincrbarg6186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_tcs_startnlbarg6229 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnlbarg6233 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_tcs_startnlbarg6243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_tcs_startnlbarg6256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_tcs_startnbnlbarg6303 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnbnlbarg6307 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_startnbnlbarg6315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_tcs_endnlbarg6358 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_endnlbarg6362 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_tcs_endnlbarg6372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_tcs_endnlbarg6385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_symbol6436 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_symbol6445 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_symbol6453 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_symbol6466 = new BitSet(new long[]{0x0000000000004000L,0x0000010000020200L,0x0000000000000080L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol6474 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_symbol6483 = new BitSet(new long[]{0x0000000000000000L,0x0000010000020200L,0x0000000000000080L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol6491 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_symbol6516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_135_in_tcs_spacekind6558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_tcs_spacekind6568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_tcs_spacekind6578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_tcs_spacekind6588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_keyword6623 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_keyword6632 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_keyword6640 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_keyword6647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_tcs_operatorlist6688 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatorlist6701 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_operatorlist6721 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000800L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist6732 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000800L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist6740 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000800L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_operatorlist6755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_tcs_priority6796 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_priority6803 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_COMA_in_tcs_priority6826 = new BitSet(new long[]{0x0000000000000000L,0x4000000000800000L});
    public static final BitSet FOLLOW_tcs_associativity_in_tcs_priority6834 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_priority6848 = new BitSet(new long[]{0x0000000000002410L,0x0000000002000000L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority6859 = new BitSet(new long[]{0x0000000000002410L,0x0000000002000000L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority6867 = new BitSet(new long[]{0x0000000000002410L,0x0000000002000000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_priority6882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_tcs_operator6929 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator6951 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_operator6960 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator6979 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operator6999 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_operator7024 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_operator7032 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operator7039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_tcs_associativity7081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_tcs_associativity7091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_andexp_in_tcs_expression7119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp7153 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_tcs_andexp7161 = new BitSet(new long[]{0xFFF1000000008010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp7168 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_tcs_equalsexp_in_tcs_atomexp7213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp7221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_isdefinedexp_in_tcs_atomexp7229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_oneexp_in_tcs_atomexp7237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_instanceofexp_in_tcs_atomexp7245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_equalsexp7279 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_equalsexp7286 = new BitSet(new long[]{0x0000000400040060L});
    public static final BitSet FOLLOW_tcs_value_in_tcs_equalsexp7294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_booleanpropertyexp7341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_tcs_isdefinedexp7384 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_isdefinedexp7388 = new BitSet(new long[]{0xFFF1000000008010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_isdefinedexp7396 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_isdefinedexp7403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_tcs_oneexp7444 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_oneexp7448 = new BitSet(new long[]{0xFFF1000000008010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_oneexp7456 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_oneexp7463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_instanceofexp7508 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_tcs_instanceofexp7514 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_qualifiedNameSymbolList_in_tcs_instanceofexp7526 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_qualifiedNameSymbolList_in_tcs_instanceofexp7534 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_identifier_in_tcs_instanceofexp7557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_stringval_in_tcs_value7602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_integerval_in_tcs_value7610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_negativeintegerval_in_tcs_value7618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_value7626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringval7660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_integerval7707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_tcs_negativeintegerval7751 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_negativeintegerval7759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_tcs_enumliteralval7803 = new BitSet(new long[]{0xFFF1000000000010L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_enumliteralval7811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_tcs_token7860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_tcs_token7878 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_identifier_in_tcs_token7885 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_token7894 = new BitSet(new long[]{0x0000000000204020L,0x0000400000500000L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_token7902 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_token7909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern7954 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_tcs_orpattern7963 = new BitSet(new long[]{0x0000000000200020L,0x0000400000500000L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern7971 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_tcs_rulepattern_in_tcs_simplepattern8016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_simplepattern8024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classpattern_in_tcs_simplepattern8032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_rule_in_tcs_rulepattern8066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wordrule_in_tcs_rule8106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endoflinerule_in_tcs_rule8114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_multilinerule_in_tcs_rule8122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_tcs_wordrule8152 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_wordrule8156 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_tcs_wordrule8160 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8164 = new BitSet(new long[]{0x0000000000220020L,0x0000400000500000L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8172 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule8179 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_tcs_wordrule8183 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8187 = new BitSet(new long[]{0x0000000000220820L,0x0000400000500000L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8195 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule8208 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_tcs_wordrule8212 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8216 = new BitSet(new long[]{0x0000000000200820L,0x0000400000500000L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8224 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_wordrule8244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_tcs_endoflinerule8285 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_endoflinerule8289 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_tcs_endoflinerule8293 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_endoflinerule8297 = new BitSet(new long[]{0x0000000000000820L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_tcs_endoflinerule8307 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_endoflinerule8329 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_endoflinerule8336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_tcs_multilinerule8377 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule8381 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_tcs_multilinerule8385 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8389 = new BitSet(new long[]{0x0000000000020020L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_tcs_multilinerule8399 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8421 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8428 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_tcs_multilinerule8432 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8436 = new BitSet(new long[]{0x0000000000020820L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_tcs_multilinerule8446 = new BitSet(new long[]{0x0000000000020820L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8468 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_tcs_multilinerule8485 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8489 = new BitSet(new long[]{0x0000000000020820L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8497 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8510 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule8515 = new BitSet(new long[]{0x0000000100000810L,0x0060000000000000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule8523 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8532 = new BitSet(new long[]{0x0000000100000010L,0x0060000000000000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule8540 = new BitSet(new long[]{0x0000000000020800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule8552 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule8583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplemapping_in_tcs_mapping8621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wildcardmapping_in_tcs_mapping8629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_octalmapping_in_tcs_mapping8637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping8645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping8679 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_simplemapping8686 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping8694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping8738 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_wildcardmapping8743 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping8748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_tcs_octalmapping8789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_tcs_hexadecimalmapping8829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringpattern8873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_classpattern8919 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classpattern8927 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_classpattern8936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred113_TCS1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred118_TCS1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred135_TCS2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred146_TCS2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequence__impl_in_synpred151_TCS3269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_synpred160_TCS3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_expression_in_synpred167_TCS3825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_synpred170_TCS3936 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred170_TCS3945 = new BitSet(new long[]{0xFFF1000033288230L,0xFFFFFFFFFFFFFFFFL,0x00000000000000FFL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_synpred170_TCS3953 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMA_in_synpred182_TCS4605 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_synpred182_TCS4609 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_EQ_in_synpred182_TCS4613 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_synpred182_TCS4621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_synpred189_TCS4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_synpred252_TCS7954 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred252_TCS7963 = new BitSet(new long[]{0x0000000000200020L,0x0000400000500000L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_synpred252_TCS7971 = new BitSet(new long[]{0x0000000002000002L});

}