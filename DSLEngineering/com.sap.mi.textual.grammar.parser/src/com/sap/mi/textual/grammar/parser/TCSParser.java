// $ANTLR 3.1.1 parser/TCS.g 2010-02-01 13:00:17

package com.sap.mi.textual.grammar.parser;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.List;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
public class TCSParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "DLCOLON", "LPAREN", "RPAREN", "EQ", "LCURLY", "RCURLY", "SEMI", "RARROW", "COLON", "COMA", "SHARP", "LT", "GT", "LSQUARE", "RSQUARE", "QMARK", "DLSQUARE", "PIPE", "DRSQUARE", "STAR", "DOLLAR", "DLCURLY", "DRCURLY", "LARROW", "POINT", "MINUS", "COMMENT", "MULTI_LINE_COMMENT", "EXCL", "AROBAS", "SLASH", "PLUS", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'part'", "'instanceOf'", "'refersTo'", "'omitted'", "'importContext'", "'template'", "'drop'", "'autoCreate'", "'lexer'", "'leftSpace'", "'ifmissing'", "'when'", "'query'", "'foreach'", "'partial'", "'leftNone'", "'start'", "'isDefined'", "'lookIn'", "'esc'", "'invert'", "'default'", "'separator'", "'multiLine'", "'operatorTemplate'", "'filter'", "'deep'", "'disambiguateV3'", "'all'", "'startNbNL'", "'function'", "'rightNone'", "'keywords'", "'priority'", "'false'", "'enumerationTemplate'", "'storeRightTo'", "'octal'", "'mode'", "'true'", "'storeOpTo'", "'abstract'", "'context'", "'symbols'", "'auto'", "'word'", "'disambiguate'", "'orKeyword'", "'always'", "'forcedUpper'", "'multi'", "'main'", "'addToContext'", "'semDisambiguate'", "'primitiveTemplate'", "'referenceOnly'", "'prefix'", "'for'", "'one'", "'left'", "'postfix'", "'syntax'", "'operatored'", "'hex'", "'nonPrimary'", "'forcedLower'", "'endNL'", "'and'", "'end'", "'right'", "'token'", "'indentIncr'", "'createIn'", "'k'", "'value'", "'endOfLine'", "'rightSpace'", "'source'", "'as'", "'never'", "'using'", "'startNL'", "'nbNL'", "'operators'", "'createAs'", "'serializer'"
    };
    public static final int DLCURLY=29;
    public static final int LT=19;
    public static final int STAR=27;
    public static final int LSQUARE=21;
    public static final int DRCURLY=30;
    public static final int EXCL=36;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int RPAREN=10;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int NAME=4;
    public static final int T__90=90;
    public static final int NL=43;
    public static final int EQ=11;
    public static final int COMMENT=34;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int NE=42;
    public static final int T__95=95;
    public static final int GE=40;
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
    public static final int ALPHA=46;
    public static final int T__88=88;
    public static final int T__126=126;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int WS=44;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__129=129;
    public static final int SNAME=47;
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
    public static final int AROBAS=37;
    public static final int T__118=118;
    public static final int ESC=48;
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
    public static final int SLASH=38;
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
    public static final int PLUS=39;
    public static final int PIPE=25;
    public static final int T__112=112;
    public static final int DIGIT=45;
    public static final int T__50=50;
    public static final int DLSQUARE=24;
    public static final int T__49=49;
    public static final int RARROW=15;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int MINUS=33;
    public static final int RSQUARE=22;
    public static final int COMA=17;
    public static final int SEMI=14;
    public static final int MULTI_LINE_COMMENT=35;
    public static final int COLON=16;
    public static final int RCURLY=13;
    public static final int LE=41;
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


       private static final String syntaxUUID = "E0DCF6CD35B822E00F2911DF80C7EEEE93CCC8E1";
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
    // parser/TCS.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'part' | 'instanceOf' | 'refersTo' | 'omitted' | 'importContext' | 'template' | 'drop' | 'autoCreate' | 'lexer' | 'leftSpace' | 'ifmissing' | 'when' | 'query' | 'foreach' | 'partial' | 'leftNone' | 'start' | 'isDefined' | 'lookIn' | 'esc' | 'invert' | 'default' | 'separator' | 'multiLine' | 'operatorTemplate' | 'filter' | 'deep' | 'disambiguateV3' | 'all' | 'startNbNL' | 'function' | 'rightNone' | 'keywords' | 'priority' | 'false' | 'enumerationTemplate' | 'storeRightTo' | 'octal' | 'mode' | 'true' | 'storeOpTo' | 'abstract' | 'context' | 'symbols' | 'auto' | 'word' | 'disambiguate' | 'orKeyword' | 'always' | 'forcedUpper' | 'multi' | 'main' | 'addToContext' | 'semDisambiguate' | 'primitiveTemplate' | 'referenceOnly' | 'prefix' | 'for' | 'one' | 'left' | 'postfix' | 'syntax' | 'operatored' | 'hex' | 'nonPrimary' | 'forcedLower' | 'endNL' | 'and' | 'end' | 'right' | 'token' | 'indentIncr' | 'createIn' | 'k' | 'value' | 'endOfLine' | 'rightSpace' | 'source' | 'as' | 'never' | 'using' | 'startNL' | 'nbNL' | 'operators' | 'createAs' | 'serializer' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:218:3: ( (ast= NAME | 'part' | 'instanceOf' | 'refersTo' | 'omitted' | 'importContext' | 'template' | 'drop' | 'autoCreate' | 'lexer' | 'leftSpace' | 'ifmissing' | 'when' | 'query' | 'foreach' | 'partial' | 'leftNone' | 'start' | 'isDefined' | 'lookIn' | 'esc' | 'invert' | 'default' | 'separator' | 'multiLine' | 'operatorTemplate' | 'filter' | 'deep' | 'disambiguateV3' | 'all' | 'startNbNL' | 'function' | 'rightNone' | 'keywords' | 'priority' | 'false' | 'enumerationTemplate' | 'storeRightTo' | 'octal' | 'mode' | 'true' | 'storeOpTo' | 'abstract' | 'context' | 'symbols' | 'auto' | 'word' | 'disambiguate' | 'orKeyword' | 'always' | 'forcedUpper' | 'multi' | 'main' | 'addToContext' | 'semDisambiguate' | 'primitiveTemplate' | 'referenceOnly' | 'prefix' | 'for' | 'one' | 'left' | 'postfix' | 'syntax' | 'operatored' | 'hex' | 'nonPrimary' | 'forcedLower' | 'endNL' | 'and' | 'end' | 'right' | 'token' | 'indentIncr' | 'createIn' | 'k' | 'value' | 'endOfLine' | 'rightSpace' | 'source' | 'as' | 'never' | 'using' | 'startNL' | 'nbNL' | 'operators' | 'createAs' | 'serializer' ) )
            // parser/TCS.g:219:3: (ast= NAME | 'part' | 'instanceOf' | 'refersTo' | 'omitted' | 'importContext' | 'template' | 'drop' | 'autoCreate' | 'lexer' | 'leftSpace' | 'ifmissing' | 'when' | 'query' | 'foreach' | 'partial' | 'leftNone' | 'start' | 'isDefined' | 'lookIn' | 'esc' | 'invert' | 'default' | 'separator' | 'multiLine' | 'operatorTemplate' | 'filter' | 'deep' | 'disambiguateV3' | 'all' | 'startNbNL' | 'function' | 'rightNone' | 'keywords' | 'priority' | 'false' | 'enumerationTemplate' | 'storeRightTo' | 'octal' | 'mode' | 'true' | 'storeOpTo' | 'abstract' | 'context' | 'symbols' | 'auto' | 'word' | 'disambiguate' | 'orKeyword' | 'always' | 'forcedUpper' | 'multi' | 'main' | 'addToContext' | 'semDisambiguate' | 'primitiveTemplate' | 'referenceOnly' | 'prefix' | 'for' | 'one' | 'left' | 'postfix' | 'syntax' | 'operatored' | 'hex' | 'nonPrimary' | 'forcedLower' | 'endNL' | 'and' | 'end' | 'right' | 'token' | 'indentIncr' | 'createIn' | 'k' | 'value' | 'endOfLine' | 'rightSpace' | 'source' | 'as' | 'never' | 'using' | 'startNL' | 'nbNL' | 'operators' | 'createAs' | 'serializer' )
            {
            // parser/TCS.g:219:3: (ast= NAME | 'part' | 'instanceOf' | 'refersTo' | 'omitted' | 'importContext' | 'template' | 'drop' | 'autoCreate' | 'lexer' | 'leftSpace' | 'ifmissing' | 'when' | 'query' | 'foreach' | 'partial' | 'leftNone' | 'start' | 'isDefined' | 'lookIn' | 'esc' | 'invert' | 'default' | 'separator' | 'multiLine' | 'operatorTemplate' | 'filter' | 'deep' | 'disambiguateV3' | 'all' | 'startNbNL' | 'function' | 'rightNone' | 'keywords' | 'priority' | 'false' | 'enumerationTemplate' | 'storeRightTo' | 'octal' | 'mode' | 'true' | 'storeOpTo' | 'abstract' | 'context' | 'symbols' | 'auto' | 'word' | 'disambiguate' | 'orKeyword' | 'always' | 'forcedUpper' | 'multi' | 'main' | 'addToContext' | 'semDisambiguate' | 'primitiveTemplate' | 'referenceOnly' | 'prefix' | 'for' | 'one' | 'left' | 'postfix' | 'syntax' | 'operatored' | 'hex' | 'nonPrimary' | 'forcedLower' | 'endNL' | 'and' | 'end' | 'right' | 'token' | 'indentIncr' | 'createIn' | 'k' | 'value' | 'endOfLine' | 'rightSpace' | 'source' | 'as' | 'never' | 'using' | 'startNL' | 'nbNL' | 'operators' | 'createAs' | 'serializer' )
            int alt1=87;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 49:
                {
                alt1=2;
                }
                break;
            case 50:
                {
                alt1=3;
                }
                break;
            case 51:
                {
                alt1=4;
                }
                break;
            case 52:
                {
                alt1=5;
                }
                break;
            case 53:
                {
                alt1=6;
                }
                break;
            case 54:
                {
                alt1=7;
                }
                break;
            case 55:
                {
                alt1=8;
                }
                break;
            case 56:
                {
                alt1=9;
                }
                break;
            case 57:
                {
                alt1=10;
                }
                break;
            case 58:
                {
                alt1=11;
                }
                break;
            case 59:
                {
                alt1=12;
                }
                break;
            case 60:
                {
                alt1=13;
                }
                break;
            case 61:
                {
                alt1=14;
                }
                break;
            case 62:
                {
                alt1=15;
                }
                break;
            case 63:
                {
                alt1=16;
                }
                break;
            case 64:
                {
                alt1=17;
                }
                break;
            case 65:
                {
                alt1=18;
                }
                break;
            case 66:
                {
                alt1=19;
                }
                break;
            case 67:
                {
                alt1=20;
                }
                break;
            case 68:
                {
                alt1=21;
                }
                break;
            case 69:
                {
                alt1=22;
                }
                break;
            case 70:
                {
                alt1=23;
                }
                break;
            case 71:
                {
                alt1=24;
                }
                break;
            case 72:
                {
                alt1=25;
                }
                break;
            case 73:
                {
                alt1=26;
                }
                break;
            case 74:
                {
                alt1=27;
                }
                break;
            case 75:
                {
                alt1=28;
                }
                break;
            case 76:
                {
                alt1=29;
                }
                break;
            case 77:
                {
                alt1=30;
                }
                break;
            case 78:
                {
                alt1=31;
                }
                break;
            case 79:
                {
                alt1=32;
                }
                break;
            case 80:
                {
                alt1=33;
                }
                break;
            case 81:
                {
                alt1=34;
                }
                break;
            case 82:
                {
                alt1=35;
                }
                break;
            case 83:
                {
                alt1=36;
                }
                break;
            case 84:
                {
                alt1=37;
                }
                break;
            case 85:
                {
                alt1=38;
                }
                break;
            case 86:
                {
                alt1=39;
                }
                break;
            case 87:
                {
                alt1=40;
                }
                break;
            case 88:
                {
                alt1=41;
                }
                break;
            case 89:
                {
                alt1=42;
                }
                break;
            case 90:
                {
                alt1=43;
                }
                break;
            case 91:
                {
                alt1=44;
                }
                break;
            case 92:
                {
                alt1=45;
                }
                break;
            case 93:
                {
                alt1=46;
                }
                break;
            case 94:
                {
                alt1=47;
                }
                break;
            case 95:
                {
                alt1=48;
                }
                break;
            case 96:
                {
                alt1=49;
                }
                break;
            case 97:
                {
                alt1=50;
                }
                break;
            case 98:
                {
                alt1=51;
                }
                break;
            case 99:
                {
                alt1=52;
                }
                break;
            case 100:
                {
                alt1=53;
                }
                break;
            case 101:
                {
                alt1=54;
                }
                break;
            case 102:
                {
                alt1=55;
                }
                break;
            case 103:
                {
                alt1=56;
                }
                break;
            case 104:
                {
                alt1=57;
                }
                break;
            case 105:
                {
                alt1=58;
                }
                break;
            case 106:
                {
                alt1=59;
                }
                break;
            case 107:
                {
                alt1=60;
                }
                break;
            case 108:
                {
                alt1=61;
                }
                break;
            case 109:
                {
                alt1=62;
                }
                break;
            case 110:
                {
                alt1=63;
                }
                break;
            case 111:
                {
                alt1=64;
                }
                break;
            case 112:
                {
                alt1=65;
                }
                break;
            case 113:
                {
                alt1=66;
                }
                break;
            case 114:
                {
                alt1=67;
                }
                break;
            case 115:
                {
                alt1=68;
                }
                break;
            case 116:
                {
                alt1=69;
                }
                break;
            case 117:
                {
                alt1=70;
                }
                break;
            case 118:
                {
                alt1=71;
                }
                break;
            case 119:
                {
                alt1=72;
                }
                break;
            case 120:
                {
                alt1=73;
                }
                break;
            case 121:
                {
                alt1=74;
                }
                break;
            case 122:
                {
                alt1=75;
                }
                break;
            case 123:
                {
                alt1=76;
                }
                break;
            case 124:
                {
                alt1=77;
                }
                break;
            case 125:
                {
                alt1=78;
                }
                break;
            case 126:
                {
                alt1=79;
                }
                break;
            case 127:
                {
                alt1=80;
                }
                break;
            case 128:
                {
                alt1=81;
                }
                break;
            case 129:
                {
                alt1=82;
                }
                break;
            case 130:
                {
                alt1=83;
                }
                break;
            case 131:
                {
                alt1=84;
                }
                break;
            case 132:
                {
                alt1=85;
                }
                break;
            case 133:
                {
                alt1=86;
                }
                break;
            case 134:
                {
                alt1=87;
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
                    // parser/TCS.g:221:5: 'part'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "part";
                    }

                    }
                    break;
                case 3 :
                    // parser/TCS.g:222:5: 'instanceOf'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "instanceOf";
                    }

                    }
                    break;
                case 4 :
                    // parser/TCS.g:223:5: 'refersTo'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "refersTo";
                    }

                    }
                    break;
                case 5 :
                    // parser/TCS.g:224:5: 'omitted'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "omitted";
                    }

                    }
                    break;
                case 6 :
                    // parser/TCS.g:225:5: 'importContext'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "importContext";
                    }

                    }
                    break;
                case 7 :
                    // parser/TCS.g:226:5: 'template'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "template";
                    }

                    }
                    break;
                case 8 :
                    // parser/TCS.g:227:5: 'drop'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "drop";
                    }

                    }
                    break;
                case 9 :
                    // parser/TCS.g:228:5: 'autoCreate'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "autoCreate";
                    }

                    }
                    break;
                case 10 :
                    // parser/TCS.g:229:5: 'lexer'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lexer";
                    }

                    }
                    break;
                case 11 :
                    // parser/TCS.g:230:5: 'leftSpace'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftSpace";
                    }

                    }
                    break;
                case 12 :
                    // parser/TCS.g:231:5: 'ifmissing'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "ifmissing";
                    }

                    }
                    break;
                case 13 :
                    // parser/TCS.g:232:5: 'when'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "when";
                    }

                    }
                    break;
                case 14 :
                    // parser/TCS.g:233:5: 'query'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "query";
                    }

                    }
                    break;
                case 15 :
                    // parser/TCS.g:234:5: 'foreach'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 16 :
                    // parser/TCS.g:235:5: 'partial'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "partial";
                    }

                    }
                    break;
                case 17 :
                    // parser/TCS.g:236:5: 'leftNone'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftNone";
                    }

                    }
                    break;
                case 18 :
                    // parser/TCS.g:237:5: 'start'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword236); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "start";
                    }

                    }
                    break;
                case 19 :
                    // parser/TCS.g:238:5: 'isDefined'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword244); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "isDefined";
                    }

                    }
                    break;
                case 20 :
                    // parser/TCS.g:239:5: 'lookIn'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword252); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookIn";
                    }

                    }
                    break;
                case 21 :
                    // parser/TCS.g:240:5: 'esc'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword260); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "esc";
                    }

                    }
                    break;
                case 22 :
                    // parser/TCS.g:241:5: 'invert'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword268); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "invert";
                    }

                    }
                    break;
                case 23 :
                    // parser/TCS.g:242:5: 'default'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword276); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "default";
                    }

                    }
                    break;
                case 24 :
                    // parser/TCS.g:243:5: 'separator'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "separator";
                    }

                    }
                    break;
                case 25 :
                    // parser/TCS.g:244:5: 'multiLine'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multiLine";
                    }

                    }
                    break;
                case 26 :
                    // parser/TCS.g:245:5: 'operatorTemplate'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword300); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatorTemplate";
                    }

                    }
                    break;
                case 27 :
                    // parser/TCS.g:246:5: 'filter'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword308); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "filter";
                    }

                    }
                    break;
                case 28 :
                    // parser/TCS.g:247:5: 'deep'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword316); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "deep";
                    }

                    }
                    break;
                case 29 :
                    // parser/TCS.g:248:5: 'disambiguateV3'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword324); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguateV3";
                    }

                    }
                    break;
                case 30 :
                    // parser/TCS.g:249:5: 'all'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword332); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "all";
                    }

                    }
                    break;
                case 31 :
                    // parser/TCS.g:250:5: 'startNbNL'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword340); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNbNL";
                    }

                    }
                    break;
                case 32 :
                    // parser/TCS.g:251:5: 'function'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword348); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "function";
                    }

                    }
                    break;
                case 33 :
                    // parser/TCS.g:252:5: 'rightNone'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword356); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightNone";
                    }

                    }
                    break;
                case 34 :
                    // parser/TCS.g:253:5: 'keywords'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword364); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "keywords";
                    }

                    }
                    break;
                case 35 :
                    // parser/TCS.g:254:5: 'priority'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword372); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "priority";
                    }

                    }
                    break;
                case 36 :
                    // parser/TCS.g:255:5: 'false'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword380); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 37 :
                    // parser/TCS.g:256:5: 'enumerationTemplate'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword388); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "enumerationTemplate";
                    }

                    }
                    break;
                case 38 :
                    // parser/TCS.g:257:5: 'storeRightTo'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword396); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeRightTo";
                    }

                    }
                    break;
                case 39 :
                    // parser/TCS.g:258:5: 'octal'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword404); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "octal";
                    }

                    }
                    break;
                case 40 :
                    // parser/TCS.g:259:5: 'mode'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword412); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "mode";
                    }

                    }
                    break;
                case 41 :
                    // parser/TCS.g:260:5: 'true'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword420); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 42 :
                    // parser/TCS.g:261:5: 'storeOpTo'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword428); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeOpTo";
                    }

                    }
                    break;
                case 43 :
                    // parser/TCS.g:262:5: 'abstract'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword436); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 44 :
                    // parser/TCS.g:263:5: 'context'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword444); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 45 :
                    // parser/TCS.g:264:5: 'symbols'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword452); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "symbols";
                    }

                    }
                    break;
                case 46 :
                    // parser/TCS.g:265:5: 'auto'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword460); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "auto";
                    }

                    }
                    break;
                case 47 :
                    // parser/TCS.g:266:5: 'word'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword468); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "word";
                    }

                    }
                    break;
                case 48 :
                    // parser/TCS.g:267:5: 'disambiguate'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword476); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguate";
                    }

                    }
                    break;
                case 49 :
                    // parser/TCS.g:268:5: 'orKeyword'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword484); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "orKeyword";
                    }

                    }
                    break;
                case 50 :
                    // parser/TCS.g:269:5: 'always'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword492); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "always";
                    }

                    }
                    break;
                case 51 :
                    // parser/TCS.g:270:5: 'forcedUpper'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword500); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedUpper";
                    }

                    }
                    break;
                case 52 :
                    // parser/TCS.g:271:5: 'multi'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword508); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multi";
                    }

                    }
                    break;
                case 53 :
                    // parser/TCS.g:272:5: 'main'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword516); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "main";
                    }

                    }
                    break;
                case 54 :
                    // parser/TCS.g:273:5: 'addToContext'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword524); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "addToContext";
                    }

                    }
                    break;
                case 55 :
                    // parser/TCS.g:274:5: 'semDisambiguate'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword532); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "semDisambiguate";
                    }

                    }
                    break;
                case 56 :
                    // parser/TCS.g:275:5: 'primitiveTemplate'
                    {
                    match(input,103,FOLLOW_103_in_identifierOrKeyword540); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "primitiveTemplate";
                    }

                    }
                    break;
                case 57 :
                    // parser/TCS.g:276:5: 'referenceOnly'
                    {
                    match(input,104,FOLLOW_104_in_identifierOrKeyword548); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "referenceOnly";
                    }

                    }
                    break;
                case 58 :
                    // parser/TCS.g:277:5: 'prefix'
                    {
                    match(input,105,FOLLOW_105_in_identifierOrKeyword556); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "prefix";
                    }

                    }
                    break;
                case 59 :
                    // parser/TCS.g:278:5: 'for'
                    {
                    match(input,106,FOLLOW_106_in_identifierOrKeyword564); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 60 :
                    // parser/TCS.g:279:5: 'one'
                    {
                    match(input,107,FOLLOW_107_in_identifierOrKeyword572); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "one";
                    }

                    }
                    break;
                case 61 :
                    // parser/TCS.g:280:5: 'left'
                    {
                    match(input,108,FOLLOW_108_in_identifierOrKeyword580); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "left";
                    }

                    }
                    break;
                case 62 :
                    // parser/TCS.g:281:5: 'postfix'
                    {
                    match(input,109,FOLLOW_109_in_identifierOrKeyword588); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "postfix";
                    }

                    }
                    break;
                case 63 :
                    // parser/TCS.g:282:5: 'syntax'
                    {
                    match(input,110,FOLLOW_110_in_identifierOrKeyword596); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "syntax";
                    }

                    }
                    break;
                case 64 :
                    // parser/TCS.g:283:5: 'operatored'
                    {
                    match(input,111,FOLLOW_111_in_identifierOrKeyword604); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatored";
                    }

                    }
                    break;
                case 65 :
                    // parser/TCS.g:284:5: 'hex'
                    {
                    match(input,112,FOLLOW_112_in_identifierOrKeyword612); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "hex";
                    }

                    }
                    break;
                case 66 :
                    // parser/TCS.g:285:5: 'nonPrimary'
                    {
                    match(input,113,FOLLOW_113_in_identifierOrKeyword620); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nonPrimary";
                    }

                    }
                    break;
                case 67 :
                    // parser/TCS.g:286:5: 'forcedLower'
                    {
                    match(input,114,FOLLOW_114_in_identifierOrKeyword628); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedLower";
                    }

                    }
                    break;
                case 68 :
                    // parser/TCS.g:287:5: 'endNL'
                    {
                    match(input,115,FOLLOW_115_in_identifierOrKeyword636); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endNL";
                    }

                    }
                    break;
                case 69 :
                    // parser/TCS.g:288:5: 'and'
                    {
                    match(input,116,FOLLOW_116_in_identifierOrKeyword644); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 70 :
                    // parser/TCS.g:289:5: 'end'
                    {
                    match(input,117,FOLLOW_117_in_identifierOrKeyword652); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "end";
                    }

                    }
                    break;
                case 71 :
                    // parser/TCS.g:290:5: 'right'
                    {
                    match(input,118,FOLLOW_118_in_identifierOrKeyword660); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "right";
                    }

                    }
                    break;
                case 72 :
                    // parser/TCS.g:291:5: 'token'
                    {
                    match(input,119,FOLLOW_119_in_identifierOrKeyword668); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "token";
                    }

                    }
                    break;
                case 73 :
                    // parser/TCS.g:292:5: 'indentIncr'
                    {
                    match(input,120,FOLLOW_120_in_identifierOrKeyword676); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "indentIncr";
                    }

                    }
                    break;
                case 74 :
                    // parser/TCS.g:293:5: 'createIn'
                    {
                    match(input,121,FOLLOW_121_in_identifierOrKeyword684); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createIn";
                    }

                    }
                    break;
                case 75 :
                    // parser/TCS.g:294:5: 'k'
                    {
                    match(input,122,FOLLOW_122_in_identifierOrKeyword692); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "k";
                    }

                    }
                    break;
                case 76 :
                    // parser/TCS.g:295:5: 'value'
                    {
                    match(input,123,FOLLOW_123_in_identifierOrKeyword700); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "value";
                    }

                    }
                    break;
                case 77 :
                    // parser/TCS.g:296:5: 'endOfLine'
                    {
                    match(input,124,FOLLOW_124_in_identifierOrKeyword708); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endOfLine";
                    }

                    }
                    break;
                case 78 :
                    // parser/TCS.g:297:5: 'rightSpace'
                    {
                    match(input,125,FOLLOW_125_in_identifierOrKeyword716); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightSpace";
                    }

                    }
                    break;
                case 79 :
                    // parser/TCS.g:298:5: 'source'
                    {
                    match(input,126,FOLLOW_126_in_identifierOrKeyword724); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "source";
                    }

                    }
                    break;
                case 80 :
                    // parser/TCS.g:299:5: 'as'
                    {
                    match(input,127,FOLLOW_127_in_identifierOrKeyword732); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "as";
                    }

                    }
                    break;
                case 81 :
                    // parser/TCS.g:300:5: 'never'
                    {
                    match(input,128,FOLLOW_128_in_identifierOrKeyword740); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "never";
                    }

                    }
                    break;
                case 82 :
                    // parser/TCS.g:301:5: 'using'
                    {
                    match(input,129,FOLLOW_129_in_identifierOrKeyword748); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "using";
                    }

                    }
                    break;
                case 83 :
                    // parser/TCS.g:302:5: 'startNL'
                    {
                    match(input,130,FOLLOW_130_in_identifierOrKeyword756); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNL";
                    }

                    }
                    break;
                case 84 :
                    // parser/TCS.g:303:5: 'nbNL'
                    {
                    match(input,131,FOLLOW_131_in_identifierOrKeyword764); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nbNL";
                    }

                    }
                    break;
                case 85 :
                    // parser/TCS.g:304:5: 'operators'
                    {
                    match(input,132,FOLLOW_132_in_identifierOrKeyword772); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operators";
                    }

                    }
                    break;
                case 86 :
                    // parser/TCS.g:305:5: 'createAs'
                    {
                    match(input,133,FOLLOW_133_in_identifierOrKeyword780); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createAs";
                    }

                    }
                    break;
                case 87 :
                    // parser/TCS.g:306:5: 'serializer'
                    {
                    match(input,134,FOLLOW_134_in_identifierOrKeyword788); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "serializer";
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
    // parser/TCS.g:313:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:314:3: ( (ast= STRING ) )
            // parser/TCS.g:315:3: (ast= STRING )
            {
            // parser/TCS.g:315:3: (ast= STRING )
            // parser/TCS.g:315:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol819); if (state.failed) return ret2;
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
    // parser/TCS.g:323:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:324:3: ( (ast= INT ) )
            // parser/TCS.g:325:3: (ast= INT )
            {
            // parser/TCS.g:325:3: (ast= INT )
            // parser/TCS.g:325:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol850); if (state.failed) return ret2;
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
    // parser/TCS.g:333:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:334:3: ( (ast= FLOAT ) )
            // parser/TCS.g:335:3: (ast= FLOAT )
            {
            // parser/TCS.g:335:3: (ast= FLOAT )
            // parser/TCS.g:335:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol881); if (state.failed) return ret2;
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
    // parser/TCS.g:343:1: model_classifier returns [Object ret2] : ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) ) ;
    public final Object model_classifier() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Classifier");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:348:3: ( ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) ) )
            // parser/TCS.g:349:3: ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) )
            {
            // parser/TCS.g:349:3: ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) )
            // parser/TCS.g:349:4: ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD32F532500F2911DFAA12EEEE93CCC8E1");
            }
            // parser/TCS.g:349:64: ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==EOF||(LA2_1>=LPAREN && LA2_1<=RPAREN)||LA2_1==SEMI||LA2_1==COLON||LA2_1==SHARP||LA2_1==70||LA2_1==75||(LA2_1>=90 && LA2_1<=91)||LA2_1==93||(LA2_1>=99 && LA2_1<=101)||(LA2_1>=104 && LA2_1<=105)||LA2_1==111||LA2_1==113||LA2_1==129) ) {
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
                    // parser/TCS.g:349:65: ( (temp= model_namespace ) DLCOLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:349:81: ( (temp= model_namespace ) DLCOLON (temp= identifier ) )
                    // parser/TCS.g:349:82: (temp= model_namespace ) DLCOLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD32D17DB00F2911DFB3BBEEEE93CCC8E1");
                    }
                    // parser/TCS.g:349:141: (temp= model_namespace )
                    // parser/TCS.g:349:143: temp= model_namespace
                    {
                    pushFollow(FOLLOW_model_namespace_in_model_classifier921);
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
                      _beforeSeqEl("E0DCF6CD32DAF3900F2911DFAE80EEEE93CCC8E1");
                    }
                    match(input,DLCOLON,FOLLOW_DLCOLON_in_model_classifier928); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD32DD64910F2911DFBA4EEEEE93CCC8E1");
                    }
                    // parser/TCS.g:349:362: (temp= identifier )
                    // parser/TCS.g:349:364: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_model_classifier936);
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
                    // parser/TCS.g:349:448: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:349:464: ( (temp= identifier ) )
                    // parser/TCS.g:349:465: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD32F2C1510F2911DFB83BEEEE93CCC8E1");
                    }
                    // parser/TCS.g:349:524: (temp= identifier )
                    // parser/TCS.g:349:526: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_model_classifier955);
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
    // parser/TCS.g:358:1: primary_model_namespace returns [Object ret2] : (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) ) ;
    public final Object primary_model_namespace() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:359:3: ( (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) ) )
            // parser/TCS.g:360:3: (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) )
            {
            // parser/TCS.g:360:3: (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) )
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
                    // parser/TCS.g:360:4: ret= model_generalizableelement
                    {
                    pushFollow(FOLLOW_model_generalizableelement_in_primary_model_namespace1001);
                    ret=model_generalizableelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:361:5: ( LPAREN ret= model_namespace RPAREN )
                    {
                    // parser/TCS.g:361:5: ( LPAREN ret= model_namespace RPAREN )
                    // parser/TCS.g:361:6: LPAREN ret= model_namespace RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_model_namespace1010); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_model_namespace_in_primary_model_namespace1016);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_model_namespace1020); if (state.failed) return ret2;
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
    // parser/TCS.g:368:1: dblcolon_priority_0 returns [Object ret2] : ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object dblcolon_priority_0() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // parser/TCS.g:369:3: ( ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) ) )
            // parser/TCS.g:370:4: ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) )
            {
            // parser/TCS.g:370:4: ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) )
            // parser/TCS.g:370:6: (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* )
            {
            // parser/TCS.g:370:6: (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* )
            // parser/TCS.g:370:8: ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_model_namespace_in_dblcolon_priority_01058);
            ret=primary_model_namespace();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // parser/TCS.g:370:35: ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DLCOLON) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==NAME) ) {
                        int LA4_3 = input.LA(3);

                        if ( (LA4_3==DLCOLON) && (synpred89_TCS())) {
                            alt4=1;
                        }
                        else if ( (LA4_3==RPAREN) ) {
                            int LA4_5 = input.LA(4);

                            if ( (LA4_5==DLCOLON) && (synpred89_TCS())) {
                                alt4=1;
                            }
                            else if ( (LA4_5==RPAREN) && (synpred89_TCS())) {
                                alt4=1;
                            }


                        }


                    }


                }


                switch (alt4) {
            	case 1 :
            	    // parser/TCS.g:370:36: ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) )
            	    {
            	    // parser/TCS.g:370:47: ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) )
            	    // parser/TCS.g:370:48: DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("::", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_dblcolon_priority_01067); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "::";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // parser/TCS.g:370:135: ( (ret= model_modelelement[opName, ret, firstToken] ) )
            	    // parser/TCS.g:370:136: (ret= model_modelelement[opName, ret, firstToken] )
            	    {
            	    // parser/TCS.g:370:136: (ret= model_modelelement[opName, ret, firstToken] )
            	    // parser/TCS.g:370:137: ret= model_modelelement[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_model_modelelement_in_dblcolon_priority_01075);
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
    // parser/TCS.g:378:1: model_namespace returns [Object ret2] : ret= dblcolon_priority_0 ;
    public final Object model_namespace() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:379:3: (ret= dblcolon_priority_0 )
            // parser/TCS.g:380:3: ret= dblcolon_priority_0
            {
            pushFollow(FOLLOW_dblcolon_priority_0_in_model_namespace1107);
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
    // parser/TCS.g:387:1: model_generalizableelement returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object model_generalizableelement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","GeneralizableElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:392:3: ( ( (temp= identifier ) ) )
            // parser/TCS.g:393:3: ( (temp= identifier ) )
            {
            // parser/TCS.g:393:3: ( (temp= identifier ) )
            // parser/TCS.g:393:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD332012E10F2911DFCC1FEEEE93CCC8E1");
            }
            // parser/TCS.g:393:63: (temp= identifier )
            // parser/TCS.g:393:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_generalizableelement1140);
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
    // parser/TCS.g:401:1: model_modelelement[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object model_modelelement(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","ModelElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ?  createReferenceProxy(metaType) : null;


        try {
            // parser/TCS.g:406:3: ( ( (temp= identifier ) ) )
            // parser/TCS.g:407:3: ( (temp= identifier ) )
            {
            // parser/TCS.g:407:3: ( (temp= identifier ) )
            // parser/TCS.g:407:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3324CDD20F2911DF9809EEEE93CCC8E1");
            }
            // parser/TCS.g:407:63: (temp= identifier )
            // parser/TCS.g:407:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_modelelement1188);
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
    // parser/TCS.g:417:1: textblockdefinition_textblockdefinition returns [Object ret2] : () ;
    public final Object textblockdefinition_textblockdefinition() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("textblockdefinition","TextBlockDefinition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:422:3: ( () )
            // parser/TCS.g:423:3: ()
            {
            // parser/TCS.g:423:3: ()
            // parser/TCS.g:423:4: 
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
    // parser/TCS.g:431:1: main returns [Object ret2] : ( (ret= tcs_concretesyntax ) EOF ) ;
    public final Object main() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:432:3: ( ( (ret= tcs_concretesyntax ) EOF ) )
            // parser/TCS.g:433:3: ( (ret= tcs_concretesyntax ) EOF )
            {
            // parser/TCS.g:433:3: ( (ret= tcs_concretesyntax ) EOF )
            // parser/TCS.g:433:4: (ret= tcs_concretesyntax ) EOF
            {
            // parser/TCS.g:433:4: (ret= tcs_concretesyntax )
            // parser/TCS.g:433:5: ret= tcs_concretesyntax
            {
            pushFollow(FOLLOW_tcs_concretesyntax_in_main1258);
            ret=tcs_concretesyntax();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main1261); if (state.failed) return ret2;

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
    // parser/TCS.g:440:1: tcs_concretesyntax returns [Object ret2] : ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) ;
    public final Object tcs_concretesyntax() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConcreteSyntax");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:445:3: ( ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) )
            // parser/TCS.g:446:3: ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            {
            // parser/TCS.g:446:3: ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            // parser/TCS.g:446:4: 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3343C7800F2911DF8D9CEEEE93CCC8E1");
            }
            match(input,110,FOLLOW_110_in_tcs_concretesyntax1292); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD334611710F2911DFAAEBEEEE93CCC8E1");
            }
            // parser/TCS.g:446:146: (temp= identifier )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NAME) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // parser/TCS.g:446:148: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_concretesyntax1299);
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
              _beforeSeqEl("E0DCF6CD3346117C0F2911DF96C6EEEE93CCC8E1");
            }
            // parser/TCS.g:446:276: ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | )
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
                    // parser/TCS.g:446:277: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:446:293: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    // parser/TCS.g:446:294: LPAREN 'k' EQ (temp= integerSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD334611750F2911DF8EE2EEEE93CCC8E1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_concretesyntax1314); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD334611760F2911DFB96FEEEE93CCC8E1");
                    }
                    match(input,122,FOLLOW_122_in_tcs_concretesyntax1318); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD334611770F2911DFC2CCEEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1322); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD334611790F2911DF88C2EEEE93CCC8E1");
                    }
                    // parser/TCS.g:446:593: (temp= integerSymbol )
                    // parser/TCS.g:446:595: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_tcs_concretesyntax1330);
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
                      _beforeSeqEl("E0DCF6CD3346117A0F2911DF8EA5EEEE93CCC8E1");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_concretesyntax1337); if (state.failed) return ret2;
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
                    // parser/TCS.g:446:762: 
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
              _beforeSeqEl("E0DCF6CD3346117D0F2911DFB195EEEE93CCC8E1");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1355); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD337363000F2911DFC06DEEEE93CCC8E1");
            }
            // parser/TCS.g:447:159: ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) )
            // parser/TCS.g:447:160: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            {
            // parser/TCS.g:447:160: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            // parser/TCS.g:447:161: (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3346117F0F2911DF82CEEEEE93CCC8E1");
            }
            // parser/TCS.g:447:220: (temp= tcs_template (temp= tcs_template )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==54||LA8_0==73||LA8_0==79||LA8_0==84||LA8_0==103) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // parser/TCS.g:447:222: temp= tcs_template (temp= tcs_template )*
                    {
                    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax1366);
                    temp=tcs_template();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templates", temp);
                    }
                    // parser/TCS.g:447:279: (temp= tcs_template )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==54||LA7_0==73||LA7_0==79||LA7_0==84||LA7_0==103) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // parser/TCS.g:447:281: temp= tcs_template
                    	    {
                    	    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax1374);
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
              _beforeSeqEl("E0DCF6CD335924420F2911DF81E4EEEE93CCC8E1");
            }
            // parser/TCS.g:447:419: ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==81) ) {
                alt11=1;
            }
            else if ( (LA11_0==RCURLY||LA11_0==52||LA11_0==57||LA11_0==92||LA11_0==119||LA11_0==132) ) {
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
                    // parser/TCS.g:447:420: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:447:436: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    // parser/TCS.g:447:437: 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD334882710F2911DFB34AEEEE93CCC8E1");
                    }
                    match(input,81,FOLLOW_81_in_tcs_concretesyntax1391); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD334882720F2911DF9C57EEEE93CCC8E1");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1395); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD334D3D600F2911DFB9FCEEEE93CCC8E1");
                    }
                    // parser/TCS.g:447:664: ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) )
                    // parser/TCS.g:447:665: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    {
                    // parser/TCS.g:447:665: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    // parser/TCS.g:447:666: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD334882740F2911DFB449EEEE93CCC8E1");
                    }
                    // parser/TCS.g:447:725: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NAME||LA10_0==EQ) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // parser/TCS.g:447:727: temp= tcs_keyword (temp= tcs_keyword )*
                            {
                            pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax1406);
                            temp=tcs_keyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "keywords", temp);
                            }
                            // parser/TCS.g:447:782: (temp= tcs_keyword )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==NAME||LA9_0==EQ) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // parser/TCS.g:447:784: temp= tcs_keyword
                            	    {
                            	    pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax1414);
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
                      _beforeSeqEl("E0DCF6CD335924400F2911DF9678EEEE93CCC8E1");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1429); if (state.failed) return ret2;
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
                    // parser/TCS.g:447:979: 
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
              _beforeSeqEl("E0DCF6CD335B954B0F2911DF85E9EEEE93CCC8E1");
            }
            // parser/TCS.g:448:77: ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==92) ) {
                alt14=1;
            }
            else if ( (LA14_0==RCURLY||LA14_0==52||LA14_0==57||LA14_0==119||LA14_0==132) ) {
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
                    // parser/TCS.g:448:78: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:448:94: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    // parser/TCS.g:448:95: 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD335B95430F2911DFCFB6EEEE93CCC8E1");
                    }
                    match(input,92,FOLLOW_92_in_tcs_concretesyntax1452); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD335B95440F2911DF96EDEEEE93CCC8E1");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1456); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD335B95480F2911DF8D33EEEE93CCC8E1");
                    }
                    // parser/TCS.g:448:321: ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) )
                    // parser/TCS.g:448:322: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    {
                    // parser/TCS.g:448:322: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    // parser/TCS.g:448:323: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD335B95460F2911DFB8DCEEEE93CCC8E1");
                    }
                    // parser/TCS.g:448:382: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==NAME||LA13_0==EQ) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // parser/TCS.g:448:384: temp= tcs_symbol (temp= tcs_symbol )*
                            {
                            pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1467);
                            temp=tcs_symbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "symbols", temp);
                            }
                            // parser/TCS.g:448:437: (temp= tcs_symbol )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==NAME||LA12_0==EQ) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // parser/TCS.g:448:439: temp= tcs_symbol
                            	    {
                            	    pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1475);
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
                      _beforeSeqEl("E0DCF6CD335B95490F2911DFBD3EEEEE93CCC8E1");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1490); if (state.failed) return ret2;
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
                    // parser/TCS.g:448:632: 
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
              _beforeSeqEl("E0DCF6CD335B954D0F2911DFA6B1EEEE93CCC8E1");
            }
            // parser/TCS.g:449:76: (temp= tcs_operatorlist (temp= tcs_operatorlist )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==132) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // parser/TCS.g:449:78: temp= tcs_operatorlist (temp= tcs_operatorlist )*
                    {
                    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1511);
                    temp=tcs_operatorlist();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operatorLists", temp);
                    }
                    // parser/TCS.g:449:143: (temp= tcs_operatorlist )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==132) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // parser/TCS.g:449:145: temp= tcs_operatorlist
                    	    {
                    	    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1519);
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
              _beforeSeqEl("E0DCF6CD335B954F0F2911DFAB08EEEE93CCC8E1");
            }
            // parser/TCS.g:449:290: (temp= tcs_token (temp= tcs_token )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==52||LA18_0==119) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // parser/TCS.g:449:292: temp= tcs_token (temp= tcs_token )*
                    {
                    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1534);
                    temp=tcs_token();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tokens", temp);
                    }
                    // parser/TCS.g:449:343: (temp= tcs_token )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==52||LA17_0==119) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // parser/TCS.g:449:345: temp= tcs_token
                    	    {
                    	    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1542);
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
              _beforeSeqEl("E0DCF6CD3369C6120F2911DF88C7EEEE93CCC8E1");
            }
            // parser/TCS.g:449:477: ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==57) ) {
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
                    // parser/TCS.g:449:478: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:449:494: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    // parser/TCS.g:449:495: 'lexer' EQ (temp= stringSymbol ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD335DDF330F2911DF9A47EEEE93CCC8E1");
                    }
                    match(input,57,FOLLOW_57_in_tcs_concretesyntax1559); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD335DDF340F2911DFA233EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1563); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33629A200F2911DFBA61EEEE93CCC8E1");
                    }
                    // parser/TCS.g:449:715: (temp= stringSymbol )
                    // parser/TCS.g:449:717: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_concretesyntax1571);
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
                      _beforeSeqEl("E0DCF6CD3369C6100F2911DF96FAEEEE93CCC8E1");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_concretesyntax1578); if (state.failed) return ret2;
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
                    // parser/TCS.g:449:885: 
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
              _beforeSeqEl("E0DCF6CD3375ACF00F2911DFCEDFEEEE93CCC8E1");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1599); if (state.failed) return ret2;
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
    // parser/TCS.g:458:1: reference[Object ret] : ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) ) ;
    public final void reference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // parser/TCS.g:459:3: ( ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) ) )
            // parser/TCS.g:460:3: ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) )
            {
            // parser/TCS.g:460:3: ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) )
            // parser/TCS.g:460:4: ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33864EC20F2911DFA4FBEEEE93CCC8E1");
            }
            // parser/TCS.g:460:64: ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) )
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
                    // parser/TCS.g:460:65: ( (temp= model_classifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:460:81: ( (temp= model_classifier ) )
                    // parser/TCS.g:460:82: (temp= model_classifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33781DF40F2911DF802CEEEE93CCC8E1");
                    }
                    // parser/TCS.g:460:141: (temp= model_classifier )
                    // parser/TCS.g:460:143: temp= model_classifier
                    {
                    pushFollow(FOLLOW_model_classifier_in_reference1644);
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
                    // parser/TCS.g:460:242: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:460:258: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? )
                    // parser/TCS.g:460:259: RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33781DF60F2911DF94EEEEEE93CCC8E1");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_reference1660); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33864EC00F2911DFB152EEEE93CCC8E1");
                    }
                    // parser/TCS.g:460:401: (temp= identifier ( ( DLCOLON ) temp= identifier )* )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==NAME) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // parser/TCS.g:460:403: temp= identifier ( ( DLCOLON ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_reference1668);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "names", temp);
                            }
                            // parser/TCS.g:460:454: ( ( DLCOLON ) temp= identifier )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==DLCOLON) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // parser/TCS.g:460:455: ( DLCOLON ) temp= identifier
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:460:472: ( DLCOLON )
                            	    // parser/TCS.g:460:473: DLCOLON
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD33781DF80F2911DFC93EEEEE93CCC8E1");
                            	    }
                            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_reference1677); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_identifier_in_reference1685);
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
    // parser/TCS.g:468:1: tcs_template returns [Object ret2] : (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate ) ;
    public final Object tcs_template() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:469:3: ( (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate ) )
            // parser/TCS.g:470:3: (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate )
            {
            // parser/TCS.g:470:3: (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 54:
            case 73:
                {
                alt23=1;
                }
                break;
            case 103:
                {
                alt23=2;
                }
                break;
            case 84:
                {
                alt23=3;
                }
                break;
            case 79:
                {
                alt23=4;
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
                    // parser/TCS.g:470:4: ret= tcs_contexttemplate
                    {
                    pushFollow(FOLLOW_tcs_contexttemplate_in_tcs_template1726);
                    ret=tcs_contexttemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:471:5: ret= tcs_primitivetemplate
                    {
                    pushFollow(FOLLOW_tcs_primitivetemplate_in_tcs_template1734);
                    ret=tcs_primitivetemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:472:5: ret= tcs_enumerationtemplate
                    {
                    pushFollow(FOLLOW_tcs_enumerationtemplate_in_tcs_template1742);
                    ret=tcs_enumerationtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
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


    // $ANTLR start "tcs_contexttemplate"
    // parser/TCS.g:480:1: tcs_contexttemplate returns [Object ret2] : (ret= tcs_classtemplate | ret= tcs_operatortemplate ) ;
    public final Object tcs_contexttemplate() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:481:3: ( (ret= tcs_classtemplate | ret= tcs_operatortemplate ) )
            // parser/TCS.g:482:3: (ret= tcs_classtemplate | ret= tcs_operatortemplate )
            {
            // parser/TCS.g:482:3: (ret= tcs_classtemplate | ret= tcs_operatortemplate )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==54) ) {
                alt24=1;
            }
            else if ( (LA24_0==73) ) {
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
                    // parser/TCS.g:482:4: ret= tcs_classtemplate
                    {
                    pushFollow(FOLLOW_tcs_classtemplate_in_tcs_contexttemplate1777);
                    ret=tcs_classtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:483:5: ret= tcs_operatortemplate
                    {
                    pushFollow(FOLLOW_tcs_operatortemplate_in_tcs_contexttemplate1785);
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
    // parser/TCS.g:490:1: tcs_primitivetemplate returns [Object ret2] : ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_primitivetemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitiveTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:495:3: ( ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:496:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:496:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:496:4: 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD339717A00F2911DFC96FEEEE93CCC8E1");
            }
            match(input,103,FOLLOW_103_in_tcs_primitivetemplate1815); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD339717A20F2911DFC2FDEEEE93CCC8E1");
            }
            // parser/TCS.g:496:157: (temp= identifier )
            // parser/TCS.g:496:159: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1822);
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
              _beforeSeqEl("E0DCF6CD339717A30F2911DF9015EEEE93CCC8E1");
            }
            match(input,106,FOLLOW_106_in_tcs_primitivetemplate1828); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD339717A40F2911DFCD53EEEE93CCC8E1");
            }
            pushFollow(FOLLOW_reference_in_tcs_primitivetemplate1831);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33A08D830F2911DFCE64EEEE93CCC8E1");
            }
            // parser/TCS.g:496:462: ( ( 'default' ) | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==70) ) {
                alt25=1;
            }
            else if ( (LA25_0==129) ) {
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
                    // parser/TCS.g:496:463: ( 'default' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:496:479: ( 'default' )
                    // parser/TCS.g:496:480: 'default'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33A08D810F2911DF9976EEEE93CCC8E1");
                    }
                    match(input,70,FOLLOW_70_in_tcs_primitivetemplate1841); if (state.failed) return ret2;
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
                    // parser/TCS.g:496:638: 
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
              _beforeSeqEl("E0DCF6CD33A2FE800F2911DFAA2AEEEE93CCC8E1");
            }
            match(input,129,FOLLOW_129_in_tcs_primitivetemplate1859); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33A2FE820F2911DF83AAEEEE93CCC8E1");
            }
            // parser/TCS.g:497:158: (temp= identifier )
            // parser/TCS.g:497:160: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1866);
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
              _beforeSeqEl("E0DCF6CD33A2FE880F2911DFC59BEEEE93CCC8E1");
            }
            // parser/TCS.g:497:291: ( ( 'orKeyword' ) | )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==96) ) {
                alt26=1;
            }
            else if ( (LA26_0==COLON) ) {
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
                    // parser/TCS.g:497:292: ( 'orKeyword' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:497:308: ( 'orKeyword' )
                    // parser/TCS.g:497:309: 'orKeyword'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33A2FE860F2911DFAE62EEEE93CCC8E1");
                    }
                    match(input,96,FOLLOW_96_in_tcs_primitivetemplate1878); if (state.failed) return ret2;
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
                    // parser/TCS.g:497:469: 
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
              _beforeSeqEl("E0DCF6CD33A2FE890F2911DFC7A7EEEE93CCC8E1");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_primitivetemplate1897); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33A2FE8A0F2911DFB5F7EEEE93CCC8E1");
            }
            match(input,123,FOLLOW_123_in_tcs_primitivetemplate1901); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33A2FE8B0F2911DF8834EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1905); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33A2FE8E0F2911DF991EEEEE93CCC8E1");
            }
            // parser/TCS.g:498:319: (temp= stringSymbol )
            // parser/TCS.g:498:321: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1913);
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
              _beforeSeqEl("E0DCF6CD33A2FE990F2911DF9055EEEE93CCC8E1");
            }
            // parser/TCS.g:498:450: ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==COMA) ) {
                alt27=1;
            }
            else if ( (LA27_0==SEMI) ) {
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
                    // parser/TCS.g:498:451: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:498:467: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:498:468: COMA 'serializer' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33A2FE920F2911DFB14DEEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_primitivetemplate1926); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33A2FE930F2911DFAC08EEEE93CCC8E1");
                    }
                    match(input,134,FOLLOW_134_in_tcs_primitivetemplate1930); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33A2FE940F2911DF8103EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1934); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33A2FE970F2911DF91EDEEEE93CCC8E1");
                    }
                    // parser/TCS.g:498:774: (temp= stringSymbol )
                    // parser/TCS.g:498:776: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1942);
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
                    // parser/TCS.g:498:868: 
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
              _beforeSeqEl("E0DCF6CD33A2FE9A0F2911DFC6EFEEEE93CCC8E1");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_primitivetemplate1962); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33AA03600F2911DFA173EEEE93CCC8E1");
            }
            // parser/TCS.g:499:157: (temp= textblockdefinition_textblockdefinition )?
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // parser/TCS.g:499:159: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_primitivetemplate1970);
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
    // parser/TCS.g:507:1: tcs_enumerationtemplate returns [Object ret2] : ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_enumerationtemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumerationTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:512:3: ( ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:513:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:513:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:513:4: 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33BD16300F2911DF8DE4EEEE93CCC8E1");
            }
            match(input,84,FOLLOW_84_in_tcs_enumerationtemplate2015); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33BD16310F2911DFCF3AEEEE93CCC8E1");
            }
            pushFollow(FOLLOW_reference_in_tcs_enumerationtemplate2018);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33BD16370F2911DFA4E9EEEE93CCC8E1");
            }
            // parser/TCS.g:513:249: ( ( 'auto' ) | )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==93) ) {
                alt29=1;
            }
            else if ( (LA29_0==SEMI||LA29_0==COLON) ) {
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
                    // parser/TCS.g:513:250: ( 'auto' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:513:266: ( 'auto' )
                    // parser/TCS.g:513:267: 'auto'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33BD16350F2911DFAFE9EEEE93CCC8E1");
                    }
                    match(input,93,FOLLOW_93_in_tcs_enumerationtemplate2028); if (state.failed) return ret2;
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
                    // parser/TCS.g:513:422: 
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
              _beforeSeqEl("E0DCF6CD33CB6E170F2911DFB73FEEEE93CCC8E1");
            }
            // parser/TCS.g:514:77: ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==COLON) ) {
                alt32=1;
            }
            else if ( (LA32_0==SEMI) ) {
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
                    // parser/TCS.g:514:78: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:514:94: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    // parser/TCS.g:514:95: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33CB6E130F2911DF9E12EEEE93CCC8E1");
                    }
                    // parser/TCS.g:514:154: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    // parser/TCS.g:514:155: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    {
                    // parser/TCS.g:514:155: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    // parser/TCS.g:514:156: COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33BD163B0F2911DFA2D0EEEE93CCC8E1");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_enumerationtemplate2056); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33CB6E100F2911DFAE52EEEE93CCC8E1");
                    }
                    // parser/TCS.g:514:297: ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) )
                    // parser/TCS.g:514:298: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    {
                    // parser/TCS.g:514:298: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    // parser/TCS.g:514:299: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33BF87300F2911DF9449EEEE93CCC8E1");
                    }
                    // parser/TCS.g:514:358: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==SHARP) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // parser/TCS.g:514:360: temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )*
                            {
                            pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2067);
                            temp=tcs_enumliteralmapping();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mappings", temp);
                            }
                            // parser/TCS.g:514:426: ( ( COMA ) temp= tcs_enumliteralmapping )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==COMA) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // parser/TCS.g:514:427: ( COMA ) temp= tcs_enumliteralmapping
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:514:444: ( COMA )
                            	    // parser/TCS.g:514:445: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD33BD163D0F2911DFAE3DEEEE93CCC8E1");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_enumerationtemplate2076); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2084);
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
                            	    break loop30;
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
                      _beforeSeqEl("E0DCF6CD33CB6E110F2911DFCFF8EEEE93CCC8E1");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate2099); if (state.failed) return ret2;
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
                    // parser/TCS.g:514:766: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:514:782: ( SEMI )
                    // parser/TCS.g:514:783: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33CB6E150F2911DFC287EEEE93CCC8E1");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate2116); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD33CB6E1A0F2911DFBFA5EEEE93CCC8E1");
            }
            // parser/TCS.g:515:76: (temp= textblockdefinition_textblockdefinition )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // parser/TCS.g:515:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_enumerationtemplate2130);
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
    // parser/TCS.g:523:1: tcs_enumliteralmapping returns [Object ret2] : ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) ) ;
    public final Object tcs_enumliteralmapping() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:528:3: ( ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) ) )
            // parser/TCS.g:529:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) )
            {
            // parser/TCS.g:529:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) )
            // parser/TCS.g:529:4: (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33CDB8010F2911DFA7BCEEEE93CCC8E1");
            }
            // parser/TCS.g:529:63: (temp= tcs_enumliteralval )
            // parser/TCS.g:529:65: temp= tcs_enumliteralval
            {
            pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping2179);
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
              _beforeSeqEl("E0DCF6CD33CDB8020F2911DFB808EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_enumliteralmapping2186); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33CDB8040F2911DF800CEEEE93CCC8E1");
            }
            // parser/TCS.g:529:280: (temp= tcs_literalref )
            // parser/TCS.g:529:282: temp= tcs_literalref
            {
            pushFollow(FOLLOW_tcs_literalref_in_tcs_enumliteralmapping2194);
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
    // parser/TCS.g:537:1: tcs_classtemplate returns [Object ret2] : ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_classtemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:542:3: ( ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:543:3: ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:543:3: ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:543:4: 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33D029000F2911DF9930EEEE93CCC8E1");
            }
            match(input,54,FOLLOW_54_in_tcs_classtemplate2237); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33D029010F2911DFBEB9EEEE93CCC8E1");
            }
            pushFollow(FOLLOW_reference_in_tcs_classtemplate2240);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33E33BD10F2911DFC8D1EEEE93CCC8E1");
            }
            // parser/TCS.g:543:238: ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==104) ) {
                alt49=1;
            }
            else if ( (LA49_0==LPAREN||LA49_0==SEMI||LA49_0==COLON||LA49_0==SHARP||LA49_0==75||(LA49_0>=90 && LA49_0<=91)||(LA49_0>=99 && LA49_0<=101)||LA49_0==105||LA49_0==111||LA49_0==113) ) {
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
                    // parser/TCS.g:543:239: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:543:255: ( 'referenceOnly' )
                    // parser/TCS.g:543:256: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33D029050F2911DFC1B6EEEE93CCC8E1");
                    }
                    match(input,104,FOLLOW_104_in_tcs_classtemplate2250); if (state.failed) return ret2;
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
                    // parser/TCS.g:543:426: ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:543:442: ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) )
                    // parser/TCS.g:543:443: ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33D29A070F2911DFA3C1EEEE93CCC8E1");
                    }
                    // parser/TCS.g:543:503: ( ( SHARP (temp= identifier ) ) | )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==SHARP) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==LPAREN||LA34_0==SEMI||LA34_0==COLON||LA34_0==75||(LA34_0>=90 && LA34_0<=91)||(LA34_0>=99 && LA34_0<=101)||LA34_0==105||LA34_0==111||LA34_0==113) ) {
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
                            // parser/TCS.g:543:504: ( SHARP (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:543:520: ( SHARP (temp= identifier ) )
                            // parser/TCS.g:543:521: SHARP (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D29A030F2911DF9D64EEEE93CCC8E1");
                            }
                            match(input,SHARP,FOLLOW_SHARP_in_tcs_classtemplate2270); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D29A050F2911DFAE31EEEE93CCC8E1");
                            }
                            // parser/TCS.g:543:662: (temp= identifier )
                            // parser/TCS.g:543:664: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_classtemplate2278);
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
                            // parser/TCS.g:543:748: 
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
                      _beforeSeqEl("E0DCF6CD33D29A130F2911DF94D1EEEE93CCC8E1");
                    }
                    // parser/TCS.g:544:77: ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==LPAREN) ) {
                        int LA35_1 = input.LA(2);

                        if ( (LA35_1==95) ) {
                            alt35=1;
                        }
                        else if ( (LA35_1==76||LA35_1==102) ) {
                            alt35=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 35, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA35_0==SEMI||LA35_0==COLON||LA35_0==75||(LA35_0>=90 && LA35_0<=91)||(LA35_0>=99 && LA35_0<=101)||LA35_0==105||LA35_0==111||LA35_0==113) ) {
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
                            // parser/TCS.g:544:78: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:544:94: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:544:95: LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D29A0B0F2911DF8021EEEE93CCC8E1");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2304); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D29A0C0F2911DFA6B5EEEE93CCC8E1");
                            }
                            match(input,95,FOLLOW_95_in_tcs_classtemplate2308); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D29A0D0F2911DFC081EEEE93CCC8E1");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2312); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D29A100F2911DFC15FEEEE93CCC8E1");
                            }
                            // parser/TCS.g:544:405: (temp= stringSymbol )
                            // parser/TCS.g:544:407: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2320);
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
                              _beforeSeqEl("E0DCF6CD33D29A110F2911DF851FEEEE93CCC8E1");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2327); if (state.failed) return ret2;
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
                            // parser/TCS.g:544:584: 
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
                      _beforeSeqEl("E0DCF6CD33D4E3F80F2911DFAE26EEEE93CCC8E1");
                    }
                    // parser/TCS.g:545:77: ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==LPAREN) ) {
                        int LA36_1 = input.LA(2);

                        if ( (LA36_1==102) ) {
                            alt36=2;
                        }
                        else if ( (LA36_1==76) ) {
                            alt36=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 36, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA36_0==SEMI||LA36_0==COLON||LA36_0==75||(LA36_0>=90 && LA36_0<=91)||(LA36_0>=99 && LA36_0<=101)||LA36_0==105||LA36_0==111||LA36_0==113) ) {
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
                            // parser/TCS.g:545:78: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:545:94: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:545:95: LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E3F00F2911DFCBD3EEEE93CCC8E1");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2351); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E3F10F2911DF929EEEEE93CCC8E1");
                            }
                            match(input,76,FOLLOW_76_in_tcs_classtemplate2355); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E3F20F2911DFBB18EEEE93CCC8E1");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2359); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E3F50F2911DF8468EEEE93CCC8E1");
                            }
                            // parser/TCS.g:545:407: (temp= stringSymbol )
                            // parser/TCS.g:545:409: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2367);
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
                              _beforeSeqEl("E0DCF6CD33D4E3F60F2911DFAD35EEEE93CCC8E1");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2374); if (state.failed) return ret2;
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
                            // parser/TCS.g:545:588: 
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
                      _beforeSeqEl("E0DCF6CD33D4E4040F2911DFB5D7EEEE93CCC8E1");
                    }
                    // parser/TCS.g:546:77: ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==LPAREN) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==SEMI||LA37_0==COLON||LA37_0==75||(LA37_0>=90 && LA37_0<=91)||(LA37_0>=99 && LA37_0<=101)||LA37_0==105||LA37_0==111||LA37_0==113) ) {
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
                            // parser/TCS.g:546:78: ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:546:94: ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:546:95: LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E3FC0F2911DFAADBEEEE93CCC8E1");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2398); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E3FD0F2911DFA712EEEE93CCC8E1");
                            }
                            match(input,102,FOLLOW_102_in_tcs_classtemplate2402); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E3FE0F2911DF88BDEEEE93CCC8E1");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2406); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E4010F2911DFBE80EEEE93CCC8E1");
                            }
                            // parser/TCS.g:546:408: (temp= stringSymbol )
                            // parser/TCS.g:546:410: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2414);
                            temp=stringSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "semDisambiguate", temp);
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E4020F2911DF8CC3EEEE93CCC8E1");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2421); if (state.failed) return ret2;
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
                            // parser/TCS.g:546:590: 
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
                      _beforeSeqEl("E0DCF6CD33D4E40A0F2911DFB2AFEEEE93CCC8E1");
                    }
                    // parser/TCS.g:547:77: ( ( 'multi' ) | )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==99) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==SEMI||LA38_0==COLON||LA38_0==75||(LA38_0>=90 && LA38_0<=91)||(LA38_0>=100 && LA38_0<=101)||LA38_0==105||LA38_0==111||LA38_0==113) ) {
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
                            // parser/TCS.g:547:78: ( 'multi' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:547:94: ( 'multi' )
                            // parser/TCS.g:547:95: 'multi'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D4E4080F2911DF8F9EEEEE93CCC8E1");
                            }
                            match(input,99,FOLLOW_99_in_tcs_classtemplate2444); if (state.failed) return ret2;
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
                            // parser/TCS.g:547:249: 
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
                      _beforeSeqEl("E0DCF6CD33D754F50F2911DF8BA8EEEE93CCC8E1");
                    }
                    // parser/TCS.g:548:77: ( ( 'main' ) | )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==100) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==SEMI||LA39_0==COLON||LA39_0==75||(LA39_0>=90 && LA39_0<=91)||LA39_0==101||LA39_0==105||LA39_0==111||LA39_0==113) ) {
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
                            // parser/TCS.g:548:78: ( 'main' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:548:94: ( 'main' )
                            // parser/TCS.g:548:95: 'main'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D754F30F2911DFC6E8EEEE93CCC8E1");
                            }
                            match(input,100,FOLLOW_100_in_tcs_classtemplate2468); if (state.failed) return ret2;
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
                            // parser/TCS.g:548:247: 
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
                      _beforeSeqEl("E0DCF6CD33D755010F2911DFBF0EEEEE93CCC8E1");
                    }
                    // parser/TCS.g:549:77: ( ( ( ( 'deep' ) | ) 'abstract' ) | )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==75||LA41_0==90) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==SEMI||LA41_0==COLON||LA41_0==91||LA41_0==101||LA41_0==105||LA41_0==111||LA41_0==113) ) {
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
                            // parser/TCS.g:549:78: ( ( ( 'deep' ) | ) 'abstract' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:549:94: ( ( ( 'deep' ) | ) 'abstract' )
                            // parser/TCS.g:549:95: ( ( 'deep' ) | ) 'abstract'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D754FE0F2911DFC92DEEEE93CCC8E1");
                            }
                            // parser/TCS.g:549:155: ( ( 'deep' ) | )
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==75) ) {
                                alt40=1;
                            }
                            else if ( (LA40_0==90) ) {
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
                                    // parser/TCS.g:549:156: ( 'deep' )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:549:172: ( 'deep' )
                                    // parser/TCS.g:549:173: 'deep'
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD33D754FC0F2911DF8375EEEE93CCC8E1");
                                    }
                                    match(input,75,FOLLOW_75_in_tcs_classtemplate2498); if (state.failed) return ret2;
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
                                    // parser/TCS.g:549:325: 
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
                              _beforeSeqEl("E0DCF6CD33D754FF0F2911DFA4AEEEEE93CCC8E1");
                            }
                            match(input,90,FOLLOW_90_in_tcs_classtemplate2516); if (state.failed) return ret2;
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
                            // parser/TCS.g:550:177: 
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
                      _beforeSeqEl("E0DCF6CD33DE80E50F2911DFAAEFEEEE93CCC8E1");
                    }
                    // parser/TCS.g:551:77: ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==111) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==SEMI||LA43_0==COLON||LA43_0==91||LA43_0==101||LA43_0==105||LA43_0==113) ) {
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
                            // parser/TCS.g:551:78: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:551:94: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            // parser/TCS.g:551:95: 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33D755050F2911DFCF19EEEE93CCC8E1");
                            }
                            match(input,111,FOLLOW_111_in_tcs_classtemplate2540); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33DE80E30F2911DFCA31EEEE93CCC8E1");
                            }
                            // parser/TCS.g:551:242: ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            int alt42=2;
                            int LA42_0 = input.LA(1);

                            if ( (LA42_0==LPAREN) ) {
                                alt42=1;
                            }
                            else if ( (LA42_0==SEMI||LA42_0==COLON||LA42_0==91||LA42_0==101||LA42_0==105||LA42_0==113) ) {
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
                                    // parser/TCS.g:551:243: ( LPAREN (temp= identifier ) RPAREN )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:551:259: ( LPAREN (temp= identifier ) RPAREN )
                                    // parser/TCS.g:551:260: LPAREN (temp= identifier ) RPAREN
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD33D755090F2911DF89E9EEEE93CCC8E1");
                                    }
                                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2550); if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD33DE80E00F2911DFAE51EEEE93CCC8E1");
                                    }
                                    // parser/TCS.g:551:402: (temp= identifier )
                                    // parser/TCS.g:551:404: temp= identifier
                                    {
                                    pushFollow(FOLLOW_identifier_in_tcs_classtemplate2558);
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
                                      _beforeSeqEl("E0DCF6CD33DE80E10F2911DFA42CEEEE93CCC8E1");
                                    }
                                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2565); if (state.failed) return ret2;
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
                                    // parser/TCS.g:551:644: 
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
                            // parser/TCS.g:552:94: 
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
                      _beforeSeqEl("E0DCF6CD33E0CAD30F2911DFB7A7EEEE93CCC8E1");
                    }
                    // parser/TCS.g:553:77: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==91) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==SEMI||LA45_0==COLON||LA45_0==101||LA45_0==105||LA45_0==113) ) {
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
                            // parser/TCS.g:553:78: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:553:94: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            // parser/TCS.g:553:95: 'context' ( ( (temp= tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33DE80E90F2911DF8288EEEE93CCC8E1");
                            }
                            match(input,91,FOLLOW_91_in_tcs_classtemplate2603); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33E0CAD10F2911DFAEA5EEEE93CCC8E1");
                            }
                            // parser/TCS.g:553:239: ( ( (temp= tcs_contexttags ) ) | )
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( (LA44_0==LPAREN) ) {
                                alt44=1;
                            }
                            else if ( (LA44_0==SEMI||LA44_0==COLON||LA44_0==101||LA44_0==105||LA44_0==113) ) {
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
                                    // parser/TCS.g:553:240: ( (temp= tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:553:256: ( (temp= tcs_contexttags ) )
                                    // parser/TCS.g:553:257: (temp= tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD33DE80EE0F2911DFB0C5EEEE93CCC8E1");
                                    }
                                    // parser/TCS.g:553:316: (temp= tcs_contexttags )
                                    // parser/TCS.g:553:318: temp= tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_tcs_contexttags_in_tcs_classtemplate2616);
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
                                    // parser/TCS.g:553:414: 
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
                            // parser/TCS.g:554:91: 
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
                      _beforeSeqEl("E0DCF6CD33E0CAD90F2911DFB1F8EEEE93CCC8E1");
                    }
                    // parser/TCS.g:555:77: ( ( 'addToContext' ) | )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==101) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==SEMI||LA46_0==COLON||LA46_0==105||LA46_0==113) ) {
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
                            // parser/TCS.g:555:78: ( 'addToContext' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:555:94: ( 'addToContext' )
                            // parser/TCS.g:555:95: 'addToContext'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33E0CAD70F2911DF944AEEEE93CCC8E1");
                            }
                            match(input,101,FOLLOW_101_in_tcs_classtemplate2656); if (state.failed) return ret2;
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
                            // parser/TCS.g:555:263: 
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
                      _beforeSeqEl("E0DCF6CD33E0CADF0F2911DFABB6EEEE93CCC8E1");
                    }
                    // parser/TCS.g:556:77: ( ( 'nonPrimary' ) | )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==113) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==SEMI||LA47_0==COLON||LA47_0==105) ) {
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
                            // parser/TCS.g:556:78: ( 'nonPrimary' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:556:94: ( 'nonPrimary' )
                            // parser/TCS.g:556:95: 'nonPrimary'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33E0CADD0F2911DFBE70EEEE93CCC8E1");
                            }
                            match(input,113,FOLLOW_113_in_tcs_classtemplate2680); if (state.failed) return ret2;
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
                            // parser/TCS.g:556:259: 
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
                      _beforeSeqEl("E0DCF6CD33E0CAED0F2911DF860FEEEE93CCC8E1");
                    }
                    // parser/TCS.g:557:77: ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==105) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==SEMI||LA48_0==COLON) ) {
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
                            // parser/TCS.g:557:78: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:557:94: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                            // parser/TCS.g:557:95: 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33E0CAE30F2911DF8CB4EEEE93CCC8E1");
                            }
                            match(input,105,FOLLOW_105_in_tcs_classtemplate2704); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33E0CAEB0F2911DFA13EEEEE93CCC8E1");
                            }
                            // parser/TCS.g:557:237: ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                            // parser/TCS.g:557:238: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                            {
                            // parser/TCS.g:557:238: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                            // parser/TCS.g:557:239: COLON ( ( (temp= tcs_sequence ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33E0CAE40F2911DF8335EEEE93CCC8E1");
                            }
                            match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2711); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33E0CAE90F2911DFA2FEEEEE93CCC8E1");
                            }
                            // parser/TCS.g:557:380: ( ( (temp= tcs_sequence ) ) )
                            // parser/TCS.g:557:381: ( (temp= tcs_sequence ) )
                            {
                            // parser/TCS.g:557:381: ( (temp= tcs_sequence ) )
                            // parser/TCS.g:557:382: (temp= tcs_sequence )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33E0CAE60F2911DFB992EEEE93CCC8E1");
                            }
                            // parser/TCS.g:557:441: (temp= tcs_sequence )
                            // parser/TCS.g:557:443: temp= tcs_sequence
                            {
                            pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2722);
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
                            // parser/TCS.g:557:575: 
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
              _beforeSeqEl("E0DCF6CD33E585C40F2911DFC23CEEEE93CCC8E1");
            }
            // parser/TCS.g:559:77: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==COLON) ) {
                alt50=1;
            }
            else if ( (LA50_0==SEMI) ) {
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
                    // parser/TCS.g:559:78: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:559:94: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // parser/TCS.g:559:95: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33E585C00F2911DF9937EEEE93CCC8E1");
                    }
                    // parser/TCS.g:559:154: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // parser/TCS.g:559:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // parser/TCS.g:559:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // parser/TCS.g:559:156: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33E33BD50F2911DF9570EEEE93CCC8E1");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2764); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33E33BDA0F2911DFCA94EEEE93CCC8E1");
                    }
                    // parser/TCS.g:559:297: ( ( (temp= tcs_sequence ) ) )
                    // parser/TCS.g:559:298: ( (temp= tcs_sequence ) )
                    {
                    // parser/TCS.g:559:298: ( (temp= tcs_sequence ) )
                    // parser/TCS.g:559:299: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33E33BD70F2911DFCCC0EEEE93CCC8E1");
                    }
                    // parser/TCS.g:559:358: (temp= tcs_sequence )
                    // parser/TCS.g:559:360: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2775);
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
                      _beforeSeqEl("E0DCF6CD33E33BDB0F2911DFCF1EEEEE93CCC8E1");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2785); if (state.failed) return ret2;
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
                    // parser/TCS.g:559:575: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:559:591: ( SEMI )
                    // parser/TCS.g:559:592: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33E585C20F2911DFA3A7EEEE93CCC8E1");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2802); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD33E585C70F2911DFC4A3EEEE93CCC8E1");
            }
            // parser/TCS.g:560:76: (temp= textblockdefinition_textblockdefinition )?
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // parser/TCS.g:560:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_classtemplate2816);
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
    // parser/TCS.g:568:1: tcs_operatortemplate returns [Object ret2] : ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_operatortemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:573:3: ( ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:574:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:574:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:574:4: 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EA00F2911DF99F5EEEE93CCC8E1");
            }
            match(input,73,FOLLOW_73_in_tcs_operatortemplate2861); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EA10F2911DF8810EEEE93CCC8E1");
            }
            pushFollow(FOLLOW_reference_in_tcs_operatortemplate2864);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EA20F2911DF8CF5EEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_operatortemplate2869); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EA30F2911DFCABBEEEE93CCC8E1");
            }
            match(input,132,FOLLOW_132_in_tcs_operatortemplate2873); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EA40F2911DFB8FAEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2877); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EA70F2911DF95A2EEEE93CCC8E1");
            }
            // parser/TCS.g:574:493: (temp= identifier (temp= identifier )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==NAME) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // parser/TCS.g:574:495: temp= identifier (temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2885);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);
                    }
                    // parser/TCS.g:574:611: (temp= identifier )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==NAME) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // parser/TCS.g:574:613: temp= identifier
                    	    {
                    	    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2893);
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
              _beforeSeqEl("E0DCF6CD33F64EA80F2911DF891FEEEE93CCC8E1");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2905); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EA90F2911DFCA38EEEE93CCC8E1");
            }
            match(input,126,FOLLOW_126_in_tcs_operatortemplate2909); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EAA0F2911DFCAF0EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2913); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33F64EAC0F2911DF8250EEEE93CCC8E1");
            }
            // parser/TCS.g:574:1052: (temp= tcs_propertyreference )
            // parser/TCS.g:574:1054: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2921);
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
              _beforeSeqEl("E0DCF6CD33F64EB60F2911DF8A6DEEEE93CCC8E1");
            }
            // parser/TCS.g:574:1202: ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==COMA) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==76||LA54_1==85||LA54_1==95) ) {
                    alt54=2;
                }
                else if ( (LA54_1==89) ) {
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
                    // parser/TCS.g:574:1203: ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:574:1219: ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) )
                    // parser/TCS.g:574:1220: COMA 'storeOpTo' EQ (temp= tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F64EB00F2911DFB023EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2934); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F64EB10F2911DFAC36EEEE93CCC8E1");
                    }
                    match(input,89,FOLLOW_89_in_tcs_operatortemplate2938); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F64EB20F2911DF806AEEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2942); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F64EB40F2911DFC610EEEE93CCC8E1");
                    }
                    // parser/TCS.g:574:1525: (temp= tcs_propertyreference )
                    // parser/TCS.g:574:1527: temp= tcs_propertyreference
                    {
                    pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2950);
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
                    // parser/TCS.g:574:1633: 
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
              _beforeSeqEl("E0DCF6CD33F898930F2911DFA217EEEE93CCC8E1");
            }
            // parser/TCS.g:575:77: ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==COMA) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==76||LA55_1==95) ) {
                    alt55=2;
                }
                else if ( (LA55_1==85) ) {
                    alt55=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 1, input);

                    throw nvae;
                }
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
                    // parser/TCS.g:575:78: ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:575:94: ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) )
                    // parser/TCS.g:575:95: COMA 'storeRightTo' EQ (temp= tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F64EBA0F2911DF8324EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2976); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F64EBB0F2911DFADE6EEEE93CCC8E1");
                    }
                    match(input,85,FOLLOW_85_in_tcs_operatortemplate2980); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F64EBC0F2911DF95EEEEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2984); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898910F2911DFC6DFEEEE93CCC8E1");
                    }
                    // parser/TCS.g:575:403: (temp= tcs_propertyreference )
                    // parser/TCS.g:575:405: temp= tcs_propertyreference
                    {
                    pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2992);
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
                    // parser/TCS.g:575:512: 
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
              _beforeSeqEl("E0DCF6CD33F8989E0F2911DF80CAEEEE93CCC8E1");
            }
            // parser/TCS.g:576:77: ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==COMA) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==76) ) {
                    alt56=2;
                }
                else if ( (LA56_1==95) ) {
                    alt56=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA56_0==RPAREN) ) {
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
                    // parser/TCS.g:576:78: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:576:94: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:576:95: COMA 'disambiguate' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898970F2911DFB0D3EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate3018); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898980F2911DFA757EEEE93CCC8E1");
                    }
                    match(input,95,FOLLOW_95_in_tcs_operatortemplate3022); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898990F2911DFAAA5EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate3026); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F8989C0F2911DF9540EEEE93CCC8E1");
                    }
                    // parser/TCS.g:576:403: (temp= stringSymbol )
                    // parser/TCS.g:576:405: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate3034);
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
                    // parser/TCS.g:576:499: 
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
              _beforeSeqEl("E0DCF6CD33F898A90F2911DF88D9EEEE93CCC8E1");
            }
            // parser/TCS.g:577:77: ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==COMA) ) {
                alt57=1;
            }
            else if ( (LA57_0==RPAREN) ) {
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
                    // parser/TCS.g:577:78: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:577:94: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:577:95: COMA 'disambiguateV3' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898A20F2911DF8431EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate3060); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898A30F2911DFB2FEEEEE93CCC8E1");
                    }
                    match(input,76,FOLLOW_76_in_tcs_operatortemplate3064); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898A40F2911DFA9C8EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate3068); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898A70F2911DF8376EEEE93CCC8E1");
                    }
                    // parser/TCS.g:577:405: (temp= stringSymbol )
                    // parser/TCS.g:577:407: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate3076);
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
                    // parser/TCS.g:577:503: 
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
              _beforeSeqEl("E0DCF6CD33F898AA0F2911DFAC12EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_operatortemplate3096); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FB099E0F2911DFB671EEEE93CCC8E1");
            }
            // parser/TCS.g:578:160: ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==104) ) {
                alt60=1;
            }
            else if ( (LA60_0==SEMI||LA60_0==COLON||LA60_0==91) ) {
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
                    // parser/TCS.g:578:161: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:578:177: ( 'referenceOnly' )
                    // parser/TCS.g:578:178: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33F898AE0F2911DF9C46EEEE93CCC8E1");
                    }
                    match(input,104,FOLLOW_104_in_tcs_operatortemplate3106); if (state.failed) return ret2;
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
                    // parser/TCS.g:578:348: ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:578:364: ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) )
                    // parser/TCS.g:578:365: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33FB099C0F2911DFAC2EEEEE93CCC8E1");
                    }
                    // parser/TCS.g:578:425: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==91) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==SEMI||LA59_0==COLON) ) {
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
                            // parser/TCS.g:578:426: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:578:442: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            // parser/TCS.g:578:443: 'context' ( ( (temp= tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33FB09930F2911DF86CFEEEE93CCC8E1");
                            }
                            match(input,91,FOLLOW_91_in_tcs_operatortemplate3125); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD33FB099A0F2911DF8B0AEEEE93CCC8E1");
                            }
                            // parser/TCS.g:578:587: ( ( (temp= tcs_contexttags ) ) | )
                            int alt58=2;
                            int LA58_0 = input.LA(1);

                            if ( (LA58_0==LPAREN) ) {
                                alt58=1;
                            }
                            else if ( (LA58_0==SEMI||LA58_0==COLON) ) {
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
                                    // parser/TCS.g:578:588: ( (temp= tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:578:604: ( (temp= tcs_contexttags ) )
                                    // parser/TCS.g:578:605: (temp= tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CD33FB09980F2911DF9F8BEEEE93CCC8E1");
                                    }
                                    // parser/TCS.g:578:664: (temp= tcs_contexttags )
                                    // parser/TCS.g:578:666: temp= tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_tcs_contexttags_in_tcs_operatortemplate3138);
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
                                    // parser/TCS.g:578:762: 
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
                            // parser/TCS.g:579:91: 
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
              _beforeSeqEl("E0DCF6CD33FB09AE0F2911DFA969EEEE93CCC8E1");
            }
            // parser/TCS.g:581:77: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==COLON) ) {
                alt61=1;
            }
            else if ( (LA61_0==SEMI) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // parser/TCS.g:581:78: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:581:94: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // parser/TCS.g:581:95: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33FB09AA0F2911DF8E0BEEEE93CCC8E1");
                    }
                    // parser/TCS.g:581:154: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // parser/TCS.g:581:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // parser/TCS.g:581:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // parser/TCS.g:581:156: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33FB09A20F2911DFC2FAEEEE93CCC8E1");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_operatortemplate3189); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33FB09A70F2911DFCAFAEEEE93CCC8E1");
                    }
                    // parser/TCS.g:581:297: ( ( (temp= tcs_sequence ) ) )
                    // parser/TCS.g:581:298: ( (temp= tcs_sequence ) )
                    {
                    // parser/TCS.g:581:298: ( (temp= tcs_sequence ) )
                    // parser/TCS.g:581:299: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33FB09A40F2911DF9406EEEE93CCC8E1");
                    }
                    // parser/TCS.g:581:358: (temp= tcs_sequence )
                    // parser/TCS.g:581:360: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_operatortemplate3200);
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
                      _beforeSeqEl("E0DCF6CD33FB09A80F2911DFAF9CEEEE93CCC8E1");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate3210); if (state.failed) return ret2;
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
                    // parser/TCS.g:581:569: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:581:585: ( SEMI )
                    // parser/TCS.g:581:586: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD33FB09AC0F2911DFA72DEEEE93CCC8E1");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate3227); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD33FB09B10F2911DF86BDEEEE93CCC8E1");
            }
            // parser/TCS.g:582:76: (temp= textblockdefinition_textblockdefinition )?
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // parser/TCS.g:582:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_operatortemplate3241);
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
    // parser/TCS.g:590:1: tcs_functiontemplate returns [Object ret2] : ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) ;
    public final Object tcs_functiontemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:595:3: ( ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) )
            // parser/TCS.g:596:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            {
            // parser/TCS.g:596:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            // parser/TCS.g:596:4: 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FD53820F2911DF80D7EEEE93CCC8E1");
            }
            match(input,79,FOLLOW_79_in_tcs_functiontemplate3286); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FD53840F2911DFA92BEEEE93CCC8E1");
            }
            // parser/TCS.g:596:148: (temp= identifier )
            // parser/TCS.g:596:150: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functiontemplate3293);
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
              _beforeSeqEl("E0DCF6CD33FD53850F2911DF9BB1EEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_functiontemplate3300); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FD53860F2911DF9A6FEEEE93CCC8E1");
            }
            pushFollow(FOLLOW_reference_in_tcs_functiontemplate3304);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FD53870F2911DF8B88EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_functiontemplate3309); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FFC4840F2911DF98F5EEEE93CCC8E1");
            }
            // parser/TCS.g:596:538: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            // parser/TCS.g:596:539: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            {
            // parser/TCS.g:596:539: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            // parser/TCS.g:596:540: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FD53880F2911DFCCFAEEEE93CCC8E1");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_functiontemplate3317); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FFC4810F2911DFC303EEEE93CCC8E1");
            }
            // parser/TCS.g:596:681: ( ( (temp= tcs_sequence ) ) )
            // parser/TCS.g:596:682: ( (temp= tcs_sequence ) )
            {
            // parser/TCS.g:596:682: ( (temp= tcs_sequence ) )
            // parser/TCS.g:596:683: (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FD538A0F2911DF9811EEEE93CCC8E1");
            }
            // parser/TCS.g:596:742: (temp= tcs_sequence )
            // parser/TCS.g:596:744: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_functiontemplate3328);
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
              _beforeSeqEl("E0DCF6CD33FFC4820F2911DFC8DEEEEE93CCC8E1");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_functiontemplate3338); if (state.failed) return ret2;
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
    // parser/TCS.g:604:1: tcs_contexttags returns [Object ret2] : ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) ;
    public final Object tcs_contexttags() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ContextTags");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:609:3: ( ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) )
            // parser/TCS.g:610:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            {
            // parser/TCS.g:610:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            // parser/TCS.g:610:4: LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD33FFC4880F2911DF9D7EEEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_contexttags3383); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD340235810F2911DFCFDFEEEE93CCC8E1");
            }
            // parser/TCS.g:610:146: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==NAME) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // parser/TCS.g:610:148: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_contexttags3391);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tags", temp);
                    }
                    // parser/TCS.g:610:198: ( ( COMA ) temp= identifier )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==COMA) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // parser/TCS.g:610:199: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:610:216: ( COMA )
                    	    // parser/TCS.g:610:217: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD33FFC48A0F2911DF829EEEEE93CCC8E1");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_tcs_contexttags3400); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_tcs_contexttags3408);
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
                    	    break loop63;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD340235820F2911DFBD31EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_contexttags3420); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:618:1: tcs_sequence__impl returns [Object ret2] : ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequence__impl() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Sequence");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:623:3: ( ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // parser/TCS.g:624:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // parser/TCS.g:624:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // parser/TCS.g:624:4: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD340235870F2911DF9D91EEEE93CCC8E1");
            }
            // parser/TCS.g:624:63: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=NAME && LA66_0<=STRING)||LA66_0==LPAREN||LA66_0==RARROW||LA66_0==LT||LA66_0==LSQUARE||LA66_0==DLSQUARE||(LA66_0>=DOLLAR && LA66_0<=DLCURLY)||(LA66_0>=49 && LA66_0<=134)) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // parser/TCS.g:624:65: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3465);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // parser/TCS.g:624:128: (temp= tcs_sequenceelement )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( ((LA65_0>=NAME && LA65_0<=STRING)||LA65_0==LPAREN||LA65_0==RARROW||LA65_0==LT||LA65_0==LSQUARE||LA65_0==DLSQUARE||(LA65_0>=DOLLAR && LA65_0<=DLCURLY)||(LA65_0>=49 && LA65_0<=134)) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // parser/TCS.g:624:130: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3473);
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
                    	    break loop65;
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
    // parser/TCS.g:632:1: tcs_sequence returns [Object ret2] : (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) ) ;
    public final Object tcs_sequence() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:633:3: ( (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) ) )
            // parser/TCS.g:634:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )
            {
            // parser/TCS.g:634:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )
            int alt67=2;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // parser/TCS.g:634:4: ret= tcs_sequence__impl
                    {
                    pushFollow(FOLLOW_tcs_sequence__impl_in_tcs_sequence3518);
                    ret=tcs_sequence__impl();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:634:27: (ret= tcs_sequenceinalternative )
                    {
                    // parser/TCS.g:634:27: (ret= tcs_sequenceinalternative )
                    // parser/TCS.g:634:28: ret= tcs_sequenceinalternative
                    {
                    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_sequence3523);
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
    // parser/TCS.g:641:1: tcs_sequenceelement returns [Object ret2] : (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock ) ;
    public final Object tcs_sequenceelement() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:642:3: ( (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock ) )
            // parser/TCS.g:643:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock )
            {
            // parser/TCS.g:643:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock )
            int alt68=8;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt68=1;
                }
                break;
            case NAME:
            case RARROW:
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
            case 133:
            case 134:
                {
                alt68=2;
                }
                break;
            case LT:
                {
                alt68=3;
                }
                break;
            case LSQUARE:
                {
                alt68=4;
                }
                break;
            case LPAREN:
                {
                alt68=5;
                }
                break;
            case DLSQUARE:
                {
                alt68=6;
                }
                break;
            case DOLLAR:
                {
                alt68=7;
                }
                break;
            case DLCURLY:
                {
                alt68=8;
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
                    // parser/TCS.g:643:4: ret= tcs_literalref
                    {
                    pushFollow(FOLLOW_tcs_literalref_in_tcs_sequenceelement3552);
                    ret=tcs_literalref();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:644:5: ret= tcs_property
                    {
                    pushFollow(FOLLOW_tcs_property_in_tcs_sequenceelement3560);
                    ret=tcs_property();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:645:5: ret= tcs_customseparator
                    {
                    pushFollow(FOLLOW_tcs_customseparator_in_tcs_sequenceelement3568);
                    ret=tcs_customseparator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:646:5: ret= tcs_block
                    {
                    pushFollow(FOLLOW_tcs_block_in_tcs_sequenceelement3576);
                    ret=tcs_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:647:5: ret= tcs_conditionalelement
                    {
                    pushFollow(FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement3584);
                    ret=tcs_conditionalelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:648:5: ret= tcs_alternative
                    {
                    pushFollow(FOLLOW_tcs_alternative_in_tcs_sequenceelement3592);
                    ret=tcs_alternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:649:5: ret= tcs_functioncall
                    {
                    pushFollow(FOLLOW_tcs_functioncall_in_tcs_sequenceelement3600);
                    ret=tcs_functioncall();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:650:5: ret= tcs_injectoractionsblock
                    {
                    pushFollow(FOLLOW_tcs_injectoractionsblock_in_tcs_sequenceelement3608);
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
    // parser/TCS.g:657:1: tcs_literalref returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_literalref() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LiteralRef");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:662:3: ( ( (temp= stringSymbol ) ) )
            // parser/TCS.g:663:3: ( (temp= stringSymbol ) )
            {
            // parser/TCS.g:663:3: ( (temp= stringSymbol ) )
            // parser/TCS.g:663:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD343B46E00F2911DFA498EEEE93CCC8E1");
            }
            // parser/TCS.g:663:63: (temp= stringSymbol )
            // parser/TCS.g:663:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_literalref3642);
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
              _beforeSeqEl("E0DCF6CD3450CAB00F2911DFB413EEEE93CCC8E1");
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
    // parser/TCS.g:671:1: tcs_propertyreference returns [Object ret2] : ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) ) ;
    public final Object tcs_propertyreference() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PropertyReference");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:676:3: ( ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) ) )
            // parser/TCS.g:677:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) )
            {
            // parser/TCS.g:677:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) )
            // parser/TCS.g:677:4: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346627760F2911DFA774EEEE93CCC8E1");
            }
            // parser/TCS.g:677:64: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==NAME||(LA70_0>=49 && LA70_0<=134)) ) {
                alt70=1;
            }
            else if ( (LA70_0==RARROW) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // parser/TCS.g:677:65: ( (temp= identifierOrKeyword ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:677:81: ( (temp= identifierOrKeyword ) )
                    // parser/TCS.g:677:82: (temp= identifierOrKeyword )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3463B6720F2911DFA2EEEEEE93CCC8E1");
                    }
                    // parser/TCS.g:677:141: (temp= identifierOrKeyword )
                    // parser/TCS.g:677:143: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_propertyreference3698);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"                                                let result = c.lookupElementExtended(?) in"+"                                                if not (result.oclIsInvalid()) then"+"                                                        if(result.oclIsTypeOf(Model::Attribute) or"+"                                                                        result.oclIsTypeOf(Model::Reference)"+"                                                                        or result.oclIsTypeOf(Model::StructureField)) then"+"                                                                Bag{result}     "+"                                                        else            "+"                                                                c.allSupertypes()->prepend(c)->collect("+"                                                                        st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                                te | "+"                                                                                        if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                                te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                        else            "+"                                                                                                false "+"                                                                                        endif"+"                                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"                                                                )"+"                                                        endif "+"                                                else    "+"                                                        c.allSupertypes()->prepend(c)->collect("+"                                                                st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                        te | "+"                                                                                if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                        te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                else"+"                                                                                        false "+"                                                                                endif"+"                                                                        )"+"                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"                                                        ) "+"                                                endif"+"                                                        ");
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
                    // parser/TCS.g:677:3487: ( RARROW (temp= identifierOrKeyword )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:677:3503: ( RARROW (temp= identifierOrKeyword )? )
                    // parser/TCS.g:677:3504: RARROW (temp= identifierOrKeyword )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346627710F2911DFC74BEEEE93CCC8E1");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_tcs_propertyreference3714); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346627740F2911DFC661EEEE93CCC8E1");
                    }
                    // parser/TCS.g:677:3646: (temp= identifierOrKeyword )?
                    int alt69=2;
                    alt69 = dfa69.predict(input);
                    switch (alt69) {
                        case 1 :
                            // parser/TCS.g:677:3648: temp= identifierOrKeyword
                            {
                            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_propertyreference3722);
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
    // parser/TCS.g:686:1: tcs_property returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_property() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Property");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:691:3: ( ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) )
            // parser/TCS.g:692:3: ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            {
            // parser/TCS.g:692:3: ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            // parser/TCS.g:692:4: (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3466277B0F2911DFA78AEEEE93CCC8E1");
            }
            // parser/TCS.g:692:63: (temp= tcs_propertyreference )
            // parser/TCS.g:692:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_property3777);
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
              _beforeSeqEl("E0DCF6CD3468987B0F2911DF8DF1EEEE93CCC8E1");
            }
            // parser/TCS.g:692:215: ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==LCURLY) ) {
                alt73=1;
            }
            else if ( (LA73_0==EOF||(LA73_0>=NAME && LA73_0<=STRING)||(LA73_0>=LPAREN && LA73_0<=RPAREN)||(LA73_0>=RCURLY && LA73_0<=COMA)||LA73_0==LT||(LA73_0>=LSQUARE && LA73_0<=RSQUARE)||(LA73_0>=DLSQUARE && LA73_0<=DRSQUARE)||(LA73_0>=DOLLAR && LA73_0<=DLCURLY)||(LA73_0>=49 && LA73_0<=134)) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // parser/TCS.g:692:216: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:692:232: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    // parser/TCS.g:692:233: LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346898730F2911DFCF8CEEEE93CCC8E1");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_property3790); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346898780F2911DFAE2DEEEE93CCC8E1");
                    }
                    // parser/TCS.g:692:375: (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )?
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==51||LA72_0==53||LA72_0==56||LA72_0==61||LA72_0==63||LA72_0==67||LA72_0==71||LA72_0==74||LA72_0==87||LA72_0==95||LA72_0==98||LA72_0==114||LA72_0==121||LA72_0==127||LA72_0==133) ) {
                        alt72=1;
                    }
                    switch (alt72) {
                        case 1 :
                            // parser/TCS.g:692:377: temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )*
                            {
                            pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property3798);
                            temp=tcs_propertyarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "propertyArgs", temp);
                            }
                            // parser/TCS.g:692:440: ( ( COMA ) temp= tcs_propertyarg )*
                            loop71:
                            do {
                                int alt71=2;
                                int LA71_0 = input.LA(1);

                                if ( (LA71_0==COMA) ) {
                                    alt71=1;
                                }


                                switch (alt71) {
                            	case 1 :
                            	    // parser/TCS.g:692:441: ( COMA ) temp= tcs_propertyarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:692:458: ( COMA )
                            	    // parser/TCS.g:692:459: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD346898750F2911DF9A6EEEEE93CCC8E1");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_property3807); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property3815);
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
                            	    break loop71;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346898790F2911DFA37CEEEE93CCC8E1");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_property3827); if (state.failed) return ret2;
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
                    // parser/TCS.g:692:743: 
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
              _beforeSeqEl("E0DCF6CD3468987E0F2911DF9D75EEEE93CCC8E1");
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
    // parser/TCS.g:701:1: tcs_customseparator returns [Object ret2] : ( LT (temp= identifier ) GT ) ;
    public final Object tcs_customseparator() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CustomSeparator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:706:3: ( ( LT (temp= identifier ) GT ) )
            // parser/TCS.g:707:3: ( LT (temp= identifier ) GT )
            {
            // parser/TCS.g:707:3: ( LT (temp= identifier ) GT )
            // parser/TCS.g:707:4: LT (temp= identifier ) GT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346898820F2911DFB874EEEE93CCC8E1");
            }
            match(input,LT,FOLLOW_LT_in_tcs_customseparator3885); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346898840F2911DFA7C9EEEE93CCC8E1");
            }
            // parser/TCS.g:707:142: (temp= identifier )
            // parser/TCS.g:707:144: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_customseparator3893);
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
              _beforeSeqEl("E0DCF6CD346898850F2911DF9CEFEEEE93CCC8E1");
            }
            match(input,GT,FOLLOW_GT_in_tcs_customseparator3900); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346AE2620F2911DFB79EEEEE93CCC8E1");
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
    // parser/TCS.g:715:1: tcs_block returns [Object ret2] : ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_block() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:720:3: ( ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) )
            // parser/TCS.g:721:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            {
            // parser/TCS.g:721:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            // parser/TCS.g:721:4: LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346AE2660F2911DF872CEEEE93CCC8E1");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_block3945); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346AE2680F2911DFB3CEEEEE93CCC8E1");
            }
            // parser/TCS.g:721:147: (temp= tcs_sequence )
            // parser/TCS.g:721:149: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_block3953);
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
              _beforeSeqEl("E0DCF6CD346AE2690F2911DFA61AEEEE93CCC8E1");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_block3960); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346D53620F2911DFBCD8EEEE93CCC8E1");
            }
            // parser/TCS.g:721:370: ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==LCURLY) ) {
                alt76=1;
            }
            else if ( (LA76_0==EOF||(LA76_0>=NAME && LA76_0<=STRING)||(LA76_0>=LPAREN && LA76_0<=RPAREN)||(LA76_0>=RCURLY && LA76_0<=COMA)||LA76_0==LT||(LA76_0>=LSQUARE && LA76_0<=RSQUARE)||(LA76_0>=DLSQUARE && LA76_0<=DRSQUARE)||(LA76_0>=DOLLAR && LA76_0<=DLCURLY)||(LA76_0>=49 && LA76_0<=134)) ) {
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
                    // parser/TCS.g:721:371: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:721:387: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    // parser/TCS.g:721:388: LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346AE26D0F2911DF87EBEEEE93CCC8E1");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_block3971); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346AE2720F2911DF98C3EEEE93CCC8E1");
                    }
                    // parser/TCS.g:721:530: (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==78||LA75_0==115||LA75_0==120||(LA75_0>=130 && LA75_0<=131)) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // parser/TCS.g:721:532: temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )*
                            {
                            pushFollow(FOLLOW_tcs_blockarg_in_tcs_block3979);
                            temp=tcs_blockarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "blockArgs", temp);
                            }
                            // parser/TCS.g:721:589: ( ( COMA ) temp= tcs_blockarg )*
                            loop74:
                            do {
                                int alt74=2;
                                int LA74_0 = input.LA(1);

                                if ( (LA74_0==COMA) ) {
                                    alt74=1;
                                }


                                switch (alt74) {
                            	case 1 :
                            	    // parser/TCS.g:721:590: ( COMA ) temp= tcs_blockarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:721:607: ( COMA )
                            	    // parser/TCS.g:721:608: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD346AE26F0F2911DFA3B9EEEE93CCC8E1");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_block3988); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_blockarg_in_tcs_block3996);
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
                            	    break loop74;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346D53600F2911DFBFA4EEEE93CCC8E1");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_block4008); if (state.failed) return ret2;
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
                    // parser/TCS.g:721:886: 
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
              _beforeSeqEl("E0DCF6CD346D53650F2911DFCB76EEEE93CCC8E1");
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
    // parser/TCS.g:730:1: tcs_conditionalelement returns [Object ret2] : ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) ;
    public final Object tcs_conditionalelement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConditionalElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:735:3: ( ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) )
            // parser/TCS.g:736:3: ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            {
            // parser/TCS.g:736:3: ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            // parser/TCS.g:736:4: LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346D53690F2911DF9CECEEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_conditionalelement4066); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346D536B0F2911DFAFCEEEEE93CCC8E1");
            }
            // parser/TCS.g:736:146: (temp= tcs_expression )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==NAME||LA77_0==RARROW||(LA77_0>=49 && LA77_0<=134)) ) {
                alt77=1;
            }
            else if ( (LA77_0==QMARK) ) {
                int LA77_2 = input.LA(2);

                if ( (synpred170_TCS()) ) {
                    alt77=1;
                }
            }
            switch (alt77) {
                case 1 :
                    // parser/TCS.g:736:148: temp= tcs_expression
                    {
                    pushFollow(FOLLOW_tcs_expression_in_tcs_conditionalelement4074);
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
              _beforeSeqEl("E0DCF6CD346D536C0F2911DFC815EEEE93CCC8E1");
            }
            match(input,QMARK,FOLLOW_QMARK_in_tcs_conditionalelement4083); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346D536E0F2911DFB7F4EEEE93CCC8E1");
            }
            // parser/TCS.g:736:366: (temp= tcs_sequence )
            // parser/TCS.g:736:368: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement4091);
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
              _beforeSeqEl("E0DCF6CD346D53760F2911DF8C38EEEE93CCC8E1");
            }
            // parser/TCS.g:736:504: ( ( COLON (temp= tcs_sequence ) ) | )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==COLON) ) {
                alt78=1;
            }
            else if ( (LA78_0==RPAREN) ) {
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
                    // parser/TCS.g:736:505: ( COLON (temp= tcs_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:736:521: ( COLON (temp= tcs_sequence ) )
                    // parser/TCS.g:736:522: COLON (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346D53720F2911DFAA81EEEE93CCC8E1");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_conditionalelement4104); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346D53740F2911DFBF69EEEE93CCC8E1");
                    }
                    // parser/TCS.g:736:663: (temp= tcs_sequence )
                    // parser/TCS.g:736:665: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement4112);
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
                    // parser/TCS.g:736:759: 
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
              _beforeSeqEl("E0DCF6CD346F9D500F2911DF80B3EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_conditionalelement4132); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346F9D530F2911DFAB0FEEEE93CCC8E1");
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
    // parser/TCS.g:745:1: tcs_alternative returns [Object ret2] : ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) ) ;
    public final Object tcs_alternative() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Alternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:750:3: ( ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) ) )
            // parser/TCS.g:751:3: ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) )
            {
            // parser/TCS.g:751:3: ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) )
            // parser/TCS.g:751:4: DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346F9D570F2911DFCC71EEEE93CCC8E1");
            }
            match(input,DLSQUARE,FOLLOW_DLSQUARE_in_tcs_alternative4177); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346F9D5C0F2911DF908FEEEE93CCC8E1");
            }
            // parser/TCS.g:751:148: (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=NAME && LA80_0<=STRING)||LA80_0==LPAREN||LA80_0==RARROW||LA80_0==LT||LA80_0==LSQUARE||(LA80_0>=DLSQUARE && LA80_0<=PIPE)||(LA80_0>=DOLLAR && LA80_0<=DLCURLY)||(LA80_0>=49 && LA80_0<=134)) ) {
                alt80=1;
            }
            else if ( (LA80_0==DRSQUARE) ) {
                int LA80_2 = input.LA(2);

                if ( (synpred173_TCS()) ) {
                    alt80=1;
                }
            }
            switch (alt80) {
                case 1 :
                    // parser/TCS.g:751:150: temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4185);
                    temp=tcs_sequenceinalternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sequences", temp);
                    }
                    // parser/TCS.g:751:220: ( ( PIPE ) temp= tcs_sequenceinalternative )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==PIPE) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // parser/TCS.g:751:221: ( PIPE ) temp= tcs_sequenceinalternative
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:751:238: ( PIPE )
                    	    // parser/TCS.g:751:239: PIPE
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD346F9D590F2911DF9371EEEE93CCC8E1");
                    	    }
                    	    match(input,PIPE,FOLLOW_PIPE_in_tcs_alternative4194); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4202);
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
                    	    break loop79;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346F9D5D0F2911DF8E68EEEE93CCC8E1");
            }
            match(input,DRSQUARE,FOLLOW_DRSQUARE_in_tcs_alternative4214); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD346F9D630F2911DFB18DEEEE93CCC8E1");
            }
            // parser/TCS.g:751:574: ( ( STAR ) | )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==STAR) ) {
                alt81=1;
            }
            else if ( (LA81_0==EOF||(LA81_0>=NAME && LA81_0<=STRING)||(LA81_0>=LPAREN && LA81_0<=RPAREN)||(LA81_0>=RCURLY && LA81_0<=COMA)||LA81_0==LT||(LA81_0>=LSQUARE && LA81_0<=RSQUARE)||(LA81_0>=DLSQUARE && LA81_0<=DRSQUARE)||(LA81_0>=DOLLAR && LA81_0<=DLCURLY)||(LA81_0>=49 && LA81_0<=134)) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // parser/TCS.g:751:575: ( STAR )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:751:591: ( STAR )
                    // parser/TCS.g:751:592: STAR
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD346F9D610F2911DF8554EEEE93CCC8E1");
                    }
                    match(input,STAR,FOLLOW_STAR_in_tcs_alternative4225); if (state.failed) return ret2;
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
                    // parser/TCS.g:751:745: 
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
              _beforeSeqEl("E0DCF6CD346F9D660F2911DF85F4EEEE93CCC8E1");
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
    // parser/TCS.g:760:1: tcs_sequenceinalternative returns [Object ret2] : ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequenceinalternative() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SequenceInAlternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:765:3: ( ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // parser/TCS.g:766:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // parser/TCS.g:766:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // parser/TCS.g:766:4: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34720E5C0F2911DF8CCDEEEE93CCC8E1");
            }
            // parser/TCS.g:766:64: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==95) ) {
                int LA82_1 = input.LA(2);

                if ( (LA82_1==EOF||(LA82_1>=NAME && LA82_1<=STRING)||LA82_1==RPAREN||(LA82_1>=LCURLY && LA82_1<=COMA)||LA82_1==LT||(LA82_1>=LSQUARE && LA82_1<=RSQUARE)||(LA82_1>=DLSQUARE && LA82_1<=DRSQUARE)||(LA82_1>=DOLLAR && LA82_1<=DLCURLY)||(LA82_1>=49 && LA82_1<=134)) ) {
                    alt82=2;
                }
                else if ( (LA82_1==LPAREN) ) {
                    int LA82_3 = input.LA(3);

                    if ( (LA82_3==NAME||LA82_3==RARROW||LA82_3==QMARK||(LA82_3>=49 && LA82_3<=134)) ) {
                        alt82=2;
                    }
                    else if ( (LA82_3==STRING) ) {
                        alt82=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 82, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA82_0==EOF||(LA82_0>=NAME && LA82_0<=STRING)||(LA82_0>=LPAREN && LA82_0<=RPAREN)||(LA82_0>=RCURLY && LA82_0<=COMA)||LA82_0==LT||(LA82_0>=LSQUARE && LA82_0<=RSQUARE)||(LA82_0>=DLSQUARE && LA82_0<=DRSQUARE)||(LA82_0>=DOLLAR && LA82_0<=DLCURLY)||(LA82_0>=49 && LA82_0<=94)||(LA82_0>=96 && LA82_0<=134)) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // parser/TCS.g:766:65: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:766:81: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    // parser/TCS.g:766:82: 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34720E550F2911DFC514EEEE93CCC8E1");
                    }
                    match(input,95,FOLLOW_95_in_tcs_sequenceinalternative4290); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34720E560F2911DF9781EEEE93CCC8E1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_sequenceinalternative4294); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34720E590F2911DF9078EEEE93CCC8E1");
                    }
                    // parser/TCS.g:766:313: (temp= stringSymbol )
                    // parser/TCS.g:766:315: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_sequenceinalternative4302);
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
                      _beforeSeqEl("E0DCF6CD34720E5A0F2911DFB7B6EEEE93CCC8E1");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_sequenceinalternative4309); if (state.failed) return ret2;
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
                    // parser/TCS.g:766:492: 
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
              _beforeSeqEl("E0DCF6CD34747F510F2911DFC68DEEEE93CCC8E1");
            }
            // parser/TCS.g:767:76: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=NAME && LA84_0<=STRING)||LA84_0==LPAREN||LA84_0==RARROW||LA84_0==LT||LA84_0==LSQUARE||LA84_0==DLSQUARE||(LA84_0>=DOLLAR && LA84_0<=DLCURLY)||(LA84_0>=49 && LA84_0<=134)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // parser/TCS.g:767:78: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4330);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // parser/TCS.g:767:141: (temp= tcs_sequenceelement )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( ((LA83_0>=NAME && LA83_0<=STRING)||LA83_0==LPAREN||LA83_0==RARROW||LA83_0==LT||LA83_0==LSQUARE||LA83_0==DLSQUARE||(LA83_0>=DOLLAR && LA83_0<=DLCURLY)||(LA83_0>=49 && LA83_0<=134)) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // parser/TCS.g:767:143: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4338);
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
                    	    break loop83;
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
    // parser/TCS.g:775:1: tcs_functioncall returns [Object ret2] : ( DOLLAR (temp= identifier ) ) ;
    public final Object tcs_functioncall() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:780:3: ( ( DOLLAR (temp= identifier ) ) )
            // parser/TCS.g:781:3: ( DOLLAR (temp= identifier ) )
            {
            // parser/TCS.g:781:3: ( DOLLAR (temp= identifier ) )
            // parser/TCS.g:781:4: DOLLAR (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34747F550F2911DF94DAEEEE93CCC8E1");
            }
            match(input,DOLLAR,FOLLOW_DOLLAR_in_tcs_functioncall4387); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34747F580F2911DF95D9EEEE93CCC8E1");
            }
            // parser/TCS.g:781:146: (temp= identifier )
            // parser/TCS.g:781:148: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functioncall4395);
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
              _beforeSeqEl("E0DCF6CD34747F5B0F2911DFB91FEEEE93CCC8E1");
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
    // parser/TCS.g:789:1: tcs_injectoractionsblock returns [Object ret2] : ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY ) ;
    public final Object tcs_injectoractionsblock() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","InjectorActionsBlock");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:794:3: ( ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY ) )
            // parser/TCS.g:795:3: ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY )
            {
            // parser/TCS.g:795:3: ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY )
            // parser/TCS.g:795:4: DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3476C9400F2911DFB8D0EEEE93CCC8E1");
            }
            match(input,DLCURLY,FOLLOW_DLCURLY_in_tcs_injectoractionsblock4442); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3476C9450F2911DFAB24EEEE93CCC8E1");
            }
            // parser/TCS.g:795:147: (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==NAME||LA86_0==RARROW||(LA86_0>=49 && LA86_0<=134)) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // parser/TCS.g:795:149: temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )*
                    {
                    pushFollow(FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4450);
                    temp=tcs_injectoraction();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "injectorActions", temp);
                    }
                    // parser/TCS.g:795:218: ( ( COMA ) temp= tcs_injectoraction )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==COMA) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // parser/TCS.g:795:219: ( COMA ) temp= tcs_injectoraction
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:795:236: ( COMA )
                    	    // parser/TCS.g:795:237: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD3476C9420F2911DFACF8EEEE93CCC8E1");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_tcs_injectoractionsblock4459); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4467);
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
                    	    break loop85;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3476C9460F2911DFBA4CEEEE93CCC8E1");
            }
            match(input,DRCURLY,FOLLOW_DRCURLY_in_tcs_injectoractionsblock4479); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3476C9490F2911DFA0C6EEEE93CCC8E1");
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
    // parser/TCS.g:803:1: tcs_injectoraction returns [Object ret2] : (ret= tcs_propertyinit ) ;
    public final Object tcs_injectoraction() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:804:3: ( (ret= tcs_propertyinit ) )
            // parser/TCS.g:805:3: (ret= tcs_propertyinit )
            {
            // parser/TCS.g:805:3: (ret= tcs_propertyinit )
            // parser/TCS.g:805:4: ret= tcs_propertyinit
            {
            pushFollow(FOLLOW_tcs_propertyinit_in_tcs_injectoraction4520);
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
    // parser/TCS.g:812:1: tcs_propertyinit returns [Object ret2] : (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit ) ;
    public final Object tcs_propertyinit() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:813:3: ( (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit ) )
            // parser/TCS.g:814:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )
            {
            // parser/TCS.g:814:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )
            int alt87=3;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // parser/TCS.g:814:4: ret= tcs_primitivepropertyinit
                    {
                    pushFollow(FOLLOW_tcs_primitivepropertyinit_in_tcs_propertyinit4547);
                    ret=tcs_primitivepropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:815:5: ret= tcs_lookuppropertyinit
                    {
                    pushFollow(FOLLOW_tcs_lookuppropertyinit_in_tcs_propertyinit4555);
                    ret=tcs_lookuppropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:816:5: ret= tcs_foreachpredicatepropertyinit
                    {
                    pushFollow(FOLLOW_tcs_foreachpredicatepropertyinit_in_tcs_propertyinit4563);
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
    // parser/TCS.g:823:1: tcs_primitivepropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) ) ;
    public final Object tcs_primitivepropertyinit() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitivePropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:828:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) ) )
            // parser/TCS.g:829:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) )
            {
            // parser/TCS.g:829:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) )
            // parser/TCS.g:829:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34793A440F2911DFAFD4EEEE93CCC8E1");
            }
            // parser/TCS.g:829:63: (temp= tcs_propertyreference )
            // parser/TCS.g:829:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_primitivepropertyinit4597);
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
              _beforeSeqEl("E0DCF6CD347B84350F2911DF94DCEEEE93CCC8E1");
            }
            // parser/TCS.g:829:215: ( ( LARROW ) | ( EQ ) )
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
                    // parser/TCS.g:829:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:829:232: ( LARROW )
                    // parser/TCS.g:829:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD347B84310F2911DF8A32EEEE93CCC8E1");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_primitivepropertyinit4610); if (state.failed) return ret2;
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
                    // parser/TCS.g:829:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:829:406: ( EQ )
                    // parser/TCS.g:829:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD347B84330F2911DFB652EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivepropertyinit4625); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD347B84370F2911DFA745EEEE93CCC8E1");
            }
            // parser/TCS.g:830:76: (temp= identifier )
            // parser/TCS.g:830:78: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivepropertyinit4640);
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
    // parser/TCS.g:838:1: tcs_lookuppropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN ) ;
    public final Object tcs_lookuppropertyinit() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookupPropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:843:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN ) )
            // parser/TCS.g:844:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN )
            {
            // parser/TCS.g:844:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN )
            // parser/TCS.g:844:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD347B843C0F2911DFAEB5EEEE93CCC8E1");
            }
            // parser/TCS.g:844:63: (temp= tcs_propertyreference )
            // parser/TCS.g:844:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_lookuppropertyinit4687);
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
              _beforeSeqEl("E0DCF6CD347B84440F2911DFB029EEEE93CCC8E1");
            }
            // parser/TCS.g:844:215: ( ( LARROW ) | ( EQ ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==LARROW) ) {
                alt89=1;
            }
            else if ( (LA89_0==EQ) ) {
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
                    // parser/TCS.g:844:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:844:232: ( LARROW )
                    // parser/TCS.g:844:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD347B84400F2911DFC208EEEE93CCC8E1");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_lookuppropertyinit4700); if (state.failed) return ret2;
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
                    // parser/TCS.g:844:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:844:406: ( EQ )
                    // parser/TCS.g:844:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD347B84420F2911DF89ABEEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_lookuppropertyinit4715); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD347DF5300F2911DF990DEEEE93CCC8E1");
            }
            match(input,67,FOLLOW_67_in_tcs_lookuppropertyinit4726); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD347DF5310F2911DFBF18EEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_lookuppropertyinit4730); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD347DF5340F2911DFA11AEEEE93CCC8E1");
            }
            // parser/TCS.g:845:242: (temp= stringSymbol )
            // parser/TCS.g:845:244: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_lookuppropertyinit4738);
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
              _beforeSeqEl("E0DCF6CD347DF5350F2911DFC7A8EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_lookuppropertyinit4745); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:853:1: tcs_foreachpredicatepropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN ) ;
    public final Object tcs_foreachpredicatepropertyinit() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForeachPredicatePropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:858:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN ) )
            // parser/TCS.g:859:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN )
            {
            // parser/TCS.g:859:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN )
            // parser/TCS.g:859:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD347DF53A0F2911DFB723EEEE93CCC8E1");
            }
            // parser/TCS.g:859:63: (temp= tcs_propertyreference )
            // parser/TCS.g:859:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_foreachpredicatepropertyinit4790);
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
              _beforeSeqEl("E0DCF6CD347DF5420F2911DFB21DEEEE93CCC8E1");
            }
            // parser/TCS.g:859:215: ( ( LARROW ) | ( EQ ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==LARROW) ) {
                alt90=1;
            }
            else if ( (LA90_0==EQ) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // parser/TCS.g:859:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:859:232: ( LARROW )
                    // parser/TCS.g:859:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD347DF53E0F2911DF928EEEEE93CCC8E1");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_foreachpredicatepropertyinit4803); if (state.failed) return ret2;
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
                    // parser/TCS.g:859:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:859:406: ( EQ )
                    // parser/TCS.g:859:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD347DF5400F2911DFC5A9EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4818); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CD347DF5430F2911DFAD3CEEEE93CCC8E1");
            }
            match(input,62,FOLLOW_62_in_tcs_foreachpredicatepropertyinit4829); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD347DF5440F2911DFB988EEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_foreachpredicatepropertyinit4833); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD347DF5470F2911DFC102EEEE93CCC8E1");
            }
            // parser/TCS.g:860:243: (temp= stringSymbol )
            // parser/TCS.g:860:245: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4841);
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
              _beforeSeqEl("E0DCF6CD3480663A0F2911DFA82BEEEE93CCC8E1");
            }
            // parser/TCS.g:860:374: ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==COMA) ) {
                int LA91_1 = input.LA(2);

                if ( (LA91_1==RPAREN||LA91_1==60||LA91_1==127) ) {
                    alt91=2;
                }
                else if ( (LA91_1==87) ) {
                    int LA91_3 = input.LA(3);

                    if ( (LA91_3==EQ) ) {
                        int LA91_4 = input.LA(4);

                        if ( (LA91_4==STRING) ) {
                            int LA91_5 = input.LA(5);

                            if ( (LA91_5==COMA) ) {
                                int LA91_6 = input.LA(6);

                                if ( (synpred185_TCS()) ) {
                                    alt91=1;
                                }
                                else if ( (true) ) {
                                    alt91=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ret2;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 91, 6, input);

                                    throw nvae;
                                }
                            }
                            else if ( (LA91_5==RPAREN) ) {
                                alt91=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ret2;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 91, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 91, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 91, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 1, input);

                    throw nvae;
                }
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
                    // parser/TCS.g:860:375: ( COMA 'mode' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:860:391: ( COMA 'mode' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:860:392: COMA 'mode' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD348066330F2911DF89DDEEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4854); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD348066340F2911DFB2B7EEEE93CCC8E1");
                    }
                    match(input,87,FOLLOW_87_in_tcs_foreachpredicatepropertyinit4858); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD348066350F2911DF90B8EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4862); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD348066380F2911DF9C7EEEEE93CCC8E1");
                    }
                    // parser/TCS.g:860:692: (temp= stringSymbol )
                    // parser/TCS.g:860:694: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4870);
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
                    // parser/TCS.g:860:780: 
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
              _beforeSeqEl("E0DCF6CD348066450F2911DF9C18EEEE93CCC8E1");
            }
            // parser/TCS.g:861:77: ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==COMA) ) {
                alt94=1;
            }
            else if ( (LA94_0==RPAREN) ) {
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
                    // parser/TCS.g:861:78: ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:861:94: ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? )
                    // parser/TCS.g:861:95: COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3480663E0F2911DFC6D0EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4896); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD348066430F2911DFC250EEEE93CCC8E1");
                    }
                    // parser/TCS.g:861:235: (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )?
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==60||LA93_0==87||LA93_0==127) ) {
                        alt93=1;
                    }
                    switch (alt93) {
                        case 1 :
                            // parser/TCS.g:861:237: temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )*
                            {
                            pushFollow(FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4904);
                            temp=tcs_predicatesemantic();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "predicatesemantic", temp);
                            }
                            // parser/TCS.g:861:311: ( ( COMA ) temp= tcs_predicatesemantic )*
                            loop92:
                            do {
                                int alt92=2;
                                int LA92_0 = input.LA(1);

                                if ( (LA92_0==COMA) ) {
                                    alt92=1;
                                }


                                switch (alt92) {
                            	case 1 :
                            	    // parser/TCS.g:861:312: ( COMA ) temp= tcs_predicatesemantic
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:861:329: ( COMA )
                            	    // parser/TCS.g:861:330: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD348066400F2911DF9EA6EEEE93CCC8E1");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4913); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4921);
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
                            	    break loop92;
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
                    // parser/TCS.g:861:542: 
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
              _beforeSeqEl("E0DCF6CD348066460F2911DF9994EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_foreachpredicatepropertyinit4946); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:870:1: tcs_predicatesemantic returns [Object ret2] : ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? ) ;
    public final Object tcs_predicatesemantic() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PredicateSemantic");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:875:3: ( ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? ) )
            // parser/TCS.g:876:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? )
            {
            // parser/TCS.g:876:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? )
            // parser/TCS.g:876:4: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3482B02A0F2911DF9A9CEEEE93CCC8E1");
            }
            // parser/TCS.g:876:64: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==60) ) {
                alt95=1;
            }
            else if ( (LA95_0==87||LA95_0==127) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // parser/TCS.g:876:65: ( 'when' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:876:81: ( 'when' EQ (temp= stringSymbol ) COMA )
                    // parser/TCS.g:876:82: 'when' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3482B0230F2911DFC41CEEEE93CCC8E1");
                    }
                    match(input,60,FOLLOW_60_in_tcs_predicatesemantic4993); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3482B0240F2911DFB709EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic4997); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3482B0270F2911DFA196EEEE93CCC8E1");
                    }
                    // parser/TCS.g:876:301: (temp= stringSymbol )
                    // parser/TCS.g:876:303: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_predicatesemantic5005);
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
                      _beforeSeqEl("E0DCF6CD3482B0280F2911DFAD01EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_predicatesemantic5012); if (state.failed) return ret2;
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
                    // parser/TCS.g:876:470: 
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
              _beforeSeqEl("E0DCF6CD3482B0350F2911DF9110EEEE93CCC8E1");
            }
            // parser/TCS.g:877:77: ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==87) ) {
                alt96=1;
            }
            else if ( (LA96_0==127) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // parser/TCS.g:877:78: ( 'mode' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:877:94: ( 'mode' EQ (temp= stringSymbol ) COMA )
                    // parser/TCS.g:877:95: 'mode' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3482B02E0F2911DFAC76EEEE93CCC8E1");
                    }
                    match(input,87,FOLLOW_87_in_tcs_predicatesemantic5035); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3482B02F0F2911DFB702EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic5039); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3482B0320F2911DF9206EEEE93CCC8E1");
                    }
                    // parser/TCS.g:877:314: (temp= stringSymbol )
                    // parser/TCS.g:877:316: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_predicatesemantic5047);
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
                      _beforeSeqEl("E0DCF6CD3482B0330F2911DFAD59EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_predicatesemantic5054); if (state.failed) return ret2;
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
                    // parser/TCS.g:877:483: 
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
              _beforeSeqEl("E0DCF6CD3482B0360F2911DF903CEEEE93CCC8E1");
            }
            match(input,127,FOLLOW_127_in_tcs_predicatesemantic5071); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3482B0370F2911DFA20FEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic5075); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3482B03C0F2911DF829CEEEE93CCC8E1");
            }
            // parser/TCS.g:878:234: (temp= identifierOrKeyword )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==NAME||(LA97_0>=49 && LA97_0<=134)) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // parser/TCS.g:878:236: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_predicatesemantic5083);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");
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
    // parser/TCS.g:886:1: tcs_propertyarg returns [Object ret2] : (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg ) ;
    public final Object tcs_propertyarg() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:887:3: ( (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg ) )
            // parser/TCS.g:888:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg )
            {
            // parser/TCS.g:888:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg )
            int alt98=15;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt98=1;
                }
                break;
            case 67:
                {
                alt98=2;
                }
                break;
            case 121:
                {
                alt98=3;
                }
                break;
            case 127:
                {
                alt98=4;
                }
                break;
            case 71:
                {
                alt98=5;
                }
                break;
            case 95:
                {
                alt98=6;
                }
                break;
            case 56:
                {
                alt98=7;
                }
                break;
            case 53:
                {
                alt98=8;
                }
                break;
            case 63:
                {
                alt98=9;
                }
                break;
            case 114:
                {
                alt98=10;
                }
                break;
            case 98:
                {
                alt98=11;
                }
                break;
            case 133:
                {
                alt98=12;
                }
                break;
            case 61:
                {
                alt98=13;
                }
                break;
            case 74:
                {
                alt98=14;
                }
                break;
            case 87:
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
                    // parser/TCS.g:888:4: ret= tcs_referstoparg
                    {
                    pushFollow(FOLLOW_tcs_referstoparg_in_tcs_propertyarg5125);
                    ret=tcs_referstoparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:889:5: ret= tcs_lookinparg
                    {
                    pushFollow(FOLLOW_tcs_lookinparg_in_tcs_propertyarg5133);
                    ret=tcs_lookinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:890:5: ret= tcs_createinparg
                    {
                    pushFollow(FOLLOW_tcs_createinparg_in_tcs_propertyarg5141);
                    ret=tcs_createinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:891:5: ret= tcs_asparg
                    {
                    pushFollow(FOLLOW_tcs_asparg_in_tcs_propertyarg5149);
                    ret=tcs_asparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:892:5: ret= tcs_separatorparg
                    {
                    pushFollow(FOLLOW_tcs_separatorparg_in_tcs_propertyarg5157);
                    ret=tcs_separatorparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:893:5: ret= tcs_disambiguateparg
                    {
                    pushFollow(FOLLOW_tcs_disambiguateparg_in_tcs_propertyarg5165);
                    ret=tcs_disambiguateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:894:5: ret= tcs_autocreateparg
                    {
                    pushFollow(FOLLOW_tcs_autocreateparg_in_tcs_propertyarg5173);
                    ret=tcs_autocreateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:895:5: ret= tcs_importcontextparg
                    {
                    pushFollow(FOLLOW_tcs_importcontextparg_in_tcs_propertyarg5181);
                    ret=tcs_importcontextparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 9 :
                    // parser/TCS.g:896:5: ret= tcs_partialparg
                    {
                    pushFollow(FOLLOW_tcs_partialparg_in_tcs_propertyarg5189);
                    ret=tcs_partialparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 10 :
                    // parser/TCS.g:897:5: ret= tcs_forcedlowerparg
                    {
                    pushFollow(FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg5197);
                    ret=tcs_forcedlowerparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 11 :
                    // parser/TCS.g:898:5: ret= tcs_forcedupperparg
                    {
                    pushFollow(FOLLOW_tcs_forcedupperparg_in_tcs_propertyarg5205);
                    ret=tcs_forcedupperparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 12 :
                    // parser/TCS.g:899:5: ret= tcs_createasparg
                    {
                    pushFollow(FOLLOW_tcs_createasparg_in_tcs_propertyarg5213);
                    ret=tcs_createasparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 13 :
                    // parser/TCS.g:900:5: ret= tcs_queryparg
                    {
                    pushFollow(FOLLOW_tcs_queryparg_in_tcs_propertyarg5221);
                    ret=tcs_queryparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 14 :
                    // parser/TCS.g:901:5: ret= tcs_filterparg
                    {
                    pushFollow(FOLLOW_tcs_filterparg_in_tcs_propertyarg5229);
                    ret=tcs_filterparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 15 :
                    // parser/TCS.g:902:5: ret= tcs_modeparg
                    {
                    pushFollow(FOLLOW_tcs_modeparg_in_tcs_propertyarg5237);
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
    // parser/TCS.g:909:1: tcs_referstoparg returns [Object ret2] : ( 'refersTo' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_referstoparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RefersToPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:914:3: ( ( 'refersTo' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:915:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:915:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:915:4: 'refersTo' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD348521220F2911DFB298EEEE93CCC8E1");
            }
            match(input,51,FOLLOW_51_in_tcs_referstoparg5267); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD348521230F2911DFC52FEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_referstoparg5271); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD348521260F2911DF8C71EEEE93CCC8E1");
            }
            // parser/TCS.g:915:227: (temp= identifierOrKeyword )
            // parser/TCS.g:915:229: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_referstoparg5279);
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
    // parser/TCS.g:923:1: tcs_lookinparg returns [Object ret2] : ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) ;
    public final Object tcs_lookinparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:928:3: ( ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) )
            // parser/TCS.g:929:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            {
            // parser/TCS.g:929:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            // parser/TCS.g:929:4: 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34876B100F2911DFC9EEEEEE93CCC8E1");
            }
            match(input,67,FOLLOW_67_in_tcs_lookinparg5322); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34876B110F2911DFC7DAEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_lookinparg5326); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A1A9DB0F2911DFB735EEEE93CCC8E1");
            }
            // parser/TCS.g:929:226: ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==SHARP) ) {
                alt100=1;
            }
            else if ( (LA100_0==NAME||(LA100_0>=49 && LA100_0<=134)) ) {
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
                    // parser/TCS.g:929:227: ( SHARP 'all' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:929:243: ( SHARP 'all' )
                    // parser/TCS.g:929:244: SHARP 'all'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34A1A9D10F2911DFA88AEEEE93CCC8E1");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_tcs_lookinparg5337); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34A1A9D20F2911DF87EAEEEE93CCC8E1");
                    }
                    match(input,77,FOLLOW_77_in_tcs_lookinparg5341); if (state.failed) return ret2;
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
                    // parser/TCS.g:929:479: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:929:495: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    // parser/TCS.g:929:496: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34A1A9D90F2911DFBABEEEEE93CCC8E1");
                    }
                    // parser/TCS.g:929:555: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    // parser/TCS.g:929:557: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg5358);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyName", temp);
                    }
                    // parser/TCS.g:929:624: ( ( POINT ) temp= identifierOrKeyword )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==POINT) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // parser/TCS.g:929:625: ( POINT ) temp= identifierOrKeyword
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:929:642: ( POINT )
                    	    // parser/TCS.g:929:643: POINT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD34A1A9D60F2911DF87D7EEEE93CCC8E1");
                    	    }
                    	    match(input,POINT,FOLLOW_POINT_in_tcs_lookinparg5367); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg5375);
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
    // parser/TCS.g:938:1: tcs_createinparg returns [Object ret2] : ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createinparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:943:3: ( ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            // parser/TCS.g:944:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            {
            // parser/TCS.g:944:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            // parser/TCS.g:944:4: 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A41AD20F2911DFB1D1EEEE93CCC8E1");
            }
            match(input,121,FOLLOW_121_in_tcs_createinparg5428); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A41AD30F2911DF861FEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createinparg5432); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A41AD90F2911DFADDBEEEE93CCC8E1");
            }
            // parser/TCS.g:944:227: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            // parser/TCS.g:944:229: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg5440);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
            }
            // parser/TCS.g:944:296: ( ( POINT ) temp= identifierOrKeyword )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( (LA101_0==POINT) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // parser/TCS.g:944:297: ( POINT ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:944:314: ( POINT )
            	    // parser/TCS.g:944:315: POINT
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CD34A41AD60F2911DFCFB3EEEE93CCC8E1");
            	    }
            	    match(input,POINT,FOLLOW_POINT_in_tcs_createinparg5449); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg5457);
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
    // parser/TCS.g:952:1: tcs_asparg returns [Object ret2] : ( 'as' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_asparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:957:3: ( ( 'as' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:958:3: ( 'as' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:958:3: ( 'as' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:958:4: 'as' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A664C20F2911DF9972EEEE93CCC8E1");
            }
            match(input,127,FOLLOW_127_in_tcs_asparg5503); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A664C30F2911DF932BEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_asparg5507); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A664C80F2911DF89ADEEEE93CCC8E1");
            }
            // parser/TCS.g:958:221: (temp= identifierOrKeyword )
            // parser/TCS.g:958:223: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_asparg5515);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"                                                                                and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"                                                                                        ->prepend(self.property.propertyReference.strucfeature.type)"+"                                                                                        ->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"                                                                                and ("+"                                                                                        if (not self.property.propertyArgs->select("+"                                                                                                        arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"                                                                                                ) "+"                                                                                        then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = "+"                                                                                                        self.property.propertyArgs->select("+"                                                                                                                arg | arg.oclIsTypeOf(TCS::ModePArg))"+"                                                                                                                        .oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"                                                                                                        .mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"                                                                                        endif"+"                                                                                )"+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");
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
    // parser/TCS.g:966:1: tcs_separatorparg returns [Object ret2] : ( 'separator' EQ (temp= tcs_sequence ) ) ;
    public final Object tcs_separatorparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SeparatorPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:971:3: ( ( 'separator' EQ (temp= tcs_sequence ) ) )
            // parser/TCS.g:972:3: ( 'separator' EQ (temp= tcs_sequence ) )
            {
            // parser/TCS.g:972:3: ( 'separator' EQ (temp= tcs_sequence ) )
            // parser/TCS.g:972:4: 'separator' EQ (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A8D5C00F2911DFA9A9EEEE93CCC8E1");
            }
            match(input,71,FOLLOW_71_in_tcs_separatorparg5558); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A8D5C10F2911DF9C21EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_separatorparg5562); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A8D5C30F2911DF9D3AEEEE93CCC8E1");
            }
            // parser/TCS.g:972:228: (temp= tcs_sequence )
            // parser/TCS.g:972:230: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_separatorparg5570);
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
    // parser/TCS.g:980:1: tcs_disambiguateparg returns [Object ret2] : ( 'disambiguate' EQ (temp= stringSymbol ) ) ;
    public final Object tcs_disambiguateparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","DisambiguatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:985:3: ( ( 'disambiguate' EQ (temp= stringSymbol ) ) )
            // parser/TCS.g:986:3: ( 'disambiguate' EQ (temp= stringSymbol ) )
            {
            // parser/TCS.g:986:3: ( 'disambiguate' EQ (temp= stringSymbol ) )
            // parser/TCS.g:986:4: 'disambiguate' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A8D5C70F2911DFCBB4EEEE93CCC8E1");
            }
            match(input,95,FOLLOW_95_in_tcs_disambiguateparg5613); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A8D5C80F2911DF9A9AEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_disambiguateparg5617); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34A8D5CB0F2911DFA6C1EEEE93CCC8E1");
            }
            // parser/TCS.g:986:231: (temp= stringSymbol )
            // parser/TCS.g:986:233: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_disambiguateparg5625);
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
    // parser/TCS.g:994:1: tcs_autocreateparg returns [Object ret2] : ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) ;
    public final Object tcs_autocreateparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AutoCreatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:999:3: ( ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) )
            // parser/TCS.g:1000:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            {
            // parser/TCS.g:1000:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            // parser/TCS.g:1000:4: 'autoCreate' EQ (temp= tcs_autocreatekind )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34AB1FB00F2911DF8415EEEE93CCC8E1");
            }
            match(input,56,FOLLOW_56_in_tcs_autocreateparg5668); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34AB1FB10F2911DF9B70EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_autocreateparg5672); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34AB1FB30F2911DF996BEEEE93CCC8E1");
            }
            // parser/TCS.g:1000:229: (temp= tcs_autocreatekind )
            // parser/TCS.g:1000:231: temp= tcs_autocreatekind
            {
            pushFollow(FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg5680);
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
    // parser/TCS.g:1008:1: tcs_autocreatekind returns [Object ret2] : ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) ;
    public final Object tcs_autocreatekind() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1009:3: ( ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) )
            // parser/TCS.g:1010:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            {
            // parser/TCS.g:1010:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            int alt102=3;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt102=1;
                }
                break;
            case 59:
                {
                alt102=2;
                }
                break;
            case 128:
                {
                alt102=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // parser/TCS.g:1010:4: ( 'always' )
                    {
                    // parser/TCS.g:1010:4: ( 'always' )
                    // parser/TCS.g:1010:5: 'always'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34B24BA00F2911DFA1D5EEEE93CCC8E1");
                    }
                    match(input,97,FOLLOW_97_in_tcs_autocreatekind5724); if (state.failed) return ret2;
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
                    // parser/TCS.g:1011:4: ( 'ifmissing' )
                    {
                    // parser/TCS.g:1011:4: ( 'ifmissing' )
                    // parser/TCS.g:1011:5: 'ifmissing'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34C55E710F2911DF9917EEEE93CCC8E1");
                    }
                    match(input,59,FOLLOW_59_in_tcs_autocreatekind5734); if (state.failed) return ret2;
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
                    // parser/TCS.g:1012:4: ( 'never' )
                    {
                    // parser/TCS.g:1012:4: ( 'never' )
                    // parser/TCS.g:1012:5: 'never'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34C7CF710F2911DFCD80EEEE93CCC8E1");
                    }
                    match(input,128,FOLLOW_128_in_tcs_autocreatekind5744); if (state.failed) return ret2;
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
    // parser/TCS.g:1019:1: tcs_importcontextparg returns [Object ret2] : ( 'importContext' ) ;
    public final Object tcs_importcontextparg() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","ImportContextPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1024:3: ( ( 'importContext' ) )
            // parser/TCS.g:1025:3: ( 'importContext' )
            {
            // parser/TCS.g:1025:3: ( 'importContext' )
            // parser/TCS.g:1025:4: 'importContext'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34D600400F2911DFA67FEEEE93CCC8E1");
            }
            match(input,53,FOLLOW_53_in_tcs_importcontextparg5775); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1033:1: tcs_partialparg returns [Object ret2] : ( 'partial' ) ;
    public final Object tcs_partialparg() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","PartialPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1038:3: ( ( 'partial' ) )
            // parser/TCS.g:1039:3: ( 'partial' )
            {
            // parser/TCS.g:1039:3: ( 'partial' )
            // parser/TCS.g:1039:4: 'partial'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34D600440F2911DFB96AEEEE93CCC8E1");
            }
            match(input,63,FOLLOW_63_in_tcs_partialparg5815); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1047:1: tcs_forcedlowerparg returns [Object ret2] : ( 'forcedLower' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedlowerparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedLowerPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1052:3: ( ( 'forcedLower' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1053:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1053:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1053:4: 'forcedLower' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34D871400F2911DFA81BEEEE93CCC8E1");
            }
            match(input,114,FOLLOW_114_in_tcs_forcedlowerparg5855); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34D871410F2911DF8534EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedlowerparg5859); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34D871430F2911DFB0FFEEEE93CCC8E1");
            }
            // parser/TCS.g:1053:230: (temp= integerSymbol )
            // parser/TCS.g:1053:232: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedlowerparg5867);
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
    // parser/TCS.g:1061:1: tcs_forcedupperparg returns [Object ret2] : ( 'forcedUpper' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedupperparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedUpperPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1066:3: ( ( 'forcedUpper' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1067:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1067:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1067:4: 'forcedUpper' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34D871470F2911DFC85DEEEE93CCC8E1");
            }
            match(input,98,FOLLOW_98_in_tcs_forcedupperparg5910); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34D871480F2911DF8B9AEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedupperparg5914); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34D8714A0F2911DFB123EEEE93CCC8E1");
            }
            // parser/TCS.g:1067:230: (temp= integerSymbol )
            // parser/TCS.g:1067:232: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedupperparg5922);
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
    // parser/TCS.g:1075:1: tcs_createasparg returns [Object ret2] : ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createasparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateAsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1080:3: ( ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) ) )
            // parser/TCS.g:1081:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) )
            {
            // parser/TCS.g:1081:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) )
            // parser/TCS.g:1081:4: 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DABB300F2911DF957EEEEE93CCC8E1");
            }
            match(input,133,FOLLOW_133_in_tcs_createasparg5965); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DABB310F2911DFC0A3EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createasparg5969); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DABB370F2911DF8999EEEE93CCC8E1");
            }
            // parser/TCS.g:1081:227: (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )
            // parser/TCS.g:1081:229: temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg5977);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }
            // parser/TCS.g:1081:288: ( ( DLCOLON ) temp= identifierOrKeyword )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==DLCOLON) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // parser/TCS.g:1081:289: ( DLCOLON ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:1081:306: ( DLCOLON )
            	    // parser/TCS.g:1081:307: DLCOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CD34DABB340F2911DFB00BEEEE93CCC8E1");
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_tcs_createasparg5986); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg5994);
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
            	    break loop103;
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
    // parser/TCS.g:1089:1: tcs_queryparg returns [Object ret2] : ( 'query' EQ (temp= stringSymbol ) ) ;
    public final Object tcs_queryparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","QueryPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1094:3: ( ( 'query' EQ (temp= stringSymbol ) ) )
            // parser/TCS.g:1095:3: ( 'query' EQ (temp= stringSymbol ) )
            {
            // parser/TCS.g:1095:3: ( 'query' EQ (temp= stringSymbol ) )
            // parser/TCS.g:1095:4: 'query' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DABB3B0F2911DF9709EEEE93CCC8E1");
            }
            match(input,61,FOLLOW_61_in_tcs_queryparg6040); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DABB3C0F2911DF9B78EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_queryparg6044); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DABB3F0F2911DFB2ACEEEE93CCC8E1");
            }
            // parser/TCS.g:1095:224: (temp= stringSymbol )
            // parser/TCS.g:1095:226: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_queryparg6052);
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
    // parser/TCS.g:1103:1: tcs_filterparg returns [Object ret2] : ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) ) ;
    public final Object tcs_filterparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FilterPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1108:3: ( ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) ) )
            // parser/TCS.g:1109:3: ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) )
            {
            // parser/TCS.g:1109:3: ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) )
            // parser/TCS.g:1109:4: 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DD2C300F2911DF87E8EEEE93CCC8E1");
            }
            match(input,74,FOLLOW_74_in_tcs_filterparg6095); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DD2C310F2911DFC2A1EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_filterparg6099); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DD2C340F2911DFC2CCEEEE93CCC8E1");
            }
            // parser/TCS.g:1109:225: (temp= stringSymbol )
            // parser/TCS.g:1109:227: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_filterparg6107);
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
              _beforeSeqEl("E0DCF6CD34DD2C3F0F2911DFA982EEEE93CCC8E1");
            }
            // parser/TCS.g:1109:357: ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==COMA) ) {
                int LA104_1 = input.LA(2);

                if ( (LA104_1==51||LA104_1==53||LA104_1==56||LA104_1==61||LA104_1==63||LA104_1==67||LA104_1==71||LA104_1==74||LA104_1==87||LA104_1==95||LA104_1==98||LA104_1==114||LA104_1==121||LA104_1==127||LA104_1==133) ) {
                    alt104=2;
                }
                else if ( (LA104_1==69) ) {
                    alt104=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 104, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA104_0==EOF||LA104_0==RCURLY) ) {
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
                    // parser/TCS.g:1109:358: ( COMA 'invert' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1109:374: ( COMA 'invert' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:1109:375: COMA 'invert' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34DD2C380F2911DFB875EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_filterparg6120); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34DD2C390F2911DF90AFEEEE93CCC8E1");
                    }
                    match(input,69,FOLLOW_69_in_tcs_filterparg6124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34DD2C3A0F2911DFA053EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_filterparg6128); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34DD2C3D0F2911DF9CE9EEEE93CCC8E1");
                    }
                    // parser/TCS.g:1109:677: (temp= stringSymbol )
                    // parser/TCS.g:1109:679: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_filterparg6136);
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
                    // parser/TCS.g:1109:767: 
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
    // parser/TCS.g:1118:1: tcs_modeparg returns [Object ret2] : ( 'mode' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_modeparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ModePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1123:3: ( ( 'mode' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:1124:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:1124:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:1124:4: 'mode' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DF9D300F2911DF9302EEEE93CCC8E1");
            }
            match(input,87,FOLLOW_87_in_tcs_modeparg6192); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DF9D310F2911DFB364EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_modeparg6196); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34DF9D340F2911DFA611EEEE93CCC8E1");
            }
            // parser/TCS.g:1124:223: (temp= identifierOrKeyword )
            // parser/TCS.g:1124:225: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_modeparg6204);
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
    // parser/TCS.g:1132:1: tcs_blockarg returns [Object ret2] : (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) ;
    public final Object tcs_blockarg() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1133:3: ( (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) )
            // parser/TCS.g:1134:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            {
            // parser/TCS.g:1134:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            int alt105=5;
            switch ( input.LA(1) ) {
            case 131:
                {
                alt105=1;
                }
                break;
            case 120:
                {
                alt105=2;
                }
                break;
            case 130:
                {
                alt105=3;
                }
                break;
            case 78:
                {
                alt105=4;
                }
                break;
            case 115:
                {
                alt105=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }

            switch (alt105) {
                case 1 :
                    // parser/TCS.g:1134:4: ret= tcs_nbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_nbnlbarg_in_tcs_blockarg6244);
                    ret=tcs_nbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1135:5: ret= tcs_indentincrbarg
                    {
                    pushFollow(FOLLOW_tcs_indentincrbarg_in_tcs_blockarg6252);
                    ret=tcs_indentincrbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1136:5: ret= tcs_startnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnlbarg_in_tcs_blockarg6260);
                    ret=tcs_startnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1137:5: ret= tcs_startnbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg6268);
                    ret=tcs_startnbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1138:5: ret= tcs_endnlbarg
                    {
                    pushFollow(FOLLOW_tcs_endnlbarg_in_tcs_blockarg6276);
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
    // parser/TCS.g:1145:1: tcs_nbnlbarg returns [Object ret2] : ( 'nbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_nbnlbarg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1150:3: ( ( 'nbNL' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1151:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1151:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1151:4: 'nbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E1E7220F2911DFA3F2EEEE93CCC8E1");
            }
            match(input,131,FOLLOW_131_in_tcs_nbnlbarg6306); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E1E7230F2911DF90DCEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_nbnlbarg6310); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E1E7250F2911DFC943EEEE93CCC8E1");
            }
            // parser/TCS.g:1151:223: (temp= integerSymbol )
            // parser/TCS.g:1151:225: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_nbnlbarg6318);
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
    // parser/TCS.g:1159:1: tcs_indentincrbarg returns [Object ret2] : ( 'indentIncr' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_indentincrbarg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IndentIncrBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1164:3: ( ( 'indentIncr' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1165:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1165:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1165:4: 'indentIncr' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E458200F2911DF888BEEEE93CCC8E1");
            }
            match(input,120,FOLLOW_120_in_tcs_indentincrbarg6361); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E458210F2911DFA25DEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_indentincrbarg6365); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E458230F2911DF9BC1EEEE93CCC8E1");
            }
            // parser/TCS.g:1165:229: (temp= integerSymbol )
            // parser/TCS.g:1165:231: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_indentincrbarg6373);
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
    // parser/TCS.g:1173:1: tcs_startnlbarg returns [Object ret2] : ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_startnlbarg() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","StartNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1178:3: ( ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // parser/TCS.g:1179:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // parser/TCS.g:1179:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // parser/TCS.g:1179:4: 'startNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E458270F2911DFA80EEEEE93CCC8E1");
            }
            match(input,130,FOLLOW_130_in_tcs_startnlbarg6416); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E458280F2911DFB110EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnlbarg6420); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E458300F2911DFCB22EEEE93CCC8E1");
            }
            // parser/TCS.g:1179:227: ( ( 'true' ) | ( 'false' ) )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==88) ) {
                alt106=1;
            }
            else if ( (LA106_0==83) ) {
                alt106=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // parser/TCS.g:1179:228: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1179:244: ( 'true' )
                    // parser/TCS.g:1179:245: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34E4582C0F2911DF9E7AEEEE93CCC8E1");
                    }
                    match(input,88,FOLLOW_88_in_tcs_startnlbarg6430); if (state.failed) return ret2;
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
                    // parser/TCS.g:1179:396: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1179:412: ( 'false' )
                    // parser/TCS.g:1179:413: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34E4582E0F2911DF8781EEEE93CCC8E1");
                    }
                    match(input,83,FOLLOW_83_in_tcs_startnlbarg6443); if (state.failed) return ret2;
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
    // parser/TCS.g:1188:1: tcs_startnbnlbarg returns [Object ret2] : ( 'startNbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_startnbnlbarg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StartNbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1193:3: ( ( 'startNbNL' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1194:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1194:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1194:4: 'startNbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E6A2100F2911DFCB97EEEE93CCC8E1");
            }
            match(input,78,FOLLOW_78_in_tcs_startnbnlbarg6490); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E6A2110F2911DF8A43EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnbnlbarg6494); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E6A2130F2911DF8EBCEEEE93CCC8E1");
            }
            // parser/TCS.g:1194:228: (temp= integerSymbol )
            // parser/TCS.g:1194:230: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_startnbnlbarg6502);
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
    // parser/TCS.g:1202:1: tcs_endnlbarg returns [Object ret2] : ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_endnlbarg() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","EndNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1207:3: ( ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // parser/TCS.g:1208:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // parser/TCS.g:1208:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // parser/TCS.g:1208:4: 'endNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E6A2170F2911DFC6EDEEEE93CCC8E1");
            }
            match(input,115,FOLLOW_115_in_tcs_endnlbarg6545); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E6A2180F2911DFC006EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endnlbarg6549); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E913120F2911DF9B0AEEEE93CCC8E1");
            }
            // parser/TCS.g:1208:225: ( ( 'true' ) | ( 'false' ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==88) ) {
                alt107=1;
            }
            else if ( (LA107_0==83) ) {
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
                    // parser/TCS.g:1208:226: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1208:242: ( 'true' )
                    // parser/TCS.g:1208:243: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34E6A21C0F2911DFAEF9EEEE93CCC8E1");
                    }
                    match(input,88,FOLLOW_88_in_tcs_endnlbarg6559); if (state.failed) return ret2;
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
                    // parser/TCS.g:1208:394: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1208:410: ( 'false' )
                    // parser/TCS.g:1208:411: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34E913100F2911DFCCB4EEEE93CCC8E1");
                    }
                    match(input,83,FOLLOW_83_in_tcs_endnlbarg6572); if (state.failed) return ret2;
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
    // parser/TCS.g:1217:1: tcs_symbol returns [Object ret2] : ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) ;
    public final Object tcs_symbol() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Symbol");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1222:3: ( ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) )
            // parser/TCS.g:1223:3: ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            {
            // parser/TCS.g:1223:3: ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            // parser/TCS.g:1223:4: (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E913170F2911DFB4FEEEEE93CCC8E1");
            }
            // parser/TCS.g:1223:63: (temp= identifier )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==NAME) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // parser/TCS.g:1223:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_symbol6623);
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
              _beforeSeqEl("E0DCF6CD34E913180F2911DF8896EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_symbol6632); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34E9131B0F2911DFBC8EEEEE93CCC8E1");
            }
            // parser/TCS.g:1223:271: (temp= stringSymbol )
            // parser/TCS.g:1223:273: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_symbol6640);
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
              _beforeSeqEl("E0DCF6CD34EB84100F2911DF9546EEEE93CCC8E1");
            }
            // parser/TCS.g:1223:402: ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==COLON) ) {
                alt111=1;
            }
            else if ( (LA111_0==SEMI) ) {
                alt111=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // parser/TCS.g:1223:403: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1223:419: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    // parser/TCS.g:1223:420: COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34E9131F0F2911DFAFACEEEE93CCC8E1");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_symbol6653); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34E913240F2911DFB127EEEE93CCC8E1");
                    }
                    // parser/TCS.g:1223:561: (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==58||LA110_0==64||LA110_0==80||LA110_0==125) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // parser/TCS.g:1223:563: temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )*
                            {
                            pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol6661);
                            temp=tcs_spacekind();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "spaces", temp);
                            }
                            // parser/TCS.g:1223:618: ( ( COMA ) temp= tcs_spacekind )*
                            loop109:
                            do {
                                int alt109=2;
                                int LA109_0 = input.LA(1);

                                if ( (LA109_0==COMA) ) {
                                    alt109=1;
                                }


                                switch (alt109) {
                            	case 1 :
                            	    // parser/TCS.g:1223:619: ( COMA ) temp= tcs_spacekind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:1223:636: ( COMA )
                            	    // parser/TCS.g:1223:637: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CD34E913210F2911DF81B7EEEE93CCC8E1");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_symbol6670); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol6678);
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
                            	    break loop109;
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
                    // parser/TCS.g:1223:830: 
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
              _beforeSeqEl("E0DCF6CD34EB84110F2911DF91CEEEEE93CCC8E1");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_symbol6703); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1232:1: tcs_spacekind returns [Object ret2] : ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) ;
    public final Object tcs_spacekind() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1233:3: ( ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) )
            // parser/TCS.g:1234:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            {
            // parser/TCS.g:1234:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            int alt112=4;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt112=1;
                }
                break;
            case 64:
                {
                alt112=2;
                }
                break;
            case 125:
                {
                alt112=3;
                }
                break;
            case 80:
                {
                alt112=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // parser/TCS.g:1234:4: ( 'leftSpace' )
                    {
                    // parser/TCS.g:1234:4: ( 'leftSpace' )
                    // parser/TCS.g:1234:5: 'leftSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34EB84160F2911DF8D15EEEE93CCC8E1");
                    }
                    match(input,58,FOLLOW_58_in_tcs_spacekind6745); if (state.failed) return ret2;
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
                    // parser/TCS.g:1235:4: ( 'leftNone' )
                    {
                    // parser/TCS.g:1235:4: ( 'leftNone' )
                    // parser/TCS.g:1235:5: 'leftNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34EB84190F2911DFC308EEEE93CCC8E1");
                    }
                    match(input,64,FOLLOW_64_in_tcs_spacekind6755); if (state.failed) return ret2;
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
                    // parser/TCS.g:1236:4: ( 'rightSpace' )
                    {
                    // parser/TCS.g:1236:4: ( 'rightSpace' )
                    // parser/TCS.g:1236:5: 'rightSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34EB841C0F2911DF88EFEEEE93CCC8E1");
                    }
                    match(input,125,FOLLOW_125_in_tcs_spacekind6765); if (state.failed) return ret2;
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
                    // parser/TCS.g:1237:4: ( 'rightNone' )
                    {
                    // parser/TCS.g:1237:4: ( 'rightNone' )
                    // parser/TCS.g:1237:5: 'rightNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34EB841F0F2911DF8F4AEEEE93CCC8E1");
                    }
                    match(input,80,FOLLOW_80_in_tcs_spacekind6775); if (state.failed) return ret2;
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
    // parser/TCS.g:1244:1: tcs_keyword returns [Object ret2] : ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI ) ;
    public final Object tcs_keyword() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Keyword");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1249:3: ( ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI ) )
            // parser/TCS.g:1250:3: ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI )
            {
            // parser/TCS.g:1250:3: ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI )
            // parser/TCS.g:1250:4: (temp= identifier )? EQ (temp= stringSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34EDCE010F2911DFC4E8EEEE93CCC8E1");
            }
            // parser/TCS.g:1250:63: (temp= identifier )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==NAME) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // parser/TCS.g:1250:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_keyword6810);
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
              _beforeSeqEl("E0DCF6CD34EDCE020F2911DFBF20EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_keyword6819); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34EDCE050F2911DFBDB2EEEE93CCC8E1");
            }
            // parser/TCS.g:1250:271: (temp= stringSymbol )
            // parser/TCS.g:1250:273: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_keyword6827);
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
              _beforeSeqEl("E0DCF6CD34EDCE060F2911DF89FAEEEE93CCC8E1");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_keyword6834); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1258:1: tcs_operatorlist returns [Object ret2] : ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) ;
    public final Object tcs_operatorlist() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1263:3: ( ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) )
            // parser/TCS.g:1264:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            {
            // parser/TCS.g:1264:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            // parser/TCS.g:1264:4: 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34EDCE0A0F2911DF85D8EEEE93CCC8E1");
            }
            match(input,132,FOLLOW_132_in_tcs_operatorlist6875); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34F03F010F2911DF9C83EEEE93CCC8E1");
            }
            // parser/TCS.g:1264:150: ( ( (temp= identifier ) ) | )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==NAME) ) {
                alt114=1;
            }
            else if ( (LA114_0==LCURLY) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // parser/TCS.g:1264:151: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1264:167: ( (temp= identifier ) )
                    // parser/TCS.g:1264:168: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34EDCE0F0F2911DFBEFDEEEE93CCC8E1");
                    }
                    // parser/TCS.g:1264:227: (temp= identifier )
                    // parser/TCS.g:1264:229: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatorlist6888);
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
                    // parser/TCS.g:1264:313: 
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
              _beforeSeqEl("E0DCF6CD34F03F020F2911DF88B9EEEE93CCC8E1");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_operatorlist6908); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34F03F060F2911DFB326EEEE93CCC8E1");
            }
            // parser/TCS.g:1265:159: ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) )
            // parser/TCS.g:1265:160: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            {
            // parser/TCS.g:1265:160: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            // parser/TCS.g:1265:161: (temp= tcs_priority (temp= tcs_priority )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34F03F040F2911DFA0E6EEEE93CCC8E1");
            }
            // parser/TCS.g:1265:220: (temp= tcs_priority (temp= tcs_priority )* )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==82) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // parser/TCS.g:1265:222: temp= tcs_priority (temp= tcs_priority )*
                    {
                    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist6919);
                    temp=tcs_priority();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "priorities", temp);
                    }
                    // parser/TCS.g:1265:280: (temp= tcs_priority )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==82) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // parser/TCS.g:1265:282: temp= tcs_priority
                    	    {
                    	    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist6927);
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
                    	    break loop115;
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
              _beforeSeqEl("E0DCF6CD34F03F070F2911DF9A4BEEEE93CCC8E1");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_operatorlist6942); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1273:1: tcs_priority returns [Object ret2] : ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) ;
    public final Object tcs_priority() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Priority");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1278:3: ( ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) )
            // parser/TCS.g:1279:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            {
            // parser/TCS.g:1279:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            // parser/TCS.g:1279:4: 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34F03F0B0F2911DF8A08EEEE93CCC8E1");
            }
            match(input,82,FOLLOW_82_in_tcs_priority6983); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34F03F0D0F2911DFC695EEEE93CCC8E1");
            }
            // parser/TCS.g:1279:148: (temp= integerSymbol )
            // parser/TCS.g:1279:150: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_priority6990);
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
              _beforeSeqEl("E0DCF6CD34F03F170F2911DFB426EEEE93CCC8E1");
            }
            // parser/TCS.g:1279:280: ( () | ( COMA (temp= tcs_associativity ) ) )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==LCURLY) ) {
                alt117=1;
            }
            else if ( (LA117_0==COMA) ) {
                alt117=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // parser/TCS.g:1279:281: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1279:297: ()
                    // parser/TCS.g:1279:298: 
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
                    // parser/TCS.g:1279:407: ( COMA (temp= tcs_associativity ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1279:423: ( COMA (temp= tcs_associativity ) )
                    // parser/TCS.g:1279:424: COMA (temp= tcs_associativity )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34F03F130F2911DFA47FEEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_priority7013); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34F03F150F2911DF880DEEEE93CCC8E1");
                    }
                    // parser/TCS.g:1279:564: (temp= tcs_associativity )
                    // parser/TCS.g:1279:566: temp= tcs_associativity
                    {
                    pushFollow(FOLLOW_tcs_associativity_in_tcs_priority7021);
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
              _beforeSeqEl("E0DCF6CD34F03F180F2911DFB6B7EEEE93CCC8E1");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_priority7035); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34F288F00F2911DFCBCAEEEE93CCC8E1");
            }
            // parser/TCS.g:1280:159: ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) )
            // parser/TCS.g:1280:160: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            {
            // parser/TCS.g:1280:160: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            // parser/TCS.g:1280:161: (temp= tcs_operator (temp= tcs_operator )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34F03F1A0F2911DFA263EEEE93CCC8E1");
            }
            // parser/TCS.g:1280:220: (temp= tcs_operator (temp= tcs_operator )* )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==NAME||LA119_0==EQ||LA119_0==109) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // parser/TCS.g:1280:222: temp= tcs_operator (temp= tcs_operator )*
                    {
                    pushFollow(FOLLOW_tcs_operator_in_tcs_priority7046);
                    temp=tcs_operator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operators", temp);
                    }
                    // parser/TCS.g:1280:279: (temp= tcs_operator )*
                    loop118:
                    do {
                        int alt118=2;
                        int LA118_0 = input.LA(1);

                        if ( (LA118_0==NAME||LA118_0==EQ||LA118_0==109) ) {
                            alt118=1;
                        }


                        switch (alt118) {
                    	case 1 :
                    	    // parser/TCS.g:1280:281: temp= tcs_operator
                    	    {
                    	    pushFollow(FOLLOW_tcs_operator_in_tcs_priority7054);
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
                    	    break loop118;
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
              _beforeSeqEl("E0DCF6CD34F288F10F2911DFCF8FEEEE93CCC8E1");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_priority7069); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1288:1: tcs_operator returns [Object ret2] : ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) ;
    public final Object tcs_operator() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Operator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1293:3: ( ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) )
            // parser/TCS.g:1294:3: ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            {
            // parser/TCS.g:1294:3: ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            // parser/TCS.g:1294:4: ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD34F288FA0F2911DF806DEEEE93CCC8E1");
            }
            // parser/TCS.g:1294:64: ( ( 'postfix' ) | )
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==109) ) {
                alt120=1;
            }
            else if ( (LA120_0==NAME||LA120_0==EQ) ) {
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
                    // parser/TCS.g:1294:65: ( 'postfix' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1294:81: ( 'postfix' )
                    // parser/TCS.g:1294:82: 'postfix'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD34F288F80F2911DFB3CBEEEE93CCC8E1");
                    }
                    match(input,109,FOLLOW_109_in_tcs_operator7116); if (state.failed) return ret2;
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
                    // parser/TCS.g:1294:240: 
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
              _beforeSeqEl("E0DCF6CD34F288FC0F2911DFB433EEEE93CCC8E1");
            }
            // parser/TCS.g:1295:76: (temp= identifier )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==NAME) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // parser/TCS.g:1295:78: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operator7138);
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
              _beforeSeqEl("E0DCF6CD34F288FD0F2911DFBD3CEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operator7147); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD350CC7B10F2911DFCB79EEEE93CCC8E1");
            }
            // parser/TCS.g:1295:285: ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( ((LA123_0>=NAME && LA123_0<=STRING)) ) {
                alt123=1;
            }
            else if ( (LA123_0==COMA) ) {
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
                    // parser/TCS.g:1295:286: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1295:302: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    // parser/TCS.g:1295:303: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD35059BC00F2911DF9520EEEE93CCC8E1");
                    }
                    // parser/TCS.g:1295:362: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    int alt122=2;
                    int LA122_0 = input.LA(1);

                    if ( (LA122_0==NAME) ) {
                        alt122=1;
                    }
                    else if ( (LA122_0==STRING) ) {
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
                            // parser/TCS.g:1295:363: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:1295:379: ( (temp= identifier ) )
                            // parser/TCS.g:1295:380: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD34F289030F2911DF9389EEEE93CCC8E1");
                            }
                            // parser/TCS.g:1295:439: (temp= identifier )
                            // parser/TCS.g:1295:441: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_operator7166);
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
                            // parser/TCS.g:1296:4: ( (temp= stringSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // parser/TCS.g:1296:20: ( (temp= stringSymbol ) )
                            // parser/TCS.g:1296:21: (temp= stringSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD350351D60F2911DFC9B2EEEE93CCC8E1");
                            }
                            // parser/TCS.g:1296:80: (temp= stringSymbol )
                            // parser/TCS.g:1296:82: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_operator7186);
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
                    // parser/TCS.g:1296:287: 
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
              _beforeSeqEl("E0DCF6CD350CC7B20F2911DFA825EEEE93CCC8E1");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_operator7211); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD350CC7B40F2911DFB80BEEEE93CCC8E1");
            }
            // parser/TCS.g:1297:157: (temp= integerSymbol )
            // parser/TCS.g:1297:159: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_operator7219);
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
              _beforeSeqEl("E0DCF6CD350F38B00F2911DF98D1EEEE93CCC8E1");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_operator7226); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1305:1: tcs_associativity returns [Object ret2] : ( ( 'left' ) | ( 'right' ) ) ;
    public final Object tcs_associativity() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1306:3: ( ( ( 'left' ) | ( 'right' ) ) )
            // parser/TCS.g:1307:3: ( ( 'left' ) | ( 'right' ) )
            {
            // parser/TCS.g:1307:3: ( ( 'left' ) | ( 'right' ) )
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==108) ) {
                alt124=1;
            }
            else if ( (LA124_0==118) ) {
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
                    // parser/TCS.g:1307:4: ( 'left' )
                    {
                    // parser/TCS.g:1307:4: ( 'left' )
                    // parser/TCS.g:1307:5: 'left'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD350F38B50F2911DFBD16EEEE93CCC8E1");
                    }
                    match(input,108,FOLLOW_108_in_tcs_associativity7268); if (state.failed) return ret2;
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
                    // parser/TCS.g:1308:4: ( 'right' )
                    {
                    // parser/TCS.g:1308:4: ( 'right' )
                    // parser/TCS.g:1308:5: 'right'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD350F38B80F2911DFB842EEEE93CCC8E1");
                    }
                    match(input,118,FOLLOW_118_in_tcs_associativity7278); if (state.failed) return ret2;
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
    // parser/TCS.g:1315:1: tcs_expression returns [Object ret2] : (ret= tcs_andexp ) ;
    public final Object tcs_expression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1316:3: ( (ret= tcs_andexp ) )
            // parser/TCS.g:1317:3: (ret= tcs_andexp )
            {
            // parser/TCS.g:1317:3: (ret= tcs_andexp )
            // parser/TCS.g:1317:4: ret= tcs_andexp
            {
            pushFollow(FOLLOW_tcs_andexp_in_tcs_expression7306);
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
    // parser/TCS.g:1324:1: tcs_andexp returns [Object ret2] : ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) ;
    public final Object tcs_andexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AndExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1329:3: ( ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) )
            // parser/TCS.g:1330:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            {
            // parser/TCS.g:1330:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            // parser/TCS.g:1330:4: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351182A60F2911DFA00EEEEE93CCC8E1");
            }
            // parser/TCS.g:1330:63: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==NAME||LA126_0==RARROW||(LA126_0>=49 && LA126_0<=134)) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // parser/TCS.g:1330:65: temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )*
                    {
                    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp7340);
                    temp=tcs_atomexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "expressions", temp);
                    }
                    // parser/TCS.g:1330:123: ( ( 'and' ) temp= tcs_atomexp )*
                    loop125:
                    do {
                        int alt125=2;
                        int LA125_0 = input.LA(1);

                        if ( (LA125_0==116) ) {
                            alt125=1;
                        }


                        switch (alt125) {
                    	case 1 :
                    	    // parser/TCS.g:1330:124: ( 'and' ) temp= tcs_atomexp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:1330:141: ( 'and' )
                    	    // parser/TCS.g:1330:142: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD351182A30F2911DF89C9EEEE93CCC8E1");
                    	    }
                    	    match(input,116,FOLLOW_116_in_tcs_andexp7348); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp7355);
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
                    	    break loop125;
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
    // parser/TCS.g:1338:1: tcs_atomexp returns [Object ret2] : (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp ) ;
    public final Object tcs_atomexp() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1339:3: ( (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp ) )
            // parser/TCS.g:1340:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )
            {
            // parser/TCS.g:1340:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )
            int alt127=5;
            alt127 = dfa127.predict(input);
            switch (alt127) {
                case 1 :
                    // parser/TCS.g:1340:4: ret= tcs_equalsexp
                    {
                    pushFollow(FOLLOW_tcs_equalsexp_in_tcs_atomexp7400);
                    ret=tcs_equalsexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1341:5: ret= tcs_booleanpropertyexp
                    {
                    pushFollow(FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp7408);
                    ret=tcs_booleanpropertyexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1342:5: ret= tcs_isdefinedexp
                    {
                    pushFollow(FOLLOW_tcs_isdefinedexp_in_tcs_atomexp7416);
                    ret=tcs_isdefinedexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1343:5: ret= tcs_oneexp
                    {
                    pushFollow(FOLLOW_tcs_oneexp_in_tcs_atomexp7424);
                    ret=tcs_oneexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1344:5: ret= tcs_instanceofexp
                    {
                    pushFollow(FOLLOW_tcs_instanceofexp_in_tcs_atomexp7432);
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
    // parser/TCS.g:1351:1: tcs_equalsexp returns [Object ret2] : ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) ) ;
    public final Object tcs_equalsexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EqualsExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1356:3: ( ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) ) )
            // parser/TCS.g:1357:3: ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) )
            {
            // parser/TCS.g:1357:3: ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) )
            // parser/TCS.g:1357:4: (temp= tcs_propertyreference ) EQ (temp= tcs_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3513F3A10F2911DFC2FDEEEE93CCC8E1");
            }
            // parser/TCS.g:1357:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1357:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_equalsexp7466);
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
              _beforeSeqEl("E0DCF6CD3513F3A20F2911DFBF66EEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_equalsexp7473); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3513F3A40F2911DFBD04EEEE93CCC8E1");
            }
            // parser/TCS.g:1357:293: (temp= tcs_value )
            // parser/TCS.g:1357:295: temp= tcs_value
            {
            pushFollow(FOLLOW_tcs_value_in_tcs_equalsexp7481);
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
    // parser/TCS.g:1365:1: tcs_booleanpropertyexp returns [Object ret2] : ( (temp= tcs_propertyreference ) ) ;
    public final Object tcs_booleanpropertyexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","BooleanPropertyExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1370:3: ( ( (temp= tcs_propertyreference ) ) )
            // parser/TCS.g:1371:3: ( (temp= tcs_propertyreference ) )
            {
            // parser/TCS.g:1371:3: ( (temp= tcs_propertyreference ) )
            // parser/TCS.g:1371:4: (temp= tcs_propertyreference )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3513F3A90F2911DFAC69EEEE93CCC8E1");
            }
            // parser/TCS.g:1371:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1371:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_booleanpropertyexp7528);
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
    // parser/TCS.g:1379:1: tcs_isdefinedexp returns [Object ret2] : ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN ) ;
    public final Object tcs_isdefinedexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IsDefinedExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1384:3: ( ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN ) )
            // parser/TCS.g:1385:3: ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN )
            {
            // parser/TCS.g:1385:3: ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN )
            // parser/TCS.g:1385:4: 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD35163D900F2911DFCE9FEEEE93CCC8E1");
            }
            match(input,66,FOLLOW_66_in_tcs_isdefinedexp7571); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD35163D910F2911DF8060EEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_isdefinedexp7575); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD35163D930F2911DFC12FEEEE93CCC8E1");
            }
            // parser/TCS.g:1385:232: (temp= tcs_propertyreference )
            // parser/TCS.g:1385:234: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_isdefinedexp7583);
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
              _beforeSeqEl("E0DCF6CD35163D940F2911DF9BE2EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_isdefinedexp7590); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1393:1: tcs_oneexp returns [Object ret2] : ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN ) ;
    public final Object tcs_oneexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OneExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1398:3: ( ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN ) )
            // parser/TCS.g:1399:3: ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN )
            {
            // parser/TCS.g:1399:3: ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN )
            // parser/TCS.g:1399:4: 'one' LPAREN (temp= tcs_propertyreference ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD35163D980F2911DFB674EEEE93CCC8E1");
            }
            match(input,107,FOLLOW_107_in_tcs_oneexp7631); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD35163D990F2911DF8038EEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_oneexp7635); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD35163D9B0F2911DF8570EEEE93CCC8E1");
            }
            // parser/TCS.g:1399:226: (temp= tcs_propertyreference )
            // parser/TCS.g:1399:228: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_oneexp7643);
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
              _beforeSeqEl("E0DCF6CD35163D9C0F2911DFB1AAEEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_oneexp7650); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1407:1: tcs_instanceofexp returns [Object ret2] : ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) ;
    public final Object tcs_instanceofexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","InstanceOfExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1412:3: ( ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) )
            // parser/TCS.g:1413:3: ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
            {
            // parser/TCS.g:1413:3: ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
            // parser/TCS.g:1413:4: (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3518AE910F2911DFA7BAEEEE93CCC8E1");
            }
            // parser/TCS.g:1413:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1413:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_instanceofexp7695);
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
              _beforeSeqEl("E0DCF6CD3518AE920F2911DFBDC6EEEE93CCC8E1");
            }
            match(input,50,FOLLOW_50_in_tcs_instanceofexp7701); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3518AE970F2911DFB95EEEEE93CCC8E1");
            }
            // parser/TCS.g:1413:301: (temp= identifier ( ( DLCOLON ) temp= identifier )* )
            // parser/TCS.g:1413:303: temp= identifier ( ( DLCOLON ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_tcs_instanceofexp7708);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "supertype", temp);
            }
            // parser/TCS.g:1413:358: ( ( DLCOLON ) temp= identifier )*
            loop128:
            do {
                int alt128=2;
                int LA128_0 = input.LA(1);

                if ( (LA128_0==DLCOLON) ) {
                    alt128=1;
                }


                switch (alt128) {
            	case 1 :
            	    // parser/TCS.g:1413:359: ( DLCOLON ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:1413:376: ( DLCOLON )
            	    // parser/TCS.g:1413:377: DLCOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CD3518AE940F2911DFAC67EEEE93CCC8E1");
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_tcs_instanceofexp7717); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_tcs_instanceofexp7725);
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
            	    break loop128;
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
    // parser/TCS.g:1421:1: tcs_value returns [Object ret2] : (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) ;
    public final Object tcs_value() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1422:3: ( (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) )
            // parser/TCS.g:1423:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            {
            // parser/TCS.g:1423:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            int alt129=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt129=1;
                }
                break;
            case INT:
                {
                alt129=2;
                }
                break;
            case MINUS:
                {
                alt129=3;
                }
                break;
            case SHARP:
                {
                alt129=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }

            switch (alt129) {
                case 1 :
                    // parser/TCS.g:1423:4: ret= tcs_stringval
                    {
                    pushFollow(FOLLOW_tcs_stringval_in_tcs_value7768);
                    ret=tcs_stringval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1424:5: ret= tcs_integerval
                    {
                    pushFollow(FOLLOW_tcs_integerval_in_tcs_value7776);
                    ret=tcs_integerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1425:5: ret= tcs_negativeintegerval
                    {
                    pushFollow(FOLLOW_tcs_negativeintegerval_in_tcs_value7784);
                    ret=tcs_negativeintegerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1426:5: ret= tcs_enumliteralval
                    {
                    pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_value7792);
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
    // parser/TCS.g:1433:1: tcs_stringval returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_stringval() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1438:3: ( ( (temp= stringSymbol ) ) )
            // parser/TCS.g:1439:3: ( (temp= stringSymbol ) )
            {
            // parser/TCS.g:1439:3: ( (temp= stringSymbol ) )
            // parser/TCS.g:1439:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351B1F920F2911DF8228EEEE93CCC8E1");
            }
            // parser/TCS.g:1439:63: (temp= stringSymbol )
            // parser/TCS.g:1439:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_stringval7826);
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
    // parser/TCS.g:1447:1: tcs_integerval returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object tcs_integerval() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1452:3: ( ( (temp= integerSymbol ) ) )
            // parser/TCS.g:1453:3: ( (temp= integerSymbol ) )
            {
            // parser/TCS.g:1453:3: ( (temp= integerSymbol ) )
            // parser/TCS.g:1453:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351B1F970F2911DF902EEEEE93CCC8E1");
            }
            // parser/TCS.g:1453:63: (temp= integerSymbol )
            // parser/TCS.g:1453:65: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_integerval7873);
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
    // parser/TCS.g:1461:1: tcs_negativeintegerval returns [Object ret2] : ( MINUS (temp= integerSymbol ) ) ;
    public final Object tcs_negativeintegerval() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NegativeIntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1466:3: ( ( MINUS (temp= integerSymbol ) ) )
            // parser/TCS.g:1467:3: ( MINUS (temp= integerSymbol ) )
            {
            // parser/TCS.g:1467:3: ( MINUS (temp= integerSymbol ) )
            // parser/TCS.g:1467:4: MINUS (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351D69800F2911DF85ECEEEE93CCC8E1");
            }
            match(input,MINUS,FOLLOW_MINUS_in_tcs_negativeintegerval7917); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351D69820F2911DFC4E2EEEE93CCC8E1");
            }
            // parser/TCS.g:1467:145: (temp= integerSymbol )
            // parser/TCS.g:1467:147: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_negativeintegerval7925);
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
    // parser/TCS.g:1475:1: tcs_enumliteralval returns [Object ret2] : ( SHARP (temp= identifierOrKeyword ) ) ;
    public final Object tcs_enumliteralval() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1480:3: ( ( SHARP (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:1481:3: ( SHARP (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:1481:3: ( SHARP (temp= identifierOrKeyword ) )
            // parser/TCS.g:1481:4: SHARP (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351D69860F2911DFCCB5EEEE93CCC8E1");
            }
            match(input,SHARP,FOLLOW_SHARP_in_tcs_enumliteralval7969); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351D69890F2911DFCD06EEEE93CCC8E1");
            }
            // parser/TCS.g:1481:145: (temp= identifierOrKeyword )
            // parser/TCS.g:1481:147: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_enumliteralval7977);
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
    // parser/TCS.g:1489:1: tcs_token returns [Object ret2] : ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI ) ;
    public final Object tcs_token() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Token");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1494:3: ( ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI ) )
            // parser/TCS.g:1495:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI )
            {
            // parser/TCS.g:1495:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI )
            // parser/TCS.g:1495:4: ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351FDA850F2911DF8B3BEEEE93CCC8E1");
            }
            // parser/TCS.g:1495:64: ( ( 'omitted' ) | )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==52) ) {
                alt130=1;
            }
            else if ( (LA130_0==119) ) {
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
                    // parser/TCS.g:1495:65: ( 'omitted' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1495:81: ( 'omitted' )
                    // parser/TCS.g:1495:82: 'omitted'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD351FDA830F2911DFABE7EEEE93CCC8E1");
                    }
                    match(input,52,FOLLOW_52_in_tcs_token8026); if (state.failed) return ret2;
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
                    // parser/TCS.g:1495:240: 
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
              _beforeSeqEl("E0DCF6CD351FDA860F2911DF8321EEEE93CCC8E1");
            }
            match(input,119,FOLLOW_119_in_tcs_token8044); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351FDA880F2911DFB6F2EEEE93CCC8E1");
            }
            // parser/TCS.g:1496:158: (temp= identifier )?
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==NAME) ) {
                alt131=1;
            }
            switch (alt131) {
                case 1 :
                    // parser/TCS.g:1496:160: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_token8051);
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
              _beforeSeqEl("E0DCF6CD351FDA890F2911DFBEEEEEEE93CCC8E1");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_token8060); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351FDA8B0F2911DF8097EEEE93CCC8E1");
            }
            // parser/TCS.g:1496:369: (temp= tcs_orpattern )
            // parser/TCS.g:1496:371: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_token8068);
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
              _beforeSeqEl("E0DCF6CD351FDA8C0F2911DFBE50EEEE93CCC8E1");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_token8075); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1504:1: tcs_orpattern returns [Object ret2] : ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? ) ;
    public final Object tcs_orpattern() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OrPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1509:3: ( ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? ) )
            // parser/TCS.g:1510:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? )
            {
            // parser/TCS.g:1510:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? )
            // parser/TCS.g:1510:4: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD351FDA940F2911DFA267EEEE93CCC8E1");
            }
            // parser/TCS.g:1510:63: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )?
            int alt133=2;
            switch ( input.LA(1) ) {
                case STRING:
                case LSQUARE:
                case PIPE:
                case 72:
                case 94:
                case 124:
                    {
                    alt133=1;
                    }
                    break;
                case SEMI:
                    {
                    int LA133_2 = input.LA(2);

                    if ( (synpred251_TCS()) ) {
                        alt133=1;
                    }
                    }
                    break;
                case COMA:
                    {
                    int LA133_3 = input.LA(2);

                    if ( (synpred251_TCS()) ) {
                        alt133=1;
                    }
                    }
                    break;
                case RPAREN:
                    {
                    int LA133_4 = input.LA(2);

                    if ( (synpred251_TCS()) ) {
                        alt133=1;
                    }
                    }
                    break;
                case EOF:
                    {
                    int LA133_5 = input.LA(2);

                    if ( (synpred251_TCS()) ) {
                        alt133=1;
                    }
                    }
                    break;
            }

            switch (alt133) {
                case 1 :
                    // parser/TCS.g:1510:65: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
                    {
                    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern8120);
                    temp=tcs_simplepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "simplePatterns", temp);
                    }
                    // parser/TCS.g:1510:132: ( ( PIPE ) temp= tcs_simplepattern )*
                    loop132:
                    do {
                        int alt132=2;
                        int LA132_0 = input.LA(1);

                        if ( (LA132_0==PIPE) ) {
                            alt132=1;
                        }


                        switch (alt132) {
                    	case 1 :
                    	    // parser/TCS.g:1510:133: ( PIPE ) temp= tcs_simplepattern
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:1510:150: ( PIPE )
                    	    // parser/TCS.g:1510:151: PIPE
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CD351FDA910F2911DF8AC5EEEE93CCC8E1");
                    	    }
                    	    match(input,PIPE,FOLLOW_PIPE_in_tcs_orpattern8129); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern8137);
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
                    	    break loop132;
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
    // parser/TCS.g:1518:1: tcs_simplepattern returns [Object ret2] : (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) ;
    public final Object tcs_simplepattern() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1519:3: ( (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) )
            // parser/TCS.g:1520:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            {
            // parser/TCS.g:1520:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            int alt134=3;
            switch ( input.LA(1) ) {
            case 72:
            case 94:
            case 124:
                {
                alt134=1;
                }
                break;
            case EOF:
            case STRING:
            case RPAREN:
            case SEMI:
            case COMA:
            case PIPE:
                {
                alt134=2;
                }
                break;
            case LSQUARE:
                {
                alt134=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }

            switch (alt134) {
                case 1 :
                    // parser/TCS.g:1520:4: ret= tcs_rulepattern
                    {
                    pushFollow(FOLLOW_tcs_rulepattern_in_tcs_simplepattern8182);
                    ret=tcs_rulepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1521:5: ret= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_simplepattern8190);
                    ret=tcs_stringpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1522:5: ret= tcs_classpattern
                    {
                    pushFollow(FOLLOW_tcs_classpattern_in_tcs_simplepattern8198);
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
    // parser/TCS.g:1529:1: tcs_rulepattern returns [Object ret2] : ( (temp= tcs_rule ) ) ;
    public final Object tcs_rulepattern() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RulePattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1534:3: ( ( (temp= tcs_rule ) ) )
            // parser/TCS.g:1535:3: ( (temp= tcs_rule ) )
            {
            // parser/TCS.g:1535:3: ( (temp= tcs_rule ) )
            // parser/TCS.g:1535:4: (temp= tcs_rule )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352224750F2911DFA24DEEEE93CCC8E1");
            }
            // parser/TCS.g:1535:63: (temp= tcs_rule )
            // parser/TCS.g:1535:65: temp= tcs_rule
            {
            pushFollow(FOLLOW_tcs_rule_in_tcs_rulepattern8232);
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
    // parser/TCS.g:1543:1: tcs_rule returns [Object ret2] : (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) ;
    public final Object tcs_rule() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1544:3: ( (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) )
            // parser/TCS.g:1545:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            {
            // parser/TCS.g:1545:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            int alt135=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt135=1;
                }
                break;
            case 124:
                {
                alt135=2;
                }
                break;
            case 72:
                {
                alt135=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }

            switch (alt135) {
                case 1 :
                    // parser/TCS.g:1545:4: ret= tcs_wordrule
                    {
                    pushFollow(FOLLOW_tcs_wordrule_in_tcs_rule8272);
                    ret=tcs_wordrule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1546:5: ret= tcs_endoflinerule
                    {
                    pushFollow(FOLLOW_tcs_endoflinerule_in_tcs_rule8280);
                    ret=tcs_endoflinerule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1547:5: ret= tcs_multilinerule
                    {
                    pushFollow(FOLLOW_tcs_multilinerule_in_tcs_rule8288);
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
    // parser/TCS.g:1554:1: tcs_wordrule returns [Object ret2] : ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN ) ;
    public final Object tcs_wordrule() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","WordRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1559:3: ( ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN ) )
            // parser/TCS.g:1560:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN )
            {
            // parser/TCS.g:1560:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN )
            // parser/TCS.g:1560:4: 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352495720F2911DF9C95EEEE93CCC8E1");
            }
            match(input,94,FOLLOW_94_in_tcs_wordrule8318); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352495730F2911DFB4F6EEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_wordrule8322); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352495740F2911DF8E1CEEEE93CCC8E1");
            }
            match(input,65,FOLLOW_65_in_tcs_wordrule8326); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352495750F2911DF87CBEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8330); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352495770F2911DFAB90EEEE93CCC8E1");
            }
            // parser/TCS.g:1560:388: (temp= tcs_orpattern )
            // parser/TCS.g:1560:390: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8338);
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
              _beforeSeqEl("E0DCF6CD352495780F2911DF94F0EEEE93CCC8E1");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_wordrule8345); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352495790F2911DFAF14EEEE93CCC8E1");
            }
            match(input,49,FOLLOW_49_in_tcs_wordrule8349); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3524957A0F2911DFC85BEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8353); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3524957C0F2911DFC65BEEEE93CCC8E1");
            }
            // parser/TCS.g:1560:760: (temp= tcs_orpattern )
            // parser/TCS.g:1560:762: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8361);
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
              _beforeSeqEl("E0DCF6CD352495860F2911DF8546EEEE93CCC8E1");
            }
            // parser/TCS.g:1560:891: ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | )
            int alt136=2;
            int LA136_0 = input.LA(1);

            if ( (LA136_0==COMA) ) {
                alt136=1;
            }
            else if ( (LA136_0==RPAREN) ) {
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
                    // parser/TCS.g:1560:892: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1560:908: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    // parser/TCS.g:1560:909: COMA 'end' EQ (temp= tcs_orpattern )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD352495800F2911DFB057EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_wordrule8374); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD352495810F2911DF8803EEEE93CCC8E1");
                    }
                    match(input,117,FOLLOW_117_in_tcs_wordrule8378); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD352495820F2911DFA67EEEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8382); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD352495840F2911DFB181EEEE93CCC8E1");
                    }
                    // parser/TCS.g:1560:1208: (temp= tcs_orpattern )
                    // parser/TCS.g:1560:1210: temp= tcs_orpattern
                    {
                    pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8390);
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
                    // parser/TCS.g:1560:1296: 
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
              _beforeSeqEl("E0DCF6CD352495870F2911DFC7A3EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_wordrule8410); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1569:1: tcs_endoflinerule returns [Object ret2] : ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) ;
    public final Object tcs_endoflinerule() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EndOfLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1574:3: ( ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) )
            // parser/TCS.g:1575:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            {
            // parser/TCS.g:1575:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            // parser/TCS.g:1575:4: 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352706700F2911DFC5F2EEEE93CCC8E1");
            }
            match(input,124,FOLLOW_124_in_tcs_endoflinerule8451); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352706710F2911DFA650EEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_endoflinerule8455); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352706720F2911DFB6D8EEEE93CCC8E1");
            }
            match(input,65,FOLLOW_65_in_tcs_endoflinerule8459); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352706730F2911DFA3DFEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endoflinerule8463); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352706790F2911DFC485EEEE93CCC8E1");
            }
            // parser/TCS.g:1575:394: ( ( 'drop' ) | )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==55) ) {
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
                    // parser/TCS.g:1575:395: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1575:411: ( 'drop' )
                    // parser/TCS.g:1575:412: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD352706770F2911DFA51AEEEE93CCC8E1");
                    }
                    match(input,55,FOLLOW_55_in_tcs_endoflinerule8473); if (state.failed) return ret2;
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
                    // parser/TCS.g:1575:567: 
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
              _beforeSeqEl("E0DCF6CD3527067B0F2911DF8B59EEEE93CCC8E1");
            }
            // parser/TCS.g:1576:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1576:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_endoflinerule8495);
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
              _beforeSeqEl("E0DCF6CD3527067C0F2911DFC625EEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_endoflinerule8502); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1584:1: tcs_multilinerule returns [Object ret2] : ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) ;
    public final Object tcs_multilinerule() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","MultiLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1589:3: ( ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) )
            // parser/TCS.g:1590:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            {
            // parser/TCS.g:1590:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            // parser/TCS.g:1590:4: 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352950600F2911DFBBA3EEEE93CCC8E1");
            }
            match(input,72,FOLLOW_72_in_tcs_multilinerule8543); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352950610F2911DFC8FEEEEE93CCC8E1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule8547); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352950620F2911DF960EEEEE93CCC8E1");
            }
            match(input,65,FOLLOW_65_in_tcs_multilinerule8551); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352950630F2911DFCE3CEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8555); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352950690F2911DFB8E6EEEE93CCC8E1");
            }
            // parser/TCS.g:1590:394: ( ( 'drop' ) | )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==55) ) {
                alt138=1;
            }
            else if ( (LA138_0==EOF||LA138_0==STRING||LA138_0==RPAREN||LA138_0==SEMI||LA138_0==COMA||LA138_0==PIPE) ) {
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
                    // parser/TCS.g:1590:395: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1590:411: ( 'drop' )
                    // parser/TCS.g:1590:412: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD352950670F2911DFB446EEEE93CCC8E1");
                    }
                    match(input,55,FOLLOW_55_in_tcs_multilinerule8565); if (state.failed) return ret2;
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
                    // parser/TCS.g:1590:567: 
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
              _beforeSeqEl("E0DCF6CD3529506B0F2911DFA315EEEE93CCC8E1");
            }
            // parser/TCS.g:1591:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1591:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8587);
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
              _beforeSeqEl("E0DCF6CD3529506C0F2911DFB192EEEE93CCC8E1");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8594); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3529506D0F2911DF8798EEEE93CCC8E1");
            }
            match(input,117,FOLLOW_117_in_tcs_multilinerule8598); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3529506E0F2911DFC28BEEEE93CCC8E1");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8602); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352950740F2911DF904EEEEE93CCC8E1");
            }
            // parser/TCS.g:1591:452: ( ( 'drop' ) | )
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==55) ) {
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
                    // parser/TCS.g:1591:453: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1591:469: ( 'drop' )
                    // parser/TCS.g:1591:470: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD352950720F2911DFA6DCEEEE93CCC8E1");
                    }
                    match(input,55,FOLLOW_55_in_tcs_multilinerule8612); if (state.failed) return ret2;
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
                    // parser/TCS.g:1591:623: 
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
              _beforeSeqEl("E0DCF6CD352950760F2911DFBC0EEEEE93CCC8E1");
            }
            // parser/TCS.g:1592:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1592:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8634);
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
              _beforeSeqEl("E0DCF6CD3529508D0F2911DFB371EEEE93CCC8E1");
            }
            // parser/TCS.g:1592:210: ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | )
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==COMA) ) {
                alt143=1;
            }
            else if ( (LA143_0==RPAREN) ) {
                alt143=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 143, 0, input);

                throw nvae;
            }
            switch (alt143) {
                case 1 :
                    // parser/TCS.g:1592:211: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1592:227: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    // parser/TCS.g:1592:228: COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3529507A0F2911DFBBE2EEEE93CCC8E1");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8647); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3529507B0F2911DF98F4EEEE93CCC8E1");
                    }
                    match(input,68,FOLLOW_68_in_tcs_multilinerule8651); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3529507C0F2911DF8AE2EEEE93CCC8E1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8655); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CD3529507E0F2911DF9E0BEEEE93CCC8E1");
                    }
                    // parser/TCS.g:1592:527: (temp= tcs_stringpattern )
                    // parser/TCS.g:1592:529: temp= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8663);
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
                      _beforeSeqEl("E0DCF6CD3529508B0F2911DFC23BEEEE93CCC8E1");
                    }
                    // parser/TCS.g:1592:661: ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    int alt142=2;
                    int LA142_0 = input.LA(1);

                    if ( (LA142_0==COMA) ) {
                        alt142=1;
                    }
                    else if ( (LA142_0==RPAREN) ) {
                        alt142=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 142, 0, input);

                        throw nvae;
                    }
                    switch (alt142) {
                        case 1 :
                            // parser/TCS.g:1592:662: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:1592:678: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            // parser/TCS.g:1592:679: COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD352950820F2911DF984AEEEE93CCC8E1");
                            }
                            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8676); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD352950830F2911DFCF60EEEE93CCC8E1");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule8681); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD352950880F2911DF8326EEEE93CCC8E1");
                            }
                            // parser/TCS.g:1592:902: (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )?
                            int alt141=2;
                            int LA141_0 = input.LA(1);

                            if ( (LA141_0==NAME||LA141_0==POINT||LA141_0==86||LA141_0==112) ) {
                                alt141=1;
                            }
                            switch (alt141) {
                                case 1 :
                                    // parser/TCS.g:1592:904: temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )*
                                    {
                                    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule8689);
                                    temp=tcs_mapping();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "escMappings", temp);
                                    }
                                    // parser/TCS.g:1592:962: ( ( COMA ) temp= tcs_mapping )*
                                    loop140:
                                    do {
                                        int alt140=2;
                                        int LA140_0 = input.LA(1);

                                        if ( (LA140_0==COMA) ) {
                                            alt140=1;
                                        }


                                        switch (alt140) {
                                    	case 1 :
                                    	    // parser/TCS.g:1592:963: ( COMA ) temp= tcs_mapping
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _enterSepSeq();
                                    	    }
                                    	    // parser/TCS.g:1592:980: ( COMA )
                                    	    // parser/TCS.g:1592:981: COMA
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _beforeSeqEl("E0DCF6CD352950850F2911DFA023EEEE93CCC8E1");
                                    	    }
                                    	    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8698); if (state.failed) return ret2;
                                    	    if ( state.backtracking==0 ) {
                                    	      _afterSeqEl();
                                    	    }

                                    	    }

                                    	    if ( state.backtracking==0 ) {
                                    	      _exitSepSeq();
                                    	    }
                                    	    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule8706);
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
                                    	    break loop140;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CD352950890F2911DFA70DEEEE93CCC8E1");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule8718); if (state.failed) return ret2;
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
                            // parser/TCS.g:1592:1260: 
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
                    // parser/TCS.g:1593:35: 
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
              _beforeSeqEl("E0DCF6CD3529508E0F2911DFBCEEEEEE93CCC8E1");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule8749); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1602:1: tcs_mapping returns [Object ret2] : (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) ;
    public final Object tcs_mapping() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1603:3: ( (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) )
            // parser/TCS.g:1604:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            {
            // parser/TCS.g:1604:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            int alt144=4;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt144=1;
                }
                break;
            case POINT:
                {
                alt144=2;
                }
                break;
            case 86:
                {
                alt144=3;
                }
                break;
            case 112:
                {
                alt144=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 144, 0, input);

                throw nvae;
            }

            switch (alt144) {
                case 1 :
                    // parser/TCS.g:1604:4: ret= tcs_simplemapping
                    {
                    pushFollow(FOLLOW_tcs_simplemapping_in_tcs_mapping8787);
                    ret=tcs_simplemapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1605:5: ret= tcs_wildcardmapping
                    {
                    pushFollow(FOLLOW_tcs_wildcardmapping_in_tcs_mapping8795);
                    ret=tcs_wildcardmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1606:5: ret= tcs_octalmapping
                    {
                    pushFollow(FOLLOW_tcs_octalmapping_in_tcs_mapping8803);
                    ret=tcs_octalmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1607:5: ret= tcs_hexadecimalmapping
                    {
                    pushFollow(FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping8811);
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
    // parser/TCS.g:1614:1: tcs_simplemapping returns [Object ret2] : ( (temp= identifier ) RARROW (temp= identifier ) ) ;
    public final Object tcs_simplemapping() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SimpleMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1619:3: ( ( (temp= identifier ) RARROW (temp= identifier ) ) )
            // parser/TCS.g:1620:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            {
            // parser/TCS.g:1620:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            // parser/TCS.g:1620:4: (temp= identifier ) RARROW (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352BC1630F2911DF9923EEEE93CCC8E1");
            }
            // parser/TCS.g:1620:63: (temp= identifier )
            // parser/TCS.g:1620:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping8845);
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
              _beforeSeqEl("E0DCF6CD352BC1640F2911DF8979EEEE93CCC8E1");
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_simplemapping8852); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352BC1660F2911DFA6DAEEEE93CCC8E1");
            }
            // parser/TCS.g:1620:272: (temp= identifier )
            // parser/TCS.g:1620:274: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping8860);
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
    // parser/TCS.g:1628:1: tcs_wildcardmapping returns [Object ret2] : ( POINT RARROW POINT ) ;
    public final Object tcs_wildcardmapping() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","WildcardMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1633:3: ( ( POINT RARROW POINT ) )
            // parser/TCS.g:1634:3: ( POINT RARROW POINT )
            {
            // parser/TCS.g:1634:3: ( POINT RARROW POINT )
            // parser/TCS.g:1634:4: POINT RARROW POINT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352E0B500F2911DFB435EEEE93CCC8E1");
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping8904); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352E0B510F2911DF8C0EEEEE93CCC8E1");
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_wildcardmapping8909); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352E0B520F2911DF8790EEEE93CCC8E1");
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping8914); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1642:1: tcs_octalmapping returns [Object ret2] : ( 'octal' ) ;
    public final Object tcs_octalmapping() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","OctalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1647:3: ( ( 'octal' ) )
            // parser/TCS.g:1648:3: ( 'octal' )
            {
            // parser/TCS.g:1648:3: ( 'octal' )
            // parser/TCS.g:1648:4: 'octal'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD352E0B560F2911DFB7D6EEEE93CCC8E1");
            }
            match(input,86,FOLLOW_86_in_tcs_octalmapping8955); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1656:1: tcs_hexadecimalmapping returns [Object ret2] : ( 'hex' ) ;
    public final Object tcs_hexadecimalmapping() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","HexadecimalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1661:3: ( ( 'hex' ) )
            // parser/TCS.g:1662:3: ( 'hex' )
            {
            // parser/TCS.g:1662:3: ( 'hex' )
            // parser/TCS.g:1662:4: 'hex'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD35307C500F2911DFC4F1EEEE93CCC8E1");
            }
            match(input,112,FOLLOW_112_in_tcs_hexadecimalmapping8995); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1670:1: tcs_stringpattern returns [Object ret2] : ( (temp= stringSymbol )? ) ;
    public final Object tcs_stringpattern() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1675:3: ( ( (temp= stringSymbol )? ) )
            // parser/TCS.g:1676:3: ( (temp= stringSymbol )? )
            {
            // parser/TCS.g:1676:3: ( (temp= stringSymbol )? )
            // parser/TCS.g:1676:4: (temp= stringSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD35307C560F2911DFC4E0EEEE93CCC8E1");
            }
            // parser/TCS.g:1676:63: (temp= stringSymbol )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==STRING) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // parser/TCS.g:1676:65: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_stringpattern9039);
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
    // parser/TCS.g:1684:1: tcs_classpattern returns [Object ret2] : ( LSQUARE (temp= identifier )? RSQUARE ) ;
    public final Object tcs_classpattern() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1689:3: ( ( LSQUARE (temp= identifier )? RSQUARE ) )
            // parser/TCS.g:1690:3: ( LSQUARE (temp= identifier )? RSQUARE )
            {
            // parser/TCS.g:1690:3: ( LSQUARE (temp= identifier )? RSQUARE )
            // parser/TCS.g:1690:4: LSQUARE (temp= identifier )? RSQUARE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3532ED500F2911DF8913EEEE93CCC8E1");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_classpattern9085); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CD3532ED520F2911DF820BEEEE93CCC8E1");
            }
            // parser/TCS.g:1690:147: (temp= identifier )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==NAME) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // parser/TCS.g:1690:149: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_classpattern9093);
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
              _beforeSeqEl("E0DCF6CD3532ED530F2911DF93C5EEEE93CCC8E1");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_classpattern9102); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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

    // $ANTLR start synpred89_TCS
    public final void synpred89_TCS_fragment() throws RecognitionException {   
        // parser/TCS.g:370:36: ( DLCOLON )
        // parser/TCS.g:370:37: DLCOLON
        {
        match(input,DLCOLON,FOLLOW_DLCOLON_in_synpred89_TCS1061); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_TCS

    // $ANTLR start synpred115_TCS
    public final void synpred115_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:499:159: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:499:159: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred115_TCS1970);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred115_TCS

    // $ANTLR start synpred120_TCS
    public final void synpred120_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:515:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:515:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred120_TCS2130);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred120_TCS

    // $ANTLR start synpred138_TCS
    public final void synpred138_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:560:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:560:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred138_TCS2816);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred138_TCS

    // $ANTLR start synpred149_TCS
    public final void synpred149_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:582:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:582:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred149_TCS3241);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred149_TCS

    // $ANTLR start synpred154_TCS
    public final void synpred154_TCS_fragment() throws RecognitionException {   
        Object ret = null;


        // parser/TCS.g:634:4: (ret= tcs_sequence__impl )
        // parser/TCS.g:634:4: ret= tcs_sequence__impl
        {
        pushFollow(FOLLOW_tcs_sequence__impl_in_synpred154_TCS3518);
        ret=tcs_sequence__impl();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred154_TCS

    // $ANTLR start synpred163_TCS
    public final void synpred163_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:677:3648: (temp= identifierOrKeyword )
        // parser/TCS.g:677:3648: temp= identifierOrKeyword
        {
        pushFollow(FOLLOW_identifierOrKeyword_in_synpred163_TCS3722);
        temp=identifierOrKeyword();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred163_TCS

    // $ANTLR start synpred170_TCS
    public final void synpred170_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:736:148: (temp= tcs_expression )
        // parser/TCS.g:736:148: temp= tcs_expression
        {
        pushFollow(FOLLOW_tcs_expression_in_synpred170_TCS4074);
        temp=tcs_expression();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred170_TCS

    // $ANTLR start synpred173_TCS
    public final void synpred173_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:751:150: (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )
        // parser/TCS.g:751:150: temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )*
        {
        pushFollow(FOLLOW_tcs_sequenceinalternative_in_synpred173_TCS4185);
        temp=tcs_sequenceinalternative();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // parser/TCS.g:751:220: ( ( PIPE ) temp= tcs_sequenceinalternative )*
        loop173:
        do {
            int alt173=2;
            int LA173_0 = input.LA(1);

            if ( (LA173_0==PIPE) ) {
                alt173=1;
            }


            switch (alt173) {
        	case 1 :
        	    // parser/TCS.g:751:221: ( PIPE ) temp= tcs_sequenceinalternative
        	    {
        	    // parser/TCS.g:751:238: ( PIPE )
        	    // parser/TCS.g:751:239: PIPE
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("E0DCF6CD346F9D590F2911DF9371EEEE93CCC8E1");
        	    }
        	    match(input,PIPE,FOLLOW_PIPE_in_synpred173_TCS4194); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_tcs_sequenceinalternative_in_synpred173_TCS4202);
        	    temp=tcs_sequenceinalternative();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop173;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred173_TCS

    // $ANTLR start synpred185_TCS
    public final void synpred185_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:860:375: ( ( COMA 'mode' EQ (temp= stringSymbol ) ) )
        // parser/TCS.g:860:375: ( COMA 'mode' EQ (temp= stringSymbol ) )
        {
        if ( state.backtracking==0 ) {
          _enterAlt(0);
        }
        // parser/TCS.g:860:391: ( COMA 'mode' EQ (temp= stringSymbol ) )
        // parser/TCS.g:860:392: COMA 'mode' EQ (temp= stringSymbol )
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl("E0DCF6CD348066330F2911DF89DDEEEE93CCC8E1");
        }
        match(input,COMA,FOLLOW_COMA_in_synpred185_TCS4854); if (state.failed) return ;
        match(input,87,FOLLOW_87_in_synpred185_TCS4858); if (state.failed) return ;
        match(input,EQ,FOLLOW_EQ_in_synpred185_TCS4862); if (state.failed) return ;
        // parser/TCS.g:860:692: (temp= stringSymbol )
        // parser/TCS.g:860:694: temp= stringSymbol
        {
        pushFollow(FOLLOW_stringSymbol_in_synpred185_TCS4870);
        temp=stringSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred185_TCS

    // $ANTLR start synpred251_TCS
    public final void synpred251_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:1510:65: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )
        // parser/TCS.g:1510:65: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
        {
        pushFollow(FOLLOW_tcs_simplepattern_in_synpred251_TCS8120);
        temp=tcs_simplepattern();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // parser/TCS.g:1510:132: ( ( PIPE ) temp= tcs_simplepattern )*
        loop186:
        do {
            int alt186=2;
            int LA186_0 = input.LA(1);

            if ( (LA186_0==PIPE) ) {
                alt186=1;
            }


            switch (alt186) {
        	case 1 :
        	    // parser/TCS.g:1510:133: ( PIPE ) temp= tcs_simplepattern
        	    {
        	    // parser/TCS.g:1510:150: ( PIPE )
        	    // parser/TCS.g:1510:151: PIPE
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("E0DCF6CD351FDA910F2911DF8AC5EEEE93CCC8E1");
        	    }
        	    match(input,PIPE,FOLLOW_PIPE_in_synpred251_TCS8129); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_tcs_simplepattern_in_synpred251_TCS8137);
        	    temp=tcs_simplepattern();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop186;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred251_TCS

    // Delegated rules

    public final boolean synpred115_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred173_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred173_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred154_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred154_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred251_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred251_TCS_fragment(); // can never throw exception
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
    public final boolean synpred89_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred120_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred120_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred149_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred149_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred163_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred163_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred138_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred138_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred185_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred185_TCS_fragment(); // can never throw exception
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
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA62 dfa62 = new DFA62(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA127 dfa127 = new DFA127(this);
    static final String DFA28_eotS =
        "\20\uffff";
    static final String DFA28_eofS =
        "\1\15\17\uffff";
    static final String DFA28_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA28_maxS =
        "\1\u0084\15\0\2\uffff";
    static final String DFA28_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA28_specialS =
        "\1\uffff\1\4\1\10\1\1\1\13\1\2\1\12\1\6\1\7\1\11\1\5\1\0\1\14\1"+
        "\3\2\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\14\46\uffff\1\11\1\uffff\1\1\2\uffff\1\13\17\uffff\1\2\5"+
            "\uffff\1\5\1\uffff\1\6\2\uffff\1\4\7\uffff\1\7\12\uffff\1\3"+
            "\17\uffff\1\12\14\uffff\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "499:157: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA28_11 = input.LA(1);

                         
                        int index28_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_11);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA28_3 = input.LA(1);

                         
                        int index28_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_3);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA28_5 = input.LA(1);

                         
                        int index28_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_5);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA28_13 = input.LA(1);

                         
                        int index28_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_13);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA28_10 = input.LA(1);

                         
                        int index28_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_10);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA28_7 = input.LA(1);

                         
                        int index28_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_7);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA28_8 = input.LA(1);

                         
                        int index28_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_8);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA28_2 = input.LA(1);

                         
                        int index28_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_2);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA28_9 = input.LA(1);

                         
                        int index28_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_9);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA28_6 = input.LA(1);

                         
                        int index28_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_6);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA28_4 = input.LA(1);

                         
                        int index28_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_4);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA28_12 = input.LA(1);

                         
                        int index28_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA33_eotS =
        "\20\uffff";
    static final String DFA33_eofS =
        "\1\15\17\uffff";
    static final String DFA33_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA33_maxS =
        "\1\u0084\15\0\2\uffff";
    static final String DFA33_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA33_specialS =
        "\1\uffff\1\4\1\10\1\1\1\13\1\2\1\12\1\6\1\7\1\11\1\5\1\0\1\14\1"+
        "\3\2\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\14\46\uffff\1\11\1\uffff\1\1\2\uffff\1\13\17\uffff\1\2\5"+
            "\uffff\1\5\1\uffff\1\6\2\uffff\1\4\7\uffff\1\7\12\uffff\1\3"+
            "\17\uffff\1\12\14\uffff\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "515:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA33_11 = input.LA(1);

                         
                        int index33_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_11);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA33_3 = input.LA(1);

                         
                        int index33_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_3);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA33_5 = input.LA(1);

                         
                        int index33_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_5);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA33_13 = input.LA(1);

                         
                        int index33_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_13);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA33_10 = input.LA(1);

                         
                        int index33_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_10);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA33_7 = input.LA(1);

                         
                        int index33_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_7);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA33_8 = input.LA(1);

                         
                        int index33_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_8);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA33_2 = input.LA(1);

                         
                        int index33_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_2);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA33_9 = input.LA(1);

                         
                        int index33_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_9);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA33_6 = input.LA(1);

                         
                        int index33_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_6);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA33_4 = input.LA(1);

                         
                        int index33_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_4);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA33_12 = input.LA(1);

                         
                        int index33_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA51_eotS =
        "\20\uffff";
    static final String DFA51_eofS =
        "\1\15\17\uffff";
    static final String DFA51_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA51_maxS =
        "\1\u0084\15\0\2\uffff";
    static final String DFA51_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA51_specialS =
        "\1\uffff\1\3\1\10\1\1\1\13\1\2\1\12\1\5\1\7\1\11\1\4\1\0\1\14\1"+
        "\6\2\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\14\46\uffff\1\11\1\uffff\1\1\2\uffff\1\13\17\uffff\1\2\5"+
            "\uffff\1\5\1\uffff\1\6\2\uffff\1\4\7\uffff\1\7\12\uffff\1\3"+
            "\17\uffff\1\12\14\uffff\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "560:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA51_11 = input.LA(1);

                         
                        int index51_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_11);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA51_3 = input.LA(1);

                         
                        int index51_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_3);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA51_5 = input.LA(1);

                         
                        int index51_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_5);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA51_1 = input.LA(1);

                         
                        int index51_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_1);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA51_10 = input.LA(1);

                         
                        int index51_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_10);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA51_7 = input.LA(1);

                         
                        int index51_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_7);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA51_13 = input.LA(1);

                         
                        int index51_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_13);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA51_8 = input.LA(1);

                         
                        int index51_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_8);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA51_2 = input.LA(1);

                         
                        int index51_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_2);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA51_9 = input.LA(1);

                         
                        int index51_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_9);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA51_6 = input.LA(1);

                         
                        int index51_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_6);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA51_4 = input.LA(1);

                         
                        int index51_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_4);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA51_12 = input.LA(1);

                         
                        int index51_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 51, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA62_eotS =
        "\20\uffff";
    static final String DFA62_eofS =
        "\1\15\17\uffff";
    static final String DFA62_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA62_maxS =
        "\1\u0084\15\0\2\uffff";
    static final String DFA62_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA62_specialS =
        "\1\uffff\1\3\1\7\1\1\1\13\1\2\1\11\1\5\1\6\1\10\1\4\1\0\1\14\1"+
        "\12\2\uffff}>";
    static final String[] DFA62_transitionS = {
            "\1\14\46\uffff\1\11\1\uffff\1\1\2\uffff\1\13\17\uffff\1\2\5"+
            "\uffff\1\5\1\uffff\1\6\2\uffff\1\4\7\uffff\1\7\12\uffff\1\3"+
            "\17\uffff\1\12\14\uffff\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA62_eot = DFA.unpackEncodedString(DFA62_eotS);
    static final short[] DFA62_eof = DFA.unpackEncodedString(DFA62_eofS);
    static final char[] DFA62_min = DFA.unpackEncodedStringToUnsignedChars(DFA62_minS);
    static final char[] DFA62_max = DFA.unpackEncodedStringToUnsignedChars(DFA62_maxS);
    static final short[] DFA62_accept = DFA.unpackEncodedString(DFA62_acceptS);
    static final short[] DFA62_special = DFA.unpackEncodedString(DFA62_specialS);
    static final short[][] DFA62_transition;

    static {
        int numStates = DFA62_transitionS.length;
        DFA62_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA62_transition[i] = DFA.unpackEncodedString(DFA62_transitionS[i]);
        }
    }

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = DFA62_eot;
            this.eof = DFA62_eof;
            this.min = DFA62_min;
            this.max = DFA62_max;
            this.accept = DFA62_accept;
            this.special = DFA62_special;
            this.transition = DFA62_transition;
        }
        public String getDescription() {
            return "582:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA62_11 = input.LA(1);

                         
                        int index62_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_11);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA62_3 = input.LA(1);

                         
                        int index62_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_3);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA62_5 = input.LA(1);

                         
                        int index62_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_5);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA62_1 = input.LA(1);

                         
                        int index62_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_1);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA62_10 = input.LA(1);

                         
                        int index62_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_10);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA62_7 = input.LA(1);

                         
                        int index62_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_7);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA62_8 = input.LA(1);

                         
                        int index62_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_8);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA62_2 = input.LA(1);

                         
                        int index62_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_2);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA62_9 = input.LA(1);

                         
                        int index62_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_9);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA62_6 = input.LA(1);

                         
                        int index62_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_6);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA62_13 = input.LA(1);

                         
                        int index62_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_13);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA62_4 = input.LA(1);

                         
                        int index62_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_4);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA62_12 = input.LA(1);

                         
                        int index62_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred149_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index62_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 62, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA67_eotS =
        "\151\uffff";
    static final String DFA67_eofS =
        "\1\146\150\uffff";
    static final String DFA67_minS =
        "\1\4\146\0\2\uffff";
    static final String DFA67_maxS =
        "\1\u0086\146\0\2\uffff";
    static final String DFA67_acceptS =
        "\147\uffff\1\1\1\2";
    static final String DFA67_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
        "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62"+
        "\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77"+
        "\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112"+
        "\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125"+
        "\1\126\1\127\1\130\1\131\1\132\1\133\1\134\1\135\1\136\1\137\1\140"+
        "\1\141\1\142\1\143\1\144\1\145\2\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\2\1\1\3\uffff\1\134\1\143\2\uffff\1\145\1\141\1\131\1\140"+
            "\1\144\1\uffff\1\132\1\uffff\1\133\1\142\1\uffff\1\135\3\uffff"+
            "\1\136\1\137\23\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
            "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
            "\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
            "\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57"+
            "\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73"+
            "\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106"+
            "\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120"+
            "\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "634:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA67_1 = input.LA(1);

                         
                        int index67_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_1);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA67_2 = input.LA(1);

                         
                        int index67_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_2);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA67_3 = input.LA(1);

                         
                        int index67_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_3);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA67_4 = input.LA(1);

                         
                        int index67_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_4);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA67_5 = input.LA(1);

                         
                        int index67_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_5);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA67_6 = input.LA(1);

                         
                        int index67_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_6);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA67_7 = input.LA(1);

                         
                        int index67_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_7);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA67_8 = input.LA(1);

                         
                        int index67_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_8);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA67_9 = input.LA(1);

                         
                        int index67_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_9);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA67_10 = input.LA(1);

                         
                        int index67_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_10);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA67_11 = input.LA(1);

                         
                        int index67_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_11);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA67_12 = input.LA(1);

                         
                        int index67_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_12);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA67_13 = input.LA(1);

                         
                        int index67_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_13);
                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA67_14 = input.LA(1);

                         
                        int index67_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_14);
                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA67_15 = input.LA(1);

                         
                        int index67_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_15);
                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA67_16 = input.LA(1);

                         
                        int index67_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_16);
                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA67_17 = input.LA(1);

                         
                        int index67_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_17);
                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA67_18 = input.LA(1);

                         
                        int index67_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_18);
                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA67_19 = input.LA(1);

                         
                        int index67_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_19);
                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA67_20 = input.LA(1);

                         
                        int index67_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_20);
                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA67_21 = input.LA(1);

                         
                        int index67_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_21);
                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA67_22 = input.LA(1);

                         
                        int index67_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_22);
                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA67_23 = input.LA(1);

                         
                        int index67_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_23);
                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA67_24 = input.LA(1);

                         
                        int index67_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_24);
                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA67_25 = input.LA(1);

                         
                        int index67_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_25);
                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA67_26 = input.LA(1);

                         
                        int index67_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_26);
                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA67_27 = input.LA(1);

                         
                        int index67_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_27);
                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA67_28 = input.LA(1);

                         
                        int index67_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_28);
                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA67_29 = input.LA(1);

                         
                        int index67_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_29);
                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA67_30 = input.LA(1);

                         
                        int index67_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_30);
                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA67_31 = input.LA(1);

                         
                        int index67_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_31);
                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA67_32 = input.LA(1);

                         
                        int index67_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_32);
                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA67_33 = input.LA(1);

                         
                        int index67_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_33);
                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA67_34 = input.LA(1);

                         
                        int index67_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_34);
                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA67_35 = input.LA(1);

                         
                        int index67_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_35);
                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA67_36 = input.LA(1);

                         
                        int index67_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_36);
                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA67_37 = input.LA(1);

                         
                        int index67_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_37);
                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA67_38 = input.LA(1);

                         
                        int index67_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_38);
                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA67_39 = input.LA(1);

                         
                        int index67_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_39);
                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA67_40 = input.LA(1);

                         
                        int index67_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_40);
                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA67_41 = input.LA(1);

                         
                        int index67_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_41);
                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA67_42 = input.LA(1);

                         
                        int index67_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_42);
                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA67_43 = input.LA(1);

                         
                        int index67_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_43);
                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA67_44 = input.LA(1);

                         
                        int index67_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_44);
                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA67_45 = input.LA(1);

                         
                        int index67_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_45);
                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA67_46 = input.LA(1);

                         
                        int index67_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_46);
                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA67_47 = input.LA(1);

                         
                        int index67_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_47);
                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA67_48 = input.LA(1);

                         
                        int index67_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_48);
                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA67_49 = input.LA(1);

                         
                        int index67_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_49);
                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA67_50 = input.LA(1);

                         
                        int index67_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_50);
                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA67_51 = input.LA(1);

                         
                        int index67_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_51);
                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA67_52 = input.LA(1);

                         
                        int index67_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_52);
                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA67_53 = input.LA(1);

                         
                        int index67_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_53);
                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA67_54 = input.LA(1);

                         
                        int index67_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_54);
                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA67_55 = input.LA(1);

                         
                        int index67_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_55);
                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA67_56 = input.LA(1);

                         
                        int index67_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_56);
                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA67_57 = input.LA(1);

                         
                        int index67_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_57);
                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA67_58 = input.LA(1);

                         
                        int index67_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_58);
                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA67_59 = input.LA(1);

                         
                        int index67_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_59);
                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA67_60 = input.LA(1);

                         
                        int index67_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_60);
                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA67_61 = input.LA(1);

                         
                        int index67_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_61);
                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA67_62 = input.LA(1);

                         
                        int index67_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_62);
                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA67_63 = input.LA(1);

                         
                        int index67_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_63);
                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA67_64 = input.LA(1);

                         
                        int index67_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_64);
                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA67_65 = input.LA(1);

                         
                        int index67_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_65);
                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA67_66 = input.LA(1);

                         
                        int index67_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_66);
                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA67_67 = input.LA(1);

                         
                        int index67_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_67);
                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA67_68 = input.LA(1);

                         
                        int index67_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_68);
                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA67_69 = input.LA(1);

                         
                        int index67_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_69);
                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA67_70 = input.LA(1);

                         
                        int index67_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_70);
                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA67_71 = input.LA(1);

                         
                        int index67_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_71);
                        if ( s>=0 ) return s;
                        break;

                    case 71 : 
                        int LA67_72 = input.LA(1);

                         
                        int index67_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_72);
                        if ( s>=0 ) return s;
                        break;

                    case 72 : 
                        int LA67_73 = input.LA(1);

                         
                        int index67_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_73);
                        if ( s>=0 ) return s;
                        break;

                    case 73 : 
                        int LA67_74 = input.LA(1);

                         
                        int index67_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_74);
                        if ( s>=0 ) return s;
                        break;

                    case 74 : 
                        int LA67_75 = input.LA(1);

                         
                        int index67_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_75);
                        if ( s>=0 ) return s;
                        break;

                    case 75 : 
                        int LA67_76 = input.LA(1);

                         
                        int index67_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_76);
                        if ( s>=0 ) return s;
                        break;

                    case 76 : 
                        int LA67_77 = input.LA(1);

                         
                        int index67_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_77);
                        if ( s>=0 ) return s;
                        break;

                    case 77 : 
                        int LA67_78 = input.LA(1);

                         
                        int index67_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_78);
                        if ( s>=0 ) return s;
                        break;

                    case 78 : 
                        int LA67_79 = input.LA(1);

                         
                        int index67_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_79);
                        if ( s>=0 ) return s;
                        break;

                    case 79 : 
                        int LA67_80 = input.LA(1);

                         
                        int index67_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_80);
                        if ( s>=0 ) return s;
                        break;

                    case 80 : 
                        int LA67_81 = input.LA(1);

                         
                        int index67_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_81);
                        if ( s>=0 ) return s;
                        break;

                    case 81 : 
                        int LA67_82 = input.LA(1);

                         
                        int index67_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_82);
                        if ( s>=0 ) return s;
                        break;

                    case 82 : 
                        int LA67_83 = input.LA(1);

                         
                        int index67_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_83);
                        if ( s>=0 ) return s;
                        break;

                    case 83 : 
                        int LA67_84 = input.LA(1);

                         
                        int index67_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_84);
                        if ( s>=0 ) return s;
                        break;

                    case 84 : 
                        int LA67_85 = input.LA(1);

                         
                        int index67_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_85);
                        if ( s>=0 ) return s;
                        break;

                    case 85 : 
                        int LA67_86 = input.LA(1);

                         
                        int index67_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_86);
                        if ( s>=0 ) return s;
                        break;

                    case 86 : 
                        int LA67_87 = input.LA(1);

                         
                        int index67_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_87);
                        if ( s>=0 ) return s;
                        break;

                    case 87 : 
                        int LA67_88 = input.LA(1);

                         
                        int index67_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_88);
                        if ( s>=0 ) return s;
                        break;

                    case 88 : 
                        int LA67_89 = input.LA(1);

                         
                        int index67_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_89);
                        if ( s>=0 ) return s;
                        break;

                    case 89 : 
                        int LA67_90 = input.LA(1);

                         
                        int index67_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_90);
                        if ( s>=0 ) return s;
                        break;

                    case 90 : 
                        int LA67_91 = input.LA(1);

                         
                        int index67_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_91);
                        if ( s>=0 ) return s;
                        break;

                    case 91 : 
                        int LA67_92 = input.LA(1);

                         
                        int index67_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_92);
                        if ( s>=0 ) return s;
                        break;

                    case 92 : 
                        int LA67_93 = input.LA(1);

                         
                        int index67_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_93);
                        if ( s>=0 ) return s;
                        break;

                    case 93 : 
                        int LA67_94 = input.LA(1);

                         
                        int index67_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_94);
                        if ( s>=0 ) return s;
                        break;

                    case 94 : 
                        int LA67_95 = input.LA(1);

                         
                        int index67_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_95);
                        if ( s>=0 ) return s;
                        break;

                    case 95 : 
                        int LA67_96 = input.LA(1);

                         
                        int index67_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_96);
                        if ( s>=0 ) return s;
                        break;

                    case 96 : 
                        int LA67_97 = input.LA(1);

                         
                        int index67_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_97);
                        if ( s>=0 ) return s;
                        break;

                    case 97 : 
                        int LA67_98 = input.LA(1);

                         
                        int index67_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_98);
                        if ( s>=0 ) return s;
                        break;

                    case 98 : 
                        int LA67_99 = input.LA(1);

                         
                        int index67_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_99);
                        if ( s>=0 ) return s;
                        break;

                    case 99 : 
                        int LA67_100 = input.LA(1);

                         
                        int index67_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_100);
                        if ( s>=0 ) return s;
                        break;

                    case 100 : 
                        int LA67_101 = input.LA(1);

                         
                        int index67_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_101);
                        if ( s>=0 ) return s;
                        break;

                    case 101 : 
                        int LA67_102 = input.LA(1);

                         
                        int index67_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred154_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index67_102);
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
    static final String DFA69_eotS =
        "\132\uffff";
    static final String DFA69_eofS =
        "\1\130\131\uffff";
    static final String DFA69_minS =
        "\1\4\127\0\2\uffff";
    static final String DFA69_maxS =
        "\1\u0086\127\0\2\uffff";
    static final String DFA69_acceptS =
        "\130\uffff\1\2\1\1";
    static final String DFA69_specialS =
        "\1\uffff\1\101\1\2\1\50\1\110\1\31\1\17\1\61\1\16\1\55\1\20\1\66"+
        "\1\21\1\106\1\26\1\76\1\24\1\56\1\22\1\75\1\23\1\35\1\13\1\74\1"+
        "\11\1\72\1\14\1\77\1\15\1\100\1\7\1\67\1\6\1\65\1\3\1\62\1\5\1\64"+
        "\1\122\1\36\1\105\1\37\1\123\1\34\1\104\1\33\1\70\1\40\1\107\1\42"+
        "\1\124\1\45\1\111\1\44\1\4\1\63\1\121\1\43\1\126\1\54\1\120\1\41"+
        "\1\103\1\25\1\112\1\32\1\125\1\53\1\115\1\71\1\10\1\102\1\12\1\47"+
        "\1\114\1\27\1\113\1\46\1\57\1\0\1\60\1\51\1\117\1\30\1\116\1\52"+
        "\1\1\1\73\2\uffff}>";
    static final String[] DFA69_transitionS = {
            "\1\1\1\130\3\uffff\11\130\1\uffff\1\130\1\uffff\6\130\1\uffff"+
            "\2\130\1\uffff\1\130\21\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1"+
            "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1"+
            "\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1"+
            "\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1"+
            "\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1"+
            "\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1"+
            "\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA69_eot = DFA.unpackEncodedString(DFA69_eotS);
    static final short[] DFA69_eof = DFA.unpackEncodedString(DFA69_eofS);
    static final char[] DFA69_min = DFA.unpackEncodedStringToUnsignedChars(DFA69_minS);
    static final char[] DFA69_max = DFA.unpackEncodedStringToUnsignedChars(DFA69_maxS);
    static final short[] DFA69_accept = DFA.unpackEncodedString(DFA69_acceptS);
    static final short[] DFA69_special = DFA.unpackEncodedString(DFA69_specialS);
    static final short[][] DFA69_transition;

    static {
        int numStates = DFA69_transitionS.length;
        DFA69_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA69_transition[i] = DFA.unpackEncodedString(DFA69_transitionS[i]);
        }
    }

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = DFA69_eot;
            this.eof = DFA69_eof;
            this.min = DFA69_min;
            this.max = DFA69_max;
            this.accept = DFA69_accept;
            this.special = DFA69_special;
            this.transition = DFA69_transition;
        }
        public String getDescription() {
            return "677:3646: (temp= identifierOrKeyword )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA69_79 = input.LA(1);

                         
                        int index69_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_79);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA69_86 = input.LA(1);

                         
                        int index69_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_86);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA69_2 = input.LA(1);

                         
                        int index69_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_2);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA69_34 = input.LA(1);

                         
                        int index69_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_34);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA69_54 = input.LA(1);

                         
                        int index69_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_54);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA69_36 = input.LA(1);

                         
                        int index69_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_36);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA69_32 = input.LA(1);

                         
                        int index69_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_32);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA69_30 = input.LA(1);

                         
                        int index69_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_30);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA69_70 = input.LA(1);

                         
                        int index69_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_70);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA69_24 = input.LA(1);

                         
                        int index69_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_24);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA69_72 = input.LA(1);

                         
                        int index69_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_72);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA69_22 = input.LA(1);

                         
                        int index69_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_22);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA69_26 = input.LA(1);

                         
                        int index69_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_26);
                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA69_28 = input.LA(1);

                         
                        int index69_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_28);
                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA69_8 = input.LA(1);

                         
                        int index69_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_8);
                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA69_6 = input.LA(1);

                         
                        int index69_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_6);
                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA69_10 = input.LA(1);

                         
                        int index69_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_10);
                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA69_12 = input.LA(1);

                         
                        int index69_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_12);
                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA69_18 = input.LA(1);

                         
                        int index69_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_18);
                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA69_20 = input.LA(1);

                         
                        int index69_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_20);
                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA69_16 = input.LA(1);

                         
                        int index69_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_16);
                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA69_63 = input.LA(1);

                         
                        int index69_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_63);
                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA69_14 = input.LA(1);

                         
                        int index69_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_14);
                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA69_75 = input.LA(1);

                         
                        int index69_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_75);
                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA69_83 = input.LA(1);

                         
                        int index69_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_83);
                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA69_5 = input.LA(1);

                         
                        int index69_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_5);
                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA69_65 = input.LA(1);

                         
                        int index69_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_65);
                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA69_45 = input.LA(1);

                         
                        int index69_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_45);
                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA69_43 = input.LA(1);

                         
                        int index69_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_43);
                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA69_21 = input.LA(1);

                         
                        int index69_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_21);
                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA69_39 = input.LA(1);

                         
                        int index69_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_39);
                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA69_41 = input.LA(1);

                         
                        int index69_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_41);
                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA69_47 = input.LA(1);

                         
                        int index69_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_47);
                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA69_61 = input.LA(1);

                         
                        int index69_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_61);
                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA69_49 = input.LA(1);

                         
                        int index69_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_49);
                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA69_57 = input.LA(1);

                         
                        int index69_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_57);
                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA69_53 = input.LA(1);

                         
                        int index69_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_53);
                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA69_51 = input.LA(1);

                         
                        int index69_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_51);
                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA69_77 = input.LA(1);

                         
                        int index69_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_77);
                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA69_73 = input.LA(1);

                         
                        int index69_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_73);
                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA69_3 = input.LA(1);

                         
                        int index69_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_3);
                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA69_81 = input.LA(1);

                         
                        int index69_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_81);
                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA69_85 = input.LA(1);

                         
                        int index69_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_85);
                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA69_67 = input.LA(1);

                         
                        int index69_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_67);
                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA69_59 = input.LA(1);

                         
                        int index69_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_59);
                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA69_9 = input.LA(1);

                         
                        int index69_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_9);
                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA69_17 = input.LA(1);

                         
                        int index69_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_17);
                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA69_78 = input.LA(1);

                         
                        int index69_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_78);
                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA69_80 = input.LA(1);

                         
                        int index69_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_80);
                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA69_7 = input.LA(1);

                         
                        int index69_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_7);
                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA69_35 = input.LA(1);

                         
                        int index69_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_35);
                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA69_55 = input.LA(1);

                         
                        int index69_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_55);
                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA69_37 = input.LA(1);

                         
                        int index69_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_37);
                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA69_33 = input.LA(1);

                         
                        int index69_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_33);
                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA69_11 = input.LA(1);

                         
                        int index69_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_11);
                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA69_31 = input.LA(1);

                         
                        int index69_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_31);
                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA69_46 = input.LA(1);

                         
                        int index69_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_46);
                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA69_69 = input.LA(1);

                         
                        int index69_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_69);
                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA69_25 = input.LA(1);

                         
                        int index69_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_25);
                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA69_87 = input.LA(1);

                         
                        int index69_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_87);
                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA69_23 = input.LA(1);

                         
                        int index69_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_23);
                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA69_19 = input.LA(1);

                         
                        int index69_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_19);
                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA69_15 = input.LA(1);

                         
                        int index69_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_15);
                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA69_27 = input.LA(1);

                         
                        int index69_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_27);
                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA69_29 = input.LA(1);

                         
                        int index69_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_29);
                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA69_1 = input.LA(1);

                         
                        int index69_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_1);
                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA69_71 = input.LA(1);

                         
                        int index69_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_71);
                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA69_62 = input.LA(1);

                         
                        int index69_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_62);
                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA69_44 = input.LA(1);

                         
                        int index69_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_44);
                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA69_40 = input.LA(1);

                         
                        int index69_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_40);
                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA69_13 = input.LA(1);

                         
                        int index69_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_13);
                        if ( s>=0 ) return s;
                        break;

                    case 71 : 
                        int LA69_48 = input.LA(1);

                         
                        int index69_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_48);
                        if ( s>=0 ) return s;
                        break;

                    case 72 : 
                        int LA69_4 = input.LA(1);

                         
                        int index69_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_4);
                        if ( s>=0 ) return s;
                        break;

                    case 73 : 
                        int LA69_52 = input.LA(1);

                         
                        int index69_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_52);
                        if ( s>=0 ) return s;
                        break;

                    case 74 : 
                        int LA69_64 = input.LA(1);

                         
                        int index69_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_64);
                        if ( s>=0 ) return s;
                        break;

                    case 75 : 
                        int LA69_76 = input.LA(1);

                         
                        int index69_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_76);
                        if ( s>=0 ) return s;
                        break;

                    case 76 : 
                        int LA69_74 = input.LA(1);

                         
                        int index69_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_74);
                        if ( s>=0 ) return s;
                        break;

                    case 77 : 
                        int LA69_68 = input.LA(1);

                         
                        int index69_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_68);
                        if ( s>=0 ) return s;
                        break;

                    case 78 : 
                        int LA69_84 = input.LA(1);

                         
                        int index69_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_84);
                        if ( s>=0 ) return s;
                        break;

                    case 79 : 
                        int LA69_82 = input.LA(1);

                         
                        int index69_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_82);
                        if ( s>=0 ) return s;
                        break;

                    case 80 : 
                        int LA69_60 = input.LA(1);

                         
                        int index69_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_60);
                        if ( s>=0 ) return s;
                        break;

                    case 81 : 
                        int LA69_56 = input.LA(1);

                         
                        int index69_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_56);
                        if ( s>=0 ) return s;
                        break;

                    case 82 : 
                        int LA69_38 = input.LA(1);

                         
                        int index69_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_38);
                        if ( s>=0 ) return s;
                        break;

                    case 83 : 
                        int LA69_42 = input.LA(1);

                         
                        int index69_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_42);
                        if ( s>=0 ) return s;
                        break;

                    case 84 : 
                        int LA69_50 = input.LA(1);

                         
                        int index69_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_50);
                        if ( s>=0 ) return s;
                        break;

                    case 85 : 
                        int LA69_66 = input.LA(1);

                         
                        int index69_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_66);
                        if ( s>=0 ) return s;
                        break;

                    case 86 : 
                        int LA69_58 = input.LA(1);

                         
                        int index69_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred163_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index69_58);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 69, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA87_eotS =
        "\u00b5\uffff";
    static final String DFA87_eofS =
        "\u00b5\uffff";
    static final String DFA87_minS =
        "\1\4\127\13\3\4\127\13\3\uffff";
    static final String DFA87_maxS =
        "\1\u0086\127\37\1\u0086\2\103\127\37\3\uffff";
    static final String DFA87_acceptS =
        "\u00b2\uffff\1\3\1\1\1\2";
    static final String DFA87_specialS =
        "\u00b5\uffff}>";
    static final String[] DFA87_transitionS = {
            "\1\1\12\uffff\1\130\41\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1"+
            "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1"+
            "\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1"+
            "\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1"+
            "\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1"+
            "\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1"+
            "\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\133\6\uffff\1\132\23\uffff\1\131\21\uffff\1\134\1\135\1"+
            "\136\1\137\1\140\1\141\1\142\1\143\1\144\1\145\1\146\1\147\1"+
            "\150\1\151\1\152\1\153\1\154\1\155\1\156\1\157\1\160\1\161\1"+
            "\162\1\163\1\164\1\165\1\166\1\167\1\170\1\171\1\172\1\173\1"+
            "\174\1\175\1\176\1\177\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084"+
            "\1\u0085\1\u0086\1\u0087\1\u0088\1\u0089\1\u008a\1\u008b\1\u008c"+
            "\1\u008d\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\u0094"+
            "\1\u0095\1\u0096\1\u0097\1\u0098\1\u0099\1\u009a\1\u009b\1\u009c"+
            "\1\u009d\1\u009e\1\u009f\1\u00a0\1\u00a1\1\u00a2\1\u00a3\1\u00a4"+
            "\1\u00a5\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa\1\u00ab\1\u00ac"+
            "\1\u00ad\1\u00ae\1\u00af\1\u00b0\1\u00b1",
            "\1\u00b3\71\uffff\1\u00b2\4\uffff\1\u00b4",
            "\1\u00b3\71\uffff\1\u00b2\4\uffff\1\u00b4",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "\1\132\23\uffff\1\131",
            "",
            "",
            ""
    };

    static final short[] DFA87_eot = DFA.unpackEncodedString(DFA87_eotS);
    static final short[] DFA87_eof = DFA.unpackEncodedString(DFA87_eofS);
    static final char[] DFA87_min = DFA.unpackEncodedStringToUnsignedChars(DFA87_minS);
    static final char[] DFA87_max = DFA.unpackEncodedStringToUnsignedChars(DFA87_maxS);
    static final short[] DFA87_accept = DFA.unpackEncodedString(DFA87_acceptS);
    static final short[] DFA87_special = DFA.unpackEncodedString(DFA87_specialS);
    static final short[][] DFA87_transition;

    static {
        int numStates = DFA87_transitionS.length;
        DFA87_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA87_transition[i] = DFA.unpackEncodedString(DFA87_transitionS[i]);
        }
    }

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = DFA87_eot;
            this.eof = DFA87_eof;
            this.min = DFA87_min;
            this.max = DFA87_max;
            this.accept = DFA87_accept;
            this.special = DFA87_special;
            this.transition = DFA87_transition;
        }
        public String getDescription() {
            return "814:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )";
        }
    }
    static final String DFA127_eotS =
        "\u00b6\uffff";
    static final String DFA127_eofS =
        "\1\uffff\130\133\5\uffff\130\133";
    static final String DFA127_minS =
        "\1\4\22\13\1\11\50\13\1\11\33\13\1\4\5\uffff\2\13\1\4\101\13\1"+
        "\4\22\13\1\4";
    static final String DFA127_maxS =
        "\1\u0086\127\164\1\u0086\5\uffff\104\164\1\u0086\23\164";
    static final String DFA127_acceptS =
        "\131\uffff\1\1\1\5\1\2\1\3\1\4\130\uffff";
    static final String DFA127_specialS =
        "\u00b6\uffff}>";
    static final String[] DFA127_transitionS = {
            "\1\1\12\uffff\1\130\41\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1"+
            "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1"+
            "\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1"+
            "\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1"+
            "\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1"+
            "\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1"+
            "\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\134\1\uffff\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff"+
            "\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\135\1\uffff\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff"+
            "\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\136\6\uffff\1\131\13\uffff\1\133\31\uffff\1\137\1\140\1"+
            "\141\1\142\1\143\1\144\1\145\1\146\1\147\1\150\1\151\1\152\1"+
            "\153\1\154\1\155\1\156\1\157\1\160\1\161\1\162\1\163\1\164\1"+
            "\165\1\166\1\167\1\170\1\171\1\172\1\173\1\174\1\175\1\176\1"+
            "\177\1\u0080\1\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086"+
            "\1\u0087\1\u0088\1\u0089\1\u008a\1\u008b\1\u008c\1\u008d\1\u008e"+
            "\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\u0094\1\u0095\1\u0096"+
            "\1\u0097\1\u0098\1\u0099\1\u009a\1\u009b\1\u009c\1\u009d\1\u009e"+
            "\1\u009f\1\u00a0\1\u00a1\1\u00a2\1\u00a3\1\u00a4\1\u00a5\1\u00a6"+
            "\1\u00a7\1\u00a8\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae"+
            "\1\u00af\1\u00b0\1\u00b1\1\u00b2\1\u00b3\1\u00b4",
            "",
            "",
            "",
            "",
            "",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\132\6\uffff\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff"+
            "\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\133\6\uffff\1\131\3\uffff\1\133\7\uffff\1\133\31\uffff"+
            "\1\133\1\u00b5\124\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\131\13\uffff\1\133\32\uffff\1\132\101\uffff\1\133",
            "\1\132\6\uffff\1\133\13\uffff\1\133\32\uffff\1\133\101\uffff"+
            "\1\133"
    };

    static final short[] DFA127_eot = DFA.unpackEncodedString(DFA127_eotS);
    static final short[] DFA127_eof = DFA.unpackEncodedString(DFA127_eofS);
    static final char[] DFA127_min = DFA.unpackEncodedStringToUnsignedChars(DFA127_minS);
    static final char[] DFA127_max = DFA.unpackEncodedStringToUnsignedChars(DFA127_maxS);
    static final short[] DFA127_accept = DFA.unpackEncodedString(DFA127_acceptS);
    static final short[] DFA127_special = DFA.unpackEncodedString(DFA127_specialS);
    static final short[][] DFA127_transition;

    static {
        int numStates = DFA127_transitionS.length;
        DFA127_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA127_transition[i] = DFA.unpackEncodedString(DFA127_transitionS[i]);
        }
    }

    class DFA127 extends DFA {

        public DFA127(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 127;
            this.eot = DFA127_eot;
            this.eof = DFA127_eof;
            this.min = DFA127_min;
            this.max = DFA127_max;
            this.accept = DFA127_accept;
            this.special = DFA127_special;
            this.transition = DFA127_transition;
        }
        public String getDescription() {
            return "1340:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )";
        }
    }
 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_identifierOrKeyword148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_identifierOrKeyword156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_identifierOrKeyword164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_identifierOrKeyword172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_identifierOrKeyword180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_identifierOrKeyword188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_identifierOrKeyword196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_identifierOrKeyword204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_identifierOrKeyword212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_identifierOrKeyword220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_identifierOrKeyword228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifierOrKeyword236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_identifierOrKeyword244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_identifierOrKeyword252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_identifierOrKeyword260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_identifierOrKeyword268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_identifierOrKeyword276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_identifierOrKeyword284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_identifierOrKeyword292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_identifierOrKeyword300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_identifierOrKeyword308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_identifierOrKeyword316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_identifierOrKeyword324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_identifierOrKeyword332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_identifierOrKeyword340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_identifierOrKeyword348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_identifierOrKeyword356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_identifierOrKeyword364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_identifierOrKeyword372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_identifierOrKeyword380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_identifierOrKeyword388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_identifierOrKeyword396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_identifierOrKeyword404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_identifierOrKeyword412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_identifierOrKeyword420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_identifierOrKeyword428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_identifierOrKeyword436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_identifierOrKeyword444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_identifierOrKeyword452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_identifierOrKeyword460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_identifierOrKeyword468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_identifierOrKeyword476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_identifierOrKeyword484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_identifierOrKeyword492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_identifierOrKeyword500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_identifierOrKeyword508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_identifierOrKeyword516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_identifierOrKeyword524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_identifierOrKeyword532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_identifierOrKeyword540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_identifierOrKeyword548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_identifierOrKeyword556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_identifierOrKeyword564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_identifierOrKeyword572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_identifierOrKeyword580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_identifierOrKeyword588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_identifierOrKeyword596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_identifierOrKeyword604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_identifierOrKeyword612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_identifierOrKeyword620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_identifierOrKeyword628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_identifierOrKeyword636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_identifierOrKeyword644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_identifierOrKeyword652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_identifierOrKeyword660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_identifierOrKeyword668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_identifierOrKeyword676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_identifierOrKeyword684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_identifierOrKeyword692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_identifierOrKeyword700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_identifierOrKeyword708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_identifierOrKeyword716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_identifierOrKeyword724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_identifierOrKeyword732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_identifierOrKeyword740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_identifierOrKeyword748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_identifierOrKeyword756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_identifierOrKeyword764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_identifierOrKeyword772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_identifierOrKeyword780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_134_in_identifierOrKeyword788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_namespace_in_model_classifier921 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_DLCOLON_in_model_classifier928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_model_classifier936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_model_classifier955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_generalizableelement_in_primary_model_namespace1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_model_namespace1010 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_model_namespace_in_primary_model_namespace1016 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_primary_model_namespace1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_model_namespace_in_dblcolon_priority_01058 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_dblcolon_priority_01067 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_model_modelelement_in_dblcolon_priority_01075 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_dblcolon_priority_0_in_model_namespace1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_model_generalizableelement1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_model_modelelement1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_concretesyntax_in_main1258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_tcs_concretesyntax1292 = new BitSet(new long[]{0x0000000000001210L});
    public static final BitSet FOLLOW_identifier_in_tcs_concretesyntax1299 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_concretesyntax1314 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_tcs_concretesyntax1318 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1322 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_concretesyntax1330 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_concretesyntax1337 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1355 = new BitSet(new long[]{0x0250000000002000L,0x0080008010128200L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax1366 = new BitSet(new long[]{0x0250000000002000L,0x0080008010128200L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax1374 = new BitSet(new long[]{0x0250000000002000L,0x0080008010128200L,0x0000000000000010L});
    public static final BitSet FOLLOW_81_in_tcs_concretesyntax1391 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1395 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax1406 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax1414 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1429 = new BitSet(new long[]{0x0210000000002000L,0x0080000010000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_92_in_tcs_concretesyntax1452 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1456 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1467 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1475 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1490 = new BitSet(new long[]{0x0210000000002000L,0x0080000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1511 = new BitSet(new long[]{0x0210000000002000L,0x0080000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1519 = new BitSet(new long[]{0x0210000000002000L,0x0080000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1534 = new BitSet(new long[]{0x0210000000002000L,0x0080000000000000L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1542 = new BitSet(new long[]{0x0210000000002000L,0x0080000000000000L});
    public static final BitSet FOLLOW_57_in_tcs_concretesyntax1559 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1563 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_concretesyntax1571 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_concretesyntax1578 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_classifier_in_reference1644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_reference1660 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_reference1668 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_reference1677 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_reference1685 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_tcs_contexttemplate_in_tcs_template1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_primitivetemplate_in_tcs_template1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumerationtemplate_in_tcs_template1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functiontemplate_in_tcs_template1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classtemplate_in_tcs_contexttemplate1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_operatortemplate_in_tcs_contexttemplate1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_tcs_primitivetemplate1815 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1822 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_tcs_primitivetemplate1828 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_primitivetemplate1831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_tcs_primitivetemplate1841 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_tcs_primitivetemplate1859 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1866 = new BitSet(new long[]{0x0000000000010000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_tcs_primitivetemplate1878 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_primitivetemplate1897 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_tcs_primitivetemplate1901 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1905 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1913 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_primitivetemplate1926 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_tcs_primitivetemplate1930 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1934 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1942 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_primitivetemplate1962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_primitivetemplate1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_tcs_enumerationtemplate2015 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_enumerationtemplate2018 = new BitSet(new long[]{0x0000000000014000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_tcs_enumerationtemplate2028 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_enumerationtemplate2056 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2067 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_enumerationtemplate2076 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2084 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate2099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate2116 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_enumerationtemplate2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping2179 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_enumliteralmapping2186 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_enumliteralmapping2194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_tcs_classtemplate2237 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_classtemplate2240 = new BitSet(new long[]{0x0000000000054200L,0x000283380C000800L});
    public static final BitSet FOLLOW_104_in_tcs_classtemplate2250 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_SHARP_in_tcs_classtemplate2270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate2278 = new BitSet(new long[]{0x0000000000014200L,0x000282380C000800L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2304 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_tcs_classtemplate2308 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2312 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2320 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2327 = new BitSet(new long[]{0x0000000000014200L,0x000282380C000800L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_tcs_classtemplate2355 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2359 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2367 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2374 = new BitSet(new long[]{0x0000000000014200L,0x000282380C000800L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2398 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_tcs_classtemplate2402 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2406 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2414 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2421 = new BitSet(new long[]{0x0000000000014000L,0x000282380C000800L});
    public static final BitSet FOLLOW_99_in_tcs_classtemplate2444 = new BitSet(new long[]{0x0000000000014000L,0x000282300C000800L});
    public static final BitSet FOLLOW_100_in_tcs_classtemplate2468 = new BitSet(new long[]{0x0000000000014000L,0x000282200C000800L});
    public static final BitSet FOLLOW_75_in_tcs_classtemplate2498 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_tcs_classtemplate2516 = new BitSet(new long[]{0x0000000000014000L,0x0002822008000000L});
    public static final BitSet FOLLOW_111_in_tcs_classtemplate2540 = new BitSet(new long[]{0x0000000000014200L,0x0002022008000000L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2550 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate2558 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2565 = new BitSet(new long[]{0x0000000000014000L,0x0002022008000000L});
    public static final BitSet FOLLOW_91_in_tcs_classtemplate2603 = new BitSet(new long[]{0x0000000000014200L,0x0002022000000000L});
    public static final BitSet FOLLOW_tcs_contexttags_in_tcs_classtemplate2616 = new BitSet(new long[]{0x0000000000014000L,0x0002022000000000L});
    public static final BitSet FOLLOW_101_in_tcs_classtemplate2656 = new BitSet(new long[]{0x0000000000014000L,0x0002020000000000L});
    public static final BitSet FOLLOW_113_in_tcs_classtemplate2680 = new BitSet(new long[]{0x0000000000014000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_tcs_classtemplate2704 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2711 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2722 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2764 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2775 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2785 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_classtemplate2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_tcs_operatortemplate2861 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_operatortemplate2864 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_operatortemplate2869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_tcs_operatortemplate2873 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2877 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2885 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2893 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2905 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
    public static final BitSet FOLLOW_126_in_tcs_operatortemplate2909 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2913 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2921 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2934 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_tcs_operatortemplate2938 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2942 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2950 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2976 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_85_in_tcs_operatortemplate2980 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2984 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2992 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate3018 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_tcs_operatortemplate3022 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate3026 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate3034 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate3060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_tcs_operatortemplate3064 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate3068 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate3076 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_operatortemplate3096 = new BitSet(new long[]{0x0000000000014000L,0x0000010008000000L});
    public static final BitSet FOLLOW_104_in_tcs_operatortemplate3106 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_91_in_tcs_operatortemplate3125 = new BitSet(new long[]{0x0000000000014200L});
    public static final BitSet FOLLOW_tcs_contexttags_in_tcs_operatortemplate3138 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_operatortemplate3189 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_operatortemplate3200 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate3210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate3227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_operatortemplate3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_tcs_functiontemplate3286 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functiontemplate3293 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_functiontemplate3300 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_functiontemplate3304 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_functiontemplate3309 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_functiontemplate3317 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_functiontemplate3328 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_functiontemplate3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_contexttags3383 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_identifier_in_tcs_contexttags3391 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_contexttags3400 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_contexttags3408 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_contexttags3420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3465 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3473 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence__impl_in_tcs_sequence3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_sequence3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_sequenceelement3552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_property_in_tcs_sequenceelement3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_customseparator_in_tcs_sequenceelement3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_block_in_tcs_sequenceelement3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_alternative_in_tcs_sequenceelement3592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functioncall_in_tcs_sequenceelement3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_injectoractionsblock_in_tcs_sequenceelement3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_literalref3642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_propertyreference3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_tcs_propertyreference3714 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_propertyreference3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_property3777 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_property3790 = new BitSet(new long[]{0xA128000000002000L,0x8204000480800488L,0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property3798 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_property3807 = new BitSet(new long[]{0xA128000000000000L,0x8204000480800488L,0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property3815 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_property3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_tcs_customseparator3885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_customseparator3893 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_GT_in_tcs_customseparator3900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_block3945 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_block3953 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_block3960 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_block3971 = new BitSet(new long[]{0x0000000000002000L,0x0108000000004000L,0x000000000000000CL});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block3979 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_block3988 = new BitSet(new long[]{0x0000000000000000L,0x0108000000004000L,0x000000000000000CL});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block3996 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_block4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_conditionalelement4066 = new BitSet(new long[]{0xFFFE000000808010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_expression_in_tcs_conditionalelement4074 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_QMARK_in_tcs_conditionalelement4083 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement4091 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_COLON_in_tcs_conditionalelement4104 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement4112 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_conditionalelement4132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLSQUARE_in_tcs_alternative4177 = new BitSet(new long[]{0xFFFE000037288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4185 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_PIPE_in_tcs_alternative4194 = new BitSet(new long[]{0xFFFE000037288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4202 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_DRSQUARE_in_tcs_alternative4214 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_STAR_in_tcs_alternative4225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_tcs_sequenceinalternative4290 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_sequenceinalternative4294 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_sequenceinalternative4302 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_sequenceinalternative4309 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4330 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4338 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_DOLLAR_in_tcs_functioncall4387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functioncall4395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCURLY_in_tcs_injectoractionsblock4442 = new BitSet(new long[]{0xFFFE000040008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4450 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_injectoractionsblock4459 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4467 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_DRCURLY_in_tcs_injectoractionsblock4479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyinit_in_tcs_injectoraction4520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_primitivepropertyinit_in_tcs_propertyinit4547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookuppropertyinit_in_tcs_propertyinit4555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_foreachpredicatepropertyinit_in_tcs_propertyinit4563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_primitivepropertyinit4597 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_primitivepropertyinit4610 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivepropertyinit4625 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivepropertyinit4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_lookuppropertyinit4687 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_lookuppropertyinit4700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookuppropertyinit4715 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_tcs_lookuppropertyinit4726 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_lookuppropertyinit4730 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_lookuppropertyinit4738 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_lookuppropertyinit4745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_foreachpredicatepropertyinit4790 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_foreachpredicatepropertyinit4803 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4818 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_tcs_foreachpredicatepropertyinit4829 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_foreachpredicatepropertyinit4833 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4841 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_tcs_foreachpredicatepropertyinit4858 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4862 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4870 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4896 = new BitSet(new long[]{0x1000000000000400L,0x8000000000800000L});
    public static final BitSet FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4904 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4913 = new BitSet(new long[]{0x1000000000000000L,0x8000000000800000L});
    public static final BitSet FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4921 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_foreachpredicatepropertyinit4946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_tcs_predicatesemantic4993 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic4997 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_predicatesemantic5005 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_predicatesemantic5012 = new BitSet(new long[]{0x0000000000000000L,0x8000000000800000L});
    public static final BitSet FOLLOW_87_in_tcs_predicatesemantic5035 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic5039 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_predicatesemantic5047 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_predicatesemantic5054 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_tcs_predicatesemantic5071 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic5075 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_predicatesemantic5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_referstoparg_in_tcs_propertyarg5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookinparg_in_tcs_propertyarg5133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createinparg_in_tcs_propertyarg5141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_asparg_in_tcs_propertyarg5149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_separatorparg_in_tcs_propertyarg5157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_disambiguateparg_in_tcs_propertyarg5165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_autocreateparg_in_tcs_propertyarg5173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_importcontextparg_in_tcs_propertyarg5181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_partialparg_in_tcs_propertyarg5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedupperparg_in_tcs_propertyarg5205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createasparg_in_tcs_propertyarg5213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_queryparg_in_tcs_propertyarg5221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_filterparg_in_tcs_propertyarg5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_modeparg_in_tcs_propertyarg5237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_tcs_referstoparg5267 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_referstoparg5271 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_referstoparg5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_tcs_lookinparg5322 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookinparg5326 = new BitSet(new long[]{0xFFFE000000040010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_SHARP_in_tcs_lookinparg5337 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_tcs_lookinparg5341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg5358 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_lookinparg5367 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg5375 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_121_in_tcs_createinparg5428 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_createinparg5432 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg5440 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_createinparg5449 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg5457 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_127_in_tcs_asparg5503 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_asparg5507 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_asparg5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_tcs_separatorparg5558 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_separatorparg5562 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_separatorparg5570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_tcs_disambiguateparg5613 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_disambiguateparg5617 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_disambiguateparg5625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_tcs_autocreateparg5668 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_autocreateparg5672 = new BitSet(new long[]{0x0800000000000000L,0x0000000200000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg5680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_tcs_autocreatekind5724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_tcs_autocreatekind5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_tcs_autocreatekind5744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_tcs_importcontextparg5775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_tcs_partialparg5815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_tcs_forcedlowerparg5855 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedlowerparg5859 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedlowerparg5867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_tcs_forcedupperparg5910 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedupperparg5914 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedupperparg5922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_tcs_createasparg5965 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_createasparg5969 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg5977 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_tcs_createasparg5986 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg5994 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_61_in_tcs_queryparg6040 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_queryparg6044 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_queryparg6052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_tcs_filterparg6095 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_filterparg6099 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_filterparg6107 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COMA_in_tcs_filterparg6120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_tcs_filterparg6124 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_filterparg6128 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_filterparg6136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_tcs_modeparg6192 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_modeparg6196 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_modeparg6204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_nbnlbarg_in_tcs_blockarg6244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_indentincrbarg_in_tcs_blockarg6252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnlbarg_in_tcs_blockarg6260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg6268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endnlbarg_in_tcs_blockarg6276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_tcs_nbnlbarg6306 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_nbnlbarg6310 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_nbnlbarg6318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_tcs_indentincrbarg6361 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_indentincrbarg6365 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_indentincrbarg6373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_tcs_startnlbarg6416 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnlbarg6420 = new BitSet(new long[]{0x0000000000000000L,0x0000000001080000L});
    public static final BitSet FOLLOW_88_in_tcs_startnlbarg6430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_tcs_startnlbarg6443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_tcs_startnbnlbarg6490 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnbnlbarg6494 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_startnbnlbarg6502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_tcs_endnlbarg6545 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_endnlbarg6549 = new BitSet(new long[]{0x0000000000000000L,0x0000000001080000L});
    public static final BitSet FOLLOW_88_in_tcs_endnlbarg6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_tcs_endnlbarg6572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_symbol6623 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_symbol6632 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_symbol6640 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_symbol6653 = new BitSet(new long[]{0x0400000000004000L,0x2000000000010001L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol6661 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_symbol6670 = new BitSet(new long[]{0x0400000000000000L,0x2000000000010001L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol6678 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_symbol6703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_tcs_spacekind6745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_tcs_spacekind6755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_tcs_spacekind6765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_tcs_spacekind6775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_keyword6810 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_keyword6819 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_keyword6827 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_keyword6834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_tcs_operatorlist6875 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatorlist6888 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_operatorlist6908 = new BitSet(new long[]{0x0000000000002000L,0x0000000000040000L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist6919 = new BitSet(new long[]{0x0000000000002000L,0x0000000000040000L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist6927 = new BitSet(new long[]{0x0000000000002000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_operatorlist6942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_tcs_priority6983 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_priority6990 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_COMA_in_tcs_priority7013 = new BitSet(new long[]{0x0000000000000000L,0x0040100000000000L});
    public static final BitSet FOLLOW_tcs_associativity_in_tcs_priority7021 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_priority7035 = new BitSet(new long[]{0x0000000000002810L,0x0000200000000000L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority7046 = new BitSet(new long[]{0x0000000000002810L,0x0000200000000000L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority7054 = new BitSet(new long[]{0x0000000000002810L,0x0000200000000000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_priority7069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_tcs_operator7116 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator7138 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operator7147 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator7166 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operator7186 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_operator7211 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_operator7219 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operator7226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_tcs_associativity7268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_tcs_associativity7278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_andexp_in_tcs_expression7306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp7340 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_tcs_andexp7348 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp7355 = new BitSet(new long[]{0x0000000000000002L,0x0010000000000000L});
    public static final BitSet FOLLOW_tcs_equalsexp_in_tcs_atomexp7400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp7408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_isdefinedexp_in_tcs_atomexp7416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_oneexp_in_tcs_atomexp7424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_instanceofexp_in_tcs_atomexp7432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_equalsexp7466 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_equalsexp7473 = new BitSet(new long[]{0x0000000200040060L});
    public static final BitSet FOLLOW_tcs_value_in_tcs_equalsexp7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_booleanpropertyexp7528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_tcs_isdefinedexp7571 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_isdefinedexp7575 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_isdefinedexp7583 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_isdefinedexp7590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_tcs_oneexp7631 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_oneexp7635 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_oneexp7643 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_oneexp7650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_instanceofexp7695 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_tcs_instanceofexp7701 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_instanceofexp7708 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_tcs_instanceofexp7717 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_instanceofexp7725 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_tcs_stringval_in_tcs_value7768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_integerval_in_tcs_value7776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_negativeintegerval_in_tcs_value7784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_value7792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringval7826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_integerval7873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_tcs_negativeintegerval7917 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_negativeintegerval7925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_tcs_enumliteralval7969 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_enumliteralval7977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_tcs_token8026 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_tcs_token8044 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_identifier_in_tcs_token8051 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_token8060 = new BitSet(new long[]{0x0000000000204020L,0x1000000040000100L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_token8068 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_token8075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern8120 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_tcs_orpattern8129 = new BitSet(new long[]{0x0000000000200020L,0x1000000040000100L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern8137 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_tcs_rulepattern_in_tcs_simplepattern8182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_simplepattern8190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classpattern_in_tcs_simplepattern8198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_rule_in_tcs_rulepattern8232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wordrule_in_tcs_rule8272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endoflinerule_in_tcs_rule8280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_multilinerule_in_tcs_rule8288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_tcs_wordrule8318 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_wordrule8322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_tcs_wordrule8326 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8330 = new BitSet(new long[]{0x0000000000220020L,0x1000000040000100L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8338 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule8345 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_tcs_wordrule8349 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8353 = new BitSet(new long[]{0x0000000000220420L,0x1000000040000100L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8361 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule8374 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_tcs_wordrule8378 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8382 = new BitSet(new long[]{0x0000000000200420L,0x1000000040000100L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8390 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_wordrule8410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_tcs_endoflinerule8451 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_endoflinerule8455 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_tcs_endoflinerule8459 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_endoflinerule8463 = new BitSet(new long[]{0x0080000000000420L});
    public static final BitSet FOLLOW_55_in_tcs_endoflinerule8473 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_endoflinerule8495 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_endoflinerule8502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_tcs_multilinerule8543 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule8547 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_tcs_multilinerule8551 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8555 = new BitSet(new long[]{0x0080000000020020L});
    public static final BitSet FOLLOW_55_in_tcs_multilinerule8565 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8587 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8594 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_tcs_multilinerule8598 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8602 = new BitSet(new long[]{0x0080000000020420L});
    public static final BitSet FOLLOW_55_in_tcs_multilinerule8612 = new BitSet(new long[]{0x0000000000020420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8634 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8647 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_tcs_multilinerule8651 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8655 = new BitSet(new long[]{0x0000000000020420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8663 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8676 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule8681 = new BitSet(new long[]{0x0000000100000410L,0x0001000000400000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule8689 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8698 = new BitSet(new long[]{0x0000000100000010L,0x0001000000400000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule8706 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule8718 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule8749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplemapping_in_tcs_mapping8787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wildcardmapping_in_tcs_mapping8795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_octalmapping_in_tcs_mapping8803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping8811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping8845 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_simplemapping8852 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping8860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping8904 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_wildcardmapping8909 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping8914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_tcs_octalmapping8955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_tcs_hexadecimalmapping8995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringpattern9039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_classpattern9085 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classpattern9093 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_classpattern9102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCOLON_in_synpred89_TCS1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred115_TCS1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred120_TCS2130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred138_TCS2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred149_TCS3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequence__impl_in_synpred154_TCS3518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_synpred163_TCS3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_expression_in_synpred170_TCS4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_synpred173_TCS4185 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred173_TCS4194 = new BitSet(new long[]{0xFFFE000033288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_synpred173_TCS4202 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMA_in_synpred185_TCS4854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_synpred185_TCS4858 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_synpred185_TCS4862 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_synpred185_TCS4870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_synpred251_TCS8120 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred251_TCS8129 = new BitSet(new long[]{0x0000000000200020L,0x1000000040000100L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_synpred251_TCS8137 = new BitSet(new long[]{0x0000000002000002L});

}